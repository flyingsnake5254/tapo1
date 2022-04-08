package b.d.e0.h;

import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: FlashlightManager.java */
/* loaded from: classes3.dex */
final class d {
    private static final String a = "d";

    /* renamed from: b  reason: collision with root package name */
    private static final Object f410b;

    /* renamed from: c  reason: collision with root package name */
    private static final Method f411c;

    static {
        String simpleName = d.class.getSimpleName();
        Object b2 = b();
        f410b = b2;
        f411c = c(b2);
        if (b2 == null) {
            Log.v(simpleName, "This device does supports control of a flashlight");
        } else {
            Log.v(simpleName, "This device does not support control of a flashlight");
        }
    }

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a() {
        g(false);
    }

    private static Object b() {
        Method f2;
        Object d2;
        Class<?> e2;
        Method f3;
        Class<?> e3 = e("android.os.ServiceManager");
        if (e3 == null || (f2 = f(e3, "getService", String.class)) == null || (d2 = d(f2, null, "hardware")) == null || (e2 = e("android.os.IHardwareService$Stub")) == null || (f3 = f(e2, "asInterface", IBinder.class)) == null) {
            return null;
        }
        return d(f3, null, d2);
    }

    private static Method c(Object obj) {
        if (obj == null) {
            return null;
        }
        return f(obj.getClass(), "setFlashlightEnabled", Boolean.TYPE);
    }

    private static Object d(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            String str = a;
            Log.w(str, "Unexpected error while invoking " + method, e2);
            return null;
        } catch (RuntimeException e3) {
            String str2 = a;
            Log.w(str2, "Unexpected error while invoking " + method, e3);
            return null;
        } catch (InvocationTargetException e4) {
            String str3 = a;
            Log.w(str3, "Unexpected error while invoking " + method, e4.getCause());
            return null;
        }
    }

    private static Class<?> e(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (RuntimeException e2) {
            String str2 = a;
            Log.w(str2, "Unexpected error while finding class " + str, e2);
            return null;
        }
    }

    private static Method f(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
            return null;
        } catch (RuntimeException e2) {
            String str2 = a;
            Log.w(str2, "Unexpected error while finding method " + str, e2);
            return null;
        }
    }

    private static void g(boolean z) {
        Object obj = f410b;
        if (obj != null) {
            d(f411c, obj, Boolean.valueOf(z));
        }
    }
}
