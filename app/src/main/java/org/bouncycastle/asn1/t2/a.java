package org.bouncycastle.asn1.t2;

import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;

/* loaded from: classes4.dex */
public class a extends l {

    /* renamed from: c  reason: collision with root package name */
    private m f16903c;

    /* renamed from: d  reason: collision with root package name */
    private e f16904d;

    public a(m mVar, e eVar) {
        this.f16903c = mVar;
        this.f16904d = eVar;
    }

    private a(r rVar) {
        this.f16903c = (m) rVar.p(0);
        this.f16904d = rVar.p(1);
    }

    public static a f(Object obj) {
        if (obj instanceof a) {
            return (a) obj;
        }
        if (obj != null) {
            return new a(r.m(obj));
        }
        throw new IllegalArgumentException("null value in getInstance()");
    }

    @Override // org.bouncycastle.asn1.l, org.bouncycastle.asn1.e
    public q c() {
        f fVar = new f();
        fVar.a(this.f16903c);
        fVar.a(this.f16904d);
        return new b1(fVar);
    }

    public m g() {
        return this.f16903c;
    }

    public e h() {
        return this.f16904d;
    }
}
