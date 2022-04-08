package e.a.c.b.b;

import e.a.c.d.a.a;
import e.a.c.d.a.b;
import e.a.c.d.a.c;
import e.a.c.d.a.h;
import e.a.c.d.a.i;
import e.a.c.d.a.k;

/* loaded from: classes4.dex */
public class f extends d {

    /* renamed from: d  reason: collision with root package name */
    private int f15538d;

    /* renamed from: f  reason: collision with root package name */
    private int f15539f;
    private h p0;
    private a p1;
    private i[] p2;
    private b q;
    private i x;
    private a y;
    private h z;

    public f(int i, int i2, b bVar, i iVar, h hVar, h hVar2, a aVar) {
        super(true, null);
        this.f15539f = i2;
        this.f15538d = i;
        this.q = bVar;
        this.x = iVar;
        this.y = aVar;
        this.z = hVar;
        this.p0 = hVar2;
        this.p1 = c.a(bVar, iVar);
        this.p2 = new k(bVar, iVar).c();
    }

    public b b() {
        return this.q;
    }

    public i c() {
        return this.x;
    }

    public a d() {
        return this.p1;
    }

    public int e() {
        return this.f15539f;
    }

    public int f() {
        return this.f15538d;
    }

    public h g() {
        return this.z;
    }

    public h h() {
        return this.p0;
    }

    public i[] i() {
        return this.p2;
    }

    public a j() {
        return this.y;
    }
}
