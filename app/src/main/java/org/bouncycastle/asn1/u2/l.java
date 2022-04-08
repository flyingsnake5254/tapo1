package org.bouncycastle.asn1.u2;

import e.a.b.a.d;
import e.a.b.a.h;
import org.bouncycastle.asn1.n;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.x0;
import org.bouncycastle.util.a;

/* loaded from: classes4.dex */
public class l extends org.bouncycastle.asn1.l {

    /* renamed from: c  reason: collision with root package name */
    private final n f16948c;

    /* renamed from: d  reason: collision with root package name */
    private d f16949d;

    /* renamed from: f  reason: collision with root package name */
    private h f16950f;

    public l(d dVar, n nVar) {
        this(dVar, nVar.o());
    }

    public l(d dVar, byte[] bArr) {
        this.f16949d = dVar;
        this.f16948c = new x0(a.g(bArr));
    }

    public l(h hVar) {
        this(hVar, false);
    }

    public l(h hVar, boolean z) {
        this.f16950f = hVar.A();
        this.f16948c = new x0(hVar.l(z));
    }

    @Override // org.bouncycastle.asn1.l, org.bouncycastle.asn1.e
    public q c() {
        return this.f16948c;
    }

    public synchronized h f() {
        if (this.f16950f == null) {
            this.f16950f = this.f16949d.k(this.f16948c.o()).A();
        }
        return this.f16950f;
    }
}
