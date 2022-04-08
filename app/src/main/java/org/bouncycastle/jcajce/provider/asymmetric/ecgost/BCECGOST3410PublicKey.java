package org.bouncycastle.jcajce.provider.asymmetric.ecgost;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.n0;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.u2.h;
import org.bouncycastle.asn1.u2.j;
import org.bouncycastle.asn1.x0;
import org.bouncycastle.asn1.x509.w;
import org.bouncycastle.crypto.w.n;
import org.bouncycastle.crypto.w.s;
import org.bouncycastle.jcajce.provider.asymmetric.util.a;
import org.bouncycastle.jcajce.provider.config.b;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.c;
import org.bouncycastle.jce.spec.d;
import org.bouncycastle.jce.spec.f;

/* loaded from: classes4.dex */
public class BCECGOST3410PublicKey implements ECPublicKey, org.bouncycastle.jce.interfaces.ECPublicKey {
    static final long serialVersionUID = 7026240464295649314L;
    private String algorithm;
    private transient s ecPublicKey;
    private transient ECParameterSpec ecSpec;
    private transient e gostParams;
    private boolean withCompression;

    public BCECGOST3410PublicKey(String str, s sVar) {
        this.algorithm = "ECGOST3410";
        this.algorithm = str;
        this.ecPublicKey = sVar;
        this.ecSpec = null;
    }

    public BCECGOST3410PublicKey(String str, s sVar, ECParameterSpec eCParameterSpec) {
        this.algorithm = "ECGOST3410";
        n b2 = sVar.b();
        this.algorithm = str;
        this.ecPublicKey = sVar;
        if (eCParameterSpec == null) {
            this.ecSpec = createSpec(a.a(b2.a(), b2.f()), b2);
        } else {
            this.ecSpec = eCParameterSpec;
        }
    }

    public BCECGOST3410PublicKey(String str, s sVar, d dVar) {
        this.algorithm = "ECGOST3410";
        n b2 = sVar.b();
        this.algorithm = str;
        this.ecPublicKey = sVar;
        this.ecSpec = dVar == null ? createSpec(a.a(b2.a(), b2.f()), b2) : a.g(a.a(dVar.a(), dVar.e()), dVar);
    }

    public BCECGOST3410PublicKey(ECPublicKey eCPublicKey) {
        this.algorithm = "ECGOST3410";
        this.algorithm = eCPublicKey.getAlgorithm();
        ECParameterSpec params = eCPublicKey.getParams();
        this.ecSpec = params;
        this.ecPublicKey = new s(a.e(params, eCPublicKey.getW(), false), a.k(null, eCPublicKey.getParams()));
    }

    public BCECGOST3410PublicKey(ECPublicKeySpec eCPublicKeySpec) {
        this.algorithm = "ECGOST3410";
        ECParameterSpec params = eCPublicKeySpec.getParams();
        this.ecSpec = params;
        this.ecPublicKey = new s(a.e(params, eCPublicKeySpec.getW(), false), a.k(null, eCPublicKeySpec.getParams()));
    }

    BCECGOST3410PublicKey(w wVar) {
        this.algorithm = "ECGOST3410";
        populateFromPubKeyInfo(wVar);
    }

    public BCECGOST3410PublicKey(BCECGOST3410PublicKey bCECGOST3410PublicKey) {
        this.algorithm = "ECGOST3410";
        this.ecPublicKey = bCECGOST3410PublicKey.ecPublicKey;
        this.ecSpec = bCECGOST3410PublicKey.ecSpec;
        this.withCompression = bCECGOST3410PublicKey.withCompression;
        this.gostParams = bCECGOST3410PublicKey.gostParams;
    }

    public BCECGOST3410PublicKey(f fVar, b bVar) {
        this.algorithm = "ECGOST3410";
        throw null;
    }

    private ECParameterSpec createSpec(EllipticCurve ellipticCurve, n nVar) {
        return new ECParameterSpec(ellipticCurve, a.d(nVar.b()), nVar.e(), nVar.c().intValue());
    }

    private void extractBytes(byte[] bArr, int i, BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length < 32) {
            byte[] bArr2 = new byte[32];
            System.arraycopy(byteArray, 0, bArr2, 32 - byteArray.length, byteArray.length);
            byteArray = bArr2;
        }
        for (int i2 = 0; i2 != 32; i2++) {
            bArr[i + i2] = byteArray[(byteArray.length - 1) - i2];
        }
    }

    private void populateFromPubKeyInfo(w wVar) {
        m mVar;
        n0 i = wVar.i();
        this.algorithm = "ECGOST3410";
        try {
            byte[] o = ((org.bouncycastle.asn1.n) q.i(i.o())).o();
            byte[] bArr = new byte[65];
            bArr[0] = 4;
            for (int i2 = 1; i2 <= 32; i2++) {
                bArr[i2] = o[32 - i2];
                bArr[i2 + 32] = o[64 - i2];
            }
            boolean z = wVar.f().i() instanceof m;
            e i3 = wVar.f().i();
            if (z) {
                mVar = m.r(i3);
                this.gostParams = mVar;
            } else {
                org.bouncycastle.asn1.d2.e h = org.bouncycastle.asn1.d2.e.h(i3);
                this.gostParams = h;
                mVar = h.i();
            }
            org.bouncycastle.jce.spec.b a = e.a.a.a.a(org.bouncycastle.asn1.d2.b.c(mVar));
            e.a.b.a.d a2 = a.a();
            EllipticCurve a3 = a.a(a2, a.e());
            this.ecPublicKey = new s(a2.k(bArr), org.bouncycastle.jcajce.provider.asymmetric.util.b.f(null, a));
            this.ecSpec = new c(org.bouncycastle.asn1.d2.b.c(mVar), a3, a.d(a.b()), a.d(), a.c());
        } catch (IOException unused) {
            throw new IllegalArgumentException("error recovering public key");
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
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
        return eCParameterSpec != null ? a.h(eCParameterSpec, this.withCompression) : BouncyCastleProvider.CONFIGURATION.b();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BCECGOST3410PublicKey)) {
            return false;
        }
        BCECGOST3410PublicKey bCECGOST3410PublicKey = (BCECGOST3410PublicKey) obj;
        return this.ecPublicKey.c().e(bCECGOST3410PublicKey.ecPublicKey.c()) && engineGetSpec().equals(bCECGOST3410PublicKey.engineGetSpec());
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.algorithm;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        e gostParams = getGostParams();
        if (gostParams == null) {
            ECParameterSpec eCParameterSpec = this.ecSpec;
            if (eCParameterSpec instanceof c) {
                gostParams = new org.bouncycastle.asn1.d2.e(org.bouncycastle.asn1.d2.b.d(((c) eCParameterSpec).a()), org.bouncycastle.asn1.d2.a.p);
            } else {
                e.a.b.a.d b2 = a.b(eCParameterSpec.getCurve());
                gostParams = new h(new j(b2, a.f(b2, this.ecSpec.getGenerator(), this.withCompression), this.ecSpec.getOrder(), BigInteger.valueOf(this.ecSpec.getCofactor()), this.ecSpec.getCurve().getSeed()));
            }
        }
        BigInteger t = this.ecPublicKey.c().f().t();
        BigInteger t2 = this.ecPublicKey.c().g().t();
        byte[] bArr = new byte[64];
        extractBytes(bArr, 0, t);
        extractBytes(bArr, 32, t2);
        try {
            return org.bouncycastle.jcajce.provider.asymmetric.util.c.d(new w(new org.bouncycastle.asn1.x509.a(org.bouncycastle.asn1.d2.a.m, gostParams), new x0(bArr)));
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e getGostParams() {
        if (this.gostParams == null) {
            ECParameterSpec eCParameterSpec = this.ecSpec;
            if (eCParameterSpec instanceof c) {
                this.gostParams = new org.bouncycastle.asn1.d2.e(org.bouncycastle.asn1.d2.b.d(((c) eCParameterSpec).a()), org.bouncycastle.asn1.d2.a.p);
            }
        }
        return this.gostParams;
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
        return this.ecSpec == null ? this.ecPublicKey.c().k() : this.ecPublicKey.c();
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
        return org.bouncycastle.jcajce.provider.asymmetric.util.b.k(this.algorithm, this.ecPublicKey.c(), engineGetSpec());
    }
}
