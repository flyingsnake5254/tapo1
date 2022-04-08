package com.tplink.iot.Utils.x0;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.f;
import com.google.gson.k;
import com.tplink.iot.Utils.p0;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleAwayMode;
import com.tplink.iot.cloud.bean.thing.common.ThingUsage;
import com.tplink.iot.cloud.enumerate.RuleTimeType;
import com.tplink.libtpcommonstream.stream.control.common.PreviewAudio;
import com.tplink.libtpmediastatistics.SSLClient;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DesiredStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.CountdownRuleBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.ScheduleRuleBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;

/* compiled from: DetailFireBaseUtils.java */
/* loaded from: classes2.dex */
public class i {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailFireBaseUtils.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[RuleTimeType.values().length];
            a = iArr;
            try {
                iArr[RuleTimeType.SUNSET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[RuleTimeType.SUNRISE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[RuleTimeType.NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static void A(String str) {
        h.g("schedule", "delete_schedule", str, new l[0]);
    }

    public static void B(String str, boolean z) {
        l[] lVarArr = new l[1];
        lVarArr[0] = new l(ThingModelDefine.Service.OUTPUT_PARAMS_RESULT, z ? FirebaseAnalytics.Param.SUCCESS : "fail");
        h.g("schedule", "execute_schedule", str, lVarArr);
    }

    public static void C() {
        h.i("detail", "device_share_click", new l[0]);
    }

    public static void D(String str, int i) {
        h.g("detail", "slide_to_change_brightness", str, new l("brightness", Integer.valueOf(i)));
    }

    public static void E(String str, ThingRuleAwayMode thingRuleAwayMode, boolean z, String str2) {
        if (thingRuleAwayMode != null) {
            h.g("away_mode", "start_away_mode", str, new l("start_time_type", a(thingRuleAwayMode.getStartTimeType())), new l("start_time", b(p0.b(thingRuleAwayMode.getStartTimeMin(), z, str2))), new l("end_time_type", a(thingRuleAwayMode.getEndTimeType())), new l("end_time", b(p0.b(thingRuleAwayMode.getEndTimeMin(), z, str2))), new l("repeat_day", c(thingRuleAwayMode.getWeekOfDays())));
        }
    }

    public static void F(String str, CountdownRuleBean countdownRuleBean) {
        BaseALIoTDevice I1;
        if (countdownRuleBean != null && (I1 = TPIoTClientManager.I1(str)) != null) {
            char c2 = I1.isPlug() ? (char) 1 : (!I1.isBulb() || !com.tplink.iot.Utils.w0.a.e(str)) ? (char) 3 : (char) 2;
            int delay = countdownRuleBean.getDelay() / 60;
            k kVar = new k();
            if (countdownRuleBean.getFormatDesiredStates() != null) {
                DesiredStatesBean formatDesiredStates = countdownRuleBean.getFormatDesiredStates();
                kVar.m("device_on", h.c(formatDesiredStates.isOn()));
                if (formatDesiredStates.isOn() && c2 != 1) {
                    if (formatDesiredStates.isAuto()) {
                        kVar.k(ThingModelDefine.Property.PROPERTY_AUTO, Boolean.valueOf(formatDesiredStates.isAuto()));
                        kVar.m(ThingModelDefine.Property.PROPERTY_AUTO_MODE, formatDesiredStates.getAutoMode());
                    } else {
                        kVar.l("brightness", Integer.valueOf(formatDesiredStates.getBrightness()));
                        if (c2 == 2) {
                            kVar.l("color_temperature", Integer.valueOf(formatDesiredStates.getColorTemp()));
                            kVar.l(ThingModelDefine.Property.PROPERTY_HUE, Integer.valueOf(formatDesiredStates.getHue()));
                            kVar.l(ThingModelDefine.Property.PROPERTY_SATURATION, Integer.valueOf(formatDesiredStates.getSaturation()));
                        }
                    }
                }
            } else {
                kVar.m("device_on", h.c("on".equalsIgnoreCase(countdownRuleBean.getAction())));
            }
            h.g("timer", "start_timer", str, new l(ThingModelDefine.Service.INPUT_PARAM_DURATION, Integer.valueOf(delay)), new l("state_info", kVar));
        }
    }

    public static void G(String str) {
        h.g("away_mode", "stop_away_mode_manually", str, new l[0]);
    }

    public static void H(String str) {
        h.g("timer", "stop_timer", str, new l[0]);
    }

    public static String a(RuleTimeType ruleTimeType) {
        if (ruleTimeType == null) {
            return "none";
        }
        int i = a.a[ruleTimeType.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? "none" : "normal" : "sunrise" : "sunset";
    }

    public static String b(int i) {
        StringBuilder sb;
        String str;
        int i2 = (i / 60) % 24;
        int i3 = i % 60;
        if (i2 < 10) {
            sb = new StringBuilder();
            sb.append("0");
        } else {
            sb = new StringBuilder();
            sb.append("");
        }
        sb.append(i2);
        String sb2 = sb.toString();
        if (i3 < 10) {
            str = "0" + i3;
        } else {
            str = "" + i3;
        }
        return sb2 + SSLClient.COLON + str;
    }

    public static f c(int i) {
        f fVar = new f();
        for (int i2 = 0; i2 < 7; i2++) {
            if (((1 << i2) & i) > 0) {
                fVar.k(Integer.valueOf(i2));
            }
        }
        return fVar;
    }

    public static void d(String str, int i) {
        k kVar = new k();
        kVar.l("brightness", Integer.valueOf(i));
        h.g("detail", "preset_click", str, new l("state_info", kVar));
    }

    public static void e(String str, boolean z) {
        h.g("detail", "bulb_on_off", str, new l("device_status", h.c(z)));
    }

    public static void f(String str, String str2) {
        h.g("detail", "change_device_icon", str, new l("device_icon", str2));
    }

    public static void g(String str, String str2) {
        h.g("detail", "change_device_location", str, new l("device_location", str2));
    }

    public static void h(String str, String str2) {
        h.g("detail", "change_device_name", str, new l("device_name", str2));
    }

    public static void i(String str, ScheduleRuleBean scheduleRuleBean) {
        BaseALIoTDevice I1;
        if (scheduleRuleBean != null && (I1 = TPIoTClientManager.I1(str)) != null) {
            char c2 = I1.isPlug() ? (char) 1 : (!I1.isBulb() || !com.tplink.iot.Utils.w0.a.e(str)) ? (char) 3 : (char) 2;
            boolean isEnable = scheduleRuleBean.isEnable();
            RuleTimeType startTimeType = scheduleRuleBean.getStartTimeType();
            int startTimeMin = scheduleRuleBean.getStartTimeMin();
            k kVar = new k();
            kVar.m(PreviewAudio.AUDIO_ENABLE, h.c(isEnable));
            kVar.m("start_time_type", a(startTimeType));
            kVar.l("start_time", Integer.valueOf(startTimeMin));
            if (scheduleRuleBean.getDesiredStates() != null) {
                DesiredStatesBean desiredStates = scheduleRuleBean.getDesiredStates();
                boolean isOn = desiredStates.isOn();
                kVar.m("device_on", h.c(isOn));
                if (isOn && c2 != 1) {
                    if (desiredStates.isAuto()) {
                        kVar.k(ThingModelDefine.Property.PROPERTY_AUTO, Boolean.valueOf(desiredStates.isAuto()));
                        kVar.m(ThingModelDefine.Property.PROPERTY_AUTO_MODE, desiredStates.getAutoMode());
                    } else {
                        kVar.l("brightness", Integer.valueOf(desiredStates.getBrightness()));
                        if (c2 == 2) {
                            kVar.l("color_temperature", Integer.valueOf(desiredStates.getColorTemp()));
                            kVar.l(ThingModelDefine.Property.PROPERTY_HUE, Integer.valueOf(desiredStates.getHue()));
                            kVar.l(ThingModelDefine.Property.PROPERTY_SATURATION, Integer.valueOf(desiredStates.getSaturation()));
                        }
                    }
                }
            } else {
                kVar.m("device_on", h.c(scheduleRuleBean.isActionOn()));
            }
            h.g("schedule", "change_schedule", str, new l("schedule_info", kVar));
        }
    }

    public static void j(String str) {
        h.g("detail", "consumption_chart_past1y", str, new l[0]);
    }

    public static void k(String str) {
        h.g("detail", "consumption_chart_past30d", str, new l[0]);
    }

    public static void l(String str) {
        h.g("detail", "power_chart_past24h", str, new l[0]);
    }

    public static void m(String str) {
        h.g("detail", "power_chart_past7d", str, new l[0]);
    }

    public static void n(String str, LightStateBean lightStateBean) {
        if (lightStateBean != null) {
            k kVar = new k();
            kVar.l("brightness", Integer.valueOf(lightStateBean.getBrightness()));
            kVar.l("color_temperature", Integer.valueOf(lightStateBean.getColorTemp()));
            kVar.l(ThingModelDefine.Property.PROPERTY_HUE, Integer.valueOf(lightStateBean.getHue()));
            kVar.l(ThingModelDefine.Property.PROPERTY_SATURATION, Integer.valueOf(lightStateBean.getSaturation()));
            h.g("detail", "preset_click", str, new l("state_info", kVar));
        }
    }

    public static void o(String str, int i) {
        h.g("detail", "energy_usage_current_power_click", str, new l("current_power", Integer.valueOf(i)));
    }

    public static void p(String str, int i) {
        h.g("detail", "energy_usage_past30d_click", str, new l("usage", Integer.valueOf(i)));
    }

    public static void q(String str, int i) {
        h.g("detail", "energy_usage_today_click", str, new l("usage", Integer.valueOf(i)));
    }

    public static void r() {
        h.i("away_mode", "enter_away_mode_page", new l[0]);
    }

    public static void s() {
        h.i("detail", "enter_detail", new l[0]);
    }

    public static void t(String str, ThingUsage thingUsage) {
        if (thingUsage != null && thingUsage.getTimeUsage() != null) {
            h.g("detail", "time_usage", str, new l("time_usage_in_thirty_days", l.i(thingUsage.getTimeUsage().getPast30())));
        }
    }

    public static void u() {
        h.i("schedule", "enter_schedule_page", new l[0]);
    }

    public static void v() {
        h.i("timer", "enter_timer_page", new l[0]);
    }

    public static void w() {
        h.i("detail", "faq_click", new l[0]);
    }

    public static void x(String str, boolean z) {
        l[] lVarArr = new l[1];
        lVarArr[0] = new l("favorite", z ? "yes" : "no");
        h.g("detail", "detail_favorite", str, lVarArr);
    }

    public static void y(String str, boolean z) {
        h.g("detail", "plug_on_off", str, new l("device_status", h.c(z)));
    }

    public static void z(int i) {
        h.i("schedule", "schedule_count", new l("schedule_count", Integer.valueOf(i)));
    }
}
