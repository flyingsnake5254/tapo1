package com.tplink.libtpnetwork.TDPNetwork.bean;

import com.google.gson.q.c;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class TDPCameraDevice extends TDPIoTDevice implements Serializable {
    @c("ssid")
    private String connectSsid;
    @c("connect_type")
    private String connectType;
    @c(ThingModelDefine.Event.UPLOAD_PARAMS_DEVICE_ID)
    protected String deviceId;
    @c("device_name")
    private String deviceName;
    @c("fw_ver")
    private String firmwareVer;
    @c("hw_ver")
    private String hardwareVer;
    @c("isResetWiFi")
    private boolean isResetWiFi;
    @c("last_alarm_time")
    private String lastAlarmTime;
    @c("last_alarm_type")
    private String lastAlarmType;
    @c("sd_status")
    private String sdStatus;

    public String getConnectSsid() {
        return this.connectSsid;
    }

    public String getConnectType() {
        return this.connectType;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public String getFirmwareVer() {
        return this.firmwareVer;
    }

    public String getHardwareVer() {
        return this.hardwareVer;
    }

    @Override // com.tplink.libtpnetwork.TDPNetwork.bean.TDPIoTDevice
    public int getHttpPort() {
        int i = this.httpPort;
        if (i != 0) {
            return i;
        }
        return 443;
    }

    public String getLastAlarmTime() {
        return this.lastAlarmTime;
    }

    public String getLastAlarmType() {
        return this.lastAlarmType;
    }

    public String getSdStatus() {
        return this.sdStatus;
    }

    public boolean isResetWiFi() {
        return this.isResetWiFi;
    }

    public void setConnectSsid(String str) {
        this.connectSsid = str;
    }

    public void setConnectType(String str) {
        this.connectType = str;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setFirmwareVer(String str) {
        this.firmwareVer = str;
    }

    public void setHardwareVer(String str) {
        this.hardwareVer = str;
    }

    public void setLastAlarmTime(String str) {
        this.lastAlarmTime = str;
    }

    public void setLastAlarmType(String str) {
        this.lastAlarmType = str;
    }

    public void setResetWiFi(boolean z) {
        this.isResetWiFi = z;
    }

    public void setSdStatus(String str) {
        this.sdStatus = str;
    }

    public TDPCameraDevice clone() {
        TDPCameraDevice tDPCameraDevice = new TDPCameraDevice();
        tDPCameraDevice.deviceName = this.deviceName;
        tDPCameraDevice.hardwareVer = this.hardwareVer;
        tDPCameraDevice.firmwareVer = this.firmwareVer;
        tDPCameraDevice.deviceId = this.deviceId;
        tDPCameraDevice.deviceIdMd5 = this.deviceIdMd5;
        tDPCameraDevice.ip = this.ip;
        tDPCameraDevice.mac = this.mac;
        tDPCameraDevice.httpPort = this.httpPort;
        tDPCameraDevice.connectType = this.connectType;
        tDPCameraDevice.connectSsid = this.connectSsid;
        tDPCameraDevice.owner = this.owner;
        tDPCameraDevice.lastAlarmType = this.lastAlarmType;
        tDPCameraDevice.lastAlarmTime = this.lastAlarmTime;
        tDPCameraDevice.sdStatus = this.sdStatus;
        tDPCameraDevice.deviceModel = this.deviceModel;
        tDPCameraDevice.isResetWiFi = this.isResetWiFi;
        return tDPCameraDevice;
    }
}
