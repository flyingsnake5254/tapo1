package com.tplink.iot.cloud.bean.share.result;

import com.google.gson.i;

/* loaded from: classes2.dex */
public class DeviceShareActionHandleResult {
    private Integer code;
    private i data;
    private String message;
    private String shareId;

    public Integer getCode() {
        return this.code;
    }

    public i getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public String getShareId() {
        return this.shareId;
    }

    public void setCode(Integer num) {
        this.code = num;
    }

    public void setData(i iVar) {
        this.data = iVar;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setShareId(String str) {
        this.shareId = str;
    }
}
