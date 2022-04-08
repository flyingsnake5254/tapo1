package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.i;

/* loaded from: classes4.dex */
public class s0 extends h {
    public s0(String str) {
        super(str);
    }

    public s0(byte[] bArr) {
        super(bArr);
    }

    private byte[] v() {
        byte[] bArr = this.f16757c;
        if (bArr[bArr.length - 1] != 90) {
            return bArr;
        }
        if (!s()) {
            byte[] bArr2 = this.f16757c;
            byte[] bArr3 = new byte[bArr2.length + 4];
            System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length - 1);
            System.arraycopy(i.e("0000Z"), 0, bArr3, this.f16757c.length - 1, 5);
            return bArr3;
        } else if (!t()) {
            byte[] bArr4 = this.f16757c;
            byte[] bArr5 = new byte[bArr4.length + 2];
            System.arraycopy(bArr4, 0, bArr5, 0, bArr4.length - 1);
            System.arraycopy(i.e("00Z"), 0, bArr5, this.f16757c.length - 1, 3);
            return bArr5;
        } else if (!r()) {
            return this.f16757c;
        } else {
            int length = this.f16757c.length - 2;
            while (length > 0 && this.f16757c[length] == 48) {
                length--;
            }
            byte[] bArr6 = this.f16757c;
            if (bArr6[length] == 46) {
                byte[] bArr7 = new byte[length + 1];
                System.arraycopy(bArr6, 0, bArr7, 0, length);
                bArr7[length] = 90;
                return bArr7;
            }
            byte[] bArr8 = new byte[length + 2];
            int i = length + 1;
            System.arraycopy(bArr6, 0, bArr8, 0, i);
            bArr8[i] = 90;
            return bArr8;
        }
    }

    @Override // org.bouncycastle.asn1.h, org.bouncycastle.asn1.q
    void g(p pVar) throws IOException {
        pVar.g(24, v());
    }

    @Override // org.bouncycastle.asn1.h, org.bouncycastle.asn1.q
    int h() {
        int length = v().length;
        return y1.a(length) + 1 + length;
    }
}
