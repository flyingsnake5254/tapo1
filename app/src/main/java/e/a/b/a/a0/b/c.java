package e.a.b.a.a0.b;

import e.a.b.a.e;
import e.a.b.c.b;
import e.a.b.c.g;
import java.math.BigInteger;
import org.bouncycastle.util.a;

/* loaded from: classes4.dex */
public class c extends e.b {
    public static final BigInteger g = a.i;
    protected int[] h;

    public c() {
        this.h = g.h();
    }

    public c(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(g) >= 0) {
            throw new IllegalArgumentException("x value invalid for SM2P256V1FieldElement");
        }
        this.h = b.d(bigInteger);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(int[] iArr) {
        this.h = iArr;
    }

    @Override // e.a.b.a.e
    public e a(e eVar) {
        int[] h = g.h();
        b.a(this.h, ((c) eVar).h, h);
        return new c(h);
    }

    @Override // e.a.b.a.e
    public e b() {
        int[] h = g.h();
        b.b(this.h, h);
        return new c(h);
    }

    @Override // e.a.b.a.e
    public e d(e eVar) {
        int[] h = g.h();
        b.d(b.a, ((c) eVar).h, h);
        b.e(h, this.h, h);
        return new c(h);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        return g.m(this.h, ((c) obj).h);
    }

    @Override // e.a.b.a.e
    public int f() {
        return g.bitLength();
    }

    @Override // e.a.b.a.e
    public e g() {
        int[] h = g.h();
        b.d(b.a, this.h, h);
        return new c(h);
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
        b.e(this.h, ((c) eVar).h, h);
        return new c(h);
    }

    @Override // e.a.b.a.e
    public e m() {
        int[] h = g.h();
        b.g(this.h, h);
        return new c(h);
    }

    @Override // e.a.b.a.e
    public e n() {
        int[] iArr = this.h;
        if (g.v(iArr) || g.t(iArr)) {
            return this;
        }
        int[] h = g.h();
        b.j(iArr, h);
        b.e(h, iArr, h);
        int[] h2 = g.h();
        b.k(h, 2, h2);
        b.e(h2, h, h2);
        int[] h3 = g.h();
        b.k(h2, 2, h3);
        b.e(h3, h, h3);
        b.k(h3, 6, h);
        b.e(h, h3, h);
        int[] h4 = g.h();
        b.k(h, 12, h4);
        b.e(h4, h, h4);
        b.k(h4, 6, h);
        b.e(h, h3, h);
        b.j(h, h3);
        b.e(h3, iArr, h3);
        b.k(h3, 31, h4);
        b.e(h4, h3, h);
        b.k(h4, 32, h4);
        b.e(h4, h, h4);
        b.k(h4, 62, h4);
        b.e(h4, h, h4);
        b.k(h4, 4, h4);
        b.e(h4, h2, h4);
        b.k(h4, 32, h4);
        b.e(h4, iArr, h4);
        b.k(h4, 62, h4);
        b.j(h4, h2);
        if (g.m(iArr, h2)) {
            return new c(h4);
        }
        return null;
    }

    @Override // e.a.b.a.e
    public e o() {
        int[] h = g.h();
        b.j(this.h, h);
        return new c(h);
    }

    @Override // e.a.b.a.e
    public e r(e eVar) {
        int[] h = g.h();
        b.m(this.h, ((c) eVar).h, h);
        return new c(h);
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
