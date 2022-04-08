package com.google.android.exoplayer2.o2.l0;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.o2.b0;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.o2.l0.i0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.e0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.i;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.z;
import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: H264Reader.java */
/* loaded from: classes.dex */
public final class r implements o {
    private final e0 a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f2985b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f2986c;
    private long g;
    private String i;
    private b0 j;
    private b k;
    private boolean l;
    private long m;
    private boolean n;
    private final boolean[] h = new boolean[3];

    /* renamed from: d  reason: collision with root package name */
    private final w f2987d = new w(7, 128);

    /* renamed from: e  reason: collision with root package name */
    private final w f2988e = new w(8, 128);

    /* renamed from: f  reason: collision with root package name */
    private final w f2989f = new w(6, 128);
    private final d0 o = new d0();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: H264Reader.java */
    /* loaded from: classes.dex */
    public static final class b {
        private final b0 a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f2990b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f2991c;

        /* renamed from: f  reason: collision with root package name */
        private final e0 f2994f;
        private byte[] g;
        private int h;
        private int i;
        private long j;
        private boolean k;
        private long l;
        private boolean o;
        private long p;
        private long q;
        private boolean r;

        /* renamed from: d  reason: collision with root package name */
        private final SparseArray<z.b> f2992d = new SparseArray<>();

        /* renamed from: e  reason: collision with root package name */
        private final SparseArray<z.a> f2993e = new SparseArray<>();
        private a m = new a();
        private a n = new a();

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: H264Reader.java */
        /* loaded from: classes.dex */
        public static final class a {
            private boolean a;

            /* renamed from: b  reason: collision with root package name */
            private boolean f2995b;
            @Nullable

            /* renamed from: c  reason: collision with root package name */
            private z.b f2996c;

            /* renamed from: d  reason: collision with root package name */
            private int f2997d;

            /* renamed from: e  reason: collision with root package name */
            private int f2998e;

            /* renamed from: f  reason: collision with root package name */
            private int f2999f;
            private int g;
            private boolean h;
            private boolean i;
            private boolean j;
            private boolean k;
            private int l;
            private int m;
            private int n;
            private int o;
            private int p;

            private a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public boolean c(a aVar) {
                int i;
                int i2;
                int i3;
                boolean z;
                if (!this.a) {
                    return false;
                }
                if (!aVar.a) {
                    return true;
                }
                z.b bVar = (z.b) g.i(this.f2996c);
                z.b bVar2 = (z.b) g.i(aVar.f2996c);
                return (this.f2999f == aVar.f2999f && this.g == aVar.g && this.h == aVar.h && (!this.i || !aVar.i || this.j == aVar.j) && (((i = this.f2997d) == (i2 = aVar.f2997d) || (i != 0 && i2 != 0)) && (((i3 = bVar.k) != 0 || bVar2.k != 0 || (this.m == aVar.m && this.n == aVar.n)) && ((i3 != 1 || bVar2.k != 1 || (this.o == aVar.o && this.p == aVar.p)) && (z = this.k) == aVar.k && (!z || this.l == aVar.l))))) ? false : true;
            }

            public void b() {
                this.f2995b = false;
                this.a = false;
            }

            public boolean d() {
                int i;
                return this.f2995b && ((i = this.f2998e) == 7 || i == 2);
            }

            public void e(z.b bVar, int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4, int i5, int i6, int i7, int i8, int i9) {
                this.f2996c = bVar;
                this.f2997d = i;
                this.f2998e = i2;
                this.f2999f = i3;
                this.g = i4;
                this.h = z;
                this.i = z2;
                this.j = z3;
                this.k = z4;
                this.l = i5;
                this.m = i6;
                this.n = i7;
                this.o = i8;
                this.p = i9;
                this.a = true;
                this.f2995b = true;
            }

            public void f(int i) {
                this.f2998e = i;
                this.f2995b = true;
            }
        }

        public b(b0 b0Var, boolean z, boolean z2) {
            this.a = b0Var;
            this.f2990b = z;
            this.f2991c = z2;
            byte[] bArr = new byte[128];
            this.g = bArr;
            this.f2994f = new e0(bArr, 0, 0);
            g();
        }

        private void d(int i) {
            boolean z = this.r;
            this.a.e(this.q, z ? 1 : 0, (int) (this.j - this.p), i, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:53:0x00ff  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0102  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0106  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0118  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x011e  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x014e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(byte[] r24, int r25, int r26) {
            /*
                Method dump skipped, instructions count: 408
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.o2.l0.r.b.a(byte[], int, int):void");
        }

        public boolean b(long j, int i, boolean z, boolean z2) {
            boolean z3 = false;
            if (this.i == 9 || (this.f2991c && this.n.c(this.m))) {
                if (z && this.o) {
                    d(i + ((int) (j - this.j)));
                }
                this.p = this.j;
                this.q = this.l;
                this.r = false;
                this.o = true;
            }
            if (this.f2990b) {
                z2 = this.n.d();
            }
            boolean z4 = this.r;
            int i2 = this.i;
            if (i2 == 5 || (z2 && i2 == 1)) {
                z3 = true;
            }
            boolean z5 = z4 | z3;
            this.r = z5;
            return z5;
        }

        public boolean c() {
            return this.f2991c;
        }

        public void e(z.a aVar) {
            this.f2993e.append(aVar.a, aVar);
        }

        public void f(z.b bVar) {
            this.f2992d.append(bVar.f3964d, bVar);
        }

        public void g() {
            this.k = false;
            this.o = false;
            this.n.b();
        }

        public void h(long j, int i, long j2) {
            this.i = i;
            this.l = j2;
            this.j = j;
            if (!this.f2990b || i != 1) {
                if (!this.f2991c) {
                    return;
                }
                if (!(i == 5 || i == 1 || i == 2)) {
                    return;
                }
            }
            a aVar = this.m;
            this.m = this.n;
            this.n = aVar;
            aVar.b();
            this.h = 0;
            this.k = true;
        }
    }

    public r(e0 e0Var, boolean z, boolean z2) {
        this.a = e0Var;
        this.f2985b = z;
        this.f2986c = z2;
    }

    @EnsuresNonNull({"output", "sampleReader"})
    private void a() {
        g.i(this.j);
        o0.i(this.k);
    }

    @RequiresNonNull({"output", "sampleReader"})
    private void g(long j, int i, int i2, long j2) {
        if (!this.l || this.k.c()) {
            this.f2987d.b(i2);
            this.f2988e.b(i2);
            if (!this.l) {
                if (this.f2987d.c() && this.f2988e.c()) {
                    ArrayList arrayList = new ArrayList();
                    w wVar = this.f2987d;
                    arrayList.add(Arrays.copyOf(wVar.f3027d, wVar.f3028e));
                    w wVar2 = this.f2988e;
                    arrayList.add(Arrays.copyOf(wVar2.f3027d, wVar2.f3028e));
                    w wVar3 = this.f2987d;
                    z.b i3 = z.i(wVar3.f3027d, 3, wVar3.f3028e);
                    w wVar4 = this.f2988e;
                    z.a h = z.h(wVar4.f3027d, 3, wVar4.f3028e);
                    this.j.d(new Format.b().S(this.i).e0("video/avc").I(i.a(i3.a, i3.f3962b, i3.f3963c)).j0(i3.f3965e).Q(i3.f3966f).a0(i3.g).T(arrayList).E());
                    this.l = true;
                    this.k.f(i3);
                    this.k.e(h);
                    this.f2987d.d();
                    this.f2988e.d();
                }
            } else if (this.f2987d.c()) {
                w wVar5 = this.f2987d;
                this.k.f(z.i(wVar5.f3027d, 3, wVar5.f3028e));
                this.f2987d.d();
            } else if (this.f2988e.c()) {
                w wVar6 = this.f2988e;
                this.k.e(z.h(wVar6.f3027d, 3, wVar6.f3028e));
                this.f2988e.d();
            }
        }
        if (this.f2989f.b(i2)) {
            w wVar7 = this.f2989f;
            this.o.N(this.f2989f.f3027d, z.k(wVar7.f3027d, wVar7.f3028e));
            this.o.P(4);
            this.a.a(j2, this.o);
        }
        if (this.k.b(j, i, this.l, this.n)) {
            this.n = false;
        }
    }

    @RequiresNonNull({"sampleReader"})
    private void h(byte[] bArr, int i, int i2) {
        if (!this.l || this.k.c()) {
            this.f2987d.a(bArr, i, i2);
            this.f2988e.a(bArr, i, i2);
        }
        this.f2989f.a(bArr, i, i2);
        this.k.a(bArr, i, i2);
    }

    @RequiresNonNull({"sampleReader"})
    private void i(long j, int i, long j2) {
        if (!this.l || this.k.c()) {
            this.f2987d.e(i);
            this.f2988e.e(i);
        }
        this.f2989f.e(i);
        this.k.h(j, i, j2);
    }

    @Override // com.google.android.exoplayer2.o2.l0.o
    public void b(d0 d0Var) {
        a();
        int e2 = d0Var.e();
        int f2 = d0Var.f();
        byte[] d2 = d0Var.d();
        this.g += d0Var.a();
        this.j.c(d0Var, d0Var.a());
        while (true) {
            int c2 = z.c(d2, e2, f2, this.h);
            if (c2 == f2) {
                h(d2, e2, f2);
                return;
            }
            int f3 = z.f(d2, c2);
            int i = c2 - e2;
            if (i > 0) {
                h(d2, e2, c2);
            }
            int i2 = f2 - c2;
            long j = this.g - i2;
            g(j, i2, i < 0 ? -i : 0, this.m);
            i(j, f3, this.m);
            e2 = c2 + 3;
        }
    }

    @Override // com.google.android.exoplayer2.o2.l0.o
    public void c() {
        this.g = 0L;
        this.n = false;
        z.a(this.h);
        this.f2987d.d();
        this.f2988e.d();
        this.f2989f.d();
        b bVar = this.k;
        if (bVar != null) {
            bVar.g();
        }
    }

    @Override // com.google.android.exoplayer2.o2.l0.o
    public void d(l lVar, i0.d dVar) {
        dVar.a();
        this.i = dVar.b();
        b0 t = lVar.t(dVar.c(), 2);
        this.j = t;
        this.k = new b(t, this.f2985b, this.f2986c);
        this.a.b(lVar, dVar);
    }

    @Override // com.google.android.exoplayer2.o2.l0.o
    public void e() {
    }

    @Override // com.google.android.exoplayer2.o2.l0.o
    public void f(long j, int i) {
        this.m = j;
        this.n |= (i & 2) != 0;
    }
}
