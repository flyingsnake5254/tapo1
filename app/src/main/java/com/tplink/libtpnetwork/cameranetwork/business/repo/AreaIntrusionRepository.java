package com.tplink.libtpnetwork.cameranetwork.business.repo;

import androidx.annotation.NonNull;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.model.DayOfWeek;
import com.tplink.libtpnetwork.cameranetwork.business.model.c;
import com.tplink.libtpnetwork.cameranetwork.f4;
import com.tplink.libtpnetwork.cameranetwork.g4.m;
import com.tplink.libtpnetwork.cameranetwork.model.ArmScheduleInfo;
import com.tplink.libtpnetwork.cameranetwork.model.DetectionInfo;
import com.tplink.libtpnetwork.cameranetwork.model.IntrusionDetectionInfo;
import com.tplink.libtpnetwork.cameranetwork.model.IntrusionDetectionRegion;
import com.tplink.libtpnetwork.cameranetwork.model.IntrusionSchedule;
import com.tplink.libtpnetwork.cameranetwork.model.ScheduleParser;
import io.reactivex.q;
import io.reactivex.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.l;
import kotlin.jvm.internal.j;

/* compiled from: AreaIntrusionRepository.kt */
/* loaded from: classes3.dex */
public final class AreaIntrusionRepository extends com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c {

    /* renamed from: d  reason: collision with root package name */
    public static final a f14171d = new a(null);

    /* renamed from: e  reason: collision with root package name */
    private final com.tplink.libtpnetwork.cameranetwork.business.model.c f14172e = new com.tplink.libtpnetwork.cameranetwork.business.model.c();

    /* compiled from: AreaIntrusionRepository.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public final HashMap<String, List<IntrusionDetectionRegion>> a(List<? extends c.a> regions) {
            j.e(regions, "regions");
            ArrayList arrayList = new ArrayList();
            for (c.a aVar : regions) {
                arrayList.add(new IntrusionDetectionRegion(String.valueOf(aVar.c()), String.valueOf(aVar.d()), String.valueOf(aVar.c() + aVar.b()), String.valueOf(aVar.d()), String.valueOf(aVar.c() + aVar.b()), String.valueOf(aVar.d() + aVar.a()), String.valueOf(aVar.c()), String.valueOf(aVar.d() + aVar.a()), "50", "0", "0"));
            }
            HashMap<String, List<IntrusionDetectionRegion>> hashMap = new HashMap<>();
            hashMap.put("region_info", arrayList);
            return hashMap;
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AreaIntrusionRepository.kt */
    /* loaded from: classes3.dex */
    public static final class b<T, R> implements io.reactivex.g0.j<Object, Boolean> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ List f14174d;

        b(List list) {
            this.f14174d = list;
        }

        /* renamed from: a */
        public final Boolean apply(Object it) {
            j.e(it, "it");
            AreaIntrusionRepository.this.f14172e.e(this.f14174d);
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AreaIntrusionRepository.kt */
    /* loaded from: classes3.dex */
    public static final class c<T> implements io.reactivex.g0.g<List<Map<String, IntrusionDetectionRegion>>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AreaIntrusionRepository.kt */
        /* loaded from: classes3.dex */
        public static final class a<T> implements io.reactivex.g0.g<Throwable> {

            /* renamed from: c  reason: collision with root package name */
            public static final a f14176c = new a();

            a() {
            }

            /* renamed from: a */
            public final void accept(Throwable th) {
                th.printStackTrace();
            }
        }

        c() {
        }

        /* renamed from: a */
        public final void accept(List<Map<String, IntrusionDetectionRegion>> it) {
            ArrayList arrayList = new ArrayList();
            j.d(it, "it");
            int size = it.size();
            boolean z = false;
            for (int i = 0; i < size; i++) {
                IntrusionDetectionRegion intrusionDetectionRegion = (IntrusionDetectionRegion) l.w(it.get(i).values());
                c.a aVar = new c.a();
                aVar.g(Integer.parseInt(intrusionDetectionRegion.getLeftTopX()));
                aVar.h(Integer.parseInt(intrusionDetectionRegion.getLeftTopY()));
                aVar.f(Integer.parseInt(intrusionDetectionRegion.getRightTopX()) - Integer.parseInt(intrusionDetectionRegion.getLeftTopX()));
                aVar.e(Integer.parseInt(intrusionDetectionRegion.getLeftBottomY()) - Integer.parseInt(intrusionDetectionRegion.getLeftTopY()));
                arrayList.add(aVar);
                if (Integer.parseInt(intrusionDetectionRegion.getLeftBottomX()) < Integer.parseInt(intrusionDetectionRegion.getRightBottomX())) {
                    z = true;
                }
            }
            if (z) {
                AreaIntrusionRepository.this.w(arrayList).C(a.f14176c).F0();
            }
            AreaIntrusionRepository.this.f14172e.e(arrayList);
        }
    }

    /* compiled from: AreaIntrusionRepository.kt */
    /* loaded from: classes3.dex */
    static final class d<T> implements io.reactivex.g0.g<IntrusionDetectionInfo> {
        d() {
        }

        /* renamed from: a */
        public final void accept(IntrusionDetectionInfo intrusionDetectionInfo) {
            com.tplink.libtpnetwork.cameranetwork.business.model.c cVar = AreaIntrusionRepository.this.f14172e;
            DetectionInfo detectionInfo = intrusionDetectionInfo.getDetectionInfo();
            cVar.d(j.a("on", detectionInfo != null ? detectionInfo.getEnabled() : null));
            ArmScheduleInfo armScheduleInfo = intrusionDetectionInfo.getArmScheduleInfo();
            if (armScheduleInfo != null) {
                AreaIntrusionRepository.this.B(armScheduleInfo);
            }
        }
    }

    /* compiled from: AreaIntrusionRepository.kt */
    /* loaded from: classes3.dex */
    static final class e<T, R> implements io.reactivex.g0.j<IntrusionDetectionInfo, t<? extends List<? extends Map<String, ? extends IntrusionDetectionRegion>>>> {
        e() {
        }

        /* renamed from: a */
        public final t<? extends List<Map<String, IntrusionDetectionRegion>>> apply(IntrusionDetectionInfo intrusionDetectionInfo) {
            j.e(intrusionDetectionInfo, "<anonymous parameter 0>");
            return AreaIntrusionRepository.this.y();
        }
    }

    /* compiled from: AreaIntrusionRepository.kt */
    /* loaded from: classes3.dex */
    static final class f<T, R> implements io.reactivex.g0.j<List<? extends Map<String, ? extends IntrusionDetectionRegion>>, Boolean> {

        /* renamed from: c  reason: collision with root package name */
        public static final f f14179c = new f();

        f() {
        }

        /* renamed from: a */
        public final Boolean apply(List<? extends Map<String, IntrusionDetectionRegion>> it) {
            j.e(it, "it");
            return Boolean.TRUE;
        }
    }

    /* compiled from: AreaIntrusionRepository.kt */
    /* loaded from: classes3.dex */
    static final class g<T, R> implements io.reactivex.g0.j<Object, Boolean> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ DetectionInfo f14181d;

        g(DetectionInfo detectionInfo) {
            this.f14181d = detectionInfo;
        }

        /* renamed from: a */
        public final Boolean apply(Object it) {
            j.e(it, "it");
            AreaIntrusionRepository.this.f14172e.d(j.a("on", this.f14181d.getEnabled()));
            return Boolean.TRUE;
        }
    }

    /* compiled from: AreaIntrusionRepository.kt */
    /* loaded from: classes3.dex */
    static final class h<T, R> implements io.reactivex.g0.j<Object, Boolean> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Map f14183d;

        h(Map map) {
            this.f14183d = map;
        }

        /* renamed from: a */
        public final Boolean apply(Object it) {
            j.e(it, "it");
            AreaIntrusionRepository areaIntrusionRepository = AreaIntrusionRepository.this;
            areaIntrusionRepository.B(areaIntrusionRepository.x(this.f14183d));
            return Boolean.TRUE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AreaIntrusionRepository(@NonNull TPCameraDeviceContext deviceContext) {
        super(deviceContext);
        j.e(deviceContext, "deviceContext");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(ArmScheduleInfo armScheduleInfo) {
        this.f14172e.f(DayOfWeek.SUNDAY, ScheduleParser.parseIntrusionSchedules(armScheduleInfo.getSunday()));
        this.f14172e.f(DayOfWeek.MONDAY, ScheduleParser.parseIntrusionSchedules(armScheduleInfo.getMonday()));
        this.f14172e.f(DayOfWeek.TUESDAY, ScheduleParser.parseIntrusionSchedules(armScheduleInfo.getTuesday()));
        this.f14172e.f(DayOfWeek.WEDNESDAY, ScheduleParser.parseIntrusionSchedules(armScheduleInfo.getWednesday()));
        this.f14172e.f(DayOfWeek.THURSDAY, ScheduleParser.parseIntrusionSchedules(armScheduleInfo.getThursday()));
        this.f14172e.f(DayOfWeek.FRIDAY, ScheduleParser.parseIntrusionSchedules(armScheduleInfo.getFriday()));
        this.f14172e.f(DayOfWeek.SATURDAY, ScheduleParser.parseIntrusionSchedules(armScheduleInfo.getSaturday()));
    }

    private final void C(IntrusionDetectionInfo intrusionDetectionInfo) {
        com.tplink.libtpnetwork.cameranetwork.business.model.c cVar = this.f14172e;
        DetectionInfo detectionInfo = intrusionDetectionInfo.getDetectionInfo();
        cVar.d(j.a("on", detectionInfo != null ? detectionInfo.getEnabled() : null));
        ArmScheduleInfo armScheduleInfo = intrusionDetectionInfo.getArmScheduleInfo();
        if (armScheduleInfo != null) {
            B(armScheduleInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArmScheduleInfo x(Map<DayOfWeek, ? extends List<IntrusionSchedule>> map) {
        return new ArmScheduleInfo(ScheduleParser.formatIntrusionSchedules((List) map.get(DayOfWeek.MONDAY)), ScheduleParser.formatIntrusionSchedules((List) map.get(DayOfWeek.TUESDAY)), ScheduleParser.formatIntrusionSchedules((List) map.get(DayOfWeek.WEDNESDAY)), ScheduleParser.formatIntrusionSchedules((List) map.get(DayOfWeek.THURSDAY)), ScheduleParser.formatIntrusionSchedules((List) map.get(DayOfWeek.FRIDAY)), ScheduleParser.formatIntrusionSchedules((List) map.get(DayOfWeek.SATURDAY)), ScheduleParser.formatIntrusionSchedules((List) map.get(DayOfWeek.SUNDAY)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final q<List<Map<String, IntrusionDetectionRegion>>> y() {
        f4 cameraClient = this.f14514c;
        j.d(cameraClient, "cameraClient");
        q<List<Map<String, IntrusionDetectionRegion>>> E = cameraClient.S().i(m.a()).L0(io.reactivex.l0.a.c()).E(new c());
        j.d(E, "cameraClient.intrusionDe…onsList\n                }");
        return E;
    }

    public final q<Boolean> A() {
        f4 cameraClient = this.f14514c;
        j.d(cameraClient, "cameraClient");
        q<Boolean> g0 = cameraClient.R().i(m.a()).L0(io.reactivex.l0.a.c()).E(new d()).N(new e()).g0(f.f14179c);
        j.d(g0, "cameraClient.intrusionDe…   true\n                }");
        return g0;
    }

    public final q<Boolean> D(DetectionInfo detectionInfo) {
        j.e(detectionInfo, "detectionInfo");
        q<Boolean> g0 = this.f14514c.z2(detectionInfo).i(m.a()).L0(io.reactivex.l0.a.c()).g0(new g(detectionInfo));
        j.d(g0, "cameraClient.setIntrusio…   true\n                }");
        return g0;
    }

    public final q<Boolean> E(Map<DayOfWeek, ? extends List<IntrusionSchedule>> schedules) {
        j.e(schedules, "schedules");
        q<Boolean> g0 = this.f14514c.A2(x(schedules)).i(m.a()).L0(io.reactivex.l0.a.c()).g0(new h(schedules));
        j.d(g0, "cameraClient.setIntrusio…   true\n                }");
        return g0;
    }

    public final void F(IntrusionDetectionInfo intrusionDetectionInfo) {
        j.e(intrusionDetectionInfo, "intrusionDetectionInfo");
        C(intrusionDetectionInfo);
    }

    public final q<Boolean> w(List<? extends c.a> regions) {
        j.e(regions, "regions");
        q<Boolean> g0 = this.f14514c.d(f14171d.a(regions)).i(m.a()).L0(io.reactivex.l0.a.c()).g0(new b(regions));
        j.d(g0, "cameraClient.addIntrusio…   true\n                }");
        return g0;
    }

    public final com.tplink.libtpnetwork.cameranetwork.business.model.c z() {
        return this.f14172e;
    }
}
