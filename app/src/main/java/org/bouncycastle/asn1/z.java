package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes4.dex */
public class z extends a {
    public z(int i, f fVar) {
        super(true, i, r(fVar));
    }

    private static byte[] r(f fVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i != fVar.c(); i++) {
            try {
                byteArrayOutputStream.write(((l) fVar.b(i)).e("BER"));
            } catch (IOException e2) {
                throw new ASN1ParsingException("malformed object: " + e2, e2);
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.a, org.bouncycastle.asn1.q
    public void g(p pVar) throws IOException {
        pVar.k(this.f16678c ? 96 : 64, this.f16679d);
        pVar.c(128);
        pVar.d(this.f16680f);
        pVar.c(0);
        pVar.c(0);
    }
}
