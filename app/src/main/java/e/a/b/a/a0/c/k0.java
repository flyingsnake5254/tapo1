package e.a.b.a.a0.c;

import e.a.b.a.e;
import e.a.b.c.b;
import e.a.b.c.g;
import java.math.BigInteger;
import org.bouncycastle.util.a;

/* loaded from: classes4.dex */
public class k0 extends e.b {
    public static final BigInteger g = i0.i;
    protected int[] h;

    public k0() {
        this.h = g.h();
    }

    public k0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(g) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP256R1FieldElement");
        }
        this.h = j0.d(bigInteger);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public k0(int[] iArr) {
        this.h = iArr;
    }

    @Override // e.a.b.a.e
    public e a(e eVar) {
        int[] h = g.h();
        j0.a(this.h, ((k0) eVar).h, h);
        return new k0(h);
    }

    @Override // e.a.b.a.e
    public e b() {
        int[] h = g.h();
        j0.b(this.h, h);
        return new k0(h);
    }

    @Override // e.a.b.a.e
    public e d(e eVar) {
        int[] h = g.h();
        b.d(j0.a, ((k0) eVar).h, h);
        j0.e(h, this.h, h);
        return new k0(h);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k0)) {
            return false;
        }
        return g.m(this.h, ((k0) obj).h);
    }

    @Override // e.a.b.a.e
    public int f() {
        return g.bitLength();
    }

    @Override // e.a.b.a.e
    public e g() {
        int[] h = g.h();
        b.d(j0.a, this.h, h);
        return new k0(h);
    }

    @Override // e.a.b.a.e
    public boolean h() {
        return g.t(this.h);
    }

    public int hashCode() {
        return g.hashCode() ^ a.z(this.h, 0, 8);
    }

    @Override // e.a.b.a.e
    public boolean i() {
        return g.v(this.h);
    }

    @Override // e.a.b.a.e
    public e j(e eVar) {
        int[] h = g.h();
        j0.e(this.h, ((k0) eVar).h, h);
        return new k0(h);
    }

    @Override // e.a.b.a.e
    public e m() {
        int[] h = g.h();
        j0.g(this.h, h);
        return new k0(h);
    }

    @Override // e.a.b.a.e
    public e n() {
        int[] iArr = this.h;
        if (g.v(iArr) || g.t(iArr)) {
            return this;
        }
        int[] h = g.h();
        int[] h2 = g.h();
        j0.j(iArr, h);
        j0.e(h, iArr, h);
        j0.k(h, 2, h2);
        j0.e(h2, h, h2);
        j0.k(h2, 4, h);
        j0.e(h, h2, h);
        j0.k(h, 8, h2);
        j0.e(h2, h, h2);
        j0.k(h2, 16, h);
        j0.e(h, h2, h);
        j0.k(h, 32, h);
        j0.e(h, iArr, h);
        j0.k(h, 96, h);
        j0.e(h, iArr, h);
        j0.k(h, 94, h);
        j0.j(h, h2);
        if (g.m(iArr, h2)) {
            return new k0(h);
        }
        return null;
    }

    @Override // e.a.b.a.e
    public e o() {
        int[] h = g.h();
        j0.j(this.h, h);
        return new k0(h);
    }

    @Override // e.a.b.a.e
    public e r(e eVar) {
        int[] h = g.h();
        j0.m(this.h, ((k0) eVar).h, h);
        return new k0(h);
    }

    @Override // e.a.b.a.e
    public boolean s() {
        return g.q(this.h, 0) == 1;
    }

    @Override // e.a.b.a.e
    public BigInteger t() {
        return g.J(this.h);
    }
}
