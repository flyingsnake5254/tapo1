package com.tplink.libtpnetwork.IoTNetwork.bean.sub.common;

import com.google.gson.q.c;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import kotlin.jvm.internal.j;

/* compiled from: TriggerLogs.kt */
/* loaded from: classes3.dex */
public final class TriggerLogsParams {
    @c(ThingModelDefine.Event.UPLOAD_PARAMS_DEVICE_ID)
    private String deviceId;
    @c("page_size")
    private int pageSize;
    @c("start_id")
    private int startId;

    public TriggerLogsParams(String deviceId, int i, int i2) {
        j.e(deviceId, "deviceId");
        this.deviceId = deviceId;
        this.startId = i;
        this.pageSize = i2;
    }

    public static /* synthetic */ TriggerLogsParams copy$default(TriggerLogsParams triggerLogsParams, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = triggerLogsParams.deviceId;
        }
        if ((i3 & 2) != 0) {
            i = triggerLogsParams.startId;
        }
        if ((i3 & 4) != 0) {
            i2 = triggerLogsParams.pageSize;
        }
        return triggerLogsParams.copy(str, i, i2);
    }

    public final String component1() {
        return this.deviceId;
    }

    public final int component2() {
        return this.startId;
    }

    public final int component3() {
        return this.pageSize;
    }

    public final TriggerLogsParams copy(String deviceId, int i, int i2) {
        j.e(deviceId, "deviceId");
        return new TriggerLogsParams(deviceId, i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TriggerLogsParams)) {
            return false;
        }
        TriggerLogsParams triggerLogsParams = (TriggerLogsParams) obj;
        return j.a(this.deviceId, triggerLogsParams.deviceId) && this.startId == triggerLogsParams.startId && this.pageSize == triggerLogsParams.pageSize;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    public final int getStartId() {
        return this.startId;
    }

    public int hashCode() {
        String str = this.deviceId;
        return ((((str != null ? str.hashCode() : 0) * 31) + this.startId) * 31) + this.pageSize;
    }

    public final void setDeviceId(String str) {
        j.e(str, "<set-?>");
        this.deviceId = str;
    }

    public final void setPageSize(int i) {
        this.pageSize = i;
    }

    public final void setStartId(int i) {
        this.startId = i;
    }

    public String toString() {
        return "TriggerLogsParams(deviceId=" + this.deviceId + ", startId=" + this.startId + ", pageSize=" + this.pageSize + ")";
    }
}
