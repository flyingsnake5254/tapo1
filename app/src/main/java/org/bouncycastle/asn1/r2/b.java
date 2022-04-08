package org.bouncycastle.asn1.r2;

import java.math.BigInteger;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.g1;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.n;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x;
import org.bouncycastle.util.a;

/* loaded from: classes4.dex */
public class b extends l {

    /* renamed from: c  reason: collision with root package name */
    BigInteger f16884c;

    /* renamed from: d  reason: collision with root package name */
    a f16885d;

    /* renamed from: f  reason: collision with root package name */
    j f16886f;
    n q;
    j x;
    n y;

    private b(r rVar) {
        this.f16884c = BigInteger.valueOf(0L);
        int i = 0;
        if (rVar.p(0) instanceof x) {
            x xVar = (x) rVar.p(0);
            if (!xVar.q() || xVar.p() != 0) {
                throw new IllegalArgumentException("object parse error");
            }
            this.f16884c = j.m(xVar.b()).p();
            i = 1;
        }
        this.f16885d = a.f(rVar.p(i));
        int i2 = i + 1;
        this.f16886f = j.m(rVar.p(i2));
        int i3 = i2 + 1;
        this.q = n.m(rVar.p(i3));
        int i4 = i3 + 1;
        this.x = j.m(rVar.p(i4));
        this.y = n.m(rVar.p(i4 + 1));
    }

    public static b j(Object obj) {
        if (obj instanceof b) {
            return (b) obj;
        }
        if (obj != null) {
            return new b(r.m(obj));
        }
        return null;
    }

    @Override // org.bouncycastle.asn1.l, org.bouncycastle.asn1.e
    public q c() {
        f fVar = new f();
        if (this.f16884c.compareTo(BigInteger.valueOf(0L)) != 0) {
            fVar.a(new g1(true, 0, new j(this.f16884c)));
        }
        fVar.a(this.f16885d);
        fVar.a(this.f16886f);
        fVar.a(this.q);
        fVar.a(this.x);
        fVar.a(this.y);
        return new b1(fVar);
    }

    public BigInteger f() {
        return this.f16886f.p();
    }

    public byte[] g() {
        return a.g(this.q.o());
    }

    public a h() {
        return this.f16885d;
    }

    public byte[] i() {
        return a.g(this.y.o());
    }

    public BigInteger k() {
        return this.x.p();
    }
}
