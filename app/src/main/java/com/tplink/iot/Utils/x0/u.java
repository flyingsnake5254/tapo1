package com.tplink.iot.Utils.x0;

import b.d.w.h.a;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.f;
import com.google.gson.k;
import com.tplink.iot.Utils.n;
import com.tplink.iot.core.AppContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import com.tplink.libtpnetwork.Utils.i;

/* compiled from: QuickSetupFireBaseUtils.java */
/* loaded from: classes2.dex */
public class u {
    private static long a() {
        return (System.currentTimeMillis() - AppContext.f6185c.f6186d) / 1000;
    }

    private static String b(int i, String str, String str2, String str3) {
        k kVar = new k();
        kVar.l("error_code", Integer.valueOf(i));
        kVar.m("account_id", str);
        kVar.m("saved_password", a.g(str3));
        kVar.m("email", a.g(str2));
        kVar.l("since_launch_time", Long.valueOf(a()));
        return i.f(kVar);
    }

    public static void c(String str, String str2, String str3, String str4, String str5) {
        String h = b.d.s.a.a.h();
        k kVar = new k();
        k kVar2 = new k();
        kVar.m("type", str3);
        kVar.m("model", str4);
        kVar.m("WIFI", str2);
        kVar.m(ThingModelDefine.Event.UPLOAD_PARAMS_DEVICE_ID, str);
        f fVar = new f();
        fVar.j(kVar);
        kVar2.j("device_list", fVar);
        kVar2.m("user_email", h);
        String f2 = i.f(kVar2);
        k kVar3 = new k();
        k kVar4 = new k();
        kVar3.m("type", str3);
        kVar3.m("model", str4);
        kVar3.m(FirebaseAnalytics.Param.LOCATION, str5);
        kVar3.m(ThingModelDefine.Event.UPLOAD_PARAMS_DEVICE_ID, str);
        kVar4.j("device_info", kVar3);
        kVar4.m("user_email", h);
        String f3 = i.f(kVar4);
        n.b().f("user_assets", "add_device", f2);
        n.b().f("onboarding", "onboarding_succeed", f3);
    }

    private static void d(String str, String str2, String str3) {
        n.b().f(str, str2, str3);
    }

    public static void e(int i, String str, String str2, String str3) {
        d("onboarding", "check_password_fail", b(i, str, str2, str3));
    }

    public static void f(int i, String str, String str2, String str3) {
        d("onboarding", "check_password_fail_other", b(i, str, str2, str3));
    }

    public static void g(int i) {
        String h = b.d.s.a.a.h();
        k kVar = new k();
        kVar.l("error_code", Integer.valueOf(i));
        kVar.m("user_email", h);
        n.b().f("onboarding", "onboarding_failed", i.f(kVar));
    }

    public static void h(int i, String str, String str2, String str3) {
        d("onboarding", "offline_account_info_empty", b(i, str, str2, str3));
    }

    public static void i(int i, String str, String str2, String str3) {
        d("onboarding", "online_account_info_empty", b(i, str, str2, str3));
    }

    public static void j(int i, String str, String str2, String str3) {
        d("onboarding", "check_password_success", b(i, str, str2, str3));
    }
}
