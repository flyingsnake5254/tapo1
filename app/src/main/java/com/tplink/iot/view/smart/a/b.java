package com.tplink.iot.view.smart.a;

import com.tplink.iot.cloud.bean.thing.common.ThingInfo;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.libtpnetwork.enumerate.EnumIoTCategory;
import kotlin.jvm.internal.j;

/* compiled from: SmartTemplateUtils.kt */
/* loaded from: classes2.dex */
public final class b {
    public static final b a = new b();

    private b() {
    }

    public static final boolean a(String str) {
        if (str != null) {
            return j.a(EnumIoTCategory.LIGHT.value(), str) || j.a(EnumIoTCategory.LIGHT_STRIP.value(), str);
        }
        return false;
    }

    public static final boolean b(ThingInfo thingInfo) {
        if (thingInfo == null) {
            return true;
        }
        return !(j.a(thingInfo.getDeviceType(), EnumDeviceType.CAMERA.getDeviceType()) && thingInfo.getRole() == 1);
    }

    public static final boolean c(BaseALIoTDevice<?> baseALIoTDevice) {
        if (baseALIoTDevice == null) {
            return true;
        }
        return !(baseALIoTDevice.isCamera() && baseALIoTDevice.isUserRoleTypeDevice());
    }

    public static final boolean d(String str, ThingInfo thingInfo) {
        return str != null && thingInfo != null && j.a(str, thingInfo.getCategory()) && b(thingInfo);
    }

    public static final boolean e(String str, BaseALIoTDevice<?> baseALIoTDevice) {
        return str != null && baseALIoTDevice != null && j.a(str, baseALIoTDevice.getCategory()) && c(baseALIoTDevice);
    }
}
