package com.tplink.cloud.bean.device.params;

import java.util.List;

/* loaded from: classes2.dex */
public class DeviceConfigInfoParams {
    private boolean avatarNeeded;
    private List<String> deviceIdList;

    public DeviceConfigInfoParams() {
    }

    public List<String> getDeviceIdList() {
        return this.deviceIdList;
    }

    public boolean isAvatarNeeded() {
        return this.avatarNeeded;
    }

    public void setAvatarNeeded(boolean z) {
        this.avatarNeeded = z;
    }

    public void setDeviceIdList(List<String> list) {
        this.deviceIdList = list;
    }

    public DeviceConfigInfoParams(List<String> list, boolean z) {
        this.deviceIdList = list;
        this.avatarNeeded = z;
    }
}
