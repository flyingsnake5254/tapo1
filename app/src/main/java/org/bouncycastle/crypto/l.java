package org.bouncycastle.crypto;

/* loaded from: classes4.dex */
public abstract class l implements c, m {
    private final c a;

    /* JADX INFO: Access modifiers changed from: protected */
    public l(c cVar) {
        this.a = cVar;
    }

    @Override // org.bouncycastle.crypto.m
    public int c(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException {
        int i4 = i + i2;
        if (i4 > bArr.length) {
            throw new DataLengthException("input buffer too small");
        } else if (i3 + i2 <= bArr2.length) {
            while (i < i4) {
                i3++;
                i++;
                bArr2[i3] = e(bArr[i]);
            }
            return i2;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    protected abstract byte e(byte b2);
}
