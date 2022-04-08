package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.n0;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.t2.c;

/* loaded from: classes4.dex */
public class h extends l {

    /* renamed from: c  reason: collision with root package name */
    r f17004c;

    /* renamed from: d  reason: collision with root package name */
    y f17005d;

    /* renamed from: f  reason: collision with root package name */
    a f17006f;
    n0 q;

    private h(r rVar) {
        this.f17004c = rVar;
        if (rVar.size() == 3) {
            this.f17005d = y.h(rVar.p(0));
            this.f17006f = a.g(rVar.p(1));
            this.q = n0.s(rVar.p(2));
            return;
        }
        throw new IllegalArgumentException("sequence wrong size for a certificate");
    }

    public static h g(Object obj) {
        if (obj instanceof h) {
            return (h) obj;
        }
        if (obj != null) {
            return new h(r.m(obj));
        }
        return null;
    }

    @Override // org.bouncycastle.asn1.l, org.bouncycastle.asn1.e
    public q c() {
        return this.f17004c;
    }

    public z f() {
        return this.f17005d.f();
    }

    public c h() {
        return this.f17005d.i();
    }

    public j i() {
        return this.f17005d.k();
    }

    public n0 j() {
        return this.q;
    }

    public a k() {
        return this.f17006f;
    }

    public z l() {
        return this.f17005d.m();
    }

    public c m() {
        return this.f17005d.n();
    }

    public w n() {
        return this.f17005d.o();
    }

    public y o() {
        return this.f17005d;
    }

    public int p() {
        return this.f17005d.q();
    }
}
