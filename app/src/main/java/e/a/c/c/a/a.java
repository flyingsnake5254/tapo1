package e.a.c.c.a;

import java.security.spec.KeySpec;

/* loaded from: classes4.dex */
public class a implements KeySpec {

    /* renamed from: c  reason: collision with root package name */
    private short[][] f15551c;

    /* renamed from: d  reason: collision with root package name */
    private short[] f15552d;

    /* renamed from: f  reason: collision with root package name */
    private short[][] f15553f;
    private short[] q;
    private int[] x;
    private e.a.c.b.d.a[] y;

    public a(short[][] sArr, short[] sArr2, short[][] sArr3, short[] sArr4, int[] iArr, e.a.c.b.d.a[] aVarArr) {
        this.f15551c = sArr;
        this.f15552d = sArr2;
        this.f15553f = sArr3;
        this.q = sArr4;
        this.x = iArr;
        this.y = aVarArr;
    }

    public short[] a() {
        return this.f15552d;
    }

    public short[] b() {
        return this.q;
    }

    public short[][] c() {
        return this.f15551c;
    }

    public short[][] d() {
        return this.f15553f;
    }

    public e.a.c.b.d.a[] e() {
        return this.y;
    }

    public int[] f() {
        return this.x;
    }
}
