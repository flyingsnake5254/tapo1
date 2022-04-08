package org.bouncycastle.crypto.tls;

import java.io.IOException;

/* loaded from: classes4.dex */
public class w extends b {
    protected c1 i;

    public w(c1 c1Var) {
        this(new n(), c1Var);
    }

    public w(j0 j0Var, c1 c1Var) {
        super(j0Var);
        this.i = c1Var;
    }

    protected x0 C(int i) {
        return new e1(i, this.f17195c, this.i, null, null, this.f17196d, this.f17197e, this.f17198f);
    }

    @Override // org.bouncycastle.crypto.tls.k0
    public x0 h() throws IOException {
        int D = m1.D(this.g);
        if (D != 24) {
            switch (D) {
                case 13:
                case 14:
                case 15:
                    break;
                default:
                    throw new TlsFatalAlert((short) 80);
            }
        }
        return C(D);
    }

    @Override // org.bouncycastle.crypto.tls.k0
    public int[] j() {
        return new int[]{49207, 49205, 178, 144};
    }

    @Override // org.bouncycastle.crypto.tls.k0
    public g0 u() throws IOException {
        throw new TlsFatalAlert((short) 80);
    }
}
