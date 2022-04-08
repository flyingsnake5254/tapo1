package b.d.d0.g2;

/* compiled from: BusinessPacket.java */
/* loaded from: classes3.dex */
public class d {
    private c a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f280b;

    public d(c cVar, byte[] bArr) {
        this.a = cVar;
        this.f280b = bArr;
    }

    public c a() {
        return this.a;
    }

    public byte[] b() {
        return this.f280b;
    }

    public byte[] c() {
        byte[] c2 = this.a.c();
        byte[] bArr = this.f280b;
        if (bArr == null || bArr.length <= 0) {
            return c2;
        }
        byte[] bArr2 = new byte[c2.length + bArr.length];
        System.arraycopy(c2, 0, bArr2, 0, c2.length);
        byte[] bArr3 = this.f280b;
        System.arraycopy(bArr3, 0, bArr2, c2.length, bArr3.length);
        return bArr2;
    }

    public void d(c cVar) {
        this.a = cVar;
    }

    public void e(byte[] bArr) {
        this.f280b = bArr;
    }

    public d(byte[] bArr) {
        this.a = new c(bArr[0], bArr[1]);
        byte[] bArr2 = new byte[bArr.length - 2];
        this.f280b = bArr2;
        System.arraycopy(bArr, 2, bArr2, 0, bArr.length - 2);
    }
}
