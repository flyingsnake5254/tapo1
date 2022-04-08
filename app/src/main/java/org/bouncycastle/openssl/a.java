package org.bouncycastle.openssl;

import java.util.Enumeration;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.i1;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x;

/* loaded from: classes4.dex */
public class a {
    private r a;

    /* renamed from: b  reason: collision with root package name */
    private r f17415b;

    /* renamed from: c  reason: collision with root package name */
    private String f17416c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(byte[] bArr) {
        Enumeration q = r.m(bArr).q();
        while (q.hasMoreElements()) {
            e eVar = (e) q.nextElement();
            if (eVar instanceof r) {
                this.a = r.m(eVar);
            } else if (eVar instanceof x) {
                this.f17415b = r.n((x) eVar, false);
            } else if (eVar instanceof i1) {
                this.f17416c = i1.m(eVar).getString();
            }
        }
    }
}
