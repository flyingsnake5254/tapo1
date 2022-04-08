package org.bouncycastle.pqc.jcajce.provider.xmss;

import e.a.c.a.e;
import e.a.c.a.k;
import e.a.c.a.l;
import java.io.IOException;
import java.security.PrivateKey;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.n2.h;
import org.bouncycastle.pqc.crypto.xmss.BDSStateMap;
import org.bouncycastle.pqc.crypto.xmss.n;
import org.bouncycastle.pqc.crypto.xmss.u;
import org.bouncycastle.util.a;

/* loaded from: classes4.dex */
public class BCXMSSMTPrivateKey implements PrivateKey {
    private final n keyParams;
    private final m treeDigest;

    public BCXMSSMTPrivateKey(m mVar, n nVar) {
        this.treeDigest = mVar;
        this.keyParams = nVar;
    }

    public BCXMSSMTPrivateKey(h hVar) throws IOException {
        k g = k.g(hVar.h().i());
        m f2 = g.i().f();
        this.treeDigest = f2;
        e.a.c.a.m h = e.a.c.a.m.h(hVar.i());
        try {
            n.b n = new n.b(new org.bouncycastle.pqc.crypto.xmss.m(g.f(), g.h(), a.a(f2))).l(h.g()).p(h.l()).o(h.k()).m(h.i()).n(h.j());
            if (h.f() != null) {
                n.k((BDSStateMap) u.f(h.f(), BDSStateMap.class));
            }
            this.keyParams = n.j();
        } catch (ClassNotFoundException e2) {
            throw new IOException("ClassNotFoundException processing BDS state: " + e2.getMessage());
        }
    }

    private l createKeyStructure() {
        byte[] c2 = this.keyParams.c();
        int b2 = this.keyParams.b().b();
        int c3 = this.keyParams.b().c();
        int i = (c3 + 7) / 8;
        int a = (int) u.a(c2, 0, i);
        if (u.l(c3, a)) {
            int i2 = i + 0;
            byte[] g = u.g(c2, i2, b2);
            int i3 = i2 + b2;
            byte[] g2 = u.g(c2, i3, b2);
            int i4 = i3 + b2;
            byte[] g3 = u.g(c2, i4, b2);
            int i5 = i4 + b2;
            byte[] g4 = u.g(c2, i5, b2);
            int i6 = i5 + b2;
            return new l(a, g, g2, g3, g4, u.g(c2, i6, c2.length - i6));
        }
        throw new IllegalArgumentException("index out of bounds");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BCXMSSMTPrivateKey)) {
            return false;
        }
        BCXMSSMTPrivateKey bCXMSSMTPrivateKey = (BCXMSSMTPrivateKey) obj;
        return this.treeDigest.equals(bCXMSSMTPrivateKey.treeDigest) && a.c(this.keyParams.c(), bCXMSSMTPrivateKey.keyParams.c());
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "XMSSMT";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return new h(new org.bouncycastle.asn1.x509.a(e.B, new k(this.keyParams.b().c(), this.keyParams.b().d(), new org.bouncycastle.asn1.x509.a(this.treeDigest))), createKeyStructure()).d();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public int getHeight() {
        return this.keyParams.b().c();
    }

    org.bouncycastle.crypto.e getKeyParams() {
        return this.keyParams;
    }

    public int getLayers() {
        return this.keyParams.b().d();
    }

    public String getTreeDigest() {
        return a.b(this.treeDigest);
    }

    m getTreeDigestOID() {
        return this.treeDigest;
    }

    public int hashCode() {
        return this.treeDigest.hashCode() + (a.w(this.keyParams.c()) * 37);
    }
}
