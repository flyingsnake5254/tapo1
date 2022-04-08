package org.bouncycastle.asn1.u2;

import e.a.b.a.d;
import e.a.b.a.e;
import java.math.BigInteger;

/* loaded from: classes4.dex */
public class o {
    public int a(d dVar) {
        return (dVar.t() + 7) / 8;
    }

    public int b(e eVar) {
        return (eVar.f() + 7) / 8;
    }

    public byte[] c(BigInteger bigInteger, int i) {
        byte[] byteArray = bigInteger.toByteArray();
        if (i < byteArray.length) {
            byte[] bArr = new byte[i];
            System.arraycopy(byteArray, byteArray.length - i, bArr, 0, i);
            return bArr;
        } else if (i <= byteArray.length) {
            return byteArray;
        } else {
            byte[] bArr2 = new byte[i];
            System.arraycopy(byteArray, 0, bArr2, i - byteArray.length, byteArray.length);
            return bArr2;
        }
    }
}
