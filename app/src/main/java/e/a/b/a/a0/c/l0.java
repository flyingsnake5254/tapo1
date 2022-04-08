package e.a.b.a.a0.c;

import e.a.b.a.d;
import e.a.b.a.e;
import e.a.b.a.h;
import e.a.b.c.g;
import e.a.b.c.m;

/* loaded from: classes4.dex */
public class l0 extends h.c {
    public l0(d dVar, e eVar, e eVar2) {
        this(dVar, eVar, eVar2, false);
    }

    public l0(d dVar, e eVar, e eVar2, boolean z) {
        super(dVar, eVar, eVar2);
        if ((eVar == null) == (eVar2 != null ? false : true)) {
            this.f15462f = z;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l0(d dVar, e eVar, e eVar2, e[] eVarArr, boolean z) {
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
        k0 k0Var = (k0) this.f15460d;
        if (k0Var.i()) {
            return i.u();
        }
        k0 k0Var2 = (k0) this.f15459c;
        k0 k0Var3 = (k0) this.f15461e[0];
        int[] h = g.h();
        int[] h2 = g.h();
        int[] h3 = g.h();
        j0.j(k0Var.h, h3);
        int[] h4 = g.h();
        j0.j(h3, h4);
        boolean h5 = k0Var3.h();
        int[] iArr = k0Var3.h;
        if (!h5) {
            j0.j(iArr, h2);
            iArr = h2;
        }
        j0.m(k0Var2.h, iArr, h);
        j0.a(k0Var2.h, iArr, h2);
        j0.e(h2, h, h2);
        j0.i(g.b(h2, h2, h2), h2);
        j0.e(h3, k0Var2.h, h3);
        j0.i(m.G(8, h3, 2, 0), h3);
        j0.i(m.H(8, h4, 3, 0, h), h);
        k0 k0Var4 = new k0(h4);
        j0.j(h2, k0Var4.h);
        int[] iArr2 = k0Var4.h;
        j0.m(iArr2, h3, iArr2);
        int[] iArr3 = k0Var4.h;
        j0.m(iArr3, h3, iArr3);
        k0 k0Var5 = new k0(h3);
        j0.m(h3, k0Var4.h, k0Var5.h);
        int[] iArr4 = k0Var5.h;
        j0.e(iArr4, h2, iArr4);
        int[] iArr5 = k0Var5.h;
        j0.m(iArr5, h, iArr5);
        k0 k0Var6 = new k0(h2);
        j0.n(k0Var.h, k0Var6.h);
        if (!h5) {
            int[] iArr6 = k0Var6.h;
            j0.e(iArr6, k0Var3.h, iArr6);
        }
        return new l0(i, k0Var4, k0Var5, new e[]{k0Var6}, this.f15462f);
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
        k0 k0Var = (k0) this.f15459c;
        k0 k0Var2 = (k0) this.f15460d;
        k0 k0Var3 = (k0) hVar.q();
        k0 k0Var4 = (k0) hVar.r();
        k0 k0Var5 = (k0) this.f15461e[0];
        k0 k0Var6 = (k0) hVar.s(0);
        int[] j = g.j();
        int[] h = g.h();
        int[] h2 = g.h();
        int[] h3 = g.h();
        boolean h4 = k0Var5.h();
        if (h4) {
            iArr2 = k0Var3.h;
            iArr = k0Var4.h;
        } else {
            j0.j(k0Var5.h, h2);
            j0.e(h2, k0Var3.h, h);
            j0.e(h2, k0Var5.h, h2);
            j0.e(h2, k0Var4.h, h2);
            iArr2 = h;
            iArr = h2;
        }
        boolean h5 = k0Var6.h();
        if (h5) {
            iArr4 = k0Var.h;
            iArr3 = k0Var2.h;
        } else {
            j0.j(k0Var6.h, h3);
            j0.e(h3, k0Var.h, j);
            j0.e(h3, k0Var6.h, h3);
            j0.e(h3, k0Var2.h, h3);
            iArr4 = j;
            iArr3 = h3;
        }
        int[] h6 = g.h();
        j0.m(iArr4, iArr2, h6);
        j0.m(iArr3, iArr, h);
        if (g.v(h6)) {
            return g.v(h) ? J() : i.u();
        }
        j0.j(h6, h2);
        int[] h7 = g.h();
        j0.e(h2, h6, h7);
        j0.e(h2, iArr4, h2);
        j0.g(h7, h7);
        g.y(iArr3, h7, j);
        j0.i(g.b(h2, h2, h7), h7);
        k0 k0Var7 = new k0(h3);
        j0.j(h, k0Var7.h);
        int[] iArr5 = k0Var7.h;
        j0.m(iArr5, h7, iArr5);
        k0 k0Var8 = new k0(h7);
        j0.m(h2, k0Var7.h, k0Var8.h);
        j0.f(k0Var8.h, h, j);
        j0.h(j, k0Var8.h);
        k0 k0Var9 = new k0(h6);
        if (!h4) {
            int[] iArr6 = k0Var9.h;
            j0.e(iArr6, k0Var5.h, iArr6);
        }
        if (!h5) {
            int[] iArr7 = k0Var9.h;
            j0.e(iArr7, k0Var6.h, iArr7);
        }
        return new l0(i, k0Var7, k0Var8, new e[]{k0Var9}, this.f15462f);
    }

    @Override // e.a.b.a.h
    protected h d() {
        return new l0(null, f(), g());
    }

    @Override // e.a.b.a.h
    public h z() {
        return u() ? this : new l0(this.f15458b, this.f15459c, this.f15460d.m(), this.f15461e, this.f15462f);
    }
}
