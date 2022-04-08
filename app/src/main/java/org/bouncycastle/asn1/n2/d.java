package org.bouncycastle.asn1.n2;

import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.e0;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.i0;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.o1;
import org.bouncycastle.asn1.q;

/* loaded from: classes4.dex */
public class d extends l implements g {

    /* renamed from: c  reason: collision with root package name */
    private m f16820c;

    /* renamed from: d  reason: collision with root package name */
    private e f16821d;

    /* renamed from: f  reason: collision with root package name */
    private boolean f16822f = true;

    public d(m mVar, e eVar) {
        this.f16820c = mVar;
        this.f16821d = eVar;
    }

    @Override // org.bouncycastle.asn1.l, org.bouncycastle.asn1.e
    public q c() {
        f fVar = new f();
        fVar.a(this.f16820c);
        e eVar = this.f16821d;
        if (eVar != null) {
            fVar.a(new i0(true, 0, eVar));
        }
        return this.f16822f ? new e0(fVar) : new o1(fVar);
    }
}
