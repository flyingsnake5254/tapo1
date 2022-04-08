package e.a.b.a.a0.c;

import e.a.b.a.c;
import e.a.b.a.d;
import e.a.b.a.e;
import e.a.b.a.h;
import e.a.b.c.l;

/* loaded from: classes4.dex */
public class t2 extends h.b {
    public t2(d dVar, e eVar, e eVar2) {
        this(dVar, eVar, eVar2, false);
    }

    public t2(d dVar, e eVar, e eVar2, boolean z) {
        super(dVar, eVar, eVar2);
        if ((eVar == null) == (eVar2 != null ? false : true)) {
            this.f15462f = z;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public t2(d dVar, e eVar, e eVar2, e[] eVarArr, boolean z) {
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
            return new t2(i, a, i.p(), this.f15462f);
        }
        e o2 = a.o();
        e j = h ? a : a.j(o);
        e o3 = eVar2.a(eVar).o();
        if (!h) {
            eVar3 = o.o();
        }
        return new t2(i, o2, o3.a(a).a(o).j(o3).a(eVar3).a(o2).a(j), new e[]{j}, this.f15462f);
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
            return new t2(i, l, i.p(), this.f15462f);
        }
        e j2 = l.o().j(j);
        e j3 = l.j(o5).j(o4);
        return new t2(i, j2, l.a(o5).o().l(a, b2, j3), new e[]{j3}, this.f15462f);
    }

    @Override // e.a.b.a.h
    public h a(h hVar) {
        long[] jArr;
        long[] jArr2;
        long[] jArr3;
        r2 r2Var;
        r2 r2Var2;
        r2 r2Var3;
        if (u()) {
            return hVar;
        }
        if (hVar.u()) {
            return this;
        }
        d i = i();
        r2 r2Var4 = (r2) this.f15459c;
        r2 r2Var5 = (r2) hVar.n();
        if (r2Var4.i()) {
            return r2Var5.i() ? i.u() : hVar.a(this);
        }
        r2 r2Var6 = (r2) this.f15460d;
        r2 r2Var7 = (r2) this.f15461e[0];
        r2 r2Var8 = (r2) hVar.o();
        r2 r2Var9 = (r2) hVar.s(0);
        long[] b2 = l.b();
        long[] b3 = l.b();
        long[] b4 = l.b();
        long[] b5 = l.b();
        long[] p = r2Var7.h() ? null : q2.p(r2Var7.g);
        if (p == null) {
            jArr = r2Var5.g;
            jArr2 = r2Var8.g;
        } else {
            q2.n(r2Var5.g, p, b3);
            q2.n(r2Var8.g, p, b5);
            jArr = b3;
            jArr2 = b5;
        }
        long[] p2 = r2Var9.h() ? null : q2.p(r2Var9.g);
        long[] jArr4 = r2Var4.g;
        if (p2 == null) {
            jArr3 = r2Var6.g;
        } else {
            q2.n(jArr4, p2, b2);
            q2.n(r2Var6.g, p2, b4);
            jArr4 = b2;
            jArr3 = b4;
        }
        q2.b(jArr3, jArr2, b4);
        q2.b(jArr4, jArr, b5);
        if (l.g(b5)) {
            return l.g(b4) ? J() : i.u();
        }
        if (r2Var5.i()) {
            h A = A();
            r2 r2Var10 = (r2) A.q();
            e r = A.r();
            e d2 = r.a(r2Var8).d(r2Var10);
            r2Var2 = (r2) d2.o().a(d2).a(r2Var10);
            if (r2Var2.i()) {
                return new t2(i, r2Var2, i.p(), this.f15462f);
            }
            r2Var = (r2) d2.j(r2Var10.a(r2Var2)).a(r2Var2).a(r).d(r2Var2).a(r2Var2);
            r2Var3 = (r2) i.n(c.f15438b);
        } else {
            q2.t(b5, b5);
            long[] p3 = q2.p(b4);
            q2.n(jArr4, p3, b2);
            q2.n(jArr, p3, b3);
            r2 r2Var11 = new r2(b2);
            q2.l(b2, b3, r2Var11.g);
            if (r2Var11.i()) {
                return new t2(i, r2Var11, i.p(), this.f15462f);
            }
            r2 r2Var12 = new r2(b4);
            q2.n(b5, p3, r2Var12.g);
            if (p2 != null) {
                long[] jArr5 = r2Var12.g;
                q2.n(jArr5, p2, jArr5);
            }
            long[] c2 = l.c();
            q2.b(b3, b5, b5);
            q2.u(b5, c2);
            q2.b(r2Var6.g, r2Var7.g, b5);
            q2.m(b5, r2Var12.g, c2);
            r2 r2Var13 = new r2(b5);
            q2.q(c2, r2Var13.g);
            if (p != null) {
                long[] jArr6 = r2Var12.g;
                q2.n(jArr6, p, jArr6);
            }
            r2Var2 = r2Var11;
            r2Var = r2Var13;
            r2Var3 = r2Var12;
        }
        return new t2(i, r2Var2, r2Var, new e[]{r2Var3}, this.f15462f);
    }

    @Override // e.a.b.a.h
    protected h d() {
        return new t2(null, f(), g());
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
        return new t2(this.f15458b, eVar, eVar2.a(eVar3), new e[]{eVar3}, this.f15462f);
    }
}
