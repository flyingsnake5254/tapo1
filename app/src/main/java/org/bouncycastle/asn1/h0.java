package org.bouncycastle.asn1;

import java.io.IOException;

/* loaded from: classes4.dex */
public class h0 implements u {

    /* renamed from: c  reason: collision with root package name */
    private v f16758c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h0(v vVar) {
        this.f16758c = vVar;
    }

    @Override // org.bouncycastle.asn1.s1
    public q b() throws IOException {
        return new g0(this.f16758c.d());
    }

    @Override // org.bouncycastle.asn1.e
    public q c() {
        try {
            return b();
        } catch (IOException e2) {
            throw new ASN1ParsingException(e2.getMessage(), e2);
        }
    }
}
