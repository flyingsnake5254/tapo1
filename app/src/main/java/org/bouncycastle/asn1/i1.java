package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.a;
import org.bouncycastle.util.i;

/* loaded from: classes4.dex */
public class i1 extends q implements w {

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f16766c;

    public i1(String str) {
        this.f16766c = i.h(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i1(byte[] bArr) {
        this.f16766c = bArr;
    }

    public static i1 m(Object obj) {
        if (obj == null || (obj instanceof i1)) {
            return (i1) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return (i1) q.i((byte[]) obj);
            } catch (Exception e2) {
                throw new IllegalArgumentException("encoding error in getInstance: " + e2.toString());
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }

    @Override // org.bouncycastle.asn1.q
    boolean f(q qVar) {
        if (!(qVar instanceof i1)) {
            return false;
        }
        return a.c(this.f16766c, ((i1) qVar).f16766c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public void g(p pVar) throws IOException {
        pVar.g(12, this.f16766c);
    }

    @Override // org.bouncycastle.asn1.w
    public String getString() {
        return i.c(this.f16766c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public int h() throws IOException {
        return y1.a(this.f16766c.length) + 1 + this.f16766c.length;
    }

    @Override // org.bouncycastle.asn1.l
    public int hashCode() {
        return a.w(this.f16766c);
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
