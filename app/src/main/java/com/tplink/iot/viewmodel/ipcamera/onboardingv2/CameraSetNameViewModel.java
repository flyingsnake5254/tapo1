package com.tplink.iot.viewmodel.ipcamera.onboardingv2;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;

/* loaded from: classes2.dex */
public class CameraSetNameViewModel extends OnBoardingFragmentViewModel {
    public final ObservableBoolean a = new ObservableBoolean(true);

    public CameraSetNameViewModel(@NonNull Application application) {
        super(application);
    }

    public boolean f(String str) {
        int i;
        try {
            i = str.getBytes("UTF-8").length;
        } catch (Exception e2) {
            e2.printStackTrace();
            i = 0;
        }
        return i > 0 && i <= 32;
    }
}
