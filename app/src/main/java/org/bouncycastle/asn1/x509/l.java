package org.bouncycastle.asn1.x509;

import java.io.IOException;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.c;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.n;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;

/* loaded from: classes4.dex */
public class l extends org.bouncycastle.asn1.l {
    private m c4;
    private boolean d4;
    private n e4;

    /* renamed from: c  reason: collision with root package name */
    public static final m f17015c = new m("2.5.29.9").t();

    /* renamed from: d  reason: collision with root package name */
    public static final m f17016d = new m("2.5.29.14").t();

    /* renamed from: f  reason: collision with root package name */
    public static final m f17017f = new m("2.5.29.15").t();
    public static final m q = new m("2.5.29.16").t();
    public static final m x = new m("2.5.29.17").t();
    public static final m y = new m("2.5.29.18").t();
    public static final m z = new m("2.5.29.19").t();
    public static final m p0 = new m("2.5.29.20").t();
    public static final m p1 = new m("2.5.29.21").t();
    public static final m p2 = new m("2.5.29.23").t();
    public static final m p3 = new m("2.5.29.24").t();
    public static final m H3 = new m("2.5.29.27").t();
    public static final m I3 = new m("2.5.29.28").t();
    public static final m J3 = new m("2.5.29.29").t();
    public static final m K3 = new m("2.5.29.30").t();
    public static final m L3 = new m("2.5.29.31").t();
    public static final m M3 = new m("2.5.29.32").t();
    public static final m N3 = new m("2.5.29.33").t();
    public static final m O3 = new m("2.5.29.35").t();
    public static final m P3 = new m("2.5.29.36").t();
    public static final m Q3 = new m("2.5.29.37").t();
    public static final m R3 = new m("2.5.29.46").t();
    public static final m S3 = new m("2.5.29.54").t();
    public static final m T3 = new m("1.3.6.1.5.5.7.1.1").t();
    public static final m U3 = new m("1.3.6.1.5.5.7.1.11").t();
    public static final m V3 = new m("1.3.6.1.5.5.7.1.12").t();
    public static final m W3 = new m("1.3.6.1.5.5.7.1.2").t();
    public static final m X3 = new m("1.3.6.1.5.5.7.1.3").t();
    public static final m Y3 = new m("1.3.6.1.5.5.7.1.4").t();
    public static final m Z3 = new m("2.5.29.56").t();
    public static final m a4 = new m("2.5.29.55").t();
    public static final m b4 = new m("2.5.29.60").t();

    private l(r rVar) {
        e p;
        if (rVar.size() == 2) {
            this.c4 = m.r(rVar.p(0));
            this.d4 = false;
            p = rVar.p(1);
        } else if (rVar.size() == 3) {
            this.c4 = m.r(rVar.p(0));
            this.d4 = c.n(rVar.p(1)).q();
            p = rVar.p(2);
        } else {
            throw new IllegalArgumentException("Bad sequence size: " + rVar.size());
        }
        this.e4 = n.m(p);
    }

    private static q f(l lVar) throws IllegalArgumentException {
        try {
            return q.i(lVar.h().o());
        } catch (IOException e2) {
            throw new IllegalArgumentException("can't convert extension: " + e2);
        }
    }

    public static l i(Object obj) {
        if (obj instanceof l) {
            return (l) obj;
        }
        if (obj != null) {
            return new l(r.m(obj));
        }
        return null;
    }

    @Override // org.bouncycastle.asn1.l, org.bouncycastle.asn1.e
    public q c() {
        f fVar = new f();
        fVar.a(this.c4);
        if (this.d4) {
            fVar.a(c.p(true));
        }
        fVar.a(this.e4);
        return new b1(fVar);
    }

    @Override // org.bouncycastle.asn1.l
    public boolean equals(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return lVar.g().equals(g()) && lVar.h().equals(h()) && lVar.k() == k();
    }

    public m g() {
        return this.c4;
    }

    public n h() {
        return this.e4;
    }

    @Override // org.bouncycastle.asn1.l
    public int hashCode() {
        return k() ? h().hashCode() ^ g().hashCode() : ~(h().hashCode() ^ g().hashCode());
    }

    public e j() {
        return f(this);
    }

    public boolean k() {
        return this.d4;
    }
}
