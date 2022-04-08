package com.tplink.iot.dailysummary.viewmodel;

import android.app.Application;
import android.text.TextUtils;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.tplink.iot.R;
import com.tplink.iot.dailysummary.network.DailySummaryRepository;
import com.tplink.iot.dailysummary.network.bean.common.SummaryConfig;
import com.tplink.iot.dailysummary.network.bean.result.SummarySupportResult;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import com.tplink.libtpnetwork.cameranetwork.model.SettingsData;
import io.reactivex.t;
import io.reactivex.v;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/* compiled from: DailySummaryViewModel.kt */
/* loaded from: classes2.dex */
public final class DailySummaryViewModel extends BaseSummaryListViewModel {
    public static final a n = new a(null);
    private final LiveData<String> A;
    private final LiveData<ArrayList<com.tplink.iot.dailysummary.model.b>> B;
    private final LiveData<Boolean> C;
    private final LiveData<Boolean> D;
    private final LiveData<Boolean> E;
    private Calendar o;
    private Calendar p;
    private CommonCameraRepository r;
    private b.d.w.g.a s;
    private final MutableLiveData<com.tplink.iot.dailysummary.model.d> t;
    private final LiveData<com.tplink.iot.dailysummary.model.b> z;
    private String q = "";
    private final MutableLiveData<com.tplink.iot.dailysummary.model.d> u = new MutableLiveData<>();
    private final MutableLiveData<Boolean> v = new MutableLiveData<>();
    private final MutableLiveData<Boolean> w = new MutableLiveData<>();
    private final MutableLiveData<Boolean> x = new MutableLiveData<>();
    private final MutableLiveData<Boolean> y = new MutableLiveData<>();

    /* compiled from: DailySummaryViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DailySummaryViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class b<T, R> implements io.reactivex.g0.j<CameraComponent, t<? extends Boolean>> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ CameraSettingRepository f6415d;

        b(CameraSettingRepository cameraSettingRepository) {
            this.f6415d = cameraSettingRepository;
        }

        /* renamed from: a */
        public final t<? extends Boolean> apply(CameraComponent cameraComponent) {
            kotlin.jvm.internal.j.e(cameraComponent, "cameraComponent");
            return this.f6415d.K(cameraComponent).L0(io.reactivex.l0.a.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DailySummaryViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class c<T> implements io.reactivex.g0.g<Boolean> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f6416c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ DailySummaryViewModel f6417d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ CameraSettingRepository f6418f;

        c(String str, DailySummaryViewModel dailySummaryViewModel, CameraSettingRepository cameraSettingRepository) {
            this.f6416c = str;
            this.f6417d = dailySummaryViewModel;
            this.f6418f = cameraSettingRepository;
        }

        /* renamed from: a */
        public final void accept(Boolean aBoolean) {
            SettingsData x;
            String zoneId;
            kotlin.jvm.internal.j.d(aBoolean, "aBoolean");
            if (!aBoolean.booleanValue() || (x = this.f6418f.x()) == null || (zoneId = x.getZoneId()) == null) {
                throw new Exception("getSupportDailySummaryByTimezone failed");
            }
            DailySummaryViewModel dailySummaryViewModel = this.f6417d;
            dailySummaryViewModel.g0(dailySummaryViewModel.s(), zoneId, this.f6416c, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DailySummaryViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class d<T> implements io.reactivex.g0.g<Throwable> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ CameraSettingRepository f6420d;

        d(CameraSettingRepository cameraSettingRepository) {
            this.f6420d = cameraSettingRepository;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            MutableLiveData<Boolean> r = DailySummaryViewModel.this.r();
            Boolean bool = Boolean.FALSE;
            r.setValue(bool);
            com.tplink.iot.e.a.c.k.e().put(DailySummaryViewModel.this.s(), bool);
            b.d.w.c.a.d("getDeviceSetting failed: " + th.getMessage());
        }
    }

    /* compiled from: DailySummaryViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class e implements v<SummaryConfig> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f6422d;

        e(String str) {
            this.f6422d = str;
        }

        /* renamed from: a */
        public void onNext(SummaryConfig result) {
            kotlin.jvm.internal.j.e(result, "result");
            boolean isAuto = result.isAuto();
            boolean equals = "basic".equals(result.getStrategy());
            boolean isNotify = result.isNotify();
            DailySummaryViewModel dailySummaryViewModel = DailySummaryViewModel.this;
            String timezone = result.getTimezone();
            kotlin.jvm.internal.j.d(timezone, "result.timezone");
            dailySummaryViewModel.q = timezone;
            com.tplink.iot.dailysummary.model.d dVar = new com.tplink.iot.dailysummary.model.d(isAuto, equals, isNotify);
            com.tplink.iot.e.a.c.k.s(dVar);
            DailySummaryViewModel.this.t.setValue(dVar);
            DailySummaryViewModel.this.w.setValue(Boolean.TRUE);
        }

        @Override // io.reactivex.v
        public void onComplete() {
        }

        @Override // io.reactivex.v
        public void onError(Throwable e2) {
            kotlin.jvm.internal.j.e(e2, "e");
            b.d.w.c.a.c("tylerTest", "getSummaryConfig Request failed!");
            DailySummaryViewModel.this.w.setValue(Boolean.FALSE);
        }

        @Override // io.reactivex.v
        public void onSubscribe(io.reactivex.e0.c d2) {
            kotlin.jvm.internal.j.e(d2, "d");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DailySummaryViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class f<T> implements io.reactivex.g0.g<io.reactivex.e0.c> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f6424d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f6425f;
        final /* synthetic */ String q;
        final /* synthetic */ boolean x;

        f(String str, String str2, String str3, boolean z) {
            this.f6424d = str;
            this.f6425f = str2;
            this.q = str3;
            this.x = z;
        }

        /* renamed from: a */
        public final void accept(io.reactivex.e0.c cVar) {
            if (this.x) {
                b.d.w.g.a aVar = DailySummaryViewModel.this.s;
                aVar.k("timeZoneId" + this.f6424d, this.f6425f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DailySummaryViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class g<T> implements io.reactivex.g0.g<SummarySupportResult> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f6427d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f6428f;
        final /* synthetic */ String q;
        final /* synthetic */ boolean x;

        g(String str, String str2, String str3, boolean z) {
            this.f6427d = str;
            this.f6428f = str2;
            this.q = str3;
            this.x = z;
        }

        /* renamed from: a */
        public final void accept(SummarySupportResult supportResult) {
            MutableLiveData<Boolean> r = DailySummaryViewModel.this.r();
            kotlin.jvm.internal.j.d(supportResult, "supportResult");
            r.setValue(supportResult.getSupport());
            com.tplink.iot.e.a.c.k.e().put(DailySummaryViewModel.this.s(), supportResult.getSupport());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DailySummaryViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class h<T> implements io.reactivex.g0.g<Throwable> {

        /* renamed from: c  reason: collision with root package name */
        public static final h f6429c = new h();

        h() {
        }

        /* renamed from: a */
        public final void accept(Throwable throwable) {
            kotlin.jvm.internal.j.e(throwable, "throwable");
            b.d.w.c.a.d("getSupportDailySummaryByTimezone failed:" + throwable.getMessage());
        }
    }

    /* compiled from: DailySummaryViewModel.kt */
    /* loaded from: classes2.dex */
    static final class i<I, O> implements Function<ArrayList<com.tplink.iot.dailysummary.model.b>, Boolean> {
        public static final i a = new i();

        i() {
        }

        /* renamed from: a */
        public final Boolean apply(ArrayList<com.tplink.iot.dailysummary.model.b> arrayList) {
            return Boolean.valueOf(arrayList.size() > 0);
        }
    }

    /* compiled from: DailySummaryViewModel.kt */
    /* loaded from: classes2.dex */
    static final class j<I, O> implements Function<ArrayList<com.tplink.iot.dailysummary.model.b>, Boolean> {
        public static final j a = new j();

        j() {
        }

        /* renamed from: a */
        public final Boolean apply(ArrayList<com.tplink.iot.dailysummary.model.b> arrayList) {
            return Boolean.valueOf(arrayList.size() > 2);
        }
    }

    /* compiled from: DailySummaryViewModel.kt */
    /* loaded from: classes2.dex */
    static final class k<I, O> implements Function<ArrayList<com.tplink.iot.dailysummary.model.b>, Boolean> {
        public static final k a = new k();

        k() {
        }

        /* renamed from: a */
        public final Boolean apply(ArrayList<com.tplink.iot.dailysummary.model.b> arrayList) {
            return Boolean.valueOf(arrayList.size() > 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DailySummaryViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class l implements io.reactivex.g0.a {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SummaryConfig f6430b;

        l(SummaryConfig summaryConfig) {
            this.f6430b = summaryConfig;
        }

        @Override // io.reactivex.g0.a
        public final void run() {
            com.tplink.iot.dailysummary.model.d dVar = (com.tplink.iot.dailysummary.model.d) DailySummaryViewModel.this.u.getValue();
            if (dVar != null) {
                com.tplink.iot.dailysummary.model.d dVar2 = new com.tplink.iot.dailysummary.model.d(dVar.b(), dVar.f(), dVar.e());
                com.tplink.iot.e.a.c.k.s(dVar2);
                DailySummaryViewModel.this.t.setValue(dVar2);
            }
            DailySummaryViewModel.this.j0(true);
            DailySummaryViewModel.this.y.setValue(Boolean.TRUE);
            DailySummaryViewModel.this.p0(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DailySummaryViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class m<T> implements io.reactivex.g0.g<Throwable> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ SummaryConfig f6432d;

        m(SummaryConfig summaryConfig) {
            this.f6432d = summaryConfig;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            b.d.w.c.a.c("tylerTest", "changeSummaryConfig failed: " + th.getMessage());
            DailySummaryViewModel.this.y.setValue(Boolean.FALSE);
        }
    }

    /* compiled from: DailySummaryViewModel.kt */
    /* loaded from: classes2.dex */
    static final class n<I, O> implements Function<ArrayList<com.tplink.iot.dailysummary.model.b>, ArrayList<com.tplink.iot.dailysummary.model.b>> {
        public static final n a = new n();

        n() {
        }

        /* renamed from: a */
        public final ArrayList<com.tplink.iot.dailysummary.model.b> apply(ArrayList<com.tplink.iot.dailysummary.model.b> arrayList) {
            ArrayList<com.tplink.iot.dailysummary.model.b> arrayList2 = new ArrayList<>();
            int i = 1;
            int size = arrayList.size() - 1;
            if (1 <= size) {
                while (true) {
                    if (arrayList2.size() < 2) {
                        arrayList2.add(arrayList.get(i));
                    }
                    if (i == size) {
                        break;
                    }
                    i++;
                }
            }
            return arrayList2;
        }
    }

    /* compiled from: DailySummaryViewModel.kt */
    /* loaded from: classes2.dex */
    static final class o<I, O> implements Function<ArrayList<com.tplink.iot.dailysummary.model.b>, com.tplink.iot.dailysummary.model.b> {
        public static final o a = new o();

        o() {
        }

        /* renamed from: a */
        public final com.tplink.iot.dailysummary.model.b apply(ArrayList<com.tplink.iot.dailysummary.model.b> arrayList) {
            if (arrayList.size() == 0) {
                return null;
            }
            return arrayList.get(0);
        }
    }

    /* compiled from: DailySummaryViewModel.kt */
    /* loaded from: classes2.dex */
    static final class p<I, O> implements Function<ArrayList<com.tplink.iot.dailysummary.model.b>, String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Application f6433b;

        p(Application application) {
            this.f6433b = application;
        }

        /* renamed from: a */
        public final String apply(ArrayList<com.tplink.iot.dailysummary.model.b> arrayList) {
            if (arrayList.size() == 0 || TextUtils.isEmpty(arrayList.get(0).c())) {
                return null;
            }
            if (DailySummaryViewModel.this.U(arrayList.get(0).c())) {
                return this.f6433b.getApplicationContext().getString(R.string.yesterday);
            }
            return arrayList.get(0).c();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DailySummaryViewModel(Application application) {
        super(application);
        kotlin.jvm.internal.j.e(application, "application");
        MutableLiveData<com.tplink.iot.dailysummary.model.d> mutableLiveData = new MutableLiveData<>();
        this.t = mutableLiveData;
        LiveData<com.tplink.iot.dailysummary.model.b> map = Transformations.map(x(), o.a);
        kotlin.jvm.internal.j.d(map, "Transformations.map(mSum…    it[0]\n        }\n    }");
        this.z = map;
        LiveData<String> map2 = Transformations.map(x(), new p(application));
        kotlin.jvm.internal.j.d(map2, "Transformations.map(mSum…        }\n        }\n    }");
        this.A = map2;
        LiveData<ArrayList<com.tplink.iot.dailysummary.model.b>> map3 = Transformations.map(x(), n.a);
        kotlin.jvm.internal.j.d(map3, "Transformations.map(mSum…     }\n        list\n    }");
        this.B = map3;
        LiveData<Boolean> map4 = Transformations.map(map3, i.a);
        kotlin.jvm.internal.j.d(map4, "Transformations.map(summ…        it.size > 0\n    }");
        this.C = map4;
        LiveData<Boolean> map5 = Transformations.map(x(), k.a);
        kotlin.jvm.internal.j.d(map5, "Transformations.map(mSum…        it.size > 0\n    }");
        this.D = map5;
        LiveData<Boolean> map6 = Transformations.map(x(), j.a);
        kotlin.jvm.internal.j.d(map6, "Transformations.map(mSum…        it.size > 2\n    }");
        this.E = map6;
        mutableLiveData.setValue(com.tplink.iot.e.a.c.k.j());
        Calendar instance = Calendar.getInstance();
        TimeZone timeZone = TimeZone.getDefault();
        kotlin.jvm.internal.j.d(timeZone, "TimeZone.getDefault()");
        instance.setTimeZone(TimeZone.getTimeZone(timeZone.getID()));
        instance.setTimeInMillis(System.currentTimeMillis());
        instance.add(5, -1);
        kotlin.p pVar = kotlin.p.a;
        kotlin.jvm.internal.j.d(instance, "Calendar.getInstance().a…Y_OF_MONTH, -1)\n        }");
        this.o = instance;
        Calendar instance2 = Calendar.getInstance();
        TimeZone timeZone2 = TimeZone.getDefault();
        kotlin.jvm.internal.j.d(timeZone2, "TimeZone.getDefault()");
        instance2.setTimeZone(TimeZone.getTimeZone(timeZone2.getID()));
        instance2.setTimeInMillis(System.currentTimeMillis());
        instance2.add(5, -3);
        kotlin.jvm.internal.j.d(instance2, "Calendar.getInstance().a…Y_OF_MONTH, -3)\n        }");
        this.p = instance2;
        this.s = new b.d.w.g.a(application.getApplicationContext(), "DailySummary");
    }

    private final boolean S() {
        com.tplink.iot.dailysummary.model.d value;
        com.tplink.iot.dailysummary.model.d value2 = this.u.getValue();
        if (value2 == null || (value = this.t.getValue()) == null) {
            return false;
        }
        return (value2.e() == value.e() && value2.b() == value.b() && value2.f() == value.f()) ? false : true;
    }

    private final void T(ALCameraDevice aLCameraDevice) {
        String zoneId;
        CameraSettingRepository cameraSettingRepository = (CameraSettingRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(b.d.w.h.a.g(s()), CameraSettingRepository.class);
        String deviceType = aLCameraDevice.getDeviceType();
        if (deviceType != null) {
            b.d.w.g.a aVar = this.s;
            String timeZoneLocal = aVar.f("timeZoneId" + s(), "");
            if (!TextUtils.isEmpty(timeZoneLocal)) {
                String s = s();
                kotlin.jvm.internal.j.d(timeZoneLocal, "timeZoneLocal");
                g0(s, timeZoneLocal, deviceType, false);
                return;
            }
            SettingsData x = cameraSettingRepository.x();
            if (x == null || (zoneId = x.getZoneId()) == null) {
                CommonCameraRepository commonCameraRepository = this.r;
                kotlin.jvm.internal.j.c(commonCameraRepository);
                commonCameraRepository.K0().T0(5L, TimeUnit.SECONDS).N(new b(cameraSettingRepository)).E(new c(deviceType, this, cameraSettingRepository)).C(new d(cameraSettingRepository)).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).F0();
                return;
            }
            g0(s(), zoneId, deviceType, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean U(String str) {
        com.tplink.iot.view.ipcamera.widget.calendar.d a2 = com.tplink.iot.e.a.a.a(str);
        return a2.e() == this.o.get(1) && a2.d() == this.o.get(2) + 1 && a2.c() == this.o.get(5);
    }

    private final void d0(String str) {
        DailySummaryRepository t = t();
        if (t != null) {
            t.K(str).a(new e(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g0(String str, String str2, String str3, boolean z) {
        DailySummaryRepository t;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && (t = t()) != null) {
            t.M(str, str2, str3).F(new f(str, str2, str3, z)).E(new g(str, str2, str3, z)).C(h.f6429c).F0();
        }
    }

    private final void o0(SummaryConfig summaryConfig) {
        DailySummaryRepository t = t();
        if (t != null) {
            t.N(summaryConfig).i(new l(summaryConfig)).j(new m(summaryConfig)).y();
        }
    }

    public final void P(boolean z) {
        com.tplink.iot.dailysummary.model.d value = this.u.getValue();
        if (value != null) {
            value.h(z);
            this.x.setValue(Boolean.valueOf(S()));
            MutableLiveData<com.tplink.iot.dailysummary.model.d> mutableLiveData = this.u;
            mutableLiveData.setValue(mutableLiveData.getValue());
        }
    }

    public final void Q(boolean z) {
        com.tplink.iot.dailysummary.model.d value = this.u.getValue();
        if (value != null) {
            value.i(z);
            this.x.setValue(Boolean.valueOf(S()));
            MutableLiveData<com.tplink.iot.dailysummary.model.d> mutableLiveData = this.u;
            mutableLiveData.setValue(mutableLiveData.getValue());
        }
    }

    public final void R(boolean z) {
        com.tplink.iot.dailysummary.model.d value = this.u.getValue();
        if (value != null) {
            value.j(z);
            this.x.setValue(Boolean.valueOf(S()));
            MutableLiveData<com.tplink.iot.dailysummary.model.d> mutableLiveData = this.u;
            mutableLiveData.setValue(mutableLiveData.getValue());
        }
    }

    public final MutableLiveData<Boolean> V() {
        return this.w;
    }

    public final LiveData<Boolean> W() {
        return this.C;
    }

    public final LiveData<Boolean> X() {
        return this.E;
    }

    public final LiveData<Boolean> Y() {
        return this.D;
    }

    public final MutableLiveData<com.tplink.iot.dailysummary.model.d> Z() {
        return this.t;
    }

    public final MutableLiveData<Boolean> a0() {
        return this.y;
    }

    public final MutableLiveData<Boolean> b0() {
        return this.v;
    }

    public final LiveData<ArrayList<com.tplink.iot.dailysummary.model.b>> c0() {
        return this.B;
    }

    public final MutableLiveData<com.tplink.iot.dailysummary.model.d> e0() {
        return this.u;
    }

    public final MutableLiveData<Boolean> f0() {
        return this.x;
    }

    public final LiveData<com.tplink.iot.dailysummary.model.b> h0() {
        return this.z;
    }

    public final LiveData<String> i0() {
        return this.A;
    }

    public final void j0(boolean z) {
        m0(z);
        l0();
        com.tplink.iot.e.a.c.k.o(false);
    }

    public final void k0() {
        TPCameraDeviceContext b2;
        ALCameraDevice device;
        com.tplink.iot.e.a.c cVar = com.tplink.iot.e.a.c.k;
        F(cVar.b());
        HashMap<String, Boolean> e2 = cVar.e();
        Boolean bool = e2.get(s());
        if (bool != null) {
            r().setValue(bool);
            return;
        }
        CommonCameraRepository commonCameraRepository = (CommonCameraRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(b.d.w.h.a.g(s()), CommonCameraRepository.class);
        this.r = commonCameraRepository;
        if (commonCameraRepository == null || (b2 = commonCameraRepository.b()) == null || (device = b2.getCameraDevice()) == null) {
            MutableLiveData<Boolean> r = r();
            Boolean bool2 = Boolean.FALSE;
            r.setValue(bool2);
            e2.put(s(), bool2);
            return;
        }
        kotlin.jvm.internal.j.d(device, "device");
        T(device);
    }

    public final void l0() {
        d0(s());
    }

    protected void m0(boolean z) {
        if (kotlin.jvm.internal.j.a(r().getValue(), Boolean.TRUE)) {
            D(s(), 0, 3, z);
        } else {
            A(s(), 3, z);
        }
    }

    public final void n0() {
        com.tplink.iot.dailysummary.model.d value = this.u.getValue();
        if (value != null) {
            SummaryConfig summaryConfig = new SummaryConfig();
            summaryConfig.setDeviceId(s());
            summaryConfig.setAuto(value.b());
            summaryConfig.setStrategy(value.f() ? "basic" : "smart");
            summaryConfig.setTimezone(this.q);
            summaryConfig.setNotify(value.e());
            o0(summaryConfig);
        }
    }

    public final void p0(boolean z) {
        if (z) {
            MutableLiveData<com.tplink.iot.dailysummary.model.d> mutableLiveData = this.u;
            com.tplink.iot.dailysummary.model.d value = this.t.getValue();
            mutableLiveData.setValue(value != null ? value.a() : null);
            this.x.setValue(Boolean.FALSE);
        }
        this.v.setValue(Boolean.valueOf(z));
    }
}
