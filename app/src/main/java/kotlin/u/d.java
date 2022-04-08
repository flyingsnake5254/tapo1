package kotlin.u;

import kotlin.jvm.internal.j;

/* compiled from: Random.kt */
/* loaded from: classes4.dex */
public final class d {
    public static final String a(Object from, Object until) {
        j.e(from, "from");
        j.e(until, "until");
        return "Random range is empty: [" + from + ", " + until + ").";
    }

    public static final void b(int i, int i2) {
        if (!(i2 > i)) {
            throw new IllegalArgumentException(a(Integer.valueOf(i), Integer.valueOf(i2)).toString());
        }
    }

    public static final int c(int i) {
        return 31 - Integer.numberOfLeadingZeros(i);
    }

    public static final int d(int i, int i2) {
        return (i >>> (32 - i2)) & ((-i2) >> 31);
    }
}
