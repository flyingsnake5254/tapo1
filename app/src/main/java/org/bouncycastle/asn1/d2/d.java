package org.bouncycastle.asn1.d2;

import java.math.BigInteger;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.q;

/* loaded from: classes4.dex */
public class d extends l {

    /* renamed from: c  reason: collision with root package name */
    int f16722c;

    /* renamed from: d  reason: collision with root package name */
    j f16723d;

    /* renamed from: f  reason: collision with root package name */
    j f16724f;
    j q;

    public d(int i, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f16722c = i;
        this.f16723d = new j(bigInteger);
        this.f16724f = new j(bigInteger2);
        this.q = new j(bigInteger3);
    }

    @Override // org.bouncycastle.asn1.l, org.bouncycastle.asn1.e
    public q c() {
        f fVar = new f();
        fVar.a(new j(this.f16722c));
        fVar.a(this.f16723d);
        fVar.a(this.f16724f);
        fVar.a(this.q);
        return new b1(fVar);
    }

    public BigInteger f() {
        return this.q.o();
    }

    public BigInteger g() {
        return this.f16723d.o();
    }

    public BigInteger h() {
        return this.f16724f.o();
    }
}
