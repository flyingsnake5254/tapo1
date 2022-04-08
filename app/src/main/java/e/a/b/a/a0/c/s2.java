package e.a.b.a.a0.c;

import e.a.b.a.d;
import e.a.b.a.e;
import e.a.b.a.f;
import e.a.b.a.g;
import e.a.b.a.h;
import e.a.b.a.x;
import e.a.b.c.l;
import java.math.BigInteger;

/* loaded from: classes4.dex */
public class s2 extends d.b {
    protected t2 j = new t2(this, null, null);

    /* loaded from: classes4.dex */
    class a implements f {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long[] f15413b;

        a(int i, long[] jArr) {
            this.a = i;
            this.f15413b = jArr;
        }

        @Override // e.a.b.a.f
        public int a() {
            return this.a;
        }

        @Override // e.a.b.a.f
        public h b(int i) {
            long[] b2 = l.b();
            long[] b3 = l.b();
            int i2 = 0;
            for (int i3 = 0; i3 < this.a; i3++) {
                long j = ((i3 ^ i) - 1) >> 31;
                for (int i4 = 0; i4 < 9; i4++) {
                    long j2 = b2[i4];
                    long[] jArr = this.f15413b;
                    b2[i4] = j2 ^ (jArr[i2 + i4] & j);
                    b3[i4] = b3[i4] ^ (jArr[(i2 + 9) + i4] & j);
                }
                i2 += 18;
            }
            return s2.this.i(new r2(b2), new r2(b3), false);
        }
    }

    public s2() {
        super(571, 2, 5, 10);
        this.f15443b = n(BigInteger.valueOf(0L));
        this.f15444c = n(BigInteger.valueOf(1L));
        this.f15445d = new BigInteger(1, org.bouncycastle.util.encoders.d.a("020000000000000000000000000000000000000000000000000000000000000000000000131850E1F19A63E4B391A8DB917F4138B630D84BE5D639381E91DEB45CFE778F637C1001"));
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
        return new s2();
    }

    @Override // e.a.b.a.d
    public f e(h[] hVarArr, int i, int i2) {
        long[] jArr = new long[i2 * 9 * 2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            h hVar = hVarArr[i + i4];
            l.a(((r2) hVar.n()).g, 0, jArr, i3);
            int i5 = i3 + 9;
            l.a(((r2) hVar.o()).g, 0, jArr, i5);
            i3 = i5 + 9;
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
        return new t2(this, eVar, eVar2, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.a.b.a.d
    public h j(e eVar, e eVar2, e[] eVarArr, boolean z) {
        return new t2(this, eVar, eVar2, eVarArr, z);
    }

    @Override // e.a.b.a.d
    public e n(BigInteger bigInteger) {
        return new r2(bigInteger);
    }

    @Override // e.a.b.a.d
    public int t() {
        return 571;
    }

    @Override // e.a.b.a.d
    public h u() {
        return this.j;
    }
}
