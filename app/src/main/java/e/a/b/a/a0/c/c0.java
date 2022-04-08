package e.a.b.a.a0.c;

import e.a.b.a.e;
import e.a.b.c.b;
import e.a.b.c.f;
import e.a.b.c.m;
import java.math.BigInteger;
import org.bouncycastle.util.a;

/* loaded from: classes4.dex */
public class c0 extends e.b {
    public static final BigInteger g = a0.i;
    protected int[] h;

    public c0() {
        this.h = f.e();
    }

    public c0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(g) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP224R1FieldElement");
        }
        this.h = b0.d(bigInteger);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c0(int[] iArr) {
        this.h = iArr;
    }

    private static void u(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5, int[] iArr6, int[] iArr7) {
        b0.e(iArr5, iArr3, iArr7);
        b0.e(iArr7, iArr, iArr7);
        b0.e(iArr4, iArr2, iArr6);
        b0.a(iArr6, iArr7, iArr6);
        b0.e(iArr4, iArr3, iArr7);
        f.d(iArr6, iArr4);
        b0.e(iArr5, iArr2, iArr5);
        b0.a(iArr5, iArr7, iArr5);
        b0.j(iArr5, iArr6);
        b0.e(iArr6, iArr, iArr6);
    }

    private static void v(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5) {
        f.d(iArr, iArr4);
        int[] e2 = f.e();
        int[] e3 = f.e();
        for (int i = 0; i < 7; i++) {
            f.d(iArr2, e2);
            f.d(iArr3, e3);
            int i2 = 1 << i;
            while (true) {
                i2--;
                if (i2 >= 0) {
                    w(iArr2, iArr3, iArr4, iArr5);
                }
            }
            u(iArr, e2, e3, iArr2, iArr3, iArr4, iArr5);
        }
    }

    private static void w(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        b0.e(iArr2, iArr, iArr2);
        b0.n(iArr2, iArr2);
        b0.j(iArr, iArr4);
        b0.a(iArr3, iArr4, iArr);
        b0.e(iArr3, iArr4, iArr3);
        b0.i(m.G(7, iArr3, 2, 0), iArr3);
    }

    private static boolean x(int[] iArr) {
        int[] e2 = f.e();
        int[] e3 = f.e();
        f.d(iArr, e2);
        for (int i = 0; i < 7; i++) {
            f.d(e2, e3);
            b0.k(e2, 1 << i, e2);
            b0.e(e2, e3, e2);
        }
        b0.k(e2, 95, e2);
        return f.k(e2);
    }

    private static boolean y(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] e2 = f.e();
        f.d(iArr2, e2);
        int[] e3 = f.e();
        e3[0] = 1;
        int[] e4 = f.e();
        v(iArr, e2, e3, e4, iArr3);
        int[] e5 = f.e();
        int[] e6 = f.e();
        for (int i = 1; i < 96; i++) {
            f.d(e2, e5);
            f.d(e3, e6);
            w(e2, e3, e4, iArr3);
            if (f.l(e2)) {
                b.d(b0.a, e6, iArr3);
                b0.e(iArr3, e5, iArr3);
                return true;
            }
        }
        return false;
    }

    @Override // e.a.b.a.e
    public e a(e eVar) {
        int[] e2 = f.e();
        b0.a(this.h, ((c0) eVar).h, e2);
        return new c0(e2);
    }

    @Override // e.a.b.a.e
    public e b() {
        int[] e2 = f.e();
        b0.b(this.h, e2);
        return new c0(e2);
    }

    @Override // e.a.b.a.e
    public e d(e eVar) {
        int[] e2 = f.e();
        b.d(b0.a, ((c0) eVar).h, e2);
        b0.e(e2, this.h, e2);
        return new c0(e2);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        return f.g(this.h, ((c0) obj).h);
    }

    @Override // e.a.b.a.e
    public int f() {
        return g.bitLength();
    }

    @Override // e.a.b.a.e
    public e g() {
        int[] e2 = f.e();
        b.d(b0.a, this.h, e2);
        return new c0(e2);
    }

    @Override // e.a.b.a.e
    public boolean h() {
        return f.k(this.h);
    }

    public int hashCode() {
        return g.hashCode() ^ a.z(this.h, 0, 7);
    }

    @Override // e.a.b.a.e
    public boolean i() {
        return f.l(this.h);
    }

    @Override // e.a.b.a.e
    public e j(e eVar) {
        int[] e2 = f.e();
        b0.e(this.h, ((c0) eVar).h, e2);
        return new c0(e2);
    }

    @Override // e.a.b.a.e
    public e m() {
        int[] e2 = f.e();
        b0.g(this.h, e2);
        return new c0(e2);
    }

    @Override // e.a.b.a.e
    public e n() {
        int[] iArr = this.h;
        if (f.l(iArr) || f.k(iArr)) {
            return this;
        }
        int[] e2 = f.e();
        b0.g(iArr, e2);
        int[] e3 = b.e(b0.a);
        int[] e4 = f.e();
        if (!x(iArr)) {
            return null;
        }
        while (!y(e2, e3, e4)) {
            b0.b(e3, e3);
        }
        b0.j(e4, e3);
        if (f.g(iArr, e3)) {
            return new c0(e4);
        }
        return null;
    }

    @Override // e.a.b.a.e
    public e o() {
        int[] e2 = f.e();
        b0.j(this.h, e2);
        return new c0(e2);
    }

    @Override // e.a.b.a.e
    public e r(e eVar) {
        int[] e2 = f.e();
        b0.m(this.h, ((c0) eVar).h, e2);
        return new c0(e2);
    }

    @Override // e.a.b.a.e
    public boolean s() {
        return f.i(this.h, 0) == 1;
    }

    @Override // e.a.b.a.e
    public BigInteger t() {
        return f.u(this.h);
    }
}
