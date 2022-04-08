package b.d.c.a;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import b.d.c.a.h.k;
import com.tplink.libtpanalytics.core.define.TAException;
import com.tplink.libtpanalytics.core.define.c;
import com.tplink.libtpanalytics.net.TPCloudManager;
import com.tplink.libtpanalytics.utils.FragmentStateMonitor;
import com.tplink.libtpanalytics.utils.b;
import com.tplink.libtpanalytics.utils.d;
import com.tplink.libtpanalytics.utils.g;
import com.tplink.libtpanalytics.utils.h;
import com.tplink.libtpanalytics.utils.i;
import com.tplink.libtpanalytics.utils.j;
import com.tplink.libtpanalytics.utils.l.d;
import com.tplink.libtpanalytics.utils.l.f;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* compiled from: TPAnalytics.java */
/* loaded from: classes3.dex */
public class e implements b.d.c.c.a {
    private static b.d.c.c.a a;

    /* renamed from: b  reason: collision with root package name */
    private com.tplink.libtpanalytics.core.define.e f111b;

    /* renamed from: c  reason: collision with root package name */
    private b.d.c.a.j.b f112c;

    /* renamed from: d  reason: collision with root package name */
    private b.d.c.a.g.a f113d;

    /* renamed from: e  reason: collision with root package name */
    private b.d.c.a.i.b f114e;

    /* renamed from: f  reason: collision with root package name */
    private b.d.c.a.f.a f115f;
    private b.d.c.a.l.a g;
    private b.d.c.a.k.a h;
    private k i;
    private b.d.c.c.b j;
    private TPCloudManager k;
    private Application m;
    private String n;
    private String o;
    private String p;
    private volatile boolean l = false;
    private final List<d> q = new ArrayList();
    private final b.AbstractC0249b r = new a();
    private final FragmentStateMonitor.b s = new b();
    private final b.c t = new b.c() { // from class: b.d.c.a.b
        @Override // com.tplink.libtpanalytics.utils.b.c
        public final void a(String str) {
            e.this.z(str);
        }
    };
    private final b.d.c.c.e u = new b.d.c.c.e() { // from class: b.d.c.a.a
        @Override // b.d.c.c.e
        public final void a() {
            e.this.B();
        }
    };
    private final b.d.c.c.e v = new b.d.c.c.e() { // from class: b.d.c.a.c
        @Override // b.d.c.c.e
        public final void a() {
            e.this.v();
        }
    };

    /* compiled from: TPAnalytics.java */
    /* loaded from: classes3.dex */
    class a implements b.AbstractC0249b {
        a() {
        }

        @Override // com.tplink.libtpanalytics.utils.b.AbstractC0249b
        public void a() {
            e.this.x();
        }

        @Override // com.tplink.libtpanalytics.utils.b.AbstractC0249b
        public void b() {
            e.this.w();
        }
    }

    /* compiled from: TPAnalytics.java */
    /* loaded from: classes3.dex */
    class b implements FragmentStateMonitor.b {
        b() {
        }

        @Override // com.tplink.libtpanalytics.utils.FragmentStateMonitor.b
        public void a(Fragment fragment, Fragment fragment2) {
            String str = "";
            String simpleName = fragment != null ? fragment.getClass().getSimpleName() : str;
            if (fragment2 != null) {
                str = fragment2.getClass().getSimpleName();
            }
            e.this.A(simpleName, str);
        }

        @Override // com.tplink.libtpanalytics.utils.FragmentStateMonitor.b
        public void b(Fragment fragment) {
        }
    }

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(String str, String str2) {
        this.g.d(str2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        com.tplink.libtpanalytics.database.d.b a2 = b.d.c.b.a.a(new b.d.c.b.b("user_engagement", this.f111b));
        if (a2 != null) {
            this.f114e.j(a2);
        }
    }

    private void C(c cVar) {
        String i = j.g(this.m).i();
        if (TextUtils.isEmpty(i)) {
            i = d.a(this.m);
            if (!TextUtils.isEmpty(i)) {
                j.g(this.m).m(i);
            }
        }
        if (TextUtils.isEmpty(i)) {
            i = UUID.randomUUID().toString();
            if (!TextUtils.isEmpty(i)) {
                j.g(this.m).m(i);
            }
        }
        cVar.B(i);
    }

    private void k() {
        this.f113d.d();
    }

    public static b.d.c.c.a l() {
        if (a == null) {
            synchronized (e.class) {
                if (a == null) {
                    a = new e();
                }
            }
        }
        return a;
    }

    private com.tplink.libtpanalytics.core.define.d m() {
        com.tplink.libtpanalytics.core.define.d dVar = new com.tplink.libtpanalytics.core.define.d();
        dVar.c(h.a());
        dVar.d(h.d());
        return dVar;
    }

    private c n(String str) {
        c cVar = new c();
        cVar.o(this.n);
        cVar.A(this.o);
        cVar.s(this.p);
        cVar.r(g.a(this.m));
        cVar.q(this.m.getPackageName());
        cVar.v(h.c());
        cVar.z(h.b());
        cVar.y(h.e());
        cVar.u(true);
        cVar.w(m());
        if (!TextUtils.isEmpty(str)) {
            cVar.B(str);
            j.g(this.m).m(str);
        } else {
            C(cVar);
        }
        return cVar;
    }

    private com.tplink.libtpanalytics.core.define.e o(com.tplink.cloud.context.b bVar) {
        com.tplink.libtpanalytics.core.define.e eVar = new com.tplink.libtpanalytics.core.define.e();
        eVar.h(this.m);
        eVar.f(bVar);
        eVar.i(new d.b().h(com.tplink.libtpanalytics.utils.l.e.a(this.m, "tp_analytics_v1.pem")).i(com.tplink.libtpanalytics.utils.l.e.b(this.m, "tp_analytics_v1.pem")).a());
        eVar.g(new f());
        eVar.j(n(bVar.e().q()));
        String n = bVar.e().n();
        if (!TextUtils.isEmpty(n)) {
            eVar.e().x(n);
        }
        return eVar;
    }

    private void p() {
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = this.m.getPackageManager().getApplicationInfo(this.m.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            applicationInfo = null;
        }
        if (applicationInfo != null) {
            String string = applicationInfo.metaData.getString("ANALYTICS_URL");
            this.p = string;
            if (!TextUtils.isEmpty(string)) {
                this.o = applicationInfo.metaData.getString("SECRET");
                this.n = applicationInfo.metaData.getString("ACCESS_KEY");
                if (TextUtils.isEmpty(this.o)) {
                    throw new TAException("please configure secret in build.gradle");
                } else if (!TextUtils.isEmpty(this.n)) {
                    i.c("ANALYTICS_URL:" + this.p + "\nSECRET:" + this.o + "\nACCESS_KEY:" + this.n);
                } else {
                    throw new TAException("please configure accessKey in build.gradle");
                }
            } else {
                throw new TAException("please configure ANALYTICS_URL");
            }
        }
    }

    private void q() {
        if (!this.l) {
            com.tplink.libtpanalytics.utils.b.f().e(this.r, this.t);
            FragmentStateMonitor.h().n(this.s);
            this.f114e.p(true);
            this.i.x(true);
            for (d dVar : this.q) {
                dVar.a(true);
            }
            b.d.c.a.m.c.f().a();
            b.d.c.a.m.c.f().b(this.u);
            b.d.c.a.m.b.f().a();
            b.d.c.a.m.b.f().b(this.v);
            this.l = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        this.f113d.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        this.f113d.h();
        this.g.b();
        this.h.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        this.f113d.l();
        this.g.e();
        this.h.f();
    }

    private void y() {
        this.f115f.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str) {
        this.g.c(str);
    }

    @Override // b.d.c.c.a
    public void a(String str) {
        this.f111b.e().p(str);
    }

    @Override // b.d.c.c.a
    public void b() {
        if (this.l) {
            com.tplink.libtpanalytics.utils.b.f().d();
            FragmentStateMonitor.h().p(this.s);
            this.f114e.p(false);
            this.i.x(false);
            for (d dVar : this.q) {
                dVar.a(false);
            }
            b.d.c.a.m.c.f().c();
            b.d.c.a.m.c.f().d(this.u);
            b.d.c.a.m.b.f().c();
            b.d.c.a.m.b.f().d(this.v);
            this.l = false;
        }
    }

    @Override // b.d.c.c.a
    public void c() {
        if (!this.l) {
            q();
            k();
        }
    }

    @Override // b.d.c.c.a
    public void d(String str) {
        this.f111b.e().t(str);
    }

    @Override // b.d.c.c.a
    public void e() {
        com.tplink.libtpanalytics.utils.f.a = true;
    }

    @Override // b.d.c.c.a
    public void f(@NonNull String str, @NonNull Bundle bundle) {
        this.h.c(str, bundle);
    }

    @Override // b.d.c.c.a
    public void g(Application application, com.tplink.cloud.context.b bVar, boolean z) {
        this.m = application;
        p();
        r(o(bVar));
        i.a = z;
        y();
    }

    public void r(com.tplink.libtpanalytics.core.define.e eVar) {
        this.f111b = eVar;
        com.tplink.libtpanalytics.database.c cVar = new com.tplink.libtpanalytics.database.c();
        this.j = cVar;
        cVar.a(eVar.c());
        this.f111b.b().k(this.j);
        this.f111b.b().l(eVar.d());
        this.f111b.b().e(eVar.c());
        TPCloudManager tPCloudManager = (TPCloudManager) b.d.b.f.b.a(eVar.a(), TPCloudManager.class);
        this.k = tPCloudManager;
        tPCloudManager.d(this.f111b.e());
        this.i = new k(this.j, this.k, eVar.e(), eVar.b());
        b.d.c.a.i.b bVar = new b.d.c.a.i.b(this.j, eVar.b());
        this.f114e = bVar;
        this.f113d = new b.d.c.a.g.a(eVar, bVar);
        this.f112c = new b.d.c.a.j.b(eVar, this.f114e);
        this.f115f = new b.d.c.a.f.a(eVar, this.f114e);
        this.g = new b.d.c.a.l.a(eVar, this.f114e);
        this.h = new b.d.c.a.k.a(eVar, this.f114e);
        this.q.add(this.f113d);
        this.q.add(this.f112c);
        this.q.add(this.f115f);
        this.q.add(this.g);
        this.q.add(this.h);
        com.tplink.libtpanalytics.utils.b.f().h(eVar.c());
        if (eVar.e().n()) {
            q();
        } else {
            b();
        }
    }
}
