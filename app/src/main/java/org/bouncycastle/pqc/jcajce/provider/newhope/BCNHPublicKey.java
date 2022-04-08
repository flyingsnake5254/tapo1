package org.bouncycastle.pqc.jcajce.provider.newhope;

import e.a.c.a.e;
import e.a.c.b.c.b;
import java.io.IOException;
import org.bouncycastle.asn1.x509.w;
import org.bouncycastle.pqc.jcajce.interfaces.NHPublicKey;
import org.bouncycastle.util.a;

/* loaded from: classes4.dex */
public class BCNHPublicKey implements NHPublicKey {
    private static final long serialVersionUID = 1;
    private final b params;

    public BCNHPublicKey(b bVar) {
        this.params = bVar;
    }

    public BCNHPublicKey(w wVar) {
        this.params = new b(wVar.i().o());
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof BCNHPublicKey)) {
            return false;
        }
        return a.c(this.params.b(), ((BCNHPublicKey) obj).params.b());
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "NH";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return new w(new org.bouncycastle.asn1.x509.a(e.v), this.params.b()).d();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    org.bouncycastle.crypto.e getKeyParams() {
        return this.params;
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.NHPublicKey
    public byte[] getPublicData() {
        return this.params.b();
    }

    public int hashCode() {
        return a.w(this.params.b());
    }
}
