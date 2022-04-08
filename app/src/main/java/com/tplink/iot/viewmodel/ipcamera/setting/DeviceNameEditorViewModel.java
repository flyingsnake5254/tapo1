package com.tplink.iot.viewmodel.ipcamera.setting;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import b.d.s.a.a;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.model.CameraInfoCache;
import io.reactivex.e0.b;
import io.reactivex.q;

/* loaded from: classes3.dex */
public class DeviceNameEditorViewModel extends AndroidViewModel {

    /* renamed from: c  reason: collision with root package name */
    public String f10724c;

    /* renamed from: e  reason: collision with root package name */
    private CameraSettingRepository f10726e;
    public ObservableBoolean a = new ObservableBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public ObservableField<String> f10723b = new ObservableField<>("");

    /* renamed from: d  reason: collision with root package name */
    private b f10725d = new b();

    /* renamed from: f  reason: collision with root package name */
    private TPIoTClientManager f10727f = (TPIoTClientManager) b.d.b.f.b.a(a.f(), TPIoTClientManager.class);

    public DeviceNameEditorViewModel(@NonNull Application application, TPCameraDeviceContext tPCameraDeviceContext) {
        super(application);
        String deviceIdMD5 = tPCameraDeviceContext.getDeviceIdMD5();
        this.f10724c = deviceIdMD5;
        this.f10726e = (CameraSettingRepository) e.c(deviceIdMD5, CameraSettingRepository.class);
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

    public void g() {
        CameraInfoCache cameraInfo = this.f10726e.x().getCameraInfo();
        this.f10723b.set(cameraInfo == null ? "" : cameraInfo.getName());
    }

    public q<Boolean> h(String str) {
        if (f(str)) {
            return this.f10727f.R3(this.f10724c, str);
        }
        return q.f0(Boolean.FALSE);
    }

    public void i(String str) {
        this.f10726e.x().getCameraInfo().setName(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.f10725d.dispose();
    }
}
