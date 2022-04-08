package com.tplink.iot.viewmodel.smart;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import com.tplink.iot.cloud.bean.thing.common.ThingEvent;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.d0;
import kotlin.collections.e0;
import kotlin.collections.o;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.m;
import kotlin.n;
import kotlin.reflect.j;
import kotlin.t.c;
import kotlin.v.g;

/* compiled from: DeviceTriggerViewModel.kt */
/* loaded from: classes3.dex */
public final class DeviceTriggerViewModel extends AndroidViewModel {
    static final /* synthetic */ j[] a = {m.h(new PropertyReference1Impl(DeviceTriggerViewModel.class, "mThingCloudRepository", "getMThingCloudRepository()Lcom/tplink/libtpnetwork/TPCloudNetwork/repository/ThingCloudRepository;", 0))};

    /* renamed from: b  reason: collision with root package name */
    private final ThingContext f11405b;

    /* renamed from: c  reason: collision with root package name */
    private final c f11406c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, Boolean> f11407d;

    /* compiled from: DelegateUtils.kt */
    /* loaded from: classes3.dex */
    public static final class a implements c<Object, ThingCloudRepository> {
        private final ThingCloudRepository a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ThingContext f11408b;

        /* JADX WARN: Type inference failed for: r2v2, types: [b.d.b.f.a, java.lang.Object, com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository] */
        /* JADX WARN: Unknown variable types count: 1 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public a(com.tplink.libtpnetwork.IoTNetwork.ThingContext r2) {
            /*
                r1 = this;
                r1.f11408b = r2
                r1.<init>()
                com.tplink.cloud.context.b r2 = r2.getAccountContext()
                java.lang.Class<com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository> r0 = com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository.class
                b.d.b.f.a r2 = b.d.b.f.b.a(r2, r0)
                java.lang.String r0 = "CloudRepositoryProviders…ontext, REPO::class.java)"
                kotlin.jvm.internal.j.d(r2, r0)
                r1.a = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.viewmodel.smart.DeviceTriggerViewModel.a.<init>(com.tplink.libtpnetwork.IoTNetwork.ThingContext):void");
        }

        /* renamed from: c */
        public ThingCloudRepository b(Object thisRef, j<?> property) {
            kotlin.jvm.internal.j.e(thisRef, "thisRef");
            kotlin.jvm.internal.j.e(property, "property");
            return this.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceTriggerViewModel(Application application, ThingContext thingContext) {
        super(application);
        Map map;
        List<ThingEvent> events;
        int l;
        int a2;
        int b2;
        kotlin.jvm.internal.j.e(application, "application");
        kotlin.jvm.internal.j.e(thingContext, "thingContext");
        this.f11405b = thingContext;
        this.f11406c = new a(thingContext);
        ThingModel g = g();
        if (g == null || (events = g.getEvents()) == null) {
            map = e0.d();
        } else {
            l = o.l(events, 10);
            a2 = d0.a(l);
            b2 = g.b(a2, 16);
            map = new LinkedHashMap(b2);
            for (ThingEvent it : events) {
                kotlin.jvm.internal.j.d(it, "it");
                Pair a3 = n.a(it.getId(), Boolean.TRUE);
                map.put(a3.getFirst(), a3.getSecond());
            }
        }
        this.f11407d = map;
    }

    private final ThingCloudRepository f() {
        return (ThingCloudRepository) this.f11406c.b(this, a[0]);
    }

    private final ThingModel g() {
        String thingModelId;
        ThingModel thingModel = this.f11405b.getThingModel();
        if (thingModel != null) {
            return thingModel;
        }
        ThingDevice thingDevice = this.f11405b.getThingDevice();
        if (thingDevice == null || (thingModelId = thingDevice.getThingModelId()) == null) {
            return null;
        }
        return f().m0(thingModelId);
    }
}
