package org.bouncycastle.cert.jcajce;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import org.bouncycastle.asn1.x509.h;
import org.bouncycastle.cert.X509CertificateHolder;

/* loaded from: classes4.dex */
public class JcaX509CertificateHolder extends X509CertificateHolder {
    public JcaX509CertificateHolder(X509Certificate x509Certificate) throws CertificateEncodingException {
        super(h.g(x509Certificate.getEncoded()));
    }
}
