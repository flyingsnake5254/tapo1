package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPrivateKeySpec;
import java.util.Enumeration;
import org.bouncycastle.asn1.k;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.n0;
import org.bouncycastle.asn1.n2.h;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.u2.j;
import org.bouncycastle.asn1.u2.p;
import org.bouncycastle.asn1.v0;
import org.bouncycastle.asn1.x509.w;
import org.bouncycastle.crypto.w.n;
import org.bouncycastle.crypto.w.r;
import org.bouncycastle.jcajce.provider.asymmetric.util.a;
import org.bouncycastle.jcajce.provider.asymmetric.util.d;
import org.bouncycastle.jce.interfaces.b;
import org.bouncycastle.jce.spec.c;
import org.bouncycastle.jce.spec.e;
import org.bouncycastle.util.i;

/* loaded from: classes4.dex */
public class JCEECPrivateKey implements ECPrivateKey, org.bouncycastle.jce.interfaces.ECPrivateKey, b {
    private String algorithm;
    private d attrCarrier;

    /* renamed from: d  reason: collision with root package name */
    private BigInteger f17392d;
    private ECParameterSpec ecSpec;
    private n0 publicKey;
    private boolean withCompression;

    protected JCEECPrivateKey() {
        this.algorithm = "EC";
        this.attrCarrier = new d();
    }

    public JCEECPrivateKey(String str, ECPrivateKeySpec eCPrivateKeySpec) {
        this.algorithm = "EC";
        this.attrCarrier = new d();
        this.algorithm = str;
        this.f17392d = eCPrivateKeySpec.getS();
        this.ecSpec = eCPrivateKeySpec.getParams();
    }

    public JCEECPrivateKey(String str, r rVar) {
        this.algorithm = "EC";
        this.attrCarrier = new d();
        this.algorithm = str;
        this.f17392d = rVar.c();
        this.ecSpec = null;
    }

    public JCEECPrivateKey(String str, r rVar, JCEECPublicKey jCEECPublicKey, ECParameterSpec eCParameterSpec) {
        this.algorithm = "EC";
        this.attrCarrier = new d();
        this.algorithm = str;
        this.f17392d = rVar.c();
        if (eCParameterSpec == null) {
            n b2 = rVar.b();
            eCParameterSpec = new ECParameterSpec(a.a(b2.a(), b2.f()), a.d(b2.b()), b2.e(), b2.c().intValue());
        }
        this.ecSpec = eCParameterSpec;
        this.publicKey = getPublicKeyDetails(jCEECPublicKey);
    }

    public JCEECPrivateKey(String str, r rVar, JCEECPublicKey jCEECPublicKey, org.bouncycastle.jce.spec.d dVar) {
        this.algorithm = "EC";
        this.attrCarrier = new d();
        this.algorithm = str;
        this.f17392d = rVar.c();
        if (dVar == null) {
            n b2 = rVar.b();
            this.ecSpec = new ECParameterSpec(a.a(b2.a(), b2.f()), a.d(b2.b()), b2.e(), b2.c().intValue());
        } else {
            this.ecSpec = new ECParameterSpec(a.a(dVar.a(), dVar.e()), a.d(dVar.b()), dVar.d(), dVar.c().intValue());
        }
        this.publicKey = getPublicKeyDetails(jCEECPublicKey);
    }

    public JCEECPrivateKey(String str, JCEECPrivateKey jCEECPrivateKey) {
        this.algorithm = "EC";
        this.attrCarrier = new d();
        this.algorithm = str;
        this.f17392d = jCEECPrivateKey.f17392d;
        this.ecSpec = jCEECPrivateKey.ecSpec;
        this.withCompression = jCEECPrivateKey.withCompression;
        this.attrCarrier = jCEECPrivateKey.attrCarrier;
        this.publicKey = jCEECPrivateKey.publicKey;
    }

    public JCEECPrivateKey(String str, e eVar) {
        this.algorithm = "EC";
        this.attrCarrier = new d();
        this.algorithm = str;
        throw null;
    }

    public JCEECPrivateKey(ECPrivateKey eCPrivateKey) {
        this.algorithm = "EC";
        this.attrCarrier = new d();
        this.f17392d = eCPrivateKey.getS();
        this.algorithm = eCPrivateKey.getAlgorithm();
        this.ecSpec = eCPrivateKey.getParams();
    }

    JCEECPrivateKey(h hVar) throws IOException {
        this.algorithm = "EC";
        this.attrCarrier = new d();
        populateFromPrivKeyInfo(hVar);
    }

    private n0 getPublicKeyDetails(JCEECPublicKey jCEECPublicKey) {
        try {
            return w.h(q.i(jCEECPublicKey.getEncoded())).i();
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void populateFromPrivKeyInfo(org.bouncycastle.asn1.n2.h r11) throws java.io.IOException {
        /*
            r10 = this;
            org.bouncycastle.asn1.u2.h r0 = new org.bouncycastle.asn1.u2.h
            org.bouncycastle.asn1.x509.a r1 = r11.h()
            org.bouncycastle.asn1.e r1 = r1.i()
            org.bouncycastle.asn1.q r1 = (org.bouncycastle.asn1.q) r1
            r0.<init>(r1)
            boolean r1 = r0.i()
            if (r1 == 0) goto L_0x0075
            org.bouncycastle.asn1.q r0 = r0.g()
            org.bouncycastle.asn1.m r0 = org.bouncycastle.asn1.m.r(r0)
            org.bouncycastle.asn1.u2.j r1 = org.bouncycastle.jcajce.provider.asymmetric.util.b.g(r0)
            if (r1 != 0) goto L_0x004e
            org.bouncycastle.crypto.w.n r1 = org.bouncycastle.asn1.d2.b.b(r0)
            e.a.b.a.d r2 = r1.a()
            byte[] r3 = r1.f()
            java.security.spec.EllipticCurve r6 = org.bouncycastle.jcajce.provider.asymmetric.util.a.a(r2, r3)
            org.bouncycastle.jce.spec.c r2 = new org.bouncycastle.jce.spec.c
            java.lang.String r5 = org.bouncycastle.asn1.d2.b.c(r0)
            e.a.b.a.h r0 = r1.b()
            java.security.spec.ECPoint r7 = org.bouncycastle.jcajce.provider.asymmetric.util.a.d(r0)
            java.math.BigInteger r8 = r1.e()
            java.math.BigInteger r9 = r1.c()
            r4 = r2
            r4.<init>(r5, r6, r7, r8, r9)
            goto L_0x00ac
        L_0x004e:
            e.a.b.a.d r2 = r1.f()
            byte[] r3 = r1.k()
            java.security.spec.EllipticCurve r6 = org.bouncycastle.jcajce.provider.asymmetric.util.a.a(r2, r3)
            org.bouncycastle.jce.spec.c r2 = new org.bouncycastle.jce.spec.c
            java.lang.String r5 = org.bouncycastle.jcajce.provider.asymmetric.util.b.d(r0)
            e.a.b.a.h r0 = r1.g()
            java.security.spec.ECPoint r7 = org.bouncycastle.jcajce.provider.asymmetric.util.a.d(r0)
            java.math.BigInteger r8 = r1.j()
            java.math.BigInteger r9 = r1.h()
            r4 = r2
            r4.<init>(r5, r6, r7, r8, r9)
            goto L_0x00ac
        L_0x0075:
            boolean r1 = r0.h()
            if (r1 == 0) goto L_0x007f
            r0 = 0
            r10.ecSpec = r0
            goto L_0x00ae
        L_0x007f:
            org.bouncycastle.asn1.q r0 = r0.g()
            org.bouncycastle.asn1.u2.j r0 = org.bouncycastle.asn1.u2.j.i(r0)
            e.a.b.a.d r1 = r0.f()
            byte[] r2 = r0.k()
            java.security.spec.EllipticCurve r1 = org.bouncycastle.jcajce.provider.asymmetric.util.a.a(r1, r2)
            java.security.spec.ECParameterSpec r2 = new java.security.spec.ECParameterSpec
            e.a.b.a.h r3 = r0.g()
            java.security.spec.ECPoint r3 = org.bouncycastle.jcajce.provider.asymmetric.util.a.d(r3)
            java.math.BigInteger r4 = r0.j()
            java.math.BigInteger r0 = r0.h()
            int r0 = r0.intValue()
            r2.<init>(r1, r3, r4, r0)
        L_0x00ac:
            r10.ecSpec = r2
        L_0x00ae:
            org.bouncycastle.asn1.e r11 = r11.i()
            boolean r0 = r11 instanceof org.bouncycastle.asn1.j
            if (r0 == 0) goto L_0x00c1
            org.bouncycastle.asn1.j r11 = org.bouncycastle.asn1.j.m(r11)
            java.math.BigInteger r11 = r11.p()
            r10.f17392d = r11
            goto L_0x00d4
        L_0x00c1:
            org.bouncycastle.asn1.p2.b r0 = new org.bouncycastle.asn1.p2.b
            org.bouncycastle.asn1.r r11 = (org.bouncycastle.asn1.r) r11
            r0.<init>(r11)
            java.math.BigInteger r11 = r0.f()
            r10.f17392d = r11
            org.bouncycastle.asn1.n0 r11 = r0.h()
            r10.publicKey = r11
        L_0x00d4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jce.provider.JCEECPrivateKey.populateFromPrivKeyInfo(org.bouncycastle.asn1.n2.h):void");
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        populateFromPrivKeyInfo(h.g(q.i((byte[]) objectInputStream.readObject())));
        this.algorithm = (String) objectInputStream.readObject();
        this.withCompression = objectInputStream.readBoolean();
        d dVar = new d();
        this.attrCarrier = dVar;
        dVar.a(objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(getEncoded());
        objectOutputStream.writeObject(this.algorithm);
        objectOutputStream.writeBoolean(this.withCompression);
        this.attrCarrier.b(objectOutputStream);
    }

    org.bouncycastle.jce.spec.d engineGetSpec() {
        ECParameterSpec eCParameterSpec = this.ecSpec;
        return eCParameterSpec != null ? a.h(eCParameterSpec, this.withCompression) : BouncyCastleProvider.CONFIGURATION.b();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof JCEECPrivateKey)) {
            return false;
        }
        JCEECPrivateKey jCEECPrivateKey = (JCEECPrivateKey) obj;
        return getD().equals(jCEECPrivateKey.getD()) && engineGetSpec().equals(jCEECPrivateKey.engineGetSpec());
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.algorithm;
    }

    @Override // org.bouncycastle.jce.interfaces.b
    public org.bouncycastle.asn1.e getBagAttribute(m mVar) {
        return this.attrCarrier.getBagAttribute(mVar);
    }

    @Override // org.bouncycastle.jce.interfaces.b
    public Enumeration getBagAttributeKeys() {
        return this.attrCarrier.getBagAttributeKeys();
    }

    @Override // org.bouncycastle.jce.interfaces.ECPrivateKey
    public BigInteger getD() {
        return this.f17392d;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        org.bouncycastle.asn1.u2.h hVar;
        ECParameterSpec eCParameterSpec = this.ecSpec;
        if (eCParameterSpec instanceof c) {
            m h = org.bouncycastle.jcajce.provider.asymmetric.util.b.h(((c) eCParameterSpec).a());
            if (h == null) {
                h = new m(((c) this.ecSpec).a());
            }
            hVar = new org.bouncycastle.asn1.u2.h(h);
        } else if (eCParameterSpec == null) {
            hVar = new org.bouncycastle.asn1.u2.h((k) v0.f16957c);
        } else {
            e.a.b.a.d b2 = a.b(eCParameterSpec.getCurve());
            hVar = new org.bouncycastle.asn1.u2.h(new j(b2, a.f(b2, this.ecSpec.getGenerator(), this.withCompression), this.ecSpec.getOrder(), BigInteger.valueOf(this.ecSpec.getCofactor()), this.ecSpec.getCurve().getSeed()));
        }
        org.bouncycastle.asn1.p2.b bVar = this.publicKey != null ? new org.bouncycastle.asn1.p2.b(getS(), this.publicKey, hVar) : new org.bouncycastle.asn1.p2.b(getS(), hVar);
        try {
            return (this.algorithm.equals("ECGOST3410") ? new h(new org.bouncycastle.asn1.x509.a(org.bouncycastle.asn1.d2.a.m, hVar.c()), bVar.c()) : new h(new org.bouncycastle.asn1.x509.a(p.B2, hVar.c()), bVar.c())).e("DER");
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // org.bouncycastle.jce.interfaces.ECPrivateKey
    public org.bouncycastle.jce.spec.d getParameters() {
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

    @Override // java.security.interfaces.ECPrivateKey
    public BigInteger getS() {
        return this.f17392d;
    }

    public int hashCode() {
        return getD().hashCode() ^ engineGetSpec().hashCode();
    }

    @Override // org.bouncycastle.jce.interfaces.b
    public void setBagAttribute(m mVar, org.bouncycastle.asn1.e eVar) {
        this.attrCarrier.setBagAttribute(mVar, eVar);
    }

    public void setPointFormat(String str) {
        this.withCompression = !"UNCOMPRESSED".equalsIgnoreCase(str);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String d2 = i.d();
        stringBuffer.append("EC Private Key");
        stringBuffer.append(d2);
        stringBuffer.append("             S: ");
        stringBuffer.append(this.f17392d.toString(16));
        stringBuffer.append(d2);
        return stringBuffer.toString();
    }
}
