package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

/* loaded from: classes4.dex */
public class p1 extends t {

    /* renamed from: f  reason: collision with root package name */
    private int f16854f = -1;

    public p1() {
    }

    public p1(e eVar) {
        super(eVar);
    }

    public p1(f fVar) {
        super(fVar, false);
    }

    public p1(e[] eVarArr) {
        super(eVarArr, false);
    }

    private int v() throws IOException {
        if (this.f16854f < 0) {
            int i = 0;
            Enumeration r = r();
            while (r.hasMoreElements()) {
                i += ((e) r.nextElement()).c().l().h();
            }
            this.f16854f = i;
        }
        return this.f16854f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public void g(p pVar) throws IOException {
        p b2 = pVar.b();
        int v = v();
        pVar.c(49);
        pVar.i(v);
        Enumeration r = r();
        while (r.hasMoreElements()) {
            b2.j((e) r.nextElement());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public int h() throws IOException {
        int v = v();
        return y1.a(v) + 1 + v;
    }
}
