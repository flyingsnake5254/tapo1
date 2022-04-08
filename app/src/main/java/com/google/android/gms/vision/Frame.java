package com.google.android.gms.vision;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.Image;
import androidx.annotation.RequiresApi;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes.dex */
public class Frame {
    public static final int ROTATION_0 = 0;
    public static final int ROTATION_180 = 2;
    public static final int ROTATION_270 = 3;
    public static final int ROTATION_90 = 1;
    private final Metadata zzao;
    @Nullable
    private ByteBuffer zzap;
    @RequiresApi(19)
    @Nullable
    private zza zzaq;
    @Nullable
    private Bitmap zzar;

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    /* loaded from: classes.dex */
    public static class Builder {
        private final Frame zzax = new Frame();

        public Frame build() {
            if (this.zzax.zzap != null || this.zzax.zzar != null || this.zzax.zzaq != null) {
                return this.zzax;
            }
            throw new IllegalStateException("Missing image data.  Call either setBitmap or setImageData to specify the image");
        }

        public Builder setBitmap(Bitmap bitmap) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            this.zzax.zzar = bitmap;
            Metadata metadata = this.zzax.getMetadata();
            metadata.width = width;
            metadata.height = height;
            return this;
        }

        public Builder setId(int i) {
            this.zzax.getMetadata().id = i;
            return this;
        }

        public Builder setImageData(ByteBuffer byteBuffer, int i, int i2, int i3) {
            if (byteBuffer == null) {
                throw new IllegalArgumentException("Null image data supplied.");
            } else if (byteBuffer.capacity() < i * i2) {
                throw new IllegalArgumentException("Invalid image data size.");
            } else if (i3 == 16 || i3 == 17 || i3 == 842094169) {
                this.zzax.zzap = byteBuffer;
                Metadata metadata = this.zzax.getMetadata();
                metadata.width = i;
                metadata.height = i2;
                metadata.format = i3;
                return this;
            } else {
                StringBuilder sb = new StringBuilder(37);
                sb.append("Unsupported image format: ");
                sb.append(i3);
                throw new IllegalArgumentException(sb.toString());
            }
        }

        @RequiresApi(19)
        @KeepForSdk
        public Builder setPlanes(Image.Plane[] planeArr, int i, int i2, int i3) {
            if (planeArr == null) {
                throw new IllegalArgumentException("Null image data supplied.");
            } else if (planeArr.length != 3) {
                throw new IllegalArgumentException("Only android.graphics.ImageFormat#YUV_420_888 is supported which should have 3 planes.");
            } else if (planeArr[0].getBuffer().capacity() >= i * i2) {
                this.zzax.zzaq = new zza(planeArr);
                Metadata metadata = this.zzax.getMetadata();
                metadata.width = i;
                metadata.height = i2;
                metadata.format = i3;
                return this;
            } else {
                throw new IllegalArgumentException("Invalid image data size.");
            }
        }

        public Builder setRotation(int i) {
            this.zzax.getMetadata().rotation = i;
            return this;
        }

        public Builder setTimestampMillis(long j) {
            this.zzax.getMetadata().zzaz = j;
            return this;
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    /* loaded from: classes.dex */
    public static class Metadata {
        private int format;
        private int height;
        private int id;
        private int rotation;
        private int width;
        private long zzaz;

        public Metadata() {
            this.format = -1;
        }

        public int getFormat() {
            return this.format;
        }

        public int getHeight() {
            return this.height;
        }

        public int getId() {
            return this.id;
        }

        public int getRotation() {
            return this.rotation;
        }

        public long getTimestampMillis() {
            return this.zzaz;
        }

        public int getWidth() {
            return this.width;
        }

        public final void zze() {
            if (this.rotation % 2 != 0) {
                int i = this.width;
                this.width = this.height;
                this.height = i;
            }
            this.rotation = 0;
        }

        public Metadata(Metadata metadata) {
            this.format = -1;
            this.width = metadata.getWidth();
            this.height = metadata.getHeight();
            this.id = metadata.getId();
            this.zzaz = metadata.getTimestampMillis();
            this.rotation = metadata.getRotation();
            this.format = metadata.getFormat();
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    /* loaded from: classes.dex */
    static class zza {
        private final Image.Plane[] zzay;

        zza(Image.Plane[] planeArr) {
            this.zzay = planeArr;
        }

        final Image.Plane[] getPlanes() {
            return this.zzay;
        }
    }

    private Frame() {
        this.zzao = new Metadata();
        this.zzap = null;
        this.zzaq = null;
        this.zzar = null;
    }

    public Bitmap getBitmap() {
        return this.zzar;
    }

    public ByteBuffer getGrayscaleImageData() {
        Bitmap bitmap = this.zzar;
        if (bitmap == null) {
            return this.zzap;
        }
        int width = bitmap.getWidth();
        int height = this.zzar.getHeight();
        int i = width * height;
        int[] iArr = new int[i];
        this.zzar.getPixels(iArr, 0, width, 0, 0, width, height);
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) ((Color.red(iArr[i2]) * 0.299f) + (Color.green(iArr[i2]) * 0.587f) + (Color.blue(iArr[i2]) * 0.114f));
        }
        return ByteBuffer.wrap(bArr);
    }

    public Metadata getMetadata() {
        return this.zzao;
    }

    @RequiresApi(19)
    @KeepForSdk
    @Nullable
    public Image.Plane[] getPlanes() {
        zza zzaVar = this.zzaq;
        if (zzaVar == null) {
            return null;
        }
        return zzaVar.getPlanes();
    }
}
