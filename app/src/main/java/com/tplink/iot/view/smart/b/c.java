package com.tplink.iot.view.smart.b;

import com.tplink.iot.view.smart.a.a;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import kotlin.jvm.internal.j;

/* compiled from: ActionDeviceValidators.kt */
/* loaded from: classes2.dex */
public final class c implements d {
    @Override // com.tplink.iot.view.smart.b.d
    public boolean a(BaseALIoTDevice<?> device) {
        j.e(device, "device");
        EnumDeviceType enumDeviceType = device.getEnumDeviceType();
        boolean z = enumDeviceType != null && a.f9714c.contains(enumDeviceType);
        String category = device.getCategory();
        return z && (!(category == null || category.length() == 0) && a.f9715d.contains(category));
    }
}
