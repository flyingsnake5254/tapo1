package com.tplink.iot.g.b.b.e;

import com.tplink.iot.g.b.b.a;
import com.tplink.iot.g.b.b.c;
import com.tplink.iot.g.b.b.d;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.CustomizedEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.PredefinedEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightingEffectData;
import kotlin.jvm.internal.j;

/* compiled from: LightStripEffectsBaseItemExt.kt */
/* loaded from: classes2.dex */
public final class b {
    public static final String a(a resolveItemId) {
        j.e(resolveItemId, "$this$resolveItemId");
        if (resolveItemId instanceof c) {
            return ((c) resolveItemId).c();
        }
        if (resolveItemId instanceof a) {
            return ((a) resolveItemId).e();
        }
        if (resolveItemId instanceof com.tplink.iot.g.b.b.b) {
            return ((com.tplink.iot.g.b.b.b) resolveItemId).e();
        }
        if (!(resolveItemId instanceof d)) {
            return null;
        }
        d dVar = (d) resolveItemId;
        return dVar.i() ? "PredefinedEffect_Daylight" : dVar.f();
    }

    public static final LightStateBean b(a resolveLightState, boolean z) {
        LightingEffectData C;
        LightingEffectData B;
        LightingEffectData B2;
        j.e(resolveLightState, "$this$resolveLightState");
        if (resolveLightState instanceof c) {
            return ((c) resolveLightState).e();
        }
        if (resolveLightState instanceof a) {
            CustomizedEffect d2 = ((a) resolveLightState).d();
            if (d2 == null || (B2 = com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.B(d2)) == null) {
                return null;
            }
            LightStateBean lightStateBean = new LightStateBean();
            lightStateBean.setLightingEffectData(B2);
            return lightStateBean;
        } else if (resolveLightState instanceof com.tplink.iot.g.b.b.b) {
            CustomizedEffect d3 = ((com.tplink.iot.g.b.b.b) resolveLightState).d();
            CustomizedEffect a = d3 != null ? com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.a(d3, z) : null;
            if (a == null || (B = com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.B(a)) == null) {
                return null;
            }
            LightStateBean lightStateBean2 = new LightStateBean();
            lightStateBean2.setLightingEffectData(B);
            return lightStateBean2;
        } else if (!(resolveLightState instanceof d)) {
            return null;
        } else {
            d dVar = (d) resolveLightState;
            if (dVar.i()) {
                return dVar.c();
            }
            PredefinedEffect e2 = dVar.e();
            PredefinedEffect c2 = e2 != null ? com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.c(e2, z) : null;
            if (c2 == null || (C = com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.C(c2)) == null) {
                return null;
            }
            LightStateBean lightStateBean3 = new LightStateBean();
            lightStateBean3.setLightingEffectData(C);
            return lightStateBean3;
        }
    }

    public static final LightStateBean c(a resolveLightStateFromPreset) {
        LightingEffectData g;
        j.e(resolveLightStateFromPreset, "$this$resolveLightStateFromPreset");
        if (resolveLightStateFromPreset instanceof c) {
            return ((c) resolveLightStateFromPreset).e();
        }
        if (resolveLightStateFromPreset instanceof a) {
            LightingEffectData g2 = ((a) resolveLightStateFromPreset).g();
            if (g2 == null) {
                return null;
            }
            LightStateBean lightStateBean = new LightStateBean();
            lightStateBean.setLightingEffectData(g2);
            return lightStateBean;
        } else if (resolveLightStateFromPreset instanceof com.tplink.iot.g.b.b.b) {
            LightingEffectData f2 = ((com.tplink.iot.g.b.b.b) resolveLightStateFromPreset).f();
            if (f2 == null) {
                return null;
            }
            LightStateBean lightStateBean2 = new LightStateBean();
            lightStateBean2.setLightingEffectData(f2);
            return lightStateBean2;
        } else if (!(resolveLightStateFromPreset instanceof d) || (g = ((d) resolveLightStateFromPreset).g()) == null) {
            return null;
        } else {
            LightStateBean lightStateBean3 = new LightStateBean();
            lightStateBean3.setLightingEffectData(g);
            return lightStateBean3;
        }
    }
}
