package com.google.android.exoplayer2.o2.k0;

import com.google.android.exoplayer2.o2.k;
import com.google.android.exoplayer2.o2.m;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: OggPacket.java */
/* loaded from: classes.dex */
final class e {
    private final f a = new f();

    /* renamed from: b  reason: collision with root package name */
    private final d0 f2851b = new d0(new byte[65025], 0);

    /* renamed from: c  reason: collision with root package name */
    private int f2852c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f2853d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f2854e;

    private int a(int i) {
        int i2;
        int i3 = 0;
        this.f2853d = 0;
        do {
            int i4 = this.f2853d;
            int i5 = i + i4;
            f fVar = this.a;
            if (i5 >= fVar.g) {
                break;
            }
            int[] iArr = fVar.j;
            this.f2853d = i4 + 1;
            i2 = iArr[i4 + i];
            i3 += i2;
        } while (i2 == 255);
        return i3;
    }

    public f b() {
        return this.a;
    }

    public d0 c() {
        return this.f2851b;
    }

    public boolean d(k kVar) throws IOException {
        int i;
        g.g(kVar != null);
        if (this.f2854e) {
            this.f2854e = false;
            this.f2851b.L(0);
        }
        while (!this.f2854e) {
            if (this.f2852c < 0) {
                if (!this.a.c(kVar) || !this.a.a(kVar, true)) {
                    return false;
                }
                f fVar = this.a;
                int i2 = fVar.h;
                if ((fVar.f2855b & 1) == 1 && this.f2851b.f() == 0) {
                    i2 += a(0);
                    i = this.f2853d + 0;
                } else {
                    i = 0;
                }
                if (!m.e(kVar, i2)) {
                    return false;
                }
                this.f2852c = i;
            }
            int a = a(this.f2852c);
            int i3 = this.f2852c + this.f2853d;
            if (a > 0) {
                d0 d0Var = this.f2851b;
                d0Var.c(d0Var.f() + a);
                if (!m.d(kVar, this.f2851b.d(), this.f2851b.f(), a)) {
                    return false;
                }
                d0 d0Var2 = this.f2851b;
                d0Var2.O(d0Var2.f() + a);
                this.f2854e = this.a.j[i3 + (-1)] != 255;
            }
            if (i3 == this.a.g) {
                i3 = -1;
            }
            this.f2852c = i3;
        }
        return true;
    }

    public void e() {
        this.a.b();
        this.f2851b.L(0);
        this.f2852c = -1;
        this.f2854e = false;
    }

    public void f() {
        if (this.f2851b.d().length != 65025) {
            d0 d0Var = this.f2851b;
            d0Var.N(Arrays.copyOf(d0Var.d(), Math.max(65025, this.f2851b.f())), this.f2851b.f());
        }
    }
}
