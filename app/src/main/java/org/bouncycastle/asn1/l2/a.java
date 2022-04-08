package org.bouncycastle.asn1.l2;

import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.g1;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x;

/* loaded from: classes4.dex */
public class a extends l {

    /* renamed from: c  reason: collision with root package name */
    b f16794c;

    /* renamed from: d  reason: collision with root package name */
    c f16795d;

    private a(r rVar) {
        this.f16794c = b.f(rVar.p(0));
        if (rVar.size() == 2) {
            this.f16795d = c.g((x) rVar.p(1), true);
        }
    }

    public static a f(Object obj) {
        if (obj instanceof a) {
            return (a) obj;
        }
        if (obj != null) {
            return new a(r.m(obj));
        }
        return null;
    }

    @Override // org.bouncycastle.asn1.l, org.bouncycastle.asn1.e
    public q c() {
        f fVar = new f();
        fVar.a(this.f16794c);
        if (this.f16795d != null) {
            fVar.a(new g1(true, 0, this.f16795d));
        }
        return new b1(fVar);
    }
}
