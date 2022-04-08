package com.tplink.iot.dailysummary.viewmodel;

import android.app.Application;
import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.tplink.iot.dailysummary.network.DailySummaryRepository;
import com.tplink.iot.dailysummary.network.bean.common.Summary;
import com.tplink.iot.dailysummary.network.bean.common.SummaryClip;
import com.tplink.iot.dailysummary.network.bean.common.SummaryVideo;
import com.tplink.iot.dailysummary.network.bean.params.CreateSummaryParams;
import com.tplink.iot.dailysummary.network.bean.result.SummaryClipInfoResult;
import com.tplink.iot.dailysummary.network.bean.result.SummaryEventIdResult;
import com.tplink.iot.dailysummary.network.bean.result.SummaryResult;
import com.tplink.libtpcommonstream.stream.control.common.ClientType;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.Utils.d0;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import io.reactivex.q;
import io.reactivex.r;
import io.reactivex.s;
import io.reactivex.v;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.p;
import kotlin.text.y;

/* compiled from: SummaryPlayViewModel.kt */
/* loaded from: classes2.dex */
public final class SummaryPlayViewModel extends BaseSummaryListViewModel {
    public static final a n = new a(null);
    private final LiveData<ArrayList<com.tplink.iot.view.ipcamera.widget.calendar.d>> E;
    private final MutableLiveData<LinkedList<com.tplink.iot.dailysummary.model.c>> P;
    private final MutableLiveData<Long> W;
    private final LiveData<String> X;
    private ALCameraDevice o;
    private com.tplink.iot.h.f p;
    private io.reactivex.e0.c q;
    private int t;
    private long u;
    private final MutableLiveData<com.tplink.iot.dailysummary.model.d> y;
    private String r = "";
    private String s = "";
    private boolean v = true;
    private final com.tplink.iot.dailysummary.model.b w = new com.tplink.iot.dailysummary.model.b("", 100, "", null, 0, false, false, 120, null);
    private final com.tplink.iot.dailysummary.model.b x = new com.tplink.iot.dailysummary.model.b("", -6, "", null, 0, false, false, 120, null);
    private final MutableLiveData<Integer> z = new MutableLiveData<>();
    private final MutableLiveData<List<SummaryClip>> A = new MutableLiveData<>();
    private final MutableLiveData<ArrayList<Long>> B = new MutableLiveData<>();
    private final MutableLiveData<Boolean> C = new MutableLiveData<>();
    private final MutableLiveData<String> D = new MutableLiveData<>();
    private final MutableLiveData<String> F = new MutableLiveData<>();
    private final MutableLiveData<Boolean> G = new MutableLiveData<>();
    private final MutableLiveData<Boolean> H = new MutableLiveData<>();
    private final MutableLiveData<Boolean> I = new MutableLiveData<>();
    private final MutableLiveData<Boolean> J = new MutableLiveData<>();
    private final MutableLiveData<Boolean> K = new MutableLiveData<>();
    private final MutableLiveData<Boolean> L = new MutableLiveData<>();
    private final MutableLiveData<Boolean> M = new MutableLiveData<>();
    private final MutableLiveData<com.tplink.iot.dailysummary.model.b> N = new MutableLiveData<>();
    private final MutableLiveData<SummaryVideo> O = new MutableLiveData<>();
    private final MutableLiveData<Long> Q = new MutableLiveData<>();
    private final MutableLiveData<Boolean> R = new MutableLiveData<>();
    private final MutableLiveData<Boolean> S = new MutableLiveData<>();
    private final MutableLiveData<Boolean> T = new MutableLiveData<>();
    private final MutableLiveData<Boolean> U = new MutableLiveData<>();
    private final MutableLiveData<Long> V = new MutableLiveData<>();
    private final MutableLiveData<Boolean> Y = new MutableLiveData<>();
    private final MutableLiveData<String> Z = new MutableLiveData<>();
    private final MutableLiveData<Integer> a0 = new MutableLiveData<>();

    /* compiled from: SummaryPlayViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: SummaryPlayViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class b implements s<Boolean> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Bitmap f6448b;

        b(Bitmap bitmap) {
            this.f6448b = bitmap;
        }

        @Override // io.reactivex.s
        public void subscribe(r<Boolean> emitter) {
            kotlin.jvm.internal.j.e(emitter, "emitter");
            emitter.onNext(Boolean.valueOf(SummaryPlayViewModel.this.W(this.f6448b)));
            emitter.onComplete();
        }
    }

    /* compiled from: SummaryPlayViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class c implements v<Boolean> {
        c() {
        }

        public void a(boolean z) {
            SummaryPlayViewModel.this.Y.setValue(Boolean.valueOf(z));
        }

        @Override // io.reactivex.v
        public void onComplete() {
        }

        @Override // io.reactivex.v
        public void onError(Throwable e2) {
            kotlin.jvm.internal.j.e(e2, "e");
            b.d.w.c.a.c("PlayViewModel-tyler", "capturePic failed: " + e2.getMessage());
            SummaryPlayViewModel.this.Y.setValue(Boolean.FALSE);
        }

        @Override // io.reactivex.v
        public /* bridge */ /* synthetic */ void onNext(Boolean bool) {
            a(bool.booleanValue());
        }

        @Override // io.reactivex.v
        public void onSubscribe(io.reactivex.e0.c d2) {
            kotlin.jvm.internal.j.e(d2, "d");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SummaryPlayViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class d<T> implements io.reactivex.g0.g<SummaryEventIdResult> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CreateSummaryParams f6450c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f6451d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ SummaryPlayViewModel f6452f;

        d(CreateSummaryParams createSummaryParams, String str, SummaryPlayViewModel summaryPlayViewModel) {
            this.f6450c = createSummaryParams;
            this.f6451d = str;
            this.f6452f = summaryPlayViewModel;
        }

        /* renamed from: a */
        public final void accept(SummaryEventIdResult it) {
            HashMap<String, String> u = this.f6452f.u();
            String str = this.f6451d;
            kotlin.jvm.internal.j.d(it, "it");
            u.put(str, it.getEventId());
            com.tplink.iot.dailysummary.model.b bVar = (com.tplink.iot.dailysummary.model.b) this.f6452f.N.getValue();
            if (bVar != null) {
                bVar.r(1);
            }
            this.f6452f.N.setValue(this.f6452f.N.getValue());
            this.f6452f.j0();
            com.tplink.iot.e.a.c cVar = com.tplink.iot.e.a.c.k;
            cVar.r(true);
            cVar.o(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SummaryPlayViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class e<T> implements io.reactivex.g0.g<Throwable> {

        /* renamed from: c  reason: collision with root package name */
        public static final e f6453c = new e();

        e() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            b.d.w.c.a.c("PlayViewModel-tyler", "create summary failed!\n" + th.getMessage());
        }
    }

    /* compiled from: SummaryPlayViewModel.kt */
    /* loaded from: classes2.dex */
    static final class f<I, O> implements Function<Long, String> {
        public static final f a = new f();

        f() {
        }

        /* renamed from: a */
        public final String apply(Long l) {
            return com.tplink.iot.e.a.e.a.b((int) (l.longValue() / 1000));
        }
    }

    /* compiled from: SummaryPlayViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class g implements com.tplink.iot.h.i.b {
        final /* synthetic */ com.tplink.iot.h.f a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f6454b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f6455c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ SummaryPlayViewModel f6456d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ boolean f6457e;

        g(com.tplink.iot.h.f fVar, String str, String str2, SummaryPlayViewModel summaryPlayViewModel, boolean z) {
            this.a = fVar;
            this.f6454b = str;
            this.f6455c = str2;
            this.f6456d = summaryPlayViewModel;
            this.f6457e = z;
        }

        @Override // com.tplink.iot.h.i.b
        public void a(long j, long j2, int i) {
            com.tplink.iot.h.f fVar = this.f6456d.p;
            if (fVar != null && fVar.E() && j > 0) {
                this.f6456d.a0.setValue(Integer.valueOf(Math.min((int) ((100 * j2) / j), 99)));
            }
        }

        @Override // com.tplink.iot.h.i.b
        public void b(int i, int i2) {
            ALCameraDevice aLCameraDevice = this.f6456d.o;
            if (aLCameraDevice != null) {
                b.d.q.b.p.b.u(aLCameraDevice, String.valueOf(System.currentTimeMillis()), this.a.B(), i2);
                this.f6456d.z.setValue(2);
                if (this.f6457e) {
                    this.f6456d.Z.setValue(this.f6456d.s);
                }
            }
        }

        @Override // com.tplink.iot.h.i.a
        public void onError(Throwable errorMsg) {
            kotlin.jvm.internal.j.e(errorMsg, "errorMsg");
            this.f6456d.z.setValue(3);
        }

        @Override // com.tplink.iot.h.i.a
        public void onStart() {
            this.f6456d.z.setValue(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SummaryPlayViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class h<T> implements io.reactivex.g0.g<SummaryResult> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ DailySummaryRepository f6458c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ SummaryPlayViewModel f6459d;

        h(DailySummaryRepository dailySummaryRepository, SummaryPlayViewModel summaryPlayViewModel) {
            this.f6458c = dailySummaryRepository;
            this.f6459d = summaryPlayViewModel;
        }

        /* renamed from: a */
        public final void accept(SummaryResult it) {
            this.f6459d.R0();
            kotlin.jvm.internal.j.d(it, "it");
            com.tplink.iot.dailysummary.model.b e2 = com.tplink.iot.e.a.a.e(it);
            if (e2 != null) {
                Summary summary = it.getSummaryList().get(0);
                kotlin.jvm.internal.j.d(summary, "it.summaryList[0]");
                SummaryVideo video = summary.getVideo();
                b.d.w.c.a.c("PlayViewModel-tyler", "getSummaryByDate: \nsummaryItem = " + e2 + "\n summaryVideo = " + video);
                if (kotlin.jvm.internal.j.a(this.f6459d.r().getValue(), Boolean.TRUE) || e2.j() == 2) {
                    this.f6459d.N.setValue(e2);
                } else {
                    this.f6459d.N.setValue(this.f6459d.o0());
                }
                this.f6459d.O.setValue(video);
                return;
            }
            this.f6459d.N.setValue(this.f6459d.o0());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SummaryPlayViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class i<T> implements io.reactivex.g0.g<Throwable> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ DailySummaryRepository f6460c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ SummaryPlayViewModel f6461d;

        i(DailySummaryRepository dailySummaryRepository, SummaryPlayViewModel summaryPlayViewModel) {
            this.f6460c = dailySummaryRepository;
            this.f6461d = summaryPlayViewModel;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            this.f6461d.N.setValue(this.f6461d.n0());
            this.f6461d.R0();
            b.d.w.c.a.c("PlayViewModel-tyler", "getSummaryByDate failed: " + th.getMessage());
        }
    }

    /* compiled from: SummaryPlayViewModel.kt */
    /* loaded from: classes2.dex */
    static final class j<T> implements io.reactivex.g0.g<SummaryClipInfoResult> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f6463d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f6464f;
        final /* synthetic */ String q;

        j(String str, String str2, String str3) {
            this.f6463d = str;
            this.f6464f = str2;
            this.q = str3;
        }

        /* renamed from: a */
        public final void accept(SummaryClipInfoResult it) {
            MutableLiveData mutableLiveData = SummaryPlayViewModel.this.A;
            kotlin.jvm.internal.j.d(it, "it");
            mutableLiveData.setValue(it.getClipList());
        }
    }

    /* compiled from: SummaryPlayViewModel.kt */
    /* loaded from: classes2.dex */
    static final class k<T> implements io.reactivex.g0.g<Throwable> {

        /* renamed from: c  reason: collision with root package name */
        public static final k f6465c = new k();

        k() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            b.d.w.c.a.e("tylerTest", "getSummaryClipInfo failed: " + th);
        }
    }

    /* compiled from: SummaryPlayViewModel.kt */
    /* loaded from: classes2.dex */
    static final class l<I, O> implements Function<HashMap<String, Integer>, ArrayList<com.tplink.iot.view.ipcamera.widget.calendar.d>> {
        public static final l a = new l();

        l() {
        }

        /* renamed from: a */
        public final ArrayList<com.tplink.iot.view.ipcamera.widget.calendar.d> apply(HashMap<String, Integer> it) {
            ArrayList<com.tplink.iot.view.ipcamera.widget.calendar.d> arrayList = new ArrayList<>();
            kotlin.jvm.internal.j.d(it, "it");
            for (Map.Entry<String, Integer> entry : it.entrySet()) {
                int intValue = entry.getValue().intValue();
                if (intValue == 2 || intValue == 1 || intValue == 0) {
                    arrayList.add(com.tplink.iot.e.a.a.a(entry.getKey()));
                }
            }
            return arrayList;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SummaryPlayViewModel(Application application) {
        super(application);
        kotlin.jvm.internal.j.e(application, "application");
        MutableLiveData<com.tplink.iot.dailysummary.model.d> mutableLiveData = new MutableLiveData<>();
        this.y = mutableLiveData;
        LiveData<ArrayList<com.tplink.iot.view.ipcamera.widget.calendar.d>> map = Transformations.map(y(), l.a);
        kotlin.jvm.internal.j.d(map, "Transformations.map(mSum…       markDaysList\n    }");
        this.E = map;
        MutableLiveData<LinkedList<com.tplink.iot.dailysummary.model.c>> mutableLiveData2 = new MutableLiveData<>();
        this.P = mutableLiveData2;
        MutableLiveData<Long> mutableLiveData3 = new MutableLiveData<>();
        this.W = mutableLiveData3;
        LiveData<String> map2 = Transformations.map(mutableLiveData3, f.a);
        kotlin.jvm.internal.j.d(map2, "Transformations.map(mDis…it / 1000).toInt())\n    }");
        this.X = map2;
        if (t() == null) {
            G((DailySummaryRepository) b.d.b.f.b.a(b.d.s.a.a.f(), DailySummaryRepository.class));
        }
        mutableLiveData.setValue(com.tplink.iot.e.a.c.k.j());
        mutableLiveData2.setValue(new LinkedList<>());
    }

    private final void P0() {
        com.tplink.iot.e.a.c cVar = com.tplink.iot.e.a.c.k;
        F(cVar.b());
        String g2 = b.d.w.h.a.g(s());
        if (g2 != null && !TextUtils.isEmpty(g2)) {
            TPCameraDeviceContext K1 = TPIoTClientManager.K1(g2);
            kotlin.jvm.internal.j.d(K1, "TPIoTClientManager.getCameraContext(md5String)");
            ALCameraDevice cameraDevice = K1.getCameraDevice();
            if (cameraDevice != null && !d0.a(this.o, cameraDevice)) {
                this.o = cameraDevice;
            }
        }
        MutableLiveData<Boolean> r = r();
        Boolean bool = cVar.e().get(s());
        r.setValue(Boolean.valueOf(bool != null ? bool.booleanValue() : false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R0() {
        this.t = 0;
        this.u = 0L;
        MutableLiveData<Boolean> mutableLiveData = this.R;
        Boolean bool = Boolean.FALSE;
        mutableLiveData.setValue(bool);
        this.S.setValue(bool);
        this.U.setValue(bool);
        this.Q.setValue(0L);
        this.L.setValue(bool);
        this.V.setValue(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean W(Bitmap bitmap) {
        if (bitmap.isRecycled()) {
            return false;
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        StringBuilder sb = new StringBuilder();
        sb.append(b.d.q.b.p.b.h());
        String str = File.separator;
        sb.append(str);
        sb.append("cloudvideo");
        sb.append(str);
        sb.append(valueOf);
        sb.append(".jpg");
        String sb2 = sb.toString();
        b.d.q.b.p.b.u(this.o, valueOf, sb2, -1);
        FileOutputStream fileOutputStream = new FileOutputStream(new File(sb2));
        try {
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                fileOutputStream.close();
                return true;
            } catch (Exception unused) {
                b.d.w.c.a.c("PlayViewModel-tyler", "catch (ignored: Exception)! in " + getClass().getSimpleName());
                fileOutputStream.close();
                return false;
            }
        } catch (Throwable th) {
            fileOutputStream.close();
            throw th;
        }
    }

    private final boolean Z() {
        String value = this.D.getValue();
        if (value == null) {
            return false;
        }
        this.r = "summary_" + s() + '_' + value + ".mp4";
        StringBuilder sb = new StringBuilder();
        sb.append(b.d.q.b.p.b.h());
        String str = File.separator;
        sb.append(str);
        sb.append("cloudvideo");
        sb.append(str);
        sb.append(ClientType.DOWNLOAD);
        sb.append(str);
        sb.append(this.r);
        this.s = sb.toString();
        try {
            return new File(this.s).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    private final void c0() {
        String value = this.D.getValue();
        if (value != null) {
            CreateSummaryParams createSummaryParams = new CreateSummaryParams();
            createSummaryParams.setDate(value);
            createSummaryParams.setDeviceId(s());
            DailySummaryRepository t = t();
            if (t != null) {
                t.E(createSummaryParams).H0(new d(createSummaryParams, value, this), e.f6453c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0() {
        String it;
        DailySummaryRepository t = t();
        if (t != null && (it = this.D.getValue()) != null) {
            io.reactivex.e0.c cVar = this.q;
            if (cVar != null) {
                cVar.dispose();
            }
            String s = s();
            kotlin.jvm.internal.j.d(it, "it");
            this.q = t.I(s, it).H0(new h(t, this), new i(t, this));
        }
    }

    public final MutableLiveData<String> A0() {
        return this.Z;
    }

    public final MutableLiveData<Boolean> B0() {
        return this.G;
    }

    public final MutableLiveData<Boolean> C0() {
        return this.M;
    }

    public final MutableLiveData<Boolean> D0() {
        return this.L;
    }

    public final MutableLiveData<Integer> E0() {
        return this.z;
    }

    public final MutableLiveData<Boolean> F0() {
        return this.C;
    }

    public final MutableLiveData<List<SummaryClip>> G0() {
        return this.A;
    }

    public final MutableLiveData<ArrayList<Long>> H0() {
        return this.B;
    }

    public final MutableLiveData<Long> I0() {
        return this.Q;
    }

    public final MutableLiveData<com.tplink.iot.dailysummary.model.b> J0() {
        return this.N;
    }

    public final LiveData<ArrayList<com.tplink.iot.view.ipcamera.widget.calendar.d>> K0() {
        return this.E;
    }

    public final MutableLiveData<LinkedList<com.tplink.iot.dailysummary.model.c>> L0() {
        return this.P;
    }

    public final MutableLiveData<SummaryVideo> M0() {
        return this.O;
    }

    public final void N0() {
        DailySummaryRepository t;
        String s = s();
        String value = this.D.getValue();
        com.tplink.iot.dailysummary.model.b value2 = this.N.getValue();
        String l2 = value2 != null ? value2.l() : null;
        if (value != null && l2 != null && s.length() != 0 && value.length() != 0 && l2.length() != 0 && (t = t()) != null) {
            t.J(s, value, l2).H0(new j(s, value, l2), k.f6465c);
        }
    }

    public final void O0() {
        P0();
        Q0();
        R0();
        T0();
    }

    public final void Q0() {
        this.z.setValue(0);
        MutableLiveData<Boolean> mutableLiveData = this.G;
        Boolean bool = Boolean.FALSE;
        mutableLiveData.setValue(bool);
        this.K.setValue(bool);
        this.J.setValue(bool);
        this.M.setValue(bool);
        this.V.setValue(0L);
    }

    public final void S0(long j2) {
        b1(j2);
    }

    public final void T0() {
        this.N.setValue(this.w);
        if (this.D.getValue() != null) {
            j0();
        }
    }

    public final void U() {
        com.tplink.iot.h.f fVar = this.p;
        if (fVar != null) {
            fVar.y();
        }
    }

    public final void U0(int i2) {
        if (s().length() == 0) {
            F(com.tplink.iot.e.a.c.k.b());
        }
        if (kotlin.jvm.internal.j.a(r().getValue(), Boolean.TRUE)) {
            while (true) {
                com.tplink.iot.e.a.c cVar = com.tplink.iot.e.a.c.k;
                if (cVar.c() < (i2 / 10) + 6) {
                    BaseSummaryListViewModel.E(this, s(), cVar.a(), 10, false, 8, null);
                } else {
                    return;
                }
            }
        } else if (!com.tplink.iot.e.a.c.k.g()) {
            BaseSummaryListViewModel.B(this, s(), 30, false, 4, null);
        }
    }

    public final void V(Bitmap bitmap) {
        kotlin.jvm.internal.j.e(bitmap, "bitmap");
        q.m(new b(bitmap)).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).a(new c());
    }

    public final void V0() {
        LinkedList<com.tplink.iot.dailysummary.model.c> value = this.P.getValue();
        if (value != null) {
            Iterator<com.tplink.iot.dailysummary.model.c> it = value.iterator();
            while (it.hasNext()) {
                it.next().a().recycle();
            }
            value.clear();
        }
    }

    public final void W0(int i2, long j2, boolean z) {
        this.t = i2;
        this.u = j2;
        this.v = z;
    }

    public final void X() {
        if (kotlin.jvm.internal.j.a(this.R.getValue(), Boolean.TRUE)) {
            boolean z = false;
            Boolean value = this.M.getValue();
            if (value != null) {
                z = !value.booleanValue();
            }
            this.M.setValue(Boolean.valueOf(z));
        }
    }

    public final void X0(boolean z) {
        this.I.setValue(Boolean.valueOf(z));
    }

    public final void Y(boolean z) {
        this.K.setValue(Boolean.valueOf(z));
    }

    public final void Y0(boolean z) {
        this.H.setValue(Boolean.valueOf(z));
    }

    public final void Z0(String str) {
        kotlin.jvm.internal.j.e(str, "str");
        this.F.setValue(str);
    }

    public final void a0() {
        Boolean value = this.L.getValue();
        if (value != null && kotlin.jvm.internal.j.a(this.R.getValue(), Boolean.TRUE)) {
            this.L.setValue(Boolean.valueOf(!value.booleanValue()));
            this.M.setValue(Boolean.valueOf(!value.booleanValue()));
        }
    }

    public final void a1(com.tplink.iot.view.ipcamera.widget.calendar.d oneDayInfo) {
        kotlin.jvm.internal.j.e(oneDayInfo, "oneDayInfo");
        int e2 = oneDayInfo.e();
        int d2 = oneDayInfo.d();
        int c2 = oneDayInfo.c();
        p pVar = p.a;
        String format = String.format("%04d-%02d-%02d", Arrays.copyOf(new Object[]{Integer.valueOf(e2), Integer.valueOf(d2), Integer.valueOf(c2)}, 3));
        kotlin.jvm.internal.j.d(format, "java.lang.String.format(format, *args)");
        this.D.setValue(format);
        T0();
    }

    public final void b0() {
        c0();
    }

    public final void b1(long j2) {
        this.W.setValue(Long.valueOf(j2));
    }

    public final void c1(long j2) {
        this.V.postValue(Long.valueOf(j2));
    }

    public final void d0(boolean z) {
        SummaryVideo it = this.O.getValue();
        if (it == null) {
            return;
        }
        if (!Z()) {
            kotlin.jvm.internal.j.d(it, "it");
            String a2 = b.d.w.h.a.a(it.getM3u8());
            String uri = it.getUri();
            com.tplink.iot.h.f fVar = new com.tplink.iot.h.f("1000");
            fVar.z(this.r, a2, uri, new g(fVar, a2, uri, this, z));
            kotlin.p pVar = kotlin.p.a;
            this.p = fVar;
        } else if (z) {
            this.Z.setValue(this.s);
        } else {
            this.z.setValue(4);
        }
    }

    public final void d1(int i2) {
        this.t = i2;
    }

    public final MutableLiveData<Boolean> e0() {
        return this.I;
    }

    public final void e1(boolean z) {
        com.tplink.iot.dailysummary.model.b value;
        this.U.setValue(Boolean.valueOf(z && (value = this.N.getValue()) != null && value.j() == 2));
    }

    public final MutableLiveData<Boolean> f0() {
        return this.H;
    }

    public final void f1(boolean z) {
        this.S.setValue(Boolean.valueOf(z));
        if (z) {
            g1(false);
            this.U.setValue(Boolean.FALSE);
        }
    }

    public final MutableLiveData<String> g0() {
        return this.F;
    }

    public final void g1(boolean z) {
        this.R.setValue(Boolean.valueOf(z));
        if (z) {
            MutableLiveData<Boolean> mutableLiveData = this.M;
            Boolean bool = Boolean.TRUE;
            mutableLiveData.setValue(bool);
            this.L.setValue(bool);
        }
    }

    public final MutableLiveData<Boolean> h0() {
        return this.Y;
    }

    public final void h1(long j2) {
        this.u = j2;
    }

    public final MutableLiveData<String> i0() {
        return this.D;
    }

    public final void i1(boolean z) {
        this.T.postValue(Boolean.valueOf(z));
    }

    public final void j1(boolean z) {
        MutableLiveData<String> mutableLiveData = this.F;
        String value = this.D.getValue();
        mutableLiveData.setValue(value != null ? y.v0(value, 3) : null);
        this.G.setValue(Boolean.valueOf(z));
    }

    public final MutableLiveData<Long> k0() {
        return this.W;
    }

    public final void k1(int i2) {
        this.z.postValue(Integer.valueOf(i2));
        if (i2 == 5) {
            MutableLiveData<Boolean> mutableLiveData = this.J;
            Boolean bool = Boolean.FALSE;
            mutableLiveData.postValue(bool);
            this.C.postValue(bool);
        } else if (i2 == 6) {
            this.J.postValue(Boolean.TRUE);
        }
    }

    public final LiveData<String> l0() {
        return this.X;
    }

    public final void l1(boolean z) {
        this.C.setValue(Boolean.valueOf(z));
    }

    public final MutableLiveData<Integer> m0() {
        return this.a0;
    }

    public final void m1(ArrayList<Long> splitPointList) {
        kotlin.jvm.internal.j.e(splitPointList, "splitPointList");
        this.B.setValue(splitPointList);
    }

    public final com.tplink.iot.dailysummary.model.b n0() {
        return this.w;
    }

    public final void n1(long j2) {
        this.Q.setValue(Long.valueOf(j2));
    }

    public final com.tplink.iot.dailysummary.model.b o0() {
        return this.x;
    }

    public final void o1(LinkedList<com.tplink.iot.dailysummary.model.c> thumbnailList) {
        kotlin.jvm.internal.j.e(thumbnailList, "thumbnailList");
        this.P.setValue(thumbnailList);
    }

    public final MutableLiveData<com.tplink.iot.dailysummary.model.d> p0() {
        return this.y;
    }

    public final MutableLiveData<Long> q0() {
        return this.V;
    }

    public final int r0() {
        return this.t;
    }

    public final MutableLiveData<Boolean> s0() {
        return this.U;
    }

    public final MutableLiveData<Boolean> t0() {
        return this.K;
    }

    public final MutableLiveData<Boolean> u0() {
        return this.J;
    }

    public final MutableLiveData<Boolean> v0() {
        return this.S;
    }

    public final boolean w0() {
        return this.v;
    }

    public final MutableLiveData<Boolean> x0() {
        return this.R;
    }

    public final long y0() {
        return this.u;
    }

    public final MutableLiveData<Boolean> z0() {
        return this.T;
    }
}
