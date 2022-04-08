package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.a;
import org.bouncycastle.util.i;

/* loaded from: classes4.dex */
public class k1 extends q implements w {

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f16787c;

    public k1(byte[] bArr) {
        this.f16787c = a.g(bArr);
    }

    @Override // org.bouncycastle.asn1.q
    boolean f(q qVar) {
        if (!(qVar instanceof k1)) {
            return false;
        }
        return a.c(this.f16787c, ((k1) qVar).f16787c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public void g(p pVar) throws IOException {
        pVar.g(21, this.f16787c);
    }

    @Override // org.bouncycastle.asn1.w
    public String getString() {
        return i.b(this.f16787c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public int h() {
        return y1.a(this.f16787c.length) + 1 + this.f16787c.length;
    }

    @Override // org.bouncycastle.asn1.l
    public int hashCode() {
        return a.w(this.f16787c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public boolean j() {
        return false;
    }
}
