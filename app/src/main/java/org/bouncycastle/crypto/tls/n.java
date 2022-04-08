package org.bouncycastle.crypto.tls;

import java.io.IOException;
import org.bouncycastle.crypto.engines.f;
import org.bouncycastle.crypto.engines.j;
import org.bouncycastle.crypto.g;
import org.bouncycastle.crypto.m;
import org.bouncycastle.crypto.u.a;
import org.bouncycastle.crypto.u.b;
import org.bouncycastle.crypto.u.c;
import org.bouncycastle.crypto.u.d;
import org.bouncycastle.crypto.u.e;

/* loaded from: classes4.dex */
public class n extends a {
    @Override // org.bouncycastle.crypto.tls.j0
    public i0 a(p0 p0Var, int i, int i2) throws IOException {
        if (i == 0) {
            return t(p0Var, i2);
        }
        if (i == 2) {
            return u(p0Var, 16, i2);
        }
        if (i == 103) {
            return o(p0Var, 16, 12);
        }
        if (i == 104) {
            return o(p0Var, 32, 12);
        }
        switch (i) {
            case 7:
                return r(p0Var, i2);
            case 8:
                return g(p0Var, 16, i2);
            case 9:
                return g(p0Var, 32, i2);
            case 10:
                return n(p0Var, 16, 16);
            case 11:
                return n(p0Var, 32, 16);
            case 12:
                return j(p0Var, 16, i2);
            case 13:
                return j(p0Var, 32, i2);
            case 14:
                return x(p0Var, i2);
            case 15:
                return m(p0Var, 16, 16);
            case 16:
                return m(p0Var, 16, 8);
            case 17:
                return m(p0Var, 32, 16);
            case 18:
                return m(p0Var, 32, 8);
            case 19:
                return p(p0Var, 16, 16);
            case 20:
                return p(p0Var, 32, 16);
            case 21:
                return l(p0Var);
            default:
                throw new TlsFatalAlert((short) 80);
        }
    }

    protected a b() {
        return new c(h());
    }

    protected a c() {
        return new d(h());
    }

    protected a d() {
        return new e(h(), h());
    }

    protected a e() {
        return new d(k());
    }

    protected org.bouncycastle.crypto.c f() {
        return new b(h());
    }

    protected h0 g(p0 p0Var, int i, int i2) throws IOException {
        return new h0(p0Var, f(), f(), s(i2), s(i2), i);
    }

    protected org.bouncycastle.crypto.c h() {
        return new org.bouncycastle.crypto.engines.a();
    }

    protected org.bouncycastle.crypto.c i() {
        return new b(k());
    }

    protected h0 j(p0 p0Var, int i, int i2) throws IOException {
        return new h0(p0Var, i(), i(), s(i2), s(i2), i);
    }

    protected org.bouncycastle.crypto.c k() {
        return new org.bouncycastle.crypto.engines.b();
    }

    protected i0 l(p0 p0Var) throws IOException {
        return new k(p0Var);
    }

    protected f0 m(p0 p0Var, int i, int i2) throws IOException {
        return new f0(p0Var, b(), b(), i, i2);
    }

    protected f0 n(p0 p0Var, int i, int i2) throws IOException {
        return new f0(p0Var, c(), c(), i, i2);
    }

    protected f0 o(p0 p0Var, int i, int i2) throws IOException {
        return new f0(p0Var, d(), d(), i, i2, 2);
    }

    protected f0 p(p0 p0Var, int i, int i2) throws IOException {
        return new f0(p0Var, e(), e(), i, i2);
    }

    protected org.bouncycastle.crypto.c q() {
        return new b(new f());
    }

    protected h0 r(p0 p0Var, int i) throws IOException {
        return new h0(p0Var, q(), q(), s(i), s(i), 24);
    }

    protected g s(int i) throws IOException {
        if (i == 0) {
            return null;
        }
        if (i == 1) {
            return m1.n((short) 1);
        }
        if (i == 2) {
            return m1.n((short) 2);
        }
        if (i == 3) {
            return m1.n((short) 4);
        }
        if (i == 4) {
            return m1.n((short) 5);
        }
        if (i == 5) {
            return m1.n((short) 6);
        }
        throw new TlsFatalAlert((short) 80);
    }

    protected z0 t(p0 p0Var, int i) throws IOException {
        return new z0(p0Var, s(i), s(i));
    }

    protected l1 u(p0 p0Var, int i, int i2) throws IOException {
        return new l1(p0Var, v(), v(), s(i2), s(i2), i, false);
    }

    protected m v() {
        return new org.bouncycastle.crypto.engines.g();
    }

    protected org.bouncycastle.crypto.c w() {
        return new b(new j());
    }

    protected h0 x(p0 p0Var, int i) throws IOException {
        return new h0(p0Var, w(), w(), s(i), s(i), 16);
    }
}
