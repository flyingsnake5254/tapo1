package org.bouncycastle.crypto.p;

import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import org.bouncycastle.util.e;

/* loaded from: classes4.dex */
public class f extends a {

    /* renamed from: d  reason: collision with root package name */
    static final int[] f17129d = {1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998};

    /* renamed from: e  reason: collision with root package name */
    private int f17130e;

    /* renamed from: f  reason: collision with root package name */
    private int f17131f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int[] m;
    private int n;

    public f() {
        this.m = new int[64];
        reset();
    }

    public f(f fVar) {
        super(fVar);
        this.m = new int[64];
        y(fVar);
    }

    private int s(int i, int i2, int i3) {
        return ((~i) & i3) ^ (i2 & i);
    }

    private int t(int i, int i2, int i3) {
        return ((i & i3) ^ (i & i2)) ^ (i2 & i3);
    }

    private int u(int i) {
        return ((i << 10) | (i >>> 22)) ^ (((i >>> 2) | (i << 30)) ^ ((i >>> 13) | (i << 19)));
    }

    private int v(int i) {
        return ((i << 7) | (i >>> 25)) ^ (((i >>> 6) | (i << 26)) ^ ((i >>> 11) | (i << 21)));
    }

    private int w(int i) {
        return (i >>> 3) ^ (((i >>> 7) | (i << 25)) ^ ((i >>> 18) | (i << 14)));
    }

    private int x(int i) {
        return (i >>> 10) ^ (((i >>> 17) | (i << 15)) ^ ((i >>> 19) | (i << 13)));
    }

    private void y(f fVar) {
        super.n(fVar);
        this.f17130e = fVar.f17130e;
        this.f17131f = fVar.f17131f;
        this.g = fVar.g;
        this.h = fVar.h;
        this.i = fVar.i;
        this.j = fVar.j;
        this.k = fVar.k;
        this.l = fVar.l;
        int[] iArr = fVar.m;
        System.arraycopy(iArr, 0, this.m, 0, iArr.length);
        this.n = fVar.n;
    }

    @Override // org.bouncycastle.crypto.g
    public String b() {
        return "SHA-224";
    }

    @Override // org.bouncycastle.util.e
    public e copy() {
        return new f(this);
    }

    @Override // org.bouncycastle.crypto.g
    public int doFinal(byte[] bArr, int i) {
        o();
        org.bouncycastle.util.f.d(this.f17130e, bArr, i);
        org.bouncycastle.util.f.d(this.f17131f, bArr, i + 4);
        org.bouncycastle.util.f.d(this.g, bArr, i + 8);
        org.bouncycastle.util.f.d(this.h, bArr, i + 12);
        org.bouncycastle.util.f.d(this.i, bArr, i + 16);
        org.bouncycastle.util.f.d(this.j, bArr, i + 20);
        org.bouncycastle.util.f.d(this.k, bArr, i + 24);
        reset();
        return 28;
    }

    @Override // org.bouncycastle.crypto.g
    public int e() {
        return 28;
    }

    @Override // org.bouncycastle.util.e
    public void m(e eVar) {
        y((f) eVar);
    }

    @Override // org.bouncycastle.crypto.p.a
    protected void p() {
        for (int i = 16; i <= 63; i++) {
            int[] iArr = this.m;
            int x = x(iArr[i - 2]);
            int[] iArr2 = this.m;
            iArr[i] = x + iArr2[i - 7] + w(iArr2[i - 15]) + this.m[i - 16];
        }
        int i2 = this.f17130e;
        int i3 = this.f17131f;
        int i4 = this.g;
        int i5 = this.h;
        int i6 = this.i;
        int i7 = this.j;
        int i8 = this.k;
        int i9 = this.l;
        int i10 = 0;
        for (int i11 = 0; i11 < 8; i11++) {
            int v = v(i6) + s(i6, i7, i8);
            int[] iArr3 = f17129d;
            int i12 = i9 + v + iArr3[i10] + this.m[i10];
            int i13 = i5 + i12;
            int u = i12 + u(i2) + t(i2, i3, i4);
            int i14 = i10 + 1;
            int v2 = i8 + v(i13) + s(i13, i6, i7) + iArr3[i14] + this.m[i14];
            int i15 = i4 + v2;
            int u2 = v2 + u(u) + t(u, i2, i3);
            int i16 = i14 + 1;
            int v3 = i7 + v(i15) + s(i15, i13, i6) + iArr3[i16] + this.m[i16];
            int i17 = i3 + v3;
            int u3 = v3 + u(u2) + t(u2, u, i2);
            int i18 = i16 + 1;
            int v4 = i6 + v(i17) + s(i17, i15, i13) + iArr3[i18] + this.m[i18];
            int i19 = i2 + v4;
            int u4 = v4 + u(u3) + t(u3, u2, u);
            int i20 = i18 + 1;
            int v5 = i13 + v(i19) + s(i19, i17, i15) + iArr3[i20] + this.m[i20];
            i9 = u + v5;
            i5 = v5 + u(u4) + t(u4, u3, u2);
            int i21 = i20 + 1;
            int v6 = i15 + v(i9) + s(i9, i19, i17) + iArr3[i21] + this.m[i21];
            i8 = u2 + v6;
            i4 = v6 + u(i5) + t(i5, u4, u3);
            int i22 = i21 + 1;
            int v7 = i17 + v(i8) + s(i8, i9, i19) + iArr3[i22] + this.m[i22];
            i7 = u3 + v7;
            i3 = v7 + u(i4) + t(i4, i5, u4);
            int i23 = i22 + 1;
            int v8 = i19 + v(i7) + s(i7, i8, i9) + iArr3[i23] + this.m[i23];
            i6 = u4 + v8;
            i2 = v8 + u(i3) + t(i3, i4, i5);
            i10 = i23 + 1;
        }
        this.f17130e += i2;
        this.f17131f += i3;
        this.g += i4;
        this.h += i5;
        this.i += i6;
        this.j += i7;
        this.k += i8;
        this.l += i9;
        this.n = 0;
        for (int i24 = 0; i24 < 16; i24++) {
            this.m[i24] = 0;
        }
    }

    @Override // org.bouncycastle.crypto.p.a
    protected void q(long j) {
        if (this.n > 14) {
            p();
        }
        int[] iArr = this.m;
        iArr[14] = (int) (j >>> 32);
        iArr[15] = (int) (j & (-1));
    }

    @Override // org.bouncycastle.crypto.p.a
    protected void r(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = (bArr[i3 + 1] & 255) | (bArr[i] << BinaryMemcacheOpcodes.FLUSHQ) | ((bArr[i2] & 255) << 16) | ((bArr[i3] & 255) << 8);
        int[] iArr = this.m;
        int i5 = this.n;
        iArr[i5] = i4;
        int i6 = i5 + 1;
        this.n = i6;
        if (i6 == 16) {
            p();
        }
    }

    @Override // org.bouncycastle.crypto.p.a, org.bouncycastle.crypto.g
    public void reset() {
        super.reset();
        this.f17130e = -1056596264;
        this.f17131f = 914150663;
        this.g = 812702999;
        this.h = -150054599;
        this.i = -4191439;
        this.j = 1750603025;
        this.k = 1694076839;
        this.l = -1090891868;
        this.n = 0;
        int i = 0;
        while (true) {
            int[] iArr = this.m;
            if (i != iArr.length) {
                iArr[i] = 0;
                i++;
            } else {
                return;
            }
        }
    }
}
