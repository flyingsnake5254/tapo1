package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.g1;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x;

/* loaded from: classes4.dex */
public class q extends l {

    /* renamed from: c  reason: collision with root package name */
    r f17024c;

    /* renamed from: d  reason: collision with root package name */
    p f17025d;

    /* renamed from: f  reason: collision with root package name */
    u f17026f;
    private int q;

    private q(r rVar) {
        this.q = 1;
        if (rVar.size() <= 3) {
            for (int i = 0; i != rVar.size(); i++) {
                x m = x.m(rVar.p(i));
                int p = m.p();
                if (p == 0) {
                    this.f17024c = r.g(m, false);
                } else if (p == 1) {
                    this.f17025d = p.g(m, false);
                } else if (p == 2) {
                    this.f17026f = u.g(m, false);
                } else {
                    throw new IllegalArgumentException("unknown tag in Holder");
                }
            }
            this.q = 1;
            return;
        }
        throw new IllegalArgumentException("Bad sequence size: " + rVar.size());
    }

    private q(x xVar) {
        this.q = 1;
        int p = xVar.p();
        if (p == 0) {
            this.f17024c = r.g(xVar, true);
        } else if (p == 1) {
            this.f17025d = p.g(xVar, true);
        } else {
            throw new IllegalArgumentException("unknown tag in Holder");
        }
        this.q = 0;
    }

    public static q f(Object obj) {
        if (obj instanceof q) {
            return (q) obj;
        }
        if (obj instanceof x) {
            return new q(x.m(obj));
        }
        if (obj != null) {
            return new q(r.m(obj));
        }
        return null;
    }

    @Override // org.bouncycastle.asn1.l, org.bouncycastle.asn1.e
    public org.bouncycastle.asn1.q c() {
        if (this.q != 1) {
            return this.f17025d != null ? new g1(true, 1, this.f17025d) : new g1(true, 0, this.f17024c);
        }
        f fVar = new f();
        if (this.f17024c != null) {
            fVar.a(new g1(false, 0, this.f17024c));
        }
        if (this.f17025d != null) {
            fVar.a(new g1(false, 1, this.f17025d));
        }
        if (this.f17026f != null) {
            fVar.a(new g1(false, 2, this.f17026f));
        }
        return new b1(fVar);
    }
}
