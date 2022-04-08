package com.tplink.iot.viewmodel.smart.conditiondevice;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.cloud.bean.thing.common.ThingProperty;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository;
import com.tplink.libtpnetwork.Utils.l;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import kotlin.f;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.m;
import kotlin.reflect.j;

/* compiled from: DeviceTriggerBaseViewModel.kt */
/* loaded from: classes3.dex */
public final class DeviceTriggerBaseViewModel extends AndroidViewModel {
    static final /* synthetic */ j[] a = {m.h(new PropertyReference1Impl(DeviceTriggerBaseViewModel.class, "mThingCloudRepository", "getMThingCloudRepository()Lcom/tplink/libtpnetwork/TPCloudNetwork/repository/ThingCloudRepository;", 0))};

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.t.c f11423b;

    /* renamed from: c  reason: collision with root package name */
    private final TPBaseDeviceContext<?> f11424c;

    /* renamed from: d  reason: collision with root package name */
    private final f f11425d;

    /* compiled from: DelegateUtils.kt */
    /* loaded from: classes3.dex */
    public static final class a implements kotlin.t.c<Object, ThingCloudRepository> {
        private final ThingCloudRepository a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.tplink.cloud.context.b f11426b;

        /* JADX WARN: Type inference failed for: r2v1, types: [b.d.b.f.a, java.lang.Object, com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository] */
        /* JADX WARN: Unknown variable types count: 1 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public a(com.tplink.cloud.context.b r2) {
            /*
                r1 = this;
                r1.f11426b = r2
                r1.<init>()
                java.lang.Class<com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository> r0 = com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository.class
                b.d.b.f.a r2 = b.d.b.f.b.a(r2, r0)
                java.lang.String r0 = "CloudRepositoryProviders…sitory, REPO::class.java)"
                kotlin.jvm.internal.j.d(r2, r0)
                r1.a = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.viewmodel.smart.conditiondevice.DeviceTriggerBaseViewModel.a.<init>(com.tplink.cloud.context.b):void");
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
    public static final class b implements kotlin.t.c<Object, ThingCloudRepository> {
        private final ThingCloudRepository a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.tplink.cloud.context.b f11427b;

        /* JADX WARN: Type inference failed for: r2v1, types: [b.d.b.f.a, java.lang.Object, com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository] */
        /* JADX WARN: Unknown variable types count: 1 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public b(com.tplink.cloud.context.b r2) {
            /*
                r1 = this;
                r1.f11427b = r2
                r1.<init>()
                java.lang.Class<com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository> r0 = com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository.class
                b.d.b.f.a r2 = b.d.b.f.b.a(r2, r0)
                java.lang.String r0 = "CloudRepositoryProviders…sitory, REPO::class.java)"
                kotlin.jvm.internal.j.d(r2, r0)
                r1.a = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.viewmodel.smart.conditiondevice.DeviceTriggerBaseViewModel.b.<init>(com.tplink.cloud.context.b):void");
        }

        /* renamed from: c */
        public ThingCloudRepository b(Object thisRef, j<?> property) {
            kotlin.jvm.internal.j.e(thisRef, "thisRef");
            kotlin.jvm.internal.j.e(property, "property");
            return this.a;
        }
    }

    /* compiled from: DeviceTriggerBaseViewModel.kt */
    /* loaded from: classes3.dex */
    static final class c extends Lambda implements kotlin.jvm.b.a<ThingModel> {
        c() {
            super(0);
        }

        /* renamed from: a */
        public final ThingModel invoke() {
            return DeviceTriggerBaseViewModel.this.l();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceTriggerBaseViewModel(Application application, ThingContext iotDeviceContext) {
        super(application);
        f b2;
        kotlin.jvm.internal.j.e(application, "application");
        kotlin.jvm.internal.j.e(iotDeviceContext, "iotDeviceContext");
        com.tplink.cloud.context.b f2 = b.d.s.a.a.f();
        kotlin.jvm.internal.j.d(f2, "TPAppCloudContext.getCurrentAccountContext()");
        this.f11423b = new a(f2);
        b2 = i.b(new c());
        this.f11425d = b2;
        this.f11424c = iotDeviceContext;
    }

    private final ThingModel g(TPCameraDeviceContext tPCameraDeviceContext) {
        ThingModel thingModel = tPCameraDeviceContext.getThingModel();
        return thingModel != null ? thingModel : j().m0(tPCameraDeviceContext.getThingModelId());
    }

    private final ThingModel i(ThingContext thingContext) {
        ThingModel thingModel = thingContext.getThingModel();
        return thingModel != null ? thingModel : j().m0(thingContext.getThingModelId());
    }

    private final ThingCloudRepository j() {
        return (ThingCloudRepository) this.f11423b.b(this, a[0]);
    }

    private final ThingModel k() {
        return (ThingModel) this.f11425d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ThingModel l() {
        ThingModel thingModel;
        TPBaseDeviceContext<?> tPBaseDeviceContext = this.f11424c;
        if (tPBaseDeviceContext instanceof ThingContext) {
            thingModel = i((ThingContext) tPBaseDeviceContext);
        } else {
            thingModel = tPBaseDeviceContext instanceof TPCameraDeviceContext ? g((TPCameraDeviceContext) tPBaseDeviceContext) : null;
        }
        b.d.w.c.a.n("Smart", "ThingModel is: " + l.h(thingModel));
        return thingModel;
    }

    public final EnumDeviceType h() {
        BaseALIoTDevice ioTDevice = this.f11424c.getIoTDevice();
        if (ioTDevice != null) {
            return ioTDevice.getEnumDeviceType();
        }
        return null;
    }

    public final ThingProperty m(String id) {
        kotlin.jvm.internal.j.e(id, "id");
        ThingModel k = k();
        if (k != null) {
            return k.getThingProperty(id);
        }
        return null;
    }

    public final boolean n(String str) {
        if (str == null) {
            return false;
        }
        ThingModel k = k();
        return (k != null ? k.getThingEvent(str) : null) != null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceTriggerBaseViewModel(Application application, TPCameraDeviceContext cameraContext) {
        super(application);
        f b2;
        kotlin.jvm.internal.j.e(application, "application");
        kotlin.jvm.internal.j.e(cameraContext, "cameraContext");
        com.tplink.cloud.context.b f2 = b.d.s.a.a.f();
        kotlin.jvm.internal.j.d(f2, "TPAppCloudContext.getCurrentAccountContext()");
        this.f11423b = new b(f2);
        b2 = i.b(new c());
        this.f11425d = b2;
        this.f11424c = cameraContext;
    }
}
