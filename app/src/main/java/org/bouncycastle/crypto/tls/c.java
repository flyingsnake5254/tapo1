package org.bouncycastle.crypto.tls;

import java.security.SecureRandom;
import org.bouncycastle.crypto.prng.g;
import org.bouncycastle.util.j;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class c implements p0 {
    private static long a = j.a();

    /* renamed from: b  reason: collision with root package name */
    private g f17201b;

    /* renamed from: c  reason: collision with root package name */
    private SecureRandom f17202c;

    /* renamed from: d  reason: collision with root package name */
    private a0 f17203d;

    /* renamed from: e  reason: collision with root package name */
    private x f17204e = null;

    /* renamed from: f  reason: collision with root package name */
    private x f17205f = null;
    private i1 g = null;
    private Object h = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(SecureRandom secureRandom, a0 a0Var) {
        org.bouncycastle.crypto.g n = m1.n((short) 4);
        byte[] bArr = new byte[n.e()];
        secureRandom.nextBytes(bArr);
        org.bouncycastle.crypto.prng.c cVar = new org.bouncycastle.crypto.prng.c(n);
        this.f17201b = cVar;
        cVar.c(f());
        this.f17201b.c(j.a());
        this.f17201b.a(bArr);
        this.f17202c = secureRandom;
        this.f17203d = a0Var;
    }

    private static synchronized long f() {
        long j;
        synchronized (c.class) {
            j = a + 1;
            a = j;
        }
        return j;
    }

    @Override // org.bouncycastle.crypto.tls.p0
    public x a() {
        return this.f17204e;
    }

    @Override // org.bouncycastle.crypto.tls.p0
    public x b() {
        return this.f17205f;
    }

    @Override // org.bouncycastle.crypto.tls.p0
    public SecureRandom c() {
        return this.f17202c;
    }

    @Override // org.bouncycastle.crypto.tls.p0
    public g d() {
        return this.f17201b;
    }

    @Override // org.bouncycastle.crypto.tls.p0
    public a0 e() {
        return this.f17203d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(x xVar) {
        this.f17204e = xVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(i1 i1Var) {
        this.g = i1Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(x xVar) {
        this.f17205f = xVar;
    }
}
