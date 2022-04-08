package com.jcraft.jsch.jce;

import com.jcraft.jsch.HASH;
import java.security.MessageDigest;

/* loaded from: classes2.dex */
public class SHA512 implements HASH {
    MessageDigest md;

    @Override // com.jcraft.jsch.HASH
    public byte[] digest() throws Exception {
        return this.md.digest();
    }

    @Override // com.jcraft.jsch.HASH
    public int getBlockSize() {
        return 64;
    }

    @Override // com.jcraft.jsch.HASH
    public void init() throws Exception {
        try {
            this.md = MessageDigest.getInstance("SHA-512");
        } catch (Exception e2) {
            System.err.println(e2);
        }
    }

    @Override // com.jcraft.jsch.HASH
    public void update(byte[] bArr, int i, int i2) throws Exception {
        this.md.update(bArr, i, i2);
    }
}
