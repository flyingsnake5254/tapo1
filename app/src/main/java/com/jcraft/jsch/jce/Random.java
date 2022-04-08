package com.jcraft.jsch.jce;

import java.security.SecureRandom;

/* loaded from: classes2.dex */
public class Random implements com.jcraft.jsch.Random {
    private SecureRandom random;
    private byte[] tmp = new byte[16];

    public Random() {
        this.random = null;
        this.random = new SecureRandom();
    }

    @Override // com.jcraft.jsch.Random
    public void fill(byte[] bArr, int i, int i2) {
        if (i2 > this.tmp.length) {
            this.tmp = new byte[i2];
        }
        this.random.nextBytes(this.tmp);
        System.arraycopy(this.tmp, 0, bArr, i, i2);
    }
}
