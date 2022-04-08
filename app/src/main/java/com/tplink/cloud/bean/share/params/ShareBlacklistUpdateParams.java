package com.tplink.cloud.bean.share.params;

import java.util.List;

/* loaded from: classes2.dex */
public class ShareBlacklistUpdateParams {
    private List<String> blackList;

    public ShareBlacklistUpdateParams() {
    }

    public List<String> getBlackList() {
        return this.blackList;
    }

    public void setBlackList(List<String> list) {
        this.blackList = list;
    }

    public ShareBlacklistUpdateParams(List<String> list) {
        this.blackList = list;
    }
}
