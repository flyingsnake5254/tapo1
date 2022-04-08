package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class WhiteLampConfig {
    @c("wtl_intensity_level")
    private final String wtlIntensityLevel;

    public WhiteLampConfig(String str) {
        this.wtlIntensityLevel = str;
    }

    public static /* synthetic */ WhiteLampConfig copy$default(WhiteLampConfig whiteLampConfig, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = whiteLampConfig.wtlIntensityLevel;
        }
        return whiteLampConfig.copy(str);
    }

    public final String component1() {
        return this.wtlIntensityLevel;
    }

    public final WhiteLampConfig copy(String str) {
        return new WhiteLampConfig(str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof WhiteLampConfig) && j.a(this.wtlIntensityLevel, ((WhiteLampConfig) obj).wtlIntensityLevel);
        }
        return true;
    }

    public final String getWtlIntensityLevel() {
        return this.wtlIntensityLevel;
    }

    public int hashCode() {
        String str = this.wtlIntensityLevel;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "WhiteLampConfig(wtlIntensityLevel=" + this.wtlIntensityLevel + ")";
    }

    public WhiteLampConfig(int i) {
        this(String.valueOf(i));
    }
}
