package org.bouncycastle.asn1.n2;

import java.util.Enumeration;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.n;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x509.a;

/* loaded from: classes4.dex */
public class f extends l {

    /* renamed from: c  reason: collision with root package name */
    private a f16826c;

    /* renamed from: d  reason: collision with root package name */
    private n f16827d;

    private f(r rVar) {
        Enumeration q = rVar.q();
        this.f16826c = a.g(q.nextElement());
        this.f16827d = n.m(q.nextElement());
    }

    public static f f(Object obj) {
        if (obj instanceof f) {
            return (f) obj;
        }
        if (obj != null) {
            return new f(r.m(obj));
        }
        return null;
    }

    @Override // org.bouncycastle.asn1.l, org.bouncycastle.asn1.e
    public q c() {
        org.bouncycastle.asn1.f fVar = new org.bouncycastle.asn1.f();
        fVar.a(this.f16826c);
        fVar.a(this.f16827d);
        return new b1(fVar);
    }
}
