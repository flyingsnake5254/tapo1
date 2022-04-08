package org.bouncycastle.asn1.p2;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.g1;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.n;
import org.bouncycastle.asn1.n0;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x;
import org.bouncycastle.asn1.x0;

/* loaded from: classes4.dex */
public class b extends l {

    /* renamed from: c  reason: collision with root package name */
    private r f16856c;

    public b(BigInteger bigInteger, e eVar) {
        this(bigInteger, null, eVar);
    }

    public b(BigInteger bigInteger, n0 n0Var, e eVar) {
        byte[] b2 = org.bouncycastle.util.b.b(bigInteger);
        f fVar = new f();
        fVar.a(new j(1L));
        fVar.a(new x0(b2));
        if (eVar != null) {
            fVar.a(new g1(true, 0, eVar));
        }
        if (n0Var != null) {
            fVar.a(new g1(true, 1, n0Var));
        }
        this.f16856c = new b1(fVar);
    }

    public b(r rVar) {
        this.f16856c = rVar;
    }

    private q g(int i) {
        Enumeration q = this.f16856c.q();
        while (q.hasMoreElements()) {
            e eVar = (e) q.nextElement();
            if (eVar instanceof x) {
                x xVar = (x) eVar;
                if (xVar.p() == i) {
                    return xVar.o().c();
                }
            }
        }
        return null;
    }

    @Override // org.bouncycastle.asn1.l, org.bouncycastle.asn1.e
    public q c() {
        return this.f16856c;
    }

    public BigInteger f() {
        return new BigInteger(1, ((n) this.f16856c.p(1)).o());
    }

    public n0 h() {
        return (n0) g(1);
    }
}
