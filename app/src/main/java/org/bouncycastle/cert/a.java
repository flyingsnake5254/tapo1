package org.bouncycastle.cert;

import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x509.q;

/* loaded from: classes4.dex */
public class a implements Cloneable {

    /* renamed from: c  reason: collision with root package name */
    final q f17054c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(r rVar) {
        this.f17054c = q.f(rVar);
    }

    public Object clone() {
        return new a((r) this.f17054c.c());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        return this.f17054c.equals(((a) obj).f17054c);
    }

    public int hashCode() {
        return this.f17054c.hashCode();
    }
}
