package com.tplink.cloud.bean.share.params;

import java.util.List;

/* loaded from: classes2.dex */
public class DeviceShareListParams {
    private List<DeviceShareParams> shareList;

    public DeviceShareListParams() {
    }

    public List<DeviceShareParams> getShareList() {
        return this.shareList;
    }

    public void setShareList(List<DeviceShareParams> list) {
        this.shareList = list;
    }

    public DeviceShareListParams(List<DeviceShareParams> list) {
        this.shareList = list;
    }
}
