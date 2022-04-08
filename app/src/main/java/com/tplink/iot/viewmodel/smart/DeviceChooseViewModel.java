package com.tplink.iot.viewmodel.smart;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import com.tplink.cloud.context.b;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.m;
import kotlin.reflect.j;
import kotlin.t.c;

/* compiled from: DeviceChooseViewModel.kt */
/* loaded from: classes3.dex */
public final class DeviceChooseViewModel extends AndroidViewModel {
    static final /* synthetic */ j[] a = {m.h(new PropertyReference1Impl(DeviceChooseViewModel.class, "mThingCloudRepository", "getMThingCloudRepository()Lcom/tplink/libtpnetwork/TPCloudNetwork/repository/ThingCloudRepository;", 0))};

    /* renamed from: b  reason: collision with root package name */
    private final c f11398b;

    /* compiled from: DelegateUtils.kt */
    /* loaded from: classes3.dex */
    public static final class a implements c<Object, ThingCloudRepository> {
        private final ThingCloudRepository a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f11399b;

        /* JADX WARN: Type inference failed for: r2v1, types: [b.d.b.f.a, java.lang.Object, com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository] */
        /* JADX WARN: Unknown variable types count: 1 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public a(com.tplink.cloud.context.b r2) {
            /*
                r1 = this;
                r1.f11399b = r2
                r1.<init>()
                java.lang.Class<com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository> r0 = com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository.class
                b.d.b.f.a r2 = b.d.b.f.b.a(r2, r0)
                java.lang.String r0 = "CloudRepositoryProviders…sitory, REPO::class.java)"
                kotlin.jvm.internal.j.d(r2, r0)
                r1.a = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.viewmodel.smart.DeviceChooseViewModel.a.<init>(com.tplink.cloud.context.b):void");
        }

        /* renamed from: c */
        public ThingCloudRepository b(Object thisRef, j<?> property) {
            kotlin.jvm.internal.j.e(thisRef, "thisRef");
            kotlin.jvm.internal.j.e(property, "property");
            return this.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceChooseViewModel(Application application) {
        super(application);
        kotlin.jvm.internal.j.e(application, "application");
        b f2 = b.d.s.a.a.f();
        kotlin.jvm.internal.j.d(f2, "TPAppCloudContext.getCurrentAccountContext()");
        this.f11398b = new a(f2);
    }

    private final ThingModel f(TPCameraDeviceContext tPCameraDeviceContext) {
        ThingModel thingModel;
        if (tPCameraDeviceContext != null && (thingModel = tPCameraDeviceContext.getThingModel()) != null) {
            return thingModel;
        }
        return h().m0(tPCameraDeviceContext != null ? tPCameraDeviceContext.getThingModelId() : null);
    }

    private final ThingModel g(ThingContext thingContext) {
        ThingDevice thingDevice;
        ThingModel thingModel;
        if (thingContext != null && (thingModel = thingContext.getThingModel()) != null) {
            return thingModel;
        }
        return h().m0((thingContext == null || (thingDevice = thingContext.getThingDevice()) == null) ? null : thingDevice.getThingModelId());
    }

    private final ThingCloudRepository h() {
        return (ThingCloudRepository) this.f11398b.b(this, a[0]);
    }

    public final ThingModel i(BaseALIoTDevice<?> baseALIoTDevice) {
        if (baseALIoTDevice == null) {
            return null;
        }
        if (baseALIoTDevice.isCamera()) {
            return f(TPIoTClientManager.K1(baseALIoTDevice.getDeviceIdMD5()));
        }
        return g(TPIoTClientManager.k2(baseALIoTDevice.getDeviceIdMD5()));
    }
}
