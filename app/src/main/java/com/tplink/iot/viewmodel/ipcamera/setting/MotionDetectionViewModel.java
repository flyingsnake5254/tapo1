package com.tplink.iot.viewmodel.ipcamera.setting;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import b.d.q.b.l;
import com.tplink.libtpmediaother.database.model.e;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.model.d;
import com.tplink.libtpnetwork.cameranetwork.business.repo.MotionDetectionRepository;
import io.reactivex.e0.b;
import io.reactivex.e0.c;
import io.reactivex.g0.a;
import io.reactivex.g0.g;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class MotionDetectionViewModel extends AndroidViewModel {
    public final MutableLiveData<Boolean> a;

    /* renamed from: d  reason: collision with root package name */
    public final MutableLiveData<Boolean> f10773d;

    /* renamed from: e  reason: collision with root package name */
    public final MutableLiveData<Boolean> f10774e;

    /* renamed from: f  reason: collision with root package name */
    public final MutableLiveData<Boolean> f10775f;
    private String k;
    private e l;
    private int m;
    private MotionDetectionRepository n;

    /* renamed from: b  reason: collision with root package name */
    public final MutableLiveData<List<d>> f10771b = new MutableLiveData<>();

    /* renamed from: c  reason: collision with root package name */
    public ObservableInt f10772c = new ObservableInt(30);
    public ObservableBoolean g = new ObservableBoolean(false);
    public ObservableBoolean h = new ObservableBoolean(false);
    public ObservableBoolean i = new ObservableBoolean(false);
    private final b j = new b();

    public MotionDetectionViewModel(@NonNull Application application, TPCameraDeviceContext tPCameraDeviceContext) {
        super(application);
        Boolean bool = Boolean.FALSE;
        this.a = new MutableLiveData<>(bool);
        this.f10773d = new MutableLiveData<>(bool);
        this.f10774e = new MutableLiveData<>(bool);
        this.f10775f = new MutableLiveData<>(bool);
        this.k = tPCameraDeviceContext.getDeviceIdMD5();
        this.n = (MotionDetectionRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.b(tPCameraDeviceContext, MotionDetectionRepository.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B */
    public /* synthetic */ void C(c cVar) throws Exception {
        this.f10773d.postValue(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public /* synthetic */ void E(Throwable th) throws Exception {
        this.f10774e.postValue(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F */
    public /* synthetic */ void G() throws Exception {
        this.f10775f.postValue(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H */
    public /* synthetic */ void I() throws Exception {
        this.f10773d.postValue(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J */
    public /* synthetic */ void K(Boolean bool) throws Exception {
        if (bool.booleanValue()) {
            R();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L */
    public /* synthetic */ void M(Throwable th) throws Exception {
        R();
        this.f10774e.postValue(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N */
    public /* synthetic */ void O(c cVar) throws Exception {
        this.f10773d.postValue(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P */
    public /* synthetic */ void Q() throws Exception {
        this.f10773d.postValue(Boolean.FALSE);
    }

    private void T(boolean z, boolean z2) {
        com.tplink.iot.Utils.x0.d.l(this.k, z, z2);
    }

    private void U(List<d> list) {
        String str = this.k;
        boolean z = false;
        int size = list == null ? 0 : list.size();
        if (this.m != 3) {
            z = true;
        }
        com.tplink.iot.Utils.x0.d.j(str, size, z);
    }

    private void V(String str) {
        com.tplink.iot.Utils.x0.d.k(this.k, str, this.m != 3);
    }

    private void W(final List<d> list) {
        boolean z = true;
        if (this.m != 1) {
            z = false;
        }
        l.s(this.k, z, new com.tplink.libtpnetwork.Utils.f0.b() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.r5
            @Override // com.tplink.libtpnetwork.Utils.f0.b
            public final void a(Object obj) {
                MotionDetectionViewModel.this.y(list, (e) obj);
            }
        });
    }

    private void X(final boolean z) {
        boolean z2 = true;
        if (this.m != 1) {
            z2 = false;
        }
        l.s(this.k, z2, new com.tplink.libtpnetwork.Utils.f0.b() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.t5
            @Override // com.tplink.libtpnetwork.Utils.f0.b
            public final void a(Object obj) {
                ((e) obj).e0(z);
            }
        });
    }

    private void Y(final int i) {
        boolean z = true;
        if (this.m != 1) {
            z = false;
        }
        l.s(this.k, z, new com.tplink.libtpnetwork.Utils.f0.b() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.q5
            @Override // com.tplink.libtpnetwork.Utils.f0.b
            public final void a(Object obj) {
                ((e) obj).x0(i);
            }
        });
    }

    private void a0(boolean z, int i) {
        this.j.b(this.n.s(z, i).F(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.x5
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                MotionDetectionViewModel.this.O((c) obj);
            }
        }).y(new a() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.j5
            @Override // io.reactivex.g0.a
            public final void run() {
                MotionDetectionViewModel.this.Q();
            }
        }).H0(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.o5
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                MotionDetectionViewModel.this.K((Boolean) obj);
            }
        }, new g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.s5
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                MotionDetectionViewModel.this.M((Throwable) obj);
            }
        }));
    }

    private List<e.c> g(List<d> list) {
        ArrayList arrayList = new ArrayList();
        for (d dVar : list) {
            e.c cVar = new e.c();
            cVar.g(dVar.a());
            cVar.h(dVar.b());
            cVar.i(dVar.c());
            cVar.j(dVar.d());
            arrayList.add(cVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public /* synthetic */ void l(e eVar) {
        this.l = eVar;
        List<d> f2 = com.tplink.iot.view.ipcamera.preview.mode.e.f(eVar.H());
        this.f10771b.postValue(f2);
        f(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public /* synthetic */ void n(Throwable th) throws Exception {
        R();
        this.f10774e.postValue(Boolean.TRUE);
        th.printStackTrace();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public /* synthetic */ void p(c cVar) throws Exception {
        this.f10773d.postValue(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public /* synthetic */ void s() throws Exception {
        this.f10773d.postValue(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public /* synthetic */ void u(Boolean bool) throws Exception {
        if (bool.booleanValue()) {
            R();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public /* synthetic */ void w(e eVar) {
        this.l = eVar;
        this.a.postValue(Boolean.valueOf(eVar.p()));
        this.f10771b.postValue(com.tplink.iot.view.ipcamera.preview.mode.e.f(eVar.H()));
        this.f10772c.set(this.l.J() - 20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public /* synthetic */ void y(List list, e eVar) {
        eVar.v0(g(list));
    }

    public void R() {
        this.a.postValue(Boolean.valueOf(this.n.y().e()));
        this.f10771b.postValue(this.n.y().c());
        this.f10772c.set(this.n.y().d() - 20);
    }

    public void S() {
        boolean z = true;
        if (this.m != 1) {
            z = false;
        }
        l.g(this.k, z, new com.tplink.libtpnetwork.Utils.f0.b() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.m5
            @Override // com.tplink.libtpnetwork.Utils.f0.b
            public final void a(Object obj) {
                MotionDetectionViewModel.this.w((e) obj);
            }
        });
    }

    public void Z(List<d> list) {
        U(list);
        if (this.m == 3) {
            this.j.b(this.n.a0(list).F(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.l5
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    MotionDetectionViewModel.this.C((c) obj);
                }
            }).C(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.h5
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    MotionDetectionViewModel.this.E((Throwable) obj);
                }
            }).z(new a() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.i5
                @Override // io.reactivex.g0.a
                public final void run() {
                    MotionDetectionViewModel.this.G();
                }
            }).y(new a() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.u5
                @Override // io.reactivex.g0.a
                public final void run() {
                    MotionDetectionViewModel.this.I();
                }
            }).F0());
            return;
        }
        W(list);
        this.f10775f.postValue(Boolean.TRUE);
    }

    public void b0(boolean z) {
        if (this.m == 3) {
            a0(z, this.n.y().d());
        } else {
            X(z);
            this.a.postValue(Boolean.valueOf(z));
        }
        T(z, this.m != 3);
    }

    public void c0(int i) {
        if (this.m == 3) {
            a0(this.n.y().e(), i);
        } else {
            Y(i);
        }
    }

    public void d0(int i) {
        int i2 = this.f10772c.get();
        this.f10772c.set(i);
        if (i > i2) {
            if (i > 38) {
                i2 = 60;
                V("High");
            } else if (i > 8) {
                V("Normal");
                i2 = 30;
            }
        } else if (i < i2) {
            if (i < 22) {
                i2 = 0;
                V("Low");
            } else if (i < 52) {
                V("Normal");
                i2 = 30;
            }
        }
        this.f10772c.set(i2);
        c0(i2 + 20);
    }

    public void f(List<d> list) {
        for (d dVar : list) {
            if (dVar.c() == 0 && dVar.d() == 0 && dVar.a() == 10000 && dVar.b() == 10000) {
                this.i.set(true);
                return;
            }
            this.i.set(false);
        }
    }

    public void h() {
        int i = this.m;
        if (i == 3) {
            com.tplink.libtpnetwork.cameranetwork.business.model.g y = this.n.y();
            this.f10771b.postValue(y.c());
            f(y.c());
            return;
        }
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        l.g(this.k, z, new com.tplink.libtpnetwork.Utils.f0.b() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.n5
            @Override // com.tplink.libtpnetwork.Utils.f0.b
            public final void a(Object obj) {
                MotionDetectionViewModel.this.l((e) obj);
            }
        });
    }

    public String i() {
        return this.k;
    }

    public void j(int i) {
        this.m = i;
        if (i == 3) {
            this.j.b(this.n.X().C(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.k5
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    MotionDetectionViewModel.this.n((Throwable) obj);
                }
            }).F(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.p5
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    MotionDetectionViewModel.this.p((c) obj);
                }
            }).y(new a() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.w5
                @Override // io.reactivex.g0.a
                public final void run() {
                    MotionDetectionViewModel.this.s();
                }
            }).G0(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.v5
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    MotionDetectionViewModel.this.u((Boolean) obj);
                }
            }));
            return;
        }
        S();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.j.dispose();
    }
}
