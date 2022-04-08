package com.google.common.base;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Preconditions.java */
/* loaded from: classes2.dex */
public final class n {
    private static String a(int i, int i2, @NullableDecl String str) {
        if (i < 0) {
            return s.b("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return s.b("%s (%s) must be less than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IllegalArgumentException("negative size: " + i2);
    }

    private static String b(int i, int i2, @NullableDecl String str) {
        if (i < 0) {
            return s.b("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return s.b("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IllegalArgumentException("negative size: " + i2);
    }

    private static String c(int i, int i2, int i3) {
        if (i < 0 || i > i3) {
            return b(i, i3, "start index");
        }
        return (i2 < 0 || i2 > i3) ? b(i2, i3, "end index") : s.b("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
    }

    public static void d(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void e(boolean z, @NullableDecl Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void f(boolean z, @NullableDecl String str, int i) {
        if (!z) {
            throw new IllegalArgumentException(s.b(str, Integer.valueOf(i)));
        }
    }

    public static void g(boolean z, @NullableDecl String str, int i, int i2) {
        if (!z) {
            throw new IllegalArgumentException(s.b(str, Integer.valueOf(i), Integer.valueOf(i2)));
        }
    }

    public static void h(boolean z, @NullableDecl String str, long j) {
        if (!z) {
            throw new IllegalArgumentException(s.b(str, Long.valueOf(j)));
        }
    }

    public static void i(boolean z, @NullableDecl String str, long j, long j2) {
        if (!z) {
            throw new IllegalArgumentException(s.b(str, Long.valueOf(j), Long.valueOf(j2)));
        }
    }

    public static void j(boolean z, @NullableDecl String str, @NullableDecl Object obj) {
        if (!z) {
            throw new IllegalArgumentException(s.b(str, obj));
        }
    }

    public static void k(boolean z, @NullableDecl String str, @NullableDecl Object obj, @NullableDecl Object obj2) {
        if (!z) {
            throw new IllegalArgumentException(s.b(str, obj, obj2));
        }
    }

    public static void l(boolean z, @NullableDecl String str, @NullableDecl Object obj, @NullableDecl Object obj2, @NullableDecl Object obj3, @NullableDecl Object obj4) {
        if (!z) {
            throw new IllegalArgumentException(s.b(str, obj, obj2, obj3, obj4));
        }
    }

    @CanIgnoreReturnValue
    public static int m(int i, int i2) {
        return n(i, i2, FirebaseAnalytics.Param.INDEX);
    }

    @CanIgnoreReturnValue
    public static int n(int i, int i2, @NullableDecl String str) {
        if (i >= 0 && i < i2) {
            return i;
        }
        throw new IndexOutOfBoundsException(a(i, i2, str));
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T o(@NonNullDecl T t) {
        Objects.requireNonNull(t);
        return t;
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T p(@NonNullDecl T t, @NullableDecl Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T q(@NonNullDecl T t, @NullableDecl String str, @NullableDecl Object obj, @NullableDecl Object obj2) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(s.b(str, obj, obj2));
    }

    @CanIgnoreReturnValue
    public static int r(int i, int i2) {
        return s(i, i2, FirebaseAnalytics.Param.INDEX);
    }

    @CanIgnoreReturnValue
    public static int s(int i, int i2, @NullableDecl String str) {
        if (i >= 0 && i <= i2) {
            return i;
        }
        throw new IndexOutOfBoundsException(b(i, i2, str));
    }

    public static void t(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            throw new IndexOutOfBoundsException(c(i, i2, i3));
        }
    }

    public static void u(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void v(boolean z, @NullableDecl Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void w(boolean z, @NullableDecl String str, int i) {
        if (!z) {
            throw new IllegalStateException(s.b(str, Integer.valueOf(i)));
        }
    }

    public static void x(boolean z, @NullableDecl String str, @NullableDecl Object obj) {
        if (!z) {
            throw new IllegalStateException(s.b(str, obj));
        }
    }
}
