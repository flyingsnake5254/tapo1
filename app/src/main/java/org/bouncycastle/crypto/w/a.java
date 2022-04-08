package org.bouncycastle.crypto.w;

import org.bouncycastle.crypto.e;

/* loaded from: classes4.dex */
public class a implements e {

    /* renamed from: c  reason: collision with root package name */
    private byte[] f17333c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f17334d;

    /* renamed from: f  reason: collision with root package name */
    private a0 f17335f;
    private int q;

    public a(a0 a0Var, int i, byte[] bArr) {
        this(a0Var, i, bArr, null);
    }

    public a(a0 a0Var, int i, byte[] bArr, byte[] bArr2) {
        this.f17335f = a0Var;
        this.f17334d = bArr;
        this.q = i;
        this.f17333c = bArr2;
    }

    public byte[] a() {
        return this.f17333c;
    }

    public a0 b() {
        return this.f17335f;
    }

    public int c() {
        return this.q;
    }

    public byte[] d() {
        return this.f17334d;
    }
}
