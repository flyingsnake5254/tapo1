package com.tplink.iot.viewmodel.ipcamera.setting;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCDeviceRepository;
import com.tplink.libtpnetwork.Utils.f;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.bean.CameraAvatarInfo;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceAvatarFeatureInfo;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceFeatureInfo;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;
import com.tplink.libtpnetwork.cameranetwork.util.JsonUtils;
import io.reactivex.e0.b;
import java.io.File;

/* loaded from: classes3.dex */
public class LocateSettingViewModel extends AndroidViewModel {

    /* renamed from: b  reason: collision with root package name */
    private String f10766b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private ALCameraDevice f10767c;

    /* renamed from: e  reason: collision with root package name */
    private TCDeviceRepository f10769e;

    /* renamed from: f  reason: collision with root package name */
    private CameraSettingRepository f10770f;
    private TPCameraDeviceContext g;
    private TPIoTClientManager h;
    public ObservableBoolean a = new ObservableBoolean(false);

    /* renamed from: d  reason: collision with root package name */
    public MutableLiveData<a<j9>> f10768d = new MutableLiveData<>();
    private b i = new b();

    public LocateSettingViewModel(@NonNull Application application, TPCameraDeviceContext tPCameraDeviceContext) {
        super(application);
        this.f10766b = tPCameraDeviceContext.getDeviceIdMD5();
        this.f10767c = tPCameraDeviceContext.getCameraDevice();
        this.g = tPCameraDeviceContext;
        this.f10769e = (TCDeviceRepository) b.d.b.f.b.c(tPCameraDeviceContext.getTcAccountContext()).a(TCDeviceRepository.class);
        this.h = (TPIoTClientManager) b.d.b.f.b.a(tPCameraDeviceContext.getTcAccountContext(), TPIoTClientManager.class);
        this.f10770f = (CameraSettingRepository) e.c(this.f10766b, CameraSettingRepository.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public /* synthetic */ void i(String str) throws Exception {
        this.f10768d.postValue(new a<>(new j9(str, null, true)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void j(Boolean bool) throws Exception {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public /* synthetic */ void l(String str, String str2, String str3) {
        String concat = b.d.q.b.p.b.c(str).concat(File.separator).concat(str2).concat(str3).concat(".png");
        t(str, true, false, str3, concat);
        this.f10768d.postValue(new a<>(new j9(str3, concat, false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public /* synthetic */ void n(String str) throws Exception {
        this.f10768d.postValue(new a<>(new j9(str, null, true)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void o(ALCameraDevice aLCameraDevice, boolean z, String str, String str2) throws Exception {
        CameraAvatarInfo cameraAvatarInfo = aLCameraDevice.getCameraAvatarInfo();
        if (cameraAvatarInfo == null) {
            cameraAvatarInfo = new CameraAvatarInfo();
            aLCameraDevice.setCameraAvatarInfo(cameraAvatarInfo);
        }
        cameraAvatarInfo.setAvatarDefault(Boolean.valueOf(z));
        cameraAvatarInfo.setAvatarRemoteUrl(str);
        cameraAvatarInfo.setAvatarName(str2);
        cameraAvatarInfo.setAvatarNameModified(Boolean.FALSE);
    }

    private void s(final String str) {
        this.i.b(this.f10770f.x1(str).y(new io.reactivex.g0.a() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.e5
            @Override // io.reactivex.g0.a
            public final void run() {
                LocateSettingViewModel.this.i(str);
            }
        }).H0(g5.f10948c, h9.f10962c));
    }

    private void t(String str, boolean z, boolean z2, String str2, String str3) {
        ALCameraDevice cameraDevice = TPIoTClientManager.K1(str).getCameraDevice();
        if (cameraDevice != null) {
            CameraAvatarInfo cameraAvatarInfo = cameraDevice.getCameraAvatarInfo();
            if (cameraAvatarInfo == null) {
                cameraAvatarInfo = new CameraAvatarInfo();
                cameraDevice.setCameraAvatarInfo(cameraAvatarInfo);
            }
            cameraAvatarInfo.setAvatarName(str2);
            cameraAvatarInfo.setAvatarDefault(Boolean.valueOf(z2));
            cameraAvatarInfo.setAvatarNameModified(Boolean.TRUE);
            if (!z2) {
                cameraAvatarInfo.setAvatarRemoteUrl(str3);
            }
        }
    }

    private void w(final ALCameraDevice aLCameraDevice, final String str, final String str2, final boolean z) {
        String deviceId = aLCameraDevice.getDeviceId();
        String cloudUserName = this.g.getTcAccountContext().c().getCloudUserName();
        String token = this.g.getTcAccountContext().c().getToken();
        DeviceFeatureInfo deviceFeatureInfo = new DeviceFeatureInfo();
        deviceFeatureInfo.setLastUpdateTimestamp(Long.valueOf(System.currentTimeMillis()));
        deviceFeatureInfo.setDeviceAvatarFeatureInfo(new DeviceAvatarFeatureInfo(Boolean.valueOf(z), str));
        this.i.b(this.f10769e.X(cloudUserName, deviceId, JsonUtils.g(deviceFeatureInfo), token).C(io.reactivex.l0.a.c()).h(new io.reactivex.g0.a() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.f5
            @Override // io.reactivex.g0.a
            public final void run() {
                LocateSettingViewModel.this.n(str);
            }
        }).A(new io.reactivex.g0.a() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.d5
            @Override // io.reactivex.g0.a
            public final void run() {
                LocateSettingViewModel.o(ALCameraDevice.this, z, str2, str);
            }
        }, h9.f10962c));
    }

    public String f() {
        ALCameraDevice aLCameraDevice = this.f10767c;
        return aLCameraDevice != null ? aLCameraDevice.getDeviceLocation() : "";
    }

    public boolean g() {
        ALCameraDevice aLCameraDevice = this.f10767c;
        return aLCameraDevice != null && aLCameraDevice.isDefaultLocation();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.i.dispose();
    }

    public void p() {
        this.h.H3(this.f10766b).y();
    }

    public void r(String str, String str2, String str3) {
        ALCameraDevice aLCameraDevice = this.f10767c;
        if (aLCameraDevice == null || !aLCameraDevice.isFirmwareSupportIoTCloud()) {
            v(str, str2, str3);
        } else {
            s(str2);
        }
    }

    public void u(Context context, final String str, final String str2, String str3) {
        final String valueOf = String.valueOf(System.currentTimeMillis());
        b.d.q.b.p.b.i(context, str, str2, valueOf, null);
        new Handler().postDelayed(new Runnable() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.c5
            @Override // java.lang.Runnable
            public final void run() {
                LocateSettingViewModel.this.l(str, valueOf, str2);
            }
        }, 600L);
    }

    public void v(String str, String str2, String str3) {
        t(str, true, true, str2, null);
        ALCameraDevice cameraDevice = TPIoTClientManager.K1(str).getCameraDevice();
        if (cameraDevice == null || !f.j(cameraDevice.getDeviceIdMD5())) {
            this.f10768d.postValue(new a<>(new j9(str2, null, true)));
        } else {
            w(cameraDevice, str2, null, true);
        }
    }
}
