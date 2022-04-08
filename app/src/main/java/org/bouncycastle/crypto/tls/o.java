package org.bouncycastle.crypto.tls;

import java.util.Enumeration;
import java.util.Hashtable;
import org.bouncycastle.crypto.g;
import org.bouncycastle.util.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class o implements v0 {
    protected p0 a;

    /* renamed from: b  reason: collision with root package name */
    private p f17264b;

    /* renamed from: c  reason: collision with root package name */
    private Hashtable f17265c;

    /* renamed from: d  reason: collision with root package name */
    private Short f17266d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o() {
        this.f17264b = new p();
        this.f17265c = new Hashtable();
        this.f17266d = null;
    }

    private o(Short sh, g gVar) {
        this.f17264b = null;
        Hashtable hashtable = new Hashtable();
        this.f17265c = hashtable;
        this.f17266d = sh;
        hashtable.put(sh, gVar);
    }

    @Override // org.bouncycastle.crypto.tls.v0
    public void a(p0 p0Var) {
        this.a = p0Var;
    }

    @Override // org.bouncycastle.crypto.g
    public String b() {
        throw new IllegalStateException("Use fork() to get a definite Digest");
    }

    @Override // org.bouncycastle.crypto.g
    public void c(byte b2) {
        p pVar = this.f17264b;
        if (pVar != null) {
            pVar.write(b2);
            return;
        }
        Enumeration elements = this.f17265c.elements();
        while (elements.hasMoreElements()) {
            ((g) elements.nextElement()).c(b2);
        }
    }

    @Override // org.bouncycastle.crypto.tls.v0
    public v0 d() {
        g l = m1.l(this.f17266d.shortValue(), (g) this.f17265c.get(this.f17266d));
        p pVar = this.f17264b;
        if (pVar != null) {
            pVar.a(l);
        }
        o oVar = new o(this.f17266d, l);
        oVar.a(this.a);
        return oVar;
    }

    @Override // org.bouncycastle.crypto.g
    public int doFinal(byte[] bArr, int i) {
        throw new IllegalStateException("Use fork() to get a definite Digest");
    }

    @Override // org.bouncycastle.crypto.g
    public int e() {
        throw new IllegalStateException("Use fork() to get a definite Digest");
    }

    @Override // org.bouncycastle.crypto.tls.v0
    public g f() {
        m();
        if (this.f17264b == null) {
            return m1.l(this.f17266d.shortValue(), (g) this.f17265c.get(this.f17266d));
        }
        g n = m1.n(this.f17266d.shortValue());
        this.f17264b.a(n);
        return n;
    }

    @Override // org.bouncycastle.crypto.tls.v0
    public v0 g() {
        int g = this.a.e().g();
        if (g == 0) {
            m mVar = new m();
            mVar.a(this.a);
            this.f17264b.a(mVar);
            return mVar.g();
        }
        Short a = h.a(m1.C(g));
        this.f17266d = a;
        n(a);
        return this;
    }

    @Override // org.bouncycastle.crypto.tls.v0
    public void h(short s) {
        if (this.f17264b != null) {
            n(h.a(s));
            return;
        }
        throw new IllegalStateException("Too late to track more hash algorithms");
    }

    @Override // org.bouncycastle.crypto.tls.v0
    public byte[] i(short s) {
        g gVar = (g) this.f17265c.get(h.a(s));
        if (gVar != null) {
            g l = m1.l(s, gVar);
            p pVar = this.f17264b;
            if (pVar != null) {
                pVar.a(l);
            }
            byte[] bArr = new byte[l.e()];
            l.doFinal(bArr, 0);
            return bArr;
        }
        throw new IllegalStateException("HashAlgorithm." + s.b(s) + " is not being tracked");
    }

    @Override // org.bouncycastle.crypto.tls.v0
    public void l() {
        m();
    }

    protected void m() {
        if (this.f17264b != null && this.f17265c.size() <= 4) {
            Enumeration elements = this.f17265c.elements();
            while (elements.hasMoreElements()) {
                this.f17264b.a((g) elements.nextElement());
            }
            this.f17264b = null;
        }
    }

    protected void n(Short sh) {
        if (!this.f17265c.containsKey(sh)) {
            this.f17265c.put(sh, m1.n(sh.shortValue()));
        }
    }

    @Override // org.bouncycastle.crypto.g
    public void reset() {
        p pVar = this.f17264b;
        if (pVar != null) {
            pVar.reset();
            return;
        }
        Enumeration elements = this.f17265c.elements();
        while (elements.hasMoreElements()) {
            ((g) elements.nextElement()).reset();
        }
    }

    @Override // org.bouncycastle.crypto.g
    public void update(byte[] bArr, int i, int i2) {
        p pVar = this.f17264b;
        if (pVar != null) {
            pVar.write(bArr, i, i2);
            return;
        }
        Enumeration elements = this.f17265c.elements();
        while (elements.hasMoreElements()) {
            ((g) elements.nextElement()).update(bArr, i, i2);
        }
    }
}
