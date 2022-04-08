package com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa;

import com.tplink.iot.devices.lightstrip.lightingeffect.common.KasaLightState;
import java.util.Comparator;

/* compiled from: KasaLightStateComparator.java */
/* loaded from: classes2.dex */
public class a implements Comparator<KasaLightState> {
    /* renamed from: a */
    public int compare(KasaLightState kasaLightState, KasaLightState kasaLightState2) {
        org.apache.commons.lang.builder.a aVar = new org.apache.commons.lang.builder.a();
        aVar.g(kasaLightState.getBrightness(), kasaLightState2.getBrightness()).g(kasaLightState.getColorTemperature(), kasaLightState2.getColorTemperature()).g(kasaLightState.getHue(), kasaLightState2.getHue()).g(kasaLightState.getSaturation(), kasaLightState2.getSaturation());
        return aVar.t();
    }
}
