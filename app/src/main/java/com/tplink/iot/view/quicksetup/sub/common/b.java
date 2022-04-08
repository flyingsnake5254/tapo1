package com.tplink.iot.view.quicksetup.sub.common;

import androidx.annotation.StringRes;
import com.tplink.iot.R;
import com.tplink.iot.view.quicksetup.sub.common.e;
import com.tplink.libtpnetwork.enumerate.EnumContactSensorAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.j;

/* compiled from: ContactSensorSetupResources.kt */
/* loaded from: classes2.dex */
public final class b implements e {
    @Override // com.tplink.iot.view.quicksetup.sub.common.e
    public String a() {
        return p(R.string.subg_qs_remove_cover_the_cover, new Object[0]);
    }

    @Override // com.tplink.iot.view.quicksetup.sub.common.e
    public String b() {
        return p(R.string.subg_qs_remove_cover_hint_t110, new Object[0]);
    }

    @Override // com.tplink.iot.view.quicksetup.sub.common.e
    public String c() {
        return p(R.string.subg_qs_no_found_reset_hint_V2, 5);
    }

    @Override // com.tplink.iot.view.quicksetup.sub.common.e
    public int d() {
        return R.drawable.reset_sensor_t110_led;
    }

    @Override // com.tplink.iot.view.quicksetup.sub.common.e
    public int e() {
        return R.drawable.power_up_t110;
    }

    @Override // com.tplink.iot.view.quicksetup.sub.common.e
    public EnumDeviceType f() {
        return EnumDeviceType.SENSOR;
    }

    @Override // com.tplink.iot.view.quicksetup.sub.common.e
    public int[] g() {
        return null;
    }

    @Override // com.tplink.iot.view.quicksetup.sub.common.e
    public int h() {
        return R.drawable.sensor_t110_animate;
    }

    @Override // com.tplink.iot.view.quicksetup.sub.common.e
    public String i() {
        return p(R.string.iot_contact_sensor, new Object[0]);
    }

    @Override // com.tplink.iot.view.quicksetup.sub.common.e
    public int j() {
        return R.drawable.remove_cover_t110;
    }

    @Override // com.tplink.iot.view.quicksetup.sub.common.e
    public List<String> k() {
        EnumContactSensorAvatarType[] values = EnumContactSensorAvatarType.values();
        ArrayList arrayList = new ArrayList(values.length);
        for (EnumContactSensorAvatarType enumContactSensorAvatarType : values) {
            arrayList.add(enumContactSensorAvatarType.getValue());
        }
        return arrayList;
    }

    @Override // com.tplink.iot.view.quicksetup.sub.common.e
    public int l() {
        return R.drawable.reset_sensor_t110_led;
    }

    @Override // com.tplink.iot.view.quicksetup.sub.common.e
    public String m() {
        return p(R.string.subg_qs_check_status_led_V3, 5);
    }

    @Override // com.tplink.iot.view.quicksetup.sub.common.e
    public String n() {
        return p(R.string.subg_qs_power_up_device_hint_t110_V2, new Object[0]);
    }

    @Override // com.tplink.iot.view.quicksetup.sub.common.e
    public int o() {
        return R.drawable.complete_t110;
    }

    public String p(@StringRes int i, Object... formatArgs) {
        j.e(formatArgs, "formatArgs");
        return e.c.a(this, i, formatArgs);
    }
}
