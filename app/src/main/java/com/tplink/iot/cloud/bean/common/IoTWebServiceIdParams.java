package com.tplink.iot.cloud.bean.common;

/* loaded from: classes2.dex */
public class IoTWebServiceIdParams {
    private String iotAppServerId;
    private String iotGatewayId;
    private String iotSecurityId;

    public IoTWebServiceIdParams() {
    }

    public String getIotAppServerId() {
        return this.iotAppServerId;
    }

    public String getIotGatewayId() {
        return this.iotGatewayId;
    }

    public String getIotSecurityId() {
        return this.iotSecurityId;
    }

    public void setIotAppServerId(String str) {
        this.iotAppServerId = str;
    }

    public void setIotGatewayId(String str) {
        this.iotGatewayId = str;
    }

    public void setIotSecurityId(String str) {
        this.iotSecurityId = str;
    }

    public IoTWebServiceIdParams(String str, String str2, String str3) {
        this.iotAppServerId = str;
        this.iotGatewayId = str2;
        this.iotSecurityId = str3;
    }
}
