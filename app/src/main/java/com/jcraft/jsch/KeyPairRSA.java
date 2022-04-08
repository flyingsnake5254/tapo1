package com.jcraft.jsch;

import java.math.BigInteger;

/* loaded from: classes2.dex */
public class KeyPairRSA extends KeyPair {
    private static final byte[] begin = Util.str2byte("-----BEGIN RSA PRIVATE KEY-----");
    private static final byte[] end = Util.str2byte("-----END RSA PRIVATE KEY-----");
    private static final byte[] sshrsa = Util.str2byte("ssh-rsa");
    private byte[] c_array;
    private byte[] ep_array;
    private byte[] eq_array;
    private int key_size;
    private byte[] n_array;
    private byte[] p_array;
    private byte[] prv_array;
    private byte[] pub_array;
    private byte[] q_array;

    public KeyPairRSA(JSch jSch) {
        this(jSch, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static KeyPair fromSSHAgent(JSch jSch, Buffer buffer) throws JSchException {
        byte[][] bytes = buffer.getBytes(8, "invalid key format");
        KeyPairRSA keyPairRSA = new KeyPairRSA(jSch, bytes[1], bytes[2], bytes[3]);
        keyPairRSA.c_array = bytes[4];
        keyPairRSA.p_array = bytes[5];
        keyPairRSA.q_array = bytes[6];
        keyPairRSA.publicKeyComment = new String(bytes[7]);
        keyPairRSA.vendor = 0;
        return keyPairRSA;
    }

    private byte[] getCArray() {
        if (this.c_array == null) {
            this.c_array = new BigInteger(this.q_array).modInverse(new BigInteger(this.p_array)).toByteArray();
        }
        return this.c_array;
    }

    private byte[] getEPArray() {
        if (this.ep_array == null) {
            this.ep_array = new BigInteger(this.prv_array).mod(new BigInteger(this.p_array).subtract(BigInteger.ONE)).toByteArray();
        }
        return this.ep_array;
    }

    private byte[] getEQArray() {
        if (this.eq_array == null) {
            this.eq_array = new BigInteger(this.prv_array).mod(new BigInteger(this.q_array).subtract(BigInteger.ONE)).toByteArray();
        }
        return this.eq_array;
    }

    @Override // com.jcraft.jsch.KeyPair
    public void dispose() {
        super.dispose();
        Util.bzero(this.prv_array);
    }

    @Override // com.jcraft.jsch.KeyPair
    public byte[] forSSHAgent() throws JSchException {
        if (!isEncrypted()) {
            Buffer buffer = new Buffer();
            buffer.putString(sshrsa);
            buffer.putString(this.n_array);
            buffer.putString(this.pub_array);
            buffer.putString(this.prv_array);
            buffer.putString(getCArray());
            buffer.putString(this.p_array);
            buffer.putString(this.q_array);
            buffer.putString(Util.str2byte(this.publicKeyComment));
            int length = buffer.getLength();
            byte[] bArr = new byte[length];
            buffer.getByte(bArr, 0, length);
            return bArr;
        }
        throw new JSchException("key is encrypted.");
    }

    @Override // com.jcraft.jsch.KeyPair
    void generate(int i) throws JSchException {
        this.key_size = i;
        try {
            KeyPairGenRSA keyPairGenRSA = (KeyPairGenRSA) Class.forName(JSch.getConfig("keypairgen.rsa")).newInstance();
            keyPairGenRSA.init(i);
            this.pub_array = keyPairGenRSA.getE();
            this.prv_array = keyPairGenRSA.getD();
            this.n_array = keyPairGenRSA.getN();
            this.p_array = keyPairGenRSA.getP();
            this.q_array = keyPairGenRSA.getQ();
            this.ep_array = keyPairGenRSA.getEP();
            this.eq_array = keyPairGenRSA.getEQ();
            this.c_array = keyPairGenRSA.getC();
        } catch (Exception e2) {
            throw new JSchException(e2.toString(), e2);
        }
    }

    @Override // com.jcraft.jsch.KeyPair
    byte[] getBegin() {
        return begin;
    }

    @Override // com.jcraft.jsch.KeyPair
    byte[] getEnd() {
        return end;
    }

    @Override // com.jcraft.jsch.KeyPair
    public int getKeySize() {
        return this.key_size;
    }

    @Override // com.jcraft.jsch.KeyPair
    public int getKeyType() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.jcraft.jsch.KeyPair
    public byte[] getKeyTypeName() {
        return sshrsa;
    }

    @Override // com.jcraft.jsch.KeyPair
    byte[] getPrivateKey() {
        int countLength = countLength(1) + 1 + 1 + 1 + countLength(this.n_array.length) + this.n_array.length + 1 + countLength(this.pub_array.length) + this.pub_array.length + 1 + countLength(this.prv_array.length) + this.prv_array.length + 1 + countLength(this.p_array.length) + this.p_array.length + 1 + countLength(this.q_array.length) + this.q_array.length + 1 + countLength(this.ep_array.length) + this.ep_array.length + 1 + countLength(this.eq_array.length) + this.eq_array.length + 1 + countLength(this.c_array.length) + this.c_array.length;
        byte[] bArr = new byte[countLength(countLength) + 1 + countLength];
        writeINTEGER(bArr, writeINTEGER(bArr, writeINTEGER(bArr, writeINTEGER(bArr, writeINTEGER(bArr, writeINTEGER(bArr, writeINTEGER(bArr, writeINTEGER(bArr, writeINTEGER(bArr, writeSEQUENCE(bArr, 0, countLength), new byte[1]), this.n_array), this.pub_array), this.prv_array), this.p_array), this.q_array), this.ep_array), this.eq_array), this.c_array);
        return bArr;
    }

    @Override // com.jcraft.jsch.KeyPair
    public byte[] getPublicKeyBlob() {
        byte[] publicKeyBlob = super.getPublicKeyBlob();
        if (publicKeyBlob != null) {
            return publicKeyBlob;
        }
        byte[] bArr = this.pub_array;
        if (bArr == null) {
            return null;
        }
        return Buffer.fromBytes(new byte[][]{sshrsa, bArr, this.n_array}).buffer;
    }

    @Override // com.jcraft.jsch.KeyPair
    public byte[] getSignature(byte[] bArr) {
        try {
            SignatureRSA signatureRSA = (SignatureRSA) Class.forName(JSch.getConfig("signature.rsa")).newInstance();
            signatureRSA.init();
            signatureRSA.setPrvKey(this.prv_array, this.n_array);
            signatureRSA.update(bArr);
            return Buffer.fromBytes(new byte[][]{sshrsa, signatureRSA.sign()}).buffer;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.jcraft.jsch.KeyPair
    public Signature getVerifier() {
        try {
            SignatureRSA signatureRSA = (SignatureRSA) Class.forName(JSch.getConfig("signature.rsa")).newInstance();
            signatureRSA.init();
            if (this.pub_array == null && this.n_array == null && getPublicKeyBlob() != null) {
                Buffer buffer = new Buffer(getPublicKeyBlob());
                buffer.getString();
                this.pub_array = buffer.getString();
                this.n_array = buffer.getString();
            }
            signatureRSA.setPubKey(this.pub_array, this.n_array);
            return signatureRSA;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.jcraft.jsch.KeyPair
    public boolean parse(byte[] bArr) {
        int i;
        try {
            int i2 = this.vendor;
            if (i2 == 2) {
                Buffer buffer = new Buffer(bArr);
                buffer.skip(bArr.length);
                try {
                    byte[][] bytes = buffer.getBytes(4, "");
                    this.prv_array = bytes[0];
                    this.p_array = bytes[1];
                    this.q_array = bytes[2];
                    this.c_array = bytes[3];
                    getEPArray();
                    getEQArray();
                    return true;
                } catch (JSchException unused) {
                    return false;
                }
            } else if (i2 != 1) {
                int i3 = bArr[1] & 255;
                if ((i3 & 128) != 0) {
                    int i4 = i3 & 127;
                    i = 2;
                    while (true) {
                        i4--;
                        if (i4 <= 0) {
                            break;
                        }
                        i++;
                        byte b2 = bArr[i];
                    }
                } else {
                    i = 2;
                }
                if (bArr[i] != 2) {
                    return false;
                }
                int i5 = i + 1;
                int i6 = i5 + 1;
                int i7 = bArr[i5] & 255;
                if ((i7 & 128) != 0) {
                    int i8 = i7 & 127;
                    int i9 = 0;
                    while (true) {
                        i8--;
                        if (i8 <= 0) {
                            break;
                        }
                        i6++;
                        i9 = (bArr[i6] & 255) + (i9 << 8);
                    }
                    i7 = i9;
                }
                int i10 = i6 + i7 + 1;
                int i11 = i10 + 1;
                int i12 = bArr[i10] & 255;
                if ((i12 & 128) != 0) {
                    int i13 = i12 & 127;
                    int i14 = i11;
                    int i15 = 0;
                    while (true) {
                        i13--;
                        if (i13 <= 0) {
                            break;
                        }
                        i14++;
                        i15 = (i15 << 8) + (bArr[i14] & 255);
                    }
                    i12 = i15;
                    i11 = i14;
                }
                byte[] bArr2 = new byte[i12];
                this.n_array = bArr2;
                System.arraycopy(bArr, i11, bArr2, 0, i12);
                int i16 = i11 + i12 + 1;
                int i17 = i16 + 1;
                int i18 = bArr[i16] & 255;
                if ((i18 & 128) != 0) {
                    int i19 = i18 & 127;
                    int i20 = 0;
                    while (true) {
                        i19--;
                        if (i19 <= 0) {
                            break;
                        }
                        i17++;
                        i20 = (bArr[i17] & 255) + (i20 << 8);
                    }
                    i18 = i20;
                }
                byte[] bArr3 = new byte[i18];
                this.pub_array = bArr3;
                System.arraycopy(bArr, i17, bArr3, 0, i18);
                int i21 = i17 + i18 + 1;
                int i22 = i21 + 1;
                int i23 = bArr[i21] & 255;
                if ((i23 & 128) != 0) {
                    int i24 = i23 & 127;
                    int i25 = i22;
                    int i26 = 0;
                    while (true) {
                        i24--;
                        if (i24 <= 0) {
                            break;
                        }
                        i25++;
                        i26 = (i26 << 8) + (bArr[i25] & 255);
                    }
                    i23 = i26;
                    i22 = i25;
                }
                byte[] bArr4 = new byte[i23];
                this.prv_array = bArr4;
                System.arraycopy(bArr, i22, bArr4, 0, i23);
                int i27 = i22 + i23 + 1;
                int i28 = i27 + 1;
                int i29 = bArr[i27] & 255;
                if ((i29 & 128) != 0) {
                    int i30 = i29 & 127;
                    int i31 = 0;
                    while (true) {
                        i30--;
                        if (i30 <= 0) {
                            break;
                        }
                        i28++;
                        i31 = (bArr[i28] & 255) + (i31 << 8);
                    }
                    i29 = i31;
                }
                byte[] bArr5 = new byte[i29];
                this.p_array = bArr5;
                System.arraycopy(bArr, i28, bArr5, 0, i29);
                int i32 = i28 + i29 + 1;
                int i33 = i32 + 1;
                int i34 = bArr[i32] & 255;
                if ((i34 & 128) != 0) {
                    int i35 = i34 & 127;
                    int i36 = i33;
                    int i37 = 0;
                    while (true) {
                        i35--;
                        if (i35 <= 0) {
                            break;
                        }
                        i36++;
                        i37 = (i37 << 8) + (bArr[i36] & 255);
                    }
                    i34 = i37;
                    i33 = i36;
                }
                byte[] bArr6 = new byte[i34];
                this.q_array = bArr6;
                System.arraycopy(bArr, i33, bArr6, 0, i34);
                int i38 = i33 + i34 + 1;
                int i39 = i38 + 1;
                int i40 = bArr[i38] & 255;
                if ((i40 & 128) != 0) {
                    int i41 = i40 & 127;
                    int i42 = 0;
                    while (true) {
                        i41--;
                        if (i41 <= 0) {
                            break;
                        }
                        i39++;
                        i42 = (bArr[i39] & 255) + (i42 << 8);
                    }
                    i40 = i42;
                }
                byte[] bArr7 = new byte[i40];
                this.ep_array = bArr7;
                System.arraycopy(bArr, i39, bArr7, 0, i40);
                int i43 = i39 + i40 + 1;
                int i44 = i43 + 1;
                int i45 = bArr[i43] & 255;
                if ((i45 & 128) != 0) {
                    int i46 = i45 & 127;
                    int i47 = i44;
                    int i48 = 0;
                    while (true) {
                        i46--;
                        if (i46 <= 0) {
                            break;
                        }
                        i47++;
                        i48 = (i48 << 8) + (bArr[i47] & 255);
                    }
                    i45 = i48;
                    i44 = i47;
                }
                byte[] bArr8 = new byte[i45];
                this.eq_array = bArr8;
                System.arraycopy(bArr, i44, bArr8, 0, i45);
                int i49 = i44 + i45 + 1;
                int i50 = i49 + 1;
                int i51 = bArr[i49] & 255;
                if ((i51 & 128) != 0) {
                    int i52 = i51 & 127;
                    int i53 = 0;
                    while (true) {
                        i52--;
                        if (i52 <= 0) {
                            break;
                        }
                        i50++;
                        i53 = (bArr[i50] & 255) + (i53 << 8);
                    }
                    i51 = i53;
                }
                byte[] bArr9 = new byte[i51];
                this.c_array = bArr9;
                System.arraycopy(bArr, i50, bArr9, 0, i51);
                if (this.n_array != null) {
                    this.key_size = new BigInteger(this.n_array).bitLength();
                }
                return true;
            } else if (bArr[0] == 48) {
                return false;
            } else {
                Buffer buffer2 = new Buffer(bArr);
                this.pub_array = buffer2.getMPIntBits();
                this.prv_array = buffer2.getMPIntBits();
                this.n_array = buffer2.getMPIntBits();
                buffer2.getMPIntBits();
                this.p_array = buffer2.getMPIntBits();
                this.q_array = buffer2.getMPIntBits();
                if (this.n_array != null) {
                    this.key_size = new BigInteger(this.n_array).bitLength();
                }
                getEPArray();
                getEQArray();
                getCArray();
                return true;
            }
        } catch (Exception unused2) {
            return false;
        }
    }

    public KeyPairRSA(JSch jSch, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super(jSch);
        this.key_size = 1024;
        this.n_array = bArr;
        this.pub_array = bArr2;
        this.prv_array = bArr3;
        if (bArr != null) {
            this.key_size = new BigInteger(bArr).bitLength();
        }
    }
}
