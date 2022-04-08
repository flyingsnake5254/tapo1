package com.tplink.iot.viewmodel.smart.taskdevice;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.gson.k;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.cloud.bean.thing.common.ThingProperty;
import com.tplink.iot.cloud.bean.thing.common.ThingService;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.params.PlayAlarmParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeAlarmTimeBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeConfigBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import com.tplink.libtpnetwork.IoTNetwork.repository.HubRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository;
import com.tplink.libtpnetwork.enumerate.EnumGuardMode;
import com.tplink.libtpnetwork.enumerate.EnumGuardModeAlarmTimeType;
import com.tplink.libtpnetwork.enumerate.EnumGuardModeAlarmVolume;
import io.reactivex.g0.g;
import java.util.List;
import kotlin.collections.l;
import kotlin.collections.n;
import kotlin.f;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.m;
import kotlin.p;
import kotlin.reflect.j;

/* compiled from: TaskHubControlViewModel.kt */
/* loaded from: classes3.dex */
public final class TaskHubControlViewModel extends AndroidViewModel {
    static final /* synthetic */ j[] a = {m.h(new PropertyReference1Impl(TaskHubControlViewModel.class, "mHubRepository", "getMHubRepository()Lcom/tplink/libtpnetwork/IoTNetwork/repository/HubRepository;", 0)), m.h(new PropertyReference1Impl(TaskHubControlViewModel.class, "mThingCloudRepository", "getMThingCloudRepository()Lcom/tplink/libtpnetwork/TPCloudNetwork/repository/ThingCloudRepository;", 0))};

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.t.c f11445b;

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.t.c f11446c;

    /* renamed from: d  reason: collision with root package name */
    private final f f11447d;

    /* renamed from: e  reason: collision with root package name */
    private final GuardModeConfigBean f11448e;

    /* renamed from: f  reason: collision with root package name */
    private final MutableLiveData<GuardModeConfigBean> f11449f;
    private final LiveData<GuardModeConfigBean> g;
    private final boolean h;
    private final boolean i;
    private final boolean j;

    /* compiled from: DelegateUtils.kt */
    /* loaded from: classes3.dex */
    public static final class a implements kotlin.t.c<Object, ThingCloudRepository> {
        private final ThingCloudRepository a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.tplink.cloud.context.b f11450b;

        /* JADX WARN: Type inference failed for: r2v1, types: [b.d.b.f.a, java.lang.Object, com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository] */
        /* JADX WARN: Unknown variable types count: 1 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public a(com.tplink.cloud.context.b r2) {
            /*
                r1 = this;
                r1.f11450b = r2
                r1.<init>()
                java.lang.Class<com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository> r0 = com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository.class
                b.d.b.f.a r2 = b.d.b.f.b.a(r2, r0)
                java.lang.String r0 = "CloudRepositoryProviders…sitory, REPO::class.java)"
                kotlin.jvm.internal.j.d(r2, r0)
                r1.a = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.viewmodel.smart.taskdevice.TaskHubControlViewModel.a.<init>(com.tplink.cloud.context.b):void");
        }

        /* renamed from: c */
        public ThingCloudRepository b(Object thisRef, j<?> property) {
            kotlin.jvm.internal.j.e(thisRef, "thisRef");
            kotlin.jvm.internal.j.e(property, "property");
            return this.a;
        }
    }

    /* compiled from: DelegateUtils.kt */
    /* loaded from: classes3.dex */
    public static final class b implements kotlin.t.c<Object, HubRepository> {
        private final HubRepository a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ThingContext f11451b;

        /* JADX WARN: Type inference failed for: r2v1, types: [com.tplink.libtpnetwork.IoTNetwork.repository.HubRepository, com.tplink.libtpnetwork.IoTNetwork.repository.kb.c, java.lang.Object] */
        /* JADX WARN: Unknown variable types count: 1 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public b(com.tplink.libtpnetwork.IoTNetwork.ThingContext r2) {
            /*
                r1 = this;
                r1.f11451b = r2
                r1.<init>()
                java.lang.Class<com.tplink.libtpnetwork.IoTNetwork.repository.HubRepository> r0 = com.tplink.libtpnetwork.IoTNetwork.repository.HubRepository.class
                com.tplink.libtpnetwork.IoTNetwork.repository.kb.c r2 = com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(r2, r0)
                java.lang.String r0 = "IoTDeviceRepositoryProvi…sitory, REPO::class.java)"
                kotlin.jvm.internal.j.d(r2, r0)
                r1.a = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.viewmodel.smart.taskdevice.TaskHubControlViewModel.b.<init>(com.tplink.libtpnetwork.IoTNetwork.ThingContext):void");
        }

        /* renamed from: c */
        public HubRepository b(Object thisRef, j<?> property) {
            kotlin.jvm.internal.j.e(thisRef, "thisRef");
            kotlin.jvm.internal.j.e(property, "property");
            return this.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TaskHubControlViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class c<T> implements g<List<String>> {
        c() {
        }

        /* renamed from: a */
        public final void accept(List<String> list) {
            boolean z = true;
            if (TaskHubControlViewModel.this.f11448e.getAlarmType().length() == 0) {
                if (list != null && !list.isEmpty()) {
                    z = false;
                }
                if (!z) {
                    TaskHubControlViewModel taskHubControlViewModel = TaskHubControlViewModel.this;
                    Object x = l.x(list);
                    kotlin.jvm.internal.j.d(x, "it.first()");
                    taskHubControlViewModel.v((String) x);
                }
            }
        }
    }

    /* compiled from: TaskHubControlViewModel.kt */
    /* loaded from: classes3.dex */
    static final class d extends Lambda implements kotlin.jvm.b.a<ThingModel> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ThingContext f11454d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(ThingContext thingContext) {
            super(0);
            this.f11454d = thingContext;
        }

        /* renamed from: a */
        public final ThingModel invoke() {
            String thingModelId;
            ThingModel thingModel = this.f11454d.getThingModel();
            if (thingModel != null) {
                return thingModel;
            }
            TaskHubControlViewModel taskHubControlViewModel = TaskHubControlViewModel.this;
            ThingDevice thingDevice = this.f11454d.getThingDevice();
            if (thingDevice == null || (thingModelId = thingDevice.getThingModelId()) == null) {
                return null;
            }
            return taskHubControlViewModel.k().m0(thingModelId);
        }
    }

    /* compiled from: TaskHubControlViewModel.kt */
    /* loaded from: classes3.dex */
    static final class e<T> implements g<Throwable> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.b.a f11455c;

        e(kotlin.jvm.b.a aVar) {
            this.f11455c = aVar;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            this.f11455c.invoke();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskHubControlViewModel(Application application, ThingContext iotDeviceContext) {
        super(application);
        f b2;
        List d2;
        boolean z;
        List<ThingService> services;
        String str;
        kotlin.jvm.internal.j.e(application, "application");
        kotlin.jvm.internal.j.e(iotDeviceContext, "iotDeviceContext");
        this.f11445b = new b(iotDeviceContext);
        com.tplink.cloud.context.b accountContext = iotDeviceContext.getAccountContext();
        kotlin.jvm.internal.j.d(accountContext, "iotDeviceContext.accountContext");
        this.f11446c = new a(accountContext);
        b2 = i.b(new d(iotDeviceContext));
        this.f11447d = b2;
        String value = EnumGuardMode.HOME.getValue();
        d2 = n.d();
        MutableLiveData<List<String>> q5 = j().q5();
        kotlin.jvm.internal.j.d(q5, "mHubRepository.supportAlarmTypeListLiveData");
        List<String> value2 = q5.getValue();
        GuardModeConfigBean guardModeConfigBean = new GuardModeConfigBean(value, d2, (value2 == null || (str = (String) l.y(value2)) == null) ? "" : str, EnumGuardModeAlarmVolume.HIGH.getValue(), GuardModeAlarmTimeBean.Companion.getDefault());
        this.f11448e = guardModeConfigBean;
        MutableLiveData<GuardModeConfigBean> mutableLiveData = new MutableLiveData<>(guardModeConfigBean);
        this.f11449f = mutableLiveData;
        this.g = mutableLiveData;
        ThingModel l = l();
        boolean z2 = true;
        if (!(l == null || (services = l.getServices()) == null || services.isEmpty())) {
            for (ThingService it : services) {
                kotlin.jvm.internal.j.d(it, "it");
                if (kotlin.jvm.internal.j.a(ThingModelDefine.Service.SERVICE_RING, it.getId())) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        this.h = z;
        ThingModel l2 = l();
        ThingProperty thingProperty = null;
        this.i = (l2 != null ? l2.getThingProperty(ThingModelDefine.Property.PROPERTY_GUARD_ON) : null) != null;
        ThingModel l3 = l();
        this.j = (l3 != null ? l3.getThingProperty("guard_mode") : thingProperty) == null ? false : z2;
    }

    private final HubRepository j() {
        return (HubRepository) this.f11445b.b(this, a[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ThingCloudRepository k() {
        return (ThingCloudRepository) this.f11446c.b(this, a[1]);
    }

    private final ThingModel l() {
        return (ThingModel) this.f11447d.getValue();
    }

    private final void x() {
        this.f11449f.postValue(this.f11448e);
    }

    public final k h() {
        k kVar = new k();
        kVar.m("type", this.f11448e.getAlarmType());
        kVar.m(ThingModelDefine.Service.INPUT_PARAM_VOLUME, this.f11448e.getAlarmVolume());
        int i = a.a[this.f11448e.getAlarmTime().getEnumType().ordinal()];
        if (i == 1) {
            kVar.l(ThingModelDefine.Service.INPUT_PARAM_DURATION, 0);
        } else if (i == 2) {
            kVar.l(ThingModelDefine.Service.INPUT_PARAM_DURATION, Integer.valueOf(this.f11448e.getAlarmTime().getTime()));
        }
        return kVar;
    }

    public final LiveData<GuardModeConfigBean> i() {
        return this.g;
    }

    public final void m() {
        j().p5().E(new c()).F0();
    }

    public final LiveData<List<String>> n() {
        MutableLiveData<List<String>> q5 = j().q5();
        kotlin.jvm.internal.j.d(q5, "mHubRepository.supportAlarmTypeListLiveData");
        return q5;
    }

    public final boolean o() {
        return this.j;
    }

    public final boolean p() {
        return this.i;
    }

    public final boolean r() {
        return this.h;
    }

    public final void s(String alarmType, kotlin.jvm.b.a<p> errorAction) {
        kotlin.jvm.internal.j.e(alarmType, "alarmType");
        kotlin.jvm.internal.j.e(errorAction, "errorAction");
        j().A6(new PlayAlarmParams(alarmType, EnumGuardModeAlarmVolume.NORMAL.getValue())).r(io.reactivex.d0.b.a.a()).j(new e(errorAction)).y();
    }

    public final void t() {
        j().Q6().y();
    }

    public final void u(EnumGuardModeAlarmTimeType timeType, int i) {
        kotlin.jvm.internal.j.e(timeType, "timeType");
        this.f11448e.setAlarmTime(new GuardModeAlarmTimeBean(timeType.getValue(), i));
        x();
    }

    public final void v(String type) {
        kotlin.jvm.internal.j.e(type, "type");
        this.f11448e.setAlarmType(type);
        x();
    }

    public final void w(EnumGuardModeAlarmVolume volume) {
        kotlin.jvm.internal.j.e(volume, "volume");
        this.f11448e.setAlarmVolume(volume.getValue());
        x();
    }
}
