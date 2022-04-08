package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes4.dex */
public class y0 implements o {

    /* renamed from: c  reason: collision with root package name */
    private r1 f17050c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y0(r1 r1Var) {
        this.f17050c = r1Var;
    }

    @Override // org.bouncycastle.asn1.o
    public InputStream a() {
        return this.f17050c;
    }

    @Override // org.bouncycastle.asn1.s1
    public q b() throws IOException {
        return new x0(this.f17050c.e());
    }

    @Override // org.bouncycastle.asn1.e
    public q c() {
        try {
            return b();
        } catch (IOException e2) {
            throw new ASN1ParsingException("IOException converting stream to byte array: " + e2.getMessage(), e2);
        }
    }
}
