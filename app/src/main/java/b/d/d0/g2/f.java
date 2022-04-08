package b.d.d0.g2;

import b.d.d0.f2.a;

/* compiled from: TMPHeader.java */
/* loaded from: classes3.dex */
public class f extends e {

    /* renamed from: e  reason: collision with root package name */
    private short f284e;

    /* renamed from: f  reason: collision with root package name */
    private byte f285f;
    private byte g;
    private int h;
    private int i;

    public f(byte b2, byte b3, byte b4, byte b5, short s, byte b6, byte b7, int i, int i2) {
        super(b2, b3, b4, b5);
        this.f284e = s;
        this.f285f = b6;
        this.g = b7;
        this.h = i;
        this.i = i2;
    }

    @Override // b.d.d0.g2.e
    public byte[] b() {
        byte[] bArr = new byte[16];
        System.arraycopy(super.b(), 0, bArr, 0, 4);
        System.arraycopy(a.b(this.f284e), 0, bArr, 4, 2);
        bArr[6] = this.f285f;
        bArr[7] = this.g;
        System.arraycopy(a.a(this.h), 0, bArr, 8, 4);
        System.arraycopy(a.a(this.i), 0, bArr, 12, 4);
        return bArr;
    }

    public int c() {
        return this.i;
    }

    public byte d() {
        return this.g;
    }

    public short e() {
        return this.f284e;
    }

    public int f() {
        return this.h;
    }

    public void g(int i) {
        this.i = i;
    }

    public f(byte b2, byte b3, byte b4, byte b5, byte[] bArr) {
        super(b2, b3, b4, b5);
        this.f284e = a.d(bArr, 0);
        this.f285f = bArr[2];
        this.g = bArr[3];
        this.h = a.c(bArr, 4);
        this.i = a.c(bArr, 8);
    }
}
