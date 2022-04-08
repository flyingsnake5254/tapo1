package com.tplink.libtpnetwork.IoTNetwork.util;

import androidx.annotation.NonNull;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.BulbRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.HubRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.LightStripRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.PlugRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.SensorRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.SwitchRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.TRVRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.ThingBaseRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.j;

/* compiled from: IoTDeviceRepositoryUtils.kt */
/* loaded from: classes3.dex */
public final class c {
    public static final c a = new c();

    private c() {
    }

    public static final ThingBaseRepository a(@NonNull ThingContext thingContext) {
        EnumDeviceType enumDeviceType;
        j.e(thingContext, "thingContext");
        ALIoTDevice ioTDevice = thingContext.getIoTDevice();
        if (ioTDevice == null || (enumDeviceType = ioTDevice.getEnumDeviceType()) == null) {
            enumDeviceType = EnumDeviceType.UNKNOWN;
        }
        switch (b.a[enumDeviceType.ordinal()]) {
            case 1:
                return (ThingBaseRepository) e.a(thingContext, PlugRepository.class);
            case 2:
                if (ioTDevice == null || !ioTDevice.isLightStrip()) {
                    return (AbstractThingRepository) e.a(thingContext, BulbRepository.class);
                }
                return (AbstractThingRepository) e.a(thingContext, LightStripRepository.class);
            case 3:
                return (ThingBaseRepository) e.a(thingContext, HubRepository.class);
            case 4:
                return (ThingBaseRepository) e.a(thingContext, SwitchRepository.class);
            case 5:
                return (ThingBaseRepository) e.a(thingContext, SensorRepository.class);
            case 6:
                return (ThingBaseRepository) e.a(thingContext, TRVRepository.class);
            case 7:
            case 8:
                return null;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final ThingBaseRepository b(@NonNull String deviceIdMD5) {
        j.e(deviceIdMD5, "deviceIdMD5");
        ThingContext k2 = TPIoTClientManager.k2(deviceIdMD5);
        j.d(k2, "TPIoTClientManager.getThingContext(deviceIdMD5)");
        return a(k2);
    }

    public static final ThingBaseRepository c(@NonNull ThingContext thingContext) {
        j.e(thingContext, "thingContext");
        ThingBaseRepository a2 = a(thingContext);
        if (a2 != null) {
            return a2;
        }
        com.tplink.libtpnetwork.IoTNetwork.repository.kb.c a3 = e.a(thingContext, PlugRepository.class);
        j.d(a3, "IoTDeviceRepositoryProvi…ugRepository::class.java)");
        return (ThingBaseRepository) a3;
    }

    public static final ThingBaseRepository d(@NonNull String deviceIdMD5) {
        j.e(deviceIdMD5, "deviceIdMD5");
        ThingBaseRepository b2 = b(deviceIdMD5);
        if (b2 != null) {
            return b2;
        }
        com.tplink.libtpnetwork.IoTNetwork.repository.kb.c a2 = e.a(TPIoTClientManager.k2(deviceIdMD5), PlugRepository.class);
        j.d(a2, "IoTDeviceRepositoryProvi…ugRepository::class.java)");
        return (ThingBaseRepository) a2;
    }
}
