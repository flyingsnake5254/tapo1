package org.bouncycastle.crypto.s;

import java.math.BigInteger;
import org.bouncycastle.crypto.b;
import org.bouncycastle.crypto.i;
import org.bouncycastle.crypto.w.c;
import org.bouncycastle.crypto.w.e;
import org.bouncycastle.crypto.w.f;
import org.bouncycastle.crypto.w.g;

/* loaded from: classes4.dex */
public class a {
    private c a;

    public b a() {
        b bVar = b.a;
        e b2 = this.a.b();
        BigInteger a = bVar.a(b2, this.a.a());
        return new b(new g(bVar.b(b2, a), b2), new f(a, b2));
    }

    public void b(i iVar) {
        this.a = (c) iVar;
    }
}
