package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

/* compiled from: SettingsCacheModel.kt */
/* loaded from: classes3.dex */
public final class SdCardInfoCache {
    private String detectStatus;
    private String freeSpace;
    private boolean loopEnable;
    private String realTotalSpace;
    private SdCardStatus status;
    private String totalSpace;
    private String usedSpace;

    public SdCardInfoCache(SdCardStatus sdCardStatus, String str, String str2, String str3, String str4, boolean z, String str5) {
        this.status = sdCardStatus;
        this.detectStatus = str;
        this.totalSpace = str2;
        this.usedSpace = str3;
        this.freeSpace = str4;
        this.loopEnable = z;
        this.realTotalSpace = str5;
    }

    public static /* synthetic */ SdCardInfoCache copy$default(SdCardInfoCache sdCardInfoCache, SdCardStatus sdCardStatus, String str, String str2, String str3, String str4, boolean z, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            sdCardStatus = sdCardInfoCache.status;
        }
        if ((i & 2) != 0) {
            str = sdCardInfoCache.detectStatus;
        }
        if ((i & 4) != 0) {
            str2 = sdCardInfoCache.totalSpace;
        }
        if ((i & 8) != 0) {
            str3 = sdCardInfoCache.usedSpace;
        }
        if ((i & 16) != 0) {
            str4 = sdCardInfoCache.freeSpace;
        }
        if ((i & 32) != 0) {
            z = sdCardInfoCache.loopEnable;
        }
        if ((i & 64) != 0) {
            str5 = sdCardInfoCache.realTotalSpace;
        }
        return sdCardInfoCache.copy(sdCardStatus, str, str2, str3, str4, z, str5);
    }

    public final SdCardStatus component1() {
        return this.status;
    }

    public final String component2() {
        return this.detectStatus;
    }

    public final String component3() {
        return this.totalSpace;
    }

    public final String component4() {
        return this.usedSpace;
    }

    public final String component5() {
        return this.freeSpace;
    }

    public final boolean component6() {
        return this.loopEnable;
    }

    public final String component7() {
        return this.realTotalSpace;
    }

    public final SdCardInfoCache copy(SdCardStatus sdCardStatus, String str, String str2, String str3, String str4, boolean z, String str5) {
        return new SdCardInfoCache(sdCardStatus, str, str2, str3, str4, z, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SdCardInfoCache)) {
            return false;
        }
        SdCardInfoCache sdCardInfoCache = (SdCardInfoCache) obj;
        return j.a(this.status, sdCardInfoCache.status) && j.a(this.detectStatus, sdCardInfoCache.detectStatus) && j.a(this.totalSpace, sdCardInfoCache.totalSpace) && j.a(this.usedSpace, sdCardInfoCache.usedSpace) && j.a(this.freeSpace, sdCardInfoCache.freeSpace) && this.loopEnable == sdCardInfoCache.loopEnable && j.a(this.realTotalSpace, sdCardInfoCache.realTotalSpace);
    }

    public final String getDetectStatus() {
        return this.detectStatus;
    }

    public final String getFreeSpace() {
        return this.freeSpace;
    }

    public final boolean getLoopEnable() {
        return this.loopEnable;
    }

    public final String getRealTotalSpace() {
        return this.realTotalSpace;
    }

    public final SdCardStatus getStatus() {
        return this.status;
    }

    public final String getTotalSpace() {
        return this.totalSpace;
    }

    public final String getUsedSpace() {
        return this.usedSpace;
    }

    public int hashCode() {
        SdCardStatus sdCardStatus = this.status;
        int i = 0;
        int hashCode = (sdCardStatus != null ? sdCardStatus.hashCode() : 0) * 31;
        String str = this.detectStatus;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.totalSpace;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.usedSpace;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.freeSpace;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        boolean z = this.loopEnable;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = (hashCode5 + i2) * 31;
        String str5 = this.realTotalSpace;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return i5 + i;
    }

    public final void setDetectStatus(String str) {
        this.detectStatus = str;
    }

    public final void setFreeSpace(String str) {
        this.freeSpace = str;
    }

    public final void setLoopEnable(boolean z) {
        this.loopEnable = z;
    }

    public final void setRealTotalSpace(String str) {
        this.realTotalSpace = str;
    }

    public final void setStatus(SdCardStatus sdCardStatus) {
        this.status = sdCardStatus;
    }

    public final void setTotalSpace(String str) {
        this.totalSpace = str;
    }

    public final void setUsedSpace(String str) {
        this.usedSpace = str;
    }

    public String toString() {
        return "SdCardInfoCache(status=" + this.status + ", detectStatus=" + this.detectStatus + ", totalSpace=" + this.totalSpace + ", usedSpace=" + this.usedSpace + ", freeSpace=" + this.freeSpace + ", loopEnable=" + this.loopEnable + ", realTotalSpace=" + this.realTotalSpace + ")";
    }
}
