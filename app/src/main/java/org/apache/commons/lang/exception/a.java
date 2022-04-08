package org.apache.commons.lang.exception;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import org.apache.commons.lang.f;

/* compiled from: ExceptionUtils.java */
/* loaded from: classes4.dex */
public class a {
    private static final Object a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static String[] f16644b = {"getCause", "getNextException", "getTargetException", "getException", "getSourceException", "getRootCause", "getCausedByException", "getNested", "getLinkedException", "getNestedException", "getLinkedCause", "getThrowable"};

    /* renamed from: c  reason: collision with root package name */
    private static final Method f16645c;

    /* renamed from: d  reason: collision with root package name */
    private static final Method f16646d;

    /* renamed from: e  reason: collision with root package name */
    static /* synthetic */ Class f16647e;

    static {
        Method method;
        Method method2 = null;
        try {
            Class cls = f16647e;
            if (cls == null) {
                cls = a("java.lang.Throwable");
                f16647e = cls;
            }
            method = cls.getMethod("getCause", null);
        } catch (Exception unused) {
            method = null;
        }
        f16645c = method;
        try {
            Class cls2 = f16647e;
            if (cls2 == null) {
                cls2 = a("java.lang.Throwable");
                f16647e = cls2;
            }
            Class<?>[] clsArr = new Class[1];
            Class<?> cls3 = f16647e;
            if (cls3 == null) {
                cls3 = a("java.lang.Throwable");
                f16647e = cls3;
            }
            clsArr[0] = cls3;
            method2 = cls2.getMethod("initCause", clsArr);
        } catch (Exception unused2) {
        }
        f16646d = method2;
    }

    static /* synthetic */ Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    public static Throwable b(Throwable th) {
        Throwable c2;
        synchronized (a) {
            c2 = c(th, f16644b);
        }
        return c2;
    }

    public static Throwable c(Throwable th, String[] strArr) {
        String str;
        if (th == null) {
            return null;
        }
        Throwable f2 = f(th);
        if (f2 != null) {
            return f2;
        }
        if (strArr == null) {
            synchronized (a) {
                strArr = f16644b;
            }
        }
        for (int i = 0; i < strArr.length && ((str = strArr[i]) == null || (f2 = e(th, str)) == null); i++) {
        }
        return f2 == null ? d(th, "detail") : f2;
    }

    private static Throwable d(Throwable th, String str) {
        Field field;
        try {
            field = th.getClass().getField(str);
        } catch (NoSuchFieldException | SecurityException unused) {
            field = null;
        }
        if (field != null) {
            Class cls = f16647e;
            if (cls == null) {
                cls = a("java.lang.Throwable");
                f16647e = cls;
            }
            if (cls.isAssignableFrom(field.getType())) {
                try {
                    return (Throwable) field.get(th);
                } catch (IllegalAccessException | IllegalArgumentException unused2) {
                }
            }
        }
        return null;
    }

    private static Throwable e(Throwable th, String str) {
        Method method;
        try {
            method = th.getClass().getMethod(str, null);
        } catch (NoSuchMethodException | SecurityException unused) {
            method = null;
        }
        if (method != null) {
            Class cls = f16647e;
            if (cls == null) {
                cls = a("java.lang.Throwable");
                f16647e = cls;
            }
            if (cls.isAssignableFrom(method.getReturnType())) {
                try {
                    return (Throwable) method.invoke(th, org.apache.commons.lang.a.a);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused2) {
                }
            }
        }
        return null;
    }

    private static Throwable f(Throwable th) {
        if (th instanceof b) {
            return ((b) th).getCause();
        }
        if (th instanceof SQLException) {
            return ((SQLException) th).getNextException();
        }
        if (th instanceof InvocationTargetException) {
            return ((InvocationTargetException) th).getTargetException();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String[] g(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, f.F);
        ArrayList arrayList = new ArrayList();
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        return m(arrayList);
    }

    public static int h(Throwable th) {
        return i(th).size();
    }

    public static List i(Throwable th) {
        ArrayList arrayList = new ArrayList();
        while (th != null && !arrayList.contains(th)) {
            arrayList.add(th);
            th = b(th);
        }
        return arrayList;
    }

    public static Throwable[] j(Throwable th) {
        List i = i(th);
        return (Throwable[]) i.toArray(new Throwable[i.size()]);
    }

    public static boolean k() {
        return f16645c != null;
    }

    public static void l(List list, List list2) {
        if (list == null || list2 == null) {
            throw new IllegalArgumentException("The List must not be null");
        }
        int size = list.size() - 1;
        for (int size2 = list2.size() - 1; size >= 0 && size2 >= 0; size2--) {
            if (((String) list.get(size)).equals((String) list2.get(size2))) {
                list.remove(size);
            }
            size--;
        }
    }

    private static String[] m(List list) {
        return (String[]) list.toArray(new String[list.size()]);
    }
}
