package com.tplink.iot.viewmodel.ipcamera.onboardingv2;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;

/* loaded from: classes2.dex */
public class CameraSearchAfterSetupViewModel extends OnBoardingFragmentViewModel {
    public final ObservableBoolean a = new ObservableBoolean(true);

    public CameraSearchAfterSetupViewModel(@NonNull Application application) {
        super(application);
    }
}
