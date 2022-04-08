package com.google.android.exoplayer2.o2.l0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.n;
import com.google.android.exoplayer2.o2.b0;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.o2.l0.i0;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.o0;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: Ac3Reader.java */
/* loaded from: classes.dex */
public final class g implements o {
    private final c0 a;

    /* renamed from: b  reason: collision with root package name */
    private final d0 f2902b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final String f2903c;

    /* renamed from: d  reason: collision with root package name */
    private String f2904d;

    /* renamed from: e  reason: collision with root package name */
    private b0 f2905e;

    /* renamed from: f  reason: collision with root package name */
    private int f2906f;
    private int g;
    private boolean h;
    private long i;
    private Format j;
    private int k;
    private long l;

    public g() {
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
        n.b e2 = n.e(this.a);
        Format format = this.j;
        if (format == null || e2.f2100d != format.U3 || e2.f2099c != format.V3 || !o0.b(e2.a, format.H3)) {
            Format E = new Format.b().S(this.f2904d).e0(e2.a).H(e2.f2100d).f0(e2.f2099c).V(this.f2903c).E();
            this.j = E;
            this.f2905e.d(E);
        }
        this.k = e2.f2101e;
        this.i = (e2.f2102f * 1000000) / this.j.V3;
    }

    private boolean h(d0 d0Var) {
        while (true) {
            boolean z = false;
            if (d0Var.a() <= 0) {
                return false;
            }
            if (!this.h) {
                if (d0Var.D() == 11) {
                    z = true;
                }
                this.h = z;
            } else {
                int D = d0Var.D();
                if (D == 119) {
                    this.h = false;
                    return true;
                }
                if (D == 11) {
                    z = true;
                }
                this.h = z;
            }
        }
    }

    @Override // com.google.android.exoplayer2.o2.l0.o
    public void b(d0 d0Var) {
        com.google.android.exoplayer2.util.g.i(this.f2905e);
        while (d0Var.a() > 0) {
            int i = this.f2906f;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        int min = Math.min(d0Var.a(), this.k - this.g);
                        this.f2905e.c(d0Var, min);
                        int i2 = this.g + min;
                        this.g = i2;
                        int i3 = this.k;
                        if (i2 == i3) {
                            this.f2905e.e(this.l, 1, i3, 0, null);
                            this.l += this.i;
                            this.f2906f = 0;
                        }
                    }
                } else if (a(d0Var, this.f2902b.d(), 128)) {
                    g();
                    this.f2902b.P(0);
                    this.f2905e.c(this.f2902b, 128);
                    this.f2906f = 2;
                }
            } else if (h(d0Var)) {
                this.f2906f = 1;
                this.f2902b.d()[0] = 11;
                this.f2902b.d()[1] = 119;
                this.g = 2;
            }
        }
    }

    @Override // com.google.android.exoplayer2.o2.l0.o
    public void c() {
        this.f2906f = 0;
        this.g = 0;
        this.h = false;
    }

    @Override // com.google.android.exoplayer2.o2.l0.o
    public void d(l lVar, i0.d dVar) {
        dVar.a();
        this.f2904d = dVar.b();
        this.f2905e = lVar.t(dVar.c(), 1);
    }

    @Override // com.google.android.exoplayer2.o2.l0.o
    public void e() {
    }

    @Override // com.google.android.exoplayer2.o2.l0.o
    public void f(long j, int i) {
        this.l = j;
    }

    public g(@Nullable String str) {
        c0 c0Var = new c0(new byte[128]);
        this.a = c0Var;
        this.f2902b = new d0(c0Var.a);
        this.f2906f = 0;
        this.f2903c = str;
    }
}
