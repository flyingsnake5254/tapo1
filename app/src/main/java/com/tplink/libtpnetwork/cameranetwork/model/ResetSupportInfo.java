package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class ResetSupportInfo {
    @c("reset_wifi_supported")
    private final String resetWifiSupported;

    public ResetSupportInfo(String str) {
        this.resetWifiSupported = str;
    }

    public static /* synthetic */ ResetSupportInfo copy$default(ResetSupportInfo resetSupportInfo, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = resetSupportInfo.resetWifiSupported;
        }
        return resetSupportInfo.copy(str);
    }

    public final String component1() {
        return this.resetWifiSupported;
    }

    public final ResetSupportInfo copy(String str) {
        return new ResetSupportInfo(str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof ResetSupportInfo) && j.a(this.resetWifiSupported, ((ResetSupportInfo) obj).resetWifiSupported);
        }
        return true;
    }

    public final String getResetWifiSupported() {
        return this.resetWifiSupported;
    }

    public int hashCode() {
        String str = this.resetWifiSupported;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "ResetSupportInfo(resetWifiSupported=" + this.resetWifiSupported + ")";
    }
}
