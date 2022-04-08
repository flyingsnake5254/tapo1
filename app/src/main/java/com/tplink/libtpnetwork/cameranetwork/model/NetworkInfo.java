package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class NetworkInfo {
    @c("link_type")
    private final String linkType;
    private final String rssi;
    private final String rssiValue;
    private final String ssid;

    public NetworkInfo(String ssid, String str, String rssi, String rssiValue) {
        j.e(ssid, "ssid");
        j.e(rssi, "rssi");
        j.e(rssiValue, "rssiValue");
        this.ssid = ssid;
        this.linkType = str;
        this.rssi = rssi;
        this.rssiValue = rssiValue;
    }

    public static /* synthetic */ NetworkInfo copy$default(NetworkInfo networkInfo, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = networkInfo.ssid;
        }
        if ((i & 2) != 0) {
            str2 = networkInfo.linkType;
        }
        if ((i & 4) != 0) {
            str3 = networkInfo.rssi;
        }
        if ((i & 8) != 0) {
            str4 = networkInfo.rssiValue;
        }
        return networkInfo.copy(str, str2, str3, str4);
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

    public final NetworkInfo copy(String ssid, String str, String rssi, String rssiValue) {
        j.e(ssid, "ssid");
        j.e(rssi, "rssi");
        j.e(rssiValue, "rssiValue");
        return new NetworkInfo(ssid, str, rssi, rssiValue);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkInfo)) {
            return false;
        }
        NetworkInfo networkInfo = (NetworkInfo) obj;
        return j.a(this.ssid, networkInfo.ssid) && j.a(this.linkType, networkInfo.linkType) && j.a(this.rssi, networkInfo.rssi) && j.a(this.rssiValue, networkInfo.rssiValue);
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

    public String toString() {
        return "NetworkInfo(ssid=" + this.ssid + ", linkType=" + this.linkType + ", rssi=" + this.rssi + ", rssiValue=" + this.rssiValue + ")";
    }
}
