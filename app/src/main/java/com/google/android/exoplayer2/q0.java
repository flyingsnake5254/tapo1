package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.j2;
import com.google.android.exoplayer2.source.p0;
import com.google.android.exoplayer2.util.g;

/* compiled from: AbstractConcatenatedTimeline.java */
/* loaded from: classes.dex */
public abstract class q0 extends j2 {

    /* renamed from: c  reason: collision with root package name */
    private final int f3108c;

    /* renamed from: d  reason: collision with root package name */
    private final p0 f3109d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f3110e;

    public q0(boolean z, p0 p0Var) {
        this.f3110e = z;
        this.f3109d = p0Var;
        this.f3108c = p0Var.a();
    }

    private int B(int i, boolean z) {
        if (z) {
            return this.f3109d.d(i);
        }
        if (i < this.f3108c - 1) {
            return i + 1;
        }
        return -1;
    }

    private int C(int i, boolean z) {
        if (z) {
            return this.f3109d.c(i);
        }
        if (i > 0) {
            return i - 1;
        }
        return -1;
    }

    public static Object v(Object obj) {
        return ((Pair) obj).second;
    }

    public static Object w(Object obj) {
        return ((Pair) obj).first;
    }

    public static Object y(Object obj, Object obj2) {
        return Pair.create(obj, obj2);
    }

    protected abstract int A(int i);

    protected abstract j2 D(int i);

    @Override // com.google.android.exoplayer2.j2
    public int a(boolean z) {
        if (this.f3108c == 0) {
            return -1;
        }
        int i = 0;
        if (this.f3110e) {
            z = false;
        }
        if (z) {
            i = this.f3109d.g();
        }
        while (D(i).q()) {
            i = B(i, z);
            if (i == -1) {
                return -1;
            }
        }
        return A(i) + D(i).a(z);
    }

    @Override // com.google.android.exoplayer2.j2
    public final int b(Object obj) {
        int b2;
        if (!(obj instanceof Pair)) {
            return -1;
        }
        Object w = w(obj);
        Object v = v(obj);
        int s = s(w);
        if (s == -1 || (b2 = D(s).b(v)) == -1) {
            return -1;
        }
        return z(s) + b2;
    }

    @Override // com.google.android.exoplayer2.j2
    public int c(boolean z) {
        int i = this.f3108c;
        if (i == 0) {
            return -1;
        }
        if (this.f3110e) {
            z = false;
        }
        int e2 = z ? this.f3109d.e() : i - 1;
        while (D(e2).q()) {
            e2 = C(e2, z);
            if (e2 == -1) {
                return -1;
            }
        }
        return A(e2) + D(e2).c(z);
    }

    @Override // com.google.android.exoplayer2.j2
    public int e(int i, int i2, boolean z) {
        int i3 = 0;
        if (this.f3110e) {
            if (i2 == 1) {
                i2 = 2;
            }
            z = false;
        }
        int u = u(i);
        int A = A(u);
        j2 D = D(u);
        int i4 = i - A;
        if (i2 != 2) {
            i3 = i2;
        }
        int e2 = D.e(i4, i3, z);
        if (e2 != -1) {
            return A + e2;
        }
        int B = B(u, z);
        while (B != -1 && D(B).q()) {
            B = B(B, z);
        }
        if (B != -1) {
            return A(B) + D(B).a(z);
        }
        if (i2 == 2) {
            return a(z);
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.j2
    public final j2.b g(int i, j2.b bVar, boolean z) {
        int t = t(i);
        int A = A(t);
        D(t).g(i - z(t), bVar, z);
        bVar.f2330d += A;
        if (z) {
            bVar.f2329c = y(x(t), g.e(bVar.f2329c));
        }
        return bVar;
    }

    @Override // com.google.android.exoplayer2.j2
    public final j2.b h(Object obj, j2.b bVar) {
        Object w = w(obj);
        Object v = v(obj);
        int s = s(w);
        int A = A(s);
        D(s).h(v, bVar);
        bVar.f2330d += A;
        bVar.f2329c = obj;
        return bVar;
    }

    @Override // com.google.android.exoplayer2.j2
    public int l(int i, int i2, boolean z) {
        int i3 = 0;
        if (this.f3110e) {
            if (i2 == 1) {
                i2 = 2;
            }
            z = false;
        }
        int u = u(i);
        int A = A(u);
        j2 D = D(u);
        int i4 = i - A;
        if (i2 != 2) {
            i3 = i2;
        }
        int l = D.l(i4, i3, z);
        if (l != -1) {
            return A + l;
        }
        int C = C(u, z);
        while (C != -1 && D(C).q()) {
            C = C(C, z);
        }
        if (C != -1) {
            return A(C) + D(C).c(z);
        }
        if (i2 == 2) {
            return c(z);
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.j2
    public final Object m(int i) {
        int t = t(i);
        return y(x(t), D(t).m(i - z(t)));
    }

    @Override // com.google.android.exoplayer2.j2
    public final j2.c o(int i, j2.c cVar, long j) {
        int u = u(i);
        int A = A(u);
        int z = z(u);
        D(u).o(i - A, cVar, j);
        Object x = x(u);
        if (!j2.c.a.equals(cVar.f2336e)) {
            x = y(x, cVar.f2336e);
        }
        cVar.f2336e = x;
        cVar.s += z;
        cVar.t += z;
        return cVar;
    }

    protected abstract int s(Object obj);

    protected abstract int t(int i);

    protected abstract int u(int i);

    protected abstract Object x(int i);

    protected abstract int z(int i);
}
