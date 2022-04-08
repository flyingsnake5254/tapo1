package com.google.android.exoplayer2.o2.l0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.m;
import com.google.android.exoplayer2.o2.b0;
import com.google.android.exoplayer2.o2.i;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.o2.l0.i0;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import java.util.Arrays;
import java.util.Collections;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: AdtsReader.java */
/* loaded from: classes.dex */
public final class k implements o {
    private static final byte[] a = {73, 68, 51};

    /* renamed from: b  reason: collision with root package name */
    private final boolean f2944b;

    /* renamed from: c  reason: collision with root package name */
    private final c0 f2945c;

    /* renamed from: d  reason: collision with root package name */
    private final d0 f2946d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final String f2947e;

    /* renamed from: f  reason: collision with root package name */
    private String f2948f;
    private b0 g;
    private b0 h;
    private int i;
    private int j;
    private int k;
    private boolean l;
    private boolean m;
    private int n;
    private int o;
    private int p;
    private boolean q;
    private long r;
    private int s;
    private long t;
    private b0 u;
    private long v;

    public k(boolean z) {
        this(z, null);
    }

    @EnsuresNonNull({"output", "currentOutput", "id3Output"})
    private void a() {
        g.e(this.g);
        o0.i(this.u);
        o0.i(this.h);
    }

    private void g(d0 d0Var) {
        if (d0Var.a() != 0) {
            this.f2945c.a[0] = d0Var.d()[d0Var.e()];
            this.f2945c.p(2);
            int h = this.f2945c.h(4);
            int i = this.o;
            if (i == -1 || h == i) {
                if (!this.m) {
                    this.m = true;
                    this.n = this.p;
                    this.o = h;
                }
                t();
                return;
            }
            q();
        }
    }

    private boolean h(d0 d0Var, int i) {
        d0Var.P(i + 1);
        if (!w(d0Var, this.f2945c.a, 1)) {
            return false;
        }
        this.f2945c.p(4);
        int h = this.f2945c.h(1);
        int i2 = this.n;
        if (i2 != -1 && h != i2) {
            return false;
        }
        if (this.o != -1) {
            if (!w(d0Var, this.f2945c.a, 1)) {
                return true;
            }
            this.f2945c.p(2);
            if (this.f2945c.h(4) != this.o) {
                return false;
            }
            d0Var.P(i + 2);
        }
        if (!w(d0Var, this.f2945c.a, 4)) {
            return true;
        }
        this.f2945c.p(14);
        int h2 = this.f2945c.h(13);
        if (h2 < 7) {
            return false;
        }
        byte[] d2 = d0Var.d();
        int f2 = d0Var.f();
        int i3 = i + h2;
        if (i3 >= f2) {
            return true;
        }
        if (d2[i3] == -1) {
            int i4 = i3 + 1;
            if (i4 == f2) {
                return true;
            }
            return l((byte) -1, d2[i4]) && ((d2[i4] & 8) >> 3) == h;
        } else if (d2[i3] != 73) {
            return false;
        } else {
            int i5 = i3 + 1;
            if (i5 == f2) {
                return true;
            }
            if (d2[i5] != 68) {
                return false;
            }
            int i6 = i3 + 2;
            return i6 == f2 || d2[i6] == 51;
        }
    }

    private boolean i(d0 d0Var, byte[] bArr, int i) {
        int min = Math.min(d0Var.a(), i - this.j);
        d0Var.j(bArr, this.j, min);
        int i2 = this.j + min;
        this.j = i2;
        return i2 == i;
    }

    private void j(d0 d0Var) {
        byte[] d2 = d0Var.d();
        int e2 = d0Var.e();
        int f2 = d0Var.f();
        while (e2 < f2) {
            e2++;
            int i = d2[e2] & 255;
            if (this.k != 512 || !l((byte) -1, (byte) i) || (!this.m && !h(d0Var, e2 - 2))) {
                int i2 = this.k;
                int i3 = i | i2;
                if (i3 == 329) {
                    this.k = 768;
                } else if (i3 == 511) {
                    this.k = 512;
                } else if (i3 == 836) {
                    this.k = 1024;
                } else if (i3 == 1075) {
                    u();
                    d0Var.P(e2);
                    return;
                } else if (i2 != 256) {
                    this.k = 256;
                    e2--;
                }
            } else {
                this.p = (i & 8) >> 3;
                boolean z = true;
                if ((i & 1) != 0) {
                    z = false;
                }
                this.l = z;
                if (!this.m) {
                    r();
                } else {
                    t();
                }
                d0Var.P(e2);
                return;
            }
        }
        d0Var.P(e2);
    }

    private boolean l(byte b2, byte b3) {
        return m(((b2 & 255) << 8) | (b3 & 255));
    }

    public static boolean m(int i) {
        return (i & 65526) == 65520;
    }

    @RequiresNonNull({"output"})
    private void n() throws ParserException {
        this.f2945c.p(0);
        if (!this.q) {
            int h = this.f2945c.h(2) + 1;
            if (h != 2) {
                StringBuilder sb = new StringBuilder(61);
                sb.append("Detected audio object type: ");
                sb.append(h);
                sb.append(", but assuming AAC LC.");
                u.h("AdtsReader", sb.toString());
                h = 2;
            }
            this.f2945c.r(5);
            byte[] a2 = m.a(h, this.o, this.f2945c.h(3));
            m.b f2 = m.f(a2);
            Format E = new Format.b().S(this.f2948f).e0("audio/mp4a-latm").I(f2.f2092c).H(f2.f2091b).f0(f2.a).T(Collections.singletonList(a2)).V(this.f2947e).E();
            this.r = 1024000000 / E.V3;
            this.g.d(E);
            this.q = true;
        } else {
            this.f2945c.r(10);
        }
        this.f2945c.r(4);
        int h2 = (this.f2945c.h(13) - 2) - 5;
        if (this.l) {
            h2 -= 2;
        }
        v(this.g, this.r, 0, h2);
    }

    @RequiresNonNull({"id3Output"})
    private void o() {
        this.h.c(this.f2946d, 10);
        this.f2946d.P(6);
        v(this.h, 0L, 10, this.f2946d.C() + 10);
    }

    @RequiresNonNull({"currentOutput"})
    private void p(d0 d0Var) {
        int min = Math.min(d0Var.a(), this.s - this.j);
        this.u.c(d0Var, min);
        int i = this.j + min;
        this.j = i;
        int i2 = this.s;
        if (i == i2) {
            this.u.e(this.t, 1, i2, 0, null);
            this.t += this.v;
            s();
        }
    }

    private void q() {
        this.m = false;
        s();
    }

    private void r() {
        this.i = 1;
        this.j = 0;
    }

    private void s() {
        this.i = 0;
        this.j = 0;
        this.k = 256;
    }

    private void t() {
        this.i = 3;
        this.j = 0;
    }

    private void u() {
        this.i = 2;
        this.j = a.length;
        this.s = 0;
        this.f2946d.P(0);
    }

    private void v(b0 b0Var, long j, int i, int i2) {
        this.i = 4;
        this.j = i;
        this.u = b0Var;
        this.v = j;
        this.s = i2;
    }

    private boolean w(d0 d0Var, byte[] bArr, int i) {
        if (d0Var.a() < i) {
            return false;
        }
        d0Var.j(bArr, 0, i);
        return true;
    }

    @Override // com.google.android.exoplayer2.o2.l0.o
    public void b(d0 d0Var) throws ParserException {
        a();
        while (d0Var.a() > 0) {
            int i = this.i;
            if (i == 0) {
                j(d0Var);
            } else if (i == 1) {
                g(d0Var);
            } else if (i != 2) {
                if (i == 3) {
                    if (i(d0Var, this.f2945c.a, this.l ? 7 : 5)) {
                        n();
                    }
                } else if (i == 4) {
                    p(d0Var);
                } else {
                    throw new IllegalStateException();
                }
            } else if (i(d0Var, this.f2946d.d(), 10)) {
                o();
            }
        }
    }

    @Override // com.google.android.exoplayer2.o2.l0.o
    public void c() {
        q();
    }

    @Override // com.google.android.exoplayer2.o2.l0.o
    public void d(l lVar, i0.d dVar) {
        dVar.a();
        this.f2948f = dVar.b();
        b0 t = lVar.t(dVar.c(), 1);
        this.g = t;
        this.u = t;
        if (this.f2944b) {
            dVar.a();
            b0 t2 = lVar.t(dVar.c(), 5);
            this.h = t2;
            t2.d(new Format.b().S(dVar.b()).e0("application/id3").E());
            return;
        }
        this.h = new i();
    }

    @Override // com.google.android.exoplayer2.o2.l0.o
    public void e() {
    }

    @Override // com.google.android.exoplayer2.o2.l0.o
    public void f(long j, int i) {
        this.t = j;
    }

    public long k() {
        return this.r;
    }

    public k(boolean z, @Nullable String str) {
        this.f2945c = new c0(new byte[7]);
        this.f2946d = new d0(Arrays.copyOf(a, 10));
        s();
        this.n = -1;
        this.o = -1;
        this.r = -9223372036854775807L;
        this.f2944b = z;
        this.f2947e = str;
    }
}
