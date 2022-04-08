package e.a.b.a;

import e.a.b.c.m;
import java.math.BigInteger;

/* loaded from: classes4.dex */
public class j extends a {
    @Override // e.a.b.a.a
    protected h c(h hVar, BigInteger bigInteger) {
        int a;
        d i = hVar.i();
        if (bigInteger.bitLength() <= l.a(i)) {
            k b2 = l.b(hVar);
            f a2 = b2.a();
            int c2 = b2.c();
            int i2 = ((a + c2) - 1) / c2;
            h u = i.u();
            int i3 = c2 * i2;
            int[] o = m.o(i3, bigInteger);
            int i4 = i3 - 1;
            for (int i5 = 0; i5 < i2; i5++) {
                int i6 = 0;
                for (int i7 = i4 - i5; i7 >= 0; i7 -= i2) {
                    i6 = (i6 << 1) | m.p(o, i7);
                }
                u = u.K(a2.b(i6));
            }
            return u.a(b2.b());
        }
        throw new IllegalStateException("fixed-point comb doesn't support scalars larger than the curve order");
    }
}
