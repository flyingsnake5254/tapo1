package com.tplink.libtpstreampreconnect.bean;

/* loaded from: classes3.dex */
public class NatStatistics {
    public static final int STATUS_FAILURE_UNKNOWN = -1;
    private int failureReason;
    private long penetrationTime;

    public int getFailureReason() {
        return this.failureReason;
    }

    public long getPenetrationTime() {
        return this.penetrationTime;
    }

    public void setFailureReason(int i) {
        this.failureReason = i;
    }

    public void setPenetrationTime(long j) {
        this.penetrationTime = j;
    }

    public String toString() {
        return "failureReason : ".concat(String.valueOf(this.failureReason)).concat("   penetrationTime : ").concat(String.valueOf(this.penetrationTime));
    }
}
