package org.bouncycastle.jcajce.provider.asymmetric.dh;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.u2.d;
import org.bouncycastle.asn1.u2.f;
import org.bouncycastle.asn1.u2.p;
import org.bouncycastle.asn1.x509.w;
import org.bouncycastle.crypto.w.e;
import org.bouncycastle.crypto.w.g;
import org.bouncycastle.crypto.w.h;
import org.bouncycastle.jcajce.provider.asymmetric.util.c;
import org.bouncycastle.jcajce.spec.a;

/* loaded from: classes4.dex */
public class BCDHPublicKey implements DHPublicKey {
    static final long serialVersionUID = -216691575254424324L;
    private transient g dhPublicKey;
    private transient DHParameterSpec dhSpec;
    private transient w info;
    private BigInteger y;

    BCDHPublicKey(BigInteger bigInteger, DHParameterSpec dHParameterSpec) {
        this.y = bigInteger;
        this.dhSpec = dHParameterSpec;
        this.dhPublicKey = dHParameterSpec instanceof a ? new g(bigInteger, ((a) dHParameterSpec).a()) : new g(bigInteger, new e(dHParameterSpec.getP(), dHParameterSpec.getG()));
    }

    BCDHPublicKey(DHPublicKey dHPublicKey) {
        this.y = dHPublicKey.getY();
        this.dhSpec = dHPublicKey.getParams();
        this.dhPublicKey = new g(this.y, new e(this.dhSpec.getP(), this.dhSpec.getG()));
    }

    BCDHPublicKey(DHPublicKeySpec dHPublicKeySpec) {
        this.y = dHPublicKeySpec.getY();
        this.dhSpec = new DHParameterSpec(dHPublicKeySpec.getP(), dHPublicKeySpec.getG());
        this.dhPublicKey = new g(this.y, new e(dHPublicKeySpec.getP(), dHPublicKeySpec.getG()));
    }

    public BCDHPublicKey(w wVar) {
        this.info = wVar;
        try {
            this.y = ((j) wVar.j()).p();
            r m = r.m(wVar.f().i());
            m f2 = wVar.f().f();
            if (f2.equals(org.bouncycastle.asn1.n2.g.S) || isPKCSParam(m)) {
                org.bouncycastle.asn1.n2.e g = org.bouncycastle.asn1.n2.e.g(m);
                this.dhSpec = g.h() != null ? new DHParameterSpec(g.i(), g.f(), g.h().intValue()) : new DHParameterSpec(g.i(), g.f());
                this.dhPublicKey = new g(this.y, new e(this.dhSpec.getP(), this.dhSpec.getG()));
            } else if (f2.equals(p.t3)) {
                d g2 = d.g(m);
                f l = g2.l();
                if (l != null) {
                    this.dhPublicKey = new g(this.y, new e(g2.j(), g2.f(), g2.k(), g2.h(), new h(l.h(), l.g().intValue())));
                } else {
                    this.dhPublicKey = new g(this.y, new e(g2.j(), g2.f(), g2.k(), g2.h(), null));
                }
                this.dhSpec = new a(this.dhPublicKey.b());
            } else {
                throw new IllegalArgumentException("unknown algorithm type: " + f2);
            }
        } catch (IOException unused) {
            throw new IllegalArgumentException("invalid info structure in DH public key");
        }
    }

    BCDHPublicKey(g gVar) {
        this.y = gVar.c();
        this.dhSpec = new a(gVar.b());
        this.dhPublicKey = gVar;
    }

    private boolean isPKCSParam(r rVar) {
        if (rVar.size() == 2) {
            return true;
        }
        if (rVar.size() > 3) {
            return false;
        }
        return j.m(rVar.p(2)).p().compareTo(BigInteger.valueOf((long) j.m(rVar.p(0)).p().bitLength())) <= 0;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.dhSpec = new DHParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), objectInputStream.readInt());
        this.info = null;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.dhSpec.getP());
        objectOutputStream.writeObject(this.dhSpec.getG());
        objectOutputStream.writeInt(this.dhSpec.getL());
    }

    public g engineGetKeyParameters() {
        return this.dhPublicKey;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DHPublicKey)) {
            return false;
        }
        DHPublicKey dHPublicKey = (DHPublicKey) obj;
        return getY().equals(dHPublicKey.getY()) && getParams().getG().equals(dHPublicKey.getParams().getG()) && getParams().getP().equals(dHPublicKey.getParams().getP()) && getParams().getL() == dHPublicKey.getParams().getL();
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "DH";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        w wVar = this.info;
        if (wVar != null) {
            return c.d(wVar);
        }
        DHParameterSpec dHParameterSpec = this.dhSpec;
        if (!(dHParameterSpec instanceof a) || ((a) dHParameterSpec).b() == null) {
            return c.c(new org.bouncycastle.asn1.x509.a(org.bouncycastle.asn1.n2.g.S, new org.bouncycastle.asn1.n2.e(this.dhSpec.getP(), this.dhSpec.getG(), this.dhSpec.getL()).c()), new j(this.y));
        }
        e a = ((a) this.dhSpec).a();
        h h = a.h();
        f fVar = null;
        if (h == null) {
            fVar = new f(h.b(), h.a());
        }
        return c.c(new org.bouncycastle.asn1.x509.a(p.t3, new d(a.f(), a.b(), a.g(), a.c(), fVar).c()), new j(this.y));
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // javax.crypto.interfaces.DHKey
    public DHParameterSpec getParams() {
        return this.dhSpec;
    }

    @Override // javax.crypto.interfaces.DHPublicKey
    public BigInteger getY() {
        return this.y;
    }

    public int hashCode() {
        return ((getY().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode()) ^ getParams().getL();
    }
}
