package org.bouncycastle.pqc.jcajce.provider.xmss;

import e.a.c.a.e;
import e.a.c.a.j;
import e.a.c.a.n;
import java.io.IOException;
import java.security.PublicKey;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.x509.w;
import org.bouncycastle.pqc.crypto.xmss.r;
import org.bouncycastle.pqc.crypto.xmss.t;
import org.bouncycastle.util.a;

/* loaded from: classes4.dex */
public class BCXMSSPublicKey implements PublicKey {
    private final t keyParams;
    private final m treeDigest;

    public BCXMSSPublicKey(m mVar, t tVar) {
        this.treeDigest = mVar;
        this.keyParams = tVar;
    }

    public BCXMSSPublicKey(w wVar) throws IOException {
        j g = j.g(wVar.f().i());
        m f2 = g.h().f();
        this.treeDigest = f2;
        n f3 = n.f(wVar.j());
        this.keyParams = new t.b(new r(g.f(), a.a(f2))).f(f3.g()).g(f3.h()).e();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BCXMSSPublicKey)) {
            return false;
        }
        BCXMSSPublicKey bCXMSSPublicKey = (BCXMSSPublicKey) obj;
        return this.treeDigest.equals(bCXMSSPublicKey.treeDigest) && a.c(this.keyParams.e(), bCXMSSPublicKey.keyParams.e());
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "XMSS";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return new w(new org.bouncycastle.asn1.x509.a(e.w, new j(this.keyParams.b().d(), new org.bouncycastle.asn1.x509.a(this.treeDigest))), new n(this.keyParams.c(), this.keyParams.d())).d();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public int getHeight() {
        return this.keyParams.b().d();
    }

    org.bouncycastle.crypto.e getKeyParams() {
        return this.keyParams;
    }

    public String getTreeDigest() {
        return a.b(this.treeDigest);
    }

    public int hashCode() {
        return this.treeDigest.hashCode() + (a.w(this.keyParams.e()) * 37);
    }
}
