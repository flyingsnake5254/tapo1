package org.bouncycastle.pqc.crypto.xmss;

import java.util.Objects;
import org.bouncycastle.crypto.g;
import org.bouncycastle.crypto.n;

/* loaded from: classes4.dex */
final class e {
    private final g a;

    /* renamed from: b  reason: collision with root package name */
    private final int f17456b;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(g gVar, int i) {
        Objects.requireNonNull(gVar, "digest == null");
        this.a = gVar;
        this.f17456b = i;
    }

    private byte[] d(int i, byte[] bArr, byte[] bArr2) {
        byte[] p = u.p(i, this.f17456b);
        this.a.update(p, 0, p.length);
        this.a.update(bArr, 0, bArr.length);
        this.a.update(bArr2, 0, bArr2.length);
        int i2 = this.f17456b;
        byte[] bArr3 = new byte[i2];
        g gVar = this.a;
        if (gVar instanceof n) {
            ((n) gVar).j(bArr3, 0, i2);
        } else {
            gVar.doFinal(bArr3, 0);
        }
        return bArr3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] a(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i = this.f17456b;
        if (length != i) {
            throw new IllegalArgumentException("wrong key length");
        } else if (bArr2.length == i) {
            return d(0, bArr, bArr2);
        } else {
            throw new IllegalArgumentException("wrong in length");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] b(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i = this.f17456b;
        if (length != i) {
            throw new IllegalArgumentException("wrong key length");
        } else if (bArr2.length == i * 2) {
            return d(1, bArr, bArr2);
        } else {
            throw new IllegalArgumentException("wrong in length");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] c(byte[] bArr, byte[] bArr2) {
        if (bArr.length != this.f17456b) {
            throw new IllegalArgumentException("wrong key length");
        } else if (bArr2.length == 32) {
            return d(3, bArr, bArr2);
        } else {
            throw new IllegalArgumentException("wrong address length");
        }
    }
}
