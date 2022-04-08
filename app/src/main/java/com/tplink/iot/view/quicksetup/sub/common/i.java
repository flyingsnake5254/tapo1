package com.tplink.iot.view.quicksetup.sub.common;

import androidx.annotation.StringRes;
import com.tplink.iot.R;
import com.tplink.iot.view.quicksetup.sub.common.e;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.libtpnetwork.enumerate.EnumTRVAvatarType;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.j;

/* compiled from: TRVSetupResources.kt */
/* loaded from: classes2.dex */
public final class i implements e {
    @Override // com.tplink.iot.view.quicksetup.sub.common.e
    public String a() {
        return p(R.string.subg_qs_remove_cover_the_cover, new Object[0]);
    }

    @Override // com.tplink.iot.view.quicksetup.sub.common.e
    public String b() {
        return p(R.string.subg_qs_remove_cover_hint_t100, new Object[0]);
    }

    @Override // com.tplink.iot.view.quicksetup.sub.common.e
    public String c() {
        return p(R.string.subg_qs_press_reset_button_hint, 5);
    }

    @Override // com.tplink.iot.view.quicksetup.sub.common.e
    public int d() {
        return R.drawable.check_status_trv_e100;
    }

    @Override // com.tplink.iot.view.quicksetup.sub.common.e
    public int e() {
        return R.drawable.check_status_trv_e100;
    }

    @Override // com.tplink.iot.view.quicksetup.sub.common.e
    public EnumDeviceType f() {
        return EnumDeviceType.ENERGY;
    }

    @Override // com.tplink.iot.view.quicksetup.sub.common.e
    public int[] g() {
        return null;
    }

    @Override // com.tplink.iot.view.quicksetup.sub.common.e
    public int h() {
        return R.drawable.trv_e100_animate;
    }

    @Override // com.tplink.iot.view.quicksetup.sub.common.e
    public String i() {
        return p(R.string.smart_thermostat, new Object[0]);
    }

    @Override // com.tplink.iot.view.quicksetup.sub.common.e
    public int j() {
        return 0;
    }

    @Override // com.tplink.iot.view.quicksetup.sub.common.e
    public List<String> k() {
        EnumTRVAvatarType[] values = EnumTRVAvatarType.values();
        ArrayList arrayList = new ArrayList(values.length);
        for (EnumTRVAvatarType enumTRVAvatarType : values) {
            arrayList.add(enumTRVAvatarType.getValue());
        }
        return arrayList;
    }

    @Override // com.tplink.iot.view.quicksetup.sub.common.e
    public int l() {
        return R.drawable.check_status_trv_e100;
    }

    @Override // com.tplink.iot.view.quicksetup.sub.common.e
    public String m() {
        return p(R.string.subg_qs_check_status_led, new Object[0]);
    }

    @Override // com.tplink.iot.view.quicksetup.sub.common.e
    public String n() {
        return p(R.string.subg_qs_power_up_device_hint_switch, new Object[0]);
    }

    @Override // com.tplink.iot.view.quicksetup.sub.common.e
    public int o() {
        return R.drawable.complete_e100;
    }

    public String p(@StringRes int i, Object... formatArgs) {
        j.e(formatArgs, "formatArgs");
        return e.c.a(this, i, formatArgs);
    }
}
