package com.tplink.iot.viewmodel.ipcamera.onboardingv2;

import android.app.Application;
import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public class CameraLocationPermissionViewModel extends OnBoardingFragmentViewModel {
    private boolean a = false;

    public CameraLocationPermissionViewModel(@NonNull Application application) {
        super(application);
    }

    public boolean f() {
        return this.a;
    }

    public void g(boolean z) {
        this.a = z;
    }
}
