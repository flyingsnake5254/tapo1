package com.tplink.iot.devices.lightstrip.lightingeffect;

import b.d.b.f.b;
import com.tplink.iot.devices.lightstrip.adapter.PredefinedEffectsAdapter;
import com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d;
import com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.e;
import com.tplink.iot.g.b.b.c;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.LightStripLightingEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.IntegerAttributeValue;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.AbstractLightingEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.CustomizedEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.LightingEffectMeta;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.LightingEffectSettings;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.PredefinedEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightingEffectData;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.LightingEffectRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Pair;
import kotlin.collections.o;
import kotlin.collections.v;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.j;

/* compiled from: LightingEffectFactory.kt */
/* loaded from: classes2.dex */
public final class a {
    private static final IntegerAttributeValue a;

    /* renamed from: b  reason: collision with root package name */
    public static final a f7505b = new a();

    /* compiled from: LightingEffectFactory.kt */
    /* renamed from: com.tplink.iot.devices.lightstrip.lightingeffect.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final /* synthetic */ class C0199a extends FunctionReferenceImpl implements l<String, PredefinedEffect> {
        C0199a(LightingEffectRepository lightingEffectRepository) {
            super(1, lightingEffectRepository, LightingEffectRepository.class, "getPredefinedEffectFromMap", "getPredefinedEffectFromMap(Ljava/lang/String;)Lcom/tplink/libtpnetwork/IoTNetwork/bean/lightstrip/lightingeffect/model/PredefinedEffect;", 0);
        }

        /* renamed from: a */
        public final PredefinedEffect invoke(String p1) {
            j.e(p1, "p1");
            return ((LightingEffectRepository) this.receiver).Z(p1);
        }
    }

    static {
        IntegerAttributeValue integerAttributeValue = new IntegerAttributeValue();
        integerAttributeValue.setAbsolute((Integer) 50);
        a = integerAttributeValue;
    }

    private a() {
    }

    private final boolean e(boolean z, String str) {
        return !z && j.a("Lightning", str);
    }

    private final void h(CustomizedEffect customizedEffect, String str) {
        customizedEffect.setMeta(LightingEffectMeta.builder().alias(str).build());
    }

    public final void a(boolean z, CustomizedEffect effect) {
        j.e(effect, "effect");
        b.d.b.f.a a2 = b.a(b.d.s.a.a.f(), LightingEffectRepository.class);
        j.d(a2, "CloudRepositoryProviders…ctRepository::class.java)");
        b(z, effect, new C0199a((LightingEffectRepository) a2));
    }

    public final void b(boolean z, CustomizedEffect effect, l<? super String, ? extends PredefinedEffect> predefinedEffectGetter) {
        LightingEffectSettings settings;
        LightingEffectMeta meta;
        j.e(effect, "effect");
        j.e(predefinedEffectGetter, "predefinedEffectGetter");
        String predefinedEffectId = effect.getPredefinedEffectId();
        String str = null;
        PredefinedEffect predefinedEffect = predefinedEffectId != null ? (PredefinedEffect) predefinedEffectGetter.invoke(predefinedEffectId) : null;
        if (!(predefinedEffect == null || (meta = predefinedEffect.getMeta()) == null)) {
            str = meta.getAlias();
        }
        if (e(z, str) && (settings = effect.getSettings()) != null) {
            settings.setRandomSeed(a);
        }
    }

    public final void c(boolean z, PredefinedEffect effect) {
        LightingEffectSettings settings;
        j.e(effect, "effect");
        LightingEffectMeta meta = effect.getMeta();
        if (e(z, meta != null ? meta.getAlias() : null) && (settings = effect.getSettings()) != null) {
            settings.setRandomSeed(a);
        }
    }

    public final CustomizedEffect d(String effectName, List<ColorPaintingSegment> segments) {
        int l;
        j.e(effectName, "effectName");
        j.e(segments, "segments");
        l = o.l(segments, 10);
        ArrayList arrayList = new ArrayList(l);
        for (ColorPaintingSegment colorPaintingSegment : segments) {
            arrayList.add(colorPaintingSegment.e());
        }
        LightStripLightingEffect effect = new e().Q(com.tplink.iot.devices.lightstrip.lightingeffect.common.a.a().h(1).g(arrayList).f());
        CustomizedEffect.CustomizedEffectBuilder builder = CustomizedEffect.builder();
        j.d(effect, "effect");
        CustomizedEffect customEffect = builder.colorRegistry(effect.getColorRegistry()).customization(effect.getCustomization()).expansionStrategy(effect.getExpansionStrategy()).segments(effect.getSegments()).type(effect.getType()).settings(effect.getSettings()).build();
        j.d(customEffect, "customEffect");
        h(customEffect, effectName);
        d.E(customEffect, true);
        AbstractLightingEffect s = d.s(customEffect);
        Objects.requireNonNull(s, "null cannot be cast to non-null type com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.CustomizedEffect");
        return (CustomizedEffect) s;
    }

    public final List<com.tplink.iot.g.b.b.e.a> f(List<? extends LightStateBean> presets) {
        List U;
        List U2;
        List U3;
        j.e(presets, "presets");
        ArrayList arrayList = new ArrayList();
        for (LightStateBean lightStateBean : presets) {
            LightingEffectData lightingEffectData = lightStateBean.getLightingEffectData();
            if (lightingEffectData != null) {
                List<Integer> t = d.t(lightingEffectData);
                if (d.r(lightingEffectData)) {
                    Pair<List<Integer>, List<Integer>> g = g(t);
                    CustomizedEffect build = CustomizedEffect.builder().id(lightingEffectData.id).build();
                    U = v.U(g.component1());
                    U2 = v.U(g.component2());
                    com.tplink.iot.g.b.b.a aVar = new com.tplink.iot.g.b.b.a("", U, U2, build);
                    aVar.i(lightingEffectData);
                    arrayList.add(aVar);
                } else {
                    com.tplink.iot.g.b.b.d b2 = PredefinedEffectsAdapter.h.b(lightingEffectData.name);
                    Integer num = lightingEffectData.custom;
                    if (num == null || num.intValue() != 0 || b2 == null) {
                        CustomizedEffect build2 = CustomizedEffect.builder().id(lightingEffectData.id).build();
                        U3 = v.U(t);
                        com.tplink.iot.g.b.b.b bVar = new com.tplink.iot.g.b.b.b("", U3, build2);
                        bVar.h(lightingEffectData);
                        arrayList.add(bVar);
                    } else {
                        com.tplink.iot.g.b.b.d dVar = new com.tplink.iot.g.b.b.d(b2.h(), b2.d(), PredefinedEffect.builder().id(lightingEffectData.id).build());
                        dVar.m(lightingEffectData);
                        arrayList.add(dVar);
                    }
                }
            } else {
                LightStateBean lightStateBean2 = new LightStateBean(lightStateBean.getHue(), lightStateBean.getSaturation(), lightStateBean.getColorTemp(), lightStateBean.getBrightness());
                arrayList.add(new c(d.v(lightStateBean2), lightStateBean2));
            }
        }
        return arrayList;
    }

    public final Pair<List<Integer>, List<Integer>> g(List<Integer> colorList) {
        j.e(colorList, "colorList");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Integer num = null;
        int i = 0;
        for (Integer num2 : colorList) {
            int intValue = num2.intValue();
            if (num != null && intValue == num.intValue()) {
                i++;
            } else {
                arrayList.add(Integer.valueOf(intValue));
                if (num != null) {
                    arrayList2.add(Integer.valueOf(i));
                }
                num = Integer.valueOf(intValue);
                i = 1;
            }
        }
        arrayList2.add(Integer.valueOf(i));
        return new Pair<>(arrayList, arrayList2);
    }

    public final CustomizedEffect i(String effectName, CustomizedEffect originEffect, List<ColorPaintingSegment> newColorSegments) {
        int l;
        j.e(effectName, "effectName");
        j.e(originEffect, "originEffect");
        j.e(newColorSegments, "newColorSegments");
        l = o.l(newColorSegments, 10);
        ArrayList arrayList = new ArrayList(l);
        for (ColorPaintingSegment colorPaintingSegment : newColorSegments) {
            arrayList.add(colorPaintingSegment.e());
        }
        LightStripLightingEffect updatedEffect = new e().Q(com.tplink.iot.devices.lightstrip.lightingeffect.common.a.a().h(1).g(arrayList).f());
        j.d(updatedEffect, "updatedEffect");
        originEffect.setColorRegistry(updatedEffect.getColorRegistry());
        LightingEffectSettings settings = originEffect.getSettings();
        if (settings != null) {
            LightingEffectSettings settings2 = updatedEffect.getSettings();
            settings.setColorSequence(settings2 != null ? settings2.getColorSequence() : null);
        }
        originEffect.setSegments(updatedEffect.getSegments());
        d.E(originEffect, false);
        f7505b.h(originEffect, effectName);
        AbstractLightingEffect s = d.s(originEffect);
        Objects.requireNonNull(s, "null cannot be cast to non-null type com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.CustomizedEffect");
        return (CustomizedEffect) s;
    }
}
