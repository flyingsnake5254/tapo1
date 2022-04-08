package com.tplink.libtpnetwork.IoTNetwork.repository;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.google.gson.k;
import com.tplink.iot.cloud.bean.thing.common.SubThingCategoryBean;
import com.tplink.iot.cloud.bean.thing.common.ThingEventLog;
import com.tplink.iot.cloud.bean.thing.common.ThingRealTimeInfo;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleGuardMode;
import com.tplink.iot.cloud.bean.thing.common.ThingSupportAlarm;
import com.tplink.iot.cloud.bean.thing.common.ThingSupportCategory;
import com.tplink.iot.cloud.bean.thing.params.ThingServiceParams;
import com.tplink.iot.cloud.bean.thing.result.ThingEventLogResult;
import com.tplink.libtpmediastatistics.SSLClient;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.ThingServiceExecResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.IoTHubDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.params.DeviceIdListParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.params.GuardModeParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.params.HubDeviceParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.params.PlayAlarmParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeConfigBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeRuleResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.HubAlarmLog;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.HubDeviceRunningInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.LoadInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumGuardModeAlarmVolume;
import io.reactivex.e;
import io.reactivex.g0.g;
import io.reactivex.g0.j;
import io.reactivex.q;
import io.reactivex.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class HubRepository extends AbstractThingRepository {
    private MutableLiveData<List<String>> C = new MutableLiveData<>();
    private MediatorLiveData<LoadInfoBean> D = new MediatorLiveData<>();
    private MutableLiveData<List<SubThingCategoryBean>> E = new MutableLiveData<>();
    @Nullable
    private String F = null;
    private final MutableLiveData<List<HubAlarmLog>> G = new MutableLiveData<>();
    private int H = 0;
    private boolean I = false;
    private final MutableLiveData<Boolean> J = new MutableLiveData<>(Boolean.FALSE);
    private MutableLiveData<List<GuardModeConfigBean>> K = new MutableLiveData<>();
    private Map<String, GuardModeConfigBean> L = new LinkedHashMap();

    /* loaded from: classes3.dex */
    class a implements Function<LocalIoTBaseDevice, IoTHubDevice> {
        a() {
        }

        /* renamed from: a */
        public IoTHubDevice apply(LocalIoTBaseDevice localIoTBaseDevice) {
            if (localIoTBaseDevice instanceof IoTHubDevice) {
                return (IoTHubDevice) localIoTBaseDevice;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements Comparator<String> {

        /* renamed from: c  reason: collision with root package name */
        private final Pattern f12933c = Pattern.compile("(.*) ([0-9]*)");

        b() {
        }

        /* renamed from: a */
        public int compare(String str, String str2) {
            Matcher matcher = this.f12933c.matcher(str);
            Matcher matcher2 = this.f12933c.matcher(str2);
            if (matcher.matches() && matcher2.matches() && matcher.groupCount() == 2 && matcher2.groupCount() == 2 && TextUtils.equals(matcher.group(1), matcher2.group(1))) {
                try {
                    return Integer.parseInt(matcher.group(2)) - Integer.parseInt(matcher2.group(2));
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
            return str.compareTo(str2);
        }
    }

    public HubRepository(ThingContext thingContext) {
        super(thingContext, IoTHubDevice.class, HubDeviceRunningInfoResult.class);
        ALIoTDevice ioTDevice = thingContext.getIoTDevice();
        if (ioTDevice == null || !(ioTDevice.getLocalIoTDevice() instanceof IoTHubDevice)) {
            this.n.postValue(new IoTHubDevice());
        } else {
            this.n.postValue((IoTHubDevice) ioTDevice.getLocalIoTDevice());
        }
        this.D.addSource(this.o, new Observer() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.x5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HubRepository.this.Y5((ThingRealTimeInfo) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B5 */
    public /* synthetic */ void C5(GuardModeRuleResult guardModeRuleResult) throws Exception {
        if (!(guardModeRuleResult == null || guardModeRuleResult.getRuleList() == null)) {
            for (ThingRuleGuardMode thingRuleGuardMode : guardModeRuleResult.getRuleList()) {
                this.L.put(thingRuleGuardMode.getId(), new GuardModeConfigBean(thingRuleGuardMode));
            }
        }
        this.K.postValue(new ArrayList(this.L.values()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        r2 = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void B6(@androidx.annotation.Nullable java.util.List<com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.HubAlarmLog> r2, boolean r3) {
        /*
            r1 = this;
            if (r2 != 0) goto L_0x0007
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
        L_0x0007:
            boolean r0 = r2.isEmpty()
            r0 = r0 ^ 1
            if (r3 != 0) goto L_0x001c
            java.util.List r3 = r1.J6()
            r3.addAll(r2)
            r2.clear()
            r2.addAll(r3)
        L_0x001c:
            r1.I6(r2)
            r1.L6(r2)
            androidx.lifecycle.MutableLiveData<java.util.List<com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.HubAlarmLog>> r3 = r1.G
            r3.postValue(r2)
            r1.C6(r0)
            boolean r3 = r2.isEmpty()
            if (r3 != 0) goto L_0x0042
            int r3 = r2.size()
            int r3 = r3 + (-1)
            java.lang.Object r2 = r2.get(r3)
            com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.HubAlarmLog r2 = (com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.HubAlarmLog) r2
            int r2 = r2.getId()
            r1.H = r2
        L_0x0042:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.libtpnetwork.IoTNetwork.repository.HubRepository.B6(java.util.List, boolean):void");
    }

    private void C6(boolean z) {
        this.I = z;
        this.J.postValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D5 */
    public /* synthetic */ void E5(Throwable th) throws Exception {
        this.K.postValue(new ArrayList(this.L.values()));
    }

    private q<List<HubAlarmLog>> E6() {
        return o5(null, null, 20, null, "DESC");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ List F5(ThingEventLogResult thingEventLogResult) throws Exception {
        ArrayList arrayList = new ArrayList();
        List<ThingEventLog> events = thingEventLogResult.getEvents();
        if (events != null) {
            for (ThingEventLog thingEventLog : events) {
                if (thingEventLog.getParams() != null && !thingEventLog.getParams().isEmpty()) {
                    arrayList.add(new HubAlarmLog(thingEventLog));
                }
            }
        }
        return arrayList;
    }

    private io.reactivex.a F6() {
        return this.f13137d.a1(((ThingContext) this.a).getThingUrl(), ((ThingContext) this.a).getThingName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G5 */
    public /* synthetic */ void H5(List list) throws Exception {
        this.C.postValue(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I5 */
    public /* synthetic */ void J5(List list) throws Exception {
        this.C.postValue(list);
    }

    private void I6(@Nullable List<HubAlarmLog> list) {
        if (!(list == null || list.isEmpty())) {
            HashSet hashSet = new HashSet();
            ArrayList arrayList = new ArrayList();
            for (HubAlarmLog hubAlarmLog : list) {
                if (!TextUtils.isEmpty(hubAlarmLog.getEventId()) && !hashSet.contains(hubAlarmLog.getEventId())) {
                    arrayList.add(hubAlarmLog);
                    hashSet.add(hubAlarmLog.getEventId());
                }
            }
            hashSet.clear();
            list.clear();
            list.addAll(arrayList);
        }
    }

    @NonNull
    private List<HubAlarmLog> J6() {
        List<HubAlarmLog> c2 = b.d.w.d.a.c(b.d.w.h.a.g(b.d.s.a.a.f().c().getCloudUserName()), "hub_alarm_log_cache_list", ((ThingContext) this.a).getDeviceIdMD5(), HubAlarmLog.class);
        if (c2 != null && !c2.isEmpty()) {
            I6(c2);
        }
        return c2 != null ? c2 : new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K5 */
    public /* synthetic */ t L5(Throwable th) throws Exception {
        if (F0(th)) {
            return this.f13137d.u0(((ThingContext) this.a).getThingUrl(), ((ThingContext) this.a).getThingName(), b.d.s.c.a.c("support_alarms")).g0(bb.f13176c);
        }
        return q.J(th);
    }

    @NonNull
    private List<String> K6() {
        List<String> c2 = b.d.w.d.a.c(b.d.w.h.a.g(b.d.s.a.a.f().c().getCloudUserName()), "hub_support_alarm_type_list", ((ThingContext) this.a).getDeviceIdMD5(), String.class);
        return c2 != null ? c2 : new ArrayList();
    }

    private void L6(@Nullable List<HubAlarmLog> list) {
        b.d.w.d.a.l(b.d.w.h.a.g(b.d.s.a.a.f().c().getCloudUserName()), list, "hub_alarm_log_cache_list", ((ThingContext) this.a).getDeviceIdMD5());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ List M5(ThingSupportAlarm thingSupportAlarm) throws Exception {
        if (thingSupportAlarm.getAlarmTypeList() != null) {
            return thingSupportAlarm.getAlarmTypeList();
        }
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N5 */
    public /* synthetic */ void O5(List list) throws Exception {
        this.C.postValue(list);
        if (!list.isEmpty()) {
            R6(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> O6(@NonNull List<String> list) {
        b bVar = new b();
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList, bVar);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P5 */
    public /* synthetic */ void Q5(Throwable th) throws Exception {
        this.C.postValue(new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R5 */
    public /* synthetic */ t S5(Throwable th) throws Exception {
        if (F0(th)) {
            return this.f13137d.u0(((ThingContext) this.a).getThingUrl(), ((ThingContext) this.a).getThingName(), b.d.s.c.a.c("support_categories")).g0(eb.f13223c);
        }
        return q.J(th);
    }

    private void R6(@NonNull List<String> list) {
        b.d.w.d.a.l(b.d.w.h.a.g(b.d.s.a.a.f().c().getCloudUserName()), list, "hub_support_alarm_type_list", ((ThingContext) this.a).getDeviceIdMD5());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T5 */
    public /* synthetic */ void U5(ThingSupportCategory thingSupportCategory) throws Exception {
        this.F = ((ThingContext) this.a).getIoTDevice() != null ? ((ThingContext) this.a).getIoTDevice().getDeviceFwVer() : null;
        this.E.postValue(thingSupportCategory.getDeviceCategoryList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V5 */
    public /* synthetic */ void W5(List list) throws Exception {
        B6(list, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X5 */
    public /* synthetic */ void Y5(ThingRealTimeInfo thingRealTimeInfo) {
        if (thingRealTimeInfo != null && thingRealTimeInfo.getTotalMemory() != null) {
            this.D.postValue(new LoadInfoBean(thingRealTimeInfo));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b6 */
    public /* synthetic */ t c6(PlayAlarmParams playAlarmParams, Throwable th) throws Exception {
        if (F0(th)) {
            return z6(playAlarmParams).g0(q6.f13439c);
        }
        return q.J(th);
    }

    @Nullable
    private String e5(List<HubAlarmLog> list, Long l) {
        if (list == null || list.isEmpty() || l == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int size = list.size() - 1; size >= 0; size--) {
            HubAlarmLog hubAlarmLog = list.get(size);
            if (hubAlarmLog.getTimestamp() != l.longValue()) {
                break;
            }
            if (hubAlarmLog.getEventId() != null) {
                if (sb.length() > 0) {
                    sb.append(SSLClient.COMMA);
                }
                sb.append(hubAlarmLog.getEventId());
            }
        }
        b.d.w.c.a.n("AlarmLog", "filterIds: " + sb.toString());
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e6 */
    public /* synthetic */ void f6(List list) throws Exception {
        B6(list, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g6 */
    public /* synthetic */ void h6() throws Exception {
        this.H = 0;
        this.J.postValue(Boolean.FALSE);
        this.G.postValue(new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i6 */
    public /* synthetic */ e j6(GuardModeParams guardModeParams, Throwable th) throws Exception {
        if (F0(th)) {
            return K4(new HubDeviceParams(guardModeParams), false);
        }
        return io.reactivex.a.m(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k6 */
    public /* synthetic */ t l6(ThingRuleGuardMode thingRuleGuardMode, Throwable th) throws Exception {
        if (F0(th)) {
            return this.f13137d.h1(((ThingContext) this.a).getThingUrl(), ((ThingContext) this.a).getThingName(), thingRuleGuardMode.getId(), thingRuleGuardMode).g0(r6.f13451c);
        }
        return q.J(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m6 */
    public /* synthetic */ void n6(ThingRuleGuardMode thingRuleGuardMode) throws Exception {
        this.L.put(thingRuleGuardMode.getId(), new GuardModeConfigBean(thingRuleGuardMode));
        this.K.postValue(new ArrayList(this.L.values()));
    }

    private q<List<HubAlarmLog>> o5(Long l, Long l2, int i, String str, String str2) {
        return this.f13137d.h0(((ThingContext) this.a).getThingUrl(), ((ThingContext) this.a).getThingName(), l, l2, i, str, str2).g0(n6.f13382c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o6 */
    public /* synthetic */ void p6(Throwable th) throws Exception {
        this.K.postValue(new ArrayList(this.L.values()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q6 */
    public /* synthetic */ e r6(Throwable th) throws Exception {
        if (!F0(th)) {
            return io.reactivex.a.m(th);
        }
        HubDeviceParams hubDeviceParams = new HubDeviceParams();
        hubDeviceParams.setInAlarm(Boolean.FALSE);
        return J4(hubDeviceParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s6 */
    public /* synthetic */ void t6() throws Exception {
        if (this.n.getValue() instanceof IoTHubDevice) {
            IoTHubDevice ioTHubDevice = (IoTHubDevice) this.n.getValue();
            ioTHubDevice.setInAlarm(false);
            this.n.postValue(ioTHubDevice);
            this.f13334b.L3();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t5 */
    public /* synthetic */ void u5(LoadInfoBean loadInfoBean) throws Exception {
        this.D.postValue(loadInfoBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u6 */
    public /* synthetic */ e v6(Throwable th) throws Exception {
        if (F0(th)) {
            return z6(new PlayAlarmParams("", EnumGuardModeAlarmVolume.MUTE.getValue())).Z();
        }
        return io.reactivex.a.m(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v5 */
    public /* synthetic */ t w5(Throwable th) throws Exception {
        if (F0(th)) {
            return this.f13137d.p0(((ThingContext) this.a).getThingUrl(), ((ThingContext) this.a).getThingName()).g0(ib.f13287c);
        }
        return q.J(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x5 */
    public /* synthetic */ void y5(LoadInfoBean loadInfoBean) throws Exception {
        this.D.postValue(loadInfoBean);
    }

    private q<List<HubAlarmLog>> y6() {
        String str;
        List<HubAlarmLog> J6 = J6();
        Long l = null;
        if (!J6.isEmpty()) {
            Long valueOf = Long.valueOf(J6.get(J6.size() - 1).getTimestamp());
            str = e5(J6, valueOf);
            l = valueOf;
        } else {
            str = null;
        }
        return o5(null, l, 20, str, "DESC");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z5 */
    public /* synthetic */ t A5(Throwable th) throws Exception {
        if (F0(th)) {
            return this.f13137d.X(((ThingContext) this.a).getThingUrl(), ((ThingContext) this.a).getThingName(), 0).g0(k8.f13325c);
        }
        return q.J(th);
    }

    private q<ThingServiceExecResult> z6(PlayAlarmParams playAlarmParams) {
        if (playAlarmParams == null) {
            return q.J(new Throwable("PlayAlarmParams is null"));
        }
        k kVar = new k();
        kVar.m("type", playAlarmParams.getAlarmType());
        kVar.m(ThingModelDefine.Service.INPUT_PARAM_VOLUME, playAlarmParams.getAlarmVolume());
        return this.f13137d.P(((ThingContext) this.a).getThingUrl(), ((ThingContext) this.a).getThingName(), ((ThingContext) this.a).getThingGatewayUrlV2(), new ThingServiceParams(ThingModelDefine.Service.SERVICE_RING, kVar));
    }

    public io.reactivex.a A6(final PlayAlarmParams playAlarmParams) {
        return y0("play_alarm", playAlarmParams, Boolean.class).o0(new j() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.u6
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return HubRepository.this.c6(playAlarmParams, (Throwable) obj);
            }
        }).Z();
    }

    public io.reactivex.a D6() {
        return E6().E(new g() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.u5
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                HubRepository.this.f6((List) obj);
            }
        }).Z();
    }

    public io.reactivex.a G6() {
        return F6().i(new io.reactivex.g0.a() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.z5
            @Override // io.reactivex.g0.a
            public final void run() {
                HubRepository.this.h6();
            }
        });
    }

    public io.reactivex.a H6(DeviceIdListParams deviceIdListParams) {
        return y0("remove_child_device_list", deviceIdListParams, Boolean.class).Z();
    }

    public io.reactivex.a M6(final GuardModeParams guardModeParams) {
        if (this.n.getValue() instanceof IoTHubDevice) {
            IoTHubDevice ioTHubDevice = (IoTHubDevice) this.n.getValue();
            this.i = ioTHubDevice.getDeviceInfoParams();
            ioTHubDevice.setGuardOn(guardModeParams.getEnable());
            ioTHubDevice.setGuardMode(guardModeParams.getGuardMode());
            this.n.postValue(ioTHubDevice);
            this.f13334b.L3();
        }
        return y0("set_guard_mode", guardModeParams, Boolean.class).Z().u(new j() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.m6
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return HubRepository.this.j6(guardModeParams, (Throwable) obj);
            }
        }).j(new g() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.cb
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                HubRepository.this.E4((Throwable) obj);
            }
        });
    }

    public io.reactivex.a N6(final ThingRuleGuardMode thingRuleGuardMode) {
        return y0("set_guard_mode_config", thingRuleGuardMode, Boolean.class).L0(io.reactivex.l0.a.c()).o0(new j() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.s6
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return HubRepository.this.l6(thingRuleGuardMode, (Throwable) obj);
            }
        }).z(new io.reactivex.g0.a() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.k6
            @Override // io.reactivex.g0.a
            public final void run() {
                HubRepository.this.n6(thingRuleGuardMode);
            }
        }).C(new g() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.i6
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                HubRepository.this.p6((Throwable) obj);
            }
        }).Z();
    }

    public io.reactivex.a P6() {
        return y0("stop_alarm", null, Boolean.class).Z().u(new j() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.l6
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return HubRepository.this.r6((Throwable) obj);
            }
        }).i(new io.reactivex.g0.a() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.a6
            @Override // io.reactivex.g0.a
            public final void run() {
                HubRepository.this.t6();
            }
        });
    }

    public io.reactivex.a Q6() {
        return y0("stop_alarm", null, Boolean.class).Z().u(new j() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.p6
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return HubRepository.this.v6((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.libtpnetwork.IoTNetwork.repository.AbstractThingRepository, com.tplink.libtpnetwork.IoTNetwork.repository.ThingBaseRepository, com.tplink.libtpnetwork.IoTNetwork.repository.kb.b, com.tplink.libtpnetwork.IoTNetwork.repository.kb.c
    public void e() {
        this.f13333c.l();
        super.e();
    }

    public LiveData<List<HubAlarmLog>> f5() {
        return this.G;
    }

    public LiveData<Boolean> g5() {
        return this.J;
    }

    public LiveData<IoTHubDevice> h5() {
        return Transformations.map(super.j1(), new a());
    }

    public q<LoadInfoBean> i5() {
        return y0("get_device_load_info", null, LoadInfoBean.class).E(new g() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.o6
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                HubRepository.this.u5((LoadInfoBean) obj);
            }
        });
    }

    public q<LoadInfoBean> j5() {
        return y0("get_device_load_info", null, LoadInfoBean.class).o0(new j() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.v5
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return HubRepository.this.w5((Throwable) obj);
            }
        }).E(new g() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.j6
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                HubRepository.this.y5((LoadInfoBean) obj);
            }
        });
    }

    @Nullable
    public String k5() {
        return this.F;
    }

    public LiveData<List<GuardModeConfigBean>> l5() {
        return this.K;
    }

    public q<GuardModeRuleResult> m5() {
        return x0("get_guard_mode_configs", GuardModeRuleResult.class).L0(io.reactivex.l0.a.c()).o0(new j() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.b6
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return HubRepository.this.A5((Throwable) obj);
            }
        }).E(new g() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.h6
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                HubRepository.this.C5((GuardModeRuleResult) obj);
            }
        }).C(new g() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.x6
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                HubRepository.this.E5((Throwable) obj);
            }
        });
    }

    public LiveData<LoadInfoBean> n5() {
        return this.D;
    }

    public q<List<String>> p5() {
        if (this.C.getValue() != null && !this.C.getValue().isEmpty()) {
            return q.f0(this.C.getValue()).g0(new j() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.t6
                @Override // io.reactivex.g0.j
                public final Object apply(Object obj) {
                    List O6;
                    O6 = HubRepository.this.O6((List) obj);
                    return O6;
                }
            }).E(new g() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.y5
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    HubRepository.this.H5((List) obj);
                }
            });
        }
        List<String> K6 = K6();
        if (!K6.isEmpty()) {
            return q.f0(K6).g0(new j() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.t6
                @Override // io.reactivex.g0.j
                public final Object apply(Object obj) {
                    List O6;
                    O6 = HubRepository.this.O6((List) obj);
                    return O6;
                }
            }).E(new g() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.g6
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    HubRepository.this.J5((List) obj);
                }
            });
        }
        return y0("get_support_alarm_type_list", null, ThingSupportAlarm.class).o0(new j() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.w6
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return HubRepository.this.L5((Throwable) obj);
            }
        }).g0(c6.f13186c).g0(new j() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.t6
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                List O6;
                O6 = HubRepository.this.O6((List) obj);
                return O6;
            }
        }).E(new g() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.d6
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                HubRepository.this.O5((List) obj);
            }
        }).C(new g() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.w5
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                HubRepository.this.Q5((Throwable) obj);
            }
        });
    }

    public MutableLiveData<List<String>> q5() {
        return this.C;
    }

    public q<ThingSupportCategory> r5() {
        return y0("get_support_child_device_category", null, ThingSupportCategory.class).o0(new j() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.v6
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return HubRepository.this.S5((Throwable) obj);
            }
        }).E(new g() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.e6
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                HubRepository.this.U5((ThingSupportCategory) obj);
            }
        });
    }

    public LiveData<List<SubThingCategoryBean>> s5() {
        return this.E;
    }

    public void w6() {
        this.G.postValue(J6());
    }

    public io.reactivex.a x6() {
        if (this.I) {
            return y6().E(new g() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.f6
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    HubRepository.this.W5((List) obj);
                }
            }).Z();
        }
        C6(false);
        return io.reactivex.a.e();
    }
}
