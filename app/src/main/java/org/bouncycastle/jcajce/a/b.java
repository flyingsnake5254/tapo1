package org.bouncycastle.jcajce.a;

import java.security.AlgorithmParameters;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

/* loaded from: classes4.dex */
public class b implements c {
    @Override // org.bouncycastle.jcajce.a.c
    public CertificateFactory a(String str) throws CertificateException {
        return CertificateFactory.getInstance(str);
    }

    @Override // org.bouncycastle.jcajce.a.c
    public Signature b(String str) throws NoSuchAlgorithmException {
        return Signature.getInstance(str);
    }

    @Override // org.bouncycastle.jcajce.a.c
    public KeyFactory c(String str) throws NoSuchAlgorithmException {
        return KeyFactory.getInstance(str);
    }

    @Override // org.bouncycastle.jcajce.a.c
    public MessageDigest d(String str) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance(str);
    }

    @Override // org.bouncycastle.jcajce.a.c
    public AlgorithmParameters e(String str) throws NoSuchAlgorithmException {
        return AlgorithmParameters.getInstance(str);
    }
}
