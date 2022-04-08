package com.google.android.exoplayer2.util;

import java.util.NoSuchElementException;

/* compiled from: IntArrayQueue.java */
/* loaded from: classes.dex */
public final class s {
    private int a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f3939b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f3940c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int[] f3941d;

    /* renamed from: e  reason: collision with root package name */
    private int f3942e;

    public s() {
        int[] iArr = new int[16];
        this.f3941d = iArr;
        this.f3942e = iArr.length - 1;
    }

    private void c() {
        int[] iArr = this.f3941d;
        int length = iArr.length << 1;
        if (length >= 0) {
            int[] iArr2 = new int[length];
            int length2 = iArr.length;
            int i = this.a;
            int i2 = length2 - i;
            System.arraycopy(iArr, i, iArr2, 0, i2);
            System.arraycopy(this.f3941d, 0, iArr2, i2, i);
            this.a = 0;
            this.f3939b = this.f3940c - 1;
            this.f3941d = iArr2;
            this.f3942e = iArr2.length - 1;
            return;
        }
        throw new IllegalStateException();
    }

    public void a(int i) {
        if (this.f3940c == this.f3941d.length) {
            c();
        }
        int i2 = (this.f3939b + 1) & this.f3942e;
        this.f3939b = i2;
        this.f3941d[i2] = i;
        this.f3940c++;
    }

    public void b() {
        this.a = 0;
        this.f3939b = -1;
        this.f3940c = 0;
    }

    public boolean d() {
        return this.f3940c == 0;
    }

    public int e() {
        int i = this.f3940c;
        if (i != 0) {
            int[] iArr = this.f3941d;
            int i2 = this.a;
            int i3 = iArr[i2];
            this.a = (i2 + 1) & this.f3942e;
            this.f3940c = i - 1;
            return i3;
        }
        throw new NoSuchElementException();
    }
}
