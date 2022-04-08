package com.tplink.iot.devices.switches.viewmodel;

import android.app.Application;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.params.DelayActionInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.repository.SwitchRepository;
import io.reactivex.g0.g;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.m;
import kotlin.reflect.j;

/* compiled from: SwitchSetDelayOffViewModel.kt */
/* loaded from: classes2.dex */
public final class SwitchSetDelayOffViewModel extends AndroidViewModel {
    static final /* synthetic */ j[] a = {m.h(new PropertyReference1Impl(SwitchSetDelayOffViewModel.class, "mSwitchRepository", "getMSwitchRepository()Lcom/tplink/libtpnetwork/IoTNetwork/repository/SwitchRepository;", 0))};

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.t.c f7849b;

    /* renamed from: d  reason: collision with root package name */
    private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> f7851d;

    /* renamed from: e  reason: collision with root package name */
    private final LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> f7852e;

    /* renamed from: c  reason: collision with root package name */
    private final LiveData<DelayActionInfoBean> f7850c = i().l4();

    /* renamed from: f  reason: collision with root package name */
    private final ObservableBoolean f7853f = new ObservableBoolean(false);

    /* compiled from: DelegateUtils.kt */
    /* loaded from: classes2.dex */
    public static final class a implements kotlin.t.c<Object, SwitchRepository> {
        private final SwitchRepository a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ThingContext f7854b;

        /* JADX WARN: Type inference failed for: r2v1, types: [com.tplink.libtpnetwork.IoTNetwork.repository.kb.c, java.lang.Object, com.tplink.libtpnetwork.IoTNetwork.repository.SwitchRepository] */
        /* JADX WARN: Unknown variable types count: 1 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public a(com.tplink.libtpnetwork.IoTNetwork.ThingContext r2) {
            /*
                r1 = this;
                r1.f7854b = r2
                r1.<init>()
                java.lang.Class<com.tplink.libtpnetwork.IoTNetwork.repository.SwitchRepository> r0 = com.tplink.libtpnetwork.IoTNetwork.repository.SwitchRepository.class
                com.tplink.libtpnetwork.IoTNetwork.repository.kb.c r2 = com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(r2, r0)
                java.lang.String r0 = "IoTDeviceRepositoryProvi…sitory, REPO::class.java)"
                kotlin.jvm.internal.j.d(r2, r0)
                r1.a = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.devices.switches.viewmodel.SwitchSetDelayOffViewModel.a.<init>(com.tplink.libtpnetwork.IoTNetwork.ThingContext):void");
        }

        /* renamed from: c */
        public SwitchRepository b(Object thisRef, j<?> property) {
            kotlin.jvm.internal.j.e(thisRef, "thisRef");
            kotlin.jvm.internal.j.e(property, "property");
            return this.a;
        }
    }

    /* compiled from: SwitchSetDelayOffViewModel.kt */
    /* loaded from: classes2.dex */
    static final class b implements io.reactivex.g0.a {
        b() {
        }

        @Override // io.reactivex.g0.a
        public final void run() {
            SwitchSetDelayOffViewModel.this.f7851d.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.TRUE));
        }
    }

    /* compiled from: SwitchSetDelayOffViewModel.kt */
    /* loaded from: classes2.dex */
    static final class c<T> implements g<Throwable> {
        c() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            SwitchSetDelayOffViewModel.this.f7851d.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.FALSE));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwitchSetDelayOffViewModel(Application application, ThingContext iotDeviceContext) {
        super(application);
        kotlin.jvm.internal.j.e(application, "application");
        kotlin.jvm.internal.j.e(iotDeviceContext, "iotDeviceContext");
        this.f7849b = new a(iotDeviceContext);
        MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> mutableLiveData = new MutableLiveData<>();
        this.f7851d = mutableLiveData;
        this.f7852e = mutableLiveData;
    }

    private final SwitchRepository i() {
        return (SwitchRepository) this.f7849b.b(this, a[0]);
    }

    public final LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> g() {
        return this.f7852e;
    }

    public final LiveData<DelayActionInfoBean> h() {
        return this.f7850c;
    }

    public final ObservableBoolean j() {
        return this.f7853f;
    }

    public final void k(DelayActionInfoBean info) {
        kotlin.jvm.internal.j.e(info, "info");
        i().q4(info).i(new b()).j(new c()).y();
    }
}
