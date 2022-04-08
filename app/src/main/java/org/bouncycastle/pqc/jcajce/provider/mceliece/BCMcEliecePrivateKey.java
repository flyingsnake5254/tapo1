package org.bouncycastle.pqc.jcajce.provider.mceliece;

import e.a.c.a.c;
import e.a.c.b.b.f;
import e.a.c.d.a.b;
import e.a.c.d.a.i;
import java.io.IOException;
import java.security.PrivateKey;
import org.bouncycastle.asn1.n2.h;
import org.bouncycastle.asn1.x509.a;
import org.bouncycastle.crypto.e;

/* loaded from: classes4.dex */
public class BCMcEliecePrivateKey implements e, PrivateKey {
    private static final long serialVersionUID = 1;
    private f params;

    public BCMcEliecePrivateKey(f fVar) {
        this.params = fVar;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BCMcEliecePrivateKey)) {
            return false;
        }
        BCMcEliecePrivateKey bCMcEliecePrivateKey = (BCMcEliecePrivateKey) obj;
        return getN() == bCMcEliecePrivateKey.getN() && getK() == bCMcEliecePrivateKey.getK() && getField().equals(bCMcEliecePrivateKey.getField()) && getGoppaPoly().equals(bCMcEliecePrivateKey.getGoppaPoly()) && getSInv().equals(bCMcEliecePrivateKey.getSInv()) && getP1().equals(bCMcEliecePrivateKey.getP1()) && getP2().equals(bCMcEliecePrivateKey.getP2());
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "McEliece";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return new h(new a(e.a.c.a.e.m), new c(this.params.f(), this.params.e(), this.params.b(), this.params.c(), this.params.g(), this.params.h(), this.params.j())).d();
        } catch (IOException unused) {
            return null;
        }
    }

    public b getField() {
        return this.params.b();
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public i getGoppaPoly() {
        return this.params.c();
    }

    public e.a.c.d.a.a getH() {
        return this.params.d();
    }

    public int getK() {
        return this.params.e();
    }

    org.bouncycastle.crypto.w.b getKeyParams() {
        return this.params;
    }

    public int getN() {
        return this.params.f();
    }

    public e.a.c.d.a.h getP1() {
        return this.params.g();
    }

    public e.a.c.d.a.h getP2() {
        return this.params.h();
    }

    public i[] getQInv() {
        return this.params.i();
    }

    public e.a.c.d.a.a getSInv() {
        return this.params.j();
    }

    public int hashCode() {
        return (((((((((((this.params.e() * 37) + this.params.f()) * 37) + this.params.b().hashCode()) * 37) + this.params.c().hashCode()) * 37) + this.params.g().hashCode()) * 37) + this.params.h().hashCode()) * 37) + this.params.j().hashCode();
    }
}
