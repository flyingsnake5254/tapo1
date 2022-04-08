package com.tplink.iot.devices.lightstrip.lightingeffect.template;

import com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a.a;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.CustomizedEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.PredefinedEffectTemplate;
import com.tplink.libtpnetwork.Utils.i;
import java.util.HashMap;
import kotlin.jvm.internal.j;

/* compiled from: LightingEffectTemplateProcessor.kt */
/* loaded from: classes2.dex */
public final class LightingEffectTemplateProcessor {
    private final a templateProcessor;

    public LightingEffectTemplateProcessor(a templateProcessor) {
        j.e(templateProcessor, "templateProcessor");
        this.templateProcessor = templateProcessor;
    }

    private final String compileTemplate(String str, PredefinedEffectsTemplateInput predefinedEffectsTemplateInput) {
        HashMap hashMap = new HashMap();
        hashMap.put("colors", predefinedEffectsTemplateInput.getColors());
        hashMap.put("speed", predefinedEffectsTemplateInput.getSpeed());
        return this.templateProcessor.a(str, hashMap);
    }

    public final CustomizedEffect compileEffect(PredefinedEffectTemplate effectTemplate, PredefinedEffectsTemplateInput input) {
        j.e(effectTemplate, "effectTemplate");
        j.e(input, "input");
        String decodeTemplate = PredefinedEffectTemplateExtKt.decodeTemplate(effectTemplate);
        if (decodeTemplate != null) {
            return compileEffect(decodeTemplate, input);
        }
        return null;
    }

    public final CustomizedEffect compileEffect(String templateStr, PredefinedEffectsTemplateInput input) {
        j.e(templateStr, "templateStr");
        j.e(input, "input");
        return (CustomizedEffect) i.d(compileTemplate(templateStr, input), CustomizedEffect.class);
    }
}
