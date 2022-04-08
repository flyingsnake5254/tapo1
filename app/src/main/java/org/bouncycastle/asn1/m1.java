package org.bouncycastle.asn1;

import java.io.IOException;

/* loaded from: classes4.dex */
public class m1 extends b {
    public m1(byte[] bArr, int i) {
        super(bArr, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public void g(p pVar) throws IOException {
        byte[] bArr = this.f16690d;
        int length = bArr.length + 1;
        byte[] bArr2 = new byte[length];
        bArr2[0] = (byte) q();
        System.arraycopy(bArr, 0, bArr2, 1, length - 1);
        pVar.g(3, bArr2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public int h() {
        return y1.a(this.f16690d.length + 1) + 1 + this.f16690d.length + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public boolean j() {
        return false;
    }
}
