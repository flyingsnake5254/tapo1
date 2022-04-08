package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;

/* loaded from: classes4.dex */
public abstract class b extends e implements k0 {
    protected j0 a;

    /* renamed from: b  reason: collision with root package name */
    protected l0 f17194b;

    /* renamed from: c  reason: collision with root package name */
    protected Vector f17195c;

    /* renamed from: d  reason: collision with root package name */
    protected int[] f17196d;

    /* renamed from: e  reason: collision with root package name */
    protected short[] f17197e;

    /* renamed from: f  reason: collision with root package name */
    protected short[] f17198f;
    protected int g;
    protected short h;

    public b(j0 j0Var) {
        this.a = j0Var;
    }

    protected void A(Hashtable hashtable, Integer num) throws IOException {
        byte[] B = m1.B(hashtable, num);
        if (B != null && !z(num, B)) {
            throw new TlsFatalAlert((short) 47);
        }
    }

    public x B() {
        return x.f17283b;
    }

    @Override // org.bouncycastle.crypto.tls.k0
    public x a() {
        return x.f17285d;
    }

    @Override // org.bouncycastle.crypto.tls.k0
    public void b(short s) {
        this.h = s;
    }

    @Override // org.bouncycastle.crypto.tls.k0
    public boolean c() {
        return false;
    }

    @Override // org.bouncycastle.crypto.tls.k0
    public Vector d() throws IOException {
        return null;
    }

    @Override // org.bouncycastle.crypto.tls.k0
    public void e(l0 l0Var) {
        this.f17194b = l0Var;
    }

    @Override // org.bouncycastle.crypto.tls.f1
    public o0 f() throws IOException {
        if (this.h == 0) {
            return new a1();
        }
        throw new TlsFatalAlert((short) 80);
    }

    @Override // org.bouncycastle.crypto.tls.k0
    public void g(Hashtable hashtable) throws IOException {
        if (hashtable != null) {
            A(hashtable, m1.f17262e);
            A(hashtable, s0.a);
            if (s0.q(this.g)) {
                this.f17198f = s0.o(hashtable);
            } else {
                A(hashtable, s0.f17273b);
            }
            A(hashtable, u0.f17278e);
        }
    }

    @Override // org.bouncycastle.crypto.tls.k0
    public x i() {
        return a();
    }

    @Override // org.bouncycastle.crypto.tls.f1
    public i0 l() throws IOException {
        return this.a.a(this.f17194b, m1.A(this.g), m1.E(this.g));
    }

    @Override // org.bouncycastle.crypto.tls.k0
    public void m(x xVar) throws IOException {
        if (!B().h(xVar)) {
            throw new TlsFatalAlert((short) 70);
        }
    }

    @Override // org.bouncycastle.crypto.tls.k0
    public short[] o() {
        return new short[]{0};
    }

    @Override // org.bouncycastle.crypto.tls.k0
    public void q(Vector vector) throws IOException {
        if (vector != null) {
            throw new TlsFatalAlert((short) 10);
        }
    }

    @Override // org.bouncycastle.crypto.tls.k0
    public i1 r() {
        return null;
    }

    @Override // org.bouncycastle.crypto.tls.k0
    public void s(byte[] bArr) {
    }

    @Override // org.bouncycastle.crypto.tls.k0
    public void v(int i) {
        this.g = i;
    }

    @Override // org.bouncycastle.crypto.tls.k0
    public void x(v vVar) throws IOException {
    }

    public Hashtable y() throws IOException {
        Hashtable hashtable = null;
        if (m1.L(this.f17194b.a())) {
            this.f17195c = m1.z();
            hashtable = u0.a(null);
            m1.c(hashtable, this.f17195c);
        }
        if (!s0.e(j())) {
            return hashtable;
        }
        this.f17196d = new int[]{23, 24};
        this.f17197e = new short[]{0, 1, 2};
        Hashtable a = u0.a(hashtable);
        s0.a(a, this.f17196d);
        s0.b(a, this.f17197e);
        return a;
    }

    protected boolean z(Integer num, byte[] bArr) throws IOException {
        int intValue = num.intValue();
        if (intValue == 10) {
            s0.w(bArr);
            return true;
        } else if (intValue != 11) {
            return false;
        } else {
            s0.x(bArr);
            return true;
        }
    }
}
