package e.a.b.a.a0.c;

import e.a.b.a.d;
import e.a.b.a.e;
import e.a.b.a.f;
import e.a.b.a.h;
import e.a.b.c.c;
import java.math.BigInteger;

/* loaded from: classes4.dex */
public class a extends d.c {
    public static final BigInteger i = new BigInteger(1, org.bouncycastle.util.encoders.d.a("FFFFFFFDFFFFFFFFFFFFFFFFFFFFFFFF"));
    protected d j = new d(this, null, null);

    /* renamed from: e.a.b.a.a0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    class C0280a implements f {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int[] f15352b;

        C0280a(int i, int[] iArr) {
            this.a = i;
            this.f15352b = iArr;
        }

        @Override // e.a.b.a.f
        public int a() {
            return this.a;
        }

        @Override // e.a.b.a.f
        public h b(int i) {
            int[] e2 = c.e();
            int[] e3 = c.e();
            int i2 = 0;
            for (int i3 = 0; i3 < this.a; i3++) {
                int i4 = ((i3 ^ i) - 1) >> 31;
                for (int i5 = 0; i5 < 4; i5++) {
                    int i6 = e2[i5];
                    int[] iArr = this.f15352b;
                    e2[i5] = i6 ^ (iArr[i2 + i5] & i4);
                    e3[i5] = e3[i5] ^ (iArr[(i2 + 4) + i5] & i4);
                }
                i2 += 8;
            }
            return a.this.i(new c(e2), new c(e3), false);
        }
    }

    public a() {
        super(i);
        this.f15443b = n(new BigInteger(1, org.bouncycastle.util.encoders.d.a("FFFFFFFDFFFFFFFFFFFFFFFFFFFFFFFC")));
        this.f15444c = n(new BigInteger(1, org.bouncycastle.util.encoders.d.a("E87579C11079F43DD824993C2CEE5ED3")));
        this.f15445d = new BigInteger(1, org.bouncycastle.util.encoders.d.a("FFFFFFFE0000000075A30D1B9038A115"));
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
        int[] iArr = new int[i3 * 4 * 2];
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            h hVar = hVarArr[i2 + i5];
            c.c(((c) hVar.n()).h, 0, iArr, i4);
            int i6 = i4 + 4;
            c.c(((c) hVar.o()).h, 0, iArr, i6);
            i4 = i6 + 4;
        }
        return new C0280a(i3, iArr);
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
