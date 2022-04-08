package com.tplink.libtpnetwork.IoTNetwork.bean.hub.result;

import com.google.gson.q.b;
import com.google.gson.q.c;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import com.tplink.libtpnetwork.IoTNetwork.util.Base64TypeAdapter;
import com.tplink.libtpnetwork.enumerate.EnumGuardMode;
import kotlin.jvm.internal.j;

/* compiled from: HubAlarmLogsResult.kt */
/* loaded from: classes3.dex */
public final class HubAlarmLog {
    @c(ThingModelDefine.Event.UPLOAD_PARAMS_DEVICE_ID)
    private String deviceId;
    private String eventId;
    @c("guard_mode")
    private String guardMode;
    private int id;
    @b(Base64TypeAdapter.class)
    private String nickname;
    private long timestamp;

    public HubAlarmLog(int i, long j, String str, String str2, String str3) {
        this.id = i;
        this.timestamp = j;
        this.guardMode = str;
        this.deviceId = str2;
        this.nickname = str3;
    }

    public static /* synthetic */ HubAlarmLog copy$default(HubAlarmLog hubAlarmLog, int i, long j, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = hubAlarmLog.id;
        }
        if ((i2 & 2) != 0) {
            j = hubAlarmLog.timestamp;
        }
        if ((i2 & 4) != 0) {
            str = hubAlarmLog.guardMode;
        }
        if ((i2 & 8) != 0) {
            str2 = hubAlarmLog.deviceId;
        }
        if ((i2 & 16) != 0) {
            str3 = hubAlarmLog.nickname;
        }
        return hubAlarmLog.copy(i, j, str, str2, str3);
    }

    public final int component1() {
        return this.id;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final String component3() {
        return this.guardMode;
    }

    public final String component4() {
        return this.deviceId;
    }

    public final String component5() {
        return this.nickname;
    }

    public final HubAlarmLog copy(int i, long j, String str, String str2, String str3) {
        return new HubAlarmLog(i, j, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HubAlarmLog)) {
            return false;
        }
        HubAlarmLog hubAlarmLog = (HubAlarmLog) obj;
        return this.id == hubAlarmLog.id && this.timestamp == hubAlarmLog.timestamp && j.a(this.guardMode, hubAlarmLog.guardMode) && j.a(this.deviceId, hubAlarmLog.deviceId) && j.a(this.nickname, hubAlarmLog.nickname);
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final EnumGuardMode getEnumGuardMode() {
        return EnumGuardMode.Companion.b(this.guardMode);
    }

    public final String getEventId() {
        return this.eventId;
    }

    public final String getGuardMode() {
        return this.guardMode;
    }

    public final int getId() {
        return this.id;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        long j = this.timestamp;
        int i = ((this.id * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        String str = this.guardMode;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.deviceId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.nickname;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public final void setDeviceId(String str) {
        this.deviceId = str;
    }

    public final void setEventId(String str) {
        this.eventId = str;
    }

    public final void setGuardMode(String str) {
        this.guardMode = str;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setNickname(String str) {
        this.nickname = str;
    }

    public final void setTimestamp(long j) {
        this.timestamp = j;
    }

    public String toString() {
        return "HubAlarmLog(id=" + this.id + ", timestamp=" + this.timestamp + ", guardMode=" + this.guardMode + ", deviceId=" + this.deviceId + ", nickname=" + this.nickname + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public HubAlarmLog(com.tplink.iot.cloud.bean.thing.common.ThingEventLog r9) {
        /*
            r8 = this;
            java.lang.String r0 = "thingEventLog"
            kotlin.jvm.internal.j.e(r9, r0)
            java.lang.Integer r0 = r9.getLogId()
            if (r0 == 0) goto L_0x0011
            int r0 = r0.intValue()
            r2 = r0
            goto L_0x0013
        L_0x0011:
            r0 = 0
            r2 = 0
        L_0x0013:
            long r3 = r9.getTimestamp()
            r5 = 0
            r6 = 0
            r7 = 0
            r1 = r8
            r1.<init>(r2, r3, r5, r6, r7)
            java.lang.String r0 = r9.getEventId()
            r8.eventId = r0
            java.util.Map r0 = r9.getParams()
            r1 = 0
            if (r0 == 0) goto L_0x0032
            java.lang.String r2 = "guard_mode"
            java.lang.Object r0 = r0.get(r2)
            goto L_0x0033
        L_0x0032:
            r0 = r1
        L_0x0033:
            boolean r2 = r0 instanceof java.lang.String
            if (r2 != 0) goto L_0x0038
            r0 = r1
        L_0x0038:
            java.lang.String r0 = (java.lang.String) r0
            r8.guardMode = r0
            java.util.Map r0 = r9.getParams()
            if (r0 == 0) goto L_0x0049
            java.lang.String r2 = "device_id"
            java.lang.Object r0 = r0.get(r2)
            goto L_0x004a
        L_0x0049:
            r0 = r1
        L_0x004a:
            boolean r2 = r0 instanceof java.lang.String
            if (r2 != 0) goto L_0x004f
            r0 = r1
        L_0x004f:
            java.lang.String r0 = (java.lang.String) r0
            r8.deviceId = r0
            java.util.Map r9 = r9.getParams()
            if (r9 == 0) goto L_0x0060
            java.lang.String r0 = "nickname"
            java.lang.Object r9 = r9.get(r0)
            goto L_0x0061
        L_0x0060:
            r9 = r1
        L_0x0061:
            boolean r0 = r9 instanceof java.lang.String
            if (r0 != 0) goto L_0x0066
            goto L_0x0067
        L_0x0066:
            r1 = r9
        L_0x0067:
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r9 = b.d.w.h.a.a(r1)
            r8.nickname = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.HubAlarmLog.<init>(com.tplink.iot.cloud.bean.thing.common.ThingEventLog):void");
    }
}
