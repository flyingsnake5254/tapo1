package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

/* loaded from: classes4.dex */
public class o1 extends r {

    /* renamed from: d  reason: collision with root package name */
    private int f16845d = -1;

    public o1() {
    }

    public o1(e eVar) {
        super(eVar);
    }

    public o1(f fVar) {
        super(fVar);
    }

    private int s() throws IOException {
        if (this.f16845d < 0) {
            int i = 0;
            Enumeration q = q();
            while (q.hasMoreElements()) {
                i += ((e) q.nextElement()).c().l().h();
            }
            this.f16845d = i;
        }
        return this.f16845d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public void g(p pVar) throws IOException {
        p b2 = pVar.b();
        int s = s();
        pVar.c(48);
        pVar.i(s);
        Enumeration q = q();
        while (q.hasMoreElements()) {
            b2.j((e) q.nextElement());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public int h() throws IOException {
        int s = s();
        return y1.a(s) + 1 + s;
    }
}
