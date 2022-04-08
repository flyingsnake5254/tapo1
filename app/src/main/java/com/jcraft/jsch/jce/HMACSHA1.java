package com.jcraft.jsch.jce;

/* loaded from: classes2.dex */
public class HMACSHA1 extends HMAC {
    public HMACSHA1() {
        this.name = "hmac-sha1";
        this.bsize = 20;
        this.algorithm = "HmacSHA1";
    }

    @Override // com.jcraft.jsch.jce.HMAC, com.jcraft.jsch.MAC
    public /* bridge */ /* synthetic */ void doFinal(byte[] bArr, int i) {
        super.doFinal(bArr, i);
    }

    @Override // com.jcraft.jsch.jce.HMAC, com.jcraft.jsch.MAC
    public /* bridge */ /* synthetic */ int getBlockSize() {
        return super.getBlockSize();
    }

    @Override // com.jcraft.jsch.jce.HMAC, com.jcraft.jsch.MAC
    public /* bridge */ /* synthetic */ String getName() {
        return super.getName();
    }

    @Override // com.jcraft.jsch.jce.HMAC, com.jcraft.jsch.MAC
    public /* bridge */ /* synthetic */ void init(byte[] bArr) throws Exception {
        super.init(bArr);
    }

    @Override // com.jcraft.jsch.jce.HMAC, com.jcraft.jsch.MAC
    public /* bridge */ /* synthetic */ void update(int i) {
        super.update(i);
    }

    @Override // com.jcraft.jsch.jce.HMAC, com.jcraft.jsch.MAC
    public /* bridge */ /* synthetic */ void update(byte[] bArr, int i, int i2) {
        super.update(bArr, i, i2);
    }
}
