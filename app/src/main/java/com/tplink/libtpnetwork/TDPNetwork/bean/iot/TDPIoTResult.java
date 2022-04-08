package com.tplink.libtpnetwork.TDPNetwork.bean.iot;

import com.google.gson.q.c;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import com.tplink.libtpnetwork.Utils.i;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class TDPIoTResult extends BaseTDPJsonResult implements Serializable {
    @c(ThingModelDefine.Event.UPLOAD_PARAMS_DEVICE_ID)
    private String deviceIdMd5;
    @c("mgt_encrypt_schm")
    private EncryptScheme encryptScheme;
    @c("is_support_iot_cloud")
    private boolean isSupportIoTCloud;
    @c("obd_src")
    private String obdSrc;
    private String owner;

    /* loaded from: classes3.dex */
    public static class EncryptScheme implements Serializable {
        @c("encrypt_type")
        private EnumEncryptType encryptType;
        @c("http_port")
        private int httpPort;
        @c("is_support_https")
        private boolean isSupportHttps = false;

        public EnumEncryptType getEncryptType() {
            return this.encryptType;
        }

        public int getHttpPort() {
            return this.httpPort;
        }

        public boolean isSupportHttps() {
            return this.isSupportHttps;
        }

        public void setEncryptType(EnumEncryptType enumEncryptType) {
            this.encryptType = enumEncryptType;
        }

        public void setHttpPort(int i) {
            this.httpPort = i;
        }

        public void setSupportHttps(boolean z) {
            this.isSupportHttps = z;
        }
    }

    public String getDeviceIdMd5() {
        return this.deviceIdMd5;
    }

    public EncryptScheme getEncryptScheme() {
        return this.encryptScheme;
    }

    public int getHttpPort() {
        EncryptScheme encryptScheme = this.encryptScheme;
        if (encryptScheme != null) {
            return encryptScheme.getHttpPort();
        }
        return 0;
    }

    public String getObdSrc() {
        return this.obdSrc;
    }

    public String getOwner() {
        return this.owner;
    }

    public boolean isSupportHttps() {
        EncryptScheme encryptScheme = this.encryptScheme;
        return encryptScheme != null && encryptScheme.isSupportHttps();
    }

    public boolean isSupportIoTCloud() {
        return this.isSupportIoTCloud;
    }

    public void setDeviceIdMd5(String str) {
        this.deviceIdMd5 = str;
    }

    public void setEncryptScheme(EncryptScheme encryptScheme) {
        this.encryptScheme = encryptScheme;
    }

    public void setObdSrc(String str) {
        this.obdSrc = str;
    }

    public void setOwner(String str) {
        this.owner = str;
    }

    public void setSupportIoTCloud(boolean z) {
        this.isSupportIoTCloud = z;
    }

    @Override // com.tplink.libtpnetwork.TDPNetwork.bean.iot.BaseTDPJsonResult
    public String toString() {
        return i.h(this);
    }
}
