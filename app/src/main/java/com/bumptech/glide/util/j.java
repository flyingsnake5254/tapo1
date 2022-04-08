package com.bumptech.glide.util;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.j.l;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

/* compiled from: Util.java */
/* loaded from: classes.dex */
public final class j {
    private static final char[] a = "0123456789abcdef".toCharArray();

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f1778b = new char[64];
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private static volatile Handler f1779c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Util.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            a = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Bitmap.Config.RGBA_F16.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Bitmap.Config.ARGB_8888.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private j() {
    }

    public static void a() {
        if (!r()) {
            throw new IllegalArgumentException("You must call this method on a background thread");
        }
    }

    public static void b() {
        if (!s()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static boolean c(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        if (obj instanceof l) {
            return ((l) obj).a(obj2);
        }
        return obj.equals(obj2);
    }

    public static boolean d(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    @NonNull
    private static String e(@NonNull byte[] bArr, @NonNull char[] cArr) {
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            char[] cArr2 = a;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    @NonNull
    public static <T> Queue<T> f(int i) {
        return new ArrayDeque(i);
    }

    public static int g(int i, int i2, @Nullable Bitmap.Config config) {
        return i * i2 * i(config);
    }

    @TargetApi(19)
    public static int h(@NonNull Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            if (Build.VERSION.SDK_INT >= 19) {
                try {
                    return bitmap.getAllocationByteCount();
                } catch (NullPointerException unused) {
                }
            }
            return bitmap.getHeight() * bitmap.getRowBytes();
        }
        throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
    }

    private static int i(@Nullable Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i = a.a[config.ordinal()];
        if (i == 1) {
            return 1;
        }
        if (i == 2 || i == 3) {
            return 2;
        }
        return i != 4 ? 4 : 8;
    }

    @NonNull
    public static <T> List<T> j(@NonNull Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T t : collection) {
            if (t != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    private static Handler k() {
        if (f1779c == null) {
            synchronized (j.class) {
                if (f1779c == null) {
                    f1779c = new Handler(Looper.getMainLooper());
                }
            }
        }
        return f1779c;
    }

    public static int l(float f2) {
        return m(f2, 17);
    }

    public static int m(float f2, int i) {
        return o(Float.floatToIntBits(f2), i);
    }

    public static int n(int i) {
        return o(i, 17);
    }

    public static int o(int i, int i2) {
        return (i2 * 31) + i;
    }

    public static int p(@Nullable Object obj, int i) {
        return o(obj == null ? 0 : obj.hashCode(), i);
    }

    public static int q(boolean z, int i) {
        return o(z ? 1 : 0, i);
    }

    public static boolean r() {
        return !s();
    }

    public static boolean s() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    private static boolean t(int i) {
        return i > 0 || i == Integer.MIN_VALUE;
    }

    public static boolean u(int i, int i2) {
        return t(i) && t(i2);
    }

    public static void v(Runnable runnable) {
        k().post(runnable);
    }

    public static void w(Runnable runnable) {
        k().removeCallbacks(runnable);
    }

    @NonNull
    public static String x(@NonNull byte[] bArr) {
        String e2;
        char[] cArr = f1778b;
        synchronized (cArr) {
            e2 = e(bArr, cArr);
        }
        return e2;
    }
}
