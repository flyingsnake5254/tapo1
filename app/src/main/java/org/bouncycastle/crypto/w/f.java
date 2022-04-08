package org.bouncycastle.crypto.w;

import java.math.BigInteger;

/* loaded from: classes4.dex */
public class f extends d {

    /* renamed from: f  reason: collision with root package name */
    private BigInteger f17349f;

    public f(BigInteger bigInteger, e eVar) {
        super(true, eVar);
        this.f17349f = bigInteger;
    }

    public BigInteger c() {
        return this.f17349f;
    }

    @Override // org.bouncycastle.crypto.w.d
    public boolean equals(Object obj) {
        return (obj instanceof f) && ((f) obj).c().equals(this.f17349f) && super.equals(obj);
    }

    @Override // org.bouncycastle.crypto.w.d
    public int hashCode() {
        return this.f17349f.hashCode() ^ super.hashCode();
    }
}
