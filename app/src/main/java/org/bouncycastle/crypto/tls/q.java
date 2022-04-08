package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes4.dex */
public class q {
    protected d0 a;

    /* renamed from: b  reason: collision with root package name */
    protected byte[] f17267b;

    public q(d0 d0Var, byte[] bArr) {
        if (bArr != null) {
            this.a = d0Var;
            this.f17267b = bArr;
            return;
        }
        throw new IllegalArgumentException("'signature' cannot be null");
    }

    public void a(OutputStream outputStream) throws IOException {
        d0 d0Var = this.a;
        if (d0Var != null) {
            d0Var.a(outputStream);
        }
        m1.t0(this.f17267b, outputStream);
    }
}
