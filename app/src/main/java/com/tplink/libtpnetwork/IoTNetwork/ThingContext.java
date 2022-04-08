package com.tplink.libtpnetwork.IoTNetwork;

import com.tplink.cloud.context.b;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.cloud.bean.thing.common.ThingSetting;
import com.tplink.iot.cloud.bean.thing.common.ThingShadow;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingDevice;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import java.io.Serializable;
import java.util.Map;

/* loaded from: classes3.dex */
public class ThingContext extends TPBaseDeviceContext<ALIoTDevice> implements Serializable {
    private ThingModel thingModel;

    public ThingContext(String str, b bVar) {
        super(str, bVar);
    }

    private String getThingGatewayUrl() {
        T t = this.iotDevice;
        if (t != 0) {
            return ((ALIoTDevice) t).getThingGatewayUrl();
        }
        return null;
    }

    public String getLang() {
        T t = this.iotDevice;
        if (t != 0) {
            return ((ALIoTDevice) t).getLang();
        }
        return null;
    }

    public ThingDevice getThingDevice() {
        T t = this.iotDevice;
        if (t != 0) {
            return ((ALIoTDevice) t).getThingDevice();
        }
        return null;
    }

    public String getThingGatewayUrlV2() {
        T t = this.iotDevice;
        String thingGatewayUrlV2 = t != 0 ? ((ALIoTDevice) t).getThingGatewayUrlV2() : null;
        return !b.d.w.h.b.d(thingGatewayUrlV2) ? thingGatewayUrlV2 : getThingGatewayUrl();
    }

    public ThingModel getThingModel() {
        return this.thingModel;
    }

    public String getThingModelId() {
        T t = this.iotDevice;
        if (t != 0) {
            return ((ALIoTDevice) t).getThingModelId();
        }
        return null;
    }

    public String getThingName() {
        T t = this.iotDevice;
        if (t != 0) {
            return ((ALIoTDevice) t).getThingName();
        }
        return null;
    }

    public ThingSetting getThingSetting() {
        T t = this.iotDevice;
        if (t != 0) {
            return ((ALIoTDevice) t).getThingSetting();
        }
        return null;
    }

    public ThingShadow getThingShadow() {
        T t = this.iotDevice;
        if (t != 0) {
            return ((ALIoTDevice) t).getThingShadow();
        }
        return null;
    }

    public long getThingShadowVersion() {
        ThingShadow thingShadow = getThingShadow();
        if (thingShadow != null) {
            return thingShadow.getVersion();
        }
        return 0L;
    }

    @Override // com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext
    public String getThingUrl() {
        T t = this.iotDevice;
        if (t != 0) {
            return ((ALIoTDevice) t).getThingUrl();
        }
        return null;
    }

    public boolean isDataFromThing() {
        T t = this.iotDevice;
        if (t != 0) {
            return ((ALIoTDevice) t).isDataFromThing();
        }
        return false;
    }

    public boolean isThingOnline() {
        T t = this.iotDevice;
        return t != 0 && ((ALIoTDevice) t).isThingOnline();
    }

    public void setDataFromThing(boolean z) {
        T t = this.iotDevice;
        if (t != 0) {
            ((ALIoTDevice) t).setDataFromThing(z);
        }
    }

    public void setThingModel(ThingModel thingModel) {
        this.thingModel = thingModel;
    }

    public void setThingSetting(ThingSetting thingSetting) {
        T t = this.iotDevice;
        if (t != 0) {
            ((ALIoTDevice) t).setThingSetting(thingSetting);
        }
    }

    public void setThingShadow(ThingShadow thingShadow) {
        T t = this.iotDevice;
        if (t != 0) {
            ((ALIoTDevice) t).setThingShadow(thingShadow);
        }
    }

    public void updateThingShadow(long j, Map<String, Object> map) {
        updateThingShadow(j, map, null);
    }

    public ThingContext(b bVar, BaseALIoTDevice baseALIoTDevice) {
        this.tcAccountContext = bVar;
        if (baseALIoTDevice != null) {
            this.deviceIdMD5 = baseALIoTDevice.getDeviceIdMD5();
        }
        if (baseALIoTDevice instanceof ALIoTDevice) {
            this.iotDevice = (ALIoTDevice) baseALIoTDevice;
        }
    }

    public void updateThingShadow(long j, Map<String, Object> map, Map<String, Object> map2) {
        T t = this.iotDevice;
        if (t != 0) {
            ((ALIoTDevice) t).updateThingShadow(j, map, map2);
        }
    }
}
