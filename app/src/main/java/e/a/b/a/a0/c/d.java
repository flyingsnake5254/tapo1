package e.a.b.a.a0.c;

import e.a.b.a.e;
import e.a.b.a.h;
import e.a.b.c.c;
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
        int[] e2 = c.e();
        int[] e3 = c.e();
        int[] e4 = c.e();
        b.j(cVar.h, e4);
        int[] e5 = c.e();
        b.j(e4, e5);
        boolean h = cVar3.h();
        int[] iArr = cVar3.h;
        if (!h) {
            b.j(iArr, e3);
            iArr = e3;
        }
        b.m(cVar2.h, iArr, e2);
        b.a(cVar2.h, iArr, e3);
        b.e(e3, e2, e3);
        b.i(c.b(e3, e3, e3), e3);
        b.e(e4, cVar2.h, e4);
        b.i(m.G(4, e4, 2, 0), e4);
        b.i(m.H(4, e5, 3, 0, e2), e2);
        c cVar4 = new c(e5);
        b.j(e3, cVar4.h);
        int[] iArr2 = cVar4.h;
        b.m(iArr2, e4, iArr2);
        int[] iArr3 = cVar4.h;
        b.m(iArr3, e4, iArr3);
        c cVar5 = new c(e4);
        b.m(e4, cVar4.h, cVar5.h);
        int[] iArr4 = cVar5.h;
        b.e(iArr4, e3, iArr4);
        int[] iArr5 = cVar5.h;
        b.m(iArr5, e2, iArr5);
        c cVar6 = new c(e3);
        b.n(cVar.h, cVar6.h);
        if (!h) {
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
        int[] g = c.g();
        int[] e2 = c.e();
        int[] e3 = c.e();
        int[] e4 = c.e();
        boolean h = cVar5.h();
        if (h) {
            iArr2 = cVar3.h;
            iArr = cVar4.h;
        } else {
            b.j(cVar5.h, e3);
            b.e(e3, cVar3.h, e2);
            b.e(e3, cVar5.h, e3);
            b.e(e3, cVar4.h, e3);
            iArr2 = e2;
            iArr = e3;
        }
        boolean h2 = cVar6.h();
        if (h2) {
            iArr4 = cVar.h;
            iArr3 = cVar2.h;
        } else {
            b.j(cVar6.h, e4);
            b.e(e4, cVar.h, g);
            b.e(e4, cVar6.h, e4);
            b.e(e4, cVar2.h, e4);
            iArr4 = g;
            iArr3 = e4;
        }
        int[] e5 = c.e();
        b.m(iArr4, iArr2, e5);
        b.m(iArr3, iArr, e2);
        if (c.q(e5)) {
            return c.q(e2) ? J() : i.u();
        }
        b.j(e5, e3);
        int[] e6 = c.e();
        b.e(e3, e5, e6);
        b.e(e3, iArr4, e3);
        b.g(e6, e6);
        c.s(iArr3, e6, g);
        b.i(c.b(e3, e3, e6), e6);
        c cVar7 = new c(e4);
        b.j(e2, cVar7.h);
        int[] iArr5 = cVar7.h;
        b.m(iArr5, e6, iArr5);
        c cVar8 = new c(e6);
        b.m(e3, cVar7.h, cVar8.h);
        b.f(cVar8.h, e2, g);
        b.h(g, cVar8.h);
        c cVar9 = new c(e5);
        if (!h) {
            int[] iArr6 = cVar9.h;
            b.e(iArr6, cVar5.h, iArr6);
        }
        if (!h2) {
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
