package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class Timezone {
    @c("timing_mode")
    private final String mode;
    private final String offset;
    private String timezone;
    @c("zone_id")
    private final String zoneId;

    public Timezone(String timezone, String str, String str2, String str3) {
        j.e(timezone, "timezone");
        this.timezone = timezone;
        this.mode = str;
        this.zoneId = str2;
        this.offset = str3;
    }

    public static /* synthetic */ Timezone copy$default(Timezone timezone, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = timezone.timezone;
        }
        if ((i & 2) != 0) {
            str2 = timezone.mode;
        }
        if ((i & 4) != 0) {
            str3 = timezone.zoneId;
        }
        if ((i & 8) != 0) {
            str4 = timezone.offset;
        }
        return timezone.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.timezone;
    }

    public final String component2() {
        return this.mode;
    }

    public final String component3() {
        return this.zoneId;
    }

    public final String component4() {
        return this.offset;
    }

    public final Timezone copy(String timezone, String str, String str2, String str3) {
        j.e(timezone, "timezone");
        return new Timezone(timezone, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Timezone)) {
            return false;
        }
        Timezone timezone = (Timezone) obj;
        return j.a(this.timezone, timezone.timezone) && j.a(this.mode, timezone.mode) && j.a(this.zoneId, timezone.zoneId) && j.a(this.offset, timezone.offset);
    }

    public final String getMode() {
        return this.mode;
    }

    public final String getOffset() {
        return this.offset;
    }

    public final String getTimezone() {
        return this.timezone;
    }

    public final String getZoneId() {
        return this.zoneId;
    }

    public int hashCode() {
        String str = this.timezone;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.mode;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.zoneId;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.offset;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    public final void setTimezone(String str) {
        j.e(str, "<set-?>");
        this.timezone = str;
    }

    public String toString() {
        return "Timezone(timezone=" + this.timezone + ", mode=" + this.mode + ", zoneId=" + this.zoneId + ", offset=" + this.offset + ")";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Timezone(String zone, String region) {
        this(zone, "ntp", region, null);
        j.e(zone, "zone");
        j.e(region, "region");
    }
}
