package com.tplink.iot.viewmodel.ipcamera.setting;

import android.app.Activity;
import android.app.Application;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.R;
import com.tplink.iot.Utils.v0.d;
import com.tplink.iot.Utils.x0.g;
import com.tplink.iot.Utils.z0.h;
import com.tplink.iot.cloud.bean.cloudvideo.common.DeviceCloudProduct;
import com.tplink.iot.cloud.bean.cloudvideo.result.TrialResult;
import com.tplink.iot.view.tapocare.TrialDialogActivity;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.CloudVideoRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCDeviceRepository;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.business.model.o;
import com.tplink.libtpnetwork.cameranetwork.business.repo.AIDetectionRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.AlarmSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.AreaIntrusionRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.FirmwareRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.LineCrossingDetectionRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.MotionDetectionRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.NightVisionRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.TamperDetectionRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.FirmwareManager;
import com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.u;
import com.tplink.libtpnetwork.cameranetwork.g4.l;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import com.tplink.libtpnetwork.cameranetwork.model.ComponentType;
import com.tplink.libtpnetwork.cameranetwork.model.LatestFirmwareInfo;
import com.tplink.libtpnetwork.cameranetwork.model.NightVisionModeType;
import com.tplink.libtpnetwork.cameranetwork.model.ResolutionType;
import com.tplink.libtpnetwork.cameranetwork.model.SdCardInfoCache;
import com.tplink.libtpnetwork.cameranetwork.model.SdCardStatus;
import com.tplink.libtpnetwork.cameranetwork.model.SettingCompositeV2;
import com.tplink.libtpnetwork.cameranetwork.model.SettingsData;
import io.reactivex.e0.b;
import io.reactivex.e0.c;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.eclipse.paho.client.mqttv3.DisconnectedBufferOptions;

/* loaded from: classes3.dex */
public class DeviceSettingNewViewModel extends AndroidViewModel {
    public c d0;
    private TCDeviceRepository f0;
    private String g0;
    @Nullable
    public ALCameraDevice h0;
    public boolean i0;
    private CameraSettingRepository j0;
    private FirmwareRepository k0;
    private CommonCameraRepository l0;
    private CloudVideoRepository m0;
    private LineCrossingDetectionRepository n0;
    private AreaIntrusionRepository o0;
    private TamperDetectionRepository p0;
    private MotionDetectionRepository q0;
    private AlarmSettingRepository r0;
    private NightVisionRepository s0;
    private AIDetectionRepository t0;
    private FirmwareManager u0;
    private TPIoTClientManager v0;
    private String y0;
    public final ObservableBoolean z;
    private final String a = DeviceSettingNewViewModel.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public ObservableBoolean f10728b = new ObservableBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    public ObservableBoolean f10729c = new ObservableBoolean(false);

    /* renamed from: d  reason: collision with root package name */
    public ObservableField<String> f10730d = new ObservableField<>();

    /* renamed from: e  reason: collision with root package name */
    public ObservableField<String> f10731e = new ObservableField<>();

    /* renamed from: f  reason: collision with root package name */
    public ObservableField<String> f10732f = new ObservableField<>();
    public ObservableField<String> g = new ObservableField<>();
    public ObservableField<String> h = new ObservableField<>();
    public ObservableBoolean i = new ObservableBoolean(false);
    public ObservableBoolean j = new ObservableBoolean(false);
    public ObservableBoolean k = new ObservableBoolean(false);
    public ObservableBoolean l = new ObservableBoolean(false);
    public ObservableField<String> m = new ObservableField<>();
    public ObservableBoolean n = new ObservableBoolean(false);
    public ObservableBoolean o = new ObservableBoolean(false);
    public ObservableBoolean p = new ObservableBoolean(false);
    public ObservableBoolean q = new ObservableBoolean(false);
    public ObservableBoolean r = new ObservableBoolean(false);
    public ObservableBoolean s = new ObservableBoolean(false);
    public ObservableBoolean t = new ObservableBoolean(false);
    public ObservableBoolean u = new ObservableBoolean(false);
    public ObservableField<String> v = new ObservableField<>();
    public ObservableField<String> w = new ObservableField<>();
    public ObservableField<String> x = new ObservableField<>();
    public ObservableBoolean y = new ObservableBoolean(true);
    public final ObservableField<String> A = new ObservableField<>();
    private b B = new b();
    private MediatorLiveData<com.tplink.libtpnetwork.cameranetwork.business.model.b> C = new MediatorLiveData<>();
    private MediatorLiveData<o> D = new MediatorLiveData<>();
    public MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> E = new MutableLiveData<>();
    public MutableLiveData<Boolean> F = new MutableLiveData<>();
    public MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> G = new MutableLiveData<>();
    public MutableLiveData<Boolean> H = new MutableLiveData<>();
    public ObservableBoolean I = new ObservableBoolean(false);
    public ObservableBoolean J = new ObservableBoolean();
    public ObservableBoolean K = new ObservableBoolean(false);
    public ObservableBoolean L = new ObservableBoolean(false);
    public ObservableBoolean M = new ObservableBoolean(false);
    public ObservableBoolean N = new ObservableBoolean(false);
    public ObservableBoolean O = new ObservableBoolean(false);
    public ObservableBoolean P = new ObservableBoolean(false);
    public ObservableBoolean Q = new ObservableBoolean(false);
    public ObservableBoolean R = new ObservableBoolean(false);
    public ObservableBoolean S = new ObservableBoolean(false);
    public ObservableBoolean T = new ObservableBoolean(false);
    public ObservableBoolean U = new ObservableBoolean(false);
    public ObservableBoolean V = new ObservableBoolean(false);
    public ObservableBoolean W = new ObservableBoolean(false);
    public ObservableBoolean X = new ObservableBoolean(false);
    public ObservableBoolean Y = new ObservableBoolean(false);
    public ObservableBoolean Z = new ObservableBoolean(false);
    public ObservableBoolean a0 = new ObservableBoolean(false);
    public ObservableBoolean b0 = new ObservableBoolean(false);
    public ObservableBoolean c0 = new ObservableBoolean(false);
    public ObservableBoolean e0 = new ObservableBoolean(false);
    private boolean w0 = true;
    private boolean x0 = true;
    private long z0 = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f10733b;

        static {
            int[] iArr = new int[SdCardStatus.values().length];
            f10733b = iArr;
            try {
                iArr[SdCardStatus.FULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10733b[SdCardStatus.INSUFFICIENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10733b[SdCardStatus.NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10733b[SdCardStatus.OFFLINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10733b[SdCardStatus.FORMATTING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10733b[SdCardStatus.UNFORMATTED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f10733b[SdCardStatus.ABNORMAL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr2 = new int[NightVisionModeType.values().length];
            a = iArr2;
            try {
                iArr2[NightVisionModeType.SMART.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[NightVisionModeType.INFRARED.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[NightVisionModeType.FULL_COLOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public DeviceSettingNewViewModel(@NonNull Application application, TPCameraDeviceContext tPCameraDeviceContext) {
        super(application);
        boolean z = false;
        ObservableBoolean observableBoolean = new ObservableBoolean(false);
        this.z = observableBoolean;
        String deviceIdMD5 = tPCameraDeviceContext.getDeviceIdMD5();
        this.g0 = deviceIdMD5;
        this.y0 = j(deviceIdMD5);
        ALCameraDevice cameraDevice = TPIoTClientManager.K1(this.g0).getCameraDevice();
        this.h0 = cameraDevice;
        this.i0 = cameraDevice != null && cameraDevice.getCloudIoTDevice() == null;
        ObservableBoolean observableBoolean2 = this.f10729c;
        ALCameraDevice aLCameraDevice = this.h0;
        observableBoolean2.set(aLCameraDevice != null && aLCameraDevice.isSupportIoTCloud());
        ObservableBoolean observableBoolean3 = this.f10728b;
        ALCameraDevice aLCameraDevice2 = this.h0;
        observableBoolean3.set(aLCameraDevice2 != null && aLCameraDevice2.isFirmwareSupportIoTCloud());
        this.j0 = (CameraSettingRepository) e.c(this.g0, CameraSettingRepository.class);
        this.k0 = (FirmwareRepository) e.c(this.g0, FirmwareRepository.class);
        this.l0 = (CommonCameraRepository) e.c(this.g0, CommonCameraRepository.class);
        this.n0 = (LineCrossingDetectionRepository) e.c(this.g0, LineCrossingDetectionRepository.class);
        this.o0 = (AreaIntrusionRepository) e.c(this.g0, AreaIntrusionRepository.class);
        this.p0 = (TamperDetectionRepository) e.c(this.g0, TamperDetectionRepository.class);
        this.q0 = (MotionDetectionRepository) e.c(this.g0, MotionDetectionRepository.class);
        this.r0 = (AlarmSettingRepository) e.c(this.g0, AlarmSettingRepository.class);
        this.s0 = (NightVisionRepository) e.c(this.g0, NightVisionRepository.class);
        this.t0 = (AIDetectionRepository) e.c(this.g0, AIDetectionRepository.class);
        com.tplink.cloud.context.b f2 = b.d.s.a.a.f();
        this.f0 = (TCDeviceRepository) b.d.b.f.b.c(f2).a(TCDeviceRepository.class);
        this.v0 = (TPIoTClientManager) b.d.b.f.b.a(f2, TPIoTClientManager.class);
        this.u0 = (FirmwareManager) b.d.b.f.b.a(b.d.s.a.a.f(), FirmwareManager.class);
        this.X.set(d.c(this.g0));
        this.m0 = (CloudVideoRepository) b.d.b.f.b.c(f2).a(CloudVideoRepository.class);
        ALCameraDevice cameraDevice2 = TPIoTClientManager.K1(this.g0).getCameraDevice();
        if (cameraDevice2 != null && cameraDevice2.isUserRoleTypeDevice()) {
            z = true;
        }
        observableBoolean.set(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B */
    public /* synthetic */ void C() throws Exception {
        this.c0.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B0 */
    public /* synthetic */ void C0() throws Exception {
        this.c0.set(false);
        this.F.postValue(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D0 */
    public /* synthetic */ void E0(c cVar) throws Exception {
        this.c0.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F */
    public /* synthetic */ void G(Throwable th) throws Exception {
        e1(R.string.general_failed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F0 */
    public /* synthetic */ void G0(Boolean bool) throws Exception {
        h();
        D();
        l9.a().b(this.g0).V();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H */
    public /* synthetic */ void I(c cVar) throws Exception {
        this.c0.set(true);
        this.B.b(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H0 */
    public /* synthetic */ void I0(Throwable th) throws Exception {
        this.c0.set(false);
        e1(R.string.general_failed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J */
    public /* synthetic */ void K() throws Exception {
        this.c0.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J0 */
    public /* synthetic */ void K0(Boolean bool) throws Exception {
        if (!TextUtils.isEmpty(this.g0)) {
            g.s(this.g0);
        }
        D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L */
    public /* synthetic */ void M(CameraComponent cameraComponent, SettingCompositeV2 settingCompositeV2) throws Exception {
        if (settingCompositeV2 != null) {
            if (settingCompositeV2.getLensMaskInfo() != null) {
                this.q.set("on".equals(settingCompositeV2.getLensMaskInfo().getEnabled()));
                if (cameraComponent.getComponent(ComponentType.LEN_MASK) == 2) {
                    this.r.set(false);
                } else {
                    this.r.set(this.q.get());
                }
            }
            if (settingCompositeV2.getMotionDetectionInfo() != null) {
                this.q0.b0(settingCompositeV2.getMotionDetectionInfo());
            }
            if (settingCompositeV2.getAlarmInfo() != null) {
                this.r0.P("on".equals(settingCompositeV2.getAlarmInfo().getEnabled()));
            }
            if (cameraComponent.isSupportLineCrossingDetection() && settingCompositeV2.getLineCrossingDetectionInfo() != null) {
                this.n0.G(settingCompositeV2.getLineCrossingDetectionInfo());
            }
            if (cameraComponent.isSupportIntrusionDetection() && settingCompositeV2.getIntrusionDetectionInfo() != null) {
                this.o0.F(settingCompositeV2.getIntrusionDetectionInfo());
            }
            if (cameraComponent.isSupportTamperDetection() && settingCompositeV2.getTamperDetectConfig() != null) {
                this.p0.x(settingCompositeV2.getTamperDetectConfig());
            }
            if (cameraComponent.isSupportNightVision()) {
                if (settingCompositeV2.getNightVisionCapability() != null) {
                    this.s0.E(settingCompositeV2.getNightVisionCapability());
                }
                cameraComponent.isSupportWhiteLampConfig();
            }
            if (settingCompositeV2.getRecordPlanInfo() != null) {
                this.j0.G1(settingCompositeV2.getRecordPlanInfo());
            }
            if (cameraComponent.isSupportBabyCry() && settingCompositeV2.getBabyCryDetectionInfo() != null) {
                this.t0.z(settingCompositeV2.getBabyCryDetectionInfo());
            }
            if (cameraComponent.isSupportPersonDetection() && settingCompositeV2.getHumanRecognitionInfo() != null) {
                this.t0.A(settingCompositeV2.getHumanRecognitionInfo());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L0 */
    public /* synthetic */ void M0(Throwable th) throws Exception {
        this.c0.set(false);
        e1(R.string.general_failed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N0 */
    public /* synthetic */ void O0(c cVar) throws Exception {
        this.c0.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O */
    public /* synthetic */ void P(CameraComponent cameraComponent) throws Exception {
        this.P.set(cameraComponent.hasComponent(ComponentType.ALERT));
        this.M.set(cameraComponent.hasComponent(ComponentType.RECORD));
        this.O.set(cameraComponent.hasComponent(ComponentType.DETECTION));
        this.L.set(cameraComponent.hasComponent(ComponentType.SD_CARD));
        this.S.set(cameraComponent.hasComponent(ComponentType.TIME_ZONE));
        this.U.set(cameraComponent.hasComponent(ComponentType.VIDEO_ROTATION));
        this.K.set(cameraComponent.hasComponent(ComponentType.SYSTEM));
        this.N.set(cameraComponent.hasComponent(ComponentType.LED));
        this.M.set(true);
        this.a0.set(cameraComponent.getComponent(ComponentType.VIDEO) >= 2);
        this.Z.set(cameraComponent.hasComponent(ComponentType.DEVICE_SHARE));
        this.V.set(cameraComponent.hasComponent(ComponentType.BLOCK_ZONE));
        this.W.set(cameraComponent.isSupportMsgPush());
        this.Q.set(cameraComponent.isSupportNightVision());
        this.R.set(cameraComponent.isSupportWhiteLampConfig());
        if (cameraComponent.hasComponent(ComponentType.FIRMWARE)) {
            this.T.set(true);
            d1();
        }
        u(cameraComponent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P0 */
    public /* synthetic */ void Q0() throws Exception {
        this.c0.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q */
    public /* synthetic */ void R(Throwable th) throws Exception {
        th.printStackTrace();
        if (this.w0) {
            e1(R.string.general_failed);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void R0(Boolean bool) throws Exception {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S0 */
    public /* synthetic */ void T0(Throwable th) throws Exception {
        e1(R.string.general_failed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T */
    public /* synthetic */ void U() throws Exception {
        this.c0.set(false);
        if (this.w0) {
            this.w0 = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void U0(com.tplink.libtpnetwork.cameranetwork.business.model.b bVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V */
    public /* synthetic */ void W(Boolean bool) throws Exception {
        r();
        SettingsData x = this.j0.x();
        if (this.N.get()) {
            this.k.set(x.isLedEnable());
        }
        if (this.U.get()) {
            this.j.set(x.getImageFlipEnable());
        }
        this.m.set(getApplication().getString(x.isRebootEnable() ? R.string.common_on : R.string.common_off));
        if (this.S.get()) {
            this.g.set(x.getTimezone());
        }
        if (x.getCameraInfo() != null) {
            this.f10730d.set(x.getCameraInfo().getName());
            this.f10731e.set(h.l(x.getCameraInfo().getModel()));
        }
        if (this.N.get()) {
            this.o.set(true);
        }
        m1();
        this.n.set(true);
        this.s.set(true);
        this.p.set(true);
        if (this.a0.get()) {
            n1(x);
        }
        q1(x);
        p1();
        this.Y.set(h.b(ComponentType.BLOCK_ZONE, this.g0));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void V0(o oVar) {
    }

    private void W0(boolean z) {
        g.e(this.g0, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X */
    public /* synthetic */ void Y(DeviceCloudProduct deviceCloudProduct) throws Exception {
        if (deviceCloudProduct != null) {
            TrialResult trial = deviceCloudProduct.getTrial();
            if (deviceCloudProduct.getTrialQualified() && !h.s(this.g0)) {
                this.b0.set(true);
                this.i.set(false);
                this.h.set(String.format(getApplication().getString(R.string.tapo_care_trial_close_tip), "30"));
            } else if (trial != null && "active".equals(trial.getStatus())) {
                this.b0.set(true);
                this.i.set(true);
                long endTime = (trial.getEndTime() - deviceCloudProduct.getTimestamp()) / 86400000;
                this.z0 = endTime;
                if (endTime > 1) {
                    ObservableField<String> observableField = this.h;
                    Resources resources = getApplication().getResources();
                    observableField.set(resources.getString(R.string.tapo_care_trial_open_tip2, this.z0 + ""));
                    return;
                }
                ObservableField<String> observableField2 = this.h;
                Resources resources2 = getApplication().getResources();
                observableField2.set(resources2.getString(R.string.tapo_care_trial_open_tip, this.z0 + ""));
            }
        }
    }

    private void X0(boolean z) {
        g.g(this.g0, z);
    }

    private void Y0(boolean z) {
        g.f(this.g0, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void Z(Throwable th) throws Exception {
    }

    private void Z0(ALCameraDevice aLCameraDevice) {
        g.t(aLCameraDevice.getDeviceIdMD5());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a0 */
    public /* synthetic */ void b0(DeviceCloudProduct deviceCloudProduct) throws Exception {
        if (deviceCloudProduct != null) {
            TrialResult trial = deviceCloudProduct.getTrial();
            if (deviceCloudProduct.getTrialQualified() && !h.s(this.g0)) {
                this.b0.set(true);
                this.i.set(false);
                this.h.set(String.format(getApplication().getString(R.string.tapo_care_trial_close_tip), "30"));
            } else if (trial != null && "active".equals(trial.getStatus())) {
                this.b0.set(true);
                this.i.set(true);
                long endTime = (trial.getEndTime() - deviceCloudProduct.getTimestamp()) / 86400000;
                this.z0 = endTime;
                if (endTime > 1) {
                    ObservableField<String> observableField = this.h;
                    Resources resources = getApplication().getResources();
                    observableField.set(resources.getString(R.string.tapo_care_trial_open_tip2, this.z0 + ""));
                    return;
                }
                ObservableField<String> observableField2 = this.h;
                Resources resources2 = getApplication().getResources();
                observableField2.set(resources2.getString(R.string.tapo_care_trial_open_tip, this.z0 + ""));
            } else if (trial != null && trial.getRemainTime() == 0) {
                this.i.set(false);
                this.b0.set(false);
                e1(R.string.cancel_trial_tip);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c0(Throwable th) throws Exception {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d0 */
    public /* synthetic */ void e0(c cVar) throws Exception {
        this.c0.set(true);
        this.n.set(false);
    }

    private void d1() {
        u g = this.u0.g(this.g0);
        if (g != null) {
            this.t.set(g.e());
        }
        this.d0 = this.k0.u().x0(new l(1, DisconnectedBufferOptions.DISCONNECTED_BUFFER_SIZE_DEFAULT)).H0(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.g3
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                DeviceSettingNewViewModel.this.A0((LatestFirmwareInfo) obj);
            }
        }, h9.f10962c);
    }

    private void e1(@StringRes int i) {
        f1(getApplication().getResources().getString(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f0 */
    public /* synthetic */ void g0() throws Exception {
        this.c0.set(false);
        this.n.set(true);
    }

    private void f1(String str) {
        this.E.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g1 */
    public void D() {
        this.B.b(q.W0(3L, TimeUnit.SECONDS).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).y(new io.reactivex.g0.a() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.z1
            @Override // io.reactivex.g0.a
            public final void run() {
                DeviceSettingNewViewModel.this.C0();
            }
        }).F0());
    }

    private void h() {
        this.v0.e3(this.g0).y();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void h0(Boolean bool) throws Exception {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i0 */
    public /* synthetic */ void j0(Throwable th) throws Exception {
        ObservableBoolean observableBoolean = this.j;
        observableBoolean.set(!observableBoolean.get());
        e1(R.string.general_failed);
    }

    private String j(String str) {
        TPCameraDeviceContext K1;
        ALCameraDevice cameraDevice;
        if (str == null || (K1 = TPIoTClientManager.K1(str)) == null || (cameraDevice = K1.getCameraDevice()) == null || cameraDevice.getDeviceId() == null) {
            return null;
        }
        return cameraDevice.getDeviceId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k0 */
    public /* synthetic */ void l0(c cVar) throws Exception {
        this.c0.set(true);
    }

    private void k1() {
        this.c0.set(true);
        this.B.b(this.v0.z3(this.g0).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).H0(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.w2
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                DeviceSettingNewViewModel.this.K0((Boolean) obj);
            }
        }, new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.c3
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                DeviceSettingNewViewModel.this.M0((Throwable) obj);
            }
        }));
    }

    private q<Boolean> m(final CameraComponent cameraComponent) {
        return this.j0.L(cameraComponent).E(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.b3
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                DeviceSettingNewViewModel.this.M(cameraComponent, (SettingCompositeV2) obj);
            }
        }).g0(t2.f11084c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m0 */
    public /* synthetic */ void n0() throws Exception {
        this.c0.set(false);
    }

    private void m1() {
        if (this.M.get()) {
            this.l.set(this.j0.T() && this.u.get());
        }
    }

    private int n(ResolutionType resolutionType) {
        return resolutionType == ResolutionType.HD_4M ? R.string.video_quality_4mp : resolutionType == ResolutionType.HD_3M ? R.string.video_quality_3mp : resolutionType == ResolutionType.HD_1080P ? R.string.video_quality_1080p : (resolutionType != ResolutionType.HD_720P && resolutionType == ResolutionType.VGA_360P) ? R.string.video_quality_360p : R.string.video_quality_720p;
    }

    private void n1(SettingsData settingsData) {
        this.A.set(getApplication().getString(n(settingsData.getResolutionType())));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void o0(Boolean bool) throws Exception {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p0 */
    public /* synthetic */ void q0(Throwable th) throws Exception {
        ObservableBoolean observableBoolean = this.k;
        observableBoolean.set(!observableBoolean.get());
        e1(R.string.general_failed);
    }

    private void p1() {
        String str;
        boolean R = this.j0.R();
        boolean y = this.r0.y();
        if (R && y) {
            str = getApplication().getString(R.string.setting_on);
        } else if (y || !R) {
            str = getApplication().getString(R.string.setting_off);
        } else {
            str = getApplication().getString(R.string.setting_detection_only);
        }
        this.v.set(str);
    }

    private void q1(SettingsData settingsData) {
        if (this.Q.get()) {
            this.s0.F(settingsData.getImageFlip());
            if (settingsData.getImageFlip() != null && settingsData.getImageFlip().getNightVisionModeType() != null) {
                int i = a.a[settingsData.getImageFlip().getNightVisionModeType().ordinal()];
                if (i == 1) {
                    this.w.set(getApplication().getString(R.string.camera_setting_night_vision_smart));
                } else if (i == 2) {
                    this.w.set(getApplication().getString(R.string.camera_setting_night_vision_infrared));
                } else if (i == 3) {
                    this.w.set(getApplication().getString(R.string.camera_setting_night_vision_full_color));
                }
            }
        }
    }

    private void r() {
        SdCardInfoCache sdCardInfoCache;
        if (this.L.get() && (sdCardInfoCache = this.j0.x().getSdCardInfoCache()) != null) {
            SdCardStatus status = sdCardInfoCache.getStatus();
            boolean z = false;
            this.y.set(status != SdCardStatus.OFFLINE);
            if (status != null) {
                switch (a.f10733b[status.ordinal()]) {
                    case 1:
                    case 2:
                        this.x.set(getApplication().getString(R.string.setting_storage_lack));
                        break;
                    case 3:
                        this.x.set(getApplication().getString(R.string.device_setting_good));
                        break;
                    case 4:
                        this.x.set(getApplication().getString(R.string.setting_no_sdcard));
                        break;
                    case 5:
                        this.x.set(getApplication().getString(R.string.device_setting_formatting));
                        break;
                    case 6:
                        this.x.set(getApplication().getString(R.string.setting_storage_unformatted));
                        break;
                    case 7:
                        this.x.set(getApplication().getString(R.string.setting_storage_unidentified));
                        break;
                }
                ObservableBoolean observableBoolean = this.u;
                if (status == SdCardStatus.NORMAL) {
                    z = true;
                }
                observableBoolean.set(z);
                if (status == SdCardStatus.FULL && sdCardInfoCache.getLoopEnable()) {
                    this.x.set(getApplication().getString(R.string.device_setting_good));
                    this.u.set(true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r0 */
    public /* synthetic */ void s0(c cVar) throws Exception {
        this.c0.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t0 */
    public /* synthetic */ void u0() throws Exception {
        this.c0.set(false);
    }

    private void u(CameraComponent cameraComponent) {
        this.B.b(q.f1(this.j0.K(cameraComponent), m(cameraComponent), j2.f10972c).y(new io.reactivex.g0.a() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.l2
            @Override // io.reactivex.g0.a
            public final void run() {
                DeviceSettingNewViewModel.this.U();
            }
        }).H0(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.k2
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                DeviceSettingNewViewModel.this.W((Boolean) obj);
            }
        }, new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.i2
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                DeviceSettingNewViewModel.this.R((Throwable) obj);
            }
        }));
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v0 */
    public /* synthetic */ void w0(Boolean bool) throws Exception {
        Y0(this.l.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x0 */
    public /* synthetic */ void y0(Throwable th) throws Exception {
        ObservableBoolean observableBoolean = this.l;
        observableBoolean.set(!observableBoolean.get());
        e1(R.string.general_failed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public /* synthetic */ void A(c cVar) throws Exception {
        this.c0.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z0 */
    public /* synthetic */ void A0(LatestFirmwareInfo latestFirmwareInfo) throws Exception {
        b.d.w.c.a.e("FirmwareManager", "CameraSetting FirmwareVersion: " + latestFirmwareInfo.getVersion());
        this.u0.z(this.g0, latestFirmwareInfo);
        if (latestFirmwareInfo.getVersion() != null) {
            this.t.set(true);
        }
    }

    public void a1() {
        if (this.n.get()) {
            X0(this.j.get());
            this.B.b(this.j0.z1(this.j.get()).F(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.a3
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    DeviceSettingNewViewModel.this.e0((c) obj);
                }
            }).y(new io.reactivex.g0.a() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.p2
                @Override // io.reactivex.g0.a
                public final void run() {
                    DeviceSettingNewViewModel.this.g0();
                }
            }).H0(k3.f10981c, new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.s2
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    DeviceSettingNewViewModel.this.j0((Throwable) obj);
                }
            }));
        }
    }

    public void b1() {
        if (this.o.get()) {
            W0(this.k.get());
            this.B.b(this.j0.A1(this.k.get()).F(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.d3
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    DeviceSettingNewViewModel.this.l0((c) obj);
                }
            }).y(new io.reactivex.g0.a() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.f2
                @Override // io.reactivex.g0.a
                public final void run() {
                    DeviceSettingNewViewModel.this.n0();
                }
            }).H0(w1.f11132c, new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.n2
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    DeviceSettingNewViewModel.this.q0((Throwable) obj);
                }
            }));
        }
    }

    public void c1() {
        if (this.p.get()) {
            this.B.b(this.j0.w1(this.l.get()).F(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.f3
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    DeviceSettingNewViewModel.this.s0((c) obj);
                }
            }).y(new io.reactivex.g0.a() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.e3
                @Override // io.reactivex.g0.a
                public final void run() {
                    DeviceSettingNewViewModel.this.u0();
                }
            }).H0(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.b2
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    DeviceSettingNewViewModel.this.w0((Boolean) obj);
                }
            }, new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.o2
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    DeviceSettingNewViewModel.this.y0((Throwable) obj);
                }
            }));
            if (!this.l.get()) {
                return;
            }
            if (this.j0.Q() && this.j0.S()) {
                this.G.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>("both"));
            } else if (this.j0.Q()) {
                this.G.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>("detect"));
            } else if (this.j0.S()) {
                this.G.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>("record"));
            } else {
                this.G.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>("empty"));
            }
        }
    }

    public void f(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        this.B.b(((TPIoTClientManager) b.d.b.f.b.a(b.d.s.a.a.f(), TPIoTClientManager.class)).w(arrayList).l(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.e2
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                DeviceSettingNewViewModel.this.A((c) obj);
            }
        }).h(new io.reactivex.g0.a() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.g2
            @Override // io.reactivex.g0.a
            public final void run() {
                DeviceSettingNewViewModel.this.C();
            }
        }).i(new io.reactivex.g0.a() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.y2
            @Override // io.reactivex.g0.a
            public final void run() {
                DeviceSettingNewViewModel.this.E();
            }
        }).j(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.h2
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                DeviceSettingNewViewModel.this.G((Throwable) obj);
            }
        }).y());
    }

    public q<Boolean> g() {
        return this.j0.w1(false).F(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.x1
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                DeviceSettingNewViewModel.this.I((c) obj);
            }
        }).y(new io.reactivex.g0.a() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.q2
            @Override // io.reactivex.g0.a
            public final void run() {
                DeviceSettingNewViewModel.this.K();
            }
        }).C(h9.f10962c);
    }

    public void h1() {
        CameraSettingRepository cameraSettingRepository = this.j0;
        if (cameraSettingRepository != null) {
            this.B.b(cameraSettingRepository.u1().F(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.h3
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    DeviceSettingNewViewModel.this.E0((c) obj);
                }
            }).H0(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.y1
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    DeviceSettingNewViewModel.this.G0((Boolean) obj);
                }
            }, new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.d2
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    DeviceSettingNewViewModel.this.I0((Throwable) obj);
                }
            }));
            return;
        }
        e1(R.string.general_failed);
    }

    public String i() {
        return this.y0;
    }

    public void i1() {
        CameraSettingRepository cameraSettingRepository;
        if (this.I.get() && (cameraSettingRepository = this.j0) != null && cameraSettingRepository.x() != null && this.j0.x().getCameraInfo() != null) {
            this.f10730d.set(this.j0.x().getCameraInfo().getName());
            if (this.S.get()) {
                this.g.set(this.j0.x().getTimezone());
            }
            if (this.L.get()) {
                r();
            }
            this.m.set(getApplication().getString(this.j0.x().isRebootEnable() ? R.string.common_on : R.string.common_off));
        }
    }

    public void j1() {
        ALCameraDevice aLCameraDevice = this.h0;
        if (aLCameraDevice != null) {
            Z0(aLCameraDevice);
        }
        k1();
    }

    public void k() {
        if (this.h0 != null) {
            this.f10732f.set(com.tplink.iot.Utils.z0.l.b(getApplication(), this.h0));
            return;
        }
        this.f10732f.set(getApplication().getString(R.string.onBoarding_set_location_home));
    }

    public long l() {
        return this.z0;
    }

    public void l1() {
        int i = s() ? 2 : 1;
        CameraSettingRepository cameraSettingRepository = this.j0;
        this.B.b(cameraSettingRepository.v1(cameraSettingRepository.I(i)).F(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.v2
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                DeviceSettingNewViewModel.this.O0((c) obj);
            }
        }).y(new io.reactivex.g0.a() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.z2
            @Override // io.reactivex.g0.a
            public final void run() {
                DeviceSettingNewViewModel.this.Q0();
            }
        }).H0(x2.f11144c, new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.m2
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                DeviceSettingNewViewModel.this.T0((Throwable) obj);
            }
        }));
    }

    public void o(Activity activity, String str) {
        TrialDialogActivity.f1(activity, com.tplink.iot.Utils.v0.e.k(h.j(str)));
    }

    public void o1(LifecycleOwner lifecycleOwner) {
        this.C.observe(lifecycleOwner, a2.a);
        this.D.observe(lifecycleOwner, j3.a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.B.dispose();
        c cVar = this.d0;
        if (cVar != null) {
            cVar.dispose();
        }
    }

    public void p(Activity activity, String str) {
        TrialDialogActivity.e1(activity, com.tplink.iot.Utils.v0.e.l(h.j(str), ((TPIoTClientManager) b.d.b.f.b.a(b.d.s.a.a.f(), TPIoTClientManager.class)).V1(str)));
    }

    public boolean s() {
        return this.j0.R();
    }

    public void t() {
        this.B.b(this.l0.K0().H0(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.c2
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                DeviceSettingNewViewModel.this.P((CameraComponent) obj);
            }
        }, h9.f10962c));
    }

    public void v() {
        ALCameraDevice aLCameraDevice = this.h0;
        if (aLCameraDevice != null) {
            this.f10730d.set(aLCameraDevice.getDeviceAlias());
            this.f10731e.set(h.l(this.h0.getModel()));
            k();
        }
    }

    public void w() {
        if (d.c(this.g0)) {
            this.B.b(h.i(this.g0, true).E(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.u2
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    DeviceSettingNewViewModel.this.Y((DeviceCloudProduct) obj);
                }
            }).C(r2.f11063c).F0());
        }
    }

    public boolean x() {
        CameraSettingRepository cameraSettingRepository = this.j0;
        return (cameraSettingRepository == null || cameraSettingRepository.x() == null || this.j0.x().getTimezone() == null) ? false : true;
    }

    public void y() {
        if (d.c(this.g0)) {
            this.B.b(h.i(this.g0, true).E(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.l3
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    DeviceSettingNewViewModel.this.b0((DeviceCloudProduct) obj);
                }
            }).C(i3.f10966c).F0());
        }
    }
}
