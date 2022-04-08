package com.tplink.iot.viewmodel.ipcamera.setting;

import android.annotation.SuppressLint;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import b.d.q.b.l;
import com.tplink.iot.Utils.x0.d;
import com.tplink.libtpmediaother.database.model.e;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.model.c;
import com.tplink.libtpnetwork.cameranetwork.business.repo.AreaIntrusionRepository;
import com.tplink.libtpnetwork.cameranetwork.model.DetectionInfo;
import io.reactivex.e0.b;
import io.reactivex.g0.a;
import io.reactivex.g0.g;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class AreaIntrusionViewModel extends AndroidViewModel {
    private String a;

    /* renamed from: b  reason: collision with root package name */
    private AreaIntrusionRepository f10702b;

    /* renamed from: d  reason: collision with root package name */
    private e f10704d;

    /* renamed from: e  reason: collision with root package name */
    private final MutableLiveData<Boolean> f10705e;

    /* renamed from: f  reason: collision with root package name */
    private final MutableLiveData<Boolean> f10706f;
    private final MutableLiveData<Boolean> g;
    private final MutableLiveData<Boolean> m;

    /* renamed from: c  reason: collision with root package name */
    private int f10703c = 3;
    private final MutableLiveData<List<c.a>> h = new MutableLiveData<>();
    public final ObservableBoolean i = new ObservableBoolean(false);
    public final ObservableBoolean j = new ObservableBoolean(false);
    public final ObservableBoolean k = new ObservableBoolean(false);
    private final b l = new b();

    public AreaIntrusionViewModel(@NonNull Application application, TPCameraDeviceContext tPCameraDeviceContext) {
        super(application);
        Boolean bool = Boolean.FALSE;
        this.f10705e = new MutableLiveData<>(bool);
        this.f10706f = new MutableLiveData<>(bool);
        this.g = new MutableLiveData<>(bool);
        this.m = new MutableLiveData<>(bool);
        String deviceIdMD5 = tPCameraDeviceContext.getDeviceIdMD5();
        this.a = deviceIdMD5;
        this.f10702b = (AreaIntrusionRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(deviceIdMD5, AreaIntrusionRepository.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A */
    public /* synthetic */ void B(e eVar) {
        this.f10704d = eVar;
        this.f10705e.postValue(Boolean.valueOf(eVar.N()));
        this.h.postValue(com.tplink.iot.view.ipcamera.preview.mode.e.c(this.f10704d.m()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public /* synthetic */ void E(List list, e eVar) {
        eVar.b0(g(list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F */
    public /* synthetic */ void G(io.reactivex.e0.c cVar) throws Exception {
        this.f10706f.postValue(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H */
    public /* synthetic */ void I() throws Exception {
        this.f10706f.postValue(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J */
    public /* synthetic */ void K(Boolean bool) throws Exception {
        if (bool.booleanValue()) {
            V();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L */
    public /* synthetic */ void M(Throwable th) throws Exception {
        V();
        this.g.postValue(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N */
    public /* synthetic */ void O(io.reactivex.e0.c cVar) throws Exception {
        this.f10706f.postValue(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P */
    public /* synthetic */ void Q() throws Exception {
        this.f10706f.postValue(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R */
    public /* synthetic */ void S(Throwable th) throws Exception {
        th.printStackTrace();
        this.g.postValue(Boolean.TRUE);
        V();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T */
    public /* synthetic */ void U(Boolean bool) throws Exception {
        if (bool.booleanValue()) {
            V();
            this.m.postValue(Boolean.TRUE);
        }
    }

    private void X(final boolean z) {
        boolean z2 = true;
        if (this.f10703c != 1) {
            z2 = false;
        }
        l.s(this.a, z2, new com.tplink.libtpnetwork.Utils.f0.b() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.w0
            @Override // com.tplink.libtpnetwork.Utils.f0.b
            public final void a(Object obj) {
                ((e) obj).a0(z);
            }
        });
    }

    private void Y(final List<c.a> list) {
        boolean z = true;
        if (this.f10703c != 1) {
            z = false;
        }
        l.s(this.a, z, new com.tplink.libtpnetwork.Utils.f0.b() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.i0
            @Override // com.tplink.libtpnetwork.Utils.f0.b
            public final void a(Object obj) {
                AreaIntrusionViewModel.this.E(list, (e) obj);
            }
        });
    }

    private void Z(DetectionInfo detectionInfo) {
        this.l.b(this.f10702b.D(detectionInfo).F(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.t0
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                AreaIntrusionViewModel.this.G((io.reactivex.e0.c) obj);
            }
        }).y(new a() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.l0
            @Override // io.reactivex.g0.a
            public final void run() {
                AreaIntrusionViewModel.this.I();
            }
        }).H0(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.x0
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                AreaIntrusionViewModel.this.K((Boolean) obj);
            }
        }, new g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.p0
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                AreaIntrusionViewModel.this.M((Throwable) obj);
            }
        }));
    }

    private List<e.c> g(List<c.a> list) {
        ArrayList arrayList = new ArrayList();
        for (c.a aVar : list) {
            e.c cVar = new e.c();
            cVar.g(aVar.a());
            cVar.h(aVar.b());
            cVar.i(aVar.c());
            cVar.j(aVar.d());
            arrayList.add(cVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public /* synthetic */ void r(e eVar) {
        this.f10704d = eVar;
        List<c.a> c2 = com.tplink.iot.view.ipcamera.preview.mode.e.c(eVar.m());
        this.h.postValue(c2);
        f(c2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public /* synthetic */ void t(Throwable th) throws Exception {
        V();
        this.g.postValue(Boolean.TRUE);
        th.printStackTrace();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public /* synthetic */ void v(io.reactivex.e0.c cVar) throws Exception {
        this.f10706f.postValue(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w */
    public /* synthetic */ void x() throws Exception {
        this.f10706f.postValue(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y */
    public /* synthetic */ void z(Boolean bool) throws Exception {
        if (bool.booleanValue()) {
            V();
        }
    }

    public void V() {
        this.f10705e.postValue(Boolean.valueOf(this.f10702b.z().c()));
        this.h.postValue(this.f10702b.z().a());
    }

    public void W() {
        boolean z = true;
        if (this.f10703c != 1) {
            z = false;
        }
        l.g(this.a, z, new com.tplink.libtpnetwork.Utils.f0.b() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.k0
            @Override // com.tplink.libtpnetwork.Utils.f0.b
            public final void a(Object obj) {
                AreaIntrusionViewModel.this.B((e) obj);
            }
        });
    }

    public void a0(boolean z) {
        if (this.f10703c == 3) {
            Z(new DetectionInfo(z ? "on" : "off"));
        } else {
            X(z);
            this.f10705e.postValue(Boolean.valueOf(z));
        }
        d.c(this.a, z, this.f10703c != 3);
    }

    public void b0(List<c.a> list) {
        if (this.f10703c == 3) {
            this.l.b(this.f10702b.w(list).F(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.u0
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    AreaIntrusionViewModel.this.O((io.reactivex.e0.c) obj);
                }
            }).y(new a() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.r0
                @Override // io.reactivex.g0.a
                public final void run() {
                    AreaIntrusionViewModel.this.Q();
                }
            }).C(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.m0
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    AreaIntrusionViewModel.this.S((Throwable) obj);
                }
            }).G0(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.q0
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    AreaIntrusionViewModel.this.U((Boolean) obj);
                }
            }));
        } else {
            Y(list);
            this.m.postValue(Boolean.TRUE);
        }
        d.b(this.a, list.size(), this.f10703c != 3);
    }

    public void f(List<c.a> list) {
        for (c.a aVar : list) {
            if (aVar.c() == 0 && aVar.d() == 0 && aVar.a() == 10000 && aVar.b() == 10000) {
                this.k.set(true);
                return;
            }
            this.k.set(false);
        }
    }

    public void h() {
        int i = this.f10703c;
        if (i == 3) {
            c z = this.f10702b.z();
            this.h.postValue(z.a());
            f(z.a());
            return;
        }
        boolean z2 = true;
        if (i != 1) {
            z2 = false;
        }
        l.g(this.a, z2, new com.tplink.libtpnetwork.Utils.f0.b() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.n0
            @Override // com.tplink.libtpnetwork.Utils.f0.b
            public final void a(Object obj) {
                AreaIntrusionViewModel.this.r((e) obj);
            }
        });
    }

    public String i() {
        return this.a;
    }

    public MutableLiveData<Boolean> j() {
        return this.g;
    }

    public MutableLiveData<Boolean> k() {
        return this.m;
    }

    public MutableLiveData<Boolean> l() {
        return this.f10705e;
    }

    public MutableLiveData<Boolean> m() {
        return this.f10706f;
    }

    public MutableLiveData<List<c.a>> n() {
        return this.h;
    }

    @SuppressLint({"CheckResult"})
    public void o(int i) {
        this.f10703c = i;
        if (i == 3) {
            this.l.b(this.f10702b.A().C(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.j0
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    AreaIntrusionViewModel.this.t((Throwable) obj);
                }
            }).F(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.s0
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    AreaIntrusionViewModel.this.v((io.reactivex.e0.c) obj);
                }
            }).y(new a() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.v0
                @Override // io.reactivex.g0.a
                public final void run() {
                    AreaIntrusionViewModel.this.x();
                }
            }).G0(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.o0
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    AreaIntrusionViewModel.this.z((Boolean) obj);
                }
            }));
            return;
        }
        W();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.l.dispose();
    }
}
