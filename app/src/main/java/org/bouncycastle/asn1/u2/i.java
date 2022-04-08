package org.bouncycastle.asn1.u2;

import e.a.b.a.b;
import e.a.b.a.d;
import java.math.BigInteger;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.n;
import org.bouncycastle.asn1.n0;
import org.bouncycastle.asn1.r;

/* loaded from: classes4.dex */
public class i extends l implements p {

    /* renamed from: c  reason: collision with root package name */
    private d f16942c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f16943d;

    /* renamed from: f  reason: collision with root package name */
    private m f16944f;

    public i(d dVar, byte[] bArr) {
        this.f16944f = null;
        this.f16942c = dVar;
        this.f16943d = bArr;
        h();
    }

    public i(n nVar, BigInteger bigInteger, BigInteger bigInteger2, r rVar) {
        int i;
        int i2;
        int i3;
        d eVar;
        this.f16944f = null;
        m f2 = nVar.f();
        this.f16944f = f2;
        if (f2.equals(p.t2)) {
            eVar = new d.f(((j) nVar.h()).p(), new BigInteger(1, n.m(rVar.p(0)).o()), new BigInteger(1, n.m(rVar.p(1)).o()), bigInteger, bigInteger2);
        } else if (this.f16944f.equals(p.u2)) {
            r m = r.m(nVar.h());
            int intValue = ((j) m.p(0)).p().intValue();
            m mVar = (m) m.p(1);
            if (mVar.equals(p.w2)) {
                i3 = j.m(m.p(2)).p().intValue();
                i2 = 0;
                i = 0;
            } else if (mVar.equals(p.x2)) {
                r m2 = r.m(m.p(2));
                i3 = j.m(m2.p(0)).p().intValue();
                i2 = j.m(m2.p(1)).p().intValue();
                i = j.m(m2.p(2)).p().intValue();
            } else {
                throw new IllegalArgumentException("This type of EC basis is not implemented");
            }
            eVar = new d.e(intValue, i3, i2, i, new BigInteger(1, n.m(rVar.p(0)).o()), new BigInteger(1, n.m(rVar.p(1)).o()), bigInteger, bigInteger2);
        } else {
            throw new IllegalArgumentException("This type of ECCurve is not implemented");
        }
        this.f16942c = eVar;
        if (rVar.size() == 3) {
            this.f16943d = ((n0) rVar.p(2)).o();
        }
    }

    private void h() {
        m mVar;
        if (b.i(this.f16942c)) {
            mVar = p.t2;
        } else if (b.g(this.f16942c)) {
            mVar = p.u2;
        } else {
            throw new IllegalArgumentException("This type of ECCurve is not implemented");
        }
        this.f16944f = mVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0060  */
    @Override // org.bouncycastle.asn1.l, org.bouncycastle.asn1.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.bouncycastle.asn1.q c() {
        /*
            r3 = this;
            org.bouncycastle.asn1.f r0 = new org.bouncycastle.asn1.f
            r0.<init>()
            org.bouncycastle.asn1.m r1 = r3.f16944f
            org.bouncycastle.asn1.m r2 = org.bouncycastle.asn1.u2.p.t2
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0034
            org.bouncycastle.asn1.u2.m r1 = new org.bouncycastle.asn1.u2.m
            e.a.b.a.d r2 = r3.f16942c
            e.a.b.a.e r2 = r2.o()
            r1.<init>(r2)
            org.bouncycastle.asn1.q r1 = r1.c()
            r0.a(r1)
            org.bouncycastle.asn1.u2.m r1 = new org.bouncycastle.asn1.u2.m
            e.a.b.a.d r2 = r3.f16942c
            e.a.b.a.e r2 = r2.p()
            r1.<init>(r2)
        L_0x002c:
            org.bouncycastle.asn1.q r1 = r1.c()
            r0.a(r1)
            goto L_0x005c
        L_0x0034:
            org.bouncycastle.asn1.m r1 = r3.f16944f
            org.bouncycastle.asn1.m r2 = org.bouncycastle.asn1.u2.p.u2
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x005c
            org.bouncycastle.asn1.u2.m r1 = new org.bouncycastle.asn1.u2.m
            e.a.b.a.d r2 = r3.f16942c
            e.a.b.a.e r2 = r2.o()
            r1.<init>(r2)
            org.bouncycastle.asn1.q r1 = r1.c()
            r0.a(r1)
            org.bouncycastle.asn1.u2.m r1 = new org.bouncycastle.asn1.u2.m
            e.a.b.a.d r2 = r3.f16942c
            e.a.b.a.e r2 = r2.p()
            r1.<init>(r2)
            goto L_0x002c
        L_0x005c:
            byte[] r1 = r3.f16943d
            if (r1 == 0) goto L_0x006a
            org.bouncycastle.asn1.n0 r1 = new org.bouncycastle.asn1.n0
            byte[] r2 = r3.f16943d
            r1.<init>(r2)
            r0.a(r1)
        L_0x006a:
            org.bouncycastle.asn1.b1 r1 = new org.bouncycastle.asn1.b1
            r1.<init>(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.asn1.u2.i.c():org.bouncycastle.asn1.q");
    }

    public d f() {
        return this.f16942c;
    }

    public byte[] g() {
        return this.f16943d;
    }
}
