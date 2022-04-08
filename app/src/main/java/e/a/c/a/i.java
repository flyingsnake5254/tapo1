package e.a.c.a;

import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x509.a;

/* loaded from: classes4.dex */
public class i extends l {

    /* renamed from: c  reason: collision with root package name */
    private final j f15519c;

    /* renamed from: d  reason: collision with root package name */
    private final a f15520d;

    private i(r rVar) {
        this.f15519c = j.m(rVar.p(0));
        this.f15520d = a.g(rVar.p(1));
    }

    public i(a aVar) {
        this.f15519c = new j(0L);
        this.f15520d = aVar;
    }

    public static final i f(Object obj) {
        if (obj instanceof i) {
            return (i) obj;
        }
        if (obj != null) {
            return new i(r.m(obj));
        }
        return null;
    }

    @Override // org.bouncycastle.asn1.l, org.bouncycastle.asn1.e
    public q c() {
        f fVar = new f();
        fVar.a(this.f15519c);
        fVar.a(this.f15520d);
        return new b1(fVar);
    }

    public a g() {
        return this.f15520d;
    }
}
