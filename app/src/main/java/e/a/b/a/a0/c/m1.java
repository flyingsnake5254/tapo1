package e.a.b.a.a0.c;

import e.a.b.a.d;
import e.a.b.a.f;
import e.a.b.a.h;
import e.a.b.c.e;
import java.math.BigInteger;

/* loaded from: classes4.dex */
public class m1 extends d.b {
    protected n1 j = new n1(this, null, null);

    /* loaded from: classes4.dex */
    class a implements f {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long[] f15393b;

        a(int i, long[] jArr) {
            this.a = i;
            this.f15393b = jArr;
        }

        @Override // e.a.b.a.f
        public int a() {
            return this.a;
        }

        @Override // e.a.b.a.f
        public h b(int i) {
            long[] h = e.h();
            long[] h2 = e.h();
            int i2 = 0;
            for (int i3 = 0; i3 < this.a; i3++) {
                long j = ((i3 ^ i) - 1) >> 31;
                for (int i4 = 0; i4 < 3; i4++) {
                    long j2 = h[i4];
                    long[] jArr = this.f15393b;
                    h[i4] = j2 ^ (jArr[i2 + i4] & j);
                    h2[i4] = h2[i4] ^ (jArr[(i2 + 3) + i4] & j);
                }
                i2 += 6;
            }
            return m1.this.i(new h1(h), new h1(h2), false);
        }
    }

    public m1() {
        super(163, 3, 6, 7);
        this.f15443b = n(BigInteger.valueOf(1L));
        this.f15444c = n(new BigInteger(1, org.bouncycastle.util.encoders.d.a("020A601907B8C953CA1481EB10512F78744A3205FD")));
        this.f15445d = new BigInteger(1, org.bouncycastle.util.encoders.d.a("040000000000000000000292FE77E70C12A4234C33"));
        this.f15446e = BigInteger.valueOf(2L);
        this.f15447f = 6;
    }

    @Override // e.a.b.a.d
    public boolean C(int i) {
        return i == 6;
    }

    @Override // e.a.b.a.d.b
    public boolean G() {
        return false;
    }

    @Override // e.a.b.a.d
    protected d c() {
        return new m1();
    }

    @Override // e.a.b.a.d
    public f e(h[] hVarArr, int i, int i2) {
        long[] jArr = new long[i2 * 3 * 2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            h hVar = hVarArr[i + i4];
            e.f(((h1) hVar.n()).g, 0, jArr, i3);
            int i5 = i3 + 3;
            e.f(((h1) hVar.o()).g, 0, jArr, i5);
            i3 = i5 + 3;
        }
        return new a(i2, jArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.a.b.a.d
    public h i(e.a.b.a.e eVar, e.a.b.a.e eVar2, boolean z) {
        return new n1(this, eVar, eVar2, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.a.b.a.d
    public h j(e.a.b.a.e eVar, e.a.b.a.e eVar2, e.a.b.a.e[] eVarArr, boolean z) {
        return new n1(this, eVar, eVar2, eVarArr, z);
    }

    @Override // e.a.b.a.d
    public e.a.b.a.e n(BigInteger bigInteger) {
        return new h1(bigInteger);
    }

    @Override // e.a.b.a.d
    public int t() {
        return 163;
    }

    @Override // e.a.b.a.d
    public h u() {
        return this.j;
    }
}
