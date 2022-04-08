package com.tplink.iot.cloud.bean.cloudvideo.result;

import com.tplink.iot.cloud.bean.cloudvideo.common.CloudVideoDevice;
import java.util.List;

/* loaded from: classes2.dex */
public class CloudVideoDevicesResult {
    private List<CloudVideoDevice> deviceList;
    private int page;
    private int pageSize;
    private int total;

    public List<CloudVideoDevice> getDeviceList() {
        return this.deviceList;
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

    public void setDeviceList(List<CloudVideoDevice> list) {
        this.deviceList = list;
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
