package e.a.b.a.a0.c;

import e.a.b.a.c;
import e.a.b.a.d;
import e.a.b.a.e;
import e.a.b.a.h;
import e.a.b.c.l;
import e.a.b.c.m;

/* loaded from: classes4.dex */
public class v2 extends h.b {
    public v2(d dVar, e eVar, e eVar2) {
        this(dVar, eVar, eVar2, false);
    }

    public v2(d dVar, e eVar, e eVar2, boolean z) {
        super(dVar, eVar, eVar2);
        if ((eVar == null) == (eVar2 != null ? false : true)) {
            this.f15462f = z;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public v2(d dVar, e eVar, e eVar2, e[] eVarArr, boolean z) {
        super(dVar, eVar, eVar2, eVarArr);
        this.f15462f = z;
    }

    @Override // e.a.b.a.h
    public h J() {
        long[] jArr;
        if (u()) {
            return this;
        }
        d i = i();
        r2 r2Var = (r2) this.f15459c;
        if (r2Var.i()) {
            return i.u();
        }
        r2 r2Var2 = (r2) this.f15460d;
        r2 r2Var3 = (r2) this.f15461e[0];
        long[] b2 = l.b();
        long[] b3 = l.b();
        long[] p = r2Var3.h() ? null : q2.p(r2Var3.g);
        long[] jArr2 = r2Var2.g;
        if (p == null) {
            jArr = r2Var3.g;
        } else {
            q2.n(jArr2, p, b2);
            q2.t(r2Var3.g, b3);
            jArr2 = b2;
            jArr = b3;
        }
        long[] b4 = l.b();
        q2.t(r2Var2.g, b4);
        q2.d(jArr2, jArr, b4);
        if (l.g(b4)) {
            return new v2(i, new r2(b4), u2.k, this.f15462f);
        }
        long[] c2 = l.c();
        q2.m(b4, jArr2, c2);
        r2 r2Var4 = new r2(b2);
        q2.t(b4, r2Var4.g);
        r2 r2Var5 = new r2(b4);
        if (p != null) {
            long[] jArr3 = r2Var5.g;
            q2.l(jArr3, jArr, jArr3);
        }
        long[] jArr4 = r2Var.g;
        if (p != null) {
            q2.n(jArr4, p, b3);
            jArr4 = b3;
        }
        q2.u(jArr4, c2);
        q2.q(c2, b3);
        q2.d(r2Var4.g, r2Var5.g, b3);
        return new v2(i, r2Var4, new r2(b3), new e[]{r2Var5}, this.f15462f);
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
        r2 r2Var = (r2) this.f15459c;
        if (r2Var.i()) {
            return hVar;
        }
        r2 r2Var2 = (r2) hVar.n();
        r2 r2Var3 = (r2) hVar.s(0);
        if (r2Var2.i() || !r2Var3.h()) {
            return J().a(hVar);
        }
        r2 r2Var4 = (r2) this.f15460d;
        r2 r2Var5 = (r2) this.f15461e[0];
        r2 r2Var6 = (r2) hVar.o();
        long[] b2 = l.b();
        long[] b3 = l.b();
        long[] b4 = l.b();
        long[] b5 = l.b();
        q2.t(r2Var.g, b2);
        q2.t(r2Var4.g, b3);
        q2.t(r2Var5.g, b4);
        q2.l(r2Var4.g, r2Var5.g, b5);
        q2.d(b4, b3, b5);
        long[] p = q2.p(b4);
        q2.n(r2Var6.g, p, b4);
        q2.b(b4, b3, b4);
        long[] c2 = l.c();
        q2.m(b4, b5, c2);
        q2.o(b2, p, c2);
        q2.q(c2, b4);
        q2.n(r2Var2.g, p, b2);
        q2.b(b2, b5, b3);
        q2.t(b3, b3);
        if (l.g(b3)) {
            return l.g(b4) ? hVar.J() : i.u();
        }
        if (l.g(b4)) {
            return new v2(i, new r2(b4), u2.k, this.f15462f);
        }
        r2 r2Var7 = new r2();
        q2.t(b4, r2Var7.g);
        long[] jArr = r2Var7.g;
        q2.l(jArr, b2, jArr);
        r2 r2Var8 = new r2(b2);
        q2.l(b4, b3, r2Var8.g);
        long[] jArr2 = r2Var8.g;
        q2.n(jArr2, p, jArr2);
        r2 r2Var9 = new r2(b3);
        q2.b(b4, b3, r2Var9.g);
        long[] jArr3 = r2Var9.g;
        q2.t(jArr3, jArr3);
        m.R(18, c2);
        q2.m(r2Var9.g, b5, c2);
        q2.f(r2Var6.g, b5);
        q2.m(b5, r2Var8.g, c2);
        q2.q(c2, r2Var9.g);
        return new v2(i, r2Var7, r2Var9, new e[]{r2Var8}, this.f15462f);
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
            r2Var2 = (r2) d2.o().a(d2).a(r2Var10).b();
            if (r2Var2.i()) {
                return new v2(i, r2Var2, u2.k, this.f15462f);
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
                return new v2(i, r2Var11, u2.k, this.f15462f);
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
        return new v2(i, r2Var2, r2Var, new e[]{r2Var3}, this.f15462f);
    }

    @Override // e.a.b.a.h
    protected h d() {
        return new v2(null, f(), g());
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
        return new v2(this.f15458b, eVar, eVar2.a(eVar3), new e[]{eVar3}, this.f15462f);
    }
}
