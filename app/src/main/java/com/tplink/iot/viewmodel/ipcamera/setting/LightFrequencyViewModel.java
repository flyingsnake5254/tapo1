package com.tplink.iot.viewmodel.ipcamera.setting;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.AndroidViewModel;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository;

/* loaded from: classes3.dex */
public class LightFrequencyViewModel extends AndroidViewModel {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public ObservableBoolean f10754b = new ObservableBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    public CameraSettingRepository f10755c;

    public LightFrequencyViewModel(@NonNull Application application, TPCameraDeviceContext tPCameraDeviceContext) {
        super(application);
        String deviceIdMD5 = tPCameraDeviceContext.getDeviceIdMD5();
        this.a = deviceIdMD5;
        this.f10755c = (CameraSettingRepository) e.c(deviceIdMD5, CameraSettingRepository.class);
    }
}
