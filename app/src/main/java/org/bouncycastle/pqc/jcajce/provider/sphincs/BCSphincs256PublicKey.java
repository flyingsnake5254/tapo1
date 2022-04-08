package org.bouncycastle.pqc.jcajce.provider.sphincs;

import e.a.c.a.e;
import e.a.c.a.i;
import e.a.c.b.e.b;
import java.io.IOException;
import java.security.PublicKey;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.x509.w;
import org.bouncycastle.pqc.jcajce.interfaces.SPHINCSKey;
import org.bouncycastle.util.a;

/* loaded from: classes4.dex */
public class BCSphincs256PublicKey implements PublicKey, SPHINCSKey {
    private static final long serialVersionUID = 1;
    private final b params;
    private final m treeDigest;

    public BCSphincs256PublicKey(m mVar, b bVar) {
        this.treeDigest = mVar;
        this.params = bVar;
    }

    public BCSphincs256PublicKey(w wVar) {
        this.treeDigest = i.f(wVar.f().i()).g().f();
        this.params = new b(wVar.i().o());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BCSphincs256PublicKey)) {
            return false;
        }
        BCSphincs256PublicKey bCSphincs256PublicKey = (BCSphincs256PublicKey) obj;
        return this.treeDigest.equals(bCSphincs256PublicKey.treeDigest) && a.c(this.params.b(), bCSphincs256PublicKey.params.b());
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "SPHINCS-256";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return new w(new org.bouncycastle.asn1.x509.a(e.r, new i(new org.bouncycastle.asn1.x509.a(this.treeDigest))), this.params.b()).d();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.SPHINCSKey
    public byte[] getKeyData() {
        return this.params.b();
    }

    org.bouncycastle.crypto.e getKeyParams() {
        return this.params;
    }

    public int hashCode() {
        return this.treeDigest.hashCode() + (a.w(this.params.b()) * 37);
    }
}
