package com.tplink.libtpnetwork.IoTNetwork.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.iot.cloud.bean.thing.common.ThingEventLog;
import com.tplink.iot.cloud.bean.thing.result.ThingEventLogResult;
import com.tplink.libtpmediastatistics.SSLClient;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository;
import com.tplink.libtpnetwork.Utils.i;
import io.reactivex.g0.g;
import io.reactivex.g0.j;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.n;
import kotlin.collections.v;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;

/* compiled from: ThingEventLogRepository.kt */
/* loaded from: classes3.dex */
public final class ThingEventLogRepository extends ThingBaseRepository {
    public static final a p = new a(null);
    private String q = "default_thing_event_log_list";
    private int r = 10;
    private final MutableLiveData<List<ThingEventLog>> s;
    private boolean t;
    private final MutableLiveData<Boolean> u;
    private final LiveData<List<ThingEventLog>> v;
    private final LiveData<Boolean> w;

    /* compiled from: ThingEventLogRepository.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ThingEventLogRepository.kt */
    /* loaded from: classes3.dex */
    public static final class b<T, R> implements j<ThingEventLogResult, List<? extends ThingEventLog>> {

        /* renamed from: c  reason: collision with root package name */
        public static final b f13145c = new b();

        b() {
        }

        /* renamed from: a */
        public final List<ThingEventLog> apply(ThingEventLogResult result) {
            List<ThingEventLog> d2;
            kotlin.jvm.internal.j.e(result, "result");
            List<ThingEventLog> events = result.getEvents();
            if (events != null) {
                return events;
            }
            d2 = n.d();
            return d2;
        }
    }

    /* compiled from: ThingEventLogRepository.kt */
    /* loaded from: classes3.dex */
    static final class c<T> implements g<List<? extends ThingEventLog>> {
        c() {
        }

        /* renamed from: a */
        public final void accept(List<? extends ThingEventLog> it) {
            ThingEventLogRepository thingEventLogRepository = ThingEventLogRepository.this;
            kotlin.jvm.internal.j.d(it, "it");
            thingEventLogRepository.X0(it, false);
        }
    }

    /* compiled from: ThingEventLogRepository.kt */
    /* loaded from: classes3.dex */
    static final class d<T> implements g<List<? extends ThingEventLog>> {
        d() {
        }

        /* renamed from: a */
        public final void accept(List<? extends ThingEventLog> it) {
            ThingEventLogRepository thingEventLogRepository = ThingEventLogRepository.this;
            kotlin.jvm.internal.j.d(it, "it");
            thingEventLogRepository.X0(it, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ThingEventLogRepository.kt */
    /* loaded from: classes3.dex */
    public static final class e extends Lambda implements l<ThingEventLog, Boolean> {

        /* renamed from: c  reason: collision with root package name */
        public static final e f13148c = new e();

        e() {
            super(1);
        }

        public final boolean a(ThingEventLog it) {
            kotlin.jvm.internal.j.e(it, "it");
            String eventId = it.getEventId();
            return eventId == null || eventId.length() == 0;
        }

        @Override // kotlin.jvm.b.l
        public /* bridge */ /* synthetic */ Boolean invoke(ThingEventLog thingEventLog) {
            return Boolean.valueOf(a(thingEventLog));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ThingEventLogRepository.kt */
    /* loaded from: classes3.dex */
    public static final class f extends Lambda implements l<ThingEventLog, String> {

        /* renamed from: c  reason: collision with root package name */
        public static final f f13149c = new f();

        f() {
            super(1);
        }

        /* renamed from: a */
        public final String invoke(ThingEventLog it) {
            kotlin.jvm.internal.j.e(it, "it");
            return it.getEventId();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThingEventLogRepository(ThingContext thingContext) {
        super(thingContext);
        kotlin.jvm.internal.j.e(thingContext, "thingContext");
        MutableLiveData<List<ThingEventLog>> mutableLiveData = new MutableLiveData<>();
        this.s = mutableLiveData;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>(Boolean.valueOf(this.t));
        this.u = mutableLiveData2;
        this.v = mutableLiveData;
        this.w = mutableLiveData2;
    }

    private final String O0(List<? extends ThingEventLog> list, Long l) {
        if (list.isEmpty() || l == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder("");
        for (int size = list.size() - 1; size >= 0 && ((ThingEventLog) list.get(size)).getTimestamp() == l.longValue(); size--) {
            if (sb.length() > 0) {
                sb.append(SSLClient.COMMA);
            }
            sb.append(((ThingEventLog) list.get(size)).getEventId());
        }
        String sb2 = sb.toString();
        kotlin.jvm.internal.j.d(sb2, "ids.toString()");
        return sb2;
    }

    private final q<List<ThingEventLog>> R0(Long l, Long l2, int i, String str, String str2) {
        ThingCloudRepository thingCloudRepository = this.f13137d;
        T mThingContext = this.a;
        kotlin.jvm.internal.j.d(mThingContext, "mThingContext");
        String thingUrl = ((ThingContext) mThingContext).getThingUrl();
        T mThingContext2 = this.a;
        kotlin.jvm.internal.j.d(mThingContext2, "mThingContext");
        q g0 = thingCloudRepository.h0(thingUrl, ((ThingContext) mThingContext2).getThingName(), l, l2, i, str, str2).g0(b.f13145c);
        kotlin.jvm.internal.j.d(g0, "mThingCloudRepository.ge…emptyList()\n            }");
        return g0;
    }

    static /* synthetic */ q S0(ThingEventLogRepository thingEventLogRepository, Long l, Long l2, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            l = null;
        }
        if ((i2 & 2) != 0) {
            l2 = null;
        }
        if ((i2 & 4) != 0) {
            i = thingEventLogRepository.r;
        }
        if ((i2 & 8) != 0) {
            str = null;
        }
        if ((i2 & 16) != 0) {
            str2 = "DESC";
        }
        return thingEventLogRepository.R0(l, l2, i, str, str2);
    }

    private final q<List<ThingEventLog>> V0() {
        List<ThingEventLog> b1 = b1();
        ThingEventLog thingEventLog = (ThingEventLog) kotlin.collections.l.G(b1);
        Long valueOf = thingEventLog != null ? Long.valueOf(thingEventLog.getTimestamp()) : null;
        String O0 = O0(b1, valueOf);
        b.d.w.c.a.n("ThingEventLog", "FilterIds: " + O0);
        return S0(this, null, valueOf, 0, O0, null, 21, null);
    }

    private final void W0(boolean z) {
        this.t = z;
        this.u.postValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void X0(List<? extends ThingEventLog> list, boolean z) {
        List list2;
        List U;
        boolean z2 = !list.isEmpty();
        if (z) {
            list2 = v.U(list);
        } else {
            U = v.U(b1());
            U.addAll(list);
            list2 = U;
        }
        a1(list2);
        c1(list2);
        this.s.postValue(list2);
        W0(z2);
    }

    private final q<List<ThingEventLog>> Z0() {
        return S0(this, null, null, 0, null, null, 31, null);
    }

    private final void a1(List<ThingEventLog> list) {
        kotlin.sequences.f t;
        kotlin.sequences.f f2;
        kotlin.sequences.f e2;
        List i;
        t = v.t(list);
        f2 = kotlin.sequences.l.f(t, e.f13148c);
        e2 = kotlin.sequences.l.e(f2, f.f13149c);
        i = kotlin.sequences.l.i(e2);
        list.clear();
        list.addAll(i);
    }

    private final List<ThingEventLog> b1() {
        com.tplink.cloud.context.b f2 = b.d.s.a.a.f();
        kotlin.jvm.internal.j.d(f2, "TPAppCloudContext.getCurrentAccountContext()");
        TCAccountBean c2 = f2.c();
        kotlin.jvm.internal.j.d(c2, "TPAppCloudContext.getCur…tAccountContext().account");
        String g = b.d.w.h.a.g(c2.getCloudUserName());
        String str = this.q;
        T mThingContext = this.a;
        kotlin.jvm.internal.j.d(mThingContext, "mThingContext");
        List<ThingEventLog> c3 = b.d.w.d.a.c(g, str, ((ThingContext) mThingContext).getDeviceIdMD5(), ThingEventLog.class);
        if (c3 == null) {
            c3 = new ArrayList<>();
        }
        b.d.w.c.a.n("ThingEventLog", "restore: " + i.f(c3));
        a1(c3);
        return c3;
    }

    private final void c1(List<? extends ThingEventLog> list) {
        b.d.w.c.a.n("ThingEventLog", "save: " + i.f(list));
        com.tplink.cloud.context.b f2 = b.d.s.a.a.f();
        kotlin.jvm.internal.j.d(f2, "TPAppCloudContext.getCurrentAccountContext()");
        TCAccountBean c2 = f2.c();
        kotlin.jvm.internal.j.d(c2, "TPAppCloudContext.getCur…tAccountContext().account");
        String g = b.d.w.h.a.g(c2.getCloudUserName());
        String str = this.q;
        T mThingContext = this.a;
        kotlin.jvm.internal.j.d(mThingContext, "mThingContext");
        b.d.w.d.a.l(g, list, str, ((ThingContext) mThingContext).getDeviceIdMD5());
    }

    public final LiveData<Boolean> P0() {
        return this.w;
    }

    public final LiveData<List<ThingEventLog>> Q0() {
        return this.v;
    }

    public final void T0() {
        this.s.postValue(b1());
    }

    public final io.reactivex.a U0() {
        if (!this.t) {
            W0(false);
            io.reactivex.a e2 = io.reactivex.a.e();
            kotlin.jvm.internal.j.d(e2, "Completable.complete()");
            return e2;
        }
        io.reactivex.a Z = V0().E(new c()).Z();
        kotlin.jvm.internal.j.d(Z, "loadMoreEventLogsRemotel…        .ignoreElements()");
        return Z;
    }

    public final io.reactivex.a Y0() {
        io.reactivex.a Z = Z0().E(new d()).Z();
        kotlin.jvm.internal.j.d(Z, "refreshEventLogsRemotely…        .ignoreElements()");
        return Z;
    }

    public final void d1(String dirName) {
        kotlin.jvm.internal.j.e(dirName, "dirName");
        this.q = dirName;
    }
}
