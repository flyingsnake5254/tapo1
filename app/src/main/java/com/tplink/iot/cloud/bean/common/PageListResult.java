package com.tplink.iot.cloud.bean.common;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class PageListResult<T> {
    private List<T> data = new ArrayList();
    private int page;
    private int pageSize;
    private long total;

    public List<T> getData() {
        return this.data;
    }

    public int getPage() {
        return this.page;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public long getTotal() {
        return this.total;
    }

    public void setData(List<T> list) {
        this.data = list;
    }

    public void setPage(int i) {
        this.page = i;
    }

    public void setPageSize(int i) {
        this.pageSize = i;
    }

    public void setTotal(long j) {
        this.total = j;
    }
}
