package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.a;

/* loaded from: classes4.dex */
public class m0 extends q implements w {

    /* renamed from: c  reason: collision with root package name */
    private final char[] f16803c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m0(char[] cArr) {
        this.f16803c = cArr;
    }

    @Override // org.bouncycastle.asn1.q
    protected boolean f(q qVar) {
        if (!(qVar instanceof m0)) {
            return false;
        }
        return a.d(this.f16803c, ((m0) qVar).f16803c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public void g(p pVar) throws IOException {
        pVar.c(30);
        pVar.i(this.f16803c.length * 2);
        int i = 0;
        while (true) {
            char[] cArr = this.f16803c;
            if (i != cArr.length) {
                char c2 = cArr[i];
                pVar.c((byte) (c2 >> '\b'));
                pVar.c((byte) c2);
                i++;
            } else {
                return;
            }
        }
    }

    @Override // org.bouncycastle.asn1.w
    public String getString() {
        return new String(this.f16803c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public int h() {
        return y1.a(this.f16803c.length * 2) + 1 + (this.f16803c.length * 2);
    }

    @Override // org.bouncycastle.asn1.l
    public int hashCode() {
        return a.x(this.f16803c);
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
