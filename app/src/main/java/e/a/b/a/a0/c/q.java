package e.a.b.a.a0.c;

import e.a.b.a.e;
import e.a.b.c.b;
import java.math.BigInteger;
import org.bouncycastle.util.a;

/* loaded from: classes4.dex */
public class q extends e.b {
    public static final BigInteger g = o.i;
    protected int[] h;

    public q() {
        this.h = e.a.b.c.e.g();
    }

    public q(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(g) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP192K1FieldElement");
        }
        this.h = p.c(bigInteger);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public q(int[] iArr) {
        this.h = iArr;
    }

    @Override // e.a.b.a.e
    public e a(e eVar) {
        int[] g2 = e.a.b.c.e.g();
        p.a(this.h, ((q) eVar).h, g2);
        return new q(g2);
    }

    @Override // e.a.b.a.e
    public e b() {
        int[] g2 = e.a.b.c.e.g();
        p.b(this.h, g2);
        return new q(g2);
    }

    @Override // e.a.b.a.e
    public e d(e eVar) {
        int[] g2 = e.a.b.c.e.g();
        b.d(p.a, ((q) eVar).h, g2);
        p.d(g2, this.h, g2);
        return new q(g2);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        return e.a.b.c.e.l(this.h, ((q) obj).h);
    }

    @Override // e.a.b.a.e
    public int f() {
        return g.bitLength();
    }

    @Override // e.a.b.a.e
    public e g() {
        int[] g2 = e.a.b.c.e.g();
        b.d(p.a, this.h, g2);
        return new q(g2);
    }

    @Override // e.a.b.a.e
    public boolean h() {
        return e.a.b.c.e.s(this.h);
    }

    public int hashCode() {
        return g.hashCode() ^ a.z(this.h, 0, 6);
    }

    @Override // e.a.b.a.e
    public boolean i() {
        return e.a.b.c.e.u(this.h);
    }

    @Override // e.a.b.a.e
    public e j(e eVar) {
        int[] g2 = e.a.b.c.e.g();
        p.d(this.h, ((q) eVar).h, g2);
        return new q(g2);
    }

    @Override // e.a.b.a.e
    public e m() {
        int[] g2 = e.a.b.c.e.g();
        p.f(this.h, g2);
        return new q(g2);
    }

    @Override // e.a.b.a.e
    public e n() {
        int[] iArr = this.h;
        if (e.a.b.c.e.u(iArr) || e.a.b.c.e.s(iArr)) {
            return this;
        }
        int[] g2 = e.a.b.c.e.g();
        p.i(iArr, g2);
        p.d(g2, iArr, g2);
        int[] g3 = e.a.b.c.e.g();
        p.i(g2, g3);
        p.d(g3, iArr, g3);
        int[] g4 = e.a.b.c.e.g();
        p.j(g3, 3, g4);
        p.d(g4, g3, g4);
        p.j(g4, 2, g4);
        p.d(g4, g2, g4);
        p.j(g4, 8, g2);
        p.d(g2, g4, g2);
        p.j(g2, 3, g4);
        p.d(g4, g3, g4);
        int[] g5 = e.a.b.c.e.g();
        p.j(g4, 16, g5);
        p.d(g5, g2, g5);
        p.j(g5, 35, g2);
        p.d(g2, g5, g2);
        p.j(g2, 70, g5);
        p.d(g5, g2, g5);
        p.j(g5, 19, g2);
        p.d(g2, g4, g2);
        p.j(g2, 20, g2);
        p.d(g2, g4, g2);
        p.j(g2, 4, g2);
        p.d(g2, g3, g2);
        p.j(g2, 6, g2);
        p.d(g2, g3, g2);
        p.i(g2, g2);
        p.i(g2, g3);
        if (e.a.b.c.e.l(iArr, g3)) {
            return new q(g2);
        }
        return null;
    }

    @Override // e.a.b.a.e
    public e o() {
        int[] g2 = e.a.b.c.e.g();
        p.i(this.h, g2);
        return new q(g2);
    }

    @Override // e.a.b.a.e
    public e r(e eVar) {
        int[] g2 = e.a.b.c.e.g();
        p.k(this.h, ((q) eVar).h, g2);
        return new q(g2);
    }

    @Override // e.a.b.a.e
    public boolean s() {
        return e.a.b.c.e.p(this.h, 0) == 1;
    }

    @Override // e.a.b.a.e
    public BigInteger t() {
        return e.a.b.c.e.H(this.h);
    }
}
