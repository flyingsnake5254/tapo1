package com.tplink.iot.view.smart.b;

import com.tplink.iot.cloud.bean.thing.common.ThingEvent;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.cloud.bean.thing.common.ThingProperty;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.List;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;

/* compiled from: TriggerDeviceValidators.kt */
/* loaded from: classes2.dex */
public final class g implements d {
    private final l<BaseALIoTDevice<?>, ThingModel> a;

    /* JADX WARN: Multi-variable type inference failed */
    public g(l<? super BaseALIoTDevice<?>, ? extends ThingModel> mThingModelAccessor) {
        j.e(mThingModelAccessor, "mThingModelAccessor");
        this.a = mThingModelAccessor;
    }

    @Override // com.tplink.iot.view.smart.b.d
    public boolean a(BaseALIoTDevice<?> device) {
        j.e(device, "device");
        ThingModel invoke = this.a.invoke(device);
        if (invoke == null) {
            return false;
        }
        List<ThingProperty> properties = invoke.getProperties();
        boolean z = !(properties == null || properties.isEmpty());
        List<ThingEvent> events = invoke.getEvents();
        return z || ((events == null || events.isEmpty()) ^ true);
    }
}
