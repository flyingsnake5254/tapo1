package com.tplink.libtpnetwork.TPCloudNetwork.repository;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import com.tplink.cloud.define.CloudException;
import com.tplink.iot.cloud.bean.common.AsyncResult;
import com.tplink.iot.cloud.bean.common.PageListResult;
import com.tplink.iot.cloud.bean.thing.common.FirmwareDownloadState;
import com.tplink.iot.cloud.bean.thing.common.NextEvent;
import com.tplink.iot.cloud.bean.thing.common.ThingDetail;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.cloud.bean.thing.common.ThingInfo;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.cloud.bean.thing.common.ThingNextEvent;
import com.tplink.iot.cloud.bean.thing.common.ThingRealTimeInfo;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleAwayMode;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleGuardMode;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleLightEffect;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleSchedule;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleTimer;
import com.tplink.iot.cloud.bean.thing.common.ThingSetting;
import com.tplink.iot.cloud.bean.thing.common.ThingUsage;
import com.tplink.iot.cloud.bean.thing.params.SubThingAddListParams;
import com.tplink.iot.cloud.bean.thing.params.SubThingCategoryScanParams;
import com.tplink.iot.cloud.bean.thing.params.SubThingQuickSetupInfoListParams;
import com.tplink.iot.cloud.bean.thing.params.ThingBatchUnbindParams;
import com.tplink.iot.cloud.bean.thing.params.ThingCommonDeviceParams;
import com.tplink.iot.cloud.bean.thing.params.ThingRuleDeleteParams;
import com.tplink.iot.cloud.bean.thing.params.ThingServiceParams;
import com.tplink.iot.cloud.bean.thing.params.ThingShadowUpdateParams;
import com.tplink.iot.cloud.bean.thing.result.SubThingScanListResult;
import com.tplink.iot.cloud.bean.thing.result.ThingBatchUnbindResult;
import com.tplink.iot.cloud.bean.thing.result.ThingCommonDeviceResult;
import com.tplink.iot.cloud.bean.thing.result.ThingComponentResult;
import com.tplink.iot.cloud.bean.thing.result.ThingEventLogResult;
import com.tplink.iot.cloud.bean.thing.result.ThingFailResult;
import com.tplink.iot.cloud.bean.thing.result.ThingRuleListResult;
import com.tplink.iot.cloud.bean.thing.result.ThingRuleUpdateResult;
import com.tplink.iot.cloud.bean.thing.result.ThingServiceResult;
import com.tplink.iot.cloud.bean.thing.result.ThingShadowListResult;
import com.tplink.iot.cloud.bean.thing.result.ThingShadowUpdateResult;
import com.tplink.iot.cloud.bean.thing.result.ThingSupportInfoResult;
import com.tplink.iot.cloud.exception.IoTCloudException;
import com.tplink.iot.cloud.mqtt.MqttRepository;
import com.tplink.iot.cloud.mqtt.q0;
import com.tplink.iot.cloud.repository.AbstractIoTCloudRepository;
import com.tplink.libtpmediastatistics.SSLClient;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.ThingServiceExecResult;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingListPageParams;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingModelCache;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository;
import io.reactivex.q;
import io.reactivex.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;

/* loaded from: classes3.dex */
public class ThingCloudRepository extends AbstractIoTCloudRepository implements q0 {
    private com.tplink.iot.c.b.j h;
    private com.tplink.iot.c.b.a i;
    private MqttRepository j;
    private Map<String, ThingDevice> k = new ConcurrentHashMap();
    private MutableLiveData<List<ThingDevice>> l = new MutableLiveData<>();
    private MutableLiveData<List<ThingInfo>> m = new MutableLiveData<>();
    private Map<String, io.reactivex.m0.g<Long>> n = new ConcurrentHashMap();
    private final Map<String, io.reactivex.m0.g<ThingServiceExecResult>> o = new ConcurrentHashMap();
    private Map<String, ThingModel> p = new ConcurrentHashMap();
    private q0 q;

    /* loaded from: classes3.dex */
    class a implements io.reactivex.g0.j<String, t<ThingNextEvent>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f13919c;

        a(String str) {
            this.f13919c = str;
        }

        /* renamed from: a */
        public t<ThingNextEvent> apply(String str) throws Exception {
            return ThingCloudRepository.this.h.P0(str, this.f13919c).L0(io.reactivex.l0.a.c());
        }
    }

    /* loaded from: classes3.dex */
    class b implements io.reactivex.g0.j<String, t<List<ThingNextEvent>>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f13921c;

        b(String str) {
            this.f13921c = str;
        }

        /* renamed from: a */
        public t<List<ThingNextEvent>> apply(String str) throws Exception {
            return ThingCloudRepository.this.h.Z0(str, this.f13921c).L0(io.reactivex.l0.a.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements io.reactivex.g0.j<String, t<Boolean>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f13923c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ List f13924d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class a implements io.reactivex.g0.g<io.reactivex.e0.c> {
            a() {
            }

            /* renamed from: a */
            public void accept(io.reactivex.e0.c cVar) throws Exception {
                for (String str : c.this.f13924d) {
                    c cVar2 = c.this;
                    ThingCloudRepository.this.g1(str, cVar2.f13923c);
                }
                ThingCloudRepository.this.f1();
            }
        }

        c(boolean z, List list) {
            this.f13923c = z;
            this.f13924d = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public /* synthetic */ void c(boolean z, ThingCommonDeviceResult thingCommonDeviceResult) throws Exception {
            List<ThingFailResult> failThingList;
            if (!(thingCommonDeviceResult == null || (failThingList = thingCommonDeviceResult.getFailThingList()) == null || failThingList.isEmpty())) {
                for (ThingFailResult thingFailResult : failThingList) {
                    ThingCloudRepository.this.g1(thingFailResult.getThingName(), !z);
                }
            }
            ThingCloudRepository.this.f1();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e */
        public /* synthetic */ void f(List list, boolean z, Throwable th) throws Exception {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ThingCloudRepository.this.g1((String) it.next(), !z);
            }
            ThingCloudRepository.this.f1();
        }

        /* renamed from: a */
        public t<Boolean> apply(String str) throws Exception {
            q F = ThingCloudRepository.this.l1(str, new ThingCommonDeviceParams(this.f13923c, this.f13924d)).F(new a());
            final boolean z = this.f13923c;
            q g0 = F.E(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.TPCloudNetwork.repository.l1
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    ThingCloudRepository.c.this.c(z, (ThingCommonDeviceResult) obj);
                }
            }).g0(m1.f14004c);
            final List list = this.f13924d;
            final boolean z2 = this.f13923c;
            return g0.C(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.TPCloudNetwork.repository.k1
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    ThingCloudRepository.c.this.f(list, z2, (Throwable) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d implements io.reactivex.g0.a {
        final /* synthetic */ ThingShadowUpdateResult a;

        d(ThingShadowUpdateResult thingShadowUpdateResult) {
            this.a = thingShadowUpdateResult;
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            ThingCloudRepository.this.n.remove(this.a.getRequestId());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class e implements io.reactivex.g0.j<Throwable, t<Long>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ThingShadowUpdateResult f13928c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class a implements io.reactivex.g0.j<AsyncResult, t<Long>> {
            a() {
            }

            /* renamed from: a */
            public t<Long> apply(AsyncResult asyncResult) throws Exception {
                if (asyncResult.getCode() == 0) {
                    return q.I();
                }
                return q.J(new IoTCloudException(asyncResult.getCode(), asyncResult.getMessage(), asyncResult.getData()));
            }
        }

        e(ThingShadowUpdateResult thingShadowUpdateResult) {
            this.f13928c = thingShadowUpdateResult;
        }

        /* renamed from: a */
        public t<Long> apply(Throwable th) throws Exception {
            if (th instanceof IoTCloudException) {
                return q.J(th);
            }
            return ThingCloudRepository.this.W0(this.f13928c.getRequestId()).N(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class f implements io.reactivex.g0.j<String, t<AsyncResult>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f13931c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class a implements io.reactivex.g0.j<String, t<AsyncResult>> {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f13933c;

            a(String str) {
                this.f13933c = str;
            }

            /* renamed from: a */
            public t<AsyncResult> apply(String str) throws Exception {
                return ThingCloudRepository.this.i.G1(this.f13933c, str).L0(io.reactivex.l0.a.c());
            }
        }

        f(String str) {
            this.f13931c = str;
        }

        /* renamed from: a */
        public t<AsyncResult> apply(String str) throws Exception {
            return q.f0(this.f13931c).N(new a(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class g implements io.reactivex.g0.j<String, t<PageListResult<ThingInfo>>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ThingListPageParams f13935c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f13936d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class a implements io.reactivex.g0.j<ThingListPageParams, t<PageListResult<ThingInfo>>> {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f13938c;

            a(String str) {
                this.f13938c = str;
            }

            /* renamed from: a */
            public t<PageListResult<ThingInfo>> apply(ThingListPageParams thingListPageParams) throws Exception {
                return ThingCloudRepository.this.h.t(this.f13938c, g.this.f13935c.getPage(), g.this.f13935c.getPageSize(), g.this.f13936d).L0(io.reactivex.l0.a.c());
            }
        }

        g(ThingListPageParams thingListPageParams, String str) {
            this.f13935c = thingListPageParams;
            this.f13936d = str;
        }

        /* renamed from: a */
        public t<PageListResult<ThingInfo>> apply(String str) throws Exception {
            return q.f0(this.f13935c).N(new a(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class h implements io.reactivex.g0.g<ThingModel> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f13940c;

        h(String str) {
            this.f13940c = str;
        }

        /* renamed from: a */
        public void accept(ThingModel thingModel) throws Exception {
            if (this.f13940c != null) {
                ThingCloudRepository.this.p.put(this.f13940c, thingModel);
                ThingCloudRepository.this.e1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class i implements io.reactivex.g0.g<io.reactivex.e0.c> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f13942c;

        i(String str) {
            this.f13942c = str;
        }

        /* renamed from: a */
        public void accept(io.reactivex.e0.c cVar) throws Exception {
            ThingCloudRepository.this.b1(this.f13942c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class j implements io.reactivex.g0.j<List<ThingBatchUnbindResult>, Boolean> {
        j() {
        }

        /* renamed from: a */
        public Boolean apply(List<ThingBatchUnbindResult> list) throws Exception {
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class k implements io.reactivex.g0.g<io.reactivex.e0.c> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f13945c;

        k(List list) {
            this.f13945c = list;
        }

        /* renamed from: a */
        public void accept(io.reactivex.e0.c cVar) throws Exception {
            ThingCloudRepository.this.c1(this.f13945c);
        }
    }

    public ThingCloudRepository(com.tplink.iot.c.c.a aVar) {
        super(aVar);
        this.h = (com.tplink.iot.c.b.j) aVar.k().R1(com.tplink.iot.c.b.j.class);
        this.i = (com.tplink.iot.c.b.a) aVar.k().R1(com.tplink.iot.c.b.a.class);
        this.j = (MqttRepository) b.d.b.f.b.a(aVar, MqttRepository.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean B0(Throwable th) throws Exception {
        if (th instanceof CloudException) {
            CloudException cloudException = (CloudException) th;
            if (cloudException.getErrCode() == -2 && "DATA_RETRY".equals(cloudException.getMsg())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C0 */
    public /* synthetic */ void D0(Throwable th) throws Exception {
        this.m.postValue(new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean E0(Throwable th) throws Exception {
        if (th instanceof CloudException) {
            CloudException cloudException = (CloudException) th;
            if (cloudException.getErrCode() == -2 && "DATA_RETRY".equals(cloudException.getMsg())) {
                return true;
            }
        }
        return false;
    }

    private /* synthetic */ List F0(List list, List list2, ThingListPageParams thingListPageParams, PageListResult pageListResult) throws Exception {
        list.addAll(r0(pageListResult.getData()));
        list2.addAll(pageListResult.getData());
        thingListPageParams.setPage(thingListPageParams.getPage() + 1);
        if (list2.size() >= pageListResult.getTotal()) {
            this.k.clear();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ThingDevice thingDevice = (ThingDevice) it.next();
                this.k.put(thingDevice.getThingName(), thingDevice);
            }
            f1();
            Z0(list2);
            return list2;
        }
        throw new CloudException(-2, "DATA_RETRY");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H0 */
    public /* synthetic */ t I0(ThingShadowUpdateResult thingShadowUpdateResult) throws Exception {
        String requestId = thingShadowUpdateResult.getRequestId();
        io.reactivex.m0.g<Long> remove = this.n.remove(requestId);
        if (remove == null) {
            remove = io.reactivex.m0.b.n1();
            this.n.put(requestId, remove);
        }
        return remove.E0(Long.valueOf(thingShadowUpdateResult.getVersion()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ t K0(AsyncResult asyncResult) throws Exception {
        b.d.w.c.a.n("ThingService", "getThingServiceExecCallback onErrorResumeNext asyncResult: " + com.tplink.libtpnetwork.Utils.i.j(asyncResult));
        if (asyncResult.getCode() == 0) {
            return q.f0(new ThingServiceExecResult(asyncResult.getRequestId(), asyncResult.getData()));
        }
        return q.J(new IoTCloudException(asyncResult.getCode(), asyncResult.getMessage(), asyncResult.getData()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L0 */
    public /* synthetic */ t M0(String str, String str2) throws Exception {
        return this.i.G1(str2, str).L0(io.reactivex.l0.a.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N0 */
    public /* synthetic */ t O0(ThingServiceResult thingServiceResult) throws Exception {
        String requestId = thingServiceResult.getRequestId();
        io.reactivex.m0.g<ThingServiceExecResult> gVar = this.o.get(requestId);
        if (gVar != null) {
            return gVar;
        }
        io.reactivex.m0.b n1 = io.reactivex.m0.b.n1();
        this.o.put(requestId, n1);
        return n1;
    }

    private q0 O() {
        if (this.q == null) {
            this.q = new q0() { // from class: com.tplink.libtpnetwork.TPCloudNetwork.repository.v1
                @Override // com.tplink.iot.cloud.mqtt.q0
                public final void a(AsyncResult asyncResult) {
                    ThingCloudRepository.this.V0(asyncResult);
                }
            };
        }
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P0 */
    public /* synthetic */ t Q0(ThingServiceResult thingServiceResult, Throwable th) throws Exception {
        if (!(th instanceof IoTCloudException)) {
            return Y0(thingServiceResult.getRequestId()).N(t1.f14044c);
        }
        b.d.w.c.a.n("ThingService", "getThingServiceExecCallback onErrorResumeNext throwable: " + th);
        return q.J(th);
    }

    private q<List<ThingDevice>> Q(final ThingListPageParams thingListPageParams, String str) {
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        return l0(thingListPageParams, str).g0(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.TPCloudNetwork.repository.r1
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                ThingCloudRepository thingCloudRepository = ThingCloudRepository.this;
                List list = arrayList2;
                thingCloudRepository.A0(list, arrayList, thingListPageParams, (PageListResult) obj);
                return list;
            }
        }).w0(i1.f13981c).C(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.TPCloudNetwork.repository.o1
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                ThingCloudRepository.this.D0((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R0 */
    public /* synthetic */ void S0(ThingServiceResult thingServiceResult) throws Exception {
        this.o.remove(thingServiceResult.getRequestId());
    }

    private q<List<ThingInfo>> T(final ThingListPageParams thingListPageParams, String str) {
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        return l0(thingListPageParams, str).L0(io.reactivex.l0.a.c()).g0(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.TPCloudNetwork.repository.j1
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                ThingCloudRepository thingCloudRepository = ThingCloudRepository.this;
                List list = arrayList2;
                List list2 = arrayList;
                thingCloudRepository.G0(list, list2, thingListPageParams, (PageListResult) obj);
                return list2;
            }
        }).w0(u1.f14046c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0(AsyncResult asyncResult) {
        b.d.w.c.a.n("ThingService", "onThingServiceExecAsyncResultArrived:" + com.tplink.libtpnetwork.Utils.i.j(asyncResult));
        io.reactivex.m0.g<ThingServiceExecResult> remove = this.o.remove(asyncResult.getRequestId());
        if (remove == null) {
            remove = io.reactivex.m0.b.n1();
            this.o.put(asyncResult.getRequestId(), remove);
        }
        if (asyncResult.getCode() == 0) {
            remove.onNext(new ThingServiceExecResult(asyncResult.getRequestId(), asyncResult.getData()));
            remove.onComplete();
            return;
        }
        remove.onError(new IoTCloudException(asyncResult.getCode(), asyncResult.getMessage(), asyncResult.getData()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public q<AsyncResult> W0(String str) {
        return d().N(new f(str));
    }

    private q<ThingModel> X0(String str, String str2) {
        return this.h.v1(str, str2).L0(io.reactivex.l0.a.c()).E(new h(str2));
    }

    private q<AsyncResult> Y0(final String str) {
        return d().N(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.TPCloudNetwork.repository.n1
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return ThingCloudRepository.this.M0(str, (String) obj);
            }
        });
    }

    private void Z0(List<ThingInfo> list) {
        if (!(list == null || list.isEmpty())) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (ThingInfo thingInfo : list) {
                String thingModelId = thingInfo.getThingModelId();
                if (!TextUtils.isEmpty(thingModelId) && !this.p.containsKey(thingModelId) && !concurrentHashMap.containsKey(thingModelId)) {
                    concurrentHashMap.put(thingModelId, thingInfo);
                }
            }
            if (!concurrentHashMap.isEmpty()) {
                for (ThingInfo thingInfo2 : concurrentHashMap.values()) {
                    X0(thingInfo2.getAppServerUrl(), thingInfo2.getThingModelId()).L0(io.reactivex.l0.a.c()).F0();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b1(String str) {
        this.k.remove(str);
        f1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c1(List<String> list) {
        for (String str : list) {
            this.k.remove(str);
        }
        f1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e1() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, ThingModel> entry : this.p.entrySet()) {
            arrayList.add(new ThingModelCache(entry.getKey(), entry.getValue()));
        }
        b.d.w.d.a.l(b.d.w.h.a.g(this.f100b.c().getCloudUserName()), arrayList, "thing_model_list_key_v2", "thing_model_list_key_v2");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f1() {
        this.l.postValue(new ArrayList(this.k.values()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g1(String str, boolean z) {
        ThingDevice thingDevice;
        if (!TextUtils.isEmpty(str) && (thingDevice = this.k.get(str)) != null) {
            thingDevice.setCommonDevice(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public q<ThingCommonDeviceResult> l1(String str, ThingCommonDeviceParams thingCommonDeviceParams) {
        return this.h.A1(str, thingCommonDeviceParams).L0(io.reactivex.l0.a.c());
    }

    private List<ThingDevice> r0(List<ThingInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (ThingInfo thingInfo : list) {
                arrayList.add(x0(thingInfo));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public q<Long> s0(ThingShadowUpdateResult thingShadowUpdateResult) {
        return q.f0(thingShadowUpdateResult).N(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.TPCloudNetwork.repository.x1
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return ThingCloudRepository.this.I0((ThingShadowUpdateResult) obj);
            }
        }).T0(10L, TimeUnit.SECONDS).o0(new e(thingShadowUpdateResult)).y(new d(thingShadowUpdateResult));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public q<ThingServiceExecResult> w1(final ThingServiceResult thingServiceResult) {
        return q.f0(thingServiceResult).N(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.TPCloudNetwork.repository.p1
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return ThingCloudRepository.this.O0((ThingServiceResult) obj);
            }
        }).T0(10L, TimeUnit.SECONDS).o0(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.TPCloudNetwork.repository.s1
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return ThingCloudRepository.this.Q0(thingServiceResult, (Throwable) obj);
            }
        }).y(new io.reactivex.g0.a() { // from class: com.tplink.libtpnetwork.TPCloudNetwork.repository.w1
            @Override // io.reactivex.g0.a
            public final void run() {
                ThingCloudRepository.this.S0(thingServiceResult);
            }
        });
    }

    private ThingDevice x0(ThingInfo thingInfo) {
        ThingDevice thingDevice = this.k.get(thingInfo.getThingName());
        if (thingDevice == null) {
            return new ThingDevice(thingInfo);
        }
        thingDevice.setThingInfo(thingInfo);
        return thingDevice;
    }

    private /* synthetic */ List z0(List list, List list2, ThingListPageParams thingListPageParams, PageListResult pageListResult) throws Exception {
        list.addAll(r0(pageListResult.getData()));
        list2.addAll(pageListResult.getData());
        thingListPageParams.setPage(thingListPageParams.getPage() + 1);
        if (list.size() >= pageListResult.getTotal()) {
            this.k.clear();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ThingDevice thingDevice = (ThingDevice) it.next();
                this.k.put(thingDevice.getThingName(), thingDevice);
            }
            f1();
            this.m.postValue(list2);
            Z0(list2);
            return list;
        }
        throw new CloudException(-2, "DATA_RETRY");
    }

    public /* synthetic */ List A0(List list, List list2, ThingListPageParams thingListPageParams, PageListResult pageListResult) {
        z0(list, list2, thingListPageParams, pageListResult);
        return list;
    }

    public /* synthetic */ List G0(List list, List list2, ThingListPageParams thingListPageParams, PageListResult pageListResult) {
        F0(list, list2, thingListPageParams, pageListResult);
        return list2;
    }

    public q<ThingRuleUpdateResult> H(String str, String str2, ThingRuleAwayMode thingRuleAwayMode) {
        return this.h.V0(str, str2, thingRuleAwayMode).L0(io.reactivex.l0.a.c());
    }

    public q<ThingRuleUpdateResult> I(String str, String str2, ThingRuleSchedule thingRuleSchedule) {
        return this.h.L(str, str2, thingRuleSchedule).L0(io.reactivex.l0.a.c());
    }

    public q<ThingRuleUpdateResult> J(String str, String str2, ThingRuleTimer thingRuleTimer) {
        return this.h.w0(str, str2, thingRuleTimer).L0(io.reactivex.l0.a.c());
    }

    public q<Boolean> K(String str, List<String> list) {
        return this.h.D1(str, new ThingBatchUnbindParams(list)).L0(io.reactivex.l0.a.c()).F(new k(list)).g0(new j());
    }

    public io.reactivex.a L(String str, String str2, SubThingCategoryScanParams subThingCategoryScanParams) {
        return this.h.y0(str, str2, subThingCategoryScanParams).C(io.reactivex.l0.a.c());
    }

    public io.reactivex.a M(String str, String str2, SubThingAddListParams subThingAddListParams) {
        return this.h.h(str, str2, subThingAddListParams).C(io.reactivex.l0.a.c());
    }

    public io.reactivex.a N(String str, String str2, ThingRuleDeleteParams thingRuleDeleteParams) {
        return this.h.H1(str, str2, thingRuleDeleteParams).C(io.reactivex.l0.a.c());
    }

    public q<ThingServiceExecResult> P(String str, String str2, String str3, ThingServiceParams thingServiceParams) {
        this.j.x(str3, O()).L0(io.reactivex.l0.a.c()).F0();
        return this.h.A(str, str2, thingServiceParams).N(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.TPCloudNetwork.repository.y1
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                q w1;
                w1 = ThingCloudRepository.this.w1((ThingServiceResult) obj);
                return w1;
            }
        }).L0(io.reactivex.l0.a.c());
    }

    public List<ThingDevice> R() {
        return new ArrayList(this.k.values());
    }

    public q<List<ThingInfo>> S() {
        return T(new ThingListPageParams(0, 100), b.d.s.c.a.b());
    }

    public q<List<ThingDevice>> U() {
        return Q(new ThingListPageParams(0, 20), b.d.s.c.a.b());
    }

    public io.reactivex.a U0(String str, String str2, String... strArr) {
        return this.h.J0(str, str2, TextUtils.join(SSLClient.COMMA, strArr)).C(io.reactivex.l0.a.c());
    }

    public q<ThingRuleListResult<ThingRuleAwayMode>> V(String str, String str2, int i2) {
        return this.h.w(str, str2, i2).L0(io.reactivex.l0.a.c());
    }

    public q<FirmwareDownloadState> W(String str, String str2) {
        return this.h.E0(str, str2).L0(io.reactivex.l0.a.c());
    }

    public q<ThingRuleListResult<ThingRuleGuardMode>> X(String str, String str2, int i2) {
        return this.h.z(str, str2, i2).L0(io.reactivex.l0.a.c());
    }

    public q<ThingNextEvent> Y(String str) {
        return d().N(new a(str));
    }

    public q<ThingRuleListResult<ThingRuleLightEffect>> Z(String str, String str2, int i2) {
        return this.h.I(str, str2, i2).L0(io.reactivex.l0.a.c());
    }

    @Override // com.tplink.iot.cloud.mqtt.q0
    public void a(AsyncResult asyncResult) {
        io.reactivex.m0.g<Long> remove = this.n.remove(asyncResult.getRequestId());
        if (remove == null) {
            remove = io.reactivex.m0.b.n1();
            this.n.put(asyncResult.getRequestId(), remove);
        }
        if (asyncResult.getCode() == 0) {
            remove.onComplete();
        } else {
            remove.onError(new IoTCloudException(asyncResult.getCode(), asyncResult.getMessage(), asyncResult.getData()));
        }
    }

    public q<NextEvent> a0(String str, String str2) {
        return this.h.l1(str, str2).L0(io.reactivex.l0.a.c());
    }

    public io.reactivex.a a1(String str, String str2) {
        return this.h.f1(str, str2).C(io.reactivex.l0.a.c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // b.d.b.d.b.a
    public void b() {
        super.b();
        this.n.clear();
    }

    public q<List<ThingNextEvent>> b0(String str) {
        return d().N(new b(str));
    }

    public q<SubThingScanListResult> c0(String str, String str2) {
        return this.h.K(str, str2).L0(io.reactivex.l0.a.c());
    }

    public q<ThingRuleListResult<ThingRuleSchedule>> d0(String str, String str2, int i2) {
        return this.h.g0(str, str2, i2).L0(io.reactivex.l0.a.c());
    }

    public void d1() {
        List<ThingModelCache> list;
        try {
            list = b.d.w.d.a.c(b.d.w.h.a.g(this.f100b.c().getCloudUserName()), "thing_model_list_key_v2", "thing_model_list_key_v2", ThingModelCache.class);
        } catch (Exception unused) {
            list = new ArrayList();
        }
        this.p.clear();
        if (!(list == null || list.isEmpty())) {
            for (ThingModelCache thingModelCache : list) {
                if (thingModelCache != null && !TextUtils.isEmpty(thingModelCache.getThingModelId())) {
                    this.p.put(thingModelCache.getThingModelId(), thingModelCache.getThingModel());
                }
            }
        }
    }

    public q<ThingComponentResult> e0(String str, String str2) {
        return this.h.t0(str, str2).L0(io.reactivex.l0.a.c());
    }

    public q<ThingDetail> f0(String str, String str2) {
        return this.h.M1(str, str2).L0(io.reactivex.l0.a.c());
    }

    public MutableLiveData<List<ThingDevice>> g0() {
        return this.l;
    }

    public q<ThingEventLogResult> h0(String str, String str2, Long l, Long l2, int i2, String str3, String str4) {
        return this.h.j(str, str2, l, l2, i2, str3, str4).L0(io.reactivex.l0.a.c());
    }

    public q<ThingRuleUpdateResult> h1(String str, String str2, String str3, ThingRuleGuardMode thingRuleGuardMode) {
        return this.h.p0(str, str2, str3, thingRuleGuardMode).L0(io.reactivex.l0.a.c());
    }

    public q<com.google.gson.i> i0(String str, String str2, String str3) {
        return this.h.G(str, str2, str3).L0(io.reactivex.l0.a.c());
    }

    public io.reactivex.a i1(String str, String str2, SubThingQuickSetupInfoListParams subThingQuickSetupInfoListParams) {
        return this.h.W(str, str2, subThingQuickSetupInfoListParams).C(io.reactivex.l0.a.c());
    }

    public q<ThingFirmware> j0(String str, String str2) {
        return this.h.R0(str, str2).L0(io.reactivex.l0.a.c());
    }

    public io.reactivex.a j1(String str, String str2) {
        return this.h.E1(str, str2).C(io.reactivex.l0.a.c()).l(new i(str2));
    }

    public MutableLiveData<List<ThingInfo>> k0() {
        return this.m;
    }

    public q<ThingRuleUpdateResult> k1(String str, String str2, String str3, ThingRuleAwayMode thingRuleAwayMode) {
        return this.h.D(str, str2, str3, thingRuleAwayMode).L0(io.reactivex.l0.a.c());
    }

    public q<PageListResult<ThingInfo>> l0(ThingListPageParams thingListPageParams, String str) {
        return d().N(new g(thingListPageParams, str));
    }

    public ThingModel m0(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return this.p.get(str);
    }

    public q<Boolean> m1(List<String> list, boolean z) {
        if (list == null || list.isEmpty()) {
            return q.f0(Boolean.FALSE);
        }
        return d().N(new c(z, list));
    }

    public q<ThingModel> n0(String str, String str2) {
        ThingModel thingModel;
        if (str2 == null || (thingModel = this.p.get(str2)) == null) {
            return X0(str, str2);
        }
        return q.f0(thingModel);
    }

    public q<ThingRuleUpdateResult> n1(String str, String str2, String str3, ThingRuleLightEffect thingRuleLightEffect) {
        return this.h.S(str, str2, str3, thingRuleLightEffect).L0(io.reactivex.l0.a.c());
    }

    public q<com.google.gson.i> o0(String str, String str2) {
        return this.h.X0(str, str2).L0(io.reactivex.l0.a.c());
    }

    public q<ThingRuleUpdateResult> o1(String str, String str2, String str3, ThingRuleSchedule thingRuleSchedule) {
        return this.h.m(str, str2, str3, thingRuleSchedule).L0(io.reactivex.l0.a.c());
    }

    public q<ThingRealTimeInfo> p0(String str, String str2) {
        return this.h.x(str, str2).L0(io.reactivex.l0.a.c());
    }

    public q<com.google.gson.i> p1(String str, String str2, String str3, com.google.gson.i iVar) {
        return this.h.i0(str, str2, str3, iVar).L0(io.reactivex.l0.a.c());
    }

    public q<ThingSetting> q0(String str, String str2) {
        return this.h.M0(str, str2).L0(io.reactivex.l0.a.c());
    }

    public io.reactivex.a q1(String str, String str2, com.google.gson.i iVar) {
        return this.h.T0(str, str2, iVar).C(io.reactivex.l0.a.c());
    }

    public io.reactivex.a r1(String str, String str2, Integer num, com.google.gson.i iVar) {
        return this.h.O(str, str2, num, iVar).C(io.reactivex.l0.a.c());
    }

    public io.reactivex.a s1(String str, String str2, ThingSetting thingSetting) {
        return this.h.s0(str, str2, thingSetting).C(io.reactivex.l0.a.c());
    }

    public q<ThingShadowListResult> t0(String str, String... strArr) {
        return this.h.H0(str, strArr).L0(io.reactivex.l0.a.c());
    }

    public q<Long> t1(String str, String str2, String str3, ThingShadowUpdateParams thingShadowUpdateParams, IMqttMessageListener iMqttMessageListener) {
        this.j.y(str3, this, str2, iMqttMessageListener).C(io.reactivex.l0.a.c()).y();
        return this.h.O1(str, str2, thingShadowUpdateParams).N(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.TPCloudNetwork.repository.q1
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                q s0;
                s0 = ThingCloudRepository.this.s0((ThingShadowUpdateResult) obj);
                return s0;
            }
        }).L0(io.reactivex.l0.a.c());
    }

    public q<ThingSupportInfoResult> u0(String str, String str2, String str3) {
        return this.h.Z(str, str2, str3).L0(io.reactivex.l0.a.c());
    }

    public q<ThingRuleUpdateResult> u1(String str, String str2, String str3, ThingRuleTimer thingRuleTimer) {
        return this.h.u1(str, str2, str3, thingRuleTimer).L0(io.reactivex.l0.a.c());
    }

    public q<ThingUsage> v0(String str, String str2) {
        return this.h.x0(str, str2).L0(io.reactivex.l0.a.c());
    }

    public io.reactivex.a v1(String str, String str2) {
        return this.h.q0(str, str2).C(io.reactivex.l0.a.c());
    }

    public q<ThingRuleListResult<ThingRuleTimer>> w0(String str, String str2, int i2) {
        return this.h.F(str, str2, i2).L0(io.reactivex.l0.a.c());
    }
}
