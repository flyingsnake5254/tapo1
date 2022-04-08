package e.a.c.a;

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
public class a extends l {

    /* renamed from: c  reason: collision with root package name */
    private int f15493c;

    /* renamed from: d  reason: collision with root package name */
    private int f15494d;

    /* renamed from: f  reason: collision with root package name */
    private byte[] f15495f;
    private byte[] q;
    private byte[] x;
    private org.bouncycastle.asn1.x509.a y;

    public a(int i, int i2, b bVar, i iVar, h hVar, org.bouncycastle.asn1.x509.a aVar) {
        this.f15493c = i;
        this.f15494d = i2;
        this.f15495f = bVar.e();
        this.q = iVar.h();
        this.x = hVar.a();
        this.y = aVar;
    }

    private a(r rVar) {
        this.f15493c = ((j) rVar.p(0)).p().intValue();
        this.f15494d = ((j) rVar.p(1)).p().intValue();
        this.f15495f = ((n) rVar.p(2)).o();
        this.q = ((n) rVar.p(3)).o();
        this.x = ((n) rVar.p(4)).o();
        this.y = org.bouncycastle.asn1.x509.a.g(rVar.p(5));
    }

    public static a i(Object obj) {
        if (obj instanceof a) {
            return (a) obj;
        }
        if (obj != null) {
            return new a(r.m(obj));
        }
        return null;
    }

    @Override // org.bouncycastle.asn1.l, org.bouncycastle.asn1.e
    public q c() {
        f fVar = new f();
        fVar.a(new j(this.f15493c));
        fVar.a(new j(this.f15494d));
        fVar.a(new x0(this.f15495f));
        fVar.a(new x0(this.q));
        fVar.a(new x0(this.x));
        fVar.a(this.y);
        return new b1(fVar);
    }

    public org.bouncycastle.asn1.x509.a f() {
        return this.y;
    }

    public b g() {
        return new b(this.f15495f);
    }

    public i h() {
        return new i(g(), this.q);
    }

    public int j() {
        return this.f15494d;
    }

    public int k() {
        return this.f15493c;
    }

    public h l() {
        return new h(this.x);
    }
}
