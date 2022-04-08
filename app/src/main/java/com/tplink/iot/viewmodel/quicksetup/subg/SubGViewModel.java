package com.tplink.iot.viewmodel.quicksetup.subg;

import android.annotation.SuppressLint;
import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.MutableLiveData;
import b.d.b.d.b.b;
import com.tplink.cloud.define.CloudException;
import com.tplink.iot.cloud.bean.common.PageListResult;
import com.tplink.iot.cloud.bean.family.common.RoomInfo;
import com.tplink.iot.cloud.bean.thing.common.SubThingCategoryBean;
import com.tplink.iot.cloud.bean.thing.common.SubThingSetupInfo;
import com.tplink.iot.cloud.bean.thing.common.ThingInfo;
import com.tplink.iot.cloud.bean.thing.params.SubThingAddListParams;
import com.tplink.iot.cloud.bean.thing.params.SubThingAddParams;
import com.tplink.iot.cloud.bean.thing.params.SubThingCategoryScanParams;
import com.tplink.iot.cloud.bean.thing.params.SubThingQuickSetupInfoListParams;
import com.tplink.iot.cloud.bean.thing.result.SubThingScanListResult;
import com.tplink.iot.view.quicksetup.sub.common.SubDeviceModel;
import com.tplink.iot.view.quicksetup.sub.common.e;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.IoTDataWrapper;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.params.DeviceInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.params.RulePageParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.ChildDeviceListBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.IoTSubDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.SubGQuickSetupRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingListPageParams;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyManagerRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository;
import com.tplink.libtpnetwork.Utils.y;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.g0.j;
import io.reactivex.m0.e;
import io.reactivex.q;
import io.reactivex.t;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class SubGViewModel extends SubGBaseViewModel {

    /* renamed from: c  reason: collision with root package name */
    private SubThingSetupInfo f11333c;

    /* renamed from: d  reason: collision with root package name */
    private String f11334d;

    /* renamed from: e  reason: collision with root package name */
    private String f11335e;

    /* renamed from: f  reason: collision with root package name */
    private ALIoTDevice f11336f;
    private e<Integer> g;
    private c h;
    private c i;
    private boolean j;
    private boolean k;
    private final FamilyManagerRepository x;
    private final ThingCloudRepository y;
    private SubGQuickSetupRepository z;
    private SubDeviceModel a = SubDeviceModel.SENSOR_T100;

    /* renamed from: b  reason: collision with root package name */
    private com.tplink.iot.view.quicksetup.sub.common.e f11332b = e.b.f9677b;
    private boolean l = true;
    public final ObservableField<String> m = new ObservableField<>("");
    public final ObservableField<String> n = new ObservableField<>("");
    public final ObservableField<String> o = new ObservableField<>("");
    public final ObservableInt p = new ObservableInt(0);
    public final ObservableInt q = new ObservableInt(0);
    public final ObservableBoolean r = new ObservableBoolean(false);
    public final MutableLiveData<a<i<SubThingScanListResult>>> s = new MutableLiveData<>();
    public final MutableLiveData<a<Boolean>> t = new MutableLiveData<>();
    public final MutableLiveData<a<Boolean>> u = new MutableLiveData<>();
    public final MutableLiveData<a<Boolean>> v = new MutableLiveData<>();
    private final MutableLiveData<a<Integer>> w = new MutableLiveData<>();

    public SubGViewModel(@NonNull Application application) {
        super(application);
        b c2 = b.d.b.f.b.c(b.d.s.a.a.f());
        this.x = (FamilyManagerRepository) c2.a(FamilyManagerRepository.class);
        this.y = (ThingCloudRepository) c2.a(ThingCloudRepository.class);
    }

    private boolean B() {
        SubDeviceModel subDeviceModel = this.a;
        return subDeviceModel == SubDeviceModel.SWITCH_S210 || subDeviceModel == SubDeviceModel.SWITCH_S220;
    }

    @SuppressLint({"CheckResult"})
    private void B0(String str, String str2, List<String> list) {
        boolean z;
        String str3;
        List<RoomInfo> s = s();
        if (s != null) {
            for (RoomInfo roomInfo : s) {
                if (TextUtils.equals(roomInfo.getName(), str2)) {
                    str3 = roomInfo.getId();
                    z = false;
                    break;
                }
            }
        }
        str3 = null;
        z = true;
        this.x.M(list, str, str3, str2, z, true).y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C */
    public /* synthetic */ void D() throws Exception {
        this.u.postValue(new a<>(Boolean.TRUE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E */
    public /* synthetic */ void F(Throwable th) throws Exception {
        this.u.postValue(new a<>(Boolean.FALSE));
    }

    private void F0() {
        this.k = true;
        n(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G */
    public /* synthetic */ t H(Long l) throws Exception {
        return r0();
    }

    private void G0(@Nullable IoTSubDevice ioTSubDevice, @Nullable ThingDevice thingDevice) {
        if (this.f11336f == null) {
            this.f11336f = new ALIoTDevice(ioTSubDevice);
        }
        if (ioTSubDevice != null) {
            this.f11336f.setLocalIoTDevice((LocalIoTBaseDevice) ioTSubDevice);
        }
        if (thingDevice != null) {
            this.f11336f.setThingDevice(thingDevice);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I */
    public /* synthetic */ void J(Boolean bool) throws Exception {
        b.d.w.c.a.d("findDeviceByCloud doOnNext isFind: " + bool);
        if (bool.booleanValue()) {
            k();
        } else {
            o0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K */
    public /* synthetic */ void L(Throwable th) throws Exception {
        b.d.w.c.a.d("findDeviceByCloud doOnError");
        o0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M */
    public /* synthetic */ void N(Integer num) throws Exception {
        b.d.w.c.a.d("findDeviceByTDPAndCloud doOnNext");
        h();
        w0(num.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O */
    public /* synthetic */ Boolean P(RulePageParams rulePageParams, ChildDeviceListBean childDeviceListBean) throws Exception {
        boolean z;
        if (childDeviceListBean.getChildDeviceList() == null) {
            return Boolean.FALSE;
        }
        List<IoTSubDevice> childDeviceList = childDeviceListBean.getChildDeviceList();
        rulePageParams.setStartIndex(rulePageParams.getStartIndex() + childDeviceList.size());
        Iterator<IoTSubDevice> it = childDeviceList.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            IoTSubDevice next = it.next();
            if (TextUtils.equals(B() ? next.getOriginalDeviceId() : next.getDeviceId(), this.f11333c.getDeviceId())) {
                G0(next, null);
                z = true;
                break;
            }
        }
        if (z) {
            return Boolean.TRUE;
        }
        if (rulePageParams.getStartIndex() >= childDeviceListBean.getSum()) {
            return Boolean.FALSE;
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
    public /* synthetic */ void S(Boolean bool) throws Exception {
        if (bool.booleanValue()) {
            b.d.w.c.a.e("SubGViewModel", "getChildDeviceList find success");
            F0();
            return;
        }
        b.d.w.c.a.e("SubGViewModel", "getChildDeviceList find fail");
        q0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T */
    public /* synthetic */ void U(Throwable th) throws Exception {
        q0();
        b.d.w.c.a.e("SubGViewModel", "getChildDeviceList find error");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V */
    public /* synthetic */ void W(SubThingScanListResult subThingScanListResult) throws Exception {
        this.s.postValue(new a<>(new i(0, subThingScanListResult)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X */
    public /* synthetic */ void Y(Throwable th) throws Exception {
        this.s.postValue(new a<>(new i(1, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z */
    public /* synthetic */ Boolean a0(ThingListPageParams thingListPageParams, IoTDataWrapper ioTDataWrapper, PageListResult pageListResult) throws Exception {
        List data = pageListResult.getData();
        if (data == null || data.isEmpty()) {
            return Boolean.FALSE;
        }
        boolean z = true;
        thingListPageParams.setPage(thingListPageParams.getPage() + 1);
        ioTDataWrapper.setData(Integer.valueOf(((Integer) ioTDataWrapper.getData()).intValue() + data.size()));
        Iterator it = data.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            ThingInfo thingInfo = (ThingInfo) it.next();
            if (TextUtils.equals(B() ? thingInfo.getOriginalThingName() : thingInfo.getThingName(), this.f11333c.getDeviceId())) {
                G0(null, new ThingDevice(thingInfo));
                break;
            }
        }
        if (z) {
            return Boolean.TRUE;
        }
        if (((Integer) ioTDataWrapper.getData()).intValue() >= pageListResult.getTotal()) {
            return Boolean.FALSE;
        }
        throw new CloudException(-2, "DATA_RETRY");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean b0(Throwable th) throws Exception {
        if (th instanceof CloudException) {
            CloudException cloudException = (CloudException) th;
            if (cloudException.getErrCode() == -2 && "DATA_RETRY".equals(cloudException.getMsg())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e0 */
    public /* synthetic */ void f0(Throwable th) throws Exception {
        int a = y.a(th);
        if (a == -1011) {
            this.s.postValue(new a<>(new i(a, null)));
        } else {
            this.s.postValue(new a<>(new i(1, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g0 */
    public /* synthetic */ void h0() throws Exception {
        b.d.w.c.a.e("SubGViewModel", "Local setChildDeviceQsInfo complete");
        this.v.postValue(new a<>(Boolean.TRUE));
    }

    private void i() {
        c cVar = this.i;
        if (cVar != null && !cVar.isDisposed()) {
            this.i.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i0 */
    public /* synthetic */ void j0(Throwable th) throws Exception {
        b.d.w.c.a.e("SubGViewModel", "Local setChildDeviceQsInfo error");
        this.v.postValue(new a<>(Boolean.FALSE));
    }

    private void j() {
        c cVar = this.h;
        if (cVar != null && !cVar.isDisposed()) {
            this.h.dispose();
        }
    }

    private void k() {
        this.j = true;
        n(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k0 */
    public /* synthetic */ void l0() throws Exception {
        b.d.w.c.a.e("SubGViewModel", "Cloud setChildDeviceQsInfo complete");
        this.v.postValue(new a<>(Boolean.TRUE));
    }

    private void l() {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.i = q.W0(3L, timeUnit).N(new j() { // from class: com.tplink.iot.viewmodel.quicksetup.subg.l
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return SubGViewModel.this.H((Long) obj);
            }
        }).T0(20L, timeUnit).E(new g() { // from class: com.tplink.iot.viewmodel.quicksetup.subg.h
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                SubGViewModel.this.J((Boolean) obj);
            }
        }).C(new g() { // from class: com.tplink.iot.viewmodel.quicksetup.subg.i
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                SubGViewModel.this.L((Throwable) obj);
            }
        }).F0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m0 */
    public /* synthetic */ void n0(Throwable th) throws Exception {
        b.d.w.c.a.e("SubGViewModel", "Cloud setChildDeviceQsInfo error");
        this.v.postValue(new a<>(Boolean.FALSE));
    }

    private void n(int i) {
        io.reactivex.m0.e<Integer> eVar = this.g;
        if (eVar != null && !eVar.j1()) {
            this.g.onNext(Integer.valueOf(i));
            this.g.onComplete();
            if (!this.k) {
                j();
            }
            if (!this.j) {
                i();
            }
        }
    }

    private void o0() {
        this.j = true;
        p0(548);
    }

    @SuppressLint({"CheckResult"})
    private void p() {
        if (this.z == null || this.f11333c == null) {
            this.k = true;
            p0(543);
            b.d.w.c.a.e("SubGViewModel", "getChildDeviceList()  return ");
            return;
        }
        final RulePageParams rulePageParams = new RulePageParams(0);
        this.h = this.z.a1(rulePageParams).g0(new j() { // from class: com.tplink.iot.viewmodel.quicksetup.subg.s
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return SubGViewModel.this.P(rulePageParams, (ChildDeviceListBean) obj);
            }
        }).w0(o.f11365c).y(new io.reactivex.g0.a() { // from class: com.tplink.iot.viewmodel.quicksetup.subg.a
            @Override // io.reactivex.g0.a
            public final void run() {
                SubGViewModel.this.u0();
            }
        }).H0(new g() { // from class: com.tplink.iot.viewmodel.quicksetup.subg.f
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                SubGViewModel.this.S((Boolean) obj);
            }
        }, new g() { // from class: com.tplink.iot.viewmodel.quicksetup.subg.k
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                SubGViewModel.this.U((Throwable) obj);
            }
        });
    }

    private void p0(int i) {
        io.reactivex.m0.e<Integer> eVar;
        b.d.w.c.a.d("noFindDeviceResult errorCode: " + i);
        if (this.k && this.j && (eVar = this.g) != null && !eVar.j1()) {
            this.g.onNext(0);
            this.g.onComplete();
        }
    }

    private void q0() {
        this.k = true;
        p0(543);
    }

    private q<Boolean> r0() {
        final ThingListPageParams thingListPageParams = new ThingListPageParams(0, 20);
        final IoTDataWrapper ioTDataWrapper = new IoTDataWrapper(0);
        return this.y.l0(thingListPageParams, b.d.s.c.a.b()).g0(new j() { // from class: com.tplink.iot.viewmodel.quicksetup.subg.y
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return SubGViewModel.this.a0(thingListPageParams, ioTDataWrapper, (PageListResult) obj);
            }
        }).w0(w.f11373c).L0(io.reactivex.l0.a.c());
    }

    private String w() {
        String str = this.f11334d;
        if (this.a == SubDeviceModel.SWITCH_S210) {
            ALIoTDevice aLIoTDevice = this.f11336f;
            if (aLIoTDevice != null) {
                str = aLIoTDevice.getDeviceId();
            } else {
                str = str + "00";
            }
        }
        b.d.w.c.a.d("getRealChildDeviceId deviceModel: " + this.a.value() + " id: " + str);
        return str;
    }

    private void w0(int i) {
        b.d.w.c.a.e("SubGViewModel", "setChildDeviceQsInfo findType = " + i);
        h();
        String w = w();
        if (i == 1) {
            DeviceInfoParams deviceInfoParams = new DeviceInfoParams();
            deviceInfoParams.setAvatar(this.o.get());
            deviceInfoParams.setNickname(this.m.get());
            this.z.p5(deviceInfoParams, w).i(new io.reactivex.g0.a() { // from class: com.tplink.iot.viewmodel.quicksetup.subg.r
                @Override // io.reactivex.g0.a
                public final void run() {
                    SubGViewModel.this.h0();
                }
            }).j(new g() { // from class: com.tplink.iot.viewmodel.quicksetup.subg.t
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    SubGViewModel.this.j0((Throwable) obj);
                }
            }).y();
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.z.g5(w, this.m.get(), this.o.get()));
            SubThingQuickSetupInfoListParams subThingQuickSetupInfoListParams = new SubThingQuickSetupInfoListParams();
            subThingQuickSetupInfoListParams.setDataList(arrayList);
            b.d.w.c.a.e("SubGViewModel", "setChildDeviceQsInfo By Cloud");
            this.z.o5(subThingQuickSetupInfoListParams).i(new io.reactivex.g0.a() { // from class: com.tplink.iot.viewmodel.quicksetup.subg.n
                @Override // io.reactivex.g0.a
                public final void run() {
                    SubGViewModel.this.l0();
                }
            }).j(new g() { // from class: com.tplink.iot.viewmodel.quicksetup.subg.g
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    SubGViewModel.this.n0((Throwable) obj);
                }
            }).y();
        }
        if (this.l) {
            this.l = false;
            C0(this.n.get());
        }
    }

    public MutableLiveData<a<Integer>> A() {
        return this.w;
    }

    public void A0(String str) {
        this.f11335e = str;
        this.z = (SubGQuickSetupRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(str, SubGQuickSetupRepository.class);
    }

    @SuppressLint({"CheckResult"})
    public void C0(String str) {
        String id = this.x.X() != null ? this.x.X().getId() : null;
        if (TextUtils.isEmpty(id) || TextUtils.isEmpty(str)) {
            b.d.w.c.a.d("setDeviceFamilyAndRoom2Cloud return");
            return;
        }
        String w = w();
        if (!TextUtils.isEmpty(w)) {
            B0(id, str, Collections.singletonList(w));
        }
    }

    public void D0(String str, List<String> list) {
        String id = this.x.X() != null ? this.x.X().getId() : null;
        if (TextUtils.isEmpty(id) || TextUtils.isEmpty(str)) {
            b.d.w.c.a.d("setDeviceFamilyAndRoom2Cloud return");
        } else if (list != null && !list.isEmpty()) {
            B0(id, str, list);
        }
    }

    public void E0(int i) {
        this.w.setValue(new a<>(Integer.valueOf(i)));
    }

    public void f() {
        SubThingSetupInfo subThingSetupInfo;
        if (this.z == null || (subThingSetupInfo = this.f11333c) == null) {
            this.u.postValue(new a<>(Boolean.FALSE));
            return;
        }
        SubThingAddParams subThingAddParams = new SubThingAddParams(subThingSetupInfo.getDeviceId(), this.f11333c.getCategory());
        ArrayList arrayList = new ArrayList();
        arrayList.add(subThingAddParams);
        this.z.e5(new SubThingAddListParams(arrayList)).C(io.reactivex.l0.a.c()).i(new io.reactivex.g0.a() { // from class: com.tplink.iot.viewmodel.quicksetup.subg.m
            @Override // io.reactivex.g0.a
            public final void run() {
                SubGViewModel.this.D();
            }
        }).j(new g() { // from class: com.tplink.iot.viewmodel.quicksetup.subg.j
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                SubGViewModel.this.F((Throwable) obj);
            }
        }).y();
    }

    public void g() {
        String w = w();
        if (!TextUtils.isEmpty(w)) {
            List<String> singletonList = Collections.singletonList(w);
            if (this.a == SubDeviceModel.SWITCH_S220) {
                singletonList = Arrays.asList(w + "00", w + "01");
            }
            this.x.O0(singletonList);
        }
    }

    public void h() {
        j();
        i();
    }

    public void m() {
        b.d.w.c.a.e("SubGViewModel", "findDeviceByTDPAndCloud child deviceId = " + this.f11334d);
        if (TextUtils.isEmpty(this.f11334d)) {
            b.d.w.c.a.e("SubGViewModel", "findDeviceByTDPAndCloud empty child deviceId");
            this.v.postValue(new a<>(Boolean.FALSE));
            return;
        }
        this.g = io.reactivex.m0.e.n1();
        this.k = false;
        this.j = false;
        l();
        p();
        this.g.T0(30L, TimeUnit.SECONDS).q0(0).E(new g() { // from class: com.tplink.iot.viewmodel.quicksetup.subg.x
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                SubGViewModel.this.N((Integer) obj);
            }
        }).F0();
    }

    public String[] o() {
        SubDeviceModel subDeviceModel = this.a;
        return subDeviceModel == null ? new String[]{"all"} : new String[]{subDeviceModel.getCategory()};
    }

    public String r() {
        return this.f11334d;
    }

    @Nullable
    public List<RoomInfo> s() {
        if (this.x.X() == null) {
            return null;
        }
        return this.x.X().getRooms();
    }

    public void s0() {
        if (TextUtils.isEmpty(this.m.get())) {
            this.m.set(this.f11332b.i());
        }
    }

    public String t() {
        return this.f11335e;
    }

    public void t0() {
        this.s.setValue(new a<>(new i(1, null), true));
        this.u.setValue(new a<>(Boolean.FALSE, true));
        this.f11333c = null;
        this.f11334d = null;
    }

    @NonNull
    public SubDeviceModel u() {
        return this.a;
    }

    public void u0() {
        this.z.q5().y();
    }

    public EnumDeviceType v() {
        return this.f11332b.f();
    }

    public void v0(final String... strArr) {
        if (this.z == null) {
            this.s.postValue(new a<>(new i(1, null)));
            return;
        }
        SubThingCategoryScanParams subThingCategoryScanParams = new SubThingCategoryScanParams();
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(new SubThingCategoryBean(str));
        }
        subThingCategoryScanParams.setScanList(arrayList);
        this.z.f5(subThingCategoryScanParams).C(io.reactivex.l0.a.c()).i(new io.reactivex.g0.a() { // from class: com.tplink.iot.viewmodel.quicksetup.subg.v
            @Override // io.reactivex.g0.a
            public final void run() {
                SubGViewModel.this.d0(strArr);
            }
        }).j(new g() { // from class: com.tplink.iot.viewmodel.quicksetup.subg.p
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                SubGViewModel.this.f0((Throwable) obj);
            }
        }).y();
    }

    /* renamed from: x */
    public void c0(String... strArr) {
        if (this.z == null) {
            this.s.postValue(new a<>(new i(1, null)));
            return;
        }
        SubThingCategoryScanParams subThingCategoryScanParams = new SubThingCategoryScanParams();
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(new SubThingCategoryBean(str));
        }
        subThingCategoryScanParams.setScanList(arrayList);
        this.z.h5(subThingCategoryScanParams).L0(io.reactivex.l0.a.c()).E(new g() { // from class: com.tplink.iot.viewmodel.quicksetup.subg.q
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                SubGViewModel.this.W((SubThingScanListResult) obj);
            }
        }).C(new g() { // from class: com.tplink.iot.viewmodel.quicksetup.subg.u
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                SubGViewModel.this.Y((Throwable) obj);
            }
        }).F0();
    }

    public void x0(SubThingSetupInfo subThingSetupInfo) {
        this.f11333c = subThingSetupInfo;
    }

    public MutableLiveData<a<i<SubThingScanListResult>>> y() {
        return this.s;
    }

    public void y0(String str) {
        this.f11334d = str;
    }

    @NonNull
    public com.tplink.iot.view.quicksetup.sub.common.e z() {
        return this.f11332b;
    }

    public void z0(String str) {
        SubDeviceModel fromValue = SubDeviceModel.fromValue(str);
        this.a = fromValue;
        this.f11332b = com.tplink.iot.view.quicksetup.sub.common.g.a(fromValue);
    }
}
