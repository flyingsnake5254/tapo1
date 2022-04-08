package e.a.b.a;

import java.math.BigInteger;

/* loaded from: classes4.dex */
class r {
    private final BigInteger a;

    /* renamed from: b  reason: collision with root package name */
    private final int f15471b;

    public r(BigInteger bigInteger, int i) {
        if (i >= 0) {
            this.a = bigInteger;
            this.f15471b = i;
            return;
        }
        throw new IllegalArgumentException("scale may not be negative");
    }

    private void c(r rVar) {
        if (this.f15471b != rVar.f15471b) {
            throw new IllegalArgumentException("Only SimpleBigDecimal of same scale allowed in arithmetic operations");
        }
    }

    public r a(r rVar) {
        c(rVar);
        return new r(this.a.add(rVar.a), this.f15471b);
    }

    public r b(int i) {
        if (i >= 0) {
            int i2 = this.f15471b;
            return i == i2 ? this : new r(this.a.shiftLeft(i - i2), i);
        }
        throw new IllegalArgumentException("scale may not be negative");
    }

    public int d(BigInteger bigInteger) {
        return this.a.compareTo(bigInteger.shiftLeft(this.f15471b));
    }

    public BigInteger e() {
        return this.a.shiftRight(this.f15471b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return this.a.equals(rVar.a) && this.f15471b == rVar.f15471b;
    }

    public int f() {
        return this.f15471b;
    }

    public r g() {
        return new r(this.a.negate(), this.f15471b);
    }

    public BigInteger h() {
        return a(new r(c.f15438b, 1).b(this.f15471b)).e();
    }

    public int hashCode() {
        return this.a.hashCode() ^ this.f15471b;
    }

    public r i(BigInteger bigInteger) {
        return new r(this.a.subtract(bigInteger.shiftLeft(this.f15471b)), this.f15471b);
    }

    public r j(r rVar) {
        return a(rVar.g());
    }

    public String toString() {
        if (this.f15471b == 0) {
            return this.a.toString();
        }
        BigInteger e2 = e();
        BigInteger subtract = this.a.subtract(e2.shiftLeft(this.f15471b));
        if (this.a.signum() == -1) {
            subtract = c.f15438b.shiftLeft(this.f15471b).subtract(subtract);
        }
        if (e2.signum() == -1 && !subtract.equals(c.a)) {
            e2 = e2.add(c.f15438b);
        }
        String bigInteger = e2.toString();
        char[] cArr = new char[this.f15471b];
        String bigInteger2 = subtract.toString(2);
        int length = bigInteger2.length();
        int i = this.f15471b - length;
        for (int i2 = 0; i2 < i; i2++) {
            cArr[i2] = '0';
        }
        for (int i3 = 0; i3 < length; i3++) {
            cArr[i + i3] = bigInteger2.charAt(i3);
        }
        String str = new String(cArr);
        StringBuffer stringBuffer = new StringBuffer(bigInteger);
        stringBuffer.append(".");
        stringBuffer.append(str);
        return stringBuffer.toString();
    }
}
