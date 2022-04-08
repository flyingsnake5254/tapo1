package com.tplink.libmediaapi.device.apibean;

import com.google.gson.q.c;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;

/* loaded from: classes3.dex */
public class MediaDevice {
    @c("P2P_Available")
    private boolean P2PAvailable;
    @c("app_server_url")
    protected String appServerUrl;
    @c(ThingModelDefine.Event.UPLOAD_PARAMS_DEVICE_ID)
    protected String deviceId;
    @c("device_local")
    private boolean deviceLocal;
    @c("mac")
    protected String deviceMac;
    @c("device_remote_online")
    private boolean deviceRemoteOnline;
    @c("force_main_stream")
    private boolean forceMainStream;
    @c("http_port")
    protected int httpPort;
    @c("iot_thing_url")
    protected String iotThingUrl;
    @c("is_support_iot_cloud")
    protected boolean isSupportIoTCloud;
    @c("localIp")
    protected String localIp;
    @c("model")
    protected String model;
    @c("user_role_type_device")
    private boolean userRoleTypeDevice;
    @c("user_share_password")
    protected String userSharePassword;
    @c("user_share_username")
    protected String userShareUsername;

    public String getAppServerUrl() {
        return this.appServerUrl;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getDeviceIdMd5() {
        return b.d.p.c.b(this.deviceId);
    }

    public String getDeviceMac() {
        return this.deviceMac;
    }

    public int getHttpPort() {
        return this.httpPort;
    }

    public String getIotThingUrl() {
        return this.iotThingUrl;
    }

    public String getLocalIp() {
        return this.localIp;
    }

    public String getModel() {
        return this.model;
    }

    public String getUserSharePassword() {
        return this.userSharePassword;
    }

    public String getUserShareUsername() {
        return this.userShareUsername;
    }

    public boolean isDeviceLocal() {
        return this.deviceLocal;
    }

    public boolean isDeviceRemoteOnline() {
        return this.deviceRemoteOnline;
    }

    public boolean isForceMainStream() {
        return this.forceMainStream;
    }

    public boolean isP2PAvailable() {
        return this.P2PAvailable;
    }

    public boolean isSupportIoTCloud() {
        return this.isSupportIoTCloud;
    }

    public boolean isUserRoleTypeDevice() {
        return this.userRoleTypeDevice;
    }

    public void setAppServerUrl(String str) {
        this.appServerUrl = str;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setDeviceLocal(boolean z) {
        this.deviceLocal = z;
    }

    public void setDeviceMac(String str) {
        this.deviceMac = str;
    }

    public void setDeviceRemoteOnline(boolean z) {
        this.deviceRemoteOnline = z;
    }

    public void setForceMainStream(boolean z) {
        this.forceMainStream = z;
    }

    public void setHttpPort(int i) {
        this.httpPort = i;
    }

    public void setIotThingUrl(String str) {
        this.iotThingUrl = str;
    }

    public void setLocalIp(String str) {
        this.localIp = str;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public void setP2PAvailable(boolean z) {
        this.P2PAvailable = z;
    }

    public void setSupportIoTCloud(boolean z) {
        this.isSupportIoTCloud = z;
    }

    public void setUserRoleTypeDevice(boolean z) {
        this.userRoleTypeDevice = z;
    }

    public void setUserSharePassword(String str) {
        this.userSharePassword = str;
    }

    public void setUserShareUsername(String str) {
        this.userShareUsername = str;
    }
}
