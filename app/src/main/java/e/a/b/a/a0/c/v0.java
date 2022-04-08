package e.a.b.a.a0.c;

import e.a.b.a.e;
import e.a.b.c.c;
import java.math.BigInteger;
import org.bouncycastle.util.a;

/* loaded from: classes4.dex */
public class v0 extends e.a {
    protected long[] g;

    public v0() {
        this.g = c.f();
    }

    public v0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 113) {
            throw new IllegalArgumentException("x value invalid for SecT113FieldElement");
        }
        this.g = u0.d(bigInteger);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public v0(long[] jArr) {
        this.g = jArr;
    }

    @Override // e.a.b.a.e
    public e a(e eVar) {
        long[] f2 = c.f();
        u0.a(this.g, ((v0) eVar).g, f2);
        return new v0(f2);
    }

    @Override // e.a.b.a.e
    public e b() {
        long[] f2 = c.f();
        u0.c(this.g, f2);
        return new v0(f2);
    }

    @Override // e.a.b.a.e
    public e d(e eVar) {
        return j(eVar.g());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v0)) {
            return false;
        }
        return c.j(this.g, ((v0) obj).g);
    }

    @Override // e.a.b.a.e
    public int f() {
        return 113;
    }

    @Override // e.a.b.a.e
    public e g() {
        long[] f2 = c.f();
        u0.h(this.g, f2);
        return new v0(f2);
    }

    @Override // e.a.b.a.e
    public boolean h() {
        return c.p(this.g);
    }

    public int hashCode() {
        return a.A(this.g, 0, 2) ^ 113009;
    }

    @Override // e.a.b.a.e
    public boolean i() {
        return c.r(this.g);
    }

    @Override // e.a.b.a.e
    public e j(e eVar) {
        long[] f2 = c.f();
        u0.i(this.g, ((v0) eVar).g, f2);
        return new v0(f2);
    }

    @Override // e.a.b.a.e
    public e k(e eVar, e eVar2, e eVar3) {
        return l(eVar, eVar2, eVar3);
    }

    @Override // e.a.b.a.e
    public e l(e eVar, e eVar2, e eVar3) {
        long[] jArr = this.g;
        long[] jArr2 = ((v0) eVar).g;
        long[] jArr3 = ((v0) eVar2).g;
        long[] jArr4 = ((v0) eVar3).g;
        long[] h = c.h();
        u0.j(jArr, jArr2, h);
        u0.j(jArr3, jArr4, h);
        long[] f2 = c.f();
        u0.k(h, f2);
        return new v0(f2);
    }

    @Override // e.a.b.a.e
    public e m() {
        return this;
    }

    @Override // e.a.b.a.e
    public e n() {
        long[] f2 = c.f();
        u0.m(this.g, f2);
        return new v0(f2);
    }

    @Override // e.a.b.a.e
    public e o() {
        long[] f2 = c.f();
        u0.n(this.g, f2);
        return new v0(f2);
    }

    @Override // e.a.b.a.e
    public e p(e eVar, e eVar2) {
        long[] jArr = this.g;
        long[] jArr2 = ((v0) eVar).g;
        long[] jArr3 = ((v0) eVar2).g;
        long[] h = c.h();
        u0.o(jArr, h);
        u0.j(jArr2, jArr3, h);
        long[] f2 = c.f();
        u0.k(h, f2);
        return new v0(f2);
    }

    @Override // e.a.b.a.e
    public e q(int i) {
        if (i < 1) {
            return this;
        }
        long[] f2 = c.f();
        u0.p(this.g, i, f2);
        return new v0(f2);
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
        return c.y(this.g);
    }

    @Override // e.a.b.a.e.a
    public int u() {
        return u0.q(this.g);
    }
}
