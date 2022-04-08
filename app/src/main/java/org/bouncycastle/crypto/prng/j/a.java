package org.bouncycastle.crypto.prng.j;

import org.bouncycastle.crypto.j;
import org.bouncycastle.crypto.prng.d;
import org.bouncycastle.crypto.w.a0;

/* loaded from: classes4.dex */
public class a implements c {
    private byte[] a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f17152b;

    /* renamed from: c  reason: collision with root package name */
    private long f17153c;

    /* renamed from: d  reason: collision with root package name */
    private d f17154d;

    /* renamed from: e  reason: collision with root package name */
    private j f17155e;

    /* renamed from: f  reason: collision with root package name */
    private int f17156f;

    public a(j jVar, int i, d dVar, byte[] bArr, byte[] bArr2) {
        if (i > d.b(jVar)) {
            throw new IllegalArgumentException("Requested security strength is not supported by the derivation function");
        } else if (dVar.b() >= i) {
            this.f17156f = i;
            this.f17154d = dVar;
            this.f17155e = jVar;
            byte[] m = org.bouncycastle.util.a.m(c(), bArr2, bArr);
            byte[] bArr3 = new byte[jVar.a()];
            this.a = bArr3;
            byte[] bArr4 = new byte[bArr3.length];
            this.f17152b = bArr4;
            org.bouncycastle.util.a.u(bArr4, (byte) 1);
            d(m);
            this.f17153c = 1L;
        } else {
            throw new IllegalArgumentException("Not enough entropy for security strength required");
        }
    }

    private byte[] c() {
        byte[] a = this.f17154d.a();
        if (a.length >= (this.f17156f + 7) / 8) {
            return a;
        }
        throw new IllegalStateException("Insufficient entropy provided by entropy source");
    }

    private void d(byte[] bArr) {
        e(bArr, (byte) 0);
        if (bArr != null) {
            e(bArr, (byte) 1);
        }
    }

    private void e(byte[] bArr, byte b2) {
        this.f17155e.d(new a0(this.a));
        j jVar = this.f17155e;
        byte[] bArr2 = this.f17152b;
        jVar.update(bArr2, 0, bArr2.length);
        this.f17155e.c(b2);
        if (bArr != null) {
            this.f17155e.update(bArr, 0, bArr.length);
        }
        this.f17155e.doFinal(this.a, 0);
        this.f17155e.d(new a0(this.a));
        j jVar2 = this.f17155e;
        byte[] bArr3 = this.f17152b;
        jVar2.update(bArr3, 0, bArr3.length);
        this.f17155e.doFinal(this.f17152b, 0);
    }

    @Override // org.bouncycastle.crypto.prng.j.c
    public int a(byte[] bArr, byte[] bArr2, boolean z) {
        int length = bArr.length * 8;
        if (length > 262144) {
            throw new IllegalArgumentException("Number of bits per request limited to 262144");
        } else if (this.f17153c > 140737488355328L) {
            return -1;
        } else {
            if (z) {
                b(bArr2);
                bArr2 = null;
            }
            if (bArr2 != null) {
                d(bArr2);
            }
            int length2 = bArr.length;
            byte[] bArr3 = new byte[length2];
            int length3 = bArr.length / this.f17152b.length;
            this.f17155e.d(new a0(this.a));
            for (int i = 0; i < length3; i++) {
                j jVar = this.f17155e;
                byte[] bArr4 = this.f17152b;
                jVar.update(bArr4, 0, bArr4.length);
                this.f17155e.doFinal(this.f17152b, 0);
                byte[] bArr5 = this.f17152b;
                System.arraycopy(bArr5, 0, bArr3, bArr5.length * i, bArr5.length);
            }
            byte[] bArr6 = this.f17152b;
            if (bArr6.length * length3 < length2) {
                this.f17155e.update(bArr6, 0, bArr6.length);
                this.f17155e.doFinal(this.f17152b, 0);
                byte[] bArr7 = this.f17152b;
                System.arraycopy(bArr7, 0, bArr3, bArr7.length * length3, length2 - (length3 * bArr7.length));
            }
            d(bArr2);
            this.f17153c++;
            System.arraycopy(bArr3, 0, bArr, 0, bArr.length);
            return length;
        }
    }

    @Override // org.bouncycastle.crypto.prng.j.c
    public void b(byte[] bArr) {
        d(org.bouncycastle.util.a.l(c(), bArr));
        this.f17153c = 1L;
    }
}
