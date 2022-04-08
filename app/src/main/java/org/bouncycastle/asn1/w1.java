package org.bouncycastle.asn1;

import java.io.InputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class w1 extends InputStream {

    /* renamed from: c  reason: collision with root package name */
    protected final InputStream f16961c;

    /* renamed from: d  reason: collision with root package name */
    private int f16962d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w1(InputStream inputStream, int i) {
        this.f16961c = inputStream;
        this.f16962d = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f16962d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(boolean z) {
        InputStream inputStream = this.f16961c;
        if (inputStream instanceof t1) {
            ((t1) inputStream).g(z);
        }
    }
}
