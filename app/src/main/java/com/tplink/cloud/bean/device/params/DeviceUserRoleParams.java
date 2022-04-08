package com.tplink.cloud.bean.device.params;

import java.util.List;

/* loaded from: classes2.dex */
public class DeviceUserRoleParams {
    private List<String> deviceIdList;
    private String userAccount;

    public DeviceUserRoleParams() {
    }

    public List<String> getDeviceIdList() {
        return this.deviceIdList;
    }

    public String getUserAccount() {
        return this.userAccount;
    }

    public void setDeviceIdList(List<String> list) {
        this.deviceIdList = list;
    }

    public void setUserAccount(String str) {
        this.userAccount = str;
    }

    public DeviceUserRoleParams(List<String> list, String str) {
        this.deviceIdList = list;
        this.userAccount = str;
    }
}
