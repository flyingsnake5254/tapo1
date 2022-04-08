package com.tplink.iot.devices.featuredactions.viewmodel.base;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.tplink.iot.cloud.bean.smart.common.SmartAction;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.cloud.bean.smart.common.SmartLocation;
import com.tplink.iot.cloud.bean.smart.common.SmartPeriodSetting;
import com.tplink.iot.cloud.bean.smart.common.SmartThingAction;
import com.tplink.iot.cloud.bean.smart.common.SmartThingTrigger;
import com.tplink.iot.cloud.bean.smart.common.SmartTimeSetting;
import com.tplink.iot.cloud.bean.smart.common.SmartTrigger;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.cloud.bean.thing.common.ThingInfo;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractSubThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.SmartRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.ThingBaseRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository;
import io.reactivex.f;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import kotlin.collections.n;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.m;
import kotlin.reflect.j;

/* compiled from: AbstractFeaturedActionViewModel.kt */
/* loaded from: classes2.dex */
public abstract class AbstractFeaturedActionViewModel extends AndroidViewModel {
    static final /* synthetic */ j[] a = {m.h(new PropertyReference1Impl(AbstractFeaturedActionViewModel.class, "mThingCloudRepository", "getMThingCloudRepository()Lcom/tplink/libtpnetwork/TPCloudNetwork/repository/ThingCloudRepository;", 0)), m.h(new PropertyReference1Impl(AbstractFeaturedActionViewModel.class, "mTPIoTClientManager", "getMTPIoTClientManager()Lcom/tplink/libtpnetwork/IoTNetwork/TPIoTClientManager;", 0)), m.h(new PropertyReference1Impl(AbstractFeaturedActionViewModel.class, "mSmartRepository", "getMSmartRepository()Lcom/tplink/libtpnetwork/IoTNetwork/repository/SmartRepository;", 0)), m.h(new PropertyReference1Impl(AbstractFeaturedActionViewModel.class, "mBaseALIoTDeviceLiveData", "getMBaseALIoTDeviceLiveData()Landroidx/lifecycle/LiveData;", 0))};

    /* renamed from: e  reason: collision with root package name */
    private final ALIoTDevice f7474e;

    /* renamed from: f  reason: collision with root package name */
    private final LiveData<List<BaseALIoTDevice<?>>> f7475f;
    private final kotlin.t.c g;
    private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> h;
    private final LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> i;
    private final MutableLiveData<List<com.tplink.iot.g.a.a.b>> k;
    private final LiveData<List<com.tplink.iot.g.a.a.b>> l;

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.t.c f7471b = new a();

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.t.c f7472c = new b();

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.t.c f7473d = new c();
    private final HashMap<String, com.tplink.iot.g.a.a.b> j = new HashMap<>();

    /* compiled from: DelegateUtils.kt */
    /* loaded from: classes2.dex */
    public static final class a implements kotlin.t.c<Object, ThingCloudRepository> {
        private final ThingCloudRepository a;

        /* JADX WARN: Type inference failed for: r0v1, types: [b.d.b.f.a, java.lang.Object, com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository] */
        /* JADX WARN: Unknown variable types count: 1 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public a() {
            /*
                r2 = this;
                r2.<init>()
                com.tplink.cloud.context.b r0 = b.d.s.a.a.f()
                java.lang.Class<com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository> r1 = com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository.class
                b.d.b.f.a r0 = b.d.b.f.b.a(r0, r1)
                java.lang.String r1 = "CloudRepositoryProviders…text(), REPO::class.java)"
                kotlin.jvm.internal.j.d(r0, r1)
                r2.a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.devices.featuredactions.viewmodel.base.AbstractFeaturedActionViewModel.a.<init>():void");
        }

        /* renamed from: c */
        public ThingCloudRepository b(Object thisRef, j<?> property) {
            kotlin.jvm.internal.j.e(thisRef, "thisRef");
            kotlin.jvm.internal.j.e(property, "property");
            return this.a;
        }
    }

    /* compiled from: DelegateUtils.kt */
    /* loaded from: classes2.dex */
    public static final class b implements kotlin.t.c<Object, TPIoTClientManager> {
        private final TPIoTClientManager a;

        /* JADX WARN: Type inference failed for: r0v1, types: [b.d.b.f.a, com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager, java.lang.Object] */
        /* JADX WARN: Unknown variable types count: 1 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public b() {
            /*
                r2 = this;
                r2.<init>()
                com.tplink.cloud.context.b r0 = b.d.s.a.a.f()
                java.lang.Class<com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager> r1 = com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager.class
                b.d.b.f.a r0 = b.d.b.f.b.a(r0, r1)
                java.lang.String r1 = "CloudRepositoryProviders…text(), REPO::class.java)"
                kotlin.jvm.internal.j.d(r0, r1)
                r2.a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.devices.featuredactions.viewmodel.base.AbstractFeaturedActionViewModel.b.<init>():void");
        }

        /* renamed from: c */
        public TPIoTClientManager b(Object thisRef, j<?> property) {
            kotlin.jvm.internal.j.e(thisRef, "thisRef");
            kotlin.jvm.internal.j.e(property, "property");
            return this.a;
        }
    }

    /* compiled from: DelegateUtils.kt */
    /* loaded from: classes2.dex */
    public static final class c implements kotlin.t.c<Object, SmartRepository> {
        private final SmartRepository a;

        /* JADX WARN: Type inference failed for: r0v1, types: [com.tplink.libtpnetwork.IoTNetwork.repository.SmartRepository, b.d.b.f.a, java.lang.Object] */
        /* JADX WARN: Unknown variable types count: 1 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public c() {
            /*
                r2 = this;
                r2.<init>()
                com.tplink.cloud.context.b r0 = b.d.s.a.a.f()
                java.lang.Class<com.tplink.libtpnetwork.IoTNetwork.repository.SmartRepository> r1 = com.tplink.libtpnetwork.IoTNetwork.repository.SmartRepository.class
                b.d.b.f.a r0 = b.d.b.f.b.a(r0, r1)
                java.lang.String r1 = "CloudRepositoryProviders…text(), REPO::class.java)"
                kotlin.jvm.internal.j.d(r0, r1)
                r2.a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.devices.featuredactions.viewmodel.base.AbstractFeaturedActionViewModel.c.<init>():void");
        }

        /* renamed from: c */
        public SmartRepository b(Object thisRef, j<?> property) {
            kotlin.jvm.internal.j.e(thisRef, "thisRef");
            kotlin.jvm.internal.j.e(property, "property");
            return this.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractFeaturedActionViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class d implements f {

        /* compiled from: AbstractFeaturedActionViewModel.kt */
        /* loaded from: classes2.dex */
        static final class a<T> implements g<io.reactivex.e0.c> {
            a() {
            }

            /* renamed from: a */
            public final void accept(io.reactivex.e0.c cVar) {
                AbstractFeaturedActionViewModel.this.t().postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(100));
            }
        }

        /* compiled from: AbstractFeaturedActionViewModel.kt */
        /* loaded from: classes2.dex */
        static final class b implements io.reactivex.g0.a {
            b() {
            }

            @Override // io.reactivex.g0.a
            public final void run() {
                AbstractFeaturedActionViewModel.this.t().postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Integer.valueOf((int) ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION)));
            }
        }

        /* compiled from: AbstractFeaturedActionViewModel.kt */
        /* loaded from: classes2.dex */
        static final class c<T> implements g<Throwable> {
            c() {
            }

            /* renamed from: a */
            public final void accept(Throwable th) {
                AbstractFeaturedActionViewModel.this.t().postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(300));
            }
        }

        d() {
        }

        @Override // io.reactivex.f
        public final io.reactivex.e a(io.reactivex.a upstream) {
            kotlin.jvm.internal.j.e(upstream, "upstream");
            return upstream.l(new a()).i(new b()).j(new c());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractFeaturedActionViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class e<T> implements g<ThingFirmware> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.tplink.iot.g.a.a.b f7479d;

        e(com.tplink.iot.g.a.a.b bVar) {
            this.f7479d = bVar;
        }

        /* renamed from: a */
        public final void accept(ThingFirmware thingFirmware) {
            this.f7479d.d(thingFirmware);
            AbstractFeaturedActionViewModel.this.D();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractFeaturedActionViewModel(Application application, ThingContext iotDeviceContext) {
        super(application);
        kotlin.jvm.internal.j.e(application, "application");
        kotlin.jvm.internal.j.e(iotDeviceContext, "iotDeviceContext");
        this.f7474e = iotDeviceContext.getIoTDevice();
        MutableLiveData<List<BaseALIoTDevice>> C1 = v().C1();
        kotlin.jvm.internal.j.d(C1, "mTPIoTClientManager.allIoTDeviceLiveData");
        this.f7475f = C1;
        this.g = com.tplink.iot.Utils.extension.c.a(iotDeviceContext);
        MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> mutableLiveData = new MutableLiveData<>();
        this.h = mutableLiveData;
        this.i = mutableLiveData;
        MutableLiveData<List<com.tplink.iot.g.a.a.b>> mutableLiveData2 = new MutableLiveData<>();
        this.k = mutableLiveData2;
        this.l = mutableLiveData2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D() {
        this.k.postValue(new ArrayList(this.j.values()));
    }

    private final void E(com.tplink.iot.g.a.a.b bVar, ThingFirmware thingFirmware, q<ThingFirmware> qVar) {
        if (thingFirmware != null) {
            bVar.d(thingFirmware);
        } else {
            qVar.E(new e(bVar)).F0();
        }
    }

    private final void p() {
        Iterator it = new ArrayList(this.j.values()).iterator();
        while (it.hasNext()) {
            com.tplink.iot.g.a.a.b deviceInfo = (com.tplink.iot.g.a.a.b) it.next();
            if (!deviceInfo.c()) {
                String deviceIdMD5 = deviceInfo.a().getDeviceIdMD5();
                kotlin.jvm.internal.j.d(deviceIdMD5, "deviceInfo.device.deviceIdMD5");
                ThingBaseRepository d2 = com.tplink.libtpnetwork.IoTNetwork.util.c.d(deviceIdMD5);
                if (d2 instanceof AbstractThingRepository) {
                    kotlin.jvm.internal.j.d(deviceInfo, "deviceInfo");
                    AbstractThingRepository abstractThingRepository = (AbstractThingRepository) d2;
                    LiveData<ThingFirmware> w1 = abstractThingRepository.w1();
                    kotlin.jvm.internal.j.d(w1, "repo.firmwareLatestInfoData");
                    q<ThingFirmware> v1 = abstractThingRepository.v1();
                    kotlin.jvm.internal.j.d(v1, "repo.firmwareLatestInfo");
                    E(deviceInfo, w1.getValue(), v1);
                } else if (d2 instanceof AbstractSubThingRepository) {
                    kotlin.jvm.internal.j.d(deviceInfo, "deviceInfo");
                    AbstractSubThingRepository abstractSubThingRepository = (AbstractSubThingRepository) d2;
                    MutableLiveData<ThingFirmware> h1 = abstractSubThingRepository.h1();
                    kotlin.jvm.internal.j.d(h1, "repo.firmwareLatestInfoData");
                    q<ThingFirmware> g1 = abstractSubThingRepository.g1();
                    kotlin.jvm.internal.j.d(g1, "repo.firmwareLatestInfo");
                    E(deviceInfo, h1.getValue(), g1);
                }
            }
        }
        D();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SmartThingAction A(BaseALIoTDevice<?> baseALIoTDevice) {
        SmartThingAction smartThingAction = new SmartThingAction();
        String str = null;
        smartThingAction.setThingName(baseALIoTDevice != null ? baseALIoTDevice.getDeviceId() : null);
        smartThingAction.setCategory(baseALIoTDevice != null ? baseALIoTDevice.getCategory() : null);
        SmartRepository u = u();
        if (baseALIoTDevice != null) {
            str = baseALIoTDevice.getDeviceId();
        }
        ThingInfo N = u.N(str);
        if (N != null) {
            smartThingAction.setNickname(N.getNickname());
            smartThingAction.setAvatarUrl(N.getAvatarUrl());
            smartThingAction.setSubThing(N.isSubThing());
        }
        return smartThingAction;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SmartThingTrigger B(BaseALIoTDevice<?> baseALIoTDevice) {
        SmartThingTrigger smartThingTrigger = new SmartThingTrigger();
        String str = null;
        smartThingTrigger.setThingName(baseALIoTDevice != null ? baseALIoTDevice.getDeviceId() : null);
        smartThingTrigger.setCategory(baseALIoTDevice != null ? baseALIoTDevice.getCategory() : null);
        SmartRepository u = u();
        if (baseALIoTDevice != null) {
            str = baseALIoTDevice.getDeviceId();
        }
        ThingInfo N = u.N(str);
        if (N != null) {
            smartThingTrigger.setNickname(N.getNickname());
            smartThingTrigger.setAvatarUrl(N.getAvatarUrl());
            smartThingTrigger.setSubThing(N.isSubThing());
        }
        return smartThingTrigger;
    }

    protected final SmartTrigger C() {
        SmartTrigger smartTrigger = new SmartTrigger();
        smartTrigger.setManual(false);
        smartTrigger.setCondition(Byte.valueOf((byte) 0));
        smartTrigger.setSchedules(null);
        smartTrigger.setThings(null);
        return smartTrigger;
    }

    protected final void F(SmartInfo smartInfo) {
        kotlin.jvm.internal.j.e(smartInfo, "smartInfo");
        String a2 = com.tplink.iot.view.smart.a.g.a(smartInfo);
        if (a2.length() == 0) {
            a2 = SmartRepository.h[1];
        }
        smartInfo.setAvatarUrl(a2);
    }

    public final void G(List<com.tplink.iot.g.a.a.b> devices) {
        kotlin.jvm.internal.j.e(devices, "devices");
        this.j.clear();
        for (com.tplink.iot.g.a.a.b bVar : devices) {
            HashMap<String, com.tplink.iot.g.a.a.b> hashMap = this.j;
            String deviceIdMD5 = bVar.a().getDeviceIdMD5();
            kotlin.jvm.internal.j.d(deviceIdMD5, "deviceInfo.device.deviceIdMD5");
            hashMap.put(deviceIdMD5, bVar);
        }
        p();
        D();
    }

    public final void g(SmartInfo[] smarts) {
        kotlin.jvm.internal.j.e(smarts, "smarts");
        ArrayList arrayList = new ArrayList(smarts.length);
        for (SmartInfo smartInfo : smarts) {
            F(smartInfo);
            arrayList.add(u().F(smartInfo));
        }
        io.reactivex.a.p(arrayList).f(n()).y();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SmartPeriodSetting h(byte b2, SmartTimeSetting timeSetting) {
        kotlin.jvm.internal.j.e(timeSetting, "timeSetting");
        return new SmartPeriodSetting(SmartPeriodSetting.PeriodType.CUSTOM, b2, timeSetting);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SmartTimeSetting i(int i, int i2, int i3, int i4) {
        SmartTimeSetting smartTimeSetting = new SmartTimeSetting();
        smartTimeSetting.setStartTime((i * 60) + i2);
        smartTimeSetting.setEndTime((i3 * 60) + i4);
        return smartTimeSetting;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SmartInfo j(String title, SmartThingAction thingAction, List<? extends BaseALIoTDevice<?>> devices, p<? super SmartThingTrigger, ? super BaseALIoTDevice<?>, kotlin.p> configThingTrigger) {
        List<SmartThingAction> h;
        kotlin.jvm.internal.j.e(title, "title");
        kotlin.jvm.internal.j.e(thingAction, "thingAction");
        kotlin.jvm.internal.j.e(devices, "devices");
        kotlin.jvm.internal.j.e(configThingTrigger, "configThingTrigger");
        SmartInfo z = z(title);
        SmartAction y = y();
        h = n.h(thingAction);
        y.setThings(h);
        kotlin.p pVar = kotlin.p.a;
        z.setActionSetting(y);
        SmartTrigger C = C();
        ArrayList arrayList = new ArrayList();
        for (BaseALIoTDevice<?> baseALIoTDevice : devices) {
            SmartThingTrigger B = B(baseALIoTDevice);
            configThingTrigger.invoke(B, baseALIoTDevice);
            arrayList.add(B);
        }
        C.setThings(arrayList);
        z.setTriggerSetting(C);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SmartInfo k(String title, SmartThingTrigger thingTrigger, List<? extends BaseALIoTDevice<?>> devices, p<? super SmartThingAction, ? super BaseALIoTDevice<?>, kotlin.p> configThingAction) {
        List<SmartThingTrigger> h;
        kotlin.jvm.internal.j.e(title, "title");
        kotlin.jvm.internal.j.e(thingTrigger, "thingTrigger");
        kotlin.jvm.internal.j.e(devices, "devices");
        kotlin.jvm.internal.j.e(configThingAction, "configThingAction");
        SmartInfo z = z(title);
        SmartTrigger C = C();
        h = n.h(thingTrigger);
        C.setThings(h);
        kotlin.p pVar = kotlin.p.a;
        z.setTriggerSetting(C);
        SmartAction y = y();
        ArrayList arrayList = new ArrayList();
        for (BaseALIoTDevice<?> baseALIoTDevice : devices) {
            SmartThingAction A = A(baseALIoTDevice);
            configThingAction.invoke(A, baseALIoTDevice);
            arrayList.add(A);
        }
        y.setThings(arrayList);
        z.setActionSetting(y);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final byte l(String days) {
        int i;
        int a2;
        kotlin.jvm.internal.j.e(days, "days");
        try {
            a2 = kotlin.text.b.a(2);
            i = Integer.parseInt(days, a2);
        } catch (Exception unused) {
            i = 127;
        }
        return (byte) i;
    }

    public final LiveData<List<BaseALIoTDevice<?>>> m() {
        return this.f7475f;
    }

    protected final f n() {
        return new d();
    }

    public final LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> o() {
        return this.i;
    }

    public final LiveData<List<com.tplink.iot.g.a.a.b>> r() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ALIoTDevice s() {
        return this.f7474e;
    }

    protected final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> t() {
        return this.h;
    }

    protected final SmartRepository u() {
        return (SmartRepository) this.f7473d.b(this, a[2]);
    }

    protected final TPIoTClientManager v() {
        return (TPIoTClientManager) this.f7472c.b(this, a[1]);
    }

    protected final ThingCloudRepository w() {
        return (ThingCloudRepository) this.f7471b.b(this, a[0]);
    }

    public final ThingModel x(BaseALIoTDevice<?> baseALIoTDevice) {
        String thingModelId;
        ThingModel thingModel = null;
        if (baseALIoTDevice == null) {
            return null;
        }
        ThingContext thingContext = TPIoTClientManager.k2(baseALIoTDevice.getDeviceIdMD5());
        kotlin.jvm.internal.j.d(thingContext, "thingContext");
        ThingModel thingModel2 = thingContext.getThingModel();
        if (thingModel2 != null) {
            return thingModel2;
        }
        ThingDevice thingDevice = thingContext.getThingDevice();
        if (!(thingDevice == null || (thingModelId = thingDevice.getThingModelId()) == null)) {
            thingModel = w().m0(thingModelId);
        }
        return thingModel;
    }

    protected final SmartAction y() {
        SmartAction smartAction = new SmartAction();
        smartAction.setSmarts(null);
        smartAction.setThings(null);
        return smartAction;
    }

    protected final SmartInfo z(String title) {
        kotlin.jvm.internal.j.e(title, "title");
        SmartInfo smartInfo = new SmartInfo();
        smartInfo.setId(u().O());
        smartInfo.setName(title);
        smartInfo.setAvatarUrl(SmartRepository.h[1]);
        smartInfo.setEnabled(true);
        SmartLocation smartLocation = new SmartLocation();
        TimeZone timezone = TimeZone.getDefault();
        kotlin.jvm.internal.j.d(timezone, "timezone");
        smartLocation.setRegion(timezone.getID());
        smartLocation.setTimeDiff(Integer.valueOf((timezone.getRawOffset() / 1000) / 60));
        kotlin.p pVar = kotlin.p.a;
        smartInfo.setAppLocationInfo(smartLocation);
        smartInfo.setEffectivePeriod(new SmartPeriodSetting(SmartPeriodSetting.PeriodType.ALL_DAY, (byte) 127));
        return smartInfo;
    }
}
