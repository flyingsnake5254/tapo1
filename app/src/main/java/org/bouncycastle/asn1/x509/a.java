package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x;

/* loaded from: classes4.dex */
public class a extends l {

    /* renamed from: c  reason: collision with root package name */
    private m f16967c;

    /* renamed from: d  reason: collision with root package name */
    private e f16968d;

    public a(m mVar) {
        this.f16967c = mVar;
    }

    public a(m mVar, e eVar) {
        this.f16967c = mVar;
        this.f16968d = eVar;
    }

    private a(r rVar) {
        if (rVar.size() < 1 || rVar.size() > 2) {
            throw new IllegalArgumentException("Bad sequence size: " + rVar.size());
        }
        this.f16967c = m.r(rVar.p(0));
        this.f16968d = rVar.size() == 2 ? rVar.p(1) : null;
    }

    public static a g(Object obj) {
        if (obj instanceof a) {
            return (a) obj;
        }
        if (obj != null) {
            return new a(r.m(obj));
        }
        return null;
    }

    public static a h(x xVar, boolean z) {
        return g(r.n(xVar, z));
    }

    @Override // org.bouncycastle.asn1.l, org.bouncycastle.asn1.e
    public q c() {
        f fVar = new f();
        fVar.a(this.f16967c);
        e eVar = this.f16968d;
        if (eVar != null) {
            fVar.a(eVar);
        }
        return new b1(fVar);
    }

    public m f() {
        return this.f16967c;
    }

    public e i() {
        return this.f16968d;
    }
}
