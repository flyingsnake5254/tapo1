package org.bouncycastle.asn1.t2;

import java.util.Enumeration;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.d;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.t2.f.b;
import org.bouncycastle.asn1.x;

/* loaded from: classes4.dex */
public class c extends l implements d {

    /* renamed from: c  reason: collision with root package name */
    private static e f16906c = b.M;

    /* renamed from: d  reason: collision with root package name */
    private boolean f16907d;

    /* renamed from: f  reason: collision with root package name */
    private int f16908f;
    private e q;
    private b[] x;

    public c(String str) {
        this(f16906c, str);
    }

    private c(r rVar) {
        this(f16906c, rVar);
    }

    public c(e eVar, String str) {
        this(eVar.b(str));
        this.q = eVar;
    }

    private c(e eVar, r rVar) {
        this.q = eVar;
        this.x = new b[rVar.size()];
        Enumeration q = rVar.q();
        int i = 0;
        while (q.hasMoreElements()) {
            i++;
            this.x[i] = b.g(q.nextElement());
        }
    }

    public c(e eVar, c cVar) {
        this.x = cVar.x;
        this.q = eVar;
    }

    public c(e eVar, b[] bVarArr) {
        this.x = bVarArr;
        this.q = eVar;
    }

    public c(b[] bVarArr) {
        this(f16906c, bVarArr);
    }

    public static c f(Object obj) {
        if (obj instanceof c) {
            return (c) obj;
        }
        if (obj != null) {
            return new c(r.m(obj));
        }
        return null;
    }

    public static c g(x xVar, boolean z) {
        return f(r.n(xVar, true));
    }

    public static c h(e eVar, Object obj) {
        if (obj instanceof c) {
            return new c(eVar, (c) obj);
        }
        if (obj != null) {
            return new c(eVar, r.m(obj));
        }
        return null;
    }

    @Override // org.bouncycastle.asn1.l, org.bouncycastle.asn1.e
    public q c() {
        return new b1(this.x);
    }

    @Override // org.bouncycastle.asn1.l
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c) && !(obj instanceof r)) {
            return false;
        }
        if (c().equals(((e) obj).c())) {
            return true;
        }
        try {
            return this.q.a(this, new c(r.m(((e) obj).c())));
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // org.bouncycastle.asn1.l
    public int hashCode() {
        if (this.f16907d) {
            return this.f16908f;
        }
        this.f16907d = true;
        int d2 = this.q.d(this);
        this.f16908f = d2;
        return d2;
    }

    public b[] i() {
        b[] bVarArr = this.x;
        int length = bVarArr.length;
        b[] bVarArr2 = new b[length];
        System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
        return bVarArr2;
    }

    public String toString() {
        return this.q.f(this);
    }
}
