package com.tplink.iot.viewmodel.ipcamera.setting.targettrack;

import android.app.Application;
import android.util.Log;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tplink.iot.R;
import com.tplink.iot.Utils.x0.w;
import com.tplink.iot.cloud.exception.IoTCloudException;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.repo.TargetTrackRepository;
import com.tplink.libtpnetwork.cameranetwork.model.ComponentType;
import io.reactivex.q;

/* compiled from: TargetTrackViewModel.kt */
/* loaded from: classes3.dex */
public final class TargetTrackViewModel extends AndroidViewModel {

    /* renamed from: b  reason: collision with root package name */
    private final String f11089b;

    /* renamed from: c  reason: collision with root package name */
    private final TargetTrackRepository f11090c;
    private final String a = TargetTrackViewModel.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    private final MutableLiveData<Boolean> f11091d = new MutableLiveData<>();

    /* renamed from: e  reason: collision with root package name */
    private final MutableLiveData<Boolean> f11092e = new MutableLiveData<>();

    /* renamed from: f  reason: collision with root package name */
    private final io.reactivex.e0.b f11093f = new io.reactivex.e0.b();
    private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> g = new MutableLiveData<>();
    private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> h = new MutableLiveData<>();
    private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> i = new MutableLiveData<>();
    private int j = 3;

    /* compiled from: TargetTrackViewModel.kt */
    /* loaded from: classes3.dex */
    static final class a<T> implements com.tplink.libtpnetwork.Utils.f0.b<Boolean> {
        a() {
        }

        /* renamed from: b */
        public final void a(Boolean bool) {
            TargetTrackViewModel.this.w().setValue(bool);
        }
    }

    /* compiled from: TargetTrackViewModel.kt */
    /* loaded from: classes3.dex */
    static final class b<T> implements io.reactivex.g0.g<Integer> {
        b() {
        }

        /* renamed from: a */
        public final void accept(Integer it) {
            TargetTrackViewModel targetTrackViewModel = TargetTrackViewModel.this;
            kotlin.jvm.internal.j.d(it, "it");
            targetTrackViewModel.u(it.intValue());
        }
    }

    /* compiled from: TargetTrackViewModel.kt */
    /* loaded from: classes3.dex */
    static final class c<T> implements io.reactivex.g0.g<Throwable> {
        c() {
        }

        /* renamed from: a */
        public final void accept(Throwable it) {
            TargetTrackViewModel targetTrackViewModel = TargetTrackViewModel.this;
            kotlin.jvm.internal.j.d(it, "it");
            targetTrackViewModel.t(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TargetTrackViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class d<T> implements io.reactivex.g0.g<io.reactivex.e0.c> {
        d() {
        }

        /* renamed from: a */
        public final void accept(io.reactivex.e0.c cVar) {
            TargetTrackViewModel.this.w().postValue(Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TargetTrackViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class e implements io.reactivex.g0.a {
        e() {
        }

        @Override // io.reactivex.g0.a
        public final void run() {
            TargetTrackViewModel.this.w().postValue(Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TargetTrackViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class f<T> implements io.reactivex.g0.g<T> {

        /* renamed from: c  reason: collision with root package name */
        public static final f f11097c = new f();

        f() {
        }

        @Override // io.reactivex.g0.g
        public final void accept(T t) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TargetTrackViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class g<T> implements io.reactivex.g0.g<Throwable> {
        g() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            b.d.w.c.a.e(TargetTrackViewModel.this.n(), Log.getStackTraceString(th));
            TargetTrackViewModel targetTrackViewModel = TargetTrackViewModel.this;
            targetTrackViewModel.x(targetTrackViewModel.s(), R.string.general_failed);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TargetTrackViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class h<T> implements com.tplink.libtpnetwork.Utils.f0.b<com.tplink.libtpmediaother.database.model.e> {
        h() {
        }

        /* renamed from: b */
        public final void a(com.tplink.libtpmediaother.database.model.e info) {
            MutableLiveData<Boolean> r = TargetTrackViewModel.this.r();
            kotlin.jvm.internal.j.d(info, "info");
            r.setValue(Boolean.valueOf(info.M()));
        }
    }

    /* compiled from: TargetTrackViewModel.kt */
    /* loaded from: classes3.dex */
    static final class i<T> implements Observer<Boolean> {
        i() {
        }

        /* renamed from: a */
        public final void onChanged(Boolean bool) {
            TargetTrackViewModel.this.r().setValue(Boolean.valueOf(bool != null ? bool.booleanValue() : false));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TargetTrackViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class j<T> implements com.tplink.libtpnetwork.Utils.f0.b<com.tplink.libtpmediaother.database.model.e> {
        final /* synthetic */ boolean a;

        j(boolean z) {
            this.a = z;
        }

        /* renamed from: b */
        public final void a(com.tplink.libtpmediaother.database.model.e info) {
            kotlin.jvm.internal.j.d(info, "info");
            info.A0(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TargetTrackViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class k<T> implements io.reactivex.g0.g<Boolean> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f11100d;

        k(boolean z) {
            this.f11100d = z;
        }

        /* renamed from: a */
        public final void accept(Boolean bool) {
            TargetTrackViewModel.this.r().setValue(Boolean.valueOf(this.f11100d));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TargetTrackViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class l<T> implements io.reactivex.g0.g<Throwable> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f11102d;

        l(boolean z) {
            this.f11102d = z;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            TargetTrackViewModel.this.r().setValue(Boolean.valueOf(!this.f11102d));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TargetTrackViewModel(Application application, TPCameraDeviceContext context) {
        super(application);
        kotlin.jvm.internal.j.e(application, "application");
        kotlin.jvm.internal.j.e(context, "context");
        String deviceIdMD5 = context.getDeviceIdMD5();
        kotlin.jvm.internal.j.d(deviceIdMD5, "context.deviceIdMD5");
        this.f11089b = deviceIdMD5;
        com.tplink.libtpnetwork.IoTNetwork.repository.kb.c c2 = com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(deviceIdMD5, TargetTrackRepository.class);
        kotlin.jvm.internal.j.d(c2, "IoTDeviceRepositoryProvi…ckRepository::class.java)");
        this.f11090c = (TargetTrackRepository) c2;
    }

    private final void A(boolean z) {
        this.f11091d.setValue(Boolean.valueOf(z));
        boolean z2 = true;
        if (this.j != 1) {
            z2 = false;
        }
        b.d.q.b.l.s(this.f11089b, z2, new j(z));
    }

    private final void B(boolean z) {
        q<Boolean> C = this.f11090c.B(z).E(new k(z)).C(new l(z));
        kotlin.jvm.internal.j.d(C, "targetTrackRepository\n  …nabled.value = !enabled }");
        j(C);
    }

    private final <T> void j(q<T> qVar) {
        this.f11093f.b(qVar.F(new d()).y(new e()).H0(f.f11097c, new g()));
    }

    private final void l() {
        boolean z = true;
        if (this.j != 1) {
            z = false;
        }
        b.d.q.b.l.g(this.f11089b, z, new h());
    }

    private final void m() {
        q<Boolean> s = this.f11090c.s();
        kotlin.jvm.internal.j.d(s, "targetTrackRepository\n  …       .targetTrackConfig");
        j(s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(Throwable th) {
        if (th instanceof IoTCloudException) {
            this.h.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.TRUE));
        } else {
            this.g.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(getApplication().getString(R.string.common_operation_failed)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(int i2) {
        if (i2 == 1) {
            this.i.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.TRUE));
            w.g(this.f11089b);
        } else if (i2 == 2) {
            z(true);
        } else if (i2 != 3) {
            this.h.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.TRUE));
        } else {
            this.h.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.TRUE));
            w.f(this.f11089b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> mutableLiveData, int i2) {
        Application application = getApplication();
        kotlin.jvm.internal.j.d(application, "getApplication<Application>()");
        mutableLiveData.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(application.getResources().getString(i2)));
    }

    public final void i() {
        this.f11093f.b(com.tplink.iot.Utils.z0.h.a(this.f11089b, true, ComponentType.TARGET_TRACK, new a()).H0(new b(), new c()));
    }

    public final void k() {
        if (this.j == 3) {
            m();
        } else {
            l();
        }
    }

    public final String n() {
        return this.a;
    }

    public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> o() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.f11093f.d();
    }

    public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> p() {
        return this.i;
    }

    public final MutableLiveData<Boolean> r() {
        return this.f11091d;
    }

    public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> s() {
        return this.g;
    }

    public final void v(int i2) {
        this.j = i2;
        k();
    }

    public final MutableLiveData<Boolean> w() {
        return this.f11092e;
    }

    public final void y(LifecycleOwner lifecycleOwner) {
        kotlin.jvm.internal.j.e(lifecycleOwner, "lifecycleOwner");
        if (this.j == 3) {
            this.f11090c.f14325d.observe(lifecycleOwner, new i());
        }
    }

    public final void z(boolean z) {
        if (this.j == 3) {
            B(z);
        } else {
            A(z);
        }
    }
}
