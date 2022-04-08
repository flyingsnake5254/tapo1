package com.jcraft.jsch;

import com.jcraft.jsch.KeyPair;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.math.BigInteger;
import java.util.Vector;

/* loaded from: classes2.dex */
public class KeyPairPKCS8 extends KeyPair {
    private KeyPair kpair = null;
    private static final byte[] rsaEncryption = {42, -122, 72, -122, -9, 13, 1, 1, 1};
    private static final byte[] dsaEncryption = {42, -122, 72, -50, 56, 4, 1};
    private static final byte[] pbes2 = {42, -122, 72, -122, -9, 13, 1, 5, 13};
    private static final byte[] pbkdf2 = {42, -122, 72, -122, -9, 13, 1, 5, 12};
    private static final byte[] aes128cbc = {96, -122, 72, 1, 101, 3, 4, 1, 2};
    private static final byte[] aes192cbc = {96, -122, 72, 1, 101, 3, 4, 1, BinaryMemcacheOpcodes.DECREMENTQ};
    private static final byte[] aes256cbc = {96, -122, 72, 1, 101, 3, 4, 1, 42};
    private static final byte[] pbeWithMD5AndDESCBC = {42, -122, 72, -122, -9, 13, 1, 5, 3};
    private static final byte[] begin = Util.str2byte("-----BEGIN DSA PRIVATE KEY-----");
    private static final byte[] end = Util.str2byte("-----END DSA PRIVATE KEY-----");

    public KeyPairPKCS8(JSch jSch) {
        super(jSch);
    }

    @Override // com.jcraft.jsch.KeyPair
    public boolean decrypt(byte[] bArr) {
        if (!isEncrypted()) {
            return true;
        }
        if (bArr == null) {
            return !isEncrypted();
        }
        try {
            KeyPair.ASN1[] contents = new KeyPair.ASN1(this, this.data).getContents();
            byte[] content = contents[1].getContent();
            KeyPair.ASN1[] contents2 = contents[0].getContents();
            byte[] content2 = contents2[0].getContent();
            KeyPair.ASN1 asn1 = contents2[1];
            if (Util.array_equals(content2, pbes2)) {
                KeyPair.ASN1[] contents3 = asn1.getContents();
                KeyPair.ASN1 asn12 = contents3[0];
                KeyPair.ASN1 asn13 = contents3[1];
                KeyPair.ASN1[] contents4 = asn12.getContents();
                contents4[0].getContent();
                KeyPair.ASN1[] contents5 = contents4[1].getContents();
                byte[] content3 = contents5[0].getContent();
                int parseInt = Integer.parseInt(new BigInteger(contents5[1].getContent()).toString());
                KeyPair.ASN1[] contents6 = asn13.getContents();
                byte[] content4 = contents6[0].getContent();
                byte[] content5 = contents6[1].getContent();
                Cipher cipher = getCipher(content4);
                if (cipher == null) {
                    return false;
                }
                byte[] bArr2 = null;
                try {
                    bArr2 = ((PBKDF) Class.forName(JSch.getConfig("pbkdf")).newInstance()).getKey(bArr, content3, parseInt, cipher.getBlockSize());
                } catch (Exception unused) {
                }
                if (bArr2 == null) {
                    return false;
                }
                cipher.init(1, bArr2, content5);
                Util.bzero(bArr2);
                byte[] bArr3 = new byte[content.length];
                cipher.update(content, 0, content.length, bArr3, 0);
                if (parse(bArr3)) {
                    this.encrypted = false;
                    return true;
                }
            } else if (Util.array_equals(content2, pbeWithMD5AndDESCBC)) {
            }
        } catch (KeyPair.ASN1Exception | Exception unused2) {
        }
        return false;
    }

    @Override // com.jcraft.jsch.KeyPair
    public byte[] forSSHAgent() throws JSchException {
        return this.kpair.forSSHAgent();
    }

    @Override // com.jcraft.jsch.KeyPair
    void generate(int i) throws JSchException {
    }

    @Override // com.jcraft.jsch.KeyPair
    byte[] getBegin() {
        return begin;
    }

    Cipher getCipher(byte[] bArr) {
        String str;
        String str2;
        try {
            if (Util.array_equals(bArr, aes128cbc)) {
                str = "aes128-cbc";
            } else if (Util.array_equals(bArr, aes192cbc)) {
                str = "aes192-cbc";
            } else {
                str = Util.array_equals(bArr, aes256cbc) ? "aes256-cbc" : null;
            }
        } catch (Exception unused) {
            str = null;
        }
        try {
            return (Cipher) Class.forName(JSch.getConfig(str)).newInstance();
        } catch (Exception unused2) {
            if (!JSch.getLogger().isEnabled(4)) {
                return null;
            }
            if (str == null) {
                str2 = "unknown oid: " + Util.toHex(bArr);
            } else {
                str2 = "function " + str + " is not supported";
            }
            JSch.getLogger().log(4, "PKCS8: " + str2);
            return null;
        }
    }

    @Override // com.jcraft.jsch.KeyPair
    byte[] getEnd() {
        return end;
    }

    @Override // com.jcraft.jsch.KeyPair
    public int getKeySize() {
        return this.kpair.getKeySize();
    }

    @Override // com.jcraft.jsch.KeyPair
    public int getKeyType() {
        return this.kpair.getKeyType();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.jcraft.jsch.KeyPair
    public byte[] getKeyTypeName() {
        return this.kpair.getKeyTypeName();
    }

    @Override // com.jcraft.jsch.KeyPair
    byte[] getPrivateKey() {
        return null;
    }

    @Override // com.jcraft.jsch.KeyPair
    public byte[] getPublicKeyBlob() {
        return this.kpair.getPublicKeyBlob();
    }

    @Override // com.jcraft.jsch.KeyPair
    public byte[] getSignature(byte[] bArr) {
        return this.kpair.getSignature(bArr);
    }

    @Override // com.jcraft.jsch.KeyPair
    public Signature getVerifier() {
        return this.kpair.getVerifier();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.jcraft.jsch.KeyPair
    public boolean parse(byte[] bArr) {
        try {
            Vector vector = new Vector();
            KeyPair.ASN1[] contents = new KeyPair.ASN1(this, bArr).getContents();
            KeyPair.ASN1 asn1 = contents[1];
            KeyPair.ASN1 asn12 = contents[2];
            KeyPair.ASN1[] contents2 = asn1.getContents();
            byte[] content = contents2[0].getContent();
            KeyPair.ASN1[] contents3 = contents2[1].getContents();
            if (contents3.length > 0) {
                for (KeyPair.ASN1 asn13 : contents3) {
                    vector.addElement(asn13.getContent());
                }
            }
            byte[] content2 = asn12.getContent();
            if (Util.array_equals(content, rsaEncryption)) {
                KeyPairRSA keyPairRSA = new KeyPairRSA(this.jsch);
                keyPairRSA.copy(this);
                if (keyPairRSA.parse(content2)) {
                    this.kpair = keyPairRSA;
                }
            } else if (Util.array_equals(content, dsaEncryption)) {
                KeyPair.ASN1 asn14 = new KeyPair.ASN1(this, content2);
                if (vector.size() == 0) {
                    KeyPair.ASN1[] contents4 = asn14.getContents();
                    byte[] content3 = contents4[1].getContent();
                    for (KeyPair.ASN1 asn15 : contents4[0].getContents()) {
                        vector.addElement(asn15.getContent());
                    }
                    vector.addElement(content3);
                } else {
                    vector.addElement(asn14.getContent());
                }
                byte[] bArr2 = (byte[]) vector.elementAt(0);
                byte[] bArr3 = (byte[]) vector.elementAt(1);
                byte[] bArr4 = (byte[]) vector.elementAt(2);
                byte[] bArr5 = (byte[]) vector.elementAt(3);
                byte[] privateKey = new KeyPairDSA(this.jsch, bArr2, bArr3, bArr4, new BigInteger(bArr4).modPow(new BigInteger(bArr5), new BigInteger(bArr2)).toByteArray(), bArr5).getPrivateKey();
                KeyPairDSA keyPairDSA = new KeyPairDSA(this.jsch);
                keyPairDSA.copy(this);
                if (keyPairDSA.parse(privateKey)) {
                    this.kpair = keyPairDSA;
                }
            }
            return this.kpair != null;
        } catch (KeyPair.ASN1Exception | Exception unused) {
            return false;
        }
    }
}
