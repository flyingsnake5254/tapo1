package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import java.util.List;
import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class AlarmInfo {
    @c("alarm_type")
    private final String alarmType;
    private final String enabled;
    @c("light_type")
    private final String lightType;
    @c("alarm_mode")
    private final List<String> modes;

    public AlarmInfo(String alarmType, String enabled, String str, List<String> modes) {
        j.e(alarmType, "alarmType");
        j.e(enabled, "enabled");
        j.e(modes, "modes");
        this.alarmType = alarmType;
        this.enabled = enabled;
        this.lightType = str;
        this.modes = modes;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AlarmInfo copy$default(AlarmInfo alarmInfo, String str, String str2, String str3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = alarmInfo.alarmType;
        }
        if ((i & 2) != 0) {
            str2 = alarmInfo.enabled;
        }
        if ((i & 4) != 0) {
            str3 = alarmInfo.lightType;
        }
        if ((i & 8) != 0) {
            list = alarmInfo.modes;
        }
        return alarmInfo.copy(str, str2, str3, list);
    }

    public final String component1() {
        return this.alarmType;
    }

    public final String component2() {
        return this.enabled;
    }

    public final String component3() {
        return this.lightType;
    }

    public final List<String> component4() {
        return this.modes;
    }

    public final AlarmInfo copy(String alarmType, String enabled, String str, List<String> modes) {
        j.e(alarmType, "alarmType");
        j.e(enabled, "enabled");
        j.e(modes, "modes");
        return new AlarmInfo(alarmType, enabled, str, modes);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AlarmInfo)) {
            return false;
        }
        AlarmInfo alarmInfo = (AlarmInfo) obj;
        return j.a(this.alarmType, alarmInfo.alarmType) && j.a(this.enabled, alarmInfo.enabled) && j.a(this.lightType, alarmInfo.lightType) && j.a(this.modes, alarmInfo.modes);
    }

    public final String getAlarmType() {
        return this.alarmType;
    }

    public final String getEnabled() {
        return this.enabled;
    }

    public final String getLightType() {
        return this.lightType;
    }

    public final List<String> getModes() {
        return this.modes;
    }

    public int hashCode() {
        String str = this.alarmType;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.enabled;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.lightType;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        List<String> list = this.modes;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "AlarmInfo(alarmType=" + this.alarmType + ", enabled=" + this.enabled + ", lightType=" + this.lightType + ", modes=" + this.modes + ")";
    }
}
