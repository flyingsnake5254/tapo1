package com.tplink.iot.viewmodel.ipcamera.onboardingv2;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.WirelessInfoParams;
import com.tplink.libtpnetwork.Utils.o;

/* loaded from: classes2.dex */
public class InputPwdViewModel extends OnBoardingFragmentViewModel {
    public final ObservableBoolean a = new ObservableBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    private CameraOnBoardingViewModel f10427b;

    public InputPwdViewModel(@NonNull Application application) {
        super(application);
    }

    public void f() {
        if (this.f10427b.f10407e.get()) {
            o.h0().a1(new WirelessInfoParams(this.f10427b.a.get(), this.f10427b.f10404b.get(), "wpa2_psk"));
            return;
        }
        o.h0().r0(new WirelessInfoParams(this.f10427b.a.get(), "", ""));
    }

    public void g(CameraOnBoardingViewModel cameraOnBoardingViewModel) {
        this.f10427b = cameraOnBoardingViewModel;
    }
}
