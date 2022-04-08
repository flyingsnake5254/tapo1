package com.tplink.libtpnetwork.enumerate;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.LoadInfoBean;

/* loaded from: classes3.dex */
public enum EnumIoTCategory {
    LIGHT(LoadInfoBean.LoadLevel.LIGHT),
    LIGHT_STRIP("light.strip"),
    PLUG("plug"),
    HUB("hub"),
    HUB_PLUG("hub.plug"),
    CAMERA("camera"),
    SUBG_PLUGSWITCH_PLUG("subg.plugswitch.plug"),
    SUBG_PLUGSWITCH_SWITCH("subg.plugswitch.switch"),
    SUBG_TRIGGER_BUTTON("subg.trigger.button"),
    SUBG_TRIGGER_CONTACT_SENSOR("subg.trigger.contact-sensor"),
    SUBG_TRIGGER_MOTION_SENSOR("subg.trigger.motion-sensor"),
    SUBG_TRV("subg.trv");
    
    private final String value;

    EnumIoTCategory(String str) {
        this.value = str;
    }

    @Nullable
    public static EnumIoTCategory fromString(@Nullable String str) {
        EnumIoTCategory[] values;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (EnumIoTCategory enumIoTCategory : values()) {
            if (enumIoTCategory.value().equalsIgnoreCase(str)) {
                return enumIoTCategory;
            }
        }
        return null;
    }

    public String value() {
        return this.value;
    }
}
