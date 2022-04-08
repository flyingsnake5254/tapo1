package org.bouncycastle.jcajce.provider.asymmetric.gost;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import org.bouncycastle.asn1.d2.e;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x0;
import org.bouncycastle.asn1.x509.w;
import org.bouncycastle.crypto.w.z;
import org.bouncycastle.jcajce.provider.asymmetric.util.c;
import org.bouncycastle.jce.interfaces.GOST3410PublicKey;
import org.bouncycastle.jce.interfaces.a;
import org.bouncycastle.jce.spec.k;
import org.bouncycastle.jce.spec.m;
import org.bouncycastle.jce.spec.n;
import org.bouncycastle.util.i;

/* loaded from: classes4.dex */
public class BCGOST3410PublicKey implements GOST3410PublicKey {
    static final long serialVersionUID = -6251023343619275990L;
    private transient a gost3410Spec;
    private BigInteger y;

    BCGOST3410PublicKey(BigInteger bigInteger, k kVar) {
        this.y = bigInteger;
        this.gost3410Spec = kVar;
    }

    BCGOST3410PublicKey(w wVar) {
        e eVar = new e((r) wVar.g().i());
        try {
            byte[] o = ((x0) wVar.j()).o();
            byte[] bArr = new byte[o.length];
            for (int i = 0; i != o.length; i++) {
                bArr[i] = o[(o.length - 1) - i];
            }
            this.y = new BigInteger(1, bArr);
            this.gost3410Spec = k.e(eVar);
        } catch (IOException unused) {
            throw new IllegalArgumentException("invalid info structure in GOST3410 public key");
        }
    }

    BCGOST3410PublicKey(z zVar, k kVar) {
        throw null;
    }

    BCGOST3410PublicKey(GOST3410PublicKey gOST3410PublicKey) {
        this.y = gOST3410PublicKey.getY();
        this.gost3410Spec = gOST3410PublicKey.getParameters();
    }

    BCGOST3410PublicKey(n nVar) {
        throw null;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        String str = (String) objectInputStream.readObject();
        if (str != null) {
            this.gost3410Spec = new k(str, (String) objectInputStream.readObject(), (String) objectInputStream.readObject());
            return;
        }
        this.gost3410Spec = new k(new m((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject()));
        objectInputStream.readObject();
        objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Object obj;
        objectOutputStream.defaultWriteObject();
        if (this.gost3410Spec.c() != null) {
            obj = this.gost3410Spec.c();
        } else {
            objectOutputStream.writeObject(null);
            objectOutputStream.writeObject(this.gost3410Spec.a().b());
            objectOutputStream.writeObject(this.gost3410Spec.a().c());
            obj = this.gost3410Spec.a().a();
        }
        objectOutputStream.writeObject(obj);
        objectOutputStream.writeObject(this.gost3410Spec.d());
        objectOutputStream.writeObject(this.gost3410Spec.b());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BCGOST3410PublicKey)) {
            return false;
        }
        BCGOST3410PublicKey bCGOST3410PublicKey = (BCGOST3410PublicKey) obj;
        return this.y.equals(bCGOST3410PublicKey.y) && this.gost3410Spec.equals(bCGOST3410PublicKey.gost3410Spec);
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "GOST3410";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        byte[] byteArray = getY().toByteArray();
        byte[] bArr = new byte[byteArray[0] == 0 ? byteArray.length - 1 : byteArray.length];
        for (int i = 0; i != bArr.length; i++) {
            bArr[i] = byteArray[(byteArray.length - 1) - i];
        }
        try {
            a aVar = this.gost3410Spec;
            return c.d(aVar instanceof k ? aVar.b() != null ? new w(new org.bouncycastle.asn1.x509.a(org.bouncycastle.asn1.d2.a.l, new e(new org.bouncycastle.asn1.m(this.gost3410Spec.c()), new org.bouncycastle.asn1.m(this.gost3410Spec.d()), new org.bouncycastle.asn1.m(this.gost3410Spec.b()))), new x0(bArr)) : new w(new org.bouncycastle.asn1.x509.a(org.bouncycastle.asn1.d2.a.l, new e(new org.bouncycastle.asn1.m(this.gost3410Spec.c()), new org.bouncycastle.asn1.m(this.gost3410Spec.d()))), new x0(bArr)) : new w(new org.bouncycastle.asn1.x509.a(org.bouncycastle.asn1.d2.a.l), new x0(bArr)));
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // org.bouncycastle.jce.interfaces.GOST3410PublicKey
    public a getParameters() {
        return this.gost3410Spec;
    }

    @Override // org.bouncycastle.jce.interfaces.GOST3410PublicKey
    public BigInteger getY() {
        return this.y;
    }

    public int hashCode() {
        return this.y.hashCode() ^ this.gost3410Spec.hashCode();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String d2 = i.d();
        stringBuffer.append("GOST3410 Public Key");
        stringBuffer.append(d2);
        stringBuffer.append("            y: ");
        stringBuffer.append(getY().toString(16));
        stringBuffer.append(d2);
        return stringBuffer.toString();
    }
}
