package org.bouncycastle.jcajce.a;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.g2.a;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.m2.b;
import org.bouncycastle.asn1.n2.g;

/* loaded from: classes4.dex */
public class d {
    private static Map<m, String> a;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put(g.h0, "MD2");
        a.put(g.i0, "MD4");
        a.put(g.j0, "MD5");
        a.put(b.i, "SHA-1");
        a.put(org.bouncycastle.asn1.j2.b.f16783f, "SHA-224");
        a.put(org.bouncycastle.asn1.j2.b.f16780c, "SHA-256");
        a.put(org.bouncycastle.asn1.j2.b.f16781d, "SHA-384");
        a.put(org.bouncycastle.asn1.j2.b.f16782e, "SHA-512");
        a.put(org.bouncycastle.asn1.q2.b.f16874c, "RIPEMD-128");
        a.put(org.bouncycastle.asn1.q2.b.f16873b, "RIPEMD-160");
        a.put(org.bouncycastle.asn1.q2.b.f16875d, "RIPEMD-128");
        a.put(a.f16754d, "RIPEMD-128");
        a.put(a.f16753c, "RIPEMD-160");
        a.put(org.bouncycastle.asn1.d2.a.f16710b, "GOST3411");
        a.put(org.bouncycastle.asn1.f2.a.g, "Tiger");
        a.put(a.f16755e, "Whirlpool");
        a.put(org.bouncycastle.asn1.j2.b.i, "SHA3-224");
        a.put(org.bouncycastle.asn1.j2.b.j, "SHA3-256");
        a.put(org.bouncycastle.asn1.j2.b.k, "SHA3-384");
        a.put(org.bouncycastle.asn1.j2.b.l, "SHA3-512");
        a.put(org.bouncycastle.asn1.e2.b.b0, "SM3");
    }

    public static String a(m mVar) {
        String str = a.get(mVar);
        return str != null ? str : mVar.q();
    }
}
