package com.tplink.iot.cloud.bean.share.result;

import com.tplink.iot.cloud.bean.share.common.LaunchFailBean;
import com.tplink.iot.cloud.bean.share.common.LaunchSuccessBean;
import java.util.List;

/* loaded from: classes2.dex */
public class DeviceShareLaunchResult {
    private List<LaunchFailBean> failList;
    private List<LaunchSuccessBean> launchList;

    public List<LaunchFailBean> getFailList() {
        return this.failList;
    }

    public List<LaunchSuccessBean> getLaunchList() {
        return this.launchList;
    }

    public void setFailList(List<LaunchFailBean> list) {
        this.failList = list;
    }

    public void setLaunchList(List<LaunchSuccessBean> list) {
        this.launchList = list;
    }
}
