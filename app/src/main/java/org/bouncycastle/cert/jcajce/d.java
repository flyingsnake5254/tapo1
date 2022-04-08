package org.bouncycastle.cert.jcajce;

import java.math.BigInteger;
import java.security.PublicKey;
import java.util.Date;
import org.bouncycastle.asn1.t2.c;
import org.bouncycastle.asn1.x509.w;
import org.bouncycastle.cert.e;

/* loaded from: classes4.dex */
public class d extends e {
    public d(c cVar, BigInteger bigInteger, Date date, Date date2, c cVar2, PublicKey publicKey) {
        super(cVar, bigInteger, date, date2, cVar2, w.h(publicKey.getEncoded()));
    }
}
