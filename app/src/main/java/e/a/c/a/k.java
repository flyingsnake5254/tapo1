package e.a.c.a;

import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x509.a;

/* loaded from: classes4.dex */
public class k extends l {

    /* renamed from: c  reason: collision with root package name */
    private final j f15524c;

    /* renamed from: d  reason: collision with root package name */
    private final int f15525d;

    /* renamed from: f  reason: collision with root package name */
    private final int f15526f;
    private final a q;

    public k(int i, int i2, a aVar) {
        this.f15524c = new j(0L);
        this.f15525d = i;
        this.f15526f = i2;
        this.q = aVar;
    }

    private k(r rVar) {
        this.f15524c = j.m(rVar.p(0));
        this.f15525d = j.m(rVar.p(1)).p().intValue();
        this.f15526f = j.m(rVar.p(2)).p().intValue();
        this.q = a.g(rVar.p(3));
    }

    public static k g(Object obj) {
        if (obj instanceof k) {
            return (k) obj;
        }
        if (obj != null) {
            return new k(r.m(obj));
        }
        return null;
    }

    @Override // org.bouncycastle.asn1.l, org.bouncycastle.asn1.e
    public q c() {
        f fVar = new f();
        fVar.a(this.f15524c);
        fVar.a(new j(this.f15525d));
        fVar.a(new j(this.f15526f));
        fVar.a(this.q);
        return new b1(fVar);
    }

    public int f() {
        return this.f15525d;
    }

    public int h() {
        return this.f15526f;
    }

    public a i() {
        return this.q;
    }
}
