package com.google.android.exoplayer2.o2.l0;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.core.view.InputDeviceCompat;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.o2.j;
import com.google.android.exoplayer2.o2.k;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.o2.l0.i0;
import com.google.android.exoplayer2.o2.o;
import com.google.android.exoplayer2.o2.x;
import com.google.android.exoplayer2.o2.y;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.l0;
import com.google.android.exoplayer2.util.o0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: TsExtractor.java */
/* loaded from: classes.dex */
public final class h0 implements j {
    public static final o a = e.f2894b;

    /* renamed from: b  reason: collision with root package name */
    private final int f2915b;

    /* renamed from: c  reason: collision with root package name */
    private final int f2916c;

    /* renamed from: d  reason: collision with root package name */
    private final List<l0> f2917d;

    /* renamed from: e  reason: collision with root package name */
    private final d0 f2918e;

    /* renamed from: f  reason: collision with root package name */
    private final SparseIntArray f2919f;
    private final i0.c g;
    private final SparseArray<i0> h;
    private final SparseBooleanArray i;
    private final SparseBooleanArray j;
    private final g0 k;
    private f0 l;
    private l m;
    private int n;
    private boolean o;
    private boolean p;
    private boolean q;
    private i0 r;
    private int s;
    private int t;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TsExtractor.java */
    /* loaded from: classes.dex */
    public class a implements c0 {
        private final c0 a = new c0(new byte[4]);

        public a() {
        }

        @Override // com.google.android.exoplayer2.o2.l0.c0
        public void a(l0 l0Var, l lVar, i0.d dVar) {
        }

        @Override // com.google.android.exoplayer2.o2.l0.c0
        public void b(d0 d0Var) {
            if (d0Var.D() == 0 && (d0Var.D() & 128) != 0) {
                d0Var.Q(6);
                int a = d0Var.a() / 4;
                for (int i = 0; i < a; i++) {
                    d0Var.i(this.a, 4);
                    int h = this.a.h(16);
                    this.a.r(3);
                    if (h == 0) {
                        this.a.r(13);
                    } else {
                        int h2 = this.a.h(13);
                        if (h0.this.h.get(h2) == null) {
                            h0.this.h.put(h2, new d0(new b(h2)));
                            h0.j(h0.this);
                        }
                    }
                }
                if (h0.this.f2915b != 2) {
                    h0.this.h.remove(0);
                }
            }
        }
    }

    /* compiled from: TsExtractor.java */
    /* loaded from: classes.dex */
    private class b implements c0 {
        private final c0 a = new c0(new byte[5]);

        /* renamed from: b  reason: collision with root package name */
        private final SparseArray<i0> f2921b = new SparseArray<>();

        /* renamed from: c  reason: collision with root package name */
        private final SparseIntArray f2922c = new SparseIntArray();

        /* renamed from: d  reason: collision with root package name */
        private final int f2923d;

        public b(int i) {
            this.f2923d = i;
        }

        private i0.b c(d0 d0Var, int i) {
            int e2 = d0Var.e();
            int i2 = i + e2;
            String str = null;
            ArrayList arrayList = null;
            int i3 = -1;
            while (d0Var.e() < i2) {
                int D = d0Var.D();
                int e3 = d0Var.e() + d0Var.D();
                if (e3 > i2) {
                    break;
                } else if (D == 5) {
                    long F = d0Var.F();
                    if (F != 1094921523) {
                        if (F != 1161904947) {
                            if (F != 1094921524) {
                                if (F == 1212503619) {
                                    i3 = 36;
                                }
                                d0Var.Q(e3 - d0Var.e());
                            }
                            i3 = 172;
                            d0Var.Q(e3 - d0Var.e());
                        }
                        i3 = 135;
                        d0Var.Q(e3 - d0Var.e());
                    }
                    i3 = 129;
                    d0Var.Q(e3 - d0Var.e());
                } else {
                    if (D != 106) {
                        if (D != 122) {
                            if (D == 127) {
                                if (d0Var.D() != 21) {
                                }
                                i3 = 172;
                            } else if (D == 123) {
                                i3 = 138;
                            } else if (D == 10) {
                                str = d0Var.A(3).trim();
                            } else if (D == 89) {
                                arrayList = new ArrayList();
                                while (d0Var.e() < e3) {
                                    String trim = d0Var.A(3).trim();
                                    int D2 = d0Var.D();
                                    byte[] bArr = new byte[4];
                                    d0Var.j(bArr, 0, 4);
                                    arrayList.add(new i0.a(trim, D2, bArr));
                                }
                                i3 = 89;
                            } else if (D == 111) {
                                i3 = InputDeviceCompat.SOURCE_KEYBOARD;
                            }
                            d0Var.Q(e3 - d0Var.e());
                        }
                        i3 = 135;
                        d0Var.Q(e3 - d0Var.e());
                    }
                    i3 = 129;
                    d0Var.Q(e3 - d0Var.e());
                }
            }
            d0Var.P(i2);
            return new i0.b(i3, str, arrayList, Arrays.copyOfRange(d0Var.d(), e2, i2));
        }

        @Override // com.google.android.exoplayer2.o2.l0.c0
        public void a(l0 l0Var, l lVar, i0.d dVar) {
        }

        @Override // com.google.android.exoplayer2.o2.l0.c0
        public void b(d0 d0Var) {
            l0 l0Var;
            if (d0Var.D() == 2) {
                if (h0.this.f2915b == 1 || h0.this.f2915b == 2 || h0.this.n == 1) {
                    l0Var = (l0) h0.this.f2917d.get(0);
                } else {
                    l0Var = new l0(((l0) h0.this.f2917d.get(0)).c());
                    h0.this.f2917d.add(l0Var);
                }
                if ((d0Var.D() & 128) != 0) {
                    d0Var.Q(1);
                    int J = d0Var.J();
                    int i = 3;
                    d0Var.Q(3);
                    d0Var.i(this.a, 2);
                    this.a.r(3);
                    int i2 = 13;
                    h0.this.t = this.a.h(13);
                    d0Var.i(this.a, 2);
                    int i3 = 4;
                    this.a.r(4);
                    d0Var.Q(this.a.h(12));
                    if (h0.this.f2915b == 2 && h0.this.r == null) {
                        i0.b bVar = new i0.b(21, null, null, o0.f3937f);
                        h0 h0Var = h0.this;
                        h0Var.r = h0Var.g.b(21, bVar);
                        h0.this.r.a(l0Var, h0.this.m, new i0.d(J, 21, 8192));
                    }
                    this.f2921b.clear();
                    this.f2922c.clear();
                    int a = d0Var.a();
                    while (a > 0) {
                        d0Var.i(this.a, 5);
                        int h = this.a.h(8);
                        this.a.r(i);
                        int h2 = this.a.h(i2);
                        this.a.r(i3);
                        int h3 = this.a.h(12);
                        i0.b c2 = c(d0Var, h3);
                        if (h == 6 || h == 5) {
                            h = c2.a;
                        }
                        a -= h3 + 5;
                        int i4 = h0.this.f2915b == 2 ? h : h2;
                        if (!h0.this.i.get(i4)) {
                            i0 b2 = (h0.this.f2915b == 2 && h == 21) ? h0.this.r : h0.this.g.b(h, c2);
                            if (h0.this.f2915b != 2 || h2 < this.f2922c.get(i4, 8192)) {
                                this.f2922c.put(i4, h2);
                                this.f2921b.put(i4, b2);
                            }
                        }
                        i = 3;
                        i3 = 4;
                        i2 = 13;
                    }
                    int size = this.f2922c.size();
                    for (int i5 = 0; i5 < size; i5++) {
                        int keyAt = this.f2922c.keyAt(i5);
                        int valueAt = this.f2922c.valueAt(i5);
                        h0.this.i.put(keyAt, true);
                        h0.this.j.put(valueAt, true);
                        i0 valueAt2 = this.f2921b.valueAt(i5);
                        if (valueAt2 != null) {
                            if (valueAt2 != h0.this.r) {
                                valueAt2.a(l0Var, h0.this.m, new i0.d(J, keyAt, 8192));
                            }
                            h0.this.h.put(valueAt, valueAt2);
                        }
                    }
                    if (h0.this.f2915b != 2) {
                        h0.this.h.remove(this.f2923d);
                        h0 h0Var2 = h0.this;
                        h0Var2.n = h0Var2.f2915b == 1 ? 0 : h0.this.n - 1;
                        if (h0.this.n == 0) {
                            h0.this.m.r();
                            h0.this.o = true;
                        }
                    } else if (!h0.this.o) {
                        h0.this.m.r();
                        h0.this.n = 0;
                        h0.this.o = true;
                    }
                }
            }
        }
    }

    public h0() {
        this(0);
    }

    static /* synthetic */ int j(h0 h0Var) {
        int i = h0Var.n;
        h0Var.n = i + 1;
        return i;
    }

    private boolean t(k kVar) throws IOException {
        byte[] d2 = this.f2918e.d();
        if (9400 - this.f2918e.e() < 188) {
            int a2 = this.f2918e.a();
            if (a2 > 0) {
                System.arraycopy(d2, this.f2918e.e(), d2, 0, a2);
            }
            this.f2918e.N(d2, a2);
        }
        while (this.f2918e.a() < 188) {
            int f2 = this.f2918e.f();
            int read = kVar.read(d2, f2, 9400 - f2);
            if (read == -1) {
                return false;
            }
            this.f2918e.O(f2 + read);
        }
        return true;
    }

    private int u() throws ParserException {
        int e2 = this.f2918e.e();
        int f2 = this.f2918e.f();
        int a2 = j0.a(this.f2918e.d(), e2, f2);
        this.f2918e.P(a2);
        int i = a2 + 188;
        if (i > f2) {
            int i2 = this.s + (a2 - e2);
            this.s = i2;
            if (this.f2915b == 2 && i2 > 376) {
                throw ParserException.createForMalformedContainer("Cannot find sync byte. Most likely not a Transport Stream.", null);
            }
        } else {
            this.s = 0;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ j[] v() {
        return new j[]{new h0()};
    }

    private void w(long j) {
        if (!this.p) {
            this.p = true;
            if (this.k.b() != -9223372036854775807L) {
                f0 f0Var = new f0(this.k.c(), this.k.b(), j, this.t, this.f2916c);
                this.l = f0Var;
                this.m.o(f0Var.b());
                return;
            }
            this.m.o(new y.b(this.k.b()));
        }
    }

    private void x() {
        this.i.clear();
        this.h.clear();
        SparseArray<i0> a2 = this.g.a();
        int size = a2.size();
        for (int i = 0; i < size; i++) {
            this.h.put(a2.keyAt(i), a2.valueAt(i));
        }
        this.h.put(0, new d0(new a()));
        this.r = null;
    }

    private boolean y(int i) {
        return this.f2915b == 2 || this.o || !this.j.get(i, false);
    }

    @Override // com.google.android.exoplayer2.o2.j
    public void b(l lVar) {
        this.m = lVar;
    }

    @Override // com.google.android.exoplayer2.o2.j
    public void c(long j, long j2) {
        f0 f0Var;
        g.g(this.f2915b != 2);
        int size = this.f2917d.size();
        for (int i = 0; i < size; i++) {
            l0 l0Var = this.f2917d.get(i);
            boolean z = l0Var.e() == -9223372036854775807L;
            if (!z) {
                long c2 = l0Var.c();
                z = (c2 == -9223372036854775807L || c2 == 0 || c2 == j2) ? false : true;
            }
            if (z) {
                l0Var.g(j2);
            }
        }
        if (!(j2 == 0 || (f0Var = this.l) == null)) {
            f0Var.h(j2);
        }
        this.f2918e.L(0);
        this.f2919f.clear();
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            this.h.valueAt(i2).c();
        }
        this.s = 0;
    }

    @Override // com.google.android.exoplayer2.o2.j
    public boolean d(k kVar) throws IOException {
        boolean z;
        byte[] d2 = this.f2918e.d();
        kVar.n(d2, 0, 940);
        for (int i = 0; i < 188; i++) {
            int i2 = 0;
            while (true) {
                if (i2 >= 5) {
                    z = true;
                    break;
                } else if (d2[(i2 * 188) + i] != 71) {
                    z = false;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                kVar.l(i);
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.o2.j
    public int e(k kVar, x xVar) throws IOException {
        long a2 = kVar.a();
        if (this.o) {
            if (((a2 == -1 || this.f2915b == 2) ? false : true) && !this.k.d()) {
                return this.k.e(kVar, xVar, this.t);
            }
            w(a2);
            if (this.q) {
                this.q = false;
                c(0L, 0L);
                if (kVar.getPosition() != 0) {
                    xVar.a = 0L;
                    return 1;
                }
            }
            f0 f0Var = this.l;
            if (f0Var != null && f0Var.d()) {
                return this.l.c(kVar, xVar);
            }
        }
        if (!t(kVar)) {
            return -1;
        }
        int u = u();
        int f2 = this.f2918e.f();
        if (u > f2) {
            return 0;
        }
        int n = this.f2918e.n();
        if ((8388608 & n) != 0) {
            this.f2918e.P(u);
            return 0;
        }
        int i = ((4194304 & n) != 0 ? 1 : 0) | 0;
        int i2 = (2096896 & n) >> 8;
        boolean z = (n & 32) != 0;
        i0 i0Var = (n & 16) != 0 ? this.h.get(i2) : null;
        if (i0Var == null) {
            this.f2918e.P(u);
            return 0;
        }
        if (this.f2915b != 2) {
            int i3 = n & 15;
            int i4 = this.f2919f.get(i2, i3 - 1);
            this.f2919f.put(i2, i3);
            if (i4 == i3) {
                this.f2918e.P(u);
                return 0;
            } else if (i3 != ((i4 + 1) & 15)) {
                i0Var.c();
            }
        }
        if (z) {
            int D = this.f2918e.D();
            i |= (this.f2918e.D() & 64) != 0 ? 2 : 0;
            this.f2918e.Q(D - 1);
        }
        boolean z2 = this.o;
        if (y(i2)) {
            this.f2918e.O(u);
            i0Var.b(this.f2918e, i);
            this.f2918e.O(f2);
        }
        if (this.f2915b != 2 && !z2 && this.o && a2 != -1) {
            this.q = true;
        }
        this.f2918e.P(u);
        return 0;
    }

    @Override // com.google.android.exoplayer2.o2.j
    public void release() {
    }

    public h0(int i) {
        this(1, i, 112800);
    }

    public h0(int i, int i2, int i3) {
        this(i, new l0(0L), new l(i2), i3);
    }

    public h0(int i, l0 l0Var, i0.c cVar) {
        this(i, l0Var, cVar, 112800);
    }

    public h0(int i, l0 l0Var, i0.c cVar, int i2) {
        this.g = (i0.c) g.e(cVar);
        this.f2916c = i2;
        this.f2915b = i;
        if (i == 1 || i == 2) {
            this.f2917d = Collections.singletonList(l0Var);
        } else {
            ArrayList arrayList = new ArrayList();
            this.f2917d = arrayList;
            arrayList.add(l0Var);
        }
        this.f2918e = new d0(new byte[9400], 0);
        this.i = new SparseBooleanArray();
        this.j = new SparseBooleanArray();
        this.h = new SparseArray<>();
        this.f2919f = new SparseIntArray();
        this.k = new g0(i2);
        this.t = -1;
        x();
    }
}
