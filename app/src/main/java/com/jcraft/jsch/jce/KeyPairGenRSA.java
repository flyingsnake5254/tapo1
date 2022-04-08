package com.jcraft.jsch.jce;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/* loaded from: classes2.dex */
public class KeyPairGenRSA implements com.jcraft.jsch.KeyPairGenRSA {

    /* renamed from: c  reason: collision with root package name */
    byte[] f5114c;

    /* renamed from: d  reason: collision with root package name */
    byte[] f5115d;

    /* renamed from: e  reason: collision with root package name */
    byte[] f5116e;
    byte[] ep;
    byte[] eq;
    byte[] n;
    byte[] p;
    byte[] q;

    @Override // com.jcraft.jsch.KeyPairGenRSA
    public byte[] getC() {
        return this.f5114c;
    }

    @Override // com.jcraft.jsch.KeyPairGenRSA
    public byte[] getD() {
        return this.f5115d;
    }

    @Override // com.jcraft.jsch.KeyPairGenRSA
    public byte[] getE() {
        return this.f5116e;
    }

    @Override // com.jcraft.jsch.KeyPairGenRSA
    public byte[] getEP() {
        return this.ep;
    }

    @Override // com.jcraft.jsch.KeyPairGenRSA
    public byte[] getEQ() {
        return this.eq;
    }

    @Override // com.jcraft.jsch.KeyPairGenRSA
    public byte[] getN() {
        return this.n;
    }

    @Override // com.jcraft.jsch.KeyPairGenRSA
    public byte[] getP() {
        return this.p;
    }

    @Override // com.jcraft.jsch.KeyPairGenRSA
    public byte[] getQ() {
        return this.q;
    }

    @Override // com.jcraft.jsch.KeyPairGenRSA
    public void init(int i) throws Exception {
        KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA");
        instance.initialize(i, new SecureRandom());
        KeyPair generateKeyPair = instance.generateKeyPair();
        PublicKey publicKey = generateKeyPair.getPublic();
        PrivateKey privateKey = generateKeyPair.getPrivate();
        RSAPrivateKey rSAPrivateKey = (RSAPrivateKey) privateKey;
        this.f5115d = rSAPrivateKey.getPrivateExponent().toByteArray();
        this.f5116e = ((RSAPublicKey) publicKey).getPublicExponent().toByteArray();
        this.n = rSAPrivateKey.getModulus().toByteArray();
        RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) privateKey;
        this.f5114c = rSAPrivateCrtKey.getCrtCoefficient().toByteArray();
        this.ep = rSAPrivateCrtKey.getPrimeExponentP().toByteArray();
        this.eq = rSAPrivateCrtKey.getPrimeExponentQ().toByteArray();
        this.p = rSAPrivateCrtKey.getPrimeP().toByteArray();
        this.q = rSAPrivateCrtKey.getPrimeQ().toByteArray();
    }
}
