package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class LedStatus {
    private String enabled;

    public LedStatus(String enabled) {
        j.e(enabled, "enabled");
        this.enabled = enabled;
    }

    public static /* synthetic */ LedStatus copy$default(LedStatus ledStatus, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ledStatus.enabled;
        }
        return ledStatus.copy(str);
    }

    public final String component1() {
        return this.enabled;
    }

    public final LedStatus copy(String enabled) {
        j.e(enabled, "enabled");
        return new LedStatus(enabled);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof LedStatus) && j.a(this.enabled, ((LedStatus) obj).enabled);
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
        return "LedStatus(enabled=" + this.enabled + ")";
    }
}
