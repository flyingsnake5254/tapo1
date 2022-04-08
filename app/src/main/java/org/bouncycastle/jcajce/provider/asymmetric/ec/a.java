package org.bouncycastle.jcajce.provider.asymmetric.ec;

import e.a.b.a.d;
import java.math.BigInteger;
import java.security.spec.ECParameterSpec;
import org.bouncycastle.asn1.k;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.u2.h;
import org.bouncycastle.asn1.u2.j;
import org.bouncycastle.asn1.v0;
import org.bouncycastle.jcajce.provider.asymmetric.util.b;
import org.bouncycastle.jce.spec.c;

/* loaded from: classes4.dex */
class a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static h a(ECParameterSpec eCParameterSpec, boolean z) {
        if (eCParameterSpec instanceof c) {
            c cVar = (c) eCParameterSpec;
            m h = b.h(cVar.a());
            if (h == null) {
                h = new m(cVar.a());
            }
            return new h(h);
        } else if (eCParameterSpec == null) {
            return new h((k) v0.f16957c);
        } else {
            d b2 = org.bouncycastle.jcajce.provider.asymmetric.util.a.b(eCParameterSpec.getCurve());
            return new h(new j(b2, org.bouncycastle.jcajce.provider.asymmetric.util.a.f(b2, eCParameterSpec.getGenerator(), z), eCParameterSpec.getOrder(), BigInteger.valueOf(eCParameterSpec.getCofactor()), eCParameterSpec.getCurve().getSeed()));
        }
    }
}
