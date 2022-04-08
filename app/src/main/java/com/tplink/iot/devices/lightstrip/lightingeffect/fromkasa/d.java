package com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa;

import androidx.annotation.ColorInt;
import com.google.gson.k;
import com.tplink.iot.devices.lightstrip.lightingeffect.template.LEColor;
import com.tplink.iot.devices.lightstrip.lightingeffect.template.PredefinedEffectsTemplateInput;
import com.tplink.iot.devices.lightstrip.lightingeffect.template.PredefinedEffectsTemplateInputKt;
import com.tplink.iot.devices.lightstrip.lightingeffect.template.Speed;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.LightStripLightingEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.ColorHSBAttributeValue;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.IntegerAttributeValue;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.AbstractLightingEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.ColorSequence;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.CustomizationSettings;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.CustomizedEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.ExpansionStrategy;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.LightingEffectSettings;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.PredefinedEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.Segment;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.Type;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightingEffectData;
import com.tplink.libtpnetwork.Utils.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.collections.e0;
import kotlin.collections.o;
import kotlin.collections.v;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.n;
import kotlin.u.c;

/* compiled from: LightingEffectExt.kt */
/* loaded from: classes2.dex */
public final class d {

    /* compiled from: Comparisons.kt */
    /* loaded from: classes2.dex */
    public static final class a<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int a;
            a = kotlin.q.b.a(((LEColor) t).getH(), ((LEColor) t2).getH());
            return a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LightingEffectExt.kt */
    /* loaded from: classes2.dex */
    public static final class b<T> implements Comparator<ColorHSBAttributeValue> {

        /* renamed from: c  reason: collision with root package name */
        public static final b f7519c = new b();

        b() {
        }

        /* renamed from: a */
        public final int compare(ColorHSBAttributeValue lhs, ColorHSBAttributeValue rhs) {
            org.apache.commons.lang.builder.a aVar = new org.apache.commons.lang.builder.a();
            j.d(lhs, "lhs");
            IntegerAttributeValue h = lhs.getH();
            j.d(h, "lhs.h");
            Integer absolute = h.getAbsolute();
            j.d(absolute, "lhs.h.absolute");
            int intValue = absolute.intValue();
            j.d(rhs, "rhs");
            IntegerAttributeValue h2 = rhs.getH();
            j.d(h2, "rhs.h");
            Integer absolute2 = h2.getAbsolute();
            j.d(absolute2, "rhs.h.absolute");
            aVar.e(intValue, absolute2.intValue());
            IntegerAttributeValue s = lhs.getS();
            j.d(s, "lhs.s");
            Integer absolute3 = s.getAbsolute();
            j.d(absolute3, "lhs.s.absolute");
            int intValue2 = absolute3.intValue();
            IntegerAttributeValue s2 = rhs.getS();
            j.d(s2, "rhs.s");
            Integer absolute4 = s2.getAbsolute();
            j.d(absolute4, "rhs.s.absolute");
            aVar.e(intValue2, absolute4.intValue());
            IntegerAttributeValue b2 = lhs.getB();
            j.d(b2, "lhs.b");
            Integer absolute5 = b2.getAbsolute();
            j.d(absolute5, "lhs.b.absolute");
            int intValue3 = absolute5.intValue();
            IntegerAttributeValue b3 = rhs.getB();
            j.d(b3, "rhs.b");
            Integer absolute6 = b3.getAbsolute();
            j.d(absolute6, "rhs.b.absolute");
            aVar.e(intValue3, absolute6.intValue());
            return aVar.t();
        }
    }

    public static final LightStripLightingEffect A(PredefinedEffect transform) {
        j.e(transform, "$this$transform");
        LightStripLightingEffect build = LightStripLightingEffect.builder().sourceType(LightingEffectType.PREDEFINED.getValue()).onOff(1).id(transform.getId()).createdOn(transform.getCreatedOn()).updatedOn(transform.getUpdatedOn()).expansionStrategy(transform.getExpansionStrategy()).meta(transform.getMeta()).settings(transform.getSettings()).type(transform.getType()).segments(transform.getSegments()).colorRegistry(transform.getColorRegistry()).customization(transform.getCustomization()).animationType(transform.getAnimationType()).version(transform.getVersion()).build();
        j.d(build, "LightStripLightingEffect…ion)\n            .build()");
        return build;
    }

    public static final LightingEffectData B(CustomizedEffect transformIntoData) {
        j.e(transformIntoData, "$this$transformIntoData");
        int j = j(transformIntoData);
        LightingEffectData b2 = com.tplink.iot.g.b.c.d.b(z(transformIntoData));
        b2.display_colors = m(transformIntoData);
        b2.brightness = Integer.valueOf(j);
        j.d(b2, "LightingEffectUtils.conv…= overallBrightness\n    }");
        return b2;
    }

    public static final LightingEffectData C(PredefinedEffect transformIntoData) {
        j.e(transformIntoData, "$this$transformIntoData");
        int k = k(transformIntoData);
        LightingEffectData b2 = com.tplink.iot.g.b.c.d.b(A(transformIntoData));
        b2.display_colors = m(transformIntoData);
        b2.brightness = Integer.valueOf(k);
        j.d(b2, "LightingEffectUtils.conv…= overallBrightness\n    }");
        return b2;
    }

    public static final LightStripLightingEffect D(LightingEffectData transformIntoEffect) {
        j.e(transformIntoEffect, "$this$transformIntoEffect");
        LightStripLightingEffect a2 = com.tplink.iot.g.b.c.d.a(transformIntoEffect);
        j.d(a2, "LightingEffectUtils.convert(this)");
        return a2;
    }

    public static final void E(CustomizedEffect updateTimeInfo, boolean z) {
        j.e(updateTimeInfo, "$this$updateTimeInfo");
        if (z) {
            long currentTimeMillis = System.currentTimeMillis();
            updateTimeInfo.setCreatedOn(Long.valueOf(currentTimeMillis));
            updateTimeInfo.setUpdatedOn(Long.valueOf(currentTimeMillis));
            return;
        }
        updateTimeInfo.setUpdatedOn(Long.valueOf(System.currentTimeMillis()));
    }

    public static final CustomizedEffect a(CustomizedEffect adjustIfNeed, boolean z) {
        j.e(adjustIfNeed, "$this$adjustIfNeed");
        com.tplink.iot.devices.lightstrip.lightingeffect.a.f7505b.a(z, adjustIfNeed);
        return adjustIfNeed;
    }

    public static final CustomizedEffect b(CustomizedEffect adjustIfNeed, boolean z, l<? super String, ? extends PredefinedEffect> predefinedEffectGetter) {
        j.e(adjustIfNeed, "$this$adjustIfNeed");
        j.e(predefinedEffectGetter, "predefinedEffectGetter");
        com.tplink.iot.devices.lightstrip.lightingeffect.a.f7505b.b(z, adjustIfNeed, predefinedEffectGetter);
        return adjustIfNeed;
    }

    public static final PredefinedEffect c(PredefinedEffect adjustIfNeed, boolean z) {
        j.e(adjustIfNeed, "$this$adjustIfNeed");
        com.tplink.iot.devices.lightstrip.lightingeffect.a.f7505b.c(z, adjustIfNeed);
        return adjustIfNeed;
    }

    public static final AbstractLightingEffect d(AbstractLightingEffect copy) {
        j.e(copy, "$this$copy");
        if (copy instanceof CustomizedEffect) {
            CustomizedEffect customizedEffect = (CustomizedEffect) copy;
            CustomizedEffect.CustomizedEffectBuilder meta = CustomizedEffect.builder().id(customizedEffect.getId()).accountId(customizedEffect.getAccountId()).predefinedEffectId(customizedEffect.getPredefinedEffectId()).templateInput(customizedEffect.getTemplateInput()).createdOn(customizedEffect.getCreatedOn()).updatedOn(customizedEffect.getUpdatedOn()).expansionStrategy(customizedEffect.getExpansionStrategy()).meta(customizedEffect.getMeta());
            LightingEffectSettings settings = customizedEffect.getSettings();
            j.d(settings, "settings");
            CustomizedEffect build = meta.settings(f(settings)).type(customizedEffect.getType()).segments(customizedEffect.getSegments()).colorRegistry(customizedEffect.getColorRegistry()).customization(customizedEffect.getCustomization()).animationType(customizedEffect.getAnimationType()).version(customizedEffect.getVersion()).build();
            j.d(build, "CustomizedEffect.builder…                 .build()");
            return build;
        } else if (copy instanceof PredefinedEffect) {
            PredefinedEffect predefinedEffect = (PredefinedEffect) copy;
            PredefinedEffect.PredefinedEffectBuilder meta2 = PredefinedEffect.builder().id(predefinedEffect.getId()).createdOn(predefinedEffect.getCreatedOn()).updatedOn(predefinedEffect.getUpdatedOn()).expansionStrategy(predefinedEffect.getExpansionStrategy()).meta(predefinedEffect.getMeta());
            LightingEffectSettings settings2 = predefinedEffect.getSettings();
            j.d(settings2, "settings");
            PredefinedEffect build2 = meta2.settings(f(settings2)).type(predefinedEffect.getType()).segments(predefinedEffect.getSegments()).colorRegistry(predefinedEffect.getColorRegistry()).customization(predefinedEffect.getCustomization()).animationType(predefinedEffect.getAnimationType()).version(predefinedEffect.getVersion()).active(predefinedEffect.getActive()).build();
            j.d(build2, "PredefinedEffect.builder…                 .build()");
            return build2;
        } else {
            LightStripLightingEffect y = y(copy);
            LightStripLightingEffect.Builder meta3 = LightStripLightingEffect.builder().sourceType(y.getSourceType()).onOff(y.getOnOff()).id(y.getId()).createdOn(y.getCreatedOn()).updatedOn(y.getUpdatedOn()).expansionStrategy(y.getExpansionStrategy()).meta(y.getMeta());
            LightingEffectSettings settings3 = y.getSettings();
            j.d(settings3, "deviceEffect.settings");
            LightStripLightingEffect build3 = meta3.settings(f(settings3)).type(y.getType()).segments(y.getSegments()).colorRegistry(y.getColorRegistry()).customization(y.getCustomization()).animationType(y.getAnimationType()).version(y.getVersion()).build();
            j.d(build3, "LightStripLightingEffect…                 .build()");
            return build3;
        }
    }

    private static final ColorSequence e(ColorSequence colorSequence) {
        ColorSequence build = ColorSequence.builder().sortBy(colorSequence.getSortBy()).order(colorSequence.getOrder()).seq(colorSequence.getSeq()).build();
        j.d(build, "ColorSequence.builder()\n…seq)\n            .build()");
        return build;
    }

    private static final LightingEffectSettings f(LightingEffectSettings lightingEffectSettings) {
        LightingEffectSettings.LightingEffectSettingsBuilder background = LightingEffectSettings.builder().transition(lightingEffectSettings.getTransition()).delay(lightingEffectSettings.getDelay()).color(lightingEffectSettings.getColor()).randomSeed(lightingEffectSettings.getRandomSeed()).background(lightingEffectSettings.getBackground());
        ColorSequence colorSequence = lightingEffectSettings.getColorSequence();
        j.d(colorSequence, "this.colorSequence");
        LightingEffectSettings build = background.colorSequence(e(colorSequence)).spread(lightingEffectSettings.getSpread()).repeat(lightingEffectSettings.getRepeat()).direction(lightingEffectSettings.getDirection()).build();
        j.d(build, "LightingEffectSettings.b…ion)\n            .build()");
        return build;
    }

    private static final AbstractLightingEffect g(int i, AbstractLightingEffect abstractLightingEffect) {
        List<Segment> segments = abstractLightingEffect.getSegments();
        int size = segments.size();
        LightingEffectSettings settings = abstractLightingEffect.getSettings();
        j.d(settings, "lightingEffect.settings");
        ColorSequence colorSequence = settings.getColorSequence();
        j.d(colorSequence, "lightingEffect.settings.colorSequence");
        List<ColorHSBAttributeValue> seq = colorSequence.getSeq();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i2 = 0;
        ColorHSBAttributeValue repeatColorSequence = seq.get(0);
        Segment repeatSegment = segments.get(0);
        j.d(repeatSegment, "repeatSegment");
        Integer start = repeatSegment.getStart();
        Integer end = repeatSegment.getEnd();
        while (true) {
            if (start.intValue() >= i) {
                break;
            }
            ColorHSBAttributeValue.ColorHSBAttributeValueBuilder builder = ColorHSBAttributeValue.builder();
            j.d(repeatColorSequence, "repeatColorSequence");
            ColorHSBAttributeValue newColorSequence = builder.id(repeatColorSequence.getId()).h(repeatColorSequence.getH()).s(repeatColorSequence.getS()).b(repeatColorSequence.getB()).build();
            j.d(newColorSequence, "newColorSequence");
            arrayList2.add(newColorSequence);
            Segment segment = new Segment();
            arrayList.add(segment);
            segment.setStart(start);
            if (end.intValue() >= i) {
                segment.setEnd(Integer.valueOf(i - 1));
                break;
            }
            segment.setEnd(end);
            i2 = (i2 + 1) % size;
            Segment repeatSegment2 = segments.get(i2);
            start = Integer.valueOf(end.intValue() + 1);
            int intValue = start.intValue();
            j.d(repeatSegment2, "repeatSegment");
            Integer end2 = repeatSegment2.getEnd();
            j.d(end2, "repeatSegment.end");
            Integer start2 = repeatSegment2.getStart();
            j.d(start2, "repeatSegment.start");
            end = Integer.valueOf((intValue + end2.intValue()) - start2.intValue());
            repeatColorSequence = seq.get(i2);
        }
        abstractLightingEffect.setSegments(arrayList);
        LightingEffectSettings settings2 = abstractLightingEffect.getSettings();
        j.d(settings2, "lightingEffect.settings");
        ColorSequence colorSequence2 = settings2.getColorSequence();
        j.d(colorSequence2, "lightingEffect.settings.colorSequence");
        colorSequence2.setSeq(arrayList2);
        return abstractLightingEffect;
    }

    public static final AbstractLightingEffect h(AbstractLightingEffect expandColorPaintingEffect, int i, ExpansionStrategy expansionStrategy) {
        j.e(expandColorPaintingEffect, "$this$expandColorPaintingEffect");
        j.e(expansionStrategy, "expansionStrategy");
        return c.a[expansionStrategy.ordinal()] != 1 ? expandColorPaintingEffect : g(i, expandColorPaintingEffect);
    }

    private static final int i(PredefinedEffectsTemplateInput predefinedEffectsTemplateInput) {
        List<LEColor> colors;
        Object obj;
        Integer b2;
        boolean z;
        if (!(predefinedEffectsTemplateInput == null || (colors = predefinedEffectsTemplateInput.getColors()) == null)) {
            Iterator<T> it = colors.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((LEColor) obj).getB() != null) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            LEColor lEColor = (LEColor) obj;
            if (!(lEColor == null || (b2 = lEColor.getB()) == null)) {
                return b2.intValue();
            }
        }
        return 100;
    }

    public static final int j(CustomizedEffect findOverallBrightness) {
        Object obj;
        IntegerAttributeValue b2;
        Integer absolute;
        boolean z;
        j.e(findOverallBrightness, "$this$findOverallBrightness");
        if (!q(findOverallBrightness)) {
            return i(w(findOverallBrightness));
        }
        List<ColorHSBAttributeValue> colorRegistry = findOverallBrightness.getColorRegistry();
        if (colorRegistry != null) {
            Iterator<T> it = colorRegistry.iterator();
            while (true) {
                obj = null;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                ColorHSBAttributeValue it2 = (ColorHSBAttributeValue) next;
                j.d(it2, "it");
                IntegerAttributeValue b3 = it2.getB();
                if (b3 != null) {
                    obj = b3.getAbsolute();
                }
                if (obj != null) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    obj = next;
                    break;
                }
            }
            ColorHSBAttributeValue colorHSBAttributeValue = (ColorHSBAttributeValue) obj;
            if (!(colorHSBAttributeValue == null || (b2 = colorHSBAttributeValue.getB()) == null || (absolute = b2.getAbsolute()) == null)) {
                return absolute.intValue();
            }
        }
        return 100;
    }

    public static final int k(PredefinedEffect findOverallBrightness) {
        j.e(findOverallBrightness, "$this$findOverallBrightness");
        return i(w(findOverallBrightness));
    }

    private static final PredefinedEffectsTemplateInput l(int i) {
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(Integer.valueOf(c.f16409b.d(0, 360)));
        }
        ArrayList arrayList2 = new ArrayList(i);
        for (int i3 = 0; i3 < i; i3++) {
            arrayList2.add(Integer.valueOf(c.f16409b.d(0, 100)));
        }
        ArrayList arrayList3 = new ArrayList();
        for (int i4 = 0; i4 < i; i4++) {
            arrayList3.add(new LEColor(Integer.valueOf(((Number) arrayList.get(i4)).intValue()), Integer.valueOf(((Number) arrayList2.get(i4)).intValue()), null));
        }
        return new PredefinedEffectsTemplateInput(arrayList3, new Speed(Integer.valueOf(c.f16409b.d(0, 100))), 0, 4, null);
    }

    private static final Integer[][] m(AbstractLightingEffect abstractLightingEffect) {
        List<LEColor> colors;
        int l;
        List P;
        IntegerAttributeValue b2;
        IntegerAttributeValue s;
        IntegerAttributeValue h;
        if (q(abstractLightingEffect)) {
            ArrayList arrayList = new ArrayList();
            List<ColorHSBAttributeValue> colorRegistry = abstractLightingEffect.getColorRegistry();
            if (colorRegistry != null) {
                for (ColorHSBAttributeValue colorHSBAttributeValue : colorRegistry) {
                    Integer num = null;
                    Integer absolute = (colorHSBAttributeValue == null || (h = colorHSBAttributeValue.getH()) == null) ? null : h.getAbsolute();
                    Integer absolute2 = (colorHSBAttributeValue == null || (s = colorHSBAttributeValue.getS()) == null) ? null : s.getAbsolute();
                    if (!(colorHSBAttributeValue == null || (b2 = colorHSBAttributeValue.getB()) == null)) {
                        num = b2.getAbsolute();
                    }
                    if (!(absolute == null || absolute2 == null || num == null)) {
                        arrayList.add(new Integer[]{absolute, absolute2, num});
                    }
                }
            }
            P = v.P(arrayList, 4);
            Object[] array = P.toArray(new Integer[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            return (Integer[][]) array;
        }
        PredefinedEffectsTemplateInput w = w(abstractLightingEffect);
        if (w == null || (colors = w.getColors()) == null) {
            return new Integer[0];
        }
        l = o.l(colors, 10);
        ArrayList arrayList2 = new ArrayList(l);
        for (LEColor lEColor : colors) {
            Integer[] numArr = new Integer[3];
            Integer h2 = lEColor.getH();
            numArr[0] = Integer.valueOf(h2 != null ? h2.intValue() : 0);
            Integer s2 = lEColor.getS();
            numArr[1] = Integer.valueOf(s2 != null ? s2.intValue() : 0);
            Integer b3 = lEColor.getB();
            numArr[2] = Integer.valueOf(b3 != null ? b3.intValue() : 100);
            arrayList2.add(numArr);
        }
        Object[] array2 = arrayList2.toArray(new Integer[0]);
        Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
        return (Integer[][]) array2;
    }

    private static final List<Integer> n(ColorSequence colorSequence, List<? extends ColorHSBAttributeValue> list) {
        new ArrayList();
        Integer[][] N = new e().N(colorSequence, list);
        ArrayList arrayList = new ArrayList();
        if (N != null) {
            for (Integer[] numArr : N) {
                arrayList.add(Integer.valueOf(PredefinedEffectsTemplateInputKt.toColorInt(new LEColor(numArr[0], numArr[1], 100))));
            }
        }
        return arrayList;
    }

    public static final List<Integer> o(CustomizedEffect getColorsForCustomIcon) {
        j.e(getColorsForCustomIcon, "$this$getColorsForCustomIcon");
        ArrayList arrayList = new ArrayList();
        if (q(getColorsForCustomIcon)) {
            AbstractLightingEffect x = x(getColorsForCustomIcon);
            LightingEffectSettings settings = x.getSettings();
            j.d(settings, "splitSegmentEffect.settings");
            ColorSequence colorSequence = settings.getColorSequence();
            j.d(colorSequence, "splitSegmentEffect.settings.colorSequence");
            List<ColorHSBAttributeValue> colorRegistry = x.getColorRegistry();
            j.d(colorRegistry, "splitSegmentEffect.colorRegistry");
            arrayList.addAll(n(colorSequence, colorRegistry));
        } else {
            PredefinedEffectsTemplateInput w = w(getColorsForCustomIcon);
            List<LEColor> list = null;
            List<LEColor> colors = w != null ? w.getColors() : null;
            if (colors != null) {
                list = v.O(colors, new a());
            }
            if (list != null) {
                for (LEColor lEColor : list) {
                    arrayList.add(Integer.valueOf(PredefinedEffectsTemplateInputKt.toColorInt(LEColor.copy$default(lEColor, null, null, 100, 3, null))));
                }
            }
        }
        return arrayList;
    }

    public static final int p(LightingEffectData getOverallBrightness) {
        j.e(getOverallBrightness, "$this$getOverallBrightness");
        Integer num = getOverallBrightness.brightness;
        if (num != null) {
            return num.intValue();
        }
        return 100;
    }

    public static final boolean q(AbstractLightingEffect isColorPaintingEffect) {
        j.e(isColorPaintingEffect, "$this$isColorPaintingEffect");
        String str = Type.STATIC.toString();
        Type type = isColorPaintingEffect.getType();
        return j.a(str, type != null ? type.toString() : null);
    }

    public static final boolean r(LightingEffectData isColorPaintingEffect) {
        boolean q;
        j.e(isColorPaintingEffect, "$this$isColorPaintingEffect");
        q = kotlin.text.v.q(isColorPaintingEffect.type, Type.STATIC.toString(), true);
        return q;
    }

    public static final AbstractLightingEffect s(AbstractLightingEffect mergeColorPaintingSegments) {
        int l;
        Map k;
        ColorSequence colorSequence;
        j.e(mergeColorPaintingSegments, "$this$mergeColorPaintingSegments");
        List<Segment> segments = mergeColorPaintingSegments.getSegments();
        LightingEffectSettings settings = mergeColorPaintingSegments.getSettings();
        List<ColorHSBAttributeValue> seq = (settings == null || (colorSequence = settings.getColorSequence()) == null) ? null : colorSequence.getSeq();
        if (segments == null || segments.isEmpty()) {
            return mergeColorPaintingSegments;
        }
        if (seq == null || seq.isEmpty()) {
            return mergeColorPaintingSegments;
        }
        List<ColorHSBAttributeValue> colorRegistry = mergeColorPaintingSegments.getColorRegistry();
        j.d(colorRegistry, "colorRegistry");
        l = o.l(colorRegistry, 10);
        ArrayList arrayList = new ArrayList(l);
        for (ColorHSBAttributeValue it : colorRegistry) {
            j.d(it, "it");
            arrayList.add(n.a(it.getId(), it));
        }
        k = e0.k(arrayList);
        b bVar = b.f7519c;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Segment firstSeg = (Segment) kotlin.collections.l.x(segments);
        ColorHSBAttributeValue firstColor = (ColorHSBAttributeValue) kotlin.collections.l.x(seq);
        Segment.SegmentBuilder builder = Segment.builder();
        j.d(firstSeg, "firstSeg");
        Segment curSegment = builder.start(firstSeg.getStart()).end(firstSeg.getEnd()).build();
        ColorHSBAttributeValue.ColorHSBAttributeValueBuilder builder2 = ColorHSBAttributeValue.builder();
        j.d(firstColor, "firstColor");
        ColorHSBAttributeValue curColor = builder2.id(firstColor.getId()).h(firstColor.getH()).s(firstColor.getS()).b(firstColor.getB()).build();
        j.d(curSegment, "curSegment");
        arrayList2.add(curSegment);
        j.d(curColor, "curColor");
        arrayList3.add(curColor);
        int size = segments.size();
        int i = 1;
        while (i < size) {
            Segment seg = segments.get(i);
            ColorHSBAttributeValue color = seq.get(i);
            Object obj = k.get(curColor.getId());
            j.d(color, "color");
            if (bVar.compare(obj, k.get(color.getId())) == 0) {
                j.d(seg, "seg");
                curSegment.setEnd(seg.getEnd());
            } else {
                Segment.SegmentBuilder builder3 = Segment.builder();
                j.d(seg, "seg");
                Segment curSegment2 = builder3.start(seg.getStart()).end(seg.getEnd()).build();
                j.d(curSegment2, "curSegment");
                arrayList2.add(curSegment2);
                ColorHSBAttributeValue curColor2 = ColorHSBAttributeValue.builder().id(color.getId()).h(color.getH()).s(color.getS()).b(color.getB()).build();
                j.d(curColor2, "curColor");
                arrayList3.add(curColor2);
                curSegment = curSegment2;
                curColor = curColor2;
            }
            i++;
            segments = segments;
        }
        AbstractLightingEffect d2 = d(mergeColorPaintingSegments);
        d2.setSegments(arrayList2);
        LightingEffectSettings settings2 = d2.getSettings();
        j.d(settings2, "copy.settings");
        ColorSequence colorSequence2 = settings2.getColorSequence();
        j.d(colorSequence2, "copy.settings.colorSequence");
        colorSequence2.setSeq(arrayList3);
        return d2;
    }

    public static final List<Integer> t(LightingEffectData resolveDisplayColorsFully) {
        Collection collection;
        j.e(resolveDisplayColorsFully, "$this$resolveDisplayColorsFully");
        ArrayList arrayList = new ArrayList();
        char c2 = 0;
        if (r(resolveDisplayColorsFully)) {
            Integer[] numArr = resolveDisplayColorsFully.segments;
            if (numArr == null) {
                numArr = new Integer[0];
            }
            Integer[][] numArr2 = resolveDisplayColorsFully.sequence;
            if (numArr2 == null) {
                numArr2 = new Integer[0];
            }
            if (numArr.length == 0) {
                ArrayList arrayList2 = new ArrayList(numArr2.length);
                for (Integer[] numArr3 : numArr2) {
                    Integer num = numArr3[0];
                    j.d(num, "it[0]");
                    int intValue = num.intValue();
                    Integer num2 = numArr3[1];
                    j.d(num2, "it[1]");
                    int intValue2 = num2.intValue();
                    Integer num3 = numArr3[2];
                    j.d(num3, "it[2]");
                    arrayList2.add(Integer.valueOf(new com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c(intValue, intValue2, num3.intValue()).g()));
                }
                arrayList.addAll(arrayList2);
            } else if (!(numArr2.length == 0)) {
                int length = numArr.length;
                int i = 0;
                int i2 = 0;
                while (i < length) {
                    int length2 = numArr2.length;
                    if (i < 0 || length2 <= i) {
                        break;
                    }
                    Integer num4 = numArr[i];
                    Integer[] numArr4 = numArr2[i];
                    Integer num5 = numArr4[c2];
                    j.d(num5, "it[0]");
                    int intValue3 = num5.intValue();
                    Integer num6 = numArr4[1];
                    j.d(num6, "it[1]");
                    int intValue4 = num6.intValue();
                    Integer num7 = numArr4[2];
                    j.d(num7, "it[2]");
                    int g = new com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c(intValue3, intValue4, num7.intValue()).g();
                    int intValue5 = (num4.intValue() - i2) + 1;
                    for (int i3 = 0; i3 < intValue5; i3++) {
                        arrayList.add(Integer.valueOf(g));
                    }
                    i2 = num4.intValue() + 1;
                    i++;
                    c2 = 0;
                }
            }
        } else {
            Integer[][] numArr5 = resolveDisplayColorsFully.display_colors;
            if (numArr5 != null) {
                collection = new ArrayList(numArr5.length);
                for (Integer[] numArr6 : numArr5) {
                    Integer num8 = numArr6[0];
                    j.d(num8, "it[0]");
                    int intValue6 = num8.intValue();
                    Integer num9 = numArr6[1];
                    j.d(num9, "it[1]");
                    int intValue7 = num9.intValue();
                    Integer num10 = numArr6[2];
                    j.d(num10, "it[2]");
                    collection.add(Integer.valueOf(new com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c(intValue6, intValue7, num10.intValue()).g()));
                }
            } else {
                collection = kotlin.collections.n.d();
            }
            arrayList.addAll(collection);
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.util.List<java.lang.Integer> u(com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightingEffectData r14) {
        /*
            Method dump skipped, instructions count: 297
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.u(com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightingEffectData):java.util.List");
    }

    @ColorInt
    public static final int v(LightStateBean resolveNormalColor) {
        j.e(resolveNormalColor, "$this$resolveNormalColor");
        if (resolveNormalColor.getColorTemp() != 0) {
            return -1;
        }
        return new com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c(resolveNormalColor.getHue(), resolveNormalColor.getSaturation(), resolveNormalColor.getBrightness()).g();
    }

    public static final PredefinedEffectsTemplateInput w(AbstractLightingEffect resolveTemplateInput) {
        IntegerAttributeValue colors;
        Integer absolute;
        k initialValues;
        IntegerAttributeValue colors2;
        Integer absolute2;
        j.e(resolveTemplateInput, "$this$resolveTemplateInput");
        if (resolveTemplateInput instanceof PredefinedEffect) {
            PredefinedEffect predefinedEffect = (PredefinedEffect) resolveTemplateInput;
            CustomizationSettings customization = predefinedEffect.getCustomization();
            int i = 1;
            if (customization == null || (initialValues = customization.getInitialValues()) == null) {
                CustomizationSettings customization2 = predefinedEffect.getCustomization();
                if (!(customization2 == null || (colors = customization2.getColors()) == null || (absolute = colors.getAbsolute()) == null)) {
                    i = absolute.intValue();
                }
                return l(i);
            }
            try {
                return (PredefinedEffectsTemplateInput) i.a(initialValues, PredefinedEffectsTemplateInput.class);
            } catch (Exception e2) {
                b.d.w.c.a.e("LightingEffectExt", e2.toString());
                CustomizationSettings customization3 = predefinedEffect.getCustomization();
                if (!(customization3 == null || (colors2 = customization3.getColors()) == null || (absolute2 = colors2.getAbsolute()) == null)) {
                    i = absolute2.intValue();
                }
                return l(i);
            }
        } else if (resolveTemplateInput instanceof CustomizedEffect) {
            return (PredefinedEffectsTemplateInput) i.c(((CustomizedEffect) resolveTemplateInput).getTemplateInput(), PredefinedEffectsTemplateInput.class);
        } else {
            return null;
        }
    }

    public static final AbstractLightingEffect x(AbstractLightingEffect splitColorPaintingSegments) {
        ColorSequence colorSequence;
        j.e(splitColorPaintingSegments, "$this$splitColorPaintingSegments");
        List<Segment> segments = splitColorPaintingSegments.getSegments();
        LightingEffectSettings settings = splitColorPaintingSegments.getSettings();
        List<ColorHSBAttributeValue> seq = (settings == null || (colorSequence = settings.getColorSequence()) == null) ? null : colorSequence.getSeq();
        boolean z = true;
        if (segments == null || segments.isEmpty()) {
            return splitColorPaintingSegments;
        }
        if (seq != null && !seq.isEmpty()) {
            z = false;
        }
        if (z || segments.size() != seq.size()) {
            return splitColorPaintingSegments;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int size = segments.size();
        for (int i = 0; i < size; i++) {
            Segment seg = segments.get(i);
            ColorHSBAttributeValue color = seq.get(i);
            j.d(seg, "seg");
            int intValue = seg.getStart().intValue();
            Integer end = seg.getEnd();
            j.d(end, "seg.end");
            int intValue2 = end.intValue();
            if (intValue <= intValue2) {
                while (true) {
                    Segment curSegment = Segment.builder().start(Integer.valueOf(intValue)).end(Integer.valueOf(intValue)).build();
                    j.d(curSegment, "curSegment");
                    arrayList.add(curSegment);
                    ColorHSBAttributeValue.ColorHSBAttributeValueBuilder builder = ColorHSBAttributeValue.builder();
                    j.d(color, "color");
                    ColorHSBAttributeValue curColor = builder.id(color.getId()).h(color.getH()).s(color.getS()).b(color.getB()).build();
                    j.d(curColor, "curColor");
                    arrayList2.add(curColor);
                    if (intValue != intValue2) {
                        intValue++;
                    }
                }
            }
        }
        AbstractLightingEffect d2 = d(splitColorPaintingSegments);
        d2.setSegments(arrayList);
        LightingEffectSettings settings2 = d2.getSettings();
        j.d(settings2, "copy.settings");
        ColorSequence colorSequence2 = settings2.getColorSequence();
        j.d(colorSequence2, "copy.settings.colorSequence");
        colorSequence2.setSeq(arrayList2);
        return d2;
    }

    public static final LightStripLightingEffect y(AbstractLightingEffect transform) {
        String str;
        j.e(transform, "$this$transform");
        if (transform instanceof PredefinedEffect) {
            str = LightingEffectType.PREDEFINED.getValue();
        } else if (transform instanceof CustomizedEffect) {
            str = LightingEffectType.CUSTOM.getValue();
        } else if (transform instanceof LightStripLightingEffect) {
            str = ((LightStripLightingEffect) transform).getSourceType();
        } else {
            str = LightingEffectType.UNKNOWN.getValue();
        }
        LightStripLightingEffect build = LightStripLightingEffect.builder().sourceType(str).onOff(1).id(transform.getId()).createdOn(transform.getCreatedOn()).updatedOn(transform.getUpdatedOn()).expansionStrategy(transform.getExpansionStrategy()).meta(transform.getMeta()).settings(transform.getSettings()).type(transform.getType()).segments(transform.getSegments()).colorRegistry(transform.getColorRegistry()).customization(transform.getCustomization()).animationType(transform.getAnimationType()).version(transform.getVersion()).build();
        j.d(build, "LightStripLightingEffect…ion)\n            .build()");
        return build;
    }

    public static final LightStripLightingEffect z(CustomizedEffect transform) {
        j.e(transform, "$this$transform");
        LightStripLightingEffect build = LightStripLightingEffect.builder().sourceType(LightingEffectType.CUSTOM.getValue()).onOff(1).id(transform.getId()).createdOn(transform.getCreatedOn()).updatedOn(transform.getUpdatedOn()).expansionStrategy(transform.getExpansionStrategy()).meta(transform.getMeta()).settings(transform.getSettings()).type(transform.getType()).segments(transform.getSegments()).colorRegistry(transform.getColorRegistry()).customization(transform.getCustomization()).animationType(transform.getAnimationType()).version(transform.getVersion()).build();
        j.d(build, "LightStripLightingEffect…ion)\n            .build()");
        return build;
    }
}
