package com.tplink.libtpnetwork.IoTNetwork.bean.sub.result;

import com.google.gson.q.c;

/* compiled from: RealTimeBatteryInfoResult.kt */
/* loaded from: classes3.dex */
public final class RealTimeBatteryInfoResult {
    @c("allow_upgrade")
    private boolean allowUpgrade;

    public RealTimeBatteryInfoResult(boolean z) {
        this.allowUpgrade = z;
    }

    public static /* synthetic */ RealTimeBatteryInfoResult copy$default(RealTimeBatteryInfoResult realTimeBatteryInfoResult, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = realTimeBatteryInfoResult.allowUpgrade;
        }
        return realTimeBatteryInfoResult.copy(z);
    }

    public final boolean component1() {
        return this.allowUpgrade;
    }

    public final RealTimeBatteryInfoResult copy(boolean z) {
        return new RealTimeBatteryInfoResult(z);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof RealTimeBatteryInfoResult) && this.allowUpgrade == ((RealTimeBatteryInfoResult) obj).allowUpgrade;
        }
        return true;
    }

    public final boolean getAllowUpgrade() {
        return this.allowUpgrade;
    }

    public int hashCode() {
        boolean z = this.allowUpgrade;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public final void setAllowUpgrade(boolean z) {
        this.allowUpgrade = z;
    }

    public String toString() {
        return "RealTimeBatteryInfoResult(allowUpgrade=" + this.allowUpgrade + ")";
    }

    public RealTimeBatteryInfoResult() {
        this(false);
    }
}
