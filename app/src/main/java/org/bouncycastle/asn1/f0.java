package org.bouncycastle.asn1;

import java.io.IOException;

/* loaded from: classes4.dex */
public class f0 implements s {

    /* renamed from: c  reason: collision with root package name */
    private v f16743c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f0(v vVar) {
        this.f16743c = vVar;
    }

    @Override // org.bouncycastle.asn1.s1
    public q b() throws IOException {
        return new e0(this.f16743c.d());
    }

    @Override // org.bouncycastle.asn1.e
    public q c() {
        try {
            return b();
        } catch (IOException e2) {
            throw new IllegalStateException(e2.getMessage());
        }
    }
}
