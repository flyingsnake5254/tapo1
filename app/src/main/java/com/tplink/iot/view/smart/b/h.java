package com.tplink.iot.view.smart.b;

import com.tplink.iot.view.smart.a.a;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import kotlin.jvm.internal.j;

/* compiled from: TriggerDeviceValidators.kt */
/* loaded from: classes2.dex */
public final class h implements d {
    @Override // com.tplink.iot.view.smart.b.d
    public boolean a(BaseALIoTDevice<?> device) {
        j.e(device, "device");
        EnumDeviceType enumDeviceType = device.getEnumDeviceType();
        boolean z = enumDeviceType != null && a.a.contains(enumDeviceType);
        String category = device.getCategory();
        return z && (!(category == null || category.length() == 0) && a.f9713b.contains(category));
    }
}
