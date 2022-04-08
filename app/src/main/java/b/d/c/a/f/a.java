package b.d.c.a.f;

import android.text.TextUtils;
import b.d.c.a.d;
import b.d.c.a.i.b;
import com.tplink.libtpanalytics.bean.AppUpdateParams;
import com.tplink.libtpanalytics.bean.OSUpdateParams;
import com.tplink.libtpanalytics.core.define.e;
import com.tplink.libtpanalytics.core.define.f;
import com.tplink.libtpanalytics.utils.j;

/* compiled from: TAMAppLaunch.java */
/* loaded from: classes3.dex */
public class a extends d {

    /* renamed from: b  reason: collision with root package name */
    private b f116b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f117c = false;

    public a(e eVar, b bVar) {
        super(eVar);
        this.f116b = bVar;
    }

    private void b() {
        f.a().c();
        com.tplink.libtpanalytics.database.d.b a = b.d.c.b.a.a(new b.d.c.b.b("app_launch", this.a));
        if (a != null) {
            this.f116b.b(a);
        }
    }

    private void c() {
        String f2 = j.g(this.a.c()).f();
        String d2 = this.a.e().d();
        if (TextUtils.isEmpty(f2)) {
            j.g(this.a.c()).k(d2);
        } else if (!f2.equals(d2)) {
            j.g(this.a.c()).k(d2);
            b.d.c.b.b bVar = new b.d.c.b.b("app_update", this.a);
            bVar.d(new AppUpdateParams(f2));
            com.tplink.libtpanalytics.database.d.b a = b.d.c.b.a.a(bVar);
            if (a != null) {
                this.f116b.c(a);
            }
        }
    }

    private void d() {
        String h = j.g(this.a.c()).h();
        String j = this.a.e().j();
        if (TextUtils.isEmpty(h)) {
            j.g(this.a.c()).l(j);
        } else if (!h.equals(j)) {
            j.g(this.a.c()).l(j);
            b.d.c.b.b bVar = new b.d.c.b.b("os_update", this.a);
            bVar.d(new OSUpdateParams(h));
            com.tplink.libtpanalytics.database.d.b a = b.d.c.b.a.a(bVar);
            if (a != null) {
                this.f116b.g(a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // b.d.c.a.d
    public void a(boolean z) {
        super.a(z);
        this.f117c = z;
    }

    public void e() {
        if (this.f117c) {
            b();
            d();
            c();
        }
    }
}
