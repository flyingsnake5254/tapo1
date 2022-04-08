package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes4.dex */
public class o0 extends q {

    /* renamed from: c  reason: collision with root package name */
    private m f16842c;

    /* renamed from: d  reason: collision with root package name */
    private j f16843d;

    /* renamed from: f  reason: collision with root package name */
    private q f16844f;
    private int q;
    private q x;

    public o0(f fVar) {
        int i = 0;
        q r = r(fVar, 0);
        if (r instanceof m) {
            this.f16842c = (m) r;
            r = r(fVar, 1);
            i = 1;
        }
        if (r instanceof j) {
            this.f16843d = (j) r;
            i++;
            r = r(fVar, i);
        }
        if (!(r instanceof x)) {
            this.f16844f = r;
            i++;
            r = r(fVar, i);
        }
        if (fVar.c() != i + 1) {
            throw new IllegalArgumentException("input vector too large");
        } else if (r instanceof x) {
            x xVar = (x) r;
            s(xVar.p());
            this.x = xVar.o();
        } else {
            throw new IllegalArgumentException("No tagged object found in vector. Structure doesn't seem to be of type External");
        }
    }

    private q r(f fVar, int i) {
        if (fVar.c() > i) {
            return fVar.b(i).c();
        }
        throw new IllegalArgumentException("too few objects in input vector");
    }

    private void s(int i) {
        if (i < 0 || i > 2) {
            throw new IllegalArgumentException("invalid encoding value: " + i);
        }
        this.q = i;
    }

    @Override // org.bouncycastle.asn1.q
    boolean f(q qVar) {
        q qVar2;
        j jVar;
        m mVar;
        if (!(qVar instanceof o0)) {
            return false;
        }
        if (this == qVar) {
            return true;
        }
        o0 o0Var = (o0) qVar;
        m mVar2 = this.f16842c;
        if (mVar2 != null && ((mVar = o0Var.f16842c) == null || !mVar.equals(mVar2))) {
            return false;
        }
        j jVar2 = this.f16843d;
        if (jVar2 != null && ((jVar = o0Var.f16843d) == null || !jVar.equals(jVar2))) {
            return false;
        }
        q qVar3 = this.f16844f;
        if (qVar3 == null || ((qVar2 = o0Var.f16844f) != null && qVar2.equals(qVar3))) {
            return this.x.equals(o0Var.x);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public void g(p pVar) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        m mVar = this.f16842c;
        if (mVar != null) {
            byteArrayOutputStream.write(mVar.e("DER"));
        }
        j jVar = this.f16843d;
        if (jVar != null) {
            byteArrayOutputStream.write(jVar.e("DER"));
        }
        q qVar = this.f16844f;
        if (qVar != null) {
            byteArrayOutputStream.write(qVar.e("DER"));
        }
        byteArrayOutputStream.write(new g1(true, this.q, this.x).e("DER"));
        pVar.f(32, 8, byteArrayOutputStream.toByteArray());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public int h() throws IOException {
        return d().length;
    }

    @Override // org.bouncycastle.asn1.l
    public int hashCode() {
        m mVar = this.f16842c;
        int hashCode = mVar != null ? mVar.hashCode() : 0;
        j jVar = this.f16843d;
        if (jVar != null) {
            hashCode ^= jVar.hashCode();
        }
        q qVar = this.f16844f;
        if (qVar != null) {
            hashCode ^= qVar.hashCode();
        }
        return hashCode ^ this.x.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public boolean j() {
        return true;
    }

    public q m() {
        return this.f16844f;
    }

    public m n() {
        return this.f16842c;
    }

    public int o() {
        return this.q;
    }

    public q p() {
        return this.x;
    }

    public j q() {
        return this.f16843d;
    }
}
