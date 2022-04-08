package com.tplink.iot.model.notification;

import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;

/* loaded from: classes2.dex */
public class DeviceNotificationBean {
    boolean isSubscribe;
    BaseALIoTDevice mAlIoTDevice;

    public DeviceNotificationBean(BaseALIoTDevice baseALIoTDevice, boolean z) {
        this.mAlIoTDevice = baseALIoTDevice;
        this.isSubscribe = z;
    }

    public BaseALIoTDevice getAlIoTDevice() {
        return this.mAlIoTDevice;
    }

    public boolean isSubscribe() {
        return this.isSubscribe;
    }

    public void setAlIoTDevice(BaseALIoTDevice baseALIoTDevice) {
        this.mAlIoTDevice = baseALIoTDevice;
    }

    public void setSubscribe(boolean z) {
        this.isSubscribe = z;
    }
}
