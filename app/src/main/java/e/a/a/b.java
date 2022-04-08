package e.a.a;

import java.io.IOException;
import java.security.Principal;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.t2.c;
import org.bouncycastle.asn1.x509.d0;

/* loaded from: classes4.dex */
public class b extends d0 implements Principal {
    public b(c cVar) {
        super((r) cVar.c());
    }

    @Override // org.bouncycastle.asn1.l
    public byte[] d() {
        try {
            return e("DER");
        } catch (IOException e2) {
            throw new RuntimeException(e2.toString());
        }
    }

    @Override // java.security.Principal
    public String getName() {
        return toString();
    }
}
