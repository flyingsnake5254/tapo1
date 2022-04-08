package f.a.h;

import android.graphics.drawable.Drawable;
import java.lang.reflect.Method;

/* compiled from: SkinCompatVersionUtils.java */
/* loaded from: classes4.dex */
public final class a {
    private static Class<?> a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f15596b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f15597c;

    /* renamed from: d  reason: collision with root package name */
    private static Class<?> f15598d;

    /* renamed from: e  reason: collision with root package name */
    private static Method f15599e;

    /* renamed from: f  reason: collision with root package name */
    private static Method f15600f;

    static {
        try {
            f15598d = Class.forName("androidx.core.graphics.drawable.WrappedDrawable");
        } catch (ClassNotFoundException unused) {
            if (c.a) {
                c.a("SkinCompatUtils", "hasWrappedDrawable = false");
            }
        }
        try {
            a = Class.forName("androidx.core.graphics.drawable.DrawableWrapper");
        } catch (ClassNotFoundException unused2) {
            if (c.a) {
                c.a("SkinCompatUtils", "hasDrawableWrapper = false");
            }
        }
    }

    public static Drawable a(Drawable drawable) {
        Class<?> cls = a;
        if (cls != null) {
            if (f15596b == null) {
                try {
                    Method declaredMethod = cls.getDeclaredMethod("getWrappedDrawable", new Class[0]);
                    f15596b = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (Exception unused) {
                    if (c.a) {
                        c.a("SkinCompatUtils", "getV4DrawableWrapperWrappedDrawable No Such Method");
                    }
                }
            }
            Method method = f15596b;
            if (method != null) {
                try {
                    return (Drawable) method.invoke(drawable, new Object[0]);
                } catch (Exception e2) {
                    if (c.a) {
                        c.a("SkinCompatUtils", "getV4DrawableWrapperWrappedDrawable invoke error: " + e2);
                    }
                }
            }
        }
        return drawable;
    }

    public static Drawable b(Drawable drawable) {
        Class<?> cls = f15598d;
        if (cls != null) {
            if (f15599e == null) {
                try {
                    Method declaredMethod = cls.getDeclaredMethod("getWrappedDrawable", new Class[0]);
                    f15599e = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (Exception unused) {
                    if (c.a) {
                        c.a("SkinCompatUtils", "getV4WrappedDrawableWrappedDrawable No Such Method");
                    }
                }
            }
            Method method = f15599e;
            if (method != null) {
                try {
                    return (Drawable) method.invoke(drawable, new Object[0]);
                } catch (Exception e2) {
                    if (c.a) {
                        c.a("SkinCompatUtils", "getV4WrappedDrawableWrappedDrawable invoke error: " + e2);
                    }
                }
            }
        }
        return drawable;
    }

    public static boolean c(Drawable drawable) {
        Class<?> cls = a;
        return cls != null && cls.isAssignableFrom(drawable.getClass());
    }

    public static boolean d(Drawable drawable) {
        Class<?> cls = f15598d;
        return cls != null && cls.isAssignableFrom(drawable.getClass());
    }

    public static void e(Drawable drawable, Drawable drawable2) {
        Class<?> cls = a;
        if (cls != null) {
            if (f15597c == null) {
                try {
                    Method declaredMethod = cls.getDeclaredMethod("setWrappedDrawable", Drawable.class);
                    f15597c = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (Exception unused) {
                    if (c.a) {
                        c.a("SkinCompatUtils", "setV4DrawableWrapperWrappedDrawable No Such Method");
                    }
                }
            }
            Method method = f15597c;
            if (method != null) {
                try {
                    method.invoke(drawable, drawable2);
                } catch (Exception e2) {
                    if (c.a) {
                        c.a("SkinCompatUtils", "setV4DrawableWrapperWrappedDrawable invoke error: " + e2);
                    }
                }
            }
        }
    }

    public static void f(Drawable drawable, Drawable drawable2) {
        Class<?> cls = f15598d;
        if (cls != null) {
            if (f15600f == null) {
                try {
                    Method declaredMethod = cls.getDeclaredMethod("setWrappedDrawable", Drawable.class);
                    f15600f = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (Exception unused) {
                    if (c.a) {
                        c.a("SkinCompatUtils", "setV4WrappedDrawableWrappedDrawable No Such Method");
                    }
                }
            }
            Method method = f15600f;
            if (method != null) {
                try {
                    method.invoke(drawable, drawable2);
                } catch (Exception e2) {
                    if (c.a) {
                        c.a("SkinCompatUtils", "setV4WrappedDrawableWrappedDrawable invoke error: " + e2);
                    }
                }
            }
        }
    }
}
