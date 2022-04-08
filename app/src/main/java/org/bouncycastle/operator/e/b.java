package org.bouncycastle.operator.e;

import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.spec.PSSParameterSpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.d2.a;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.n2.g;
import org.bouncycastle.asn1.n2.k;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.u2.p;
import org.bouncycastle.asn1.v0;
import org.bouncycastle.jcajce.a.c;
import org.bouncycastle.util.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class b {
    private static final Map a;

    /* renamed from: b  reason: collision with root package name */
    private static final Map f17439b;

    /* renamed from: c  reason: collision with root package name */
    private static final Map f17440c;

    /* renamed from: d  reason: collision with root package name */
    private static final Map f17441d;

    /* renamed from: e  reason: collision with root package name */
    private static final Map f17442e;

    /* renamed from: f  reason: collision with root package name */
    private c f17443f;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        HashMap hashMap2 = new HashMap();
        f17439b = hashMap2;
        HashMap hashMap3 = new HashMap();
        f17440c = hashMap3;
        HashMap hashMap4 = new HashMap();
        f17441d = hashMap4;
        HashMap hashMap5 = new HashMap();
        f17442e = hashMap5;
        hashMap.put(new m("1.2.840.113549.1.1.5"), "SHA1WITHRSA");
        hashMap.put(g.O, "SHA224WITHRSA");
        hashMap.put(g.L, "SHA256WITHRSA");
        hashMap.put(g.M, "SHA384WITHRSA");
        hashMap.put(g.N, "SHA512WITHRSA");
        hashMap.put(a.n, "GOST3411WITHGOST3410");
        hashMap.put(a.o, "GOST3411WITHECGOST3410");
        hashMap.put(org.bouncycastle.asn1.o2.a.i, "GOST3411-2012-256WITHECGOST3410-2012-256");
        hashMap.put(org.bouncycastle.asn1.o2.a.j, "GOST3411-2012-512WITHECGOST3410-2012-512");
        hashMap.put(org.bouncycastle.asn1.b2.a.f16696d, "SHA1WITHPLAIN-ECDSA");
        hashMap.put(org.bouncycastle.asn1.b2.a.f16697e, "SHA224WITHPLAIN-ECDSA");
        hashMap.put(org.bouncycastle.asn1.b2.a.f16698f, "SHA256WITHPLAIN-ECDSA");
        hashMap.put(org.bouncycastle.asn1.b2.a.g, "SHA384WITHPLAIN-ECDSA");
        hashMap.put(org.bouncycastle.asn1.b2.a.h, "SHA512WITHPLAIN-ECDSA");
        hashMap.put(org.bouncycastle.asn1.b2.a.i, "RIPEMD160WITHPLAIN-ECDSA");
        hashMap.put(org.bouncycastle.asn1.eac.a.s, "SHA1WITHCVC-ECDSA");
        hashMap.put(org.bouncycastle.asn1.eac.a.t, "SHA224WITHCVC-ECDSA");
        hashMap.put(org.bouncycastle.asn1.eac.a.u, "SHA256WITHCVC-ECDSA");
        hashMap.put(org.bouncycastle.asn1.eac.a.v, "SHA384WITHCVC-ECDSA");
        hashMap.put(org.bouncycastle.asn1.eac.a.w, "SHA512WITHCVC-ECDSA");
        hashMap.put(new m("1.2.840.113549.1.1.4"), "MD5WITHRSA");
        hashMap.put(new m("1.2.840.113549.1.1.2"), "MD2WITHRSA");
        hashMap.put(new m("1.2.840.10040.4.3"), "SHA1WITHDSA");
        hashMap.put(p.z2, "SHA1WITHECDSA");
        hashMap.put(p.D2, "SHA224WITHECDSA");
        hashMap.put(p.E2, "SHA256WITHECDSA");
        hashMap.put(p.F2, "SHA384WITHECDSA");
        hashMap.put(p.G2, "SHA512WITHECDSA");
        hashMap.put(org.bouncycastle.asn1.m2.b.k, "SHA1WITHRSA");
        hashMap.put(org.bouncycastle.asn1.m2.b.j, "SHA1WITHDSA");
        hashMap.put(org.bouncycastle.asn1.j2.b.T, "SHA224WITHDSA");
        hashMap.put(org.bouncycastle.asn1.j2.b.U, "SHA256WITHDSA");
        hashMap.put(org.bouncycastle.asn1.m2.b.i, "SHA1");
        hashMap.put(org.bouncycastle.asn1.j2.b.f16783f, "SHA224");
        hashMap.put(org.bouncycastle.asn1.j2.b.f16780c, "SHA256");
        hashMap.put(org.bouncycastle.asn1.j2.b.f16781d, "SHA384");
        hashMap.put(org.bouncycastle.asn1.j2.b.f16782e, "SHA512");
        hashMap.put(org.bouncycastle.asn1.q2.b.f16874c, "RIPEMD128");
        hashMap.put(org.bouncycastle.asn1.q2.b.f16873b, "RIPEMD160");
        hashMap.put(org.bouncycastle.asn1.q2.b.f16875d, "RIPEMD256");
        hashMap2.put(g.B, "RSA/ECB/PKCS1Padding");
        hashMap2.put(a.m, "ECGOST3410");
        m mVar = g.m2;
        hashMap3.put(mVar, "DESEDEWrap");
        hashMap3.put(g.n2, "RC2Wrap");
        m mVar2 = org.bouncycastle.asn1.j2.b.x;
        hashMap3.put(mVar2, "AESWrap");
        m mVar3 = org.bouncycastle.asn1.j2.b.F;
        hashMap3.put(mVar3, "AESWrap");
        m mVar4 = org.bouncycastle.asn1.j2.b.N;
        hashMap3.put(mVar4, "AESWrap");
        m mVar5 = org.bouncycastle.asn1.k2.a.f16790d;
        hashMap3.put(mVar5, "CamelliaWrap");
        m mVar6 = org.bouncycastle.asn1.k2.a.f16791e;
        hashMap3.put(mVar6, "CamelliaWrap");
        m mVar7 = org.bouncycastle.asn1.k2.a.f16792f;
        hashMap3.put(mVar7, "CamelliaWrap");
        m mVar8 = org.bouncycastle.asn1.h2.a.f16761d;
        hashMap3.put(mVar8, "SEEDWrap");
        m mVar9 = g.d0;
        hashMap3.put(mVar9, "DESede");
        hashMap5.put(mVar, d.b(192));
        hashMap5.put(mVar2, d.b(128));
        hashMap5.put(mVar3, d.b(192));
        hashMap5.put(mVar4, d.b(256));
        hashMap5.put(mVar5, d.b(128));
        hashMap5.put(mVar6, d.b(192));
        hashMap5.put(mVar7, d.b(256));
        hashMap5.put(mVar8, d.b(128));
        hashMap5.put(mVar9, d.b(192));
        hashMap4.put(org.bouncycastle.asn1.j2.b.s, "AES");
        Map map = f17441d;
        map.put(org.bouncycastle.asn1.j2.b.u, "AES");
        map.put(org.bouncycastle.asn1.j2.b.C, "AES");
        map.put(org.bouncycastle.asn1.j2.b.K, "AES");
        map.put(mVar9, "DESede");
        map.put(g.e0, "RC2");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(c cVar) {
        this.f17443f = cVar;
    }

    private static String c(m mVar) {
        String a2 = org.bouncycastle.jcajce.a.d.a(mVar);
        int indexOf = a2.indexOf(45);
        if (indexOf <= 0 || a2.startsWith("SHA3")) {
            return org.bouncycastle.jcajce.a.d.a(mVar);
        }
        return a2.substring(0, indexOf) + a2.substring(indexOf + 1);
    }

    private static String d(org.bouncycastle.asn1.x509.a aVar) {
        e i = aVar.i();
        if (i == null || v0.f16957c.equals(i) || !aVar.f().equals(g.K)) {
            Map map = a;
            boolean containsKey = map.containsKey(aVar.f());
            m f2 = aVar.f();
            return containsKey ? (String) map.get(f2) : f2.q();
        }
        k g = k.g(i);
        return c(g.f().f()) + "WITHRSAANDMGF1";
    }

    private boolean e(r rVar) throws GeneralSecurityException {
        if (rVar == null || rVar.size() == 0) {
            return false;
        }
        k g = k.g(rVar);
        if (!g.h().f().equals(g.I) || !g.f().equals(org.bouncycastle.asn1.x509.a.g(g.h().i()))) {
            return true;
        }
        return g.i().intValue() != a(g.f()).getDigestLength();
    }

    MessageDigest a(org.bouncycastle.asn1.x509.a aVar) throws GeneralSecurityException {
        try {
            return this.f17443f.d(org.bouncycastle.jcajce.a.d.a(aVar.f()));
        } catch (NoSuchAlgorithmException e2) {
            Map map = a;
            if (map.get(aVar.f()) != null) {
                return this.f17443f.d((String) map.get(aVar.f()));
            }
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Signature b(org.bouncycastle.asn1.x509.a aVar) throws GeneralSecurityException {
        Signature signature;
        try {
            signature = this.f17443f.b(d(aVar));
        } catch (NoSuchAlgorithmException e2) {
            Map map = a;
            if (map.get(aVar.f()) != null) {
                signature = this.f17443f.b((String) map.get(aVar.f()));
            } else {
                throw e2;
            }
        }
        if (aVar.f().equals(g.K)) {
            r m = r.m(aVar.i());
            if (e(m)) {
                try {
                    AlgorithmParameters e3 = this.f17443f.e("PSS");
                    e3.init(m.d());
                    signature.setParameter(e3.getParameterSpec(PSSParameterSpec.class));
                } catch (IOException e4) {
                    throw new GeneralSecurityException("unable to process PSS parameters: " + e4.getMessage());
                }
            }
        }
        return signature;
    }
}
