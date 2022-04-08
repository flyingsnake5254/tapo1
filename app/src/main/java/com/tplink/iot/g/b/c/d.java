package com.tplink.iot.g.b.c;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.e;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.LightStripLightingEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.ColorHSBAttributeValue;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.IntegerAttributeValue;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.LongAttributeValue;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.BackgroundSetting;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.ColorSequence;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.ExpansionStrategy;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.LightingEffectMeta;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.LightingEffectSettings;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.Segment;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightingEffectData;
import java.util.ArrayList;
import java.util.List;

/* compiled from: LightingEffectUtils.java */
/* loaded from: classes2.dex */
public class d {
    private static final e a = new e();

    public static LightStripLightingEffect a(@NonNull LightingEffectData lightingEffectData) {
        BackgroundSetting backgroundSetting;
        ArrayList arrayList = new ArrayList();
        int i = 1;
        e eVar = a;
        ColorHSBAttributeValue h = eVar.h(lightingEffectData.hue_range, lightingEffectData.saturation_range, lightingEffectData.brightness_range, lightingEffectData.brightness);
        i = c(h, arrayList, 1);
        Integer[][] numArr = lightingEffectData.backgrounds;
        if (numArr == null && lightingEffectData.fadeoff == null) {
            backgroundSetting = null;
        } else {
            ColorSequence b2 = eVar.b(numArr);
            if (b2 != null) {
                i = d(b2.getSeq(), arrayList, i);
            }
            backgroundSetting = BackgroundSetting.builder().colors(b2).build();
            if (lightingEffectData.fadeoff != null) {
                backgroundSetting.setFadeOff(LongAttributeValue.builder().absolute(Long.valueOf(lightingEffectData.fadeoff.intValue())).build());
            }
        }
        List<Segment> J = eVar.J(lightingEffectData.segments, lightingEffectData.init_states, lightingEffectData.segment_length);
        if (J != null) {
            for (Segment segment : J) {
                if (segment.getInitialState() != null) {
                    i = c(segment.getInitialState().getColor(), arrayList, i);
                }
            }
        }
        e eVar2 = a;
        ColorSequence L = eVar2.L(lightingEffectData.sequence);
        if (L != null) {
            if (com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.r(lightingEffectData)) {
                arrayList.clear();
            }
            d(L.getSeq(), arrayList, i);
        }
        LongAttributeValue R = eVar2.R(lightingEffectData.transition, lightingEffectData.transition_range);
        LightingEffectMeta build = LightingEffectMeta.builder().alias(lightingEffectData.name).build();
        LightingEffectSettings build2 = LightingEffectSettings.builder().direction(eVar2.o(lightingEffectData.direction)).colorSequence(L).repeat(eVar2.G(lightingEffectData.repeat_times)).transition(R).color(h).background(backgroundSetting).spread(lightingEffectData.spread).build();
        if (lightingEffectData.duration != null) {
            build2.setDelay(LongAttributeValue.builder().absolute(Long.valueOf(lightingEffectData.duration.intValue())).build());
        }
        if (lightingEffectData.random_seed != null) {
            build2.setRandomSeed(IntegerAttributeValue.builder().absolute(lightingEffectData.random_seed).build());
        }
        ExpansionStrategy expansionStrategy = ExpansionStrategy.REPEAT;
        Integer num = lightingEffectData.expansion_strategy;
        if (num != null) {
            expansionStrategy = eVar2.q(num);
        }
        return LightStripLightingEffect.builder().onOff(lightingEffectData.enable).id(lightingEffectData.id).colorRegistry(arrayList).expansionStrategy(expansionStrategy).sourceType(eVar2.m(lightingEffectData.custom)).type(eVar2.U(lightingEffectData.type)).settings(build2).segments(J).meta(build).build();
    }

    public static LightingEffectData b(@NonNull LightStripLightingEffect lightStripLightingEffect) {
        LightingEffectData lightingEffectData = new LightingEffectData();
        List<ColorHSBAttributeValue> colorRegistry = lightStripLightingEffect.getColorRegistry();
        List<Segment> segments = lightStripLightingEffect.getSegments();
        LightingEffectSettings settings = lightStripLightingEffect.getSettings();
        if (settings == null) {
            settings = LightingEffectSettings.builder().build();
        }
        e eVar = a;
        Integer[] K = eVar.K(segments);
        if (K != null) {
            lightingEffectData.segments = K;
        }
        if (K == null) {
            lightingEffectData.segment_length = eVar.I(segments);
        }
        Integer[][] w = eVar.w(eVar.W(segments), colorRegistry);
        if (w != null) {
            lightingEffectData.init_states = w;
        }
        Integer[][] N = eVar.N(settings.getColorSequence(), colorRegistry);
        if (N != null) {
            lightingEffectData.sequence = N;
        }
        if (lightStripLightingEffect.getId() != null) {
            lightingEffectData.id = lightStripLightingEffect.getId();
        }
        if (!TextUtils.isEmpty(lightStripLightingEffect.getSourceType())) {
            lightingEffectData.custom = eVar.l(lightStripLightingEffect.getSourceType());
        }
        lightingEffectData.name = eVar.D(lightStripLightingEffect.getMeta());
        if (lightStripLightingEffect.getType() != null) {
            lightingEffectData.type = lightStripLightingEffect.getType().name().toLowerCase();
        }
        if (lightStripLightingEffect.getOnOff() != null) {
            lightingEffectData.enable = lightStripLightingEffect.getOnOff();
        }
        if (settings.getDirection() != null) {
            lightingEffectData.direction = eVar.p(settings.getDirection());
        }
        if (settings.getDelay() != null) {
            lightingEffectData.duration = eVar.n(settings.getDelay());
        }
        if (settings.getSpread() != null) {
            lightingEffectData.spread = settings.getSpread();
        }
        if (settings.getRepeat() != null) {
            lightingEffectData.repeat_times = eVar.F(settings.getRepeat());
        }
        if (settings.getRandomSeed() != null) {
            lightingEffectData.random_seed = eVar.E(settings.getRandomSeed());
        }
        lightingEffectData.expansion_strategy = eVar.r(lightStripLightingEffect.getExpansionStrategy());
        BackgroundSetting background = settings.getBackground();
        Integer num = null;
        lightingEffectData.backgrounds = background != null ? eVar.c(background.getColors(), colorRegistry) : null;
        if (!(background == null || background.getFadeOff() == null)) {
            num = eVar.s(background.getFadeOff());
        }
        lightingEffectData.fadeoff = num;
        LongAttributeValue transition = settings.getTransition();
        lightingEffectData.transition = eVar.S(transition);
        lightingEffectData.transition_range = eVar.T(transition);
        ColorHSBAttributeValue color = settings.getColor();
        lightingEffectData.hue_range = eVar.u(color, colorRegistry);
        lightingEffectData.saturation_range = eVar.H(color, colorRegistry);
        lightingEffectData.brightness_range = eVar.f(color, colorRegistry);
        return lightingEffectData;
    }

    private static Integer c(ColorHSBAttributeValue colorHSBAttributeValue, List<ColorHSBAttributeValue> list, Integer num) {
        return a.X(colorHSBAttributeValue, list, num);
    }

    private static Integer d(List<ColorHSBAttributeValue> list, List<ColorHSBAttributeValue> list2, Integer num) {
        return a.Y(list, list2, num);
    }
}
