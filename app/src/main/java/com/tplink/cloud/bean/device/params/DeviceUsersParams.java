package com.tplink.cloud.bean.device.params;

import java.util.List;

/* loaded from: classes2.dex */
public class DeviceUsersParams {
    private String deviceId;
    private String ownerAccount;
    private List<String> userAccountList;

    public DeviceUsersParams() {
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getOwnerAccount() {
        return this.ownerAccount;
    }

    public List<String> getUserAccountList() {
        return this.userAccountList;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setOwnerAccount(String str) {
        this.ownerAccount = str;
    }

    public void setUserAccountList(List<String> list) {
        this.userAccountList = list;
    }

    public DeviceUsersParams(String str, String str2, List<String> list) {
        this.deviceId = str;
        this.ownerAccount = str2;
        this.userAccountList = list;
    }
}
