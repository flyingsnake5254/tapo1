package com.tplink.iot.viewmodel.ipcamera.setting;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
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
public class DiagnoseSettingViewModel extends AndroidViewModel {

    /* renamed from: c  reason: collision with root package name */
    private String f10735c;

    /* renamed from: d  reason: collision with root package name */
    private TPCameraDeviceContext f10736d;

    /* renamed from: e  reason: collision with root package name */
    private LdcDianoseSettingRepository f10737e;
    public final MutableLiveData<Boolean> a = new MutableLiveData<>();

    /* renamed from: b  reason: collision with root package name */
    public final ObservableBoolean f10734b = new ObservableBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    private b f10738f = new b();
    public MutableLiveData<a<String>> g = new MutableLiveData<>();
    public MutableLiveData<a<Boolean>> h = new MutableLiveData<>();
    private MediatorLiveData<Boolean> i = new MediatorLiveData<>();
    private MediatorLiveData<Boolean> j = new MediatorLiveData<>();

    public DiagnoseSettingViewModel(@NonNull Application application) {
        super(application);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Throwable th) {
        this.f10734b.set(false);
        this.g.postValue(new a<>(getApplication().getString(R.string.general_failed)));
    }

    private void h() {
        this.f10734b.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public /* synthetic */ void j(Boolean bool) throws Exception {
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public /* synthetic */ void m(Boolean bool) throws Exception {
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public /* synthetic */ void o(Boolean bool) {
        this.h.postValue(new a<>(bool));
    }

    private void p(boolean z) {
        g.j(this.f10735c, z);
    }

    public void f(boolean z) {
        this.f10734b.set(true);
        this.f10738f.b(this.f10737e.U(z).l0(io.reactivex.d0.b.a.a()).H0(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.o3
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                DiagnoseSettingViewModel.this.j((Boolean) obj);
            }
        }, new p3(this)));
        p(z);
    }

    public void r(String str) {
        if (!d0.a(this.f10735c, str)) {
            this.f10735c = str;
            this.f10736d = null;
            if (str != null) {
                this.f10736d = TPIoTClientManager.K1(str);
                LdcDianoseSettingRepository ldcDianoseSettingRepository = this.f10737e;
                if (ldcDianoseSettingRepository != null) {
                    this.i.removeSource(ldcDianoseSettingRepository.x());
                }
                LdcDianoseSettingRepository ldcDianoseSettingRepository2 = (LdcDianoseSettingRepository) e.b(this.f10736d, LdcDianoseSettingRepository.class);
                this.f10737e = ldcDianoseSettingRepository2;
                MediatorLiveData<Boolean> mediatorLiveData = this.i;
                MutableLiveData<Boolean> x = ldcDianoseSettingRepository2.x();
                MediatorLiveData<Boolean> mediatorLiveData2 = this.i;
                mediatorLiveData2.getClass();
                mediatorLiveData.addSource(x, new i9(mediatorLiveData2));
                this.f10737e.z().postValue(Boolean.FALSE);
                MediatorLiveData<Boolean> mediatorLiveData3 = this.j;
                MutableLiveData<Boolean> z = this.f10737e.z();
                MediatorLiveData<Boolean> mediatorLiveData4 = this.j;
                mediatorLiveData4.getClass();
                mediatorLiveData3.addSource(z, new i9(mediatorLiveData4));
                this.f10738f.b(this.f10737e.S(false).l0(io.reactivex.d0.b.a.a()).H0(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.m3
                    @Override // io.reactivex.g0.g
                    public final void accept(Object obj) {
                        DiagnoseSettingViewModel.this.m((Boolean) obj);
                    }
                }, new p3(this)));
            }
        }
    }

    public void s(LifecycleOwner lifecycleOwner) {
        MediatorLiveData<Boolean> mediatorLiveData = this.i;
        MutableLiveData<Boolean> mutableLiveData = this.a;
        mutableLiveData.getClass();
        mediatorLiveData.observe(lifecycleOwner, new f9(mutableLiveData));
        this.j.observe(lifecycleOwner, new Observer() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.n3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DiagnoseSettingViewModel.this.o((Boolean) obj);
            }
        });
    }
}
