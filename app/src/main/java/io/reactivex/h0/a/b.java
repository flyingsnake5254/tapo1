package io.reactivex.h0.a;

import io.reactivex.g0.d;
import java.util.Objects;

/* compiled from: ObjectHelper.java */
/* loaded from: classes4.dex */
public final class b {
    static final d<Object, Object> a = new a();

    /* compiled from: ObjectHelper.java */
    /* loaded from: classes4.dex */
    static final class a implements d<Object, Object> {
        a() {
        }

        @Override // io.reactivex.g0.d
        public boolean a(Object obj, Object obj2) {
            return b.c(obj, obj2);
        }
    }

    public static int a(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }

    public static int b(long j, long j2) {
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        return i > 0 ? 1 : 0;
    }

    public static boolean c(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static <T> d<T, T> d() {
        return (d<T, T>) a;
    }

    public static <T> T e(T t, String str) {
        Objects.requireNonNull(t, str);
        return t;
    }

    public static int f(int i, String str) {
        if (i > 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + i);
    }
}
