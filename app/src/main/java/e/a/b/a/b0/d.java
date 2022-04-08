package e.a.b.a.b0;

import java.math.BigInteger;

/* loaded from: classes4.dex */
public class d {
    protected final BigInteger a;

    /* renamed from: b  reason: collision with root package name */
    protected final BigInteger f15433b;

    /* renamed from: c  reason: collision with root package name */
    protected final BigInteger f15434c;

    /* renamed from: d  reason: collision with root package name */
    protected final BigInteger f15435d;

    /* renamed from: e  reason: collision with root package name */
    protected final BigInteger f15436e;

    /* renamed from: f  reason: collision with root package name */
    protected final BigInteger f15437f;
    protected final BigInteger g;
    protected final BigInteger h;
    protected final int i;

    public d(BigInteger bigInteger, BigInteger bigInteger2, BigInteger[] bigIntegerArr, BigInteger[] bigIntegerArr2, BigInteger bigInteger3, BigInteger bigInteger4, int i) {
        a(bigIntegerArr, "v1");
        a(bigIntegerArr2, "v2");
        this.a = bigInteger;
        this.f15433b = bigInteger2;
        this.f15434c = bigIntegerArr[0];
        this.f15435d = bigIntegerArr[1];
        this.f15436e = bigIntegerArr2[0];
        this.f15437f = bigIntegerArr2[1];
        this.g = bigInteger3;
        this.h = bigInteger4;
        this.i = i;
    }

    private static void a(BigInteger[] bigIntegerArr, String str) {
        if (bigIntegerArr == null || bigIntegerArr.length != 2 || bigIntegerArr[0] == null || bigIntegerArr[1] == null) {
            throw new IllegalArgumentException("'" + str + "' must consist of exactly 2 (non-null) values");
        }
    }

    public BigInteger b() {
        return this.a;
    }

    public int c() {
        return this.i;
    }

    public BigInteger d() {
        return this.g;
    }

    public BigInteger e() {
        return this.h;
    }

    public BigInteger f() {
        return this.f15434c;
    }

    public BigInteger g() {
        return this.f15435d;
    }

    public BigInteger h() {
        return this.f15436e;
    }

    public BigInteger i() {
        return this.f15437f;
    }
}
