package com.tplink.iot.Utils.x0;

import android.text.TextUtils;
import com.google.gson.f;
import com.google.gson.k;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;

/* compiled from: BulbSettingFireBaseUtils.java */
/* loaded from: classes2.dex */
public class c {
    public static void a(String str, f fVar) {
        h.g("bulb_setting", "change_preset", str, new l("preset", fVar));
    }

    public static void b(String str, DefaultStatesBean defaultStatesBean) {
        if (defaultStatesBean != null) {
            String str2 = null;
            k kVar = new k();
            if (defaultStatesBean.getBrightness() != null) {
                DefaultStatesBean.BrightnessBean brightness = defaultStatesBean.getBrightness();
                str2 = brightness.getType();
                if (TextUtils.equals(str2, DefaultStatesBean.TYPE_CUSTOM)) {
                    kVar.l("brightness", Integer.valueOf(brightness.getValue()));
                }
            } else if (!TextUtils.isEmpty(defaultStatesBean.getType())) {
                str2 = defaultStatesBean.getType();
                LightStateBean lightState = defaultStatesBean.getLightState();
                if (TextUtils.equals(str2, DefaultStatesBean.TYPE_CUSTOM) && lightState != null) {
                    kVar.l("brightness", Integer.valueOf(lightState.getBrightness()));
                    kVar.l("color_temperature", Integer.valueOf(lightState.getColorTemp()));
                    kVar.l(ThingModelDefine.Property.PROPERTY_HUE, Integer.valueOf(lightState.getHue()));
                    kVar.l(ThingModelDefine.Property.PROPERTY_SATURATION, Integer.valueOf(lightState.getSaturation()));
                }
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            if (TextUtils.equals(str2, DefaultStatesBean.TYPE_CUSTOM)) {
                h.g("bulb_setting", "default_state", str, new l("type", DefaultStatesBean.TYPE_CUSTOM), new l("state_info", kVar));
            } else {
                h.g("bulb_setting", "default_state", str, new l("type", DefaultStatesBean.TYPE_LAST_STATES));
            }
        }
    }
}
