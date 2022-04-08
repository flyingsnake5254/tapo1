package com.tplink.iot.dailysummary.network.bean.result;

import java.util.List;

/* loaded from: classes2.dex */
public class SummaryListResult {
    private List<SummaryResult> dateList;
    private long page;
    private long pageSize;
    private long total;

    public List<SummaryResult> getDateList() {
        return this.dateList;
    }

    public long getPage() {
        return this.page;
    }

    public long getPageSize() {
        return this.pageSize;
    }

    public long getTotal() {
        return this.total;
    }

    public void setDateList(List<SummaryResult> list) {
        this.dateList = list;
    }

    public void setPage(long j) {
        this.page = j;
    }

    public void setPageSize(long j) {
        this.pageSize = j;
    }

    public void setTotal(long j) {
        this.total = j;
    }

    public String toString() {
        return "SummaryListResult{total=" + this.total + ", page=" + this.page + ", pageSize=" + this.pageSize + ", dateList=" + this.dateList + '}';
    }
}
