package com.google.android.exoplayer2.o2;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.o0;
import java.io.IOException;

/* compiled from: FlacFrameReader.java */
/* loaded from: classes.dex */
public final class p {

    /* compiled from: FlacFrameReader.java */
    /* loaded from: classes.dex */
    public static final class a {
        public long a;
    }

    private static boolean a(d0 d0Var, s sVar, int i) {
        int j = j(d0Var, i);
        return j != -1 && j <= sVar.f3064b;
    }

    private static boolean b(d0 d0Var, int i) {
        return d0Var.D() == o0.t(d0Var.d(), i, d0Var.e() - 1, 0);
    }

    private static boolean c(d0 d0Var, s sVar, boolean z, a aVar) {
        try {
            long K = d0Var.K();
            if (!z) {
                K *= sVar.f3064b;
            }
            aVar.a = K;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean d(d0 d0Var, s sVar, int i, a aVar) {
        int e2 = d0Var.e();
        long F = d0Var.F();
        long j = F >>> 16;
        if (j != i) {
            return false;
        }
        return g((int) (15 & (F >> 4)), sVar) && f((int) ((F >> 1) & 7), sVar) && !(((F & 1) > 1L ? 1 : ((F & 1) == 1L ? 0 : -1)) == 0) && c(d0Var, sVar, ((j & 1) > 1L ? 1 : ((j & 1) == 1L ? 0 : -1)) == 0, aVar) && a(d0Var, sVar, (int) ((F >> 12) & 15)) && e(d0Var, sVar, (int) ((F >> 8) & 15)) && b(d0Var, e2);
    }

    private static boolean e(d0 d0Var, s sVar, int i) {
        int i2 = sVar.f3067e;
        if (i == 0) {
            return true;
        }
        if (i <= 11) {
            return i == sVar.f3068f;
        }
        if (i == 12) {
            return d0Var.D() * 1000 == i2;
        }
        if (i > 14) {
            return false;
        }
        int J = d0Var.J();
        if (i == 14) {
            J *= 10;
        }
        return J == i2;
    }

    private static boolean f(int i, s sVar) {
        return i == 0 || i == sVar.i;
    }

    private static boolean g(int i, s sVar) {
        return i <= 7 ? i == sVar.g - 1 : i <= 10 && sVar.g == 2;
    }

    public static boolean h(k kVar, s sVar, int i, a aVar) throws IOException {
        long g = kVar.g();
        byte[] bArr = new byte[2];
        kVar.n(bArr, 0, 2);
        if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i) {
            kVar.e();
            kVar.h((int) (g - kVar.getPosition()));
            return false;
        }
        d0 d0Var = new d0(16);
        System.arraycopy(bArr, 0, d0Var.d(), 0, 2);
        d0Var.O(m.c(kVar, d0Var.d(), 2, 14));
        kVar.e();
        kVar.h((int) (g - kVar.getPosition()));
        return d(d0Var, sVar, i, aVar);
    }

    public static long i(k kVar, s sVar) throws IOException {
        kVar.e();
        boolean z = true;
        kVar.h(1);
        byte[] bArr = new byte[1];
        kVar.n(bArr, 0, 1);
        if ((bArr[0] & 1) != 1) {
            z = false;
        }
        kVar.h(2);
        int i = z ? 7 : 6;
        d0 d0Var = new d0(i);
        d0Var.O(m.c(kVar, d0Var.d(), 0, i));
        kVar.e();
        a aVar = new a();
        if (c(d0Var, sVar, z, aVar)) {
            return aVar.a;
        }
        throw ParserException.createForMalformedContainer(null, null);
    }

    public static int j(d0 d0Var, int i) {
        switch (i) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i - 2);
            case 6:
                return d0Var.D() + 1;
            case 7:
                return d0Var.J() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i - 8);
            default:
                return -1;
        }
    }
}
