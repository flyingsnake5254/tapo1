package e.a.b.a.a0.c;

import e.a.b.a.d;
import e.a.b.a.e;
import e.a.b.a.h;
import e.a.b.c.f;
import e.a.b.c.m;

/* loaded from: classes4.dex */
public class z extends h.c {
    public z(d dVar, e eVar, e eVar2) {
        this(dVar, eVar, eVar2, false);
    }

    public z(d dVar, e eVar, e eVar2, boolean z) {
        super(dVar, eVar, eVar2);
        if ((eVar == null) == (eVar2 != null ? false : true)) {
            this.f15462f = z;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(d dVar, e eVar, e eVar2, e[] eVarArr, boolean z) {
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
        y yVar = (y) this.f15460d;
        if (yVar.i()) {
            return i.u();
        }
        y yVar2 = (y) this.f15459c;
        y yVar3 = (y) this.f15461e[0];
        int[] e2 = f.e();
        x.i(yVar.i, e2);
        int[] e3 = f.e();
        x.i(e2, e3);
        int[] e4 = f.e();
        x.i(yVar2.i, e4);
        x.h(f.b(e4, e4, e4), e4);
        x.d(e2, yVar2.i, e2);
        x.h(m.G(7, e2, 2, 0), e2);
        int[] e5 = f.e();
        x.h(m.H(7, e3, 3, 0, e5), e5);
        y yVar4 = new y(e3);
        x.i(e4, yVar4.i);
        int[] iArr = yVar4.i;
        x.k(iArr, e2, iArr);
        int[] iArr2 = yVar4.i;
        x.k(iArr2, e2, iArr2);
        y yVar5 = new y(e2);
        x.k(e2, yVar4.i, yVar5.i);
        int[] iArr3 = yVar5.i;
        x.d(iArr3, e4, iArr3);
        int[] iArr4 = yVar5.i;
        x.k(iArr4, e5, iArr4);
        y yVar6 = new y(e4);
        x.l(yVar.i, yVar6.i);
        if (!yVar3.h()) {
            int[] iArr5 = yVar6.i;
            x.d(iArr5, yVar3.i, iArr5);
        }
        return new z(i, yVar4, yVar5, new e[]{yVar6}, this.f15462f);
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
        y yVar = (y) this.f15459c;
        y yVar2 = (y) this.f15460d;
        y yVar3 = (y) hVar.q();
        y yVar4 = (y) hVar.r();
        y yVar5 = (y) this.f15461e[0];
        y yVar6 = (y) hVar.s(0);
        int[] f2 = f.f();
        int[] e2 = f.e();
        int[] e3 = f.e();
        int[] e4 = f.e();
        boolean h = yVar5.h();
        if (h) {
            iArr2 = yVar3.i;
            iArr = yVar4.i;
        } else {
            x.i(yVar5.i, e3);
            x.d(e3, yVar3.i, e2);
            x.d(e3, yVar5.i, e3);
            x.d(e3, yVar4.i, e3);
            iArr2 = e2;
            iArr = e3;
        }
        boolean h2 = yVar6.h();
        if (h2) {
            iArr4 = yVar.i;
            iArr3 = yVar2.i;
        } else {
            x.i(yVar6.i, e4);
            x.d(e4, yVar.i, f2);
            x.d(e4, yVar6.i, e4);
            x.d(e4, yVar2.i, e4);
            iArr4 = f2;
            iArr3 = e4;
        }
        int[] e5 = f.e();
        x.k(iArr4, iArr2, e5);
        x.k(iArr3, iArr, e2);
        if (f.l(e5)) {
            return f.l(e2) ? J() : i.u();
        }
        x.i(e5, e3);
        int[] e6 = f.e();
        x.d(e3, e5, e6);
        x.d(e3, iArr4, e3);
        x.f(e6, e6);
        f.m(iArr3, e6, f2);
        x.h(f.b(e3, e3, e6), e6);
        y yVar7 = new y(e4);
        x.i(e2, yVar7.i);
        int[] iArr5 = yVar7.i;
        x.k(iArr5, e6, iArr5);
        y yVar8 = new y(e6);
        x.k(e3, yVar7.i, yVar8.i);
        x.e(yVar8.i, e2, f2);
        x.g(f2, yVar8.i);
        y yVar9 = new y(e5);
        if (!h) {
            int[] iArr6 = yVar9.i;
            x.d(iArr6, yVar5.i, iArr6);
        }
        if (!h2) {
            int[] iArr7 = yVar9.i;
            x.d(iArr7, yVar6.i, iArr7);
        }
        return new z(i, yVar7, yVar8, new e[]{yVar9}, this.f15462f);
    }

    @Override // e.a.b.a.h
    protected h d() {
        return new z(null, f(), g());
    }

    @Override // e.a.b.a.h
    public h z() {
        return u() ? this : new z(this.f15458b, this.f15459c, this.f15460d.m(), this.f15461e, this.f15462f);
    }
}
