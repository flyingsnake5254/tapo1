package com.tplink.iot.Utils.w0;

import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import kotlin.jvm.internal.j;

/* compiled from: ComponentUtils.kt */
/* loaded from: classes2.dex */
public final class b {
    public static final boolean a(LocalIoTBaseDevice localIoTBaseDevice, EnumIoTComponent component) {
        j.e(component, "component");
        if (localIoTBaseDevice != null) {
            return localIoTBaseDevice.isSupportComponent(component);
        }
        return false;
    }
}
