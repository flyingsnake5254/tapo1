package com.tplink.libtpnetwork.IoTNetwork.bean.sub.result;

import com.google.gson.q.c;

/* compiled from: BatteryDetectInfoResult.kt */
/* loaded from: classes3.dex */
public final class BatteryDetectInfoResult {
    @c("is_low")
    private boolean isLow;

    public BatteryDetectInfoResult(boolean z) {
        this.isLow = z;
    }

    public static /* synthetic */ BatteryDetectInfoResult copy$default(BatteryDetectInfoResult batteryDetectInfoResult, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = batteryDetectInfoResult.isLow;
        }
        return batteryDetectInfoResult.copy(z);
    }

    public final boolean component1() {
        return this.isLow;
    }

    public final BatteryDetectInfoResult copy(boolean z) {
        return new BatteryDetectInfoResult(z);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof BatteryDetectInfoResult) && this.isLow == ((BatteryDetectInfoResult) obj).isLow;
        }
        return true;
    }

    public int hashCode() {
        boolean z = this.isLow;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public final boolean isLow() {
        return this.isLow;
    }

    public final void setLow(boolean z) {
        this.isLow = z;
    }

    public String toString() {
        return "BatteryDetectInfoResult(isLow=" + this.isLow + ")";
    }
}
