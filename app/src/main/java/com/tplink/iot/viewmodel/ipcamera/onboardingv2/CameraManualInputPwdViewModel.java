package com.tplink.iot.viewmodel.ipcamera.onboardingv2;

import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import b.d.w.e.b;
import com.tplink.iot.Utils.x0.f;
import com.tplink.libtpnetwork.cameranetwork.model.Wifi;

/* loaded from: classes2.dex */
public class CameraManualInputPwdViewModel extends OnBoardingFragmentViewModel {
    private CameraOnBoardingViewModel a;

    /* renamed from: b  reason: collision with root package name */
    public final ObservableBoolean f10403b = new ObservableBoolean(false);

    public CameraManualInputPwdViewModel(@NonNull Application application) {
        super(application);
    }

    public void f() {
        String str = this.a.a.get();
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        String str3 = this.a.f10404b.get();
        if (TextUtils.isEmpty(str3)) {
            str3 = str2;
        }
        Wifi wifi = new Wifi(str, "", 4, 3, 0, str3);
        if (TextUtils.isEmpty(str3)) {
            wifi = new Wifi(str, "", 0, 0, 0, "");
        }
        this.a.c2(wifi);
        this.a.a.set(!TextUtils.isEmpty(wifi.getSsid()) ? wifi.getSsid() : str2);
        ObservableField<String> observableField = this.a.f10404b;
        if (!TextUtils.isEmpty(wifi.getPassword())) {
            str2 = wifi.getPassword();
        }
        observableField.set(str2);
        f.B(this.a.B(), wifi);
    }

    public boolean g(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return !b.b(str);
    }

    public void h(CameraOnBoardingViewModel cameraOnBoardingViewModel) {
        this.a = cameraOnBoardingViewModel;
    }
}
