package org.bouncycastle.pqc.jcajce.provider.sphincs;

import e.a.c.a.e;
import e.a.c.a.i;
import e.a.c.b.e.a;
import java.io.IOException;
import java.security.PrivateKey;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.n;
import org.bouncycastle.asn1.n2.h;
import org.bouncycastle.asn1.x0;
import org.bouncycastle.pqc.jcajce.interfaces.SPHINCSKey;

/* loaded from: classes4.dex */
public class BCSphincs256PrivateKey implements PrivateKey, SPHINCSKey {
    private static final long serialVersionUID = 1;
    private final a params;
    private final m treeDigest;

    public BCSphincs256PrivateKey(m mVar, a aVar) {
        this.treeDigest = mVar;
        this.params = aVar;
    }

    public BCSphincs256PrivateKey(h hVar) throws IOException {
        this.treeDigest = i.f(hVar.h().i()).g().f();
        this.params = new a(n.m(hVar.i()).o());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BCSphincs256PrivateKey)) {
            return false;
        }
        BCSphincs256PrivateKey bCSphincs256PrivateKey = (BCSphincs256PrivateKey) obj;
        return this.treeDigest.equals(bCSphincs256PrivateKey.treeDigest) && org.bouncycastle.util.a.c(this.params.b(), bCSphincs256PrivateKey.params.b());
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "SPHINCS-256";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return new h(new org.bouncycastle.asn1.x509.a(e.r, new i(new org.bouncycastle.asn1.x509.a(this.treeDigest))), new x0(this.params.b())).d();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.SPHINCSKey
    public byte[] getKeyData() {
        return this.params.b();
    }

    org.bouncycastle.crypto.e getKeyParams() {
        return this.params;
    }

    public int hashCode() {
        return this.treeDigest.hashCode() + (org.bouncycastle.util.a.w(this.params.b()) * 37);
    }
}
