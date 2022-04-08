package com.google.android.exoplayer2.util;

import androidx.annotation.Nullable;
import com.google.common.base.e;
import java.nio.charset.Charset;
import java.util.Arrays;

/* compiled from: ParsableByteArray.java */
/* loaded from: classes.dex */
public final class d0 {
    private byte[] a;

    /* renamed from: b  reason: collision with root package name */
    private int f3900b;

    /* renamed from: c  reason: collision with root package name */
    private int f3901c;

    public d0() {
        this.a = o0.f3937f;
    }

    public String A(int i) {
        return B(i, e.f4125c);
    }

    public String B(int i, Charset charset) {
        String str = new String(this.a, this.f3900b, i, charset);
        this.f3900b += i;
        return str;
    }

    public int C() {
        return (D() << 21) | (D() << 14) | (D() << 7) | D();
    }

    public int D() {
        byte[] bArr = this.a;
        int i = this.f3900b;
        this.f3900b = i + 1;
        return bArr[i] & 255;
    }

    public int E() {
        byte[] bArr = this.a;
        int i = this.f3900b;
        int i2 = i + 1;
        this.f3900b = i2;
        int i3 = i2 + 1;
        this.f3900b = i3;
        int i4 = (bArr[i2] & 255) | ((bArr[i] & 255) << 8);
        this.f3900b = i3 + 2;
        return i4;
    }

    public long F() {
        byte[] bArr = this.a;
        int i = this.f3900b;
        int i2 = i + 1;
        this.f3900b = i2;
        int i3 = i2 + 1;
        this.f3900b = i3;
        int i4 = i3 + 1;
        this.f3900b = i4;
        this.f3900b = i4 + 1;
        return ((bArr[i] & 255) << 24) | ((bArr[i2] & 255) << 16) | ((bArr[i3] & 255) << 8) | (bArr[i4] & 255);
    }

    public int G() {
        byte[] bArr = this.a;
        int i = this.f3900b;
        int i2 = i + 1;
        this.f3900b = i2;
        int i3 = i2 + 1;
        this.f3900b = i3;
        int i4 = ((bArr[i] & 255) << 16) | ((bArr[i2] & 255) << 8);
        this.f3900b = i3 + 1;
        return (bArr[i3] & 255) | i4;
    }

    public int H() {
        int n = n();
        if (n >= 0) {
            return n;
        }
        StringBuilder sb = new StringBuilder(29);
        sb.append("Top bit not zero: ");
        sb.append(n);
        throw new IllegalStateException(sb.toString());
    }

    public long I() {
        long w = w();
        if (w >= 0) {
            return w;
        }
        StringBuilder sb = new StringBuilder(38);
        sb.append("Top bit not zero: ");
        sb.append(w);
        throw new IllegalStateException(sb.toString());
    }

    public int J() {
        byte[] bArr = this.a;
        int i = this.f3900b;
        int i2 = i + 1;
        this.f3900b = i2;
        this.f3900b = i2 + 1;
        return (bArr[i2] & 255) | ((bArr[i] & 255) << 8);
    }

    public long K() {
        int i;
        int i2;
        byte b2;
        int i3;
        long j = this.a[this.f3900b];
        int i4 = 7;
        while (true) {
            if (i4 < 0) {
                break;
            }
            if (((1 << i4) & j) != 0) {
                i4--;
            } else if (i4 < 6) {
                j &= i3 - 1;
                i2 = 7 - i4;
            } else if (i4 == 7) {
                i2 = 1;
            }
        }
        i2 = 0;
        if (i2 != 0) {
            for (i = 1; i < i2; i++) {
                if ((this.a[this.f3900b + i] & 192) == 128) {
                    j = (j << 6) | (b2 & 63);
                } else {
                    StringBuilder sb = new StringBuilder(62);
                    sb.append("Invalid UTF-8 sequence continuation byte: ");
                    sb.append(j);
                    throw new NumberFormatException(sb.toString());
                }
            }
            this.f3900b += i2;
            return j;
        }
        StringBuilder sb2 = new StringBuilder(55);
        sb2.append("Invalid UTF-8 sequence first byte: ");
        sb2.append(j);
        throw new NumberFormatException(sb2.toString());
    }

    public void L(int i) {
        N(b() < i ? new byte[i] : this.a, i);
    }

    public void M(byte[] bArr) {
        N(bArr, bArr.length);
    }

    public void N(byte[] bArr, int i) {
        this.a = bArr;
        this.f3901c = i;
        this.f3900b = 0;
    }

    public void O(int i) {
        g.a(i >= 0 && i <= this.a.length);
        this.f3901c = i;
    }

    public void P(int i) {
        g.a(i >= 0 && i <= this.f3901c);
        this.f3900b = i;
    }

    public void Q(int i) {
        P(this.f3900b + i);
    }

    public int a() {
        return this.f3901c - this.f3900b;
    }

    public int b() {
        return this.a.length;
    }

    public void c(int i) {
        if (i > b()) {
            this.a = Arrays.copyOf(this.a, i);
        }
    }

    public byte[] d() {
        return this.a;
    }

    public int e() {
        return this.f3900b;
    }

    public int f() {
        return this.f3901c;
    }

    public char g() {
        byte[] bArr = this.a;
        int i = this.f3900b;
        return (char) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    public int h() {
        return this.a[this.f3900b] & 255;
    }

    public void i(c0 c0Var, int i) {
        j(c0Var.a, 0, i);
        c0Var.p(0);
    }

    public void j(byte[] bArr, int i, int i2) {
        System.arraycopy(this.a, this.f3900b, bArr, i, i2);
        this.f3900b += i2;
    }

    @Nullable
    public String k(char c2) {
        if (a() == 0) {
            return null;
        }
        int i = this.f3900b;
        while (i < this.f3901c && this.a[i] != c2) {
            i++;
        }
        byte[] bArr = this.a;
        int i2 = this.f3900b;
        String C = o0.C(bArr, i2, i - i2);
        this.f3900b = i;
        if (i < this.f3901c) {
            this.f3900b = i + 1;
        }
        return C;
    }

    public double l() {
        return Double.longBitsToDouble(w());
    }

    public float m() {
        return Float.intBitsToFloat(n());
    }

    public int n() {
        byte[] bArr = this.a;
        int i = this.f3900b;
        int i2 = i + 1;
        this.f3900b = i2;
        int i3 = i2 + 1;
        this.f3900b = i3;
        int i4 = ((bArr[i] & 255) << 24) | ((bArr[i2] & 255) << 16);
        int i5 = i3 + 1;
        this.f3900b = i5;
        int i6 = i4 | ((bArr[i3] & 255) << 8);
        this.f3900b = i5 + 1;
        return (bArr[i5] & 255) | i6;
    }

    public int o() {
        byte[] bArr = this.a;
        int i = this.f3900b;
        int i2 = i + 1;
        this.f3900b = i2;
        int i3 = i2 + 1;
        this.f3900b = i3;
        int i4 = (((bArr[i] & 255) << 24) >> 8) | ((bArr[i2] & 255) << 8);
        this.f3900b = i3 + 1;
        return (bArr[i3] & 255) | i4;
    }

    @Nullable
    public String p() {
        if (a() == 0) {
            return null;
        }
        int i = this.f3900b;
        while (i < this.f3901c && !o0.l0(this.a[i])) {
            i++;
        }
        int i2 = this.f3900b;
        if (i - i2 >= 3) {
            byte[] bArr = this.a;
            if (bArr[i2] == -17 && bArr[i2 + 1] == -69 && bArr[i2 + 2] == -65) {
                this.f3900b = i2 + 3;
            }
        }
        byte[] bArr2 = this.a;
        int i3 = this.f3900b;
        String C = o0.C(bArr2, i3, i - i3);
        this.f3900b = i;
        int i4 = this.f3901c;
        if (i == i4) {
            return C;
        }
        byte[] bArr3 = this.a;
        if (bArr3[i] == 13) {
            int i5 = i + 1;
            this.f3900b = i5;
            if (i5 == i4) {
                return C;
            }
        }
        int i6 = this.f3900b;
        if (bArr3[i6] == 10) {
            this.f3900b = i6 + 1;
        }
        return C;
    }

    public int q() {
        byte[] bArr = this.a;
        int i = this.f3900b;
        int i2 = i + 1;
        this.f3900b = i2;
        int i3 = i2 + 1;
        this.f3900b = i3;
        int i4 = (bArr[i] & 255) | ((bArr[i2] & 255) << 8);
        int i5 = i3 + 1;
        this.f3900b = i5;
        int i6 = i4 | ((bArr[i3] & 255) << 16);
        this.f3900b = i5 + 1;
        return ((bArr[i5] & 255) << 24) | i6;
    }

    public long r() {
        byte[] bArr = this.a;
        int i = this.f3900b;
        int i2 = i + 1;
        this.f3900b = i2;
        int i3 = i2 + 1;
        this.f3900b = i3;
        int i4 = i3 + 1;
        this.f3900b = i4;
        int i5 = i4 + 1;
        this.f3900b = i5;
        int i6 = i5 + 1;
        this.f3900b = i6;
        int i7 = i6 + 1;
        this.f3900b = i7;
        int i8 = i7 + 1;
        this.f3900b = i8;
        this.f3900b = i8 + 1;
        return (bArr[i] & 255) | ((bArr[i2] & 255) << 8) | ((bArr[i3] & 255) << 16) | ((bArr[i4] & 255) << 24) | ((bArr[i5] & 255) << 32) | ((bArr[i6] & 255) << 40) | ((bArr[i7] & 255) << 48) | ((bArr[i8] & 255) << 56);
    }

    public short s() {
        byte[] bArr = this.a;
        int i = this.f3900b;
        int i2 = i + 1;
        this.f3900b = i2;
        this.f3900b = i2 + 1;
        return (short) (((bArr[i2] & 255) << 8) | (bArr[i] & 255));
    }

    public long t() {
        byte[] bArr = this.a;
        int i = this.f3900b;
        int i2 = i + 1;
        this.f3900b = i2;
        int i3 = i2 + 1;
        this.f3900b = i3;
        int i4 = i3 + 1;
        this.f3900b = i4;
        this.f3900b = i4 + 1;
        return (bArr[i] & 255) | ((bArr[i2] & 255) << 8) | ((bArr[i3] & 255) << 16) | ((bArr[i4] & 255) << 24);
    }

    public int u() {
        int q = q();
        if (q >= 0) {
            return q;
        }
        StringBuilder sb = new StringBuilder(29);
        sb.append("Top bit not zero: ");
        sb.append(q);
        throw new IllegalStateException(sb.toString());
    }

    public int v() {
        byte[] bArr = this.a;
        int i = this.f3900b;
        int i2 = i + 1;
        this.f3900b = i2;
        this.f3900b = i2 + 1;
        return ((bArr[i2] & 255) << 8) | (bArr[i] & 255);
    }

    public long w() {
        byte[] bArr = this.a;
        int i = this.f3900b;
        int i2 = i + 1;
        this.f3900b = i2;
        int i3 = i2 + 1;
        this.f3900b = i3;
        int i4 = i3 + 1;
        this.f3900b = i4;
        int i5 = i4 + 1;
        this.f3900b = i5;
        int i6 = i5 + 1;
        this.f3900b = i6;
        int i7 = i6 + 1;
        this.f3900b = i7;
        int i8 = i7 + 1;
        this.f3900b = i8;
        this.f3900b = i8 + 1;
        return ((bArr[i] & 255) << 56) | ((bArr[i2] & 255) << 48) | ((bArr[i3] & 255) << 40) | ((bArr[i4] & 255) << 32) | ((bArr[i5] & 255) << 24) | ((bArr[i6] & 255) << 16) | ((bArr[i7] & 255) << 8) | (bArr[i8] & 255);
    }

    @Nullable
    public String x() {
        return k((char) 0);
    }

    public String y(int i) {
        if (i == 0) {
            return "";
        }
        int i2 = this.f3900b;
        int i3 = (i2 + i) - 1;
        String C = o0.C(this.a, i2, (i3 >= this.f3901c || this.a[i3] != 0) ? i : i - 1);
        this.f3900b += i;
        return C;
    }

    public short z() {
        byte[] bArr = this.a;
        int i = this.f3900b;
        int i2 = i + 1;
        this.f3900b = i2;
        this.f3900b = i2 + 1;
        return (short) ((bArr[i2] & 255) | ((bArr[i] & 255) << 8));
    }

    public d0(int i) {
        this.a = new byte[i];
        this.f3901c = i;
    }

    public d0(byte[] bArr) {
        this.a = bArr;
        this.f3901c = bArr.length;
    }

    public d0(byte[] bArr, int i) {
        this.a = bArr;
        this.f3901c = i;
    }
}
