package com.tplink.libtpnetwork.IoTNetwork.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.params.DeviceInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.IoTSubDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.params.DelayActionInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.params.DoubleClickInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.result.BatteryDetectInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.result.SubDeviceRunningInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumFeatureType;
import io.reactivex.g0.j;
import io.reactivex.q;
import io.reactivex.t;
import kotlin.p;

/* compiled from: SwitchRepository.kt */
/* loaded from: classes3.dex */
public final class SwitchRepository extends AbstractSubThingRepository {
    private boolean C = true;
    private final MutableLiveData<DelayActionInfoBean> D;
    private final LiveData<DelayActionInfoBean> E;
    private final MutableLiveData<DoubleClickInfoBean> F;
    private final LiveData<DoubleClickInfoBean> G;
    private final com.tplink.libtpnetwork.IoTNetwork.util.a H;
    private final LiveData<Integer> I;

    /* compiled from: SwitchRepository.kt */
    /* loaded from: classes3.dex */
    static final class a<T, R> implements j<Throwable, t<? extends DelayActionInfoBean>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: SwitchRepository.kt */
        /* renamed from: com.tplink.libtpnetwork.IoTNetwork.repository.SwitchRepository$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0259a<T, R> implements j<com.google.gson.i, DelayActionInfoBean> {

            /* renamed from: c  reason: collision with root package name */
            public static final C0259a f13037c = new C0259a();

            C0259a() {
            }

            /* renamed from: a */
            public final DelayActionInfoBean apply(com.google.gson.i it) {
                kotlin.jvm.internal.j.e(it, "it");
                return (DelayActionInfoBean) com.tplink.libtpnetwork.Utils.i.a(it, DelayActionInfoBean.class);
            }
        }

        a() {
        }

        /* renamed from: a */
        public final t<? extends DelayActionInfoBean> apply(Throwable throwable) {
            kotlin.jvm.internal.j.e(throwable, "throwable");
            if (SwitchRepository.this.F0(throwable)) {
                return SwitchRepository.this.t(EnumFeatureType.ON_OFF_DELAY.getName()).g0(C0259a.f13037c);
            }
            return q.J(throwable);
        }
    }

    /* compiled from: SwitchRepository.kt */
    /* loaded from: classes3.dex */
    static final class b<T> implements io.reactivex.g0.g<DelayActionInfoBean> {
        b() {
        }

        /* renamed from: a */
        public final void accept(DelayActionInfoBean delayActionInfoBean) {
            SwitchRepository.this.D.postValue(delayActionInfoBean);
        }
    }

    /* compiled from: SwitchRepository.kt */
    /* loaded from: classes3.dex */
    static final class c<T, R> implements j<Throwable, t<? extends DoubleClickInfoBean>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: SwitchRepository.kt */
        /* loaded from: classes3.dex */
        public static final class a<T, R> implements j<com.google.gson.i, DoubleClickInfoBean> {

            /* renamed from: c  reason: collision with root package name */
            public static final a f13040c = new a();

            a() {
            }

            /* renamed from: a */
            public final DoubleClickInfoBean apply(com.google.gson.i it) {
                kotlin.jvm.internal.j.e(it, "it");
                return (DoubleClickInfoBean) com.tplink.libtpnetwork.Utils.i.a(it, DoubleClickInfoBean.class);
            }
        }

        c() {
        }

        /* renamed from: a */
        public final t<? extends DoubleClickInfoBean> apply(Throwable throwable) {
            kotlin.jvm.internal.j.e(throwable, "throwable");
            if (SwitchRepository.this.F0(throwable)) {
                return SwitchRepository.this.t(EnumFeatureType.DOUBLE_CLICK_CONFIG.getName()).g0(a.f13040c);
            }
            return q.J(throwable);
        }
    }

    /* compiled from: SwitchRepository.kt */
    /* loaded from: classes3.dex */
    static final class d<T> implements io.reactivex.g0.g<DoubleClickInfoBean> {
        d() {
        }

        /* renamed from: a */
        public final void accept(DoubleClickInfoBean doubleClickInfoBean) {
            SwitchRepository.this.F.postValue(doubleClickInfoBean);
        }
    }

    /* compiled from: SwitchRepository.kt */
    /* loaded from: classes3.dex */
    static final class e<T, R> implements j<Throwable, t<? extends Boolean>> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ DelayActionInfoBean f13043d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: SwitchRepository.kt */
        /* loaded from: classes3.dex */
        public static final class a<T, R> implements j<com.google.gson.i, Boolean> {

            /* renamed from: c  reason: collision with root package name */
            public static final a f13044c = new a();

            a() {
            }

            /* renamed from: a */
            public final Boolean apply(com.google.gson.i it) {
                kotlin.jvm.internal.j.e(it, "it");
                return Boolean.TRUE;
            }
        }

        e(DelayActionInfoBean delayActionInfoBean) {
            this.f13043d = delayActionInfoBean;
        }

        /* renamed from: a */
        public final t<? extends Boolean> apply(Throwable throwable) {
            kotlin.jvm.internal.j.e(throwable, "throwable");
            if (SwitchRepository.this.F0(throwable)) {
                return SwitchRepository.this.L0(EnumFeatureType.ON_OFF_DELAY.getName(), this.f13043d).g0(a.f13044c);
            }
            return q.J(throwable);
        }
    }

    /* compiled from: SwitchRepository.kt */
    /* loaded from: classes3.dex */
    static final class f implements io.reactivex.g0.a {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ DelayActionInfoBean f13045b;

        f(DelayActionInfoBean delayActionInfoBean) {
            this.f13045b = delayActionInfoBean;
        }

        @Override // io.reactivex.g0.a
        public final void run() {
            SwitchRepository.this.D.postValue(this.f13045b);
        }
    }

    /* compiled from: SwitchRepository.kt */
    /* loaded from: classes3.dex */
    static final class g implements io.reactivex.g0.a {
        g() {
        }

        @Override // io.reactivex.g0.a
        public final void run() {
            SwitchRepository.this.p4();
        }
    }

    /* compiled from: SwitchRepository.kt */
    /* loaded from: classes3.dex */
    static final class h<T, R> implements j<Throwable, t<? extends Boolean>> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ DoubleClickInfoBean f13047d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: SwitchRepository.kt */
        /* loaded from: classes3.dex */
        public static final class a<T, R> implements j<com.google.gson.i, Boolean> {

            /* renamed from: c  reason: collision with root package name */
            public static final a f13048c = new a();

            a() {
            }

            /* renamed from: a */
            public final Boolean apply(com.google.gson.i it) {
                kotlin.jvm.internal.j.e(it, "it");
                return Boolean.TRUE;
            }
        }

        h(DoubleClickInfoBean doubleClickInfoBean) {
            this.f13047d = doubleClickInfoBean;
        }

        /* renamed from: a */
        public final t<? extends Boolean> apply(Throwable throwable) {
            kotlin.jvm.internal.j.e(throwable, "throwable");
            if (SwitchRepository.this.F0(throwable)) {
                return SwitchRepository.this.L0(EnumFeatureType.DOUBLE_CLICK_CONFIG.getName(), this.f13047d).g0(a.f13048c);
            }
            return q.J(throwable);
        }
    }

    /* compiled from: SwitchRepository.kt */
    /* loaded from: classes3.dex */
    static final class i implements io.reactivex.g0.a {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ DoubleClickInfoBean f13049b;

        i(DoubleClickInfoBean doubleClickInfoBean) {
            this.f13049b = doubleClickInfoBean;
        }

        @Override // io.reactivex.g0.a
        public final void run() {
            SwitchRepository.this.F.postValue(this.f13049b);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwitchRepository(ThingContext thingContext) {
        super(thingContext, IoTSubDevice.class, SubDeviceRunningInfoResult.class);
        kotlin.jvm.internal.j.e(thingContext, "thingContext");
        MutableLiveData<DelayActionInfoBean> mutableLiveData = new MutableLiveData<>();
        this.D = mutableLiveData;
        this.E = mutableLiveData;
        MutableLiveData<DoubleClickInfoBean> mutableLiveData2 = new MutableLiveData<>();
        this.F = mutableLiveData2;
        this.G = mutableLiveData2;
        com.tplink.libtpnetwork.IoTNetwork.util.a aVar = new com.tplink.libtpnetwork.IoTNetwork.util.a();
        this.H = aVar;
        this.I = aVar.c();
        ALIoTDevice ioTDevice = thingContext.getIoTDevice();
        LocalIoTBaseDevice localIoTDevice = ioTDevice != null ? ioTDevice.getLocalIoTDevice() : null;
        if (localIoTDevice instanceof IoTSubDevice) {
            this.n.postValue(localIoTDevice);
        } else {
            this.n.postValue(new IoTSubDevice());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p4() {
        if (this.C && this.H.d() >= 3) {
            TPIoTClientManager tPIoTClientManager = this.f13334b;
            T mThingContext = this.a;
            kotlin.jvm.internal.j.d(mThingContext, "mThingContext");
            tPIoTClientManager.J3(((ThingContext) mThingContext).getIoTDevice());
            return;
        }
        this.f13334b.a1();
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.repository.kb.b, com.tplink.libtpnetwork.IoTNetwork.repository.kb.c
    public io.reactivex.a i(boolean z) {
        DeviceInfoParams deviceInfoParams = new DeviceInfoParams();
        deviceInfoParams.setDeviceOn(Boolean.valueOf(z));
        p pVar = p.a;
        io.reactivex.a h2 = X3(deviceInfoParams).f(this.H.b()).h(new g());
        kotlin.jvm.internal.j.d(h2, "setDeviceShadow(DeviceIn…FailCount()\n            }");
        return h2;
    }

    public final LiveData<Integer> j4() {
        return this.I;
    }

    public final q<DelayActionInfoBean> k4() {
        q<DelayActionInfoBean> E = x0("get_delay_action_info", DelayActionInfoBean.class).o0(new a()).E(new b());
        kotlin.jvm.internal.j.d(E, "postRequest(IoTNetworkDe…stValue(it)\n            }");
        return E;
    }

    public final LiveData<DelayActionInfoBean> l4() {
        return this.E;
    }

    public final q<DoubleClickInfoBean> m4() {
        q<DoubleClickInfoBean> E = x0("get_double_click_info", DoubleClickInfoBean.class).o0(new c()).E(new d());
        kotlin.jvm.internal.j.d(E, "postRequest(IoTNetworkDe…stValue(it)\n            }");
        return E;
    }

    public final LiveData<DoubleClickInfoBean> n4() {
        return this.G;
    }

    public final boolean o4() {
        MutableLiveData<LocalIoTBaseDevice> mDeviceInfoLiveData = this.n;
        kotlin.jvm.internal.j.d(mDeviceInfoLiveData, "mDeviceInfoLiveData");
        LocalIoTBaseDevice value = mDeviceInfoLiveData.getValue();
        Boolean bool = null;
        if (!(value instanceof IoTSubDevice)) {
            value = null;
        }
        IoTSubDevice ioTSubDevice = (IoTSubDevice) value;
        if (ioTSubDevice != null) {
            bool = Boolean.valueOf(ioTSubDevice.isAtLowBattery());
        } else {
            LiveData<BatteryDetectInfoResult> batteryDetectInfoLiveData = U0();
            kotlin.jvm.internal.j.d(batteryDetectInfoLiveData, "batteryDetectInfoLiveData");
            BatteryDetectInfoResult value2 = batteryDetectInfoLiveData.getValue();
            if (value2 != null) {
                bool = Boolean.valueOf(value2.isLow());
            }
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final io.reactivex.a q4(DelayActionInfoBean info) {
        kotlin.jvm.internal.j.e(info, "info");
        io.reactivex.a i2 = y0("set_delay_action_info", info, Boolean.class).o0(new e(info)).Z().i(new f(info));
        kotlin.jvm.internal.j.d(i2, "postRequest(IoTNetworkDe…Value(info)\n            }");
        return i2;
    }

    public final io.reactivex.a r4(DoubleClickInfoBean info) {
        kotlin.jvm.internal.j.e(info, "info");
        io.reactivex.a i2 = y0("set_double_click_info", info, Boolean.class).o0(new h(info)).Z().i(new i(info));
        kotlin.jvm.internal.j.d(i2, "postRequest(IoTNetworkDe…Value(info)\n            }");
        return i2;
    }

    public final void s4(boolean z) {
        this.C = z;
    }
}
