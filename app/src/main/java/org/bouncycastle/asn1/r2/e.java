package org.bouncycastle.asn1.r2;

import e.a.b.a.c;
import e.a.b.a.d;
import e.a.b.a.h;
import java.math.BigInteger;
import java.util.Random;

/* loaded from: classes4.dex */
public abstract class e {
    public static h a(d dVar, byte[] bArr) {
        e.a.b.a.e n = dVar.n(BigInteger.valueOf(bArr[bArr.length - 1] & 1));
        e.a.b.a.e n2 = dVar.n(new BigInteger(1, bArr));
        if (!d(n2).equals(dVar.o())) {
            n2 = n2.b();
        }
        e.a.b.a.e eVar = null;
        if (n2.i()) {
            eVar = dVar.p().n();
        } else {
            e.a.b.a.e c2 = c(dVar, n2.o().g().j(dVar.p()).a(dVar.o()).a(n2));
            if (c2 != null) {
                if (!d(c2).equals(n)) {
                    c2 = c2.b();
                }
                eVar = n2.j(c2);
            }
        }
        if (eVar != null) {
            return dVar.D(n2.t(), eVar.t());
        }
        throw new IllegalArgumentException("Invalid point compression");
    }

    public static byte[] b(h hVar) {
        h A = hVar.A();
        e.a.b.a.e f2 = A.f();
        byte[] e2 = f2.e();
        if (!f2.i()) {
            if (d(A.g().d(f2)).h()) {
                int length = e2.length - 1;
                e2[length] = (byte) (e2[length] | 1);
            } else {
                int length2 = e2.length - 1;
                e2[length2] = (byte) (e2[length2] & 254);
            }
        }
        return e2;
    }

    private static e.a.b.a.e c(d dVar, e.a.b.a.e eVar) {
        if (eVar.i()) {
            return eVar;
        }
        e.a.b.a.e n = dVar.n(c.a);
        Random random = new Random();
        int f2 = eVar.f();
        do {
            e.a.b.a.e n2 = dVar.n(new BigInteger(f2, random));
            e.a.b.a.e eVar2 = eVar;
            for (int i = 1; i <= f2 - 1; i++) {
                e.a.b.a.e o = eVar2.o();
                n = n.o().a(o.j(n2));
                eVar2 = o.a(eVar);
            }
            if (!eVar2.i()) {
                return null;
            }
        } while (n.o().a(n).i());
        return n;
    }

    private static e.a.b.a.e d(e.a.b.a.e eVar) {
        e.a.b.a.e eVar2 = eVar;
        for (int i = 1; i < eVar.f(); i++) {
            eVar2 = eVar2.o().a(eVar);
        }
        return eVar2;
    }
}
