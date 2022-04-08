package com.tplink.cloud.bean.share.result;

import java.util.List;

/* loaded from: classes2.dex */
public class ShareBlacklistResult {
    private List<ShareBlacklistItemResult> blackList;
    private int currentIndex;
    private int total;

    public List<ShareBlacklistItemResult> getBlackList() {
        return this.blackList;
    }

    public int getCurrentIndex() {
        return this.currentIndex;
    }

    public int getTotal() {
        return this.total;
    }

    public void setBlackList(List<ShareBlacklistItemResult> list) {
        this.blackList = list;
    }

    public void setCurrentIndex(int i) {
        this.currentIndex = i;
    }

    public void setTotal(int i) {
        this.total = i;
    }
}
