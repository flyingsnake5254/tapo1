package b.d.a0.b;

import java.util.ArrayList;
import java.util.List;

/* compiled from: VodStreamConnectionInfo.java */
/* loaded from: classes3.dex */
public class f {
    private long a;

    /* renamed from: b  reason: collision with root package name */
    private d f74b;

    /* renamed from: c  reason: collision with root package name */
    private List<e> f75c;

    /* renamed from: d  reason: collision with root package name */
    private int f76d;

    /* renamed from: e  reason: collision with root package name */
    private String f77e;

    /* renamed from: f  reason: collision with root package name */
    private int[] f78f;
    private long g;
    private long h;
    private boolean i = true;

    public void a(e eVar) {
        if (this.f75c == null) {
            this.f75c = new ArrayList();
        }
        this.f75c.add(eVar);
    }

    public int b() {
        return this.f76d;
    }

    public long c() {
        return this.h;
    }

    public int[] d() {
        return this.f78f;
    }

    public String e() {
        return this.f77e;
    }

    public long f() {
        return this.g;
    }

    public d g() {
        return this.f74b;
    }

    public List<e> h() {
        return this.f75c;
    }

    public boolean i() {
        return this.i;
    }

    public void j() {
        this.i = true;
    }

    public void k(int i) {
        this.f76d = i;
    }

    public void l(long j) {
        this.h = j;
    }

    public void m(int[] iArr) {
        this.f78f = iArr;
    }

    public void n(boolean z) {
        this.i = z;
    }

    public void o(String str) {
        this.f77e = str;
    }

    public void p(long j) {
        this.a = j;
    }

    public void q(long j) {
        this.g = j;
    }

    public void r(d dVar) {
        this.f74b = dVar;
    }
}
