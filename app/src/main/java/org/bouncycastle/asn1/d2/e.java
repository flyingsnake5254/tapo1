package org.bouncycastle.asn1.d2;

import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;

/* loaded from: classes4.dex */
public class e extends l {

    /* renamed from: c  reason: collision with root package name */
    private m f16725c;

    /* renamed from: d  reason: collision with root package name */
    private m f16726d;

    /* renamed from: f  reason: collision with root package name */
    private m f16727f;

    public e(m mVar, m mVar2) {
        this.f16725c = mVar;
        this.f16726d = mVar2;
        this.f16727f = null;
    }

    public e(m mVar, m mVar2, m mVar3) {
        this.f16725c = mVar;
        this.f16726d = mVar2;
        this.f16727f = mVar3;
    }

    public e(r rVar) {
        this.f16725c = (m) rVar.p(0);
        this.f16726d = (m) rVar.p(1);
        if (rVar.size() > 2) {
            this.f16727f = (m) rVar.p(2);
        }
    }

    public static e h(Object obj) {
        if (obj instanceof e) {
            return (e) obj;
        }
        if (obj != null) {
            return new e(r.m(obj));
        }
        return null;
    }

    @Override // org.bouncycastle.asn1.l, org.bouncycastle.asn1.e
    public q c() {
        f fVar = new f();
        fVar.a(this.f16725c);
        fVar.a(this.f16726d);
        m mVar = this.f16727f;
        if (mVar != null) {
            fVar.a(mVar);
        }
        return new b1(fVar);
    }

    public m f() {
        return this.f16726d;
    }

    public m g() {
        return this.f16727f;
    }

    public m i() {
        return this.f16725c;
    }
}
