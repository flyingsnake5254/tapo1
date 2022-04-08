package e.a.b.a.a0.c;

import e.a.b.a.d;
import e.a.b.a.e;
import e.a.b.a.h;
import e.a.b.c.m;

/* loaded from: classes4.dex */
public class f extends h.c {
    public f(d dVar, e eVar, e eVar2) {
        this(dVar, eVar, eVar2, false);
    }

    public f(d dVar, e eVar, e eVar2, boolean z) {
        super(dVar, eVar, eVar2);
        if ((eVar == null) == (eVar2 != null ? false : true)) {
            this.f15462f = z;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, e eVar, e eVar2, e[] eVarArr, boolean z) {
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
        m mVar = (m) this.f15460d;
        if (mVar.i()) {
            return i.u();
        }
        m mVar2 = (m) this.f15459c;
        m mVar3 = (m) this.f15461e[0];
        int[] d2 = e.a.b.c.d.d();
        l.i(mVar.h, d2);
        int[] d3 = e.a.b.c.d.d();
        l.i(d2, d3);
        int[] d4 = e.a.b.c.d.d();
        l.i(mVar2.h, d4);
        l.h(e.a.b.c.d.b(d4, d4, d4), d4);
        l.d(d2, mVar2.h, d2);
        l.h(m.G(5, d2, 2, 0), d2);
        int[] d5 = e.a.b.c.d.d();
        l.h(m.H(5, d3, 3, 0, d5), d5);
        m mVar4 = new m(d3);
        l.i(d4, mVar4.h);
        int[] iArr = mVar4.h;
        l.k(iArr, d2, iArr);
        int[] iArr2 = mVar4.h;
        l.k(iArr2, d2, iArr2);
        m mVar5 = new m(d2);
        l.k(d2, mVar4.h, mVar5.h);
        int[] iArr3 = mVar5.h;
        l.d(iArr3, d4, iArr3);
        int[] iArr4 = mVar5.h;
        l.k(iArr4, d5, iArr4);
        m mVar6 = new m(d4);
        l.l(mVar.h, mVar6.h);
        if (!mVar3.h()) {
            int[] iArr5 = mVar6.h;
            l.d(iArr5, mVar3.h, iArr5);
        }
        return new f(i, mVar4, mVar5, new e[]{mVar6}, this.f15462f);
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
        m mVar = (m) this.f15459c;
        m mVar2 = (m) this.f15460d;
        m mVar3 = (m) hVar.q();
        m mVar4 = (m) hVar.r();
        m mVar5 = (m) this.f15461e[0];
        m mVar6 = (m) hVar.s(0);
        int[] e2 = e.a.b.c.d.e();
        int[] d2 = e.a.b.c.d.d();
        int[] d3 = e.a.b.c.d.d();
        int[] d4 = e.a.b.c.d.d();
        boolean h = mVar5.h();
        if (h) {
            iArr2 = mVar3.h;
            iArr = mVar4.h;
        } else {
            l.i(mVar5.h, d3);
            l.d(d3, mVar3.h, d2);
            l.d(d3, mVar5.h, d3);
            l.d(d3, mVar4.h, d3);
            iArr2 = d2;
            iArr = d3;
        }
        boolean h2 = mVar6.h();
        if (h2) {
            iArr4 = mVar.h;
            iArr3 = mVar2.h;
        } else {
            l.i(mVar6.h, d4);
            l.d(d4, mVar.h, e2);
            l.d(d4, mVar6.h, d4);
            l.d(d4, mVar2.h, d4);
            iArr4 = e2;
            iArr3 = d4;
        }
        int[] d5 = e.a.b.c.d.d();
        l.k(iArr4, iArr2, d5);
        l.k(iArr3, iArr, d2);
        if (e.a.b.c.d.k(d5)) {
            return e.a.b.c.d.k(d2) ? J() : i.u();
        }
        l.i(d5, d3);
        int[] d6 = e.a.b.c.d.d();
        l.d(d3, d5, d6);
        l.d(d3, iArr4, d3);
        l.f(d6, d6);
        e.a.b.c.d.l(iArr3, d6, e2);
        l.h(e.a.b.c.d.b(d3, d3, d6), d6);
        m mVar7 = new m(d4);
        l.i(d2, mVar7.h);
        int[] iArr5 = mVar7.h;
        l.k(iArr5, d6, iArr5);
        m mVar8 = new m(d6);
        l.k(d3, mVar7.h, mVar8.h);
        l.e(mVar8.h, d2, e2);
        l.g(e2, mVar8.h);
        m mVar9 = new m(d5);
        if (!h) {
            int[] iArr6 = mVar9.h;
            l.d(iArr6, mVar5.h, iArr6);
        }
        if (!h2) {
            int[] iArr7 = mVar9.h;
            l.d(iArr7, mVar6.h, iArr7);
        }
        return new f(i, mVar7, mVar8, new e[]{mVar9}, this.f15462f);
    }

    @Override // e.a.b.a.h
    protected h d() {
        return new f(null, f(), g());
    }

    @Override // e.a.b.a.h
    public h z() {
        return u() ? this : new f(this.f15458b, this.f15459c, this.f15460d.m(), this.f15461e, this.f15462f);
    }
}
