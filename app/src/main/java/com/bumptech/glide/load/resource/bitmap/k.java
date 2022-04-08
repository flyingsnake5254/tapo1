package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.e;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.q;
import com.bumptech.glide.util.i;
import com.bumptech.glide.util.j;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* compiled from: Downsampler.java */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: d  reason: collision with root package name */
    public static final e<Boolean> f1638d;

    /* renamed from: e  reason: collision with root package name */
    public static final e<Boolean> f1639e;
    private final com.bumptech.glide.load.engine.z.e j;
    private final DisplayMetrics k;
    private final com.bumptech.glide.load.engine.z.b l;
    private final List<ImageHeaderParser> m;
    private final p n = p.b();
    public static final e<DecodeFormat> a = e.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.DEFAULT);

    /* renamed from: b  reason: collision with root package name */
    public static final e<PreferredColorSpace> f1636b = e.f("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", PreferredColorSpace.SRGB);
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public static final e<DownsampleStrategy> f1637c = DownsampleStrategy.h;

    /* renamed from: f  reason: collision with root package name */
    private static final Set<String> f1640f = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
    private static final b g = new a();
    private static final Set<ImageHeaderParser.ImageType> h = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
    private static final Queue<BitmapFactory.Options> i = j.f(0);

    /* compiled from: Downsampler.java */
    /* loaded from: classes.dex */
    class a implements b {
        a() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.k.b
        public void a(com.bumptech.glide.load.engine.z.e eVar, Bitmap bitmap) {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.k.b
        public void b() {
        }
    }

    /* compiled from: Downsampler.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(com.bumptech.glide.load.engine.z.e eVar, Bitmap bitmap) throws IOException;

        void b();
    }

    static {
        Boolean bool = Boolean.FALSE;
        f1638d = e.f("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        f1639e = e.f("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
    }

    public k(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, com.bumptech.glide.load.engine.z.e eVar, com.bumptech.glide.load.engine.z.b bVar) {
        this.m = list;
        this.k = (DisplayMetrics) i.d(displayMetrics);
        this.j = (com.bumptech.glide.load.engine.z.e) i.d(eVar);
        this.l = (com.bumptech.glide.load.engine.z.b) i.d(bVar);
    }

    private static int a(double d2) {
        int l = l(d2);
        int x = x(l * d2);
        return x((d2 / (x / l)) * x);
    }

    private void b(q qVar, DecodeFormat decodeFormat, boolean z, boolean z2, BitmapFactory.Options options, int i2, int i3) {
        if (!this.n.i(i2, i3, options, z, z2)) {
            if (decodeFormat == DecodeFormat.PREFER_ARGB_8888 || Build.VERSION.SDK_INT == 16) {
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                return;
            }
            boolean z3 = false;
            try {
                z3 = qVar.d().hasAlpha();
            } catch (IOException e2) {
                if (Log.isLoggable("Downsampler", 3)) {
                    Log.d("Downsampler", "Cannot determine whether the image has alpha or not from header, format " + decodeFormat, e2);
                }
            }
            Bitmap.Config config = z3 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
            options.inPreferredConfig = config;
            if (config == Bitmap.Config.RGB_565) {
                options.inDither = true;
            }
        }
    }

    private static void c(ImageHeaderParser.ImageType imageType, q qVar, b bVar, com.bumptech.glide.load.engine.z.e eVar, DownsampleStrategy downsampleStrategy, int i2, int i3, int i4, int i5, int i6, BitmapFactory.Options options) throws IOException {
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        double d2;
        if (i3 > 0 && i4 > 0) {
            if (r(i2)) {
                i7 = i3;
                i8 = i4;
            } else {
                i8 = i3;
                i7 = i4;
            }
            float b2 = downsampleStrategy.b(i8, i7, i5, i6);
            if (b2 > 0.0f) {
                DownsampleStrategy.SampleSizeRounding a2 = downsampleStrategy.a(i8, i7, i5, i6);
                if (a2 != null) {
                    float f2 = i8;
                    float f3 = i7;
                    int x = i8 / x(b2 * f2);
                    int x2 = i7 / x(b2 * f3);
                    DownsampleStrategy.SampleSizeRounding sampleSizeRounding = DownsampleStrategy.SampleSizeRounding.MEMORY;
                    if (a2 == sampleSizeRounding) {
                        i9 = Math.max(x, x2);
                    } else {
                        i9 = Math.min(x, x2);
                    }
                    int i13 = Build.VERSION.SDK_INT;
                    if (i13 > 23 || !f1640f.contains(options.outMimeType)) {
                        i10 = Math.max(1, Integer.highestOneBit(i9));
                        if (a2 == sampleSizeRounding && i10 < 1.0f / b2) {
                            i10 <<= 1;
                        }
                    } else {
                        i10 = 1;
                    }
                    options.inSampleSize = i10;
                    if (imageType == ImageHeaderParser.ImageType.JPEG) {
                        float min = Math.min(i10, 8);
                        i11 = (int) Math.ceil(f2 / min);
                        i12 = (int) Math.ceil(f3 / min);
                        int i14 = i10 / 8;
                        if (i14 > 0) {
                            i11 /= i14;
                            i12 /= i14;
                        }
                    } else {
                        if (imageType == ImageHeaderParser.ImageType.PNG || imageType == ImageHeaderParser.ImageType.PNG_A) {
                            float f4 = i10;
                            i11 = (int) Math.floor(f2 / f4);
                            d2 = Math.floor(f3 / f4);
                        } else if (imageType == ImageHeaderParser.ImageType.WEBP || imageType == ImageHeaderParser.ImageType.WEBP_A) {
                            if (i13 >= 24) {
                                float f5 = i10;
                                i11 = Math.round(f2 / f5);
                                i12 = Math.round(f3 / f5);
                            } else {
                                float f6 = i10;
                                i11 = (int) Math.floor(f2 / f6);
                                d2 = Math.floor(f3 / f6);
                            }
                        } else if (i8 % i10 == 0 && i7 % i10 == 0) {
                            i11 = i8 / i10;
                            i12 = i7 / i10;
                        } else {
                            int[] m = m(qVar, options, bVar, eVar);
                            i11 = m[0];
                            i12 = m[1];
                        }
                        i12 = (int) d2;
                    }
                    double b3 = downsampleStrategy.b(i11, i12, i5, i6);
                    if (i13 >= 19) {
                        options.inTargetDensity = a(b3);
                        options.inDensity = l(b3);
                    }
                    if (s(options)) {
                        options.inScaled = true;
                    } else {
                        options.inTargetDensity = 0;
                        options.inDensity = 0;
                    }
                    if (Log.isLoggable("Downsampler", 2)) {
                        Log.v("Downsampler", "Calculate scaling, source: [" + i3 + "x" + i4 + "], degreesToRotate: " + i2 + ", target: [" + i5 + "x" + i6 + "], power of two scaled: [" + i11 + "x" + i12 + "], exact scale factor: " + b2 + ", power of 2 sample size: " + i10 + ", adjusted scale factor: " + b3 + ", target density: " + options.inTargetDensity + ", density: " + options.inDensity);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("Cannot round with null rounding");
            }
            throw new IllegalArgumentException("Cannot scale with factor: " + b2 + " from: " + downsampleStrategy + ", source: [" + i3 + "x" + i4 + "], target: [" + i5 + "x" + i6 + "]");
        } else if (Log.isLoggable("Downsampler", 3)) {
            Log.d("Downsampler", "Unable to determine dimensions for: " + imageType + " with target [" + i5 + "x" + i6 + "]");
        }
    }

    private u<Bitmap> e(q qVar, int i2, int i3, f fVar, b bVar) throws IOException {
        byte[] bArr = (byte[]) this.l.c(65536, byte[].class);
        BitmapFactory.Options k = k();
        k.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) fVar.c(a);
        PreferredColorSpace preferredColorSpace = (PreferredColorSpace) fVar.c(f1636b);
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) fVar.c(DownsampleStrategy.h);
        boolean booleanValue = ((Boolean) fVar.c(f1638d)).booleanValue();
        e<Boolean> eVar = f1639e;
        try {
            return e.f(h(qVar, k, downsampleStrategy, decodeFormat, preferredColorSpace, fVar.c(eVar) != null && ((Boolean) fVar.c(eVar)).booleanValue(), i2, i3, booleanValue, bVar), this.j);
        } finally {
            v(k);
            this.l.e(bArr);
        }
    }

    private Bitmap h(q qVar, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, PreferredColorSpace preferredColorSpace, boolean z, int i2, int i3, boolean z2, b bVar) throws IOException {
        int i4;
        int i5;
        int i6;
        k kVar;
        int i7;
        ColorSpace colorSpace;
        int i8;
        int i9;
        long b2 = com.bumptech.glide.util.e.b();
        int[] m = m(qVar, options, bVar, this.j);
        boolean z3 = false;
        int i10 = m[0];
        int i11 = m[1];
        String str = options.outMimeType;
        boolean z4 = (i10 == -1 || i11 == -1) ? false : z;
        int c2 = qVar.c();
        int i12 = y.i(c2);
        boolean l = y.l(c2);
        if (i2 == Integer.MIN_VALUE) {
            i5 = i3;
            i4 = r(i12) ? i11 : i10;
        } else {
            i5 = i3;
            i4 = i2;
        }
        if (i5 == Integer.MIN_VALUE) {
            i6 = r(i12) ? i10 : i11;
        } else {
            i6 = i5;
        }
        ImageHeaderParser.ImageType d2 = qVar.d();
        c(d2, qVar, bVar, this.j, downsampleStrategy, i12, i10, i11, i4, i6, options);
        b(qVar, decodeFormat, z4, l, options, i4, i6);
        int i13 = Build.VERSION.SDK_INT;
        boolean z5 = i13 >= 19;
        if (options.inSampleSize == 1 || z5) {
            kVar = this;
            if (kVar.z(d2)) {
                if (i10 < 0 || i11 < 0 || !z2 || !z5) {
                    float f2 = s(options) ? options.inTargetDensity / options.inDensity : 1.0f;
                    int i14 = options.inSampleSize;
                    float f3 = i14;
                    i9 = Math.round(((int) Math.ceil(i10 / f3)) * f2);
                    i8 = Math.round(((int) Math.ceil(i11 / f3)) * f2);
                    if (Log.isLoggable("Downsampler", 2)) {
                        Log.v("Downsampler", "Calculated target [" + i9 + "x" + i8 + "] for source [" + i10 + "x" + i11 + "], sampleSize: " + i14 + ", targetDensity: " + options.inTargetDensity + ", density: " + options.inDensity + ", density multiplier: " + f2);
                    }
                } else {
                    i9 = i4;
                    i8 = i6;
                }
                if (i9 > 0 && i8 > 0) {
                    y(options, kVar.j, i9, i8);
                }
            }
        } else {
            kVar = this;
        }
        if (i13 >= 28) {
            if (preferredColorSpace == PreferredColorSpace.DISPLAY_P3 && (colorSpace = options.outColorSpace) != null && colorSpace.isWideGamut()) {
                z3 = true;
            }
            options.inPreferredColorSpace = ColorSpace.get(z3 ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB);
        } else if (i13 >= 26) {
            options.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        Bitmap i15 = i(qVar, options, bVar, kVar.j);
        bVar.a(kVar.j, i15);
        if (Log.isLoggable("Downsampler", 2)) {
            i7 = c2;
            t(i10, i11, str, options, i15, i2, i3, b2);
        } else {
            i7 = c2;
        }
        Bitmap bitmap = null;
        if (i15 != null) {
            i15.setDensity(kVar.k.densityDpi);
            bitmap = y.m(kVar.j, i15, i7);
            if (!i15.equals(bitmap)) {
                kVar.j.c(i15);
            }
        }
        return bitmap;
    }

    private static Bitmap i(q qVar, BitmapFactory.Options options, b bVar, com.bumptech.glide.load.engine.z.e eVar) throws IOException {
        if (!options.inJustDecodeBounds) {
            bVar.b();
            qVar.b();
        }
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        String str = options.outMimeType;
        y.h().lock();
        try {
            try {
                Bitmap a2 = qVar.a(options);
                y.h().unlock();
                return a2;
            } catch (IllegalArgumentException e2) {
                IOException u = u(e2, i2, i3, str, options);
                if (Log.isLoggable("Downsampler", 3)) {
                    Log.d("Downsampler", "Failed to decode with inBitmap, trying again without Bitmap re-use", u);
                }
                Bitmap bitmap = options.inBitmap;
                if (bitmap != null) {
                    try {
                        eVar.c(bitmap);
                        options.inBitmap = null;
                        Bitmap i4 = i(qVar, options, bVar, eVar);
                        y.h().unlock();
                        return i4;
                    } catch (IOException unused) {
                        throw u;
                    }
                } else {
                    throw u;
                }
            }
        } catch (Throwable th) {
            y.h().unlock();
            throw th;
        }
    }

    @Nullable
    @TargetApi(19)
    private static String j(Bitmap bitmap) {
        String str;
        if (bitmap == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            str = " (" + bitmap.getAllocationByteCount() + ")";
        } else {
            str = "";
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + str;
    }

    private static synchronized BitmapFactory.Options k() {
        BitmapFactory.Options poll;
        synchronized (k.class) {
            Queue<BitmapFactory.Options> queue = i;
            synchronized (queue) {
                poll = queue.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                w(poll);
            }
        }
        return poll;
    }

    private static int l(double d2) {
        if (d2 > 1.0d) {
            d2 = 1.0d / d2;
        }
        return (int) Math.round(d2 * 2.147483647E9d);
    }

    private static int[] m(q qVar, BitmapFactory.Options options, b bVar, com.bumptech.glide.load.engine.z.e eVar) throws IOException {
        options.inJustDecodeBounds = true;
        i(qVar, options, bVar, eVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static String n(BitmapFactory.Options options) {
        return j(options.inBitmap);
    }

    private static boolean r(int i2) {
        return i2 == 90 || i2 == 270;
    }

    private static boolean s(BitmapFactory.Options options) {
        int i2;
        int i3 = options.inTargetDensity;
        return i3 > 0 && (i2 = options.inDensity) > 0 && i3 != i2;
    }

    private static void t(int i2, int i3, String str, BitmapFactory.Options options, Bitmap bitmap, int i4, int i5, long j) {
        Log.v("Downsampler", "Decoded " + j(bitmap) + " from [" + i2 + "x" + i3 + "] " + str + " with inBitmap " + n(options) + " for [" + i4 + "x" + i5 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + com.bumptech.glide.util.e.a(j));
    }

    private static IOException u(IllegalArgumentException illegalArgumentException, int i2, int i3, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i2 + ", outHeight: " + i3 + ", outMimeType: " + str + ", inBitmap: " + n(options), illegalArgumentException);
    }

    private static void v(BitmapFactory.Options options) {
        w(options);
        Queue<BitmapFactory.Options> queue = i;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    private static void w(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    private static int x(double d2) {
        return (int) (d2 + 0.5d);
    }

    @TargetApi(26)
    private static void y(BitmapFactory.Options options, com.bumptech.glide.load.engine.z.e eVar, int i2, int i3) {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT < 26) {
            config = null;
        } else if (options.inPreferredConfig != Bitmap.Config.HARDWARE) {
            config = options.outConfig;
        } else {
            return;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = eVar.e(i2, i3, config);
    }

    private boolean z(ImageHeaderParser.ImageType imageType) {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return h.contains(imageType);
    }

    @RequiresApi(21)
    public u<Bitmap> d(ParcelFileDescriptor parcelFileDescriptor, int i2, int i3, f fVar) throws IOException {
        return e(new q.b(parcelFileDescriptor, this.m, this.l), i2, i3, fVar, g);
    }

    public u<Bitmap> f(InputStream inputStream, int i2, int i3, f fVar) throws IOException {
        return g(inputStream, i2, i3, fVar, g);
    }

    public u<Bitmap> g(InputStream inputStream, int i2, int i3, f fVar, b bVar) throws IOException {
        return e(new q.a(inputStream, this.m, this.l), i2, i3, fVar, bVar);
    }

    public boolean o(ParcelFileDescriptor parcelFileDescriptor) {
        return ParcelFileDescriptorRewinder.c();
    }

    public boolean p(InputStream inputStream) {
        return true;
    }

    public boolean q(ByteBuffer byteBuffer) {
        return true;
    }
}
