package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class LensMaskInfo {
    private String enabled;

    public LensMaskInfo(String enabled) {
        j.e(enabled, "enabled");
        this.enabled = enabled;
    }

    public static /* synthetic */ LensMaskInfo copy$default(LensMaskInfo lensMaskInfo, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = lensMaskInfo.enabled;
        }
        return lensMaskInfo.copy(str);
    }

    public final String component1() {
        return this.enabled;
    }

    public final LensMaskInfo copy(String enabled) {
        j.e(enabled, "enabled");
        return new LensMaskInfo(enabled);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof LensMaskInfo) && j.a(this.enabled, ((LensMaskInfo) obj).enabled);
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

    public final void setEnabled(String str) {
        j.e(str, "<set-?>");
        this.enabled = str;
    }

    public String toString() {
        return "LensMaskInfo(enabled=" + this.enabled + ")";
    }
}
