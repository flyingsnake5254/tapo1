package com.tplink.libtpnetwork.IoTNetwork.repository;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import com.tplink.cloud.define.CloudException;
import com.tplink.iot.cloud.bean.common.PageListResult;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.iot.cloud.bean.group.params.GroupThingGroupListParams;
import com.tplink.iot.cloud.bean.group.params.GroupThingListParams;
import com.tplink.iot.cloud.repository.AbstractIoTCloudRepository;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.AutoLightBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.params.ListParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyManagerRepository;
import com.tplink.libtpnetwork.exception.IoTException;
import io.reactivex.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class GroupRepository extends AbstractIoTCloudRepository {
    private com.tplink.iot.c.b.f h;
    private Map<String, GroupInfo> i = new LinkedHashMap();
    private MutableLiveData<List<GroupInfo>> j = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements io.reactivex.g0.a {
        final /* synthetic */ List a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f12902b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f12903c;

        a(List list, String str, String str2) {
            this.a = list;
            this.f12902b = str;
            this.f12903c = str2;
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            for (String str : this.a) {
                GroupInfo groupInfo = (GroupInfo) GroupRepository.this.i.get(str);
                if (groupInfo != null) {
                    groupInfo.setFamilyId(this.f12902b);
                    groupInfo.setRoomId(this.f12903c);
                }
            }
            GroupRepository.this.y0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements io.reactivex.g0.a {
        final /* synthetic */ String a;

        b(String str) {
            this.a = str;
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            GroupRepository.this.i.remove(this.a);
            GroupRepository.this.k0(Collections.singletonList(this.a));
            GroupRepository.this.y0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements io.reactivex.g0.a {
        final /* synthetic */ List a;

        c(List list) {
            this.a = list;
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            for (String str : this.a) {
                GroupRepository.this.i.remove(str);
            }
            GroupRepository.this.k0(this.a);
            GroupRepository.this.y0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d implements io.reactivex.g0.a {
        d() {
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            GroupRepository.this.P().F0();
        }
    }

    /* loaded from: classes3.dex */
    class e implements io.reactivex.g0.a {
        e() {
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            GroupRepository.this.P().F0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class f implements io.reactivex.g0.l<Throwable> {
        f() {
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
    public class g implements io.reactivex.g0.j<PageListResult<GroupInfo>, List<GroupInfo>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f12908c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ListParams f12909d;

        g(List list, ListParams listParams) {
            this.f12908c = list;
            this.f12909d = listParams;
        }

        /* renamed from: a */
        public List<GroupInfo> apply(PageListResult<GroupInfo> pageListResult) throws Exception {
            if (pageListResult != null) {
                long total = pageListResult.getTotal();
                if (total == 0) {
                    return new ArrayList();
                }
                if (this.f12908c.size() >= total) {
                    return this.f12908c;
                }
                List<GroupInfo> data = pageListResult.getData();
                if (data != null && !data.isEmpty()) {
                    this.f12908c.addAll(data);
                }
                if (this.f12908c.size() >= total) {
                    return this.f12908c;
                }
                this.f12909d.setPage(pageListResult.getPage() + 1);
                throw new CloudException(-2, "DATA_RETRY");
            }
            throw new IoTException(-1, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class h implements io.reactivex.g0.j<String, t<PageListResult<GroupInfo>>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ListParams f12911c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class a implements io.reactivex.g0.j<ListParams, t<PageListResult<GroupInfo>>> {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f12913c;

            a(String str) {
                this.f12913c = str;
            }

            /* renamed from: a */
            public t<PageListResult<GroupInfo>> apply(ListParams listParams) throws Exception {
                return GroupRepository.this.h.K1(this.f12913c, h.this.f12911c.getPage(), 20, new String[0]);
            }
        }

        h(ListParams listParams) {
            this.f12911c = listParams;
        }

        /* renamed from: a */
        public t<PageListResult<GroupInfo>> apply(String str) throws Exception {
            return io.reactivex.q.f0(this.f12911c).N(new a(str)).L0(io.reactivex.l0.a.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class i implements io.reactivex.g0.j<String, t<GroupInfo>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f12915c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class a implements io.reactivex.g0.g<GroupInfo> {
            a() {
            }

            /* renamed from: a */
            public void accept(GroupInfo groupInfo) throws Exception {
                GroupRepository.this.x0(groupInfo);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class b implements io.reactivex.g0.j<PageListResult<GroupInfo>, t<GroupInfo>> {
            b() {
            }

            /* renamed from: a */
            public t<GroupInfo> apply(PageListResult<GroupInfo> pageListResult) throws Exception {
                if (pageListResult == null) {
                    return io.reactivex.q.J(new Exception("pageListResult is null"));
                }
                List<GroupInfo> data = pageListResult.getData();
                if (data == null || data.isEmpty()) {
                    return io.reactivex.q.J(new Exception("groupInfoList is null"));
                }
                return io.reactivex.q.f0(data.get(0));
            }
        }

        i(String str) {
            this.f12915c = str;
        }

        /* renamed from: a */
        public t<GroupInfo> apply(String str) throws Exception {
            return GroupRepository.this.h.K1(str, 0, 1, this.f12915c).L0(io.reactivex.l0.a.c()).N(new b()).E(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class j implements io.reactivex.g0.j<List<GroupInfo>, List<GroupInfo>> {
        j() {
        }

        /* renamed from: a */
        public List<GroupInfo> apply(List<GroupInfo> list) throws Exception {
            GroupRepository.this.i.clear();
            if (list != null && !list.isEmpty()) {
                for (GroupInfo groupInfo : list) {
                    GroupRepository.this.i.put(groupInfo.getId(), groupInfo);
                }
            }
            GroupRepository.this.y0();
            return list;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class k implements io.reactivex.g0.a {
        final /* synthetic */ GroupInfo a;

        k(GroupInfo groupInfo) {
            this.a = groupInfo;
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            GroupRepository.this.C(this.a.getId());
            GroupRepository.this.P().F0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class l implements io.reactivex.g0.a {
        final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f12921b;

        l(String str, String str2) {
            this.a = str;
            this.f12921b = str2;
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            GroupInfo groupInfo = (GroupInfo) GroupRepository.this.i.get(this.a);
            if (groupInfo != null) {
                groupInfo.setRoomId(this.f12921b);
            }
            GroupRepository.this.y0();
        }
    }

    /* loaded from: classes3.dex */
    class m implements io.reactivex.g0.a {
        final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f12923b;

        m(String str, String str2) {
            this.a = str;
            this.f12923b = str2;
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            GroupInfo groupInfo = (GroupInfo) GroupRepository.this.i.get(this.a);
            if (groupInfo != null) {
                groupInfo.setName(this.f12923b);
            }
            GroupRepository.this.y0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class n implements io.reactivex.g0.a {
        final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Map f12925b;

        n(String str, Map map) {
            this.a = str;
            this.f12925b = map;
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            GroupInfo groupInfo = (GroupInfo) GroupRepository.this.i.get(this.a);
            if (groupInfo != null) {
                groupInfo.setStateDesired(this.f12925b);
            }
            GroupRepository.this.y0();
        }
    }

    /* loaded from: classes3.dex */
    class o implements io.reactivex.g0.a {
        final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.google.gson.i f12927b;

        o(String str, com.google.gson.i iVar) {
            this.a = str;
            this.f12927b = iVar;
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            GroupInfo groupInfo = (GroupInfo) GroupRepository.this.i.get(this.a);
            if (groupInfo != null) {
                groupInfo.setPresets(this.f12927b);
            }
            GroupRepository.this.y0();
        }
    }

    /* loaded from: classes3.dex */
    class p implements io.reactivex.g0.a {
        final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f12929b;

        p(String str, String str2) {
            this.a = str;
            this.f12929b = str2;
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            GroupInfo groupInfo = (GroupInfo) GroupRepository.this.i.get(this.a);
            if (groupInfo != null) {
                groupInfo.setName(this.f12929b);
            }
            GroupRepository.this.y0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class q implements io.reactivex.g0.a {
        final /* synthetic */ List a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f12931b;

        q(List list, boolean z) {
            this.a = list;
            this.f12931b = z;
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            for (String str : this.a) {
                GroupInfo groupInfo = (GroupInfo) GroupRepository.this.i.get(str);
                if (groupInfo != null) {
                    groupInfo.setCommon(Boolean.valueOf(this.f12931b));
                }
            }
            GroupRepository.this.y0();
        }
    }

    public GroupRepository(com.tplink.iot.c.c.a aVar) {
        super(aVar);
        this.h = (com.tplink.iot.c.b.f) aVar.k().R1(com.tplink.iot.c.b.f.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            ((FamilyManagerRepository) b.d.b.f.b.a(b.d.s.a.a.f(), FamilyManagerRepository.class)).N0(Collections.singletonList(str));
        }
    }

    private io.reactivex.a D(final GroupThingGroupListParams groupThingGroupListParams) {
        return d().R(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.p5
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return GroupRepository.this.Y(groupThingGroupListParams, (String) obj);
            }
        });
    }

    private io.reactivex.a F0(String str, Map<String, Object> map) {
        GroupInfo groupInfo = new GroupInfo();
        groupInfo.setStateDesired(map);
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        return z0(arrayList, groupInfo).i(new n(str, map));
    }

    private boolean G(GroupInfo groupInfo) {
        return groupInfo != null && !TextUtils.isEmpty(groupInfo.getId());
    }

    private boolean H(String str) {
        return !TextUtils.isEmpty(str);
    }

    private String N() {
        return com.tplink.libtpnetwork.Utils.m.a(8);
    }

    private io.reactivex.q<List<GroupInfo>> Q(ListParams listParams) {
        return V(listParams).g0(new g(new ArrayList(), listParams)).w0(new f());
    }

    private io.reactivex.q<PageListResult<GroupInfo>> V(ListParams listParams) {
        return d().N(new h(listParams));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X */
    public /* synthetic */ io.reactivex.e Y(GroupThingGroupListParams groupThingGroupListParams, String str) throws Exception {
        return this.h.N(str, groupThingGroupListParams).C(io.reactivex.l0.a.c()).i(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z */
    public /* synthetic */ io.reactivex.e a0(GroupInfo groupInfo, String str) throws Exception {
        return this.h.c1(str, groupInfo).C(io.reactivex.l0.a.c()).i(new k(groupInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b0 */
    public /* synthetic */ io.reactivex.e c0(String str, String str2) throws Exception {
        return this.h.B0(str2, str).C(io.reactivex.l0.a.c()).i(new b(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d0 */
    public /* synthetic */ io.reactivex.e e0(List list, String str) throws Exception {
        return this.h.B0(str, (String[]) list.toArray(new String[0])).C(io.reactivex.l0.a.c()).i(new c(list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f0 */
    public /* synthetic */ io.reactivex.e g0(String str, List list, String str2) throws Exception {
        return this.h.H(str2, str, new GroupThingListParams(list)).C(io.reactivex.l0.a.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h0 */
    public /* synthetic */ io.reactivex.e i0(List list, GroupInfo groupInfo, String str) throws Exception {
        return this.h.W0(str, list, groupInfo).C(io.reactivex.l0.a.c());
    }

    private io.reactivex.a j0(final String str, final List<String> list) {
        return d().R(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.r5
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return GroupRepository.this.g0(str, list, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(@Nullable List<String> list) {
        if (list != null && !list.isEmpty()) {
            ((FamilyManagerRepository) b.d.b.f.b.a(b.d.s.a.a.f(), FamilyManagerRepository.class)).M0();
        }
    }

    private void m0() {
        b.d.w.d.a.l(b.d.w.h.a.g(this.f100b.c().getCloudUserName()), new ArrayList(this.i.values()), "all_group_list_key", "all_group_list_key");
    }

    private void n0() {
        this.j.postValue(new ArrayList(this.i.values()));
    }

    private void q0(GroupInfo groupInfo, AutoLightBean autoLightBean) {
        List<String> thingNames = groupInfo.getThingNames();
        if (!(thingNames == null || thingNames.isEmpty())) {
            for (String str : thingNames) {
                String g2 = b.d.w.h.a.g(str);
                BaseALIoTDevice I1 = TPIoTClientManager.I1(g2);
                if (I1 != null && I1.isOnline()) {
                    ((BulbRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(g2, BulbRepository.class)).W5(autoLightBean).y();
                }
            }
        }
    }

    private void r0(GroupInfo groupInfo, int i2) {
        List<String> thingNames = groupInfo.getThingNames();
        if (!(thingNames == null || thingNames.isEmpty())) {
            for (String str : thingNames) {
                String g2 = b.d.w.h.a.g(str);
                BaseALIoTDevice I1 = TPIoTClientManager.I1(g2);
                if (I1 != null && I1.isOnline()) {
                    ((BulbRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(g2, BulbRepository.class)).X5(i2).y();
                }
            }
        }
    }

    private void s0(GroupInfo groupInfo, LightStateBean lightStateBean) {
        List<String> thingNames = groupInfo.getThingNames();
        if (!(thingNames == null || thingNames.isEmpty())) {
            for (String str : thingNames) {
                String g2 = b.d.w.h.a.g(str);
                BaseALIoTDevice I1 = TPIoTClientManager.I1(g2);
                if (I1 != null && I1.isOnline()) {
                    ((BulbRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(g2, BulbRepository.class)).b6(lightStateBean).y();
                }
            }
        }
    }

    private void t0(GroupInfo groupInfo, boolean z) {
        List<String> thingNames = groupInfo.getThingNames();
        if (!(thingNames == null || thingNames.isEmpty())) {
            for (String str : thingNames) {
                String g2 = b.d.w.h.a.g(str);
                BaseALIoTDevice I1 = TPIoTClientManager.I1(g2);
                if (I1 != null && I1.isOnline()) {
                    ((BulbRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(g2, BulbRepository.class)).i(z).y();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(GroupInfo groupInfo) {
        this.i.put(groupInfo.getId(), groupInfo);
        y0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0() {
        m0();
        n0();
    }

    private io.reactivex.a z0(final List<String> list, final GroupInfo groupInfo) {
        return d().R(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.n5
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return GroupRepository.this.i0(list, groupInfo, (String) obj);
            }
        });
    }

    public io.reactivex.a A0(List<String> list, String str, String str2) {
        GroupInfo groupInfo = new GroupInfo();
        groupInfo.setFamilyId(str);
        groupInfo.setRoomId(str2);
        return z0(list, groupInfo).i(new a(list, str, str2));
    }

    public io.reactivex.a B0(String str, String str2) {
        GroupInfo groupInfo = new GroupInfo();
        groupInfo.setAvatarUrl(str2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        return z0(arrayList, groupInfo).i(new m(str, str2));
    }

    public io.reactivex.a C0(String str, String str2) {
        GroupInfo groupInfo = new GroupInfo();
        groupInfo.setName(str2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        return z0(arrayList, groupInfo).i(new p(str, str2));
    }

    public io.reactivex.a D0(String str, com.google.gson.i iVar) {
        GroupInfo groupInfo = new GroupInfo();
        groupInfo.setPresets(iVar);
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        return z0(arrayList, groupInfo).i(new o(str, iVar));
    }

    public io.reactivex.a E(String str, List<String> list) {
        GroupThingGroupListParams groupThingGroupListParams = new GroupThingGroupListParams();
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        groupThingGroupListParams.setGroupIds(arrayList);
        groupThingGroupListParams.setThingNames(list);
        return D(groupThingGroupListParams);
    }

    public io.reactivex.a E0(String str, String str2) {
        GroupInfo groupInfo = new GroupInfo();
        groupInfo.setRoomId(str2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        return z0(arrayList, groupInfo).i(new l(str, str2));
    }

    public io.reactivex.a F(List<String> list, String str) {
        GroupThingGroupListParams groupThingGroupListParams = new GroupThingGroupListParams();
        groupThingGroupListParams.setGroupIds(list);
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        groupThingGroupListParams.setThingNames(arrayList);
        return D(groupThingGroupListParams);
    }

    public io.reactivex.a I(final GroupInfo groupInfo) {
        if (groupInfo.getId() == null) {
            groupInfo.setId(N());
        }
        return d().R(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.o5
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return GroupRepository.this.a0(groupInfo, (String) obj);
            }
        });
    }

    public io.reactivex.a J(final String str) {
        return d().R(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.s5
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return GroupRepository.this.c0(str, (String) obj);
            }
        });
    }

    public io.reactivex.a K(final List<String> list) {
        return d().R(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.q5
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return GroupRepository.this.e0(list, (String) obj);
            }
        });
    }

    public io.reactivex.a L(String str, List<String> list) {
        return j0(str, list).i(new e());
    }

    public void M(List<String> list) {
        List<String> thingNames;
        ArrayList<String> arrayList = new ArrayList();
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                for (GroupInfo groupInfo : this.i.values()) {
                    if (groupInfo != null && !TextUtils.isEmpty(groupInfo.getId()) && (thingNames = groupInfo.getThingNames()) != null && thingNames.contains(str)) {
                        arrayList.add(groupInfo.getId());
                    }
                }
            }
        }
        if (!arrayList.isEmpty()) {
            for (String str2 : arrayList) {
                j0(str2, list).y();
            }
            P().F0();
        }
    }

    public List<GroupInfo> O() {
        if (this.i == null) {
            return new ArrayList();
        }
        return new ArrayList(this.i.values());
    }

    public io.reactivex.q<List<GroupInfo>> P() {
        return Q(new ListParams(0)).g0(new j());
    }

    public GroupInfo R(String str) {
        Map<String, GroupInfo> map = this.i;
        if (map == null || str == null) {
            return null;
        }
        return map.get(str);
    }

    public io.reactivex.q<GroupInfo> S(String str) {
        return d().N(new i(str));
    }

    public MutableLiveData<List<GroupInfo>> T() {
        return this.j;
    }

    public List<GroupInfo> U(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        for (GroupInfo groupInfo : this.i.values()) {
            if (str.equals(groupInfo.getFamilyId()) && (groupInfo.getRoomId() == null || !groupInfo.getRoomId().equals(str2))) {
                arrayList.add(groupInfo);
            }
        }
        return arrayList;
    }

    public List<GroupInfo> W(String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        for (GroupInfo groupInfo : this.i.values()) {
            if (str.equals(groupInfo.getRoomId())) {
                arrayList.add(groupInfo);
            }
        }
        return arrayList;
    }

    public void l0() {
        List<GroupInfo> list;
        try {
            list = b.d.w.d.a.c(b.d.w.h.a.g(this.f100b.c().getCloudUserName()), "all_group_list_key", "all_group_list_key", GroupInfo.class);
        } catch (Exception unused) {
            list = new ArrayList();
        }
        this.i.clear();
        if (list != null && !list.isEmpty()) {
            for (GroupInfo groupInfo : list) {
                this.i.put(groupInfo.getId(), groupInfo);
            }
        }
        n0();
    }

    public void o0(String str, AutoLightBean autoLightBean) {
        if (H(str) && autoLightBean != null) {
            GroupInfo groupInfo = this.i.get(str);
            if (G(groupInfo)) {
                Map<String, Object> stateDesired = groupInfo.getStateDesired();
                if (stateDesired == null) {
                    stateDesired = new HashMap<>();
                }
                stateDesired.put(ThingModelDefine.Property.PROPERTY_AUTO_MODE, autoLightBean.getMode());
                stateDesired.put(ThingModelDefine.Property.PROPERTY_AUTO, Boolean.valueOf(autoLightBean.isEnable()));
                groupInfo.setStateDesired(stateDesired);
                F0(groupInfo.getId(), stateDesired).y();
                q0(groupInfo, autoLightBean);
            }
        }
    }

    public void p0(String str, int i2) {
        if (H(str)) {
            GroupInfo groupInfo = this.i.get(str);
            if (G(groupInfo)) {
                Map<String, Object> stateDesired = groupInfo.getStateDesired();
                if (stateDesired == null) {
                    stateDesired = new HashMap<>();
                }
                stateDesired.put("on", Boolean.TRUE);
                stateDesired.put("brightness", Integer.valueOf(i2));
                groupInfo.setStateDesired(stateDesired);
                F0(groupInfo.getId(), stateDesired).y();
                r0(groupInfo, i2);
            }
        }
    }

    public void u0(String str, boolean z) {
        if (H(str)) {
            GroupInfo groupInfo = this.i.get(str);
            if (G(groupInfo)) {
                Map<String, Object> stateDesired = groupInfo.getStateDesired();
                if (stateDesired == null) {
                    stateDesired = new HashMap<>();
                }
                stateDesired.put("on", Boolean.valueOf(z));
                groupInfo.setStateDesired(stateDesired);
                F0(groupInfo.getId(), stateDesired).y();
                t0(groupInfo, z);
            }
        }
    }

    public void v0(String str, LightStateBean lightStateBean) {
        if (H(str) && lightStateBean != null) {
            GroupInfo groupInfo = this.i.get(str);
            if (G(groupInfo)) {
                Map<String, Object> stateDesired = groupInfo.getStateDesired();
                if (stateDesired == null) {
                    stateDesired = new HashMap<>();
                }
                stateDesired.put("brightness", Integer.valueOf(lightStateBean.getBrightness()));
                stateDesired.put(ThingModelDefine.Property.PROPERTY_HUE, Integer.valueOf(lightStateBean.getHue()));
                stateDesired.put(ThingModelDefine.Property.PROPERTY_SATURATION, Integer.valueOf(lightStateBean.getSaturation()));
                stateDesired.put(ThingModelDefine.Property.PROPERTY_COLOR_TEMP, Integer.valueOf(lightStateBean.getColorTemp()));
                groupInfo.setStateDesired(stateDesired);
                F0(groupInfo.getId(), stateDesired).y();
                s0(groupInfo, lightStateBean);
            }
        }
    }

    public io.reactivex.a w0(List<String> list, boolean z) {
        GroupInfo groupInfo = new GroupInfo();
        groupInfo.setCommon(Boolean.valueOf(z));
        return z0(list, groupInfo).i(new q(list, z));
    }
}
