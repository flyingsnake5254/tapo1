package org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import java.util.NoSuchElementException;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.g1;
import org.bouncycastle.asn1.h;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.y;

/* loaded from: classes4.dex */
public class x extends l {

    /* renamed from: c  reason: collision with root package name */
    j f17039c;

    /* renamed from: d  reason: collision with root package name */
    a f17040d;

    /* renamed from: f  reason: collision with root package name */
    org.bouncycastle.asn1.t2.c f17041f;
    z q;
    z x;
    r y;
    m z;

    /* loaded from: classes4.dex */
    public static class b extends l {

        /* renamed from: c  reason: collision with root package name */
        r f17042c;

        /* renamed from: d  reason: collision with root package name */
        m f17043d;

        private b(r rVar) {
            if (rVar.size() < 2 || rVar.size() > 3) {
                throw new IllegalArgumentException("Bad sequence size: " + rVar.size());
            }
            this.f17042c = rVar;
        }

        public static b g(Object obj) {
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
            return this.f17042c;
        }

        public m f() {
            if (this.f17043d == null && this.f17042c.size() == 3) {
                this.f17043d = m.k(this.f17042c.p(2));
            }
            return this.f17043d;
        }

        public j h() {
            return j.m(this.f17042c.p(0));
        }

        public boolean i() {
            return this.f17042c.size() == 3;
        }
    }

    /* loaded from: classes4.dex */
    private class c implements Enumeration {
        private c() {
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return false;
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            throw new NoSuchElementException("Empty Enumeration");
        }
    }

    /* loaded from: classes4.dex */
    private class d implements Enumeration {
        private final Enumeration a;

        d(Enumeration enumeration) {
            this.a = enumeration;
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.a.hasMoreElements();
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            return b.g(this.a.nextElement());
        }
    }

    public x(r rVar) {
        if (rVar.size() < 3 || rVar.size() > 7) {
            throw new IllegalArgumentException("Bad sequence size: " + rVar.size());
        }
        int i = 0;
        if (rVar.p(0) instanceof j) {
            this.f17039c = j.m(rVar.p(0));
            i = 1;
        } else {
            this.f17039c = null;
        }
        int i2 = i + 1;
        this.f17040d = a.g(rVar.p(i));
        int i3 = i2 + 1;
        this.f17041f = org.bouncycastle.asn1.t2.c.f(rVar.p(i2));
        int i4 = i3 + 1;
        this.q = z.g(rVar.p(i3));
        if (i4 < rVar.size() && ((rVar.p(i4) instanceof y) || (rVar.p(i4) instanceof h) || (rVar.p(i4) instanceof z))) {
            i4++;
            this.x = z.g(rVar.p(i4));
        }
        if (i4 < rVar.size() && !(rVar.p(i4) instanceof org.bouncycastle.asn1.x)) {
            i4++;
            this.y = r.m(rVar.p(i4));
        }
        if (i4 < rVar.size() && (rVar.p(i4) instanceof org.bouncycastle.asn1.x)) {
            this.z = m.k(r.n((org.bouncycastle.asn1.x) rVar.p(i4), true));
        }
    }

    public static x g(Object obj) {
        if (obj instanceof x) {
            return (x) obj;
        }
        if (obj != null) {
            return new x(r.m(obj));
        }
        return null;
    }

    @Override // org.bouncycastle.asn1.l, org.bouncycastle.asn1.e
    public q c() {
        f fVar = new f();
        j jVar = this.f17039c;
        if (jVar != null) {
            fVar.a(jVar);
        }
        fVar.a(this.f17040d);
        fVar.a(this.f17041f);
        fVar.a(this.q);
        z zVar = this.x;
        if (zVar != null) {
            fVar.a(zVar);
        }
        r rVar = this.y;
        if (rVar != null) {
            fVar.a(rVar);
        }
        if (this.z != null) {
            fVar.a(new g1(0, this.z));
        }
        return new b1(fVar);
    }

    public m f() {
        return this.z;
    }

    public org.bouncycastle.asn1.t2.c h() {
        return this.f17041f;
    }

    public Enumeration i() {
        r rVar = this.y;
        return rVar == null ? new c() : new d(rVar.q());
    }

    public b[] j() {
        r rVar = this.y;
        if (rVar == null) {
            return new b[0];
        }
        int size = rVar.size();
        b[] bVarArr = new b[size];
        for (int i = 0; i < size; i++) {
            bVarArr[i] = b.g(this.y.p(i));
        }
        return bVarArr;
    }

    public a k() {
        return this.f17040d;
    }
}
