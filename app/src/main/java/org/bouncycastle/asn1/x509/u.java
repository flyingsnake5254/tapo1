package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.g;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.n0;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x;

/* loaded from: classes4.dex */
public class u extends l {

    /* renamed from: c  reason: collision with root package name */
    g f17034c;

    /* renamed from: d  reason: collision with root package name */
    m f17035d;

    /* renamed from: f  reason: collision with root package name */
    a f17036f;
    n0 q;

    private u(r rVar) {
        if (rVar.size() > 4 || rVar.size() < 3) {
            throw new IllegalArgumentException("Bad sequence size: " + rVar.size());
        }
        int i = 0;
        this.f17034c = g.n(rVar.p(0));
        if (rVar.size() == 4) {
            this.f17035d = m.r(rVar.p(1));
            i = 1;
        }
        this.f17036f = a.g(rVar.p(i + 1));
        this.q = n0.s(rVar.p(i + 2));
    }

    public static u f(Object obj) {
        if (obj instanceof u) {
            return (u) obj;
        }
        if (obj != null) {
            return new u(r.m(obj));
        }
        return null;
    }

    public static u g(x xVar, boolean z) {
        return f(r.n(xVar, z));
    }

    @Override // org.bouncycastle.asn1.l, org.bouncycastle.asn1.e
    public q c() {
        f fVar = new f();
        fVar.a(this.f17034c);
        m mVar = this.f17035d;
        if (mVar != null) {
            fVar.a(mVar);
        }
        fVar.a(this.f17036f);
        fVar.a(this.q);
        return new b1(fVar);
    }
}
