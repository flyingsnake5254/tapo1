package e.a.c.a;

import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x509.a;

/* loaded from: classes4.dex */
public class j extends l {

    /* renamed from: c  reason: collision with root package name */
    private final org.bouncycastle.asn1.j f15521c;

    /* renamed from: d  reason: collision with root package name */
    private final int f15522d;

    /* renamed from: f  reason: collision with root package name */
    private final a f15523f;

    public j(int i, a aVar) {
        this.f15521c = new org.bouncycastle.asn1.j(0L);
        this.f15522d = i;
        this.f15523f = aVar;
    }

    private j(r rVar) {
        this.f15521c = org.bouncycastle.asn1.j.m(rVar.p(0));
        this.f15522d = org.bouncycastle.asn1.j.m(rVar.p(1)).p().intValue();
        this.f15523f = a.g(rVar.p(2));
    }

    public static j g(Object obj) {
        if (obj instanceof j) {
            return (j) obj;
        }
        if (obj != null) {
            return new j(r.m(obj));
        }
        return null;
    }

    @Override // org.bouncycastle.asn1.l, org.bouncycastle.asn1.e
    public q c() {
        f fVar = new f();
        fVar.a(this.f15521c);
        fVar.a(new org.bouncycastle.asn1.j(this.f15522d));
        fVar.a(this.f15523f);
        return new b1(fVar);
    }

    public int f() {
        return this.f15522d;
    }

    public a h() {
        return this.f15523f;
    }
}
