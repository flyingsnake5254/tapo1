package b.d.d0.f2;

/* compiled from: TMPResponse.java */
/* loaded from: classes3.dex */
public class e {
    private int a;

    /* renamed from: b  reason: collision with root package name */
    private String f265b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f266c;

    public e(int i, String str, byte[] bArr) {
        this.a = i;
        this.f265b = str;
        this.f266c = bArr;
    }

    public int a() {
        return this.a;
    }

    public String b() {
        return this.f265b;
    }

    public byte[] c() {
        return this.f266c;
    }

    public e(int i) {
        this.a = i;
        this.f265b = c.g.get(Integer.valueOf(i));
    }

    public e(int i, String str) {
        this.a = i;
        this.f265b = str;
    }
}
