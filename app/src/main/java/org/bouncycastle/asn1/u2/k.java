package org.bouncycastle.asn1.u2;

/* loaded from: classes4.dex */
public abstract class k {
    private j a;

    protected abstract j a();

    public synchronized j b() {
        if (this.a == null) {
            this.a = a();
        }
        return this.a;
    }
}
