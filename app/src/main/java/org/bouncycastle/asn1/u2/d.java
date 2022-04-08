package org.bouncycastle.asn1.u2;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;

/* loaded from: classes4.dex */
public class d extends l {

    /* renamed from: c  reason: collision with root package name */
    private final j f16931c;

    /* renamed from: d  reason: collision with root package name */
    private final j f16932d;

    /* renamed from: f  reason: collision with root package name */
    private final j f16933f;
    private final j q;
    private final f x;

    public d(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, f fVar) {
        if (bigInteger == null) {
            throw new IllegalArgumentException("'p' cannot be null");
        } else if (bigInteger2 == null) {
            throw new IllegalArgumentException("'g' cannot be null");
        } else if (bigInteger3 != null) {
            this.f16931c = new j(bigInteger);
            this.f16932d = new j(bigInteger2);
            this.f16933f = new j(bigInteger3);
            this.q = bigInteger4 != null ? new j(bigInteger4) : null;
            this.x = fVar;
        } else {
            throw new IllegalArgumentException("'q' cannot be null");
        }
    }

    private d(r rVar) {
        if (rVar.size() < 3 || rVar.size() > 5) {
            throw new IllegalArgumentException("Bad sequence size: " + rVar.size());
        }
        Enumeration q = rVar.q();
        this.f16931c = j.m(q.nextElement());
        this.f16932d = j.m(q.nextElement());
        this.f16933f = j.m(q.nextElement());
        e i = i(q);
        if (i == null || !(i instanceof j)) {
            this.q = null;
        } else {
            this.q = j.m(i);
            i = i(q);
        }
        if (i != null) {
            this.x = f.f(i.c());
        } else {
            this.x = null;
        }
    }

    public static d g(Object obj) {
        if (obj instanceof d) {
            return (d) obj;
        }
        if (obj != null) {
            return new d(r.m(obj));
        }
        return null;
    }

    private static e i(Enumeration enumeration) {
        if (enumeration.hasMoreElements()) {
            return (e) enumeration.nextElement();
        }
        return null;
    }

    @Override // org.bouncycastle.asn1.l, org.bouncycastle.asn1.e
    public q c() {
        f fVar = new f();
        fVar.a(this.f16931c);
        fVar.a(this.f16932d);
        fVar.a(this.f16933f);
        j jVar = this.q;
        if (jVar != null) {
            fVar.a(jVar);
        }
        f fVar2 = this.x;
        if (fVar2 != null) {
            fVar.a(fVar2);
        }
        return new b1(fVar);
    }

    public BigInteger f() {
        return this.f16932d.o();
    }

    public BigInteger h() {
        j jVar = this.q;
        if (jVar == null) {
            return null;
        }
        return jVar.o();
    }

    public BigInteger j() {
        return this.f16931c.o();
    }

    public BigInteger k() {
        return this.f16933f.o();
    }

    public f l() {
        return this.x;
    }
}
