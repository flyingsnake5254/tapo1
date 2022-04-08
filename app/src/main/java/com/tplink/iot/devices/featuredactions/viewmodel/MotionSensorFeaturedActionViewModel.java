package com.tplink.iot.devices.featuredactions.viewmodel;

import android.app.Application;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.cloud.bean.smart.common.SmartPeriodSetting;
import com.tplink.iot.cloud.bean.smart.common.SmartThingAction;
import com.tplink.iot.cloud.bean.smart.common.SmartThingFutureAction;
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

/* compiled from: MotionSensorFeaturedActionViewModel.kt */
/* loaded from: classes2.dex */
public final class MotionSensorFeaturedActionViewModel extends AbstractFeaturedActionViewModel {

    /* compiled from: MotionSensorFeaturedActionViewModel.kt */
    /* loaded from: classes2.dex */
    static final class a extends Lambda implements p<SmartThingAction, BaseALIoTDevice<?>, kotlin.p> {

        /* renamed from: c  reason: collision with root package name */
        public static final a f7468c = new a();

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

    /* compiled from: MotionSensorFeaturedActionViewModel.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements p<SmartThingAction, BaseALIoTDevice<?>, kotlin.p> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ SmartThingFutureAction f7469c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(SmartThingFutureAction smartThingFutureAction) {
            super(2);
            this.f7469c = smartThingFutureAction;
        }

        public final void a(SmartThingAction receiver, BaseALIoTDevice<?> it) {
            HashMap e2;
            j.e(receiver, "$receiver");
            j.e(it, "it");
            e2 = e0.e(n.a("on", Boolean.TRUE));
            receiver.setStateDesired(e2);
            receiver.setFutureAction(this.f7469c);
        }

        @Override // kotlin.jvm.b.p
        public /* bridge */ /* synthetic */ kotlin.p invoke(SmartThingAction smartThingAction, BaseALIoTDevice<?> baseALIoTDevice) {
            a(smartThingAction, baseALIoTDevice);
            return kotlin.p.a;
        }
    }

    /* compiled from: MotionSensorFeaturedActionViewModel.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements p<SmartThingAction, BaseALIoTDevice<?>, kotlin.p> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ SmartThingFutureAction f7470c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(SmartThingFutureAction smartThingFutureAction) {
            super(2);
            this.f7470c = smartThingFutureAction;
        }

        public final void a(SmartThingAction receiver, BaseALIoTDevice<?> it) {
            HashMap e2;
            j.e(receiver, "$receiver");
            j.e(it, "it");
            e2 = e0.e(n.a("on", Boolean.TRUE));
            receiver.setStateDesired(e2);
            receiver.setFutureAction(this.f7470c);
        }

        @Override // kotlin.jvm.b.p
        public /* bridge */ /* synthetic */ kotlin.p invoke(SmartThingAction smartThingAction, BaseALIoTDevice<?> baseALIoTDevice) {
            a(smartThingAction, baseALIoTDevice);
            return kotlin.p.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MotionSensorFeaturedActionViewModel(Application application, ThingContext iotDeviceContext) {
        super(application, iotDeviceContext);
        j.e(application, "application");
        j.e(iotDeviceContext, "iotDeviceContext");
    }

    private final SmartThingTrigger H() {
        SmartThingTrigger B = B(s());
        B.setEvent(new ThingEventParams("motion"));
        return B;
    }

    public final SmartInfo I(String title, List<? extends BaseALIoTDevice<?>> devices) {
        j.e(title, "title");
        j.e(devices, "devices");
        SmartInfo k = k(title, H(), devices, a.f7468c);
        k.setEffectivePeriod(new SmartPeriodSetting(SmartPeriodSetting.PeriodType.CUSTOM, l("0111110"), i(9, 0, 18, 0)));
        return k;
    }

    public final SmartInfo J(String title, List<? extends BaseALIoTDevice<?>> devices) {
        HashMap e2;
        j.e(title, "title");
        j.e(devices, "devices");
        e2 = e0.e(n.a("on", Boolean.FALSE));
        SmartInfo k = k(title, H(), devices, new b(new SmartThingFutureAction(120, e2)));
        k.setEffectivePeriod(new SmartPeriodSetting(SmartPeriodSetting.PeriodType.CUSTOM, (byte) 127, i(18, 0, 8, 0)));
        return k;
    }

    public final SmartInfo K(String title, List<? extends BaseALIoTDevice<?>> devices) {
        HashMap e2;
        j.e(title, "title");
        j.e(devices, "devices");
        e2 = e0.e(n.a("on", Boolean.FALSE));
        SmartInfo k = k(title, H(), devices, new c(new SmartThingFutureAction(120, e2)));
        k.setEffectivePeriod(new SmartPeriodSetting(SmartPeriodSetting.PeriodType.CUSTOM, (byte) 127, i(18, 0, 8, 0)));
        return k;
    }

    public final void L(BaseALIoTDevice<?> device) {
        j.e(device, "device");
        if (device.isHub()) {
            com.tplink.libtpnetwork.IoTNetwork.repository.kb.c d2 = e.d(device.getDeviceIdMD5(), HubRepository.class);
            j.d(d2, "IoTDeviceRepositoryProvi…ubRepository::class.java)");
            ((HubRepository) d2).p5().F0();
        }
    }
}
