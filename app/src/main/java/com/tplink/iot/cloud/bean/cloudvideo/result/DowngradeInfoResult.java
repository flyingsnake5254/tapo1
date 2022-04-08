package com.tplink.iot.cloud.bean.cloudvideo.result;

import com.tplink.iot.cloud.bean.cloudvideo.common.DowngradeHandled;
import com.tplink.iot.cloud.bean.cloudvideo.common.DowngradeToHandle;

/* loaded from: classes2.dex */
public class DowngradeInfoResult {
    private DowngradeHandled downgradeHandled;
    private DowngradeToHandle downgradeToHandle;

    public DowngradeHandled getDowngradeHandled() {
        return this.downgradeHandled;
    }

    public DowngradeToHandle getDowngradeToHandle() {
        return this.downgradeToHandle;
    }

    public void setDowngradeHandled(DowngradeHandled downgradeHandled) {
        this.downgradeHandled = downgradeHandled;
    }

    public void setDowngradeToHandle(DowngradeToHandle downgradeToHandle) {
        this.downgradeToHandle = downgradeToHandle;
    }
}
