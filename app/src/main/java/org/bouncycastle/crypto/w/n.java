package org.bouncycastle.crypto.w;

import e.a.b.a.b;
import e.a.b.a.c;
import e.a.b.a.d;
import e.a.b.a.h;
import java.math.BigInteger;
import java.util.Objects;
import org.bouncycastle.util.a;

/* loaded from: classes4.dex */
public class n implements c {
    private d g;
    private byte[] h;
    private h i;
    private BigInteger j;
    private BigInteger k;
    private BigInteger l;

    public n(d dVar, h hVar, BigInteger bigInteger) {
        this(dVar, hVar, bigInteger, c.f15438b, null);
    }

    public n(d dVar, h hVar, BigInteger bigInteger, BigInteger bigInteger2) {
        this(dVar, hVar, bigInteger, bigInteger2, null);
    }

    public n(d dVar, h hVar, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this.l = null;
        Objects.requireNonNull(dVar, "curve");
        Objects.requireNonNull(bigInteger, "n");
        this.g = dVar;
        this.i = g(dVar, hVar);
        this.j = bigInteger;
        this.k = bigInteger2;
        this.h = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static h g(d dVar, h hVar) {
        if (hVar == null) {
            throw new IllegalArgumentException("point has null value");
        } else if (!hVar.u()) {
            h A = hVar.A();
            if (A.w()) {
                return b.f(dVar, A);
            }
            throw new IllegalArgumentException("point not on curve");
        } else {
            throw new IllegalArgumentException("point at infinity");
        }
    }

    public d a() {
        return this.g;
    }

    public h b() {
        return this.i;
    }

    public BigInteger c() {
        return this.k;
    }

    public synchronized BigInteger d() {
        if (this.l == null) {
            this.l = this.k.modInverse(this.j);
        }
        return this.l;
    }

    public BigInteger e() {
        return this.j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return this.g.m(nVar.g) && this.i.e(nVar.i) && this.j.equals(nVar.j) && this.k.equals(nVar.k);
    }

    public byte[] f() {
        return a.g(this.h);
    }

    public int hashCode() {
        return (((((this.g.hashCode() * 37) ^ this.i.hashCode()) * 37) ^ this.j.hashCode()) * 37) ^ this.k.hashCode();
    }
}
