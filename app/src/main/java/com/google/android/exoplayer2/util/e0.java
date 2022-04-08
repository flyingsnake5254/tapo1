package com.google.android.exoplayer2.util;

/* compiled from: ParsableNalUnitBitArray.java */
/* loaded from: classes.dex */
public final class e0 {
    private byte[] a;

    /* renamed from: b  reason: collision with root package name */
    private int f3903b;

    /* renamed from: c  reason: collision with root package name */
    private int f3904c;

    /* renamed from: d  reason: collision with root package name */
    private int f3905d;

    public e0(byte[] bArr, int i, int i2) {
        i(bArr, i, i2);
    }

    private void a() {
        int i;
        int i2 = this.f3904c;
        g.g(i2 >= 0 && (i2 < (i = this.f3903b) || (i2 == i && this.f3905d == 0)));
    }

    private int f() {
        int i = 0;
        int i2 = 0;
        while (!d()) {
            i2++;
        }
        int i3 = (1 << i2) - 1;
        if (i2 > 0) {
            i = e(i2);
        }
        return i3 + i;
    }

    private boolean j(int i) {
        if (2 <= i && i < this.f3903b) {
            byte[] bArr = this.a;
            if (bArr[i] == 3 && bArr[i - 2] == 0 && bArr[i - 1] == 0) {
                return true;
            }
        }
        return false;
    }

    public boolean b(int i) {
        int i2 = this.f3904c;
        int i3 = i / 8;
        int i4 = i2 + i3;
        int i5 = (this.f3905d + i) - (i3 * 8);
        if (i5 > 7) {
            i4++;
            i5 -= 8;
        }
        while (true) {
            i2++;
            if (i2 > i4 || i4 >= this.f3903b) {
                break;
            } else if (j(i2)) {
                i4++;
                i2 += 2;
            }
        }
        int i6 = this.f3903b;
        if (i4 >= i6) {
            return i4 == i6 && i5 == 0;
        }
        return true;
    }

    public boolean c() {
        int i = this.f3904c;
        int i2 = this.f3905d;
        int i3 = 0;
        while (this.f3904c < this.f3903b && !d()) {
            i3++;
        }
        boolean z = this.f3904c == this.f3903b;
        this.f3904c = i;
        this.f3905d = i2;
        return !z && b((i3 * 2) + 1);
    }

    public boolean d() {
        boolean z = (this.a[this.f3904c] & (128 >> this.f3905d)) != 0;
        k();
        return z;
    }

    public int e(int i) {
        int i2;
        int i3;
        this.f3905d += i;
        int i4 = 0;
        while (true) {
            i2 = this.f3905d;
            i3 = 2;
            if (i2 <= 8) {
                break;
            }
            int i5 = i2 - 8;
            this.f3905d = i5;
            byte[] bArr = this.a;
            int i6 = this.f3904c;
            i4 |= (bArr[i6] & 255) << i5;
            if (!j(i6 + 1)) {
                i3 = 1;
            }
            this.f3904c = i6 + i3;
        }
        byte[] bArr2 = this.a;
        int i7 = this.f3904c;
        int i8 = ((-1) >>> (32 - i)) & (i4 | ((bArr2[i7] & 255) >> (8 - i2)));
        if (i2 == 8) {
            this.f3905d = 0;
            if (!j(i7 + 1)) {
                i3 = 1;
            }
            this.f3904c = i7 + i3;
        }
        a();
        return i8;
    }

    public int g() {
        int f2 = f();
        return (f2 % 2 == 0 ? -1 : 1) * ((f2 + 1) / 2);
    }

    public int h() {
        return f();
    }

    public void i(byte[] bArr, int i, int i2) {
        this.a = bArr;
        this.f3904c = i;
        this.f3903b = i2;
        this.f3905d = 0;
        a();
    }

    public void k() {
        int i = 1;
        int i2 = this.f3905d + 1;
        this.f3905d = i2;
        if (i2 == 8) {
            this.f3905d = 0;
            int i3 = this.f3904c;
            if (j(i3 + 1)) {
                i = 2;
            }
            this.f3904c = i3 + i;
        }
        a();
    }

    public void l(int i) {
        int i2 = this.f3904c;
        int i3 = i / 8;
        int i4 = i2 + i3;
        this.f3904c = i4;
        int i5 = this.f3905d + (i - (i3 * 8));
        this.f3905d = i5;
        if (i5 > 7) {
            this.f3904c = i4 + 1;
            this.f3905d = i5 - 8;
        }
        while (true) {
            i2++;
            if (i2 > this.f3904c) {
                a();
                return;
            } else if (j(i2)) {
                this.f3904c++;
                i2 += 2;
            }
        }
    }
}
