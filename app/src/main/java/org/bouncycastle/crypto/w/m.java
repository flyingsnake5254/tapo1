package org.bouncycastle.crypto.w;

import org.bouncycastle.util.a;

/* loaded from: classes4.dex */
public class m {
    private int a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f17357b;

    /* renamed from: c  reason: collision with root package name */
    private int f17358c;

    public m(byte[] bArr, int i) {
        this(bArr, i, -1);
    }

    public m(byte[] bArr, int i, int i2) {
        this.f17357b = bArr;
        this.f17358c = i;
        this.a = i2;
    }

    public int a() {
        return this.f17358c;
    }

    public byte[] b() {
        return this.f17357b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        if (mVar.f17358c != this.f17358c) {
            return false;
        }
        return a.c(this.f17357b, mVar.f17357b);
    }

    public int hashCode() {
        return this.f17358c ^ a.w(this.f17357b);
    }
}
