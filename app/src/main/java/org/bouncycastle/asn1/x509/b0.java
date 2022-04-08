package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.g1;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.n0;
import org.bouncycastle.asn1.t2.c;

/* loaded from: classes4.dex */
public class b0 {
    g1 a = new g1(true, 0, new j(2));

    /* renamed from: b  reason: collision with root package name */
    j f16974b;

    /* renamed from: c  reason: collision with root package name */
    a f16975c;

    /* renamed from: d  reason: collision with root package name */
    c f16976d;

    /* renamed from: e  reason: collision with root package name */
    z f16977e;

    /* renamed from: f  reason: collision with root package name */
    z f16978f;
    c g;
    w h;
    m i;
    private boolean j;
    private n0 k;
    private n0 l;

    public y a() {
        if (this.f16974b == null || this.f16975c == null || this.f16976d == null || this.f16977e == null || this.f16978f == null || ((this.g == null && !this.j) || this.h == null)) {
            throw new IllegalStateException("not all mandatory fields set in V3 TBScertificate generator");
        }
        f fVar = new f();
        fVar.a(this.a);
        fVar.a(this.f16974b);
        fVar.a(this.f16975c);
        fVar.a(this.f16976d);
        f fVar2 = new f();
        fVar2.a(this.f16977e);
        fVar2.a(this.f16978f);
        fVar.a(new b1(fVar2));
        e eVar = this.g;
        if (eVar == null) {
            eVar = new b1();
        }
        fVar.a(eVar);
        fVar.a(this.h);
        if (this.k != null) {
            fVar.a(new g1(false, 1, this.k));
        }
        if (this.l != null) {
            fVar.a(new g1(false, 2, this.l));
        }
        if (this.i != null) {
            fVar.a(new g1(true, 3, this.i));
        }
        return y.h(new b1(fVar));
    }

    public void b(z zVar) {
        this.f16978f = zVar;
    }

    public void c(m mVar) {
        l g;
        this.i = mVar;
        if (mVar != null && (g = mVar.g(l.x)) != null && g.k()) {
            this.j = true;
        }
    }

    public void d(c cVar) {
        this.f16976d = cVar;
    }

    public void e(j jVar) {
        this.f16974b = jVar;
    }

    public void f(a aVar) {
        this.f16975c = aVar;
    }

    public void g(z zVar) {
        this.f16977e = zVar;
    }

    public void h(c cVar) {
        this.g = cVar;
    }

    public void i(w wVar) {
        this.h = wVar;
    }
}
