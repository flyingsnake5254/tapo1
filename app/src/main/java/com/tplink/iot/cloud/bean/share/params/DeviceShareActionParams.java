package com.tplink.iot.cloud.bean.share.params;

import com.tplink.iot.cloud.bean.share.EnumDeviceShareAction;

/* loaded from: classes2.dex */
public class DeviceShareActionParams {
    private EnumDeviceShareAction action;
    private String shareId;

    public DeviceShareActionParams() {
    }

    public EnumDeviceShareAction getAction() {
        return this.action;
    }

    public String getShareId() {
        return this.shareId;
    }

    public void setAction(EnumDeviceShareAction enumDeviceShareAction) {
        this.action = enumDeviceShareAction;
    }

    public void setShareId(String str) {
        this.shareId = str;
    }

    public DeviceShareActionParams(String str, EnumDeviceShareAction enumDeviceShareAction) {
        this.shareId = str;
        this.action = enumDeviceShareAction;
    }
}
