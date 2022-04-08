package org.bouncycastle.jcajce.provider.asymmetric.ecgost12;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import org.bouncycastle.asn1.d2.e;
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
public class BCECGOST3410_2012PublicKey implements ECPublicKey, org.bouncycastle.jce.interfaces.ECPublicKey {
    static final long serialVersionUID = 7026240464295649314L;
    private String algorithm;
    private transient s ecPublicKey;
    private transient ECParameterSpec ecSpec;
    private transient e gostParams;
    private boolean withCompression;

    public BCECGOST3410_2012PublicKey(String str, s sVar) {
        this.algorithm = "ECGOST3410-2012";
        this.algorithm = str;
        this.ecPublicKey = sVar;
        this.ecSpec = null;
    }

    public BCECGOST3410_2012PublicKey(String str, s sVar, ECParameterSpec eCParameterSpec) {
        this.algorithm = "ECGOST3410-2012";
        n b2 = sVar.b();
        this.algorithm = str;
        this.ecPublicKey = sVar;
        if (eCParameterSpec == null) {
            this.ecSpec = createSpec(a.a(b2.a(), b2.f()), b2);
        } else {
            this.ecSpec = eCParameterSpec;
        }
    }

    public BCECGOST3410_2012PublicKey(String str, s sVar, d dVar) {
        this.algorithm = "ECGOST3410-2012";
        n b2 = sVar.b();
        this.algorithm = str;
        this.ecPublicKey = sVar;
        this.ecSpec = dVar == null ? createSpec(a.a(b2.a(), b2.f()), b2) : a.g(a.a(dVar.a(), dVar.e()), dVar);
    }

    public BCECGOST3410_2012PublicKey(ECPublicKey eCPublicKey) {
        this.algorithm = "ECGOST3410-2012";
        this.algorithm = eCPublicKey.getAlgorithm();
        ECParameterSpec params = eCPublicKey.getParams();
        this.ecSpec = params;
        this.ecPublicKey = new s(a.e(params, eCPublicKey.getW(), false), a.k(null, eCPublicKey.getParams()));
    }

    public BCECGOST3410_2012PublicKey(ECPublicKeySpec eCPublicKeySpec) {
        this.algorithm = "ECGOST3410-2012";
        ECParameterSpec params = eCPublicKeySpec.getParams();
        this.ecSpec = params;
        this.ecPublicKey = new s(a.e(params, eCPublicKeySpec.getW(), false), a.k(null, eCPublicKeySpec.getParams()));
    }

    BCECGOST3410_2012PublicKey(w wVar) {
        this.algorithm = "ECGOST3410-2012";
        populateFromPubKeyInfo(wVar);
    }

    public BCECGOST3410_2012PublicKey(BCECGOST3410_2012PublicKey bCECGOST3410_2012PublicKey) {
        this.algorithm = "ECGOST3410-2012";
        this.ecPublicKey = bCECGOST3410_2012PublicKey.ecPublicKey;
        this.ecSpec = bCECGOST3410_2012PublicKey.ecSpec;
        this.withCompression = bCECGOST3410_2012PublicKey.withCompression;
        this.gostParams = bCECGOST3410_2012PublicKey.gostParams;
    }

    public BCECGOST3410_2012PublicKey(f fVar, b bVar) {
        this.algorithm = "ECGOST3410-2012";
        throw null;
    }

    private ECParameterSpec createSpec(EllipticCurve ellipticCurve, n nVar) {
        return new ECParameterSpec(ellipticCurve, a.d(nVar.b()), nVar.e(), nVar.c().intValue());
    }

    private void extractBytes(byte[] bArr, int i, int i2, BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length < i) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(byteArray, 0, bArr2, i - byteArray.length, byteArray.length);
            byteArray = bArr2;
        }
        for (int i3 = 0; i3 != i; i3++) {
            bArr[i2 + i3] = byteArray[(byteArray.length - 1) - i3];
        }
    }

    private void populateFromPubKeyInfo(w wVar) {
        m f2 = wVar.f().f();
        n0 i = wVar.i();
        this.algorithm = "ECGOST3410-2012";
        try {
            byte[] o = ((org.bouncycastle.asn1.n) q.i(i.o())).o();
            int i2 = 32;
            if (f2.equals(org.bouncycastle.asn1.o2.a.h)) {
                i2 = 64;
            }
            int i3 = i2 * 2;
            byte[] bArr = new byte[i3 + 1];
            bArr[0] = 4;
            for (int i4 = 1; i4 <= i2; i4++) {
                bArr[i4] = o[i2 - i4];
                bArr[i4 + i2] = o[i3 - i4];
            }
            e h = e.h(wVar.f().i());
            this.gostParams = h;
            org.bouncycastle.jce.spec.b a = e.a.a.a.a(org.bouncycastle.asn1.d2.b.c(h.i()));
            e.a.b.a.d a2 = a.a();
            EllipticCurve a3 = a.a(a2, a.e());
            this.ecPublicKey = new s(a2.k(bArr), org.bouncycastle.jcajce.provider.asymmetric.util.b.f(null, a));
            this.ecSpec = new c(org.bouncycastle.asn1.d2.b.c(this.gostParams.i()), a3, a.d(a.b()), a.d(), a.c());
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
        if (!(obj instanceof BCECGOST3410_2012PublicKey)) {
            return false;
        }
        BCECGOST3410_2012PublicKey bCECGOST3410_2012PublicKey = (BCECGOST3410_2012PublicKey) obj;
        return this.ecPublicKey.c().e(bCECGOST3410_2012PublicKey.ecPublicKey.c()) && engineGetSpec().equals(bCECGOST3410_2012PublicKey.engineGetSpec());
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.algorithm;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.security.Key
    public byte[] getEncoded() {
        m mVar;
        int i;
        e eVar;
        BigInteger t = this.ecPublicKey.c().f().t();
        BigInteger t2 = this.ecPublicKey.c().g().t();
        boolean z = t.bitLength() > 256;
        e gostParams = getGostParams();
        e eVar2 = gostParams;
        if (gostParams == null) {
            ECParameterSpec eCParameterSpec = this.ecSpec;
            if (eCParameterSpec instanceof c) {
                m d2 = org.bouncycastle.asn1.d2.b.d(((c) eCParameterSpec).a());
                if (z) {
                    new e(d2, org.bouncycastle.asn1.o2.a.f16848d);
                    eVar = d2;
                } else {
                    new e(d2, org.bouncycastle.asn1.o2.a.f16847c);
                    eVar = d2;
                }
            } else {
                e.a.b.a.d b2 = a.b(eCParameterSpec.getCurve());
                j jVar = new j(b2, a.f(b2, this.ecSpec.getGenerator(), this.withCompression), this.ecSpec.getOrder(), BigInteger.valueOf(this.ecSpec.getCofactor()), this.ecSpec.getCurve().getSeed());
                new h(jVar);
                eVar = jVar;
            }
            eVar2 = eVar;
        }
        int i2 = 64;
        if (z) {
            mVar = org.bouncycastle.asn1.o2.a.h;
            i = 64;
            i2 = 128;
        } else {
            i = 32;
            mVar = org.bouncycastle.asn1.o2.a.g;
        }
        byte[] bArr = new byte[i2];
        int i3 = i2 / 2;
        extractBytes(bArr, i3, 0, t);
        extractBytes(bArr, i3, i, t2);
        try {
            return org.bouncycastle.jcajce.provider.asymmetric.util.c.d(new w(new org.bouncycastle.asn1.x509.a(mVar, eVar2), new x0(bArr)));
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public e getGostParams() {
        if (this.gostParams == null && (this.ecSpec instanceof c)) {
            this.gostParams = this.ecPublicKey.c().f().t().bitLength() > 256 ? new e(org.bouncycastle.asn1.d2.b.d(((c) this.ecSpec).a()), org.bouncycastle.asn1.o2.a.f16848d) : new e(org.bouncycastle.asn1.d2.b.d(((c) this.ecSpec).a()), org.bouncycastle.asn1.o2.a.f16847c);
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
