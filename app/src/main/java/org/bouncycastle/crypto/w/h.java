package org.bouncycastle.crypto.w;

import org.bouncycastle.util.a;

/* loaded from: classes4.dex */
public class h {
    private byte[] a;

    /* renamed from: b  reason: collision with root package name */
    private int f17351b;

    public h(byte[] bArr, int i) {
        this.a = bArr;
        this.f17351b = i;
    }

    public int a() {
        return this.f17351b;
    }

    public byte[] b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (hVar.f17351b != this.f17351b) {
            return false;
        }
        return a.c(this.a, hVar.a);
    }

    public int hashCode() {
        return this.f17351b ^ a.w(this.a);
    }
}
