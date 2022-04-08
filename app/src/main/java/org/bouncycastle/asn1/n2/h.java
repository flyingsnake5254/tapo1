package org.bouncycastle.asn1.n2;

import java.io.IOException;
import java.util.Enumeration;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.g1;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.n;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.t;
import org.bouncycastle.asn1.x;
import org.bouncycastle.asn1.x0;
import org.bouncycastle.asn1.x509.a;

/* loaded from: classes4.dex */
public class h extends l {

    /* renamed from: c  reason: collision with root package name */
    private n f16828c;

    /* renamed from: d  reason: collision with root package name */
    private a f16829d;

    /* renamed from: f  reason: collision with root package name */
    private t f16830f;

    public h(r rVar) {
        Enumeration q = rVar.q();
        if (((j) q.nextElement()).p().intValue() == 0) {
            this.f16829d = a.g(q.nextElement());
            this.f16828c = n.m(q.nextElement());
            if (q.hasMoreElements()) {
                this.f16830f = t.o((x) q.nextElement(), false);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("wrong version for private key info");
    }

    public h(a aVar, e eVar) throws IOException {
        this(aVar, eVar, null);
    }

    public h(a aVar, e eVar, t tVar) throws IOException {
        this.f16828c = new x0(eVar.c().e("DER"));
        this.f16829d = aVar;
        this.f16830f = tVar;
    }

    public static h g(Object obj) {
        if (obj instanceof h) {
            return (h) obj;
        }
        if (obj != null) {
            return new h(r.m(obj));
        }
        return null;
    }

    @Override // org.bouncycastle.asn1.l, org.bouncycastle.asn1.e
    public q c() {
        f fVar = new f();
        fVar.a(new j(0L));
        fVar.a(this.f16829d);
        fVar.a(this.f16828c);
        if (this.f16830f != null) {
            fVar.a(new g1(false, 0, this.f16830f));
        }
        return new b1(fVar);
    }

    public a f() {
        return this.f16829d;
    }

    public a h() {
        return this.f16829d;
    }

    public e i() throws IOException {
        return q.i(this.f16828c.o());
    }
}
