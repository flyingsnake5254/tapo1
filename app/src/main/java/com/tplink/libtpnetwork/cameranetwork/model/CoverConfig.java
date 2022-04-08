package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class CoverConfig {
    private final String enabled;

    public CoverConfig(String enabled) {
        j.e(enabled, "enabled");
        this.enabled = enabled;
    }

    public static /* synthetic */ CoverConfig copy$default(CoverConfig coverConfig, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = coverConfig.enabled;
        }
        return coverConfig.copy(str);
    }

    public final String component1() {
        return this.enabled;
    }

    public final CoverConfig copy(String enabled) {
        j.e(enabled, "enabled");
        return new CoverConfig(enabled);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof CoverConfig) && j.a(this.enabled, ((CoverConfig) obj).enabled);
        }
        return true;
    }

    public final String getEnabled() {
        return this.enabled;
    }

    public int hashCode() {
        String str = this.enabled;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "CoverConfig(enabled=" + this.enabled + ")";
    }

    public CoverConfig(boolean z) {
        this(z ? "on" : "off");
    }
}
