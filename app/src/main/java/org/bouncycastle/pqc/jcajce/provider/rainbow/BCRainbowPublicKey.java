package org.bouncycastle.pqc.jcajce.provider.rainbow;

import e.a.c.a.h;
import e.a.c.b.d.c;
import e.a.c.b.d.e;
import e.a.c.b.d.f.a;
import e.a.c.c.a.b;
import java.security.PublicKey;
import org.bouncycastle.asn1.v0;

/* loaded from: classes4.dex */
public class BCRainbowPublicKey implements PublicKey {
    private static final long serialVersionUID = 1;
    private short[][] coeffquadratic;
    private short[] coeffscalar;
    private short[][] coeffsingular;
    private int docLength;
    private c rainbowParams;

    public BCRainbowPublicKey(int i, short[][] sArr, short[][] sArr2, short[] sArr3) {
        this.docLength = i;
        this.coeffquadratic = sArr;
        this.coeffsingular = sArr2;
        this.coeffscalar = sArr3;
    }

    public BCRainbowPublicKey(e eVar) {
        throw null;
    }

    public BCRainbowPublicKey(b bVar) {
        this(bVar.d(), bVar.a(), bVar.c(), bVar.b());
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof BCRainbowPublicKey)) {
            return false;
        }
        BCRainbowPublicKey bCRainbowPublicKey = (BCRainbowPublicKey) obj;
        return this.docLength == bCRainbowPublicKey.getDocLength() && a.j(this.coeffquadratic, bCRainbowPublicKey.getCoeffQuadratic()) && a.j(this.coeffsingular, bCRainbowPublicKey.getCoeffSingular()) && a.i(this.coeffscalar, bCRainbowPublicKey.getCoeffScalar());
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "Rainbow";
    }

    public short[][] getCoeffQuadratic() {
        return this.coeffquadratic;
    }

    public short[] getCoeffScalar() {
        return org.bouncycastle.util.a.k(this.coeffscalar);
    }

    public short[][] getCoeffSingular() {
        short[][] sArr = new short[this.coeffsingular.length];
        int i = 0;
        while (true) {
            short[][] sArr2 = this.coeffsingular;
            if (i == sArr2.length) {
                return sArr;
            }
            sArr[i] = org.bouncycastle.util.a.k(sArr2[i]);
            i++;
        }
    }

    public int getDocLength() {
        return this.docLength;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return org.bouncycastle.pqc.jcajce.provider.a.a.a(new org.bouncycastle.asn1.x509.a(e.a.c.a.e.a, v0.f16957c), new h(this.docLength, this.coeffquadratic, this.coeffsingular, this.coeffscalar));
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return (((((this.docLength * 37) + org.bouncycastle.util.a.C(this.coeffquadratic)) * 37) + org.bouncycastle.util.a.C(this.coeffsingular)) * 37) + org.bouncycastle.util.a.B(this.coeffscalar);
    }
}
