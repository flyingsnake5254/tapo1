package org.bouncycastle.pqc.jcajce.provider.mceliece;

import e.a.c.a.b;
import e.a.c.b.b.c;
import java.io.IOException;
import java.security.PublicKey;
import org.bouncycastle.asn1.x509.a;
import org.bouncycastle.asn1.x509.w;
import org.bouncycastle.crypto.e;

/* loaded from: classes4.dex */
public class BCMcElieceCCA2PublicKey implements e, PublicKey {
    private static final long serialVersionUID = 1;
    private c params;

    public BCMcElieceCCA2PublicKey(c cVar) {
        this.params = cVar;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof BCMcElieceCCA2PublicKey)) {
            return false;
        }
        BCMcElieceCCA2PublicKey bCMcElieceCCA2PublicKey = (BCMcElieceCCA2PublicKey) obj;
        return this.params.e() == bCMcElieceCCA2PublicKey.getN() && this.params.f() == bCMcElieceCCA2PublicKey.getT() && this.params.c().equals(bCMcElieceCCA2PublicKey.getG());
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "McEliece-CCA2";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return new w(new a(e.a.c.a.e.n), new b(this.params.e(), this.params.f(), this.params.c(), c.a(this.params.b()))).d();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public e.a.c.d.a.a getG() {
        return this.params.c();
    }

    public int getK() {
        return this.params.d();
    }

    org.bouncycastle.crypto.w.b getKeyParams() {
        return this.params;
    }

    public int getN() {
        return this.params.e();
    }

    public int getT() {
        return this.params.f();
    }

    public int hashCode() {
        return ((this.params.e() + (this.params.f() * 37)) * 37) + this.params.c().hashCode();
    }

    public String toString() {
        return (("McEliecePublicKey:\n length of the code         : " + this.params.e() + "\n") + " error correction capability: " + this.params.f() + "\n") + " generator matrix           : " + this.params.c().toString();
    }
}
