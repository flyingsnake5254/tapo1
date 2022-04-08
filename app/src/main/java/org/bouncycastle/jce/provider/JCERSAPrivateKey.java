package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.RSAPrivateKeySpec;
import java.util.Enumeration;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.n2.g;
import org.bouncycastle.asn1.n2.i;
import org.bouncycastle.asn1.v0;
import org.bouncycastle.asn1.x509.a;
import org.bouncycastle.crypto.w.d0;
import org.bouncycastle.jcajce.provider.asymmetric.util.c;
import org.bouncycastle.jcajce.provider.asymmetric.util.d;
import org.bouncycastle.jce.interfaces.b;

/* loaded from: classes4.dex */
public class JCERSAPrivateKey implements RSAPrivateKey, b {
    private static BigInteger ZERO = BigInteger.valueOf(0);
    static final long serialVersionUID = 5110188922551353628L;
    private transient d attrCarrier = new d();
    protected BigInteger modulus;
    protected BigInteger privateExponent;

    /* JADX INFO: Access modifiers changed from: protected */
    public JCERSAPrivateKey() {
    }

    JCERSAPrivateKey(RSAPrivateKey rSAPrivateKey) {
        this.modulus = rSAPrivateKey.getModulus();
        this.privateExponent = rSAPrivateKey.getPrivateExponent();
    }

    JCERSAPrivateKey(RSAPrivateKeySpec rSAPrivateKeySpec) {
        this.modulus = rSAPrivateKeySpec.getModulus();
        this.privateExponent = rSAPrivateKeySpec.getPrivateExponent();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JCERSAPrivateKey(d0 d0Var) {
        this.modulus = d0Var.c();
        this.privateExponent = d0Var.b();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.modulus = (BigInteger) objectInputStream.readObject();
        d dVar = new d();
        this.attrCarrier = dVar;
        dVar.a(objectInputStream);
        this.privateExponent = (BigInteger) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.modulus);
        this.attrCarrier.b(objectOutputStream);
        objectOutputStream.writeObject(this.privateExponent);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof RSAPrivateKey)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        RSAPrivateKey rSAPrivateKey = (RSAPrivateKey) obj;
        return getModulus().equals(rSAPrivateKey.getModulus()) && getPrivateExponent().equals(rSAPrivateKey.getPrivateExponent());
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "RSA";
    }

    @Override // org.bouncycastle.jce.interfaces.b
    public e getBagAttribute(m mVar) {
        return this.attrCarrier.getBagAttribute(mVar);
    }

    @Override // org.bouncycastle.jce.interfaces.b
    public Enumeration getBagAttributeKeys() {
        return this.attrCarrier.getBagAttributeKeys();
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        a aVar = new a(g.B, v0.f16957c);
        BigInteger modulus = getModulus();
        BigInteger bigInteger = ZERO;
        BigInteger privateExponent = getPrivateExponent();
        BigInteger bigInteger2 = ZERO;
        return c.b(aVar, new i(modulus, bigInteger, privateExponent, bigInteger2, bigInteger2, bigInteger2, bigInteger2, bigInteger2));
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // java.security.interfaces.RSAKey
    public BigInteger getModulus() {
        return this.modulus;
    }

    @Override // java.security.interfaces.RSAPrivateKey
    public BigInteger getPrivateExponent() {
        return this.privateExponent;
    }

    public int hashCode() {
        return getModulus().hashCode() ^ getPrivateExponent().hashCode();
    }

    @Override // org.bouncycastle.jce.interfaces.b
    public void setBagAttribute(m mVar, e eVar) {
        this.attrCarrier.setBagAttribute(mVar, eVar);
    }
}
