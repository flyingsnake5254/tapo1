package com.tplink.cloud.bean.device.result;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class DeviceListResult {
    private List<DeviceInfoResult> deviceList = new ArrayList();

    public List<DeviceInfoResult> getDeviceList() {
        return this.deviceList;
    }

    public void setDeviceList(List<DeviceInfoResult> list) {
        this.deviceList = list;
    }
}
