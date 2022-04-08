package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.security.SecureRandom;
import org.bouncycastle.crypto.c;
import org.bouncycastle.crypto.g;
import org.bouncycastle.crypto.w.a0;
import org.bouncycastle.crypto.w.b0;
import org.bouncycastle.util.a;

/* loaded from: classes4.dex */
public class h0 implements i0 {
    protected p0 a;

    /* renamed from: b  reason: collision with root package name */
    protected byte[] f17238b = new byte[256];

    /* renamed from: c  reason: collision with root package name */
    protected boolean f17239c;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f17240d;

    /* renamed from: e  reason: collision with root package name */
    protected c f17241e;

    /* renamed from: f  reason: collision with root package name */
    protected c f17242f;
    protected y0 g;
    protected y0 h;

    public h0(p0 p0Var, c cVar, c cVar2, g gVar, g gVar2, int i) throws IOException {
        byte[] bArr;
        byte[] bArr2;
        b0 b0Var;
        b0 b0Var2;
        this.a = p0Var;
        p0Var.d().b(this.f17238b);
        this.f17239c = m1.N(p0Var);
        this.f17240d = p0Var.e().n;
        int e2 = (i * 2) + gVar.e() + gVar2.e();
        e2 = !this.f17239c ? e2 + cVar.getBlockSize() + cVar2.getBlockSize() : e2;
        byte[] d2 = m1.d(p0Var, e2);
        y0 y0Var = new y0(p0Var, gVar, d2, 0, gVar.e());
        int e3 = gVar.e() + 0;
        y0 y0Var2 = new y0(p0Var, gVar2, d2, e3, gVar2.e());
        int e4 = e3 + gVar2.e();
        a0 a0Var = new a0(d2, e4, i);
        int i2 = e4 + i;
        a0 a0Var2 = new a0(d2, i2, i);
        int i3 = i2 + i;
        if (this.f17239c) {
            bArr2 = new byte[cVar.getBlockSize()];
            bArr = new byte[cVar2.getBlockSize()];
        } else {
            bArr2 = a.s(d2, i3, cVar.getBlockSize() + i3);
            int blockSize = i3 + cVar.getBlockSize();
            bArr = a.s(d2, blockSize, cVar2.getBlockSize() + blockSize);
            i3 = blockSize + cVar2.getBlockSize();
        }
        if (i3 == e2) {
            if (p0Var.isServer()) {
                this.g = y0Var2;
                this.h = y0Var;
                this.f17241e = cVar2;
                this.f17242f = cVar;
                b0Var = new b0(a0Var2, bArr);
                b0Var2 = new b0(a0Var, bArr2);
            } else {
                this.g = y0Var;
                this.h = y0Var2;
                this.f17241e = cVar;
                this.f17242f = cVar2;
                b0Var = new b0(a0Var, bArr2);
                b0Var2 = new b0(a0Var2, bArr);
            }
            this.f17241e.a(true, b0Var);
            this.f17242f.a(false, b0Var2);
            return;
        }
        throw new TlsFatalAlert((short) 80);
    }

    @Override // org.bouncycastle.crypto.tls.i0
    public byte[] a(long j, short s, byte[] bArr, int i, int i2) throws IOException {
        int i3;
        byte[] bArr2;
        int i4 = i;
        int blockSize = this.f17242f.getBlockSize();
        int d2 = this.h.d();
        int max = this.f17240d ? blockSize + d2 : Math.max(blockSize, d2 + 1);
        if (this.f17239c) {
            max += blockSize;
        }
        if (i2 >= max) {
            boolean z = this.f17240d;
            int i5 = z ? i2 - d2 : i2;
            if (i5 % blockSize == 0) {
                if (z) {
                    int i6 = i4 + i2;
                    if (!a.o(this.h.a(j, s, bArr, i, i2 - d2), a.s(bArr, i6 - d2, i6))) {
                        throw new TlsFatalAlert((short) 20);
                    }
                }
                if (this.f17239c) {
                    this.f17242f.a(false, new b0(null, bArr, i4, blockSize));
                    i4 += blockSize;
                    i5 -= blockSize;
                }
                for (int i7 = 0; i7 < i5; i7 += blockSize) {
                    int i8 = i4 + i7;
                    this.f17242f.d(bArr, i8, bArr, i8);
                }
                int c2 = c(bArr, i4, i5, blockSize, this.f17240d ? 0 : d2);
                boolean z2 = c2 == 0;
                int i9 = i5 - c2;
                if (!this.f17240d) {
                    i9 -= d2;
                    int i10 = i4 + i9;
                    i3 = i4;
                    bArr2 = bArr;
                    z2 |= !a.o(this.h.b(j, s, bArr, i4, i9, i5 - d2, this.f17238b), a.s(bArr, i10, i10 + d2));
                } else {
                    i3 = i4;
                    bArr2 = bArr;
                }
                if (!z2) {
                    return a.s(bArr2, i3, i3 + i9);
                }
                throw new TlsFatalAlert((short) 20);
            }
            throw new TlsFatalAlert((short) 21);
        }
        throw new TlsFatalAlert((short) 50);
    }

    @Override // org.bouncycastle.crypto.tls.i0
    public byte[] b(long j, short s, byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        byte[] bArr2;
        int blockSize = this.f17241e.getBlockSize();
        int d2 = this.g.d();
        x b2 = this.a.b();
        boolean z = this.f17240d;
        int i5 = (blockSize - 1) - ((!z ? i2 + d2 : i2) % blockSize);
        if ((z || !this.a.e().m) && !b2.g() && !b2.i()) {
            i5 += d(this.a.c(), (255 - i5) / blockSize) * blockSize;
        }
        int i6 = d2 + i2 + i5 + 1;
        boolean z2 = this.f17239c;
        if (z2) {
            i6 += blockSize;
        }
        byte[] bArr3 = new byte[i6];
        if (z2) {
            byte[] bArr4 = new byte[blockSize];
            this.a.d().b(bArr4);
            this.f17241e.a(true, new b0(null, bArr4));
            System.arraycopy(bArr4, 0, bArr3, 0, blockSize);
            i3 = blockSize + 0;
            bArr2 = bArr;
            i4 = i;
        } else {
            bArr2 = bArr;
            i4 = i;
            i3 = 0;
        }
        System.arraycopy(bArr2, i4, bArr3, i3, i2);
        int i7 = i3 + i2;
        if (!this.f17240d) {
            byte[] a = this.g.a(j, s, bArr, i, i2);
            System.arraycopy(a, 0, bArr3, i7, a.length);
            i7 += a.length;
        }
        for (int i8 = 0; i8 <= i5; i8++) {
            i7++;
            bArr3[i7] = (byte) i5;
        }
        while (i3 < i7) {
            this.f17241e.d(bArr3, i3, bArr3, i3);
            i3 += blockSize;
        }
        if (!this.f17240d) {
            return bArr3;
        }
        byte[] a2 = this.g.a(j, s, bArr3, 0, i7);
        System.arraycopy(a2, 0, bArr3, i7, a2.length);
        return bArr3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0028, code lost:
        if (r8 != 0) goto L_0x0019;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected int c(byte[] r5, int r6, int r7, int r8, int r9) {
        /*
            r4 = this;
            int r6 = r6 + r7
            int r0 = r6 + (-1)
            byte r0 = r5[r0]
            r1 = r0 & 255(0xff, float:3.57E-43)
            int r1 = r1 + 1
            org.bouncycastle.crypto.tls.p0 r2 = r4.a
            boolean r2 = org.bouncycastle.crypto.tls.m1.K(r2)
            r3 = 0
            if (r2 == 0) goto L_0x0014
            if (r1 > r8) goto L_0x0017
        L_0x0014:
            int r9 = r9 + r1
            if (r9 <= r7) goto L_0x001b
        L_0x0017:
            r5 = 0
            r8 = 0
        L_0x0019:
            r1 = 0
            goto L_0x002b
        L_0x001b:
            int r7 = r6 - r1
            r8 = 0
        L_0x001e:
            int r9 = r7 + 1
            byte r7 = r5[r7]
            r7 = r7 ^ r0
            r7 = r7 | r8
            byte r8 = (byte) r7
            if (r9 < r6) goto L_0x0041
            r5 = r1
            if (r8 == 0) goto L_0x002b
            goto L_0x0019
        L_0x002b:
            byte[] r6 = r4.f17238b
        L_0x002d:
            r7 = 256(0x100, float:3.59E-43)
            if (r5 >= r7) goto L_0x003a
            int r7 = r5 + 1
            byte r5 = r6[r5]
            r5 = r5 ^ r0
            r5 = r5 | r8
            byte r8 = (byte) r5
            r5 = r7
            goto L_0x002d
        L_0x003a:
            byte r5 = r6[r3]
            r5 = r5 ^ r8
            byte r5 = (byte) r5
            r6[r3] = r5
            return r1
        L_0x0041:
            r7 = r9
            goto L_0x001e
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.crypto.tls.h0.c(byte[], int, int, int, int):int");
    }

    protected int d(SecureRandom secureRandom, int i) {
        return Math.min(e(secureRandom.nextInt()), i);
    }

    protected int e(int i) {
        if (i == 0) {
            return 32;
        }
        int i2 = 0;
        while ((i & 1) == 0) {
            i2++;
            i >>= 1;
        }
        return i2;
    }
}
