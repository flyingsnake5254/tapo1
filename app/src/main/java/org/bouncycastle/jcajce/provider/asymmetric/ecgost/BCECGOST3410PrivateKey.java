package org.bouncycastle.jcajce.provider.asymmetric.ecgost;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPrivateKeySpec;
import java.util.Enumeration;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.n0;
import org.bouncycastle.asn1.n2.h;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.x509.w;
import org.bouncycastle.crypto.w.n;
import org.bouncycastle.crypto.w.r;
import org.bouncycastle.jcajce.provider.asymmetric.util.a;
import org.bouncycastle.jcajce.provider.asymmetric.util.d;
import org.bouncycastle.jce.interfaces.b;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/* loaded from: classes4.dex */
public class BCECGOST3410PrivateKey implements ECPrivateKey, org.bouncycastle.jce.interfaces.ECPrivateKey, b {
    static final long serialVersionUID = 7245981689601667138L;
    private String algorithm;
    private transient d attrCarrier;

    /* renamed from: d  reason: collision with root package name */
    private transient BigInteger f17371d;
    private transient ECParameterSpec ecSpec;
    private transient e gostParams;
    private transient n0 publicKey;
    private boolean withCompression;

    protected BCECGOST3410PrivateKey() {
        this.algorithm = "ECGOST3410";
        this.attrCarrier = new d();
    }

    public BCECGOST3410PrivateKey(String str, r rVar) {
        this.algorithm = "ECGOST3410";
        this.attrCarrier = new d();
        this.algorithm = str;
        this.f17371d = rVar.c();
        this.ecSpec = null;
    }

    public BCECGOST3410PrivateKey(String str, r rVar, BCECGOST3410PublicKey bCECGOST3410PublicKey, ECParameterSpec eCParameterSpec) {
        this.algorithm = "ECGOST3410";
        this.attrCarrier = new d();
        this.algorithm = str;
        this.f17371d = rVar.c();
        if (eCParameterSpec == null) {
            n b2 = rVar.b();
            eCParameterSpec = new ECParameterSpec(a.a(b2.a(), b2.f()), a.d(b2.b()), b2.e(), b2.c().intValue());
        }
        this.ecSpec = eCParameterSpec;
        this.gostParams = bCECGOST3410PublicKey.getGostParams();
        this.publicKey = getPublicKeyDetails(bCECGOST3410PublicKey);
    }

    public BCECGOST3410PrivateKey(String str, r rVar, BCECGOST3410PublicKey bCECGOST3410PublicKey, org.bouncycastle.jce.spec.d dVar) {
        this.algorithm = "ECGOST3410";
        this.attrCarrier = new d();
        this.algorithm = str;
        this.f17371d = rVar.c();
        if (dVar == null) {
            n b2 = rVar.b();
            this.ecSpec = new ECParameterSpec(a.a(b2.a(), b2.f()), a.d(b2.b()), b2.e(), b2.c().intValue());
        } else {
            this.ecSpec = new ECParameterSpec(a.a(dVar.a(), dVar.e()), a.d(dVar.b()), dVar.d(), dVar.c().intValue());
        }
        this.gostParams = bCECGOST3410PublicKey.getGostParams();
        this.publicKey = getPublicKeyDetails(bCECGOST3410PublicKey);
    }

    public BCECGOST3410PrivateKey(ECPrivateKey eCPrivateKey) {
        this.algorithm = "ECGOST3410";
        this.attrCarrier = new d();
        this.f17371d = eCPrivateKey.getS();
        this.algorithm = eCPrivateKey.getAlgorithm();
        this.ecSpec = eCPrivateKey.getParams();
    }

    public BCECGOST3410PrivateKey(ECPrivateKeySpec eCPrivateKeySpec) {
        this.algorithm = "ECGOST3410";
        this.attrCarrier = new d();
        this.f17371d = eCPrivateKeySpec.getS();
        this.ecSpec = eCPrivateKeySpec.getParams();
    }

    BCECGOST3410PrivateKey(h hVar) throws IOException {
        this.algorithm = "ECGOST3410";
        this.attrCarrier = new d();
        populateFromPrivKeyInfo(hVar);
    }

    public BCECGOST3410PrivateKey(BCECGOST3410PrivateKey bCECGOST3410PrivateKey) {
        this.algorithm = "ECGOST3410";
        this.attrCarrier = new d();
        this.f17371d = bCECGOST3410PrivateKey.f17371d;
        this.ecSpec = bCECGOST3410PrivateKey.ecSpec;
        this.withCompression = bCECGOST3410PrivateKey.withCompression;
        this.attrCarrier = bCECGOST3410PrivateKey.attrCarrier;
        this.publicKey = bCECGOST3410PrivateKey.publicKey;
        this.gostParams = bCECGOST3410PrivateKey.gostParams;
    }

    public BCECGOST3410PrivateKey(org.bouncycastle.jce.spec.e eVar) {
        this.algorithm = "ECGOST3410";
        this.attrCarrier = new d();
        throw null;
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

    private n0 getPublicKeyDetails(BCECGOST3410PublicKey bCECGOST3410PublicKey) {
        try {
            return w.h(q.i(bCECGOST3410PublicKey.getEncoded())).i();
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0148  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void populateFromPrivKeyInfo(org.bouncycastle.asn1.n2.h r11) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 345
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jcajce.provider.asymmetric.ecgost.BCECGOST3410PrivateKey.populateFromPrivKeyInfo(org.bouncycastle.asn1.n2.h):void");
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        populateFromPrivKeyInfo(h.g(q.i((byte[]) objectInputStream.readObject())));
        this.attrCarrier = new d();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    org.bouncycastle.jce.spec.d engineGetSpec() {
        ECParameterSpec eCParameterSpec = this.ecSpec;
        return eCParameterSpec != null ? a.h(eCParameterSpec, this.withCompression) : BouncyCastleProvider.CONFIGURATION.b();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BCECGOST3410PrivateKey)) {
            return false;
        }
        BCECGOST3410PrivateKey bCECGOST3410PrivateKey = (BCECGOST3410PrivateKey) obj;
        return getD().equals(bCECGOST3410PrivateKey.getD()) && engineGetSpec().equals(bCECGOST3410PrivateKey.engineGetSpec());
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.algorithm;
    }

    @Override // org.bouncycastle.jce.interfaces.b
    public e getBagAttribute(m mVar) {
        return this.attrCarrier.getBagAttribute(mVar);
    }

    @Override // org.bouncycastle.jce.interfaces.b
    public Enumeration getBagAttributeKeys() {
        return this.attrCarrier.getBagAttributeKeys();
    }

    @Override // org.bouncycastle.jce.interfaces.ECPrivateKey
    public BigInteger getD() {
        return this.f17371d;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00bf  */
    @Override // java.security.Key
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] getEncoded() {
        /*
            r9 = this;
            org.bouncycastle.asn1.e r0 = r9.gostParams
            java.lang.String r1 = "DER"
            r2 = 0
            if (r0 == 0) goto L_0x002c
            r0 = 32
            byte[] r0 = new byte[r0]
            r3 = 0
            java.math.BigInteger r4 = r9.getS()
            r9.extractBytes(r0, r3, r4)
            org.bouncycastle.asn1.n2.h r3 = new org.bouncycastle.asn1.n2.h     // Catch: IOException -> 0x002b
            org.bouncycastle.asn1.x509.a r4 = new org.bouncycastle.asn1.x509.a     // Catch: IOException -> 0x002b
            org.bouncycastle.asn1.m r5 = org.bouncycastle.asn1.d2.a.m     // Catch: IOException -> 0x002b
            org.bouncycastle.asn1.e r6 = r9.gostParams     // Catch: IOException -> 0x002b
            r4.<init>(r5, r6)     // Catch: IOException -> 0x002b
            org.bouncycastle.asn1.x0 r5 = new org.bouncycastle.asn1.x0     // Catch: IOException -> 0x002b
            r5.<init>(r0)     // Catch: IOException -> 0x002b
            r3.<init>(r4, r5)     // Catch: IOException -> 0x002b
            byte[] r0 = r3.e(r1)     // Catch: IOException -> 0x002b
            return r0
        L_0x002b:
            return r2
        L_0x002c:
            java.security.spec.ECParameterSpec r0 = r9.ecSpec
            boolean r3 = r0 instanceof org.bouncycastle.jce.spec.c
            if (r3 == 0) goto L_0x0051
            org.bouncycastle.jce.spec.c r0 = (org.bouncycastle.jce.spec.c) r0
            java.lang.String r0 = r0.a()
            org.bouncycastle.asn1.m r0 = org.bouncycastle.jcajce.provider.asymmetric.util.b.h(r0)
            if (r0 != 0) goto L_0x004b
            org.bouncycastle.asn1.m r0 = new org.bouncycastle.asn1.m
            java.security.spec.ECParameterSpec r3 = r9.ecSpec
            org.bouncycastle.jce.spec.c r3 = (org.bouncycastle.jce.spec.c) r3
            java.lang.String r3 = r3.a()
            r0.<init>(r3)
        L_0x004b:
            org.bouncycastle.asn1.u2.h r3 = new org.bouncycastle.asn1.u2.h
            r3.<init>(r0)
            goto L_0x009f
        L_0x0051:
            if (r0 != 0) goto L_0x0065
            org.bouncycastle.asn1.u2.h r3 = new org.bouncycastle.asn1.u2.h
            org.bouncycastle.asn1.v0 r0 = org.bouncycastle.asn1.v0.f16957c
            r3.<init>(r0)
            org.bouncycastle.jcajce.provider.config.b r0 = org.bouncycastle.jce.provider.BouncyCastleProvider.CONFIGURATION
            java.math.BigInteger r4 = r9.getS()
            int r0 = org.bouncycastle.jcajce.provider.asymmetric.util.b.i(r0, r2, r4)
            goto L_0x00af
        L_0x0065:
            java.security.spec.EllipticCurve r0 = r0.getCurve()
            e.a.b.a.d r4 = org.bouncycastle.jcajce.provider.asymmetric.util.a.b(r0)
            org.bouncycastle.asn1.u2.j r0 = new org.bouncycastle.asn1.u2.j
            java.security.spec.ECParameterSpec r3 = r9.ecSpec
            java.security.spec.ECPoint r3 = r3.getGenerator()
            boolean r5 = r9.withCompression
            e.a.b.a.h r5 = org.bouncycastle.jcajce.provider.asymmetric.util.a.f(r4, r3, r5)
            java.security.spec.ECParameterSpec r3 = r9.ecSpec
            java.math.BigInteger r6 = r3.getOrder()
            java.security.spec.ECParameterSpec r3 = r9.ecSpec
            int r3 = r3.getCofactor()
            long r7 = (long) r3
            java.math.BigInteger r7 = java.math.BigInteger.valueOf(r7)
            java.security.spec.ECParameterSpec r3 = r9.ecSpec
            java.security.spec.EllipticCurve r3 = r3.getCurve()
            byte[] r8 = r3.getSeed()
            r3 = r0
            r3.<init>(r4, r5, r6, r7, r8)
            org.bouncycastle.asn1.u2.h r3 = new org.bouncycastle.asn1.u2.h
            r3.<init>(r0)
        L_0x009f:
            org.bouncycastle.jcajce.provider.config.b r0 = org.bouncycastle.jce.provider.BouncyCastleProvider.CONFIGURATION
            java.security.spec.ECParameterSpec r4 = r9.ecSpec
            java.math.BigInteger r4 = r4.getOrder()
            java.math.BigInteger r5 = r9.getS()
            int r0 = org.bouncycastle.jcajce.provider.asymmetric.util.b.i(r0, r4, r5)
        L_0x00af:
            org.bouncycastle.asn1.n0 r4 = r9.publicKey
            if (r4 == 0) goto L_0x00bf
            org.bouncycastle.asn1.p2.a r4 = new org.bouncycastle.asn1.p2.a
            java.math.BigInteger r5 = r9.getS()
            org.bouncycastle.asn1.n0 r6 = r9.publicKey
            r4.<init>(r0, r5, r6, r3)
            goto L_0x00c8
        L_0x00bf:
            org.bouncycastle.asn1.p2.a r4 = new org.bouncycastle.asn1.p2.a
            java.math.BigInteger r5 = r9.getS()
            r4.<init>(r0, r5, r3)
        L_0x00c8:
            org.bouncycastle.asn1.n2.h r0 = new org.bouncycastle.asn1.n2.h     // Catch: IOException -> 0x00e1
            org.bouncycastle.asn1.x509.a r5 = new org.bouncycastle.asn1.x509.a     // Catch: IOException -> 0x00e1
            org.bouncycastle.asn1.m r6 = org.bouncycastle.asn1.d2.a.m     // Catch: IOException -> 0x00e1
            org.bouncycastle.asn1.q r3 = r3.c()     // Catch: IOException -> 0x00e1
            r5.<init>(r6, r3)     // Catch: IOException -> 0x00e1
            org.bouncycastle.asn1.q r3 = r4.c()     // Catch: IOException -> 0x00e1
            r0.<init>(r5, r3)     // Catch: IOException -> 0x00e1
            byte[] r0 = r0.e(r1)     // Catch: IOException -> 0x00e1
            return r0
        L_0x00e1:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jcajce.provider.asymmetric.ecgost.BCECGOST3410PrivateKey.getEncoded():byte[]");
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
        return this.f17371d;
    }

    public int hashCode() {
        return getD().hashCode() ^ engineGetSpec().hashCode();
    }

    @Override // org.bouncycastle.jce.interfaces.b
    public void setBagAttribute(m mVar, e eVar) {
        this.attrCarrier.setBagAttribute(mVar, eVar);
    }

    public void setPointFormat(String str) {
        this.withCompression = !"UNCOMPRESSED".equalsIgnoreCase(str);
    }

    public String toString() {
        return org.bouncycastle.jcajce.provider.asymmetric.util.b.j(this.algorithm, this.f17371d, engineGetSpec());
    }
}
