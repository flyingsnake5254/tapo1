package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

/* loaded from: classes4.dex */
public class e0 extends r {
    public e0() {
    }

    public e0(e eVar) {
        super(eVar);
    }

    public e0(f fVar) {
        super(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public void g(p pVar) throws IOException {
        pVar.c(48);
        pVar.c(128);
        Enumeration q = q();
        while (q.hasMoreElements()) {
            pVar.j((e) q.nextElement());
        }
        pVar.c(0);
        pVar.c(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public int h() throws IOException {
        Enumeration q = q();
        int i = 0;
        while (q.hasMoreElements()) {
            i += ((e) q.nextElement()).c().h();
        }
        return i + 2 + 2;
    }
}
