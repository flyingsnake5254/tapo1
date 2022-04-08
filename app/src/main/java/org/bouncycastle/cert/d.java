package org.bouncycastle.cert;

import org.bouncycastle.asn1.x509.l;
import org.bouncycastle.asn1.x509.p;
import org.bouncycastle.asn1.x509.x;

/* loaded from: classes4.dex */
public class d {
    private x.b a;

    /* renamed from: b  reason: collision with root package name */
    private p f17057b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(x.b bVar, boolean z, p pVar) {
        l g;
        this.a = bVar;
        this.f17057b = pVar;
        if (z && bVar.i() && (g = bVar.f().g(l.J3)) != null) {
            this.f17057b = p.f(g.j());
        }
    }

    public p a() {
        return this.f17057b;
    }
}
