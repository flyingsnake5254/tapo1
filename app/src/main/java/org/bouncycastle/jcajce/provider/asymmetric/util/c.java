package org.bouncycastle.jcajce.provider.asymmetric.util;

import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.n2.h;
import org.bouncycastle.asn1.x509.a;
import org.bouncycastle.asn1.x509.w;

/* loaded from: classes4.dex */
public class c {
    public static byte[] a(h hVar) {
        try {
            return hVar.e("DER");
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] b(a aVar, e eVar) {
        try {
            return a(new h(aVar, eVar.c()));
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] c(a aVar, e eVar) {
        try {
            return d(new w(aVar, eVar));
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] d(w wVar) {
        try {
            return wVar.e("DER");
        } catch (Exception unused) {
            return null;
        }
    }
}
