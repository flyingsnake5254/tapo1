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
public class d extends l {

    /* renamed from: c  reason: collision with root package name */
    private final int f15502c;

    /* renamed from: d  reason: collision with root package name */
    private final int f15503d;

    /* renamed from: f  reason: collision with root package name */
    private final a f15504f;

    public d(int i, int i2, a aVar) {
        this.f15502c = i;
        this.f15503d = i2;
        this.f15504f = new a(aVar);
    }

    private d(r rVar) {
        this.f15502c = ((j) rVar.p(0)).p().intValue();
        this.f15503d = ((j) rVar.p(1)).p().intValue();
        this.f15504f = new a(((n) rVar.p(2)).o());
    }

    public static d g(Object obj) {
        if (obj instanceof d) {
            return (d) obj;
        }
        if (obj != null) {
            return new d(r.m(obj));
        }
        return null;
    }

    @Override // org.bouncycastle.asn1.l, org.bouncycastle.asn1.e
    public q c() {
        f fVar = new f();
        fVar.a(new j(this.f15502c));
        fVar.a(new j(this.f15503d));
        fVar.a(new x0(this.f15504f.c()));
        return new b1(fVar);
    }

    public a f() {
        return new a(this.f15504f);
    }

    public int h() {
        return this.f15502c;
    }

    public int i() {
        return this.f15503d;
    }
}
