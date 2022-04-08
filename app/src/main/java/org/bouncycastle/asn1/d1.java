package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

/* loaded from: classes4.dex */
public class d1 extends t {

    /* renamed from: f  reason: collision with root package name */
    private int f16709f = -1;

    public d1() {
    }

    public d1(e eVar) {
        super(eVar);
    }

    public d1(f fVar) {
        super(fVar, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d1(f fVar, boolean z) {
        super(fVar, z);
    }

    public d1(e[] eVarArr) {
        super(eVarArr, true);
    }

    private int v() throws IOException {
        if (this.f16709f < 0) {
            int i = 0;
            Enumeration r = r();
            while (r.hasMoreElements()) {
                i += ((e) r.nextElement()).c().k().h();
            }
            this.f16709f = i;
        }
        return this.f16709f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public void g(p pVar) throws IOException {
        p a = pVar.a();
        int v = v();
        pVar.c(49);
        pVar.i(v);
        Enumeration r = r();
        while (r.hasMoreElements()) {
            a.j((e) r.nextElement());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public int h() throws IOException {
        int v = v();
        return y1.a(v) + 1 + v;
    }
}
