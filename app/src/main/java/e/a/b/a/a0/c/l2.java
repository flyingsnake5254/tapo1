package e.a.b.a.a0.c;

import e.a.b.a.e;
import e.a.b.c.j;
import e.a.b.c.m;
import java.math.BigInteger;
import org.bouncycastle.util.a;

/* loaded from: classes4.dex */
public class l2 extends e.a {
    protected long[] g;

    public l2() {
        this.g = j.b();
    }

    public l2(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 409) {
            throw new IllegalArgumentException("x value invalid for SecT409FieldElement");
        }
        this.g = k2.d(bigInteger);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public l2(long[] jArr) {
        this.g = jArr;
    }

    @Override // e.a.b.a.e
    public e a(e eVar) {
        long[] b2 = j.b();
        k2.a(this.g, ((l2) eVar).g, b2);
        return new l2(b2);
    }

    @Override // e.a.b.a.e
    public e b() {
        long[] b2 = j.b();
        k2.c(this.g, b2);
        return new l2(b2);
    }

    @Override // e.a.b.a.e
    public e d(e eVar) {
        return j(eVar.g());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l2)) {
            return false;
        }
        return j.d(this.g, ((l2) obj).g);
    }

    @Override // e.a.b.a.e
    public int f() {
        return 409;
    }

    @Override // e.a.b.a.e
    public e g() {
        long[] b2 = j.b();
        k2.j(this.g, b2);
        return new l2(b2);
    }

    @Override // e.a.b.a.e
    public boolean h() {
        return j.f(this.g);
    }

    public int hashCode() {
        return a.A(this.g, 0, 7) ^ 4090087;
    }

    @Override // e.a.b.a.e
    public boolean i() {
        return j.g(this.g);
    }

    @Override // e.a.b.a.e
    public e j(e eVar) {
        long[] b2 = j.b();
        k2.k(this.g, ((l2) eVar).g, b2);
        return new l2(b2);
    }

    @Override // e.a.b.a.e
    public e k(e eVar, e eVar2, e eVar3) {
        return l(eVar, eVar2, eVar3);
    }

    @Override // e.a.b.a.e
    public e l(e eVar, e eVar2, e eVar3) {
        long[] jArr = this.g;
        long[] jArr2 = ((l2) eVar).g;
        long[] jArr3 = ((l2) eVar2).g;
        long[] jArr4 = ((l2) eVar3).g;
        long[] k = m.k(13);
        k2.l(jArr, jArr2, k);
        k2.l(jArr3, jArr4, k);
        long[] b2 = j.b();
        k2.m(k, b2);
        return new l2(b2);
    }

    @Override // e.a.b.a.e
    public e m() {
        return this;
    }

    @Override // e.a.b.a.e
    public e n() {
        long[] b2 = j.b();
        k2.o(this.g, b2);
        return new l2(b2);
    }

    @Override // e.a.b.a.e
    public e o() {
        long[] b2 = j.b();
        k2.p(this.g, b2);
        return new l2(b2);
    }

    @Override // e.a.b.a.e
    public e p(e eVar, e eVar2) {
        long[] jArr = this.g;
        long[] jArr2 = ((l2) eVar).g;
        long[] jArr3 = ((l2) eVar2).g;
        long[] k = m.k(13);
        k2.q(jArr, k);
        k2.l(jArr2, jArr3, k);
        long[] b2 = j.b();
        k2.m(k, b2);
        return new l2(b2);
    }

    @Override // e.a.b.a.e
    public e q(int i) {
        if (i < 1) {
            return this;
        }
        long[] b2 = j.b();
        k2.r(this.g, i, b2);
        return new l2(b2);
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
        return j.h(this.g);
    }

    @Override // e.a.b.a.e.a
    public int u() {
        return k2.s(this.g);
    }
}
