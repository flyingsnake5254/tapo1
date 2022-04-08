package com.tplink.cloud.bean.device.params;

import java.util.List;

/* loaded from: classes2.dex */
public class DeviceFeatureParams {
    private String cloudUserName;
    private List<String> deviceIdList;

    public DeviceFeatureParams() {
    }

    public String getCloudUserName() {
        return this.cloudUserName;
    }

    public List<String> getDeviceIdList() {
        return this.deviceIdList;
    }

    public void setCloudUserName(String str) {
        this.cloudUserName = str;
    }

    public void setDeviceIdList(List<String> list) {
        this.deviceIdList = list;
    }

    public DeviceFeatureParams(String str, List<String> list) {
        this.cloudUserName = str;
        this.deviceIdList = list;
    }
}
