package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.a;
import org.bouncycastle.util.i;

/* loaded from: classes4.dex */
public class f1 extends q implements w {

    /* renamed from: c  reason: collision with root package name */
    private byte[] f16744c;

    public f1(byte[] bArr) {
        this.f16744c = a.g(bArr);
    }

    @Override // org.bouncycastle.asn1.q
    boolean f(q qVar) {
        if (!(qVar instanceof f1)) {
            return false;
        }
        return a.c(this.f16744c, ((f1) qVar).f16744c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public void g(p pVar) throws IOException {
        pVar.g(20, this.f16744c);
    }

    @Override // org.bouncycastle.asn1.w
    public String getString() {
        return i.b(this.f16744c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public int h() {
        return y1.a(this.f16744c.length) + 1 + this.f16744c.length;
    }

    @Override // org.bouncycastle.asn1.l
    public int hashCode() {
        return a.w(this.f16744c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public boolean j() {
        return false;
    }

    public String toString() {
        return getString();
    }
}
