package com.tplink.libtpnetwork.IoTNetwork.bean.hub.result;

import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleGuardMode;
import com.tplink.libtpnetwork.enumerate.EnumGuardMode;
import com.tplink.libtpnetwork.enumerate.EnumGuardModeAlarmVolume;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.List;
import java.util.Map;
import kotlin.collections.e0;
import kotlin.jvm.internal.j;
import kotlin.n;

/* compiled from: GuardModeConfigBean.kt */
/* loaded from: classes3.dex */
public final class GuardModeConfigBean {
    @c("alarm_time")
    private GuardModeAlarmTimeBean alarmTime;
    @c("alarm_type")
    private String alarmType;
    @c("alarm_volume")
    private String alarmVolume;
    @c("device_id_list")
    private List<String> deviceIdList;
    private String id;

    public GuardModeConfigBean(String id, List<String> deviceIdList, String alarmType, String alarmVolume, GuardModeAlarmTimeBean alarmTime) {
        j.e(id, "id");
        j.e(deviceIdList, "deviceIdList");
        j.e(alarmType, "alarmType");
        j.e(alarmVolume, "alarmVolume");
        j.e(alarmTime, "alarmTime");
        this.id = id;
        this.deviceIdList = deviceIdList;
        this.alarmType = alarmType;
        this.alarmVolume = alarmVolume;
        this.alarmTime = alarmTime;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuardModeConfigBean copy$default(GuardModeConfigBean guardModeConfigBean, String str, List list, String str2, String str3, GuardModeAlarmTimeBean guardModeAlarmTimeBean, int i, Object obj) {
        if ((i & 1) != 0) {
            str = guardModeConfigBean.id;
        }
        if ((i & 2) != 0) {
            list = guardModeConfigBean.deviceIdList;
        }
        if ((i & 4) != 0) {
            str2 = guardModeConfigBean.alarmType;
        }
        if ((i & 8) != 0) {
            str3 = guardModeConfigBean.alarmVolume;
        }
        if ((i & 16) != 0) {
            guardModeAlarmTimeBean = guardModeConfigBean.alarmTime;
        }
        return guardModeConfigBean.copy(str, list, str2, str3, guardModeAlarmTimeBean);
    }

    public final String component1() {
        return this.id;
    }

    public final List<String> component2() {
        return this.deviceIdList;
    }

    public final String component3() {
        return this.alarmType;
    }

    public final String component4() {
        return this.alarmVolume;
    }

    public final GuardModeAlarmTimeBean component5() {
        return this.alarmTime;
    }

    public final GuardModeConfigBean copy(String id, List<String> deviceIdList, String alarmType, String alarmVolume, GuardModeAlarmTimeBean alarmTime) {
        j.e(id, "id");
        j.e(deviceIdList, "deviceIdList");
        j.e(alarmType, "alarmType");
        j.e(alarmVolume, "alarmVolume");
        j.e(alarmTime, "alarmTime");
        return new GuardModeConfigBean(id, deviceIdList, alarmType, alarmVolume, alarmTime);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GuardModeConfigBean)) {
            return false;
        }
        GuardModeConfigBean guardModeConfigBean = (GuardModeConfigBean) obj;
        return j.a(this.id, guardModeConfigBean.id) && j.a(this.deviceIdList, guardModeConfigBean.deviceIdList) && j.a(this.alarmType, guardModeConfigBean.alarmType) && j.a(this.alarmVolume, guardModeConfigBean.alarmVolume) && j.a(this.alarmTime, guardModeConfigBean.alarmTime);
    }

    public final GuardModeAlarmTimeBean getAlarmTime() {
        return this.alarmTime;
    }

    public final String getAlarmType() {
        return this.alarmType;
    }

    public final String getAlarmVolume() {
        return this.alarmVolume;
    }

    public final List<String> getDeviceIdList() {
        return this.deviceIdList;
    }

    public final EnumGuardModeAlarmVolume getEnumAlarmVolume() {
        String str = this.alarmVolume;
        EnumGuardModeAlarmVolume enumGuardModeAlarmVolume = EnumGuardModeAlarmVolume.MUTE;
        if (j.a(str, enumGuardModeAlarmVolume.getValue())) {
            return enumGuardModeAlarmVolume;
        }
        EnumGuardModeAlarmVolume enumGuardModeAlarmVolume2 = EnumGuardModeAlarmVolume.LOW;
        if (j.a(str, enumGuardModeAlarmVolume2.getValue())) {
            return enumGuardModeAlarmVolume2;
        }
        EnumGuardModeAlarmVolume enumGuardModeAlarmVolume3 = EnumGuardModeAlarmVolume.NORMAL;
        if (!j.a(str, enumGuardModeAlarmVolume3.getValue())) {
            enumGuardModeAlarmVolume3 = EnumGuardModeAlarmVolume.HIGH;
            if (!j.a(str, enumGuardModeAlarmVolume3.getValue())) {
                return enumGuardModeAlarmVolume2;
            }
        }
        return enumGuardModeAlarmVolume3;
    }

    public final EnumGuardMode getEnumGuardMode() {
        return EnumGuardMode.Companion.a(this.id);
    }

    public final String getId() {
        return this.id;
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<String> list = this.deviceIdList;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.alarmType;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.alarmVolume;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        GuardModeAlarmTimeBean guardModeAlarmTimeBean = this.alarmTime;
        if (guardModeAlarmTimeBean != null) {
            i = guardModeAlarmTimeBean.hashCode();
        }
        return hashCode4 + i;
    }

    public final void setAlarmTime(GuardModeAlarmTimeBean guardModeAlarmTimeBean) {
        j.e(guardModeAlarmTimeBean, "<set-?>");
        this.alarmTime = guardModeAlarmTimeBean;
    }

    public final void setAlarmType(String str) {
        j.e(str, "<set-?>");
        this.alarmType = str;
    }

    public final void setAlarmVolume(String str) {
        j.e(str, "<set-?>");
        this.alarmVolume = str;
    }

    public final void setDeviceIdList(List<String> list) {
        j.e(list, "<set-?>");
        this.deviceIdList = list;
    }

    public final void setId(String str) {
        j.e(str, "<set-?>");
        this.id = str;
    }

    public String toString() {
        return "GuardModeConfigBean(id=" + this.id + ", deviceIdList=" + this.deviceIdList + ", alarmType=" + this.alarmType + ", alarmVolume=" + this.alarmVolume + ", alarmTime=" + this.alarmTime + ")";
    }

    public final ThingRuleGuardMode toThingRuleGuardMode() {
        Map f2;
        String str = this.id;
        List<String> list = this.deviceIdList;
        String str2 = this.alarmType;
        String str3 = this.alarmVolume;
        f2 = e0.f(n.a("type", this.alarmTime.getType()), n.a(RtspHeaders.Values.TIME, Integer.valueOf(this.alarmTime.getTime())));
        return new ThingRuleGuardMode(str, list, str2, str3, f2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public GuardModeConfigBean(com.tplink.iot.cloud.bean.thing.common.ThingRuleGuardMode r8) {
        /*
            r7 = this;
            java.lang.String r0 = "ruleGuardMode"
            kotlin.jvm.internal.j.e(r8, r0)
            java.util.List r3 = kotlin.collections.l.d()
            com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeAlarmTimeBean$Companion r0 = com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeAlarmTimeBean.Companion
            com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeAlarmTimeBean r6 = r0.getDefault()
            java.lang.String r2 = ""
            java.lang.String r4 = ""
            java.lang.String r5 = ""
            r1 = r7
            r1.<init>(r2, r3, r4, r5, r6)
            java.lang.String r0 = r8.getId()
            if (r0 == 0) goto L_0x0020
            goto L_0x0026
        L_0x0020:
            com.tplink.libtpnetwork.enumerate.EnumGuardMode r0 = com.tplink.libtpnetwork.enumerate.EnumGuardMode.HOME
            java.lang.String r0 = r0.getValue()
        L_0x0026:
            r7.id = r0
            java.util.List r0 = r8.getDeviceIdList()
            if (r0 == 0) goto L_0x002f
            goto L_0x0033
        L_0x002f:
            java.util.List r0 = kotlin.collections.l.d()
        L_0x0033:
            r7.deviceIdList = r0
            java.lang.String r0 = r8.getAlarmType()
            if (r0 == 0) goto L_0x003c
            goto L_0x003e
        L_0x003c:
            java.lang.String r0 = ""
        L_0x003e:
            r7.alarmType = r0
            java.lang.String r0 = r8.getAlarmVolume()
            if (r0 == 0) goto L_0x0047
            goto L_0x004d
        L_0x0047:
            com.tplink.libtpnetwork.enumerate.EnumGuardModeAlarmVolume r0 = com.tplink.libtpnetwork.enumerate.EnumGuardModeAlarmVolume.HIGH
            java.lang.String r0 = r0.getValue()
        L_0x004d:
            r7.alarmVolume = r0
            java.util.Map r8 = r8.getAlarmTime()
            if (r8 == 0) goto L_0x0093
            com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeAlarmTimeBean r0 = r7.alarmTime
            java.lang.String r1 = "type"
            java.lang.Object r1 = r8.get(r1)
            boolean r2 = r1 instanceof java.lang.String
            if (r2 != 0) goto L_0x0062
            r1 = 0
        L_0x0062:
            java.lang.String r1 = (java.lang.String) r1
            if (r1 == 0) goto L_0x0067
            goto L_0x006d
        L_0x0067:
            com.tplink.libtpnetwork.enumerate.EnumGuardModeAlarmTimeType r1 = com.tplink.libtpnetwork.enumerate.EnumGuardModeAlarmTimeType.ALWAYS
            java.lang.String r1 = r1.getValue()
        L_0x006d:
            r0.setType(r1)
            com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeAlarmTimeBean r0 = r7.alarmTime
            java.lang.String r1 = "time"
            java.lang.Object r8 = r8.get(r1)
            boolean r1 = r8 instanceof java.lang.Long
            if (r1 == 0) goto L_0x0084
            java.lang.Number r8 = (java.lang.Number) r8
            long r1 = r8.longValue()
            int r8 = (int) r1
            goto L_0x0090
        L_0x0084:
            boolean r1 = r8 instanceof java.lang.Integer
            if (r1 == 0) goto L_0x008f
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            goto L_0x0090
        L_0x008f:
            r8 = 0
        L_0x0090:
            r0.setTime(r8)
        L_0x0093:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeConfigBean.<init>(com.tplink.iot.cloud.bean.thing.common.ThingRuleGuardMode):void");
    }
}
