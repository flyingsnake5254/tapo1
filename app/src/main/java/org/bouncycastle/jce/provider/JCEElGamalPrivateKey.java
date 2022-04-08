package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.Enumeration;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPrivateKeySpec;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.m2.a;
import org.bouncycastle.crypto.w.v;
import org.bouncycastle.jcajce.provider.asymmetric.util.c;
import org.bouncycastle.jcajce.provider.asymmetric.util.d;
import org.bouncycastle.jce.interfaces.ElGamalPrivateKey;
import org.bouncycastle.jce.interfaces.b;
import org.bouncycastle.jce.spec.h;
import org.bouncycastle.jce.spec.i;

/* loaded from: classes4.dex */
public class JCEElGamalPrivateKey implements ElGamalPrivateKey, DHPrivateKey, b {
    static final long serialVersionUID = 4819350091141529678L;
    private d attrCarrier = new d();
    h elSpec;
    BigInteger x;

    protected JCEElGamalPrivateKey() {
    }

    JCEElGamalPrivateKey(DHPrivateKey dHPrivateKey) {
        this.x = dHPrivateKey.getX();
        this.elSpec = new h(dHPrivateKey.getParams().getP(), dHPrivateKey.getParams().getG());
    }

    JCEElGamalPrivateKey(DHPrivateKeySpec dHPrivateKeySpec) {
        this.x = dHPrivateKeySpec.getX();
        this.elSpec = new h(dHPrivateKeySpec.getP(), dHPrivateKeySpec.getG());
    }

    JCEElGamalPrivateKey(org.bouncycastle.asn1.n2.h hVar) throws IOException {
        a g = a.g(hVar.h().i());
        this.x = j.m(hVar.i()).p();
        this.elSpec = new h(g.h(), g.f());
    }

    JCEElGamalPrivateKey(v vVar) {
        throw null;
    }

    JCEElGamalPrivateKey(ElGamalPrivateKey elGamalPrivateKey) {
        this.x = elGamalPrivateKey.getX();
        this.elSpec = elGamalPrivateKey.getParameters();
    }

    JCEElGamalPrivateKey(i iVar) {
        throw null;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.x = (BigInteger) objectInputStream.readObject();
        this.elSpec = new h((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(getX());
        objectOutputStream.writeObject(this.elSpec.b());
        objectOutputStream.writeObject(this.elSpec.a());
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "ElGamal";
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
        return c.b(new org.bouncycastle.asn1.x509.a(org.bouncycastle.asn1.m2.b.l, new a(this.elSpec.b(), this.elSpec.a())), new j(getX()));
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // org.bouncycastle.jce.interfaces.ElGamalPrivateKey
    public h getParameters() {
        return this.elSpec;
    }

    @Override // javax.crypto.interfaces.DHKey
    public DHParameterSpec getParams() {
        return new DHParameterSpec(this.elSpec.b(), this.elSpec.a());
    }

    @Override // org.bouncycastle.jce.interfaces.ElGamalPrivateKey, javax.crypto.interfaces.DHPrivateKey
    public BigInteger getX() {
        return this.x;
    }

    @Override // org.bouncycastle.jce.interfaces.b
    public void setBagAttribute(m mVar, e eVar) {
        this.attrCarrier.setBagAttribute(mVar, eVar);
    }
}
