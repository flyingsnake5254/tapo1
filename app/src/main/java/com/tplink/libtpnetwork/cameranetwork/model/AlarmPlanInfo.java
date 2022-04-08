package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class AlarmPlanInfo {
    private final String enabled;
    @c("alarm_plan_1")
    private final String plan;

    public AlarmPlanInfo(String enabled, String plan) {
        j.e(enabled, "enabled");
        j.e(plan, "plan");
        this.enabled = enabled;
        this.plan = plan;
    }

    public static /* synthetic */ AlarmPlanInfo copy$default(AlarmPlanInfo alarmPlanInfo, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = alarmPlanInfo.enabled;
        }
        if ((i & 2) != 0) {
            str2 = alarmPlanInfo.plan;
        }
        return alarmPlanInfo.copy(str, str2);
    }

    public final String component1() {
        return this.enabled;
    }

    public final String component2() {
        return this.plan;
    }

    public final AlarmPlanInfo copy(String enabled, String plan) {
        j.e(enabled, "enabled");
        j.e(plan, "plan");
        return new AlarmPlanInfo(enabled, plan);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AlarmPlanInfo)) {
            return false;
        }
        AlarmPlanInfo alarmPlanInfo = (AlarmPlanInfo) obj;
        return j.a(this.enabled, alarmPlanInfo.enabled) && j.a(this.plan, alarmPlanInfo.plan);
    }

    public final String getEnabled() {
        return this.enabled;
    }

    public final String getPlan() {
        return this.plan;
    }

    public int hashCode() {
        String str = this.enabled;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.plan;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "AlarmPlanInfo(enabled=" + this.enabled + ", plan=" + this.plan + ")";
    }
}
