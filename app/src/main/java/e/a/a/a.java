package e.a.a;

import org.bouncycastle.asn1.m;
import org.bouncycastle.crypto.w.n;
import org.bouncycastle.jce.spec.b;

/* loaded from: classes4.dex */
public class a {
    public static b a(String str) {
        n a = org.bouncycastle.asn1.d2.b.a(str);
        if (a == null) {
            try {
                a = org.bouncycastle.asn1.d2.b.b(new m(str));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        if (a == null) {
            return null;
        }
        return new b(str, a.a(), a.b(), a.e(), a.c(), a.f());
    }
}
