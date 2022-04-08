package com.tplink.libtpnetwork.IoTNetwork.repository;

import android.text.TextUtils;
import com.tplink.cloud.define.CloudException;
import com.tplink.iot.c.b.h;
import com.tplink.iot.cloud.bean.share.common.LaunchFailBean;
import com.tplink.iot.cloud.bean.share.device.DeviceOwnerInfoResult;
import com.tplink.iot.cloud.bean.share.device.DeviceUserInfoResult;
import com.tplink.iot.cloud.bean.share.device.DeviceUserListResult;
import com.tplink.iot.cloud.bean.share.params.DeviceShareActionListParams;
import com.tplink.iot.cloud.bean.share.params.DeviceShareListParams;
import com.tplink.iot.cloud.bean.share.params.DeviceUserRoleListParams;
import com.tplink.iot.cloud.bean.share.params.DeviceUserRoleParams;
import com.tplink.iot.cloud.bean.share.params.DeviceUsersParams;
import com.tplink.iot.cloud.bean.share.params.UserAccountBean;
import com.tplink.iot.cloud.bean.share.result.DeviceShareActionHandleListResult;
import com.tplink.iot.cloud.bean.share.result.DeviceShareLaunchResult;
import com.tplink.iot.cloud.bean.share.result.ShareDeviceListResult;
import com.tplink.iot.cloud.bean.share.result.ShareDeviceResult;
import com.tplink.iot.cloud.repository.AbstractIoTCloudRepository;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.ICEDataFromCloudPCResult;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingListPageParams;
import com.tplink.libtpnetwork.TPCloudNetwork.device.DeviceManagerInfoBean;
import com.tplink.libtpnetwork.TPCloudNetwork.device.TCDeviceOwnerInfoBean;
import com.tplink.libtpnetwork.TPCloudNetwork.device.TCDeviceUserInfoBean;
import com.tplink.libtpnetwork.Utils.i;
import io.reactivex.g0.j;
import io.reactivex.q;
import io.reactivex.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class DeviceShareRepository extends AbstractIoTCloudRepository {
    private h h;

    /* loaded from: classes3.dex */
    class a implements j<String, t<Integer>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ DeviceShareListParams f12884c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.tplink.libtpnetwork.IoTNetwork.repository.DeviceShareRepository$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0258a implements j<DeviceShareLaunchResult, Integer> {
            C0258a() {
            }

            /* renamed from: a */
            public Integer apply(DeviceShareLaunchResult deviceShareLaunchResult) throws Exception {
                boolean z;
                ICEDataFromCloudPCResult iCEDataFromCloudPCResult;
                if (deviceShareLaunchResult == null || deviceShareLaunchResult.getFailList() == null || deviceShareLaunchResult.getFailList().size() <= 0) {
                    z = true;
                } else {
                    for (LaunchFailBean launchFailBean : deviceShareLaunchResult.getFailList()) {
                        if (launchFailBean.getCode() == 12301 && (iCEDataFromCloudPCResult = (ICEDataFromCloudPCResult) i.a(launchFailBean.getData(), ICEDataFromCloudPCResult.class)) != null) {
                            int codeFromPC = iCEDataFromCloudPCResult.getCodeFromPC();
                            if (codeFromPC == -20618) {
                                return -20618;
                            }
                            if (codeFromPC == -20508) {
                                return -20508;
                            }
                        }
                    }
                    z = false;
                }
                if (z) {
                    return 0;
                }
                return -1;
            }
        }

        a(DeviceShareListParams deviceShareListParams) {
            this.f12884c = deviceShareListParams;
        }

        /* renamed from: a */
        public t<Integer> apply(String str) throws Exception {
            return DeviceShareRepository.this.h.k(str, this.f12884c).L0(io.reactivex.l0.a.c()).g0(new C0258a()).q0(-1);
        }
    }

    /* loaded from: classes3.dex */
    class b implements j<String, t<DeviceShareActionHandleListResult>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ DeviceShareActionListParams f12887c;

        b(DeviceShareActionListParams deviceShareActionListParams) {
            this.f12887c = deviceShareActionListParams;
        }

        /* renamed from: a */
        public t<DeviceShareActionHandleListResult> apply(String str) throws Exception {
            return DeviceShareRepository.this.h.u(str, this.f12887c).L0(io.reactivex.l0.a.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements j<String, t<ShareDeviceListResult>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f12889c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f12890d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f12891f;
        final /* synthetic */ String q;
        final /* synthetic */ String x;

        c(int i, int i2, String str, String str2, String str3) {
            this.f12889c = i;
            this.f12890d = i2;
            this.f12891f = str;
            this.q = str2;
            this.x = str3;
        }

        /* renamed from: a */
        public t<ShareDeviceListResult> apply(String str) throws Exception {
            return DeviceShareRepository.this.h.b0(str, this.f12889c, this.f12890d, this.f12891f, this.q, this.x).L0(io.reactivex.l0.a.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d implements j<String, t<DeviceUserListResult>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f12892c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f12893d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class a implements io.reactivex.g0.g<DeviceUserListResult> {
            a() {
            }

            /* renamed from: a */
            public void accept(DeviceUserListResult deviceUserListResult) throws Exception {
                d dVar = d.this;
                DeviceShareRepository.this.X(dVar.f12892c, deviceUserListResult);
            }
        }

        d(String str, boolean z) {
            this.f12892c = str;
            this.f12893d = z;
        }

        /* renamed from: a */
        public t<DeviceUserListResult> apply(String str) throws Exception {
            return DeviceShareRepository.this.h.z1(str, this.f12892c, this.f12893d).L0(io.reactivex.l0.a.c()).E(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class e implements j<String, t<DeviceOwnerInfoResult>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f12896c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f12897d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class a implements io.reactivex.g0.g<DeviceOwnerInfoResult> {
            a() {
            }

            /* renamed from: a */
            public void accept(DeviceOwnerInfoResult deviceOwnerInfoResult) throws Exception {
                e eVar = e.this;
                DeviceShareRepository.this.W(eVar.f12896c, deviceOwnerInfoResult);
            }
        }

        e(String str, boolean z) {
            this.f12896c = str;
            this.f12897d = z;
        }

        /* renamed from: a */
        public t<DeviceOwnerInfoResult> apply(String str) throws Exception {
            return DeviceShareRepository.this.h.F0(str, this.f12896c, this.f12897d).L0(io.reactivex.l0.a.c()).E(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class f implements j<BaseALIoTDevice, t<Boolean>> {
        f() {
        }

        /* renamed from: a */
        public t<Boolean> apply(BaseALIoTDevice baseALIoTDevice) throws Exception {
            if (baseALIoTDevice.isUserRoleTypeDevice()) {
                DeviceShareRepository.this.G(baseALIoTDevice.getDeviceId(), baseALIoTDevice.isSubDevice()).F0();
            } else {
                DeviceShareRepository.this.H(baseALIoTDevice.getDeviceId(), baseALIoTDevice.isSubDevice()).F0();
            }
            return q.f0(Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class g implements j<List<BaseALIoTDevice>, t<BaseALIoTDevice>> {
        g() {
        }

        /* renamed from: a */
        public t<BaseALIoTDevice> apply(List<BaseALIoTDevice> list) throws Exception {
            return q.Y(list);
        }
    }

    public DeviceShareRepository(com.tplink.iot.c.c.a aVar) {
        super(aVar);
        this.h = (h) aVar.k().R1(h.class);
    }

    private q<List<ShareDeviceResult>> E(final ThingListPageParams thingListPageParams, String str, String str2, String str3) {
        final ArrayList arrayList = new ArrayList();
        return J(thingListPageParams.getPage(), thingListPageParams.getPageSize(), str, str2, str3).g0(new j() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.k5
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                List list = arrayList;
                DeviceShareRepository.P(list, thingListPageParams, (ShareDeviceListResult) obj);
                return list;
            }
        }).w0(j5.f13295c);
    }

    private BaseALIoTDevice F(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return TPIoTClientManager.I1(b.d.w.h.a.g(str));
    }

    private q<ShareDeviceListResult> J(int i, int i2, String str, String str2, String str3) {
        return d().N(new c(i, i2, str, str2, str3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L */
    public /* synthetic */ io.reactivex.e0.c M(final String str, final DeviceUsersParams deviceUsersParams, String str2) throws Exception {
        return this.h.B(str2, str, deviceUsersParams).C(io.reactivex.l0.a.c()).i(new io.reactivex.g0.a() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.i5
            @Override // io.reactivex.g0.a
            public final void run() {
                DeviceShareRepository.this.S(deviceUsersParams, str);
            }
        }).y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N */
    public /* synthetic */ io.reactivex.e0.c O(DeviceUserRoleListParams deviceUserRoleListParams, String str) throws Exception {
        return this.h.d0(str, deviceUserRoleListParams).C(io.reactivex.l0.a.c()).y();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ List P(List list, ThingListPageParams thingListPageParams, ShareDeviceListResult shareDeviceListResult) throws Exception {
        list.addAll(shareDeviceListResult.getData());
        thingListPageParams.setPage(thingListPageParams.getPage() + 1);
        if (list.size() >= shareDeviceListResult.getTotal()) {
            return list;
        }
        throw new CloudException(-2, "DATA_RETRY");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean Q(Throwable th) throws Exception {
        if (th instanceof CloudException) {
            CloudException cloudException = (CloudException) th;
            if (cloudException.getErrCode() == -2 && "DATA_RETRY".equals(cloudException.getMsg())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R */
    public /* synthetic */ void S(DeviceUsersParams deviceUsersParams, String str) throws Exception {
        List<UserAccountBean> userAccountList = deviceUsersParams.getUserAccountList();
        ArrayList arrayList = new ArrayList();
        if (userAccountList != null && !userAccountList.isEmpty()) {
            for (UserAccountBean userAccountBean : userAccountList) {
                arrayList.add(userAccountBean.getUserAccount());
            }
        }
        V(str, arrayList);
    }

    private void U() {
        ((TPIoTClientManager) b.d.b.f.b.a(b.d.s.a.a.f(), TPIoTClientManager.class)).L3();
    }

    private void V(String str, List<String> list) {
        BaseALIoTDevice F;
        DeviceManagerInfoBean deviceManagerInfo;
        if (list != null && !list.isEmpty() && str != null && !str.isEmpty() && (F = F(str)) != null && (deviceManagerInfo = F.getDeviceManagerInfo()) != null && deviceManagerInfo.getUserInfo() != null && !deviceManagerInfo.getUserInfo().isEmpty()) {
            Iterator<TCDeviceUserInfoBean> it = deviceManagerInfo.getUserInfo().iterator();
            while (it.hasNext()) {
                TCDeviceUserInfoBean next = it.next();
                if (next != null && list.contains(next.getCloudUserName())) {
                    it.remove();
                }
            }
            U();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(String str, DeviceOwnerInfoResult deviceOwnerInfoResult) {
        BaseALIoTDevice F;
        if (!TextUtils.isEmpty(str) && (F = F(str)) != null) {
            DeviceManagerInfoBean deviceManagerInfo = F.getDeviceManagerInfo();
            if (deviceManagerInfo == null) {
                deviceManagerInfo = new DeviceManagerInfoBean();
                F.setDeviceManagerInfo(deviceManagerInfo);
            }
            deviceManagerInfo.setOwnerInfo(new TCDeviceOwnerInfoBean(deviceOwnerInfoResult));
            U();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(String str, DeviceUserListResult deviceUserListResult) {
        ArrayList arrayList = new ArrayList();
        for (DeviceUserInfoResult deviceUserInfoResult : deviceUserListResult.getUserList()) {
            arrayList.add(new TCDeviceUserInfoBean(deviceUserInfoResult));
        }
        BaseALIoTDevice F = F(str);
        if (F != null) {
            DeviceManagerInfoBean deviceManagerInfo = F.getDeviceManagerInfo();
            if (deviceManagerInfo == null) {
                deviceManagerInfo = new DeviceManagerInfoBean();
                F.setDeviceManagerInfo(deviceManagerInfo);
            }
            List<TCDeviceUserInfoBean> userInfo = deviceManagerInfo.getUserInfo();
            if (userInfo == null) {
                userInfo = new ArrayList<>();
                deviceManagerInfo.setUserInfo(userInfo);
            }
            userInfo.clear();
            userInfo.addAll(arrayList);
            U();
        }
    }

    public io.reactivex.a A(final String str, final DeviceUsersParams deviceUsersParams) {
        return d().g0(new j() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.l5
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return DeviceShareRepository.this.M(str, deviceUsersParams, (String) obj);
            }
        }).Z();
    }

    public io.reactivex.a B(final DeviceUserRoleListParams deviceUserRoleListParams) {
        return d().g0(new j() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.m5
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return DeviceShareRepository.this.O(deviceUserRoleListParams, (String) obj);
            }
        }).Z();
    }

    public q<Boolean> C() {
        ArrayList arrayList = new ArrayList();
        for (BaseALIoTDevice baseALIoTDevice : ((TPIoTClientManager) b.d.b.f.b.a(b.d.s.a.a.f(), TPIoTClientManager.class)).C1().getValue()) {
            if (baseALIoTDevice.isHasThingOrCloudDevice()) {
                arrayList.add(baseALIoTDevice);
            }
        }
        return I(arrayList);
    }

    public q<List<ShareDeviceResult>> D(String str, String str2, String str3) {
        return E(new ThingListPageParams(0, 20), str, str2, str3);
    }

    public q<DeviceOwnerInfoResult> G(String str, boolean z) {
        return d().N(new e(str, z));
    }

    public q<DeviceUserListResult> H(String str, boolean z) {
        return d().N(new d(str, z));
    }

    public q<Boolean> I(List<BaseALIoTDevice> list) {
        return q.f0(list).N(new g()).N(new f());
    }

    public q<DeviceShareActionHandleListResult> K(DeviceShareActionListParams deviceShareActionListParams) {
        return d().N(new b(deviceShareActionListParams));
    }

    public q<Integer> T(DeviceShareListParams deviceShareListParams) {
        return d().N(new a(deviceShareListParams));
    }

    public io.reactivex.a w(List<DeviceUserRoleParams> list) {
        String email = this.f100b.c().getEmail();
        if (email == null || email.isEmpty()) {
            email = this.f100b.c().getCloudUserName();
        }
        return B(new DeviceUserRoleListParams(email, list));
    }
}
