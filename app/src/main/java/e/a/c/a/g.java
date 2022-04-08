package e.a.c.a;

import e.a.c.b.d.a;
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
public class g extends l {

    /* renamed from: c  reason: collision with root package name */
    private j f15513c;

    /* renamed from: d  reason: collision with root package name */
    private m f15514d;

    /* renamed from: f  reason: collision with root package name */
    private byte[][] f15515f;
    private a[] p0;
    private byte[] q;
    private byte[][] x;
    private byte[] y;
    private byte[] z;

    private g(r rVar) {
        int i = 0;
        if (rVar.p(0) instanceof j) {
            this.f15513c = j.m(rVar.p(0));
        } else {
            this.f15514d = m.r(rVar.p(0));
        }
        r rVar2 = (r) rVar.p(1);
        this.f15515f = new byte[rVar2.size()];
        for (int i2 = 0; i2 < rVar2.size(); i2++) {
            this.f15515f[i2] = ((n) rVar2.p(i2)).o();
        }
        this.q = ((n) ((r) rVar.p(2)).p(0)).o();
        r rVar3 = (r) rVar.p(3);
        this.x = new byte[rVar3.size()];
        for (int i3 = 0; i3 < rVar3.size(); i3++) {
            this.x[i3] = ((n) rVar3.p(i3)).o();
        }
        this.y = ((n) ((r) rVar.p(4)).p(0)).o();
        this.z = ((n) ((r) rVar.p(5)).p(0)).o();
        r rVar4 = (r) rVar.p(6);
        byte[][][][] bArr = new byte[rVar4.size()][][];
        byte[][][][] bArr2 = new byte[rVar4.size()][][];
        byte[][][] bArr3 = new byte[rVar4.size()][];
        byte[][] bArr4 = new byte[rVar4.size()];
        int i4 = 0;
        while (i4 < rVar4.size()) {
            r rVar5 = (r) rVar4.p(i4);
            r rVar6 = (r) rVar5.p(i);
            bArr[i4] = new byte[rVar6.size()][];
            for (int i5 = 0; i5 < rVar6.size(); i5++) {
                r rVar7 = (r) rVar6.p(i5);
                bArr[i4][i5] = new byte[rVar7.size()];
                for (int i6 = 0; i6 < rVar7.size(); i6++) {
                    bArr[i4][i5][i6] = ((n) rVar7.p(i6)).o();
                }
            }
            r rVar8 = (r) rVar5.p(1);
            bArr2[i4] = new byte[rVar8.size()][];
            for (int i7 = 0; i7 < rVar8.size(); i7++) {
                r rVar9 = (r) rVar8.p(i7);
                bArr2[i4][i7] = new byte[rVar9.size()];
                for (int i8 = 0; i8 < rVar9.size(); i8++) {
                    bArr2[i4][i7][i8] = ((n) rVar9.p(i8)).o();
                }
            }
            r rVar10 = (r) rVar5.p(2);
            bArr3[i4] = new byte[rVar10.size()];
            for (int i9 = 0; i9 < rVar10.size(); i9++) {
                bArr3[i4][i9] = ((n) rVar10.p(i9)).o();
            }
            bArr4[i4] = ((n) rVar5.p(3)).o();
            i4++;
            i = 0;
        }
        int length = this.z.length - 1;
        this.p0 = new a[length];
        int i10 = 0;
        while (i10 < length) {
            byte[] bArr5 = this.z;
            int i11 = i10 + 1;
            this.p0[i10] = new a(bArr5[i10], bArr5[i11], e.a.c.b.d.f.a.f(bArr[i10]), e.a.c.b.d.f.a.f(bArr2[i10]), e.a.c.b.d.f.a.d(bArr3[i10]), e.a.c.b.d.f.a.b(bArr4[i10]));
            i10 = i11;
        }
    }

    public g(short[][] sArr, short[] sArr2, short[][] sArr3, short[] sArr4, int[] iArr, a[] aVarArr) {
        this.f15513c = new j(1L);
        this.f15515f = e.a.c.b.d.f.a.c(sArr);
        this.q = e.a.c.b.d.f.a.a(sArr2);
        this.x = e.a.c.b.d.f.a.c(sArr3);
        this.y = e.a.c.b.d.f.a.a(sArr4);
        this.z = e.a.c.b.d.f.a.h(iArr);
        this.p0 = aVarArr;
    }

    public static g h(Object obj) {
        if (obj instanceof g) {
            return (g) obj;
        }
        if (obj != null) {
            return new g(r.m(obj));
        }
        return null;
    }

    @Override // org.bouncycastle.asn1.l, org.bouncycastle.asn1.e
    public q c() {
        f fVar = new f();
        e eVar = this.f15513c;
        if (eVar == null) {
            eVar = this.f15514d;
        }
        fVar.a(eVar);
        f fVar2 = new f();
        int i = 0;
        while (true) {
            byte[][] bArr = this.f15515f;
            if (i >= bArr.length) {
                break;
            }
            fVar2.a(new x0(bArr[i]));
            i++;
        }
        fVar.a(new b1(fVar2));
        f fVar3 = new f();
        fVar3.a(new x0(this.q));
        fVar.a(new b1(fVar3));
        f fVar4 = new f();
        int i2 = 0;
        while (true) {
            byte[][] bArr2 = this.x;
            if (i2 >= bArr2.length) {
                break;
            }
            fVar4.a(new x0(bArr2[i2]));
            i2++;
        }
        fVar.a(new b1(fVar4));
        f fVar5 = new f();
        fVar5.a(new x0(this.y));
        fVar.a(new b1(fVar5));
        f fVar6 = new f();
        fVar6.a(new x0(this.z));
        fVar.a(new b1(fVar6));
        f fVar7 = new f();
        for (int i3 = 0; i3 < this.p0.length; i3++) {
            f fVar8 = new f();
            byte[][][] e2 = e.a.c.b.d.f.a.e(this.p0[i3].a());
            f fVar9 = new f();
            for (int i4 = 0; i4 < e2.length; i4++) {
                f fVar10 = new f();
                for (int i5 = 0; i5 < e2[i4].length; i5++) {
                    fVar10.a(new x0(e2[i4][i5]));
                }
                fVar9.a(new b1(fVar10));
            }
            fVar8.a(new b1(fVar9));
            byte[][][] e3 = e.a.c.b.d.f.a.e(this.p0[i3].b());
            f fVar11 = new f();
            for (int i6 = 0; i6 < e3.length; i6++) {
                f fVar12 = new f();
                for (int i7 = 0; i7 < e3[i6].length; i7++) {
                    fVar12.a(new x0(e3[i6][i7]));
                }
                fVar11.a(new b1(fVar12));
            }
            fVar8.a(new b1(fVar11));
            byte[][] c2 = e.a.c.b.d.f.a.c(this.p0[i3].d());
            f fVar13 = new f();
            for (byte[] bArr3 : c2) {
                fVar13.a(new x0(bArr3));
            }
            fVar8.a(new b1(fVar13));
            fVar8.a(new x0(e.a.c.b.d.f.a.a(this.p0[i3].c())));
            fVar7.a(new b1(fVar8));
        }
        fVar.a(new b1(fVar7));
        return new b1(fVar);
    }

    public short[] f() {
        return e.a.c.b.d.f.a.b(this.q);
    }

    public short[] g() {
        return e.a.c.b.d.f.a.b(this.y);
    }

    public short[][] i() {
        return e.a.c.b.d.f.a.d(this.f15515f);
    }

    public short[][] j() {
        return e.a.c.b.d.f.a.d(this.x);
    }

    public a[] k() {
        return this.p0;
    }

    public int[] l() {
        return e.a.c.b.d.f.a.g(this.z);
    }
}
