package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes4.dex */
public class z0 extends p {
    public z0(OutputStream outputStream) {
        super(outputStream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.p
    public p a() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.p
    public p b() {
        return this;
    }

    @Override // org.bouncycastle.asn1.p
    public void j(e eVar) throws IOException {
        if (eVar != null) {
            eVar.c().k().g(this);
            return;
        }
        throw new IOException("null object detected");
    }
}
