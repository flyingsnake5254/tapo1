package com.tplink.iot.cloud.bean.cloudvideo.result;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class CloudVideoPageListResult<T> {
    private String deviceId;
    private List<T> index = new ArrayList();
    private int page;
    private int pageSize;
    private long total;

    public String getDeviceId() {
        return this.deviceId;
    }

    public List<T> getIndex() {
        return this.index;
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

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setIndex(List<T> list) {
        this.index = list;
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
