package org.bouncycastle.jcajce.provider.asymmetric.util;

import e.a.b.a.h;
import java.math.BigInteger;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.u2.e;
import org.bouncycastle.asn1.u2.j;
import org.bouncycastle.crypto.w.n;
import org.bouncycastle.crypto.w.q;
import org.bouncycastle.jce.spec.d;
import org.bouncycastle.util.a;
import org.bouncycastle.util.c;
import org.bouncycastle.util.i;

/* loaded from: classes4.dex */
public class b {
    private static h a(BigInteger bigInteger, d dVar) {
        return dVar.b().y(bigInteger).A();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int[] b(int[] iArr) {
        int[] iArr2 = new int[3];
        if (iArr.length == 1) {
            iArr2[0] = iArr[0];
        } else if (iArr.length != 3) {
            throw new IllegalArgumentException("Only Trinomials and pentanomials supported");
        } else if (iArr[0] < iArr[1] && iArr[0] < iArr[2]) {
            iArr2[0] = iArr[0];
            if (iArr[1] < iArr[2]) {
                iArr2[1] = iArr[1];
                iArr2[2] = iArr[2];
            } else {
                iArr2[1] = iArr[2];
                iArr2[2] = iArr[1];
            }
        } else if (iArr[1] < iArr[2]) {
            iArr2[0] = iArr[1];
            if (iArr[0] < iArr[2]) {
                iArr2[1] = iArr[0];
                iArr2[2] = iArr[2];
            } else {
                iArr2[1] = iArr[2];
                iArr2[2] = iArr[0];
            }
        } else {
            iArr2[0] = iArr[2];
            if (iArr[0] < iArr[1]) {
                iArr2[1] = iArr[0];
                iArr2[2] = iArr[1];
            } else {
                iArr2[1] = iArr[1];
                iArr2[2] = iArr[0];
            }
        }
        return iArr2;
    }

    public static String c(h hVar, d dVar) {
        e.a.b.a.d a = dVar.a();
        return a != null ? new c(a.n(hVar.l(false), a.o().e(), a.p().e(), dVar.b().l(false))).toString() : new c(hVar.l(false)).toString();
    }

    public static String d(m mVar) {
        return e.d(mVar);
    }

    public static n e(org.bouncycastle.jcajce.provider.config.b bVar, org.bouncycastle.asn1.u2.h hVar) {
        n nVar;
        if (hVar.i()) {
            m r = m.r(hVar.g());
            j g = g(r);
            if (g == null) {
                g = (j) bVar.a().get(r);
            }
            return new q(r, g.f(), g.g(), g.j(), g.h(), g.k());
        }
        if (hVar.h()) {
            d b2 = bVar.b();
            nVar = new n(b2.a(), b2.b(), b2.d(), b2.c(), b2.e());
        } else {
            j i = j.i(hVar.g());
            nVar = new n(i.f(), i.g(), i.j(), i.h(), i.k());
        }
        return nVar;
    }

    public static n f(org.bouncycastle.jcajce.provider.config.b bVar, d dVar) {
        if (dVar instanceof org.bouncycastle.jce.spec.b) {
            org.bouncycastle.jce.spec.b bVar2 = (org.bouncycastle.jce.spec.b) dVar;
            return new q(h(bVar2.f()), bVar2.a(), bVar2.b(), bVar2.d(), bVar2.c(), bVar2.e());
        } else if (dVar != null) {
            return new n(dVar.a(), dVar.b(), dVar.d(), dVar.c(), dVar.e());
        } else {
            d b2 = bVar.b();
            return new n(b2.a(), b2.b(), b2.d(), b2.c(), b2.e());
        }
    }

    public static j g(m mVar) {
        j i = org.bouncycastle.crypto.q.a.i(mVar);
        return i == null ? e.c(mVar) : i;
    }

    public static m h(String str) {
        int indexOf = str.indexOf(32);
        if (indexOf > 0) {
            str = str.substring(indexOf + 1);
        }
        try {
            if (str.charAt(0) >= '0' && str.charAt(0) <= '2') {
                return new m(str);
            }
        } catch (IllegalArgumentException unused) {
        }
        return e.e(str);
    }

    public static int i(org.bouncycastle.jcajce.provider.config.b bVar, BigInteger bigInteger, BigInteger bigInteger2) {
        if (bigInteger != null) {
            return bigInteger.bitLength();
        }
        d b2 = bVar.b();
        return b2 == null ? bigInteger2.bitLength() : b2.d().bitLength();
    }

    public static String j(String str, BigInteger bigInteger, d dVar) {
        StringBuffer stringBuffer = new StringBuffer();
        String d2 = i.d();
        h a = a(bigInteger, dVar);
        stringBuffer.append(str);
        stringBuffer.append(" Private Key [");
        stringBuffer.append(c(a, dVar));
        stringBuffer.append("]");
        stringBuffer.append(d2);
        stringBuffer.append("            X: ");
        stringBuffer.append(a.f().t().toString(16));
        stringBuffer.append(d2);
        stringBuffer.append("            Y: ");
        stringBuffer.append(a.g().t().toString(16));
        stringBuffer.append(d2);
        return stringBuffer.toString();
    }

    public static String k(String str, h hVar, d dVar) {
        StringBuffer stringBuffer = new StringBuffer();
        String d2 = i.d();
        stringBuffer.append(str);
        stringBuffer.append(" Public Key [");
        stringBuffer.append(c(hVar, dVar));
        stringBuffer.append("]");
        stringBuffer.append(d2);
        stringBuffer.append("            X: ");
        stringBuffer.append(hVar.f().t().toString(16));
        stringBuffer.append(d2);
        stringBuffer.append("            Y: ");
        stringBuffer.append(hVar.g().t().toString(16));
        stringBuffer.append(d2);
        return stringBuffer.toString();
    }
}
