package com.tplink.iot.viewmodel.ipcamera.setting;

import android.annotation.SuppressLint;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.R;
import com.tplink.iot.Utils.x0.g;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.Utils.j;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.repo.UpnpSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;
import io.reactivex.e0.c;

/* loaded from: classes3.dex */
public class UpnpSettingViewModel extends AndroidViewModel {

    /* renamed from: c  reason: collision with root package name */
    private UpnpSettingRepository f10841c;

    /* renamed from: e  reason: collision with root package name */
    private String f10843e;
    public ObservableBoolean a = new ObservableBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public final ObservableBoolean f10840b = new ObservableBoolean(false);

    /* renamed from: d  reason: collision with root package name */
    public MutableLiveData<a<String>> f10842d = new MutableLiveData<>();

    public UpnpSettingViewModel(@NonNull Application application, TPCameraDeviceContext tPCameraDeviceContext) {
        super(application);
        this.f10843e = tPCameraDeviceContext.getDeviceIdMD5();
        UpnpSettingRepository upnpSettingRepository = (UpnpSettingRepository) e.b(tPCameraDeviceContext, UpnpSettingRepository.class);
        this.f10841c = upnpSettingRepository;
        this.a.set(j.h(upnpSettingRepository.M1()));
    }

    private void f(Throwable th) {
        this.f10840b.set(false);
        this.f10842d.postValue(new a<>(getApplication().getString(R.string.common_operation_failed)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void h(c cVar) throws Exception {
        this.f10840b.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public /* synthetic */ void j() throws Exception {
        this.f10840b.set(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void k(Boolean bool) throws Exception {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public /* synthetic */ void m(boolean z, Throwable th) throws Exception {
        this.a.set(!z);
        f(th);
    }

    private void n(boolean z) {
        g.u(this.f10843e, z);
    }

    @SuppressLint({"CheckResult"})
    public void o(final boolean z) {
        this.a.set(z);
        this.f10841c.U1(z).F(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.s8
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                UpnpSettingViewModel.this.h((c) obj);
            }
        }).y(new io.reactivex.g0.a() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.t8
            @Override // io.reactivex.g0.a
            public final void run() {
                UpnpSettingViewModel.this.j();
            }
        }).H0(q8.f11061c, new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.r8
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                UpnpSettingViewModel.this.m(z, (Throwable) obj);
            }
        });
        n(z);
    }
}
