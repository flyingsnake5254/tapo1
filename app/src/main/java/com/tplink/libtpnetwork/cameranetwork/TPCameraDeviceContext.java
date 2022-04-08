package com.tplink.libtpnetwork.cameranetwork;

import androidx.annotation.Nullable;
import com.tplink.cloud.context.b;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class TPCameraDeviceContext extends TPBaseDeviceContext<ALCameraDevice> implements Serializable {
    private ThingModel thingModel;

    public TPCameraDeviceContext(String str, b bVar) {
        super(str, bVar);
    }

    @Nullable
    public ThingModel getThingModel() {
        return this.thingModel;
    }

    @Nullable
    public String getThingModelId() {
        T t = this.iotDevice;
        if (t != 0) {
            return ((ALCameraDevice) t).getThingModelId();
        }
        return null;
    }

    @Override // com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext
    public String getThingUrl() {
        T t = this.iotDevice;
        if (t != 0) {
            return ((ALCameraDevice) t).getThingUrl();
        }
        return null;
    }

    public void setThingModel(ThingModel thingModel) {
        this.thingModel = thingModel;
    }

    public TPCameraDeviceContext(b bVar, BaseALIoTDevice baseALIoTDevice) {
        this.tcAccountContext = bVar;
        if (baseALIoTDevice != null) {
            this.deviceIdMD5 = baseALIoTDevice.getDeviceIdMD5();
        }
        if (baseALIoTDevice instanceof ALCameraDevice) {
            this.iotDevice = (ALCameraDevice) baseALIoTDevice;
        }
    }
}
