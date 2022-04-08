package com.tplink.cloud.bean.device.params;

import java.util.List;

/* loaded from: classes2.dex */
public class DeviceUserNumberLimitParams {
    private List<String> deviceTypeList;

    public DeviceUserNumberLimitParams() {
    }

    public List<String> getDeviceTypeList() {
        return this.deviceTypeList;
    }

    public void setDeviceTypeList(List<String> list) {
        this.deviceTypeList = list;
    }

    public DeviceUserNumberLimitParams(List<String> list) {
        this.deviceTypeList = list;
    }
}
