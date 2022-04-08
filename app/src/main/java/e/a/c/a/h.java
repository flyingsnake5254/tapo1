package e.a.c.a;

import e.a.c.b.d.f.a;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.n;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x0;

/* loaded from: classes4.dex */
public class h extends l {

    /* renamed from: c  reason: collision with root package name */
    private j f15516c;

    /* renamed from: d  reason: collision with root package name */
    private m f15517d;

    /* renamed from: f  reason: collision with root package name */
    private j f15518f;
    private byte[][] q;
    private byte[][] x;
    private byte[] y;

    public h(int i, short[][] sArr, short[][] sArr2, short[] sArr3) {
        this.f15516c = new j(0L);
        this.f15518f = new j(i);
        this.q = a.c(sArr);
        this.x = a.c(sArr2);
        this.y = a.a(sArr3);
    }

    private h(r rVar) {
        if (rVar.p(0) instanceof j) {
            this.f15516c = j.m(rVar.p(0));
        } else {
            this.f15517d = m.r(rVar.p(0));
        }
        this.f15518f = j.m(rVar.p(1));
        r m = r.m(rVar.p(2));
        this.q = new byte[m.size()];
        for (int i = 0; i < m.size(); i++) {
            this.q[i] = n.m(m.p(i)).o();
        }
        r rVar2 = (r) rVar.p(3);
        this.x = new byte[rVar2.size()];
        for (int i2 = 0; i2 < rVar2.size(); i2++) {
            this.x[i2] = n.m(rVar2.p(i2)).o();
        }
        this.y = n.m(((r) rVar.p(4)).p(0)).o();
    }

    public static h j(Object obj) {
        if (obj instanceof h) {
            return (h) obj;
        }
        if (obj != null) {
            return new h(r.m(obj));
        }
        return null;
    }

    @Override // org.bouncycastle.asn1.l, org.bouncycastle.asn1.e
    public q c() {
        f fVar = new f();
        e eVar = this.f15516c;
        if (eVar == null) {
            eVar = this.f15517d;
        }
        fVar.a(eVar);
        fVar.a(this.f15518f);
        f fVar2 = new f();
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[][] bArr = this.q;
            if (i2 >= bArr.length) {
                break;
            }
            fVar2.a(new x0(bArr[i2]));
            i2++;
        }
        fVar.a(new b1(fVar2));
        f fVar3 = new f();
        while (true) {
            byte[][] bArr2 = this.x;
            if (i < bArr2.length) {
                fVar3.a(new x0(bArr2[i]));
                i++;
            } else {
                fVar.a(new b1(fVar3));
                f fVar4 = new f();
                fVar4.a(new x0(this.y));
                fVar.a(new b1(fVar4));
                return new b1(fVar);
            }
        }
    }

    public short[][] f() {
        return a.d(this.q);
    }

    public short[] g() {
        return a.b(this.y);
    }

    public short[][] h() {
        return a.d(this.x);
    }

    public int i() {
        return this.f15518f.p().intValue();
    }
}
