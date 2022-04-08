package e.a.b.b;

import java.math.BigInteger;

/* loaded from: classes4.dex */
public abstract class b {
    static final a a = new g(BigInteger.valueOf(2));

    /* renamed from: b  reason: collision with root package name */
    static final a f15491b = new g(BigInteger.valueOf(3));

    public static f a(int[] iArr) {
        if (iArr[0] == 0) {
            for (int i = 1; i < iArr.length; i++) {
                if (iArr[i] <= iArr[i - 1]) {
                    throw new IllegalArgumentException("Polynomial exponents must be montonically increasing");
                }
            }
            return new d(a, new c(iArr));
        }
        throw new IllegalArgumentException("Irreducible polynomials in GF(2) must have constant term");
    }

    public static a b(BigInteger bigInteger) {
        int bitLength = bigInteger.bitLength();
        if (bigInteger.signum() <= 0 || bitLength < 2) {
            throw new IllegalArgumentException("'characteristic' must be >= 2");
        }
        if (bitLength < 3) {
            int intValue = bigInteger.intValue();
            if (intValue == 2) {
                return a;
            }
            if (intValue == 3) {
                return f15491b;
            }
        }
        return new g(bigInteger);
    }
}
