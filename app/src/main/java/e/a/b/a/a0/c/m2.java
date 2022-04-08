package e.a.b.a.a0.c;

import e.a.b.a.d;
import e.a.b.a.e;
import e.a.b.a.f;
import e.a.b.a.g;
import e.a.b.a.h;
import e.a.b.a.x;
import e.a.b.c.j;
import java.math.BigInteger;

/* loaded from: classes4.dex */
public class m2 extends d.b {
    protected n2 j = new n2(this, null, null);

    /* loaded from: classes4.dex */
    class a implements f {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long[] f15395b;

        a(int i, long[] jArr) {
            this.a = i;
            this.f15395b = jArr;
        }

        @Override // e.a.b.a.f
        public int a() {
            return this.a;
        }

        @Override // e.a.b.a.f
        public h b(int i) {
            long[] b2 = j.b();
            long[] b3 = j.b();
            int i2 = 0;
            for (int i3 = 0; i3 < this.a; i3++) {
                long j = ((i3 ^ i) - 1) >> 31;
                for (int i4 = 0; i4 < 7; i4++) {
                    long j2 = b2[i4];
                    long[] jArr = this.f15395b;
                    b2[i4] = j2 ^ (jArr[i2 + i4] & j);
                    b3[i4] = b3[i4] ^ (jArr[(i2 + 7) + i4] & j);
                }
                i2 += 14;
            }
            return m2.this.i(new l2(b2), new l2(b3), false);
        }
    }

    public m2() {
        super(409, 87, 0, 0);
        this.f15443b = n(BigInteger.valueOf(0L));
        this.f15444c = n(BigInteger.valueOf(1L));
        this.f15445d = new BigInteger(1, org.bouncycastle.util.encoders.d.a("7FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFE5F83B2D4EA20400EC4557D5ED3E3E7CA5B4B5C83B8E01E5FCF"));
        this.f15446e = BigInteger.valueOf(4L);
        this.f15447f = 6;
    }

    @Override // e.a.b.a.d
    public boolean C(int i) {
        return i == 6;
    }

    @Override // e.a.b.a.d.b
    public boolean G() {
        return true;
    }

    @Override // e.a.b.a.d
    protected d c() {
        return new m2();
    }

    @Override // e.a.b.a.d
    public f e(h[] hVarArr, int i, int i2) {
        long[] jArr = new long[i2 * 7 * 2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            h hVar = hVarArr[i + i4];
            j.a(((l2) hVar.n()).g, 0, jArr, i3);
            int i5 = i3 + 7;
            j.a(((l2) hVar.o()).g, 0, jArr, i5);
            i3 = i5 + 7;
        }
        return new a(i2, jArr);
    }

    @Override // e.a.b.a.d
    protected g f() {
        return new x();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.a.b.a.d
    public h i(e eVar, e eVar2, boolean z) {
        return new n2(this, eVar, eVar2, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.a.b.a.d
    public h j(e eVar, e eVar2, e[] eVarArr, boolean z) {
        return new n2(this, eVar, eVar2, eVarArr, z);
    }

    @Override // e.a.b.a.d
    public e n(BigInteger bigInteger) {
        return new l2(bigInteger);
    }

    @Override // e.a.b.a.d
    public int t() {
        return 409;
    }

    @Override // e.a.b.a.d
    public h u() {
        return this.j;
    }
}
