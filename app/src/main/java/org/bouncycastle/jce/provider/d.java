package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.PSSParameterSpec;
import org.bouncycastle.asn1.d2.a;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.k;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.m2.b;
import org.bouncycastle.asn1.n2.g;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.u2.p;
import org.bouncycastle.asn1.v0;

/* loaded from: classes4.dex */
class d {
    private static final k a = v0.f16957c;

    private static String a(m mVar) {
        return g.j0.equals(mVar) ? "MD5" : b.i.equals(mVar) ? "SHA1" : org.bouncycastle.asn1.j2.b.f16783f.equals(mVar) ? "SHA224" : org.bouncycastle.asn1.j2.b.f16780c.equals(mVar) ? "SHA256" : org.bouncycastle.asn1.j2.b.f16781d.equals(mVar) ? "SHA384" : org.bouncycastle.asn1.j2.b.f16782e.equals(mVar) ? "SHA512" : org.bouncycastle.asn1.q2.b.f16874c.equals(mVar) ? "RIPEMD128" : org.bouncycastle.asn1.q2.b.f16873b.equals(mVar) ? "RIPEMD160" : org.bouncycastle.asn1.q2.b.f16875d.equals(mVar) ? "RIPEMD256" : a.f16710b.equals(mVar) ? "GOST3411" : mVar.q();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(org.bouncycastle.asn1.x509.a aVar) {
        e i = aVar.i();
        if (i != null && !a.equals(i)) {
            if (aVar.f().equals(g.K)) {
                org.bouncycastle.asn1.n2.k g = org.bouncycastle.asn1.n2.k.g(i);
                return a(g.f().f()) + "withRSAandMGF1";
            } else if (aVar.f().equals(p.C2)) {
                r m = r.m(i);
                return a(m.r(m.p(0))) + "withECDSA";
            }
        }
        return aVar.f().q();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(Signature signature, e eVar) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        if (eVar != null && !a.equals(eVar)) {
            AlgorithmParameters instance = AlgorithmParameters.getInstance(signature.getAlgorithm(), signature.getProvider());
            try {
                instance.init(eVar.c().d());
                if (signature.getAlgorithm().endsWith("MGF1")) {
                    try {
                        signature.setParameter(instance.getParameterSpec(PSSParameterSpec.class));
                    } catch (GeneralSecurityException e2) {
                        throw new SignatureException("Exception extracting parameters: " + e2.getMessage());
                    }
                }
            } catch (IOException e3) {
                throw new SignatureException("IOException decoding parameters: " + e3.getMessage());
            }
        }
    }
}
