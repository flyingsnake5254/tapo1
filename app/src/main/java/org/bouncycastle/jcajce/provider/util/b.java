package org.bouncycastle.jcajce.provider.util;

import java.io.IOException;
import java.security.PrivateKey;
import java.security.PublicKey;
import org.bouncycastle.asn1.n2.h;
import org.bouncycastle.asn1.x509.w;

/* loaded from: classes4.dex */
public interface b {
    PrivateKey a(h hVar) throws IOException;

    PublicKey b(w wVar) throws IOException;
}
