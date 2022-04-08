package com.tplink.libtpnetwork.TPCloudNetwork.device;

import android.text.TextUtils;
import com.tplink.cloud.bean.device.result.DeviceInfoResult;
import com.tplink.libtpnetwork.enumerate.EnumDeviceStatus;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.libtpnetwork.enumerate.EnumUserRole;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class TCDeviceBean implements Serializable {
    private String alias;
    private String appServerUrl;
    private String deviceHwVer;
    private String deviceId;
    private String deviceMac;
    private String deviceModel;
    private String deviceName;
    private String deviceType;
    private String fwId;
    private String fwVer;
    private String hwId;
    private boolean isSameRegion;
    private String oemId;
    private EnumUserRole role;
    private EnumDeviceStatus status;

    public TCDeviceBean() {
    }

    private String swapMacAddress(String str) {
        if (TextUtils.isEmpty(str) || str.length() != 12) {
            return str;
        }
        String upperCase = str.toUpperCase();
        return String.format("%s-%s-%s-%s-%s-%s", upperCase.subSequence(0, 2), upperCase.substring(2, 4), upperCase.substring(4, 6), upperCase.substring(6, 8), upperCase.substring(8, 10), upperCase.substring(10, 12));
    }

    public String getAlias() {
        return this.alias;
    }

    public String getAppServerUrl() {
        return this.appServerUrl;
    }

    public String getDeviceHwVer() {
        return this.deviceHwVer;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public DeviceInfoResult getDeviceInfo() {
        DeviceInfoResult deviceInfoResult = new DeviceInfoResult();
        deviceInfoResult.setDeviceId(this.deviceId);
        int i = 0;
        deviceInfoResult.setStatus(this.status == EnumDeviceStatus.STATUS_OFFLINE ? 0 : 1);
        deviceInfoResult.setDeviceName(this.deviceName);
        deviceInfoResult.setDeviceType(this.deviceType);
        deviceInfoResult.setAlias(this.alias);
        deviceInfoResult.setDeviceMac(this.deviceMac.replace("-", ""));
        deviceInfoResult.setHwId(this.hwId);
        deviceInfoResult.setDeviceModel(this.deviceModel);
        deviceInfoResult.setDeviceHwVer(this.deviceHwVer);
        deviceInfoResult.setFwId(this.fwId);
        deviceInfoResult.setOemId(this.oemId);
        deviceInfoResult.setFwVer(this.fwVer);
        deviceInfoResult.setAppServerUrl(this.appServerUrl);
        deviceInfoResult.setSameRegion(this.isSameRegion);
        if (this.role != EnumUserRole.ROLE_OWNER) {
            i = 1;
        }
        deviceInfoResult.setRole(i);
        return deviceInfoResult;
    }

    public String getDeviceMac() {
        return this.deviceMac;
    }

    public String getDeviceModel() {
        return this.deviceModel;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public String getDeviceType() {
        return this.deviceType;
    }

    public String getFwId() {
        return this.fwId;
    }

    public String getFwVer() {
        return this.fwVer;
    }

    public String getHwId() {
        return this.hwId;
    }

    public String getOemId() {
        return this.oemId;
    }

    public EnumUserRole getRole() {
        return this.role;
    }

    public EnumDeviceStatus getStatus() {
        return this.status;
    }

    public boolean isCamera() {
        return EnumDeviceType.CAMERA == EnumDeviceType.fromType(this.deviceType);
    }

    public boolean isSameRegion() {
        return this.isSameRegion;
    }

    public void setAlias(String str) {
        this.alias = str;
    }

    public void setAppServerUrl(String str) {
        this.appServerUrl = str;
    }

    public void setDeviceHwVer(String str) {
        this.deviceHwVer = str;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setDeviceMac(String str) {
        this.deviceMac = str;
    }

    public void setDeviceModel(String str) {
        this.deviceModel = str;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setDeviceType(String str) {
        this.deviceType = str;
    }

    public void setFwId(String str) {
        this.fwId = str;
    }

    public void setFwVer(String str) {
        this.fwVer = str;
    }

    public void setHwId(String str) {
        this.hwId = str;
    }

    public void setOemId(String str) {
        this.oemId = str;
    }

    public void setRole(EnumUserRole enumUserRole) {
        this.role = enumUserRole;
    }

    public void setSameRegion(boolean z) {
        this.isSameRegion = z;
    }

    public void setStatus(EnumDeviceStatus enumDeviceStatus) {
        this.status = enumDeviceStatus;
    }

    public TCDeviceBean(String str, EnumDeviceStatus enumDeviceStatus, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, boolean z, EnumUserRole enumUserRole) {
        this.deviceId = str;
        this.status = enumDeviceStatus;
        this.deviceName = str2;
        this.deviceType = str3;
        this.alias = str4;
        this.deviceMac = str5;
        this.hwId = str6;
        this.deviceModel = str7;
        this.deviceHwVer = str8;
        this.fwId = str9;
        this.oemId = str10;
        this.fwVer = str11;
        this.appServerUrl = str12;
        this.isSameRegion = z;
        this.role = enumUserRole;
    }

    public TCDeviceBean clone() {
        TCDeviceBean tCDeviceBean = new TCDeviceBean();
        tCDeviceBean.deviceId = this.deviceId;
        tCDeviceBean.status = this.status;
        tCDeviceBean.deviceName = this.deviceName;
        tCDeviceBean.deviceType = this.deviceType;
        tCDeviceBean.alias = this.alias;
        tCDeviceBean.deviceMac = this.deviceMac;
        tCDeviceBean.hwId = this.hwId;
        tCDeviceBean.deviceModel = this.deviceModel;
        tCDeviceBean.deviceHwVer = this.deviceHwVer;
        tCDeviceBean.fwId = this.fwId;
        tCDeviceBean.oemId = this.oemId;
        tCDeviceBean.fwVer = this.fwVer;
        tCDeviceBean.appServerUrl = this.appServerUrl;
        tCDeviceBean.isSameRegion = this.isSameRegion;
        tCDeviceBean.role = this.role;
        return tCDeviceBean;
    }

    public TCDeviceBean(DeviceInfoResult deviceInfoResult) {
        this.deviceId = deviceInfoResult.getDeviceId();
        this.status = deviceInfoResult.getStatus() == 0 ? EnumDeviceStatus.STATUS_OFFLINE : EnumDeviceStatus.STATUS_ONLINE;
        this.deviceName = deviceInfoResult.getDeviceName();
        this.deviceType = deviceInfoResult.getDeviceType();
        this.alias = deviceInfoResult.getAlias();
        this.deviceMac = swapMacAddress(deviceInfoResult.getDeviceMac());
        this.hwId = deviceInfoResult.getHwId();
        this.deviceModel = deviceInfoResult.getDeviceModel();
        this.deviceHwVer = deviceInfoResult.getDeviceHwVer();
        this.fwId = deviceInfoResult.getFwId();
        this.oemId = deviceInfoResult.getOemId();
        this.fwVer = deviceInfoResult.getFwVer();
        this.appServerUrl = deviceInfoResult.getAppServerUrl();
        this.isSameRegion = deviceInfoResult.isSameRegion();
        this.role = deviceInfoResult.getRole() == 0 ? EnumUserRole.ROLE_OWNER : EnumUserRole.ROLE_USER;
    }
}
