package com.tplink.iot.viewmodel.deviceshare;

import android.annotation.SuppressLint;
import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tplink.cloud.bean.common.CloudResult;
import com.tplink.cloud.bean.share.params.ShareBlacklistUpdateParams;
import com.tplink.cloud.bean.share.result.ShareBlacklistItemResult;
import com.tplink.cloud.define.CloudException;
import com.tplink.iot.cloud.bean.share.EnumDeviceShareRole;
import com.tplink.iot.cloud.bean.share.EnumDeviceShareStatus;
import com.tplink.iot.cloud.bean.share.params.DeviceShareActionListParams;
import com.tplink.iot.cloud.bean.share.params.DeviceShareListParams;
import com.tplink.iot.cloud.bean.share.params.DeviceShareParams;
import com.tplink.iot.cloud.bean.share.params.DeviceUsersParams;
import com.tplink.iot.cloud.bean.share.params.UserAccountBean;
import com.tplink.iot.cloud.bean.share.result.DeviceShareActionHandleListResult;
import com.tplink.iot.cloud.bean.share.result.DeviceShareActionHandleResult;
import com.tplink.iot.cloud.bean.share.result.ShareDeviceResult;
import com.tplink.iot.model.deviceshare.DeviceShareManager;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.ICEDataFromCloudPCResult;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.DeviceShareRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ShareBlacklistCacheBean;
import com.tplink.libtpnetwork.TPCloudNetwork.device.TCDeviceUserInfoBean;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCDeviceRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class DeviceShareViewModel extends AndroidViewModel {
    private com.tplink.cloud.context.b a;

    /* renamed from: b  reason: collision with root package name */
    private DeviceShareRepository f9948b;

    /* renamed from: c  reason: collision with root package name */
    private TCDeviceRepository f9949c;

    /* renamed from: d  reason: collision with root package name */
    private TPIoTClientManager f9950d;

    /* renamed from: e  reason: collision with root package name */
    private DeviceShareManager f9951e;

    /* renamed from: f  reason: collision with root package name */
    private MediatorLiveData<List<BaseALIoTDevice>> f9952f = new MediatorLiveData<>();
    private MutableLiveData<com.tplink.iot.viewmodel.quicksetup.i<Void>> g = new MutableLiveData<>();
    private MutableLiveData<List<ShareDeviceResult>> h = new MutableLiveData<>();
    private MutableLiveData<com.tplink.iot.viewmodel.quicksetup.i<String>> i = new MutableLiveData<>();
    private MutableLiveData<com.tplink.iot.viewmodel.quicksetup.i<String>> j = new MutableLiveData<>();
    private MutableLiveData<com.tplink.iot.viewmodel.quicksetup.i<CloudResult<Void>>> k = new MutableLiveData<>();
    private MutableLiveData<com.tplink.iot.viewmodel.quicksetup.i<Void>> l = new MutableLiveData<>();
    private MediatorLiveData<List<ShareBlacklistItemResult>> m = new MediatorLiveData<>();
    private MutableLiveData<com.tplink.iot.viewmodel.quicksetup.i<Void>> n = new MutableLiveData<>();
    private MutableLiveData<com.tplink.iot.viewmodel.quicksetup.i<Void>> o = new MutableLiveData<>();
    private MutableLiveData<com.tplink.iot.viewmodel.quicksetup.i<CloudResult<Void>>> p = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements io.reactivex.g0.g<Throwable> {
        a() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            com.tplink.iot.viewmodel.home.r.g().p(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements io.reactivex.g0.g<List<ShareDeviceResult>> {
        b() {
        }

        /* renamed from: a */
        public void accept(List<ShareDeviceResult> list) throws Exception {
            DeviceShareViewModel.this.V(list);
            DeviceShareViewModel.this.h.postValue(list);
            com.tplink.iot.viewmodel.home.r.g().p(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements io.reactivex.g0.g<Throwable> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f9955c;

        c(String str) {
            this.f9955c = str;
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            DeviceShareViewModel.this.i.postValue(new com.tplink.iot.viewmodel.quicksetup.i(1, this.f9955c));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements io.reactivex.g0.g<Integer> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f9957c;

        d(String str) {
            this.f9957c = str;
        }

        /* renamed from: a */
        public void accept(Integer num) throws Exception {
            if (num.intValue() == 0) {
                DeviceShareViewModel.this.i.postValue(new com.tplink.iot.viewmodel.quicksetup.i(0, this.f9957c));
            } else {
                DeviceShareViewModel.this.i.postValue(new com.tplink.iot.viewmodel.quicksetup.i(num.intValue(), this.f9957c));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements io.reactivex.g0.g<List<ShareBlacklistItemResult>> {
        e() {
        }

        /* renamed from: a */
        public void accept(List<ShareBlacklistItemResult> list) throws Exception {
            DeviceShareViewModel.this.X(list);
        }
    }

    /* loaded from: classes2.dex */
    class f implements io.reactivex.g0.g<Throwable> {
        f() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            DeviceShareViewModel.this.n.postValue(new com.tplink.iot.viewmodel.quicksetup.i(th instanceof CloudException ? ((CloudException) th).getErrCode() : 1, null));
        }
    }

    /* loaded from: classes2.dex */
    class g implements io.reactivex.g0.g<Boolean> {
        g() {
        }

        /* renamed from: a */
        public void accept(Boolean bool) throws Exception {
            DeviceShareViewModel.this.n.postValue(new com.tplink.iot.viewmodel.quicksetup.i(0, null));
            DeviceShareViewModel.this.w();
        }
    }

    /* loaded from: classes2.dex */
    class h implements io.reactivex.g0.g<Throwable> {
        h() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            DeviceShareViewModel.this.o.postValue(new com.tplink.iot.viewmodel.quicksetup.i(1, null));
        }
    }

    /* loaded from: classes2.dex */
    class i implements io.reactivex.g0.g<Boolean> {
        i() {
        }

        /* renamed from: a */
        public void accept(Boolean bool) throws Exception {
            DeviceShareViewModel.this.o.postValue(new com.tplink.iot.viewmodel.quicksetup.i(0, null));
        }
    }

    /* loaded from: classes2.dex */
    class j implements Observer<List<BaseALIoTDevice>> {
        j() {
        }

        /* renamed from: a */
        public void onChanged(List<BaseALIoTDevice> list) {
            DeviceShareViewModel.this.f9952f.postValue(list);
        }
    }

    /* loaded from: classes2.dex */
    class k implements Observer<List<ShareBlacklistItemResult>> {
        k() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable List<ShareBlacklistItemResult> list) {
            DeviceShareViewModel.this.m.postValue(list);
        }
    }

    /* loaded from: classes2.dex */
    class l implements io.reactivex.g0.a {
        l() {
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            DeviceShareViewModel.this.l.postValue(new com.tplink.iot.viewmodel.quicksetup.i(0, null));
        }
    }

    /* loaded from: classes2.dex */
    class m implements io.reactivex.g0.g<Throwable> {
        m() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            if (th instanceof CloudException) {
                DeviceShareViewModel.this.l.postValue(new com.tplink.iot.viewmodel.quicksetup.i(((CloudException) th).getErrCode(), null));
            } else {
                DeviceShareViewModel.this.l.postValue(new com.tplink.iot.viewmodel.quicksetup.i(1, null));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class n implements io.reactivex.g0.g<Throwable> {
        n() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            if (th instanceof CloudException) {
                DeviceShareViewModel.this.p.postValue(new com.tplink.iot.viewmodel.quicksetup.i(((CloudException) th).getErrCode(), null));
            } else {
                DeviceShareViewModel.this.p.postValue(new com.tplink.iot.viewmodel.quicksetup.i(1, null));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class o implements io.reactivex.g0.a {
        o() {
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            DeviceShareViewModel.this.p.postValue(new com.tplink.iot.viewmodel.quicksetup.i(0, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class p implements io.reactivex.g0.g<Throwable> {
        p() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            if (th instanceof CloudException) {
                DeviceShareViewModel.this.j.postValue(new com.tplink.iot.viewmodel.quicksetup.i(((CloudException) th).getErrCode(), null));
            } else {
                DeviceShareViewModel.this.j.postValue(new com.tplink.iot.viewmodel.quicksetup.i(1, null));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class q implements io.reactivex.g0.a {
        final /* synthetic */ String a;

        q(String str) {
            this.a = str;
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            DeviceShareViewModel.this.j.postValue(new com.tplink.iot.viewmodel.quicksetup.i(0, this.a));
        }
    }

    /* loaded from: classes2.dex */
    class r implements io.reactivex.g0.g<Integer> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ DeviceShareListParams f9968c;

        r(DeviceShareListParams deviceShareListParams) {
            this.f9968c = deviceShareListParams;
        }

        /* renamed from: a */
        public void accept(Integer num) throws Exception {
            if (num == null || num.intValue() != 0) {
                DeviceShareViewModel.this.g.postValue(new com.tplink.iot.viewmodel.quicksetup.i(num != null ? num.intValue() : 1, null));
                return;
            }
            List<DeviceShareParams> shareList = this.f9968c.getShareList();
            if (shareList != null && !shareList.isEmpty()) {
                TCDeviceUserInfoBean tCDeviceUserInfoBean = new TCDeviceUserInfoBean();
                tCDeviceUserInfoBean.setCloudUserName(shareList.get(0).getSharerUserName());
                DeviceShareViewModel.this.W(tCDeviceUserInfoBean);
            }
            DeviceShareViewModel.this.g.postValue(new com.tplink.iot.viewmodel.quicksetup.i(0, null));
        }
    }

    public DeviceShareViewModel(@NonNull Application application) {
        super(application);
        com.tplink.cloud.context.b f2 = b.d.s.a.a.f();
        this.a = f2;
        b.d.b.d.b.b c2 = b.d.b.f.b.c(f2);
        this.f9950d = (TPIoTClientManager) c2.a(TPIoTClientManager.class);
        this.f9948b = (DeviceShareRepository) c2.a(DeviceShareRepository.class);
        this.f9951e = (DeviceShareManager) c2.a(DeviceShareManager.class);
        this.f9949c = (TCDeviceRepository) c2.a(TCDeviceRepository.class);
        this.f9952f.addSource(this.f9950d.C1(), new j());
        this.m.addSource(this.f9949c.J(), new k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M */
    public /* synthetic */ Integer N(DeviceShareActionListParams deviceShareActionListParams, DeviceShareActionHandleListResult deviceShareActionHandleListResult) throws Exception {
        ICEDataFromCloudPCResult iCEDataFromCloudPCResult;
        deviceShareActionHandleListResult.getHandleList();
        List<DeviceShareActionHandleResult> failList = deviceShareActionHandleListResult.getFailList();
        int i2 = 0;
        String shareId = (deviceShareActionListParams.getShareList() == null || deviceShareActionListParams.getShareList().isEmpty()) ? null : deviceShareActionListParams.getShareList().get(0).getShareId();
        if (failList != null && !failList.isEmpty()) {
            DeviceShareActionHandleResult deviceShareActionHandleResult = failList.get(0);
            if (deviceShareActionHandleResult.getCode() == null) {
                i2 = -1;
            } else {
                i2 = deviceShareActionHandleResult.getCode().intValue();
                if (i2 == 12301 && (iCEDataFromCloudPCResult = (ICEDataFromCloudPCResult) com.tplink.libtpnetwork.Utils.i.a(deviceShareActionHandleResult.getData(), ICEDataFromCloudPCResult.class)) != null) {
                    i2 = iCEDataFromCloudPCResult.getCodeFromPC();
                }
            }
        }
        if (i2 == 0 || i2 == -27001) {
            T(shareId);
        }
        x();
        R();
        return Integer.valueOf(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O */
    public /* synthetic */ void P() throws Exception {
        this.f9948b.C().F0();
    }

    @SuppressLint({"CheckResult"})
    private void R() {
        this.f9950d.p3(com.tplink.iot.core.n.a(), b.d.w.f.b.j(getApplication()) && b.d.w.f.b.i(getApplication())).y(new io.reactivex.g0.a() { // from class: com.tplink.iot.viewmodel.deviceshare.a
            @Override // io.reactivex.g0.a
            public final void run() {
                DeviceShareViewModel.this.P();
            }
        }).F0();
    }

    private void T(String str) {
        List<ShareDeviceResult> value;
        if (!TextUtils.isEmpty(str) && (value = this.h.getValue()) != null && !value.isEmpty()) {
            Iterator<ShareDeviceResult> it = value.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (TextUtils.equals(it.next().getShareId(), str)) {
                        it.remove();
                        break;
                    }
                } else {
                    break;
                }
            }
            this.h.postValue(value);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(List<ShareDeviceResult> list) {
        if (!(list == null || list.isEmpty())) {
            HashMap hashMap = new HashMap();
            for (ShareDeviceResult shareDeviceResult : list) {
                if (hashMap.get(shareDeviceResult.getOwnerUsername()) == null) {
                    ShareBlacklistCacheBean shareBlacklistCacheBean = new ShareBlacklistCacheBean();
                    if (!TextUtils.isEmpty(shareDeviceResult.getShareCreatedTime())) {
                        shareBlacklistCacheBean.setTimeStamp(Long.parseLong(shareDeviceResult.getShareCreatedTime()));
                    }
                    shareBlacklistCacheBean.setEmail(shareDeviceResult.getOwnerUsername());
                    shareBlacklistCacheBean.setNickname(shareDeviceResult.getOwnerNickname());
                    hashMap.put(shareBlacklistCacheBean.getEmail(), shareBlacklistCacheBean);
                }
            }
            List<ShareBlacklistCacheBean> e2 = this.f9951e.e();
            if (e2 != null && !e2.isEmpty()) {
                for (ShareBlacklistCacheBean shareBlacklistCacheBean2 : e2) {
                    ShareBlacklistCacheBean shareBlacklistCacheBean3 = (ShareBlacklistCacheBean) hashMap.get(shareBlacklistCacheBean2.getEmail());
                    if (shareBlacklistCacheBean3 == null || shareBlacklistCacheBean3.getTimeStamp() < shareBlacklistCacheBean2.getTimeStamp()) {
                        hashMap.put(shareBlacklistCacheBean2.getEmail(), shareBlacklistCacheBean2);
                    }
                }
            }
            ArrayList arrayList = new ArrayList(hashMap.values());
            Collections.sort(arrayList);
            hashMap.clear();
            this.f9951e.i(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(List<ShareBlacklistItemResult> list) {
        this.f9951e.j(list);
    }

    public void A(String str, boolean z) {
        this.f9948b.H(str, z).F0();
    }

    public void B() {
        List<BaseALIoTDevice> value = this.f9950d.C1().getValue();
        ArrayList arrayList = new ArrayList();
        if (value != null && !value.isEmpty()) {
            for (BaseALIoTDevice baseALIoTDevice : value) {
                if (baseALIoTDevice.isHasThingOrCloudDevice()) {
                    arrayList.add(baseALIoTDevice);
                }
            }
        }
        this.f9948b.I(arrayList).F0();
    }

    public void C(List<BaseALIoTDevice> list) {
        this.f9948b.I(list).C(new m()).z(new l()).F0();
    }

    public MutableLiveData<com.tplink.iot.viewmodel.quicksetup.i<Void>> D() {
        return this.l;
    }

    public MutableLiveData<com.tplink.iot.viewmodel.quicksetup.i<String>> E() {
        return this.i;
    }

    public MediatorLiveData<List<BaseALIoTDevice>> F() {
        return this.f9952f;
    }

    public MutableLiveData<com.tplink.iot.viewmodel.quicksetup.i<Void>> G() {
        return this.g;
    }

    public MutableLiveData<com.tplink.iot.viewmodel.quicksetup.i<Void>> H() {
        return this.o;
    }

    public MutableLiveData<com.tplink.iot.viewmodel.quicksetup.i<CloudResult<Void>>> I() {
        return this.p;
    }

    public MutableLiveData<List<ShareBlacklistItemResult>> J() {
        return this.m;
    }

    public MutableLiveData<List<ShareDeviceResult>> K() {
        return this.h;
    }

    public void L(final DeviceShareActionListParams deviceShareActionListParams, String str) {
        this.f9948b.K(deviceShareActionListParams).g0(new io.reactivex.g0.j() { // from class: com.tplink.iot.viewmodel.deviceshare.b
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return DeviceShareViewModel.this.N(deviceShareActionListParams, (DeviceShareActionHandleListResult) obj);
            }
        }).E(new d(str)).C(new c(str)).F0();
    }

    public void Q(DeviceShareListParams deviceShareListParams) {
        this.f9948b.T(deviceShareListParams).E(new r(deviceShareListParams)).F0();
    }

    public void S(String str, List<String> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (String str2 : list) {
                UserAccountBean userAccountBean = new UserAccountBean();
                userAccountBean.setUserAccount(str2);
                arrayList.add(userAccountBean);
            }
        }
        this.f9948b.A(str, new DeviceUsersParams(this.a.c().getCloudUserName(), arrayList, z)).i(new o()).j(new n()).y();
    }

    public void U(String str) {
        ShareBlacklistUpdateParams shareBlacklistUpdateParams = new ShareBlacklistUpdateParams();
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        shareBlacklistUpdateParams.setBlackList(arrayList);
        this.f9949c.N(shareBlacklistUpdateParams).E(new i()).C(new h()).F0();
    }

    public void W(TCDeviceUserInfoBean tCDeviceUserInfoBean) {
        this.f9951e.h(tCDeviceUserInfoBean);
    }

    public void Y(List<TCDeviceUserInfoBean> list) {
        if (!(list == null || list.isEmpty())) {
            ArrayList arrayList = new ArrayList();
            for (TCDeviceUserInfoBean tCDeviceUserInfoBean : list) {
                ShareBlacklistItemResult shareBlacklistItemResult = new ShareBlacklistItemResult();
                shareBlacklistItemResult.setNickname(tCDeviceUserInfoBean.getNickname());
                shareBlacklistItemResult.setAvatarUrl(tCDeviceUserInfoBean.getAvatarUrl());
                arrayList.add(shareBlacklistItemResult);
            }
            X(arrayList);
        }
    }

    public void Z(List<TCDeviceUserInfoBean> list) {
        this.f9951e.k(list);
    }

    public void f(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        this.f9950d.x(arrayList).i(new q(str)).j(new p()).y();
    }

    public void t(String str) {
        ShareBlacklistUpdateParams shareBlacklistUpdateParams = new ShareBlacklistUpdateParams();
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        shareBlacklistUpdateParams.setBlackList(arrayList);
        this.f9949c.q(shareBlacklistUpdateParams).E(new g()).C(new f()).F0();
    }

    public MutableLiveData<com.tplink.iot.viewmodel.quicksetup.i<String>> u() {
        return this.j;
    }

    public MutableLiveData<com.tplink.iot.viewmodel.quicksetup.i<Void>> v() {
        return this.n;
    }

    public void w() {
        this.f9949c.w().E(new e()).F0();
    }

    public void x() {
        this.f9948b.D(EnumDeviceShareStatus.READY.name(), EnumDeviceShareRole.SHARER.getName(), null).E(new b()).C(new a()).F0();
    }

    public List<ShareBlacklistCacheBean> y() {
        List<ShareBlacklistCacheBean> e2 = this.f9951e.e();
        List<ShareBlacklistItemResult> I = this.f9949c.I();
        if (e2 == null || e2.isEmpty() || I == null || I.isEmpty()) {
            return e2;
        }
        ArrayList arrayList = new ArrayList();
        for (ShareBlacklistCacheBean shareBlacklistCacheBean : e2) {
            boolean z = false;
            Iterator<ShareBlacklistItemResult> it = I.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (TextUtils.equals(shareBlacklistCacheBean.getEmail(), it.next().getEmail())) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                arrayList.add(shareBlacklistCacheBean);
            }
        }
        return arrayList;
    }

    public List<TCDeviceUserInfoBean> z() {
        return this.f9951e.d();
    }
}
