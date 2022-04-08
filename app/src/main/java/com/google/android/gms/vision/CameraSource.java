package com.google.android.gms.vision;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.SystemClock;
import android.util.Log;
import android.view.SurfaceHolder;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.common.images.Size;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.vision.Frame;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes.dex */
public class CameraSource {
    @SuppressLint({"InlinedApi"})
    public static final int CAMERA_FACING_BACK = 0;
    @SuppressLint({"InlinedApi"})
    public static final int CAMERA_FACING_FRONT = 1;
    private int facing;
    private int rotation;
    private Context zzg;
    private final Object zzh;
    @GuardedBy("cameraLock")
    private Camera zzi;
    private Size zzj;
    private float zzk;
    private int zzl;
    private int zzm;
    private boolean zzn;
    private String zzo;
    private SurfaceTexture zzp;
    private boolean zzq;
    private Thread zzr;
    private zza zzs;
    private Map<byte[], ByteBuffer> zzt;

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    /* loaded from: classes.dex */
    public static class Builder {
        private final Detector<?> zzx;
        private CameraSource zzy;

        public Builder(Context context, Detector<?> detector) {
            CameraSource cameraSource = new CameraSource();
            this.zzy = cameraSource;
            if (context == null) {
                throw new IllegalArgumentException("No context supplied.");
            } else if (detector != null) {
                this.zzx = detector;
                cameraSource.zzg = context;
            } else {
                throw new IllegalArgumentException("No detector supplied.");
            }
        }

        public CameraSource build() {
            CameraSource cameraSource = this.zzy;
            cameraSource.getClass();
            cameraSource.zzs = new zza(this.zzx);
            return this.zzy;
        }

        public Builder setAutoFocusEnabled(boolean z) {
            this.zzy.zzn = z;
            return this;
        }

        public Builder setFacing(int i) {
            if (i == 0 || i == 1) {
                this.zzy.facing = i;
                return this;
            }
            StringBuilder sb = new StringBuilder(27);
            sb.append("Invalid camera: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }

        public Builder setFocusMode(String str) {
            if (!str.equals("continuous-video") && !str.equals("continuous-picture")) {
                Log.w("CameraSource", String.format("FocusMode %s is not supported for now.", str));
                str = null;
            }
            this.zzy.zzo = str;
            return this;
        }

        public Builder setRequestedFps(float f2) {
            if (f2 > 0.0f) {
                this.zzy.zzk = f2;
                return this;
            }
            StringBuilder sb = new StringBuilder(28);
            sb.append("Invalid fps: ");
            sb.append(f2);
            throw new IllegalArgumentException(sb.toString());
        }

        public Builder setRequestedPreviewSize(int i, int i2) {
            if (i <= 0 || i > 1000000 || i2 <= 0 || i2 > 1000000) {
                StringBuilder sb = new StringBuilder(45);
                sb.append("Invalid preview size: ");
                sb.append(i);
                sb.append("x");
                sb.append(i2);
                throw new IllegalArgumentException(sb.toString());
            }
            this.zzy.zzl = i;
            this.zzy.zzm = i2;
            return this;
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    /* loaded from: classes.dex */
    public interface PictureCallback {
        void onPictureTaken(byte[] bArr);
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    /* loaded from: classes.dex */
    public interface ShutterCallback {
        void onShutter();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    /* loaded from: classes.dex */
    public class zza implements Runnable {
        private long zzab;
        private ByteBuffer zzad;
        private Detector<?> zzx;
        private long zzz = SystemClock.elapsedRealtime();
        private final Object lock = new Object();
        private boolean zzaa = true;
        private int zzac = 0;

        zza(Detector<?> detector) {
            this.zzx = detector;
        }

        @SuppressLint({"Assert"})
        final void release() {
            this.zzx.release();
            this.zzx = null;
        }

        @Override // java.lang.Runnable
        @SuppressLint({"InlinedApi"})
        public final void run() {
            boolean z;
            Frame build;
            ByteBuffer byteBuffer;
            while (true) {
                synchronized (this.lock) {
                    while (true) {
                        z = this.zzaa;
                        if (!z || this.zzad != null) {
                            break;
                        }
                        try {
                            this.lock.wait();
                        } catch (InterruptedException e2) {
                            Log.d("CameraSource", "Frame processing loop terminated.", e2);
                            return;
                        }
                    }
                    if (z) {
                        build = new Frame.Builder().setImageData(this.zzad, CameraSource.this.zzj.getWidth(), CameraSource.this.zzj.getHeight(), 17).setId(this.zzac).setTimestampMillis(this.zzab).setRotation(CameraSource.this.rotation).build();
                        byteBuffer = this.zzad;
                        this.zzad = null;
                    } else {
                        return;
                    }
                }
                try {
                    this.zzx.receiveFrame(build);
                } catch (Exception e3) {
                    Log.e("CameraSource", "Exception thrown from receiver.", e3);
                } finally {
                    CameraSource.this.zzi.addCallbackBuffer(byteBuffer.array());
                }
            }
        }

        final void setActive(boolean z) {
            synchronized (this.lock) {
                this.zzaa = z;
                this.lock.notifyAll();
            }
        }

        final void zza(byte[] bArr, Camera camera) {
            synchronized (this.lock) {
                ByteBuffer byteBuffer = this.zzad;
                if (byteBuffer != null) {
                    camera.addCallbackBuffer(byteBuffer.array());
                    this.zzad = null;
                }
                if (!CameraSource.this.zzt.containsKey(bArr)) {
                    Log.d("CameraSource", "Skipping frame. Could not find ByteBuffer associated with the image data from the camera.");
                    return;
                }
                this.zzab = SystemClock.elapsedRealtime() - this.zzz;
                this.zzac++;
                this.zzad = (ByteBuffer) CameraSource.this.zzt.get(bArr);
                this.lock.notifyAll();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    /* loaded from: classes.dex */
    public class zzb implements Camera.PreviewCallback {
        private zzb() {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public final void onPreviewFrame(byte[] bArr, Camera camera) {
            CameraSource.this.zzs.zza(bArr, camera);
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    /* loaded from: classes.dex */
    class zzc implements Camera.PictureCallback {
        private PictureCallback zzaf;

        private zzc() {
        }

        @Override // android.hardware.Camera.PictureCallback
        public final void onPictureTaken(byte[] bArr, Camera camera) {
            PictureCallback pictureCallback = this.zzaf;
            if (pictureCallback != null) {
                pictureCallback.onPictureTaken(bArr);
            }
            synchronized (CameraSource.this.zzh) {
                if (CameraSource.this.zzi != null) {
                    CameraSource.this.zzi.startPreview();
                }
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    /* loaded from: classes.dex */
    static class zzd implements Camera.ShutterCallback {
        private ShutterCallback zzag;

        private zzd() {
        }

        @Override // android.hardware.Camera.ShutterCallback
        public final void onShutter() {
            ShutterCallback shutterCallback = this.zzag;
            if (shutterCallback != null) {
                shutterCallback.onShutter();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class zze {
        private Size zzaj;
        private Size zzak;

        public zze(Camera.Size size, @Nullable Camera.Size size2) {
            this.zzaj = new Size(size.width, size.height);
            if (size2 != null) {
                this.zzak = new Size(size2.width, size2.height);
            }
        }

        public final Size zzc() {
            return this.zzaj;
        }

        @Nullable
        public final Size zzd() {
            return this.zzak;
        }
    }

    private CameraSource() {
        this.zzh = new Object();
        this.facing = 0;
        this.zzk = 30.0f;
        this.zzl = 1024;
        this.zzm = 768;
        this.zzn = false;
        this.zzt = new HashMap();
    }

    @SuppressLint({"InlinedApi"})
    private final byte[] zza(Size size) {
        byte[] bArr = new byte[((int) Math.ceil(((size.getHeight() * size.getWidth()) * ImageFormat.getBitsPerPixel(17)) / 8.0d)) + 1];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        if (!wrap.hasArray() || wrap.array() != bArr) {
            throw new IllegalStateException("Failed to create valid buffer for camera source.");
        }
        this.zzt.put(bArr, wrap);
        return bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01ef  */
    @android.annotation.SuppressLint({"InlinedApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final android.hardware.Camera zzb() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 572
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.vision.CameraSource.zzb():android.hardware.Camera");
    }

    public int getCameraFacing() {
        return this.facing;
    }

    public Size getPreviewSize() {
        return this.zzj;
    }

    public void release() {
        synchronized (this.zzh) {
            stop();
            this.zzs.release();
        }
    }

    @RequiresPermission("android.permission.CAMERA")
    public CameraSource start() throws IOException {
        synchronized (this.zzh) {
            if (this.zzi != null) {
                return this;
            }
            this.zzi = zzb();
            SurfaceTexture surfaceTexture = new SurfaceTexture(100);
            this.zzp = surfaceTexture;
            this.zzi.setPreviewTexture(surfaceTexture);
            this.zzq = true;
            this.zzi.startPreview();
            Thread thread = new Thread(this.zzs);
            this.zzr = thread;
            thread.setName("gms.vision.CameraSource");
            this.zzs.setActive(true);
            this.zzr.start();
            return this;
        }
    }

    public void stop() {
        synchronized (this.zzh) {
            this.zzs.setActive(false);
            Thread thread = this.zzr;
            if (thread != null) {
                try {
                    thread.join();
                } catch (InterruptedException unused) {
                    Log.d("CameraSource", "Frame processing thread interrupted on release.");
                }
                this.zzr = null;
            }
            Camera camera = this.zzi;
            if (camera != null) {
                camera.stopPreview();
                this.zzi.setPreviewCallbackWithBuffer(null);
                try {
                    if (this.zzq) {
                        this.zzi.setPreviewTexture(null);
                    } else {
                        this.zzi.setPreviewDisplay(null);
                    }
                } catch (Exception e2) {
                    String valueOf = String.valueOf(e2);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 32);
                    sb.append("Failed to clear camera preview: ");
                    sb.append(valueOf);
                    Log.e("CameraSource", sb.toString());
                }
                this.zzi.release();
                this.zzi = null;
            }
            this.zzt.clear();
        }
    }

    public void takePicture(ShutterCallback shutterCallback, PictureCallback pictureCallback) {
        synchronized (this.zzh) {
            if (this.zzi != null) {
                zzd zzdVar = new zzd();
                zzdVar.zzag = shutterCallback;
                zzc zzcVar = new zzc();
                zzcVar.zzaf = pictureCallback;
                this.zzi.takePicture(zzdVar, null, null, zzcVar);
            }
        }
    }

    @RequiresPermission("android.permission.CAMERA")
    public CameraSource start(SurfaceHolder surfaceHolder) throws IOException {
        synchronized (this.zzh) {
            if (this.zzi != null) {
                return this;
            }
            Camera zzb2 = zzb();
            this.zzi = zzb2;
            zzb2.setPreviewDisplay(surfaceHolder);
            this.zzi.startPreview();
            this.zzr = new Thread(this.zzs);
            this.zzs.setActive(true);
            this.zzr.start();
            this.zzq = false;
            return this;
        }
    }
}
