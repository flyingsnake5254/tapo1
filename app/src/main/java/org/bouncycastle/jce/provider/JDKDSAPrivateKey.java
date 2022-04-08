package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPrivateKey;
import java.security.spec.DSAParameterSpec;
import java.security.spec.DSAPrivateKeySpec;
import java.util.Enumeration;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.n2.h;
import org.bouncycastle.asn1.u2.p;
import org.bouncycastle.asn1.x509.a;
import org.bouncycastle.asn1.x509.j;
import org.bouncycastle.crypto.w.k;
import org.bouncycastle.jcajce.provider.asymmetric.util.d;
import org.bouncycastle.jce.interfaces.b;

/* loaded from: classes4.dex */
public class JDKDSAPrivateKey implements DSAPrivateKey, b {
    private static final long serialVersionUID = -4677259546958385734L;
    private d attrCarrier = new d();
    DSAParams dsaSpec;
    BigInteger x;

    protected JDKDSAPrivateKey() {
    }

    JDKDSAPrivateKey(DSAPrivateKey dSAPrivateKey) {
        this.x = dSAPrivateKey.getX();
        this.dsaSpec = dSAPrivateKey.getParams();
    }

    JDKDSAPrivateKey(DSAPrivateKeySpec dSAPrivateKeySpec) {
        this.x = dSAPrivateKeySpec.getX();
        this.dsaSpec = new DSAParameterSpec(dSAPrivateKeySpec.getP(), dSAPrivateKeySpec.getQ(), dSAPrivateKeySpec.getG());
    }

    JDKDSAPrivateKey(h hVar) throws IOException {
        j g = j.g(hVar.h().i());
        this.x = org.bouncycastle.asn1.j.m(hVar.i()).p();
        this.dsaSpec = new DSAParameterSpec(g.h(), g.i(), g.f());
    }

    JDKDSAPrivateKey(k kVar) {
        throw null;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.x = (BigInteger) objectInputStream.readObject();
        this.dsaSpec = new DSAParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject());
        d dVar = new d();
        this.attrCarrier = dVar;
        dVar.a(objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.x);
        objectOutputStream.writeObject(this.dsaSpec.getP());
        objectOutputStream.writeObject(this.dsaSpec.getQ());
        objectOutputStream.writeObject(this.dsaSpec.getG());
        this.attrCarrier.b(objectOutputStream);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DSAPrivateKey)) {
            return false;
        }
        DSAPrivateKey dSAPrivateKey = (DSAPrivateKey) obj;
        return getX().equals(dSAPrivateKey.getX()) && getParams().getG().equals(dSAPrivateKey.getParams().getG()) && getParams().getP().equals(dSAPrivateKey.getParams().getP()) && getParams().getQ().equals(dSAPrivateKey.getParams().getQ());
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "DSA";
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
        try {
            return new h(new a(p.l3, new j(this.dsaSpec.getP(), this.dsaSpec.getQ(), this.dsaSpec.getG())), new org.bouncycastle.asn1.j(getX())).e("DER");
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // java.security.interfaces.DSAKey
    public DSAParams getParams() {
        return this.dsaSpec;
    }

    @Override // java.security.interfaces.DSAPrivateKey
    public BigInteger getX() {
        return this.x;
    }

    public int hashCode() {
        return ((getX().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode()) ^ getParams().getQ().hashCode();
    }

    @Override // org.bouncycastle.jce.interfaces.b
    public void setBagAttribute(m mVar, e eVar) {
        this.attrCarrier.setBagAttribute(mVar, eVar);
    }
}
