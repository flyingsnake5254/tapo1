package b.d.i.a.a;

import java.util.concurrent.Callable;

/* compiled from: StreamConnection.java */
/* loaded from: classes3.dex */
public abstract class f implements Callable<Boolean> {

    /* renamed from: c  reason: collision with root package name */
    protected String f462c;

    /* renamed from: d  reason: collision with root package name */
    protected String f463d;

    /* renamed from: f  reason: collision with root package name */
    protected int f464f;
    protected int q;
    protected int x;
    protected boolean y = true;
    protected boolean z = false;
    protected int p0 = 512;
    protected boolean p1 = false;

    public int a() {
        return this.x;
    }

    public String b() {
        return this.f462c;
    }

    public int c() {
        return this.q;
    }

    public boolean d() {
        return this.z;
    }

    public boolean e() {
        int i = this.x;
        return (i == 0 || 17 == i) ? false : true;
    }

    public abstract void f(String str);

    public void g(int i) {
        this.x = i;
    }

    public void h(String str) {
        this.f462c = str;
    }

    public void i(String str) {
        this.f463d = str;
    }

    public void j(int i) {
        this.f464f = i;
    }

    public void k(int i) {
        this.q = i;
    }
}
