package org.bouncycastle.cert.jcajce;

import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

/* loaded from: classes4.dex */
class b extends a {
    @Override // org.bouncycastle.cert.jcajce.a
    protected CertificateFactory a(String str) throws CertificateException {
        return CertificateFactory.getInstance(str);
    }
}
