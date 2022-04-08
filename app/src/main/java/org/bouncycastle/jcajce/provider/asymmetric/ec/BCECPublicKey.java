package org.bouncycastle.jcajce.provider.asymmetric.ec;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.u2.h;
import org.bouncycastle.asn1.u2.l;
import org.bouncycastle.asn1.u2.o;
import org.bouncycastle.asn1.u2.p;
import org.bouncycastle.asn1.x0;
import org.bouncycastle.asn1.x509.w;
import org.bouncycastle.crypto.w.n;
import org.bouncycastle.crypto.w.s;
import org.bouncycastle.jcajce.provider.asymmetric.util.a;
import org.bouncycastle.jcajce.provider.asymmetric.util.c;
import org.bouncycastle.jcajce.provider.config.b;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.d;
import org.bouncycastle.jce.spec.f;

/* loaded from: classes4.dex */
public class BCECPublicKey implements ECPublicKey, org.bouncycastle.jce.interfaces.ECPublicKey {
    static final long serialVersionUID = 2422789860422731812L;
    private String algorithm;
    private transient b configuration;
    private transient s ecPublicKey;
    private transient ECParameterSpec ecSpec;
    private boolean withCompression;

    public BCECPublicKey(String str, ECPublicKeySpec eCPublicKeySpec, b bVar) {
        this.algorithm = "EC";
        this.algorithm = str;
        ECParameterSpec params = eCPublicKeySpec.getParams();
        this.ecSpec = params;
        this.ecPublicKey = new s(a.e(params, eCPublicKeySpec.getW(), false), a.k(bVar, eCPublicKeySpec.getParams()));
        this.configuration = bVar;
    }

    BCECPublicKey(String str, w wVar, b bVar) {
        this.algorithm = "EC";
        this.algorithm = str;
        this.configuration = bVar;
        populateFromPubKeyInfo(wVar);
    }

    public BCECPublicKey(String str, s sVar, ECParameterSpec eCParameterSpec, b bVar) {
        this.algorithm = "EC";
        n b2 = sVar.b();
        this.algorithm = str;
        this.ecPublicKey = sVar;
        if (eCParameterSpec == null) {
            this.ecSpec = createSpec(a.a(b2.a(), b2.f()), b2);
        } else {
            this.ecSpec = eCParameterSpec;
        }
        this.configuration = bVar;
    }

    public BCECPublicKey(String str, s sVar, b bVar) {
        this.algorithm = "EC";
        this.algorithm = str;
        this.ecPublicKey = sVar;
        this.ecSpec = null;
        this.configuration = bVar;
    }

    public BCECPublicKey(String str, s sVar, d dVar, b bVar) {
        this.algorithm = "EC";
        n b2 = sVar.b();
        this.algorithm = str;
        this.ecSpec = dVar == null ? createSpec(a.a(b2.a(), b2.f()), b2) : a.g(a.a(dVar.a(), dVar.e()), dVar);
        this.ecPublicKey = sVar;
        this.configuration = bVar;
    }

    public BCECPublicKey(String str, BCECPublicKey bCECPublicKey) {
        this.algorithm = "EC";
        this.algorithm = str;
        this.ecPublicKey = bCECPublicKey.ecPublicKey;
        this.ecSpec = bCECPublicKey.ecSpec;
        this.withCompression = bCECPublicKey.withCompression;
        this.configuration = bCECPublicKey.configuration;
    }

    public BCECPublicKey(String str, f fVar, b bVar) {
        this.algorithm = "EC";
        this.algorithm = str;
        throw null;
    }

    public BCECPublicKey(ECPublicKey eCPublicKey, b bVar) {
        this.algorithm = "EC";
        this.algorithm = eCPublicKey.getAlgorithm();
        ECParameterSpec params = eCPublicKey.getParams();
        this.ecSpec = params;
        this.ecPublicKey = new s(a.e(params, eCPublicKey.getW(), false), a.k(bVar, eCPublicKey.getParams()));
    }

    private ECParameterSpec createSpec(EllipticCurve ellipticCurve, n nVar) {
        return new ECParameterSpec(ellipticCurve, a.d(nVar.b()), nVar.e(), nVar.c().intValue());
    }

    private void populateFromPubKeyInfo(w wVar) {
        h f2 = h.f(wVar.f().i());
        e.a.b.a.d j = a.j(this.configuration, f2);
        this.ecSpec = a.i(f2, j);
        byte[] o = wVar.i().o();
        org.bouncycastle.asn1.n x0Var = new x0(o);
        if (o[0] == 4 && o[1] == o.length - 2 && ((o[2] == 2 || o[2] == 3) && new o().a(j) >= o.length - 3)) {
            try {
                x0Var = (org.bouncycastle.asn1.n) q.i(o);
            } catch (IOException unused) {
                throw new IllegalArgumentException("error recovering public key");
            }
        }
        this.ecPublicKey = new s(new l(j, x0Var).f(), org.bouncycastle.jcajce.provider.asymmetric.util.b.e(this.configuration, f2));
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.configuration = BouncyCastleProvider.CONFIGURATION;
        populateFromPubKeyInfo(w.h(q.i((byte[]) objectInputStream.readObject())));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    s engineGetKeyParameters() {
        return this.ecPublicKey;
    }

    d engineGetSpec() {
        ECParameterSpec eCParameterSpec = this.ecSpec;
        return eCParameterSpec != null ? a.h(eCParameterSpec, this.withCompression) : this.configuration.b();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BCECPublicKey)) {
            return false;
        }
        BCECPublicKey bCECPublicKey = (BCECPublicKey) obj;
        return this.ecPublicKey.c().e(bCECPublicKey.ecPublicKey.c()) && engineGetSpec().equals(bCECPublicKey.engineGetSpec());
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.algorithm;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return c.d(new w(new org.bouncycastle.asn1.x509.a(p.B2, a.a(this.ecSpec, this.withCompression)), org.bouncycastle.asn1.n.m(new l(this.ecPublicKey.c(), this.withCompression).c()).o()));
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // org.bouncycastle.jce.interfaces.ECPublicKey
    public d getParameters() {
        ECParameterSpec eCParameterSpec = this.ecSpec;
        if (eCParameterSpec == null) {
            return null;
        }
        return a.h(eCParameterSpec, this.withCompression);
    }

    @Override // java.security.interfaces.ECKey
    public ECParameterSpec getParams() {
        return this.ecSpec;
    }

    @Override // org.bouncycastle.jce.interfaces.ECPublicKey
    public e.a.b.a.h getQ() {
        e.a.b.a.h c2 = this.ecPublicKey.c();
        return this.ecSpec == null ? c2.k() : c2;
    }

    @Override // java.security.interfaces.ECPublicKey
    public ECPoint getW() {
        return a.d(this.ecPublicKey.c());
    }

    public int hashCode() {
        return this.ecPublicKey.c().hashCode() ^ engineGetSpec().hashCode();
    }

    public void setPointFormat(String str) {
        this.withCompression = !"UNCOMPRESSED".equalsIgnoreCase(str);
    }

    public String toString() {
        return org.bouncycastle.jcajce.provider.asymmetric.util.b.k("EC", this.ecPublicKey.c(), engineGetSpec());
    }
}
