package org.bouncycastle.crypto.t;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.e;
import org.bouncycastle.crypto.j;
import org.bouncycastle.crypto.w.a0;
import org.bouncycastle.crypto.w.b0;
import org.bouncycastle.util.f;

/* loaded from: classes4.dex */
public class c implements j {

    /* renamed from: c  reason: collision with root package name */
    private int f17185c;

    /* renamed from: d  reason: collision with root package name */
    private int f17186d;

    /* renamed from: e  reason: collision with root package name */
    private int f17187e;

    /* renamed from: f  reason: collision with root package name */
    private int f17188f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f17184b = new byte[1];
    private final byte[] p = new byte[16];
    private int q = 0;
    private final org.bouncycastle.crypto.c a = null;

    private static final long e(int i, int i2) {
        return (i & 4294967295L) * i2;
    }

    private void f() {
        int i = this.q;
        if (i < 16) {
            this.p[i] = 1;
            for (int i2 = i + 1; i2 < 16; i2++) {
                this.p[i2] = 0;
            }
        }
        long g = f.g(this.p, 0) & 4294967295L;
        long g2 = f.g(this.p, 4) & 4294967295L;
        long g3 = f.g(this.p, 8) & 4294967295L;
        long g4 = 4294967295L & f.g(this.p, 12);
        int i3 = (int) (this.r + (g & 67108863));
        this.r = i3;
        this.s = (int) (this.s + ((((g2 << 32) | g) >>> 26) & 67108863));
        this.t = (int) (this.t + (((g2 | (g3 << 32)) >>> 20) & 67108863));
        this.u = (int) (this.u + ((((g4 << 32) | g3) >>> 14) & 67108863));
        int i4 = (int) (this.v + (g4 >>> 8));
        this.v = i4;
        if (this.q == 16) {
            this.v = i4 + 16777216;
        }
        long e2 = e(i3, this.f17185c) + e(this.s, this.k) + e(this.t, this.j) + e(this.u, this.i) + e(this.v, this.h);
        long e3 = e(this.r, this.f17186d) + e(this.s, this.f17185c) + e(this.t, this.k) + e(this.u, this.j) + e(this.v, this.i);
        long e4 = e(this.r, this.f17187e) + e(this.s, this.f17186d) + e(this.t, this.f17185c) + e(this.u, this.k) + e(this.v, this.j);
        long e5 = e(this.r, this.f17188f) + e(this.s, this.f17187e) + e(this.t, this.f17186d) + e(this.u, this.f17185c) + e(this.v, this.k);
        long e6 = e(this.r, this.g) + e(this.s, this.f17188f) + e(this.t, this.f17187e) + e(this.u, this.f17186d) + e(this.v, this.f17185c);
        int i5 = ((int) e2) & 67108863;
        this.r = i5;
        long j = e3 + (e2 >>> 26);
        int i6 = ((int) j) & 67108863;
        this.s = i6;
        long j2 = e4 + (j >>> 26);
        this.t = ((int) j2) & 67108863;
        long j3 = e5 + (j2 >>> 26);
        this.u = ((int) j3) & 67108863;
        long j4 = e6 + (j3 >>> 26);
        this.v = ((int) j4) & 67108863;
        int i7 = i5 + (((int) (j4 >>> 26)) * 5);
        this.r = i7;
        this.s = i6 + (i7 >>> 26);
        this.r = i7 & 67108863;
    }

    private void g(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 32) {
            int i = 16;
            if (this.a == null || (bArr2 != null && bArr2.length == 16)) {
                int g = f.g(bArr, 0);
                int g2 = f.g(bArr, 4);
                int g3 = f.g(bArr, 8);
                int g4 = f.g(bArr, 12);
                this.f17185c = 67108863 & g;
                int i2 = ((g >>> 26) | (g2 << 6)) & 67108611;
                this.f17186d = i2;
                int i3 = ((g2 >>> 20) | (g3 << 12)) & 67092735;
                this.f17187e = i3;
                int i4 = ((g3 >>> 14) | (g4 << 18)) & 66076671;
                this.f17188f = i4;
                int i5 = (g4 >>> 8) & 1048575;
                this.g = i5;
                this.h = i2 * 5;
                this.i = i3 * 5;
                this.j = i4 * 5;
                this.k = i5 * 5;
                org.bouncycastle.crypto.c cVar = this.a;
                if (cVar != null) {
                    byte[] bArr3 = new byte[16];
                    cVar.a(true, new a0(bArr, 16, 16));
                    this.a.d(bArr2, 0, bArr3, 0);
                    bArr = bArr3;
                    i = 0;
                }
                this.l = f.g(bArr, i + 0);
                this.m = f.g(bArr, i + 4);
                this.n = f.g(bArr, i + 8);
                this.o = f.g(bArr, i + 12);
                return;
            }
            throw new IllegalArgumentException("Poly1305 requires a 128 bit IV.");
        }
        throw new IllegalArgumentException("Poly1305 key must be 256 bits.");
    }

    @Override // org.bouncycastle.crypto.j
    public int a() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.j
    public String b() {
        if (this.a == null) {
            return "Poly1305";
        }
        return "Poly1305-" + this.a.b();
    }

    @Override // org.bouncycastle.crypto.j
    public void c(byte b2) throws IllegalStateException {
        byte[] bArr = this.f17184b;
        bArr[0] = b2;
        update(bArr, 0, 1);
    }

    @Override // org.bouncycastle.crypto.j
    public void d(e eVar) throws IllegalArgumentException {
        byte[] bArr;
        if (this.a == null) {
            bArr = null;
        } else if (eVar instanceof b0) {
            b0 b0Var = (b0) eVar;
            bArr = b0Var.a();
            eVar = b0Var.b();
        } else {
            throw new IllegalArgumentException("Poly1305 requires an IV when used with a block cipher.");
        }
        if (eVar instanceof a0) {
            g(((a0) eVar).a(), bArr);
            reset();
            return;
        }
        throw new IllegalArgumentException("Poly1305 requires a key.");
    }

    @Override // org.bouncycastle.crypto.j
    public int doFinal(byte[] bArr, int i) throws DataLengthException, IllegalStateException {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (i + 16 <= bArr.length) {
            if (this.q > 0) {
                f();
            }
            int i7 = this.s;
            int i8 = this.r;
            int i9 = i7 + (i8 >>> 26);
            this.s = i9;
            int i10 = i8 & 67108863;
            this.r = i10;
            int i11 = this.t + (i9 >>> 26);
            this.t = i11;
            int i12 = i9 & 67108863;
            this.s = i12;
            int i13 = this.u + (i11 >>> 26);
            this.u = i13;
            int i14 = i11 & 67108863;
            this.t = i14;
            int i15 = this.v + (i13 >>> 26);
            this.v = i15;
            int i16 = i13 & 67108863;
            this.u = i16;
            int i17 = i10 + ((i15 >>> 26) * 5);
            this.r = i17;
            int i18 = i15 & 67108863;
            this.v = i18;
            int i19 = i12 + (i17 >>> 26);
            this.s = i19;
            int i20 = i17 & 67108863;
            this.r = i20;
            int i21 = i20 + 5;
            int i22 = (i21 >>> 26) + i19;
            int i23 = (i22 >>> 26) + i14;
            int i24 = (i23 >>> 26) + i16;
            int i25 = 67108863 & i24;
            int i26 = ((i24 >>> 26) + i18) - 67108864;
            int i27 = (i26 >>> 31) - 1;
            int i28 = ~i27;
            this.r = (i20 & i28) | (i21 & 67108863 & i27);
            this.s = (i19 & i28) | (i22 & 67108863 & i27);
            this.t = (i14 & i28) | (i23 & 67108863 & i27);
            this.u = (i25 & i27) | (i16 & i28);
            this.v = (i18 & i28) | (i26 & i27);
            long j = ((i2 | (i3 << 26)) & 4294967295L) + (this.l & 4294967295L);
            f.e((int) j, bArr, i);
            long j2 = (((i3 >>> 6) | (i4 << 20)) & 4294967295L) + (this.m & 4294967295L) + (j >>> 32);
            f.e((int) j2, bArr, i + 4);
            long j3 = (((i4 >>> 12) | (i5 << 14)) & 4294967295L) + (this.n & 4294967295L) + (j2 >>> 32);
            f.e((int) j3, bArr, i + 8);
            f.e((int) ((((i5 >>> 18) | (i6 << 8)) & 4294967295L) + (4294967295L & this.o) + (j3 >>> 32)), bArr, i + 12);
            reset();
            return 16;
        }
        throw new OutputLengthException("Output buffer is too short.");
    }

    @Override // org.bouncycastle.crypto.j
    public void reset() {
        this.q = 0;
        this.v = 0;
        this.u = 0;
        this.t = 0;
        this.s = 0;
        this.r = 0;
    }

    @Override // org.bouncycastle.crypto.j
    public void update(byte[] bArr, int i, int i2) throws DataLengthException, IllegalStateException {
        int i3 = 0;
        while (i2 > i3) {
            if (this.q == 16) {
                f();
                this.q = 0;
            }
            int min = Math.min(i2 - i3, 16 - this.q);
            System.arraycopy(bArr, i3 + i, this.p, this.q, min);
            i3 += min;
            this.q += min;
        }
    }
}
