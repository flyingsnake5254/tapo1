package org.bouncycastle.pqc.jcajce.provider.mceliece;

import e.a.c.a.d;
import e.a.c.a.e;
import e.a.c.b.b.g;
import java.io.IOException;
import java.security.PublicKey;
import org.bouncycastle.asn1.x509.a;
import org.bouncycastle.asn1.x509.w;
import org.bouncycastle.crypto.w.b;

/* loaded from: classes4.dex */
public class BCMcEliecePublicKey implements PublicKey {
    private static final long serialVersionUID = 1;
    private g params;

    public BCMcEliecePublicKey(g gVar) {
        this.params = gVar;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BCMcEliecePublicKey)) {
            return false;
        }
        BCMcEliecePublicKey bCMcEliecePublicKey = (BCMcEliecePublicKey) obj;
        return this.params.d() == bCMcEliecePublicKey.getN() && this.params.e() == bCMcEliecePublicKey.getT() && this.params.b().equals(bCMcEliecePublicKey.getG());
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "McEliece";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return new w(new a(e.m), new d(this.params.d(), this.params.e(), this.params.b())).d();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public e.a.c.d.a.a getG() {
        return this.params.b();
    }

    public int getK() {
        return this.params.c();
    }

    b getKeyParams() {
        return this.params;
    }

    public int getN() {
        return this.params.d();
    }

    public int getT() {
        return this.params.e();
    }

    public int hashCode() {
        return ((this.params.d() + (this.params.e() * 37)) * 37) + this.params.b().hashCode();
    }

    public String toString() {
        return (("McEliecePublicKey:\n length of the code         : " + this.params.d() + "\n") + " error correction capability: " + this.params.e() + "\n") + " generator matrix           : " + this.params.b();
    }
}
