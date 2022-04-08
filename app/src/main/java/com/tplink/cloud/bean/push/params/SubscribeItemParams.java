package com.tplink.cloud.bean.push.params;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class SubscribeItemParams {
    private String deviceId;
    private List<String> messageTypeList;

    public SubscribeItemParams() {
        this.messageTypeList = new ArrayList();
    }

    public void addMessageType(String str) {
        if (!this.messageTypeList.contains(str)) {
            this.messageTypeList.add(str);
        }
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public List<String> getMessageTypeList() {
        return this.messageTypeList;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setMessageTypeList(List<String> list) {
        this.messageTypeList = list;
    }

    public SubscribeItemParams(String str, List<String> list) {
        this.messageTypeList = new ArrayList();
        this.deviceId = str;
        this.messageTypeList = list;
    }
}
