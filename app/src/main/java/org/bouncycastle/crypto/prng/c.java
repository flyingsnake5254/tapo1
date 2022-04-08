package org.bouncycastle.crypto.prng;

import org.bouncycastle.crypto.g;

/* loaded from: classes4.dex */
public class c implements g {
    private static long a = 10;

    /* renamed from: d  reason: collision with root package name */
    private g f17139d;

    /* renamed from: e  reason: collision with root package name */
    private byte[] f17140e;

    /* renamed from: f  reason: collision with root package name */
    private byte[] f17141f;

    /* renamed from: c  reason: collision with root package name */
    private long f17138c = 1;

    /* renamed from: b  reason: collision with root package name */
    private long f17137b = 1;

    public c(g gVar) {
        this.f17139d = gVar;
        this.f17141f = new byte[gVar.e()];
        this.f17140e = new byte[gVar.e()];
    }

    private void d() {
        g(this.f17141f);
        long j = this.f17138c;
        this.f17138c = 1 + j;
        e(j);
        f(this.f17141f);
    }

    private void e(long j) {
        for (int i = 0; i != 8; i++) {
            this.f17139d.c((byte) j);
            j >>>= 8;
        }
    }

    private void f(byte[] bArr) {
        this.f17139d.doFinal(bArr, 0);
    }

    private void g(byte[] bArr) {
        this.f17139d.update(bArr, 0, bArr.length);
    }

    private void h() {
        long j = this.f17137b;
        this.f17137b = 1 + j;
        e(j);
        g(this.f17140e);
        g(this.f17141f);
        f(this.f17140e);
        if (this.f17137b % a == 0) {
            d();
        }
    }

    @Override // org.bouncycastle.crypto.prng.g
    public void a(byte[] bArr) {
        synchronized (this) {
            g(bArr);
            g(this.f17141f);
            f(this.f17141f);
        }
    }

    @Override // org.bouncycastle.crypto.prng.g
    public void b(byte[] bArr) {
        i(bArr, 0, bArr.length);
    }

    @Override // org.bouncycastle.crypto.prng.g
    public void c(long j) {
        synchronized (this) {
            e(j);
            g(this.f17141f);
            f(this.f17141f);
        }
    }

    public void i(byte[] bArr, int i, int i2) {
        synchronized (this) {
            h();
            int i3 = i2 + i;
            int i4 = 0;
            while (i != i3) {
                if (i4 == this.f17140e.length) {
                    h();
                    i4 = 0;
                }
                i4++;
                bArr[i] = this.f17140e[i4];
                i++;
            }
        }
    }
}
