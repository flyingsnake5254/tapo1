package com.google.android.exoplayer2.o2.l0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.o;
import com.google.android.exoplayer2.o2.b0;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.o2.l0.i0;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: Ac4Reader.java */
/* loaded from: classes.dex */
public final class i implements o {
    private final c0 a;

    /* renamed from: b  reason: collision with root package name */
    private final d0 f2925b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final String f2926c;

    /* renamed from: d  reason: collision with root package name */
    private String f2927d;

    /* renamed from: e  reason: collision with root package name */
    private b0 f2928e;

    /* renamed from: f  reason: collision with root package name */
    private int f2929f;
    private int g;
    private boolean h;
    private boolean i;
    private long j;
    private Format k;
    private int l;
    private long m;

    public i() {
        this(null);
    }

    private boolean a(d0 d0Var, byte[] bArr, int i) {
        int min = Math.min(d0Var.a(), i - this.g);
        d0Var.j(bArr, this.g, min);
        int i2 = this.g + min;
        this.g = i2;
        return i2 == i;
    }

    @RequiresNonNull({"output"})
    private void g() {
        this.a.p(0);
        o.b d2 = o.d(this.a);
        Format format = this.k;
        if (format == null || d2.f2104c != format.U3 || d2.f2103b != format.V3 || !"audio/ac4".equals(format.H3)) {
            Format E = new Format.b().S(this.f2927d).e0("audio/ac4").H(d2.f2104c).f0(d2.f2103b).V(this.f2926c).E();
            this.k = E;
            this.f2928e.d(E);
        }
        this.l = d2.f2105d;
        this.j = (d2.f2106e * 1000000) / this.k.V3;
    }

    private boolean h(d0 d0Var) {
        boolean z;
        int D;
        while (true) {
            z = false;
            if (d0Var.a() <= 0) {
                return false;
            }
            if (!this.h) {
                if (d0Var.D() == 172) {
                    z = true;
                }
                this.h = z;
            } else {
                D = d0Var.D();
                this.h = D == 172;
                if (D == 64 || D == 65) {
                    break;
                }
            }
        }
        if (D == 65) {
            z = true;
        }
        this.i = z;
        return true;
    }

    @Override // com.google.android.exoplayer2.o2.l0.o
    public void b(d0 d0Var) {
        g.i(this.f2928e);
        while (d0Var.a() > 0) {
            int i = this.f2929f;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        int min = Math.min(d0Var.a(), this.l - this.g);
                        this.f2928e.c(d0Var, min);
                        int i2 = this.g + min;
                        this.g = i2;
                        int i3 = this.l;
                        if (i2 == i3) {
                            this.f2928e.e(this.m, 1, i3, 0, null);
                            this.m += this.j;
                            this.f2929f = 0;
                        }
                    }
                } else if (a(d0Var, this.f2925b.d(), 16)) {
                    g();
                    this.f2925b.P(0);
                    this.f2928e.c(this.f2925b, 16);
                    this.f2929f = 2;
                }
            } else if (h(d0Var)) {
                this.f2929f = 1;
                this.f2925b.d()[0] = -84;
                this.f2925b.d()[1] = (byte) (this.i ? 65 : 64);
                this.g = 2;
            }
        }
    }

    @Override // com.google.android.exoplayer2.o2.l0.o
    public void c() {
        this.f2929f = 0;
        this.g = 0;
        this.h = false;
        this.i = false;
    }

    @Override // com.google.android.exoplayer2.o2.l0.o
    public void d(l lVar, i0.d dVar) {
        dVar.a();
        this.f2927d = dVar.b();
        this.f2928e = lVar.t(dVar.c(), 1);
    }

    @Override // com.google.android.exoplayer2.o2.l0.o
    public void e() {
    }

    @Override // com.google.android.exoplayer2.o2.l0.o
    public void f(long j, int i) {
        this.m = j;
    }

    public i(@Nullable String str) {
        c0 c0Var = new c0(new byte[16]);
        this.a = c0Var;
        this.f2925b = new d0(c0Var.a);
        this.f2929f = 0;
        this.g = 0;
        this.h = false;
        this.i = false;
        this.f2926c = str;
    }
}
