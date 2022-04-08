package e.a.c.b.b;

import e.a.c.d.a.a;
import e.a.c.d.a.c;
import e.a.c.d.a.h;
import e.a.c.d.a.i;
import e.a.c.d.a.k;

/* loaded from: classes4.dex */
public class b extends a {

    /* renamed from: f  reason: collision with root package name */
    private int f15536f;
    private a p0;
    private i[] p1;
    private int q;
    private e.a.c.d.a.b x;
    private i y;
    private h z;

    public b(int i, int i2, e.a.c.d.a.b bVar, i iVar, a aVar, h hVar, String str) {
        super(true, str);
        this.f15536f = i;
        this.q = i2;
        this.x = bVar;
        this.y = iVar;
        this.p0 = aVar;
        this.z = hVar;
        this.p1 = new k(bVar, iVar).c();
    }

    public b(int i, int i2, e.a.c.d.a.b bVar, i iVar, h hVar, String str) {
        this(i, i2, bVar, iVar, c.a(bVar, iVar), hVar, str);
    }

    public e.a.c.d.a.b c() {
        return this.x;
    }

    public i d() {
        return this.y;
    }

    public a e() {
        return this.p0;
    }

    public int f() {
        return this.q;
    }

    public int g() {
        return this.f15536f;
    }

    public h h() {
        return this.z;
    }

    public i[] i() {
        return this.p1;
    }
}
