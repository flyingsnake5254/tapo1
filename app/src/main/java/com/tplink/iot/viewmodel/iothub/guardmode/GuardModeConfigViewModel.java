package com.tplink.iot.viewmodel.iothub.guardmode;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.params.PlayAlarmParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeAlarmTimeBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeConfigBean;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.HubRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPIoTDevice;
import com.tplink.libtpnetwork.Utils.i;
import com.tplink.libtpnetwork.enumerate.EnumGuardMode;
import com.tplink.libtpnetwork.enumerate.EnumGuardModeAlarmTimeType;
import com.tplink.libtpnetwork.enumerate.EnumGuardModeAlarmVolume;
import io.reactivex.g0.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.l;
import kotlin.collections.n;
import kotlin.collections.o;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: GuardModeConfigViewModel.kt */
/* loaded from: classes2.dex */
public final class GuardModeConfigViewModel extends AndroidViewModel {

    /* renamed from: b  reason: collision with root package name */
    private final HubRepository f10292b;

    /* renamed from: c  reason: collision with root package name */
    private final TPIoTClientManager f10293c;

    /* renamed from: d  reason: collision with root package name */
    private final String f10294d;

    /* renamed from: e  reason: collision with root package name */
    private final MediatorLiveData<List<BaseALIoTDevice<?>>> f10295e;

    /* renamed from: f  reason: collision with root package name */
    private final LiveData<List<BaseALIoTDevice<?>>> f10296f;
    private final MediatorLiveData<GuardModeConfigBean> g;
    private GuardModeConfigBean i;
    private GuardModeConfigBean j;
    private EnumGuardMode a = EnumGuardMode.HOME;
    private boolean h = true;

    /* compiled from: GuardModeConfigViewModel.kt */
    /* loaded from: classes2.dex */
    static final class a<T> implements Observer<List<GuardModeConfigBean>> {
        a() {
        }

        /* renamed from: a */
        public final void onChanged(List<GuardModeConfigBean> list) {
            GuardModeConfigViewModel.this.r(list);
        }
    }

    /* compiled from: GuardModeConfigViewModel.kt */
    /* loaded from: classes2.dex */
    static final class b<T> implements Observer<List<BaseALIoTDevice<TDPIoTDevice>>> {
        b() {
        }

        /* renamed from: a */
        public final void onChanged(List<BaseALIoTDevice<TDPIoTDevice>> list) {
            if (list != null) {
                GuardModeConfigViewModel.this.o(list);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GuardModeConfigViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class c<T> implements g<Throwable> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.b.a f10297c;

        c(kotlin.jvm.b.a aVar) {
            this.f10297c = aVar;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            this.f10297c.invoke();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuardModeConfigViewModel(Application application, ThingContext iotDeviceContext) {
        super(application);
        List d2;
        String str;
        j.e(application, "application");
        j.e(iotDeviceContext, "iotDeviceContext");
        HubRepository mHubRepository = (HubRepository) e.a(iotDeviceContext, HubRepository.class);
        this.f10292b = mHubRepository;
        TPIoTClientManager mTPIoTClientManager = (TPIoTClientManager) b.d.b.f.b.a(iotDeviceContext.getAccountContext(), TPIoTClientManager.class);
        this.f10293c = mTPIoTClientManager;
        this.f10294d = iotDeviceContext.getDeviceIdMD5();
        MediatorLiveData<List<BaseALIoTDevice<?>>> mediatorLiveData = new MediatorLiveData<>();
        this.f10295e = mediatorLiveData;
        this.f10296f = mediatorLiveData;
        MediatorLiveData<GuardModeConfigBean> mediatorLiveData2 = new MediatorLiveData<>();
        this.g = mediatorLiveData2;
        String value = this.a.getValue();
        d2 = n.d();
        List<String> value2 = k().getValue();
        this.i = new GuardModeConfigBean(value, d2, (value2 == null || (str = (String) l.y(value2)) == null) ? "" : str, EnumGuardModeAlarmVolume.HIGH.getValue(), GuardModeAlarmTimeBean.Companion.getDefault());
        j.d(mHubRepository, "mHubRepository");
        mediatorLiveData2.addSource(mHubRepository.l5(), new a());
        j.d(mTPIoTClientManager, "mTPIoTClientManager");
        mediatorLiveData.addSource(mTPIoTClientManager.C1(), new b());
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean m() {
        /*
            r6 = this;
            com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeConfigBean r0 = r6.j
            java.lang.String r1 = "mOriginGuardModeConfigBean"
            if (r0 != 0) goto L_0x0009
            kotlin.jvm.internal.j.t(r1)
        L_0x0009:
            com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeAlarmTimeBean r0 = r0.getAlarmTime()
            com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeConfigBean r2 = r6.i
            com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeAlarmTimeBean r2 = r2.getAlarmTime()
            boolean r0 = kotlin.jvm.internal.j.a(r0, r2)
            com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeConfigBean r2 = r6.j
            if (r2 != 0) goto L_0x001e
            kotlin.jvm.internal.j.t(r1)
        L_0x001e:
            com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeAlarmTimeBean r2 = r2.getAlarmTime()
            java.lang.String r2 = r2.getType()
            com.tplink.libtpnetwork.enumerate.EnumGuardModeAlarmTimeType r3 = com.tplink.libtpnetwork.enumerate.EnumGuardModeAlarmTimeType.ALWAYS
            java.lang.String r4 = r3.getValue()
            boolean r2 = kotlin.jvm.internal.j.a(r2, r4)
            r4 = 1
            if (r2 == 0) goto L_0x0048
            com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeConfigBean r2 = r6.i
            com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeAlarmTimeBean r2 = r2.getAlarmTime()
            java.lang.String r2 = r2.getType()
            java.lang.String r3 = r3.getValue()
            boolean r2 = kotlin.jvm.internal.j.a(r2, r3)
            if (r2 == 0) goto L_0x0048
            r0 = 1
        L_0x0048:
            com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeConfigBean r2 = r6.j
            if (r2 != 0) goto L_0x004f
            kotlin.jvm.internal.j.t(r1)
        L_0x004f:
            java.util.List r2 = r2.getDeviceIdList()
            int r2 = r2.size()
            com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeConfigBean r3 = r6.i
            java.util.List r3 = r3.getDeviceIdList()
            int r3 = r3.size()
            r5 = 0
            if (r2 != r3) goto L_0x007d
            com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeConfigBean r2 = r6.j
            if (r2 != 0) goto L_0x006b
            kotlin.jvm.internal.j.t(r1)
        L_0x006b:
            java.util.List r2 = r2.getDeviceIdList()
            com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeConfigBean r3 = r6.i
            java.util.List r3 = r3.getDeviceIdList()
            boolean r2 = r2.containsAll(r3)
            if (r2 == 0) goto L_0x007d
            r2 = 1
            goto L_0x007e
        L_0x007d:
            r2 = 0
        L_0x007e:
            if (r2 == 0) goto L_0x00c8
            if (r0 == 0) goto L_0x00c8
            com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeConfigBean r0 = r6.j
            if (r0 != 0) goto L_0x0089
            kotlin.jvm.internal.j.t(r1)
        L_0x0089:
            java.lang.String r0 = r0.getId()
            com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeConfigBean r2 = r6.i
            java.lang.String r2 = r2.getId()
            boolean r0 = kotlin.jvm.internal.j.a(r0, r2)
            if (r0 == 0) goto L_0x00c8
            com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeConfigBean r0 = r6.j
            if (r0 != 0) goto L_0x00a0
            kotlin.jvm.internal.j.t(r1)
        L_0x00a0:
            java.lang.String r0 = r0.getAlarmType()
            com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeConfigBean r2 = r6.i
            java.lang.String r2 = r2.getAlarmType()
            boolean r0 = kotlin.jvm.internal.j.a(r0, r2)
            if (r0 == 0) goto L_0x00c8
            com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeConfigBean r0 = r6.j
            if (r0 != 0) goto L_0x00b7
            kotlin.jvm.internal.j.t(r1)
        L_0x00b7:
            java.lang.String r0 = r0.getAlarmVolume()
            com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeConfigBean r1 = r6.i
            java.lang.String r1 = r1.getAlarmVolume()
            boolean r0 = kotlin.jvm.internal.j.a(r0, r1)
            if (r0 == 0) goto L_0x00c8
            goto L_0x00c9
        L_0x00c8:
            r4 = 0
        L_0x00c9:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.viewmodel.iothub.guardmode.GuardModeConfigViewModel.m():boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(List<? extends BaseALIoTDevice<?>> list) {
        int l;
        if (list != null) {
            ArrayList<BaseALIoTDevice> arrayList = new ArrayList();
            for (Object obj : list) {
                BaseALIoTDevice baseALIoTDevice = (BaseALIoTDevice) obj;
                if (baseALIoTDevice.isSubDevice() && j.a(baseALIoTDevice.getParentDeviceIDMD5(), this.f10294d)) {
                    arrayList.add(obj);
                }
            }
            this.f10295e.postValue(arrayList);
            if (this.h) {
                GuardModeConfigBean guardModeConfigBean = this.i;
                l = o.l(arrayList, 10);
                ArrayList arrayList2 = new ArrayList(l);
                for (BaseALIoTDevice baseALIoTDevice2 : arrayList) {
                    arrayList2.add(baseALIoTDevice2.getDeviceId());
                }
                guardModeConfigBean.setDeviceIdList(arrayList2);
                this.j = GuardModeConfigBean.copy$default(this.i, null, null, null, null, null, 31, null);
                this.g.postValue(this.i);
            }
        }
    }

    private final void p(GuardModeConfigBean guardModeConfigBean) {
        this.h = false;
        this.j = GuardModeConfigBean.copy$default(guardModeConfigBean, null, null, null, null, null, 31, null);
        GuardModeConfigBean copy$default = GuardModeConfigBean.copy$default(guardModeConfigBean, null, null, null, null, null, 31, null);
        this.i = copy$default;
        this.g.postValue(copy$default);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void r(List<GuardModeConfigBean> list) {
        boolean z;
        GuardModeConfigBean guardModeConfigBean = null;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((GuardModeConfigBean) next).getEnumGuardMode() == this.a) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    guardModeConfigBean = next;
                    break;
                }
            }
            guardModeConfigBean = guardModeConfigBean;
        }
        b.d.w.c.a.a("Find [" + this.a.getValue() + "] Config：" + guardModeConfigBean);
        GuardModeConfigBean guardModeConfigBean2 = this.j;
        if (guardModeConfigBean2 == null) {
            if (guardModeConfigBean != null) {
                p(guardModeConfigBean);
                return;
            }
            this.h = true;
            this.j = GuardModeConfigBean.copy$default(this.i, null, null, null, null, null, 31, null);
            this.g.postValue(this.i);
        } else if (guardModeConfigBean != null) {
            if (guardModeConfigBean2 == null) {
                j.t("mOriginGuardModeConfigBean");
            }
            if (!j.a(guardModeConfigBean2, guardModeConfigBean)) {
                p(guardModeConfigBean);
            }
        }
    }

    private final void z() {
        this.g.postValue(this.i);
    }

    public final LiveData<List<BaseALIoTDevice<?>>> h() {
        return this.f10296f;
    }

    public final LiveData<GuardModeConfigBean> i() {
        return this.g;
    }

    public final void j() {
        HubRepository mHubRepository = this.f10292b;
        j.d(mHubRepository, "mHubRepository");
        mHubRepository.p5().F0();
    }

    public final LiveData<List<String>> k() {
        HubRepository mHubRepository = this.f10292b;
        j.d(mHubRepository, "mHubRepository");
        MutableLiveData<List<String>> q5 = mHubRepository.q5();
        j.d(q5, "mHubRepository.supportAlarmTypeListLiveData");
        return q5;
    }

    public final boolean l() {
        return this.j != null && (this.h || !m());
    }

    public final void n(String alarmType, kotlin.jvm.b.a<p> errorAction) {
        j.e(alarmType, "alarmType");
        j.e(errorAction, "errorAction");
        this.f10292b.A6(new PlayAlarmParams(alarmType, EnumGuardModeAlarmVolume.NORMAL.getValue())).r(io.reactivex.d0.b.a.a()).j(new c(errorAction)).y();
    }

    public final io.reactivex.a s() {
        b.d.w.c.a.a("Save GuardModeConfigBean: " + i.f(this.i));
        io.reactivex.a N6 = this.f10292b.N6(this.i.toThingRuleGuardMode());
        j.d(N6, "mHubRepository.setGuardM…n.toThingRuleGuardMode())");
        return N6;
    }

    public final void t(EnumGuardModeAlarmTimeType timeType, int i) {
        j.e(timeType, "timeType");
        this.i.setAlarmTime(new GuardModeAlarmTimeBean(timeType.getValue(), i));
        z();
    }

    public final void u(String type) {
        j.e(type, "type");
        this.i.setAlarmType(type);
        z();
    }

    public final void v(EnumGuardModeAlarmVolume volume) {
        j.e(volume, "volume");
        this.i.setAlarmVolume(volume.getValue());
        z();
    }

    public final void w(EnumGuardMode mode) {
        j.e(mode, "mode");
        this.i.setId(mode.getValue());
        this.a = mode;
    }

    public final void x(List<String> deviceIdList) {
        j.e(deviceIdList, "deviceIdList");
        this.i.setDeviceIdList(deviceIdList);
        z();
    }

    public final void y() {
        this.f10292b.Q6().y();
    }
}
