package e.a.b.a.a0.c;

import e.a.b.a.c;
import e.a.b.a.d;
import e.a.b.a.f;
import e.a.b.a.h;
import e.a.b.c.e;
import java.math.BigInteger;

/* loaded from: classes4.dex */
public class o extends d.c {
    public static final BigInteger i = new BigInteger(1, org.bouncycastle.util.encoders.d.a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFEE37"));
    protected r j = new r(this, null, null);

    /* loaded from: classes4.dex */
    class a implements f {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int[] f15399b;

        a(int i, int[] iArr) {
            this.a = i;
            this.f15399b = iArr;
        }

        @Override // e.a.b.a.f
        public int a() {
            return this.a;
        }

        @Override // e.a.b.a.f
        public h b(int i) {
            int[] g = e.g();
            int[] g2 = e.g();
            int i2 = 0;
            for (int i3 = 0; i3 < this.a; i3++) {
                int i4 = ((i3 ^ i) - 1) >> 31;
                for (int i5 = 0; i5 < 6; i5++) {
                    int i6 = g[i5];
                    int[] iArr = this.f15399b;
                    g[i5] = i6 ^ (iArr[i2 + i5] & i4);
                    g2[i5] = g2[i5] ^ (iArr[(i2 + 6) + i5] & i4);
                }
                i2 += 12;
            }
            return o.this.i(new q(g), new q(g2), false);
        }
    }

    public o() {
        super(i);
        this.f15443b = n(c.a);
        this.f15444c = n(BigInteger.valueOf(3L));
        this.f15445d = new BigInteger(1, org.bouncycastle.util.encoders.d.a("FFFFFFFFFFFFFFFFFFFFFFFE26F2FC170F69466A74DEFD8D"));
        this.f15446e = BigInteger.valueOf(1L);
        this.f15447f = 2;
    }

    @Override // e.a.b.a.d
    public boolean C(int i2) {
        return i2 == 2;
    }

    @Override // e.a.b.a.d
    protected d c() {
        return new o();
    }

    @Override // e.a.b.a.d
    public f e(h[] hVarArr, int i2, int i3) {
        int[] iArr = new int[i3 * 6 * 2];
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            h hVar = hVarArr[i2 + i5];
            e.e(((q) hVar.n()).h, 0, iArr, i4);
            int i6 = i4 + 6;
            e.e(((q) hVar.o()).h, 0, iArr, i6);
            i4 = i6 + 6;
        }
        return new a(i3, iArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.a.b.a.d
    public h i(e.a.b.a.e eVar, e.a.b.a.e eVar2, boolean z) {
        return new r(this, eVar, eVar2, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.a.b.a.d
    public h j(e.a.b.a.e eVar, e.a.b.a.e eVar2, e.a.b.a.e[] eVarArr, boolean z) {
        return new r(this, eVar, eVar2, eVarArr, z);
    }

    @Override // e.a.b.a.d
    public e.a.b.a.e n(BigInteger bigInteger) {
        return new q(bigInteger);
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
