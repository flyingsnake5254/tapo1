package e.a.b.a.a0.b;

import e.a.b.a.e;
import e.a.b.a.h;
import e.a.b.c.g;
import e.a.b.c.m;

/* loaded from: classes4.dex */
public class d extends h.c {
    public d(e.a.b.a.d dVar, e eVar, e eVar2) {
        this(dVar, eVar, eVar2, false);
    }

    public d(e.a.b.a.d dVar, e eVar, e eVar2, boolean z) {
        super(dVar, eVar, eVar2);
        if ((eVar == null) == (eVar2 != null ? false : true)) {
            this.f15462f = z;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e.a.b.a.d dVar, e eVar, e eVar2, e[] eVarArr, boolean z) {
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
        e.a.b.a.d i = i();
        c cVar = (c) this.f15460d;
        if (cVar.i()) {
            return i.u();
        }
        c cVar2 = (c) this.f15459c;
        c cVar3 = (c) this.f15461e[0];
        int[] h = g.h();
        int[] h2 = g.h();
        int[] h3 = g.h();
        b.j(cVar.h, h3);
        int[] h4 = g.h();
        b.j(h3, h4);
        boolean h5 = cVar3.h();
        int[] iArr = cVar3.h;
        if (!h5) {
            b.j(iArr, h2);
            iArr = h2;
        }
        b.m(cVar2.h, iArr, h);
        b.a(cVar2.h, iArr, h2);
        b.e(h2, h, h2);
        b.i(g.b(h2, h2, h2), h2);
        b.e(h3, cVar2.h, h3);
        b.i(m.G(8, h3, 2, 0), h3);
        b.i(m.H(8, h4, 3, 0, h), h);
        c cVar4 = new c(h4);
        b.j(h2, cVar4.h);
        int[] iArr2 = cVar4.h;
        b.m(iArr2, h3, iArr2);
        int[] iArr3 = cVar4.h;
        b.m(iArr3, h3, iArr3);
        c cVar5 = new c(h3);
        b.m(h3, cVar4.h, cVar5.h);
        int[] iArr4 = cVar5.h;
        b.e(iArr4, h2, iArr4);
        int[] iArr5 = cVar5.h;
        b.m(iArr5, h, iArr5);
        c cVar6 = new c(h2);
        b.n(cVar.h, cVar6.h);
        if (!h5) {
            int[] iArr6 = cVar6.h;
            b.e(iArr6, cVar3.h, iArr6);
        }
        return new d(i, cVar4, cVar5, new e[]{cVar6}, this.f15462f);
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
        e.a.b.a.d i = i();
        c cVar = (c) this.f15459c;
        c cVar2 = (c) this.f15460d;
        c cVar3 = (c) hVar.q();
        c cVar4 = (c) hVar.r();
        c cVar5 = (c) this.f15461e[0];
        c cVar6 = (c) hVar.s(0);
        int[] j = g.j();
        int[] h = g.h();
        int[] h2 = g.h();
        int[] h3 = g.h();
        boolean h4 = cVar5.h();
        if (h4) {
            iArr2 = cVar3.h;
            iArr = cVar4.h;
        } else {
            b.j(cVar5.h, h2);
            b.e(h2, cVar3.h, h);
            b.e(h2, cVar5.h, h2);
            b.e(h2, cVar4.h, h2);
            iArr2 = h;
            iArr = h2;
        }
        boolean h5 = cVar6.h();
        if (h5) {
            iArr4 = cVar.h;
            iArr3 = cVar2.h;
        } else {
            b.j(cVar6.h, h3);
            b.e(h3, cVar.h, j);
            b.e(h3, cVar6.h, h3);
            b.e(h3, cVar2.h, h3);
            iArr4 = j;
            iArr3 = h3;
        }
        int[] h6 = g.h();
        b.m(iArr4, iArr2, h6);
        b.m(iArr3, iArr, h);
        if (g.v(h6)) {
            return g.v(h) ? J() : i.u();
        }
        b.j(h6, h2);
        int[] h7 = g.h();
        b.e(h2, h6, h7);
        b.e(h2, iArr4, h2);
        b.g(h7, h7);
        g.y(iArr3, h7, j);
        b.i(g.b(h2, h2, h7), h7);
        c cVar7 = new c(h3);
        b.j(h, cVar7.h);
        int[] iArr5 = cVar7.h;
        b.m(iArr5, h7, iArr5);
        c cVar8 = new c(h7);
        b.m(h2, cVar7.h, cVar8.h);
        b.f(cVar8.h, h, j);
        b.h(j, cVar8.h);
        c cVar9 = new c(h6);
        if (!h4) {
            int[] iArr6 = cVar9.h;
            b.e(iArr6, cVar5.h, iArr6);
        }
        if (!h5) {
            int[] iArr7 = cVar9.h;
            b.e(iArr7, cVar6.h, iArr7);
        }
        return new d(i, cVar7, cVar8, new e[]{cVar9}, this.f15462f);
    }

    @Override // e.a.b.a.h
    protected h d() {
        return new d(null, f(), g());
    }

    @Override // e.a.b.a.h
    public h z() {
        return u() ? this : new d(this.f15458b, this.f15459c, this.f15460d.m(), this.f15461e, this.f15462f);
    }
}
