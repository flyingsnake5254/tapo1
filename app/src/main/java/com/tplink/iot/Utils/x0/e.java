package com.tplink.iot.Utils.x0;

import android.text.TextUtils;
import com.github.mikephil.charting.utils.Utils;
import com.google.gson.k;
import com.tplink.libtpappcommonmedia.bean.stream.BitStreamType;
import com.tplink.libtpmediastatistics.SSLClient;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.math.BigDecimal;
import java.util.Calendar;

/* compiled from: CameraMainFireBaseUtils.java */
/* loaded from: classes2.dex */
public class e {
    public static void A(String str, double d2) {
        h.e("detail", "talk_end", str, new l(ThingModelDefine.Service.INPUT_PARAM_DURATION, Double.valueOf(a(d2))));
    }

    public static void B(String str) {
        h.e("detail", "reach_max_count_of_viewer_live", str, new l[0]);
    }

    public static void C(String str) {
        h.e("detail", "reach_max_count_of_viewer_playback", str, new l[0]);
    }

    public static void D(String str, double d2) {
        h.e("detail", "voice_call_end", str, new l(ThingModelDefine.Service.INPUT_PARAM_DURATION, Double.valueOf(a(d2))));
    }

    public static void E(String str, boolean z) {
        h.e("detail", "voice_call_mute_click", str, new l("is_on", Boolean.valueOf(z)));
    }

    public static void F(String str, boolean z) {
        h.e("detail", "voice_call_speaker_click", str, new l("is_on", Boolean.valueOf(z)));
    }

    private static double a(double d2) {
        return new BigDecimal(d2).setScale(2, 4).doubleValue();
    }

    private static k b() {
        k kVar = new k();
        kVar.m("type", "SMART.IPCAMERA");
        return kVar;
    }

    public static void c() {
        h.i("away_mode", "start_away_mode", new l("device_info", b()));
    }

    public static void d(String str) {
        h.e("detail", "change_live_view", str, new l[0]);
    }

    public static void e(String str, double d2) {
        h.e("detail", "change_microphone", str, new l(ThingModelDefine.Service.INPUT_PARAM_VOLUME, Double.valueOf(a(d2))));
    }

    public static void f(String str) {
        h.e("detail", "change_quality", str, new l[0]);
    }

    public static void g(String str, double d2) {
        h.e("detail", "change_speaker", str, new l(ThingModelDefine.Service.INPUT_PARAM_VOLUME, Double.valueOf(d2)));
    }

    public static void h(String str) {
        h.e("detail", "cruise_click", str, new l[0]);
    }

    public static void i(String str) {
        h.e("detail", "cruise_stop", str, new l[0]);
    }

    public static void j(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(currentTimeMillis);
        h.e("detail", "enter_privacy_mode", str, new l(RtspHeaders.Values.TIME, instance.get(11) + SSLClient.COLON + instance.get(12) + SSLClient.COLON + instance.get(13)));
    }

    public static void k() {
        h.i("home_mode", "start_home_mode", new l("device_info", b()));
    }

    public static void l(String str) {
        h.e("detail", "joystick_click", str, new l[0]);
    }

    public static void m(String str, double d2, BitStreamType bitStreamType, String str2, boolean z, boolean z2, String str3) {
        if (d2 >= Utils.DOUBLE_EPSILON) {
            if (TextUtils.isEmpty(str3)) {
                str3 = BitStreamType.MINOR_VGA.equals(bitStreamType) ? "lq" : "hq";
            }
            h.e("detail", "live_end", str, new l(ThingModelDefine.Service.INPUT_PARAM_DURATION, Double.valueOf(a(d2))), new l("quality", str3), new l("connect_type", str2), new l("screen_type", z ? "fourscreen" : z2 ? "fullscreen" : "portrait"));
        }
    }

    public static void n(String str) {
        h.e("camera_preview", "manage_click", str, new l[0]);
    }

    public static void o(String str) {
        h.e("detail", "mark_succeed", str, new l[0]);
    }

    public static void p(String str) {
        h.e("camera_preview", "play_click", str, new l[0]);
    }

    public static void q(String str, double d2, String str2) {
        h.e("detail", "playback_end", str, new l(ThingModelDefine.Service.INPUT_PARAM_DURATION, Double.valueOf(a(d2))), new l("connect_type", str2));
    }

    public static void r() {
        h.i("camera_preview", "change_mode_success", new l("device_info", b()));
    }

    public static void s(String str, double d2, String str2) {
        if (d2 >= Utils.DOUBLE_EPSILON) {
            h.e("camera_preview", "preview_end", str, new l(ThingModelDefine.Service.INPUT_PARAM_DURATION, Double.valueOf(a(d2))), new l("connect_type", str2));
        }
    }

    public static void t(String str) {
        h.e("detail", "record_click", str, new l[0]);
    }

    public static void u(String str) {
        h.e("detail", "resume_play", str, new l[0]);
    }

    public static void v(String str) {
        h.e("detail", "screenshot_click", str, new l[0]);
    }

    public static void w(String str) {
        h.e("detail", "sdcard_user_count", str, new l[0]);
    }

    public static void x() {
        h.e("memory", "share_click", null, new l[0]);
    }

    public static void y(String str, boolean z) {
        l[] lVarArr = new l[1];
        lVarArr[0] = new l("sound_status", z ? "on" : "off");
        h.e("camera_preview", "sound_click", str, lVarArr);
    }

    public static void z(String str, boolean z) {
        h.e("detail", "speaker_click", str, new l("is_on", Boolean.valueOf(z)));
    }
}
