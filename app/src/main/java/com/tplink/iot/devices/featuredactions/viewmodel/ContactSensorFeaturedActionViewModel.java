package com.tplink.iot.devices.featuredactions.viewmodel;

import android.app.Application;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.cloud.bean.smart.common.SmartThingAction;
import com.tplink.iot.cloud.bean.smart.common.SmartThingTrigger;
import com.tplink.iot.cloud.bean.thing.params.ThingEventParams;
import com.tplink.iot.devices.featuredactions.viewmodel.base.AbstractFeaturedActionViewModel;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.HubRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.enumerate.EnumGuardModeAlarmVolume;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.e0;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.n;

/* compiled from: ContactSensorFeaturedActionViewModel.kt */
/* loaded from: classes2.dex */
public final class ContactSensorFeaturedActionViewModel extends AbstractFeaturedActionViewModel {

    /* compiled from: ContactSensorFeaturedActionViewModel.kt */
    /* loaded from: classes2.dex */
    static final class a extends Lambda implements p<SmartThingAction, BaseALIoTDevice<?>, kotlin.p> {

        /* renamed from: c  reason: collision with root package name */
        public static final a f7459c = new a();

        a() {
            super(2);
        }

        public final void a(SmartThingAction receiver, BaseALIoTDevice<?> device) {
            j.e(receiver, "$receiver");
            j.e(device, "device");
            receiver.setService(com.tplink.iot.g.a.b.a.b(com.tplink.iot.g.a.b.a.a, device, EnumGuardModeAlarmVolume.HIGH, 60, null, 8, null));
        }

        @Override // kotlin.jvm.b.p
        public /* bridge */ /* synthetic */ kotlin.p invoke(SmartThingAction smartThingAction, BaseALIoTDevice<?> baseALIoTDevice) {
            a(smartThingAction, baseALIoTDevice);
            return kotlin.p.a;
        }
    }

    /* compiled from: ContactSensorFeaturedActionViewModel.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements p<SmartThingAction, BaseALIoTDevice<?>, kotlin.p> {

        /* renamed from: c  reason: collision with root package name */
        public static final b f7460c = new b();

        b() {
            super(2);
        }

        public final void a(SmartThingAction receiver, BaseALIoTDevice<?> it) {
            HashMap e2;
            j.e(receiver, "$receiver");
            j.e(it, "it");
            e2 = e0.e(n.a("on", Boolean.TRUE));
            receiver.setStateDesired(e2);
        }

        @Override // kotlin.jvm.b.p
        public /* bridge */ /* synthetic */ kotlin.p invoke(SmartThingAction smartThingAction, BaseALIoTDevice<?> baseALIoTDevice) {
            a(smartThingAction, baseALIoTDevice);
            return kotlin.p.a;
        }
    }

    /* compiled from: ContactSensorFeaturedActionViewModel.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements p<SmartThingAction, BaseALIoTDevice<?>, kotlin.p> {

        /* renamed from: c  reason: collision with root package name */
        public static final c f7461c = new c();

        c() {
            super(2);
        }

        public final void a(SmartThingAction receiver, BaseALIoTDevice<?> device) {
            j.e(receiver, "$receiver");
            j.e(device, "device");
            receiver.setService(com.tplink.iot.g.a.b.a.b(com.tplink.iot.g.a.b.a.a, device, EnumGuardModeAlarmVolume.NORMAL, 10, null, 8, null));
        }

        @Override // kotlin.jvm.b.p
        public /* bridge */ /* synthetic */ kotlin.p invoke(SmartThingAction smartThingAction, BaseALIoTDevice<?> baseALIoTDevice) {
            a(smartThingAction, baseALIoTDevice);
            return kotlin.p.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactSensorFeaturedActionViewModel(Application application, ThingContext iotDeviceContext) {
        super(application, iotDeviceContext);
        j.e(application, "application");
        j.e(iotDeviceContext, "iotDeviceContext");
    }

    private final SmartThingTrigger H() {
        SmartThingTrigger B = B(s());
        B.setEvent(new ThingEventParams("keepOpen"));
        return B;
    }

    private final SmartThingTrigger I() {
        SmartThingTrigger B = B(s());
        B.setEvent(new ThingEventParams("open"));
        return B;
    }

    public final SmartInfo J(String title, List<? extends BaseALIoTDevice<?>> devices) {
        j.e(title, "title");
        j.e(devices, "devices");
        SmartInfo k = k(title, I(), devices, a.f7459c);
        k.setEffectivePeriod(h(Byte.MAX_VALUE, i(18, 0, 8, 0)));
        return k;
    }

    public final SmartInfo K(String title, List<? extends BaseALIoTDevice<?>> devices) {
        j.e(title, "title");
        j.e(devices, "devices");
        SmartInfo k = k(title, I(), devices, b.f7460c);
        k.setEffectivePeriod(h(l("0111110"), i(18, 0, 8, 0)));
        return k;
    }

    public final SmartInfo L(String title, List<? extends BaseALIoTDevice<?>> devices) {
        j.e(title, "title");
        j.e(devices, "devices");
        return k(title, H(), devices, c.f7461c);
    }

    public final void M(BaseALIoTDevice<?> device) {
        j.e(device, "device");
        if (device.isHub()) {
            com.tplink.libtpnetwork.IoTNetwork.repository.kb.c d2 = e.d(device.getDeviceIdMD5(), HubRepository.class);
            j.d(d2, "IoTDeviceRepositoryProvi…ubRepository::class.java)");
            ((HubRepository) d2).p5().F0();
        }
    }
}
