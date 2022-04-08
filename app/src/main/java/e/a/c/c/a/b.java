package e.a.c.c.a;

import java.security.spec.KeySpec;

/* loaded from: classes4.dex */
public class b implements KeySpec {

    /* renamed from: c  reason: collision with root package name */
    private short[][] f15554c;

    /* renamed from: d  reason: collision with root package name */
    private short[][] f15555d;

    /* renamed from: f  reason: collision with root package name */
    private short[] f15556f;
    private int q;

    public b(int i, short[][] sArr, short[][] sArr2, short[] sArr3) {
        this.q = i;
        this.f15554c = sArr;
        this.f15555d = sArr2;
        this.f15556f = sArr3;
    }

    public short[][] a() {
        return this.f15554c;
    }

    public short[] b() {
        return this.f15556f;
    }

    public short[][] c() {
        return this.f15555d;
    }

    public int d() {
        return this.q;
    }
}
