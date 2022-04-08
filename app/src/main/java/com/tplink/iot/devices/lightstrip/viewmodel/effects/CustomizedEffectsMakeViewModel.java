package com.tplink.iot.devices.lightstrip.viewmodel.effects;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.CustomizedEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.PredefinedEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.PredefinedEffectTemplate;
import com.tplink.libtpnetwork.IoTNetwork.repository.LightStripRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.LightingEffectRepository;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.List;
import kotlin.collections.n;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.m;
import kotlin.reflect.j;

/* compiled from: CustomizedEffectsMakeViewModel.kt */
/* loaded from: classes2.dex */
public final class CustomizedEffectsMakeViewModel extends AndroidViewModel {
    static final /* synthetic */ j[] a = {m.h(new PropertyReference1Impl(CustomizedEffectsMakeViewModel.class, "mLightStripRepository", "getMLightStripRepository()Lcom/tplink/libtpnetwork/IoTNetwork/repository/LightStripRepository;", 0)), m.h(new PropertyReference1Impl(CustomizedEffectsMakeViewModel.class, "mLightingEffectRepository", "getMLightingEffectRepository()Lcom/tplink/libtpnetwork/TPCloudNetwork/repository/LightingEffectRepository;", 0))};

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.t.c f7743b;

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.t.c f7744c;

    /* renamed from: d  reason: collision with root package name */
    private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> f7745d;

    /* renamed from: e  reason: collision with root package name */
    private final LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> f7746e;

    /* renamed from: f  reason: collision with root package name */
    private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> f7747f;
    private final LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> g;
    private final MutableLiveData<String> h;
    private final LiveData<String> i;
    private String j = "";
    private final ThingContext k;

    /* compiled from: DelegateUtils.kt */
    /* loaded from: classes2.dex */
    public static final class a implements kotlin.t.c<Object, LightingEffectRepository> {
        private final LightingEffectRepository a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ThingContext f7748b;

        /* JADX WARN: Type inference failed for: r2v2, types: [b.d.b.f.a, java.lang.Object, com.tplink.libtpnetwork.TPCloudNetwork.repository.LightingEffectRepository] */
        /* JADX WARN: Unknown variable types count: 1 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public a(com.tplink.libtpnetwork.IoTNetwork.ThingContext r2) {
            /*
                r1 = this;
                r1.f7748b = r2
                r1.<init>()
                com.tplink.cloud.context.b r2 = r2.getAccountContext()
                java.lang.Class<com.tplink.libtpnetwork.TPCloudNetwork.repository.LightingEffectRepository> r0 = com.tplink.libtpnetwork.TPCloudNetwork.repository.LightingEffectRepository.class
                b.d.b.f.a r2 = b.d.b.f.b.a(r2, r0)
                java.lang.String r0 = "CloudRepositoryProviders…ontext, REPO::class.java)"
                kotlin.jvm.internal.j.d(r2, r0)
                r1.a = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.devices.lightstrip.viewmodel.effects.CustomizedEffectsMakeViewModel.a.<init>(com.tplink.libtpnetwork.IoTNetwork.ThingContext):void");
        }

        /* renamed from: c */
        public LightingEffectRepository b(Object thisRef, j<?> property) {
            kotlin.jvm.internal.j.e(thisRef, "thisRef");
            kotlin.jvm.internal.j.e(property, "property");
            return this.a;
        }
    }

    /* compiled from: DelegateUtils.kt */
    /* loaded from: classes2.dex */
    public static final class b implements kotlin.t.c<Object, LightStripRepository> {
        private final LightStripRepository a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ThingContext f7749b;

        /* JADX WARN: Type inference failed for: r2v1, types: [com.tplink.libtpnetwork.IoTNetwork.repository.kb.c, java.lang.Object, com.tplink.libtpnetwork.IoTNetwork.repository.LightStripRepository] */
        /* JADX WARN: Unknown variable types count: 1 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public b(com.tplink.libtpnetwork.IoTNetwork.ThingContext r2) {
            /*
                r1 = this;
                r1.f7749b = r2
                r1.<init>()
                java.lang.Class<com.tplink.libtpnetwork.IoTNetwork.repository.LightStripRepository> r0 = com.tplink.libtpnetwork.IoTNetwork.repository.LightStripRepository.class
                com.tplink.libtpnetwork.IoTNetwork.repository.kb.c r2 = com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(r2, r0)
                java.lang.String r0 = "IoTDeviceRepositoryProvi…sitory, REPO::class.java)"
                kotlin.jvm.internal.j.d(r2, r0)
                r1.a = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.devices.lightstrip.viewmodel.effects.CustomizedEffectsMakeViewModel.b.<init>(com.tplink.libtpnetwork.IoTNetwork.ThingContext):void");
        }

        /* renamed from: c */
        public LightStripRepository b(Object thisRef, j<?> property) {
            kotlin.jvm.internal.j.e(thisRef, "thisRef");
            kotlin.jvm.internal.j.e(property, "property");
            return this.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CustomizedEffectsMakeViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class c implements io.reactivex.f {

        /* compiled from: CustomizedEffectsMakeViewModel.kt */
        /* loaded from: classes2.dex */
        static final class a<T> implements g<io.reactivex.e0.c> {
            a() {
            }

            /* renamed from: a */
            public final void accept(io.reactivex.e0.c cVar) {
                CustomizedEffectsMakeViewModel.this.f7747f.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(100));
            }
        }

        /* compiled from: CustomizedEffectsMakeViewModel.kt */
        /* loaded from: classes2.dex */
        static final class b implements io.reactivex.g0.a {
            b() {
            }

            @Override // io.reactivex.g0.a
            public final void run() {
                CustomizedEffectsMakeViewModel.this.f7747f.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Integer.valueOf((int) ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION)));
            }
        }

        /* compiled from: CustomizedEffectsMakeViewModel.kt */
        /* renamed from: com.tplink.iot.devices.lightstrip.viewmodel.effects.CustomizedEffectsMakeViewModel$c$c  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        static final class C0208c<T> implements g<Throwable> {
            C0208c() {
            }

            /* renamed from: a */
            public final void accept(Throwable th) {
                CustomizedEffectsMakeViewModel.this.f7747f.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(300));
            }
        }

        c() {
        }

        @Override // io.reactivex.f
        public final io.reactivex.e a(io.reactivex.a source) {
            kotlin.jvm.internal.j.e(source, "source");
            return source.l(new a()).i(new b()).j(new C0208c());
        }
    }

    /* compiled from: CustomizedEffectsMakeViewModel.kt */
    /* loaded from: classes2.dex */
    static final class d<T> implements g<io.reactivex.e0.c> {
        d() {
        }

        /* renamed from: a */
        public final void accept(io.reactivex.e0.c cVar) {
            CustomizedEffectsMakeViewModel.this.f7745d.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(100));
        }
    }

    /* compiled from: CustomizedEffectsMakeViewModel.kt */
    /* loaded from: classes2.dex */
    static final class e implements io.reactivex.g0.a {
        e() {
        }

        @Override // io.reactivex.g0.a
        public final void run() {
            CustomizedEffectsMakeViewModel.this.f7745d.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Integer.valueOf((int) ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION)));
        }
    }

    /* compiled from: CustomizedEffectsMakeViewModel.kt */
    /* loaded from: classes2.dex */
    static final class f<T> implements g<Throwable> {
        f() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            CustomizedEffectsMakeViewModel.this.f7745d.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(300));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomizedEffectsMakeViewModel(Application application, ThingContext iotDeviceContext) {
        super(application);
        kotlin.jvm.internal.j.e(application, "application");
        kotlin.jvm.internal.j.e(iotDeviceContext, "iotDeviceContext");
        this.k = iotDeviceContext;
        this.f7743b = new b(iotDeviceContext);
        this.f7744c = new a(iotDeviceContext);
        MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> mutableLiveData = new MutableLiveData<>();
        this.f7745d = mutableLiveData;
        this.f7746e = mutableLiveData;
        MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> mutableLiveData2 = new MutableLiveData<>();
        this.f7747f = mutableLiveData2;
        this.g = mutableLiveData2;
        MutableLiveData<String> mutableLiveData3 = new MutableLiveData<>();
        this.h = mutableLiveData3;
        this.i = mutableLiveData3;
    }

    private final io.reactivex.f k() {
        return new c();
    }

    private final LightingEffectRepository p() {
        return (LightingEffectRepository) this.f7744c.b(this, a[1]);
    }

    public final q<CustomizedEffect> h(CustomizedEffect effect) {
        kotlin.jvm.internal.j.e(effect, "effect");
        return p().N(effect);
    }

    public final void i(String effectId) {
        kotlin.jvm.internal.j.e(effectId, "effectId");
        p().P(effectId).f(k()).y();
    }

    public final q<CustomizedEffect> j(String effectId) {
        kotlin.jvm.internal.j.e(effectId, "effectId");
        return p().U(effectId);
    }

    public final LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> l() {
        return this.g;
    }

    public final String m() {
        return this.j;
    }

    public final LiveData<String> n() {
        return this.i;
    }

    public final LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> o() {
        return this.f7746e;
    }

    public final q<PredefinedEffect> r(String predefinedEffectId) {
        kotlin.jvm.internal.j.e(predefinedEffectId, "predefinedEffectId");
        return p().Y(predefinedEffectId);
    }

    public final LiveData<List<PredefinedEffect>> s() {
        return p().b0();
    }

    public final q<PredefinedEffectTemplate> t(String predefinedEffectId) {
        kotlin.jvm.internal.j.e(predefinedEffectId, "predefinedEffectId");
        return p().c0(predefinedEffectId);
    }

    public final boolean u() {
        return com.tplink.iot.Utils.w0.a.a(this.k.getDeviceIdMD5(), EnumIoTComponent.LIGHT_STRIP_LIGHTING_EFFECT) >= 2;
    }

    public final void v() {
        p().a0().F(new d()).z(new e()).C(new f()).F0();
    }

    public final int w(String predefinedEffectId) {
        kotlin.jvm.internal.j.e(predefinedEffectId, "predefinedEffectId");
        List<CustomizedEffect> value = p().X().getValue();
        int i = 0;
        if (value != null && !value.isEmpty()) {
            for (CustomizedEffect customizedEffect : value) {
                if (kotlin.jvm.internal.j.a(customizedEffect.getPredefinedEffectId(), predefinedEffectId) && (i = i + 1) < 0) {
                    n.j();
                }
            }
        }
        return i + 1;
    }

    public final void x(String value) {
        kotlin.jvm.internal.j.e(value, "value");
        this.j = value;
        this.h.setValue(value);
    }

    public final q<CustomizedEffect> y(CustomizedEffect effect) {
        kotlin.jvm.internal.j.e(effect, "effect");
        return p().l0(effect);
    }
}
