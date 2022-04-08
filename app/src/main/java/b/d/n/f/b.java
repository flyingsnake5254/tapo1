package b.d.n.f;

import android.app.Activity;
import android.text.TextUtils;
import b.d.n.f.c.m;
import b.d.n.f.c.n;
import b.d.n.f.c.o;
import b.d.n.i.e;
import b.d.n.i.g;
import b.d.n.i.h;
import b.d.n.j.d;
import com.tplink.libtpinappmessaging.core.repository.IAMRepository;
import io.reactivex.j0.a;

/* compiled from: TPInAppMessaging.java */
/* loaded from: classes3.dex */
public final class b implements g {
    private static final String a = "b";

    /* renamed from: b  reason: collision with root package name */
    private static g f557b = null;

    /* renamed from: c  reason: collision with root package name */
    private static volatile boolean f558c = false;

    /* renamed from: d  reason: collision with root package name */
    private n f559d;

    /* renamed from: e  reason: collision with root package name */
    private o f560e;

    /* renamed from: f  reason: collision with root package name */
    private m f561f;
    private IAMRepository g;
    private e h;

    static {
        m();
        a.A(a.f556c);
    }

    private b() {
    }

    private boolean j() {
        if (!f558c) {
            b.d.n.j.e.a("please call init(...) method first!!");
        }
        return f558c;
    }

    private boolean k(com.tplink.libtpinappmessaging.model.b bVar) {
        if (bVar == null) {
            b.d.n.j.e.a(a + " iamContext is null!!");
            return false;
        } else if (bVar.b() == null) {
            b.d.n.j.e.a(a + " application is null!!");
            return false;
        } else if (TextUtils.isEmpty(bVar.e())) {
            b.d.n.j.e.a(a + " url is empty!!");
            return false;
        } else if (bVar.c() == null) {
            b.d.n.j.e.a(a + " iamLogEventHandler is null!!");
            return false;
        } else if (bVar.d() == null) {
            b.d.n.j.e.a(a + " tcAccountContext is null!!");
            return false;
        } else if (!TextUtils.isEmpty(bVar.a())) {
            return true;
        } else {
            b.d.n.j.e.a(a + " appType is empty!!");
            return false;
        }
    }

    public static g l() {
        if (f557b == null) {
            synchronized (b.class) {
                if (f557b == null) {
                    f557b = new b();
                }
            }
        }
        return f557b;
    }

    private static void m() {
        System.setProperty("rx2.purge-enabled", "true");
        System.setProperty("rx2.purge-period-seconds", "6000");
    }

    @Override // b.d.n.i.g
    public void a(String str) {
        if (!j()) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            b.d.n.j.e.a(a + " accountId is empty!!");
        } else if (!str.equals(this.g.o())) {
            d.c().f(str);
            this.g.H(str);
            this.f559d.o();
            this.f560e.g();
        }
    }

    @Override // b.d.n.i.g
    public void b() {
        if (j()) {
            this.h.b();
        }
    }

    @Override // b.d.n.i.g
    public void c() {
        if (j()) {
            this.g.G();
        }
    }

    @Override // b.d.n.i.g
    public void clear() {
        if (j()) {
            this.g.k();
            d.c().b();
        }
    }

    @Override // b.d.n.i.g
    public void d(Activity activity) {
        if (!j()) {
            return;
        }
        if (activity == null) {
            b.d.n.j.e.a(a + " context is null!!");
            return;
        }
        this.h.d(activity);
    }

    @Override // b.d.n.i.g
    public void e(com.tplink.libtpinappmessaging.model.b bVar) {
        if (k(bVar)) {
            f558c = true;
            b.d.n.j.a.b().d(bVar.b());
            d.c().i(bVar.c());
            d.c().g(bVar.a());
            this.g = (IAMRepository) b.d.b.f.b.c(bVar.d()).a(IAMRepository.class);
            b.d.w.c.a.e("TPInAppMessagingInit", bVar.e());
            this.g.I(bVar.b(), bVar.e());
            this.h = new b.d.n.g.d(bVar.b(), bVar.f());
            this.f559d = new n(this.g);
            this.f560e = new o(this.g);
            this.f561f = new m(this.g);
            this.f559d.b();
            this.f560e.g();
        }
    }

    @Override // b.d.n.i.g
    public void f(String str) {
        if (!j()) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            b.d.n.j.e.a(a + " pageId is empty!!");
            return;
        }
        this.f560e.c(str);
    }

    @Override // b.d.n.i.g
    public void g(b.d.n.i.b bVar) {
        if (j() && bVar != null) {
            this.g.j(bVar);
        }
    }

    @Override // b.d.n.i.g
    public void h(h hVar) {
        if (j()) {
            if (hVar == null) {
                b.d.n.j.e.a(a + " splashMessageListener is null!!");
                return;
            }
            this.h.c(hVar);
        } else if (hVar != null) {
            hVar.onFinish();
        }
    }

    @Override // b.d.n.i.g
    public void i(String str) {
        if (!j()) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            b.d.n.j.e.a(a + " taskId is empty!!");
            return;
        }
        this.f561f.a(str);
    }
}
