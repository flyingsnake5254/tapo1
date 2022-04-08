package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

/* compiled from: SettingsCacheModel.kt */
/* loaded from: classes3.dex */
public final class DeviceInfoCache {
    private String deviceId;
    private String imgUrl;
    private String ip;
    private String mac;

    public DeviceInfoCache(String str, String deviceId, String str2, String str3) {
        j.e(deviceId, "deviceId");
        this.mac = str;
        this.deviceId = deviceId;
        this.ip = str2;
        this.imgUrl = str3;
    }

    public static /* synthetic */ DeviceInfoCache copy$default(DeviceInfoCache deviceInfoCache, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deviceInfoCache.mac;
        }
        if ((i & 2) != 0) {
            str2 = deviceInfoCache.deviceId;
        }
        if ((i & 4) != 0) {
            str3 = deviceInfoCache.ip;
        }
        if ((i & 8) != 0) {
            str4 = deviceInfoCache.imgUrl;
        }
        return deviceInfoCache.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.mac;
    }

    public final String component2() {
        return this.deviceId;
    }

    public final String component3() {
        return this.ip;
    }

    public final String component4() {
        return this.imgUrl;
    }

    public final DeviceInfoCache copy(String str, String deviceId, String str2, String str3) {
        j.e(deviceId, "deviceId");
        return new DeviceInfoCache(str, deviceId, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceInfoCache)) {
            return false;
        }
        DeviceInfoCache deviceInfoCache = (DeviceInfoCache) obj;
        return j.a(this.mac, deviceInfoCache.mac) && j.a(this.deviceId, deviceInfoCache.deviceId) && j.a(this.ip, deviceInfoCache.ip) && j.a(this.imgUrl, deviceInfoCache.imgUrl);
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getImgUrl() {
        return this.imgUrl;
    }

    public final String getIp() {
        return this.ip;
    }

    public final String getMac() {
        return this.mac;
    }

    public int hashCode() {
        String str = this.mac;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.deviceId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.ip;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.imgUrl;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    public final void setDeviceId(String str) {
        j.e(str, "<set-?>");
        this.deviceId = str;
    }

    public final void setImgUrl(String str) {
        this.imgUrl = str;
    }

    public final void setIp(String str) {
        this.ip = str;
    }

    public final void setMac(String str) {
        this.mac = str;
    }

    public String toString() {
        return "DeviceInfoCache(mac=" + this.mac + ", deviceId=" + this.deviceId + ", ip=" + this.ip + ", imgUrl=" + this.imgUrl + ")";
    }
}
