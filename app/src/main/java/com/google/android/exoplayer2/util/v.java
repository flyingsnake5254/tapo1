package com.google.android.exoplayer2.util;

import java.util.Arrays;

/* compiled from: LongArray.java */
/* loaded from: classes.dex */
public final class v {
    private int a;

    /* renamed from: b  reason: collision with root package name */
    private long[] f3952b;

    public v() {
        this(32);
    }

    public void a(long j) {
        int i = this.a;
        long[] jArr = this.f3952b;
        if (i == jArr.length) {
            this.f3952b = Arrays.copyOf(jArr, i * 2);
        }
        long[] jArr2 = this.f3952b;
        int i2 = this.a;
        this.a = i2 + 1;
        jArr2[i2] = j;
    }

    public long b(int i) {
        if (i >= 0 && i < this.a) {
            return this.f3952b[i];
        }
        int i2 = this.a;
        StringBuilder sb = new StringBuilder(46);
        sb.append("Invalid index ");
        sb.append(i);
        sb.append(", size is ");
        sb.append(i2);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public int c() {
        return this.a;
    }

    public long[] d() {
        return Arrays.copyOf(this.f3952b, this.a);
    }

    public v(int i) {
        this.f3952b = new long[i];
    }
}
