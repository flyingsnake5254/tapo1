package e.a.c.a;

import java.math.BigInteger;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.g1;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.n;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x;
import org.bouncycastle.asn1.x0;
import org.bouncycastle.util.a;

/* loaded from: classes4.dex */
public class m extends l {

    /* renamed from: c  reason: collision with root package name */
    private final int f15530c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f15531d;

    /* renamed from: f  reason: collision with root package name */
    private final byte[] f15532f;
    private final byte[] q;
    private final byte[] x;
    private final byte[] y;

    public m(int i, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        this.f15530c = i;
        this.f15531d = a.g(bArr);
        this.f15532f = a.g(bArr2);
        this.q = a.g(bArr3);
        this.x = a.g(bArr4);
        this.y = a.g(bArr5);
    }

    private m(r rVar) {
        if (!j.m(rVar.p(0)).p().equals(BigInteger.valueOf(0L))) {
            throw new IllegalArgumentException("unknown version of sequence");
        } else if (rVar.size() == 2 || rVar.size() == 3) {
            r m = r.m(rVar.p(1));
            this.f15530c = j.m(m.p(0)).p().intValue();
            this.f15531d = a.g(n.m(m.p(1)).o());
            this.f15532f = a.g(n.m(m.p(2)).o());
            this.q = a.g(n.m(m.p(3)).o());
            this.x = a.g(n.m(m.p(4)).o());
            if (rVar.size() == 3) {
                this.y = a.g(n.n(x.m(rVar.p(2)), true).o());
            } else {
                this.y = null;
            }
        } else {
            throw new IllegalArgumentException("key sequence wrong size");
        }
    }

    public static m h(Object obj) {
        if (obj instanceof m) {
            return (m) obj;
        }
        if (obj != null) {
            return new m(r.m(obj));
        }
        return null;
    }

    @Override // org.bouncycastle.asn1.l, org.bouncycastle.asn1.e
    public q c() {
        f fVar = new f();
        fVar.a(new j(0L));
        f fVar2 = new f();
        fVar2.a(new j(this.f15530c));
        fVar2.a(new x0(this.f15531d));
        fVar2.a(new x0(this.f15532f));
        fVar2.a(new x0(this.q));
        fVar2.a(new x0(this.x));
        fVar.a(new b1(fVar2));
        fVar.a(new g1(true, 0, new x0(this.y)));
        return new b1(fVar);
    }

    public byte[] f() {
        return a.g(this.y);
    }

    public int g() {
        return this.f15530c;
    }

    public byte[] i() {
        return a.g(this.q);
    }

    public byte[] j() {
        return a.g(this.x);
    }

    public byte[] k() {
        return a.g(this.f15532f);
    }

    public byte[] l() {
        return a.g(this.f15531d);
    }
}
