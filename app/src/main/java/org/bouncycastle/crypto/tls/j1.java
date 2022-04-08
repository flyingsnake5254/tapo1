package org.bouncycastle.crypto.tls;

import org.bouncycastle.util.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class j1 implements i1 {
    final byte[] a;

    /* renamed from: b  reason: collision with root package name */
    c0 f17246b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j1(byte[] bArr, c0 c0Var) {
        if (bArr == null) {
            throw new IllegalArgumentException("'sessionID' cannot be null");
        } else if (bArr.length < 1 || bArr.length > 32) {
            throw new IllegalArgumentException("'sessionID' must have length between 1 and 32 bytes, inclusive");
        } else {
            this.a = a.g(bArr);
            this.f17246b = c0Var;
        }
    }

    @Override // org.bouncycastle.crypto.tls.i1
    public synchronized byte[] a() {
        return this.a;
    }

    @Override // org.bouncycastle.crypto.tls.i1
    public synchronized boolean b() {
        return this.f17246b != null;
    }

    @Override // org.bouncycastle.crypto.tls.i1
    public synchronized c0 c() {
        c0 c0Var;
        c0Var = this.f17246b;
        return c0Var == null ? null : c0Var.b();
    }

    @Override // org.bouncycastle.crypto.tls.i1
    public synchronized void invalidate() {
        c0 c0Var = this.f17246b;
        if (c0Var != null) {
            c0Var.a();
            this.f17246b = null;
        }
    }
}
