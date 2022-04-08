package com.google.android.exoplayer2.o2.j0;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import com.google.android.exoplayer2.o2.b0;
import com.google.android.exoplayer2.o2.j;
import com.google.android.exoplayer2.o2.j0.e;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.o2.o;
import com.google.android.exoplayer2.o2.u;
import com.google.android.exoplayer2.o2.x;
import com.google.android.exoplayer2.o2.y;
import com.google.android.exoplayer2.o2.z;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: Mp4Extractor.java */
/* loaded from: classes.dex */
public final class k implements j, y {
    public static final o a = c.f2763b;

    /* renamed from: b  reason: collision with root package name */
    private final int f2804b;

    /* renamed from: c  reason: collision with root package name */
    private final d0 f2805c;

    /* renamed from: d  reason: collision with root package name */
    private final d0 f2806d;

    /* renamed from: e  reason: collision with root package name */
    private final d0 f2807e;

    /* renamed from: f  reason: collision with root package name */
    private final d0 f2808f;
    private final ArrayDeque<e.a> g;
    private final m h;
    private final List<Metadata.Entry> i;
    private int j;
    private int k;
    private long l;
    private int m;
    @Nullable
    private d0 n;
    private int o;
    private int p;
    private int q;
    private int r;
    private l s;
    private a[] t;
    private long[][] u;
    private int v;
    private long w;
    private int x;
    @Nullable
    private MotionPhotoMetadata y;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Mp4Extractor.java */
    /* loaded from: classes.dex */
    public static final class a {
        public final o a;

        /* renamed from: b  reason: collision with root package name */
        public final r f2809b;

        /* renamed from: c  reason: collision with root package name */
        public final b0 f2810c;

        /* renamed from: d  reason: collision with root package name */
        public int f2811d;

        public a(o oVar, r rVar, b0 b0Var) {
            this.a = oVar;
            this.f2809b = rVar;
            this.f2810c = b0Var;
        }
    }

    public k() {
        this(0);
    }

    private int A(com.google.android.exoplayer2.o2.k kVar, x xVar) throws IOException {
        int c2 = this.h.c(kVar, xVar, this.i);
        if (c2 == 1 && xVar.a == 0) {
            l();
        }
        return c2;
    }

    private static boolean B(int i) {
        return i == 1836019574 || i == 1953653099 || i == 1835297121 || i == 1835626086 || i == 1937007212 || i == 1701082227 || i == 1835365473;
    }

    private static boolean C(int i) {
        return i == 1835296868 || i == 1836476516 || i == 1751411826 || i == 1937011556 || i == 1937011827 || i == 1937011571 || i == 1668576371 || i == 1701606260 || i == 1937011555 || i == 1937011578 || i == 1937013298 || i == 1937007471 || i == 1668232756 || i == 1953196132 || i == 1718909296 || i == 1969517665 || i == 1801812339 || i == 1768715124;
    }

    @RequiresNonNull({"tracks"})
    private void D(long j) {
        a[] aVarArr;
        for (a aVar : this.t) {
            r rVar = aVar.f2809b;
            int a2 = rVar.a(j);
            if (a2 == -1) {
                a2 = rVar.b(j);
            }
            aVar.f2811d = a2;
        }
    }

    private static int j(int i) {
        if (i != 1751476579) {
            return i != 1903435808 ? 0 : 1;
        }
        return 2;
    }

    private static long[][] k(a[] aVarArr) {
        long[][] jArr = new long[aVarArr.length];
        int[] iArr = new int[aVarArr.length];
        long[] jArr2 = new long[aVarArr.length];
        boolean[] zArr = new boolean[aVarArr.length];
        for (int i = 0; i < aVarArr.length; i++) {
            jArr[i] = new long[aVarArr[i].f2809b.f2834b];
            jArr2[i] = aVarArr[i].f2809b.f2838f[0];
        }
        long j = 0;
        int i2 = 0;
        while (i2 < aVarArr.length) {
            long j2 = Long.MAX_VALUE;
            int i3 = -1;
            for (int i4 = 0; i4 < aVarArr.length; i4++) {
                if (!zArr[i4] && jArr2[i4] <= j2) {
                    j2 = jArr2[i4];
                    i3 = i4;
                }
            }
            int i5 = iArr[i3];
            jArr[i3][i5] = j;
            j += aVarArr[i3].f2809b.f2836d[i5];
            int i6 = i5 + 1;
            iArr[i3] = i6;
            if (i6 < jArr[i3].length) {
                jArr2[i3] = aVarArr[i3].f2809b.f2838f[i6];
            } else {
                zArr[i3] = true;
                i2++;
            }
        }
        return jArr;
    }

    private void l() {
        this.j = 0;
        this.m = 0;
    }

    private static int m(r rVar, long j) {
        int a2 = rVar.a(j);
        return a2 == -1 ? rVar.b(j) : a2;
    }

    private int n(long j) {
        int i = -1;
        int i2 = -1;
        long j2 = Long.MAX_VALUE;
        boolean z = true;
        long j3 = Long.MAX_VALUE;
        boolean z2 = true;
        long j4 = Long.MAX_VALUE;
        for (int i3 = 0; i3 < ((a[]) o0.i(this.t)).length; i3++) {
            a aVar = this.t[i3];
            int i4 = aVar.f2811d;
            r rVar = aVar.f2809b;
            if (i4 != rVar.f2834b) {
                long j5 = rVar.f2835c[i4];
                long j6 = ((long[][]) o0.i(this.u))[i3][i4];
                long j7 = j5 - j;
                boolean z3 = j7 < 0 || j7 >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                if ((!z3 && z2) || (z3 == z2 && j7 < j4)) {
                    z2 = z3;
                    j4 = j7;
                    i2 = i3;
                    j3 = j6;
                }
                if (j6 < j2) {
                    z = z3;
                    i = i3;
                    j2 = j6;
                }
            }
        }
        return (j2 == Long.MAX_VALUE || !z || j3 < j2 + 10485760) ? i2 : i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ o o(o oVar) {
        return oVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ j[] p() {
        return new j[]{new k()};
    }

    private static long q(r rVar, long j, long j2) {
        int m = m(rVar, j);
        return m == -1 ? j2 : Math.min(rVar.f2835c[m], j2);
    }

    private void r(com.google.android.exoplayer2.o2.k kVar) throws IOException {
        this.f2807e.L(8);
        kVar.n(this.f2807e.d(), 0, 8);
        f.d(this.f2807e);
        kVar.l(this.f2807e.e());
        kVar.e();
    }

    private void s(long j) throws ParserException {
        while (!this.g.isEmpty() && this.g.peek().f2765b == j) {
            e.a pop = this.g.pop();
            if (pop.a == 1836019574) {
                v(pop);
                this.g.clear();
                this.j = 2;
            } else if (!this.g.isEmpty()) {
                this.g.peek().d(pop);
            }
        }
        if (this.j != 2) {
            l();
        }
    }

    private void t() {
        if (this.x == 2 && (this.f2804b & 2) != 0) {
            l lVar = (l) g.e(this.s);
            lVar.t(0, 4).d(new Format.b().X(this.y == null ? null : new Metadata(this.y)).E());
            lVar.r();
            lVar.o(new y.b(-9223372036854775807L));
        }
    }

    private static int u(d0 d0Var) {
        d0Var.P(8);
        int j = j(d0Var.n());
        if (j != 0) {
            return j;
        }
        d0Var.Q(4);
        while (d0Var.a() > 0) {
            int j2 = j(d0Var.n());
            if (j2 != 0) {
                return j2;
            }
        }
        return 0;
    }

    private void v(e.a aVar) throws ParserException {
        Metadata metadata;
        Metadata metadata2;
        int i;
        ArrayList arrayList = new ArrayList();
        boolean z = this.x == 1;
        u uVar = new u();
        e.b g = aVar.g(1969517665);
        if (g != null) {
            Pair<Metadata, Metadata> A = f.A(g);
            Metadata metadata3 = (Metadata) A.first;
            metadata2 = (Metadata) A.second;
            if (metadata3 != null) {
                uVar.c(metadata3);
            }
            metadata = metadata3;
        } else {
            metadata2 = null;
            metadata = null;
        }
        e.a f2 = aVar.f(1835365473);
        Metadata m = f2 != null ? f.m(f2) : null;
        List<r> z2 = f.z(aVar, uVar, -9223372036854775807L, null, (this.f2804b & 1) != 0, z, b.f2762c);
        l lVar = (l) g.e(this.s);
        int size = z2.size();
        int i2 = -1;
        long j = -9223372036854775807L;
        for (int i3 = 0; i3 < size; i3++) {
            r rVar = z2.get(i3);
            if (rVar.f2834b == 0) {
                z2 = z2;
                size = size;
                arrayList = arrayList;
            } else {
                o oVar = rVar.a;
                arrayList = arrayList;
                long j2 = oVar.f2823e;
                if (j2 == -9223372036854775807L) {
                    j2 = rVar.h;
                }
                long max = Math.max(j, j2);
                z2 = z2;
                size = size;
                a aVar2 = new a(oVar, rVar, lVar.t(i3, oVar.f2820b));
                Format.b a2 = oVar.f2824f.a();
                a2.W(rVar.f2837e + 30);
                if (oVar.f2820b == 2 && j2 > 0 && (i = rVar.f2834b) > 1) {
                    a2.P(i / (((float) j2) / 1000000.0f));
                }
                j.k(oVar.f2820b, uVar, a2);
                int i4 = oVar.f2820b;
                Metadata[] metadataArr = new Metadata[2];
                metadataArr[0] = metadata2;
                metadataArr[1] = this.i.isEmpty() ? null : new Metadata(this.i);
                j.l(i4, metadata, m, a2, metadataArr);
                aVar2.f2810c.d(a2.E());
                if (oVar.f2820b == 2 && i2 == -1) {
                    i2 = arrayList.size();
                    arrayList.add(aVar2);
                    j = max;
                }
                i2 = i2;
                arrayList.add(aVar2);
                j = max;
            }
        }
        this.v = i2;
        this.w = j;
        a[] aVarArr = (a[]) arrayList.toArray(new a[0]);
        this.t = aVarArr;
        this.u = k(aVarArr);
        lVar.r();
        lVar.o(this);
    }

    private void w(long j) {
        if (this.k == 1836086884) {
            int i = this.m;
            this.y = new MotionPhotoMetadata(0L, j, -9223372036854775807L, j + i, this.l - i);
        }
    }

    private boolean x(com.google.android.exoplayer2.o2.k kVar) throws IOException {
        e.a peek;
        if (this.m == 0) {
            if (!kVar.f(this.f2808f.d(), 0, 8, true)) {
                t();
                return false;
            }
            this.m = 8;
            this.f2808f.P(0);
            this.l = this.f2808f.F();
            this.k = this.f2808f.n();
        }
        long j = this.l;
        if (j == 1) {
            kVar.readFully(this.f2808f.d(), 8, 8);
            this.m += 8;
            this.l = this.f2808f.I();
        } else if (j == 0) {
            long a2 = kVar.a();
            if (a2 == -1 && (peek = this.g.peek()) != null) {
                a2 = peek.f2765b;
            }
            if (a2 != -1) {
                this.l = (a2 - kVar.getPosition()) + this.m;
            }
        }
        if (this.l >= this.m) {
            if (B(this.k)) {
                long position = kVar.getPosition();
                long j2 = this.l;
                int i = this.m;
                long j3 = (position + j2) - i;
                if (j2 != i && this.k == 1835365473) {
                    r(kVar);
                }
                this.g.push(new e.a(this.k, j3));
                if (this.l == this.m) {
                    s(j3);
                } else {
                    l();
                }
            } else if (C(this.k)) {
                g.g(this.m == 8);
                g.g(this.l <= 2147483647L);
                d0 d0Var = new d0((int) this.l);
                System.arraycopy(this.f2808f.d(), 0, d0Var.d(), 0, 8);
                this.n = d0Var;
                this.j = 1;
            } else {
                w(kVar.getPosition() - this.m);
                this.n = null;
                this.j = 1;
            }
            return true;
        }
        throw ParserException.createForUnsupportedContainerFeature("Atom size less than header length (unsupported).");
    }

    private boolean y(com.google.android.exoplayer2.o2.k kVar, x xVar) throws IOException {
        boolean z;
        long j = this.l - this.m;
        long position = kVar.getPosition() + j;
        d0 d0Var = this.n;
        if (d0Var != null) {
            kVar.readFully(d0Var.d(), this.m, (int) j);
            if (this.k == 1718909296) {
                this.x = u(d0Var);
            } else if (!this.g.isEmpty()) {
                this.g.peek().e(new e.b(this.k, d0Var));
            }
        } else if (j < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            kVar.l((int) j);
        } else {
            xVar.a = kVar.getPosition() + j;
            z = true;
            s(position);
            return !z && this.j != 2;
        }
        z = false;
        s(position);
        if (!z) {
        }
    }

    private int z(com.google.android.exoplayer2.o2.k kVar, x xVar) throws IOException {
        long position = kVar.getPosition();
        if (this.o == -1) {
            int n = n(position);
            this.o = n;
            if (n == -1) {
                return -1;
            }
        }
        a aVar = ((a[]) o0.i(this.t))[this.o];
        b0 b0Var = aVar.f2810c;
        int i = aVar.f2811d;
        r rVar = aVar.f2809b;
        long j = rVar.f2835c[i];
        int i2 = rVar.f2836d[i];
        long j2 = (j - position) + this.p;
        if (j2 < 0 || j2 >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            xVar.a = j;
            return 1;
        }
        if (aVar.a.g == 1) {
            j2 += 8;
            i2 -= 8;
        }
        kVar.l((int) j2);
        o oVar = aVar.a;
        if (oVar.j == 0) {
            if ("audio/ac4".equals(oVar.f2824f.H3)) {
                if (this.q == 0) {
                    com.google.android.exoplayer2.audio.o.a(i2, this.f2807e);
                    b0Var.c(this.f2807e, 7);
                    this.q += 7;
                }
                i2 += 7;
            }
            while (true) {
                int i3 = this.q;
                if (i3 >= i2) {
                    break;
                }
                int b2 = b0Var.b(kVar, i2 - i3, false);
                this.p += b2;
                this.q += b2;
                this.r -= b2;
            }
        } else {
            byte[] d2 = this.f2806d.d();
            d2[0] = 0;
            d2[1] = 0;
            d2[2] = 0;
            int i4 = aVar.a.j;
            int i5 = 4 - i4;
            while (this.q < i2) {
                int i6 = this.r;
                if (i6 == 0) {
                    kVar.readFully(d2, i5, i4);
                    this.p += i4;
                    this.f2806d.P(0);
                    int n2 = this.f2806d.n();
                    if (n2 >= 0) {
                        this.r = n2;
                        this.f2805c.P(0);
                        b0Var.c(this.f2805c, 4);
                        this.q += 4;
                        i2 += i5;
                    } else {
                        throw ParserException.createForMalformedContainer("Invalid NAL length", null);
                    }
                } else {
                    int b3 = b0Var.b(kVar, i6, false);
                    this.p += b3;
                    this.q += b3;
                    this.r -= b3;
                }
            }
        }
        r rVar2 = aVar.f2809b;
        b0Var.e(rVar2.f2838f[i], rVar2.g[i], i2, 0, null);
        aVar.f2811d++;
        this.o = -1;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        return 0;
    }

    @Override // com.google.android.exoplayer2.o2.y
    public y.a a(long j) {
        long j2;
        long j3;
        long j4;
        int b2;
        if (((a[]) g.e(this.t)).length == 0) {
            return new y.a(z.a);
        }
        int i = this.v;
        if (i != -1) {
            r rVar = this.t[i].f2809b;
            int m = m(rVar, j);
            if (m == -1) {
                return new y.a(z.a);
            }
            long j5 = rVar.f2838f[m];
            j2 = rVar.f2835c[m];
            if (j5 >= j || m >= rVar.f2834b - 1 || (b2 = rVar.b(j)) == -1 || b2 == m) {
                j3 = -1;
                j4 = -9223372036854775807L;
            } else {
                j4 = rVar.f2838f[b2];
                j3 = rVar.f2835c[b2];
            }
            j = j5;
        } else {
            j2 = Long.MAX_VALUE;
            j3 = -1;
            j4 = -9223372036854775807L;
        }
        int i2 = 0;
        while (true) {
            a[] aVarArr = this.t;
            if (i2 >= aVarArr.length) {
                break;
            }
            if (i2 != this.v) {
                r rVar2 = aVarArr[i2].f2809b;
                long q = q(rVar2, j, j2);
                if (j4 != -9223372036854775807L) {
                    j3 = q(rVar2, j4, j3);
                }
                j2 = q;
            }
            i2++;
        }
        z zVar = new z(j, j2);
        if (j4 == -9223372036854775807L) {
            return new y.a(zVar);
        }
        return new y.a(zVar, new z(j4, j3));
    }

    @Override // com.google.android.exoplayer2.o2.j
    public void b(l lVar) {
        this.s = lVar;
    }

    @Override // com.google.android.exoplayer2.o2.j
    public void c(long j, long j2) {
        this.g.clear();
        this.m = 0;
        this.o = -1;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        if (j == 0) {
            if (this.j != 3) {
                l();
                return;
            }
            this.h.g();
            this.i.clear();
        } else if (this.t != null) {
            D(j2);
        }
    }

    @Override // com.google.android.exoplayer2.o2.j
    public boolean d(com.google.android.exoplayer2.o2.k kVar) throws IOException {
        return n.d(kVar, (this.f2804b & 2) != 0);
    }

    @Override // com.google.android.exoplayer2.o2.j
    public int e(com.google.android.exoplayer2.o2.k kVar, x xVar) throws IOException {
        while (true) {
            int i = this.j;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        return z(kVar, xVar);
                    }
                    if (i == 3) {
                        return A(kVar, xVar);
                    }
                    throw new IllegalStateException();
                } else if (y(kVar, xVar)) {
                    return 1;
                }
            } else if (!x(kVar)) {
                return -1;
            }
        }
    }

    @Override // com.google.android.exoplayer2.o2.y
    public boolean g() {
        return true;
    }

    @Override // com.google.android.exoplayer2.o2.y
    public long i() {
        return this.w;
    }

    @Override // com.google.android.exoplayer2.o2.j
    public void release() {
    }

    public k(int i) {
        this.f2804b = i;
        this.j = (i & 4) != 0 ? 3 : 0;
        this.h = new m();
        this.i = new ArrayList();
        this.f2808f = new d0(16);
        this.g = new ArrayDeque<>();
        this.f2805c = new d0(com.google.android.exoplayer2.util.z.a);
        this.f2806d = new d0(4);
        this.f2807e = new d0();
        this.o = -1;
    }
}
