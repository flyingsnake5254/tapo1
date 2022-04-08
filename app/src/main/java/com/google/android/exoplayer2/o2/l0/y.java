package com.google.android.exoplayer2.o2.l0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.o2.l0.i0;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.l0;
import com.google.android.exoplayer2.util.u;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: PesReader.java */
/* loaded from: classes.dex */
public final class y implements i0 {
    private final o a;

    /* renamed from: b  reason: collision with root package name */
    private final c0 f3031b = new c0(new byte[10]);

    /* renamed from: c  reason: collision with root package name */
    private int f3032c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f3033d;

    /* renamed from: e  reason: collision with root package name */
    private l0 f3034e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f3035f;
    private boolean g;
    private boolean h;
    private int i;
    private int j;
    private boolean k;
    private long l;

    public y(o oVar) {
        this.a = oVar;
    }

    private boolean d(d0 d0Var, @Nullable byte[] bArr, int i) {
        int min = Math.min(d0Var.a(), i - this.f3033d);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            d0Var.Q(min);
        } else {
            d0Var.j(bArr, this.f3033d, min);
        }
        int i2 = this.f3033d + min;
        this.f3033d = i2;
        return i2 == i;
    }

    private boolean e() {
        this.f3031b.p(0);
        int h = this.f3031b.h(24);
        if (h != 1) {
            StringBuilder sb = new StringBuilder(41);
            sb.append("Unexpected start code prefix: ");
            sb.append(h);
            u.h("PesReader", sb.toString());
            this.j = -1;
            return false;
        }
        this.f3031b.r(8);
        int h2 = this.f3031b.h(16);
        this.f3031b.r(5);
        this.k = this.f3031b.g();
        this.f3031b.r(2);
        this.f3035f = this.f3031b.g();
        this.g = this.f3031b.g();
        this.f3031b.r(6);
        int h3 = this.f3031b.h(8);
        this.i = h3;
        if (h2 == 0) {
            this.j = -1;
        } else {
            int i = ((h2 + 6) - 9) - h3;
            this.j = i;
            if (i < 0) {
                StringBuilder sb2 = new StringBuilder(47);
                sb2.append("Found negative packet payload size: ");
                sb2.append(i);
                u.h("PesReader", sb2.toString());
                this.j = -1;
            }
        }
        return true;
    }

    @RequiresNonNull({"timestampAdjuster"})
    private void f() {
        this.f3031b.p(0);
        this.l = -9223372036854775807L;
        if (this.f3035f) {
            this.f3031b.r(4);
            this.f3031b.r(1);
            this.f3031b.r(1);
            long h = (this.f3031b.h(3) << 30) | (this.f3031b.h(15) << 15) | this.f3031b.h(15);
            this.f3031b.r(1);
            if (!this.h && this.g) {
                this.f3031b.r(4);
                this.f3031b.r(1);
                this.f3031b.r(1);
                this.f3031b.r(1);
                this.f3034e.b((this.f3031b.h(3) << 30) | (this.f3031b.h(15) << 15) | this.f3031b.h(15));
                this.h = true;
            }
            this.l = this.f3034e.b(h);
        }
    }

    private void g(int i) {
        this.f3032c = i;
        this.f3033d = 0;
    }

    @Override // com.google.android.exoplayer2.o2.l0.i0
    public void a(l0 l0Var, l lVar, i0.d dVar) {
        this.f3034e = l0Var;
        this.a.d(lVar, dVar);
    }

    @Override // com.google.android.exoplayer2.o2.l0.i0
    public final void b(d0 d0Var, int i) throws ParserException {
        g.i(this.f3034e);
        if ((i & 1) != 0) {
            int i2 = this.f3032c;
            if (!(i2 == 0 || i2 == 1)) {
                if (i2 == 2) {
                    u.h("PesReader", "Unexpected start indicator reading extended header");
                } else if (i2 == 3) {
                    int i3 = this.j;
                    if (i3 != -1) {
                        StringBuilder sb = new StringBuilder(59);
                        sb.append("Unexpected start indicator: expected ");
                        sb.append(i3);
                        sb.append(" more bytes");
                        u.h("PesReader", sb.toString());
                    }
                    this.a.e();
                } else {
                    throw new IllegalStateException();
                }
            }
            g(1);
        }
        while (d0Var.a() > 0) {
            int i4 = this.f3032c;
            if (i4 != 0) {
                int i5 = 0;
                if (i4 != 1) {
                    if (i4 == 2) {
                        if (d(d0Var, this.f3031b.a, Math.min(10, this.i)) && d(d0Var, null, this.i)) {
                            f();
                            if (this.k) {
                                i5 = 4;
                            }
                            i |= i5;
                            this.a.f(this.l, i);
                            g(3);
                        }
                    } else if (i4 == 3) {
                        int a = d0Var.a();
                        int i6 = this.j;
                        if (i6 != -1) {
                            i5 = a - i6;
                        }
                        if (i5 > 0) {
                            a -= i5;
                            d0Var.O(d0Var.e() + a);
                        }
                        this.a.b(d0Var);
                        int i7 = this.j;
                        if (i7 != -1) {
                            int i8 = i7 - a;
                            this.j = i8;
                            if (i8 == 0) {
                                this.a.e();
                                g(1);
                            }
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                } else if (d(d0Var, this.f3031b.a, 9)) {
                    if (e()) {
                        i5 = 2;
                    }
                    g(i5);
                }
            } else {
                d0Var.Q(d0Var.a());
            }
        }
    }

    @Override // com.google.android.exoplayer2.o2.l0.i0
    public final void c() {
        this.f3032c = 0;
        this.f3033d = 0;
        this.h = false;
        this.a.c();
    }
}
