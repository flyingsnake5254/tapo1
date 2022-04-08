package e.a.b.c;

import java.util.Random;

/* loaded from: classes4.dex */
public abstract class b {
    private static int a(int i) {
        int i2 = 0;
        while ((i & 1) == 0) {
            i >>>= 1;
            i2++;
        }
        return i2;
    }

    private static void b(int[] iArr, int i, int[] iArr2, int[] iArr3) {
        if (i < 0) {
            m.a(iArr.length, iArr2, iArr, iArr3);
        } else {
            System.arraycopy(iArr2, 0, iArr3, 0, iArr.length);
        }
    }

    private static int c(int[] iArr, int[] iArr2, int i, int[] iArr3, int i2) {
        int length = iArr.length;
        int i3 = 0;
        while (iArr2[0] == 0) {
            m.C(i, iArr2, 0);
            i3 += 32;
        }
        int a = a(iArr2[0]);
        if (a > 0) {
            m.A(i, iArr2, a, 0);
            i3 += a;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if ((iArr3[0] & 1) != 0) {
                i2 += i2 < 0 ? m.e(length, iArr, iArr3) : m.N(length, iArr, iArr3);
            }
            m.z(length, iArr3, i2);
        }
        return i2;
    }

    public static void d(int[] iArr, int[] iArr2, int[] iArr3) {
        int length = iArr.length;
        if (!m.w(length, iArr2)) {
            int i = 0;
            if (m.v(length, iArr2)) {
                System.arraycopy(iArr2, 0, iArr3, 0, length);
                return;
            }
            int[] i2 = m.i(length, iArr2);
            int[] j = m.j(length);
            j[0] = 1;
            int c2 = (1 & i2[0]) == 0 ? c(iArr, i2, length, j, 0) : 0;
            if (m.v(length, i2)) {
                b(iArr, c2, j, iArr3);
                return;
            }
            int[] i3 = m.i(length, iArr);
            int[] j2 = m.j(length);
            int i4 = length;
            while (true) {
                int i5 = i4 - 1;
                if (i2[i5] == 0 && i3[i5] == 0) {
                    i4--;
                } else if (m.q(i4, i2, i3)) {
                    m.N(i4, i3, i2);
                    c2 = c(iArr, i2, i4, j, c2 + (m.N(length, j2, j) - i));
                    if (m.v(i4, i2)) {
                        b(iArr, c2, j, iArr3);
                        return;
                    }
                } else {
                    m.N(i4, i2, i3);
                    i = c(iArr, i3, i4, j2, i + (m.N(length, j, j2) - c2));
                    if (m.v(i4, i3)) {
                        b(iArr, i, j2, iArr3);
                        return;
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("'x' cannot be 0");
        }
    }

    public static int[] e(int[] iArr) {
        int length = iArr.length;
        Random random = new Random();
        int[] j = m.j(length);
        int i = length - 1;
        int i2 = iArr[i];
        int i3 = i2 | (i2 >>> 1);
        int i4 = i3 | (i3 >>> 2);
        int i5 = i4 | (i4 >>> 4);
        int i6 = i5 | (i5 >>> 8);
        int i7 = i6 | (i6 >>> 16);
        do {
            for (int i8 = 0; i8 != length; i8++) {
                j[i8] = random.nextInt();
            }
            j[i] = j[i] & i7;
        } while (m.q(length, j, iArr));
        return j;
    }
}
