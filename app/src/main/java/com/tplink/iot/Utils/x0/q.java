package com.tplink.iot.Utils.x0;

import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.f;
import com.google.gson.k;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.List;

/* compiled from: MeFireBaseUtils.java */
/* loaded from: classes2.dex */
public class q {
    public static void a() {
        h.i("me", "about_click", new l[0]);
    }

    public static void b() {
        h.i("me", "yandex_alice_click", new l[0]);
    }

    public static void c() {
        h.i("me", "amazon_alexa_click", new l[0]);
    }

    public static void d() {
        h.i("me", "camera_memory_click", new l[0]);
    }

    public static void e() {
        h.i("me", "filter_click", new l[0]);
    }

    public static void f() {
        h.i("camera_preference", "camera_preference_click", new l[0]);
    }

    public static void g(boolean z) {
        h.i("camera_preference", "camera_preference_live_tag_click", new l(NotificationCompat.CATEGORY_STATUS, h.c(z)));
    }

    public static void h(boolean z) {
        h.i("camera_preference", "camera_preference_speed_tag_click", new l(NotificationCompat.CATEGORY_STATUS, h.c(z)));
    }

    public static void i(i<Void> iVar) {
        if (iVar != null) {
            h.i(FirebaseAnalytics.Event.SHARE, "share_click_fail", new l("error_code", Integer.valueOf(iVar.b())));
        }
    }

    public static void j(List<BaseALIoTDevice> list) {
        if (!(list == null || list.isEmpty())) {
            f fVar = new f();
            for (int i = 0; i < list.size(); i++) {
                BaseALIoTDevice baseALIoTDevice = list.get(i);
                String deviceType = baseALIoTDevice.getDeviceType();
                String deviceModel = baseALIoTDevice.getDeviceModel();
                String deviceIdMD5 = baseALIoTDevice.getDeviceIdMD5();
                k kVar = new k();
                kVar.m("type", deviceType);
                kVar.m("model", deviceModel);
                kVar.m(ThingModelDefine.Event.UPLOAD_PARAMS_DEVICE_ID, deviceIdMD5);
                fVar.j(kVar);
            }
            h.i(FirebaseAnalytics.Event.SHARE, "share_click_success", new l("device_list", fVar));
        }
    }

    public static void k() {
        h.i("me", "google_assistant_click", new l[0]);
    }

    public static void l() {
        h.i("me", "mail_ru_click", new l[0]);
    }

    public static void m() {
        h.i("me", "notifications_click", new l[0]);
    }

    public static void n(boolean z, String str) {
        h.i("me", "notification_switch", new l("on", Boolean.valueOf(z)), new l("type", str));
    }

    public static void o() {
        h.i(FirebaseAnalytics.Event.SHARE, "remove_accept_share", new l[0]);
    }

    public static void p() {
        h.i("me", "share_blacklist_add", new l[0]);
    }

    public static void q() {
        h.i("me", "device_share_blacklist_click", new l[0]);
    }

    public static void r() {
        h.i(FirebaseAnalytics.Event.SHARE, "remove_all_share", new l[0]);
    }

    public static void s() {
        h.i(FirebaseAnalytics.Event.SHARE, "remove_single_share", new l[0]);
    }

    public static void t() {
        h.i("me", "samsung_smartthings_click", new l[0]);
    }

    public static void u() {
        h.i("me", "voice_control_click", new l[0]);
    }
}
