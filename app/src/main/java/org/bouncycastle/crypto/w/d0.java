package org.bouncycastle.crypto.w;

import java.math.BigInteger;

/* loaded from: classes4.dex */
public class d0 extends b {

    /* renamed from: d  reason: collision with root package name */
    private static final BigInteger f17344d = BigInteger.valueOf(1);

    /* renamed from: f  reason: collision with root package name */
    private BigInteger f17345f;
    private BigInteger q;

    public d0(boolean z, BigInteger bigInteger, BigInteger bigInteger2) {
        super(z);
        if (z || (bigInteger2.intValue() & 1) != 0) {
            this.f17345f = d(bigInteger);
            this.q = bigInteger2;
            return;
        }
        throw new IllegalArgumentException("RSA publicExponent is even");
    }

    private BigInteger d(BigInteger bigInteger) {
        if ((bigInteger.intValue() & 1) == 0) {
            throw new IllegalArgumentException("RSA modulus is even");
        } else if (bigInteger.gcd(new BigInteger("1451887755777639901511587432083070202422614380984889313550570919659315177065956574359078912654149167643992684236991305777574330831666511589145701059710742276692757882915756220901998212975756543223550490431013061082131040808010565293748926901442915057819663730454818359472391642885328171302299245556663073719855")).equals(f17344d)) {
            return bigInteger;
        } else {
            throw new IllegalArgumentException("RSA modulus has a small prime factor");
        }
    }

    public BigInteger b() {
        return this.q;
    }

    public BigInteger c() {
        return this.f17345f;
    }
}
