package com.tplink.cloud.bean.share.params;

import java.util.List;

/* loaded from: classes2.dex */
public class DeviceShareActionListParams {
    private List<DeviceShareActionParams> shareList;

    public DeviceShareActionListParams() {
    }

    public List<DeviceShareActionParams> getShareList() {
        return this.shareList;
    }

    public void setShareList(List<DeviceShareActionParams> list) {
        this.shareList = list;
    }

    public DeviceShareActionListParams(List<DeviceShareActionParams> list) {
        this.shareList = list;
    }
}
