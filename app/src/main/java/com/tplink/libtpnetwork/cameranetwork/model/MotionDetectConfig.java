package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class MotionDetectConfig {
    @c("digital_sensitivity")
    private final String digitalSensitivity;
    private final String enabled;
    private final String enhanced;
    private final String sensitivity;

    public MotionDetectConfig(String digitalSensitivity, String enabled, String str, String str2) {
        j.e(digitalSensitivity, "digitalSensitivity");
        j.e(enabled, "enabled");
        this.digitalSensitivity = digitalSensitivity;
        this.enabled = enabled;
        this.sensitivity = str;
        this.enhanced = str2;
    }

    public static /* synthetic */ MotionDetectConfig copy$default(MotionDetectConfig motionDetectConfig, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = motionDetectConfig.digitalSensitivity;
        }
        if ((i & 2) != 0) {
            str2 = motionDetectConfig.enabled;
        }
        if ((i & 4) != 0) {
            str3 = motionDetectConfig.sensitivity;
        }
        if ((i & 8) != 0) {
            str4 = motionDetectConfig.enhanced;
        }
        return motionDetectConfig.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.digitalSensitivity;
    }

    public final String component2() {
        return this.enabled;
    }

    public final String component3() {
        return this.sensitivity;
    }

    public final String component4() {
        return this.enhanced;
    }

    public final MotionDetectConfig copy(String digitalSensitivity, String enabled, String str, String str2) {
        j.e(digitalSensitivity, "digitalSensitivity");
        j.e(enabled, "enabled");
        return new MotionDetectConfig(digitalSensitivity, enabled, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MotionDetectConfig)) {
            return false;
        }
        MotionDetectConfig motionDetectConfig = (MotionDetectConfig) obj;
        return j.a(this.digitalSensitivity, motionDetectConfig.digitalSensitivity) && j.a(this.enabled, motionDetectConfig.enabled) && j.a(this.sensitivity, motionDetectConfig.sensitivity) && j.a(this.enhanced, motionDetectConfig.enhanced);
    }

    public final String getDigitalSensitivity() {
        return this.digitalSensitivity;
    }

    public final String getEnabled() {
        return this.enabled;
    }

    public final String getEnhanced() {
        return this.enhanced;
    }

    public final String getSensitivity() {
        return this.sensitivity;
    }

    public int hashCode() {
        String str = this.digitalSensitivity;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.enabled;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.sensitivity;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.enhanced;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "MotionDetectConfig(digitalSensitivity=" + this.digitalSensitivity + ", enabled=" + this.enabled + ", sensitivity=" + this.sensitivity + ", enhanced=" + this.enhanced + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MotionDetectConfig(int r3, boolean r4, java.lang.Boolean r5) {
        /*
            r2 = this;
            java.lang.String r3 = java.lang.String.valueOf(r3)
            com.tplink.libtpnetwork.cameranetwork.model.OptionSwitch$Companion r0 = com.tplink.libtpnetwork.cameranetwork.model.OptionSwitch.Companion
            com.tplink.libtpnetwork.cameranetwork.model.OptionSwitch r4 = r0.fromBoolean(r4)
            java.lang.String r4 = r4.getRaw()
            r1 = 0
            if (r5 != 0) goto L_0x0013
            r5 = r1
            goto L_0x001f
        L_0x0013:
            boolean r5 = r5.booleanValue()
            com.tplink.libtpnetwork.cameranetwork.model.OptionSwitch r5 = r0.fromBoolean(r5)
            java.lang.String r5 = r5.getRaw()
        L_0x001f:
            r2.<init>(r3, r4, r1, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.libtpnetwork.cameranetwork.model.MotionDetectConfig.<init>(int, boolean, java.lang.Boolean):void");
    }
}
