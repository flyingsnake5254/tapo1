package b.d.w.c;

import android.content.Context;
import b.c.a.g;
import b.d.w.c.c.e;

/* compiled from: TLog.java */
/* loaded from: classes3.dex */
public class a {
    private static boolean a = false;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f783b = false;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f784c = false;

    public static void a(String str) {
        g.b(str);
    }

    public static void b(String str, Object obj) {
        g.f(str).c(obj);
    }

    public static void c(String str, String str2) {
        g.f(str).c(str2);
    }

    public static void d(String str) {
        g.c(str, new Object[0]);
    }

    public static void e(String str, String str2) {
        g.f(str).f(str2, new Object[0]);
    }

    public static void f(String str, Throwable th, String str2, Object... objArr) {
        g.f(str).i(th, str2, objArr);
    }

    public static void g(Throwable th, String str, Object... objArr) {
        g.d(th, str, objArr);
    }

    public static void h(String str) {
        g.e(str, new Object[0]);
    }

    public static void i(String str, String str2) {
        g.f(str).b(str2, new Object[0]);
    }

    public static void j(Context context, String str, boolean z, boolean z2, boolean z3) {
        a = z;
        f783b = z2;
        f784c = z3;
        if (z) {
            g.a(new b.c.a.a());
        }
        if (z2) {
            g.a(b.d.w.c.b.a.e(context, str, 0L));
        }
        if (z3) {
            g.a(e.d(context));
        }
    }

    public static void k(String str, String str2) {
        g.f(str).a(str2);
    }

    public static void l(String str, String str2) {
        g.f(str).e(str2, new Object[0]);
    }

    public static void m(String str) {
        g.g(str, new Object[0]);
    }

    public static void n(String str, String str2) {
        g.f(str).h(str2, new Object[0]);
    }
}
