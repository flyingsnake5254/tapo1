package com.google.android.exoplayer2.o2.l0;

import com.google.android.exoplayer2.util.d0;

/* compiled from: TsUtil.java */
/* loaded from: classes.dex */
public final class j0 {
    public static int a(byte[] bArr, int i, int i2) {
        while (i < i2 && bArr[i] != 71) {
            i++;
        }
        return i;
    }

    public static boolean b(byte[] bArr, int i, int i2, int i3) {
        int i4 = 0;
        for (int i5 = -4; i5 <= 4; i5++) {
            int i6 = (i5 * 188) + i3;
            if (i6 < i || i6 >= i2 || bArr[i6] != 71) {
                i4 = 0;
            } else {
                i4++;
                if (i4 == 5) {
                    return true;
                }
            }
        }
        return false;
    }

    public static long c(d0 d0Var, int i, int i2) {
        d0Var.P(i);
        if (d0Var.a() < 5) {
            return -9223372036854775807L;
        }
        int n = d0Var.n();
        if ((8388608 & n) != 0 || ((2096896 & n) >> 8) != i2) {
            return -9223372036854775807L;
        }
        boolean z = true;
        if (((n & 32) != 0) && d0Var.D() >= 7 && d0Var.a() >= 7) {
            if ((d0Var.D() & 16) != 16) {
                z = false;
            }
            if (z) {
                byte[] bArr = new byte[6];
                d0Var.j(bArr, 0, 6);
                return d(bArr);
            }
        }
        return -9223372036854775807L;
    }

    private static long d(byte[] bArr) {
        return ((bArr[0] & 255) << 25) | ((bArr[1] & 255) << 17) | ((bArr[2] & 255) << 9) | ((bArr[3] & 255) << 1) | ((255 & bArr[4]) >> 7);
    }
}
