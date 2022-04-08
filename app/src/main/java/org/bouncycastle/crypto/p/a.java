package org.bouncycastle.crypto.p;

import io.netty.handler.codec.memcache.binary.DefaultBinaryMemcacheRequest;
import org.bouncycastle.crypto.h;
import org.bouncycastle.util.e;

/* loaded from: classes4.dex */
public abstract class a implements h, e {
    private final byte[] a;

    /* renamed from: b  reason: collision with root package name */
    private int f17111b;

    /* renamed from: c  reason: collision with root package name */
    private long f17112c;

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        this.a = new byte[4];
        this.f17111b = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(a aVar) {
        this.a = new byte[4];
        n(aVar);
    }

    @Override // org.bouncycastle.crypto.g
    public void c(byte b2) {
        byte[] bArr = this.a;
        int i = this.f17111b;
        int i2 = i + 1;
        this.f17111b = i2;
        bArr[i] = b2;
        if (i2 == bArr.length) {
            r(bArr, 0);
            this.f17111b = 0;
        }
        this.f17112c++;
    }

    @Override // org.bouncycastle.crypto.h
    public int k() {
        return 64;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(a aVar) {
        byte[] bArr = aVar.a;
        System.arraycopy(bArr, 0, this.a, 0, bArr.length);
        this.f17111b = aVar.f17111b;
        this.f17112c = aVar.f17112c;
    }

    public void o() {
        long j = this.f17112c << 3;
        byte b2 = DefaultBinaryMemcacheRequest.REQUEST_MAGIC_BYTE;
        while (true) {
            c(b2);
            if (this.f17111b != 0) {
                b2 = 0;
            } else {
                q(j);
                p();
                return;
            }
        }
    }

    protected abstract void p();

    protected abstract void q(long j);

    protected abstract void r(byte[] bArr, int i);

    @Override // org.bouncycastle.crypto.g
    public void reset() {
        this.f17112c = 0L;
        this.f17111b = 0;
        int i = 0;
        while (true) {
            byte[] bArr = this.a;
            if (i < bArr.length) {
                bArr[i] = 0;
                i++;
            } else {
                return;
            }
        }
    }

    @Override // org.bouncycastle.crypto.g
    public void update(byte[] bArr, int i, int i2) {
        int i3 = 0;
        int max = Math.max(0, i2);
        if (this.f17111b != 0) {
            int i4 = 0;
            while (true) {
                if (i4 >= max) {
                    i3 = i4;
                    break;
                }
                byte[] bArr2 = this.a;
                int i5 = this.f17111b;
                int i6 = i5 + 1;
                this.f17111b = i6;
                int i7 = i4 + 1;
                bArr2[i5] = bArr[i4 + i];
                if (i6 == 4) {
                    r(bArr2, 0);
                    this.f17111b = 0;
                    i3 = i7;
                    break;
                }
                i4 = i7;
            }
        }
        int i8 = ((max - i3) & (-4)) + i3;
        while (i3 < i8) {
            r(bArr, i + i3);
            i3 += 4;
        }
        while (i3 < max) {
            byte[] bArr3 = this.a;
            int i9 = this.f17111b;
            this.f17111b = i9 + 1;
            i3++;
            bArr3[i9] = bArr[i3 + i];
        }
        this.f17112c += max;
    }
}
