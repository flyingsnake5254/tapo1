package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.engines.h;
import org.bouncycastle.crypto.r.a;
import org.bouncycastle.crypto.w.c0;
import org.bouncycastle.crypto.w.d0;

/* loaded from: classes4.dex */
public class h1 {
    public static byte[] a(p0 p0Var, d0 d0Var, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[48];
        p0Var.c().nextBytes(bArr);
        m1.O0(p0Var.a(), bArr, 0);
        a aVar = new a(new h());
        aVar.a(true, new c0(d0Var, p0Var.c()));
        try {
            byte[] d2 = aVar.d(bArr, 0, 48);
            if (m1.K(p0Var)) {
                outputStream.write(d2);
            } else {
                m1.t0(d2, outputStream);
            }
            return bArr;
        } catch (InvalidCipherTextException e2) {
            throw new TlsFatalAlert((short) 80, e2);
        }
    }
}
