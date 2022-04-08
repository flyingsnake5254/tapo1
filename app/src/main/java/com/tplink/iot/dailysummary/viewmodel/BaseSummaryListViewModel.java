package com.tplink.iot.dailysummary.viewmodel;

import android.app.Application;
import android.text.TextUtils;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.dailysummary.network.DailySummaryRepository;
import com.tplink.iot.dailysummary.network.bean.common.Summary;
import com.tplink.iot.dailysummary.network.bean.params.CancelCreateSummaryParams;
import com.tplink.iot.dailysummary.network.bean.params.CreateSummaryParams;
import com.tplink.iot.dailysummary.network.bean.result.RecentSummaryListResult;
import com.tplink.iot.dailysummary.network.bean.result.SummaryEventIdResult;
import com.tplink.iot.dailysummary.network.bean.result.SummaryListResult;
import com.tplink.iot.dailysummary.network.bean.result.SummaryResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: BaseSummaryListViewModel.kt */
/* loaded from: classes2.dex */
public abstract class BaseSummaryListViewModel extends AndroidViewModel {
    public static final a a = new a(null);

    /* renamed from: c  reason: collision with root package name */
    private DailySummaryRepository f6374c;

    /* renamed from: d  reason: collision with root package name */
    private final HashMap<String, String> f6375d;

    /* renamed from: e  reason: collision with root package name */
    private int f6376e;
    private final MutableLiveData<HashMap<String, Integer>> g;

    /* renamed from: b  reason: collision with root package name */
    private String f6373b = "";

    /* renamed from: f  reason: collision with root package name */
    private final MutableLiveData<Boolean> f6377f = new MutableLiveData<>();
    private final MutableLiveData<ArrayList<com.tplink.iot.dailysummary.model.b>> h = new MutableLiveData<>();
    private final MutableLiveData<Boolean> i = new MutableLiveData<>();
    private final MutableLiveData<Boolean> j = new MutableLiveData<>();
    private final MutableLiveData<Boolean> k = new MutableLiveData<>();
    private final MutableLiveData<Boolean> l = new MutableLiveData<>();
    private final MutableLiveData<Boolean> m = new MutableLiveData<>();

    /* compiled from: BaseSummaryListViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BaseSummaryListViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class b<T> implements io.reactivex.g0.g<SummaryEventIdResult> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ CancelCreateSummaryParams f6379d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f6380f;
        final /* synthetic */ String q;

        b(CancelCreateSummaryParams cancelCreateSummaryParams, int i, String str) {
            this.f6379d = cancelCreateSummaryParams;
            this.f6380f = i;
            this.q = str;
        }

        /* renamed from: a */
        public final void accept(SummaryEventIdResult summaryEventIdResult) {
            b.d.w.c.a.c("tylerTest", "cancel create success!");
            ArrayList<com.tplink.iot.dailysummary.model.b> value = BaseSummaryListViewModel.this.x().getValue();
            if (value != null) {
                value.get(this.f6380f).r(0);
            }
            BaseSummaryListViewModel.this.x().setValue(BaseSummaryListViewModel.this.x().getValue());
            if (BaseSummaryListViewModel.this.u().containsKey(this.q)) {
                BaseSummaryListViewModel.this.u().remove(this.q);
            }
            BaseSummaryListViewModel.this.l.setValue(Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BaseSummaryListViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class c<T> implements io.reactivex.g0.g<Throwable> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ CancelCreateSummaryParams f6382d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f6383f;
        final /* synthetic */ String q;

        c(CancelCreateSummaryParams cancelCreateSummaryParams, int i, String str) {
            this.f6382d = cancelCreateSummaryParams;
            this.f6383f = i;
            this.q = str;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            b.d.w.c.a.c("tylerTest", "cancel create summary failed!");
            BaseSummaryListViewModel.this.l.setValue(Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BaseSummaryListViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class d<T> implements io.reactivex.g0.g<SummaryEventIdResult> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ CreateSummaryParams f6385d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f6386f;
        final /* synthetic */ String q;

        d(CreateSummaryParams createSummaryParams, int i, String str) {
            this.f6385d = createSummaryParams;
            this.f6386f = i;
            this.q = str;
        }

        /* renamed from: a */
        public final void accept(SummaryEventIdResult it) {
            ArrayList<com.tplink.iot.dailysummary.model.b> value = BaseSummaryListViewModel.this.x().getValue();
            if (value != null) {
                value.get(this.f6386f).r(1);
            }
            BaseSummaryListViewModel.this.x().setValue(BaseSummaryListViewModel.this.x().getValue());
            BaseSummaryListViewModel.this.k.setValue(Boolean.TRUE);
            HashMap<String, String> u = BaseSummaryListViewModel.this.u();
            String str = this.q;
            kotlin.jvm.internal.j.d(it, "it");
            u.put(str, it.getEventId());
            com.tplink.iot.e.a.c.k.o(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BaseSummaryListViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class e<T> implements io.reactivex.g0.g<Throwable> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ CreateSummaryParams f6388d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f6389f;
        final /* synthetic */ String q;

        e(CreateSummaryParams createSummaryParams, int i, String str) {
            this.f6388d = createSummaryParams;
            this.f6389f = i;
            this.q = str;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            b.d.w.c.a.c("BaseSLViewModel-tyler", "create summary failed!");
            BaseSummaryListViewModel.this.k.setValue(Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BaseSummaryListViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class f<T> implements io.reactivex.g0.g<SummaryListResult> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f6391d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f6392f;

        f(String str, int i) {
            this.f6391d = str;
            this.f6392f = i;
        }

        /* renamed from: a */
        public final void accept(SummaryListResult it) {
            kotlin.jvm.internal.j.d(it, "it");
            List<SummaryResult> dateList = it.getDateList();
            ArrayList<com.tplink.iot.dailysummary.model.b> value = BaseSummaryListViewModel.this.x().getValue();
            if (value == null) {
                value = new ArrayList<>();
            }
            int size = dateList.size() - 1;
            if (size >= 0) {
                int i = 0;
                while (true) {
                    SummaryResult summaryResult = dateList.get(i);
                    kotlin.jvm.internal.j.d(summaryResult, "summaryResult");
                    com.tplink.iot.dailysummary.model.b e2 = com.tplink.iot.e.a.a.e(summaryResult);
                    if (e2 != null) {
                        int j = e2.j();
                        if (j == 2 || j == 1 || j == 0) {
                            com.tplink.iot.e.a.c cVar = com.tplink.iot.e.a.c.k;
                            cVar.k().put(e2.c(), Integer.valueOf(j));
                            BaseSummaryListViewModel.this.y().setValue(cVar.k());
                        }
                        value.add(e2);
                        Summary summary = summaryResult.getSummaryList().get(0);
                        kotlin.jvm.internal.j.d(summary, "summaryResult.summaryList[0]");
                        String eventId = summary.getEventId();
                        if (eventId != null) {
                            BaseSummaryListViewModel.this.u().put(e2.c(), eventId);
                        }
                    }
                    if (i == size) {
                        break;
                    }
                    i++;
                }
            }
            BaseSummaryListViewModel.this.f6376e++;
            com.tplink.iot.e.a.c cVar2 = com.tplink.iot.e.a.c.k;
            if (cVar2.c() < BaseSummaryListViewModel.this.f6376e) {
                cVar2.n(BaseSummaryListViewModel.this.f6376e);
            }
            BaseSummaryListViewModel.this.x().setValue(value);
            BaseSummaryListViewModel.this.v().setValue(Boolean.TRUE);
            BaseSummaryListViewModel.this.w().postValue(Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BaseSummaryListViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class g<T> implements io.reactivex.g0.g<Throwable> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f6394d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f6395f;

        g(String str, int i) {
            this.f6394d = str;
            this.f6395f = i;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            b.d.w.c.a.c("tylerTest", BaseSummaryListViewModel.this.getClass().getSimpleName() + " getSummaryList failed!\n" + th.getMessage());
            MutableLiveData<Boolean> w = BaseSummaryListViewModel.this.w();
            Boolean bool = Boolean.FALSE;
            w.postValue(bool);
            if (!"parameter errror".equals(th.getMessage()) && !"Index: 0".equals(th.getMessage())) {
                BaseSummaryListViewModel.this.v().setValue(bool);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BaseSummaryListViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class h<T> implements io.reactivex.g0.g<io.reactivex.e0.c> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f6397d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f6398f;
        final /* synthetic */ boolean q;

        h(String str, int i, boolean z) {
            this.f6397d = str;
            this.f6398f = i;
            this.q = z;
        }

        /* renamed from: a */
        public final void accept(io.reactivex.e0.c cVar) {
            BaseSummaryListViewModel.this.w().postValue(Boolean.valueOf(this.q));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BaseSummaryListViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class i<T> implements io.reactivex.g0.g<RecentSummaryListResult> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f6400d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f6401f;
        final /* synthetic */ boolean q;

        i(String str, int i, boolean z) {
            this.f6400d = str;
            this.f6401f = i;
            this.q = z;
        }

        /* renamed from: a */
        public final void accept(RecentSummaryListResult it) {
            kotlin.jvm.internal.j.d(it, "it");
            List<SummaryResult> dateList = it.getDateList();
            if ((dateList != null ? dateList.size() : 0) > 0) {
                ArrayList<com.tplink.iot.dailysummary.model.b> arrayList = new ArrayList<>();
                int size = dateList.size() - 1;
                if (size >= 0) {
                    int i = 0;
                    while (true) {
                        SummaryResult summryResult = dateList.get(i);
                        kotlin.jvm.internal.j.d(summryResult, "summryResult");
                        com.tplink.iot.dailysummary.model.b e2 = com.tplink.iot.e.a.a.e(summryResult);
                        if (e2 != null) {
                            int j = e2.j();
                            if (j == 2) {
                                com.tplink.iot.e.a.c cVar = com.tplink.iot.e.a.c.k;
                                cVar.k().put(e2.c(), Integer.valueOf(j));
                                BaseSummaryListViewModel.this.y().setValue(cVar.k());
                            }
                            arrayList.add(e2);
                            Summary summary = summryResult.getSummaryList().get(0);
                            kotlin.jvm.internal.j.d(summary, "summryResult.summaryList[0]");
                            String eventId = summary.getEventId();
                            if (eventId != null) {
                                BaseSummaryListViewModel.this.u().put(e2.c(), eventId);
                            }
                        }
                        if (i == size) {
                            break;
                        }
                        i++;
                    }
                }
                BaseSummaryListViewModel.this.x().setValue(arrayList);
                if (this.f6401f == 30) {
                    com.tplink.iot.e.a.c.k.p(true);
                }
            }
            BaseSummaryListViewModel.this.v().setValue(Boolean.TRUE);
            BaseSummaryListViewModel.this.w().postValue(Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BaseSummaryListViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class j<T> implements io.reactivex.g0.g<Throwable> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f6403d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f6404f;
        final /* synthetic */ boolean q;

        j(String str, int i, boolean z) {
            this.f6403d = str;
            this.f6404f = i;
            this.q = z;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            b.d.w.c.a.c("BaseSLViewModel-tyler", "getRecentSummaryList failed: \n" + th.getMessage());
            MutableLiveData<Boolean> w = BaseSummaryListViewModel.this.w();
            Boolean bool = Boolean.FALSE;
            w.postValue(bool);
            BaseSummaryListViewModel.this.v().setValue(bool);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BaseSummaryListViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class k<T> implements io.reactivex.g0.g<io.reactivex.e0.c> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f6406d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f6407f;
        final /* synthetic */ int q;
        final /* synthetic */ boolean x;

        k(String str, int i, int i2, boolean z) {
            this.f6406d = str;
            this.f6407f = i;
            this.q = i2;
            this.x = z;
        }

        /* renamed from: a */
        public final void accept(io.reactivex.e0.c cVar) {
            BaseSummaryListViewModel.this.w().postValue(Boolean.valueOf(this.x));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BaseSummaryListViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class l<T> implements io.reactivex.g0.g<SummaryListResult> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f6409d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f6410f;
        final /* synthetic */ int q;
        final /* synthetic */ boolean x;

        l(String str, int i, int i2, boolean z) {
            this.f6409d = str;
            this.f6410f = i;
            this.q = i2;
            this.x = z;
        }

        /* renamed from: a */
        public final void accept(SummaryListResult it) {
            kotlin.jvm.internal.j.d(it, "it");
            List<SummaryResult> dateList = it.getDateList();
            ArrayList<com.tplink.iot.dailysummary.model.b> arrayList = new ArrayList<>();
            int size = dateList.size() - 1;
            if (size >= 0) {
                int i = 0;
                while (true) {
                    SummaryResult summryResult = dateList.get(i);
                    kotlin.jvm.internal.j.d(summryResult, "summryResult");
                    com.tplink.iot.dailysummary.model.b e2 = com.tplink.iot.e.a.a.e(summryResult);
                    if (e2 != null) {
                        int j = e2.j();
                        if (j == 2 || j == 1 || j == 0) {
                            com.tplink.iot.e.a.c cVar = com.tplink.iot.e.a.c.k;
                            cVar.k().put(e2.c(), Integer.valueOf(j));
                            BaseSummaryListViewModel.this.y().setValue(cVar.k());
                        }
                        arrayList.add(e2);
                        Summary summary = summryResult.getSummaryList().get(0);
                        kotlin.jvm.internal.j.d(summary, "summryResult.summaryList[0]");
                        String eventId = summary.getEventId();
                        if (eventId != null) {
                            BaseSummaryListViewModel.this.u().put(e2.c(), eventId);
                        }
                    }
                    if (i == size) {
                        break;
                    }
                    i++;
                }
            }
            if (this.f6410f == 0 && this.q == 10) {
                BaseSummaryListViewModel.this.f6376e = 1;
                com.tplink.iot.e.a.c cVar2 = com.tplink.iot.e.a.c.k;
                if (cVar2.c() < BaseSummaryListViewModel.this.f6376e) {
                    cVar2.n(BaseSummaryListViewModel.this.f6376e);
                }
            }
            int size2 = arrayList.size();
            int i2 = this.q;
            if (size2 < (this.f6410f + 1) * i2) {
                BaseSummaryListViewModel.this.z(this.f6409d, i2);
            }
            BaseSummaryListViewModel.this.x().setValue(arrayList);
            BaseSummaryListViewModel.this.v().setValue(Boolean.TRUE);
            BaseSummaryListViewModel.this.w().postValue(Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BaseSummaryListViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class m<T> implements io.reactivex.g0.g<Throwable> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f6412d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f6413f;
        final /* synthetic */ int q;
        final /* synthetic */ boolean x;

        m(String str, int i, int i2, boolean z) {
            this.f6412d = str;
            this.f6413f = i;
            this.q = i2;
            this.x = z;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            b.d.w.c.a.c("BaseSLViewModel-tyler", "getSummaryList failed: \n" + th.getMessage());
            MutableLiveData<Boolean> w = BaseSummaryListViewModel.this.w();
            Boolean bool = Boolean.FALSE;
            w.postValue(bool);
            if (!"parameter errror".equals(th.getMessage()) && !"Index: 0".equals(th.getMessage())) {
                BaseSummaryListViewModel.this.v().setValue(bool);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseSummaryListViewModel(Application application) {
        super(application);
        kotlin.jvm.internal.j.e(application, "application");
        MutableLiveData<HashMap<String, Integer>> mutableLiveData = new MutableLiveData<>();
        this.g = mutableLiveData;
        if (this.f6374c == null) {
            this.f6374c = (DailySummaryRepository) b.d.b.f.b.a(b.d.s.a.a.f(), DailySummaryRepository.class);
        }
        com.tplink.iot.e.a.c cVar = com.tplink.iot.e.a.c.k;
        this.f6375d = cVar.f();
        mutableLiveData.setValue(cVar.k());
    }

    public static /* synthetic */ void B(BaseSummaryListViewModel baseSummaryListViewModel, String str, int i2, boolean z, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                z = false;
            }
            baseSummaryListViewModel.A(str, i2, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getRecentSummaryList");
    }

    public static /* synthetic */ void E(BaseSummaryListViewModel baseSummaryListViewModel, String str, int i2, int i3, boolean z, int i4, Object obj) {
        if (obj == null) {
            if ((i4 & 8) != 0) {
                z = false;
            }
            baseSummaryListViewModel.D(str, i2, i3, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSummaryList");
    }

    private final void j(CancelCreateSummaryParams cancelCreateSummaryParams, String str, int i2) {
        DailySummaryRepository dailySummaryRepository;
        ArrayList<com.tplink.iot.dailysummary.model.b> value = this.h.getValue();
        if ((value != null ? value.size() : 0) > i2 && (dailySummaryRepository = this.f6374c) != null) {
            dailySummaryRepository.C(cancelCreateSummaryParams).H0(new b(cancelCreateSummaryParams, i2, str), new c(cancelCreateSummaryParams, i2, str));
        }
    }

    private final void l(CreateSummaryParams createSummaryParams, String str, int i2) {
        DailySummaryRepository dailySummaryRepository;
        ArrayList<com.tplink.iot.dailysummary.model.b> value = this.h.getValue();
        if ((value != null ? value.size() : 0) > i2 && (dailySummaryRepository = this.f6374c) != null) {
            dailySummaryRepository.E(createSummaryParams).E(new d(createSummaryParams, i2, str)).C(new e(createSummaryParams, i2, str)).F0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void A(String deviceId, int i2, boolean z) {
        DailySummaryRepository dailySummaryRepository;
        kotlin.jvm.internal.j.e(deviceId, "deviceId");
        if (!TextUtils.isEmpty(deviceId) && (dailySummaryRepository = this.f6374c) != null) {
            dailySummaryRepository.H(deviceId, i2).F(new h(deviceId, i2, z)).H0(new i(deviceId, i2, z), new j(deviceId, i2, z));
        }
    }

    public final MutableLiveData<ArrayList<com.tplink.iot.dailysummary.model.b>> C() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void D(String deviceId, int i2, int i3, boolean z) {
        DailySummaryRepository dailySummaryRepository;
        kotlin.jvm.internal.j.e(deviceId, "deviceId");
        if (deviceId.length() != 0 && (dailySummaryRepository = this.f6374c) != null) {
            dailySummaryRepository.L(deviceId, i2, i3).F(new k(deviceId, i2, i3, z)).H0(new l(deviceId, i2, i3, z), new m(deviceId, i2, i3, z));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void F(String str) {
        kotlin.jvm.internal.j.e(str, "<set-?>");
        this.f6373b = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void G(DailySummaryRepository dailySummaryRepository) {
        this.f6374c = dailySummaryRepository;
    }

    public final void k(int i2, int i3) {
        ArrayList<com.tplink.iot.dailysummary.model.b> value;
        ArrayList<com.tplink.iot.dailysummary.model.b> value2 = this.h.getValue();
        if ((value2 != null ? value2.size() : 0) > i2) {
            if (i3 == 0) {
                ArrayList<com.tplink.iot.dailysummary.model.b> value3 = this.h.getValue();
                if (value3 != null) {
                    String c2 = value3.get(i2).c();
                    CancelCreateSummaryParams cancelCreateSummaryParams = new CancelCreateSummaryParams();
                    cancelCreateSummaryParams.setDeviceId(this.f6373b);
                    if (this.f6375d.containsKey(c2)) {
                        cancelCreateSummaryParams.setEventId(this.f6375d.get(c2));
                    }
                    j(cancelCreateSummaryParams, c2, i2);
                }
            } else if (i3 == 1 && (value = this.h.getValue()) != null) {
                String c3 = value.get(i2).c();
                CreateSummaryParams createSummaryParams = new CreateSummaryParams();
                createSummaryParams.setDeviceId(this.f6373b);
                createSummaryParams.setDate(c3);
                l(createSummaryParams, c3, i2);
            }
        }
    }

    public final MutableLiveData<Boolean> m() {
        return this.k;
    }

    public final MutableLiveData<Boolean> n() {
        return this.f6377f;
    }

    public final MutableLiveData<Boolean> o() {
        return this.i;
    }

    public final MutableLiveData<Boolean> p() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MutableLiveData<Boolean> r() {
        return this.f6377f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String s() {
        return this.f6373b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final DailySummaryRepository t() {
        return this.f6374c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final HashMap<String, String> u() {
        return this.f6375d;
    }

    protected final MutableLiveData<Boolean> v() {
        return this.i;
    }

    protected final MutableLiveData<Boolean> w() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MutableLiveData<ArrayList<com.tplink.iot.dailysummary.model.b>> x() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MutableLiveData<HashMap<String, Integer>> y() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void z(String deviceId, int i2) {
        kotlin.jvm.internal.j.e(deviceId, "deviceId");
        DailySummaryRepository dailySummaryRepository = this.f6374c;
        if (dailySummaryRepository != null) {
            dailySummaryRepository.L(deviceId, this.f6376e, i2).H0(new f(deviceId, i2), new g(deviceId, i2));
        }
    }
}
