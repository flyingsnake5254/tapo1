package b.d.d0.g2;

/* compiled from: BusinessHeader.java */
/* loaded from: classes3.dex */
public class c {
    private byte a;

    /* renamed from: b  reason: collision with root package name */
    private byte f279b;

    public c(byte b2, byte b3) {
        this.a = b2;
        this.f279b = b3;
    }

    public byte a() {
        return this.a;
    }

    public byte b() {
        return this.f279b;
    }

    public byte[] c() {
        return new byte[]{this.a, this.f279b};
    }

    public c(byte[] bArr) {
        this.a = bArr[0];
        this.f279b = bArr[1];
    }
}
