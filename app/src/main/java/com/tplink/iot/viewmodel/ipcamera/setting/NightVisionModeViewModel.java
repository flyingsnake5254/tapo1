package com.tplink.iot.viewmodel.ipcamera.setting;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.repo.NightVisionRepository;
import com.tplink.libtpnetwork.cameranetwork.model.NightVisionModeType;
import java.util.List;
import kotlin.text.u;

/* compiled from: NightVisionModeViewModel.kt */
/* loaded from: classes3.dex */
public final class NightVisionModeViewModel extends AndroidViewModel {
    private final String a;

    /* renamed from: c  reason: collision with root package name */
    private final String f10782c;

    /* renamed from: d  reason: collision with root package name */
    private final NightVisionRepository f10783d;
    private final TPCameraDeviceContext j;

    /* renamed from: b  reason: collision with root package name */
    private final MutableLiveData<Boolean> f10781b = new MutableLiveData<>();

    /* renamed from: e  reason: collision with root package name */
    private final io.reactivex.e0.b f10784e = new io.reactivex.e0.b();

    /* renamed from: f  reason: collision with root package name */
    private final MutableLiveData<NightVisionModeType> f10785f = new MutableLiveData<>();
    private final MutableLiveData<Integer> g = new MutableLiveData<>();
    private final MutableLiveData<List<NightVisionModeType>> h = new MutableLiveData<>();
    private final MutableLiveData<Boolean> i = new MutableLiveData<>();

    /* compiled from: NightVisionModeViewModel.kt */
    /* loaded from: classes3.dex */
    static final class a<T> implements io.reactivex.g0.g<io.reactivex.e0.c> {
        a() {
        }

        /* renamed from: a */
        public final void accept(io.reactivex.e0.c cVar) {
            NightVisionModeViewModel.this.n().postValue(Boolean.TRUE);
        }
    }

    /* compiled from: NightVisionModeViewModel.kt */
    /* loaded from: classes3.dex */
    static final class b implements io.reactivex.g0.a {
        b() {
        }

        @Override // io.reactivex.g0.a
        public final void run() {
            NightVisionModeViewModel.this.n().postValue(Boolean.FALSE);
        }
    }

    /* compiled from: NightVisionModeViewModel.kt */
    /* loaded from: classes3.dex */
    static final class c<T> implements io.reactivex.g0.g<Boolean> {
        c() {
        }

        /* renamed from: a */
        public final void accept(Boolean bool) {
            NightVisionModeViewModel.this.o();
        }
    }

    /* compiled from: NightVisionModeViewModel.kt */
    /* loaded from: classes3.dex */
    static final class d<T> implements io.reactivex.g0.g<io.reactivex.e0.c> {
        d() {
        }

        /* renamed from: a */
        public final void accept(io.reactivex.e0.c cVar) {
            NightVisionModeViewModel.this.n().postValue(Boolean.TRUE);
        }
    }

    /* compiled from: NightVisionModeViewModel.kt */
    /* loaded from: classes3.dex */
    static final class e<T> implements io.reactivex.g0.g<Boolean> {
        e() {
        }

        /* renamed from: a */
        public final void accept(Boolean bool) {
            NightVisionModeViewModel.this.j().postValue(NightVisionModeViewModel.this.f10783d.t());
        }
    }

    /* compiled from: NightVisionModeViewModel.kt */
    /* loaded from: classes3.dex */
    static final class f<T> implements io.reactivex.g0.g<Throwable> {
        f() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            NightVisionModeViewModel.this.h().postValue(Boolean.TRUE);
        }
    }

    /* compiled from: NightVisionModeViewModel.kt */
    /* loaded from: classes3.dex */
    static final class g implements io.reactivex.g0.a {
        g() {
        }

        @Override // io.reactivex.g0.a
        public final void run() {
            NightVisionModeViewModel.this.n().postValue(Boolean.FALSE);
        }
    }

    /* compiled from: NightVisionModeViewModel.kt */
    /* loaded from: classes3.dex */
    static final class h<T> implements io.reactivex.g0.g<io.reactivex.e0.c> {
        h() {
        }

        /* renamed from: a */
        public final void accept(io.reactivex.e0.c cVar) {
            NightVisionModeViewModel.this.n().postValue(Boolean.TRUE);
        }
    }

    /* compiled from: NightVisionModeViewModel.kt */
    /* loaded from: classes3.dex */
    static final class i implements io.reactivex.g0.a {
        i() {
        }

        @Override // io.reactivex.g0.a
        public final void run() {
            NightVisionModeViewModel.this.n().postValue(Boolean.FALSE);
        }
    }

    /* compiled from: NightVisionModeViewModel.kt */
    /* loaded from: classes3.dex */
    static final class j<T> implements io.reactivex.g0.g<Boolean> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f10793d;

        j(int i) {
            this.f10793d = i;
        }

        /* renamed from: a */
        public final void accept(Boolean bool) {
            NightVisionModeViewModel.this.l().postValue(Integer.valueOf(this.f10793d));
        }
    }

    /* compiled from: NightVisionModeViewModel.kt */
    /* loaded from: classes3.dex */
    static final class k<T> implements io.reactivex.g0.g<Throwable> {
        k() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            NightVisionModeViewModel.this.o();
            NightVisionModeViewModel.this.h().postValue(Boolean.TRUE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NightVisionModeViewModel(Application application, TPCameraDeviceContext cameraDeviceContext) {
        super(application);
        kotlin.jvm.internal.j.e(application, "application");
        kotlin.jvm.internal.j.e(cameraDeviceContext, "cameraDeviceContext");
        this.j = cameraDeviceContext;
        String simpleName = NightVisionModeViewModel.class.getSimpleName();
        kotlin.jvm.internal.j.d(simpleName, "NightVisionModeViewModel::class.java.simpleName");
        this.a = simpleName;
        String deviceIdMD5 = cameraDeviceContext.getDeviceIdMD5();
        this.f10782c = deviceIdMD5;
        this.f10783d = (NightVisionRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(deviceIdMD5, NightVisionRepository.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        String v = this.f10783d.v();
        Integer k2 = v != null ? u.k(v) : null;
        if (k2 != null) {
            k2.intValue();
            this.g.postValue(k2);
        }
    }

    public final MutableLiveData<Boolean> h() {
        return this.i;
    }

    public final MutableLiveData<List<NightVisionModeType>> i() {
        return this.h;
    }

    public final MutableLiveData<NightVisionModeType> j() {
        return this.f10785f;
    }

    public final void k() {
        this.f10783d.w().F(new a()).y(new b()).E(new c()).F0();
    }

    public final MutableLiveData<Integer> l() {
        return this.g;
    }

    public final void m() {
        this.f10785f.postValue(this.f10783d.t());
        this.h.postValue(this.f10783d.u());
        MutableLiveData<Integer> mutableLiveData = this.g;
        String v = this.f10783d.v();
        mutableLiveData.postValue(v != null ? Integer.valueOf(Integer.parseInt(v)) : null);
    }

    public final MutableLiveData<Boolean> n() {
        return this.f10781b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.f10784e.d();
    }

    public final void p(NightVisionModeType mode) {
        kotlin.jvm.internal.j.e(mode, "mode");
        this.f10783d.A(mode).F(new d()).E(new e()).C(new f()).y(new g()).F0();
    }

    public final void r(int i2) {
        this.f10783d.C(i2).F(new h()).y(new i()).E(new j(i2)).C(new k()).F0();
    }
}
