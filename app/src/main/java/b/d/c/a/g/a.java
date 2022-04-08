package b.d.c.a.g;

import b.d.c.a.d;
import b.d.c.a.h.j;
import b.d.c.a.i.b;
import b.d.c.a.m.c;
import com.tplink.libtpanalytics.core.define.e;
import com.tplink.libtpanalytics.core.define.f;

/* compiled from: TAMBackground.java */
/* loaded from: classes3.dex */
public class a extends d {

    /* renamed from: c  reason: collision with root package name */
    private b f119c;

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f118b = true;

    /* renamed from: d  reason: collision with root package name */
    private boolean f120d = true;

    public a(e eVar, b bVar) {
        super(eVar);
        this.f119c = bVar;
    }

    private void b() {
        com.tplink.libtpanalytics.database.d.b a = b.d.c.b.a.a(new b.d.c.b.b("enter_background", this.a));
        if (a != null) {
            this.f119c.d(a);
        }
    }

    private void c() {
        com.tplink.libtpanalytics.database.d.b a = b.d.c.b.a.a(new b.d.c.b.b("enter_foreground", this.a));
        if (a != null) {
            this.f119c.e(a);
        }
    }

    private void e() {
        b.d.c.a.m.b.f().c();
    }

    private void f() {
        c.f().c();
    }

    private void g() {
        if ((System.currentTimeMillis() - this.f119c.l()) / 1000 > 1800) {
            d();
        }
    }

    private void j() {
        b.d.c.a.m.b.f().e();
    }

    private void k() {
        c.f().e();
    }

    public void d() {
        f.a().c();
        com.tplink.libtpanalytics.database.d.b a = b.d.c.b.a.a(new b.d.c.b.b("session_start", this.a));
        if (a != null) {
            this.f119c.i(a);
        }
    }

    public void h() {
        this.f118b = false;
        this.f120d = true;
        b();
        j.a().b("bg");
        f();
        e();
    }

    public void i() {
        if (!this.f120d) {
            j.a().b("timer");
        }
    }

    public void l() {
        this.f120d = false;
        if (!this.f118b) {
            g();
            c();
            k();
            j();
        }
    }
}
