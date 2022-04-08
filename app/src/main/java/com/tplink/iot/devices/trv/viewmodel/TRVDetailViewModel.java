package com.tplink.iot.devices.trv.viewmodel;

import android.app.Application;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.tplink.iot.cloud.bean.thing.common.NextEvent;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.devicecommon.feature.NextEventFeature;
import com.tplink.iot.devicecommon.viewmodel.IoTDetailBaseViewModel;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.CloudConnectStateResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.IoTSubDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.params.SubDeviceInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.ChildProtectionBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.FrostProtectionBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.result.TRVNextEvent;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.result.TRVTemperatureRecordsResult;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.TRVRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.ThingBaseRepository;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import com.tplink.libtpnetwork.enumerate.EnumTemperatureUnit;
import io.reactivex.q;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.m;
import kotlin.reflect.j;

/* compiled from: TRVDetailViewModel.kt */
/* loaded from: classes2.dex */
public final class TRVDetailViewModel extends IoTDetailBaseViewModel {
    static final /* synthetic */ j[] r = {m.h(new PropertyReference1Impl(TRVDetailViewModel.class, "mTRVRepository", "getMTRVRepository()Lcom/tplink/libtpnetwork/IoTNetwork/repository/TRVRepository;", 0))};
    private final boolean A;
    private final boolean B;
    private final kotlin.t.c s;
    private final LiveData<IoTSubDevice> t;
    private final LiveData<ChildProtectionBean> u = S().s4();
    private final LiveData<TRVTemperatureRecordsResult> v = S().F4();
    private final LiveData<FrostProtectionBean> w = S().w4();
    private final com.tplink.libtpnetwork.IoTNetwork.util.a x;
    private final LiveData<Integer> y;
    private final NextEventFeature.b z;

    /* compiled from: DelegateUtils.kt */
    /* loaded from: classes2.dex */
    public static final class a implements kotlin.t.c<Object, TRVRepository> {
        private final TRVRepository a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ThingContext f7918b;

        /* JADX WARN: Type inference failed for: r2v1, types: [com.tplink.libtpnetwork.IoTNetwork.repository.kb.c, com.tplink.libtpnetwork.IoTNetwork.repository.TRVRepository, java.lang.Object] */
        /* JADX WARN: Unknown variable types count: 1 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public a(com.tplink.libtpnetwork.IoTNetwork.ThingContext r2) {
            /*
                r1 = this;
                r1.f7918b = r2
                r1.<init>()
                java.lang.Class<com.tplink.libtpnetwork.IoTNetwork.repository.TRVRepository> r0 = com.tplink.libtpnetwork.IoTNetwork.repository.TRVRepository.class
                com.tplink.libtpnetwork.IoTNetwork.repository.kb.c r2 = com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(r2, r0)
                java.lang.String r0 = "IoTDeviceRepositoryProvi…sitory, REPO::class.java)"
                kotlin.jvm.internal.j.d(r2, r0)
                r1.a = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.devices.trv.viewmodel.TRVDetailViewModel.a.<init>(com.tplink.libtpnetwork.IoTNetwork.ThingContext):void");
        }

        /* renamed from: c */
        public TRVRepository b(Object thisRef, j<?> property) {
            kotlin.jvm.internal.j.e(thisRef, "thisRef");
            kotlin.jvm.internal.j.e(property, "property");
            return this.a;
        }
    }

    /* compiled from: TRVDetailViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class b implements NextEventFeature.b {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ThingContext f7919b;

        /* compiled from: TRVDetailViewModel.kt */
        /* loaded from: classes2.dex */
        static final class a<I, O> implements Function<NextEvent, NextEvent> {
            public static final a a = new a();

            a() {
            }

            /* renamed from: a */
            public final NextEvent apply(NextEvent nextEvent) {
                return new TRVNextEvent(nextEvent);
            }
        }

        b(ThingContext thingContext) {
            this.f7919b = thingContext;
        }

        @Override // com.tplink.iot.devicecommon.feature.NextEventFeature.b
        public void a() {
            TRVDetailViewModel.this.P();
        }

        @Override // com.tplink.iot.devicecommon.feature.NextEventFeature.b
        public LiveData<NextEvent> b() {
            LiveData<NextEvent> map = Transformations.map(TRVDetailViewModel.this.S().m1(), a.a);
            kotlin.jvm.internal.j.d(map, "Transformations.map(mTRV…ata) { TRVNextEvent(it) }");
            return map;
        }

        @Override // com.tplink.iot.devicecommon.feature.NextEventFeature.b
        public void c() {
            TRVDetailViewModel.this.T();
        }

        @Override // com.tplink.iot.devicecommon.feature.NextEventFeature.b
        public String d() {
            LocalIoTBaseDevice localIoTDevice;
            ALIoTDevice ioTDevice = this.f7919b.getIoTDevice();
            if (ioTDevice == null || (localIoTDevice = ioTDevice.getLocalIoTDevice()) == null) {
                return null;
            }
            return localIoTDevice.getRegion();
        }
    }

    /* compiled from: TRVDetailViewModel.kt */
    /* loaded from: classes2.dex */
    static final class c<T> implements Observer<ThingFirmware> {
        c() {
        }

        /* renamed from: a */
        public final void onChanged(ThingFirmware thingFirmware) {
            MediatorLiveData o = TRVDetailViewModel.this.o();
            boolean z = true;
            if (thingFirmware == null || !thingFirmware.isNeedToUpgrade()) {
                z = false;
            }
            o.postValue(Boolean.valueOf(z));
        }
    }

    /* compiled from: TRVDetailViewModel.kt */
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TRVDetailViewModel(Application application, ThingContext iotDeviceContext) {
        super(application, iotDeviceContext);
        kotlin.jvm.internal.j.e(application, "application");
        kotlin.jvm.internal.j.e(iotDeviceContext, "iotDeviceContext");
        this.s = new a(iotDeviceContext);
        LiveData<IoTSubDevice> map = Transformations.map(i(), d.a);
        kotlin.jvm.internal.j.d(map, "Transformations.map(alIo…ce as? IoTSubDevice\n    }");
        this.t = map;
        com.tplink.libtpnetwork.IoTNetwork.util.a aVar = new com.tplink.libtpnetwork.IoTNetwork.util.a();
        this.x = aVar;
        this.y = aVar.c();
        this.z = new b(iotDeviceContext);
        ALIoTDevice ioTDevice = iotDeviceContext.getIoTDevice();
        LocalIoTBaseDevice localIoTDevice = ioTDevice != null ? ioTDevice.getLocalIoTDevice() : null;
        this.A = com.tplink.iot.Utils.w0.b.a(localIoTDevice, EnumIoTComponent.CHILD_PROTECTION);
        this.B = com.tplink.iot.Utils.w0.b.a(localIoTDevice, EnumIoTComponent.FROST_PROTECTION);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P() {
        S().Z0().F0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TRVRepository S() {
        return (TRVRepository) this.s.b(this, r[0]);
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
        o().addSource(S().h1(), new c());
    }

    public final void M() {
        S().r4().F0();
    }

    public final LiveData<ChildProtectionBean> N() {
        return this.u;
    }

    public final LiveData<Integer> O() {
        return this.y;
    }

    public final void Q() {
        S().v4().F0();
    }

    public final LiveData<FrostProtectionBean> R() {
        return this.w;
    }

    public final NextEventFeature.b U() {
        return this.z;
    }

    public final void V() {
        S().E4().F0();
    }

    public final LiveData<TRVTemperatureRecordsResult> W() {
        return this.v;
    }

    public final LiveData<IoTSubDevice> X() {
        return this.t;
    }

    public final boolean Y() {
        return this.A;
    }

    public final void Z(boolean z) {
        SubDeviceInfoParams subDeviceInfoParams = new SubDeviceInfoParams();
        subDeviceInfoParams.setFrostProtectionOn(Boolean.valueOf(z));
        S().L4(subDeviceInfoParams).f(this.x.b()).y();
    }

    public final void a0(int i, EnumTemperatureUnit unit) {
        kotlin.jvm.internal.j.e(unit, "unit");
        SubDeviceInfoParams subDeviceInfoParams = new SubDeviceInfoParams();
        subDeviceInfoParams.setTargetTemp(Integer.valueOf(i));
        subDeviceInfoParams.setTempUnit(unit.getValue());
        subDeviceInfoParams.setFrostProtectionOn(Boolean.FALSE);
        S().L4(subDeviceInfoParams).f(this.x.b()).y();
    }

    @Override // com.tplink.iot.devicecommon.viewmodel.IoTDetailBaseViewModel
    public q<CloudConnectStateResult> j() {
        q<CloudConnectStateResult> V0 = S().V0();
        kotlin.jvm.internal.j.d(V0, "mTRVRepository.cloudConnectState");
        return V0;
    }

    @Override // com.tplink.iot.devicecommon.viewmodel.IoTDetailBaseViewModel
    public ThingBaseRepository r() {
        return S();
    }
}
