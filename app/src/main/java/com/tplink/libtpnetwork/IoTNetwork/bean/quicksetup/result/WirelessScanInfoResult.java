package com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result;

import com.google.gson.q.c;
import java.util.List;

/* loaded from: classes3.dex */
public class WirelessScanInfoResult {
    @c("ap_list")
    private List<WirelessScanInfoBean> apList;
    @c("start_index")
    private int startIndex;
    private int sum;
    @c("wep_supported")
    private boolean wepSupported;

    public List<WirelessScanInfoBean> getApList() {
        return this.apList;
    }

    public int getStartIndex() {
        return this.startIndex;
    }

    public int getSum() {
        return this.sum;
    }

    public boolean isWepSupported() {
        return this.wepSupported;
    }

    public void setApList(List<WirelessScanInfoBean> list) {
        this.apList = list;
    }

    public void setStartIndex(int i) {
        this.startIndex = i;
    }

    public void setSum(int i) {
        this.sum = i;
    }

    public void setWepSupported(boolean z) {
        this.wepSupported = z;
    }
}
