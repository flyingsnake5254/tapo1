package com.tplink.iot.viewmodel.ipcamera.setting;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.R;
import com.tplink.iot.Utils.x0.g;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.Utils.d0;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.repo.LdcDianoseSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;
import io.reactivex.e0.b;

/* loaded from: classes3.dex */
public class LdcSettingViewModel extends AndroidViewModel {

    /* renamed from: c  reason: collision with root package name */
    private String f10750c;

    /* renamed from: d  reason: collision with root package name */
    private TPCameraDeviceContext f10751d;

    /* renamed from: e  reason: collision with root package name */
    private LdcDianoseSettingRepository f10752e;
    public final MutableLiveData<Boolean> a = new MutableLiveData<>();

    /* renamed from: b  reason: collision with root package name */
    public final ObservableBoolean f10749b = new ObservableBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    private b f10753f = new b();
    public MutableLiveData<a<String>> g = new MutableLiveData<>();
    private MediatorLiveData<Boolean> h = new MediatorLiveData<>();

    public LdcSettingViewModel(@NonNull Application application) {
        super(application);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Throwable th) {
        this.f10749b.set(false);
        this.g.postValue(new a<>(getApplication().getString(R.string.general_failed)));
    }

    private void h() {
        this.f10749b.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public /* synthetic */ void j(Boolean bool) throws Exception {
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public /* synthetic */ void l(Boolean bool) throws Exception {
        h();
    }

    private void n(boolean z) {
        g.k(this.f10750c, z);
    }

    public void f(boolean z) {
        this.f10749b.set(true);
        this.f10753f.b(this.f10752e.W(z).l0(io.reactivex.d0.b.a.a()).H0(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.f4
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                LdcSettingViewModel.this.j((Boolean) obj);
            }
        }, new g4(this)));
        n(z);
    }

    public void o(String str) {
        if (!d0.a(this.f10750c, str)) {
            this.f10750c = str;
            this.f10751d = null;
            if (str != null) {
                this.f10751d = TPIoTClientManager.K1(str);
                LdcDianoseSettingRepository ldcDianoseSettingRepository = this.f10752e;
                if (ldcDianoseSettingRepository != null) {
                    this.h.removeSource(ldcDianoseSettingRepository.y());
                }
                LdcDianoseSettingRepository ldcDianoseSettingRepository2 = (LdcDianoseSettingRepository) e.b(this.f10751d, LdcDianoseSettingRepository.class);
                this.f10752e = ldcDianoseSettingRepository2;
                MediatorLiveData<Boolean> mediatorLiveData = this.h;
                MutableLiveData<Boolean> y = ldcDianoseSettingRepository2.y();
                MediatorLiveData<Boolean> mediatorLiveData2 = this.h;
                mediatorLiveData2.getClass();
                mediatorLiveData.addSource(y, new i9(mediatorLiveData2));
                this.f10753f.b(this.f10752e.T().l0(io.reactivex.d0.b.a.a()).H0(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.h4
                    @Override // io.reactivex.g0.g
                    public final void accept(Object obj) {
                        LdcSettingViewModel.this.l((Boolean) obj);
                    }
                }, new g4(this)));
            }
        }
    }

    public void p(LifecycleOwner lifecycleOwner) {
        MediatorLiveData<Boolean> mediatorLiveData = this.h;
        MutableLiveData<Boolean> mutableLiveData = this.a;
        mutableLiveData.getClass();
        mediatorLiveData.observe(lifecycleOwner, new f9(mutableLiveData));
    }
}
