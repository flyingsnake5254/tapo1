package e.a.b.a.a0.c;

import e.a.b.a.d;
import e.a.b.a.e;
import e.a.b.a.f;
import e.a.b.a.h;
import e.a.b.c.g;
import java.math.BigInteger;

/* loaded from: classes4.dex */
public class i0 extends d.c {
    public static final BigInteger i = new BigInteger(1, org.bouncycastle.util.encoders.d.a("FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFF"));
    protected l0 j = new l0(this, null, null);

    /* loaded from: classes4.dex */
    class a implements f {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int[] f15378b;

        a(int i, int[] iArr) {
            this.a = i;
            this.f15378b = iArr;
        }

        @Override // e.a.b.a.f
        public int a() {
            return this.a;
        }

        @Override // e.a.b.a.f
        public h b(int i) {
            int[] h = g.h();
            int[] h2 = g.h();
            int i2 = 0;
            for (int i3 = 0; i3 < this.a; i3++) {
                int i4 = ((i3 ^ i) - 1) >> 31;
                for (int i5 = 0; i5 < 8; i5++) {
                    int i6 = h[i5];
                    int[] iArr = this.f15378b;
                    h[i5] = i6 ^ (iArr[i2 + i5] & i4);
                    h2[i5] = h2[i5] ^ (iArr[(i2 + 8) + i5] & i4);
                }
                i2 += 16;
            }
            return i0.this.i(new k0(h), new k0(h2), false);
        }
    }

    public i0() {
        super(i);
        this.f15443b = n(new BigInteger(1, org.bouncycastle.util.encoders.d.a("FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFC")));
        this.f15444c = n(new BigInteger(1, org.bouncycastle.util.encoders.d.a("5AC635D8AA3A93E7B3EBBD55769886BC651D06B0CC53B0F63BCE3C3E27D2604B")));
        this.f15445d = new BigInteger(1, org.bouncycastle.util.encoders.d.a("FFFFFFFF00000000FFFFFFFFFFFFFFFFBCE6FAADA7179E84F3B9CAC2FC632551"));
        this.f15446e = BigInteger.valueOf(1L);
        this.f15447f = 2;
    }

    @Override // e.a.b.a.d
    public boolean C(int i2) {
        return i2 == 2;
    }

    @Override // e.a.b.a.d
    protected d c() {
        return new i0();
    }

    @Override // e.a.b.a.d
    public f e(h[] hVarArr, int i2, int i3) {
        int[] iArr = new int[i3 * 8 * 2];
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            h hVar = hVarArr[i2 + i5];
            g.f(((k0) hVar.n()).h, 0, iArr, i4);
            int i6 = i4 + 8;
            g.f(((k0) hVar.o()).h, 0, iArr, i6);
            i4 = i6 + 8;
        }
        return new a(i3, iArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.a.b.a.d
    public h i(e eVar, e eVar2, boolean z) {
        return new l0(this, eVar, eVar2, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.a.b.a.d
    public h j(e eVar, e eVar2, e[] eVarArr, boolean z) {
        return new l0(this, eVar, eVar2, eVarArr, z);
    }

    @Override // e.a.b.a.d
    public e n(BigInteger bigInteger) {
        return new k0(bigInteger);
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
