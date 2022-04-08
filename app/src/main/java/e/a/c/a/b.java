package e.a.c.a;

import e.a.c.d.a.a;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.n;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x0;

/* loaded from: classes4.dex */
public class b extends l {

    /* renamed from: c  reason: collision with root package name */
    private final int f15496c;

    /* renamed from: d  reason: collision with root package name */
    private final int f15497d;

    /* renamed from: f  reason: collision with root package name */
    private final a f15498f;
    private final org.bouncycastle.asn1.x509.a q;

    public b(int i, int i2, a aVar, org.bouncycastle.asn1.x509.a aVar2) {
        this.f15496c = i;
        this.f15497d = i2;
        this.f15498f = new a(aVar.c());
        this.q = aVar2;
    }

    private b(r rVar) {
        this.f15496c = ((j) rVar.p(0)).p().intValue();
        this.f15497d = ((j) rVar.p(1)).p().intValue();
        this.f15498f = new a(((n) rVar.p(2)).o());
        this.q = org.bouncycastle.asn1.x509.a.g(rVar.p(3));
    }

    public static b h(Object obj) {
        if (obj instanceof b) {
            return (b) obj;
        }
        if (obj != null) {
            return new b(r.m(obj));
        }
        return null;
    }

    @Override // org.bouncycastle.asn1.l, org.bouncycastle.asn1.e
    public q c() {
        f fVar = new f();
        fVar.a(new j(this.f15496c));
        fVar.a(new j(this.f15497d));
        fVar.a(new x0(this.f15498f.c()));
        fVar.a(this.q);
        return new b1(fVar);
    }

    public org.bouncycastle.asn1.x509.a f() {
        return this.q;
    }

    public a g() {
        return this.f15498f;
    }

    public int i() {
        return this.f15496c;
    }

    public int j() {
        return this.f15497d;
    }
}
