package com.tplink.cloud.bean.share.params;

import com.tplink.cloud.bean.share.EnumDeviceShareRole;
import com.tplink.cloud.bean.share.EnumDeviceShareStatus;
import java.util.List;

/* loaded from: classes2.dex */
public class ShareDeviceParams {
    private List<String> deviceTypeList;
    private int index;
    private int limit;
    private EnumDeviceShareRole shareRole;
    private EnumDeviceShareStatus shareStatus;

    public List<String> getDeviceTypeList() {
        return this.deviceTypeList;
    }

    public int getIndex() {
        return this.index;
    }

    public int getLimit() {
        return this.limit;
    }

    public EnumDeviceShareRole getShareRole() {
        return this.shareRole;
    }

    public EnumDeviceShareStatus getShareStatus() {
        return this.shareStatus;
    }

    public void setDeviceTypeList(List<String> list) {
        this.deviceTypeList = list;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public void setLimit(int i) {
        this.limit = i;
    }

    public void setShareRole(EnumDeviceShareRole enumDeviceShareRole) {
        this.shareRole = enumDeviceShareRole;
    }

    public void setShareStatus(EnumDeviceShareStatus enumDeviceShareStatus) {
        this.shareStatus = enumDeviceShareStatus;
    }
}
