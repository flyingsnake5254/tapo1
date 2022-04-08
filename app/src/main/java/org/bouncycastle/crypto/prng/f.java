package org.bouncycastle.crypto.prng;

/* loaded from: classes4.dex */
public class f {
    public static byte[] a(d dVar, int i) {
        byte[] bArr = new byte[i];
        if (i * 8 <= dVar.b()) {
            System.arraycopy(dVar.a(), 0, bArr, 0, i);
        } else {
            int b2 = dVar.b() / 8;
            for (int i2 = 0; i2 < i; i2 += b2) {
                byte[] a = dVar.a();
                int i3 = i - i2;
                if (a.length <= i3) {
                    System.arraycopy(a, 0, bArr, i2, a.length);
                } else {
                    System.arraycopy(a, 0, bArr, i2, i3);
                }
            }
        }
        return bArr;
    }
}
