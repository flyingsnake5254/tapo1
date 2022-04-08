package e.a.b.a;

import java.math.BigInteger;

/* loaded from: classes4.dex */
public class u extends a {
    @Override // e.a.b.a.a
    protected h c(h hVar, BigInteger bigInteger) {
        h hVar2;
        int max = Math.max(2, Math.min(16, d(bigInteger.bitLength())));
        v m = w.m(hVar, max, true);
        h[] a = m.a();
        h[] b2 = m.b();
        int[] d2 = w.d(max, bigInteger);
        h u = hVar.i().u();
        int length = d2.length;
        if (length > 1) {
            length--;
            int i = d2[length];
            int i2 = i >> 16;
            int i3 = i & 65535;
            int abs = Math.abs(i2);
            h[] hVarArr = i2 < 0 ? b2 : a;
            if ((abs << 2) < (1 << max)) {
                byte b3 = n.y[abs];
                int i4 = max - b3;
                hVar2 = hVarArr[((1 << (max - 1)) - 1) >>> 1].a(hVarArr[(((abs ^ (1 << (b3 - 1))) << i4) + 1) >>> 1]);
                i3 -= i4;
            } else {
                hVar2 = hVarArr[abs >>> 1];
            }
            u = hVar2.I(i3);
        }
        while (length > 0) {
            length--;
            int i5 = d2[length];
            int i6 = i5 >> 16;
            u = u.K((i6 < 0 ? b2 : a)[Math.abs(i6) >>> 1]).I(i5 & 65535);
        }
        return u;
    }

    protected int d(int i) {
        return w.j(i);
    }
}
