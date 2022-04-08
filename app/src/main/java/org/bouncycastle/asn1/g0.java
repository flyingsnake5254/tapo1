package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

/* loaded from: classes4.dex */
public class g0 extends t {
    public g0() {
    }

    public g0(e eVar) {
        super(eVar);
    }

    public g0(f fVar) {
        super(fVar, false);
    }

    public g0(e[] eVarArr) {
        super(eVarArr, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public void g(p pVar) throws IOException {
        pVar.c(49);
        pVar.c(128);
        Enumeration r = r();
        while (r.hasMoreElements()) {
            pVar.j((e) r.nextElement());
        }
        pVar.c(0);
        pVar.c(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public int h() throws IOException {
        Enumeration r = r();
        int i = 0;
        while (r.hasMoreElements()) {
            i += ((e) r.nextElement()).c().h();
        }
        return i + 2 + 2;
    }
}
