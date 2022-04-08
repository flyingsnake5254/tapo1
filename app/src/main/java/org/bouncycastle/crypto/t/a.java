package org.bouncycastle.crypto.t;

import org.bouncycastle.crypto.c;
import org.bouncycastle.crypto.e;
import org.bouncycastle.crypto.j;
import org.bouncycastle.crypto.u.b;

/* loaded from: classes4.dex */
public class a implements j {
    private byte[] a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f17174b;

    /* renamed from: c  reason: collision with root package name */
    private int f17175c;

    /* renamed from: d  reason: collision with root package name */
    private c f17176d;

    /* renamed from: e  reason: collision with root package name */
    private org.bouncycastle.crypto.v.a f17177e;

    /* renamed from: f  reason: collision with root package name */
    private int f17178f;

    public a(c cVar, int i) {
        this(cVar, i, null);
    }

    public a(c cVar, int i, org.bouncycastle.crypto.v.a aVar) {
        if (i % 8 == 0) {
            this.f17176d = new b(cVar);
            this.f17177e = aVar;
            this.f17178f = i / 8;
            this.a = new byte[cVar.getBlockSize()];
            this.f17174b = new byte[cVar.getBlockSize()];
            this.f17175c = 0;
            return;
        }
        throw new IllegalArgumentException("MAC size must be multiple of 8");
    }

    @Override // org.bouncycastle.crypto.j
    public int a() {
        return this.f17178f;
    }

    @Override // org.bouncycastle.crypto.j
    public String b() {
        return this.f17176d.b();
    }

    @Override // org.bouncycastle.crypto.j
    public void c(byte b2) {
        int i = this.f17175c;
        byte[] bArr = this.f17174b;
        if (i == bArr.length) {
            this.f17176d.d(bArr, 0, this.a, 0);
            this.f17175c = 0;
        }
        byte[] bArr2 = this.f17174b;
        int i2 = this.f17175c;
        this.f17175c = i2 + 1;
        bArr2[i2] = b2;
    }

    @Override // org.bouncycastle.crypto.j
    public void d(e eVar) {
        reset();
        this.f17176d.a(true, eVar);
    }

    @Override // org.bouncycastle.crypto.j
    public int doFinal(byte[] bArr, int i) {
        int blockSize = this.f17176d.getBlockSize();
        if (this.f17177e == null) {
            while (true) {
                int i2 = this.f17175c;
                if (i2 >= blockSize) {
                    break;
                }
                this.f17174b[i2] = 0;
                this.f17175c = i2 + 1;
            }
        } else {
            if (this.f17175c == blockSize) {
                this.f17176d.d(this.f17174b, 0, this.a, 0);
                this.f17175c = 0;
            }
            this.f17177e.a(this.f17174b, this.f17175c);
        }
        this.f17176d.d(this.f17174b, 0, this.a, 0);
        System.arraycopy(this.a, 0, bArr, i, this.f17178f);
        reset();
        return this.f17178f;
    }

    @Override // org.bouncycastle.crypto.j
    public void reset() {
        int i = 0;
        while (true) {
            byte[] bArr = this.f17174b;
            if (i < bArr.length) {
                bArr[i] = 0;
                i++;
            } else {
                this.f17175c = 0;
                this.f17176d.reset();
                return;
            }
        }
    }

    @Override // org.bouncycastle.crypto.j
    public void update(byte[] bArr, int i, int i2) {
        if (i2 >= 0) {
            int blockSize = this.f17176d.getBlockSize();
            int i3 = this.f17175c;
            int i4 = blockSize - i3;
            if (i2 > i4) {
                System.arraycopy(bArr, i, this.f17174b, i3, i4);
                this.f17176d.d(this.f17174b, 0, this.a, 0);
                this.f17175c = 0;
                i2 -= i4;
                i += i4;
                while (i2 > blockSize) {
                    this.f17176d.d(bArr, i, this.a, 0);
                    i2 -= blockSize;
                    i += blockSize;
                }
            }
            System.arraycopy(bArr, i, this.f17174b, this.f17175c, i2);
            this.f17175c += i2;
            return;
        }
        throw new IllegalArgumentException("Can't have a negative input length!");
    }
}
