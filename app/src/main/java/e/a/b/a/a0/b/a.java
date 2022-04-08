package e.a.b.a.a0.b;

import e.a.b.a.d;
import e.a.b.a.e;
import e.a.b.a.f;
import e.a.b.a.h;
import e.a.b.c.g;
import java.math.BigInteger;

/* loaded from: classes4.dex */
public class a extends d.c {
    public static final BigInteger i = new BigInteger(1, org.bouncycastle.util.encoders.d.a("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFF"));
    protected d j = new d(this, null, null);

    /* renamed from: e.a.b.a.a0.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    class C0279a implements f {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int[] f15349b;

        C0279a(int i, int[] iArr) {
            this.a = i;
            this.f15349b = iArr;
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
                    int[] iArr = this.f15349b;
                    h[i5] = i6 ^ (iArr[i2 + i5] & i4);
                    h2[i5] = h2[i5] ^ (iArr[(i2 + 8) + i5] & i4);
                }
                i2 += 16;
            }
            return a.this.i(new c(h), new c(h2), false);
        }
    }

    public a() {
        super(i);
        this.f15443b = n(new BigInteger(1, org.bouncycastle.util.encoders.d.a("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFC")));
        this.f15444c = n(new BigInteger(1, org.bouncycastle.util.encoders.d.a("28E9FA9E9D9F5E344D5A9E4BCF6509A7F39789F515AB8F92DDBCBD414D940E93")));
        this.f15445d = new BigInteger(1, org.bouncycastle.util.encoders.d.a("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFF7203DF6B21C6052B53BBF40939D54123"));
        this.f15446e = BigInteger.valueOf(1L);
        this.f15447f = 2;
    }

    @Override // e.a.b.a.d
    public boolean C(int i2) {
        return i2 == 2;
    }

    @Override // e.a.b.a.d
    protected d c() {
        return new a();
    }

    @Override // e.a.b.a.d
    public f e(h[] hVarArr, int i2, int i3) {
        int[] iArr = new int[i3 * 8 * 2];
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            h hVar = hVarArr[i2 + i5];
            g.f(((c) hVar.n()).h, 0, iArr, i4);
            int i6 = i4 + 8;
            g.f(((c) hVar.o()).h, 0, iArr, i6);
            i4 = i6 + 8;
        }
        return new C0279a(i3, iArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.a.b.a.d
    public h i(e eVar, e eVar2, boolean z) {
        return new d(this, eVar, eVar2, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.a.b.a.d
    public h j(e eVar, e eVar2, e[] eVarArr, boolean z) {
        return new d(this, eVar, eVar2, eVarArr, z);
    }

    @Override // e.a.b.a.d
    public e n(BigInteger bigInteger) {
        return new c(bigInteger);
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
