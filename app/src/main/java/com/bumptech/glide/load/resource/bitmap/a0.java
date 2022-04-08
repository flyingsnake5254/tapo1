package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.e;
import com.bumptech.glide.load.engine.u;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: VideoDecoder.java */
/* loaded from: classes.dex */
public class a0<T> implements com.bumptech.glide.load.g<T, Bitmap> {
    public static final com.bumptech.glide.load.e<Long> a = com.bumptech.glide.load.e.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new a());

    /* renamed from: b  reason: collision with root package name */
    public static final com.bumptech.glide.load.e<Integer> f1621b = com.bumptech.glide.load.e.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new b());

    /* renamed from: c  reason: collision with root package name */
    private static final e f1622c = new e();

    /* renamed from: d  reason: collision with root package name */
    private final f<T> f1623d;

    /* renamed from: e  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.z.e f1624e;

    /* renamed from: f  reason: collision with root package name */
    private final e f1625f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoDecoder.java */
    /* loaded from: classes.dex */
    public class a implements e.b<Long> {
        private final ByteBuffer a = ByteBuffer.allocate(8);

        a() {
        }

        /* renamed from: b */
        public void a(@NonNull byte[] bArr, @NonNull Long l, @NonNull MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.a) {
                this.a.position(0);
                messageDigest.update(this.a.putLong(l.longValue()).array());
            }
        }
    }

    /* compiled from: VideoDecoder.java */
    /* loaded from: classes.dex */
    class b implements e.b<Integer> {
        private final ByteBuffer a = ByteBuffer.allocate(4);

        b() {
        }

        /* renamed from: b */
        public void a(@NonNull byte[] bArr, @NonNull Integer num, @NonNull MessageDigest messageDigest) {
            if (num != null) {
                messageDigest.update(bArr);
                synchronized (this.a) {
                    this.a.position(0);
                    messageDigest.update(this.a.putInt(num.intValue()).array());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VideoDecoder.java */
    /* loaded from: classes.dex */
    public static final class c implements f<AssetFileDescriptor> {
        private c() {
        }

        /* renamed from: b */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoDecoder.java */
    @RequiresApi(23)
    /* loaded from: classes.dex */
    public static final class d implements f<ByteBuffer> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: VideoDecoder.java */
        /* loaded from: classes.dex */
        public class a extends MediaDataSource {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ByteBuffer f1626c;

            a(ByteBuffer byteBuffer) {
                this.f1626c = byteBuffer;
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // android.media.MediaDataSource
            public long getSize() {
                return this.f1626c.limit();
            }

            @Override // android.media.MediaDataSource
            public int readAt(long j, byte[] bArr, int i, int i2) {
                if (j >= this.f1626c.limit()) {
                    return -1;
                }
                this.f1626c.position((int) j);
                int min = Math.min(i2, this.f1626c.remaining());
                this.f1626c.get(bArr, i, min);
                return min;
            }
        }

        d() {
        }

        /* renamed from: b */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ByteBuffer byteBuffer) {
            mediaMetadataRetriever.setDataSource(new a(byteBuffer));
        }
    }

    /* compiled from: VideoDecoder.java */
    @VisibleForTesting
    /* loaded from: classes.dex */
    static class e {
        e() {
        }

        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoDecoder.java */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public interface f<T> {
        void a(MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoDecoder.java */
    /* loaded from: classes.dex */
    public static final class g implements f<ParcelFileDescriptor> {
        g() {
        }

        /* renamed from: b */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VideoDecoder.java */
    /* loaded from: classes.dex */
    public static final class h extends RuntimeException {
        h() {
            super("MediaMetadataRetriever failed to retrieve a frame without throwing, check the adb logs for .*MetadataRetriever.* prior to this exception for details");
        }
    }

    a0(com.bumptech.glide.load.engine.z.e eVar, f<T> fVar) {
        this(eVar, fVar, f1622c);
    }

    public static com.bumptech.glide.load.g<AssetFileDescriptor, Bitmap> c(com.bumptech.glide.load.engine.z.e eVar) {
        return new a0(eVar, new c(null));
    }

    @RequiresApi(api = 23)
    public static com.bumptech.glide.load.g<ByteBuffer, Bitmap> d(com.bumptech.glide.load.engine.z.e eVar) {
        return new a0(eVar, new d());
    }

    @Nullable
    private static Bitmap e(MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, DownsampleStrategy downsampleStrategy) {
        Bitmap g2 = (Build.VERSION.SDK_INT < 27 || i2 == Integer.MIN_VALUE || i3 == Integer.MIN_VALUE || downsampleStrategy == DownsampleStrategy.f1619f) ? null : g(mediaMetadataRetriever, j, i, i2, i3, downsampleStrategy);
        if (g2 == null) {
            g2 = f(mediaMetadataRetriever, j, i);
        }
        if (g2 != null) {
            return g2;
        }
        throw new h();
    }

    private static Bitmap f(MediaMetadataRetriever mediaMetadataRetriever, long j, int i) {
        return mediaMetadataRetriever.getFrameAtTime(j, i);
    }

    @Nullable
    @TargetApi(27)
    private static Bitmap g(MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, DownsampleStrategy downsampleStrategy) {
        try {
            int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (parseInt3 == 90 || parseInt3 == 270) {
                parseInt2 = parseInt;
                parseInt = parseInt2;
            }
            float b2 = downsampleStrategy.b(parseInt, parseInt2, i2, i3);
            return mediaMetadataRetriever.getScaledFrameAtTime(j, i, Math.round(parseInt * b2), Math.round(b2 * parseInt2));
        } catch (Throwable th) {
            if (!Log.isLoggable("VideoDecoder", 3)) {
                return null;
            }
            Log.d("VideoDecoder", "Exception trying to decode a scaled frame on oreo+, falling back to a fullsize frame", th);
            return null;
        }
    }

    public static com.bumptech.glide.load.g<ParcelFileDescriptor, Bitmap> h(com.bumptech.glide.load.engine.z.e eVar) {
        return new a0(eVar, new g());
    }

    @Override // com.bumptech.glide.load.g
    public boolean a(@NonNull T t, @NonNull com.bumptech.glide.load.f fVar) {
        return true;
    }

    /* JADX WARN: Finally extract failed */
    @Override // com.bumptech.glide.load.g
    public u<Bitmap> b(@NonNull T t, int i, int i2, @NonNull com.bumptech.glide.load.f fVar) throws IOException {
        long longValue = ((Long) fVar.c(a)).longValue();
        if (longValue >= 0 || longValue == -1) {
            Integer num = (Integer) fVar.c(f1621b);
            if (num == null) {
                num = 2;
            }
            DownsampleStrategy downsampleStrategy = (DownsampleStrategy) fVar.c(DownsampleStrategy.h);
            if (downsampleStrategy == null) {
                downsampleStrategy = DownsampleStrategy.g;
            }
            MediaMetadataRetriever a2 = this.f1625f.a();
            try {
                this.f1623d.a(a2, t);
                Bitmap e2 = e(a2, longValue, num.intValue(), i, i2, downsampleStrategy);
                a2.release();
                return e.f(e2, this.f1624e);
            } catch (Throwable th) {
                a2.release();
                throw th;
            }
        } else {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + longValue);
        }
    }

    @VisibleForTesting
    a0(com.bumptech.glide.load.engine.z.e eVar, f<T> fVar, e eVar2) {
        this.f1624e = eVar;
        this.f1623d = fVar;
        this.f1625f = eVar2;
    }
}
