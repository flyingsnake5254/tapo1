package com.tplink.libtpnetwork.Utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import b.d.w.g.a;
import com.google.gson.k;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.cloud.define.EnumAccountStatus;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.WirelessInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import com.tplink.libtputility.security.PlainEncryptKeyDelegate;
import com.tplink.libtputility.security.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SP.java */
/* loaded from: classes3.dex */
public class o extends a {

    /* renamed from: c  reason: collision with root package name */
    private static Context f14082c;

    /* renamed from: d  reason: collision with root package name */
    private static volatile o f14083d;

    /* renamed from: e  reason: collision with root package name */
    private com.tplink.libtputility.security.a f14084e;

    private o() {
        super(f14082c, "aria_sp");
        q0();
    }

    public static String E() {
        String cloudUserName = b.d.s.a.a.f().c().getCloudUserName();
        return !TextUtils.isEmpty(cloudUserName) ? b.d.w.h.a.g(cloudUserName) : "";
    }

    public static void G0(Context context) {
        f14082c = context;
    }

    public static Set<String> M() {
        o h0 = h0();
        return h0.g("sp_home_mode_can_show_device" + E());
    }

    public static void N0() {
        o h0 = h0();
        h0.h("sp_first_edit_away_mode" + E(), false);
    }

    public static void O0() {
        o h0 = h0();
        h0.h("sp_first_edit_home_mode" + E(), false);
    }

    public static void S0(Set<String> set) {
        o h0 = h0();
        h0.m("sp_home_mode_can_show_device" + E(), set);
    }

    public static o h0() {
        if (f14083d == null) {
            synchronized (o.class) {
                if (f14083d == null) {
                    f14083d = new o();
                }
            }
        }
        return f14083d;
    }

    public static boolean k0() {
        o h0 = h0();
        return h0.c("sp_first_edit_away_mode" + E(), true);
    }

    public static boolean l0() {
        o h0 = h0();
        return h0.c("sp_first_edit_home_mode" + E(), true);
    }

    private void o() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, ?> entry : b().entrySet()) {
            if (entry.getValue() instanceof String) {
                arrayList.add(entry.getKey());
            }
        }
        n(arrayList);
    }

    private void q0() {
        b c2 = b.c();
        if (!c2.f("deco_sp_file_key") || !a("deco_sp_key") || !a("deco_sp_vector")) {
            c2.e(f14082c, "deco_sp_file_key");
            if (a("deco_sp_key") || a("deco_sp_vector")) {
                o();
            }
            HashMap hashMap = new HashMap();
            com.tplink.libtputility.security.a aVar = new com.tplink.libtputility.security.a();
            this.f14084e = aVar;
            String h = aVar.h();
            String g = this.f14084e.g();
            String b2 = c2.b(h, "deco_sp_file_key");
            String b3 = c2.b(g, "deco_sp_file_key");
            if (b2 == null || b2.isEmpty() || b3 == null || b3.isEmpty()) {
                this.f14084e = null;
                return;
            }
            hashMap.put("deco_sp_key", b2);
            hashMap.put("deco_sp_vector", b3);
            l(hashMap);
            return;
        }
        String f2 = super.f("deco_sp_key", "");
        String f3 = super.f("deco_sp_vector", "");
        if (f2.isEmpty() || f3.isEmpty()) {
            this.f14084e = r(c2);
            return;
        }
        String a = c2.a(f2, "deco_sp_file_key");
        String a2 = c2.a(f3, "deco_sp_file_key");
        if (a == null || a.isEmpty() || a2 == null || a2.isEmpty()) {
            this.f14084e = r(c2);
        } else {
            this.f14084e = new com.tplink.libtputility.security.a(a, a2);
        }
    }

    private com.tplink.libtputility.security.a r(b bVar) {
        o();
        com.tplink.libtputility.security.a aVar = new com.tplink.libtputility.security.a();
        String h = aVar.h();
        String g = aVar.g();
        String b2 = bVar.b(h, "deco_sp_file_key");
        String b3 = bVar.b(g, "deco_sp_file_key");
        if (b2 == null || b2.isEmpty() || b3 == null || b3.isEmpty()) {
            return null;
        }
        super.k("deco_sp_key", b2);
        super.k("deco_sp_vector", b3);
        return aVar;
    }

    public static Set<String> x() {
        o h0 = h0();
        return h0.g("sp_away_mode_can_show_device" + E());
    }

    private String y() {
        return "key_has_connected_ap_list" + b.d.s.a.a.f().c().getCloudUserName();
    }

    public static void z0(Set<String> set) {
        o h0 = h0();
        h0.m("sp_away_mode_can_show_device" + E(), set);
    }

    public String A(String str) {
        return f("sp_camera_need_pay_function_list" + str, null);
    }

    public void A0(String str, String str2) {
        k("sp_camera_need_pay_function_list" + str, str2);
    }

    public boolean B(String str) {
        return c("sp_showed_conflict_flag_" + b.d.w.h.a.g(E() + str), true);
    }

    public void B0() {
        h("first_time_apply_camera_permission", false);
    }

    public boolean C(String str) {
        return c("sp_cloud_video_has_show_" + b.d.w.h.a.g(str), false);
    }

    public void C0(String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("sp_showed_conflict_flag_");
        sb.append(b.d.w.h.a.g(E() + str));
        h(sb.toString(), z);
    }

    public boolean D() {
        return c("sp_color_bulb_guide_set_preset_key", false);
    }

    public void D0() {
        h("sp_check_google_service" + E(), true);
    }

    public void E0(String str, boolean z) {
        h("sp_cloud_video_has_show_" + b.d.w.h.a.g(str), z);
    }

    public long F() {
        return e("sp_detail_banner_close_time_" + E(), 0L);
    }

    public void F0(boolean z) {
        h("sp_color_bulb_guide_set_preset_key", z);
    }

    public long G() {
        return e("sp_detail_banner_close_time_" + E(), 0L);
    }

    public long H() {
        return e("sp_downgrade_timestamp_" + E(), 0L);
    }

    public void H0(long j) {
        j("sp_detail_banner_close_time_" + E(), j);
    }

    public int I() {
        return d("sp_downgrade_handel_show_times_" + E(), 0);
    }

    public void I0(long j) {
        j("sp_detail_banner_close_time_" + E(), j);
    }

    public boolean J(String str) {
        if (str == null) {
            return false;
        }
        return c("sp_email_topic_has_subscribe_" + b.d.w.h.a.g(str), false);
    }

    public void J0(long j) {
        j("sp_downgrade_timestamp_" + E(), j);
    }

    public int K(String str) {
        if (str == null) {
            return 0;
        }
        return d("sp_email_topic_has_show_times_" + b.d.w.h.a.g(str), 0);
    }

    public void K0(int i) {
        i("sp_downgrade_handel_show_times_" + E(), i);
    }

    public boolean L() {
        return c("key_region_different_utc_" + E(), false);
    }

    public void L0(String str, boolean z) {
        if (str != null) {
            h("sp_email_topic_has_subscribe_" + b.d.w.h.a.g(str), z);
        }
    }

    public void M0(String str, int i) {
        if (str != null) {
            i("sp_email_topic_has_show_times_" + b.d.w.h.a.g(str), i);
        }
    }

    public boolean N() {
        return c("sp_is_first_open_music_rhyme", true);
    }

    public boolean O() {
        return c("is_first_show_home_tips", true);
    }

    public TCAccountBean P() {
        String f2 = f("LAST_LOGIN_ACCOUNT_KEY", "");
        if (TextUtils.isEmpty(f2)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(f2);
            String optString = jSONObject.optString("cloudUserName", "");
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            String optString2 = jSONObject.optString("cloudPassword");
            TCAccountBean tCAccountBean = new TCAccountBean();
            com.tplink.libtputility.security.a aVar = new com.tplink.libtputility.security.a(b.d.w.h.a.f(PlainEncryptKeyDelegate.a(f14082c).getBytes("utf-8")), null, "AES");
            tCAccountBean.setCloudUserName(new String(aVar.b(b.d.w.h.a.j(optString))));
            if (!TextUtils.isEmpty(optString2)) {
                tCAccountBean.setPassword(new String(aVar.b(b.d.w.h.a.j(optString2))));
            }
            tCAccountBean.setEmail(jSONObject.optString("email"));
            tCAccountBean.setUserName(jSONObject.optString("username"));
            tCAccountBean.setPhone(jSONObject.optString("phone"));
            tCAccountBean.setNickName(jSONObject.optString(ThingModelDefine.Event.UPLOAD_PARAMS_NICKNAME));
            tCAccountBean.setRegTime(jSONObject.optString("regTime"));
            tCAccountBean.setAccountStatus(EnumAccountStatus.getStatusByInt(jSONObject.optInt(NotificationCompat.CATEGORY_STATUS)));
            String optString3 = jSONObject.optString("token");
            if (!TextUtils.isEmpty(optString3)) {
                tCAccountBean.setToken(new String(aVar.b(b.d.w.h.a.j(optString3))));
            }
            String optString4 = jSONObject.optString("refreshToken");
            if (!TextUtils.isEmpty(optString4)) {
                tCAccountBean.setRefreshToken(new String(aVar.b(b.d.w.h.a.j(optString4))));
            }
            return tCAccountBean;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public void P0() {
        h("sp_voice_control_guide_key_" + E(), true);
    }

    public String Q() {
        return f("last_post_fcm_token", null);
    }

    public void Q0() {
        h("sp_subscribe_msg_init_flag_" + E(), true);
    }

    public long R(String str) {
        if (str == null) {
            return 0L;
        }
        return e("sp_last_time_email_topic_show_" + b.d.w.h.a.g(str), 0L);
    }

    public void R0() {
        h("key_region_different_utc_" + E(), true);
    }

    public String S(String str) {
        return f("latest_iot_device_cache_" + str, "");
    }

    public boolean T() {
        return c("sp_light_strip_guide_set_preset_key", false);
    }

    public void T0(boolean z) {
        h("sp_is_first_open_music_rhyme", z);
    }

    public long U() {
        return e("sp_preview_banner_close_time_" + E(), 0L);
    }

    public void U0(boolean z) {
        h("is_first_show_home_tips", z);
    }

    public String V(String str) {
        List<WirelessInfoParams> list;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            list = i.e(f(y(), ""), WirelessInfoParams.class);
        } catch (Exception unused) {
            list = new ArrayList();
        }
        if (list != null && !list.isEmpty()) {
            for (WirelessInfoParams wirelessInfoParams : list) {
                if (TextUtils.equals(wirelessInfoParams.getSsid(), str)) {
                    return wirelessInfoParams.getPassword();
                }
            }
        }
        return null;
    }

    public void V0(String str) {
        if (str != null) {
            k("last_post_fcm_token", str);
        }
    }

    public long W() {
        return e("sp_sys_notification_disabled_timestamp", 0L);
    }

    public void W0(String str, long j) {
        if (str != null) {
            j("sp_last_time_email_topic_show_" + b.d.w.h.a.g(str), j);
        }
    }

    public int X() {
        return d("sp_smart_fragment_index", 0);
    }

    public void X0(String str, String str2) {
        k("latest_iot_device_cache_" + str, str2);
    }

    public boolean Y(String str) {
        if (str == null) {
            return false;
        }
        return c("sp_storage_services_one_has_show_" + b.d.w.h.a.g(str), false);
    }

    public void Y0(boolean z) {
        h("sp_light_strip_guide_set_preset_key", z);
    }

    public boolean Z(String str) {
        if (str == null) {
            return false;
        }
        return c("sp_storage_services_seven_has_show_" + b.d.w.h.a.g(str), false);
    }

    public void Z0(long j) {
        j("sp_preview_banner_close_time_" + E(), j);
    }

    public boolean a0(String str) {
        if (str == null) {
            return false;
        }
        return c("sp_storage_services_three_has_show_" + b.d.w.h.a.g(str), false);
    }

    public void a1(WirelessInfoParams wirelessInfoParams) {
        List<WirelessInfoParams> z = z();
        if (!z.isEmpty()) {
            Iterator<WirelessInfoParams> it = z.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(it.next().getSsid(), wirelessInfoParams.getSsid())) {
                    it.remove();
                }
            }
        }
        z.add(0, wirelessInfoParams);
        k(y(), i.f(z));
    }

    public boolean b0() {
        return c("sp_subscribe_msg_firmware_" + E(), true);
    }

    public void b1(long j) {
        j("sp_sys_notification_disabled_timestamp", j);
    }

    public boolean c0() {
        return c("sp_subscribe_msg_iac_market_promotion_" + E(), true);
    }

    public void c1(boolean z) {
        h("sp_first_click_preview_mode_" + E(), z);
    }

    public boolean d0() {
        return c("sp_subscribe_msg_init_flag_" + E(), false);
    }

    public void d1(String str, boolean z) {
        if (str != null) {
            h("sp_storage_services_one_has_show_" + b.d.w.h.a.g(str), z);
        }
    }

    public boolean e0() {
        return c("sp_subscribe_msg_sdcard_" + E(), true);
    }

    public void e1(String str, boolean z) {
        if (str != null) {
            h("sp_storage_services_seven_has_show_" + b.d.w.h.a.g(str), z);
        }
    }

    @Override // b.d.w.g.a
    public String f(String str, String str2) {
        if (this.f14084e == null) {
            return super.f(str, str2);
        }
        if (b.d.w.h.b.c(str)) {
            str = b.d.w.h.a.g(str);
        }
        if (!a(str)) {
            return str2;
        }
        try {
            return this.f14084e.a(super.f(str, str2));
        } catch (Exception e2) {
            b.d.w.c.a.d(e2.toString());
            return str2;
        }
    }

    public boolean f0() {
        return c("sp_switch_vibrate_key", true);
    }

    public void f1(String str, boolean z) {
        if (str != null) {
            h("sp_storage_services_three_has_show_" + b.d.w.h.a.g(str), z);
        }
    }

    public boolean g0(String str) {
        if (str == null) {
            return false;
        }
        return c("sp_un_favorite_device_in_all_" + b.d.w.h.a.g(str), false);
    }

    public void g1(boolean z) {
        h("sp_subscribe_msg_firmware_" + E(), z);
    }

    public void h1(boolean z) {
        h("sp_subscribe_msg_iac_market_promotion_" + E(), z);
    }

    public boolean i0() {
        return c("sp_check_google_service" + E(), false);
    }

    public void i1(boolean z) {
        h("sp_subscribe_msg_sdcard_" + E(), z);
    }

    public boolean j0() {
        return c("sp_first_click_preview_mode_" + E(), true);
    }

    public void j1(boolean z) {
        h("sp_switch_vibrate_key", z);
    }

    @Override // b.d.w.g.a
    public void k(String str, String str2) {
        String c2;
        if (this.f14084e != null) {
            if (b.d.w.h.b.c(str)) {
                str = b.d.w.h.a.g(str);
            }
            if (str2 == null) {
                c2 = null;
            } else {
                try {
                    c2 = this.f14084e.c(str2);
                } catch (Exception e2) {
                    b.d.w.c.a.d(e2.toString());
                    return;
                }
            }
            super.k(str, c2);
            return;
        }
        super.k(str, str2);
    }

    public void k1(String str, boolean z) {
        if (str != null) {
            h("sp_un_favorite_device_in_all_" + b.d.w.h.a.g(str), z);
        }
    }

    public void l1(String str) {
        h("sp_showed_subscription_entrance_" + b.d.w.h.a.g(str), true);
    }

    public boolean m0() {
        return c("first_time_apply_camera_permission", true);
    }

    public void m1(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("sp_showed_subscription_entrance_");
        sb.append(b.d.w.h.a.g(str + str2));
        h(sb.toString(), true);
    }

    public boolean n0() {
        return c("sp_voice_control_guide_key_" + E(), false);
    }

    public boolean o0(String str) {
        return c("sp_showed_subscription_entrance_" + b.d.w.h.a.g(str), false);
    }

    public void p() {
        String f2 = f("LAST_LOGIN_ACCOUNT_KEY", "");
        if (!TextUtils.isEmpty(f2)) {
            try {
                JSONObject jSONObject = new JSONObject(f2);
                jSONObject.put("cloudPassword", "");
                jSONObject.put("token", "");
                jSONObject.put("refreshToken", "");
                k("LAST_LOGIN_ACCOUNT_KEY", jSONObject.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean p0(String str, String str2) {
        return c("sp_showed_subscription_entrance_" + b.d.w.h.a.g(str + str2), false);
    }

    public void q() {
        p();
        if (!u()) {
            k("LAST_LOGIN_ACCOUNT_KEY", new k().toString());
        }
    }

    public void r0(WirelessInfoParams wirelessInfoParams) {
        List<WirelessInfoParams> z = z();
        if (!z.isEmpty()) {
            Iterator<WirelessInfoParams> it = z.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (TextUtils.equals(it.next().getSsid(), wirelessInfoParams.getSsid())) {
                        it.remove();
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        k(y(), i.f(z));
    }

    public String s(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f("ACCOUNT_NICKNAME_PREFIX_" + b.d.w.h.a.g(str), "");
    }

    public void s0(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            k("ACCOUNT_NICKNAME_PREFIX_" + b.d.w.h.a.g(str), str2);
        }
    }

    public String t(String str) {
        if (str == null) {
            return null;
        }
        return f("sp_choose_region_" + b.d.w.h.a.g(str), null);
    }

    public void t0(TCAccountBean tCAccountBean) {
        if (tCAccountBean != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(tCAccountBean.getEmail())) {
                    jSONObject.put("email", tCAccountBean.getEmail());
                }
                if (!TextUtils.isEmpty(tCAccountBean.getUserName())) {
                    jSONObject.put("username", tCAccountBean.getUserName());
                }
                if (!TextUtils.isEmpty(tCAccountBean.getPhone())) {
                    jSONObject.put("phone", tCAccountBean.getPhone());
                }
                com.tplink.libtputility.security.a aVar = new com.tplink.libtputility.security.a(b.d.w.h.a.f(PlainEncryptKeyDelegate.a(f14082c).getBytes("utf-8")), null, "AES");
                if (!TextUtils.isEmpty(tCAccountBean.getCloudUserName())) {
                    jSONObject.put("cloudUserName", b.d.w.h.a.l(aVar.d(tCAccountBean.getCloudUserName().getBytes())));
                }
                if (!TextUtils.isEmpty(tCAccountBean.getPassword())) {
                    jSONObject.put("cloudPassword", b.d.w.h.a.l(aVar.d(tCAccountBean.getPassword().getBytes())));
                }
                if (!TextUtils.isEmpty(tCAccountBean.getNickName())) {
                    jSONObject.put(ThingModelDefine.Event.UPLOAD_PARAMS_NICKNAME, tCAccountBean.getNickName());
                }
                if (!TextUtils.isEmpty(tCAccountBean.getRegTime())) {
                    jSONObject.put("regTime", tCAccountBean.getRegTime());
                }
                jSONObject.put(NotificationCompat.CATEGORY_STATUS, tCAccountBean.getAccountStatus().getValue());
                if (!TextUtils.isEmpty(tCAccountBean.getToken())) {
                    jSONObject.put("token", b.d.w.h.a.l(aVar.d(tCAccountBean.getToken().getBytes())));
                }
                if (!TextUtils.isEmpty(tCAccountBean.getRefreshToken())) {
                    jSONObject.put("refreshToken", b.d.w.h.a.l(aVar.d(tCAccountBean.getToken().getBytes())));
                }
                k("LAST_LOGIN_ACCOUNT_KEY", jSONObject.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public boolean u() {
        return c("accountRememberMe", true);
    }

    public void u0(int i) {
        i("sp_smart_fragment_index", i);
    }

    public boolean v() {
        return c("first_time_active_login_user", false);
    }

    public void v0(String str, String str2) {
        if (str != null && str2 != null) {
            k("sp_choose_region_" + b.d.w.h.a.g(str), str2);
        }
    }

    public long w(String str) {
        return e("app_marketing_last_query_time_" + str, 0L);
    }

    public void w0(boolean z) {
        h("accountRememberMe", z);
    }

    public void x0(boolean z) {
        h("first_time_active_login_user", z);
    }

    public void y0(String str, long j) {
        j("app_marketing_last_query_time_" + str, j);
    }

    public List<WirelessInfoParams> z() {
        List<WirelessInfoParams> list;
        try {
            list = i.e(f(y(), ""), WirelessInfoParams.class);
        } catch (Exception unused) {
            list = new ArrayList<>();
        }
        return list == null ? new ArrayList() : list;
    }
}
