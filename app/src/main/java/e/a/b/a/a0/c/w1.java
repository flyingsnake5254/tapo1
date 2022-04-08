package e.a.b.a.a0.c;

import e.a.b.a.d;
import e.a.b.a.e;
import e.a.b.a.f;
import e.a.b.a.h;
import e.a.b.a.x;
import e.a.b.c.g;
import java.math.BigInteger;

/* loaded from: classes4.dex */
public class w1 extends d.b {
    protected x1 j = new x1(this, null, null);

    /* loaded from: classes4.dex */
    class a implements f {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long[] f15423b;

        a(int i, long[] jArr) {
            this.a = i;
            this.f15423b = jArr;
        }

        @Override // e.a.b.a.f
        public int a() {
            return this.a;
        }

        @Override // e.a.b.a.f
        public h b(int i) {
            long[] i2 = g.i();
            long[] i3 = g.i();
            int i4 = 0;
            for (int i5 = 0; i5 < this.a; i5++) {
                long j = ((i5 ^ i) - 1) >> 31;
                for (int i6 = 0; i6 < 4; i6++) {
                    long j2 = i2[i6];
                    long[] jArr = this.f15423b;
                    i2[i6] = j2 ^ (jArr[i4 + i6] & j);
                    i3[i6] = i3[i6] ^ (jArr[(i4 + 4) + i6] & j);
                }
                i4 += 8;
            }
            return w1.this.i(new v1(i2), new v1(i3), false);
        }
    }

    public w1() {
        super(233, 74, 0, 0);
        this.f15443b = n(BigInteger.valueOf(0L));
        this.f15444c = n(BigInteger.valueOf(1L));
        this.f15445d = new BigInteger(1, org.bouncycastle.util.encoders.d.a("8000000000000000000000000000069D5BB915BCD46EFB1AD5F173ABDF"));
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
        return new w1();
    }

    @Override // e.a.b.a.d
    public f e(h[] hVarArr, int i, int i2) {
        long[] jArr = new long[i2 * 4 * 2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            h hVar = hVarArr[i + i4];
            g.g(((v1) hVar.n()).g, 0, jArr, i3);
            int i5 = i3 + 4;
            g.g(((v1) hVar.o()).g, 0, jArr, i5);
            i3 = i5 + 4;
        }
        return new a(i2, jArr);
    }

    @Override // e.a.b.a.d
    protected e.a.b.a.g f() {
        return new x();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.a.b.a.d
    public h i(e eVar, e eVar2, boolean z) {
        return new x1(this, eVar, eVar2, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.a.b.a.d
    public h j(e eVar, e eVar2, e[] eVarArr, boolean z) {
        return new x1(this, eVar, eVar2, eVarArr, z);
    }

    @Override // e.a.b.a.d
    public e n(BigInteger bigInteger) {
        return new v1(bigInteger);
    }

    @Override // e.a.b.a.d
    public int t() {
        return 233;
    }

    @Override // e.a.b.a.d
    public h u() {
        return this.j;
    }
}
