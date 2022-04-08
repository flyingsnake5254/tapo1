package com.tplink.iot.devicecommon.viewmodel;

import android.app.Application;
import android.text.TextUtils;
import androidx.arch.core.util.Function;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.CloudConnectStateResult;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.ThingBaseRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.device.DeviceManagerInfoBean;
import com.tplink.libtpnetwork.TPCloudNetwork.device.TCDeviceUserInfoBean;
import io.reactivex.q;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.m;

/* compiled from: IoTDetailBaseViewModel.kt */
/* loaded from: classes2.dex */
public abstract class IoTDetailBaseViewModel extends AndroidViewModel {
    static final /* synthetic */ kotlin.reflect.j[] a = {m.h(new PropertyReference1Impl(IoTDetailBaseViewModel.class, "mTPIoTClientManager", "getMTPIoTClientManager()Lcom/tplink/libtpnetwork/IoTNetwork/TPIoTClientManager;", 0)), m.h(new PropertyReference1Impl(IoTDetailBaseViewModel.class, "alIoTDeviceLiveData", "getAlIoTDeviceLiveData()Landroidx/lifecycle/LiveData;", 0))};

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.t.c f7411b;

    /* renamed from: c  reason: collision with root package name */
    private final String f7412c;

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.t.c f7413d;

    /* renamed from: e  reason: collision with root package name */
    private final MutableLiveData<com.tplink.iot.viewmodel.quicksetup.i<CloudConnectStateResult>> f7414e;

    /* renamed from: f  reason: collision with root package name */
    private final LiveData<com.tplink.iot.viewmodel.quicksetup.i<CloudConnectStateResult>> f7415f;
    private boolean g;
    private final MediatorLiveData<Boolean> h;
    private io.reactivex.e0.c i;
    private final LiveData<String> j;
    private final LiveData<String> k;
    private final LiveData<Boolean> l;
    private final LiveData<Boolean> m;
    private final LiveData<Boolean> n;
    private final LiveData<Integer> o;
    private final LiveData<Boolean> p;
    private final LiveData<Boolean> q;

    /* compiled from: DelegateUtils.kt */
    /* loaded from: classes2.dex */
    public static final class a implements kotlin.t.c<Object, TPIoTClientManager> {
        private final TPIoTClientManager a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ThingContext f7416b;

        /* JADX WARN: Type inference failed for: r2v2, types: [b.d.b.f.a, com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager, java.lang.Object] */
        /* JADX WARN: Unknown variable types count: 1 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public a(com.tplink.libtpnetwork.IoTNetwork.ThingContext r2) {
            /*
                r1 = this;
                r1.f7416b = r2
                r1.<init>()
                com.tplink.cloud.context.b r2 = r2.getAccountContext()
                java.lang.Class<com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager> r0 = com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager.class
                b.d.b.f.a r2 = b.d.b.f.b.a(r2, r0)
                java.lang.String r0 = "CloudRepositoryProviders…ontext, REPO::class.java)"
                kotlin.jvm.internal.j.d(r2, r0)
                r1.a = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.devicecommon.viewmodel.IoTDetailBaseViewModel.a.<init>(com.tplink.libtpnetwork.IoTNetwork.ThingContext):void");
        }

        /* renamed from: c */
        public TPIoTClientManager b(Object thisRef, kotlin.reflect.j<?> property) {
            kotlin.jvm.internal.j.e(thisRef, "thisRef");
            kotlin.jvm.internal.j.e(property, "property");
            return this.a;
        }
    }

    /* compiled from: IoTDetailBaseViewModel.kt */
    /* loaded from: classes2.dex */
    static final class b<T> implements io.reactivex.g0.g<CloudConnectStateResult> {
        b() {
        }

        /* renamed from: a */
        public final void accept(CloudConnectStateResult cloudConnectStateResult) {
            IoTDetailBaseViewModel.this.m().postValue(new com.tplink.iot.viewmodel.quicksetup.i<>(0, cloudConnectStateResult));
        }
    }

    /* compiled from: IoTDetailBaseViewModel.kt */
    /* loaded from: classes2.dex */
    static final class c<T> implements io.reactivex.g0.g<Throwable> {
        c() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            IoTDetailBaseViewModel.this.m().postValue(new com.tplink.iot.viewmodel.quicksetup.i<>(1, null));
        }
    }

    /* compiled from: IoTDetailBaseViewModel.kt */
    /* loaded from: classes2.dex */
    static final class d<I, O> implements Function<BaseALIoTDevice<?>, Integer> {
        public static final d a = new d();

        d() {
        }

        /* renamed from: a */
        public final Integer apply(BaseALIoTDevice<?> baseALIoTDevice) {
            DeviceManagerInfoBean deviceManagerInfo;
            List<TCDeviceUserInfoBean> userInfo;
            return Integer.valueOf(Math.max(((baseALIoTDevice == null || (deviceManagerInfo = baseALIoTDevice.getDeviceManagerInfo()) == null || (userInfo = deviceManagerInfo.getUserInfo()) == null) ? 1 : userInfo.size()) - 1, 0));
        }
    }

    /* compiled from: IoTDetailBaseViewModel.kt */
    /* loaded from: classes2.dex */
    static final class e<I, O> implements Function<BaseALIoTDevice<?>, Boolean> {
        public static final e a = new e();

        e() {
        }

        /* renamed from: a */
        public final Boolean apply(BaseALIoTDevice<?> baseALIoTDevice) {
            return Boolean.valueOf(baseALIoTDevice != null ? baseALIoTDevice.isCommonDevice() : true);
        }
    }

    /* compiled from: IoTDetailBaseViewModel.kt */
    /* loaded from: classes2.dex */
    static final class f<I, O> implements Function<BaseALIoTDevice<?>, Boolean> {
        public static final f a = new f();

        f() {
        }

        /* renamed from: a */
        public final Boolean apply(BaseALIoTDevice<?> baseALIoTDevice) {
            return Boolean.valueOf(baseALIoTDevice != null ? baseALIoTDevice.isSupportIoTCloud() : false);
        }
    }

    /* compiled from: IoTDetailBaseViewModel.kt */
    /* loaded from: classes2.dex */
    static final class g<I, O> implements Function<String, Boolean> {
        public static final g a = new g();

        g() {
        }

        /* renamed from: a */
        public final Boolean apply(String str) {
            return Boolean.valueOf(!TextUtils.isEmpty(str));
        }
    }

    /* compiled from: IoTDetailBaseViewModel.kt */
    /* loaded from: classes2.dex */
    static final class h<I, O> implements Function<BaseALIoTDevice<?>, Boolean> {
        public static final h a = new h();

        h() {
        }

        /* renamed from: a */
        public final Boolean apply(BaseALIoTDevice<?> baseALIoTDevice) {
            boolean z = true;
            if (baseALIoTDevice != null && ((baseALIoTDevice.isSupportIoTCloud() || baseALIoTDevice.getCloudIoTDevice() != null) && !baseALIoTDevice.isUserRoleTypeDevice())) {
                z = false;
            }
            return Boolean.valueOf(z);
        }
    }

    /* compiled from: IoTDetailBaseViewModel.kt */
    /* loaded from: classes2.dex */
    static final class i<I, O> implements Function<BaseALIoTDevice<?>, Boolean> {
        public static final i a = new i();

        i() {
        }

        /* renamed from: a */
        public final Boolean apply(BaseALIoTDevice<?> baseALIoTDevice) {
            return Boolean.valueOf(baseALIoTDevice != null ? baseALIoTDevice.isUserRoleTypeDevice() : false);
        }
    }

    /* compiled from: IoTDetailBaseViewModel.kt */
    /* loaded from: classes2.dex */
    static final class j<I, O> implements Function<BaseALIoTDevice<?>, String> {
        j() {
        }

        /* renamed from: a */
        public final String apply(BaseALIoTDevice<?> baseALIoTDevice) {
            Application application = IoTDetailBaseViewModel.this.getApplication();
            String str = null;
            String deviceType = baseALIoTDevice != null ? baseALIoTDevice.getDeviceType() : null;
            String deviceName = baseALIoTDevice != null ? baseALIoTDevice.getDeviceName() : null;
            if (baseALIoTDevice != null) {
                str = baseALIoTDevice.getDeviceModel();
            }
            return com.tplink.iot.Utils.z0.l.e(application, deviceType, deviceName, str);
        }
    }

    /* compiled from: IoTDetailBaseViewModel.kt */
    /* loaded from: classes2.dex */
    static final class k<I, O> implements Function<BaseALIoTDevice<?>, String> {
        public static final k a = new k();

        k() {
        }

        /* renamed from: a */
        public final String apply(BaseALIoTDevice<?> baseALIoTDevice) {
            return com.tplink.iot.Utils.z0.l.h(baseALIoTDevice);
        }
    }

    /* compiled from: IoTDetailBaseViewModel.kt */
    /* loaded from: classes2.dex */
    static final class l<T> implements io.reactivex.g0.g<Long> {
        l() {
        }

        /* renamed from: a */
        public final void accept(Long l) {
            if (IoTDetailBaseViewModel.this.r().D()) {
                IoTDetailBaseViewModel.this.E();
                return;
            }
            io.reactivex.e0.c cVar = IoTDetailBaseViewModel.this.i;
            if (cVar != null) {
                cVar.dispose();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IoTDetailBaseViewModel(Application application, ThingContext iotDeviceContext) {
        super(application);
        kotlin.jvm.internal.j.e(application, "application");
        kotlin.jvm.internal.j.e(iotDeviceContext, "iotDeviceContext");
        this.f7411b = new a(iotDeviceContext);
        String deviceIdMD5 = iotDeviceContext.getDeviceIdMD5();
        this.f7412c = deviceIdMD5 == null ? "" : deviceIdMD5;
        this.f7413d = com.tplink.iot.Utils.extension.c.a(iotDeviceContext);
        MutableLiveData<com.tplink.iot.viewmodel.quicksetup.i<CloudConnectStateResult>> mutableLiveData = new MutableLiveData<>();
        this.f7414e = mutableLiveData;
        this.f7415f = mutableLiveData;
        this.h = new MediatorLiveData<>();
        LiveData<String> map = Transformations.map(i(), new j());
        kotlin.jvm.internal.j.d(map, "Transformations.map(alIo…e, it?.deviceModel)\n    }");
        this.j = map;
        LiveData<String> map2 = Transformations.map(i(), k.a);
        kotlin.jvm.internal.j.d(map2, "Transformations.map(alIo…getRoomLocation(it)\n    }");
        this.k = map2;
        LiveData<Boolean> map3 = Transformations.map(map2, g.a);
        kotlin.jvm.internal.j.d(map3, "Transformations.map(room…xtUtils.isEmpty(it)\n    }");
        this.l = map3;
        LiveData<Boolean> map4 = Transformations.map(i(), e.a);
        kotlin.jvm.internal.j.d(map4, "Transformations.map(alIo….isCommonDevice ?: true }");
        this.m = map4;
        LiveData<Boolean> map5 = Transformations.map(i(), f.a);
        kotlin.jvm.internal.j.d(map5, "Transformations.map(alIo…upportIoTCloud ?: false }");
        this.n = map5;
        LiveData<Integer> map6 = Transformations.map(i(), d.a);
        kotlin.jvm.internal.j.d(map6, "Transformations.map(alIo….size ?: 1) - 1, 0)\n    }");
        this.o = map6;
        LiveData<Boolean> map7 = Transformations.map(i(), i.a);
        kotlin.jvm.internal.j.d(map7, "Transformations.map(alIo…TypeDevice ?: false\n    }");
        this.p = map7;
        LiveData<Boolean> map8 = Transformations.map(i(), h.a);
        kotlin.jvm.internal.j.d(map8, "Transformations.map(alIo…e\n        } ?: true\n    }");
        this.q = map8;
    }

    public final LiveData<Boolean> A() {
        return this.p;
    }

    public final boolean B() {
        return com.tplink.iot.Utils.w0.a.d(this.f7412c);
    }

    public final boolean C() {
        return com.tplink.iot.Utils.w0.a.i(this.f7412c);
    }

    public final boolean D() {
        ALIoTDevice ioTDevice;
        ThingContext k2 = TPIoTClientManager.k2(this.f7412c);
        if (k2 == null || (ioTDevice = k2.getIoTDevice()) == null) {
            return false;
        }
        return ioTDevice.isUserRoleTypeDevice();
    }

    public abstract void E();

    public abstract void F();

    public final void G() {
        H();
        if (!r().D()) {
            E();
        } else {
            this.i = q.a0(0L, 20L, TimeUnit.SECONDS).G0(new l());
        }
    }

    public final void H() {
        io.reactivex.e0.c cVar = this.i;
        if (cVar != null) {
            cVar.dispose();
        }
    }

    public final void g(boolean z) {
        r().J0(z).y();
    }

    public final void h() {
        j().E(new b()).C(new c()).F0();
    }

    public final LiveData<BaseALIoTDevice<?>> i() {
        return (LiveData) this.f7413d.b(this, a[1]);
    }

    public abstract q<CloudConnectStateResult> j();

    public final LiveData<com.tplink.iot.viewmodel.quicksetup.i<CloudConnectStateResult>> k() {
        return this.f7415f;
    }

    public final LiveData<Integer> l() {
        return this.o;
    }

    protected final MutableLiveData<com.tplink.iot.viewmodel.quicksetup.i<CloudConnectStateResult>> m() {
        return this.f7414e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String n() {
        return this.f7412c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MediatorLiveData<Boolean> o() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final TPIoTClientManager p() {
        return (TPIoTClientManager) this.f7411b.b(this, a[0]);
    }

    public abstract ThingBaseRepository r();

    public final LiveData<String> s() {
        return this.j;
    }

    public final LiveData<String> t() {
        return this.k;
    }

    public final LiveData<Boolean> u() {
        if (!this.g) {
            this.g = true;
            F();
        }
        return this.h;
    }

    public final LiveData<Boolean> v() {
        return this.m;
    }

    public final LiveData<Boolean> w() {
        return this.n;
    }

    public final LiveData<Boolean> x() {
        return this.l;
    }

    public final boolean y() {
        ALIoTDevice b2 = com.tplink.iot.Utils.w0.a.b(this.f7412c);
        if (b2 == null) {
            return true;
        }
        if (b2.isSupportIoTCloudComponent()) {
            if (b2.getThingDevice() == null) {
                return true;
            }
        } else if (b2.getCloudIoTDevice() == null) {
            return true;
        }
        return false;
    }

    public final LiveData<Boolean> z() {
        return this.q;
    }
}
