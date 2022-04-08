package com.tplink.iot.Utils.x0;

import androidx.core.app.NotificationCompat;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;

/* compiled from: TapoCareFireBaseUtils.java */
/* loaded from: classes2.dex */
public class w {
    public static void A(String str, boolean z) {
        l[] lVarArr = new l[1];
        lVarArr[0] = new l(NotificationCompat.CATEGORY_STATUS, z ? "on" : "off");
        h.g("tapocare", "pd", str, lVarArr);
    }

    public static void B(String str, long j, String str2) {
        h.g("tapocare", "play_clips", str, new l(ThingModelDefine.Service.INPUT_PARAM_DURATION, Long.valueOf(j)), new l("uuid", str2));
    }

    public static void C(String str, long j) {
        h.g("tapocare", "play_clips_me", str, new l(ThingModelDefine.Service.INPUT_PARAM_DURATION, Long.valueOf(j)));
    }

    public static void D(String str) {
        h.i("tapocare", "tapo_care_purchase_stop_by_system", new l("error_code", str));
    }

    public static void E(String str) {
        h.i("tapocare", "tapo_care_purchase_receipt_account_match_error", new l("error_code", str));
    }

    public static void F(String str) {
        h.i("tapocare", "tapo_care_purchase_receipt_verify_error", new l("error_code", str));
    }

    public static void G() {
        h.i("tapocare", "showed_subscription_entrance", new l[0]);
    }

    public static void H(String str) {
        h.g("tapocare", "showed_trial_entrance", str, new l[0]);
    }

    public static void I(String str, boolean z) {
        l[] lVarArr = new l[1];
        lVarArr[0] = new l(NotificationCompat.CATEGORY_STATUS, z ? "on" : "off");
        h.g("tapocare", "target_track", str, lVarArr);
    }

    public static void J(String str) {
        h.e("tapocare", "click_tapo_care_learn_more_button_welcom_page", str, new l[0]);
    }

    public static void a(String str, boolean z, String str2) {
        l[] lVarArr = new l[2];
        lVarArr[0] = new l(NotificationCompat.CATEGORY_STATUS, z ? "on" : "off");
        lVarArr[1] = new l("sensitivity", str2);
        h.g("tapocare", "bcd", str, lVarArr);
    }

    public static void b(String str, boolean z, int i) {
        l[] lVarArr = new l[2];
        lVarArr[0] = new l("number", Integer.valueOf(i));
        lVarArr[1] = new l(NotificationCompat.CATEGORY_STATUS, z ? "on" : "off");
        h.g("tapocare", "block_zone", str, lVarArr);
    }

    public static void c(String str) {
        h.g("tapocare", "click_tapo_care_subscribe_ai_detection", str, new l[0]);
    }

    public static void d(String str) {
        h.g("tapocare", "click_tapo_care_trial_ai_detection", str, new l[0]);
    }

    public static void e() {
        h.i("tapocare", "click_tapo_care_cloud_video_me", new l[0]);
    }

    public static void f(String str) {
        h.g("tapocare", "click_tapo_care_subscribe_motion_tracking", str, new l[0]);
    }

    public static void g(String str) {
        h.g("tapocare", "click_tapo_care_trial_motion_tracking", str, new l[0]);
    }

    public static void h(String str) {
        h.g("tapocare", "click_tapo_care_subscribe_privacy_mask", str, new l[0]);
    }

    public static void i(String str) {
        h.g("tapocare", "click_tapo_care_trial_privacy_mask", str, new l[0]);
    }

    public static void j(String str) {
        h.g("tapocare", "click_tapo_care_subscribe_rich_notification", str, new l[0]);
    }

    public static void k(String str) {
        h.g("tapocare", "click_tapo_care_trial_rich_notification", str, new l[0]);
    }

    public static void l(String str) {
        h.g("tapocare", "click_tapo_care_cloud_service_ipc_setting", str, new l[0]);
    }

    public static void m() {
        h.i("tapocare", "click_tapo_care_cloud_video_list", new l[0]);
    }

    public static void n(String str) {
        h.g("tapocare", "click_tapo_care_control_button_ipc_detail", str, new l[0]);
    }

    public static void o() {
        h.i("tapocare", "click_tapo_care_ipc_detail", new l[0]);
    }

    public static void p() {
        h.i("tapocare", "click_tapo_care_manage_subscription_ipc_detail", new l[0]);
    }

    public static void q() {
        h.i("tapocare", "click_tapo_care_me", new l[0]);
    }

    public static void r() {
        h.i("tapocare", "click_tapo_care_preview", new l[0]);
    }

    public static void s() {
        h.i("tapocare", "click_tapo_care_trial_ipc_detail", new l[0]);
    }

    public static void t(String str, boolean z, int i) {
        l[] lVarArr = new l[2];
        lVarArr[0] = new l(NotificationCompat.CATEGORY_STATUS, z ? "on" : "off");
        lVarArr[1] = new l("days_left", Integer.valueOf(i));
        h.g("tapocare", "click_tapo_care_trial_ipc_settings", str, lVarArr);
    }

    public static void u() {
        h.i("tapocare", "click_tapo_care_upgrade_now_ipc_detail", new l[0]);
    }

    public static void v(String str) {
        h.i("tapocare", "click_tapo_care_close_banner", new l("page", str));
    }

    public static void w(String str, String str2) {
        h.e("tapocare", "click_tapo_care_close_banner", str, new l("page", str2));
    }

    public static void x(String str) {
        h.g("tapocare", "delete_cloud_video", str, new l[0]);
    }

    public static void y(String str, long j, String str2) {
        h.g("tapocare", "download_clips", str, new l(ThingModelDefine.Service.INPUT_PARAM_DURATION, Long.valueOf(j)), new l("uuid", str2));
    }

    public static void z(String str) {
        h.i("tapocare", "tapo_care_purchase_get_product_list_error", new l("error_code", str));
    }
}
