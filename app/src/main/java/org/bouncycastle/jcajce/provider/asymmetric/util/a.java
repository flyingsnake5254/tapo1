package org.bouncycastle.jcajce.provider.asymmetric.util;

import e.a.b.a.b;
import e.a.b.a.d;
import e.a.b.a.h;
import e.a.b.b.f;
import java.math.BigInteger;
import java.security.spec.ECField;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.u2.e;
import org.bouncycastle.asn1.u2.j;
import org.bouncycastle.crypto.w.n;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.c;

/* loaded from: classes4.dex */
public class a {
    private static Map a = new HashMap();

    static {
        Enumeration j = org.bouncycastle.crypto.q.a.j();
        while (j.hasMoreElements()) {
            String str = (String) j.nextElement();
            j b2 = e.b(str);
            if (b2 != null) {
                a.put(b2.f(), org.bouncycastle.crypto.q.a.h(str).f());
            }
        }
        j h = org.bouncycastle.crypto.q.a.h("Curve25519");
        a.put(new d.f(h.f().s().b(), h.f().o().t(), h.f().p().t()), h.f());
    }

    public static EllipticCurve a(d dVar, byte[] bArr) {
        return new EllipticCurve(c(dVar.s()), dVar.o().t(), dVar.p().t(), null);
    }

    public static d b(EllipticCurve ellipticCurve) {
        ECField field = ellipticCurve.getField();
        BigInteger a2 = ellipticCurve.getA();
        BigInteger b2 = ellipticCurve.getB();
        if (field instanceof ECFieldFp) {
            d.f fVar = new d.f(((ECFieldFp) field).getP(), a2, b2);
            return a.containsKey(fVar) ? (d) a.get(fVar) : fVar;
        }
        ECFieldF2m eCFieldF2m = (ECFieldF2m) field;
        int m = eCFieldF2m.getM();
        int[] b3 = b.b(eCFieldF2m.getMidTermsOfReductionPolynomial());
        return new d.e(m, b3[0], b3[1], b3[2], a2, b2);
    }

    public static ECField c(e.a.b.b.a aVar) {
        if (b.j(aVar)) {
            return new ECFieldFp(aVar.b());
        }
        e.a.b.b.e c2 = ((f) aVar).c();
        int[] a2 = c2.a();
        return new ECFieldF2m(c2.b(), org.bouncycastle.util.a.F(org.bouncycastle.util.a.t(a2, 1, a2.length - 1)));
    }

    public static ECPoint d(h hVar) {
        h A = hVar.A();
        return new ECPoint(A.f().t(), A.g().t());
    }

    public static h e(ECParameterSpec eCParameterSpec, ECPoint eCPoint, boolean z) {
        return f(b(eCParameterSpec.getCurve()), eCPoint, z);
    }

    public static h f(d dVar, ECPoint eCPoint, boolean z) {
        return dVar.g(eCPoint.getAffineX(), eCPoint.getAffineY());
    }

    public static ECParameterSpec g(EllipticCurve ellipticCurve, org.bouncycastle.jce.spec.d dVar) {
        return dVar instanceof org.bouncycastle.jce.spec.b ? new c(((org.bouncycastle.jce.spec.b) dVar).f(), ellipticCurve, d(dVar.b()), dVar.d(), dVar.c()) : new ECParameterSpec(ellipticCurve, d(dVar.b()), dVar.d(), dVar.c().intValue());
    }

    public static org.bouncycastle.jce.spec.d h(ECParameterSpec eCParameterSpec, boolean z) {
        d b2 = b(eCParameterSpec.getCurve());
        return new org.bouncycastle.jce.spec.d(b2, f(b2, eCParameterSpec.getGenerator(), z), eCParameterSpec.getOrder(), BigInteger.valueOf(eCParameterSpec.getCofactor()), eCParameterSpec.getCurve().getSeed());
    }

    public static ECParameterSpec i(org.bouncycastle.asn1.u2.h hVar, d dVar) {
        if (hVar.i()) {
            m mVar = (m) hVar.g();
            j g = b.g(mVar);
            if (g == null) {
                Map a2 = BouncyCastleProvider.CONFIGURATION.a();
                if (!a2.isEmpty()) {
                    g = (j) a2.get(mVar);
                }
            }
            return new c(b.d(mVar), a(dVar, g.k()), d(g.g()), g.j(), g.h());
        } else if (hVar.h()) {
            return null;
        } else {
            j i = j.i(hVar.g());
            EllipticCurve a3 = a(dVar, i.k());
            return i.h() != null ? new ECParameterSpec(a3, d(i.g()), i.j(), i.h().intValue()) : new ECParameterSpec(a3, d(i.g()), i.j(), 1);
        }
    }

    public static d j(org.bouncycastle.jcajce.provider.config.b bVar, org.bouncycastle.asn1.u2.h hVar) {
        Set c2 = bVar.c();
        if (hVar.i()) {
            m r = m.r(hVar.g());
            if (c2.isEmpty() || c2.contains(r)) {
                j g = b.g(r);
                if (g == null) {
                    g = (j) bVar.a().get(r);
                }
                return g.f();
            }
            throw new IllegalStateException("named curve not acceptable");
        } else if (hVar.h()) {
            return bVar.b().a();
        } else {
            if (c2.isEmpty()) {
                return j.i(hVar.g()).f();
            }
            throw new IllegalStateException("encoded parameters not acceptable");
        }
    }

    public static n k(org.bouncycastle.jcajce.provider.config.b bVar, ECParameterSpec eCParameterSpec) {
        if (eCParameterSpec != null) {
            return b.f(bVar, h(eCParameterSpec, false));
        }
        org.bouncycastle.jce.spec.d b2 = bVar.b();
        return new n(b2.a(), b2.b(), b2.d(), b2.c(), b2.e());
    }
}
