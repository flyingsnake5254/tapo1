package com.tplink.iot.viewmodel.ipcamera.setting;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import b.d.q.b.l;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.model.AlertOption;
import com.tplink.libtpnetwork.cameranetwork.business.repo.AlarmSettingRepository;
import io.reactivex.e0.b;
import io.reactivex.e0.c;
import io.reactivex.g0.a;
import io.reactivex.g0.g;

/* loaded from: classes3.dex */
public class AlarmTypeViewModel extends AndroidViewModel {
    public final MutableLiveData<Boolean> a;

    /* renamed from: b  reason: collision with root package name */
    public final MutableLiveData<Boolean> f10692b;

    /* renamed from: d  reason: collision with root package name */
    private AlarmSettingRepository f10694d;

    /* renamed from: e  reason: collision with root package name */
    private String f10695e;

    /* renamed from: f  reason: collision with root package name */
    private int f10696f;

    /* renamed from: c  reason: collision with root package name */
    public final MutableLiveData<AlertOption> f10693c = new MutableLiveData<>();
    private b g = new b();

    public AlarmTypeViewModel(@NonNull Application application, TPCameraDeviceContext tPCameraDeviceContext) {
        super(application);
        Boolean bool = Boolean.FALSE;
        this.a = new MutableLiveData<>(bool);
        this.f10692b = new MutableLiveData<>(bool);
        String deviceIdMD5 = tPCameraDeviceContext.getDeviceIdMD5();
        this.f10695e = deviceIdMD5;
        this.f10694d = (AlarmSettingRepository) e.c(deviceIdMD5, AlarmSettingRepository.class);
    }

    private AlertOption f(boolean z, boolean z2) {
        if (z2 && z) {
            return AlertOption.BOTH;
        }
        if (z2) {
            return AlertOption.LIGHT;
        }
        return AlertOption.SOUND;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public /* synthetic */ void i(com.tplink.libtpmediaother.database.model.e eVar) {
        this.f10693c.postValue(f(eVar.g(), eVar.f()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void j(boolean z, boolean z2, com.tplink.libtpmediaother.database.model.e eVar) {
        eVar.V(z);
        eVar.U(z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public /* synthetic */ void l(c cVar) throws Exception {
        this.a.postValue(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public /* synthetic */ void n() throws Exception {
        this.a.postValue(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public /* synthetic */ void p(Boolean bool) throws Exception {
        t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public /* synthetic */ void s(Throwable th) throws Exception {
        t();
        th.printStackTrace();
        this.f10692b.postValue(Boolean.TRUE);
    }

    private void t() {
        AlertOption alertOption = AlertOption.SOUND;
        com.tplink.libtpnetwork.cameranetwork.business.model.b z = this.f10694d.z();
        if (z != null) {
            alertOption = f(z.g(), z.e());
        }
        this.f10693c.postValue(alertOption);
    }

    private void u() {
        boolean z = true;
        if (this.f10696f != 1) {
            z = false;
        }
        l.g(this.f10695e, z, new com.tplink.libtpnetwork.Utils.f0.b() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.b0
            @Override // com.tplink.libtpnetwork.Utils.f0.b
            public final void a(Object obj) {
                AlarmTypeViewModel.this.i((com.tplink.libtpmediaother.database.model.e) obj);
            }
        });
    }

    private void v(final boolean z, final boolean z2) {
        boolean z3 = true;
        if (this.f10696f != 1) {
            z3 = false;
        }
        l.s(this.f10695e, z3, new com.tplink.libtpnetwork.Utils.f0.b() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.z
            @Override // com.tplink.libtpnetwork.Utils.f0.b
            public final void a(Object obj) {
                AlarmTypeViewModel.j(z, z2, (com.tplink.libtpmediaother.database.model.e) obj);
            }
        });
    }

    public void g(int i) {
        this.f10696f = i;
        if (i == 3) {
            t();
        } else {
            u();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.g.dispose();
    }

    public void w(AlertOption alertOption) {
        boolean z = true;
        boolean z2 = alertOption != AlertOption.LIGHT;
        if (alertOption == AlertOption.SOUND) {
            z = false;
        }
        if (this.f10696f == 3) {
            this.g.b(this.f10694d.t(z2, z).F(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.a0
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    AlarmTypeViewModel.this.l((c) obj);
                }
            }).y(new a() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.y
                @Override // io.reactivex.g0.a
                public final void run() {
                    AlarmTypeViewModel.this.n();
                }
            }).H0(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.x
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    AlarmTypeViewModel.this.p((Boolean) obj);
                }
            }, new g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.c0
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    AlarmTypeViewModel.this.s((Throwable) obj);
                }
            }));
            return;
        }
        v(z2, z);
        this.f10693c.postValue(alertOption);
    }
}
