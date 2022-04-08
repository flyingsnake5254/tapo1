package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.m2.a;
import org.bouncycastle.asn1.m2.b;
import org.bouncycastle.asn1.x509.w;
import org.bouncycastle.jcajce.provider.asymmetric.util.c;
import org.bouncycastle.jce.interfaces.ElGamalPublicKey;
import org.bouncycastle.jce.spec.h;

/* loaded from: classes4.dex */
public class JCEElGamalPublicKey implements ElGamalPublicKey, DHPublicKey {
    static final long serialVersionUID = 8712728417091216948L;
    private h elSpec;
    private BigInteger y;

    JCEElGamalPublicKey(BigInteger bigInteger, h hVar) {
        this.y = bigInteger;
        this.elSpec = hVar;
    }

    JCEElGamalPublicKey(DHPublicKey dHPublicKey) {
        this.y = dHPublicKey.getY();
        this.elSpec = new h(dHPublicKey.getParams().getP(), dHPublicKey.getParams().getG());
    }

    JCEElGamalPublicKey(DHPublicKeySpec dHPublicKeySpec) {
        this.y = dHPublicKeySpec.getY();
        this.elSpec = new h(dHPublicKeySpec.getP(), dHPublicKeySpec.getG());
    }

    JCEElGamalPublicKey(w wVar) {
        a g = a.g(wVar.f().i());
        try {
            this.y = ((j) wVar.j()).p();
            this.elSpec = new h(g.h(), g.f());
        } catch (IOException unused) {
            throw new IllegalArgumentException("invalid info structure in DSA public key");
        }
    }

    JCEElGamalPublicKey(org.bouncycastle.crypto.w.w wVar) {
        this.y = wVar.c();
        this.elSpec = new h(wVar.b().c(), wVar.b().a());
    }

    JCEElGamalPublicKey(ElGamalPublicKey elGamalPublicKey) {
        this.y = elGamalPublicKey.getY();
        this.elSpec = elGamalPublicKey.getParameters();
    }

    JCEElGamalPublicKey(org.bouncycastle.jce.spec.j jVar) {
        throw null;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.y = (BigInteger) objectInputStream.readObject();
        this.elSpec = new h((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(getY());
        objectOutputStream.writeObject(this.elSpec.b());
        objectOutputStream.writeObject(this.elSpec.a());
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "ElGamal";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return c.c(new org.bouncycastle.asn1.x509.a(b.l, new a(this.elSpec.b(), this.elSpec.a())), new j(this.y));
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // org.bouncycastle.jce.interfaces.ElGamalPublicKey
    public h getParameters() {
        return this.elSpec;
    }

    @Override // javax.crypto.interfaces.DHKey
    public DHParameterSpec getParams() {
        return new DHParameterSpec(this.elSpec.b(), this.elSpec.a());
    }

    @Override // org.bouncycastle.jce.interfaces.ElGamalPublicKey, javax.crypto.interfaces.DHPublicKey
    public BigInteger getY() {
        return this.y;
    }
}
