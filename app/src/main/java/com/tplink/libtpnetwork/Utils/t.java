package com.tplink.libtpnetwork.Utils;

import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import java.util.List;

/* compiled from: TapoAppUpdateUtils.java */
/* loaded from: classes3.dex */
public class t {
    public static boolean a() {
        o h0 = o.h0();
        return h0.c("sp_has_already_filter_old_camera" + o.E(), false);
    }

    public static boolean b(String str) {
        o h0 = o.h0();
        return h0.c("sp_is_old_camera" + o.E() + str, false);
    }

    public static void c(List<BaseALIoTDevice> list) {
        for (BaseALIoTDevice baseALIoTDevice : list) {
            if (baseALIoTDevice instanceof ALCameraDevice) {
                e(baseALIoTDevice.getDeviceIdMD5(), true);
            }
        }
        d(true);
    }

    public static void d(boolean z) {
        o h0 = o.h0();
        h0.h("sp_has_already_filter_old_camera" + o.E(), z);
    }

    public static void e(String str, boolean z) {
        o h0 = o.h0();
        h0.h("sp_is_old_camera" + o.E() + str, z);
    }
}
