package com.tplink.iot.viewmodel.home;

import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.Comparator;

/* compiled from: HomeOnlineBaseDeviceListComparator.java */
/* loaded from: classes2.dex */
public class v implements Comparator<BaseALIoTDevice> {
    /* renamed from: a */
    public int compare(BaseALIoTDevice baseALIoTDevice, BaseALIoTDevice baseALIoTDevice2) {
        int onBoardingTime = baseALIoTDevice.getOnBoardingTime();
        int onBoardingTime2 = baseALIoTDevice2.getOnBoardingTime();
        if (onBoardingTime != 0 && onBoardingTime2 != 0) {
            return onBoardingTime2 - onBoardingTime;
        }
        if (onBoardingTime != 0) {
            return Integer.MIN_VALUE;
        }
        if (onBoardingTime2 != 0) {
            return Integer.MAX_VALUE;
        }
        String deviceName = baseALIoTDevice.getDeviceName();
        String deviceName2 = baseALIoTDevice2.getDeviceName();
        if (deviceName.isEmpty() && deviceName2.isEmpty()) {
            return 0;
        }
        if (deviceName.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        if (deviceName2.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return deviceName.compareToIgnoreCase(deviceName2);
    }
}
