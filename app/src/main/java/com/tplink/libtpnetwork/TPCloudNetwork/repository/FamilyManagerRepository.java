package com.tplink.libtpnetwork.TPCloudNetwork.repository;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import b.d.w.c.a;
import com.tplink.cloud.define.CloudException;
import com.tplink.iot.cloud.bean.common.PageListResult;
import com.tplink.iot.cloud.bean.family.common.FamilyInfo;
import com.tplink.iot.cloud.bean.family.common.RoomInfo;
import com.tplink.iot.cloud.bean.family.common.RoomOrderInfo;
import com.tplink.iot.cloud.bean.family.params.FamilyCommonOrderParams;
import com.tplink.iot.cloud.bean.family.params.ThingFamilyParams;
import com.tplink.iot.cloud.bean.family.result.FamilyCommonOrderResult;
import com.tplink.iot.cloud.bean.thing.common.ThingInfo;
import com.tplink.iot.cloud.repository.AbstractIoTCloudRepository;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.params.FamilyListParams;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.DeviceBean;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.FamilyBean;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.FamilyCommonSortBean;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.RoomBean;
import com.tplink.libtpnetwork.exception.IoTException;
import io.reactivex.q;
import io.reactivex.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public class FamilyManagerRepository extends AbstractIoTCloudRepository {
    private com.tplink.iot.c.b.e h;
    private FamilyInfo j;
    private p o;
    private Map<String, FamilyInfo> i = new LinkedHashMap();
    private MutableLiveData<List<FamilyInfo>> k = new MutableLiveData<>();
    private MutableLiveData<FamilyInfo> l = new MutableLiveData<>();
    private final Map<String, FamilyCommonSortBean> m = new HashMap();
    private final MutableLiveData<List<String>> n = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements io.reactivex.g0.l<Throwable> {
        a() {
        }

        /* renamed from: a */
        public boolean test(Throwable th) throws Exception {
            if (th instanceof CloudException) {
                CloudException cloudException = (CloudException) th;
                if (-2 == cloudException.getErrCode() && "DATA_RETRY".equals(cloudException.getMsg())) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements io.reactivex.g0.j<PageListResult<FamilyInfo>, List<FamilyInfo>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f13727c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ FamilyListParams f13728d;

        b(List list, FamilyListParams familyListParams) {
            this.f13727c = list;
            this.f13728d = familyListParams;
        }

        /* renamed from: a */
        public List<FamilyInfo> apply(PageListResult<FamilyInfo> pageListResult) throws Exception {
            if (pageListResult != null) {
                long total = pageListResult.getTotal();
                if (total == 0) {
                    return new ArrayList();
                }
                if (this.f13727c.size() >= total) {
                    return this.f13727c;
                }
                List<FamilyInfo> data = pageListResult.getData();
                if (data != null && !data.isEmpty()) {
                    this.f13727c.addAll(data);
                }
                if (this.f13727c.size() >= total) {
                    return this.f13727c;
                }
                this.f13728d.setPage(pageListResult.getPage() + 1);
                throw new CloudException(-2, "DATA_RETRY");
            }
            throw new IoTException(-1, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements io.reactivex.g0.j<String, t<PageListResult<FamilyInfo>>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ FamilyListParams f13730c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class a implements io.reactivex.g0.j<FamilyListParams, t<PageListResult<FamilyInfo>>> {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f13732c;

            a(String str) {
                this.f13732c = str;
            }

            /* renamed from: a */
            public t<PageListResult<FamilyInfo>> apply(FamilyListParams familyListParams) throws Exception {
                return FamilyManagerRepository.this.h.j0(this.f13732c, c.this.f13730c.getPage(), 20);
            }
        }

        c(FamilyListParams familyListParams) {
            this.f13730c = familyListParams;
        }

        /* renamed from: a */
        public t<PageListResult<FamilyInfo>> apply(String str) throws Exception {
            return q.f0(this.f13730c).N(new a(str)).L0(io.reactivex.l0.a.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d implements io.reactivex.g0.j<String, t<FamilyCommonOrderResult>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f13734c;

        d(String str) {
            this.f13734c = str;
        }

        /* renamed from: a */
        public t<FamilyCommonOrderResult> apply(String str) throws Exception {
            return FamilyManagerRepository.this.h.L0(str, this.f13734c).L0(io.reactivex.l0.a.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class e implements io.reactivex.d {
        final /* synthetic */ boolean a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f13736b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f13737c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f13738d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ List f13739e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ boolean f13740f;

        /* loaded from: classes3.dex */
        class a implements io.reactivex.g0.g<Throwable> {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ io.reactivex.b f13741c;

            a(io.reactivex.b bVar) {
                this.f13741c = bVar;
            }

            /* renamed from: a */
            public void accept(Throwable th) throws Exception {
                this.f13741c.onError(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class b implements io.reactivex.g0.g<String> {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ io.reactivex.b f13743c;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* loaded from: classes3.dex */
            public class a implements io.reactivex.g0.g<Throwable> {
                a() {
                }

                /* renamed from: a */
                public void accept(Throwable th) throws Exception {
                    b.this.f13743c.onError(th);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyManagerRepository$e$b$b  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class C0273b implements io.reactivex.g0.a {
                C0273b() {
                }

                @Override // io.reactivex.g0.a
                public void run() throws Exception {
                    b.this.f13743c.onComplete();
                }
            }

            b(io.reactivex.b bVar) {
                this.f13743c = bVar;
            }

            /* renamed from: a */
            public void accept(String str) throws Exception {
                e eVar = e.this;
                FamilyManagerRepository.this.P0(eVar.f13739e, eVar.f13736b, str, eVar.f13740f).i(new C0273b()).j(new a()).y();
            }
        }

        /* loaded from: classes3.dex */
        class c implements io.reactivex.g0.j<Boolean, t<String>> {
            c() {
            }

            /* renamed from: a */
            public t<String> apply(Boolean bool) throws Exception {
                if (bool.booleanValue()) {
                    e eVar = e.this;
                    return FamilyManagerRepository.this.L(eVar.f13736b, eVar.f13737c, eVar.f13738d);
                }
                b.d.w.c.a.e("setDeviceFamilyRoom", "房间已存在");
                return q.f0(e.this.f13737c);
            }
        }

        /* loaded from: classes3.dex */
        class d implements Callable<Boolean> {
            d() {
            }

            /* renamed from: a */
            public Boolean call() throws Exception {
                return Boolean.valueOf(e.this.a);
            }
        }

        e(boolean z, String str, String str2, String str3, List list, boolean z2) {
            this.a = z;
            this.f13736b = str;
            this.f13737c = str2;
            this.f13738d = str3;
            this.f13739e = list;
            this.f13740f = z2;
        }

        @Override // io.reactivex.d
        public void a(io.reactivex.b bVar) throws Exception {
            q.X(new d()).N(new c()).E(new b(bVar)).C(new a(bVar)).F0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class f implements io.reactivex.g0.j<RoomBean, t<String>> {
        f() {
        }

        /* renamed from: a */
        public t<String> apply(RoomBean roomBean) throws Exception {
            if (roomBean == null || TextUtils.isEmpty(roomBean.getRoomId())) {
                throw new CloudException();
            }
            b.d.w.c.a.e("setDeviceFamilyRoom", "addNewRoom success");
            return q.f0(roomBean.getRoomId());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class g implements io.reactivex.g0.j<List<FamilyInfo>, List<FamilyInfo>> {
        g() {
        }

        /* renamed from: a */
        public List<FamilyInfo> apply(List<FamilyInfo> list) throws Exception {
            FamilyManagerRepository.this.i.clear();
            if (list != null && !list.isEmpty()) {
                for (FamilyInfo familyInfo : list) {
                    FamilyManagerRepository.this.i.put(familyInfo.getId(), familyInfo);
                }
            }
            FamilyManagerRepository.this.l1();
            return list;
        }
    }

    /* loaded from: classes3.dex */
    class h implements io.reactivex.g0.g<Throwable> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f13750c;

        h(String str) {
            this.f13750c = str;
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            FamilyManagerRepository familyManagerRepository = FamilyManagerRepository.this;
            familyManagerRepository.j = familyManagerRepository.Y(this.f13750c);
            FamilyManagerRepository.this.W0();
            FamilyManagerRepository.this.Y0();
            FamilyManagerRepository.this.X0();
            FamilyManagerRepository.this.Z();
        }
    }

    /* loaded from: classes3.dex */
    class i implements io.reactivex.g0.j<List<FamilyInfo>, FamilyInfo> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f13752c;

        i(String str) {
            this.f13752c = str;
        }

        /* renamed from: a */
        public FamilyInfo apply(List<FamilyInfo> list) throws Exception {
            FamilyManagerRepository familyManagerRepository = FamilyManagerRepository.this;
            familyManagerRepository.j = familyManagerRepository.Y(this.f13752c);
            FamilyManagerRepository.this.W0();
            FamilyManagerRepository.this.Y0();
            FamilyManagerRepository.this.X0();
            FamilyManagerRepository.this.Z();
            return FamilyManagerRepository.this.j;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class j implements io.reactivex.g0.j<String, t<FamilyBean>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ FamilyInfo f13754c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f13755d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class a implements io.reactivex.g0.j<FamilyInfo, FamilyBean> {
            a() {
            }

            /* renamed from: a */
            public FamilyBean apply(FamilyInfo familyInfo) {
                FamilyBean familyBean = new FamilyBean();
                if (familyInfo != null) {
                    if (j.this.f13755d) {
                        familyBean.setFamilyId(familyInfo.getId());
                        familyBean.setFamilyName(familyInfo.getName());
                    } else {
                        familyBean.setFamilyName(familyInfo.getName());
                    }
                    j jVar = j.this;
                    FamilyManagerRepository.this.i1(familyInfo, jVar.f13755d);
                }
                return familyBean;
            }
        }

        j(FamilyInfo familyInfo, boolean z) {
            this.f13754c = familyInfo;
            this.f13755d = z;
        }

        /* renamed from: a */
        public t<FamilyBean> apply(String str) throws Exception {
            return FamilyManagerRepository.this.h.m0(str, this.f13754c).L0(io.reactivex.l0.a.c()).g0(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class k implements io.reactivex.g0.a {
        final /* synthetic */ String a;

        k(String str) {
            this.a = str;
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            FamilyManagerRepository.this.i.remove(this.a);
            FamilyManagerRepository.this.l1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class l implements io.reactivex.g0.j<String, t<RoomBean>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f13759c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ RoomInfo f13760d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ boolean f13761f;
        final /* synthetic */ String q;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class a implements io.reactivex.g0.j<RoomInfo, RoomBean> {
            a() {
            }

            /* renamed from: a */
            public RoomBean apply(RoomInfo roomInfo) {
                RoomBean roomBean = new RoomBean();
                if (roomInfo != null) {
                    l lVar = l.this;
                    if (lVar.f13761f) {
                        roomBean.setRoomId(roomInfo.getId());
                        roomBean.setRoomName(roomInfo.getName());
                        roomBean.setAvatarUrl(roomInfo.getAvatarUrl());
                    } else {
                        roomBean.setRoomName(lVar.q);
                    }
                    l lVar2 = l.this;
                    FamilyManagerRepository.this.o1(lVar2.f13759c, roomInfo, lVar2.f13761f);
                }
                return roomBean;
            }
        }

        l(String str, RoomInfo roomInfo, boolean z, String str2) {
            this.f13759c = str;
            this.f13760d = roomInfo;
            this.f13761f = z;
            this.q = str2;
        }

        /* renamed from: a */
        public t<RoomBean> apply(String str) throws Exception {
            return FamilyManagerRepository.this.h.R(str, this.f13759c, this.f13760d).L0(io.reactivex.l0.a.c()).g0(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class m implements io.reactivex.g0.a {
        final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f13763b;

        m(String str, String str2) {
            this.a = str;
            this.f13763b = str2;
        }

        @Override // io.reactivex.g0.a
        public void run() {
            FamilyManagerRepository.this.Q(this.a, this.f13763b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class n implements io.reactivex.g0.a {
        final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f13765b;

        n(String str, List list) {
            this.a = str;
            this.f13765b = list;
        }

        @Override // io.reactivex.g0.a
        public void run() {
            FamilyManagerRepository.this.q1(this.a, this.f13765b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class o implements Comparator<RoomInfo> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f13767c;

        o(List list) {
            this.f13767c = list;
        }

        /* renamed from: a */
        public int compare(RoomInfo roomInfo, RoomInfo roomInfo2) {
            return this.f13767c.indexOf(roomInfo.getId()) - this.f13767c.indexOf(roomInfo2.getId());
        }
    }

    /* loaded from: classes3.dex */
    public interface p {
        void a(@NonNull List<String> list);

        void b(@NonNull List<String> list);

        void e();
    }

    public FamilyManagerRepository(com.tplink.iot.c.c.a aVar) {
        super(aVar);
        this.h = (com.tplink.iot.c.b.e) aVar.k().R1(com.tplink.iot.c.b.e.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B0 */
    public /* synthetic */ io.reactivex.e C0(ThingFamilyParams thingFamilyParams, String str) throws Exception {
        return this.h.J(str, thingFamilyParams).C(io.reactivex.l0.a.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D0 */
    public /* synthetic */ io.reactivex.e E0(ThingFamilyParams thingFamilyParams, final List list, final String str, final String str2, String str3) throws Exception {
        return this.h.J(str3, thingFamilyParams).C(io.reactivex.l0.a.c()).i(new io.reactivex.g0.a() { // from class: com.tplink.libtpnetwork.TPCloudNetwork.repository.p0
            @Override // io.reactivex.g0.a
            public final void run() {
                FamilyManagerRepository.this.x0(list, str, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F0 */
    public /* synthetic */ io.reactivex.e G0(ThingFamilyParams thingFamilyParams, final List list, final String str, final String str2, String str3) throws Exception {
        return this.h.C0(str3, thingFamilyParams).C(io.reactivex.l0.a.c()).i(new io.reactivex.g0.a() { // from class: com.tplink.libtpnetwork.TPCloudNetwork.repository.v0
            @Override // io.reactivex.g0.a
            public final void run() {
                FamilyManagerRepository.this.z0(list, str, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H0 */
    public /* synthetic */ io.reactivex.e I0(List list, String str, String str2) throws Exception {
        return this.h.v0(str2, str, new FamilyCommonOrderParams(list)).C(io.reactivex.l0.a.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J0 */
    public /* synthetic */ io.reactivex.e K0(String str, RoomOrderInfo roomOrderInfo, List list, String str2) throws Exception {
        return this.h.r0(str2, str, roomOrderInfo).C(io.reactivex.l0.a.c()).i(new n(str, list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public q<String> L(String str, String str2, String str3) {
        return n1(str, str2, str3, true).N(new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L0 */
    public List<String> q0(String str, @Nullable FamilyCommonSortBean familyCommonSortBean, @Nullable FamilyCommonOrderResult familyCommonOrderResult) {
        b.d.w.c.a.n("HomeSort", String.format("mergeLocalAndCloudSortList local: %s\ncloud: %s", com.tplink.libtpnetwork.Utils.i.j(familyCommonSortBean), com.tplink.libtpnetwork.Utils.i.j(familyCommonOrderResult)));
        if (familyCommonSortBean == null && familyCommonOrderResult == null) {
            return new ArrayList();
        }
        if (familyCommonSortBean == null) {
            m1(str, familyCommonOrderResult);
            return familyCommonOrderResult.getCommonOrders();
        } else if (familyCommonOrderResult == null) {
            return familyCommonSortBean.getSortList();
        } else {
            if (familyCommonSortBean.getRecordTimestamp() > (familyCommonOrderResult.getRecordTimestamp() != null ? familyCommonOrderResult.getRecordTimestamp().longValue() : 0L)) {
                k1(str, familyCommonSortBean.getSortList()).y();
                return familyCommonSortBean.getSortList();
            }
            m1(str, familyCommonOrderResult);
            return familyCommonOrderResult.getCommonOrders();
        }
    }

    private void O(String str) {
        FamilyInfo familyInfo = this.j;
        if (familyInfo != null && str != null && str.equals(familyInfo.getId())) {
            Y0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public io.reactivex.a P0(List<String> list, String str, String str2, final boolean z) {
        io.reactivex.a aVar;
        b.d.w.c.a.e("setDeviceFamilyRoom1", "deviceIds=" + com.tplink.libtpnetwork.Utils.i.f(list) + ", familyId=" + str + ", roomId=" + str2);
        if (z) {
            aVar = f1(str, str2, list);
        } else {
            aVar = e1(str, str2, list);
        }
        return aVar.i(new io.reactivex.g0.a() { // from class: com.tplink.libtpnetwork.TPCloudNetwork.repository.u0
            @Override // io.reactivex.g0.a
            public final void run() {
                a.e("setDeviceFamilyRoom2", "设置设备房间成功 + isFromOnBoarding=" + z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(String str, String str2) {
        FamilyInfo familyInfo = this.i.get(str);
        if (familyInfo != null) {
            Iterator<RoomInfo> it = familyInfo.getRooms().iterator();
            while (true) {
                if (it.hasNext()) {
                    if (str2.equals(it.next().getId())) {
                        it.remove();
                        break;
                    }
                } else {
                    break;
                }
            }
            Z0();
            O(familyInfo.getId());
        }
    }

    private String S() {
        return com.tplink.libtpnetwork.Utils.m.a(8);
    }

    private void U0() {
        b.d.w.c.a.n("HomeSort", "saveAllFamilyCommonSortListLocalCache: " + com.tplink.libtpnetwork.Utils.i.f(this.m));
        b.d.w.d.a.l(b.d.w.h.a.g(this.f100b.c().getCloudUserName()), new ArrayList(this.m.values()), "all_family_common_sort_list", "all_family_common_sort_list");
    }

    private q<List<FamilyInfo>> V(FamilyListParams familyListParams) {
        return e0(familyListParams).g0(new b(new ArrayList(), familyListParams)).w0(new a());
    }

    private void V0() {
        b.d.w.d.a.l(b.d.w.h.a.g(this.f100b.c().getCloudUserName()), new ArrayList(this.i.values()), "all_family_list_key", "all_family_list_key");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W0() {
        FamilyInfo familyInfo = this.j;
        if (familyInfo != null && familyInfo.getId() != null) {
            b.d.w.d.a.l(b.d.w.h.a.g(this.f100b.c().getCloudUserName()), this.j, "current_family_key", "current_family_key");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0() {
        b.d.w.c.a.n("HomeSort", "sendCurrentFamilyCommonSortListEvent currentFamily: " + com.tplink.libtpnetwork.Utils.i.f(this.j));
        FamilyInfo familyInfo = this.j;
        if (familyInfo != null) {
            FamilyCommonSortBean familyCommonSortBean = this.m.get(familyInfo.getId());
            this.n.postValue(familyCommonSortBean != null ? familyCommonSortBean.getSortList() : null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FamilyInfo Y(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (FamilyInfo familyInfo : this.i.values()) {
                if (str.equals(familyInfo.getId())) {
                    return familyInfo;
                }
            }
        }
        for (FamilyInfo familyInfo2 : this.i.values()) {
            if (familyInfo2.isDefault()) {
                return familyInfo2;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y0() {
        this.l.postValue(this.j);
    }

    private void Z0() {
        this.k.postValue(new ArrayList(this.i.values()));
    }

    private void c1() {
        FamilyInfo familyInfo = this.j;
        if (familyInfo == null || familyInfo.getId() == null) {
            this.j = Y(null);
        } else if (this.j.getId() != null) {
            this.j = Y(this.j.getId());
        }
    }

    private q<FamilyCommonOrderResult> d0(String str) {
        b.d.w.c.a.n("HomeSort", "getCommonThingOrder");
        return d().N(new d(str));
    }

    private q<PageListResult<FamilyInfo>> e0(FamilyListParams familyListParams) {
        return d().N(new c(familyListParams));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g1 */
    public void y0(List<String> list, String str, String str2) {
        ThingDevice thingDevice;
        ThingInfo thingInfo;
        if (!(list == null || list.isEmpty())) {
            TPIoTClientManager tPIoTClientManager = (TPIoTClientManager) b.d.b.f.b.a(b.d.s.a.a.f(), TPIoTClientManager.class);
            new HashMap();
            for (String str3 : list) {
                BaseALIoTDevice Z1 = tPIoTClientManager.Z1(b.d.w.h.a.g(str3));
                if (!(Z1 == null || Z1.getThingDevice() == null || (thingDevice = Z1.getThingDevice()) == null || (thingInfo = thingDevice.getThingInfo()) == null)) {
                    thingInfo.setFamilyId(str);
                    thingInfo.setRoomId(str2);
                }
            }
            tPIoTClientManager.L3();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i1(FamilyInfo familyInfo, boolean z) {
        if (z) {
            this.i.put(familyInfo.getId(), familyInfo);
        } else {
            FamilyInfo familyInfo2 = this.i.get(familyInfo.getId());
            if (familyInfo2 != null) {
                familyInfo2.setName(familyInfo.getName());
                this.i.put(familyInfo.getId(), familyInfo2);
            }
        }
        l1();
    }

    private io.reactivex.a k1(final String str, final List<String> list) {
        return d().R(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.TPCloudNetwork.repository.q0
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return FamilyManagerRepository.this.I0(list, str, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l1() {
        c1();
        W0();
        V0();
        Z0();
        Y0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m0 */
    public /* synthetic */ io.reactivex.e n0(String str, String str2) throws Exception {
        return this.h.Q(str2, str).C(io.reactivex.l0.a.c()).i(new k(str));
    }

    private void m1(String str, @NonNull FamilyCommonOrderResult familyCommonOrderResult) {
        this.m.put(str, new FamilyCommonSortBean(str, familyCommonOrderResult));
        U0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0 */
    public /* synthetic */ io.reactivex.e p0(String str, String str2, String str3) throws Exception {
        return this.h.y1(str3, str, str2).C(io.reactivex.l0.a.c()).i(new m(str, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o1(String str, RoomInfo roomInfo, boolean z) {
        FamilyInfo familyInfo = this.i.get(str);
        if (familyInfo != null) {
            List<RoomInfo> rooms = familyInfo.getRooms();
            if (z) {
                if (rooms == null) {
                    rooms = new ArrayList<>();
                }
                rooms.add(roomInfo);
                familyInfo.setRooms(rooms);
                this.i.put(str, familyInfo);
            } else if (rooms != null) {
                Iterator<RoomInfo> it = rooms.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    RoomInfo next = it.next();
                    if (next.getId().equals(roomInfo.getId())) {
                        next.setName(roomInfo.getName());
                        break;
                    }
                }
            }
        }
        l1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q1(String str, List<String> list) {
        FamilyInfo familyInfo = this.i.get(str);
        if (familyInfo != null && familyInfo.getRooms() != null) {
            Collections.sort(familyInfo.getRooms(), new o(list));
            Z0();
            O(familyInfo.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s0 */
    public /* synthetic */ void t0(List list) throws Exception {
        X0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0 */
    public /* synthetic */ void v0(Throwable th) throws Exception {
        X0();
    }

    public io.reactivex.a M(List<String> list, String str, String str2, String str3, boolean z, boolean z2) {
        return io.reactivex.a.g(new e(z, str, str2, str3, list, z2)).C(io.reactivex.l0.a.c());
    }

    public void M0() {
        p pVar = this.o;
        if (pVar != null) {
            pVar.e();
        }
    }

    public q<FamilyInfo> N(String str) {
        return U().g0(new i(str)).C(new h(str));
    }

    public void N0(@Nullable List<String> list) {
        if (this.o != null && list != null && !list.isEmpty()) {
            this.o.b(list);
        }
    }

    public void O0(@Nullable List<String> list) {
        if (this.o != null && list != null && !list.isEmpty()) {
            this.o.a(list);
        }
    }

    public io.reactivex.a P(final String str) {
        return d().R(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.TPCloudNetwork.repository.n0
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return FamilyManagerRepository.this.n0(str, (String) obj);
            }
        });
    }

    public void Q0(@Nullable List<String> list, @Nullable List<String> list2) {
        HashSet<String> hashSet = new HashSet();
        if (list != null && !list.isEmpty()) {
            for (String str : list) {
                for (FamilyCommonSortBean familyCommonSortBean : this.m.values()) {
                    if (familyCommonSortBean.removeDevice(str)) {
                        hashSet.add(familyCommonSortBean.getFamilyId());
                    }
                }
            }
        }
        if (list2 != null && !list2.isEmpty()) {
            for (String str2 : list2) {
                for (FamilyCommonSortBean familyCommonSortBean2 : this.m.values()) {
                    if (familyCommonSortBean2.removeGroup(str2)) {
                        hashSet.add(familyCommonSortBean2.getFamilyId());
                    }
                }
            }
        }
        if (!hashSet.isEmpty()) {
            for (String str3 : hashSet) {
                FamilyCommonSortBean familyCommonSortBean3 = this.m.get(str3);
                if (!(familyCommonSortBean3 == null || familyCommonSortBean3.getSortList() == null)) {
                    familyCommonSortBean3.updateRecordTimestampNow();
                    k1(str3, familyCommonSortBean3.getSortList()).y();
                }
            }
            U0();
        }
        b.d.w.c.a.n("HomeSort", String.format("removeDeviceGroupSortIdsFromAllFamily after change: %s", com.tplink.libtpnetwork.Utils.i.j(this.m)));
    }

    public io.reactivex.a R(final String str, final String str2) {
        return d().R(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.TPCloudNetwork.repository.x0
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return FamilyManagerRepository.this.p0(str, str2, (String) obj);
            }
        });
    }

    public void R0() {
        List<FamilyCommonSortBean> list;
        try {
            list = b.d.w.d.a.c(b.d.w.h.a.g(this.f100b.c().getCloudUserName()), "all_family_common_sort_list", "all_family_common_sort_list", FamilyCommonSortBean.class);
        } catch (Exception unused) {
            list = new ArrayList();
        }
        this.m.clear();
        if (list != null && !list.isEmpty()) {
            for (FamilyCommonSortBean familyCommonSortBean : list) {
                this.m.put(familyCommonSortBean.getFamilyId(), familyCommonSortBean);
            }
        }
        b.d.w.c.a.n("HomeSort", "restoreAllFamilyCommonSortListLocalCache: " + com.tplink.libtpnetwork.Utils.i.f(this.m));
        X0();
    }

    public void S0() {
        List<FamilyInfo> list;
        try {
            list = b.d.w.d.a.c(b.d.w.h.a.g(this.f100b.c().getCloudUserName()), "all_family_list_key", "all_family_list_key", FamilyInfo.class);
        } catch (Exception unused) {
            list = new ArrayList();
        }
        this.i.clear();
        if (list != null && !list.isEmpty()) {
            for (FamilyInfo familyInfo : list) {
                this.i.put(familyInfo.getId(), familyInfo);
            }
        }
        Z0();
    }

    public List<FamilyInfo> T() {
        if (this.i == null) {
            return new ArrayList();
        }
        return new ArrayList(this.i.values());
    }

    public void T0() {
        FamilyInfo familyInfo = (FamilyInfo) b.d.w.d.a.b(b.d.w.h.a.g(this.f100b.c().getCloudUserName()), "current_family_key", "current_family_key", FamilyInfo.class);
        if (familyInfo != null && familyInfo.getId() != null) {
            this.j = familyInfo;
            Y0();
        }
    }

    public q<List<FamilyInfo>> U() {
        return V(new FamilyListParams(0)).g0(new g());
    }

    public q<List<String>> W(final String str) {
        b.d.w.c.a.n("HomeSort", "getCommonDeviceGroupSortList");
        final FamilyCommonSortBean familyCommonSortBean = this.m.get(str);
        return d0(str).g0(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.TPCloudNetwork.repository.s0
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return FamilyManagerRepository.this.r0(str, familyCommonSortBean, (FamilyCommonOrderResult) obj);
            }
        }).q0((familyCommonSortBean == null || familyCommonSortBean.getSortList() == null) ? new ArrayList<>() : familyCommonSortBean.getSortList());
    }

    public FamilyInfo X() {
        return this.j;
    }

    public void Z() {
        b.d.w.c.a.n("HomeSort", "getCurrentFamilyCommonOrderAndSend currentFamily: " + com.tplink.libtpnetwork.Utils.i.f(this.j));
        FamilyInfo familyInfo = this.j;
        if (familyInfo != null) {
            W(familyInfo.getId()).E(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.TPCloudNetwork.repository.o0
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    FamilyManagerRepository.this.t0((List) obj);
                }
            }).C(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.TPCloudNetwork.repository.y0
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    FamilyManagerRepository.this.v0((Throwable) obj);
                }
            }).F0();
        }
    }

    public MutableLiveData<List<String>> a0() {
        return this.n;
    }

    public void a1(p pVar) {
        this.o = pVar;
    }

    @Nullable
    public List<String> b0() {
        FamilyCommonSortBean familyCommonSortBean;
        FamilyInfo familyInfo = this.j;
        if (familyInfo == null || (familyCommonSortBean = this.m.get(familyInfo.getId())) == null) {
            return null;
        }
        return familyCommonSortBean.getSortList();
    }

    public io.reactivex.a b1(String str, String str2, String str3, String str4, boolean z, boolean z2) {
        return M(Collections.singletonList(str), str2, str3, str4, z, z2);
    }

    public MutableLiveData<FamilyInfo> c0() {
        return this.l;
    }

    public io.reactivex.a d1(String str, String str2, List<DeviceBean> list) {
        ArrayList arrayList = new ArrayList();
        for (DeviceBean deviceBean : list) {
            arrayList.add(deviceBean.getDeviceId());
        }
        final ThingFamilyParams thingFamilyParams = new ThingFamilyParams(str, str2, arrayList);
        return d().R(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.TPCloudNetwork.repository.z0
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return FamilyManagerRepository.this.C0(thingFamilyParams, (String) obj);
            }
        });
    }

    public io.reactivex.a e1(final String str, final String str2, final List<String> list) {
        final ThingFamilyParams thingFamilyParams = new ThingFamilyParams(str, str2, list);
        return d().R(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.TPCloudNetwork.repository.t0
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return FamilyManagerRepository.this.E0(thingFamilyParams, list, str, str2, (String) obj);
            }
        });
    }

    public String f0(String str, String str2) {
        FamilyInfo familyInfo;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (familyInfo = this.i.get(str)) != null) {
            for (RoomInfo roomInfo : familyInfo.getRooms()) {
                if (str2.equals(roomInfo.getId())) {
                    return roomInfo.getName();
                }
            }
        }
        return null;
    }

    public io.reactivex.a f1(final String str, final String str2, final List<String> list) {
        final ThingFamilyParams thingFamilyParams = new ThingFamilyParams(str, str2, list);
        return d().R(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.TPCloudNetwork.repository.w0
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return FamilyManagerRepository.this.G0(thingFamilyParams, list, str, str2, (String) obj);
            }
        });
    }

    public boolean g0(FamilyInfo familyInfo) {
        if (this.j == null || familyInfo == null) {
            return false;
        }
        if (TextUtils.isEmpty(familyInfo.getId())) {
            return this.j.isDefault();
        }
        return familyInfo.getId().equals(this.j.getId());
    }

    public boolean h0(boolean z, boolean z2, boolean z3, String str) {
        if (z) {
            return z3;
        }
        if (z2 && this.j != null) {
            return TextUtils.isEmpty(str) ? this.j.isDefault() && z3 : str.equals(this.j.getId()) && z3;
        }
        return true;
    }

    public q<FamilyBean> h1(String str, String str2, boolean z) {
        if (str == null) {
            str = S();
        }
        return d().N(new j(new FamilyInfo(str, str2), z));
    }

    public boolean i0(boolean z, String str) {
        if (this.j == null) {
            return true;
        }
        return TextUtils.isEmpty(str) ? this.j.isDefault() && z : str.equals(this.j.getId()) && z;
    }

    public boolean j0(boolean z, boolean z2, String str) {
        if (z || !z2 || this.j == null) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            return this.j.isDefault();
        }
        return str.equals(this.j.getId());
    }

    public io.reactivex.a j1(String str, List<String> list) {
        FamilyCommonSortBean familyCommonSortBean = this.m.get(str);
        if (familyCommonSortBean == null) {
            this.m.put(str, new FamilyCommonSortBean(str, list, System.currentTimeMillis()));
        } else {
            familyCommonSortBean.updateRecordTimestampNow();
            familyCommonSortBean.setSortList(list);
        }
        U0();
        return k1(str, list);
    }

    public boolean k0(String str) {
        if (this.j == null) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            return this.j.isDefault();
        }
        return str.equals(this.j.getId());
    }

    public boolean l0() {
        Map<String, FamilyInfo> map = this.i;
        return map == null || map.isEmpty();
    }

    public q<RoomBean> n1(@Nullable String str, String str2, @Nullable String str3, boolean z) {
        if (str2 == null) {
            str2 = S();
        }
        RoomInfo roomInfo = new RoomInfo();
        roomInfo.setId(str2);
        roomInfo.setName(str3);
        return d().N(new l(str, roomInfo, z, str3));
    }

    public io.reactivex.a p1(final String str, final List<String> list) {
        final RoomOrderInfo roomOrderInfo = new RoomOrderInfo();
        roomOrderInfo.setRoomIds(list);
        return d().R(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.TPCloudNetwork.repository.r0
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return FamilyManagerRepository.this.K0(str, roomOrderInfo, list, (String) obj);
            }
        });
    }
}
