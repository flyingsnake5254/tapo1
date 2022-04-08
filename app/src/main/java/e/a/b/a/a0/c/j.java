package e.a.b.a.a0.c;

import e.a.b.a.d;
import e.a.b.a.e;
import e.a.b.a.h;
import e.a.b.c.m;

/* loaded from: classes4.dex */
public class j extends h.c {
    public j(d dVar, e eVar, e eVar2) {
        this(dVar, eVar, eVar2, false);
    }

    public j(d dVar, e eVar, e eVar2, boolean z) {
        super(dVar, eVar, eVar2);
        if ((eVar == null) == (eVar2 != null ? false : true)) {
            this.f15462f = z;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(d dVar, e eVar, e eVar2, e[] eVarArr, boolean z) {
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
        i iVar = (i) this.f15460d;
        if (iVar.i()) {
            return i.u();
        }
        i iVar2 = (i) this.f15459c;
        i iVar3 = (i) this.f15461e[0];
        int[] d2 = e.a.b.c.d.d();
        int[] d3 = e.a.b.c.d.d();
        int[] d4 = e.a.b.c.d.d();
        h.i(iVar.h, d4);
        int[] d5 = e.a.b.c.d.d();
        h.i(d4, d5);
        boolean h = iVar3.h();
        int[] iArr = iVar3.h;
        if (!h) {
            h.i(iArr, d3);
            iArr = d3;
        }
        h.k(iVar2.h, iArr, d2);
        h.a(iVar2.h, iArr, d3);
        h.d(d3, d2, d3);
        h.h(e.a.b.c.d.b(d3, d3, d3), d3);
        h.d(d4, iVar2.h, d4);
        h.h(m.G(5, d4, 2, 0), d4);
        h.h(m.H(5, d5, 3, 0, d2), d2);
        i iVar4 = new i(d5);
        h.i(d3, iVar4.h);
        int[] iArr2 = iVar4.h;
        h.k(iArr2, d4, iArr2);
        int[] iArr3 = iVar4.h;
        h.k(iArr3, d4, iArr3);
        i iVar5 = new i(d4);
        h.k(d4, iVar4.h, iVar5.h);
        int[] iArr4 = iVar5.h;
        h.d(iArr4, d3, iArr4);
        int[] iArr5 = iVar5.h;
        h.k(iArr5, d2, iArr5);
        i iVar6 = new i(d3);
        h.l(iVar.h, iVar6.h);
        if (!h) {
            int[] iArr6 = iVar6.h;
            h.d(iArr6, iVar3.h, iArr6);
        }
        return new j(i, iVar4, iVar5, new e[]{iVar6}, this.f15462f);
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
        i iVar = (i) this.f15459c;
        i iVar2 = (i) this.f15460d;
        i iVar3 = (i) hVar.q();
        i iVar4 = (i) hVar.r();
        i iVar5 = (i) this.f15461e[0];
        i iVar6 = (i) hVar.s(0);
        int[] e2 = e.a.b.c.d.e();
        int[] d2 = e.a.b.c.d.d();
        int[] d3 = e.a.b.c.d.d();
        int[] d4 = e.a.b.c.d.d();
        boolean h = iVar5.h();
        if (h) {
            iArr2 = iVar3.h;
            iArr = iVar4.h;
        } else {
            h.i(iVar5.h, d3);
            h.d(d3, iVar3.h, d2);
            h.d(d3, iVar5.h, d3);
            h.d(d3, iVar4.h, d3);
            iArr2 = d2;
            iArr = d3;
        }
        boolean h2 = iVar6.h();
        if (h2) {
            iArr4 = iVar.h;
            iArr3 = iVar2.h;
        } else {
            h.i(iVar6.h, d4);
            h.d(d4, iVar.h, e2);
            h.d(d4, iVar6.h, d4);
            h.d(d4, iVar2.h, d4);
            iArr4 = e2;
            iArr3 = d4;
        }
        int[] d5 = e.a.b.c.d.d();
        h.k(iArr4, iArr2, d5);
        h.k(iArr3, iArr, d2);
        if (e.a.b.c.d.k(d5)) {
            return e.a.b.c.d.k(d2) ? J() : i.u();
        }
        h.i(d5, d3);
        int[] d6 = e.a.b.c.d.d();
        h.d(d3, d5, d6);
        h.d(d3, iArr4, d3);
        h.f(d6, d6);
        e.a.b.c.d.l(iArr3, d6, e2);
        h.h(e.a.b.c.d.b(d3, d3, d6), d6);
        i iVar7 = new i(d4);
        h.i(d2, iVar7.h);
        int[] iArr5 = iVar7.h;
        h.k(iArr5, d6, iArr5);
        i iVar8 = new i(d6);
        h.k(d3, iVar7.h, iVar8.h);
        h.e(iVar8.h, d2, e2);
        h.g(e2, iVar8.h);
        i iVar9 = new i(d5);
        if (!h) {
            int[] iArr6 = iVar9.h;
            h.d(iArr6, iVar5.h, iArr6);
        }
        if (!h2) {
            int[] iArr7 = iVar9.h;
            h.d(iArr7, iVar6.h, iArr7);
        }
        return new j(i, iVar7, iVar8, new e[]{iVar9}, this.f15462f);
    }

    @Override // e.a.b.a.h
    protected h d() {
        return new j(null, f(), g());
    }

    @Override // e.a.b.a.h
    public h z() {
        return u() ? this : new j(this.f15458b, this.f15459c, this.f15460d.m(), this.f15461e, this.f15462f);
    }
}
