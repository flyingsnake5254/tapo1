package org.bouncycastle.jcajce.a;

import java.security.AlgorithmParameters;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Signature;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

/* loaded from: classes4.dex */
public interface c {
    CertificateFactory a(String str) throws NoSuchProviderException, CertificateException;

    Signature b(String str) throws NoSuchAlgorithmException, NoSuchProviderException;

    KeyFactory c(String str) throws NoSuchAlgorithmException, NoSuchProviderException;

    MessageDigest d(String str) throws NoSuchAlgorithmException, NoSuchProviderException;

    AlgorithmParameters e(String str) throws NoSuchAlgorithmException, NoSuchProviderException;
}
