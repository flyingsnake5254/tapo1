package b.d.a0.a;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: VodConnectionManager.java */
/* loaded from: classes3.dex */
public class f {
    private Map<String, b> a;

    /* renamed from: b  reason: collision with root package name */
    private e f72b;

    /* compiled from: VodConnectionManager.java */
    /* loaded from: classes3.dex */
    private static class b {
        public static f a = new f();
    }

    public static f c() {
        return b.a;
    }

    private void e() {
        for (String str : this.a.keySet()) {
            b remove = this.a.remove(str);
            if (remove != null) {
                remove.x(null);
                remove.r();
            }
        }
    }

    public void a(String str) {
        b bVar = this.a.get(str);
        if (bVar == null) {
            bVar = new b(str);
            this.a.put(str, bVar);
        }
        bVar.x(this.f72b);
        bVar.o();
    }

    public void b(String str, long j, long j2) {
        b bVar = this.a.get(str);
        if (bVar != null) {
            bVar.w(j);
            bVar.v(j2);
        } else {
            bVar = new b(str, j, j2);
            this.a.put(str, bVar);
        }
        bVar.x(this.f72b);
        bVar.o();
    }

    public void d() {
        e();
    }

    public void f(String str) {
        b bVar = this.a.get(str);
        if (bVar != null) {
            bVar.s();
        }
    }

    public void g(String str, int i) {
        b bVar = this.a.get(str);
        if (bVar != null) {
            bVar.t(i);
        }
    }

    public void h() {
        for (String str : new ArrayList(this.a.keySet())) {
            b bVar = this.a.get(str);
            if (bVar != null) {
                bVar.u();
            }
        }
    }

    public void i(e eVar) {
        this.f72b = eVar;
    }

    public void j(String str, boolean z) {
        b bVar = this.a.get(str);
        if (bVar != null) {
            bVar.y(z);
        }
    }

    private f() {
        this.a = new ConcurrentHashMap();
    }
}
