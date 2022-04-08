package e.a.b.a.a0.c;

import e.a.b.a.c;
import e.a.b.a.d;
import e.a.b.a.f;
import e.a.b.a.h;
import java.math.BigInteger;

/* loaded from: classes4.dex */
public class e extends d.c {
    public static final BigInteger i = k.i;
    protected f j = new f(this, null, null);

    /* loaded from: classes4.dex */
    class a implements f {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int[] f15364b;

        a(int i, int[] iArr) {
            this.a = i;
            this.f15364b = iArr;
        }

        @Override // e.a.b.a.f
        public int a() {
            return this.a;
        }

        @Override // e.a.b.a.f
        public h b(int i) {
            int[] d2 = e.a.b.c.d.d();
            int[] d3 = e.a.b.c.d.d();
            int i2 = 0;
            for (int i3 = 0; i3 < this.a; i3++) {
                int i4 = ((i3 ^ i) - 1) >> 31;
                for (int i5 = 0; i5 < 5; i5++) {
                    int i6 = d2[i5];
                    int[] iArr = this.f15364b;
                    d2[i5] = i6 ^ (iArr[i2 + i5] & i4);
                    d3[i5] = d3[i5] ^ (iArr[(i2 + 5) + i5] & i4);
                }
                i2 += 10;
            }
            return e.this.i(new m(d2), new m(d3), false);
        }
    }

    public e() {
        super(i);
        this.f15443b = n(c.a);
        this.f15444c = n(BigInteger.valueOf(7L));
        this.f15445d = new BigInteger(1, org.bouncycastle.util.encoders.d.a("0100000000000000000001B8FA16DFAB9ACA16B6B3"));
        this.f15446e = BigInteger.valueOf(1L);
        this.f15447f = 2;
    }

    @Override // e.a.b.a.d
    public boolean C(int i2) {
        return i2 == 2;
    }

    @Override // e.a.b.a.d
    protected d c() {
        return new e();
    }

    @Override // e.a.b.a.d
    public f e(h[] hVarArr, int i2, int i3) {
        int[] iArr = new int[i3 * 5 * 2];
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            h hVar = hVarArr[i2 + i5];
            e.a.b.c.d.c(((m) hVar.n()).h, 0, iArr, i4);
            int i6 = i4 + 5;
            e.a.b.c.d.c(((m) hVar.o()).h, 0, iArr, i6);
            i4 = i6 + 5;
        }
        return new a(i3, iArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.a.b.a.d
    public h i(e.a.b.a.e eVar, e.a.b.a.e eVar2, boolean z) {
        return new f(this, eVar, eVar2, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.a.b.a.d
    public h j(e.a.b.a.e eVar, e.a.b.a.e eVar2, e.a.b.a.e[] eVarArr, boolean z) {
        return new f(this, eVar, eVar2, eVarArr, z);
    }

    @Override // e.a.b.a.d
    public e.a.b.a.e n(BigInteger bigInteger) {
        return new m(bigInteger);
    }

    @Override // e.a.b.a.d
    public int t() {
        return i.bitLength();
    }

    @Override // e.a.b.a.d
    public h u() {
        return this.j;
    }
}
