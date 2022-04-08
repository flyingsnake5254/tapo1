package com.tplink.libtpnetwork.IoTNetwork.bean.sub.common;

import com.google.gson.q.c;
import java.util.List;
import kotlin.jvm.internal.j;

/* compiled from: TriggerLogs.kt */
/* loaded from: classes3.dex */
public final class TriggerLogsResult {
    private List<TriggerLog> logs;
    @c("start_id")
    private int startId;
    private int sum;

    public TriggerLogsResult(int i, int i2, List<TriggerLog> logs) {
        j.e(logs, "logs");
        this.startId = i;
        this.sum = i2;
        this.logs = logs;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TriggerLogsResult copy$default(TriggerLogsResult triggerLogsResult, int i, int i2, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = triggerLogsResult.startId;
        }
        if ((i3 & 2) != 0) {
            i2 = triggerLogsResult.sum;
        }
        if ((i3 & 4) != 0) {
            list = triggerLogsResult.logs;
        }
        return triggerLogsResult.copy(i, i2, list);
    }

    public final int component1() {
        return this.startId;
    }

    public final int component2() {
        return this.sum;
    }

    public final List<TriggerLog> component3() {
        return this.logs;
    }

    public final TriggerLogsResult copy(int i, int i2, List<TriggerLog> logs) {
        j.e(logs, "logs");
        return new TriggerLogsResult(i, i2, logs);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TriggerLogsResult)) {
            return false;
        }
        TriggerLogsResult triggerLogsResult = (TriggerLogsResult) obj;
        return this.startId == triggerLogsResult.startId && this.sum == triggerLogsResult.sum && j.a(this.logs, triggerLogsResult.logs);
    }

    public final List<TriggerLog> getLogs() {
        return this.logs;
    }

    public final int getStartId() {
        return this.startId;
    }

    public final int getSum() {
        return this.sum;
    }

    public int hashCode() {
        int i = ((this.startId * 31) + this.sum) * 31;
        List<TriggerLog> list = this.logs;
        return i + (list != null ? list.hashCode() : 0);
    }

    public final void setLogs(List<TriggerLog> list) {
        j.e(list, "<set-?>");
        this.logs = list;
    }

    public final void setStartId(int i) {
        this.startId = i;
    }

    public final void setSum(int i) {
        this.sum = i;
    }

    public String toString() {
        return "TriggerLogsResult(startId=" + this.startId + ", sum=" + this.sum + ", logs=" + this.logs + ")";
    }
}
