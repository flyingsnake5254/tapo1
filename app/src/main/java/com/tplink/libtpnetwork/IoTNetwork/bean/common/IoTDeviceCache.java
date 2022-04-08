package com.tplink.libtpnetwork.IoTNetwork.bean.common;

import android.text.TextUtils;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.q.c;
import com.tplink.cloud.bean.device.result.DeviceInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingDevice;

/* loaded from: classes3.dex */
public class IoTDeviceCache extends BaseDeviceCache {
    @c(ImagesContract.LOCAL)
    private LocalIoTBaseDevice localIoTDevice;

    public IoTDeviceCache() {
    }

    public String getDeviceType() {
        DeviceInfoResult deviceInfoResult = this.cloudIoTDevice;
        if (deviceInfoResult != null && !TextUtils.isEmpty(deviceInfoResult.getDeviceType())) {
            return this.cloudIoTDevice.getDeviceType();
        }
        ThingDevice thingDevice = this.thingDevice;
        if (thingDevice != null && !TextUtils.isEmpty(thingDevice.getDeviceType())) {
            return this.thingDevice.getDeviceType();
        }
        LocalIoTBaseDevice localIoTBaseDevice = this.localIoTDevice;
        return (localIoTBaseDevice == null || TextUtils.isEmpty(localIoTBaseDevice.getType())) ? "" : this.localIoTDevice.getType();
    }

    public LocalIoTBaseDevice getLocalIoTDevice() {
        return this.localIoTDevice;
    }

    public void setLocalIoTDevice(LocalIoTBaseDevice localIoTBaseDevice) {
        this.localIoTDevice = localIoTBaseDevice;
    }

    public IoTDeviceCache(ALIoTDevice aLIoTDevice) {
        if (aLIoTDevice.getCloudIoTDevice() != null) {
            this.cloudIoTDevice = aLIoTDevice.getCloudIoTDevice().getDeviceInfo();
        }
        if (aLIoTDevice.getThingDevice() != null) {
            this.thingDevice = aLIoTDevice.getThingDevice();
        }
        this.localIoTDevice = aLIoTDevice.getLocalIoTDevice();
    }
}
