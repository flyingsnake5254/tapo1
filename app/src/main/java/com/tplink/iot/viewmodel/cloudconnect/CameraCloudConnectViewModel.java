package com.tplink.iot.viewmodel.cloudconnect;

import android.app.Application;
import android.util.Log;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.tplink.cloud.bean.device.result.DeviceInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCDeviceRepository;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import io.reactivex.g0.g;
import kotlin.jvm.internal.j;

/* compiled from: CameraCloudConnectViewModel.kt */
/* loaded from: classes2.dex */
public final class CameraCloudConnectViewModel extends AndroidViewModel {

    /* renamed from: b  reason: collision with root package name */
    private io.reactivex.e0.c f9882b;

    /* renamed from: c  reason: collision with root package name */
    private final TCDeviceRepository f9883c;

    /* renamed from: d  reason: collision with root package name */
    private final TPIoTClientManager f9884d;
    private final TPCameraDeviceContext g;
    private final String a = "CameraCloudConnectViewModel";

    /* renamed from: e  reason: collision with root package name */
    private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> f9885e = new MutableLiveData<>();

    /* renamed from: f  reason: collision with root package name */
    private final MutableLiveData<Boolean> f9886f = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CameraCloudConnectViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class a<T> implements g<io.reactivex.e0.c> {
        a() {
        }

        /* renamed from: a */
        public final void accept(io.reactivex.e0.c cVar) {
            CameraCloudConnectViewModel.this.h().postValue(Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CameraCloudConnectViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class b implements io.reactivex.g0.a {
        b() {
        }

        @Override // io.reactivex.g0.a
        public final void run() {
            CameraCloudConnectViewModel.this.h().postValue(Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CameraCloudConnectViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class c<T> implements g<DeviceInfoResult> {
        c() {
        }

        /* renamed from: a */
        public final void accept(DeviceInfoResult info) {
            j.e(info, "info");
            b.d.w.c.a.b(CameraCloudConnectViewModel.this.a, info);
            CameraCloudConnectViewModel.this.g().postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.TRUE));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CameraCloudConnectViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class d<T> implements g<Throwable> {
        d() {
        }

        /* renamed from: a */
        public final void accept(Throwable throwable) {
            j.e(throwable, "throwable");
            b.d.w.c.a.e(CameraCloudConnectViewModel.this.a, Log.getStackTraceString(throwable));
            CameraCloudConnectViewModel.this.g().postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.FALSE));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraCloudConnectViewModel(Application application, TPCameraDeviceContext cameraDeviceContext) {
        super(application);
        j.e(application, "application");
        j.e(cameraDeviceContext, "cameraDeviceContext");
        this.g = cameraDeviceContext;
        b.d.b.d.b.b c2 = b.d.b.f.b.c(cameraDeviceContext.getTcAccountContext());
        j.d(c2, "CloudRepositoryProviders…Context.tcAccountContext)");
        b.d.b.d.b.a a2 = c2.a(TCDeviceRepository.class);
        j.d(a2, "repositoryProvider.get(T…ceRepository::class.java)");
        this.f9883c = (TCDeviceRepository) a2;
        b.d.b.f.a a3 = b.d.b.f.b.a(cameraDeviceContext.getTcAccountContext(), TPIoTClientManager.class);
        j.d(a3, "CloudRepositoryProviders…lientManager::class.java)");
        this.f9884d = (TPIoTClientManager) a3;
    }

    public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> g() {
        return this.f9885e;
    }

    public final MutableLiveData<Boolean> h() {
        return this.f9886f;
    }

    public final void i() {
        TCDeviceRepository tCDeviceRepository = this.f9883c;
        ALCameraDevice cameraDevice = this.g.getCameraDevice();
        this.f9882b = tCDeviceRepository.A(cameraDevice != null ? cameraDevice.getDeviceId() : null).F(new a()).y(new b()).L0(io.reactivex.l0.a.c()).H0(new c(), new d());
    }

    public final void j() {
        io.reactivex.e0.c cVar = this.f9882b;
        if (cVar != null) {
            j.c(cVar);
            cVar.dispose();
            this.f9882b = null;
        }
    }
}
