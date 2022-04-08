package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class v1 extends r {

    /* renamed from: d  reason: collision with root package name */
    private byte[] f16959d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v1(byte[] bArr) throws IOException {
        this.f16959d = bArr;
    }

    private void s() {
        u1 u1Var = new u1(this.f16959d);
        while (u1Var.hasMoreElements()) {
            this.f16878c.addElement(u1Var.nextElement());
        }
        this.f16959d = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public void g(p pVar) throws IOException {
        byte[] bArr = this.f16959d;
        if (bArr != null) {
            pVar.g(48, bArr);
        } else {
            super.l().g(pVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public int h() throws IOException {
        byte[] bArr = this.f16959d;
        return bArr != null ? y1.a(bArr.length) + 1 + this.f16959d.length : super.l().h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.r, org.bouncycastle.asn1.q
    public q k() {
        if (this.f16959d != null) {
            s();
        }
        return super.k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.r, org.bouncycastle.asn1.q
    public q l() {
        if (this.f16959d != null) {
            s();
        }
        return super.l();
    }

    @Override // org.bouncycastle.asn1.r
    public synchronized e p(int i) {
        if (this.f16959d != null) {
            s();
        }
        return super.p(i);
    }

    @Override // org.bouncycastle.asn1.r
    public synchronized Enumeration q() {
        byte[] bArr = this.f16959d;
        if (bArr == null) {
            return super.q();
        }
        return new u1(bArr);
    }

    @Override // org.bouncycastle.asn1.r
    public synchronized int size() {
        if (this.f16959d != null) {
            s();
        }
        return super.size();
    }
}
