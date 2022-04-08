package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.h;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;

/* loaded from: classes4.dex */
public class c extends l {

    /* renamed from: c  reason: collision with root package name */
    h f16979c;

    /* renamed from: d  reason: collision with root package name */
    h f16980d;

    private c(r rVar) {
        if (rVar.size() == 2) {
            this.f16979c = h.p(rVar.p(0));
            this.f16980d = h.p(rVar.p(1));
            return;
        }
        throw new IllegalArgumentException("Bad sequence size: " + rVar.size());
    }

    public static c f(Object obj) {
        if (obj instanceof c) {
            return (c) obj;
        }
        if (obj != null) {
            return new c(r.m(obj));
        }
        return null;
    }

    @Override // org.bouncycastle.asn1.l, org.bouncycastle.asn1.e
    public q c() {
        f fVar = new f();
        fVar.a(this.f16979c);
        fVar.a(this.f16980d);
        return new b1(fVar);
    }

    public h g() {
        return this.f16980d;
    }

    public h h() {
        return this.f16979c;
    }
}
