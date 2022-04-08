package com.tplink.libtpnetwork.Utils;

import android.text.TextUtils;
import b.d.w.c.a;

/* compiled from: TrialIoTEnvironment.java */
/* loaded from: classes3.dex */
public class a0 {
    public static String a() {
        String e2 = e();
        return "dist".equals(e2) ? "prod" : TextUtils.isEmpty(e2) ? "beta" : e2;
    }

    public static String b() {
        return "nbu.iot-app-server.app" + i();
    }

    public static String c() {
        return "nbu.iot-cloud-gateway.app" + i();
    }

    public static String d() {
        return "nbu.iot-security.appdevice" + i();
    }

    public static String e() {
        return o.h0().f("sp_iot_test_environment", "");
    }

    public static String f() {
        return o.h0().f("sp_tapo_care_environment", "");
    }

    public static String g() {
        String str;
        if (!j()) {
            return "tapocare.app.nbu";
        }
        String f2 = f();
        if ("dev".equals(f2)) {
            str = ".alpha";
        } else if (TextUtils.isEmpty(f2) || "dist".equals(f2) || "beta".equals(f2)) {
            str = "";
        } else {
            str = "." + f2;
        }
        return "tapocare.app.nbu" + str;
    }

    public static String h() {
        if (!j()) {
            return "https://tapo.tplinkcloud.com";
        }
        String f2 = f();
        return "dev".equals(f2) ? "https://tapo-alpha.tplinkcloud.com" : "beta2".equals(f2) ? "https://tapo-beta2.tplinkcloud.com" : "beta3".equals(f2) ? "https://tapo-beta3.tplinkcloud.com" : "staging".equals(f2) ? "https://tapo-staging.tplinkcloud.com" : "dist".equals(f2) ? "https://tapo.tplinkcloud.com" : "https://tapo-care-beta.tplinknbu.com";
    }

    private static String i() {
        String e2 = e();
        a.e("test111", "getTestEnvi=" + e2);
        if ("dist".equals(e2)) {
            return "";
        }
        if (TextUtils.isEmpty(e2)) {
            e2 = "beta";
        }
        return "." + e2;
    }

    public static boolean j() {
        return false;
    }

    public static boolean k() {
        return "dist".equals(e());
    }

    public static void l(String str) {
        o.h0().k("sp_iot_test_environment", str);
    }

    public static void m(String str) {
        o.h0().k("sp_tapo_care_environment", str);
    }
}
