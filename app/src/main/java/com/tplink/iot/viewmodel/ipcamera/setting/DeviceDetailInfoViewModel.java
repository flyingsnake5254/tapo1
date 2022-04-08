package com.tplink.iot.viewmodel.ipcamera.setting;

import android.app.Application;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import b.d.s.a.a;
import com.tplink.iot.R;
import com.tplink.iot.Utils.z0.h;
import com.tplink.libtpmediastatistics.SSLClient;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.FirmwareRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.FirmwareManager;
import com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.u;
import com.tplink.libtpnetwork.cameranetwork.g4.l;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import com.tplink.libtpnetwork.cameranetwork.model.CameraInfoCache;
import com.tplink.libtpnetwork.cameranetwork.model.ComponentType;
import com.tplink.libtpnetwork.cameranetwork.model.LatestFirmwareInfo;
import com.tplink.libtpnetwork.cameranetwork.model.NetworkInfoCache;
import io.reactivex.e0.b;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.g0.j;
import io.reactivex.q;
import io.reactivex.t;
import org.eclipse.paho.client.mqttv3.DisconnectedBufferOptions;

/* loaded from: classes3.dex */
public class DeviceDetailInfoViewModel extends AndroidViewModel {
    private FirmwareManager A;
    @Nullable
    private ALCameraDevice B;

    /* renamed from: f  reason: collision with root package name */
    private String f10722f;
    public final ObservableBoolean s;
    private c w;
    private CameraSettingRepository x;
    private FirmwareRepository y;
    private CommonCameraRepository z;
    public ObservableField<String> a = new ObservableField<>("");

    /* renamed from: b  reason: collision with root package name */
    public ObservableBoolean f10718b = new ObservableBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    public ObservableField<Drawable> f10719c = new ObservableField<>();

    /* renamed from: d  reason: collision with root package name */
    public ObservableField<String> f10720d = new ObservableField<>();

    /* renamed from: e  reason: collision with root package name */
    public ObservableBoolean f10721e = new ObservableBoolean(true);
    public ObservableField<String> g = new ObservableField<>();
    public ObservableField<String> h = new ObservableField<>();
    public ObservableField<String> i = new ObservableField<>();
    public ObservableField<String> j = new ObservableField<>();
    public ObservableField<String> k = new ObservableField<>();
    public ObservableField<String> l = new ObservableField<>();
    public ObservableBoolean m = new ObservableBoolean();
    public String n = "";
    public ObservableBoolean o = new ObservableBoolean();
    public ObservableBoolean p = new ObservableBoolean(false);
    public ObservableBoolean q = new ObservableBoolean(false);
    public ObservableBoolean r = new ObservableBoolean(false);
    public ObservableBoolean t = new ObservableBoolean(false);
    public ObservableBoolean u = new ObservableBoolean(false);
    private b v = new b();

    public DeviceDetailInfoViewModel(@NonNull Application application, TPCameraDeviceContext tPCameraDeviceContext) {
        super(application);
        boolean z = false;
        ObservableBoolean observableBoolean = new ObservableBoolean(false);
        this.s = observableBoolean;
        this.f10722f = tPCameraDeviceContext.getDeviceIdMD5();
        this.B = tPCameraDeviceContext.getCameraDevice();
        this.p.set(tPCameraDeviceContext.getCameraDevice() != null && tPCameraDeviceContext.getCameraDevice().isFirmwareSupportIoTCloud());
        this.x = (CameraSettingRepository) e.c(this.f10722f, CameraSettingRepository.class);
        this.y = (FirmwareRepository) e.c(this.f10722f, FirmwareRepository.class);
        this.z = (CommonCameraRepository) e.c(this.f10722f, CommonCameraRepository.class);
        this.A = (FirmwareManager) b.d.b.f.b.a(a.f(), FirmwareManager.class);
        ALCameraDevice cameraDevice = TPIoTClientManager.K1(this.f10722f).getCameraDevice();
        if (cameraDevice != null && cameraDevice.isUserRoleTypeDevice()) {
            z = true;
        }
        observableBoolean.set(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A */
    public /* synthetic */ void B(Boolean bool) throws Exception {
        NetworkInfoCache networkInfo = this.x.x().getNetworkInfo();
        if (networkInfo != null) {
            this.t.set(o(networkInfo.getLinkType()));
            this.h.set(networkInfo.getSsid());
            this.f10719c.set(l(networkInfo.getRssi()));
            this.f10720d.set(m(networkInfo.getRssiValue()));
        }
        this.i.set(this.x.x().getIpAddress());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C */
    public /* synthetic */ t D(CameraComponent cameraComponent) throws Exception {
        return this.x.K(cameraComponent).E(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.v1
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                DeviceDetailInfoViewModel.this.F((Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E */
    public /* synthetic */ void F(Boolean bool) throws Exception {
        CameraInfoCache cameraInfo = this.x.x().getCameraInfo();
        if (cameraInfo != null) {
            this.a.set(cameraInfo.getName());
            this.g.set(h.l(cameraInfo.getModel()));
            this.j.set(cameraInfo.getMac());
            this.k.set(cameraInfo.getHardwareVer());
            if (cameraInfo.getSoftwareVer() != null) {
                this.n = cameraInfo.getSoftwareVer();
                this.l.set(cameraInfo.getSoftwareVer().split(SSLClient.WHITE_SPACE)[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G */
    public /* synthetic */ void H(LatestFirmwareInfo latestFirmwareInfo) throws Exception {
        b.d.w.c.a.e("FirmwareManager", "CameraSetting FirmwareVersion: " + latestFirmwareInfo.getVersion());
        this.A.z(this.f10722f, latestFirmwareInfo);
        if (latestFirmwareInfo.getVersion() != null) {
            this.f10718b.set(true);
        }
    }

    private void I() {
        u g = this.A.g(this.f10722f);
        if (g != null) {
            this.f10718b.set(g.e());
        }
        this.w = this.y.v().x0(new l(1, DisconnectedBufferOptions.DISCONNECTED_BUFFER_SIZE_DEFAULT)).H0(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.r1
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                DeviceDetailInfoViewModel.this.H((LatestFirmwareInfo) obj);
            }
        }, h9.f10962c);
    }

    private q<Boolean> g() {
        if (this.q.get()) {
            return this.y.t().g0(n1.f11012c);
        }
        return q.f0(Boolean.TRUE);
    }

    private void k() {
        u g = this.A.g(this.f10722f);
        if (g != null) {
            this.f10718b.set(g.e());
        }
        this.u.set(false);
        q.e1(this.x.B(), this.x.z(), g(), o1.a).F(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.q1
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                DeviceDetailInfoViewModel.this.v((c) obj);
            }
        }).y(new io.reactivex.g0.a() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.u1
            @Override // io.reactivex.g0.a
            public final void run() {
                DeviceDetailInfoViewModel.this.x();
            }
        }).C(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.m1
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                DeviceDetailInfoViewModel.this.z((Throwable) obj);
            }
        }).E(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.s1
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                DeviceDetailInfoViewModel.this.B((Boolean) obj);
            }
        }).F0();
        CameraInfoCache cameraInfo = this.x.x().getCameraInfo();
        if (cameraInfo == null) {
            this.v.b(this.z.K0().N(new j() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.t1
                @Override // io.reactivex.g0.j
                public final Object apply(Object obj) {
                    return DeviceDetailInfoViewModel.this.D((CameraComponent) obj);
                }
            }).F0());
        } else {
            this.a.set(cameraInfo.getName());
            this.g.set(h.l(cameraInfo.getModel()));
            this.j.set(cameraInfo.getMac());
            this.k.set(cameraInfo.getHardwareVer());
            if (cameraInfo.getSoftwareVer() != null) {
                this.n = cameraInfo.getSoftwareVer();
                this.l.set(cameraInfo.getSoftwareVer().split(SSLClient.WHITE_SPACE)[0]);
            }
        }
        if (this.r.get()) {
            I();
        }
    }

    private Drawable l(String str) {
        if (str == null) {
            return null;
        }
        int parseInt = Integer.parseInt(str);
        if (parseInt == 1) {
            return getApplication().getResources().getDrawable(R.mipmap.wifi_1);
        }
        if (parseInt == 2 || parseInt == 3) {
            return getApplication().getResources().getDrawable(R.mipmap.wifi_2);
        }
        if (parseInt != 4) {
            return null;
        }
        return getApplication().getResources().getDrawable(R.mipmap.wifi_3);
    }

    private String m(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str + "(RSSI)";
    }

    private void n() {
        ALCameraDevice aLCameraDevice = this.B;
        if (aLCameraDevice != null) {
            this.a.set(aLCameraDevice.getDeviceAlias());
            this.g.set(h.l(this.B.getModel()));
            this.j.set(this.B.getMacAddress());
            this.l.set(this.B.getSoftwareVersion().split(SSLClient.WHITE_SPACE)[0]);
            this.k.set(this.B.getHardwareVersion());
        }
    }

    private boolean o(String str) {
        return "wifi".equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public /* synthetic */ void s(CameraComponent cameraComponent) throws Exception {
        this.r.set(cameraComponent.hasComponent(ComponentType.FIRMWARE));
        this.q.set(cameraComponent.isSupportFwAutoUpdate());
        if (this.o.get()) {
            k();
        } else {
            n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public /* synthetic */ void v(c cVar) throws Exception {
        this.u.set(true);
        this.v.b(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w */
    public /* synthetic */ void x() throws Exception {
        this.u.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y */
    public /* synthetic */ void z(Throwable th) throws Exception {
        this.u.set(false);
        th.printStackTrace();
    }

    public void f() {
        if (!this.f10721e.get() || TextUtils.isEmpty(this.f10720d.get())) {
            this.f10721e.set(true);
        } else {
            this.f10721e.set(false);
        }
    }

    public ALCameraDevice h() {
        return this.B;
    }

    public void i() {
        this.v.b(this.z.K0().G0(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.p1
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                DeviceDetailInfoViewModel.this.s((CameraComponent) obj);
            }
        }));
    }

    public String j() {
        return this.f10722f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        c cVar = this.w;
        if (cVar != null && !cVar.isDisposed()) {
            this.w.dispose();
        }
        b bVar = this.v;
        if (bVar != null && !bVar.isDisposed()) {
            this.v.dispose();
        }
    }
}
