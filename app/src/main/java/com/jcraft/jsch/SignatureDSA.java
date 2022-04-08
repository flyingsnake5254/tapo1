package com.jcraft.jsch;

/* loaded from: classes2.dex */
public interface SignatureDSA extends Signature {
    void setPrvKey(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) throws Exception;

    void setPubKey(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) throws Exception;
}
