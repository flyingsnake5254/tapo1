package com.tplink.libtpnetwork.cameranetwork.model;

import androidx.core.app.FrameMetricsAggregator;
import com.google.gson.q.c;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class SystemInfo {
    @c("dev_alias")
    private String alias;
    @c("append_dns")
    private final String appendDns;
    @c("avatar")
    private String avatar;
    @c("diagnose_mode")
    private String diagnoseMode;
    @c("hostname")
    private final String hostname;
    @c("is_factory")
    private final String isFactory;
    @c("makeroom_status")
    private final String makeRoomStatus;
    @c("alias")
    private final String name;
    @c("network_type")
    private final String networkType;

    public SystemInfo() {
        this(null, null, null, null, null, null, null, null, null, FrameMetricsAggregator.EVERY_DURATION, null);
    }

    public SystemInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.diagnoseMode = str;
        this.alias = str2;
        this.name = str3;
        this.avatar = str4;
        this.appendDns = str5;
        this.networkType = str6;
        this.isFactory = str7;
        this.hostname = str8;
        this.makeRoomStatus = str9;
    }

    public final String component1() {
        return this.diagnoseMode;
    }

    public final String component2() {
        return this.alias;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.avatar;
    }

    public final String component5() {
        return this.appendDns;
    }

    public final String component6() {
        return this.networkType;
    }

    public final String component7() {
        return this.isFactory;
    }

    public final String component8() {
        return this.hostname;
    }

    public final String component9() {
        return this.makeRoomStatus;
    }

    public final SystemInfo copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        return new SystemInfo(str, str2, str3, str4, str5, str6, str7, str8, str9);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SystemInfo)) {
            return false;
        }
        SystemInfo systemInfo = (SystemInfo) obj;
        return j.a(this.diagnoseMode, systemInfo.diagnoseMode) && j.a(this.alias, systemInfo.alias) && j.a(this.name, systemInfo.name) && j.a(this.avatar, systemInfo.avatar) && j.a(this.appendDns, systemInfo.appendDns) && j.a(this.networkType, systemInfo.networkType) && j.a(this.isFactory, systemInfo.isFactory) && j.a(this.hostname, systemInfo.hostname) && j.a(this.makeRoomStatus, systemInfo.makeRoomStatus);
    }

    public final String getAlias() {
        return this.alias;
    }

    public final String getAppendDns() {
        return this.appendDns;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getDiagnoseMode() {
        return this.diagnoseMode;
    }

    public final String getHostname() {
        return this.hostname;
    }

    public final String getMakeRoomStatus() {
        return this.makeRoomStatus;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNetworkType() {
        return this.networkType;
    }

    public int hashCode() {
        String str = this.diagnoseMode;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.alias;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.name;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.avatar;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.appendDns;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.networkType;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.isFactory;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.hostname;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.makeRoomStatus;
        if (str9 != null) {
            i = str9.hashCode();
        }
        return hashCode8 + i;
    }

    public final String isFactory() {
        return this.isFactory;
    }

    public final void setAlias(String str) {
        this.alias = str;
    }

    public final void setAvatar(String str) {
        this.avatar = str;
    }

    public final void setDiagnoseMode(String str) {
        this.diagnoseMode = str;
    }

    public String toString() {
        return "SystemInfo(diagnoseMode=" + this.diagnoseMode + ", alias=" + this.alias + ", name=" + this.name + ", avatar=" + this.avatar + ", appendDns=" + this.appendDns + ", networkType=" + this.networkType + ", isFactory=" + this.isFactory + ", hostname=" + this.hostname + ", makeRoomStatus=" + this.makeRoomStatus + ")";
    }

    public /* synthetic */ SystemInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, f fVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) == 0 ? str9 : null);
    }
}
