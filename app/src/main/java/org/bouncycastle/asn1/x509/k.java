package org.bouncycastle.asn1.x509;

import com.tplink.libtpmediastatistics.SSLClient;
import org.bouncycastle.asn1.d;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.g1;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.t;
import org.bouncycastle.asn1.x;
import org.bouncycastle.util.i;

/* loaded from: classes4.dex */
public class k extends l implements d {

    /* renamed from: c  reason: collision with root package name */
    e f17013c;

    /* renamed from: d  reason: collision with root package name */
    int f17014d;

    public k(x xVar) {
        int p = xVar.p();
        this.f17014d = p;
        this.f17013c = p == 0 ? p.g(xVar, false) : t.o(xVar, false);
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

    public static k g(Object obj) {
        if (obj == null || (obj instanceof k)) {
            return (k) obj;
        }
        if (obj instanceof x) {
            return new k((x) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public static k h(x xVar, boolean z) {
        return g(x.n(xVar, true));
    }

    @Override // org.bouncycastle.asn1.l, org.bouncycastle.asn1.e
    public q c() {
        return new g1(false, this.f17014d, this.f17013c);
    }

    public String toString() {
        String str;
        String str2;
        String d2 = i.d();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DistributionPointName: [");
        stringBuffer.append(d2);
        if (this.f17014d == 0) {
            str2 = this.f17013c.toString();
            str = "fullName";
        } else {
            str2 = this.f17013c.toString();
            str = "nameRelativeToCRLIssuer";
        }
        f(stringBuffer, d2, str, str2);
        stringBuffer.append("]");
        stringBuffer.append(d2);
        return stringBuffer.toString();
    }
}
