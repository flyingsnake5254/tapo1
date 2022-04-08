package com.tplink.iot.Utils.w0;

import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;

/* compiled from: ComponentUtils.java */
/* loaded from: classes2.dex */
public class a {
    public static int a(String str, EnumIoTComponent enumIoTComponent) {
        ALIoTDevice b2 = b(str);
        if (b2 == null || b2.getLocalIoTDevice() == null) {
            return 0;
        }
        return b2.getLocalIoTDevice().getComponentVersion(enumIoTComponent);
    }

    public static ALIoTDevice b(String str) {
        return TPIoTClientManager.k2(str).getIoTDevice();
    }

    public static boolean c(String str) {
        ALIoTDevice b2 = b(str);
        return b2 != null && b2.isPlugP105OfJP();
    }

    public static boolean d(String str) {
        ALIoTDevice b2 = b(str);
        return b2 != null && b2.isSupportCloudConnect();
    }

    public static boolean e(String str) {
        ALIoTDevice b2 = b(str);
        return b2 != null && b2.isSupportColorAndColorTemp();
    }

    public static boolean f(ThingContext thingContext, EnumIoTComponent enumIoTComponent) {
        ALIoTDevice ioTDevice = thingContext.getIoTDevice();
        return (ioTDevice == null || ioTDevice.getLocalIoTDevice() == null || !ioTDevice.getLocalIoTDevice().isSupportComponent(enumIoTComponent)) ? false : true;
    }

    public static boolean g(String str, EnumIoTComponent enumIoTComponent) {
        ALIoTDevice b2 = b(str);
        return (b2 == null || b2.getLocalIoTDevice() == null || !b2.getLocalIoTDevice().isSupportComponent(enumIoTComponent)) ? false : true;
    }

    public static boolean h(String str) {
        ALIoTDevice b2 = b(str);
        return b2 != null && b2.isSupportDefaultStates();
    }

    public static boolean i(String str) {
        ALIoTDevice b2 = b(str);
        return b2 != null && b2.isSupportIoTCloudComponent();
    }

    public static boolean j(String str) {
        ALIoTDevice b2 = b(str);
        return b2 != null && b2.isSupportLightEffect();
    }

    public static boolean k(String str) {
        ALIoTDevice b2 = b(str);
        return b2 != null && b2.isSupportSunriseSunset();
    }

    public static boolean l(String str) {
        ALIoTDevice b2 = b(str);
        return b2 != null && b2.isSupportLED();
    }
}
