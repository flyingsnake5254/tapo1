package e.a.b.a.a0.c;

import e.a.b.a.e;
import e.a.b.c.b;
import java.math.BigInteger;
import org.bouncycastle.util.a;

/* loaded from: classes4.dex */
public class c extends e.b {
    public static final BigInteger g = a.i;
    protected int[] h;

    public c() {
        this.h = e.a.b.c.c.e();
    }

    public c(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(g) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP128R1FieldElement");
        }
        this.h = b.d(bigInteger);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(int[] iArr) {
        this.h = iArr;
    }

    @Override // e.a.b.a.e
    public e a(e eVar) {
        int[] e2 = e.a.b.c.c.e();
        b.a(this.h, ((c) eVar).h, e2);
        return new c(e2);
    }

    @Override // e.a.b.a.e
    public e b() {
        int[] e2 = e.a.b.c.c.e();
        b.b(this.h, e2);
        return new c(e2);
    }

    @Override // e.a.b.a.e
    public e d(e eVar) {
        int[] e2 = e.a.b.c.c.e();
        b.d(b.a, ((c) eVar).h, e2);
        b.e(e2, this.h, e2);
        return new c(e2);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        return e.a.b.c.c.i(this.h, ((c) obj).h);
    }

    @Override // e.a.b.a.e
    public int f() {
        return g.bitLength();
    }

    @Override // e.a.b.a.e
    public e g() {
        int[] e2 = e.a.b.c.c.e();
        b.d(b.a, this.h, e2);
        return new c(e2);
    }

    @Override // e.a.b.a.e
    public boolean h() {
        return e.a.b.c.c.o(this.h);
    }

    public int hashCode() {
        return g.hashCode() ^ a.z(this.h, 0, 4);
    }

    @Override // e.a.b.a.e
    public boolean i() {
        return e.a.b.c.c.q(this.h);
    }

    @Override // e.a.b.a.e
    public e j(e eVar) {
        int[] e2 = e.a.b.c.c.e();
        b.e(this.h, ((c) eVar).h, e2);
        return new c(e2);
    }

    @Override // e.a.b.a.e
    public e m() {
        int[] e2 = e.a.b.c.c.e();
        b.g(this.h, e2);
        return new c(e2);
    }

    @Override // e.a.b.a.e
    public e n() {
        int[] iArr = this.h;
        if (e.a.b.c.c.q(iArr) || e.a.b.c.c.o(iArr)) {
            return this;
        }
        int[] e2 = e.a.b.c.c.e();
        b.j(iArr, e2);
        b.e(e2, iArr, e2);
        int[] e3 = e.a.b.c.c.e();
        b.k(e2, 2, e3);
        b.e(e3, e2, e3);
        int[] e4 = e.a.b.c.c.e();
        b.k(e3, 4, e4);
        b.e(e4, e3, e4);
        b.k(e4, 2, e3);
        b.e(e3, e2, e3);
        b.k(e3, 10, e2);
        b.e(e2, e3, e2);
        b.k(e2, 10, e4);
        b.e(e4, e3, e4);
        b.j(e4, e3);
        b.e(e3, iArr, e3);
        b.k(e3, 95, e3);
        b.j(e3, e4);
        if (e.a.b.c.c.i(iArr, e4)) {
            return new c(e3);
        }
        return null;
    }

    @Override // e.a.b.a.e
    public e o() {
        int[] e2 = e.a.b.c.c.e();
        b.j(this.h, e2);
        return new c(e2);
    }

    @Override // e.a.b.a.e
    public e r(e eVar) {
        int[] e2 = e.a.b.c.c.e();
        b.m(this.h, ((c) eVar).h, e2);
        return new c(e2);
    }

    @Override // e.a.b.a.e
    public boolean s() {
        return e.a.b.c.c.m(this.h, 0) == 1;
    }

    @Override // e.a.b.a.e
    public BigInteger t() {
        return e.a.b.c.c.x(this.h);
    }
}
