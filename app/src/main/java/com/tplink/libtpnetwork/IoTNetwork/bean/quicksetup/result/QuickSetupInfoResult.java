package com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result;

import com.google.gson.q.c;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class QuickSetupInfoResult implements Serializable {
    @c(ThingModelDefine.Event.UPLOAD_PARAMS_DEVICE_ID)
    private String deviceId;
    @c("inherit_status")
    private boolean inheritStatus;

    public QuickSetupInfoResult() {
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public boolean isInheritStatus() {
        return this.inheritStatus;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setInheritStatus(boolean z) {
        this.inheritStatus = z;
    }

    public QuickSetupInfoResult(String str) {
        this.deviceId = str;
    }
}
