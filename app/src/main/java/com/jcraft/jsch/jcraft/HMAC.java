package com.jcraft.jsch.jcraft;

import java.security.MessageDigest;

/* loaded from: classes2.dex */
class HMAC {
    private static final int B = 64;
    private byte[] k_ipad = null;
    private byte[] k_opad = null;
    private MessageDigest md = null;
    private int bsize = 0;
    private final byte[] tmp = new byte[4];

    public void doFinal(byte[] bArr, int i) {
        byte[] digest = this.md.digest();
        this.md.update(this.k_opad, 0, 64);
        this.md.update(digest, 0, this.bsize);
        try {
            this.md.digest(bArr, i, this.bsize);
        } catch (Exception unused) {
        }
        this.md.update(this.k_ipad, 0, 64);
    }

    public int getBlockSize() {
        return this.bsize;
    }

    public void init(byte[] bArr) throws Exception {
        this.md.reset();
        int length = bArr.length;
        int i = this.bsize;
        if (length > i) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            bArr = bArr2;
        }
        if (bArr.length > 64) {
            this.md.update(bArr, 0, bArr.length);
            bArr = this.md.digest();
        }
        byte[] bArr3 = new byte[64];
        this.k_ipad = bArr3;
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        byte[] bArr4 = new byte[64];
        this.k_opad = bArr4;
        System.arraycopy(bArr, 0, bArr4, 0, bArr.length);
        for (int i2 = 0; i2 < 64; i2++) {
            byte[] bArr5 = this.k_ipad;
            bArr5[i2] = (byte) (bArr5[i2] ^ 54);
            byte[] bArr6 = this.k_opad;
            bArr6[i2] = (byte) (bArr6[i2] ^ 92);
        }
        this.md.update(this.k_ipad, 0, 64);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setH(MessageDigest messageDigest) {
        this.md = messageDigest;
        this.bsize = messageDigest.getDigestLength();
    }

    public void update(int i) {
        byte[] bArr = this.tmp;
        bArr[0] = (byte) (i >>> 24);
        bArr[1] = (byte) (i >>> 16);
        bArr[2] = (byte) (i >>> 8);
        bArr[3] = (byte) i;
        update(bArr, 0, 4);
    }

    public void update(byte[] bArr, int i, int i2) {
        this.md.update(bArr, i, i2);
    }
}
