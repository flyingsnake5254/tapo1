package com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa;

import com.tplink.iot.devices.lightstrip.lightingeffect.common.KasaLightState;

/* compiled from: KasaLightStateUtils.java */
/* loaded from: classes2.dex */
public class b {
    public static boolean a(KasaLightState kasaLightState, KasaLightState kasaLightState2) {
        if (kasaLightState == null && kasaLightState2 == null) {
            return false;
        }
        return kasaLightState == null || kasaLightState2 == null || new a().compare(kasaLightState, kasaLightState2) != 0;
    }
}
