package com.tplink.iot.viewmodel.ipcamera.setting;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.R;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.RecordAudioRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.UpnpSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import com.tplink.libtpnetwork.cameranetwork.model.ComponentType;
import com.tplink.libtpnetwork.cameranetwork.model.LightFrequencyMode;
import io.reactivex.e0.b;
import io.reactivex.g0.g;
import io.reactivex.g0.j;
import io.reactivex.q;
import io.reactivex.t;

/* loaded from: classes3.dex */
public class AdvancedSettingViewModel extends AndroidViewModel {

    /* renamed from: d  reason: collision with root package name */
    public String f10678d;
    private CameraSettingRepository o;
    private RecordAudioRepository p;
    private UpnpSettingRepository q;
    private CommonCameraRepository r;
    public ObservableField<String> a = new ObservableField<>();

    /* renamed from: b  reason: collision with root package name */
    public ObservableField<String> f10676b = new ObservableField<>();

    /* renamed from: c  reason: collision with root package name */
    public ObservableField<String> f10677c = new ObservableField<>();

    /* renamed from: e  reason: collision with root package name */
    public ObservableBoolean f10679e = new ObservableBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    public ObservableBoolean f10680f = new ObservableBoolean(true);
    public ObservableBoolean g = new ObservableBoolean(false);
    public ObservableBoolean h = new ObservableBoolean(true);
    public ObservableBoolean i = new ObservableBoolean(false);
    public ObservableBoolean j = new ObservableBoolean(true);
    public ObservableBoolean k = new ObservableBoolean(false);
    public ObservableBoolean l = new ObservableBoolean(false);
    public ObservableBoolean m = new ObservableBoolean(false);
    private b n = new b();
    private MediatorLiveData<CameraComponent> s = new MediatorLiveData<>();
    public MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> t = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[LightFrequencyMode.values().length];
            a = iArr;
            try {
                iArr[LightFrequencyMode.AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[LightFrequencyMode.OFF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[LightFrequencyMode.FREQUENCY_50_HZ.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[LightFrequencyMode.FREQUENCY_60_HZ.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public AdvancedSettingViewModel(@NonNull Application application, TPCameraDeviceContext tPCameraDeviceContext) {
        super(application);
        this.f10678d = tPCameraDeviceContext.getDeviceIdMD5();
        this.o = (CameraSettingRepository) e.b(tPCameraDeviceContext, CameraSettingRepository.class);
        this.r = (CommonCameraRepository) e.b(tPCameraDeviceContext, CommonCameraRepository.class);
        this.p = (RecordAudioRepository) e.b(tPCameraDeviceContext, RecordAudioRepository.class);
        this.q = (UpnpSettingRepository) e.b(tPCameraDeviceContext, UpnpSettingRepository.class);
    }

    private void i() {
        this.f10679e.set(false);
        this.t.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(getApplication().getString(R.string.general_failed)));
    }

    private boolean k() {
        String deviceModel;
        BaseALIoTDevice I1 = TPIoTClientManager.I1(this.f10678d);
        if (!(I1 instanceof ALCameraDevice) || (deviceModel = ((ALCameraDevice) I1).getDeviceModel()) == null) {
            return false;
        }
        return deviceModel.contains("C310");
    }

    private boolean l(CameraComponent cameraComponent) {
        if (k()) {
            return false;
        }
        return cameraComponent.hasComponent(ComponentType.LDC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public /* synthetic */ t n(CameraComponent cameraComponent) throws Exception {
        this.g.set(cameraComponent.hasComponent(ComponentType.OSD));
        this.f10680f.set(cameraComponent.hasComponent(ComponentType.ACCOUNT));
        this.h.set(cameraComponent.hasComponent(ComponentType.LIGHT_FREQUENCY));
        this.i.set(cameraComponent.hasComponent(ComponentType.UPNPC));
        this.j.set(cameraComponent.hasComponent(ComponentType.PTZ));
        this.k.set(l(cameraComponent));
        this.l.set(cameraComponent.hasComponent(ComponentType.DIAGNOSE));
        this.m.set(cameraComponent.getComponent(ComponentType.AUDIO) >= 2);
        return q.d1(this.h.get() ? this.o.A() : q.f0(Boolean.TRUE), this.m.get() ? this.p.U1() : q.f0(Boolean.TRUE), this.i.get() ? this.q.T1() : q.f0(Boolean.TRUE), this.f10680f.get() ? this.o.M() : q.f0(Boolean.TRUE), a.a).E(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.c
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                AdvancedSettingViewModel.this.t((Boolean) obj);
            }
        }).C(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.e
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                AdvancedSettingViewModel.this.v((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public /* synthetic */ void p() throws Exception {
        this.f10679e.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public /* synthetic */ void t(Boolean bool) throws Exception {
        x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public /* synthetic */ void v(Throwable th) throws Exception {
        x();
        i();
    }

    public boolean f() {
        return this.o.x().getAccountInfo() != null;
    }

    public boolean g() {
        return this.o.x().getLightFrequencyMode() != null;
    }

    public boolean h() {
        return this.i.get();
    }

    public void j() {
        this.f10679e.set(true);
        this.n.b(this.r.K0().N(new j() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.d
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return AdvancedSettingViewModel.this.n((CameraComponent) obj);
            }
        }).y(new io.reactivex.g0.a() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.b
            @Override // io.reactivex.g0.a
            public final void run() {
                AdvancedSettingViewModel.this.p();
            }
        }).F0());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.n.d();
    }

    public void w() {
        this.r.K0().F0();
    }

    public void x() {
        RecordAudioRepository recordAudioRepository;
        UpnpSettingRepository upnpSettingRepository;
        LightFrequencyMode lightFrequencyMode = this.o.x().getLightFrequencyMode();
        int i = R.string.setting_off;
        if (lightFrequencyMode != null) {
            int i2 = a.a[this.o.x().getLightFrequencyMode().ordinal()];
            if (i2 == 1) {
                this.a.set(getApplication().getString(R.string.setting_auto));
            } else if (i2 == 2) {
                this.a.set(getApplication().getString(R.string.setting_off));
            } else if (i2 == 3) {
                this.a.set(getApplication().getString(R.string.setting_50hz));
            } else if (i2 == 4) {
                this.a.set(getApplication().getString(R.string.setting_60hz));
            }
        }
        if (this.i.get() && (upnpSettingRepository = this.q) != null) {
            this.f10676b.set(getApplication().getString(com.tplink.libtpnetwork.Utils.j.h(upnpSettingRepository.M1()) ? R.string.setting_on : R.string.setting_off));
        }
        if (this.m.get() && (recordAudioRepository = this.p) != null) {
            boolean h = com.tplink.libtpnetwork.Utils.j.h(recordAudioRepository.L1());
            ObservableField<String> observableField = this.f10677c;
            Application application = getApplication();
            if (h) {
                i = R.string.setting_on;
            }
            observableField.set(application.getString(i));
        }
    }
}
