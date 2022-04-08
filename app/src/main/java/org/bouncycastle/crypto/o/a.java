package org.bouncycastle.crypto.o;

import java.math.BigInteger;
import org.bouncycastle.crypto.w.b;
import org.bouncycastle.crypto.w.c0;
import org.bouncycastle.crypto.w.e;
import org.bouncycastle.crypto.w.f;
import org.bouncycastle.crypto.w.g;

/* loaded from: classes4.dex */
public class a {
    private static final BigInteger a = BigInteger.valueOf(1);

    /* renamed from: b  reason: collision with root package name */
    private f f17109b;

    /* renamed from: c  reason: collision with root package name */
    private e f17110c;

    public BigInteger a(org.bouncycastle.crypto.e eVar) {
        g gVar = (g) eVar;
        if (gVar.b().equals(this.f17110c)) {
            BigInteger f2 = this.f17110c.f();
            BigInteger c2 = gVar.c();
            if (c2 != null) {
                BigInteger bigInteger = a;
                if (c2.compareTo(bigInteger) > 0 && c2.compareTo(f2.subtract(bigInteger)) < 0) {
                    BigInteger modPow = c2.modPow(this.f17109b.c(), f2);
                    if (!modPow.equals(bigInteger)) {
                        return modPow;
                    }
                    throw new IllegalStateException("Shared key can't be 1");
                }
            }
            throw new IllegalArgumentException("Diffie-Hellman public key is weak");
        }
        throw new IllegalArgumentException("Diffie-Hellman public key has wrong parameters.");
    }

    public void b(org.bouncycastle.crypto.e eVar) {
        if (eVar instanceof c0) {
            eVar = ((c0) eVar).a();
        }
        b bVar = (b) eVar;
        if (bVar instanceof f) {
            f fVar = (f) bVar;
            this.f17109b = fVar;
            this.f17110c = fVar.b();
            return;
        }
        throw new IllegalArgumentException("DHEngine expects DHPrivateKeyParameters");
    }
}
