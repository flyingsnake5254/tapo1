package com.tplink.libtpnetwork.cameranetwork.bean;

import com.tplink.cloud.bean.device.result.DeviceInfoResult;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class CloudCameraDevice implements Serializable {
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
    private int role;
    private int status;

    public CloudCameraDevice(DeviceInfoResult deviceInfoResult) {
        this.deviceId = deviceInfoResult.getDeviceId();
        this.status = deviceInfoResult.getStatus();
        this.deviceName = deviceInfoResult.getDeviceName();
        this.deviceType = deviceInfoResult.getDeviceType();
        this.alias = deviceInfoResult.getAlias();
        this.deviceMac = deviceInfoResult.getDeviceMac();
        this.hwId = deviceInfoResult.getHwId();
        this.deviceModel = deviceInfoResult.getDeviceModel();
        this.deviceHwVer = deviceInfoResult.getDeviceHwVer();
        this.fwId = deviceInfoResult.getFwId();
        this.oemId = deviceInfoResult.getOemId();
        this.fwVer = deviceInfoResult.getFwVer();
        this.appServerUrl = deviceInfoResult.getAppServerUrl();
        this.isSameRegion = deviceInfoResult.isSameRegion();
        this.role = deviceInfoResult.getRole();
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
        deviceInfoResult.setStatus(this.status);
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
        deviceInfoResult.setRole(this.role);
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

    public int getRole() {
        return this.role;
    }

    public int getStatus() {
        return this.status;
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

    public void setRole(int i) {
        this.role = i;
    }

    public void setSameRegion(boolean z) {
        this.isSameRegion = z;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public CloudCameraDevice clone() {
        CloudCameraDevice cloudCameraDevice = new CloudCameraDevice();
        cloudCameraDevice.deviceId = this.deviceId;
        cloudCameraDevice.status = this.status;
        cloudCameraDevice.deviceName = this.deviceName;
        cloudCameraDevice.deviceType = this.deviceType;
        cloudCameraDevice.alias = this.alias;
        cloudCameraDevice.deviceMac = this.deviceMac;
        cloudCameraDevice.hwId = this.hwId;
        cloudCameraDevice.deviceModel = this.deviceModel;
        cloudCameraDevice.deviceHwVer = this.deviceHwVer;
        cloudCameraDevice.fwId = this.fwId;
        cloudCameraDevice.oemId = this.oemId;
        cloudCameraDevice.fwVer = this.fwVer;
        cloudCameraDevice.appServerUrl = this.appServerUrl;
        cloudCameraDevice.isSameRegion = this.isSameRegion;
        cloudCameraDevice.role = this.role;
        return cloudCameraDevice;
    }

    public CloudCameraDevice() {
    }
}
