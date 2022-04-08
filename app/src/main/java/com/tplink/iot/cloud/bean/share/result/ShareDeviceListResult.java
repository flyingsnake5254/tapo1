package com.tplink.iot.cloud.bean.share.result;

import java.util.List;

/* loaded from: classes2.dex */
public class ShareDeviceListResult {
    private List<ShareDeviceResult> data;
    private int page;
    private int pageSize;
    private int total;

    public List<ShareDeviceResult> getData() {
        return this.data;
    }

    public int getPage() {
        return this.page;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getTotal() {
        return this.total;
    }

    public void setData(List<ShareDeviceResult> list) {
        this.data = list;
    }

    public void setPage(int i) {
        this.page = i;
    }

    public void setPageSize(int i) {
        this.pageSize = i;
    }

    public void setTotal(int i) {
        this.total = i;
    }
}
