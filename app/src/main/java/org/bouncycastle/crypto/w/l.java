package org.bouncycastle.crypto.w;

import java.math.BigInteger;

/* loaded from: classes4.dex */
public class l extends i {

    /* renamed from: f  reason: collision with root package name */
    private static final BigInteger f17356f = BigInteger.valueOf(1);
    private static final BigInteger q = BigInteger.valueOf(2);
    private BigInteger x;

    public l(BigInteger bigInteger, j jVar) {
        super(false, jVar);
        this.x = d(bigInteger, jVar);
    }

    private BigInteger d(BigInteger bigInteger, j jVar) {
        if (jVar == null) {
            return bigInteger;
        }
        BigInteger bigInteger2 = q;
        if (bigInteger2.compareTo(bigInteger) <= 0 && jVar.b().subtract(bigInteger2).compareTo(bigInteger) >= 0 && f17356f.equals(bigInteger.modPow(jVar.c(), jVar.b()))) {
            return bigInteger;
        }
        throw new IllegalArgumentException("y value does not appear to be in correct group");
    }

    public BigInteger c() {
        return this.x;
    }
}
