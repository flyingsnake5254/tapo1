package com.tplink.iot.devices.lightstrip.lightingeffect.template;

import androidx.annotation.ColorInt;
import kotlin.jvm.internal.j;

/* compiled from: PredefinedEffectsTemplateInput.kt */
/* loaded from: classes2.dex */
public final class PredefinedEffectsTemplateInputKt {
    @ColorInt
    public static final int toColorInt(LEColor toColorInt) {
        j.e(toColorInt, "$this$toColorInt");
        return toColorInt.toHSB().g();
    }
}
