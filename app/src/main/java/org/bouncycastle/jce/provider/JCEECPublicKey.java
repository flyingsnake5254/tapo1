package org.bouncycastle.jce.provider;

import e.a.b.a.h;
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
import org.bouncycastle.asn1.k;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.n0;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.u2.j;
import org.bouncycastle.asn1.u2.l;
import org.bouncycastle.asn1.u2.o;
import org.bouncycastle.asn1.u2.p;
import org.bouncycastle.asn1.v0;
import org.bouncycastle.asn1.x0;
import org.bouncycastle.asn1.x509.w;
import org.bouncycastle.crypto.w.n;
import org.bouncycastle.crypto.w.s;
import org.bouncycastle.jcajce.provider.asymmetric.util.a;
import org.bouncycastle.jce.spec.b;
import org.bouncycastle.jce.spec.c;
import org.bouncycastle.jce.spec.d;
import org.bouncycastle.jce.spec.f;
import org.bouncycastle.util.i;

/* loaded from: classes4.dex */
public class JCEECPublicKey implements ECPublicKey, org.bouncycastle.jce.interfaces.ECPublicKey {
    private String algorithm;
    private ECParameterSpec ecSpec;
    private e gostParams;
    private h q;
    private boolean withCompression;

    public JCEECPublicKey(String str, ECPublicKeySpec eCPublicKeySpec) {
        this.algorithm = "EC";
        this.algorithm = str;
        ECParameterSpec params = eCPublicKeySpec.getParams();
        this.ecSpec = params;
        this.q = a.e(params, eCPublicKeySpec.getW(), false);
    }

    public JCEECPublicKey(String str, s sVar) {
        this.algorithm = "EC";
        this.algorithm = str;
        this.q = sVar.c();
        this.ecSpec = null;
    }

    public JCEECPublicKey(String str, s sVar, ECParameterSpec eCParameterSpec) {
        this.algorithm = "EC";
        n b2 = sVar.b();
        this.algorithm = str;
        this.q = sVar.c();
        if (eCParameterSpec == null) {
            this.ecSpec = createSpec(a.a(b2.a(), b2.f()), b2);
        } else {
            this.ecSpec = eCParameterSpec;
        }
    }

    public JCEECPublicKey(String str, s sVar, d dVar) {
        this.algorithm = "EC";
        n b2 = sVar.b();
        this.algorithm = str;
        this.q = sVar.c();
        this.ecSpec = dVar == null ? createSpec(a.a(b2.a(), b2.f()), b2) : a.g(a.a(dVar.a(), dVar.e()), dVar);
    }

    public JCEECPublicKey(String str, JCEECPublicKey jCEECPublicKey) {
        this.algorithm = "EC";
        this.algorithm = str;
        this.q = jCEECPublicKey.q;
        this.ecSpec = jCEECPublicKey.ecSpec;
        this.withCompression = jCEECPublicKey.withCompression;
        this.gostParams = jCEECPublicKey.gostParams;
    }

    public JCEECPublicKey(String str, f fVar) {
        this.algorithm = "EC";
        this.algorithm = str;
        throw null;
    }

    public JCEECPublicKey(ECPublicKey eCPublicKey) {
        this.algorithm = "EC";
        this.algorithm = eCPublicKey.getAlgorithm();
        ECParameterSpec params = eCPublicKey.getParams();
        this.ecSpec = params;
        this.q = a.e(params, eCPublicKey.getW(), false);
    }

    JCEECPublicKey(w wVar) {
        this.algorithm = "EC";
        populateFromPubKeyInfo(wVar);
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
        e.a.b.a.d dVar;
        byte[] o;
        org.bouncycastle.asn1.n x0Var;
        ECParameterSpec eCParameterSpec;
        if (wVar.g().f().equals(org.bouncycastle.asn1.d2.a.m)) {
            n0 i = wVar.i();
            this.algorithm = "ECGOST3410";
            try {
                byte[] o2 = ((org.bouncycastle.asn1.n) q.i(i.o())).o();
                byte[] bArr = new byte[65];
                bArr[0] = 4;
                for (int i2 = 1; i2 <= 32; i2++) {
                    bArr[i2] = o2[32 - i2];
                    bArr[i2 + 32] = o2[64 - i2];
                }
                e eVar = new e((r) wVar.g().i());
                this.gostParams = eVar;
                b a = e.a.a.a.a(org.bouncycastle.asn1.d2.b.c(eVar.i()));
                e.a.b.a.d a2 = a.a();
                EllipticCurve a3 = a.a(a2, a.e());
                this.q = a2.k(bArr);
                this.ecSpec = new c(org.bouncycastle.asn1.d2.b.c(this.gostParams.i()), a3, a.d(a.b()), a.d(), a.c());
            } catch (IOException unused) {
                throw new IllegalArgumentException("error recovering public key");
            }
        } else {
            org.bouncycastle.asn1.u2.h hVar = new org.bouncycastle.asn1.u2.h((q) wVar.g().i());
            if (hVar.i()) {
                m mVar = (m) hVar.g();
                j g = org.bouncycastle.jcajce.provider.asymmetric.util.b.g(mVar);
                dVar = g.f();
                eCParameterSpec = new c(org.bouncycastle.jcajce.provider.asymmetric.util.b.d(mVar), a.a(dVar, g.k()), a.d(g.g()), g.j(), g.h());
            } else if (hVar.h()) {
                this.ecSpec = null;
                dVar = BouncyCastleProvider.CONFIGURATION.b().a();
                o = wVar.i().o();
                x0Var = new x0(o);
                if (o[0] == 4 && o[1] == o.length - 2 && ((o[2] == 2 || o[2] == 3) && new o().a(dVar) >= o.length - 3)) {
                    try {
                        x0Var = (org.bouncycastle.asn1.n) q.i(o);
                    } catch (IOException unused2) {
                        throw new IllegalArgumentException("error recovering public key");
                    }
                }
                this.q = new l(dVar, x0Var).f();
            } else {
                j i3 = j.i(hVar.g());
                dVar = i3.f();
                eCParameterSpec = new ECParameterSpec(a.a(dVar, i3.k()), a.d(i3.g()), i3.j(), i3.h().intValue());
            }
            this.ecSpec = eCParameterSpec;
            o = wVar.i().o();
            x0Var = new x0(o);
            if (o[0] == 4) {
                x0Var = (org.bouncycastle.asn1.n) q.i(o);
            }
            this.q = new l(dVar, x0Var).f();
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        populateFromPubKeyInfo(w.h(q.i((byte[]) objectInputStream.readObject())));
        this.algorithm = (String) objectInputStream.readObject();
        this.withCompression = objectInputStream.readBoolean();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(getEncoded());
        objectOutputStream.writeObject(this.algorithm);
        objectOutputStream.writeBoolean(this.withCompression);
    }

    public h engineGetQ() {
        return this.q;
    }

    d engineGetSpec() {
        ECParameterSpec eCParameterSpec = this.ecSpec;
        return eCParameterSpec != null ? a.h(eCParameterSpec, this.withCompression) : BouncyCastleProvider.CONFIGURATION.b();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof JCEECPublicKey)) {
            return false;
        }
        JCEECPublicKey jCEECPublicKey = (JCEECPublicKey) obj;
        return engineGetQ().e(jCEECPublicKey.engineGetQ()) && engineGetSpec().equals(jCEECPublicKey.engineGetSpec());
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.algorithm;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        w wVar;
        org.bouncycastle.asn1.u2.h hVar;
        if (this.algorithm.equals("ECGOST3410")) {
            org.bouncycastle.asn1.e eVar = this.gostParams;
            if (eVar == null) {
                ECParameterSpec eCParameterSpec = this.ecSpec;
                if (eCParameterSpec instanceof c) {
                    eVar = new e(org.bouncycastle.asn1.d2.b.d(((c) eCParameterSpec).a()), org.bouncycastle.asn1.d2.a.p);
                } else {
                    e.a.b.a.d b2 = a.b(eCParameterSpec.getCurve());
                    eVar = new org.bouncycastle.asn1.u2.h(new j(b2, a.f(b2, this.ecSpec.getGenerator(), this.withCompression), this.ecSpec.getOrder(), BigInteger.valueOf(this.ecSpec.getCofactor()), this.ecSpec.getCurve().getSeed()));
                }
            }
            BigInteger t = this.q.f().t();
            BigInteger t2 = this.q.g().t();
            byte[] bArr = new byte[64];
            extractBytes(bArr, 0, t);
            extractBytes(bArr, 32, t2);
            try {
                wVar = new w(new org.bouncycastle.asn1.x509.a(org.bouncycastle.asn1.d2.a.m, eVar), new x0(bArr));
            } catch (IOException unused) {
                return null;
            }
        } else {
            ECParameterSpec eCParameterSpec2 = this.ecSpec;
            if (eCParameterSpec2 instanceof c) {
                m h = org.bouncycastle.jcajce.provider.asymmetric.util.b.h(((c) eCParameterSpec2).a());
                if (h == null) {
                    h = new m(((c) this.ecSpec).a());
                }
                hVar = new org.bouncycastle.asn1.u2.h(h);
            } else if (eCParameterSpec2 == null) {
                hVar = new org.bouncycastle.asn1.u2.h((k) v0.f16957c);
            } else {
                e.a.b.a.d b3 = a.b(eCParameterSpec2.getCurve());
                hVar = new org.bouncycastle.asn1.u2.h(new j(b3, a.f(b3, this.ecSpec.getGenerator(), this.withCompression), this.ecSpec.getOrder(), BigInteger.valueOf(this.ecSpec.getCofactor()), this.ecSpec.getCurve().getSeed()));
            }
            wVar = new w(new org.bouncycastle.asn1.x509.a(p.B2, hVar), ((org.bouncycastle.asn1.n) new l(engineGetQ().i().h(getQ().f().t(), getQ().g().t(), this.withCompression)).c()).o());
        }
        return org.bouncycastle.jcajce.provider.asymmetric.util.c.d(wVar);
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
    public h getQ() {
        return this.ecSpec == null ? this.q.k() : this.q;
    }

    @Override // java.security.interfaces.ECPublicKey
    public ECPoint getW() {
        return a.d(this.q);
    }

    public int hashCode() {
        return engineGetQ().hashCode() ^ engineGetSpec().hashCode();
    }

    public void setPointFormat(String str) {
        this.withCompression = !"UNCOMPRESSED".equalsIgnoreCase(str);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String d2 = i.d();
        stringBuffer.append("EC Public Key");
        stringBuffer.append(d2);
        stringBuffer.append("            X: ");
        stringBuffer.append(this.q.f().t().toString(16));
        stringBuffer.append(d2);
        stringBuffer.append("            Y: ");
        stringBuffer.append(this.q.g().t().toString(16));
        stringBuffer.append(d2);
        return stringBuffer.toString();
    }
}
