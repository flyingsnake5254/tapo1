package e.a.b.a;

import e.a.b.a.b0.b;
import java.math.BigInteger;

/* loaded from: classes4.dex */
public class m extends a {
    protected final d a;

    /* renamed from: b  reason: collision with root package name */
    protected final b f15467b;

    public m(d dVar, b bVar) {
        if (dVar == null || dVar.w() == null) {
            throw new IllegalArgumentException("Need curve with known group order");
        }
        this.a = dVar;
        this.f15467b = bVar;
    }

    @Override // e.a.b.a.a
    protected h c(h hVar, BigInteger bigInteger) {
        if (this.a.m(hVar.i())) {
            BigInteger[] c2 = this.f15467b.c(bigInteger.mod(hVar.i().w()));
            BigInteger bigInteger2 = c2[0];
            BigInteger bigInteger3 = c2[1];
            i b2 = this.f15467b.b();
            return this.f15467b.a() ? b.d(hVar, bigInteger2, b2, bigInteger3) : b.c(hVar, bigInteger2, b2.a(hVar), bigInteger3);
        }
        throw new IllegalStateException();
    }
}
