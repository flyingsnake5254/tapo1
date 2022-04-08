package e.a.c.d.a;

import java.math.BigInteger;
import java.security.SecureRandom;

/* loaded from: classes4.dex */
public final class e {
    private static final BigInteger a = BigInteger.valueOf(0);

    /* renamed from: b  reason: collision with root package name */
    private static final BigInteger f15560b = BigInteger.valueOf(1);

    /* renamed from: c  reason: collision with root package name */
    private static final BigInteger f15561c = BigInteger.valueOf(2);

    /* renamed from: d  reason: collision with root package name */
    private static final BigInteger f15562d = BigInteger.valueOf(4);

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f15563e = {3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41};

    /* renamed from: f  reason: collision with root package name */
    private static SecureRandom f15564f = null;
    private static final int[] g = {0, 1, 0, -1, 0, -1, 0, 1};

    public static int a(int i) {
        if (i == 0) {
            return 1;
        }
        if (i < 0) {
            i = -i;
        }
        int i2 = 0;
        while (i > 0) {
            i2++;
            i >>>= 8;
        }
        return i2;
    }
}
