package com.tplink.iot.view.smart.b;

import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import kotlin.jvm.internal.j;

/* compiled from: TriggerDeviceValidators.kt */
/* loaded from: classes2.dex */
public final class f implements d {
    @Override // com.tplink.iot.view.smart.b.d
    public boolean a(BaseALIoTDevice<?> device) {
        j.e(device, "device");
        if (!device.isCamera()) {
            return true;
        }
        return !(device.isCamera() && device.isUserRoleTypeDevice());
    }
}
