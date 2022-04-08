package com.google.android.exoplayer2.upstream;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import java.util.Arrays;

/* compiled from: DefaultAllocator.java */
/* loaded from: classes.dex */
public final class o implements e {
    private final boolean a;

    /* renamed from: b  reason: collision with root package name */
    private final int f3837b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f3838c;

    /* renamed from: d  reason: collision with root package name */
    private final d[] f3839d;

    /* renamed from: e  reason: collision with root package name */
    private int f3840e;

    /* renamed from: f  reason: collision with root package name */
    private int f3841f;
    private int g;
    private d[] h;

    public o(boolean z, int i) {
        this(z, i, 0);
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public synchronized d a() {
        d dVar;
        this.f3841f++;
        int i = this.g;
        if (i > 0) {
            d[] dVarArr = this.h;
            int i2 = i - 1;
            this.g = i2;
            dVar = (d) g.e(dVarArr[i2]);
            this.h[this.g] = null;
        } else {
            dVar = new d(new byte[this.f3837b], 0);
        }
        return dVar;
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public synchronized void b(d[] dVarArr) {
        int i = this.g;
        int length = dVarArr.length + i;
        d[] dVarArr2 = this.h;
        if (length >= dVarArr2.length) {
            this.h = (d[]) Arrays.copyOf(dVarArr2, Math.max(dVarArr2.length * 2, i + dVarArr.length));
        }
        for (d dVar : dVarArr) {
            d[] dVarArr3 = this.h;
            int i2 = this.g;
            this.g = i2 + 1;
            dVarArr3[i2] = dVar;
        }
        this.f3841f -= dVarArr.length;
        notifyAll();
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public synchronized void c(d dVar) {
        d[] dVarArr = this.f3839d;
        dVarArr[0] = dVar;
        b(dVarArr);
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public synchronized void d() {
        int i = 0;
        int max = Math.max(0, o0.k(this.f3840e, this.f3837b) - this.f3841f);
        int i2 = this.g;
        if (max < i2) {
            if (this.f3838c != null) {
                int i3 = i2 - 1;
                while (i <= i3) {
                    d dVar = (d) g.e(this.h[i]);
                    if (dVar.a == this.f3838c) {
                        i++;
                    } else {
                        d dVar2 = (d) g.e(this.h[i3]);
                        if (dVar2.a != this.f3838c) {
                            i3--;
                        } else {
                            d[] dVarArr = this.h;
                            i++;
                            dVarArr[i] = dVar2;
                            i3--;
                            dVarArr[i3] = dVar;
                        }
                    }
                }
                max = Math.max(max, i);
                if (max >= this.g) {
                    return;
                }
            }
            Arrays.fill(this.h, max, this.g, (Object) null);
            this.g = max;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public int e() {
        return this.f3837b;
    }

    public synchronized int f() {
        return this.f3841f * this.f3837b;
    }

    public synchronized void g() {
        if (this.a) {
            h(0);
        }
    }

    public synchronized void h(int i) {
        boolean z = i < this.f3840e;
        this.f3840e = i;
        if (z) {
            d();
        }
    }

    public o(boolean z, int i, int i2) {
        g.a(i > 0);
        g.a(i2 >= 0);
        this.a = z;
        this.f3837b = i;
        this.g = i2;
        this.h = new d[i2 + 100];
        if (i2 > 0) {
            this.f3838c = new byte[i2 * i];
            for (int i3 = 0; i3 < i2; i3++) {
                this.h[i3] = new d(this.f3838c, i3 * i);
            }
        } else {
            this.f3838c = null;
        }
        this.f3839d = new d[1];
    }
}
