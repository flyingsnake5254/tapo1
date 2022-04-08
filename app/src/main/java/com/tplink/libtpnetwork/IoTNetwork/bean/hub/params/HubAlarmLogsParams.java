package com.tplink.libtpnetwork.IoTNetwork.bean.hub.params;

import com.google.gson.q.c;

/* compiled from: HubAlarmLogsParams.kt */
/* loaded from: classes3.dex */
public final class HubAlarmLogsParams {
    @c("page_size")
    private int pageSize;
    @c("start_id")
    private int startId;

    public HubAlarmLogsParams(int i, int i2) {
        this.startId = i;
        this.pageSize = i2;
    }

    public static /* synthetic */ HubAlarmLogsParams copy$default(HubAlarmLogsParams hubAlarmLogsParams, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = hubAlarmLogsParams.startId;
        }
        if ((i3 & 2) != 0) {
            i2 = hubAlarmLogsParams.pageSize;
        }
        return hubAlarmLogsParams.copy(i, i2);
    }

    public final int component1() {
        return this.startId;
    }

    public final int component2() {
        return this.pageSize;
    }

    public final HubAlarmLogsParams copy(int i, int i2) {
        return new HubAlarmLogsParams(i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HubAlarmLogsParams)) {
            return false;
        }
        HubAlarmLogsParams hubAlarmLogsParams = (HubAlarmLogsParams) obj;
        return this.startId == hubAlarmLogsParams.startId && this.pageSize == hubAlarmLogsParams.pageSize;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    public final int getStartId() {
        return this.startId;
    }

    public int hashCode() {
        return (this.startId * 31) + this.pageSize;
    }

    public final void setPageSize(int i) {
        this.pageSize = i;
    }

    public final void setStartId(int i) {
        this.startId = i;
    }

    public String toString() {
        return "HubAlarmLogsParams(startId=" + this.startId + ", pageSize=" + this.pageSize + ")";
    }
}
