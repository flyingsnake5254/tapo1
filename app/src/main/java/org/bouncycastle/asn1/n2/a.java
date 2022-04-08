package org.bouncycastle.asn1.n2;

import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.t;

/* loaded from: classes4.dex */
public class a extends l {

    /* renamed from: c  reason: collision with root package name */
    private m f16812c;

    /* renamed from: d  reason: collision with root package name */
    private t f16813d;

    public a(r rVar) {
        this.f16812c = (m) rVar.p(0);
        this.f16813d = (t) rVar.p(1);
    }

    public static a h(Object obj) {
        if (obj == null || (obj instanceof a)) {
            return (a) obj;
        }
        if (obj instanceof r) {
            return new a((r) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    @Override // org.bouncycastle.asn1.l, org.bouncycastle.asn1.e
    public q c() {
        f fVar = new f();
        fVar.a(this.f16812c);
        fVar.a(this.f16813d);
        return new b1(fVar);
    }

    public m f() {
        return this.f16812c;
    }

    public t g() {
        return this.f16813d;
    }
}
