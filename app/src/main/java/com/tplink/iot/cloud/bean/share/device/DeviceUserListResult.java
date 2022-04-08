package com.tplink.iot.cloud.bean.share.device;

import java.util.List;

/* loaded from: classes2.dex */
public class DeviceUserListResult {
    private int margin;
    private List<DeviceUserInfoResult> userList;

    public int getMargin() {
        return this.margin;
    }

    public List<DeviceUserInfoResult> getUserList() {
        return this.userList;
    }

    public void setMargin(int i) {
        this.margin = i;
    }

    public void setUserList(List<DeviceUserInfoResult> list) {
        this.userList = list;
    }
}
