package e.a.b.a.a0.c;

import e.a.b.a.c;
import e.a.b.a.d;
import e.a.b.a.e;
import e.a.b.a.h;

/* loaded from: classes4.dex */
public class x1 extends h.b {
    public x1(d dVar, e eVar, e eVar2) {
        this(dVar, eVar, eVar2, false);
    }

    public x1(d dVar, e eVar, e eVar2, boolean z) {
        super(dVar, eVar, eVar2);
        if ((eVar == null) == (eVar2 != null ? false : true)) {
            this.f15462f = z;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public x1(d dVar, e eVar, e eVar2, e[] eVarArr, boolean z) {
        super(dVar, eVar, eVar2, eVarArr);
        this.f15462f = z;
    }

    @Override // e.a.b.a.h
    public h J() {
        if (u()) {
            return this;
        }
        d i = i();
        e eVar = this.f15459c;
        if (eVar.i()) {
            return i.u();
        }
        e eVar2 = this.f15460d;
        e eVar3 = this.f15461e[0];
        boolean h = eVar3.h();
        e o = h ? eVar3 : eVar3.o();
        e a = h ? eVar2.o().a(eVar2) : eVar2.a(eVar3).j(eVar2);
        if (a.i()) {
            return new x1(i, a, i.p(), this.f15462f);
        }
        e o2 = a.o();
        e j = h ? a : a.j(o);
        e o3 = eVar2.a(eVar).o();
        if (!h) {
            eVar3 = o.o();
        }
        return new x1(i, o2, o3.a(a).a(o).j(o3).a(eVar3).a(o2).a(j), new e[]{j}, this.f15462f);
    }

    @Override // e.a.b.a.h
    public h K(h hVar) {
        if (u()) {
            return hVar;
        }
        if (hVar.u()) {
            return J();
        }
        d i = i();
        e eVar = this.f15459c;
        if (eVar.i()) {
            return hVar;
        }
        e n = hVar.n();
        e s = hVar.s(0);
        if (n.i() || !s.h()) {
            return J().a(hVar);
        }
        e eVar2 = this.f15460d;
        e eVar3 = this.f15461e[0];
        e o = hVar.o();
        e o2 = eVar.o();
        e o3 = eVar2.o();
        e o4 = eVar3.o();
        e a = o3.a(eVar2.j(eVar3));
        e b2 = o.b();
        e l = b2.j(o4).a(o3).l(a, o2, o4);
        e j = n.j(o4);
        e o5 = j.a(a).o();
        if (o5.i()) {
            return l.i() ? hVar.J() : i.u();
        }
        if (l.i()) {
            return new x1(i, l, i.p(), this.f15462f);
        }
        e j2 = l.o().j(j);
        e j3 = l.j(o5).j(o4);
        return new x1(i, j2, l.a(o5).o().l(a, b2, j3), new e[]{j3}, this.f15462f);
    }

    @Override // e.a.b.a.h
    public h a(h hVar) {
        e eVar;
        e eVar2;
        e eVar3;
        e eVar4;
        e eVar5;
        e eVar6;
        if (u()) {
            return hVar;
        }
        if (hVar.u()) {
            return this;
        }
        d i = i();
        e eVar7 = this.f15459c;
        e n = hVar.n();
        if (eVar7.i()) {
            return n.i() ? i.u() : hVar.a(this);
        }
        e eVar8 = this.f15460d;
        e eVar9 = this.f15461e[0];
        e o = hVar.o();
        e s = hVar.s(0);
        boolean h = eVar9.h();
        if (!h) {
            eVar2 = n.j(eVar9);
            eVar = o.j(eVar9);
        } else {
            eVar2 = n;
            eVar = o;
        }
        boolean h2 = s.h();
        if (!h2) {
            eVar7 = eVar7.j(s);
            eVar3 = eVar8.j(s);
        } else {
            eVar3 = eVar8;
        }
        e a = eVar3.a(eVar);
        e a2 = eVar7.a(eVar2);
        if (a2.i()) {
            return a.i() ? J() : i.u();
        }
        if (n.i()) {
            h A = A();
            e q = A.q();
            e r = A.r();
            e d2 = r.a(o).d(q);
            eVar5 = d2.o().a(d2).a(q);
            if (eVar5.i()) {
                return new x1(i, eVar5, i.p(), this.f15462f);
            }
            eVar4 = d2.j(q.a(eVar5)).a(eVar5).a(r).d(eVar5).a(eVar5);
            eVar6 = i.n(c.f15438b);
        } else {
            e o2 = a2.o();
            e j = a.j(eVar7);
            e j2 = a.j(eVar2);
            e j3 = j.j(j2);
            if (j3.i()) {
                return new x1(i, j3, i.p(), this.f15462f);
            }
            e j4 = a.j(o2);
            eVar6 = !h2 ? j4.j(s) : j4;
            eVar4 = j2.a(o2).p(eVar6, eVar8.a(eVar9));
            if (!h) {
                eVar6 = eVar6.j(eVar9);
            }
            eVar5 = j3;
        }
        return new x1(i, eVar5, eVar4, new e[]{eVar6}, this.f15462f);
    }

    @Override // e.a.b.a.h
    protected h d() {
        return new x1(null, f(), g());
    }

    @Override // e.a.b.a.h
    protected boolean h() {
        e n = n();
        return !n.i() && o().s() != n.s();
    }

    @Override // e.a.b.a.h
    public e r() {
        e eVar = this.f15459c;
        e eVar2 = this.f15460d;
        if (u() || eVar.i()) {
            return eVar2;
        }
        e j = eVar2.a(eVar).j(eVar);
        e eVar3 = this.f15461e[0];
        return !eVar3.h() ? j.d(eVar3) : j;
    }

    @Override // e.a.b.a.h
    public h z() {
        if (u()) {
            return this;
        }
        e eVar = this.f15459c;
        if (eVar.i()) {
            return this;
        }
        e eVar2 = this.f15460d;
        e eVar3 = this.f15461e[0];
        return new x1(this.f15458b, eVar, eVar2.a(eVar3), new e[]{eVar3}, this.f15462f);
    }
}
