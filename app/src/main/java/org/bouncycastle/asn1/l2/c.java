package org.bouncycastle.asn1.l2;

import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.n;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x;

/* loaded from: classes4.dex */
public class c extends l {

    /* renamed from: c  reason: collision with root package name */
    m f16797c;

    /* renamed from: d  reason: collision with root package name */
    n f16798d;

    public c(r rVar) {
        this.f16797c = (m) rVar.p(0);
        this.f16798d = (n) rVar.p(1);
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

    public static c g(x xVar, boolean z) {
        return f(r.n(xVar, z));
    }

    @Override // org.bouncycastle.asn1.l, org.bouncycastle.asn1.e
    public q c() {
        f fVar = new f();
        fVar.a(this.f16797c);
        fVar.a(this.f16798d);
        return new b1(fVar);
    }
}
