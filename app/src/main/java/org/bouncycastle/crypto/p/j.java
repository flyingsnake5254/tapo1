package org.bouncycastle.crypto.p;

import org.bouncycastle.util.MemoableResetException;
import org.bouncycastle.util.e;

/* loaded from: classes4.dex */
public class j extends c {
    private int p;
    private long q;
    private long r;
    private long s;
    private long t;
    private long u;
    private long v;
    private long w;
    private long x;

    public j(int i) {
        if (i >= 512) {
            throw new IllegalArgumentException("bitLength cannot be >= 512");
        } else if (i % 8 != 0) {
            throw new IllegalArgumentException("bitLength needs to be a multiple of 8");
        } else if (i != 384) {
            int i2 = i / 8;
            this.p = i2;
            B(i2 * 8);
            reset();
        } else {
            throw new IllegalArgumentException("bitLength cannot be 384 use SHA384 instead");
        }
    }

    public j(j jVar) {
        super(jVar);
        this.p = jVar.p;
        m(jVar);
    }

    private static void A(long j, byte[] bArr, int i, int i2) {
        if (i2 > 0) {
            z((int) (j >>> 32), bArr, i, i2);
            if (i2 > 4) {
                z((int) (j & 4294967295L), bArr, i + 4, i2 - 4);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x007f, code lost:
        if (r4 > 10) goto L_0x006f;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void B(int r4) {
        /*
            r3 = this;
            r0 = -3482333909917012819(0xcfac43c256196cad, double:-6.392239886847908E75)
            r3.f17122f = r0
            r0 = 2216346199247487646(0x1ec20b20216f029e, double:1.604250256667292E-160)
            r3.g = r0
            r0 = -7364697282686394994(0x99cb56d75b315d8e, double:-2.0106609494103695E-184)
            r3.h = r0
            r0 = 65953792586715988(0xea509ffab89354, double:2.9978976005667514E-304)
            r3.i = r0
            r0 = -816286391624063116(0xf4abf7da08432774, double:-1.0252515228978657E254)
            r3.j = r0
            r0 = 4512832404995164602(0x3ea0cd298e9bc9ba, double:5.007211971427005E-7)
            r3.k = r0
            r0 = -5033199132376557362(0xba267c0e5ee418ce, double:-1.418977391716189E-28)
            r3.l = r0
            r0 = -124578254951840548(0xfe4568bcb6db84dc, double:-1.7921927020935902E300)
            r3.m = r0
            r0 = 83
            r3.c(r0)
            r0 = 72
            r3.c(r0)
            r0 = 65
            r3.c(r0)
            r0 = 45
            r3.c(r0)
            r0 = 53
            r3.c(r0)
            r0 = 49
            r3.c(r0)
            r0 = 50
            r3.c(r0)
            r0 = 47
            r3.c(r0)
            r0 = 100
            r1 = 10
            if (r4 <= r0) goto L_0x007f
            int r2 = r4 / 100
            int r2 = r2 + 48
            byte r2 = (byte) r2
            r3.c(r2)
            int r4 = r4 % r0
        L_0x006f:
            int r0 = r4 / 10
            int r0 = r0 + 48
            byte r0 = (byte) r0
            r3.c(r0)
            int r4 = r4 % r1
        L_0x0078:
            int r4 = r4 + 48
            byte r4 = (byte) r4
            r3.c(r4)
            goto L_0x0082
        L_0x007f:
            if (r4 <= r1) goto L_0x0078
            goto L_0x006f
        L_0x0082:
            r3.v()
            long r0 = r3.f17122f
            r3.q = r0
            long r0 = r3.g
            r3.r = r0
            long r0 = r3.h
            r3.s = r0
            long r0 = r3.i
            r3.t = r0
            long r0 = r3.j
            r3.u = r0
            long r0 = r3.k
            r3.v = r0
            long r0 = r3.l
            r3.w = r0
            long r0 = r3.m
            r3.x = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.crypto.p.j.B(int):void");
    }

    private static void z(int i, byte[] bArr, int i2, int i3) {
        int min = Math.min(4, i3);
        while (true) {
            min--;
            if (min >= 0) {
                bArr[i2 + min] = (byte) (i >>> ((3 - min) * 8));
            } else {
                return;
            }
        }
    }

    @Override // org.bouncycastle.crypto.g
    public String b() {
        return "SHA-512/" + Integer.toString(this.p * 8);
    }

    @Override // org.bouncycastle.util.e
    public e copy() {
        return new j(this);
    }

    @Override // org.bouncycastle.crypto.g
    public int doFinal(byte[] bArr, int i) {
        v();
        A(this.f17122f, bArr, i, this.p);
        A(this.g, bArr, i + 8, this.p - 8);
        A(this.h, bArr, i + 16, this.p - 16);
        A(this.i, bArr, i + 24, this.p - 24);
        A(this.j, bArr, i + 32, this.p - 32);
        A(this.k, bArr, i + 40, this.p - 40);
        A(this.l, bArr, i + 48, this.p - 48);
        A(this.m, bArr, i + 56, this.p - 56);
        reset();
        return this.p;
    }

    @Override // org.bouncycastle.crypto.g
    public int e() {
        return this.p;
    }

    @Override // org.bouncycastle.util.e
    public void m(e eVar) {
        j jVar = (j) eVar;
        if (this.p == jVar.p) {
            super.u(jVar);
            this.q = jVar.q;
            this.r = jVar.r;
            this.s = jVar.s;
            this.t = jVar.t;
            this.u = jVar.u;
            this.v = jVar.v;
            this.w = jVar.w;
            this.x = jVar.x;
            return;
        }
        throw new MemoableResetException("digestLength inappropriate in other");
    }

    @Override // org.bouncycastle.crypto.p.c, org.bouncycastle.crypto.g
    public void reset() {
        super.reset();
        this.f17122f = this.q;
        this.g = this.r;
        this.h = this.s;
        this.i = this.t;
        this.j = this.u;
        this.k = this.v;
        this.l = this.w;
        this.m = this.x;
    }
}
