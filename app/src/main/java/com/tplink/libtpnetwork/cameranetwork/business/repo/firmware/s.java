package com.tplink.libtpnetwork.cameranetwork.business.repo.firmware;

import b.d.w.h.b;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.cameranetwork.model.LatestFirmwareInfo;

/* compiled from: CameraFirmwareUtils.java */
/* loaded from: classes3.dex */
public class s {
    public static ThingFirmware a(BaseALIoTDevice baseALIoTDevice, LatestFirmwareInfo latestFirmwareInfo) {
        ThingFirmware thingFirmware = new ThingFirmware();
        thingFirmware.setType(b(latestFirmwareInfo.getType()));
        thingFirmware.setReleaseNote(latestFirmwareInfo.getRelease_log());
        thingFirmware.setReleaseDate(latestFirmwareInfo.getRelease_date());
        thingFirmware.setFwVer(latestFirmwareInfo.getVersion());
        String str = "";
        thingFirmware.setHwId(baseALIoTDevice.getCloudIoTDevice() != null ? baseALIoTDevice.getCloudIoTDevice().getHwId() : str);
        if (baseALIoTDevice.getCloudIoTDevice() != null) {
            str = baseALIoTDevice.getCloudIoTDevice().getOemId();
        }
        thingFirmware.setOemId(str);
        thingFirmware.setNeedToUpgrade(latestFirmwareInfo.getVersion() != null);
        return thingFirmware;
    }

    private static int b(String str) {
        int parseInt;
        if (b.d(str)) {
            return 1;
        }
        try {
            parseInt = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
        }
        if (parseInt < 1 || parseInt > 4) {
            return 1;
        }
        return parseInt;
    }
}
