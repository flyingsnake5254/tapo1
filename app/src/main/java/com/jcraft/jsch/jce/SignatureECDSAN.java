package com.jcraft.jsch.jce;

import com.jcraft.jsch.Buffer;
import com.jcraft.jsch.SignatureECDSA;
import io.netty.handler.codec.memcache.binary.DefaultBinaryMemcacheRequest;
import io.netty.handler.codec.memcache.binary.DefaultBinaryMemcacheResponse;
import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.ECPublicKeySpec;

/* loaded from: classes2.dex */
public abstract class SignatureECDSAN implements SignatureECDSA {
    KeyFactory keyFactory;
    Signature signature;

    private void bzero(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = 0;
        }
    }

    private byte[] chop0(byte[] bArr) {
        if (bArr[0] != 0) {
            return bArr;
        }
        int length = bArr.length - 1;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 1, bArr2, 0, length);
        bzero(bArr);
        return bArr2;
    }

    private byte[] insert0(byte[] bArr) {
        if ((bArr[0] & DefaultBinaryMemcacheRequest.REQUEST_MAGIC_BYTE) == 0) {
            return bArr;
        }
        byte[] bArr2 = new byte[bArr.length + 1];
        System.arraycopy(bArr, 0, bArr2, 1, bArr.length);
        bzero(bArr);
        return bArr2;
    }

    abstract String getName();

    @Override // com.jcraft.jsch.Signature
    public void init() throws Exception {
        String str;
        String name = getName();
        if (name.equals("ecdsa-sha2-nistp384")) {
            str = "SHA384withECDSA";
        } else {
            str = name.equals("ecdsa-sha2-nistp521") ? "SHA512withECDSA" : "SHA256withECDSA";
        }
        this.signature = Signature.getInstance(str);
        this.keyFactory = KeyFactory.getInstance("EC");
    }

    @Override // com.jcraft.jsch.SignatureECDSA
    public void setPrvKey(byte[] bArr) throws Exception {
        String str;
        byte[] insert0 = insert0(bArr);
        if (insert0.length >= 64) {
            str = "secp521r1";
        } else {
            str = insert0.length >= 48 ? "secp384r1" : "secp256r1";
        }
        AlgorithmParameters instance = AlgorithmParameters.getInstance("EC");
        instance.init(new ECGenParameterSpec(str));
        this.signature.initSign(this.keyFactory.generatePrivate(new ECPrivateKeySpec(new BigInteger(1, insert0), (ECParameterSpec) instance.getParameterSpec(ECParameterSpec.class))));
    }

    @Override // com.jcraft.jsch.SignatureECDSA
    public void setPubKey(byte[] bArr, byte[] bArr2) throws Exception {
        String str;
        byte[] insert0 = insert0(bArr);
        byte[] insert02 = insert0(bArr2);
        if (insert0.length >= 64) {
            str = "secp521r1";
        } else {
            str = insert0.length >= 48 ? "secp384r1" : "secp256r1";
        }
        AlgorithmParameters instance = AlgorithmParameters.getInstance("EC");
        instance.init(new ECGenParameterSpec(str));
        this.signature.initVerify(this.keyFactory.generatePublic(new ECPublicKeySpec(new ECPoint(new BigInteger(1, insert0), new BigInteger(1, insert02)), (ECParameterSpec) instance.getParameterSpec(ECParameterSpec.class))));
    }

    @Override // com.jcraft.jsch.Signature
    public byte[] sign() throws Exception {
        byte[] sign = this.signature.sign();
        if (sign[0] != 48) {
            return sign;
        }
        int i = 3;
        if (sign[1] + 2 != sign.length && ((sign[1] & DefaultBinaryMemcacheRequest.REQUEST_MAGIC_BYTE) == 0 || (sign[2] & 255) + 3 != sign.length)) {
            return sign;
        }
        if ((sign[1] & DefaultBinaryMemcacheRequest.REQUEST_MAGIC_BYTE) != 0 && (sign[2] & 255) + 3 == sign.length) {
            i = 4;
        }
        byte b2 = sign[i];
        byte[] bArr = new byte[b2];
        byte b3 = sign[i + 2 + sign[i]];
        byte[] bArr2 = new byte[b3];
        System.arraycopy(sign, i + 1, bArr, 0, b2);
        System.arraycopy(sign, i + 3 + sign[i], bArr2, 0, b3);
        byte[] chop0 = chop0(bArr);
        byte[] chop02 = chop0(bArr2);
        Buffer buffer = new Buffer();
        buffer.putMPInt(chop0);
        buffer.putMPInt(chop02);
        byte[] bArr3 = new byte[buffer.getLength()];
        buffer.setOffSet(0);
        buffer.getByte(bArr3);
        return bArr3;
    }

    @Override // com.jcraft.jsch.Signature
    public void update(byte[] bArr) throws Exception {
        this.signature.update(bArr);
    }

    @Override // com.jcraft.jsch.Signature
    public boolean verify(byte[] bArr) throws Exception {
        if (bArr[0] != 48 || (bArr[1] + 2 != bArr.length && ((bArr[1] & DefaultBinaryMemcacheRequest.REQUEST_MAGIC_BYTE) == 0 || (bArr[2] & 255) + 3 != bArr.length))) {
            Buffer buffer = new Buffer(bArr);
            buffer.getString();
            buffer.getInt();
            byte[] mPInt = buffer.getMPInt();
            byte[] mPInt2 = buffer.getMPInt();
            byte[] insert0 = insert0(mPInt);
            byte[] insert02 = insert0(mPInt2);
            if (insert0.length < 64) {
                bArr = new byte[insert0.length + 6 + insert02.length];
                bArr[0] = 48;
                bArr[1] = (byte) (insert0.length + 4 + insert02.length);
                bArr[2] = 2;
                bArr[3] = (byte) insert0.length;
                System.arraycopy(insert0, 0, bArr, 4, insert0.length);
                bArr[insert0.length + 4] = 2;
                bArr[insert0.length + 5] = (byte) insert02.length;
                System.arraycopy(insert02, 0, bArr, insert0.length + 6, insert02.length);
            } else {
                bArr = new byte[insert0.length + 6 + insert02.length + 1];
                bArr[0] = 48;
                bArr[1] = DefaultBinaryMemcacheResponse.RESPONSE_MAGIC_BYTE;
                bArr[2] = (byte) (insert0.length + 4 + insert02.length);
                bArr[3] = 2;
                bArr[4] = (byte) insert0.length;
                System.arraycopy(insert0, 0, bArr, 5, insert0.length);
                bArr[insert0.length + 5] = 2;
                bArr[insert0.length + 6] = (byte) insert02.length;
                System.arraycopy(insert02, 0, bArr, insert0.length + 7, insert02.length);
            }
        }
        return this.signature.verify(bArr);
    }
}
