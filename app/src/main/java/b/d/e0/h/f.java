package b.d.e0.h;

/* compiled from: LuminanceSource.java */
/* loaded from: classes3.dex */
public abstract class f {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final int f416b;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(int i, int i2) {
        this.a = i;
        this.f416b = i2;
    }

    public final int a() {
        return this.f416b;
    }

    public abstract byte[] b(int i, byte[] bArr);

    public final int c() {
        return this.a;
    }

    public final String toString() {
        int i = this.a;
        byte[] bArr = new byte[i];
        StringBuilder sb = new StringBuilder(this.f416b * (i + 1));
        for (int i2 = 0; i2 < this.f416b; i2++) {
            bArr = b(i2, bArr);
            for (int i3 = 0; i3 < this.a; i3++) {
                int i4 = bArr[i3] & 255;
                sb.append(i4 < 64 ? '#' : i4 < 128 ? '+' : i4 < 192 ? '.' : ' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
