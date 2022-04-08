package com.tplink.iot.Utils.x0;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.f;
import com.google.gson.k;
import com.tplink.iot.Utils.z0.h;
import com.tplink.libtpnetwork.cameranetwork.business.model.DayOfWeek;
import com.tplink.libtpnetwork.cameranetwork.business.repo.RecordPlanRepository;
import com.tplink.libtpnetwork.cameranetwork.model.Schedule;
import java.util.List;
import java.util.Map;

/* compiled from: CameraSettingsFireBaseUtils.java */
/* loaded from: classes2.dex */
public class g {
    public static void a(String str, boolean z, String str2) {
        h.e("camera_settings", "change_auto_reboot", str, new l("is_on", Boolean.valueOf(z)), new l("auto_reboot_time", str2));
    }

    public static void b(String str, String str2) {
        h.e("camera_settings", "change_device_location", str, new l(FirebaseAnalytics.Param.LOCATION, str2));
    }

    public static void c(String str) {
        h.e("camera_settings", "change_device_name", str, new l[0]);
    }

    public static void d(String str) {
        h.e("camera_settings", "change_device_timezone", str, new l[0]);
    }

    public static void e(String str, boolean z) {
        i("change_LED", str, z);
    }

    public static void f(String str, boolean z) {
        i("change_local_recording", str, z);
    }

    public static void g(String str, boolean z) {
        i("change_rotation", str, z);
    }

    @SuppressLint({"DefaultLocale"})
    public static void h(String str, Map<DayOfWeek, List<Schedule>> map) {
        k kVar = new k();
        k kVar2 = new k();
        kVar2.k("isEnabled", Boolean.valueOf(TextUtils.equals("on", RecordPlanRepository.s(map).getEnabled())));
        kVar2.l("maxPlansPerDay", 10);
        for (Map.Entry<DayOfWeek, List<Schedule>> entry : map.entrySet()) {
            if (entry.getValue().size() > 0) {
                StringBuilder sb = new StringBuilder();
                for (Schedule schedule : entry.getValue()) {
                    sb.append("(");
                    sb.append(String.format("%02d", Integer.valueOf(schedule.getStartHour())));
                    sb.append(String.format("%02d", Integer.valueOf(schedule.getStartMinute())));
                    sb.append("-");
                    sb.append(String.format("%02d", Integer.valueOf(schedule.getEndHour())));
                    sb.append(String.format("%02d", Integer.valueOf(schedule.getEndMinute())));
                    sb.append("-");
                    sb.append(schedule.getType() == 2 ? "detection" : "continuous");
                    sb.append(")");
                }
                kVar2.m(String.valueOf(entry.getKey().ordinal() + 1), sb.toString());
            }
        }
        kVar.j("schedule_config", kVar2);
        h.e("camera_settings", "change_record_schedule", str, new l("schedule_config", kVar2));
    }

    private static void i(String str, String str2, boolean z) {
        h.e("camera_settings", str, str2, new l("is_on", Boolean.valueOf(z)));
    }

    public static void j(String str, boolean z) {
        i("diagnostics_switch", str, z);
    }

    public static void k(String str, boolean z) {
        i("distortion_correction_switch", str, z);
    }

    public static void l(String str) {
        h.e("firmware_update", "firmware_update_click", str, new l[0]);
    }

    public static void m(String... strArr) {
        f fVar = new f();
        for (String str : strArr) {
            fVar.j(h.g(str));
        }
        h.i("firmware_update", "firmware_update_complete", new l("success_upgrade_device_list", fVar));
    }

    public static void n(String str, boolean z) {
        h.e("camera_settings", "osd_log_click", str, new l("isOn", Boolean.valueOf(z)));
    }

    public static void o(String str, boolean z) {
        h.e("camera_settings", "osd_text_click", str, new l("isOn", Boolean.valueOf(z)));
    }

    public static void p(String str, boolean z) {
        h.e("camera_settings", "osd_timestamp_click", str, new l("isOn", Boolean.valueOf(z)));
    }

    public static void q(String str) {
        h.e("camera_settings", "pt_correction_click", str, new l[0]);
    }

    public static void r(String str, boolean z) {
        i("record_audio_switch", str, z);
    }

    public static void s(String... strArr) {
        f fVar = new f();
        for (String str : strArr) {
            fVar.j(h.g(str));
        }
        h.i("camera_settings", "remove_camera_complete", new l("device_list", fVar));
    }

    public static void t(String... strArr) {
        f fVar = new f();
        for (String str : strArr) {
            fVar.j(h.g(str));
        }
        h.i("camera_settings", "remove_camera", new l("device_list", fVar));
    }

    public static void u(String str, boolean z) {
        i("change_upnp", str, z);
    }
}
