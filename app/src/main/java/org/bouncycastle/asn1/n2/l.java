package org.bouncycastle.asn1.n2;

import org.bouncycastle.asn1.e0;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.g1;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.t;

/* loaded from: classes4.dex */
public class l extends org.bouncycastle.asn1.l implements g {

    /* renamed from: c  reason: collision with root package name */
    private j f16839c;

    /* renamed from: d  reason: collision with root package name */
    private t f16840d;

    /* renamed from: f  reason: collision with root package name */
    private d f16841f;
    private t q;
    private t x;
    private t y;

    public l(j jVar, t tVar, d dVar, t tVar2, t tVar3, t tVar4) {
        this.f16839c = jVar;
        this.f16840d = tVar;
        this.f16841f = dVar;
        this.q = tVar2;
        this.x = tVar3;
        this.y = tVar4;
    }

    @Override // org.bouncycastle.asn1.l, org.bouncycastle.asn1.e
    public q c() {
        f fVar = new f();
        fVar.a(this.f16839c);
        fVar.a(this.f16840d);
        fVar.a(this.f16841f);
        if (this.q != null) {
            fVar.a(new g1(false, 0, this.q));
        }
        if (this.x != null) {
            fVar.a(new g1(false, 1, this.x));
        }
        fVar.a(this.y);
        return new e0(fVar);
    }
}
