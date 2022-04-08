package org.bouncycastle.openssl;

import java.io.IOException;
import org.bouncycastle.asn1.i;
import org.bouncycastle.asn1.q;
import org.bouncycastle.cert.X509CertificateHolder;

/* loaded from: classes4.dex */
public class f {
    private final X509CertificateHolder a;

    /* renamed from: b  reason: collision with root package name */
    private final a f17423b;

    public f(byte[] bArr) throws IOException {
        i iVar = new i(bArr);
        this.a = new X509CertificateHolder(iVar.t().d());
        q t = iVar.t();
        if (t != null) {
            this.f17423b = new a(t.d());
        } else {
            this.f17423b = null;
        }
    }
}
