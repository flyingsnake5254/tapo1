package e.a.b.a;

import e.a.b.c.m;
import java.math.BigInteger;
import java.util.Random;

/* loaded from: classes4.dex */
public abstract class e implements c {

    /* loaded from: classes4.dex */
    public static abstract class a extends e {
        public int u() {
            int f2 = f();
            e eVar = this;
            e eVar2 = eVar;
            for (int i = 1; i < f2; i++) {
                eVar2 = eVar2.o();
                eVar = eVar.a(eVar2);
            }
            if (eVar.i()) {
                return 0;
            }
            if (eVar.h()) {
                return 1;
            }
            throw new IllegalStateException("Internal error in trace calculation");
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class b extends e {
    }

    /* loaded from: classes4.dex */
    public static class c extends a {
        private int g;
        private int h;
        private int[] i;
        n j;

        public c(int i, int i2, int i3, int i4, BigInteger bigInteger) {
            if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > i) {
                throw new IllegalArgumentException("x value invalid in F2m field element");
            }
            if (i3 == 0 && i4 == 0) {
                this.g = 2;
                this.i = new int[]{i2};
            } else if (i3 >= i4) {
                throw new IllegalArgumentException("k2 must be smaller than k3");
            } else if (i3 > 0) {
                this.g = 3;
                this.i = new int[]{i2, i3, i4};
            } else {
                throw new IllegalArgumentException("k2 must be larger than 0");
            }
            this.h = i;
            this.j = new n(bigInteger);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i, int[] iArr, n nVar) {
            this.h = i;
            this.g = iArr.length == 1 ? 2 : 3;
            this.i = iArr;
            this.j = nVar;
        }

        public static void v(e eVar, e eVar2) {
            if (!(eVar instanceof c) || !(eVar2 instanceof c)) {
                throw new IllegalArgumentException("Field elements are not both instances of ECFieldElement.F2m");
            }
            c cVar = (c) eVar;
            c cVar2 = (c) eVar2;
            if (cVar.g != cVar2.g) {
                throw new IllegalArgumentException("One of the F2m field elements has incorrect representation");
            } else if (cVar.h != cVar2.h || !org.bouncycastle.util.a.e(cVar.i, cVar2.i)) {
                throw new IllegalArgumentException("Field elements are not elements of the same field F2m");
            }
        }

        @Override // e.a.b.a.e
        public e a(e eVar) {
            n nVar = (n) this.j.clone();
            nVar.f(((c) eVar).j, 0);
            return new c(this.h, this.i, nVar);
        }

        @Override // e.a.b.a.e
        public e b() {
            return new c(this.h, this.i, this.j.d());
        }

        @Override // e.a.b.a.e
        public int c() {
            return this.j.l();
        }

        @Override // e.a.b.a.e
        public e d(e eVar) {
            return j(eVar.g());
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.h == cVar.h && this.g == cVar.g && org.bouncycastle.util.a.e(this.i, cVar.i) && this.j.equals(cVar.j);
        }

        @Override // e.a.b.a.e
        public int f() {
            return this.h;
        }

        @Override // e.a.b.a.e
        public e g() {
            int i = this.h;
            int[] iArr = this.i;
            return new c(i, iArr, this.j.v(i, iArr));
        }

        @Override // e.a.b.a.e
        public boolean h() {
            return this.j.t();
        }

        public int hashCode() {
            return (this.j.hashCode() ^ this.h) ^ org.bouncycastle.util.a.y(this.i);
        }

        @Override // e.a.b.a.e
        public boolean i() {
            return this.j.u();
        }

        @Override // e.a.b.a.e
        public e j(e eVar) {
            int i = this.h;
            int[] iArr = this.i;
            return new c(i, iArr, this.j.w(((c) eVar).j, i, iArr));
        }

        @Override // e.a.b.a.e
        public e k(e eVar, e eVar2, e eVar3) {
            return l(eVar, eVar2, eVar3);
        }

        @Override // e.a.b.a.e
        public e l(e eVar, e eVar2, e eVar3) {
            n nVar = this.j;
            n nVar2 = ((c) eVar).j;
            n nVar3 = ((c) eVar2).j;
            n nVar4 = ((c) eVar3).j;
            n z = nVar.z(nVar2, this.h, this.i);
            n z2 = nVar3.z(nVar4, this.h, this.i);
            if (z == nVar || z == nVar2) {
                z = (n) z.clone();
            }
            z.f(z2, 0);
            z.B(this.h, this.i);
            return new c(this.h, this.i, z);
        }

        @Override // e.a.b.a.e
        public e m() {
            return this;
        }

        @Override // e.a.b.a.e
        public e n() {
            return (this.j.u() || this.j.t()) ? this : q(this.h - 1);
        }

        @Override // e.a.b.a.e
        public e o() {
            int i = this.h;
            int[] iArr = this.i;
            return new c(i, iArr, this.j.x(i, iArr));
        }

        @Override // e.a.b.a.e
        public e p(e eVar, e eVar2) {
            n nVar = this.j;
            n nVar2 = ((c) eVar).j;
            n nVar3 = ((c) eVar2).j;
            n L = nVar.L(this.h, this.i);
            n z = nVar2.z(nVar3, this.h, this.i);
            if (L == nVar) {
                L = (n) L.clone();
            }
            L.f(z, 0);
            L.B(this.h, this.i);
            return new c(this.h, this.i, L);
        }

        @Override // e.a.b.a.e
        public e q(int i) {
            if (i < 1) {
                return this;
            }
            int i2 = this.h;
            int[] iArr = this.i;
            return new c(i2, iArr, this.j.y(i, i2, iArr));
        }

        @Override // e.a.b.a.e
        public e r(e eVar) {
            return a(eVar);
        }

        @Override // e.a.b.a.e
        public boolean s() {
            return this.j.O();
        }

        @Override // e.a.b.a.e
        public BigInteger t() {
            return this.j.P();
        }
    }

    /* loaded from: classes4.dex */
    public static class d extends b {
        BigInteger g;
        BigInteger h;
        BigInteger i;

        /* JADX INFO: Access modifiers changed from: package-private */
        public d(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            if (bigInteger3 == null || bigInteger3.signum() < 0 || bigInteger3.compareTo(bigInteger) >= 0) {
                throw new IllegalArgumentException("x value invalid in Fp field element");
            }
            this.g = bigInteger;
            this.h = bigInteger2;
            this.i = bigInteger3;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static BigInteger u(BigInteger bigInteger) {
            int bitLength = bigInteger.bitLength();
            if (bitLength < 96 || bigInteger.shiftRight(bitLength - 64).longValue() != -1) {
                return null;
            }
            return c.f15438b.shiftLeft(bitLength).subtract(bigInteger);
        }

        private e v(e eVar) {
            if (eVar.o().equals(this)) {
                return eVar;
            }
            return null;
        }

        private BigInteger[] w(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            int bitLength = bigInteger3.bitLength();
            int lowestSetBit = bigInteger3.getLowestSetBit();
            BigInteger bigInteger4 = c.f15438b;
            BigInteger bigInteger5 = c.f15439c;
            BigInteger bigInteger6 = bigInteger;
            BigInteger bigInteger7 = bigInteger4;
            BigInteger bigInteger8 = bigInteger7;
            for (int i = bitLength - 1; i >= lowestSetBit + 1; i--) {
                bigInteger4 = B(bigInteger4, bigInteger8);
                if (bigInteger3.testBit(i)) {
                    bigInteger8 = B(bigInteger4, bigInteger2);
                    bigInteger7 = B(bigInteger7, bigInteger6);
                    bigInteger5 = C(bigInteger6.multiply(bigInteger5).subtract(bigInteger.multiply(bigInteger4)));
                    bigInteger6 = C(bigInteger6.multiply(bigInteger6).subtract(bigInteger8.shiftLeft(1)));
                } else {
                    bigInteger7 = C(bigInteger7.multiply(bigInteger5).subtract(bigInteger4));
                    bigInteger6 = C(bigInteger6.multiply(bigInteger5).subtract(bigInteger.multiply(bigInteger4)));
                    bigInteger5 = C(bigInteger5.multiply(bigInteger5).subtract(bigInteger4.shiftLeft(1)));
                    bigInteger8 = bigInteger4;
                }
            }
            BigInteger B = B(bigInteger4, bigInteger8);
            BigInteger B2 = B(B, bigInteger2);
            BigInteger C = C(bigInteger7.multiply(bigInteger5).subtract(B));
            BigInteger C2 = C(bigInteger6.multiply(bigInteger5).subtract(bigInteger.multiply(B)));
            BigInteger B3 = B(B, B2);
            for (int i2 = 1; i2 <= lowestSetBit; i2++) {
                C = B(C, C2);
                C2 = C(C2.multiply(C2).subtract(B3.shiftLeft(1)));
                B3 = B(B3, B3);
            }
            return new BigInteger[]{C, C2};
        }

        protected BigInteger A(BigInteger bigInteger) {
            int f2 = f();
            int i = (f2 + 31) >> 5;
            int[] o = m.o(f2, this.g);
            int[] o2 = m.o(f2, bigInteger);
            int[] j = m.j(i);
            e.a.b.c.b.d(o, o2, j);
            return m.P(i, j);
        }

        protected BigInteger B(BigInteger bigInteger, BigInteger bigInteger2) {
            return C(bigInteger.multiply(bigInteger2));
        }

        protected BigInteger C(BigInteger bigInteger) {
            if (this.h == null) {
                return bigInteger.mod(this.g);
            }
            boolean z = bigInteger.signum() < 0;
            if (z) {
                bigInteger = bigInteger.abs();
            }
            int bitLength = this.g.bitLength();
            boolean equals = this.h.equals(c.f15438b);
            while (bigInteger.bitLength() > bitLength + 1) {
                BigInteger shiftRight = bigInteger.shiftRight(bitLength);
                BigInteger subtract = bigInteger.subtract(shiftRight.shiftLeft(bitLength));
                if (!equals) {
                    shiftRight = shiftRight.multiply(this.h);
                }
                bigInteger = shiftRight.add(subtract);
            }
            while (bigInteger.compareTo(this.g) >= 0) {
                bigInteger = bigInteger.subtract(this.g);
            }
            return (!z || bigInteger.signum() == 0) ? bigInteger : this.g.subtract(bigInteger);
        }

        protected BigInteger D(BigInteger bigInteger, BigInteger bigInteger2) {
            BigInteger subtract = bigInteger.subtract(bigInteger2);
            return subtract.signum() < 0 ? subtract.add(this.g) : subtract;
        }

        @Override // e.a.b.a.e
        public e a(e eVar) {
            return new d(this.g, this.h, x(this.i, eVar.t()));
        }

        @Override // e.a.b.a.e
        public e b() {
            BigInteger add = this.i.add(c.f15438b);
            if (add.compareTo(this.g) == 0) {
                add = c.a;
            }
            return new d(this.g, this.h, add);
        }

        @Override // e.a.b.a.e
        public e d(e eVar) {
            return new d(this.g, this.h, B(this.i, A(eVar.t())));
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.g.equals(dVar.g) && this.i.equals(dVar.i);
        }

        @Override // e.a.b.a.e
        public int f() {
            return this.g.bitLength();
        }

        @Override // e.a.b.a.e
        public e g() {
            return new d(this.g, this.h, A(this.i));
        }

        public int hashCode() {
            return this.g.hashCode() ^ this.i.hashCode();
        }

        @Override // e.a.b.a.e
        public e j(e eVar) {
            return new d(this.g, this.h, B(this.i, eVar.t()));
        }

        @Override // e.a.b.a.e
        public e k(e eVar, e eVar2, e eVar3) {
            BigInteger bigInteger = this.i;
            BigInteger t = eVar.t();
            BigInteger t2 = eVar2.t();
            BigInteger t3 = eVar3.t();
            return new d(this.g, this.h, C(bigInteger.multiply(t).subtract(t2.multiply(t3))));
        }

        @Override // e.a.b.a.e
        public e l(e eVar, e eVar2, e eVar3) {
            BigInteger bigInteger = this.i;
            BigInteger t = eVar.t();
            BigInteger t2 = eVar2.t();
            BigInteger t3 = eVar3.t();
            return new d(this.g, this.h, C(bigInteger.multiply(t).add(t2.multiply(t3))));
        }

        @Override // e.a.b.a.e
        public e m() {
            if (this.i.signum() == 0) {
                return this;
            }
            BigInteger bigInteger = this.g;
            return new d(bigInteger, this.h, bigInteger.subtract(this.i));
        }

        @Override // e.a.b.a.e
        public e n() {
            if (i() || h()) {
                return this;
            }
            if (!this.g.testBit(0)) {
                throw new RuntimeException("not done yet");
            } else if (this.g.testBit(1)) {
                BigInteger add = this.g.shiftRight(2).add(c.f15438b);
                BigInteger bigInteger = this.g;
                return v(new d(bigInteger, this.h, this.i.modPow(add, bigInteger)));
            } else if (this.g.testBit(2)) {
                BigInteger modPow = this.i.modPow(this.g.shiftRight(3), this.g);
                BigInteger B = B(modPow, this.i);
                if (B(B, modPow).equals(c.f15438b)) {
                    return v(new d(this.g, this.h, B));
                }
                return v(new d(this.g, this.h, B(B, c.f15439c.modPow(this.g.shiftRight(2), this.g))));
            } else {
                BigInteger shiftRight = this.g.shiftRight(1);
                BigInteger modPow2 = this.i.modPow(shiftRight, this.g);
                BigInteger bigInteger2 = c.f15438b;
                if (!modPow2.equals(bigInteger2)) {
                    return null;
                }
                BigInteger bigInteger3 = this.i;
                BigInteger y = y(y(bigInteger3));
                BigInteger add2 = shiftRight.add(bigInteger2);
                BigInteger subtract = this.g.subtract(bigInteger2);
                Random random = new Random();
                while (true) {
                    BigInteger bigInteger4 = new BigInteger(this.g.bitLength(), random);
                    if (bigInteger4.compareTo(this.g) < 0 && C(bigInteger4.multiply(bigInteger4).subtract(y)).modPow(shiftRight, this.g).equals(subtract)) {
                        BigInteger[] w = w(bigInteger4, bigInteger3, add2);
                        BigInteger bigInteger5 = w[0];
                        BigInteger bigInteger6 = w[1];
                        if (B(bigInteger6, bigInteger6).equals(y)) {
                            return new d(this.g, this.h, z(bigInteger6));
                        }
                        if (!bigInteger5.equals(c.f15438b) && !bigInteger5.equals(subtract)) {
                            return null;
                        }
                    }
                }
            }
        }

        @Override // e.a.b.a.e
        public e o() {
            BigInteger bigInteger = this.g;
            BigInteger bigInteger2 = this.h;
            BigInteger bigInteger3 = this.i;
            return new d(bigInteger, bigInteger2, B(bigInteger3, bigInteger3));
        }

        @Override // e.a.b.a.e
        public e p(e eVar, e eVar2) {
            BigInteger bigInteger = this.i;
            BigInteger t = eVar.t();
            BigInteger t2 = eVar2.t();
            return new d(this.g, this.h, C(bigInteger.multiply(bigInteger).add(t.multiply(t2))));
        }

        @Override // e.a.b.a.e
        public e r(e eVar) {
            return new d(this.g, this.h, D(this.i, eVar.t()));
        }

        @Override // e.a.b.a.e
        public BigInteger t() {
            return this.i;
        }

        protected BigInteger x(BigInteger bigInteger, BigInteger bigInteger2) {
            BigInteger add = bigInteger.add(bigInteger2);
            return add.compareTo(this.g) >= 0 ? add.subtract(this.g) : add;
        }

        protected BigInteger y(BigInteger bigInteger) {
            BigInteger shiftLeft = bigInteger.shiftLeft(1);
            return shiftLeft.compareTo(this.g) >= 0 ? shiftLeft.subtract(this.g) : shiftLeft;
        }

        protected BigInteger z(BigInteger bigInteger) {
            if (bigInteger.testBit(0)) {
                bigInteger = this.g.subtract(bigInteger);
            }
            return bigInteger.shiftRight(1);
        }
    }

    public abstract e a(e eVar);

    public abstract e b();

    public int c() {
        return t().bitLength();
    }

    public abstract e d(e eVar);

    public byte[] e() {
        return org.bouncycastle.util.b.a((f() + 7) / 8, t());
    }

    public abstract int f();

    public abstract e g();

    public boolean h() {
        return c() == 1;
    }

    public boolean i() {
        return t().signum() == 0;
    }

    public abstract e j(e eVar);

    public e k(e eVar, e eVar2, e eVar3) {
        return j(eVar).r(eVar2.j(eVar3));
    }

    public e l(e eVar, e eVar2, e eVar3) {
        return j(eVar).a(eVar2.j(eVar3));
    }

    public abstract e m();

    public abstract e n();

    public abstract e o();

    public e p(e eVar, e eVar2) {
        return o().a(eVar.j(eVar2));
    }

    public e q(int i) {
        e eVar = this;
        for (int i2 = 0; i2 < i; i2++) {
            eVar = eVar.o();
        }
        return eVar;
    }

    public abstract e r(e eVar);

    public boolean s() {
        return t().testBit(0);
    }

    public abstract BigInteger t();

    public String toString() {
        return t().toString(16);
    }
}
