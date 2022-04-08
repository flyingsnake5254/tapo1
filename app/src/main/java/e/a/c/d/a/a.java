package e.a.c.d.a;

import java.lang.reflect.Array;

/* loaded from: classes4.dex */
public class a extends g {

    /* renamed from: c  reason: collision with root package name */
    private int[][] f15557c;

    /* renamed from: d  reason: collision with root package name */
    private int f15558d;

    public a(int i, int[][] iArr) {
        if (iArr[0].length == ((i + 31) >> 5)) {
            this.f15565b = i;
            this.a = iArr.length;
            this.f15558d = iArr[0].length;
            int i2 = i & 31;
            int i3 = i2 == 0 ? -1 : (1 << i2) - 1;
            for (int i4 = 0; i4 < this.a; i4++) {
                int[] iArr2 = iArr[i4];
                int i5 = this.f15558d - 1;
                iArr2[i5] = iArr2[i5] & i3;
            }
            this.f15557c = iArr;
            return;
        }
        throw new ArithmeticException("Int array does not match given number of columns.");
    }

    public a(a aVar) {
        this.f15565b = aVar.a();
        this.a = aVar.b();
        this.f15558d = aVar.f15558d;
        this.f15557c = new int[aVar.f15557c.length];
        int i = 0;
        while (true) {
            int[][] iArr = this.f15557c;
            if (i < iArr.length) {
                iArr[i] = d.a(aVar.f15557c[i]);
                i++;
            } else {
                return;
            }
        }
    }

    public a(byte[] bArr) {
        if (bArr.length >= 9) {
            this.a = f.e(bArr, 0);
            int e2 = f.e(bArr, 4);
            this.f15565b = e2;
            int i = this.a;
            int i2 = ((e2 + 7) >>> 3) * i;
            if (i > 0) {
                int i3 = 8;
                if (i2 == bArr.length - 8) {
                    int i4 = (e2 + 31) >>> 5;
                    this.f15558d = i4;
                    this.f15557c = (int[][]) Array.newInstance(int.class, i, i4);
                    int i5 = this.f15565b;
                    int i6 = i5 >> 5;
                    int i7 = i5 & 31;
                    for (int i8 = 0; i8 < this.a; i8++) {
                        int i9 = 0;
                        while (i9 < i6) {
                            this.f15557c[i8][i9] = f.e(bArr, i3);
                            i9++;
                            i3 += 4;
                        }
                        for (int i10 = 0; i10 < i7; i10 += 8) {
                            int[] iArr = this.f15557c[i8];
                            i3++;
                            iArr[i6] = ((bArr[i3] & 255) << i10) ^ iArr[i6];
                        }
                    }
                    return;
                }
            }
            throw new ArithmeticException("given array is not an encoded matrix over GF(2)");
        }
        throw new ArithmeticException("given array is not an encoded matrix over GF(2)");
    }

    public byte[] c() {
        int i = this.a;
        int i2 = 8;
        byte[] bArr = new byte[(((this.f15565b + 7) >>> 3) * i) + 8];
        f.a(i, bArr, 0);
        f.a(this.f15565b, bArr, 4);
        int i3 = this.f15565b;
        int i4 = i3 >>> 5;
        int i5 = i3 & 31;
        for (int i6 = 0; i6 < this.a; i6++) {
            int i7 = 0;
            while (i7 < i4) {
                f.a(this.f15557c[i6][i7], bArr, i2);
                i7++;
                i2 += 4;
            }
            for (int i8 = 0; i8 < i5; i8 += 8) {
                i2++;
                bArr[i2] = (byte) ((this.f15557c[i6][i4] >>> i8) & 255);
            }
        }
        return bArr;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!(this.a == aVar.a && this.f15565b == aVar.f15565b && this.f15558d == aVar.f15558d)) {
            return false;
        }
        for (int i = 0; i < this.a; i++) {
            if (!d.b(this.f15557c[i], aVar.f15557c[i])) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = (((this.a * 31) + this.f15565b) * 31) + this.f15558d;
        for (int i2 = 0; i2 < this.a; i2++) {
            i = (i * 31) + this.f15557c[i2].hashCode();
        }
        return i;
    }

    public String toString() {
        int i = this.f15565b & 31;
        int i2 = this.f15558d;
        if (i != 0) {
            i2--;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < this.a; i3++) {
            stringBuffer.append(i3 + ": ");
            for (int i4 = 0; i4 < i2; i4++) {
                int i5 = this.f15557c[i3][i4];
                for (int i6 = 0; i6 < 32; i6++) {
                    if (((i5 >>> i6) & 1) == 0) {
                        stringBuffer.append('0');
                    } else {
                        stringBuffer.append('1');
                    }
                }
                stringBuffer.append(' ');
            }
            int i7 = this.f15557c[i3][this.f15558d - 1];
            for (int i8 = 0; i8 < i; i8++) {
                if (((i7 >>> i8) & 1) == 0) {
                    stringBuffer.append('0');
                } else {
                    stringBuffer.append('1');
                }
            }
            stringBuffer.append('\n');
        }
        return stringBuffer.toString();
    }
}
