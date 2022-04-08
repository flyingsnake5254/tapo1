package com.tplink.iot.viewmodel.ipcamera.onboardingv2;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.libtpnetwork.cameranetwork.business.repo.OnBoardingRepository;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;
import com.tplink.libtpnetwork.cameranetwork.model.ConnectStatus;
import com.tplink.libtpnetwork.cameranetwork.model.Wifi;
import com.tplink.libtpnetwork.cameranetwork.util.j;
import io.reactivex.e0.b;
import io.reactivex.g0.g;
import java.util.Objects;

/* loaded from: classes2.dex */
public class CameraWiredConnectApViewModel extends OnBoardingFragmentViewModel {
    private final MutableLiveData<a<Integer>> a = new MutableLiveData<>();

    /* renamed from: b  reason: collision with root package name */
    private final MutableLiveData<a<Boolean>> f10424b = new MutableLiveData<>();

    /* renamed from: c  reason: collision with root package name */
    private b f10425c = new b();

    /* renamed from: d  reason: collision with root package name */
    private CameraOnBoardingViewModel f10426d;

    public CameraWiredConnectApViewModel(@NonNull Application application) {
        super(application);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public /* synthetic */ void k(ConnectStatus connectStatus) throws Exception {
        this.a.postValue(new a<>(Integer.valueOf(connectStatus.getStatus())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public /* synthetic */ void m(Throwable th) throws Exception {
        this.a.postValue(new a<>(1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public /* synthetic */ void o(String str) throws Exception {
        this.f10424b.postValue(new a<>(Boolean.TRUE));
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public /* synthetic */ void r(Throwable th) throws Exception {
        this.f10424b.postValue(new a<>(Boolean.FALSE));
    }

    public void f() {
        this.f10425c.b(this.f10426d.N().v().H0(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.onboardingv2.g1
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraWiredConnectApViewModel.this.k((ConnectStatus) obj);
            }
        }, new g() { // from class: com.tplink.iot.viewmodel.ipcamera.onboardingv2.j1
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraWiredConnectApViewModel.this.m((Throwable) obj);
            }
        }));
    }

    public void g() {
        Wifi z = this.f10426d.z();
        String str = "";
        if (z == null) {
            String str2 = this.f10426d.a.get();
            Objects.requireNonNull(str2);
            String str3 = str2;
            String str4 = this.f10426d.f10404b.get() != null ? this.f10426d.f10404b.get() : str;
            Objects.requireNonNull(str4);
            z = new Wifi(str3, "", 4, 3, 0, str4);
        }
        OnBoardingRepository N = this.f10426d.N();
        if (N != null) {
            if (this.f10426d.f10404b.get() != null) {
                str = this.f10426d.f10404b.get();
            }
            Objects.requireNonNull(str);
            this.f10425c.b(N.t(z, j.d(str)).H0(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.onboardingv2.h1
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    CameraWiredConnectApViewModel.this.o((String) obj);
                }
            }, new g() { // from class: com.tplink.iot.viewmodel.ipcamera.onboardingv2.i1
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    CameraWiredConnectApViewModel.this.r((Throwable) obj);
                }
            }));
            return;
        }
        this.f10424b.postValue(new a<>(Boolean.FALSE));
    }

    public LiveData<a<Boolean>> h() {
        return this.f10424b;
    }

    public LiveData<a<Integer>> i() {
        return this.a;
    }

    public void s(CameraOnBoardingViewModel cameraOnBoardingViewModel) {
        this.f10426d = cameraOnBoardingViewModel;
    }
}
