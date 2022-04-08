package org.bouncycastle.asn1.u2;

import java.math.BigInteger;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.n0;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;

/* loaded from: classes4.dex */
public class f extends l {

    /* renamed from: c  reason: collision with root package name */
    private n0 f16934c;

    /* renamed from: d  reason: collision with root package name */
    private j f16935d;

    private f(r rVar) {
        if (rVar.size() == 2) {
            this.f16934c = n0.s(rVar.p(0));
            this.f16935d = j.m(rVar.p(1));
            return;
        }
        throw new IllegalArgumentException("Bad sequence size: " + rVar.size());
    }

    public f(byte[] bArr, int i) {
        if (bArr != null) {
            this.f16934c = new n0(bArr);
            this.f16935d = new j(i);
            return;
        }
        throw new IllegalArgumentException("'seed' cannot be null");
    }

    public static f f(Object obj) {
        if (obj instanceof f) {
            return (f) obj;
        }
        if (obj != null) {
            return new f(r.m(obj));
        }
        return null;
    }

    @Override // org.bouncycastle.asn1.l, org.bouncycastle.asn1.e
    public q c() {
        org.bouncycastle.asn1.f fVar = new org.bouncycastle.asn1.f();
        fVar.a(this.f16934c);
        fVar.a(this.f16935d);
        return new b1(fVar);
    }

    public BigInteger g() {
        return this.f16935d.o();
    }

    public byte[] h() {
        return this.f16934c.o();
    }
}
