package com.tplink.libtpnetwork.IoTNetwork.bean.hub.result;

import com.google.gson.q.c;
import java.util.List;
import kotlin.jvm.internal.j;

/* compiled from: HubAlarmLogsResult.kt */
/* loaded from: classes3.dex */
public final class HubAlarmLogsResult {
    private final List<HubAlarmLog> logs;
    @c("start_id")
    private final int startId;
    private final int sum;

    public HubAlarmLogsResult(int i, int i2, List<HubAlarmLog> logs) {
        j.e(logs, "logs");
        this.startId = i;
        this.sum = i2;
        this.logs = logs;
    }

    public final List<HubAlarmLog> getLogs() {
        return this.logs;
    }

    public final int getStartId() {
        return this.startId;
    }

    public final int getSum() {
        return this.sum;
    }
}
