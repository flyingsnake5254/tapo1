package e.a.c.a;

import e.a.c.d.a.a;
import e.a.c.d.a.b;
import e.a.c.d.a.h;
import e.a.c.d.a.i;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.n;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x0;

/* loaded from: classes4.dex */
public class c extends l {

    /* renamed from: c  reason: collision with root package name */
    private int f15499c;

    /* renamed from: d  reason: collision with root package name */
    private int f15500d;

    /* renamed from: f  reason: collision with root package name */
    private byte[] f15501f;
    private byte[] q;
    private byte[] x;
    private byte[] y;
    private byte[] z;

    public c(int i, int i2, b bVar, i iVar, h hVar, h hVar2, a aVar) {
        this.f15499c = i;
        this.f15500d = i2;
        this.f15501f = bVar.e();
        this.q = iVar.h();
        this.x = aVar.c();
        this.y = hVar.a();
        this.z = hVar2.a();
    }

    private c(r rVar) {
        this.f15499c = ((j) rVar.p(0)).p().intValue();
        this.f15500d = ((j) rVar.p(1)).p().intValue();
        this.f15501f = ((n) rVar.p(2)).o();
        this.q = ((n) rVar.p(3)).o();
        this.y = ((n) rVar.p(4)).o();
        this.z = ((n) rVar.p(5)).o();
        this.x = ((n) rVar.p(6)).o();
    }

    public static c h(Object obj) {
        if (obj instanceof c) {
            return (c) obj;
        }
        if (obj != null) {
            return new c(r.m(obj));
        }
        return null;
    }

    @Override // org.bouncycastle.asn1.l, org.bouncycastle.asn1.e
    public q c() {
        f fVar = new f();
        fVar.a(new j(this.f15499c));
        fVar.a(new j(this.f15500d));
        fVar.a(new x0(this.f15501f));
        fVar.a(new x0(this.q));
        fVar.a(new x0(this.y));
        fVar.a(new x0(this.z));
        fVar.a(new x0(this.x));
        return new b1(fVar);
    }

    public b f() {
        return new b(this.f15501f);
    }

    public i g() {
        return new i(f(), this.q);
    }

    public int i() {
        return this.f15500d;
    }

    public int j() {
        return this.f15499c;
    }

    public h k() {
        return new h(this.y);
    }

    public h l() {
        return new h(this.z);
    }

    public a m() {
        return new a(this.x);
    }
}
