package org.bouncycastle.asn1.c2;

import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.e0;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.i0;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x;

/* loaded from: classes4.dex */
public class b extends l implements a {

    /* renamed from: c  reason: collision with root package name */
    private m f16706c;

    /* renamed from: d  reason: collision with root package name */
    private e f16707d;

    public b(r rVar) {
        if (rVar.size() < 1 || rVar.size() > 2) {
            throw new IllegalArgumentException("Bad sequence size: " + rVar.size());
        }
        this.f16706c = (m) rVar.p(0);
        if (rVar.size() > 1) {
            x xVar = (x) rVar.p(1);
            if (!xVar.q() || xVar.p() != 0) {
                throw new IllegalArgumentException("Bad tag for 'content'");
            }
            this.f16707d = xVar.o();
        }
    }

    public static b f(Object obj) {
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
        fVar.a(this.f16706c);
        e eVar = this.f16707d;
        if (eVar != null) {
            fVar.a(new i0(0, eVar));
        }
        return new e0(fVar);
    }
}
