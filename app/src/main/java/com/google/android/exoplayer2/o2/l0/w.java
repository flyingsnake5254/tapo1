package com.google.android.exoplayer2.o2.l0;

import com.google.android.exoplayer2.util.g;
import java.util.Arrays;

/* compiled from: NalUnitTargetBuffer.java */
/* loaded from: classes.dex */
final class w {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f3025b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3026c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f3027d;

    /* renamed from: e  reason: collision with root package name */
    public int f3028e;

    public w(int i, int i2) {
        this.a = i;
        byte[] bArr = new byte[i2 + 3];
        this.f3027d = bArr;
        bArr[2] = 1;
    }

    public void a(byte[] bArr, int i, int i2) {
        if (this.f3025b) {
            int i3 = i2 - i;
            byte[] bArr2 = this.f3027d;
            int length = bArr2.length;
            int i4 = this.f3028e;
            if (length < i4 + i3) {
                this.f3027d = Arrays.copyOf(bArr2, (i4 + i3) * 2);
            }
            System.arraycopy(bArr, i, this.f3027d, this.f3028e, i3);
            this.f3028e += i3;
        }
    }

    public boolean b(int i) {
        if (!this.f3025b) {
            return false;
        }
        this.f3028e -= i;
        this.f3025b = false;
        this.f3026c = true;
        return true;
    }

    public boolean c() {
        return this.f3026c;
    }

    public void d() {
        this.f3025b = false;
        this.f3026c = false;
    }

    public void e(int i) {
        boolean z = true;
        g.g(!this.f3025b);
        if (i != this.a) {
            z = false;
        }
        this.f3025b = z;
        if (z) {
            this.f3028e = 3;
            this.f3026c = false;
        }
    }
}
