package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class TamperDetectConfig {
    @c("digital_sensitivity")
    private final String digitalSensitivity;
    private final String enabled;
    private final String sensitivity;

    public TamperDetectConfig(String str, String str2, String str3) {
        this.digitalSensitivity = str;
        this.enabled = str2;
        this.sensitivity = str3;
    }

    public static /* synthetic */ TamperDetectConfig copy$default(TamperDetectConfig tamperDetectConfig, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = tamperDetectConfig.digitalSensitivity;
        }
        if ((i & 2) != 0) {
            str2 = tamperDetectConfig.enabled;
        }
        if ((i & 4) != 0) {
            str3 = tamperDetectConfig.sensitivity;
        }
        return tamperDetectConfig.copy(str, str2, str3);
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

    public final TamperDetectConfig copy(String str, String str2, String str3) {
        return new TamperDetectConfig(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TamperDetectConfig)) {
            return false;
        }
        TamperDetectConfig tamperDetectConfig = (TamperDetectConfig) obj;
        return j.a(this.digitalSensitivity, tamperDetectConfig.digitalSensitivity) && j.a(this.enabled, tamperDetectConfig.enabled) && j.a(this.sensitivity, tamperDetectConfig.sensitivity);
    }

    public final String getDigitalSensitivity() {
        return this.digitalSensitivity;
    }

    public final String getEnabled() {
        return this.enabled;
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
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "TamperDetectConfig(digitalSensitivity=" + this.digitalSensitivity + ", enabled=" + this.enabled + ", sensitivity=" + this.sensitivity + ")";
    }
}
