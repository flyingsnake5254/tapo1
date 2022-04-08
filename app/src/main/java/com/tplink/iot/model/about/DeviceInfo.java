package com.tplink.iot.model.about;

/* loaded from: classes2.dex */
public class DeviceInfo {
    private String firmwareVersion;
    private String hardwareVersion;
    private String mac;
    private String productModel;
    private String productType;

    public String getFirmwareVersion() {
        return this.firmwareVersion;
    }

    public String getHardwareVersion() {
        return this.hardwareVersion;
    }

    public String getMac() {
        return this.mac;
    }

    public String getProductModel() {
        return this.productModel;
    }

    public String getProductType() {
        return this.productType;
    }

    public void setFirmwareVersion(String str) {
        this.firmwareVersion = str;
    }

    public void setHardwareVersion(String str) {
        this.hardwareVersion = str;
    }

    public void setMac(String str) {
        this.mac = str;
    }

    public void setProductModel(String str) {
        this.productModel = str;
    }

    public void setProductType(String str) {
        this.productType = str;
    }
}
