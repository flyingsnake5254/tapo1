package e.a.b.a.a0.c;

import e.a.b.a.d;
import e.a.b.a.e;
import e.a.b.a.h;
import e.a.b.c.m;

/* loaded from: classes4.dex */
public class v extends h.c {
    public v(d dVar, e eVar, e eVar2) {
        this(dVar, eVar, eVar2, false);
    }

    public v(d dVar, e eVar, e eVar2, boolean z) {
        super(dVar, eVar, eVar2);
        if ((eVar == null) == (eVar2 != null ? false : true)) {
            this.f15462f = z;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(d dVar, e eVar, e eVar2, e[] eVarArr, boolean z) {
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
        u uVar = (u) this.f15460d;
        if (uVar.i()) {
            return i.u();
        }
        u uVar2 = (u) this.f15459c;
        u uVar3 = (u) this.f15461e[0];
        int[] g = e.a.b.c.e.g();
        int[] g2 = e.a.b.c.e.g();
        int[] g3 = e.a.b.c.e.g();
        t.j(uVar.h, g3);
        int[] g4 = e.a.b.c.e.g();
        t.j(g3, g4);
        boolean h = uVar3.h();
        int[] iArr = uVar3.h;
        if (!h) {
            t.j(iArr, g2);
            iArr = g2;
        }
        t.m(uVar2.h, iArr, g);
        t.a(uVar2.h, iArr, g2);
        t.e(g2, g, g2);
        t.i(e.a.b.c.e.b(g2, g2, g2), g2);
        t.e(g3, uVar2.h, g3);
        t.i(m.G(6, g3, 2, 0), g3);
        t.i(m.H(6, g4, 3, 0, g), g);
        u uVar4 = new u(g4);
        t.j(g2, uVar4.h);
        int[] iArr2 = uVar4.h;
        t.m(iArr2, g3, iArr2);
        int[] iArr3 = uVar4.h;
        t.m(iArr3, g3, iArr3);
        u uVar5 = new u(g3);
        t.m(g3, uVar4.h, uVar5.h);
        int[] iArr4 = uVar5.h;
        t.e(iArr4, g2, iArr4);
        int[] iArr5 = uVar5.h;
        t.m(iArr5, g, iArr5);
        u uVar6 = new u(g2);
        t.n(uVar.h, uVar6.h);
        if (!h) {
            int[] iArr6 = uVar6.h;
            t.e(iArr6, uVar3.h, iArr6);
        }
        return new v(i, uVar4, uVar5, new e[]{uVar6}, this.f15462f);
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
        u uVar = (u) this.f15459c;
        u uVar2 = (u) this.f15460d;
        u uVar3 = (u) hVar.q();
        u uVar4 = (u) hVar.r();
        u uVar5 = (u) this.f15461e[0];
        u uVar6 = (u) hVar.s(0);
        int[] i2 = e.a.b.c.e.i();
        int[] g = e.a.b.c.e.g();
        int[] g2 = e.a.b.c.e.g();
        int[] g3 = e.a.b.c.e.g();
        boolean h = uVar5.h();
        if (h) {
            iArr2 = uVar3.h;
            iArr = uVar4.h;
        } else {
            t.j(uVar5.h, g2);
            t.e(g2, uVar3.h, g);
            t.e(g2, uVar5.h, g2);
            t.e(g2, uVar4.h, g2);
            iArr2 = g;
            iArr = g2;
        }
        boolean h2 = uVar6.h();
        if (h2) {
            iArr4 = uVar.h;
            iArr3 = uVar2.h;
        } else {
            t.j(uVar6.h, g3);
            t.e(g3, uVar.h, i2);
            t.e(g3, uVar6.h, g3);
            t.e(g3, uVar2.h, g3);
            iArr4 = i2;
            iArr3 = g3;
        }
        int[] g4 = e.a.b.c.e.g();
        t.m(iArr4, iArr2, g4);
        t.m(iArr3, iArr, g);
        if (e.a.b.c.e.u(g4)) {
            return e.a.b.c.e.u(g) ? J() : i.u();
        }
        t.j(g4, g2);
        int[] g5 = e.a.b.c.e.g();
        t.e(g2, g4, g5);
        t.e(g2, iArr4, g2);
        t.g(g5, g5);
        e.a.b.c.e.x(iArr3, g5, i2);
        t.i(e.a.b.c.e.b(g2, g2, g5), g5);
        u uVar7 = new u(g3);
        t.j(g, uVar7.h);
        int[] iArr5 = uVar7.h;
        t.m(iArr5, g5, iArr5);
        u uVar8 = new u(g5);
        t.m(g2, uVar7.h, uVar8.h);
        t.f(uVar8.h, g, i2);
        t.h(i2, uVar8.h);
        u uVar9 = new u(g4);
        if (!h) {
            int[] iArr6 = uVar9.h;
            t.e(iArr6, uVar5.h, iArr6);
        }
        if (!h2) {
            int[] iArr7 = uVar9.h;
            t.e(iArr7, uVar6.h, iArr7);
        }
        return new v(i, uVar7, uVar8, new e[]{uVar9}, this.f15462f);
    }

    @Override // e.a.b.a.h
    protected h d() {
        return new v(null, f(), g());
    }

    @Override // e.a.b.a.h
    public h z() {
        return u() ? this : new v(this.f15458b, this.f15459c, this.f15460d.m(), this.f15461e, this.f15462f);
    }
}
