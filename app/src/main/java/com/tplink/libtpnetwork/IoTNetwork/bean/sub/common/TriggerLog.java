package com.tplink.libtpnetwork.IoTNetwork.bean.sub.common;

import java.util.Map;
import kotlin.jvm.internal.j;

/* compiled from: TriggerLogs.kt */
/* loaded from: classes3.dex */
public final class TriggerLog {
    private String event;
    private String eventId;
    private int id;
    private Map<String, ? extends Object> params;
    private long timestamp;

    public TriggerLog(int i, long j, @TriggerLogEvent String str, Map<String, ? extends Object> map) {
        this.id = i;
        this.timestamp = j;
        this.event = str;
        this.params = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TriggerLog copy$default(TriggerLog triggerLog, int i, long j, String str, Map map, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = triggerLog.id;
        }
        if ((i2 & 2) != 0) {
            j = triggerLog.timestamp;
        }
        if ((i2 & 4) != 0) {
            str = triggerLog.event;
        }
        if ((i2 & 8) != 0) {
            map = triggerLog.params;
        }
        return triggerLog.copy(i, j, str, map);
    }

    public final int component1() {
        return this.id;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final String component3() {
        return this.event;
    }

    public final Map<String, Object> component4() {
        return this.params;
    }

    public final TriggerLog copy(int i, long j, @TriggerLogEvent String str, Map<String, ? extends Object> map) {
        return new TriggerLog(i, j, str, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TriggerLog)) {
            return false;
        }
        TriggerLog triggerLog = (TriggerLog) obj;
        return this.id == triggerLog.id && this.timestamp == triggerLog.timestamp && j.a(this.event, triggerLog.event) && j.a(this.params, triggerLog.params);
    }

    public final String getEvent() {
        return this.event;
    }

    public final String getEventId() {
        return this.eventId;
    }

    public final int getId() {
        return this.id;
    }

    public final Map<String, Object> getParams() {
        return this.params;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        long j = this.timestamp;
        int i = ((this.id * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        String str = this.event;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        Map<String, ? extends Object> map = this.params;
        if (map != null) {
            i2 = map.hashCode();
        }
        return hashCode + i2;
    }

    public final void setEvent(String str) {
        this.event = str;
    }

    public final void setEventId(String str) {
        this.eventId = str;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setParams(Map<String, ? extends Object> map) {
        this.params = map;
    }

    public final void setTimestamp(long j) {
        this.timestamp = j;
    }

    public String toString() {
        return "TriggerLog(id=" + this.id + ", timestamp=" + this.timestamp + ", event=" + this.event + ", params=" + this.params + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public TriggerLog(com.tplink.iot.cloud.bean.thing.common.ThingEventLog r8) {
        /*
            r7 = this;
            java.lang.String r0 = "thingEventLog"
            kotlin.jvm.internal.j.e(r8, r0)
            java.lang.Integer r0 = r8.getLogId()
            if (r0 == 0) goto L_0x0011
            int r0 = r0.intValue()
            r2 = r0
            goto L_0x0013
        L_0x0011:
            r0 = 0
            r2 = 0
        L_0x0013:
            long r3 = r8.getTimestamp()
            java.lang.String r5 = r8.getName()
            java.util.Map r6 = r8.getParams()
            r1 = r7
            r1.<init>(r2, r3, r5, r6)
            java.lang.String r8 = r8.getEventId()
            r7.eventId = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.libtpnetwork.IoTNetwork.bean.sub.common.TriggerLog.<init>(com.tplink.iot.cloud.bean.thing.common.ThingEventLog):void");
    }
}
