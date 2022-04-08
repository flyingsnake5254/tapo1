package org.bouncycastle.crypto.p;

import org.bouncycastle.util.e;
import org.bouncycastle.util.f;

/* loaded from: classes4.dex */
public class h extends c {
    public h() {
    }

    public h(h hVar) {
        super(hVar);
    }

    @Override // org.bouncycastle.crypto.g
    public String b() {
        return "SHA-384";
    }

    @Override // org.bouncycastle.util.e
    public e copy() {
        return new h(this);
    }

    @Override // org.bouncycastle.crypto.g
    public int doFinal(byte[] bArr, int i) {
        v();
        f.l(this.f17122f, bArr, i);
        f.l(this.g, bArr, i + 8);
        f.l(this.h, bArr, i + 16);
        f.l(this.i, bArr, i + 24);
        f.l(this.j, bArr, i + 32);
        f.l(this.k, bArr, i + 40);
        reset();
        return 48;
    }

    @Override // org.bouncycastle.crypto.g
    public int e() {
        return 48;
    }

    @Override // org.bouncycastle.util.e
    public void m(e eVar) {
        super.u((h) eVar);
    }

    @Override // org.bouncycastle.crypto.p.c, org.bouncycastle.crypto.g
    public void reset() {
        super.reset();
        this.f17122f = -3766243637369397544L;
        this.g = 7105036623409894663L;
        this.h = -7973340178411365097L;
        this.i = 1526699215303891257L;
        this.j = 7436329637833083697L;
        this.k = -8163818279084223215L;
        this.l = -2662702644619276377L;
        this.m = 5167115440072839076L;
    }
}
