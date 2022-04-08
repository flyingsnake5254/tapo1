package org.bouncycastle.crypto.u;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.e;

/* loaded from: classes4.dex */
public interface a {
    void a(boolean z, e eVar) throws IllegalArgumentException;

    int b(int i);

    int c(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException;

    int doFinal(byte[] bArr, int i) throws IllegalStateException, InvalidCipherTextException;
}
