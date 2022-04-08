package e.a.b.a.a0.c;

import e.a.b.a.d;
import e.a.b.a.e;
import e.a.b.a.h;
import e.a.b.c.g;
import e.a.b.c.m;

/* loaded from: classes4.dex */
public class h0 extends h.c {
    public h0(d dVar, e eVar, e eVar2) {
        this(dVar, eVar, eVar2, false);
    }

    public h0(d dVar, e eVar, e eVar2, boolean z) {
        super(dVar, eVar, eVar2);
        if ((eVar == null) == (eVar2 != null ? false : true)) {
            this.f15462f = z;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h0(d dVar, e eVar, e eVar2, e[] eVarArr, boolean z) {
        super(dVar, eVar, eVar2, eVarArr);
        this.f15462f = z;
    }

    @Override // e.a.b.a.h
    public h H() {
        return (u() || this.f15460d.i()) ? this : J().a(this);
    }

    @Override // e.a.b.a.h
    public h J() {
        if (u()) {
            return this;
        }
        d i = i();
        g0 g0Var = (g0) this.f15460d;
        if (g0Var.i()) {
            return i.u();
        }
        g0 g0Var2 = (g0) this.f15459c;
        g0 g0Var3 = (g0) this.f15461e[0];
        int[] h = g.h();
        f0.i(g0Var.h, h);
        int[] h2 = g.h();
        f0.i(h, h2);
        int[] h3 = g.h();
        f0.i(g0Var2.h, h3);
        f0.h(g.b(h3, h3, h3), h3);
        f0.d(h, g0Var2.h, h);
        f0.h(m.G(8, h, 2, 0), h);
        int[] h4 = g.h();
        f0.h(m.H(8, h2, 3, 0, h4), h4);
        g0 g0Var4 = new g0(h2);
        f0.i(h3, g0Var4.h);
        int[] iArr = g0Var4.h;
        f0.k(iArr, h, iArr);
        int[] iArr2 = g0Var4.h;
        f0.k(iArr2, h, iArr2);
        g0 g0Var5 = new g0(h);
        f0.k(h, g0Var4.h, g0Var5.h);
        int[] iArr3 = g0Var5.h;
        f0.d(iArr3, h3, iArr3);
        int[] iArr4 = g0Var5.h;
        f0.k(iArr4, h4, iArr4);
        g0 g0Var6 = new g0(h3);
        f0.l(g0Var.h, g0Var6.h);
        if (!g0Var3.h()) {
            int[] iArr5 = g0Var6.h;
            f0.d(iArr5, g0Var3.h, iArr5);
        }
        return new h0(i, g0Var4, g0Var5, new e[]{g0Var6}, this.f15462f);
    }

    @Override // e.a.b.a.h
    public h K(h hVar) {
        return this == hVar ? H() : u() ? hVar : hVar.u() ? J() : this.f15460d.i() ? hVar : J().a(hVar);
    }

    @Override // e.a.b.a.h
    public h a(h hVar) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        if (u()) {
            return hVar;
        }
        if (hVar.u()) {
            return this;
        }
        if (this == hVar) {
            return J();
        }
        d i = i();
        g0 g0Var = (g0) this.f15459c;
        g0 g0Var2 = (g0) this.f15460d;
        g0 g0Var3 = (g0) hVar.q();
        g0 g0Var4 = (g0) hVar.r();
        g0 g0Var5 = (g0) this.f15461e[0];
        g0 g0Var6 = (g0) hVar.s(0);
        int[] j = g.j();
        int[] h = g.h();
        int[] h2 = g.h();
        int[] h3 = g.h();
        boolean h4 = g0Var5.h();
        if (h4) {
            iArr2 = g0Var3.h;
            iArr = g0Var4.h;
        } else {
            f0.i(g0Var5.h, h2);
            f0.d(h2, g0Var3.h, h);
            f0.d(h2, g0Var5.h, h2);
            f0.d(h2, g0Var4.h, h2);
            iArr2 = h;
            iArr = h2;
        }
        boolean h5 = g0Var6.h();
        if (h5) {
            iArr4 = g0Var.h;
            iArr3 = g0Var2.h;
        } else {
            f0.i(g0Var6.h, h3);
            f0.d(h3, g0Var.h, j);
            f0.d(h3, g0Var6.h, h3);
            f0.d(h3, g0Var2.h, h3);
            iArr4 = j;
            iArr3 = h3;
        }
        int[] h6 = g.h();
        f0.k(iArr4, iArr2, h6);
        f0.k(iArr3, iArr, h);
        if (g.v(h6)) {
            return g.v(h) ? J() : i.u();
        }
        f0.i(h6, h2);
        int[] h7 = g.h();
        f0.d(h2, h6, h7);
        f0.d(h2, iArr4, h2);
        f0.f(h7, h7);
        g.y(iArr3, h7, j);
        f0.h(g.b(h2, h2, h7), h7);
        g0 g0Var7 = new g0(h3);
        f0.i(h, g0Var7.h);
        int[] iArr5 = g0Var7.h;
        f0.k(iArr5, h7, iArr5);
        g0 g0Var8 = new g0(h7);
        f0.k(h2, g0Var7.h, g0Var8.h);
        f0.e(g0Var8.h, h, j);
        f0.g(j, g0Var8.h);
        g0 g0Var9 = new g0(h6);
        if (!h4) {
            int[] iArr6 = g0Var9.h;
            f0.d(iArr6, g0Var5.h, iArr6);
        }
        if (!h5) {
            int[] iArr7 = g0Var9.h;
            f0.d(iArr7, g0Var6.h, iArr7);
        }
        return new h0(i, g0Var7, g0Var8, new e[]{g0Var9}, this.f15462f);
    }

    @Override // e.a.b.a.h
    protected h d() {
        return new h0(null, f(), g());
    }

    @Override // e.a.b.a.h
    public h z() {
        return u() ? this : new h0(this.f15458b, this.f15459c, this.f15460d.m(), this.f15461e, this.f15462f);
    }
}
