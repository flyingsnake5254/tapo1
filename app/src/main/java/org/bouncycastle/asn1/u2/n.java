package org.bouncycastle.asn1.u2;

import java.math.BigInteger;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;

/* loaded from: classes4.dex */
public class n extends l implements p {

    /* renamed from: c  reason: collision with root package name */
    private m f16953c;

    /* renamed from: d  reason: collision with root package name */
    private q f16954d;

    public n(int i, int i2) {
        this(i, i2, 0, 0);
    }

    public n(int i, int i2, int i3, int i4) {
        this.f16953c = p.u2;
        f fVar = new f();
        fVar.a(new j(i));
        if (i3 == 0) {
            if (i4 == 0) {
                fVar.a(p.w2);
                fVar.a(new j(i2));
            } else {
                throw new IllegalArgumentException("inconsistent k values");
            }
        } else if (i3 <= i2 || i4 <= i3) {
            throw new IllegalArgumentException("inconsistent k values");
        } else {
            fVar.a(p.x2);
            f fVar2 = new f();
            fVar2.a(new j(i2));
            fVar2.a(new j(i3));
            fVar2.a(new j(i4));
            fVar.a(new b1(fVar2));
        }
        this.f16954d = new b1(fVar);
    }

    public n(BigInteger bigInteger) {
        this.f16953c = p.t2;
        this.f16954d = new j(bigInteger);
    }

    private n(r rVar) {
        this.f16953c = m.r(rVar.p(0));
        this.f16954d = rVar.p(1).c();
    }

    public static n g(Object obj) {
        if (obj instanceof n) {
            return (n) obj;
        }
        if (obj != null) {
            return new n(r.m(obj));
        }
        return null;
    }

    @Override // org.bouncycastle.asn1.l, org.bouncycastle.asn1.e
    public q c() {
        f fVar = new f();
        fVar.a(this.f16953c);
        fVar.a(this.f16954d);
        return new b1(fVar);
    }

    public m f() {
        return this.f16953c;
    }

    public q h() {
        return this.f16954d;
    }
}
