package e.a.b.a.a0.c;

import e.a.b.a.e;
import e.a.b.c.b;
import e.a.b.c.d;
import java.math.BigInteger;
import org.bouncycastle.util.a;

/* loaded from: classes4.dex */
public class m extends e.b {
    public static final BigInteger g = k.i;
    protected int[] h;

    public m() {
        this.h = d.d();
    }

    public m(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(g) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP160R2FieldElement");
        }
        this.h = l.c(bigInteger);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public m(int[] iArr) {
        this.h = iArr;
    }

    @Override // e.a.b.a.e
    public e a(e eVar) {
        int[] d2 = d.d();
        l.a(this.h, ((m) eVar).h, d2);
        return new m(d2);
    }

    @Override // e.a.b.a.e
    public e b() {
        int[] d2 = d.d();
        l.b(this.h, d2);
        return new m(d2);
    }

    @Override // e.a.b.a.e
    public e d(e eVar) {
        int[] d2 = d.d();
        b.d(l.a, ((m) eVar).h, d2);
        l.d(d2, this.h, d2);
        return new m(d2);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        return d.f(this.h, ((m) obj).h);
    }

    @Override // e.a.b.a.e
    public int f() {
        return g.bitLength();
    }

    @Override // e.a.b.a.e
    public e g() {
        int[] d2 = d.d();
        b.d(l.a, this.h, d2);
        return new m(d2);
    }

    @Override // e.a.b.a.e
    public boolean h() {
        return d.j(this.h);
    }

    public int hashCode() {
        return g.hashCode() ^ a.z(this.h, 0, 5);
    }

    @Override // e.a.b.a.e
    public boolean i() {
        return d.k(this.h);
    }

    @Override // e.a.b.a.e
    public e j(e eVar) {
        int[] d2 = d.d();
        l.d(this.h, ((m) eVar).h, d2);
        return new m(d2);
    }

    @Override // e.a.b.a.e
    public e m() {
        int[] d2 = d.d();
        l.f(this.h, d2);
        return new m(d2);
    }

    @Override // e.a.b.a.e
    public e n() {
        int[] iArr = this.h;
        if (d.k(iArr) || d.j(iArr)) {
            return this;
        }
        int[] d2 = d.d();
        l.i(iArr, d2);
        l.d(d2, iArr, d2);
        int[] d3 = d.d();
        l.i(d2, d3);
        l.d(d3, iArr, d3);
        int[] d4 = d.d();
        l.i(d3, d4);
        l.d(d4, iArr, d4);
        int[] d5 = d.d();
        l.j(d4, 3, d5);
        l.d(d5, d3, d5);
        l.j(d5, 7, d4);
        l.d(d4, d5, d4);
        l.j(d4, 3, d5);
        l.d(d5, d3, d5);
        int[] d6 = d.d();
        l.j(d5, 14, d6);
        l.d(d6, d4, d6);
        l.j(d6, 31, d4);
        l.d(d4, d6, d4);
        l.j(d4, 62, d6);
        l.d(d6, d4, d6);
        l.j(d6, 3, d4);
        l.d(d4, d3, d4);
        l.j(d4, 18, d4);
        l.d(d4, d5, d4);
        l.j(d4, 2, d4);
        l.d(d4, iArr, d4);
        l.j(d4, 3, d4);
        l.d(d4, d2, d4);
        l.j(d4, 6, d4);
        l.d(d4, d3, d4);
        l.j(d4, 2, d4);
        l.d(d4, iArr, d4);
        l.i(d4, d2);
        if (d.f(iArr, d2)) {
            return new m(d4);
        }
        return null;
    }

    @Override // e.a.b.a.e
    public e o() {
        int[] d2 = d.d();
        l.i(this.h, d2);
        return new m(d2);
    }

    @Override // e.a.b.a.e
    public e r(e eVar) {
        int[] d2 = d.d();
        l.k(this.h, ((m) eVar).h, d2);
        return new m(d2);
    }

    @Override // e.a.b.a.e
    public boolean s() {
        return d.h(this.h, 0) == 1;
    }

    @Override // e.a.b.a.e
    public BigInteger t() {
        return d.u(this.h);
    }
}
