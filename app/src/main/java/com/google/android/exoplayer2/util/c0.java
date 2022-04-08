package com.google.android.exoplayer2.util;

import androidx.core.view.MotionEventCompat;
import java.nio.charset.Charset;

/* compiled from: ParsableBitArray.java */
/* loaded from: classes.dex */
public final class c0 {
    public byte[] a;

    /* renamed from: b  reason: collision with root package name */
    private int f3896b;

    /* renamed from: c  reason: collision with root package name */
    private int f3897c;

    /* renamed from: d  reason: collision with root package name */
    private int f3898d;

    public c0() {
        this.a = o0.f3937f;
    }

    private void a() {
        int i;
        int i2 = this.f3896b;
        g.g(i2 >= 0 && (i2 < (i = this.f3898d) || (i2 == i && this.f3897c == 0)));
    }

    public int b() {
        return ((this.f3898d - this.f3896b) * 8) - this.f3897c;
    }

    public void c() {
        if (this.f3897c != 0) {
            this.f3897c = 0;
            this.f3896b++;
            a();
        }
    }

    public int d() {
        g.g(this.f3897c == 0);
        return this.f3896b;
    }

    public int e() {
        return (this.f3896b * 8) + this.f3897c;
    }

    public void f(int i, int i2) {
        if (i2 < 32) {
            i &= (1 << i2) - 1;
        }
        int min = Math.min(8 - this.f3897c, i2);
        int i3 = this.f3897c;
        int i4 = (8 - i3) - min;
        int i5 = (MotionEventCompat.ACTION_POINTER_INDEX_MASK >> i3) | ((1 << i4) - 1);
        byte[] bArr = this.a;
        int i6 = this.f3896b;
        bArr[i6] = (byte) (i5 & bArr[i6]);
        int i7 = i2 - min;
        bArr[i6] = (byte) (((i >>> i7) << i4) | bArr[i6]);
        int i8 = i6 + 1;
        while (i7 > 8) {
            i8++;
            this.a[i8] = (byte) (i >>> (i7 - 8));
            i7 -= 8;
        }
        int i9 = 8 - i7;
        byte[] bArr2 = this.a;
        bArr2[i8] = (byte) (bArr2[i8] & ((1 << i9) - 1));
        bArr2[i8] = (byte) (((i & ((1 << i7) - 1)) << i9) | bArr2[i8]);
        r(i2);
        a();
    }

    public boolean g() {
        boolean z = (this.a[this.f3896b] & (128 >> this.f3897c)) != 0;
        q();
        return z;
    }

    public int h(int i) {
        int i2;
        if (i == 0) {
            return 0;
        }
        this.f3897c += i;
        int i3 = 0;
        while (true) {
            i2 = this.f3897c;
            if (i2 <= 8) {
                break;
            }
            int i4 = i2 - 8;
            this.f3897c = i4;
            byte[] bArr = this.a;
            int i5 = this.f3896b;
            this.f3896b = i5 + 1;
            i3 |= (bArr[i5] & 255) << i4;
        }
        byte[] bArr2 = this.a;
        int i6 = this.f3896b;
        int i7 = ((-1) >>> (32 - i)) & (i3 | ((bArr2[i6] & 255) >> (8 - i2)));
        if (i2 == 8) {
            this.f3897c = 0;
            this.f3896b = i6 + 1;
        }
        a();
        return i7;
    }

    public void i(byte[] bArr, int i, int i2) {
        int i3 = (i2 >> 3) + i;
        while (i < i3) {
            byte[] bArr2 = this.a;
            int i4 = this.f3896b;
            int i5 = i4 + 1;
            this.f3896b = i5;
            byte b2 = bArr2[i4];
            int i6 = this.f3897c;
            bArr[i] = (byte) (b2 << i6);
            bArr[i] = (byte) (((255 & bArr2[i5]) >> (8 - i6)) | bArr[i]);
            i++;
        }
        int i7 = i2 & 7;
        if (i7 != 0) {
            bArr[i3] = (byte) (bArr[i3] & (255 >> i7));
            int i8 = this.f3897c;
            if (i8 + i7 > 8) {
                byte b3 = bArr[i3];
                byte[] bArr3 = this.a;
                int i9 = this.f3896b;
                this.f3896b = i9 + 1;
                bArr[i3] = (byte) (b3 | ((bArr3[i9] & 255) << i8));
                this.f3897c = i8 - 8;
            }
            int i10 = this.f3897c + i7;
            this.f3897c = i10;
            byte[] bArr4 = this.a;
            int i11 = this.f3896b;
            bArr[i3] = (byte) (((byte) (((255 & bArr4[i11]) >> (8 - i10)) << (8 - i7))) | bArr[i3]);
            if (i10 == 8) {
                this.f3897c = 0;
                this.f3896b = i11 + 1;
            }
            a();
        }
    }

    public long j(int i) {
        return i <= 32 ? o0.L0(h(i)) : o0.K0(h(i - 32), h(32));
    }

    public void k(byte[] bArr, int i, int i2) {
        g.g(this.f3897c == 0);
        System.arraycopy(this.a, this.f3896b, bArr, i, i2);
        this.f3896b += i2;
        a();
    }

    public String l(int i, Charset charset) {
        byte[] bArr = new byte[i];
        k(bArr, 0, i);
        return new String(bArr, charset);
    }

    public void m(d0 d0Var) {
        o(d0Var.d(), d0Var.f());
        p(d0Var.e() * 8);
    }

    public void n(byte[] bArr) {
        o(bArr, bArr.length);
    }

    public void o(byte[] bArr, int i) {
        this.a = bArr;
        this.f3896b = 0;
        this.f3897c = 0;
        this.f3898d = i;
    }

    public void p(int i) {
        int i2 = i / 8;
        this.f3896b = i2;
        this.f3897c = i - (i2 * 8);
        a();
    }

    public void q() {
        int i = this.f3897c + 1;
        this.f3897c = i;
        if (i == 8) {
            this.f3897c = 0;
            this.f3896b++;
        }
        a();
    }

    public void r(int i) {
        int i2 = i / 8;
        int i3 = this.f3896b + i2;
        this.f3896b = i3;
        int i4 = this.f3897c + (i - (i2 * 8));
        this.f3897c = i4;
        if (i4 > 7) {
            this.f3896b = i3 + 1;
            this.f3897c = i4 - 8;
        }
        a();
    }

    public void s(int i) {
        g.g(this.f3897c == 0);
        this.f3896b += i;
        a();
    }

    public c0(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public c0(byte[] bArr, int i) {
        this.a = bArr;
        this.f3898d = i;
    }
}
