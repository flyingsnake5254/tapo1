package com.tplink.iot.view.smart.b;

import com.tplink.iot.cloud.bean.smart.common.SmartThingAction;
import com.tplink.iot.cloud.bean.thing.params.ThingServiceParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.List;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.j;

/* compiled from: TriggerDeviceValidators.kt */
/* loaded from: classes2.dex */
public final class i implements d {
    private final a<List<SmartThingAction>> a;

    /* JADX WARN: Multi-variable type inference failed */
    public i(a<? extends List<? extends SmartThingAction>> mThingActionsAccessor) {
        j.e(mThingActionsAccessor, "mThingActionsAccessor");
        this.a = mThingActionsAccessor;
    }

    private final boolean b(BaseALIoTDevice<?> baseALIoTDevice, List<? extends SmartThingAction> list) {
        for (SmartThingAction smartThingAction : list) {
            if (j.a(baseALIoTDevice.getDeviceId(), smartThingAction.getThingName())) {
                ThingServiceParams service = smartThingAction.getService();
                if (j.a(ThingModelDefine.Service.SERVICE_RING, service != null ? service.getServiceId() : null)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.tplink.iot.view.smart.b.d
    public boolean a(BaseALIoTDevice<?> device) {
        j.e(device, "device");
        if (!device.isHub()) {
            return true;
        }
        return !b(device, this.a.invoke());
    }
}
