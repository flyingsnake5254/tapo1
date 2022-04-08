package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

/* compiled from: SettingsCacheModel.kt */
/* loaded from: classes3.dex */
public final class CameraInfoCache {
    private final String hardwareVer;
    private final String mac;
    private final String model;
    private String name;
    private final String softwareVer;

    public CameraInfoCache(String str, String str2, String str3, String str4, String str5) {
        this.name = str;
        this.hardwareVer = str2;
        this.softwareVer = str3;
        this.model = str4;
        this.mac = str5;
    }

    public static /* synthetic */ CameraInfoCache copy$default(CameraInfoCache cameraInfoCache, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cameraInfoCache.name;
        }
        if ((i & 2) != 0) {
            str2 = cameraInfoCache.hardwareVer;
        }
        if ((i & 4) != 0) {
            str3 = cameraInfoCache.softwareVer;
        }
        if ((i & 8) != 0) {
            str4 = cameraInfoCache.model;
        }
        if ((i & 16) != 0) {
            str5 = cameraInfoCache.mac;
        }
        return cameraInfoCache.copy(str, str2, str3, str4, str5);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.hardwareVer;
    }

    public final String component3() {
        return this.softwareVer;
    }

    public final String component4() {
        return this.model;
    }

    public final String component5() {
        return this.mac;
    }

    public final CameraInfoCache copy(String str, String str2, String str3, String str4, String str5) {
        return new CameraInfoCache(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraInfoCache)) {
            return false;
        }
        CameraInfoCache cameraInfoCache = (CameraInfoCache) obj;
        return j.a(this.name, cameraInfoCache.name) && j.a(this.hardwareVer, cameraInfoCache.hardwareVer) && j.a(this.softwareVer, cameraInfoCache.softwareVer) && j.a(this.model, cameraInfoCache.model) && j.a(this.mac, cameraInfoCache.mac);
    }

    public final String getHardwareVer() {
        return this.hardwareVer;
    }

    public final String getMac() {
        return this.mac;
    }

    public final String getModel() {
        return this.model;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSoftwareVer() {
        return this.softwareVer;
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.hardwareVer;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.softwareVer;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.model;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.mac;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return hashCode4 + i;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public String toString() {
        return "CameraInfoCache(name=" + this.name + ", hardwareVer=" + this.hardwareVer + ", softwareVer=" + this.softwareVer + ", model=" + this.model + ", mac=" + this.mac + ")";
    }
}
