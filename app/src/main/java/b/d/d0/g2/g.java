package b.d.d0.g2;

/* compiled from: TMPPacket.java */
/* loaded from: classes3.dex */
public class g {
    private e a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f286b;

    public g() {
    }

    public byte[] a() {
        return this.f286b;
    }

    public e b() {
        return this.a;
    }

    public short c() {
        byte[] bArr = this.f286b;
        return (short) (bArr == null ? 0 : bArr.length);
    }

    public byte[] d() {
        e eVar = this.a;
        byte[] b2 = eVar == null ? new byte[4] : eVar.b();
        byte[] bArr = this.f286b;
        if (bArr == null || bArr.length <= 0) {
            return b2;
        }
        byte[] bArr2 = new byte[b2.length + bArr.length];
        System.arraycopy(b2, 0, bArr2, 0, b2.length);
        byte[] bArr3 = this.f286b;
        System.arraycopy(bArr3, 0, bArr2, b2.length, bArr3.length);
        return bArr2;
    }

    public void e(e eVar) {
        this.a = eVar;
    }

    public g(e eVar) {
        this.a = eVar;
    }

    public g(e eVar, byte[] bArr) {
        this.a = eVar;
        this.f286b = bArr;
    }
}
