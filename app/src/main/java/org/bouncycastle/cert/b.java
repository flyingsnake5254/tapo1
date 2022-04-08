package org.bouncycastle.cert;

import org.bouncycastle.asn1.e;

/* loaded from: classes4.dex */
public class b implements Cloneable {

    /* renamed from: c  reason: collision with root package name */
    final e f17055c;

    public b(org.bouncycastle.asn1.x509.b bVar) {
        this.f17055c = bVar.g();
    }

    public Object clone() {
        return new b(org.bouncycastle.asn1.x509.b.f(this.f17055c));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        return this.f17055c.equals(((b) obj).f17055c);
    }

    public int hashCode() {
        return this.f17055c.hashCode();
    }
}
