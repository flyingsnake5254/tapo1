package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes4.dex */
public class v {
    protected long a;

    /* renamed from: b  reason: collision with root package name */
    protected byte[] f17280b;

    public v(long j, byte[] bArr) {
        this.a = j;
        this.f17280b = bArr;
    }

    public static v a(InputStream inputStream) throws IOException {
        return new v(m1.i0(inputStream), m1.a0(inputStream));
    }
}
