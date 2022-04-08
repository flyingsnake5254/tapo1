package com.google.android.exoplayer2.o2;

import com.google.android.exoplayer2.util.g;

/* compiled from: VorbisBitArray.java */
/* loaded from: classes.dex */
public final class c0 {
    private final byte[] a;

    /* renamed from: b  reason: collision with root package name */
    private final int f2650b;

    /* renamed from: c  reason: collision with root package name */
    private int f2651c;

    /* renamed from: d  reason: collision with root package name */
    private int f2652d;

    public c0(byte[] bArr) {
        this.a = bArr;
        this.f2650b = bArr.length;
    }

    private void a() {
        int i;
        int i2 = this.f2651c;
        g.g(i2 >= 0 && (i2 < (i = this.f2650b) || (i2 == i && this.f2652d == 0)));
    }

    public int b() {
        return (this.f2651c * 8) + this.f2652d;
    }

    public boolean c() {
        boolean z = (((this.a[this.f2651c] & 255) >> this.f2652d) & 1) == 1;
        e(1);
        return z;
    }

    public int d(int i) {
        int i2 = this.f2651c;
        int min = Math.min(i, 8 - this.f2652d);
        int i3 = i2 + 1;
        int i4 = ((this.a[i2] & 255) >> this.f2652d) & (255 >> (8 - min));
        while (min < i) {
            i3++;
            i4 |= (this.a[i3] & 255) << min;
            min += 8;
        }
        int i5 = i4 & ((-1) >>> (32 - i));
        e(i);
        return i5;
    }

    public void e(int i) {
        int i2 = i / 8;
        int i3 = this.f2651c + i2;
        this.f2651c = i3;
        int i4 = this.f2652d + (i - (i2 * 8));
        this.f2652d = i4;
        if (i4 > 7) {
            this.f2651c = i3 + 1;
            this.f2652d = i4 - 8;
        }
        a();
    }
}
