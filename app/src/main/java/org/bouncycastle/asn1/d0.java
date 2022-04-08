package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.util.io.b;

/* loaded from: classes4.dex */
public class d0 implements o {

    /* renamed from: c  reason: collision with root package name */
    private v f16708c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d0(v vVar) {
        this.f16708c = vVar;
    }

    @Override // org.bouncycastle.asn1.o
    public InputStream a() {
        return new k0(this.f16708c);
    }

    @Override // org.bouncycastle.asn1.s1
    public q b() throws IOException {
        return new c0(b.b(a()));
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
