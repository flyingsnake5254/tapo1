package e.a.c.b.d;

/* loaded from: classes4.dex */
public class a {
    private int a;

    /* renamed from: b  reason: collision with root package name */
    private int f15544b;

    /* renamed from: c  reason: collision with root package name */
    private int f15545c;

    /* renamed from: d  reason: collision with root package name */
    private short[][][] f15546d;

    /* renamed from: e  reason: collision with root package name */
    private short[][][] f15547e;

    /* renamed from: f  reason: collision with root package name */
    private short[][] f15548f;
    private short[] g;

    public a(byte b2, byte b3, short[][][] sArr, short[][][] sArr2, short[][] sArr3, short[] sArr4) {
        int i = b2 & 255;
        this.a = i;
        int i2 = b3 & 255;
        this.f15544b = i2;
        this.f15545c = i2 - i;
        this.f15546d = sArr;
        this.f15547e = sArr2;
        this.f15548f = sArr3;
        this.g = sArr4;
    }

    public short[][][] a() {
        return this.f15546d;
    }

    public short[][][] b() {
        return this.f15547e;
    }

    public short[] c() {
        return this.g;
    }

    public short[][] d() {
        return this.f15548f;
    }

    public int e() {
        return this.f15545c;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.a == aVar.f() && this.f15544b == aVar.g() && this.f15545c == aVar.e() && e.a.c.b.d.f.a.k(this.f15546d, aVar.a()) && e.a.c.b.d.f.a.k(this.f15547e, aVar.b()) && e.a.c.b.d.f.a.j(this.f15548f, aVar.d()) && e.a.c.b.d.f.a.i(this.g, aVar.c());
    }

    public int f() {
        return this.a;
    }

    public int g() {
        return this.f15544b;
    }

    public int hashCode() {
        return (((((((((((this.a * 37) + this.f15544b) * 37) + this.f15545c) * 37) + org.bouncycastle.util.a.D(this.f15546d)) * 37) + org.bouncycastle.util.a.D(this.f15547e)) * 37) + org.bouncycastle.util.a.C(this.f15548f)) * 37) + org.bouncycastle.util.a.B(this.g);
    }
}
