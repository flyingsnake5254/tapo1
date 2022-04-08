package org.bouncycastle.crypto.w;

import java.math.BigInteger;

/* loaded from: classes4.dex */
public class w extends t {

    /* renamed from: f  reason: collision with root package name */
    private BigInteger f17367f;

    public w(BigInteger bigInteger, u uVar) {
        super(false, uVar);
        this.f17367f = bigInteger;
    }

    public BigInteger c() {
        return this.f17367f;
    }

    @Override // org.bouncycastle.crypto.w.t
    public boolean equals(Object obj) {
        return (obj instanceof w) && ((w) obj).c().equals(this.f17367f) && super.equals(obj);
    }

    @Override // org.bouncycastle.crypto.w.t
    public int hashCode() {
        return this.f17367f.hashCode() ^ super.hashCode();
    }
}
