package org.bouncycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.crypto.tls.g1;
import org.bouncycastle.util.a;

/* loaded from: classes4.dex */
public class n0 extends g1 {
    protected k0 E = null;
    m0 F = null;
    protected byte[] G = null;
    protected x0 H = null;
    protected g0 I = null;
    protected j J = null;
    protected i K = null;

    public n0(InputStream inputStream, OutputStream outputStream, SecureRandom secureRandom) {
        super(inputStream, outputStream, secureRandom);
    }

    @Override // org.bouncycastle.crypto.tls.g1
    protected void A(short s, ByteArrayInputStream byteArrayInputStream) throws IOException {
        q0 q0Var;
        h hVar;
        if (this.y) {
            if (s == 20 && this.x == 2) {
                F(byteArrayInputStream);
                this.x = (short) 15;
                S();
                T();
                this.x = (short) 13;
                h();
                return;
            }
            throw new TlsFatalAlert((short) 10);
        } else if (s == 0) {
            g1.c(byteArrayInputStream);
            if (this.x == 16) {
                O();
            }
        } else if (s != 2) {
            if (s != 4) {
                if (s == 20) {
                    short s2 = this.x;
                    if (s2 != 13) {
                        if (s2 != 14) {
                            throw new TlsFatalAlert((short) 10);
                        }
                    } else if (this.C) {
                        throw new TlsFatalAlert((short) 10);
                    }
                    F(byteArrayInputStream);
                    this.x = (short) 15;
                    h();
                } else if (s != 22) {
                    if (s != 23) {
                        switch (s) {
                            case 11:
                                short s3 = this.x;
                                if (s3 == 2) {
                                    b0(null);
                                } else if (s3 != 3) {
                                    throw new TlsFatalAlert((short) 10);
                                }
                                this.s = h.d(byteArrayInputStream);
                                g1.c(byteArrayInputStream);
                                h hVar2 = this.s;
                                if (hVar2 == null || hVar2.c()) {
                                    this.B = false;
                                }
                                this.H.g(this.s);
                                g0 u = this.E.u();
                                this.I = u;
                                u.b(this.s);
                                this.x = (short) 4;
                                return;
                            case 12:
                                short s4 = this.x;
                                if (s4 == 2) {
                                    b0(null);
                                } else if (s4 != 3) {
                                    if (!(s4 == 4 || s4 == 5)) {
                                        throw new TlsFatalAlert((short) 10);
                                    }
                                    this.H.b(byteArrayInputStream);
                                    g1.c(byteArrayInputStream);
                                    this.x = (short) 6;
                                    return;
                                }
                                this.H.j();
                                this.I = null;
                                this.H.b(byteArrayInputStream);
                                g1.c(byteArrayInputStream);
                                this.x = (short) 6;
                                return;
                            case 13:
                                short s5 = this.x;
                                if (s5 == 4 || s5 == 5) {
                                    this.H.f();
                                } else if (s5 != 6) {
                                    throw new TlsFatalAlert((short) 10);
                                }
                                if (this.I != null) {
                                    this.K = i.b(n(), byteArrayInputStream);
                                    g1.c(byteArrayInputStream);
                                    this.H.c(this.K);
                                    m1.p0(this.f17235f.h(), this.K.a());
                                    this.x = (short) 7;
                                    return;
                                }
                                throw new TlsFatalAlert((short) 40);
                            case 14:
                                switch (this.x) {
                                    case 2:
                                        b0(null);
                                    case 3:
                                        this.H.j();
                                        this.I = null;
                                    case 4:
                                    case 5:
                                        this.H.f();
                                        break;
                                    case 6:
                                    case 7:
                                        break;
                                    default:
                                        throw new TlsFatalAlert((short) 10);
                                }
                                g1.c(byteArrayInputStream);
                                this.x = (short) 8;
                                this.f17235f.h().l();
                                Vector d2 = this.E.d();
                                if (d2 != null) {
                                    U(d2);
                                }
                                this.x = (short) 9;
                                i iVar = this.K;
                                if (iVar == null) {
                                    this.H.d();
                                    q0Var = null;
                                } else {
                                    q0Var = this.I.a(iVar);
                                    x0 x0Var = this.H;
                                    if (q0Var == null) {
                                        x0Var.d();
                                        hVar = h.a;
                                    } else {
                                        x0Var.h(q0Var);
                                        hVar = q0Var.c();
                                    }
                                    R(hVar);
                                }
                                this.x = (short) 10;
                                g0();
                                this.x = (short) 11;
                                if (m1.K(n())) {
                                    g1.l(n(), this.H);
                                }
                                v0 n = this.f17235f.n();
                                this.r.i = g1.p(n(), n, null);
                                if (!m1.K(n())) {
                                    g1.l(n(), this.H);
                                }
                                this.f17235f.s(t().f(), t().l());
                                if (q0Var != null && (q0Var instanceof k1)) {
                                    k1 k1Var = (k1) q0Var;
                                    d0 G = m1.G(n(), k1Var);
                                    e0(new q(G, k1Var.b(G == null ? this.r.j() : n.i(G.b()))));
                                    this.x = (short) 12;
                                }
                                S();
                                T();
                                this.x = (short) 13;
                                return;
                            default:
                                throw new TlsFatalAlert((short) 10);
                        }
                    } else if (this.x == 2) {
                        b0(g1.N(byteArrayInputStream));
                    } else {
                        throw new TlsFatalAlert((short) 10);
                    }
                } else if (this.x != 4) {
                    throw new TlsFatalAlert((short) 10);
                } else if (this.B) {
                    this.J = j.b(byteArrayInputStream);
                    g1.c(byteArrayInputStream);
                    this.x = (short) 5;
                } else {
                    throw new TlsFatalAlert((short) 10);
                }
            } else if (this.x != 13) {
                throw new TlsFatalAlert((short) 10);
            } else if (this.C) {
                B();
                c0(byteArrayInputStream);
                this.x = (short) 14;
            } else {
                throw new TlsFatalAlert((short) 10);
            }
        } else if (this.x == 1) {
            d0(byteArrayInputStream);
            this.x = (short) 2;
            this.f17235f.m();
            b();
            if (this.y) {
                this.r.f17193f = a.g(this.q.e());
                this.f17235f.s(t().f(), t().l());
                return;
            }
            B();
            byte[] bArr = this.G;
            if (bArr.length > 0) {
                this.p = new j1(bArr, null);
            }
        } else {
            throw new TlsFatalAlert((short) 10);
        }
    }

    public void a0(k0 k0Var) throws IOException {
        c0 c2;
        if (k0Var == null) {
            throw new IllegalArgumentException("'tlsClient' cannot be null");
        } else if (this.E == null) {
            this.E = k0Var;
            a0 a0Var = new a0();
            this.r = a0Var;
            a0Var.a = 1;
            this.F = new m0(this.g, this.r);
            this.r.g = g1.i(k0Var.w(), this.F.d());
            this.E.e(this.F);
            this.f17235f.l(this.F);
            i1 r = k0Var.r();
            if (!(r == null || !r.b() || (c2 = r.c()) == null)) {
                this.p = r;
                this.q = c2;
            }
            f0();
            this.x = (short) 1;
            d();
        } else {
            throw new IllegalStateException("'connect' can only be called once");
        }
    }

    protected void b0(Vector vector) throws IOException {
        this.E.q(vector);
        this.x = (short) 3;
        x0 h = this.E.h();
        this.H = h;
        h.a(n());
    }

    protected void c0(ByteArrayInputStream byteArrayInputStream) throws IOException {
        v a = v.a(byteArrayInputStream);
        g1.c(byteArrayInputStream);
        this.E.x(a);
    }

    protected void d0(ByteArrayInputStream byteArrayInputStream) throws IOException {
        i1 i1Var;
        x m0 = m1.m0(byteArrayInputStream);
        if (m0.g()) {
            throw new TlsFatalAlert((short) 47);
        } else if (!m0.a(this.f17235f.k())) {
            throw new TlsFatalAlert((short) 47);
        } else if (m0.h(n().a())) {
            this.f17235f.u(m0);
            o().i(m0);
            this.E.m(m0);
            this.r.h = m1.Z(32, byteArrayInputStream);
            byte[] c0 = m1.c0(byteArrayInputStream);
            this.G = c0;
            if (c0.length <= 32) {
                this.E.s(c0);
                byte[] bArr = this.G;
                boolean z = false;
                this.y = bArr.length > 0 && (i1Var = this.p) != null && a.c(bArr, i1Var.a());
                int d0 = m1.d0(byteArrayInputStream);
                if (!a.p(this.t, d0) || d0 == 0 || l.a(d0) || !m1.Q(d0, n().b())) {
                    throw new TlsFatalAlert((short) 47);
                }
                this.E.v(d0);
                short j0 = m1.j0(byteArrayInputStream);
                if (a.q(this.u, j0)) {
                    this.E.b(j0);
                    Hashtable M = g1.M(byteArrayInputStream);
                    this.w = M;
                    if (M != null) {
                        Enumeration keys = M.keys();
                        while (keys.hasMoreElements()) {
                            Integer num = (Integer) keys.nextElement();
                            if (!num.equals(g1.a) && m1.B(this.v, num) == null) {
                                throw new TlsFatalAlert((short) 110);
                            }
                        }
                    }
                    byte[] B = m1.B(this.w, g1.a);
                    if (B != null) {
                        this.A = true;
                        if (!a.o(B, g1.j(m1.a))) {
                            throw new TlsFatalAlert((short) 40);
                        }
                    }
                    this.E.k(this.A);
                    Hashtable hashtable = this.v;
                    Hashtable hashtable2 = this.w;
                    if (this.y) {
                        if (d0 == this.q.c() && j0 == this.q.d()) {
                            hashtable = null;
                            hashtable2 = this.q.f();
                        } else {
                            throw new TlsFatalAlert((short) 47);
                        }
                    }
                    a0 a0Var = this.r;
                    a0Var.f17189b = d0;
                    a0Var.f17190c = j0;
                    if (hashtable2 != null) {
                        boolean c2 = u0.c(hashtable2);
                        if (!c2 || m1.J(d0)) {
                            a0 a0Var2 = this.r;
                            a0Var2.n = c2;
                            a0Var2.o = u0.d(hashtable2);
                            this.r.l = H(hashtable, hashtable2, (short) 47);
                            this.r.m = u0.e(hashtable2);
                            this.B = !this.y && m1.H(hashtable2, u0.g, (short) 47);
                            if (!this.y && m1.H(hashtable2, g1.f17231b, (short) 47)) {
                                z = true;
                            }
                            this.C = z;
                        } else {
                            throw new TlsFatalAlert((short) 47);
                        }
                    }
                    if (hashtable != null) {
                        this.E.g(hashtable2);
                    }
                    this.r.f17191d = g1.s(n(), this.r.b());
                    this.r.f17192e = 12;
                    return;
                }
                throw new TlsFatalAlert((short) 47);
            }
            throw new TlsFatalAlert((short) 47);
        } else {
            throw new TlsFatalAlert((short) 47);
        }
    }

    protected void e0(q qVar) throws IOException {
        g1.a aVar = new g1.a(this, (short) 15);
        qVar.a(aVar);
        aVar.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.bouncycastle.crypto.tls.g1
    public void f() {
        super.f();
        this.G = null;
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = null;
    }

    protected void f0() throws IOException {
        byte[] bArr;
        c0 c0Var;
        this.f17235f.u(this.E.i());
        x a = this.E.a();
        if (!a.g()) {
            o().g(a);
            byte[] bArr2 = m1.a;
            i1 i1Var = this.p;
            if (i1Var == null || (bArr = i1Var.a()) == null || bArr.length > 32) {
                bArr = bArr2;
            }
            boolean c2 = this.E.c();
            this.t = this.E.j();
            this.u = this.E.o();
            if (bArr.length <= 0 || (c0Var = this.q) == null || (a.p(this.t, c0Var.c()) && a.q(this.u, this.q.d()))) {
                bArr2 = bArr;
            }
            this.v = this.E.y();
            g1.a aVar = new g1.a(this, (short) 1);
            m1.N0(a, aVar);
            aVar.write(this.r.c());
            m1.v0(bArr2, aVar);
            boolean z = m1.B(this.v, g1.a) == null;
            boolean z2 = !a.p(this.t, 255);
            if (z && z2) {
                this.t = a.a(this.t, 255);
            }
            if (c2 && !a.p(this.t, 22016)) {
                this.t = a.a(this.t, 22016);
            }
            m1.A0(this.t, aVar);
            m1.L0(this.u, aVar);
            Hashtable hashtable = this.v;
            if (hashtable != null) {
                g1.W(aVar, hashtable);
            }
            aVar.a();
            return;
        }
        throw new TlsFatalAlert((short) 80);
    }

    protected void g0() throws IOException {
        g1.a aVar = new g1.a(this, (short) 16);
        this.H.e(aVar);
        aVar.a();
    }

    @Override // org.bouncycastle.crypto.tls.g1
    protected p0 n() {
        return this.F;
    }

    @Override // org.bouncycastle.crypto.tls.g1
    c o() {
        return this.F;
    }

    @Override // org.bouncycastle.crypto.tls.g1
    protected f1 t() {
        return this.E;
    }
}
