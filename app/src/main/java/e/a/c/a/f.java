package e.a.c.a;

import java.math.BigInteger;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.q;

/* loaded from: classes4.dex */
public class f extends l {

    /* renamed from: c  reason: collision with root package name */
    private static final BigInteger f15510c = BigInteger.valueOf(0);

    /* renamed from: d  reason: collision with root package name */
    private int f15511d;

    /* renamed from: f  reason: collision with root package name */
    private int[] f15512f;
    private int[] q;
    private int[] x;

    @Override // org.bouncycastle.asn1.l, org.bouncycastle.asn1.e
    public q c() {
        org.bouncycastle.asn1.f fVar = new org.bouncycastle.asn1.f();
        org.bouncycastle.asn1.f fVar2 = new org.bouncycastle.asn1.f();
        org.bouncycastle.asn1.f fVar3 = new org.bouncycastle.asn1.f();
        int i = 0;
        while (true) {
            int[] iArr = this.f15512f;
            if (i < iArr.length) {
                fVar.a(new j(iArr[i]));
                fVar2.a(new j(this.q[i]));
                fVar3.a(new j(this.x[i]));
                i++;
            } else {
                org.bouncycastle.asn1.f fVar4 = new org.bouncycastle.asn1.f();
                fVar4.a(new j(this.f15511d));
                fVar4.a(new b1(fVar));
                fVar4.a(new b1(fVar2));
                fVar4.a(new b1(fVar3));
                return new b1(fVar4);
            }
        }
    }
}
