package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class AutoUpdateInfo {
    private String enabled;
    @c("random_range")
    private Integer randomRange;
    private String time;

    public AutoUpdateInfo(String enabled, String str, Integer num) {
        j.e(enabled, "enabled");
        this.enabled = enabled;
        this.time = str;
        this.randomRange = num;
    }

    public static /* synthetic */ AutoUpdateInfo copy$default(AutoUpdateInfo autoUpdateInfo, String str, String str2, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = autoUpdateInfo.enabled;
        }
        if ((i & 2) != 0) {
            str2 = autoUpdateInfo.time;
        }
        if ((i & 4) != 0) {
            num = autoUpdateInfo.randomRange;
        }
        return autoUpdateInfo.copy(str, str2, num);
    }

    public final String component1() {
        return this.enabled;
    }

    public final String component2() {
        return this.time;
    }

    public final Integer component3() {
        return this.randomRange;
    }

    public final AutoUpdateInfo copy(String enabled, String str, Integer num) {
        j.e(enabled, "enabled");
        return new AutoUpdateInfo(enabled, str, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AutoUpdateInfo)) {
            return false;
        }
        AutoUpdateInfo autoUpdateInfo = (AutoUpdateInfo) obj;
        return j.a(this.enabled, autoUpdateInfo.enabled) && j.a(this.time, autoUpdateInfo.time) && j.a(this.randomRange, autoUpdateInfo.randomRange);
    }

    public final String getEnabled() {
        return this.enabled;
    }

    public final Integer getRandomRange() {
        return this.randomRange;
    }

    public final String getTime() {
        return this.time;
    }

    public int hashCode() {
        String str = this.enabled;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.time;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.randomRange;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode2 + i;
    }

    public final void setEnabled(String str) {
        j.e(str, "<set-?>");
        this.enabled = str;
    }

    public final void setRandomRange(Integer num) {
        this.randomRange = num;
    }

    public final void setTime(String str) {
        this.time = str;
    }

    public String toString() {
        return "AutoUpdateInfo(enabled=" + this.enabled + ", time=" + this.time + ", randomRange=" + this.randomRange + ")";
    }
}
