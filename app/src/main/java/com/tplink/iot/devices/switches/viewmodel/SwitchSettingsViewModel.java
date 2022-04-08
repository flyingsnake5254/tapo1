package com.tplink.iot.devices.switches.viewmodel;

import android.app.Application;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.tplink.iot.R;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.core.AppContext;
import com.tplink.iot.devicecommon.viewmodel.IoTSettingsBaseViewModel;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.params.DelayActionInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.params.DoubleClickInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.SwitchRepository;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import com.tplink.libtpnetwork.enumerate.EnumSwitchAvatarType;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.m;
import kotlin.reflect.j;
import kotlin.t.c;

/* compiled from: SwitchSettingsViewModel.kt */
/* loaded from: classes2.dex */
public final class SwitchSettingsViewModel extends IoTSettingsBaseViewModel {
    static final /* synthetic */ j[] o = {m.h(new PropertyReference1Impl(SwitchSettingsViewModel.class, "mSwitchRepository", "getMSwitchRepository()Lcom/tplink/libtpnetwork/IoTNetwork/repository/SwitchRepository;", 0))};
    private final c p;
    private final LiveData<DelayActionInfoBean> q = E().l4();
    private final LiveData<String> r;
    private final boolean s;
    private final boolean t;

    /* compiled from: DelegateUtils.kt */
    /* loaded from: classes2.dex */
    public static final class a implements c<Object, SwitchRepository> {
        private final SwitchRepository a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ThingContext f7863b;

        /* JADX WARN: Type inference failed for: r2v1, types: [com.tplink.libtpnetwork.IoTNetwork.repository.kb.c, java.lang.Object, com.tplink.libtpnetwork.IoTNetwork.repository.SwitchRepository] */
        /* JADX WARN: Unknown variable types count: 1 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public a(com.tplink.libtpnetwork.IoTNetwork.ThingContext r2) {
            /*
                r1 = this;
                r1.f7863b = r2
                r1.<init>()
                java.lang.Class<com.tplink.libtpnetwork.IoTNetwork.repository.SwitchRepository> r0 = com.tplink.libtpnetwork.IoTNetwork.repository.SwitchRepository.class
                com.tplink.libtpnetwork.IoTNetwork.repository.kb.c r2 = com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(r2, r0)
                java.lang.String r0 = "IoTDeviceRepositoryProvi…sitory, REPO::class.java)"
                kotlin.jvm.internal.j.d(r2, r0)
                r1.a = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.devices.switches.viewmodel.SwitchSettingsViewModel.a.<init>(com.tplink.libtpnetwork.IoTNetwork.ThingContext):void");
        }

        /* renamed from: c */
        public SwitchRepository b(Object thisRef, j<?> property) {
            kotlin.jvm.internal.j.e(thisRef, "thisRef");
            kotlin.jvm.internal.j.e(property, "property");
            return this.a;
        }
    }

    /* compiled from: SwitchSettingsViewModel.kt */
    /* loaded from: classes2.dex */
    static final class b<I, O> implements Function<DoubleClickInfoBean, String> {
        public static final b a = new b();

        b() {
        }

        /* renamed from: a */
        public final String apply(DoubleClickInfoBean doubleClickInfoBean) {
            if (doubleClickInfoBean != null) {
                String string = AppContext.f6185c.getString(doubleClickInfoBean.getEnable() ? R.string.status_on : R.string.status_off);
                if (string != null) {
                    return string;
                }
            }
            return "";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwitchSettingsViewModel(Application application, ThingContext iotDeviceContext) {
        super(application, iotDeviceContext);
        kotlin.jvm.internal.j.e(application, "application");
        kotlin.jvm.internal.j.e(iotDeviceContext, "iotDeviceContext");
        this.p = new a(iotDeviceContext);
        LiveData<String> map = Transformations.map(E().n4(), b.a);
        kotlin.jvm.internal.j.d(map, "Transformations.map(mSwi…ff)\n        } ?: \"\"\n    }");
        this.r = map;
        this.s = com.tplink.iot.Utils.w0.a.f(iotDeviceContext, EnumIoTComponent.DELAY_ACTION);
        this.t = com.tplink.iot.Utils.w0.a.f(iotDeviceContext, EnumIoTComponent.DOUBLE_CLICK);
    }

    private final SwitchRepository E() {
        return (SwitchRepository) this.p.b(this, o[0]);
    }

    public final void A() {
        E().k4().F0();
    }

    public final LiveData<DelayActionInfoBean> B() {
        return this.q;
    }

    public final void C() {
        E().m4().F0();
    }

    public final LiveData<String> D() {
        return this.r;
    }

    public final boolean F() {
        return this.s;
    }

    public final boolean G() {
        return this.t;
    }

    @Override // com.tplink.iot.devicecommon.viewmodel.IoTSettingsBaseViewModel
    public int l(String str) {
        EnumSwitchAvatarType fromString = EnumSwitchAvatarType.fromString(str);
        BaseALIoTDevice<?> value = j().getValue();
        return com.tplink.iot.g.c.a.b.b(fromString, value != null ? value.getDeviceModel() : null);
    }

    @Override // com.tplink.iot.devicecommon.viewmodel.IoTSettingsBaseViewModel
    public void m() {
        E().Z0().F0();
    }

    @Override // com.tplink.iot.devicecommon.viewmodel.IoTSettingsBaseViewModel
    public void o() {
        E().g1().F0();
    }

    @Override // com.tplink.iot.devicecommon.viewmodel.IoTSettingsBaseViewModel
    public LiveData<ThingFirmware> p() {
        MutableLiveData<ThingFirmware> h1 = E().h1();
        kotlin.jvm.internal.j.d(h1, "mSwitchRepository.firmwareLatestInfoData");
        return h1;
    }
}
