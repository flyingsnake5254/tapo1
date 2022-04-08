package org.bouncycastle.crypto.u.g;

/* loaded from: classes4.dex */
public class a implements b {
    private long[] a;

    @Override // org.bouncycastle.crypto.u.g.b
    public void a(long j, byte[] bArr) {
        long[] h = d.h();
        if (j > 0) {
            long[] j2 = org.bouncycastle.util.a.j(this.a);
            do {
                if ((1 & j) != 0) {
                    d.f(h, j2);
                }
                d.i(j2, j2);
                j >>>= 1;
            } while (j > 0);
            d.a(h, bArr);
        }
        d.a(h, bArr);
    }

    @Override // org.bouncycastle.crypto.u.g.b
    public void init(byte[] bArr) {
        this.a = d.c(bArr);
    }
}
