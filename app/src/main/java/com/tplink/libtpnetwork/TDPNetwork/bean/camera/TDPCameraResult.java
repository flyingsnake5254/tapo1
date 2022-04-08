package com.tplink.libtpnetwork.TDPNetwork.bean.camera;

import com.google.firebase.messaging.Constants;
import com.google.gson.q.c;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import com.tplink.libtpnetwork.TDPNetwork.bean.iot.BaseTDPJsonResult;

/* loaded from: classes3.dex */
public class TDPCameraResult extends BaseTDPJsonResult {
    @c(ThingModelDefine.Event.UPLOAD_PARAMS_DEVICE_ID)
    private String deviceId;
    @c("device_name")
    private String deviceName;
    @c("mgt_encrypt_schm")
    private EncryptScheme encryptScheme;
    @c("encrypt_info")
    private EncryptedInfo encryptedInfo;
    @c(alternate = {"firmware_version"}, value = "firmware_ver")
    private String firmwareVer;
    @c("hardware_version")
    private String hardwareVer;
    @c("isResetWiFi")
    private boolean isResetWiFi;
    @c("is_support_iot_cloud")
    private boolean isSupportIoTCloud;

    /* loaded from: classes3.dex */
    public static class EncryptScheme {
        @c("is_support_https")
        private boolean isSupportHttps;

        public boolean isSupportHttps() {
            return this.isSupportHttps;
        }

        public void setSupportHttps(boolean z) {
            this.isSupportHttps = z;
        }
    }

    /* loaded from: classes3.dex */
    public static class EncryptedInfo {
        @c(Constants.ScionAnalytics.MessageType.DATA_MESSAGE)
        private String data;
        @c("key")
        private String key;
        @c("sym_schm")
        private String symmetricScheme;

        public String getData() {
            return this.data;
        }

        public String getKey() {
            return this.key;
        }

        public String getSymmetricScheme() {
            return this.symmetricScheme;
        }

        public void setData(String str) {
            this.data = str;
        }

        public void setKey(String str) {
            this.key = str;
        }

        public void setSymmetricScheme(String str) {
            this.symmetricScheme = str;
        }
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public EncryptScheme getEncryptScheme() {
        return this.encryptScheme;
    }

    public EncryptedInfo getEncryptedInfo() {
        return this.encryptedInfo;
    }

    public String getFirmwareVer() {
        return this.firmwareVer;
    }

    public String getHardwareVer() {
        return this.hardwareVer;
    }

    public boolean isResetWiFi() {
        return this.isResetWiFi;
    }

    public boolean isSupportIoTCloud() {
        return this.isSupportIoTCloud;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setEncryptScheme(EncryptScheme encryptScheme) {
        this.encryptScheme = encryptScheme;
    }

    public void setEncryptedInfo(EncryptedInfo encryptedInfo) {
        this.encryptedInfo = encryptedInfo;
    }

    public void setFirmwareVer(String str) {
        this.firmwareVer = str;
    }

    public void setHardwareVer(String str) {
        this.hardwareVer = str;
    }

    public void setResetWiFi(boolean z) {
        this.isResetWiFi = z;
    }

    public void setSupportIoTCloud(boolean z) {
        this.isSupportIoTCloud = z;
    }
}
