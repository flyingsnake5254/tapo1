package org.bouncycastle.pqc.jcajce.provider.mceliece;

import e.a.c.a.e;
import e.a.c.b.b.c;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.bouncycastle.asn1.n2.h;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.x509.w;
import org.bouncycastle.jcajce.provider.util.b;

/* loaded from: classes4.dex */
public class a extends KeyFactorySpi implements b {
    @Override // org.bouncycastle.jcajce.provider.util.b
    public PrivateKey a(h hVar) throws IOException {
        e.a.c.a.a i = e.a.c.a.a.i(hVar.i().c());
        return new BCMcElieceCCA2PrivateKey(new e.a.c.b.b.b(i.k(), i.j(), i.g(), i.h(), i.l(), null));
    }

    @Override // org.bouncycastle.jcajce.provider.util.b
    public PublicKey b(w wVar) throws IOException {
        e.a.c.a.b h = e.a.c.a.b.h(wVar.j());
        return new BCMcElieceCCA2PublicKey(new c(h.i(), h.j(), h.g(), c.b(h.f()).b()));
    }

    @Override // java.security.KeyFactorySpi
    protected PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof PKCS8EncodedKeySpec) {
            try {
                h g = h.g(q.i(((PKCS8EncodedKeySpec) keySpec).getEncoded()));
                try {
                    if (e.n.equals(g.h().f())) {
                        e.a.c.a.a i = e.a.c.a.a.i(g.i());
                        return new BCMcElieceCCA2PrivateKey(new e.a.c.b.b.b(i.k(), i.j(), i.g(), i.h(), i.l(), c.b(i.f()).b()));
                    }
                    throw new InvalidKeySpecException("Unable to recognise OID in McEliece public key");
                } catch (IOException unused) {
                    throw new InvalidKeySpecException("Unable to decode PKCS8EncodedKeySpec.");
                }
            } catch (IOException e2) {
                throw new InvalidKeySpecException("Unable to decode PKCS8EncodedKeySpec: " + e2);
            }
        } else {
            throw new InvalidKeySpecException("Unsupported key specification: " + keySpec.getClass() + ".");
        }
    }

    @Override // java.security.KeyFactorySpi
    protected PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof X509EncodedKeySpec) {
            try {
                w h = w.h(q.i(((X509EncodedKeySpec) keySpec).getEncoded()));
                try {
                    if (e.n.equals(h.f().f())) {
                        e.a.c.a.b h2 = e.a.c.a.b.h(h.j());
                        return new BCMcElieceCCA2PublicKey(new c(h2.i(), h2.j(), h2.g(), c.b(h2.f()).b()));
                    }
                    throw new InvalidKeySpecException("Unable to recognise OID in McEliece private key");
                } catch (IOException e2) {
                    throw new InvalidKeySpecException("Unable to decode X509EncodedKeySpec: " + e2.getMessage());
                }
            } catch (IOException e3) {
                throw new InvalidKeySpecException(e3.toString());
            }
        } else {
            throw new InvalidKeySpecException("Unsupported key specification: " + keySpec.getClass() + ".");
        }
    }

    @Override // java.security.KeyFactorySpi
    protected KeySpec engineGetKeySpec(Key key, Class cls) throws InvalidKeySpecException {
        return null;
    }

    @Override // java.security.KeyFactorySpi
    protected Key engineTranslateKey(Key key) throws InvalidKeyException {
        return null;
    }
}
