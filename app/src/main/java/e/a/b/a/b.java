package e.a.b.a;

import e.a.b.b.a;
import e.a.b.b.f;
import java.math.BigInteger;

/* loaded from: classes4.dex */
public class b {
    public static h a(d dVar, h hVar) {
        if (dVar.m(hVar.i())) {
            return dVar.k(hVar.l(false));
        }
        throw new IllegalArgumentException("Point must be on the same curve");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static h b(h hVar) {
        if (hVar.x()) {
            return hVar;
        }
        throw new IllegalStateException("Invalid result");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static h c(h hVar, BigInteger bigInteger, h hVar2, BigInteger bigInteger2) {
        boolean z = false;
        boolean z2 = bigInteger.signum() < 0;
        if (bigInteger2.signum() < 0) {
            z = true;
        }
        BigInteger abs = bigInteger.abs();
        BigInteger abs2 = bigInteger2.abs();
        int max = Math.max(2, Math.min(16, w.j(abs.bitLength())));
        int max2 = Math.max(2, Math.min(16, w.j(abs2.bitLength())));
        v m = w.m(hVar, max, true);
        v m2 = w.m(hVar2, max2, true);
        return e(z2 ? m.b() : m.a(), z2 ? m.a() : m.b(), w.f(max, abs), z ? m2.b() : m2.a(), z ? m2.a() : m2.b(), w.f(max2, abs2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static h d(h hVar, BigInteger bigInteger, i iVar, BigInteger bigInteger2) {
        boolean z = false;
        boolean z2 = bigInteger.signum() < 0;
        if (bigInteger2.signum() < 0) {
            z = true;
        }
        BigInteger abs = bigInteger.abs();
        BigInteger abs2 = bigInteger2.abs();
        int max = Math.max(2, Math.min(16, w.j(Math.max(abs.bitLength(), abs2.bitLength()))));
        h l = w.l(hVar, max, true, iVar);
        v h = w.h(hVar);
        v h2 = w.h(l);
        return e(z2 ? h.b() : h.a(), z2 ? h.a() : h.b(), w.f(max, abs), z ? h2.b() : h2.a(), z ? h2.a() : h2.b(), w.f(max, abs2));
    }

    private static h e(h[] hVarArr, h[] hVarArr2, byte[] bArr, h[] hVarArr3, h[] hVarArr4, byte[] bArr2) {
        h hVar;
        int max = Math.max(bArr.length, bArr2.length);
        h u = hVarArr[0].i().u();
        int i = max - 1;
        h hVar2 = u;
        int i2 = 0;
        while (i >= 0) {
            byte b2 = i < bArr.length ? bArr[i] : (byte) 0;
            byte b3 = i < bArr2.length ? bArr2[i] : (byte) 0;
            if ((b2 | b3) == 0) {
                i2++;
            } else {
                if (b2 != 0) {
                    hVar = u.a((b2 < 0 ? hVarArr2 : hVarArr)[Math.abs((int) b2) >>> 1]);
                } else {
                    hVar = u;
                }
                if (b3 != 0) {
                    hVar = hVar.a((b3 < 0 ? hVarArr4 : hVarArr3)[Math.abs((int) b3) >>> 1]);
                }
                if (i2 > 0) {
                    hVar2 = hVar2.I(i2);
                    i2 = 0;
                }
                hVar2 = hVar2.K(hVar);
            }
            i--;
        }
        return i2 > 0 ? hVar2.I(i2) : hVar2;
    }

    public static h f(d dVar, h hVar) {
        if (dVar.m(hVar.i())) {
            return dVar.y(hVar);
        }
        throw new IllegalArgumentException("Point must be on the same curve");
    }

    public static boolean g(d dVar) {
        return h(dVar.s());
    }

    public static boolean h(a aVar) {
        return aVar.a() > 1 && aVar.b().equals(c.f15439c) && (aVar instanceof f);
    }

    public static boolean i(d dVar) {
        return j(dVar.s());
    }

    public static boolean j(a aVar) {
        return aVar.a() == 1;
    }

    public static void k(e[] eVarArr, int i, int i2, e eVar) {
        e[] eVarArr2 = new e[i2];
        int i3 = 0;
        eVarArr2[0] = eVarArr[i];
        while (true) {
            i3++;
            if (i3 >= i2) {
                break;
            }
            eVarArr2[i3] = eVarArr2[i3 - 1].j(eVarArr[i + i3]);
        }
        int i4 = i3 - 1;
        if (eVar != null) {
            eVarArr2[i4] = eVarArr2[i4].j(eVar);
        }
        e g = eVarArr2[i4].g();
        while (i4 > 0) {
            int i5 = i4 - 1;
            int i6 = i4 + i;
            e eVar2 = eVarArr[i6];
            eVarArr[i6] = eVarArr2[i5].j(g);
            g = g.j(eVar2);
            i4 = i5;
        }
        eVarArr[i] = g;
    }

    public static h l(h hVar, BigInteger bigInteger) {
        BigInteger abs = bigInteger.abs();
        h u = hVar.i().u();
        int bitLength = abs.bitLength();
        if (bitLength > 0) {
            if (abs.testBit(0)) {
                u = hVar;
            }
            for (int i = 1; i < bitLength; i++) {
                hVar = hVar.J();
                if (abs.testBit(i)) {
                    u = u.a(hVar);
                }
            }
        }
        return bigInteger.signum() < 0 ? u.z() : u;
    }
}
