package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

/* compiled from: SettingsCacheModel.kt */
/* loaded from: classes3.dex */
public final class NetworkInfoCache {
    private final String linkType;
    private String rssi;
    private String rssiValue;
    private String ssid;

    public NetworkInfoCache(String str, String str2, String str3, String str4) {
        this.ssid = str;
        this.linkType = str2;
        this.rssi = str3;
        this.rssiValue = str4;
    }

    public static /* synthetic */ NetworkInfoCache copy$default(NetworkInfoCache networkInfoCache, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = networkInfoCache.ssid;
        }
        if ((i & 2) != 0) {
            str2 = networkInfoCache.linkType;
        }
        if ((i & 4) != 0) {
            str3 = networkInfoCache.rssi;
        }
        if ((i & 8) != 0) {
            str4 = networkInfoCache.rssiValue;
        }
        return networkInfoCache.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.ssid;
    }

    public final String component2() {
        return this.linkType;
    }

    public final String component3() {
        return this.rssi;
    }

    public final String component4() {
        return this.rssiValue;
    }

    public final NetworkInfoCache copy(String str, String str2, String str3, String str4) {
        return new NetworkInfoCache(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkInfoCache)) {
            return false;
        }
        NetworkInfoCache networkInfoCache = (NetworkInfoCache) obj;
        return j.a(this.ssid, networkInfoCache.ssid) && j.a(this.linkType, networkInfoCache.linkType) && j.a(this.rssi, networkInfoCache.rssi) && j.a(this.rssiValue, networkInfoCache.rssiValue);
    }

    public final String getLinkType() {
        return this.linkType;
    }

    public final String getRssi() {
        return this.rssi;
    }

    public final String getRssiValue() {
        return this.rssiValue;
    }

    public final String getSsid() {
        return this.ssid;
    }

    public int hashCode() {
        String str = this.ssid;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.linkType;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.rssi;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.rssiValue;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    public final void setRssi(String str) {
        this.rssi = str;
    }

    public final void setRssiValue(String str) {
        this.rssiValue = str;
    }

    public final void setSsid(String str) {
        this.ssid = str;
    }

    public String toString() {
        return "NetworkInfoCache(ssid=" + this.ssid + ", linkType=" + this.linkType + ", rssi=" + this.rssi + ", rssiValue=" + this.rssiValue + ")";
    }
}
