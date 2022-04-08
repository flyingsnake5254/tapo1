package org.bouncycastle.crypto.w;

import org.bouncycastle.crypto.e;

/* loaded from: classes4.dex */
public class a0 implements e {

    /* renamed from: c  reason: collision with root package name */
    private byte[] f17336c;

    public a0(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    public a0(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        this.f17336c = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, i2);
    }

    public byte[] a() {
        return this.f17336c;
    }
}
