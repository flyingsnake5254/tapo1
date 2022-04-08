package org.bouncycastle.operator;

import java.io.OutputStream;

/* loaded from: classes4.dex */
public interface b {
    OutputStream getOutputStream();

    boolean verify(byte[] bArr);
}
