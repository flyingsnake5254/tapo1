package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

/* compiled from: SettingsCacheModel.kt */
/* loaded from: classes3.dex */
public final class RebootInfoCache {
    private OptionSwitch enable;
    private String time;

    public RebootInfoCache(OptionSwitch optionSwitch, String str) {
        this.enable = optionSwitch;
        this.time = str;
    }

    public static /* synthetic */ RebootInfoCache copy$default(RebootInfoCache rebootInfoCache, OptionSwitch optionSwitch, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            optionSwitch = rebootInfoCache.enable;
        }
        if ((i & 2) != 0) {
            str = rebootInfoCache.time;
        }
        return rebootInfoCache.copy(optionSwitch, str);
    }

    public final OptionSwitch component1() {
        return this.enable;
    }

    public final String component2() {
        return this.time;
    }

    public final RebootInfoCache copy(OptionSwitch optionSwitch, String str) {
        return new RebootInfoCache(optionSwitch, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RebootInfoCache)) {
            return false;
        }
        RebootInfoCache rebootInfoCache = (RebootInfoCache) obj;
        return j.a(this.enable, rebootInfoCache.enable) && j.a(this.time, rebootInfoCache.time);
    }

    public final OptionSwitch getEnable() {
        return this.enable;
    }

    public final String getTime() {
        return this.time;
    }

    public int hashCode() {
        OptionSwitch optionSwitch = this.enable;
        int i = 0;
        int hashCode = (optionSwitch != null ? optionSwitch.hashCode() : 0) * 31;
        String str = this.time;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public final void setEnable(OptionSwitch optionSwitch) {
        this.enable = optionSwitch;
    }

    public final void setTime(String str) {
        this.time = str;
    }

    public String toString() {
        return "RebootInfoCache(enable=" + this.enable + ", time=" + this.time + ")";
    }
}
