package com.jcraft.jsch;

import java.math.BigInteger;

/* loaded from: classes2.dex */
public class KeyPairDSA extends KeyPair {
    private static final byte[] begin = Util.str2byte("-----BEGIN DSA PRIVATE KEY-----");
    private static final byte[] end = Util.str2byte("-----END DSA PRIVATE KEY-----");
    private static final byte[] sshdss = Util.str2byte("ssh-dss");
    private byte[] G_array;
    private byte[] P_array;
    private byte[] Q_array;
    private int key_size;
    private byte[] prv_array;
    private byte[] pub_array;

    public KeyPairDSA(JSch jSch) {
        this(jSch, null, null, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static KeyPair fromSSHAgent(JSch jSch, Buffer buffer) throws JSchException {
        byte[][] bytes = buffer.getBytes(7, "invalid key format");
        KeyPairDSA keyPairDSA = new KeyPairDSA(jSch, bytes[1], bytes[2], bytes[3], bytes[4], bytes[5]);
        keyPairDSA.publicKeyComment = new String(bytes[6]);
        keyPairDSA.vendor = 0;
        return keyPairDSA;
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
            buffer.putString(sshdss);
            buffer.putString(this.P_array);
            buffer.putString(this.Q_array);
            buffer.putString(this.G_array);
            buffer.putString(this.pub_array);
            buffer.putString(this.prv_array);
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
            KeyPairGenDSA keyPairGenDSA = (KeyPairGenDSA) Class.forName(JSch.getConfig("keypairgen.dsa")).newInstance();
            keyPairGenDSA.init(i);
            this.P_array = keyPairGenDSA.getP();
            this.Q_array = keyPairGenDSA.getQ();
            this.G_array = keyPairGenDSA.getG();
            this.pub_array = keyPairGenDSA.getY();
            this.prv_array = keyPairGenDSA.getX();
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
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.jcraft.jsch.KeyPair
    public byte[] getKeyTypeName() {
        return sshdss;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.jcraft.jsch.KeyPair
    public byte[] getPrivateKey() {
        int countLength = countLength(1) + 1 + 1 + 1 + countLength(this.P_array.length) + this.P_array.length + 1 + countLength(this.Q_array.length) + this.Q_array.length + 1 + countLength(this.G_array.length) + this.G_array.length + 1 + countLength(this.pub_array.length) + this.pub_array.length + 1 + countLength(this.prv_array.length) + this.prv_array.length;
        byte[] bArr = new byte[countLength(countLength) + 1 + countLength];
        writeINTEGER(bArr, writeINTEGER(bArr, writeINTEGER(bArr, writeINTEGER(bArr, writeINTEGER(bArr, writeINTEGER(bArr, writeSEQUENCE(bArr, 0, countLength), new byte[1]), this.P_array), this.Q_array), this.G_array), this.pub_array), this.prv_array);
        return bArr;
    }

    @Override // com.jcraft.jsch.KeyPair
    public byte[] getPublicKeyBlob() {
        byte[] publicKeyBlob = super.getPublicKeyBlob();
        if (publicKeyBlob != null) {
            return publicKeyBlob;
        }
        byte[] bArr = this.P_array;
        if (bArr == null) {
            return null;
        }
        return Buffer.fromBytes(new byte[][]{sshdss, bArr, this.Q_array, this.G_array, this.pub_array}).buffer;
    }

    @Override // com.jcraft.jsch.KeyPair
    public byte[] getSignature(byte[] bArr) {
        try {
            SignatureDSA signatureDSA = (SignatureDSA) Class.forName(JSch.getConfig("signature.dss")).newInstance();
            signatureDSA.init();
            signatureDSA.setPrvKey(this.prv_array, this.P_array, this.Q_array, this.G_array);
            signatureDSA.update(bArr);
            return Buffer.fromBytes(new byte[][]{sshdss, signatureDSA.sign()}).buffer;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.jcraft.jsch.KeyPair
    public Signature getVerifier() {
        try {
            SignatureDSA signatureDSA = (SignatureDSA) Class.forName(JSch.getConfig("signature.dss")).newInstance();
            signatureDSA.init();
            if (this.pub_array == null && this.P_array == null && getPublicKeyBlob() != null) {
                Buffer buffer = new Buffer(getPublicKeyBlob());
                buffer.getString();
                this.P_array = buffer.getString();
                this.Q_array = buffer.getString();
                this.G_array = buffer.getString();
                this.pub_array = buffer.getString();
            }
            signatureDSA.setPubKey(this.pub_array, this.P_array, this.Q_array, this.G_array);
            return signatureDSA;
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
            if (i2 == 1) {
                if (bArr[0] == 48) {
                    return false;
                }
                Buffer buffer = new Buffer(bArr);
                buffer.getInt();
                this.P_array = buffer.getMPIntBits();
                this.G_array = buffer.getMPIntBits();
                this.Q_array = buffer.getMPIntBits();
                this.pub_array = buffer.getMPIntBits();
                this.prv_array = buffer.getMPIntBits();
                if (this.P_array != null) {
                    this.key_size = new BigInteger(this.P_array).bitLength();
                }
                return true;
            } else if (i2 == 2) {
                Buffer buffer2 = new Buffer(bArr);
                buffer2.skip(bArr.length);
                try {
                    this.prv_array = buffer2.getBytes(1, "")[0];
                    return true;
                } catch (JSchException unused) {
                    return false;
                }
            } else if (bArr[0] != 48) {
                return false;
            } else {
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
                this.P_array = bArr2;
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
                this.Q_array = bArr3;
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
                this.G_array = bArr4;
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
                this.pub_array = bArr5;
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
                this.prv_array = bArr6;
                System.arraycopy(bArr, i33, bArr6, 0, i34);
                if (this.P_array != null) {
                    this.key_size = new BigInteger(this.P_array).bitLength();
                }
                return true;
            }
        } catch (Exception unused2) {
            return false;
        }
    }

    public KeyPairDSA(JSch jSch, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        super(jSch);
        this.key_size = 1024;
        this.P_array = bArr;
        this.Q_array = bArr2;
        this.G_array = bArr3;
        this.pub_array = bArr4;
        this.prv_array = bArr5;
        if (bArr != null) {
            this.key_size = new BigInteger(bArr).bitLength();
        }
    }
}
