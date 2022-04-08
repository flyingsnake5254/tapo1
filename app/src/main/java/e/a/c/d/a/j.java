package e.a.c.d.a;

/* loaded from: classes4.dex */
public final class j {
    public static int a(int i) {
        int i2 = -1;
        while (i != 0) {
            i2++;
            i >>>= 1;
        }
        return i2;
    }

    public static int b(int i, int i2) {
        while (i2 != 0) {
            i2 = e(i2, i2);
        }
        return i2;
    }

    public static boolean c(int i) {
        if (i == 0) {
            return false;
        }
        int a = a(i) >>> 1;
        int i2 = 2;
        for (int i3 = 0; i3 < a; i3++) {
            i2 = d(i2, i2, i);
            if (b(i2 ^ 2, i) != 1) {
                return false;
            }
        }
        return true;
    }

    public static int d(int i, int i2, int i3) {
        int e2 = e(i, i3);
        int e3 = e(i2, i3);
        int i4 = 0;
        if (e3 != 0) {
            int a = 1 << a(i3);
            while (e2 != 0) {
                if (((byte) (e2 & 1)) == 1) {
                    i4 ^= e3;
                }
                e2 >>>= 1;
                e3 <<= 1;
                if (e3 >= a) {
                    e3 ^= i3;
                }
            }
        }
        return i4;
    }

    public static int e(int i, int i2) {
        if (i2 == 0) {
            System.err.println("Error: to be divided by 0");
            return 0;
        }
        while (a(i) >= a(i2)) {
            i ^= i2 << (a(i) - a(i2));
        }
        return i;
    }
}
