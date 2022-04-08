package com.tplink.iot.viewmodel.ipcamera.setting.privacymask;

import android.app.Application;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.R;
import com.tplink.iot.viewmodel.ipcamera.basic.RegionEditViewModel;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.repo.PrivacyMaskRepository;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: PrivacyMaskZonesViewModel.kt */
/* loaded from: classes3.dex */
public final class PrivacyMaskZonesViewModel extends RegionEditViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final String f11049f;
    private final PrivacyMaskRepository g;
    private MutableLiveData<List<com.tplink.libtpnetwork.cameranetwork.business.model.d>> h;

    /* renamed from: e  reason: collision with root package name */
    private final String f11048e = PrivacyMaskZonesViewModel.class.getSimpleName();
    private final io.reactivex.e0.b i = new io.reactivex.e0.b();
    private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> j = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PrivacyMaskZonesViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class a<T> implements g<io.reactivex.e0.c> {
        a() {
        }

        /* renamed from: a */
        public final void accept(io.reactivex.e0.c cVar) {
            PrivacyMaskZonesViewModel.this.f10379d.set(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PrivacyMaskZonesViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class b implements io.reactivex.g0.a {
        b() {
        }

        @Override // io.reactivex.g0.a
        public final void run() {
            PrivacyMaskZonesViewModel.this.f10379d.set(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PrivacyMaskZonesViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class c<T> implements g<T> {

        /* renamed from: c  reason: collision with root package name */
        public static final c f11051c = new c();

        c() {
        }

        @Override // io.reactivex.g0.g
        public final void accept(T t) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PrivacyMaskZonesViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class d<T> implements g<Throwable> {
        d() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            b.d.w.c.a.e(PrivacyMaskZonesViewModel.this.f11048e, Log.getStackTraceString(th));
            PrivacyMaskZonesViewModel privacyMaskZonesViewModel = PrivacyMaskZonesViewModel.this;
            privacyMaskZonesViewModel.l(privacyMaskZonesViewModel.k(), R.string.general_failed);
        }
    }

    /* compiled from: PrivacyMaskZonesViewModel.kt */
    /* loaded from: classes3.dex */
    static final class e<T> implements g<Boolean> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.b.a f11053c;

        e(kotlin.jvm.b.a aVar) {
            this.f11053c = aVar;
        }

        /* renamed from: a */
        public final void accept(Boolean bool) {
            this.f11053c.invoke();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivacyMaskZonesViewModel(Application application, TPCameraDeviceContext context) {
        super(application);
        j.e(application, "application");
        j.e(context, "context");
        String deviceIdMD5 = context.getDeviceIdMD5();
        this.f11049f = deviceIdMD5;
        MutableLiveData<List<com.tplink.libtpnetwork.cameranetwork.business.model.d>> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(new LinkedList());
        p pVar = p.a;
        this.h = mutableLiveData;
        this.g = (PrivacyMaskRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(deviceIdMD5, PrivacyMaskRepository.class);
        n();
    }

    private final <T> void i(q<T> qVar) {
        this.i.b(qVar.F(new a()).y(new b()).H0(c.f11051c, new d()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> mutableLiveData, int i) {
        Application application = getApplication();
        j.d(application, "getApplication<Application>()");
        mutableLiveData.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(application.getResources().getString(i)));
    }

    private final void n() {
        List<com.tplink.libtpnetwork.cameranetwork.business.model.d> list;
        MutableLiveData<com.tplink.libtpnetwork.cameranetwork.business.model.e> mutableLiveData;
        com.tplink.libtpnetwork.cameranetwork.business.model.e value;
        MutableLiveData<List<com.tplink.libtpnetwork.cameranetwork.business.model.d>> mutableLiveData2 = this.h;
        PrivacyMaskRepository privacyMaskRepository = this.g;
        if (privacyMaskRepository == null || (mutableLiveData = privacyMaskRepository.f14316d) == null || (value = mutableLiveData.getValue()) == null || (list = value.a()) == null) {
            list = new LinkedList<>();
        }
        mutableLiveData2.setValue(list);
        List<com.tplink.libtpnetwork.cameranetwork.business.model.d> value2 = this.h.getValue();
        if (value2 != null) {
            j.d(value2, "this");
            h(value2);
        }
    }

    public final void h(List<? extends com.tplink.libtpnetwork.cameranetwork.business.model.d> list) {
        j.e(list, "list");
        for (com.tplink.libtpnetwork.cameranetwork.business.model.d dVar : list) {
            if (dVar.c() == 0 && dVar.d() == 0 && dVar.a() == 10000 && dVar.b() == 10000) {
                this.f10378c.set(true);
                return;
            }
            this.f10378c.set(false);
        }
    }

    public final MutableLiveData<List<com.tplink.libtpnetwork.cameranetwork.business.model.d>> j() {
        return this.h;
    }

    public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> k() {
        return this.j;
    }

    public final void m(List<? extends com.tplink.libtpnetwork.cameranetwork.business.model.d> regions, kotlin.jvm.b.a<p> runIfSuccess) {
        q<Boolean> H;
        q<Boolean> E;
        j.e(regions, "regions");
        j.e(runIfSuccess, "runIfSuccess");
        PrivacyMaskRepository privacyMaskRepository = this.g;
        if (privacyMaskRepository != null && (H = privacyMaskRepository.H(regions)) != null && (E = H.E(new e(runIfSuccess))) != null) {
            i(E);
        }
    }

    public final void o(List<? extends com.tplink.libtpnetwork.cameranetwork.business.model.d> regions) {
        j.e(regions, "regions");
        this.h.setValue(regions);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.i.d();
    }
}
