package org.bouncycastle.crypto.engines;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.a;
import org.bouncycastle.crypto.e;
import org.bouncycastle.crypto.f;
import org.bouncycastle.crypto.w.c0;
import org.bouncycastle.crypto.w.d0;
import org.bouncycastle.crypto.w.e0;
import org.bouncycastle.util.b;

/* loaded from: classes4.dex */
public class h implements a {
    private static final BigInteger a = BigInteger.valueOf(1);

    /* renamed from: b  reason: collision with root package name */
    private i f17085b = new i();

    /* renamed from: c  reason: collision with root package name */
    private d0 f17086c;

    /* renamed from: d  reason: collision with root package name */
    private SecureRandom f17087d;

    @Override // org.bouncycastle.crypto.a
    public void a(boolean z, e eVar) {
        SecureRandom secureRandom;
        this.f17085b.e(z, eVar);
        if (eVar instanceof c0) {
            c0 c0Var = (c0) eVar;
            this.f17086c = (d0) c0Var.a();
            secureRandom = c0Var.b();
        } else {
            this.f17086c = (d0) eVar;
            secureRandom = f.b();
        }
        this.f17087d = secureRandom;
    }

    @Override // org.bouncycastle.crypto.a
    public int b() {
        return this.f17085b.d();
    }

    @Override // org.bouncycastle.crypto.a
    public int c() {
        return this.f17085b.c();
    }

    @Override // org.bouncycastle.crypto.a
    public byte[] d(byte[] bArr, int i, int i2) {
        BigInteger bigInteger;
        e0 e0Var;
        BigInteger h;
        if (this.f17086c != null) {
            BigInteger a2 = this.f17085b.a(bArr, i, i2);
            d0 d0Var = this.f17086c;
            if (!(d0Var instanceof e0) || (h = (e0Var = (e0) d0Var).h()) == null) {
                bigInteger = this.f17085b.f(a2);
            } else {
                BigInteger c2 = e0Var.c();
                BigInteger bigInteger2 = a;
                BigInteger c3 = b.c(bigInteger2, c2.subtract(bigInteger2), this.f17087d);
                bigInteger = this.f17085b.f(c3.modPow(h, c2).multiply(a2).mod(c2)).multiply(c3.modInverse(c2)).mod(c2);
                if (!a2.equals(bigInteger.modPow(h, c2))) {
                    throw new IllegalStateException("RSA engine faulty decryption/signing detected");
                }
            }
            return this.f17085b.b(bigInteger);
        }
        throw new IllegalStateException("RSA engine not initialised");
    }
}
