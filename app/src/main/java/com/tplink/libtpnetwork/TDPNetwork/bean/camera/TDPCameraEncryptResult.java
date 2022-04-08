package com.tplink.libtpnetwork.TDPNetwork.bean.camera;

import com.google.gson.q.c;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;

/* loaded from: classes3.dex */
public class TDPCameraEncryptResult {
    @c("connect_ssid")
    private String connectSsid;
    @c("connect_type")
    private String connectType;
    @c(ThingModelDefine.Event.UPLOAD_PARAMS_DEVICE_ID)
    private String deviceId;
    @c("http_port")
    private int httpPort;
    @c("last_alarm_time")
    private String lastAlarmTime;
    @c("last_alarm_type")
    private String lastAlarmType;
    @c("owner")
    private String owner;
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

    public int getHttpPort() {
        return this.httpPort;
    }

    public String getLastAlarmTime() {
        return this.lastAlarmTime;
    }

    public String getLastAlarmType() {
        return this.lastAlarmType;
    }

    public String getOwner() {
        return this.owner;
    }

    public String getSdStatus() {
        return this.sdStatus;
    }
}
