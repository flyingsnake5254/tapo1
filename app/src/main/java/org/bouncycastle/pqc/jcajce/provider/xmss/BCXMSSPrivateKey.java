package org.bouncycastle.pqc.jcajce.provider.xmss;

import e.a.c.a.e;
import e.a.c.a.j;
import java.io.IOException;
import java.security.PrivateKey;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.n2.h;
import org.bouncycastle.pqc.crypto.xmss.BDS;
import org.bouncycastle.pqc.crypto.xmss.r;
import org.bouncycastle.pqc.crypto.xmss.s;
import org.bouncycastle.pqc.crypto.xmss.u;
import org.bouncycastle.util.a;

/* loaded from: classes4.dex */
public class BCXMSSPrivateKey implements PrivateKey {
    private final s keyParams;
    private final m treeDigest;

    public BCXMSSPrivateKey(m mVar, s sVar) {
        this.treeDigest = mVar;
        this.keyParams = sVar;
    }

    public BCXMSSPrivateKey(h hVar) throws IOException {
        j g = j.g(hVar.h().i());
        m f2 = g.h().f();
        this.treeDigest = f2;
        e.a.c.a.m h = e.a.c.a.m.h(hVar.i());
        try {
            s.b n = new s.b(new r(g.f(), a.a(f2))).l(h.g()).p(h.l()).o(h.k()).m(h.i()).n(h.j());
            if (h.f() != null) {
                n.k((BDS) u.f(h.f(), BDS.class));
            }
            this.keyParams = n.j();
        } catch (ClassNotFoundException e2) {
            throw new IOException("ClassNotFoundException processing BDS state: " + e2.getMessage());
        }
    }

    private e.a.c.a.m createKeyStructure() {
        byte[] c2 = this.keyParams.c();
        int c3 = this.keyParams.b().c();
        int d2 = this.keyParams.b().d();
        int a = (int) u.a(c2, 0, 4);
        if (u.l(d2, a)) {
            byte[] g = u.g(c2, 4, c3);
            int i = 4 + c3;
            byte[] g2 = u.g(c2, i, c3);
            int i2 = i + c3;
            byte[] g3 = u.g(c2, i2, c3);
            int i3 = i2 + c3;
            byte[] g4 = u.g(c2, i3, c3);
            int i4 = i3 + c3;
            return new e.a.c.a.m(a, g, g2, g3, g4, u.g(c2, i4, c2.length - i4));
        }
        throw new IllegalArgumentException("index out of bounds");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BCXMSSPrivateKey)) {
            return false;
        }
        BCXMSSPrivateKey bCXMSSPrivateKey = (BCXMSSPrivateKey) obj;
        return this.treeDigest.equals(bCXMSSPrivateKey.treeDigest) && a.c(this.keyParams.c(), bCXMSSPrivateKey.keyParams.c());
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "XMSS";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return new h(new org.bouncycastle.asn1.x509.a(e.w, new j(this.keyParams.b().d(), new org.bouncycastle.asn1.x509.a(this.treeDigest))), createKeyStructure()).d();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
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

    m getTreeDigestOID() {
        return this.treeDigest;
    }

    public int hashCode() {
        return this.treeDigest.hashCode() + (a.w(this.keyParams.c()) * 37);
    }
}
