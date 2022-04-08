package e.a.b.a.a0.a;

import e.a.b.a.e;
import e.a.b.c.b;
import e.a.b.c.g;
import java.math.BigInteger;
import org.bouncycastle.util.a;

/* loaded from: classes4.dex */
public class c extends e.b {
    public static final BigInteger g = a.i;
    private static final int[] h = {1242472624, -991028441, -1389370248, 792926214, 1039914919, 726466713, 1338105611, 730014848};
    protected int[] i;

    public c() {
        this.i = g.h();
    }

    public c(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(g) >= 0) {
            throw new IllegalArgumentException("x value invalid for Curve25519FieldElement");
        }
        this.i = b.d(bigInteger);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(int[] iArr) {
        this.i = iArr;
    }

    @Override // e.a.b.a.e
    public e a(e eVar) {
        int[] h2 = g.h();
        b.a(this.i, ((c) eVar).i, h2);
        return new c(h2);
    }

    @Override // e.a.b.a.e
    public e b() {
        int[] h2 = g.h();
        b.b(this.i, h2);
        return new c(h2);
    }

    @Override // e.a.b.a.e
    public e d(e eVar) {
        int[] h2 = g.h();
        b.d(b.a, ((c) eVar).i, h2);
        b.e(h2, this.i, h2);
        return new c(h2);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        return g.m(this.i, ((c) obj).i);
    }

    @Override // e.a.b.a.e
    public int f() {
        return g.bitLength();
    }

    @Override // e.a.b.a.e
    public e g() {
        int[] h2 = g.h();
        b.d(b.a, this.i, h2);
        return new c(h2);
    }

    @Override // e.a.b.a.e
    public boolean h() {
        return g.t(this.i);
    }

    public int hashCode() {
        return g.hashCode() ^ a.z(this.i, 0, 8);
    }

    @Override // e.a.b.a.e
    public boolean i() {
        return g.v(this.i);
    }

    @Override // e.a.b.a.e
    public e j(e eVar) {
        int[] h2 = g.h();
        b.e(this.i, ((c) eVar).i, h2);
        return new c(h2);
    }

    @Override // e.a.b.a.e
    public e m() {
        int[] h2 = g.h();
        b.g(this.i, h2);
        return new c(h2);
    }

    @Override // e.a.b.a.e
    public e n() {
        int[] iArr = this.i;
        if (g.v(iArr) || g.t(iArr)) {
            return this;
        }
        int[] h2 = g.h();
        b.j(iArr, h2);
        b.e(h2, iArr, h2);
        b.j(h2, h2);
        b.e(h2, iArr, h2);
        int[] h3 = g.h();
        b.j(h2, h3);
        b.e(h3, iArr, h3);
        int[] h4 = g.h();
        b.k(h3, 3, h4);
        b.e(h4, h2, h4);
        b.k(h4, 4, h2);
        b.e(h2, h3, h2);
        b.k(h2, 4, h4);
        b.e(h4, h3, h4);
        b.k(h4, 15, h3);
        b.e(h3, h4, h3);
        b.k(h3, 30, h4);
        b.e(h4, h3, h4);
        b.k(h4, 60, h3);
        b.e(h3, h4, h3);
        b.k(h3, 11, h4);
        b.e(h4, h2, h4);
        b.k(h4, 120, h2);
        b.e(h2, h3, h2);
        b.j(h2, h2);
        b.j(h2, h3);
        if (g.m(iArr, h3)) {
            return new c(h2);
        }
        b.e(h2, h, h2);
        b.j(h2, h3);
        if (g.m(iArr, h3)) {
            return new c(h2);
        }
        return null;
    }

    @Override // e.a.b.a.e
    public e o() {
        int[] h2 = g.h();
        b.j(this.i, h2);
        return new c(h2);
    }

    @Override // e.a.b.a.e
    public e r(e eVar) {
        int[] h2 = g.h();
        b.n(this.i, ((c) eVar).i, h2);
        return new c(h2);
    }

    @Override // e.a.b.a.e
    public boolean s() {
        return g.q(this.i, 0) == 1;
    }

    @Override // e.a.b.a.e
    public BigInteger t() {
        return g.J(this.i);
    }
}
