package com.tplink.cloud.bean.device.result;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class DeviceUnbindFeatureResult {
    private List<DeviceUnbindInfoResult> deviceIdList = new ArrayList();

    public List<DeviceUnbindInfoResult> getDeviceIdList() {
        return this.deviceIdList;
    }

    public void setDeviceIdList(List<DeviceUnbindInfoResult> list) {
        this.deviceIdList = list;
    }
}
