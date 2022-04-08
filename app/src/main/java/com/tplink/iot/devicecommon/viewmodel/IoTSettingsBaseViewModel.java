package com.tplink.iot.devicecommon.viewmodel;

import android.app.Application;
import androidx.annotation.DrawableRes;
import androidx.arch.core.util.Function;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.tplink.cloud.bean.common.CloudResult;
import com.tplink.cloud.define.CloudException;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.device.DeviceManagerInfoBean;
import com.tplink.libtpnetwork.TPCloudNetwork.device.TCDeviceUserInfoBean;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import java.util.List;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.m;
import kotlin.p;

/* compiled from: IoTSettingsBaseViewModel.kt */
/* loaded from: classes2.dex */
public abstract class IoTSettingsBaseViewModel extends AndroidViewModel {
    static final /* synthetic */ kotlin.reflect.j[] a = {m.h(new PropertyReference1Impl(IoTSettingsBaseViewModel.class, "mTPIoTClientManager", "getMTPIoTClientManager()Lcom/tplink/libtpnetwork/IoTNetwork/TPIoTClientManager;", 0)), m.h(new PropertyReference1Impl(IoTSettingsBaseViewModel.class, "alIoTDeviceLiveData", "getAlIoTDeviceLiveData()Landroidx/lifecycle/LiveData;", 0))};

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.t.c f7421b;

    /* renamed from: c  reason: collision with root package name */
    private final String f7422c;

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.t.c f7423d;

    /* renamed from: e  reason: collision with root package name */
    private final SingleLiveEvent<com.tplink.iot.viewmodel.quicksetup.i<p>> f7424e;

    /* renamed from: f  reason: collision with root package name */
    private final LiveData<com.tplink.iot.viewmodel.quicksetup.i<p>> f7425f;
    private final SingleLiveEvent<com.tplink.iot.viewmodel.quicksetup.i<CloudResult<Void>>> g;
    private final LiveData<com.tplink.iot.viewmodel.quicksetup.i<CloudResult<Void>>> h;
    private final LiveData<Boolean> i;
    private final LiveData<Integer> j;
    private final LiveData<String> k;
    private final LiveData<String> l;
    private LiveData<Boolean> m;
    private final LiveData<String> n;

    /* compiled from: DelegateUtils.kt */
    /* loaded from: classes2.dex */
    public static final class a implements kotlin.t.c<Object, TPIoTClientManager> {
        private final TPIoTClientManager a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ThingContext f7426b;

        /* JADX WARN: Type inference failed for: r2v2, types: [b.d.b.f.a, com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager, java.lang.Object] */
        /* JADX WARN: Unknown variable types count: 1 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public a(com.tplink.libtpnetwork.IoTNetwork.ThingContext r2) {
            /*
                r1 = this;
                r1.f7426b = r2
                r1.<init>()
                com.tplink.cloud.context.b r2 = r2.getAccountContext()
                java.lang.Class<com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager> r0 = com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager.class
                b.d.b.f.a r2 = b.d.b.f.b.a(r2, r0)
                java.lang.String r0 = "CloudRepositoryProviders…ontext, REPO::class.java)"
                kotlin.jvm.internal.j.d(r2, r0)
                r1.a = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.devicecommon.viewmodel.IoTSettingsBaseViewModel.a.<init>(com.tplink.libtpnetwork.IoTNetwork.ThingContext):void");
        }

        /* renamed from: c */
        public TPIoTClientManager b(Object thisRef, kotlin.reflect.j<?> property) {
            kotlin.jvm.internal.j.e(thisRef, "thisRef");
            kotlin.jvm.internal.j.e(property, "property");
            return this.a;
        }
    }

    /* compiled from: IoTSettingsBaseViewModel.kt */
    /* loaded from: classes2.dex */
    static final class b implements io.reactivex.g0.a {
        b() {
        }

        @Override // io.reactivex.g0.a
        public final void run() {
            IoTSettingsBaseViewModel.this.g.setValue(new com.tplink.iot.viewmodel.quicksetup.i(0, null));
        }
    }

    /* compiled from: IoTSettingsBaseViewModel.kt */
    /* loaded from: classes2.dex */
    static final class c<T> implements io.reactivex.g0.g<Throwable> {
        c() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            if (th instanceof CloudException) {
                IoTSettingsBaseViewModel.this.g.setValue(new com.tplink.iot.viewmodel.quicksetup.i(((CloudException) th).getErrCode(), null));
            } else {
                IoTSettingsBaseViewModel.this.g.setValue(new com.tplink.iot.viewmodel.quicksetup.i(1, null));
            }
        }
    }

    /* compiled from: IoTSettingsBaseViewModel.kt */
    /* loaded from: classes2.dex */
    static final class d<I, O> implements Function<BaseALIoTDevice<?>, Integer> {
        d() {
        }

        /* renamed from: a */
        public final Integer apply(BaseALIoTDevice<?> baseALIoTDevice) {
            return Integer.valueOf(IoTSettingsBaseViewModel.this.l(baseALIoTDevice != null ? baseALIoTDevice.getDeviceIcon() : null));
        }
    }

    /* compiled from: IoTSettingsBaseViewModel.kt */
    /* loaded from: classes2.dex */
    static final class e<I, O> implements Function<BaseALIoTDevice<?>, String> {
        public static final e a = new e();

        e() {
        }

        /* renamed from: a */
        public final String apply(BaseALIoTDevice<?> baseALIoTDevice) {
            String deviceFwVer;
            return (baseALIoTDevice == null || (deviceFwVer = baseALIoTDevice.getDeviceFwVer()) == null) ? "" : deviceFwVer;
        }
    }

    /* compiled from: IoTSettingsBaseViewModel.kt */
    /* loaded from: classes2.dex */
    static final class f<I, O> implements Function<BaseALIoTDevice<?>, Boolean> {
        public static final f a = new f();

        f() {
        }

        /* renamed from: a */
        public final Boolean apply(BaseALIoTDevice<?> baseALIoTDevice) {
            boolean z = true;
            if (baseALIoTDevice != null && baseALIoTDevice.isSupportIoTCloud() && !baseALIoTDevice.isUserRoleTypeDevice()) {
                z = false;
            }
            return Boolean.valueOf(z);
        }
    }

    /* compiled from: IoTSettingsBaseViewModel.kt */
    /* loaded from: classes2.dex */
    static final class g<I, O> implements Function<BaseALIoTDevice<?>, Boolean> {
        public static final g a = new g();

        g() {
        }

        /* renamed from: a */
        public final Boolean apply(BaseALIoTDevice<?> baseALIoTDevice) {
            Object obj = null;
            Object localIoTDevice = baseALIoTDevice != null ? baseALIoTDevice.getLocalIoTDevice() : null;
            if (localIoTDevice instanceof LocalIoTBaseDevice) {
                obj = localIoTDevice;
            }
            LocalIoTBaseDevice localIoTBaseDevice = (LocalIoTBaseDevice) obj;
            return Boolean.valueOf(localIoTBaseDevice != null ? localIoTBaseDevice.isSupportFirmware() : false);
        }
    }

    /* compiled from: IoTSettingsBaseViewModel.kt */
    /* loaded from: classes2.dex */
    static final class h<I, O> implements Function<BaseALIoTDevice<?>, String> {
        h() {
        }

        /* renamed from: a */
        public final String apply(BaseALIoTDevice<?> baseALIoTDevice) {
            Application application = IoTSettingsBaseViewModel.this.getApplication();
            String str = null;
            String deviceType = baseALIoTDevice != null ? baseALIoTDevice.getDeviceType() : null;
            String deviceName = baseALIoTDevice != null ? baseALIoTDevice.getDeviceName() : null;
            if (baseALIoTDevice != null) {
                str = baseALIoTDevice.getDeviceModel();
            }
            return l.e(application, deviceType, deviceName, str);
        }
    }

    /* compiled from: IoTSettingsBaseViewModel.kt */
    /* loaded from: classes2.dex */
    static final class i<I, O> implements Function<BaseALIoTDevice<?>, String> {
        public static final i a = new i();

        i() {
        }

        /* renamed from: a */
        public final String apply(BaseALIoTDevice<?> baseALIoTDevice) {
            return l.h(baseALIoTDevice);
        }
    }

    /* compiled from: IoTSettingsBaseViewModel.kt */
    /* loaded from: classes2.dex */
    static final class j<T> implements io.reactivex.g0.g<Boolean> {
        j() {
        }

        /* renamed from: a */
        public final void accept(Boolean bool) {
            IoTSettingsBaseViewModel.this.f7424e.setValue(new com.tplink.iot.viewmodel.quicksetup.i(0, null));
        }
    }

    /* compiled from: IoTSettingsBaseViewModel.kt */
    /* loaded from: classes2.dex */
    static final class k<T> implements io.reactivex.g0.g<Throwable> {
        k() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            if (th instanceof CloudException) {
                IoTSettingsBaseViewModel.this.f7424e.setValue(new com.tplink.iot.viewmodel.quicksetup.i(((CloudException) th).getErrCode(), null));
            } else {
                IoTSettingsBaseViewModel.this.f7424e.setValue(new com.tplink.iot.viewmodel.quicksetup.i(1, null));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IoTSettingsBaseViewModel(Application application, ThingContext iotDeviceContext) {
        super(application);
        kotlin.jvm.internal.j.e(application, "application");
        kotlin.jvm.internal.j.e(iotDeviceContext, "iotDeviceContext");
        this.f7421b = new a(iotDeviceContext);
        String deviceIdMD5 = iotDeviceContext.getDeviceIdMD5();
        this.f7422c = deviceIdMD5 == null ? "" : deviceIdMD5;
        this.f7423d = com.tplink.iot.Utils.extension.c.a(iotDeviceContext);
        SingleLiveEvent<com.tplink.iot.viewmodel.quicksetup.i<p>> singleLiveEvent = new SingleLiveEvent<>();
        this.f7424e = singleLiveEvent;
        this.f7425f = singleLiveEvent;
        SingleLiveEvent<com.tplink.iot.viewmodel.quicksetup.i<CloudResult<Void>>> singleLiveEvent2 = new SingleLiveEvent<>();
        this.g = singleLiveEvent2;
        this.h = singleLiveEvent2;
        LiveData<Boolean> map = Transformations.map(j(), f.a);
        kotlin.jvm.internal.j.d(map, "Transformations.map(alIo…ypeDevice\n        }\n    }");
        this.i = map;
        LiveData<Integer> map2 = Transformations.map(j(), new d());
        kotlin.jvm.internal.j.d(map2, "Transformations.map(alIo…Res(it?.deviceIcon)\n    }");
        this.j = map2;
        LiveData<String> map3 = Transformations.map(j(), new h());
        kotlin.jvm.internal.j.d(map3, "Transformations.map(alIo…e, it?.deviceModel)\n    }");
        this.k = map3;
        LiveData<String> map4 = Transformations.map(j(), i.a);
        kotlin.jvm.internal.j.d(map4, "Transformations.map(alIo…getRoomLocation(it)\n    }");
        this.l = map4;
        LiveData<Boolean> map5 = Transformations.map(j(), g.a);
        kotlin.jvm.internal.j.d(map5, "Transformations.map(alIo…rtFirmware ?: false\n    }");
        this.m = map5;
        LiveData<String> map6 = Transformations.map(j(), e.a);
        kotlin.jvm.internal.j.d(map6, "Transformations.map(alIo…{ it?.deviceFwVer ?: \"\" }");
        this.n = map6;
    }

    public final void f(String deviceIdMD5) {
        List<String> b2;
        kotlin.jvm.internal.j.e(deviceIdMD5, "deviceIdMD5");
        TPIoTClientManager s = s();
        b2 = kotlin.collections.m.b(deviceIdMD5);
        s.w(b2).r(io.reactivex.d0.b.a.a()).i(new b()).j(new c()).y();
    }

    public final LiveData<com.tplink.iot.viewmodel.quicksetup.i<CloudResult<Void>>> i() {
        return this.h;
    }

    public final LiveData<BaseALIoTDevice<?>> j() {
        return (LiveData) this.f7423d.b(this, a[1]);
    }

    public final LiveData<Integer> k() {
        return this.j;
    }

    @DrawableRes
    public abstract int l(String str);

    public abstract void m();

    public final int n() {
        DeviceManagerInfoBean deviceManagerInfo;
        List<TCDeviceUserInfoBean> userInfo;
        BaseALIoTDevice<?> value = j().getValue();
        return ((value == null || (deviceManagerInfo = value.getDeviceManagerInfo()) == null || (userInfo = deviceManagerInfo.getUserInfo()) == null) ? 1 : userInfo.size()) - 1;
    }

    public abstract void o();

    public abstract LiveData<ThingFirmware> p();

    public final LiveData<String> r() {
        return this.n;
    }

    protected final TPIoTClientManager s() {
        return (TPIoTClientManager) this.f7421b.b(this, a[0]);
    }

    public final LiveData<String> t() {
        return this.k;
    }

    public final LiveData<String> u() {
        return this.l;
    }

    public final LiveData<com.tplink.iot.viewmodel.quicksetup.i<p>> v() {
        return this.f7425f;
    }

    public final boolean w() {
        BaseALIoTDevice<?> value = j().getValue();
        if (value != null) {
            return value.isUserRoleTypeDevice();
        }
        return false;
    }

    public LiveData<Boolean> x() {
        return this.i;
    }

    public final LiveData<Boolean> y() {
        return this.m;
    }

    public final void z(String deviceIdMD5) {
        kotlin.jvm.internal.j.e(deviceIdMD5, "deviceIdMD5");
        s().n1(deviceIdMD5).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new j()).C(new k()).F0();
    }
}
