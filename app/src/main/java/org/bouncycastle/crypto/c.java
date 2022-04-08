package org.bouncycastle.crypto;

/* loaded from: classes4.dex */
public interface c {
    void a(boolean z, e eVar) throws IllegalArgumentException;

    String b();

    int d(byte[] bArr, int i, byte[] bArr2, int i2) throws DataLengthException, IllegalStateException;

    int getBlockSize();

    void reset();
}
