package b.d.c.a.l;

import b.d.c.a.d;
import b.d.c.a.i.b;
import b.d.c.a.m.c;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tplink.libtpanalytics.bean.ScreenViewParams;
import com.tplink.libtpanalytics.core.define.e;

/* compiled from: TAMScreenView.java */
/* loaded from: classes3.dex */
public class a extends d {

    /* renamed from: b  reason: collision with root package name */
    private b f152b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f153c = true;

    public a(e eVar, b bVar) {
        super(eVar);
        this.f152b = bVar;
    }

    public void b() {
        this.f153c = true;
    }

    public void c(String str) {
        b.d.c.b.b bVar = new b.d.c.b.b(FirebaseAnalytics.Event.SCREEN_VIEW, this.a);
        bVar.d(new ScreenViewParams(str));
        com.tplink.libtpanalytics.database.d.b a = b.d.c.b.a.a(bVar);
        if (a != null) {
            this.f152b.h(a);
            if (!this.f153c) {
                c.f().e();
            }
        }
    }

    public void d(String str, String str2) {
        b.d.c.b.b bVar = new b.d.c.b.b(FirebaseAnalytics.Event.SCREEN_VIEW, this.a);
        ScreenViewParams screenViewParams = new ScreenViewParams(str2);
        screenViewParams.setScreenClass(str);
        bVar.d(screenViewParams);
        com.tplink.libtpanalytics.database.d.b a = b.d.c.b.a.a(bVar);
        if (a != null) {
            this.f152b.h(a);
            if (!this.f153c) {
                c.f().e();
            }
        }
    }

    public void e() {
        this.f153c = false;
    }
}
