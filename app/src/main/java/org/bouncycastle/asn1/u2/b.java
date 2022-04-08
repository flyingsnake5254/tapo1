package org.bouncycastle.asn1.u2;

import java.math.BigInteger;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.q;

/* loaded from: classes4.dex */
public class b extends l {

    /* renamed from: c  reason: collision with root package name */
    private j f16928c;

    private b(j jVar) {
        if (jVar != null) {
            this.f16928c = jVar;
            return;
        }
        throw new IllegalArgumentException("'y' cannot be null");
    }

    public static b f(Object obj) {
        if (obj == null || (obj instanceof b)) {
            return (b) obj;
        }
        if (obj instanceof j) {
            return new b((j) obj);
        }
        throw new IllegalArgumentException("Invalid DHPublicKey: " + obj.getClass().getName());
    }

    @Override // org.bouncycastle.asn1.l, org.bouncycastle.asn1.e
    public q c() {
        return this.f16928c;
    }

    public BigInteger g() {
        return this.f16928c.o();
    }
}
