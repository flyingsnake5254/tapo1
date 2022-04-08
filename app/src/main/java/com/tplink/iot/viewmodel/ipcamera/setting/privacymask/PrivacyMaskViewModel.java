package com.tplink.iot.viewmodel.ipcamera.setting.privacymask;

import android.app.Application;
import android.util.Log;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tplink.iot.R;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.repo.PrivacyMaskRepository;
import io.reactivex.q;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: PrivacyMaskViewModel.kt */
/* loaded from: classes3.dex */
public final class PrivacyMaskViewModel extends AndroidViewModel {

    /* renamed from: b  reason: collision with root package name */
    private final String f11036b;

    /* renamed from: c  reason: collision with root package name */
    private final PrivacyMaskRepository f11037c;

    /* renamed from: d  reason: collision with root package name */
    private final MutableLiveData<Boolean> f11038d;

    /* renamed from: e  reason: collision with root package name */
    private MutableLiveData<List<com.tplink.libtpnetwork.cameranetwork.business.model.d>> f11039e;
    private final String a = PrivacyMaskViewModel.class.getSimpleName();

    /* renamed from: f  reason: collision with root package name */
    private final MutableLiveData<Boolean> f11040f = new MutableLiveData<>();
    private final MutableLiveData<Boolean> g = new MutableLiveData<>();
    private final io.reactivex.e0.b h = new io.reactivex.e0.b();
    private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> i = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PrivacyMaskViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class a<T> implements io.reactivex.g0.g<io.reactivex.e0.c> {
        a() {
        }

        /* renamed from: a */
        public final void accept(io.reactivex.e0.c cVar) {
            PrivacyMaskViewModel.this.n().postValue(Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PrivacyMaskViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class b implements io.reactivex.g0.a {
        b() {
        }

        @Override // io.reactivex.g0.a
        public final void run() {
            PrivacyMaskViewModel.this.n().postValue(Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PrivacyMaskViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class c<T> implements io.reactivex.g0.g<T> {

        /* renamed from: c  reason: collision with root package name */
        public static final c f11042c = new c();

        c() {
        }

        @Override // io.reactivex.g0.g
        public final void accept(T t) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PrivacyMaskViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class d<T> implements io.reactivex.g0.g<Throwable> {
        d() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            b.d.w.c.a.e(PrivacyMaskViewModel.this.l(), Log.getStackTraceString(th));
            PrivacyMaskViewModel privacyMaskViewModel = PrivacyMaskViewModel.this;
            privacyMaskViewModel.p(privacyMaskViewModel.m(), R.string.general_failed);
        }
    }

    /* compiled from: PrivacyMaskViewModel.kt */
    /* loaded from: classes3.dex */
    static final class e<T> implements Observer<com.tplink.libtpnetwork.cameranetwork.business.model.e> {
        e() {
        }

        /* renamed from: a */
        public final void onChanged(com.tplink.libtpnetwork.cameranetwork.business.model.e eVar) {
            List<com.tplink.libtpnetwork.cameranetwork.business.model.d> list;
            PrivacyMaskViewModel.this.j().setValue(Boolean.valueOf(eVar != null ? eVar.b() : false));
            MutableLiveData<List<com.tplink.libtpnetwork.cameranetwork.business.model.d>> k = PrivacyMaskViewModel.this.k();
            if (eVar == null || (list = eVar.a()) == null) {
                list = new LinkedList<>();
            }
            k.setValue(list);
        }
    }

    /* compiled from: PrivacyMaskViewModel.kt */
    /* loaded from: classes3.dex */
    static final class f<T> implements io.reactivex.g0.g<Boolean> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f11045d;

        f(boolean z) {
            this.f11045d = z;
        }

        /* renamed from: a */
        public final void accept(Boolean bool) {
            PrivacyMaskViewModel.this.j().setValue(Boolean.valueOf(this.f11045d));
        }
    }

    /* compiled from: PrivacyMaskViewModel.kt */
    /* loaded from: classes3.dex */
    static final class g<T> implements io.reactivex.g0.g<Throwable> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f11047d;

        g(boolean z) {
            this.f11047d = z;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            PrivacyMaskViewModel.this.j().setValue(Boolean.valueOf(!this.f11047d));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivacyMaskViewModel(Application application, TPCameraDeviceContext context) {
        super(application);
        j.e(application, "application");
        j.e(context, "context");
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(Boolean.FALSE);
        p pVar = p.a;
        this.f11038d = mutableLiveData;
        MutableLiveData<List<com.tplink.libtpnetwork.cameranetwork.business.model.d>> mutableLiveData2 = new MutableLiveData<>();
        mutableLiveData2.setValue(new LinkedList());
        this.f11039e = mutableLiveData2;
        String deviceIdMD5 = context.getDeviceIdMD5();
        j.d(deviceIdMD5, "context.deviceIdMD5");
        this.f11036b = deviceIdMD5;
        this.f11037c = (PrivacyMaskRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(deviceIdMD5, PrivacyMaskRepository.class);
    }

    private final <T> void g(q<T> qVar) {
        this.h.b(qVar.F(new a()).y(new b()).H0(c.f11042c, new d()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> mutableLiveData, int i) {
        Application application = getApplication();
        j.d(application, "getApplication<Application>()");
        mutableLiveData.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(application.getResources().getString(i)));
    }

    public final void h() {
        q<Boolean> t;
        PrivacyMaskRepository privacyMaskRepository = this.f11037c;
        if (privacyMaskRepository != null && (t = privacyMaskRepository.t()) != null) {
            g(t);
        }
    }

    public final MutableLiveData<Boolean> i() {
        return this.f11040f;
    }

    public final MutableLiveData<Boolean> j() {
        return this.f11038d;
    }

    public final MutableLiveData<List<com.tplink.libtpnetwork.cameranetwork.business.model.d>> k() {
        return this.f11039e;
    }

    public final String l() {
        return this.a;
    }

    public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> m() {
        return this.i;
    }

    public final MutableLiveData<Boolean> n() {
        return this.g;
    }

    public final boolean o() {
        MutableLiveData<com.tplink.libtpnetwork.cameranetwork.business.model.e> mutableLiveData;
        PrivacyMaskRepository privacyMaskRepository = this.f11037c;
        return ((privacyMaskRepository == null || (mutableLiveData = privacyMaskRepository.f14316d) == null) ? null : mutableLiveData.getValue()) != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.h.d();
    }

    public final void r(LifecycleOwner lifecycleOwner) {
        MutableLiveData<com.tplink.libtpnetwork.cameranetwork.business.model.e> mutableLiveData;
        j.e(lifecycleOwner, "lifecycleOwner");
        PrivacyMaskRepository privacyMaskRepository = this.f11037c;
        if (privacyMaskRepository != null && (mutableLiveData = privacyMaskRepository.f14316d) != null) {
            mutableLiveData.observe(lifecycleOwner, new e());
        }
    }

    public final void s(boolean z) {
        q<Boolean> G;
        q<Boolean> E;
        q<Boolean> C;
        PrivacyMaskRepository privacyMaskRepository = this.f11037c;
        if (privacyMaskRepository != null && (G = privacyMaskRepository.G(z)) != null && (E = G.E(new f(z))) != null && (C = E.C(new g(z))) != null) {
            g(C);
        }
    }
}
