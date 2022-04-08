package org.bouncycastle.asn1.n2;

import java.math.BigInteger;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.g1;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.m2.b;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.v0;
import org.bouncycastle.asn1.x;
import org.bouncycastle.asn1.x509.a;

/* loaded from: classes4.dex */
public class k extends l {

    /* renamed from: c  reason: collision with root package name */
    public static final a f16836c;

    /* renamed from: d  reason: collision with root package name */
    public static final a f16837d;

    /* renamed from: f  reason: collision with root package name */
    public static final j f16838f = new j(20);
    public static final j q = new j(1);
    private j p0;
    private a x;
    private a y;
    private j z;

    static {
        a aVar = new a(b.i, v0.f16957c);
        f16836c = aVar;
        f16837d = new a(g.I, aVar);
    }

    public k() {
        this.x = f16836c;
        this.y = f16837d;
        this.z = f16838f;
        this.p0 = q;
    }

    private k(r rVar) {
        this.x = f16836c;
        this.y = f16837d;
        this.z = f16838f;
        this.p0 = q;
        for (int i = 0; i != rVar.size(); i++) {
            x xVar = (x) rVar.p(i);
            int p = xVar.p();
            if (p == 0) {
                this.x = a.h(xVar, true);
            } else if (p == 1) {
                this.y = a.h(xVar, true);
            } else if (p == 2) {
                this.z = j.n(xVar, true);
            } else if (p == 3) {
                this.p0 = j.n(xVar, true);
            } else {
                throw new IllegalArgumentException("unknown tag");
            }
        }
    }

    public k(a aVar, a aVar2, j jVar, j jVar2) {
        this.x = aVar;
        this.y = aVar2;
        this.z = jVar;
        this.p0 = jVar2;
    }

    public static k g(Object obj) {
        if (obj instanceof k) {
            return (k) obj;
        }
        if (obj != null) {
            return new k(r.m(obj));
        }
        return null;
    }

    @Override // org.bouncycastle.asn1.l, org.bouncycastle.asn1.e
    public q c() {
        f fVar = new f();
        if (!this.x.equals(f16836c)) {
            fVar.a(new g1(true, 0, this.x));
        }
        if (!this.y.equals(f16837d)) {
            fVar.a(new g1(true, 1, this.y));
        }
        if (!this.z.equals(f16838f)) {
            fVar.a(new g1(true, 2, this.z));
        }
        if (!this.p0.equals(q)) {
            fVar.a(new g1(true, 3, this.p0));
        }
        return new b1(fVar);
    }

    public a f() {
        return this.x;
    }

    public a h() {
        return this.y;
    }

    public BigInteger i() {
        return this.z.p();
    }
}
