package org.bouncycastle.asn1.x509;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;

/* loaded from: classes4.dex */
public class j extends l {

    /* renamed from: c  reason: collision with root package name */
    org.bouncycastle.asn1.j f17010c;

    /* renamed from: d  reason: collision with root package name */
    org.bouncycastle.asn1.j f17011d;

    /* renamed from: f  reason: collision with root package name */
    org.bouncycastle.asn1.j f17012f;

    public j(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f17010c = new org.bouncycastle.asn1.j(bigInteger);
        this.f17011d = new org.bouncycastle.asn1.j(bigInteger2);
        this.f17012f = new org.bouncycastle.asn1.j(bigInteger3);
    }

    private j(r rVar) {
        if (rVar.size() == 3) {
            Enumeration q = rVar.q();
            this.f17010c = org.bouncycastle.asn1.j.m(q.nextElement());
            this.f17011d = org.bouncycastle.asn1.j.m(q.nextElement());
            this.f17012f = org.bouncycastle.asn1.j.m(q.nextElement());
            return;
        }
        throw new IllegalArgumentException("Bad sequence size: " + rVar.size());
    }

    public static j g(Object obj) {
        if (obj instanceof j) {
            return (j) obj;
        }
        if (obj != null) {
            return new j(r.m(obj));
        }
        return null;
    }

    @Override // org.bouncycastle.asn1.l, org.bouncycastle.asn1.e
    public q c() {
        f fVar = new f();
        fVar.a(this.f17010c);
        fVar.a(this.f17011d);
        fVar.a(this.f17012f);
        return new b1(fVar);
    }

    public BigInteger f() {
        return this.f17012f.o();
    }

    public BigInteger h() {
        return this.f17010c.o();
    }

    public BigInteger i() {
        return this.f17011d.o();
    }
}
