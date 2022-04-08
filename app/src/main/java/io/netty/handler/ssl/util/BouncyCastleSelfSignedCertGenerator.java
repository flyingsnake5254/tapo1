package io.netty.handler.ssl.util;

import java.math.BigInteger;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Date;
import org.bouncycastle.asn1.t2.c;
import org.bouncycastle.cert.jcajce.d;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.e.a;

/* loaded from: classes3.dex */
final class BouncyCastleSelfSignedCertGenerator {
    private static final Provider PROVIDER = new BouncyCastleProvider();

    private BouncyCastleSelfSignedCertGenerator() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String[] generate(String str, KeyPair keyPair, SecureRandom secureRandom, Date date, Date date2, String str2) throws Exception {
        PrivateKey privateKey = keyPair.getPrivate();
        c cVar = new c("CN=" + str);
        X509Certificate a = new org.bouncycastle.cert.jcajce.c().b(PROVIDER).a(new d(cVar, new BigInteger(64, secureRandom), date, date2, cVar, keyPair.getPublic()).a(new a(str2.equalsIgnoreCase("EC") ? "SHA256withECDSA" : "SHA256WithRSAEncryption").a(privateKey)));
        a.verify(keyPair.getPublic());
        return SelfSignedCertificate.newSelfSignedCertificate(str, privateKey, a);
    }
}
