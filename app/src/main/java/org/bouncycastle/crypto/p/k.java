package org.bouncycastle.crypto.p;

import org.bouncycastle.crypto.n;

/* loaded from: classes4.dex */
public class k extends b implements n {
    public k(int i) {
        super(v(i));
    }

    private static int v(int i) {
        if (i == 128 || i == 256) {
            return i;
        }
        throw new IllegalArgumentException("'bitLength' " + i + " not supported for SHAKE");
    }

    @Override // org.bouncycastle.crypto.g
    public String b() {
        return "SHAKE" + this.f17117f;
    }

    @Override // org.bouncycastle.crypto.g
    public int doFinal(byte[] bArr, int i) {
        return j(bArr, i, e());
    }

    @Override // org.bouncycastle.crypto.n
    public int j(byte[] bArr, int i, int i2) {
        int w = w(bArr, i, i2);
        reset();
        return w;
    }

    public int w(byte[] bArr, int i, int i2) {
        if (!this.g) {
            q(15, 4);
        }
        u(bArr, i, i2 * 8);
        return i2;
    }
}
