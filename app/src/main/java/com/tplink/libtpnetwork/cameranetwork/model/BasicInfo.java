package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class BasicInfo {
    @c("avatar")
    private final String avatar;
    private final String barcode;
    @c("device_alias")
    private final String deviceAlias;
    @c("dev_id")
    private final String deviceId;
    @c("features")
    private final String feature;
    @c("ffs")
    private final boolean ffs;
    @c("hw_desc")
    private final String hardwareDesc;
    @c("hw_version")
    private final String hardwareVer;
    @c("device_info")
    private final String info;
    @c("lock_message")
    private final String lockMessage;
    @c("lock_status")
    private final Integer lockStatus;
    private final String mac;
    @c("device_model")
    private final String model;
    @c("device_name")
    private final String name;
    @c("oem_id")
    private final String oemId;
    @c("oem_name")
    private final String oenName;
    @c("sw_version")
    private final String softwareVer;
    @c("device_type")
    private final String type;

    public BasicInfo(String type, String model, String name, String info, String hardwareVer, String softwareVer, String deviceAlias, String str, String feature, String barcode, String mac, String deviceId, String oemId, String hardwareDesc, boolean z, String str2, Integer num, String str3) {
        j.e(type, "type");
        j.e(model, "model");
        j.e(name, "name");
        j.e(info, "info");
        j.e(hardwareVer, "hardwareVer");
        j.e(softwareVer, "softwareVer");
        j.e(deviceAlias, "deviceAlias");
        j.e(feature, "feature");
        j.e(barcode, "barcode");
        j.e(mac, "mac");
        j.e(deviceId, "deviceId");
        j.e(oemId, "oemId");
        j.e(hardwareDesc, "hardwareDesc");
        this.type = type;
        this.model = model;
        this.name = name;
        this.info = info;
        this.hardwareVer = hardwareVer;
        this.softwareVer = softwareVer;
        this.deviceAlias = deviceAlias;
        this.avatar = str;
        this.feature = feature;
        this.barcode = barcode;
        this.mac = mac;
        this.deviceId = deviceId;
        this.oemId = oemId;
        this.hardwareDesc = hardwareDesc;
        this.ffs = z;
        this.oenName = str2;
        this.lockStatus = num;
        this.lockMessage = str3;
    }

    public final String component1() {
        return this.type;
    }

    public final String component10() {
        return this.barcode;
    }

    public final String component11() {
        return this.mac;
    }

    public final String component12() {
        return this.deviceId;
    }

    public final String component13() {
        return this.oemId;
    }

    public final String component14() {
        return this.hardwareDesc;
    }

    public final boolean component15() {
        return this.ffs;
    }

    public final String component16() {
        return this.oenName;
    }

    public final Integer component17() {
        return this.lockStatus;
    }

    public final String component18() {
        return this.lockMessage;
    }

    public final String component2() {
        return this.model;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.info;
    }

    public final String component5() {
        return this.hardwareVer;
    }

    public final String component6() {
        return this.softwareVer;
    }

    public final String component7() {
        return this.deviceAlias;
    }

    public final String component8() {
        return this.avatar;
    }

    public final String component9() {
        return this.feature;
    }

    public final BasicInfo copy(String type, String model, String name, String info, String hardwareVer, String softwareVer, String deviceAlias, String str, String feature, String barcode, String mac, String deviceId, String oemId, String hardwareDesc, boolean z, String str2, Integer num, String str3) {
        j.e(type, "type");
        j.e(model, "model");
        j.e(name, "name");
        j.e(info, "info");
        j.e(hardwareVer, "hardwareVer");
        j.e(softwareVer, "softwareVer");
        j.e(deviceAlias, "deviceAlias");
        j.e(feature, "feature");
        j.e(barcode, "barcode");
        j.e(mac, "mac");
        j.e(deviceId, "deviceId");
        j.e(oemId, "oemId");
        j.e(hardwareDesc, "hardwareDesc");
        return new BasicInfo(type, model, name, info, hardwareVer, softwareVer, deviceAlias, str, feature, barcode, mac, deviceId, oemId, hardwareDesc, z, str2, num, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BasicInfo)) {
            return false;
        }
        BasicInfo basicInfo = (BasicInfo) obj;
        return j.a(this.type, basicInfo.type) && j.a(this.model, basicInfo.model) && j.a(this.name, basicInfo.name) && j.a(this.info, basicInfo.info) && j.a(this.hardwareVer, basicInfo.hardwareVer) && j.a(this.softwareVer, basicInfo.softwareVer) && j.a(this.deviceAlias, basicInfo.deviceAlias) && j.a(this.avatar, basicInfo.avatar) && j.a(this.feature, basicInfo.feature) && j.a(this.barcode, basicInfo.barcode) && j.a(this.mac, basicInfo.mac) && j.a(this.deviceId, basicInfo.deviceId) && j.a(this.oemId, basicInfo.oemId) && j.a(this.hardwareDesc, basicInfo.hardwareDesc) && this.ffs == basicInfo.ffs && j.a(this.oenName, basicInfo.oenName) && j.a(this.lockStatus, basicInfo.lockStatus) && j.a(this.lockMessage, basicInfo.lockMessage);
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getBarcode() {
        return this.barcode;
    }

    public final String getDeviceAlias() {
        return this.deviceAlias;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getFeature() {
        return this.feature;
    }

    public final boolean getFfs() {
        return this.ffs;
    }

    public final String getHardwareDesc() {
        return this.hardwareDesc;
    }

    public final String getHardwareVer() {
        return this.hardwareVer;
    }

    public final String getInfo() {
        return this.info;
    }

    public final String getLockMessage() {
        return this.lockMessage;
    }

    public final Integer getLockStatus() {
        return this.lockStatus;
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

    public final String getOemId() {
        return this.oemId;
    }

    public final String getOenName() {
        return this.oenName;
    }

    public final String getSoftwareVer() {
        return this.softwareVer;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.type;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.model;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.name;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.info;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.hardwareVer;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.softwareVer;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.deviceAlias;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.avatar;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.feature;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.barcode;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.mac;
        int hashCode11 = (hashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.deviceId;
        int hashCode12 = (hashCode11 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.oemId;
        int hashCode13 = (hashCode12 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.hardwareDesc;
        int hashCode14 = (hashCode13 + (str14 != null ? str14.hashCode() : 0)) * 31;
        boolean z = this.ffs;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = (hashCode14 + i2) * 31;
        String str15 = this.oenName;
        int hashCode15 = (i5 + (str15 != null ? str15.hashCode() : 0)) * 31;
        Integer num = this.lockStatus;
        int hashCode16 = (hashCode15 + (num != null ? num.hashCode() : 0)) * 31;
        String str16 = this.lockMessage;
        if (str16 != null) {
            i = str16.hashCode();
        }
        return hashCode16 + i;
    }

    public String toString() {
        return "BasicInfo(type=" + this.type + ", model=" + this.model + ", name=" + this.name + ", info=" + this.info + ", hardwareVer=" + this.hardwareVer + ", softwareVer=" + this.softwareVer + ", deviceAlias=" + this.deviceAlias + ", avatar=" + this.avatar + ", feature=" + this.feature + ", barcode=" + this.barcode + ", mac=" + this.mac + ", deviceId=" + this.deviceId + ", oemId=" + this.oemId + ", hardwareDesc=" + this.hardwareDesc + ", ffs=" + this.ffs + ", oenName=" + this.oenName + ", lockStatus=" + this.lockStatus + ", lockMessage=" + this.lockMessage + ")";
    }
}
