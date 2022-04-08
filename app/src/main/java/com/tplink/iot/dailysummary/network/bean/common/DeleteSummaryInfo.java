package com.tplink.iot.dailysummary.network.bean.common;

import java.util.List;

/* loaded from: classes2.dex */
public class DeleteSummaryInfo {
    private String date;
    private List<String> uuidList;

    public String getDate() {
        return this.date;
    }

    public List<String> getUuidList() {
        return this.uuidList;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setUuidList(List<String> list) {
        this.uuidList = list;
    }
}
