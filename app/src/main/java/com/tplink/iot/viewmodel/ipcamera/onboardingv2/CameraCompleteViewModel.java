package com.tplink.iot.viewmodel.ipcamera.onboardingv2;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import com.tplink.iot.view.ipcamera.base.c;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceModel;

/* loaded from: classes2.dex */
public class CameraCompleteViewModel extends OnBoardingFragmentViewModel {
    public final ObservableBoolean a = new ObservableBoolean(false);

    public CameraCompleteViewModel(@NonNull Application application) {
        super(application);
    }

    public int f(DeviceModel deviceModel) {
        return (!c.t(deviceModel) && !c.u(deviceModel) && !c.v(deviceModel)) ? 4 : 0;
    }
}
