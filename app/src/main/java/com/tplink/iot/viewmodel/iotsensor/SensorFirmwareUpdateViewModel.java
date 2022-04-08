package com.tplink.iot.viewmodel.iotsensor;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import kotlin.jvm.internal.j;

/* compiled from: SensorFirmwareUpdateViewModel.kt */
/* loaded from: classes2.dex */
public final class SensorFirmwareUpdateViewModel extends AndroidViewModel {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SensorFirmwareUpdateViewModel(Application application, ThingContext iotDeviceContext) {
        super(application);
        j.e(application, "application");
        j.e(iotDeviceContext, "iotDeviceContext");
    }
}
