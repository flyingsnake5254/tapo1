package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class RebootInfo {
    private String day;
    private String enabled;
    private final String now;
    private Integer random_range;
    private String time;

    public RebootInfo(String str, String str2, String enabled, String str3, Integer num) {
        j.e(enabled, "enabled");
        this.now = str;
        this.day = str2;
        this.enabled = enabled;
        this.time = str3;
        this.random_range = num;
    }

    public static /* synthetic */ RebootInfo copy$default(RebootInfo rebootInfo, String str, String str2, String str3, String str4, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rebootInfo.now;
        }
        if ((i & 2) != 0) {
            str2 = rebootInfo.day;
        }
        if ((i & 4) != 0) {
            str3 = rebootInfo.enabled;
        }
        if ((i & 8) != 0) {
            str4 = rebootInfo.time;
        }
        if ((i & 16) != 0) {
            num = rebootInfo.random_range;
        }
        return rebootInfo.copy(str, str2, str3, str4, num);
    }

    public final String component1() {
        return this.now;
    }

    public final String component2() {
        return this.day;
    }

    public final String component3() {
        return this.enabled;
    }

    public final String component4() {
        return this.time;
    }

    public final Integer component5() {
        return this.random_range;
    }

    public final RebootInfo copy(String str, String str2, String enabled, String str3, Integer num) {
        j.e(enabled, "enabled");
        return new RebootInfo(str, str2, enabled, str3, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RebootInfo)) {
            return false;
        }
        RebootInfo rebootInfo = (RebootInfo) obj;
        return j.a(this.now, rebootInfo.now) && j.a(this.day, rebootInfo.day) && j.a(this.enabled, rebootInfo.enabled) && j.a(this.time, rebootInfo.time) && j.a(this.random_range, rebootInfo.random_range);
    }

    public final String getDay() {
        return this.day;
    }

    public final String getEnabled() {
        return this.enabled;
    }

    public final String getNow() {
        return this.now;
    }

    public final Integer getRandom_range() {
        return this.random_range;
    }

    public final String getTime() {
        return this.time;
    }

    public int hashCode() {
        String str = this.now;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.day;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.enabled;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.time;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Integer num = this.random_range;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode4 + i;
    }

    public final void setDay(String str) {
        this.day = str;
    }

    public final void setEnabled(String str) {
        j.e(str, "<set-?>");
        this.enabled = str;
    }

    public final void setRandom_range(Integer num) {
        this.random_range = num;
    }

    public final void setTime(String str) {
        this.time = str;
    }

    public String toString() {
        return "RebootInfo(now=" + this.now + ", day=" + this.day + ", enabled=" + this.enabled + ", time=" + this.time + ", random_range=" + this.random_range + ")";
    }
}
