package e.a.b.a;

import java.math.BigInteger;

/* loaded from: classes4.dex */
public class l {

    /* loaded from: classes4.dex */
    static class a implements o {
        final /* synthetic */ d a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ h f15466b;

        a(d dVar, h hVar) {
            this.a = dVar;
            this.f15466b = hVar;
        }

        private boolean b(k kVar, int i) {
            return kVar != null && c(kVar.a(), i);
        }

        private boolean c(f fVar, int i) {
            return fVar != null && fVar.a() >= i;
        }

        @Override // e.a.b.a.o
        public p a(p pVar) {
            k kVar = pVar instanceof k ? (k) pVar : null;
            int a = l.a(this.a);
            int i = a > 257 ? 6 : 5;
            int i2 = 1 << i;
            if (b(kVar, i2)) {
                return kVar;
            }
            int i3 = ((a + i) - 1) / i;
            h[] hVarArr = new h[i + 1];
            hVarArr[0] = this.f15466b;
            for (int i4 = 1; i4 < i; i4++) {
                hVarArr[i4] = hVarArr[i4 - 1].I(i3);
            }
            hVarArr[i] = hVarArr[0].G(hVarArr[1]);
            this.a.z(hVarArr);
            h[] hVarArr2 = new h[i2];
            hVarArr2[0] = hVarArr[0];
            for (int i5 = i - 1; i5 >= 0; i5--) {
                h hVar = hVarArr[i5];
                int i6 = 1 << i5;
                for (int i7 = i6; i7 < i2; i7 += i6 << 1) {
                    hVarArr2[i7] = hVarArr2[i7 - i6].a(hVar);
                }
            }
            this.a.z(hVarArr2);
            k kVar2 = new k();
            kVar2.d(this.a.e(hVarArr2, 0, i2));
            kVar2.e(hVarArr[i]);
            kVar2.f(i);
            return kVar2;
        }
    }

    public static int a(d dVar) {
        BigInteger w = dVar.w();
        return w == null ? dVar.t() + 1 : w.bitLength();
    }

    public static k b(h hVar) {
        d i = hVar.i();
        return (k) i.B(hVar, "bc_fixed_point", new a(i, hVar));
    }
}
