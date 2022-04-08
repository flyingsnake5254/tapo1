package org.bouncycastle.crypto.tls;

import org.bouncycastle.crypto.e;
import org.bouncycastle.crypto.g;
import org.bouncycastle.crypto.j;
import org.bouncycastle.crypto.w.a0;
import org.bouncycastle.util.a;

/* loaded from: classes4.dex */
public class z implements j {
    static final byte[] a = e((byte) 54, 48);

    /* renamed from: b  reason: collision with root package name */
    static final byte[] f17300b = e((byte) 92, 48);

    /* renamed from: c  reason: collision with root package name */
    private g f17301c;

    /* renamed from: d  reason: collision with root package name */
    private int f17302d;

    /* renamed from: e  reason: collision with root package name */
    private byte[] f17303e;

    public z(g gVar) {
        this.f17301c = gVar;
        this.f17302d = gVar.e() == 20 ? 40 : 48;
    }

    private static byte[] e(byte b2, int i) {
        byte[] bArr = new byte[i];
        a.u(bArr, b2);
        return bArr;
    }

    @Override // org.bouncycastle.crypto.j
    public int a() {
        return this.f17301c.e();
    }

    @Override // org.bouncycastle.crypto.j
    public String b() {
        return this.f17301c.b() + "/SSL3MAC";
    }

    @Override // org.bouncycastle.crypto.j
    public void c(byte b2) {
        this.f17301c.c(b2);
    }

    @Override // org.bouncycastle.crypto.j
    public void d(e eVar) {
        this.f17303e = a.g(((a0) eVar).a());
        reset();
    }

    @Override // org.bouncycastle.crypto.j
    public int doFinal(byte[] bArr, int i) {
        int e2 = this.f17301c.e();
        byte[] bArr2 = new byte[e2];
        this.f17301c.doFinal(bArr2, 0);
        g gVar = this.f17301c;
        byte[] bArr3 = this.f17303e;
        gVar.update(bArr3, 0, bArr3.length);
        this.f17301c.update(f17300b, 0, this.f17302d);
        this.f17301c.update(bArr2, 0, e2);
        int doFinal = this.f17301c.doFinal(bArr, i);
        reset();
        return doFinal;
    }

    @Override // org.bouncycastle.crypto.j
    public void reset() {
        this.f17301c.reset();
        g gVar = this.f17301c;
        byte[] bArr = this.f17303e;
        gVar.update(bArr, 0, bArr.length);
        this.f17301c.update(a, 0, this.f17302d);
    }

    @Override // org.bouncycastle.crypto.j
    public void update(byte[] bArr, int i, int i2) {
        this.f17301c.update(bArr, i, i2);
    }
}
