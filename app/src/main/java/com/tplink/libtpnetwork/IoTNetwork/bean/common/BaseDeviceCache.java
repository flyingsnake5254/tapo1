package com.tplink.libtpnetwork.IoTNetwork.bean.common;

import com.google.gson.q.c;
import com.tplink.cloud.bean.device.result.DeviceInfoResult;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingDevice;

/* loaded from: classes3.dex */
public abstract class BaseDeviceCache {
    @c("cloud")
    protected DeviceInfoResult cloudIoTDevice;
    protected ThingDevice thingDevice;

    public DeviceInfoResult getCloudIoTDevice() {
        return this.cloudIoTDevice;
    }

    public ThingDevice getThingDevice() {
        return this.thingDevice;
    }

    public void setCloudIoTDevice(DeviceInfoResult deviceInfoResult) {
        this.cloudIoTDevice = deviceInfoResult;
    }

    public void setThingDevice(ThingDevice thingDevice) {
        this.thingDevice = thingDevice;
    }
}
