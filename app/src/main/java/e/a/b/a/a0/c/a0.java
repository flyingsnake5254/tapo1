package e.a.b.a.a0.c;

import e.a.b.a.d;
import e.a.b.a.e;
import e.a.b.a.f;
import e.a.b.a.h;
import java.math.BigInteger;

/* loaded from: classes4.dex */
public class a0 extends d.c {
    public static final BigInteger i = new BigInteger(1, org.bouncycastle.util.encoders.d.a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF000000000000000000000001"));
    protected d0 j = new d0(this, null, null);

    /* loaded from: classes4.dex */
    class a implements f {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int[] f15354b;

        a(int i, int[] iArr) {
            this.a = i;
            this.f15354b = iArr;
        }

        @Override // e.a.b.a.f
        public int a() {
            return this.a;
        }

        @Override // e.a.b.a.f
        public h b(int i) {
            int[] e2 = e.a.b.c.f.e();
            int[] e3 = e.a.b.c.f.e();
            int i2 = 0;
            for (int i3 = 0; i3 < this.a; i3++) {
                int i4 = ((i3 ^ i) - 1) >> 31;
                for (int i5 = 0; i5 < 7; i5++) {
                    int i6 = e2[i5];
                    int[] iArr = this.f15354b;
                    e2[i5] = i6 ^ (iArr[i2 + i5] & i4);
                    e3[i5] = e3[i5] ^ (iArr[(i2 + 7) + i5] & i4);
                }
                i2 += 14;
            }
            return a0.this.i(new c0(e2), new c0(e3), false);
        }
    }

    public a0() {
        super(i);
        this.f15443b = n(new BigInteger(1, org.bouncycastle.util.encoders.d.a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFE")));
        this.f15444c = n(new BigInteger(1, org.bouncycastle.util.encoders.d.a("B4050A850C04B3ABF54132565044B0B7D7BFD8BA270B39432355FFB4")));
        this.f15445d = new BigInteger(1, org.bouncycastle.util.encoders.d.a("FFFFFFFFFFFFFFFFFFFFFFFFFFFF16A2E0B8F03E13DD29455C5C2A3D"));
        this.f15446e = BigInteger.valueOf(1L);
        this.f15447f = 2;
    }

    @Override // e.a.b.a.d
    public boolean C(int i2) {
        return i2 == 2;
    }

    @Override // e.a.b.a.d
    protected d c() {
        return new a0();
    }

    @Override // e.a.b.a.d
    public f e(h[] hVarArr, int i2, int i3) {
        int[] iArr = new int[i3 * 7 * 2];
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            h hVar = hVarArr[i2 + i5];
            e.a.b.c.f.c(((c0) hVar.n()).h, 0, iArr, i4);
            int i6 = i4 + 7;
            e.a.b.c.f.c(((c0) hVar.o()).h, 0, iArr, i6);
            i4 = i6 + 7;
        }
        return new a(i3, iArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.a.b.a.d
    public h i(e eVar, e eVar2, boolean z) {
        return new d0(this, eVar, eVar2, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.a.b.a.d
    public h j(e eVar, e eVar2, e[] eVarArr, boolean z) {
        return new d0(this, eVar, eVar2, eVarArr, z);
    }

    @Override // e.a.b.a.d
    public e n(BigInteger bigInteger) {
        return new c0(bigInteger);
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
