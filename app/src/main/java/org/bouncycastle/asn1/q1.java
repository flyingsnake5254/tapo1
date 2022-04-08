package org.bouncycastle.asn1;

import java.io.IOException;

/* loaded from: classes4.dex */
public class q1 extends x {
    private static final byte[] x = new byte[0];

    public q1(boolean z, int i, e eVar) {
        super(z, i, eVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public void g(p pVar) throws IOException {
        int i = 160;
        if (!this.f16964d) {
            q l = this.q.c().l();
            if (this.f16965f) {
                pVar.k(160, this.f16963c);
                pVar.i(l.h());
                pVar.j(l);
                return;
            }
            if (!l.j()) {
                i = 128;
            }
            pVar.k(i, this.f16963c);
            pVar.h(l);
            return;
        }
        pVar.f(160, this.f16963c, x);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public int h() throws IOException {
        int b2;
        if (this.f16964d) {
            return y1.b(this.f16963c) + 1;
        }
        int h = this.q.c().l().h();
        if (this.f16965f) {
            b2 = y1.b(this.f16963c) + y1.a(h);
        } else {
            h--;
            b2 = y1.b(this.f16963c);
        }
        return b2 + h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public boolean j() {
        if (this.f16964d || this.f16965f) {
            return true;
        }
        return this.q.c().l().j();
    }
}
