package org.bouncycastle.crypto.s;

import e.a.b.a.g;
import e.a.b.a.j;
import e.a.b.a.w;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.b;
import org.bouncycastle.crypto.f;
import org.bouncycastle.crypto.i;
import org.bouncycastle.crypto.w.n;
import org.bouncycastle.crypto.w.o;
import org.bouncycastle.crypto.w.r;
import org.bouncycastle.crypto.w.s;

/* loaded from: classes4.dex */
public class c implements e.a.b.a.c {
    n g;
    SecureRandom h;

    protected g a() {
        return new j();
    }

    public b b() {
        BigInteger e2 = this.g.e();
        int bitLength = e2.bitLength();
        int i = bitLength >>> 2;
        while (true) {
            BigInteger bigInteger = new BigInteger(bitLength, this.h);
            if (bigInteger.compareTo(e.a.b.a.c.f15439c) >= 0 && bigInteger.compareTo(e2) < 0 && w.g(bigInteger) >= i) {
                return new b(new s(a().a(this.g.b(), bigInteger), this.g), new r(bigInteger, this.g));
            }
        }
    }

    public void c(i iVar) {
        o oVar = (o) iVar;
        this.h = oVar.a();
        this.g = oVar.b();
        if (this.h == null) {
            this.h = f.b();
        }
    }
}
