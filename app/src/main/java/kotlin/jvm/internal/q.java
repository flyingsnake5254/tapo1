package kotlin.jvm.internal;

import java.util.Map;
import kotlin.jvm.b.b;
import kotlin.jvm.b.c;
import kotlin.jvm.b.d;
import kotlin.jvm.b.e;
import kotlin.jvm.b.f;
import kotlin.jvm.b.g;
import kotlin.jvm.b.h;
import kotlin.jvm.b.i;
import kotlin.jvm.b.j;
import kotlin.jvm.b.k;
import kotlin.jvm.b.l;
import kotlin.jvm.b.m;
import kotlin.jvm.b.n;
import kotlin.jvm.b.o;
import kotlin.jvm.b.p;
import kotlin.jvm.b.r;
import kotlin.jvm.b.s;
import kotlin.jvm.b.t;
import kotlin.jvm.b.u;
import kotlin.jvm.b.v;
import kotlin.jvm.b.w;
import kotlin.jvm.internal.r.a;

/* compiled from: TypeIntrinsics.java */
/* loaded from: classes4.dex */
public class q {
    public static Map a(Object obj) {
        if (obj instanceof a) {
            h(obj, "kotlin.collections.MutableMap");
        }
        return c(obj);
    }

    public static Object b(Object obj, int i) {
        if (obj != null && !e(obj, i)) {
            h(obj, "kotlin.jvm.functions.Function" + i);
        }
        return obj;
    }

    public static Map c(Object obj) {
        try {
            return (Map) obj;
        } catch (ClassCastException e2) {
            throw g(e2);
        }
    }

    public static int d(Object obj) {
        if (obj instanceof h) {
            return ((h) obj).getArity();
        }
        if (obj instanceof kotlin.jvm.b.a) {
            return 0;
        }
        if (obj instanceof l) {
            return 1;
        }
        if (obj instanceof p) {
            return 2;
        }
        if (obj instanceof kotlin.jvm.b.q) {
            return 3;
        }
        if (obj instanceof r) {
            return 4;
        }
        if (obj instanceof s) {
            return 5;
        }
        if (obj instanceof t) {
            return 6;
        }
        if (obj instanceof u) {
            return 7;
        }
        if (obj instanceof v) {
            return 8;
        }
        if (obj instanceof w) {
            return 9;
        }
        if (obj instanceof b) {
            return 10;
        }
        if (obj instanceof c) {
            return 11;
        }
        if (obj instanceof d) {
            return 12;
        }
        if (obj instanceof e) {
            return 13;
        }
        if (obj instanceof f) {
            return 14;
        }
        if (obj instanceof g) {
            return 15;
        }
        if (obj instanceof h) {
            return 16;
        }
        if (obj instanceof i) {
            return 17;
        }
        if (obj instanceof j) {
            return 18;
        }
        if (obj instanceof k) {
            return 19;
        }
        if (obj instanceof m) {
            return 20;
        }
        if (obj instanceof n) {
            return 21;
        }
        return obj instanceof o ? 22 : -1;
    }

    public static boolean e(Object obj, int i) {
        return (obj instanceof kotlin.c) && d(obj) == i;
    }

    private static <T extends Throwable> T f(T t) {
        return (T) j.l(t, q.class.getName());
    }

    public static ClassCastException g(ClassCastException classCastException) {
        throw ((ClassCastException) f(classCastException));
    }

    public static void h(Object obj, String str) {
        String name = obj == null ? "null" : obj.getClass().getName();
        i(name + " cannot be cast to " + str);
    }

    public static void i(String str) {
        throw g(new ClassCastException(str));
    }
}
