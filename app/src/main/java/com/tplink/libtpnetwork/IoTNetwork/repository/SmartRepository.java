package com.tplink.libtpnetwork.IoTNetwork.repository;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tplink.cloud.define.CloudException;
import com.tplink.iot.c.b.i;
import com.tplink.iot.cloud.bean.common.AsyncResult;
import com.tplink.iot.cloud.bean.common.PageListResult;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.cloud.bean.smart.common.SmartLog;
import com.tplink.iot.cloud.bean.smart.common.SmartTemplate;
import com.tplink.iot.cloud.bean.smart.common.SmartThingAction;
import com.tplink.iot.cloud.bean.smart.common.SmartThingTrigger;
import com.tplink.iot.cloud.bean.smart.result.SmartExecResult;
import com.tplink.iot.cloud.bean.thing.common.ThingInfo;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.cloud.bean.thing.common.ThingSetting;
import com.tplink.iot.cloud.exception.IoTCloudException;
import com.tplink.iot.cloud.mqtt.MqttRepository;
import com.tplink.iot.cloud.mqtt.q0;
import com.tplink.iot.cloud.repository.AbstractIoTCloudRepository;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.Type;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightingEffectData;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.params.DoubleClickInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.SmartRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingListPageParams;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import io.reactivex.g0.j;
import io.reactivex.q;
import io.reactivex.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class SmartRepository extends AbstractIoTCloudRepository implements q0 {
    public static final String[] h = {"SmartTimeTrigger", "SmartDeviceTrigger", "SmartMultiTrigger"};
    public static final String[] i = {"SmartOneClick", "SmartLeaveHome", "SmartBackToHome", "SmartSleepMode", "SmartRead", "SmartVedio", "SmartGame", "SmartMusic", "SmartWake", "SmartScanning", "SmartMission", "SmartAuto"};
    private i j;
    private com.tplink.iot.c.b.a k;
    private com.tplink.iot.c.c.a l;
    private ThingCloudRepository m;
    private MqttRepository n;
    private Map<String, io.reactivex.m0.g<AsyncResult>> o = new HashMap();
    private MutableLiveData<List<SmartTemplate>> p = new MutableLiveData<>();
    private Map<String, SmartInfo> q = new LinkedHashMap();
    private MutableLiveData<List<SmartInfo>> r = new MutableLiveData<>();
    private SingleLiveEvent<Boolean> s = new SingleLiveEvent<>();
    private SingleLiveEvent<Boolean> t = new SingleLiveEvent<>();
    private SingleLiveEvent<Boolean> u = new SingleLiveEvent<>();
    private MutableLiveData<List<SmartLog>> v = new MutableLiveData<>();
    private MutableLiveData<List<SmartLog>> w = new MutableLiveData<>();
    private SingleLiveEvent<Boolean> x = new SingleLiveEvent<>();
    private MutableLiveData<List<ThingInfo>> y = new MutableLiveData<>();
    private MediatorLiveData<Boolean> z = new MediatorLiveData<>();
    private MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> A = new MutableLiveData<>();
    private String[] B = {"a", "b", com.tplink.iot.Utils.hls.c.n, "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", ExifInterface.GPS_MEASUREMENT_2D, ExifInterface.GPS_MEASUREMENT_3D, "4", "5", "6", "7", "8", "9", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z"};

    /* loaded from: classes3.dex */
    class a implements Observer<List<ThingInfo>> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable List<ThingInfo> list) {
            SmartRepository.this.y.postValue(list);
            SmartRepository.this.r.postValue(SmartRepository.this.d0());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements j<String, t<PageListResult<SmartTemplate>>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ThingListPageParams f13018c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f13019d;

        b(ThingListPageParams thingListPageParams, String str) {
            this.f13018c = thingListPageParams;
            this.f13019d = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public /* synthetic */ t c(String str, String str2, ThingListPageParams thingListPageParams, ThingListPageParams thingListPageParams2) throws Exception {
            return SmartRepository.this.j.I0(str, str2, thingListPageParams.getPage(), thingListPageParams.getPageSize(), true).L0(io.reactivex.l0.a.c());
        }

        /* renamed from: a */
        public t<PageListResult<SmartTemplate>> apply(final String str) throws Exception {
            q f0 = q.f0(this.f13018c);
            final String str2 = this.f13019d;
            final ThingListPageParams thingListPageParams = this.f13018c;
            return f0.N(new j() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.m8
                @Override // io.reactivex.g0.j
                public final Object apply(Object obj) {
                    return SmartRepository.b.this.c(str, str2, thingListPageParams, (ThingListPageParams) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements j<String, t<PageListResult<SmartInfo>>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ThingListPageParams f13021c;

        c(ThingListPageParams thingListPageParams) {
            this.f13021c = thingListPageParams;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public /* synthetic */ t c(String str, ThingListPageParams thingListPageParams, ThingListPageParams thingListPageParams2) throws Exception {
            return SmartRepository.this.j.h0(str, thingListPageParams.getPage(), thingListPageParams.getPageSize());
        }

        /* renamed from: a */
        public t<PageListResult<SmartInfo>> apply(final String str) throws Exception {
            q f0 = q.f0(this.f13021c);
            final ThingListPageParams thingListPageParams = this.f13021c;
            return f0.N(new j() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.n8
                @Override // io.reactivex.g0.j
                public final Object apply(Object obj) {
                    return SmartRepository.c.this.c(str, thingListPageParams, (ThingListPageParams) obj);
                }
            }).L0(io.reactivex.l0.a.c());
        }
    }

    /* loaded from: classes3.dex */
    class d implements j<String, t<AsyncResult>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f13023c;

        d(String str) {
            this.f13023c = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public /* synthetic */ t c(String str, SmartExecResult smartExecResult) throws Exception {
            return SmartRepository.this.G1(smartExecResult, str);
        }

        /* renamed from: a */
        public t<AsyncResult> apply(String str) throws Exception {
            q<SmartExecResult> U = SmartRepository.this.j.U(str, this.f13023c);
            final String str2 = this.f13023c;
            return U.N(new j() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.o8
                @Override // io.reactivex.g0.j
                public final Object apply(Object obj) {
                    return SmartRepository.d.this.c(str2, (SmartExecResult) obj);
                }
            }).L0(io.reactivex.l0.a.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class e implements io.reactivex.g0.a {
        final /* synthetic */ SmartExecResult a;

        e(SmartExecResult smartExecResult) {
            this.a = smartExecResult;
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            SmartRepository.this.o.remove(this.a.getRequestId());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class f implements j<Throwable, t<AsyncResult>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ SmartExecResult f13026c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class a implements j<AsyncResult, t<AsyncResult>> {
            a() {
            }

            /* renamed from: a */
            public t<AsyncResult> apply(AsyncResult asyncResult) throws Exception {
                if (asyncResult.getCode() == 0) {
                    return q.f0(asyncResult);
                }
                return q.J(new IoTCloudException(asyncResult.getCode(), asyncResult.getMessage(), asyncResult.getData()));
            }
        }

        f(SmartExecResult smartExecResult) {
            this.f13026c = smartExecResult;
        }

        /* renamed from: a */
        public t<AsyncResult> apply(Throwable th) throws Exception {
            if (th instanceof IoTCloudException) {
                return q.J(th);
            }
            return SmartRepository.this.y1(this.f13026c.getRequestId()).N(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class g implements j<String, t<AsyncResult>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f13029c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class a implements j<String, t<AsyncResult>> {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f13031c;

            a(String str) {
                this.f13031c = str;
            }

            /* renamed from: a */
            public t<AsyncResult> apply(String str) throws Exception {
                return SmartRepository.this.k.G1(this.f13031c, str).L0(io.reactivex.l0.a.c());
            }
        }

        g(String str) {
            this.f13029c = str;
        }

        /* renamed from: a */
        public t<AsyncResult> apply(String str) throws Exception {
            return q.f0(this.f13029c).N(new a(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class h implements j<String, t<PageListResult<SmartLog>>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ThingListPageParams f13033c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Integer f13034d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Integer f13035f;

        h(ThingListPageParams thingListPageParams, Integer num, Integer num2) {
            this.f13033c = thingListPageParams;
            this.f13034d = num;
            this.f13035f = num2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public /* synthetic */ t c(String str, ThingListPageParams thingListPageParams, Integer num, Integer num2, ThingListPageParams thingListPageParams2) throws Exception {
            return SmartRepository.this.j.o(str, thingListPageParams.getPage(), thingListPageParams.getPageSize(), num, num2).L0(io.reactivex.l0.a.c());
        }

        /* renamed from: a */
        public t<PageListResult<SmartLog>> apply(final String str) throws Exception {
            q f0 = q.f0(this.f13033c);
            final ThingListPageParams thingListPageParams = this.f13033c;
            final Integer num = this.f13034d;
            final Integer num2 = this.f13035f;
            return f0.N(new j() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.s8
                @Override // io.reactivex.g0.j
                public final Object apply(Object obj) {
                    return SmartRepository.h.this.c(str, thingListPageParams, num, num2, (ThingListPageParams) obj);
                }
            });
        }
    }

    public SmartRepository(com.tplink.iot.c.c.a aVar) {
        super(aVar);
        this.l = aVar;
        this.j = (i) aVar.k().R1(i.class);
        this.k = (com.tplink.iot.c.b.a) aVar.k().R1(com.tplink.iot.c.b.a.class);
        this.n = (MqttRepository) b.d.b.f.b.a(aVar, MqttRepository.class);
        this.m = (ThingCloudRepository) b.d.b.f.b.a(aVar, ThingCloudRepository.class);
        B1();
        this.z.addSource(this.m.k0(), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A0 */
    public /* synthetic */ io.reactivex.e B0(SmartInfo smartInfo, String str) throws Exception {
        return this.j.k1(str, smartInfo).C(io.reactivex.l0.a.c()).i(new io.reactivex.g0.a() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.q8
            @Override // io.reactivex.g0.a
            public final void run() {
                SmartRepository.this.j1();
            }
        }).j(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.o9
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                SmartRepository.this.l1((Throwable) obj);
            }
        });
    }

    private void A1() {
        if (this.q != null) {
            this.r.postValue(d0());
        } else {
            this.r.postValue(null);
        }
    }

    private void B1() {
        List<SmartInfo> list;
        if (!(this.l.c() == null || TextUtils.isEmpty(this.l.c().getCloudUserName()))) {
            try {
                list = b.d.w.d.a.c(b.d.w.h.a.g(this.l.c().getCloudUserName()), "shortcut_list_cache_key", "shortcut_list_cache_key", SmartInfo.class);
            } catch (Exception unused) {
                list = new ArrayList();
            }
            Map<String, SmartInfo> map = this.q;
            if (map != null) {
                map.clear();
                for (SmartInfo smartInfo : list) {
                    this.q.put(smartInfo.getId(), smartInfo);
                }
                A1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C0 */
    public /* synthetic */ void D0() throws Exception {
        this.A.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.TRUE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C1 */
    public void P0() {
        if (this.l.c() != null && !TextUtils.isEmpty(this.l.c().getCloudUserName())) {
            b.d.w.d.a.l(b.d.w.h.a.g(this.l.c().getCloudUserName()), d0(), "shortcut_list_cache_key", "shortcut_list_cache_key");
        }
    }

    private boolean E(@Nullable String str, @Nullable Object obj) {
        LightingEffectData resolveObject;
        if (!TextUtils.isEmpty(str) && obj != null) {
            BaseALIoTDevice L = L(str);
            if (L instanceof ALIoTDevice) {
                ALIoTDevice aLIoTDevice = (ALIoTDevice) L;
                if (aLIoTDevice.getLocalIoTDevice() == null || (resolveObject = LightingEffectData.resolveObject(obj)) == null) {
                    return false;
                }
                return !Type.PULSE.name().equalsIgnoreCase(resolveObject.type) || !"Sunrise".equalsIgnoreCase(resolveObject.name) || aLIoTDevice.getLocalIoTDevice().getComponentVersion(EnumIoTComponent.LIGHT_STRIP_LIGHTING_EFFECT) >= 2;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E0 */
    public /* synthetic */ void F0(boolean z, List list) throws Exception {
        if (z) {
            K(list);
        }
        this.y.postValue(list);
    }

    private void E1(List<SmartInfo> list) {
        if (!(list == null || list.isEmpty())) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (SmartInfo smartInfo : list) {
                if (smartInfo.getTriggerSetting() != null) {
                    if (smartInfo.getTriggerSetting().isManual()) {
                        arrayList.add(smartInfo);
                    } else {
                        arrayList2.add(smartInfo);
                    }
                }
            }
            z1(arrayList);
            list.clear();
            list.addAll(arrayList);
            list.addAll(arrayList2);
        }
    }

    private void F1(List<SmartTemplate> list) {
        if (!(list == null || list.isEmpty())) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (SmartTemplate smartTemplate : list) {
                if (smartTemplate.getTriggerSetting() != null) {
                    if (smartTemplate.getTriggerSetting().isManual()) {
                        arrayList.add(smartTemplate);
                    } else {
                        arrayList2.add(smartTemplate);
                    }
                }
            }
            list.clear();
            list.addAll(arrayList);
            list.addAll(arrayList2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G0 */
    public /* synthetic */ void H0(Throwable th) throws Exception {
        this.y.postValue(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public t<AsyncResult> G1(SmartExecResult smartExecResult, String str) {
        return q.f0(smartExecResult).N(new j() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.p8
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return SmartRepository.this.x1((SmartExecResult) obj);
            }
        }).T0(15L, TimeUnit.SECONDS).o0(new f(smartExecResult)).y(new e(smartExecResult));
    }

    private /* synthetic */ List I0(List list, ThingListPageParams thingListPageParams, PageListResult pageListResult) throws Exception {
        list.addAll(pageListResult.getData());
        thingListPageParams.setPage(thingListPageParams.getPage() + 1);
        if (list.size() >= pageListResult.getTotal()) {
            E1(list);
            return list;
        }
        throw new CloudException(-2, "DATA_RETRY");
    }

    private void K(List<ThingInfo> list) {
        if (!(list == null || list.isEmpty())) {
            ArrayList arrayList = new ArrayList();
            for (ThingInfo thingInfo : list) {
                if (EnumDeviceType.SWITCH.getDeviceType().equals(thingInfo.getDeviceType())) {
                    arrayList.add(((SwitchRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(b.d.w.h.a.g(thingInfo.getThingName()), SwitchRepository.class)).m4());
                } else if (EnumDeviceType.CAMERA.getDeviceType().equals(thingInfo.getDeviceType())) {
                    String g2 = b.d.w.h.a.g(thingInfo.getThingName());
                    if (com.tplink.libtpnetwork.Utils.d.d(g2) && com.tplink.libtpnetwork.Utils.d.c(g2) == null) {
                        arrayList.add(com.tplink.libtpnetwork.Utils.d.b(g2));
                    }
                }
            }
            q.k0(arrayList, 10).z(new io.reactivex.g0.a() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.e9
                @Override // io.reactivex.g0.a
                public final void run() {
                    SmartRepository.this.D0();
                }
            }).F0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean K0(Throwable th) throws Exception {
        if (th instanceof CloudException) {
            CloudException cloudException = (CloudException) th;
            if (cloudException.getErrCode() == -2 && "DATA_RETRY".equals(cloudException.getMsg())) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    private BaseALIoTDevice L(String str) {
        List<BaseALIoTDevice> value;
        if (TextUtils.isEmpty(str) || (value = ((TPIoTClientManager) b.d.b.f.b.a(b.d.s.a.a.f(), TPIoTClientManager.class)).C1().getValue()) == null) {
            return null;
        }
        for (BaseALIoTDevice baseALIoTDevice : value) {
            if (str.equals(baseALIoTDevice.getDeviceId())) {
                return baseALIoTDevice;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L0 */
    public /* synthetic */ void M0(List list) throws Exception {
        this.q.clear();
        if (list != null && !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                SmartInfo smartInfo = (SmartInfo) it.next();
                this.q.put(smartInfo.getId(), smartInfo);
            }
        }
        this.r.postValue(d0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N0 */
    public /* synthetic */ void O0(Throwable th) throws Exception {
        A1();
    }

    private /* synthetic */ List R0(List list, ThingListPageParams thingListPageParams, PageListResult pageListResult) throws Exception {
        list.addAll(pageListResult.getData());
        thingListPageParams.setPage(thingListPageParams.getPage() + 1);
        if (list.size() >= pageListResult.getTotal()) {
            F1(list);
            return list;
        }
        throw new CloudException(-2, "DATA_RETRY");
    }

    private q<List<SmartInfo>> T(final ThingListPageParams thingListPageParams) {
        final ArrayList arrayList = new ArrayList();
        return c0(thingListPageParams).g0(new j() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.p9
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                SmartRepository smartRepository = SmartRepository.this;
                List list = arrayList;
                smartRepository.J0(list, thingListPageParams, (PageListResult) obj);
                return list;
            }
        }).w0(d9.f13205c).E(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.g9
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                SmartRepository.this.M0((List) obj);
            }
        }).C(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.u8
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                SmartRepository.this.O0((Throwable) obj);
            }
        }).y(new io.reactivex.g0.a() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.l9
            @Override // io.reactivex.g0.a
            public final void run() {
                SmartRepository.this.Q0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean T0(Throwable th) throws Exception {
        if (th instanceof CloudException) {
            CloudException cloudException = (CloudException) th;
            if (cloudException.getErrCode() == -2 && "DATA_RETRY".equals(cloudException.getMsg())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U0 */
    public /* synthetic */ void V0(List list) throws Exception {
        this.p.postValue(list);
    }

    private q<List<SmartTemplate>> V(String str, final ThingListPageParams thingListPageParams) {
        final ArrayList arrayList = new ArrayList();
        return l0(str, thingListPageParams).g0(new j() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.k9
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                SmartRepository smartRepository = SmartRepository.this;
                List list = arrayList;
                smartRepository.S0(list, thingListPageParams, (PageListResult) obj);
                return list;
            }
        }).w0(z8.f13575c).E(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.w8
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                SmartRepository.this.V0((List) obj);
            }
        }).C(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.j9
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                SmartRepository.this.X0((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W0 */
    public /* synthetic */ void X0(Throwable th) throws Exception {
        this.p.postValue(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y0 */
    public /* synthetic */ void Z0(List list) throws Exception {
        this.w.postValue(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a1 */
    public /* synthetic */ void b1(Throwable th) throws Exception {
        this.w.postValue(null);
    }

    private q<PageListResult<SmartInfo>> c0(ThingListPageParams thingListPageParams) {
        return d().N(new c(thingListPageParams));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c1 */
    public /* synthetic */ void d1(Integer num, List list) throws Exception {
        ArrayList arrayList = new ArrayList();
        if (!list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                SmartLog smartLog = (SmartLog) it.next();
                if (Integer.parseInt(smartLog.getTimestamp()) > num.intValue()) {
                    arrayList.add(smartLog);
                }
            }
        }
        this.v.postValue(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<SmartInfo> d0() {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList(this.q.values());
        } catch (Exception unused) {
            arrayList = null;
        }
        return arrayList == null ? new ArrayList() : arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e1 */
    public /* synthetic */ void f1(Throwable th) throws Exception {
        this.v.postValue(null);
    }

    private q<PageListResult<SmartLog>> f0(ThingListPageParams thingListPageParams, Integer num, Integer num2) {
        return d().N(new h(thingListPageParams, num, num2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g1 */
    public /* synthetic */ void h1(Throwable th) throws Exception {
        this.t.postValue(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i1 */
    public /* synthetic */ void j1() throws Exception {
        this.s.postValue(Boolean.TRUE);
    }

    private q<List<SmartLog>> j0(ThingListPageParams thingListPageParams, Integer num, Integer num2) {
        return f0(thingListPageParams, num, num2).g0(j8.f13299c);
    }

    private List<String> k0() {
        return b.d.w.d.a.c(b.d.w.h.a.g(this.l.c().getCloudUserName()), "smart_shortcut_list", "smart_shortcut_list", String.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k1 */
    public /* synthetic */ void l1(Throwable th) throws Exception {
        this.s.postValue(Boolean.FALSE);
    }

    private q<PageListResult<SmartTemplate>> l0(String str, ThingListPageParams thingListPageParams) {
        return d().N(new b(thingListPageParams, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m1 */
    public /* synthetic */ void n1() throws Exception {
        this.u.postValue(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o1 */
    public /* synthetic */ void p1(Throwable th) throws Exception {
        this.u.postValue(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q1 */
    public /* synthetic */ void r1() throws Exception {
        this.x.postValue(Boolean.TRUE);
    }

    private boolean r0(SmartThingTrigger smartThingTrigger, ThingInfo thingInfo) {
        if (smartThingTrigger == null || thingInfo == null) {
            return false;
        }
        if (smartThingTrigger.getEvent() == null) {
            return true;
        }
        String name = smartThingTrigger.getEvent().getName();
        if (com.tplink.libtpnetwork.Utils.q.c(name)) {
            return com.tplink.libtpnetwork.Utils.q.a(name, b.d.w.h.a.g(thingInfo.getThingName()));
        }
        return true;
    }

    private boolean s0(SmartThingTrigger smartThingTrigger, ThingInfo thingInfo) {
        DoubleClickInfoBean value;
        if (smartThingTrigger == null || thingInfo == null) {
            return false;
        }
        if (smartThingTrigger.getEvent() == null || !"doubleClick".equals(smartThingTrigger.getEvent().getName()) || (value = ((SwitchRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(b.d.w.h.a.g(thingInfo.getThingName()), SwitchRepository.class)).n4().getValue()) == null) {
            return true;
        }
        b.d.w.c.a.n("Smart", "isSmartSwitchTriggerAvailable: " + value.getEnable());
        return value.getEnable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s1 */
    public /* synthetic */ void t1(Throwable th) throws Exception {
        this.x.postValue(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0 */
    public /* synthetic */ io.reactivex.e v0(SmartInfo smartInfo, String str) throws Exception {
        return this.j.k1(str, smartInfo).C(io.reactivex.l0.a.c()).i(new io.reactivex.g0.a() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.a9
            @Override // io.reactivex.g0.a
            public final void run() {
                SmartRepository.this.v1();
            }
        }).j(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.b9
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                SmartRepository.this.h1((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u1 */
    public /* synthetic */ void v1() throws Exception {
        this.t.postValue(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w0 */
    public /* synthetic */ io.reactivex.e x0(String str) throws Exception {
        return this.j.w1(str).C(io.reactivex.l0.a.c()).i(new io.reactivex.g0.a() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.r9
            @Override // io.reactivex.g0.a
            public final void run() {
                SmartRepository.this.r1();
            }
        }).j(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.f9
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                SmartRepository.this.t1((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w1 */
    public /* synthetic */ t x1(SmartExecResult smartExecResult) throws Exception {
        String requestId = smartExecResult.getRequestId();
        io.reactivex.m0.g<AsyncResult> remove = this.o.remove(requestId);
        if (remove != null) {
            return remove;
        }
        io.reactivex.m0.b n1 = io.reactivex.m0.b.n1();
        this.o.put(requestId, n1);
        return n1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y0 */
    public /* synthetic */ io.reactivex.e z0(String str, String str2) throws Exception {
        return this.j.c0(str2, str).C(io.reactivex.l0.a.c()).i(new io.reactivex.g0.a() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.x8
            @Override // io.reactivex.g0.a
            public final void run() {
                SmartRepository.this.n1();
            }
        }).j(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.c9
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                SmartRepository.this.p1((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public q<AsyncResult> y1(String str) {
        return d().N(new g(str));
    }

    private void z1(List<SmartInfo> list) {
        List<String> k0 = k0();
        if (!(k0 == null || k0.isEmpty() || list.isEmpty())) {
            ArrayList arrayList = new ArrayList();
            ArrayList<SmartInfo> arrayList2 = new ArrayList(list);
            for (String str : k0) {
                for (SmartInfo smartInfo : arrayList2) {
                    if (str.equals(smartInfo.getId())) {
                        arrayList.add(smartInfo);
                        list.remove(smartInfo);
                    }
                }
            }
            list.addAll(arrayList);
        }
    }

    public void D1(List<SmartInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (SmartInfo smartInfo : list) {
                arrayList.add(smartInfo.getId());
            }
        }
        b.d.w.d.a.l(b.d.w.h.a.g(this.l.c().getCloudUserName()), arrayList, "smart_shortcut_list", "smart_shortcut_list");
    }

    public io.reactivex.a F(final SmartInfo smartInfo) {
        return d().R(new j() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.m9
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return SmartRepository.this.v0(smartInfo, (String) obj);
            }
        });
    }

    public io.reactivex.a G() {
        return d().R(new j() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.q9
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return SmartRepository.this.x0((String) obj);
            }
        });
    }

    public io.reactivex.a H(final String str) {
        return d().R(new j() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.t8
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return SmartRepository.this.z0(str, (String) obj);
            }
        });
    }

    public io.reactivex.a I(final SmartInfo smartInfo) {
        return d().R(new j() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.n9
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return SmartRepository.this.B0(smartInfo, (String) obj);
            }
        });
    }

    public q<AsyncResult> J(String str) {
        this.n.w(this).C(io.reactivex.l0.a.c()).y();
        return d().N(new d(str));
    }

    public /* synthetic */ List J0(List list, ThingListPageParams thingListPageParams, PageListResult pageListResult) {
        I0(list, thingListPageParams, pageListResult);
        return list;
    }

    public SmartInfo M(String str) {
        if (this.q == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.q.get(str);
    }

    public ThingInfo N(String str) {
        List<ThingInfo> value = this.y.getValue();
        if (value == null || str == null) {
            return null;
        }
        for (ThingInfo thingInfo : value) {
            if (str.equals(thingInfo.getThingName())) {
                return thingInfo;
            }
        }
        return null;
    }

    public String O() {
        StringBuilder sb = new StringBuilder();
        String replace = UUID.randomUUID().toString().replace("-", "");
        for (int i2 = 0; i2 < 8; i2++) {
            int i3 = i2 * 4;
            sb.append(this.B[Integer.parseInt(replace.substring(i3, i3 + 4), 16) % 62]);
        }
        return sb.toString();
    }

    public MutableLiveData<List<SmartInfo>> P() {
        return this.r;
    }

    public q<List<ThingInfo>> Q() {
        return R(false);
    }

    public q<List<ThingInfo>> R(final boolean z) {
        return this.m.S().E(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.h9
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                SmartRepository.this.F0(z, (List) obj);
            }
        }).C(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.l8
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                SmartRepository.this.H0((Throwable) obj);
            }
        });
    }

    public q<List<SmartInfo>> S() {
        return T(new ThingListPageParams(0, 20));
    }

    public /* synthetic */ List S0(List list, ThingListPageParams thingListPageParams, PageListResult pageListResult) {
        R0(list, thingListPageParams, pageListResult);
        return list;
    }

    public q<List<SmartTemplate>> U(String str) {
        return V(str, new ThingListPageParams(0, 20));
    }

    public MutableLiveData<List<ThingInfo>> W() {
        return this.y;
    }

    public SingleLiveEvent<Boolean> X() {
        return this.t;
    }

    public SingleLiveEvent<Boolean> Y() {
        return this.x;
    }

    public SingleLiveEvent<Boolean> Z() {
        return this.u;
    }

    @Override // com.tplink.iot.cloud.mqtt.q0
    public void a(AsyncResult asyncResult) {
        io.reactivex.m0.g<AsyncResult> remove = this.o.remove(asyncResult.getRequestId());
        if (remove == null) {
            remove = io.reactivex.m0.b.n1();
            this.o.put(asyncResult.getRequestId(), remove);
        }
        if (asyncResult.getCode() == 0) {
            remove.onNext(asyncResult);
            remove.onComplete();
            return;
        }
        remove.onError(new IoTCloudException(asyncResult.getCode(), asyncResult.getMessage(), asyncResult.getData()));
    }

    public MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> a0() {
        return this.A;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // b.d.b.d.b.a
    public void b() {
        super.b();
        this.o.clear();
    }

    public SingleLiveEvent<Boolean> b0() {
        return this.s;
    }

    public MutableLiveData<List<SmartLog>> e0() {
        return this.w;
    }

    public q<List<SmartLog>> g0(Integer num, Integer num2) {
        return j0(new ThingListPageParams(0, 100), num, num2).E(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.v8
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                SmartRepository.this.Z0((List) obj);
            }
        }).C(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.i9
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                SmartRepository.this.b1((Throwable) obj);
            }
        });
    }

    public q<List<SmartLog>> h0(final Integer num, Integer num2) {
        return j0(new ThingListPageParams(0, 100), num, num2).E(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.y8
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                SmartRepository.this.d1(num, (List) obj);
            }
        }).C(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.r8
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                SmartRepository.this.f1((Throwable) obj);
            }
        });
    }

    public MutableLiveData<List<SmartLog>> i0() {
        return this.v;
    }

    public MutableLiveData<List<SmartTemplate>> m0() {
        return this.p;
    }

    public MutableLiveData<Boolean> n0() {
        return this.z;
    }

    public ThingModel o0(@Nullable String str) {
        return this.m.m0(str);
    }

    public q<ThingSetting> p0(String str) {
        return this.m.q0(TPIoTClientManager.k2(b.d.w.h.a.g(str)).getThingUrl(), str).L0(io.reactivex.l0.a.c());
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean q0(java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.libtpnetwork.IoTNetwork.repository.SmartRepository.q0(java.lang.String):boolean");
    }

    public boolean t0(@Nullable String str, @Nullable SmartThingAction smartThingAction, @Nullable String str2) {
        ThingModel o0;
        boolean z = false;
        if (TextUtils.isEmpty(str) || smartThingAction == null || TextUtils.isEmpty(str2) || (o0 = o0(str)) == null) {
            return false;
        }
        if (smartThingAction.getStateDesired() == null) {
            return (smartThingAction.getService() == null || o0.getThingService(smartThingAction.getService().getServiceId()) == null) ? false : true;
        }
        Map<String, Object> stateDesired = smartThingAction.getStateDesired();
        Iterator<String> it = stateDesired.keySet().iterator();
        while (true) {
            if (it.hasNext()) {
                if (o0.getThingProperty(it.next()) == null) {
                    break;
                }
            } else {
                z = true;
                break;
            }
        }
        return (!z || !stateDesired.containsKey(ThingModelDefine.Property.PROPERTY_LIGHTING_EFFECT)) ? z : E(str2, stateDesired.get(ThingModelDefine.Property.PROPERTY_LIGHTING_EFFECT));
    }
}
