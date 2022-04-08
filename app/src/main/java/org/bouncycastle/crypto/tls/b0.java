package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.crypto.w.e;
import org.bouncycastle.crypto.w.g;

/* loaded from: classes4.dex */
public class b0 {
    protected g a;

    public b0(g gVar) {
        if (gVar != null) {
            this.a = gVar;
            return;
        }
        throw new IllegalArgumentException("'publicKey' cannot be null");
    }

    public static b0 b(InputStream inputStream) throws IOException {
        return new b0(r0.h(new g(r0.f(inputStream), new e(r0.f(inputStream), r0.f(inputStream)))));
    }

    public g a() {
        return this.a;
    }
}
