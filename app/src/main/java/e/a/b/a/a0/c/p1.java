package e.a.b.a.a0.c;

import e.a.b.a.e;
import e.a.b.c.g;
import java.math.BigInteger;
import org.bouncycastle.util.a;

/* loaded from: classes4.dex */
public class p1 extends e.a {
    protected long[] g;

    public p1() {
        this.g = g.i();
    }

    public p1(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 193) {
            throw new IllegalArgumentException("x value invalid for SecT193FieldElement");
        }
        this.g = o1.d(bigInteger);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public p1(long[] jArr) {
        this.g = jArr;
    }

    @Override // e.a.b.a.e
    public e a(e eVar) {
        long[] i = g.i();
        o1.a(this.g, ((p1) eVar).g, i);
        return new p1(i);
    }

    @Override // e.a.b.a.e
    public e b() {
        long[] i = g.i();
        o1.c(this.g, i);
        return new p1(i);
    }

    @Override // e.a.b.a.e
    public e d(e eVar) {
        return j(eVar.g());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p1)) {
            return false;
        }
        return g.n(this.g, ((p1) obj).g);
    }

    @Override // e.a.b.a.e
    public int f() {
        return 193;
    }

    @Override // e.a.b.a.e
    public e g() {
        long[] i = g.i();
        o1.j(this.g, i);
        return new p1(i);
    }

    @Override // e.a.b.a.e
    public boolean h() {
        return g.u(this.g);
    }

    public int hashCode() {
        return a.A(this.g, 0, 4) ^ 1930015;
    }

    @Override // e.a.b.a.e
    public boolean i() {
        return g.w(this.g);
    }

    @Override // e.a.b.a.e
    public e j(e eVar) {
        long[] i = g.i();
        o1.k(this.g, ((p1) eVar).g, i);
        return new p1(i);
    }

    @Override // e.a.b.a.e
    public e k(e eVar, e eVar2, e eVar3) {
        return l(eVar, eVar2, eVar3);
    }

    @Override // e.a.b.a.e
    public e l(e eVar, e eVar2, e eVar3) {
        long[] jArr = this.g;
        long[] jArr2 = ((p1) eVar).g;
        long[] jArr3 = ((p1) eVar2).g;
        long[] jArr4 = ((p1) eVar3).g;
        long[] k = g.k();
        o1.l(jArr, jArr2, k);
        o1.l(jArr3, jArr4, k);
        long[] i = g.i();
        o1.m(k, i);
        return new p1(i);
    }

    @Override // e.a.b.a.e
    public e m() {
        return this;
    }

    @Override // e.a.b.a.e
    public e n() {
        long[] i = g.i();
        o1.o(this.g, i);
        return new p1(i);
    }

    @Override // e.a.b.a.e
    public e o() {
        long[] i = g.i();
        o1.p(this.g, i);
        return new p1(i);
    }

    @Override // e.a.b.a.e
    public e p(e eVar, e eVar2) {
        long[] jArr = this.g;
        long[] jArr2 = ((p1) eVar).g;
        long[] jArr3 = ((p1) eVar2).g;
        long[] k = g.k();
        o1.q(jArr, k);
        o1.l(jArr2, jArr3, k);
        long[] i = g.i();
        o1.m(k, i);
        return new p1(i);
    }

    @Override // e.a.b.a.e
    public e q(int i) {
        if (i < 1) {
            return this;
        }
        long[] i2 = g.i();
        o1.r(this.g, i, i2);
        return new p1(i2);
    }

    @Override // e.a.b.a.e
    public e r(e eVar) {
        return a(eVar);
    }

    @Override // e.a.b.a.e
    public boolean s() {
        return (this.g[0] & 1) != 0;
    }

    @Override // e.a.b.a.e
    public BigInteger t() {
        return g.K(this.g);
    }

    @Override // e.a.b.a.e.a
    public int u() {
        return o1.s(this.g);
    }
}
