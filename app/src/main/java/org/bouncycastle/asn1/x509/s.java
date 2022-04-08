package org.bouncycastle.asn1.x509;

import com.tplink.libtpmediastatistics.SSLClient;
import org.bouncycastle.asn1.c;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.n0;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x;
import org.bouncycastle.util.i;

/* loaded from: classes4.dex */
public class s extends l {

    /* renamed from: c  reason: collision with root package name */
    private k f17030c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f17031d;

    /* renamed from: f  reason: collision with root package name */
    private boolean f17032f;
    private v q;
    private boolean x;
    private boolean y;
    private r z;

    private s(r rVar) {
        this.z = rVar;
        for (int i = 0; i != rVar.size(); i++) {
            x m = x.m(rVar.p(i));
            int p = m.p();
            if (p == 0) {
                this.f17030c = k.h(m, true);
            } else if (p == 1) {
                this.f17031d = c.o(m, false).q();
            } else if (p == 2) {
                this.f17032f = c.o(m, false).q();
            } else if (p == 3) {
                this.q = new v(n0.t(m, false));
            } else if (p == 4) {
                this.x = c.o(m, false).q();
            } else if (p == 5) {
                this.y = c.o(m, false).q();
            } else {
                throw new IllegalArgumentException("unknown tag in IssuingDistributionPoint");
            }
        }
    }

    private void f(StringBuffer stringBuffer, String str, String str2, String str3) {
        stringBuffer.append("    ");
        stringBuffer.append(str2);
        stringBuffer.append(SSLClient.COLON);
        stringBuffer.append(str);
        stringBuffer.append("    ");
        stringBuffer.append("    ");
        stringBuffer.append(str3);
        stringBuffer.append(str);
    }

    private String g(boolean z) {
        return z ? "true" : "false";
    }

    public static s h(Object obj) {
        if (obj instanceof s) {
            return (s) obj;
        }
        if (obj != null) {
            return new s(r.m(obj));
        }
        return null;
    }

    @Override // org.bouncycastle.asn1.l, org.bouncycastle.asn1.e
    public q c() {
        return this.z;
    }

    public boolean i() {
        return this.x;
    }

    public String toString() {
        String d2 = i.d();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("IssuingDistributionPoint: [");
        stringBuffer.append(d2);
        k kVar = this.f17030c;
        if (kVar != null) {
            f(stringBuffer, d2, "distributionPoint", kVar.toString());
        }
        boolean z = this.f17031d;
        if (z) {
            f(stringBuffer, d2, "onlyContainsUserCerts", g(z));
        }
        boolean z2 = this.f17032f;
        if (z2) {
            f(stringBuffer, d2, "onlyContainsCACerts", g(z2));
        }
        v vVar = this.q;
        if (vVar != null) {
            f(stringBuffer, d2, "onlySomeReasons", vVar.toString());
        }
        boolean z3 = this.y;
        if (z3) {
            f(stringBuffer, d2, "onlyContainsAttributeCerts", g(z3));
        }
        boolean z4 = this.x;
        if (z4) {
            f(stringBuffer, d2, "indirectCRL", g(z4));
        }
        stringBuffer.append("]");
        stringBuffer.append(d2);
        return stringBuffer.toString();
    }
}
