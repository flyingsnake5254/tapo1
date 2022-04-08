package com.tplink.iot.cloud.bean.cloudvideo.result;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class OrderPageListResult<T> {
    private List<T> orderList = new ArrayList();
    private int page;
    private int pageSize;
    private long total;

    public List<T> getOrderList() {
        return this.orderList;
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

    public void setOrderList(List<T> list) {
        this.orderList = list;
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
