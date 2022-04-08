package com.tplink.iot.devices.lightstrip.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.IoTLightStripDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.CustomizedEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.PredefinedEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightingEffectData;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.LightStripRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.LightingEffectRepository;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import io.reactivex.q;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.m;
import kotlin.reflect.j;
import kotlin.t.c;

/* compiled from: LightStripLightSettingsViewModel.kt */
/* loaded from: classes2.dex */
public final class LightStripLightSettingsViewModel extends AndroidViewModel {
    static final /* synthetic */ j[] a = {m.h(new PropertyReference1Impl(LightStripLightSettingsViewModel.class, "mLightStripRepository", "getMLightStripRepository()Lcom/tplink/libtpnetwork/IoTNetwork/repository/LightStripRepository;", 0)), m.h(new PropertyReference1Impl(LightStripLightSettingsViewModel.class, "mLightingEffectRepository", "getMLightingEffectRepository()Lcom/tplink/libtpnetwork/TPCloudNetwork/repository/LightingEffectRepository;", 0))};

    /* renamed from: b  reason: collision with root package name */
    private final c f7724b;

    /* renamed from: c  reason: collision with root package name */
    private final c f7725c;

    /* renamed from: d  reason: collision with root package name */
    private final BaseALIoTDevice<?> f7726d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f7727e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f7728f;
    private final boolean g;
    private final boolean h;
    private final int[] i;

    /* compiled from: DelegateUtils.kt */
    /* loaded from: classes2.dex */
    public static final class a implements c<Object, LightingEffectRepository> {
        private final LightingEffectRepository a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ThingContext f7729b;

        /* JADX WARN: Type inference failed for: r2v2, types: [b.d.b.f.a, java.lang.Object, com.tplink.libtpnetwork.TPCloudNetwork.repository.LightingEffectRepository] */
        /* JADX WARN: Unknown variable types count: 1 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public a(com.tplink.libtpnetwork.IoTNetwork.ThingContext r2) {
            /*
                r1 = this;
                r1.f7729b = r2
                r1.<init>()
                com.tplink.cloud.context.b r2 = r2.getAccountContext()
                java.lang.Class<com.tplink.libtpnetwork.TPCloudNetwork.repository.LightingEffectRepository> r0 = com.tplink.libtpnetwork.TPCloudNetwork.repository.LightingEffectRepository.class
                b.d.b.f.a r2 = b.d.b.f.b.a(r2, r0)
                java.lang.String r0 = "CloudRepositoryProviders…ontext, REPO::class.java)"
                kotlin.jvm.internal.j.d(r2, r0)
                r1.a = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.devices.lightstrip.viewmodel.LightStripLightSettingsViewModel.a.<init>(com.tplink.libtpnetwork.IoTNetwork.ThingContext):void");
        }

        /* renamed from: c */
        public LightingEffectRepository b(Object thisRef, j<?> property) {
            kotlin.jvm.internal.j.e(thisRef, "thisRef");
            kotlin.jvm.internal.j.e(property, "property");
            return this.a;
        }
    }

    /* compiled from: DelegateUtils.kt */
    /* loaded from: classes2.dex */
    public static final class b implements c<Object, LightStripRepository> {
        private final LightStripRepository a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ThingContext f7730b;

        /* JADX WARN: Type inference failed for: r2v1, types: [com.tplink.libtpnetwork.IoTNetwork.repository.kb.c, java.lang.Object, com.tplink.libtpnetwork.IoTNetwork.repository.LightStripRepository] */
        /* JADX WARN: Unknown variable types count: 1 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public b(com.tplink.libtpnetwork.IoTNetwork.ThingContext r2) {
            /*
                r1 = this;
                r1.f7730b = r2
                r1.<init>()
                java.lang.Class<com.tplink.libtpnetwork.IoTNetwork.repository.LightStripRepository> r0 = com.tplink.libtpnetwork.IoTNetwork.repository.LightStripRepository.class
                com.tplink.libtpnetwork.IoTNetwork.repository.kb.c r2 = com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(r2, r0)
                java.lang.String r0 = "IoTDeviceRepositoryProvi…sitory, REPO::class.java)"
                kotlin.jvm.internal.j.d(r2, r0)
                r1.a = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.devices.lightstrip.viewmodel.LightStripLightSettingsViewModel.b.<init>(com.tplink.libtpnetwork.IoTNetwork.ThingContext):void");
        }

        /* renamed from: c */
        public LightStripRepository b(Object thisRef, j<?> property) {
            kotlin.jvm.internal.j.e(thisRef, "thisRef");
            kotlin.jvm.internal.j.e(property, "property");
            return this.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LightStripLightSettingsViewModel(Application application, ThingContext iotDeviceContext) {
        super(application);
        kotlin.jvm.internal.j.e(application, "application");
        kotlin.jvm.internal.j.e(iotDeviceContext, "iotDeviceContext");
        this.f7724b = new b(iotDeviceContext);
        this.f7725c = new a(iotDeviceContext);
        ALIoTDevice ioTDevice = iotDeviceContext.getIoTDevice();
        this.f7726d = ioTDevice;
        boolean z = false;
        this.f7727e = ioTDevice != null ? ioTDevice.isSupportIoTComponent(EnumIoTComponent.COLOR_TEMPERATURE) : false;
        this.f7728f = ioTDevice != null ? ioTDevice.isSupportIoTComponent(EnumIoTComponent.COLOR) : false;
        this.g = ioTDevice != null ? ioTDevice.isSupportIoTComponent(EnumIoTComponent.LIGHT_STRIP_LIGHTING_EFFECT) : false;
        this.h = ioTDevice != null ? ioTDevice.isSupportIoTComponent(EnumIoTComponent.SEGMENT) : z;
        int[] iArr = null;
        Object localIoTDevice = ioTDevice != null ? ioTDevice.getLocalIoTDevice() : null;
        IoTLightStripDevice ioTLightStripDevice = (IoTLightStripDevice) (!(localIoTDevice instanceof IoTLightStripDevice) ? null : localIoTDevice);
        this.i = ioTLightStripDevice != null ? ioTLightStripDevice.getColorTempRange() : iArr;
    }

    private final LightStripRepository h() {
        return (LightStripRepository) this.f7724b.b(this, a[0]);
    }

    private final LightingEffectRepository i() {
        return (LightingEffectRepository) this.f7725c.b(this, a[1]);
    }

    public final int[] f() {
        return this.i;
    }

    public final q<CustomizedEffect> g(String effectId) {
        kotlin.jvm.internal.j.e(effectId, "effectId");
        return i().U(effectId);
    }

    public final q<PredefinedEffect> j(String predefinedEffectId) {
        kotlin.jvm.internal.j.e(predefinedEffectId, "predefinedEffectId");
        return i().Y(predefinedEffectId);
    }

    public final PredefinedEffect k(String predefinedEffectId) {
        kotlin.jvm.internal.j.e(predefinedEffectId, "predefinedEffectId");
        return i().Z(predefinedEffectId);
    }

    public final boolean l() {
        return this.f7728f;
    }

    public final boolean m() {
        return this.f7727e;
    }

    public final boolean n() {
        return this.g;
    }

    public final boolean o() {
        return this.h;
    }

    public final void p(LightStateBean lightState) {
        kotlin.jvm.internal.j.e(lightState, "lightState");
        h().B5(lightState).y();
    }

    public final io.reactivex.a r(LightingEffectData effectData) {
        kotlin.jvm.internal.j.e(effectData, "effectData");
        return h().I5(effectData);
    }
}
