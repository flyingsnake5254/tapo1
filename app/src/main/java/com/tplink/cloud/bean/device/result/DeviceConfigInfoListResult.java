package com.tplink.cloud.bean.device.result;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class DeviceConfigInfoListResult {
    private List<DeviceConfigInfoResult> deviceConfigInfo = new ArrayList();

    public List<DeviceConfigInfoResult> getDeviceConfigInfo() {
        return this.deviceConfigInfo;
    }

    public void setDeviceConfigInfo(List<DeviceConfigInfoResult> list) {
        this.deviceConfigInfo = list;
    }
}
