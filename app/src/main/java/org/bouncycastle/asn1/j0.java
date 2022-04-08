package org.bouncycastle.asn1;

import java.io.IOException;

/* loaded from: classes4.dex */
public class j0 implements e, s1 {

    /* renamed from: c  reason: collision with root package name */
    private boolean f16773c;

    /* renamed from: d  reason: collision with root package name */
    private int f16774d;

    /* renamed from: f  reason: collision with root package name */
    private v f16775f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j0(boolean z, int i, v vVar) {
        this.f16773c = z;
        this.f16774d = i;
        this.f16775f = vVar;
    }

    @Override // org.bouncycastle.asn1.s1
    public q b() throws IOException {
        return this.f16775f.c(this.f16773c, this.f16774d);
    }

    @Override // org.bouncycastle.asn1.e
    public q c() {
        try {
            return b();
        } catch (IOException e2) {
            throw new ASN1ParsingException(e2.getMessage());
        }
    }
}
