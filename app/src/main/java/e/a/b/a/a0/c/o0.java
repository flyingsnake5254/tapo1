package e.a.b.a.a0.c;

import e.a.b.a.e;
import e.a.b.c.b;
import e.a.b.c.m;
import java.math.BigInteger;
import org.bouncycastle.util.a;

/* loaded from: classes4.dex */
public class o0 extends e.b {
    public static final BigInteger g = m0.i;
    protected int[] h;

    public o0() {
        this.h = m.j(12);
    }

    public o0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(g) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP384R1FieldElement");
        }
        this.h = n0.e(bigInteger);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public o0(int[] iArr) {
        this.h = iArr;
    }

    @Override // e.a.b.a.e
    public e a(e eVar) {
        int[] j = m.j(12);
        n0.a(this.h, ((o0) eVar).h, j);
        return new o0(j);
    }

    @Override // e.a.b.a.e
    public e b() {
        int[] j = m.j(12);
        n0.c(this.h, j);
        return new o0(j);
    }

    @Override // e.a.b.a.e
    public e d(e eVar) {
        int[] j = m.j(12);
        b.d(n0.a, ((o0) eVar).h, j);
        n0.f(j, this.h, j);
        return new o0(j);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o0)) {
            return false;
        }
        return m.n(12, this.h, ((o0) obj).h);
    }

    @Override // e.a.b.a.e
    public int f() {
        return g.bitLength();
    }

    @Override // e.a.b.a.e
    public e g() {
        int[] j = m.j(12);
        b.d(n0.a, this.h, j);
        return new o0(j);
    }

    @Override // e.a.b.a.e
    public boolean h() {
        return m.v(12, this.h);
    }

    public int hashCode() {
        return g.hashCode() ^ a.z(this.h, 0, 12);
    }

    @Override // e.a.b.a.e
    public boolean i() {
        return m.w(12, this.h);
    }

    @Override // e.a.b.a.e
    public e j(e eVar) {
        int[] j = m.j(12);
        n0.f(this.h, ((o0) eVar).h, j);
        return new o0(j);
    }

    @Override // e.a.b.a.e
    public e m() {
        int[] j = m.j(12);
        n0.g(this.h, j);
        return new o0(j);
    }

    @Override // e.a.b.a.e
    public e n() {
        int[] iArr = this.h;
        if (m.w(12, iArr) || m.v(12, iArr)) {
            return this;
        }
        int[] j = m.j(12);
        int[] j2 = m.j(12);
        int[] j3 = m.j(12);
        int[] j4 = m.j(12);
        n0.j(iArr, j);
        n0.f(j, iArr, j);
        n0.k(j, 2, j2);
        n0.f(j2, j, j2);
        n0.j(j2, j2);
        n0.f(j2, iArr, j2);
        n0.k(j2, 5, j3);
        n0.f(j3, j2, j3);
        n0.k(j3, 5, j4);
        n0.f(j4, j2, j4);
        n0.k(j4, 15, j2);
        n0.f(j2, j4, j2);
        n0.k(j2, 2, j3);
        n0.f(j, j3, j);
        n0.k(j3, 28, j3);
        n0.f(j2, j3, j2);
        n0.k(j2, 60, j3);
        n0.f(j3, j2, j3);
        n0.k(j3, 120, j2);
        n0.f(j2, j3, j2);
        n0.k(j2, 15, j2);
        n0.f(j2, j4, j2);
        n0.k(j2, 33, j2);
        n0.f(j2, j, j2);
        n0.k(j2, 64, j2);
        n0.f(j2, iArr, j2);
        n0.k(j2, 30, j);
        n0.j(j, j2);
        if (m.n(12, iArr, j2)) {
            return new o0(j);
        }
        return null;
    }

    @Override // e.a.b.a.e
    public e o() {
        int[] j = m.j(12);
        n0.j(this.h, j);
        return new o0(j);
    }

    @Override // e.a.b.a.e
    public e r(e eVar) {
        int[] j = m.j(12);
        n0.m(this.h, ((o0) eVar).h, j);
        return new o0(j);
    }

    @Override // e.a.b.a.e
    public boolean s() {
        return m.p(this.h, 0) == 1;
    }

    @Override // e.a.b.a.e
    public BigInteger t() {
        return m.P(12, this.h);
    }
}
