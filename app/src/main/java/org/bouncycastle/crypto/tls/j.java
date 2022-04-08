package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.l2.a;

/* loaded from: classes4.dex */
public class j {
    protected short a;

    /* renamed from: b  reason: collision with root package name */
    protected Object f17245b;

    public j(short s, Object obj) {
        if (a(s, obj)) {
            this.a = s;
            this.f17245b = obj;
            return;
        }
        throw new IllegalArgumentException("'response' is not an instance of the correct type");
    }

    protected static boolean a(short s, Object obj) {
        if (s == 1) {
            return obj instanceof a;
        }
        throw new IllegalArgumentException("'statusType' is an unsupported CertificateStatusType");
    }

    public static j b(InputStream inputStream) throws IOException {
        short j0 = m1.j0(inputStream);
        if (j0 == 1) {
            return new j(j0, a.f(m1.Y(m1.b0(inputStream))));
        }
        throw new TlsFatalAlert((short) 50);
    }
}
