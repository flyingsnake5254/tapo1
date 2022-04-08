package com.google.android.exoplayer2.o2.l0;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.o2.b0;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.o2.l0.i0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.z;
import java.util.Arrays;

/* compiled from: H262Reader.java */
/* loaded from: classes.dex */
public final class p implements o {
    private static final double[] a = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};

    /* renamed from: b  reason: collision with root package name */
    private String f2961b;

    /* renamed from: c  reason: collision with root package name */
    private b0 f2962c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final k0 f2963d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final d0 f2964e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final w f2965f;
    private final boolean[] g;
    private final a h;
    private long i;
    private boolean j;
    private boolean k;
    private long l;
    private long m;
    private long n;
    private long o;
    private boolean p;
    private boolean q;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: H262Reader.java */
    /* loaded from: classes.dex */
    public static final class a {
        private static final byte[] a = {0, 0, 1};

        /* renamed from: b  reason: collision with root package name */
        private boolean f2966b;

        /* renamed from: c  reason: collision with root package name */
        public int f2967c;

        /* renamed from: d  reason: collision with root package name */
        public int f2968d;

        /* renamed from: e  reason: collision with root package name */
        public byte[] f2969e;

        public a(int i) {
            this.f2969e = new byte[i];
        }

        public void a(byte[] bArr, int i, int i2) {
            if (this.f2966b) {
                int i3 = i2 - i;
                byte[] bArr2 = this.f2969e;
                int length = bArr2.length;
                int i4 = this.f2967c;
                if (length < i4 + i3) {
                    this.f2969e = Arrays.copyOf(bArr2, (i4 + i3) * 2);
                }
                System.arraycopy(bArr, i, this.f2969e, this.f2967c, i3);
                this.f2967c += i3;
            }
        }

        public boolean b(int i, int i2) {
            if (this.f2966b) {
                int i3 = this.f2967c - i2;
                this.f2967c = i3;
                if (this.f2968d == 0 && i == 181) {
                    this.f2968d = i3;
                } else {
                    this.f2966b = false;
                    return true;
                }
            } else if (i == 179) {
                this.f2966b = true;
            }
            byte[] bArr = a;
            a(bArr, 0, bArr.length);
            return false;
        }

        public void c() {
            this.f2966b = false;
            this.f2967c = 0;
            this.f2968d = 0;
        }
    }

    public p() {
        this(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.util.Pair<com.google.android.exoplayer2.Format, java.lang.Long> a(com.google.android.exoplayer2.o2.l0.p.a r8, java.lang.String r9) {
        /*
            byte[] r0 = r8.f2969e
            int r1 = r8.f2967c
            byte[] r0 = java.util.Arrays.copyOf(r0, r1)
            r1 = 4
            byte r2 = r0[r1]
            r2 = r2 & 255(0xff, float:3.57E-43)
            r3 = 5
            byte r4 = r0[r3]
            r4 = r4 & 255(0xff, float:3.57E-43)
            r5 = 6
            byte r5 = r0[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r1
            int r6 = r4 >> 4
            r2 = r2 | r6
            r4 = r4 & 15
            int r4 = r4 << 8
            r4 = r4 | r5
            r5 = 7
            byte r6 = r0[r5]
            r6 = r6 & 240(0xf0, float:3.36E-43)
            int r6 = r6 >> r1
            r7 = 2
            if (r6 == r7) goto L_0x003d
            r7 = 3
            if (r6 == r7) goto L_0x0037
            if (r6 == r1) goto L_0x0031
            r1 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0044
        L_0x0031:
            int r1 = r4 * 121
            float r1 = (float) r1
            int r6 = r2 * 100
            goto L_0x0042
        L_0x0037:
            int r1 = r4 * 16
            float r1 = (float) r1
            int r6 = r2 * 9
            goto L_0x0042
        L_0x003d:
            int r1 = r4 * 4
            float r1 = (float) r1
            int r6 = r2 * 3
        L_0x0042:
            float r6 = (float) r6
            float r1 = r1 / r6
        L_0x0044:
            com.google.android.exoplayer2.Format$b r6 = new com.google.android.exoplayer2.Format$b
            r6.<init>()
            com.google.android.exoplayer2.Format$b r9 = r6.S(r9)
            java.lang.String r6 = "video/mpeg2"
            com.google.android.exoplayer2.Format$b r9 = r9.e0(r6)
            com.google.android.exoplayer2.Format$b r9 = r9.j0(r2)
            com.google.android.exoplayer2.Format$b r9 = r9.Q(r4)
            com.google.android.exoplayer2.Format$b r9 = r9.a0(r1)
            java.util.List r1 = java.util.Collections.singletonList(r0)
            com.google.android.exoplayer2.Format$b r9 = r9.T(r1)
            com.google.android.exoplayer2.Format r9 = r9.E()
            r1 = 0
            byte r4 = r0[r5]
            r4 = r4 & 15
            int r4 = r4 + (-1)
            if (r4 < 0) goto L_0x009d
            double[] r5 = com.google.android.exoplayer2.o2.l0.p.a
            int r6 = r5.length
            if (r4 >= r6) goto L_0x009d
            r1 = r5[r4]
            int r8 = r8.f2968d
            int r8 = r8 + 9
            byte r4 = r0[r8]
            r4 = r4 & 96
            int r3 = r4 >> 5
            byte r8 = r0[r8]
            r8 = r8 & 31
            if (r3 == r8) goto L_0x0096
            double r3 = (double) r3
            r5 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r3 = r3 + r5
            int r8 = r8 + 1
            double r5 = (double) r8
            double r3 = r3 / r5
            double r1 = r1 * r3
        L_0x0096:
            r3 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r3 = r3 / r1
            long r1 = (long) r3
        L_0x009d:
            java.lang.Long r8 = java.lang.Long.valueOf(r1)
            android.util.Pair r8 = android.util.Pair.create(r9, r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.o2.l0.p.a(com.google.android.exoplayer2.o2.l0.p$a, java.lang.String):android.util.Pair");
    }

    @Override // com.google.android.exoplayer2.o2.l0.o
    public void b(d0 d0Var) {
        int i;
        g.i(this.f2962c);
        int e2 = d0Var.e();
        int f2 = d0Var.f();
        byte[] d2 = d0Var.d();
        this.i += d0Var.a();
        this.f2962c.c(d0Var, d0Var.a());
        while (true) {
            int c2 = z.c(d2, e2, f2, this.g);
            if (c2 == f2) {
                break;
            }
            int i2 = c2 + 3;
            int i3 = d0Var.d()[i2] & 255;
            int i4 = c2 - e2;
            boolean z = false;
            if (!this.k) {
                if (i4 > 0) {
                    this.h.a(d2, e2, c2);
                }
                if (this.h.b(i3, i4 < 0 ? -i4 : 0)) {
                    Pair<Format, Long> a2 = a(this.h, (String) g.e(this.f2961b));
                    this.f2962c.d((Format) a2.first);
                    this.l = ((Long) a2.second).longValue();
                    this.k = true;
                }
            }
            w wVar = this.f2965f;
            if (wVar != null) {
                if (i4 > 0) {
                    wVar.a(d2, e2, c2);
                    i = 0;
                } else {
                    i = -i4;
                }
                if (this.f2965f.b(i)) {
                    w wVar2 = this.f2965f;
                    ((d0) o0.i(this.f2964e)).N(this.f2965f.f3027d, z.k(wVar2.f3027d, wVar2.f3028e));
                    ((k0) o0.i(this.f2963d)).a(this.o, this.f2964e);
                }
                if (i3 == 178 && d0Var.d()[c2 + 2] == 1) {
                    this.f2965f.e(i3);
                }
            }
            if (i3 == 0 || i3 == 179) {
                int i5 = f2 - c2;
                if (this.j && this.q && this.k) {
                    this.f2962c.e(this.o, this.p ? 1 : 0, ((int) (this.i - this.n)) - i5, i5, null);
                }
                boolean z2 = this.j;
                if (!z2 || this.q) {
                    this.n = this.i - i5;
                    long j = this.m;
                    if (j == -9223372036854775807L) {
                        j = z2 ? this.o + this.l : 0L;
                    }
                    this.o = j;
                    this.p = false;
                    this.m = -9223372036854775807L;
                    this.j = true;
                }
                if (i3 == 0) {
                    z = true;
                }
                this.q = z;
            } else if (i3 == 184) {
                this.p = true;
            }
            e2 = i2;
        }
        if (!this.k) {
            this.h.a(d2, e2, f2);
        }
        w wVar3 = this.f2965f;
        if (wVar3 != null) {
            wVar3.a(d2, e2, f2);
        }
    }

    @Override // com.google.android.exoplayer2.o2.l0.o
    public void c() {
        z.a(this.g);
        this.h.c();
        w wVar = this.f2965f;
        if (wVar != null) {
            wVar.d();
        }
        this.i = 0L;
        this.j = false;
    }

    @Override // com.google.android.exoplayer2.o2.l0.o
    public void d(l lVar, i0.d dVar) {
        dVar.a();
        this.f2961b = dVar.b();
        this.f2962c = lVar.t(dVar.c(), 2);
        k0 k0Var = this.f2963d;
        if (k0Var != null) {
            k0Var.b(lVar, dVar);
        }
    }

    @Override // com.google.android.exoplayer2.o2.l0.o
    public void e() {
    }

    @Override // com.google.android.exoplayer2.o2.l0.o
    public void f(long j, int i) {
        this.m = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(@Nullable k0 k0Var) {
        this.f2963d = k0Var;
        this.g = new boolean[4];
        this.h = new a(128);
        if (k0Var != null) {
            this.f2965f = new w(178, 128);
            this.f2964e = new d0();
            return;
        }
        this.f2965f = null;
        this.f2964e = null;
    }
}
