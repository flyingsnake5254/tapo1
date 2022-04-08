package com.tplink.iot.viewmodel.home;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.iot.core.n;
import com.tplink.iot.model.home.e;
import com.tplink.iot.model.home.f;
import com.tplink.iot.model.home.g;
import com.tplink.iot.model.home.k;
import com.tplink.libtpnetwork.IoTNetwork.bean.group.GroupBean;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumHomeState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class HomeRoomDeviceViewModel extends HomeBaseViewModel {
    private Map<String, k> z = new HashMap();
    private List<k> p0 = new ArrayList();
    private Map<String, g> p1 = new LinkedHashMap();
    private List<g> p2 = new ArrayList();
    private io.reactivex.e0.c p3 = null;
    private MediatorLiveData<List<e>> H3 = new MediatorLiveData<>();
    private MediatorLiveData<List<e>> I3 = new MediatorLiveData<>();
    private MediatorLiveData<Boolean> J3 = new MediatorLiveData<>();

    /* loaded from: classes2.dex */
    class a implements Observer<f> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable f fVar) {
            HomeRoomDeviceViewModel.this.K(fVar);
        }
    }

    /* loaded from: classes2.dex */
    class b implements Observer<List<BaseALIoTDevice>> {
        b() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable List<BaseALIoTDevice> list) {
            HomeRoomDeviceViewModel.this.L(list);
        }
    }

    /* loaded from: classes2.dex */
    class c implements Observer<List<GroupInfo>> {
        c() {
        }

        /* renamed from: a */
        public void onChanged(List<GroupInfo> list) {
            HomeRoomDeviceViewModel.this.M(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements io.reactivex.g0.g<Throwable> {
        d() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            HomeRoomDeviceViewModel.this.J3.postValue(Boolean.TRUE);
        }
    }

    public HomeRoomDeviceViewModel(@NonNull Application application) {
        super(application);
        this.I3.addSource(this.x.d(), new a());
        this.H3.addSource(this.f10052c.C1(), new b());
        this.H3.addSource(this.q.T(), new c());
        this.x.f();
    }

    private List<e> E() {
        ArrayList arrayList = new ArrayList(this.p0);
        t.e(arrayList);
        ArrayList arrayList2 = new ArrayList(this.p2);
        t.f(arrayList2);
        ArrayList arrayList3 = new ArrayList(arrayList2);
        arrayList3.addAll(arrayList);
        return arrayList3;
    }

    private void F() {
        this.p0.clear();
        this.p2.clear();
        for (k kVar : this.z.values()) {
            if (!(kVar == null || kVar.g() == null || !h(kVar))) {
                this.p0.add(kVar);
            }
        }
        for (g gVar : this.p1.values()) {
            if (!(gVar == null || gVar.h() == null || !i(gVar))) {
                this.p2.add(gVar);
            }
        }
    }

    private void G() {
        this.q.P().F0();
    }

    private void H() {
        J();
        this.p3 = this.f10052c.p3(n.a(), j()).C(new d()).F0();
    }

    private void J() {
        io.reactivex.e0.c cVar = this.p3;
        if (cVar != null && !cVar.isDisposed()) {
            this.p3.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(f fVar) {
        if (fVar != null) {
            s.c(this.z, fVar.a());
            F();
            if (fVar.b()) {
                this.I3.postValue(E());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(List<BaseALIoTDevice> list) {
        EnumHomeState value = this.f10052c.X1().getValue();
        if (this.z.isEmpty() && value == EnumHomeState.ONLINE) {
            this.x.h();
        }
        s.a(this.z, list);
        N();
        if (value == EnumHomeState.ONLINE) {
            this.x.n(new ArrayList(this.z.values()));
        }
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(List<GroupInfo> list) {
        s.b(this.p1, list);
        N();
        k();
    }

    private void N() {
        for (g gVar : this.p1.values()) {
            GroupBean h = gVar.h();
            if (h != null) {
                h.setGroupState(com.tplink.libtpnetwork.Utils.g.j(h));
            }
        }
    }

    public LiveData<Boolean> A() {
        return this.J3;
    }

    public LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<BaseALIoTDevice>> B() {
        return this.f10052c.T1();
    }

    public MediatorLiveData<List<e>> C() {
        return this.I3;
    }

    public LiveData<List<e>> D() {
        return this.H3;
    }

    public void I() {
        H();
        G();
        this.y.I();
    }

    @Override // com.tplink.iot.viewmodel.home.HomeBaseViewModel
    public void k() {
        F();
        this.H3.postValue(E());
    }

    @Override // com.tplink.iot.viewmodel.home.HomeBaseViewModel
    protected void l(String str) {
        this.z.remove(str);
    }

    @Override // com.tplink.iot.viewmodel.home.HomeBaseViewModel
    protected void n(String str) {
        this.p1.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        J();
    }

    @Override // com.tplink.iot.viewmodel.home.HomeBaseViewModel
    protected void v() {
        this.x.o(new ArrayList(this.z.values()), true);
    }
}
