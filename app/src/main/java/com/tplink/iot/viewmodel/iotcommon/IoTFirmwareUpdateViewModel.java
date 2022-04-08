package com.tplink.iot.viewmodel.iotcommon;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tplink.iot.Utils.w;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.cloud.bean.thing.common.FirmwareDownloadState;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpmediastatistics.SSLClient;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.AutoUpdateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.result.RealTimeBatteryInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractSubThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.HubRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.PlugRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.ThingBaseRepository;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class IoTFirmwareUpdateViewModel extends AndroidViewModel {
    private AbstractThingRepository a;

    /* renamed from: b  reason: collision with root package name */
    private AbstractSubThingRepository f10200b;
    public boolean i;
    public boolean j;
    private final BaseALIoTDevice m;

    /* renamed from: d  reason: collision with root package name */
    private MediatorLiveData<FirmwareDownloadState> f10202d = new MediatorLiveData<>();

    /* renamed from: e  reason: collision with root package name */
    private SingleLiveEvent<Boolean> f10203e = new SingleLiveEvent<>();

    /* renamed from: f  reason: collision with root package name */
    private SingleLiveEvent<Integer> f10204f = new SingleLiveEvent<>();
    public ObservableBoolean g = new ObservableBoolean(false);
    private MediatorLiveData<Boolean> h = new MediatorLiveData<>();
    private final MutableLiveData<i<RealTimeBatteryInfoResult>> k = new MutableLiveData<>();
    private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> l = new MutableLiveData<>();

    /* renamed from: c  reason: collision with root package name */
    private TPIoTClientManager f10201c = (TPIoTClientManager) b.d.b.f.b.a(b.d.s.a.a.f(), TPIoTClientManager.class);

    /* loaded from: classes2.dex */
    class a implements g<Throwable> {
        a() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            b.d.w.c.a.n("FirmwareUpdate", "doInitCheck error");
            IoTFirmwareUpdateViewModel.this.f10204f.postValue(7);
        }
    }

    /* loaded from: classes2.dex */
    class b implements io.reactivex.g0.c<ThingFirmware, FirmwareDownloadState, Boolean> {
        b() {
        }

        @NonNull
        /* renamed from: a */
        public Boolean apply(@NonNull ThingFirmware thingFirmware, @NonNull FirmwareDownloadState firmwareDownloadState) throws Exception {
            b.d.w.c.a.n("FirmwareUpdate", "doInitCheck apply: " + thingFirmware.isNeedToUpgrade() + SSLClient.WHITE_SPACE + firmwareDownloadState.getUpgradeTime() + SSLClient.WHITE_SPACE + thingFirmware.getFwVer());
            if (!thingFirmware.isNeedToUpgrade()) {
                IoTFirmwareUpdateViewModel.this.f10204f.postValue(7);
            } else {
                int status = firmwareDownloadState.getStatus();
                if (firmwareDownloadState.getStatus() == -1001 || firmwareDownloadState.getStatus() == -1002) {
                    status = 0;
                }
                IoTFirmwareUpdateViewModel.this.U(status);
                IoTFirmwareUpdateViewModel.this.f10202d.postValue(firmwareDownloadState);
            }
            return Boolean.TRUE;
        }
    }

    /* loaded from: classes2.dex */
    class c implements io.reactivex.g0.a {
        c() {
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            IoTFirmwareUpdateViewModel.this.f10203e.postValue(Boolean.TRUE);
        }
    }

    /* loaded from: classes2.dex */
    class d implements g<Throwable> {
        d() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            if (w.d(th)) {
                w.f();
            }
            IoTFirmwareUpdateViewModel.this.f10203e.postValue(Boolean.FALSE);
        }
    }

    /* loaded from: classes2.dex */
    class e implements g<Throwable> {
        e() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            IoTFirmwareUpdateViewModel.this.U(FirmwareDownloadState.UPGRADE_STATE_DOWNLOAD_FAIL);
            FirmwareDownloadState firmwareDownloadState = new FirmwareDownloadState();
            firmwareDownloadState.setStatus(FirmwareDownloadState.UPGRADE_STATE_DOWNLOAD_FAIL);
            IoTFirmwareUpdateViewModel.this.f10202d.postValue(firmwareDownloadState);
        }
    }

    /* loaded from: classes2.dex */
    class f implements g<FirmwareDownloadState> {
        f() {
        }

        /* renamed from: a */
        public void accept(FirmwareDownloadState firmwareDownloadState) throws Exception {
            IoTFirmwareUpdateViewModel.this.U(firmwareDownloadState.getStatus());
            IoTFirmwareUpdateViewModel.this.f10202d.postValue(firmwareDownloadState);
        }
    }

    public IoTFirmwareUpdateViewModel(@NonNull Application application, ThingContext thingContext) {
        super(application);
        boolean z = false;
        this.i = false;
        this.j = false;
        this.m = thingContext.getIoTDevice();
        ThingBaseRepository c2 = com.tplink.libtpnetwork.IoTNetwork.util.c.c(thingContext);
        if (c2 instanceof AbstractThingRepository) {
            this.a = (AbstractThingRepository) c2;
        } else if (c2 instanceof AbstractSubThingRepository) {
            this.f10200b = (AbstractSubThingRepository) c2;
        } else {
            this.a = (AbstractThingRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(thingContext, PlugRepository.class);
        }
        if (thingContext.getIoTDevice() != null) {
            this.i = thingContext.getIoTDevice().isSubDevice();
        }
        if (!(thingContext.getIoTDevice() == null || thingContext.getIoTDevice().getLocalIoTDevice() == null)) {
            LocalIoTBaseDevice localIoTDevice = thingContext.getIoTDevice().getLocalIoTDevice();
            this.g.set(localIoTDevice.getComponentVersion(EnumIoTComponent.FIRMWARE) >= 2 ? true : z);
            this.j = localIoTDevice.isSupportComponent(EnumIoTComponent.BATTERY_DETECT);
        }
        LiveData<AutoUpdateBean> mutableLiveData = new MutableLiveData<>();
        AbstractThingRepository abstractThingRepository = this.a;
        if (abstractThingRepository != null) {
            mutableLiveData = abstractThingRepository.Z0();
        } else {
            AbstractSubThingRepository abstractSubThingRepository = this.f10200b;
            if (abstractSubThingRepository != null) {
                mutableLiveData = abstractSubThingRepository.R0();
            }
        }
        this.h.addSource(mutableLiveData, new Observer() { // from class: com.tplink.iot.viewmodel.iotcommon.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                IoTFirmwareUpdateViewModel.this.R((AutoUpdateBean) obj);
            }
        });
    }

    private int A(boolean z, boolean z2) {
        if (z) {
            return z2 ? 1 : 0;
        }
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F */
    public /* synthetic */ void G(ThingFirmware thingFirmware) throws Exception {
        this.l.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Integer.valueOf(A(true, thingFirmware.isNeedToUpgrade()))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H */
    public /* synthetic */ void I(Throwable th) throws Exception {
        this.l.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Integer.valueOf(A(false, false))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J */
    public /* synthetic */ void K(io.reactivex.e0.c cVar) throws Exception {
        this.k.postValue(new i<>(10, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L */
    public /* synthetic */ void M(Throwable th) throws Exception {
        this.k.postValue(new i<>(30, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N */
    public /* synthetic */ void O(RealTimeBatteryInfoResult realTimeBatteryInfoResult) throws Exception {
        this.k.postValue(new i<>(20, realTimeBatteryInfoResult));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q */
    public /* synthetic */ void R(AutoUpdateBean autoUpdateBean) {
        if (autoUpdateBean != null) {
            this.h.postValue(Boolean.valueOf(autoUpdateBean.isEnable()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(int i) {
        if (i == 0) {
            this.f10204f.postValue(2);
        } else if (i == 1 || i == 2) {
            this.f10204f.postValue(3);
        } else if (i == 3) {
            this.f10204f.postValue(5);
        } else if (i != 4) {
            switch (i) {
                case FirmwareDownloadState.UPGRADE_STATE_TRANSFER_FAIL /* -1003 */:
                    this.f10204f.postValue(9);
                    return;
                case FirmwareDownloadState.UPGRADE_STATE_CHECK_FAIL /* -1002 */:
                    this.f10204f.postValue(6);
                    return;
                case FirmwareDownloadState.UPGRADE_STATE_DOWNLOAD_FAIL /* -1001 */:
                    this.f10204f.postValue(4);
                    return;
                default:
                    return;
            }
        } else {
            this.f10204f.postValue(8);
        }
    }

    private io.reactivex.a V() {
        AbstractThingRepository abstractThingRepository = this.a;
        if (abstractThingRepository != null) {
            return abstractThingRepository.d5();
        }
        AbstractSubThingRepository abstractSubThingRepository = this.f10200b;
        if (abstractSubThingRepository != null) {
            return abstractSubThingRepository.f4();
        }
        return io.reactivex.a.e();
    }

    private q<Boolean> n() {
        AbstractThingRepository abstractThingRepository;
        if (!this.g.get() || (abstractThingRepository = this.a) == null) {
            return q.f0(Boolean.TRUE);
        }
        return abstractThingRepository.E1().g0(e.f10226c);
    }

    private q<FirmwareDownloadState> r() {
        AbstractThingRepository abstractThingRepository = this.a;
        if (abstractThingRepository != null) {
            return abstractThingRepository.u1();
        }
        AbstractSubThingRepository abstractSubThingRepository = this.f10200b;
        if (abstractSubThingRepository != null) {
            return abstractSubThingRepository.e1();
        }
        return q.I();
    }

    private q<ThingFirmware> s() {
        AbstractThingRepository abstractThingRepository = this.a;
        if (abstractThingRepository != null) {
            return abstractThingRepository.v1();
        }
        AbstractSubThingRepository abstractSubThingRepository = this.f10200b;
        if (abstractSubThingRepository != null) {
            return abstractSubThingRepository.g1();
        }
        return q.I();
    }

    public MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> B() {
        return this.l;
    }

    public String C(Context context) {
        BaseALIoTDevice baseALIoTDevice = this.m;
        return baseALIoTDevice != null ? l.b(context, baseALIoTDevice) : "";
    }

    public MutableLiveData<i<RealTimeBatteryInfoResult>> D() {
        return this.k;
    }

    public SingleLiveEvent<Boolean> E() {
        return this.f10203e;
    }

    public void S() {
        AbstractThingRepository abstractThingRepository = this.a;
        if (abstractThingRepository != null) {
            abstractThingRepository.y4(false);
            return;
        }
        AbstractSubThingRepository abstractSubThingRepository = this.f10200b;
        if (abstractSubThingRepository != null) {
            abstractSubThingRepository.O3(false);
        }
    }

    @SuppressLint({"CheckResult"})
    public void T() {
        V().r(io.reactivex.d0.b.a.a()).A(new c(), new d());
    }

    public q<FirmwareDownloadState> j() {
        AbstractThingRepository abstractThingRepository = this.a;
        if (abstractThingRepository != null) {
            return abstractThingRepository.u1();
        }
        AbstractSubThingRepository abstractSubThingRepository = this.f10200b;
        if (abstractSubThingRepository != null) {
            return abstractSubThingRepository.O0();
        }
        return q.I();
    }

    public void k() {
        BaseALIoTDevice baseALIoTDevice = this.m;
        if (baseALIoTDevice == null || !baseALIoTDevice.isSubDevice()) {
            this.l.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Integer.valueOf(A(false, false))));
            return;
        }
        BaseALIoTDevice Z1 = this.f10201c.Z1(this.m.getParentDeviceIDMD5());
        if (Z1 != null) {
            HubRepository hubRepository = (HubRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(Z1.getDeviceIdMD5(), HubRepository.class);
            if (hubRepository.w1().getValue() != null) {
                this.l.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Integer.valueOf(A(true, hubRepository.w1().getValue().isNeedToUpgrade()))));
            } else {
                hubRepository.v1().E(new g() { // from class: com.tplink.iot.viewmodel.iotcommon.d
                    @Override // io.reactivex.g0.g
                    public final void accept(Object obj) {
                        IoTFirmwareUpdateViewModel.this.G((ThingFirmware) obj);
                    }
                }).C(new g() { // from class: com.tplink.iot.viewmodel.iotcommon.b
                    @Override // io.reactivex.g0.g
                    public final void accept(Object obj) {
                        IoTFirmwareUpdateViewModel.this.I((Throwable) obj);
                    }
                }).F0();
            }
        } else {
            this.l.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Integer.valueOf(A(false, false))));
        }
    }

    public void l() {
        b.d.w.c.a.n("FirmwareUpdate", "checkRealTimeBatteryInfo");
        AbstractSubThingRepository abstractSubThingRepository = this.f10200b;
        (abstractSubThingRepository != null ? abstractSubThingRepository.n1() : q.f0(new RealTimeBatteryInfoResult())).F(new g() { // from class: com.tplink.iot.viewmodel.iotcommon.f
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                IoTFirmwareUpdateViewModel.this.K((c) obj);
            }
        }).C(new g() { // from class: com.tplink.iot.viewmodel.iotcommon.a
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                IoTFirmwareUpdateViewModel.this.M((Throwable) obj);
            }
        }).E(new g() { // from class: com.tplink.iot.viewmodel.iotcommon.c
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                IoTFirmwareUpdateViewModel.this.O((RealTimeBatteryInfoResult) obj);
            }
        }).F0();
    }

    public void m() {
        q.f1(s(), j(), new b()).T0(30L, TimeUnit.SECONDS).C(new a()).F0();
        n().F0();
    }

    public LiveData<Boolean> o() {
        return this.h;
    }

    public BaseALIoTDevice p() {
        return this.m;
    }

    public String t(Context context) {
        BaseALIoTDevice baseALIoTDevice = this.m;
        return baseALIoTDevice != null ? l.e(context, baseALIoTDevice.getDeviceType(), baseALIoTDevice.getDeviceName(), baseALIoTDevice.getDeviceModel()) : "";
    }

    public void u() {
        AbstractThingRepository abstractThingRepository = this.a;
        if (abstractThingRepository != null) {
            abstractThingRepository.m1().F0();
            return;
        }
        AbstractSubThingRepository abstractSubThingRepository = this.f10200b;
        if (abstractSubThingRepository != null) {
            abstractSubThingRepository.b1().F0();
        }
    }

    public LiveData<FirmwareDownloadState> v() {
        return this.f10202d;
    }

    public void w() {
        r().l0(io.reactivex.d0.b.a.a()).E(new f()).C(new e()).F0();
    }

    public void x() {
        AbstractThingRepository abstractThingRepository = this.a;
        if (abstractThingRepository != null) {
            abstractThingRepository.v1().F0();
            return;
        }
        AbstractSubThingRepository abstractSubThingRepository = this.f10200b;
        if (abstractSubThingRepository != null) {
            abstractSubThingRepository.g1().F0();
        }
    }

    public LiveData<ThingFirmware> y() {
        AbstractThingRepository abstractThingRepository = this.a;
        if (abstractThingRepository != null) {
            return abstractThingRepository.w1();
        }
        AbstractSubThingRepository abstractSubThingRepository = this.f10200b;
        if (abstractSubThingRepository != null) {
            return abstractSubThingRepository.h1();
        }
        return new MutableLiveData();
    }

    public SingleLiveEvent<Integer> z() {
        return this.f10204f;
    }
}
