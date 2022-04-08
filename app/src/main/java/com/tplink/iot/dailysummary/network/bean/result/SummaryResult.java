package com.tplink.iot.dailysummary.network.bean.result;

import com.tplink.iot.dailysummary.network.bean.common.Summary;
import java.util.List;

/* loaded from: classes2.dex */
public class SummaryResult {
    private String date;
    private List<Summary> summaryList;

    public String getDate() {
        return this.date;
    }

    public List<Summary> getSummaryList() {
        return this.summaryList;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setSummaryList(List<Summary> list) {
        this.summaryList = list;
    }

    public String toString() {
        return "SummaryResult{date='" + this.date + "', summaryList=" + this.summaryList + '}';
    }
}
