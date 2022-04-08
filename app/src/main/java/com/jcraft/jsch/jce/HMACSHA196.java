package com.jcraft.jsch.jce;

/* loaded from: classes2.dex */
public class HMACSHA196 extends HMACSHA1 {
    private final byte[] _buf20 = new byte[20];

    public HMACSHA196() {
        this.name = "hmac-sha1-96";
    }

    @Override // com.jcraft.jsch.jce.HMACSHA1, com.jcraft.jsch.jce.HMAC, com.jcraft.jsch.MAC
    public void doFinal(byte[] bArr, int i) {
        super.doFinal(this._buf20, 0);
        System.arraycopy(this._buf20, 0, bArr, i, 12);
    }

    @Override // com.jcraft.jsch.jce.HMACSHA1, com.jcraft.jsch.jce.HMAC, com.jcraft.jsch.MAC
    public int getBlockSize() {
        return 12;
    }
}
