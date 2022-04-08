package com.tplink.iot.viewmodel.ipcamera.setting;

import android.annotation.SuppressLint;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.AndroidViewModel;
import com.tplink.iot.R;
import com.tplink.iot.core.AppContext;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.FirmwareRepository;
import com.tplink.libtpnetwork.cameranetwork.model.AutoUpdateInfo;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import com.tplink.libtpnetwork.cameranetwork.model.LatestFirmwareInfo;
import com.tplink.libtpnetwork.cameranetwork.model.OptionSwitch;
import io.reactivex.e0.b;
import io.reactivex.g0.g;
import io.reactivex.q;

/* loaded from: classes3.dex */
public class FirmwareCheckViewModel extends AndroidViewModel {
    public String g;
    private CameraSettingRepository h;
    private FirmwareRepository i;
    private CommonCameraRepository j;
    public ObservableField<String> a = new ObservableField<>();

    /* renamed from: b  reason: collision with root package name */
    public ObservableField<String> f10739b = new ObservableField<>();

    /* renamed from: c  reason: collision with root package name */
    public ObservableField<String> f10740c = new ObservableField<>();

    /* renamed from: d  reason: collision with root package name */
    public ObservableInt f10741d = new ObservableInt(0);

    /* renamed from: e  reason: collision with root package name */
    public ObservableBoolean f10742e = new ObservableBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    public ObservableField<String> f10743f = new ObservableField<>();
    private b k = new b();

    public FirmwareCheckViewModel(@NonNull Application application) {
        super(application);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public /* synthetic */ void i(CameraComponent cameraComponent) throws Exception {
        this.f10742e.set(cameraComponent.isSupportFwAutoUpdate());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void j(Throwable th) throws Exception {
    }

    public q<LatestFirmwareInfo> f() {
        return this.i.u();
    }

    @SuppressLint({"CheckResult"})
    public void g(String str) {
        this.g = str;
        this.h = (CameraSettingRepository) e.c(str, CameraSettingRepository.class);
        this.i = (FirmwareRepository) e.c(str, FirmwareRepository.class);
        this.j = (CommonCameraRepository) e.c(str, CommonCameraRepository.class);
        String string = getApplication().getString(R.string.firmware_version);
        if (this.h.x().getCameraInfo() != null) {
            ObservableField<String> observableField = this.a;
            observableField.set(string + this.h.x().getCameraInfo().getSoftwareVer());
        }
        this.j.K0().H0(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.r3
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                FirmwareCheckViewModel.this.i((CameraComponent) obj);
            }
        }, q3.f11057c);
    }

    public void k() {
        AutoUpdateInfo value = this.i.f14241e.getValue();
        if (value != null) {
            this.f10743f.set(AppContext.f6185c.getString(OptionSwitch.isOn(value.getEnabled()) ? R.string.common_on : R.string.common_off));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.k.dispose();
    }
}
