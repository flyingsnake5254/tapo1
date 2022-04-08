package com.tplink.iot.devices.lightstrip.lightingeffect.template;

import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: PredefinedEffectsTemplateInput.kt */
/* loaded from: classes2.dex */
public final class PredefinedEffectsTemplateInput {
    private final List<LEColor> colors;
    private final Speed speed;
    private final int version;

    public PredefinedEffectsTemplateInput(List<LEColor> colors, Speed speed, int i) {
        j.e(colors, "colors");
        j.e(speed, "speed");
        this.colors = colors;
        this.speed = speed;
        this.version = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PredefinedEffectsTemplateInput copy$default(PredefinedEffectsTemplateInput predefinedEffectsTemplateInput, List list, Speed speed, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = predefinedEffectsTemplateInput.colors;
        }
        if ((i2 & 2) != 0) {
            speed = predefinedEffectsTemplateInput.speed;
        }
        if ((i2 & 4) != 0) {
            i = predefinedEffectsTemplateInput.version;
        }
        return predefinedEffectsTemplateInput.copy(list, speed, i);
    }

    public final List<LEColor> component1() {
        return this.colors;
    }

    public final Speed component2() {
        return this.speed;
    }

    public final int component3() {
        return this.version;
    }

    public final PredefinedEffectsTemplateInput copy(List<LEColor> colors, Speed speed, int i) {
        j.e(colors, "colors");
        j.e(speed, "speed");
        return new PredefinedEffectsTemplateInput(colors, speed, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PredefinedEffectsTemplateInput)) {
            return false;
        }
        PredefinedEffectsTemplateInput predefinedEffectsTemplateInput = (PredefinedEffectsTemplateInput) obj;
        return j.a(this.colors, predefinedEffectsTemplateInput.colors) && j.a(this.speed, predefinedEffectsTemplateInput.speed) && this.version == predefinedEffectsTemplateInput.version;
    }

    public final List<LEColor> getColors() {
        return this.colors;
    }

    public final Speed getSpeed() {
        return this.speed;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        List<LEColor> list = this.colors;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        Speed speed = this.speed;
        if (speed != null) {
            i = speed.hashCode();
        }
        return ((hashCode + i) * 31) + this.version;
    }

    public String toString() {
        return "PredefinedEffectsTemplateInput(colors=" + this.colors + ", speed=" + this.speed + ", version=" + this.version + ")";
    }

    public /* synthetic */ PredefinedEffectsTemplateInput(List list, Speed speed, int i, int i2, f fVar) {
        this(list, speed, (i2 & 4) != 0 ? 1 : i);
    }
}
