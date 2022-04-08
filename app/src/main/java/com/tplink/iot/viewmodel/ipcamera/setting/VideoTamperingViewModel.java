package com.tplink.iot.viewmodel.ipcamera.setting;

import android.annotation.SuppressLint;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import b.d.q.b.l;
import com.tplink.iot.Utils.x0.d;
import com.tplink.libtpmediaother.database.model.e;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.model.p;
import com.tplink.libtpnetwork.cameranetwork.business.repo.TamperDetectionRepository;
import com.tplink.libtpnetwork.cameranetwork.model.TamperDetectConfig;
import io.reactivex.e0.b;
import io.reactivex.e0.c;
import io.reactivex.g0.a;
import io.reactivex.g0.g;

/* loaded from: classes3.dex */
public class VideoTamperingViewModel extends AndroidViewModel {
    private String a;

    /* renamed from: b  reason: collision with root package name */
    private TamperDetectionRepository f10844b;

    /* renamed from: d  reason: collision with root package name */
    private e f10846d;

    /* renamed from: e  reason: collision with root package name */
    private final MutableLiveData<Boolean> f10847e;
    private final MutableLiveData<Boolean> g;
    private final MutableLiveData<Boolean> h;

    /* renamed from: c  reason: collision with root package name */
    private int f10845c = 3;

    /* renamed from: f  reason: collision with root package name */
    private final MutableLiveData<String> f10848f = new MutableLiveData<>();
    private final b i = new b();

    public VideoTamperingViewModel(@NonNull Application application, TPCameraDeviceContext tPCameraDeviceContext) {
        super(application);
        Boolean bool = Boolean.FALSE;
        this.f10847e = new MutableLiveData<>(bool);
        this.g = new MutableLiveData<>(bool);
        this.h = new MutableLiveData<>(bool);
        String deviceIdMD5 = tPCameraDeviceContext.getDeviceIdMD5();
        this.a = deviceIdMD5;
        this.f10844b = (TamperDetectionRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(deviceIdMD5, TamperDetectionRepository.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B */
    public /* synthetic */ void C(Boolean bool) throws Exception {
        if (bool.booleanValue()) {
            F();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public /* synthetic */ void E(Throwable th) throws Exception {
        F();
        this.h.postValue(Boolean.TRUE);
    }

    private void H() {
        this.i.b(this.f10844b.u().F(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.d9
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                VideoTamperingViewModel.this.n((c) obj);
            }
        }).C(h9.f10962c).y(new a() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.a9
            @Override // io.reactivex.g0.a
            public final void run() {
                VideoTamperingViewModel.this.p();
            }
        }).G0(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.b9
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                VideoTamperingViewModel.this.s((TamperDetectConfig) obj);
            }
        }));
    }

    private void I(final boolean z) {
        boolean z2 = true;
        if (this.f10845c != 1) {
            z2 = false;
        }
        l.s(this.a, z2, new com.tplink.libtpnetwork.Utils.f0.b() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.v8
            @Override // com.tplink.libtpnetwork.Utils.f0.b
            public final void a(Object obj) {
                VideoTamperingViewModel.this.u(z, (e) obj);
            }
        });
    }

    private void J(final String str) {
        boolean z = true;
        if (this.f10845c != 1) {
            z = false;
        }
        l.s(this.a, z, new com.tplink.libtpnetwork.Utils.f0.b() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.w8
            @Override // com.tplink.libtpnetwork.Utils.f0.b
            public final void a(Object obj) {
                VideoTamperingViewModel.this.w(str, (e) obj);
            }
        });
    }

    private void K(TamperDetectConfig tamperDetectConfig) {
        this.i.b(this.f10844b.w(tamperDetectConfig).F(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.y8
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                VideoTamperingViewModel.this.y((c) obj);
            }
        }).y(new a() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.z8
            @Override // io.reactivex.g0.a
            public final void run() {
                VideoTamperingViewModel.this.A();
            }
        }).H0(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.x8
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                VideoTamperingViewModel.this.C((Boolean) obj);
            }
        }, new g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.u8
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                VideoTamperingViewModel.this.E((Throwable) obj);
            }
        }));
    }

    private void M(boolean z) {
        p a = this.f10844b.t().a();
        a.e(z);
        K(a.g());
    }

    private void O(String str) {
        p a = this.f10844b.t().a();
        a.f(str);
        K(a.g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public /* synthetic */ void l(e eVar) {
        this.f10846d = eVar;
        this.f10847e.postValue(Boolean.valueOf(eVar.P()));
        this.f10848f.postValue(this.f10846d.L());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public /* synthetic */ void n(c cVar) throws Exception {
        this.g.postValue(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public /* synthetic */ void p() throws Exception {
        this.g.postValue(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public /* synthetic */ void s(TamperDetectConfig tamperDetectConfig) throws Exception {
        F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public /* synthetic */ void u(boolean z, e eVar) {
        eVar.y0(z);
        this.f10847e.postValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public /* synthetic */ void w(String str, e eVar) {
        eVar.z0(str);
        this.f10848f.postValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public /* synthetic */ void y(c cVar) throws Exception {
        this.g.postValue(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public /* synthetic */ void A() throws Exception {
        this.g.postValue(Boolean.FALSE);
    }

    public void F() {
        p a = this.f10844b.t().a();
        this.f10847e.postValue(Boolean.valueOf(a.c()));
        this.f10848f.postValue(a.b());
    }

    public void G() {
        boolean z = true;
        if (this.f10845c != 1) {
            z = false;
        }
        l.g(this.a, z, new com.tplink.libtpnetwork.Utils.f0.b() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.c9
            @Override // com.tplink.libtpnetwork.Utils.f0.b
            public final void a(Object obj) {
                VideoTamperingViewModel.this.l((e) obj);
            }
        });
    }

    public void L(boolean z) {
        if (this.f10845c == 3) {
            M(z);
        } else {
            I(z);
        }
        d.p(this.a, z, this.f10845c != 3);
    }

    public void N(String str) {
        if (this.f10845c == 3) {
            O(str);
        } else {
            J(str);
        }
    }

    public MutableLiveData<Boolean> f() {
        return this.h;
    }

    public MutableLiveData<Boolean> g() {
        return this.g;
    }

    public MutableLiveData<String> h() {
        return this.f10848f;
    }

    public MutableLiveData<Boolean> i() {
        return this.f10847e;
    }

    @SuppressLint({"CheckResult"})
    public void j(int i) {
        this.f10845c = i;
        if (i == 3) {
            H();
        } else {
            G();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.i.dispose();
    }
}
