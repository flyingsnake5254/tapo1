package com.tplink.iot.devices.lightstrip.lightingeffect.template;

import kotlin.jvm.internal.j;

/* compiled from: PredefinedEffectsTemplateInput.kt */
/* loaded from: classes2.dex */
public final class Speed {
    private final Integer value;

    public Speed(Integer num) {
        this.value = num;
    }

    public static /* synthetic */ Speed copy$default(Speed speed, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = speed.value;
        }
        return speed.copy(num);
    }

    public final Integer component1() {
        return this.value;
    }

    public final Speed copy(Integer num) {
        return new Speed(num);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof Speed) && j.a(this.value, ((Speed) obj).value);
        }
        return true;
    }

    public final Integer getValue() {
        return this.value;
    }

    public int hashCode() {
        Integer num = this.value;
        if (num != null) {
            return num.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "Speed(value=" + this.value + ")";
    }
}
