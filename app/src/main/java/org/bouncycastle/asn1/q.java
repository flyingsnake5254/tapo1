package org.bouncycastle.asn1;

import java.io.IOException;

/* loaded from: classes4.dex */
public abstract class q extends l {
    public static q i(byte[] bArr) throws IOException {
        i iVar = new i(bArr);
        try {
            q t = iVar.t();
            if (iVar.available() == 0) {
                return t;
            }
            throw new IOException("Extra data detected in stream");
        } catch (ClassCastException unused) {
            throw new IOException("cannot recognise object in stream");
        }
    }

    @Override // org.bouncycastle.asn1.l, org.bouncycastle.asn1.e
    public q c() {
        return this;
    }

    @Override // org.bouncycastle.asn1.l
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && f(((e) obj).c());
    }

    abstract boolean f(q qVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void g(p pVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int h() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean j();

    /* JADX INFO: Access modifiers changed from: package-private */
    public q k() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q l() {
        return this;
    }
}
