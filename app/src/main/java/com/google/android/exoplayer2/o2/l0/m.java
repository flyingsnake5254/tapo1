package com.google.android.exoplayer2.o2.l0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.o2.b0;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.o2.l0.i0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: DtsReader.java */
/* loaded from: classes.dex */
public final class m implements o {
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final String f2951b;

    /* renamed from: c  reason: collision with root package name */
    private String f2952c;

    /* renamed from: d  reason: collision with root package name */
    private b0 f2953d;

    /* renamed from: f  reason: collision with root package name */
    private int f2955f;
    private int g;
    private long h;
    private Format i;
    private int j;
    private long k;
    private final d0 a = new d0(new byte[18]);

    /* renamed from: e  reason: collision with root package name */
    private int f2954e = 0;

    public m(@Nullable String str) {
        this.f2951b = str;
    }

    private boolean a(d0 d0Var, byte[] bArr, int i) {
        int min = Math.min(d0Var.a(), i - this.f2955f);
        d0Var.j(bArr, this.f2955f, min);
        int i2 = this.f2955f + min;
        this.f2955f = i2;
        return i2 == i;
    }

    @RequiresNonNull({"output"})
    private void g() {
        byte[] d2 = this.a.d();
        if (this.i == null) {
            Format g = com.google.android.exoplayer2.audio.b0.g(d2, this.f2952c, this.f2951b, null);
            this.i = g;
            this.f2953d.d(g);
        }
        this.j = com.google.android.exoplayer2.audio.b0.a(d2);
        this.h = (int) ((com.google.android.exoplayer2.audio.b0.f(d2) * 1000000) / this.i.V3);
    }

    private boolean h(d0 d0Var) {
        while (d0Var.a() > 0) {
            int i = this.g << 8;
            this.g = i;
            int D = i | d0Var.D();
            this.g = D;
            if (com.google.android.exoplayer2.audio.b0.d(D)) {
                byte[] d2 = this.a.d();
                int i2 = this.g;
                d2[0] = (byte) ((i2 >> 24) & 255);
                d2[1] = (byte) ((i2 >> 16) & 255);
                d2[2] = (byte) ((i2 >> 8) & 255);
                d2[3] = (byte) (i2 & 255);
                this.f2955f = 4;
                this.g = 0;
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.o2.l0.o
    public void b(d0 d0Var) {
        g.i(this.f2953d);
        while (d0Var.a() > 0) {
            int i = this.f2954e;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        int min = Math.min(d0Var.a(), this.j - this.f2955f);
                        this.f2953d.c(d0Var, min);
                        int i2 = this.f2955f + min;
                        this.f2955f = i2;
                        int i3 = this.j;
                        if (i2 == i3) {
                            this.f2953d.e(this.k, 1, i3, 0, null);
                            this.k += this.h;
                            this.f2954e = 0;
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                } else if (a(d0Var, this.a.d(), 18)) {
                    g();
                    this.a.P(0);
                    this.f2953d.c(this.a, 18);
                    this.f2954e = 2;
                }
            } else if (h(d0Var)) {
                this.f2954e = 1;
            }
        }
    }

    @Override // com.google.android.exoplayer2.o2.l0.o
    public void c() {
        this.f2954e = 0;
        this.f2955f = 0;
        this.g = 0;
    }

    @Override // com.google.android.exoplayer2.o2.l0.o
    public void d(l lVar, i0.d dVar) {
        dVar.a();
        this.f2952c = dVar.b();
        this.f2953d = lVar.t(dVar.c(), 1);
    }

    @Override // com.google.android.exoplayer2.o2.l0.o
    public void e() {
    }

    @Override // com.google.android.exoplayer2.o2.l0.o
    public void f(long j, int i) {
        this.k = j;
    }
}
