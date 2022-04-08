package com.tplink.iot.devices.switches.viewmodel;

import android.app.Application;
import androidx.arch.core.util.Function;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.tplink.iot.cloud.bean.thing.common.NextEvent;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.cloud.bean.thing.common.ThingUsage;
import com.tplink.iot.devicecommon.feature.NextEventFeature;
import com.tplink.iot.devicecommon.viewmodel.IoTDetailBaseViewModel;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.CloudConnectStateResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.plug.result.PlugNextEvent;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.IoTSubDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.result.BatteryDetectInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.SwitchRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.ThingBaseRepository;
import io.reactivex.q;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.m;
import kotlin.reflect.j;

/* compiled from: SwitchDetailViewModel.kt */
/* loaded from: classes2.dex */
public final class SwitchDetailViewModel extends IoTDetailBaseViewModel {
    static final /* synthetic */ j[] r = {m.h(new PropertyReference1Impl(SwitchDetailViewModel.class, "mSwitchRepository", "getMSwitchRepository()Lcom/tplink/libtpnetwork/IoTNetwork/repository/SwitchRepository;", 0))};
    private final kotlin.t.c s;
    private final LiveData<IoTSubDevice> t;
    private final LiveData<ThingUsage> u;
    private final ObservableBoolean v;
    private final MediatorLiveData<Boolean> w;
    private final LiveData<Boolean> x;
    private final LiveData<Integer> y;
    private final NextEventFeature.b z;

    /* compiled from: DelegateUtils.kt */
    /* loaded from: classes2.dex */
    public static final class a implements kotlin.t.c<Object, SwitchRepository> {
        private final SwitchRepository a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ThingContext f7844b;

        /* JADX WARN: Type inference failed for: r2v1, types: [com.tplink.libtpnetwork.IoTNetwork.repository.kb.c, java.lang.Object, com.tplink.libtpnetwork.IoTNetwork.repository.SwitchRepository] */
        /* JADX WARN: Unknown variable types count: 1 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public a(com.tplink.libtpnetwork.IoTNetwork.ThingContext r2) {
            /*
                r1 = this;
                r1.f7844b = r2
                r1.<init>()
                java.lang.Class<com.tplink.libtpnetwork.IoTNetwork.repository.SwitchRepository> r0 = com.tplink.libtpnetwork.IoTNetwork.repository.SwitchRepository.class
                com.tplink.libtpnetwork.IoTNetwork.repository.kb.c r2 = com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(r2, r0)
                java.lang.String r0 = "IoTDeviceRepositoryProvi…sitory, REPO::class.java)"
                kotlin.jvm.internal.j.d(r2, r0)
                r1.a = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.devices.switches.viewmodel.SwitchDetailViewModel.a.<init>(com.tplink.libtpnetwork.IoTNetwork.ThingContext):void");
        }

        /* renamed from: c */
        public SwitchRepository b(Object thisRef, j<?> property) {
            kotlin.jvm.internal.j.e(thisRef, "thisRef");
            kotlin.jvm.internal.j.e(property, "property");
            return this.a;
        }
    }

    /* compiled from: SwitchDetailViewModel.kt */
    /* loaded from: classes2.dex */
    static final class b<T> implements Observer<BatteryDetectInfoResult> {
        b() {
        }

        /* renamed from: a */
        public final void onChanged(BatteryDetectInfoResult batteryDetectInfoResult) {
            SwitchDetailViewModel.this.w.postValue(Boolean.valueOf(batteryDetectInfoResult != null ? batteryDetectInfoResult.isLow() : false));
        }
    }

    /* compiled from: SwitchDetailViewModel.kt */
    /* loaded from: classes2.dex */
    static final class c<T> implements Observer<IoTSubDevice> {
        c() {
        }

        /* renamed from: a */
        public final void onChanged(IoTSubDevice ioTSubDevice) {
            SwitchDetailViewModel.this.w.postValue(Boolean.valueOf(ioTSubDevice != null ? ioTSubDevice.isAtLowBattery() : false));
        }
    }

    /* compiled from: SwitchDetailViewModel.kt */
    /* loaded from: classes2.dex */
    static final class d<I, O> implements Function<BaseALIoTDevice<?>, IoTSubDevice> {
        public static final d a = new d();

        d() {
        }

        /* renamed from: a */
        public final IoTSubDevice apply(BaseALIoTDevice<?> baseALIoTDevice) {
            Object obj = null;
            Object localIoTDevice = baseALIoTDevice != null ? baseALIoTDevice.getLocalIoTDevice() : null;
            if (localIoTDevice instanceof IoTSubDevice) {
                obj = localIoTDevice;
            }
            return (IoTSubDevice) obj;
        }
    }

    /* compiled from: SwitchDetailViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class e implements NextEventFeature.b {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ThingContext f7845b;

        /* compiled from: SwitchDetailViewModel.kt */
        /* loaded from: classes2.dex */
        static final class a<I, O> implements Function<NextEvent, NextEvent> {
            public static final a a = new a();

            a() {
            }

            /* renamed from: a */
            public final NextEvent apply(NextEvent nextEvent) {
                return new PlugNextEvent(nextEvent);
            }
        }

        e(ThingContext thingContext) {
            this.f7845b = thingContext;
        }

        @Override // com.tplink.iot.devicecommon.feature.NextEventFeature.b
        public void a() {
            SwitchDetailViewModel.this.P();
        }

        @Override // com.tplink.iot.devicecommon.feature.NextEventFeature.b
        public LiveData<NextEvent> b() {
            LiveData<NextEvent> map = Transformations.map(SwitchDetailViewModel.this.S().m1(), a.a);
            kotlin.jvm.internal.j.d(map, "Transformations.map(mSwi…xtEvent(it)\n            }");
            return map;
        }

        @Override // com.tplink.iot.devicecommon.feature.NextEventFeature.b
        public void c() {
            SwitchDetailViewModel.this.T();
        }

        @Override // com.tplink.iot.devicecommon.feature.NextEventFeature.b
        public String d() {
            LocalIoTBaseDevice localIoTDevice;
            ALIoTDevice ioTDevice = this.f7845b.getIoTDevice();
            if (ioTDevice == null || (localIoTDevice = ioTDevice.getLocalIoTDevice()) == null) {
                return null;
            }
            return localIoTDevice.getRegion();
        }
    }

    /* compiled from: SwitchDetailViewModel.kt */
    /* loaded from: classes2.dex */
    static final class f implements io.reactivex.g0.a {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f7846b;

        f(long j) {
            this.f7846b = j;
        }

        @Override // io.reactivex.g0.a
        public final void run() {
            com.tplink.iot.Utils.x0.j.c(SwitchDetailViewModel.this.n(), System.currentTimeMillis() - this.f7846b, true);
        }
    }

    /* compiled from: SwitchDetailViewModel.kt */
    /* loaded from: classes2.dex */
    static final class g<T> implements io.reactivex.g0.g<Throwable> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ long f7848d;

        g(long j) {
            this.f7848d = j;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            com.tplink.iot.Utils.x0.j.c(SwitchDetailViewModel.this.n(), System.currentTimeMillis() - this.f7848d, false);
        }
    }

    /* compiled from: SwitchDetailViewModel.kt */
    /* loaded from: classes2.dex */
    static final class h<T> implements Observer<ThingFirmware> {
        h() {
        }

        /* renamed from: a */
        public final void onChanged(ThingFirmware thingFirmware) {
            MediatorLiveData o = SwitchDetailViewModel.this.o();
            boolean z = true;
            if (thingFirmware == null || !thingFirmware.isNeedToUpgrade()) {
                z = false;
            }
            o.postValue(Boolean.valueOf(z));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwitchDetailViewModel(Application application, ThingContext iotDeviceContext) {
        super(application, iotDeviceContext);
        kotlin.jvm.internal.j.e(application, "application");
        kotlin.jvm.internal.j.e(iotDeviceContext, "iotDeviceContext");
        this.s = new a(iotDeviceContext);
        LiveData<IoTSubDevice> map = Transformations.map(i(), d.a);
        kotlin.jvm.internal.j.d(map, "Transformations.map(alIo…ce as? IoTSubDevice\n    }");
        this.t = map;
        LiveData<ThingUsage> d1 = S().d1();
        kotlin.jvm.internal.j.d(d1, "mSwitchRepository.deviceUsageLiveData");
        this.u = d1;
        IoTSubDevice value = map.getValue();
        this.v = new ObservableBoolean(value != null ? value.isDeviceOn() : false);
        MediatorLiveData<Boolean> mediatorLiveData = new MediatorLiveData<>();
        this.w = mediatorLiveData;
        this.x = mediatorLiveData;
        this.y = S().j4();
        this.z = new e(iotDeviceContext);
        mediatorLiveData.addSource(S().U0(), new b());
        mediatorLiveData.addSource(map, new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P() {
        S().Z0().F0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SwitchRepository S() {
        return (SwitchRepository) this.s.b(this, r[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T() {
        S().l1().F0();
    }

    @Override // com.tplink.iot.devicecommon.viewmodel.IoTDetailBaseViewModel
    public void E() {
        P();
    }

    @Override // com.tplink.iot.devicecommon.viewmodel.IoTDetailBaseViewModel
    public void F() {
        o().addSource(S().h1(), new h());
    }

    public final LiveData<IoTSubDevice> O() {
        return this.t;
    }

    public final void Q() {
        S().c1().L0(io.reactivex.l0.a.c()).F0();
    }

    public final LiveData<ThingUsage> R() {
        return this.u;
    }

    public final NextEventFeature.b U() {
        return this.z;
    }

    public final LiveData<Integer> V() {
        return this.y;
    }

    public final LiveData<Boolean> W() {
        return this.x;
    }

    public final ObservableBoolean X() {
        return this.v;
    }

    public final void Y(boolean z) {
        this.v.set(z);
        long currentTimeMillis = System.currentTimeMillis();
        S().i(z).r(io.reactivex.d0.b.a.a()).i(new f(currentTimeMillis)).j(new g(currentTimeMillis)).y();
    }

    public final void Z(boolean z) {
        S().s4(z);
    }

    @Override // com.tplink.iot.devicecommon.viewmodel.IoTDetailBaseViewModel
    public q<CloudConnectStateResult> j() {
        q<CloudConnectStateResult> V0 = S().V0();
        kotlin.jvm.internal.j.d(V0, "mSwitchRepository.cloudConnectState");
        return V0;
    }

    @Override // com.tplink.iot.devicecommon.viewmodel.IoTDetailBaseViewModel
    public ThingBaseRepository r() {
        return S();
    }
}
