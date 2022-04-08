package com.tplink.libtpnetwork.cameranetwork.business.repo;

import android.os.Build;
import android.util.Pair;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.model.PlayBackEventType;
import com.tplink.libtpnetwork.cameranetwork.business.model.i;
import com.tplink.libtpnetwork.cameranetwork.business.model.j;
import com.tplink.libtpnetwork.cameranetwork.business.model.k;
import com.tplink.libtpnetwork.cameranetwork.business.model.l;
import com.tplink.libtpnetwork.cameranetwork.business.model.m;
import com.tplink.libtpnetwork.cameranetwork.business.model.n;
import com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import com.tplink.libtpnetwork.cameranetwork.model.ClockStatus;
import com.tplink.libtpnetwork.cameranetwork.model.ClockTimezoneDstStatus;
import com.tplink.libtpnetwork.cameranetwork.model.ClockTimezoneInfo;
import com.tplink.libtpnetwork.cameranetwork.model.DailyPlaybackItem;
import com.tplink.libtpnetwork.cameranetwork.model.DetectionList;
import com.tplink.libtpnetwork.cameranetwork.model.DstInfo;
import com.tplink.libtpnetwork.cameranetwork.model.Response;
import com.tplink.libtpnetwork.cameranetwork.model.SnapshotPlaybackItem;
import com.tplink.libtpnetwork.cameranetwork.model.Timezone;
import com.tplink.libtpnetwork.cameranetwork.model.VodUserId;
import com.tplink.libtpnetwork.cameranetwork.model.YearlyPlaybackItem;
import com.tplink.libtpnetwork.cameranetwork.net.CameraException;
import com.tplink.libtpnetwork.cameranetwork.util.d;
import io.reactivex.g0.e;
import io.reactivex.g0.g;
import io.reactivex.q;
import io.reactivex.r;
import io.reactivex.s;
import io.reactivex.t;
import io.reactivex.v;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* loaded from: classes3.dex */
public class PlayBackRepository extends c {
    private Calendar r;
    private Calendar s;
    private long t;
    private long u;
    public long v;
    public int[] w;
    private k x;
    private TimeZone y;

    /* renamed from: d  reason: collision with root package name */
    private final String f14313d = "PlayBackRepository";

    /* renamed from: e  reason: collision with root package name */
    private final MutableLiveData<Boolean> f14314e = new MutableLiveData<>();

    /* renamed from: f  reason: collision with root package name */
    private final MutableLiveData<Boolean> f14315f = new MutableLiveData<>();
    private final MutableLiveData<a<l>> g = new MutableLiveData<>();
    private final MutableLiveData<a<Long>> h = new MutableLiveData<>();
    private final MutableLiveData<m> i = new MutableLiveData<>();
    private final MutableLiveData<n> j = new MutableLiveData<>();
    private final MutableLiveData<List<j>> k = new MutableLiveData<>();
    private final MutableLiveData<a<Integer>> l = new MutableLiveData<>();
    private final Map<String, List<j>> m = new HashMap();
    private final List<DailyPlaybackItem> n = new ArrayList();
    private final List<DailyPlaybackItem> o = new ArrayList();
    private final List<DailyPlaybackItem> p = new ArrayList();
    private int q = -1;
    private final SimpleDateFormat z = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

    public PlayBackRepository(TPCameraDeviceContext tPCameraDeviceContext) {
        super(tPCameraDeviceContext);
        q0();
    }

    private List<SnapshotPlaybackItem> A(SnapshotPlaybackItem snapshotPlaybackItem, long j, Calendar calendar) {
        ArrayList arrayList = new ArrayList();
        SnapshotPlaybackItem snapshotPlaybackItem2 = new SnapshotPlaybackItem(snapshotPlaybackItem.getStartTime(), j - 1, snapshotPlaybackItem.getType());
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(snapshotPlaybackItem2.getStartTime() * 1000);
        O1(instance);
        if (u0(instance, calendar)) {
            arrayList.add(snapshotPlaybackItem2);
        }
        SnapshotPlaybackItem snapshotPlaybackItem3 = new SnapshotPlaybackItem(j + 1, snapshotPlaybackItem.getEndTime(), snapshotPlaybackItem.getType(), String.valueOf(snapshotPlaybackItem.getStartTime()));
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(snapshotPlaybackItem3.getStartTime() * 1000);
        O1(instance2);
        if (u0(instance2, calendar)) {
            arrayList.add(snapshotPlaybackItem3);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A0 */
    public /* synthetic */ void B0(Throwable th) throws Exception {
        this.g.postValue(new a<>(new l(-1, -1L, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A1 */
    public /* synthetic */ t B1(CameraComponent cameraComponent, l lVar) throws Exception {
        int i = lVar.f14145b;
        Calendar instance = Calendar.getInstance();
        if (this.x.l() != null) {
            instance.setTimeZone(this.x.l());
        }
        instance.setTimeInMillis(lVar.a);
        return U1(cameraComponent, new j(instance.get(1), instance.get(2), instance.get(5)), i);
    }

    private q<Boolean> B() {
        return l().u0().i(com.tplink.libtpnetwork.cameranetwork.g4.m.a()).L0(io.reactivex.l0.a.c()).N(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.a4
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return PlayBackRepository.this.w0((Timezone) obj);
            }
        }).E(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.h5
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                PlayBackRepository.this.y0((DetectionList) obj);
            }
        }).l0(io.reactivex.d0.b.a.a()).g0(d5.f14375c).C(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.s4
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                PlayBackRepository.this.B0((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C */
    public q<k> K0(ClockTimezoneDstStatus clockTimezoneDstStatus, long j) {
        DstInfo dstInfo = clockTimezoneDstStatus.getDstInfo();
        if (dstInfo == null || !"1".equals(dstInfo.getSynced()) || (!"1".equals(dstInfo.getHasRule()) && !ExifInterface.GPS_MEASUREMENT_2D.equals(dstInfo.getHasRule()))) {
            return D(false, new ClockTimezoneInfo(clockTimezoneDstStatus.getClockStatus(), clockTimezoneDstStatus.getTimezone()), j);
        }
        return D(true, new ClockTimezoneInfo(clockTimezoneDstStatus.getClockStatus(), clockTimezoneDstStatus.getTimezone()), j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C1 */
    public /* synthetic */ boolean D1(Throwable th) throws Exception {
        if (!(th instanceof CameraException) || ((CameraException) th).getErrorCode() != -71103) {
            return false;
        }
        r0();
        return true;
    }

    private q<k> D(boolean z, ClockTimezoneInfo clockTimezoneInfo, long j) {
        final k kVar;
        ClockStatus clockStatus = clockTimezoneInfo.getClockStatus();
        final Timezone timezone = clockTimezoneInfo.getTimezone();
        if (clockStatus == null || clockStatus.getSeconds() <= 0) {
            kVar = new k(0, j);
        } else {
            kVar = new k((int) (this.z.parse(clockStatus.getLocalTime(), new ParsePosition(0)).getTime() - (clockStatus.getSeconds() * 1000)), clockStatus.getSeconds() * 1000);
        }
        if (!z || timezone == null) {
            if (timezone != null) {
                kVar.u(timezone.getZoneId(), timezone.getTimezone());
            }
            return q.f0(kVar);
        } else if (Build.VERSION.SDK_INT < 26) {
            return d.c().g(timezone.getZoneId()).g0(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.q4
                @Override // io.reactivex.g0.j
                public final Object apply(Object obj) {
                    k kVar2 = k.this;
                    kVar2.e(r1.getZoneId(), timezone.getTimezone(), (Map) obj);
                    return kVar2;
                }
            });
        } else {
            kVar.d(timezone.getZoneId(), timezone.getTimezone());
            return q.f0(kVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D0 */
    public /* synthetic */ t E0(int i, String str, i iVar) throws Exception {
        return l().H(i, str, iVar.a(), (iVar.a() + iVar.b()) - 1).u0(1L).g0(w4.f14631c);
    }

    private m E(List<DailyPlaybackItem> list, Calendar calendar) {
        ArrayList arrayList = new ArrayList();
        Iterator<DailyPlaybackItem> it = list.iterator();
        int i = 0;
        long j = 0;
        boolean z = false;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (it.hasNext()) {
            DailyPlaybackItem next = it.next();
            if (this.x.p()) {
                long h = this.x.h(next.getStartTime() * 1000, i);
                it = it;
                long g = this.x.g(next.getStartTime() * 1000, i);
                boolean z2 = h < g;
                if (!z) {
                    z = z;
                    if (s0(next.getStartTime() * 1000, g)) {
                        Calendar instance = Calendar.getInstance();
                        instance.setTimeInMillis(g);
                        O1(instance);
                        i2 = instance.get(11);
                        i3 = instance.get(12);
                        i4 = this.x.k() / 1000;
                        j = g / 1000;
                        z = true;
                        if (!z2 && !this.x.q(next.getStartTime() * 1000, h, g) && this.x.q(next.getEndTime() * 1000, h, g)) {
                            arrayList.addAll(z(next, h / 1000, calendar));
                        } else if (!z2 && this.x.q(next.getStartTime() * 1000, h, g) && !this.x.q(next.getEndTime() * 1000, h, g)) {
                            arrayList.addAll(z(next, g / 1000, calendar));
                        } else if (z2 && !this.x.r(next.getStartTime() * 1000, h, g) && this.x.r(next.getEndTime() * 1000, h, g)) {
                            arrayList.addAll(z(next, h / 1000, calendar));
                        } else if (!z2 && this.x.r(next.getStartTime() * 1000, h, g) && !this.x.r(next.getEndTime() * 1000, h, g)) {
                            arrayList.addAll(z(next, g / 1000, calendar));
                        }
                        it = it;
                        i = 0;
                    }
                } else {
                    z = z;
                }
                if (!z2) {
                }
                if (!z2) {
                }
                if (z2) {
                }
                if (!z2) {
                    arrayList.addAll(z(next, g / 1000, calendar));
                    it = it;
                    i = 0;
                }
            } else {
                it = it;
            }
            Calendar instance2 = Calendar.getInstance();
            instance2.setTimeInMillis(next.getStartTime() * 1000);
            O1(instance2);
            Calendar instance3 = Calendar.getInstance();
            instance3.setTimeInMillis(next.getEndTime() * 1000);
            O1(instance3);
            if (u0(instance2, calendar) && u0(instance3, calendar)) {
                arrayList.add(next);
                i = 0;
            } else if (!u0(instance2, calendar) || u0(instance3, calendar)) {
                i = 0;
                if (!u0(instance2, calendar) && u0(instance3, calendar)) {
                    Calendar instance4 = Calendar.getInstance();
                    if (this.x.l() != null) {
                        instance4.setTimeZone(this.x.l());
                    }
                    instance4.setTimeInMillis(next.getStartTime() * 1000);
                    instance4.set(11, 23);
                    instance4.set(12, 59);
                    instance4.set(13, 59);
                    arrayList.add(new DailyPlaybackItem(next.getStartTime(), instance4.getTimeInMillis() / 1000, next.getType()));
                }
            } else {
                Calendar instance5 = Calendar.getInstance();
                if (this.x.l() != null) {
                    instance5.setTimeZone(this.x.l());
                }
                instance5.setTimeInMillis(next.getEndTime() * 1000);
                i = 0;
                instance5.set(11, 0);
                instance5.set(12, 0);
                instance5.set(13, 0);
                arrayList.add(new DailyPlaybackItem(instance5.getTimeInMillis() / 1000, next.getEndTime(), next.getType()));
            }
        }
        return new m(arrayList, z, i2, i3, i4, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F0 */
    public /* synthetic */ t G0(int i, long j, long j2, i iVar) throws Exception {
        return l().I(i, j, j2, iVar.a(), (iVar.a() + iVar.b()) - 1).u0(1L).g0(n5.f14536c);
    }

    private n G(List<SnapshotPlaybackItem> list, boolean z, Calendar calendar, long j) {
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        int i = 0;
        long j2 = 0;
        for (SnapshotPlaybackItem snapshotPlaybackItem : list) {
            if (this.x.p()) {
                long h = this.x.h(snapshotPlaybackItem.getStartTime() * 1000, 0);
                long g = this.x.g(snapshotPlaybackItem.getStartTime() * 1000, 0);
                boolean z3 = h < g;
                if (!z2) {
                    z2 = z2;
                    if (s0(snapshotPlaybackItem.getStartTime() * 1000, g)) {
                        i = this.x.k() / 1000;
                        j2 = g / 1000;
                        z2 = true;
                        if (!z3 && !this.x.q(snapshotPlaybackItem.getStartTime() * 1000, h, g) && this.x.q(snapshotPlaybackItem.getEndTime() * 1000, h, g)) {
                            arrayList.addAll(A(snapshotPlaybackItem, h / 1000, calendar));
                        } else if (!z3 && this.x.q(snapshotPlaybackItem.getStartTime() * 1000, h, g) && !this.x.q(snapshotPlaybackItem.getEndTime() * 1000, h, g)) {
                            arrayList.addAll(A(snapshotPlaybackItem, g / 1000, calendar));
                        } else if (z3 && !this.x.r(snapshotPlaybackItem.getStartTime() * 1000, h, g) && this.x.r(snapshotPlaybackItem.getEndTime() * 1000, h, g)) {
                            arrayList.addAll(A(snapshotPlaybackItem, h / 1000, calendar));
                        } else if (!z3 || !this.x.r(snapshotPlaybackItem.getStartTime() * 1000, h, g) || this.x.r(snapshotPlaybackItem.getEndTime() * 1000, h, g)) {
                            z2 = z2;
                            i = i;
                        } else {
                            arrayList.addAll(A(snapshotPlaybackItem, g / 1000, calendar));
                        }
                    }
                } else {
                    z2 = z2;
                }
                j2 = j2;
                if (!z3) {
                }
                if (!z3) {
                }
                if (z3) {
                }
                if (!z3) {
                }
                z2 = z2;
                i = i;
            } else {
                z2 = z2;
                i = i;
                j2 = j2;
            }
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(snapshotPlaybackItem.getStartTime() * 1000);
            O1(instance);
            if (u0(instance, calendar)) {
                if (j <= 0) {
                    arrayList.add(snapshotPlaybackItem);
                } else if (snapshotPlaybackItem.getStartTime() < j && snapshotPlaybackItem.getEndTime() < j) {
                    arrayList.add(snapshotPlaybackItem);
                } else if (snapshotPlaybackItem.getStartTime() < j && snapshotPlaybackItem.getEndTime() >= j) {
                    arrayList.add(new SnapshotPlaybackItem(snapshotPlaybackItem.getStartTime(), j, snapshotPlaybackItem.getType()));
                }
            }
        }
        return new n(arrayList, z, z2, i, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G1 */
    public /* synthetic */ t H1(Throwable th) throws Exception {
        o0(th);
        return q.f0(new ArrayList());
    }

    private boolean H(int[] iArr, int i) {
        if (iArr == null) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean H0(i iVar, List list, r rVar) throws Exception {
        boolean z = iVar.a() > list.size() || iVar.a() > 12288;
        if (z) {
            rVar.onNext(list);
            rVar.onComplete();
        }
        return z;
    }

    private long I(long j, List<DailyPlaybackItem> list) {
        if (list.isEmpty()) {
            return j;
        }
        boolean z = false;
        Iterator<DailyPlaybackItem> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            DailyPlaybackItem next = it.next();
            if (j >= next.getStartTime() && j < next.getEndTime()) {
                z = true;
                break;
            }
        }
        if (z) {
            return j;
        }
        Iterator<DailyPlaybackItem> it2 = list.iterator();
        while (it2.hasNext()) {
            DailyPlaybackItem next2 = it2.next();
            if (j < next2.getStartTime()) {
                return next2.getStartTime();
            }
            if (!it2.hasNext()) {
                j = next2.getStartTime();
            }
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void I0(List list, i iVar, Response response) throws Exception {
        List list2 = (List) response.getResult();
        if (list2 != null) {
            list.addAll(list2);
        }
        iVar.c(iVar.a() + iVar.b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ CameraComponent I1(CameraComponent cameraComponent, List list) throws Exception {
        return cameraComponent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void J0(List list, r rVar, Throwable th) throws Exception {
        if (list.isEmpty()) {
            rVar.onError(th);
            return;
        }
        rVar.onNext(list);
        rVar.onComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J1 */
    public /* synthetic */ l K1(long j, long j2, List list, Response response) throws Exception {
        VodUserId vodUserId = (VodUserId) response.getResult();
        int errorCode = response.getErrorCode();
        if (vodUserId != null && vodUserId.getId() > 0) {
            this.q = vodUserId.getId();
        }
        List<j> x = x(list);
        if (!x.isEmpty()) {
            this.m.put(P(x.get(0)), x);
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, List<j>> entry : this.m.entrySet()) {
                arrayList.addAll(entry.getValue());
            }
            this.k.postValue(arrayList);
        } else {
            this.k.postValue(new ArrayList());
        }
        if (this.q > 0) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i > 0) {
                long j3 = j * 1000;
                this.u = j3;
                this.f14315f.postValue(Boolean.TRUE);
                this.f14314e.postValue(Boolean.valueOf(u(j3, x)));
            } else {
                this.u = j2;
                this.f14314e.postValue(Boolean.valueOf(u(j2, x)));
            }
            if (i > 0) {
                return new l(this.q, j * 1000, null);
            }
            return new l(this.q, j2, null);
        }
        throw new CameraException(errorCode, "" + response);
    }

    private q<Response<List<DailyPlaybackItem>>> L(CameraComponent cameraComponent, j jVar, int i, i iVar) {
        if (!cameraComponent.isSupportUtcDst()) {
            return M(String.format(Locale.US, "%1$d%2$02d%3$02d", Integer.valueOf(jVar.c()), Integer.valueOf(jVar.b() + 1), Integer.valueOf(jVar.a())), i, iVar);
        }
        Pair<Long, Long> i2 = this.x.i(jVar.c(), jVar.b(), jVar.a());
        return N(((Long) i2.first).longValue(), ((Long) i2.second).longValue(), i, iVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L1 */
    public /* synthetic */ boolean M1(Throwable th) throws Exception {
        if (!(th instanceof CameraException) || ((CameraException) th).getErrorCode() != -71103) {
            return false;
        }
        r0();
        return true;
    }

    private q<Response<List<DailyPlaybackItem>>> M(final String str, final int i, i iVar) {
        return q.f0(iVar).N(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.c5
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return PlayBackRepository.this.E0(i, str, (i) obj);
            }
        });
    }

    private q<Response<List<DailyPlaybackItem>>> N(final long j, final long j2, final int i, i iVar) {
        return q.f0(iVar).N(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.b4
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return PlayBackRepository.this.G0(i, j, j2, (i) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N0 */
    public /* synthetic */ t O0(long j, ClockTimezoneInfo clockTimezoneInfo) throws Exception {
        return D(true, clockTimezoneInfo, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O */
    public void i1(CameraComponent cameraComponent, j jVar, int i, final i iVar, final r<List<DailyPlaybackItem>> rVar) {
        final ArrayList arrayList = new ArrayList();
        L(cameraComponent, jVar, i, iVar).s0(new e() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.g4
            @Override // io.reactivex.g0.e
            public final boolean a() {
                return PlayBackRepository.H0(i.this, arrayList, rVar);
            }
        }).L0(io.reactivex.l0.a.c()).H0(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.m5
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                PlayBackRepository.I0(arrayList, iVar, (Response) obj);
            }
        }, new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.l5
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                PlayBackRepository.J0(arrayList, rVar, (Throwable) obj);
            }
        });
    }

    private String P(j jVar) {
        return new SimpleDateFormat("yyyyMM", Locale.US).format(y(jVar));
    }

    private void P1(Calendar calendar, int i) {
        if (calendar != null) {
            int i2 = i / 1000;
            int i3 = i2 / 3600;
            calendar.add(11, i3);
            calendar.add(12, (i2 - (i3 * 3600)) / 60);
        }
    }

    private String Q(Date date) {
        return new SimpleDateFormat("yyyyMM", Locale.US).format(date);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q0 */
    public /* synthetic */ t R0(TimeZone timeZone, i iVar) throws Exception {
        int a = iVar.a();
        int a2 = (iVar.a() + iVar.b()) - 1;
        Calendar instance = Calendar.getInstance();
        instance.set(this.r.get(1), this.r.get(2), this.r.get(5), 0, 0, 0);
        instance.setTimeZone(timeZone);
        instance.add(6, 1);
        return l().q0(instance.getTimeInMillis() / 1000, (instance.getTimeInMillis() / 1000) - 1, a, a2).u0(1L);
    }

    private long S(List<DailyPlaybackItem> list, boolean z, boolean z2) {
        if (list.isEmpty()) {
            return -1L;
        }
        long startTime = list.get(0).getStartTime();
        for (DailyPlaybackItem dailyPlaybackItem : list) {
            if (PlayBackEventType.TYPE_TIMING.getName().equals(dailyPlaybackItem.getType()) && z) {
                return dailyPlaybackItem.getStartTime();
            }
            if (PlayBackEventType.TYPE_MOTION.getName().equals(dailyPlaybackItem.getType()) && z2) {
                return dailyPlaybackItem.getStartTime();
            }
        }
        return startTime;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean S0(i iVar, List list, boolean[] zArr, r rVar) throws Exception {
        boolean z = iVar.a() > list.size() || iVar.a() > 12288;
        if (z) {
            rVar.onNext(new DetectionList(Boolean.valueOf(zArr[0]), list));
            rVar.onComplete();
        }
        return z;
    }

    private int[] T(List<DailyPlaybackItem> list) {
        boolean z = false;
        boolean z2 = false;
        for (DailyPlaybackItem dailyPlaybackItem : list) {
            if (PlayBackEventType.TYPE_TIMING.getName().equals(dailyPlaybackItem.getType())) {
                z = true;
            } else {
                PlayBackEventType.TYPE_MOTION.getName().equals(dailyPlaybackItem.getType());
                z2 = true;
            }
        }
        return (!z || !z2) ? (!z || z2) ? (z || !z2) ? new int[]{PlayBackEventType.TYPE_MOTION.getValue()} : new int[]{PlayBackEventType.TYPE_MOTION.getValue()} : new int[]{PlayBackEventType.TYPE_TIMING.getValue()} : new int[]{PlayBackEventType.TYPE_TIMING.getValue(), PlayBackEventType.TYPE_MOTION.getValue()};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void T0(boolean[] zArr, List list, i iVar, Response response) throws Exception {
        List<SnapshotPlaybackItem> detectionList = ((DetectionList) response.getResult()).getDetectionList();
        if (((DetectionList) response.getResult()).getSnapshotEnable() != null) {
            zArr[0] = ((DetectionList) response.getResult()).getSnapshotEnable().booleanValue();
        }
        if (detectionList != null) {
            list.addAll(detectionList);
        }
        iVar.c(iVar.a() + iVar.b());
    }

    private Date U(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        instance.set(5, 1);
        return new Date(instance.getTimeInMillis());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void U0(List list, r rVar, boolean[] zArr, Throwable th) throws Exception {
        if (list.isEmpty()) {
            rVar.onError(th);
            return;
        }
        rVar.onNext(new DetectionList(Boolean.valueOf(zArr[0]), list));
        rVar.onComplete();
    }

    private q<List<DailyPlaybackItem>> U1(CameraComponent cameraComponent, j jVar, int i) {
        if (cameraComponent.isSupportUtcDst()) {
            return W1(cameraComponent, jVar, i, new i(0, 100));
        }
        Calendar instance = Calendar.getInstance();
        if (this.x.l() != null) {
            instance.setTimeZone(this.x.l());
        }
        instance.set(1, jVar.c());
        instance.set(2, jVar.b());
        instance.set(5, jVar.a());
        instance.set(11, 12);
        instance.set(12, 0);
        instance.set(13, 0);
        long timeInMillis = instance.getTimeInMillis();
        if (!this.x.p() || !this.x.o()) {
            if (this.x.p() && !this.x.o() && v(timeInMillis)) {
                instance.add(5, -1);
                return W1(cameraComponent, jVar, i, new i(0, 100)).i1(W1(cameraComponent, new j(instance.get(1), instance.get(2), instance.get(5)), i, new i(0, 100)).q0(new ArrayList()), k4.f14489c);
            }
        } else if (!v(timeInMillis)) {
            instance.add(5, 1);
            return W1(cameraComponent, jVar, i, new i(0, 100)).i1(W1(cameraComponent, new j(instance.get(1), instance.get(2), instance.get(5)), i, new i(0, 100)).q0(new ArrayList()), n4.f14535c);
        }
        return W1(cameraComponent, jVar, i, new i(0, 100));
    }

    private Date V(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        instance.set(5, 1);
        instance.add(2, 1);
        instance.add(5, -1);
        return new Date(instance.getTimeInMillis());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ List V0(Response response) throws Exception {
        if (response.getErrorCode() == 0) {
            return (List) response.getResult();
        }
        throw new CameraException(response.getErrorCode(), response.toString());
    }

    private q<Boolean> V1(final CameraComponent cameraComponent) {
        return q.f0(1).N(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.y4
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return PlayBackRepository.this.h1(cameraComponent, (Integer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W0 */
    public /* synthetic */ t X0(CameraComponent cameraComponent, Response response) throws Exception {
        VodUserId vodUserId = (VodUserId) response.getResult();
        int errorCode = response.getErrorCode();
        if (vodUserId != null && vodUserId.getId() > 0) {
            this.q = vodUserId.getId();
        }
        if (this.q > 0) {
            return X1(cameraComponent, new j(this.r.get(1), this.r.get(2), this.r.get(5)), this.q);
        }
        return q.J(new CameraException(errorCode, "" + response));
    }

    private q<List<DailyPlaybackItem>> W1(final CameraComponent cameraComponent, final j jVar, final int i, final i iVar) {
        return q.m(new s() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.c4
            @Override // io.reactivex.s
            public final void subscribe(r rVar) {
                PlayBackRepository.this.j1(cameraComponent, jVar, i, iVar, rVar);
            }
        });
    }

    private q<k> X(CameraComponent cameraComponent, final long j) {
        if (cameraComponent.isSupportUtcDst()) {
            return l().B().i(com.tplink.libtpnetwork.cameranetwork.g4.m.a()).L0(io.reactivex.l0.a.c()).N(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.m4
                @Override // io.reactivex.g0.j
                public final Object apply(Object obj) {
                    return PlayBackRepository.this.L0(j, (ClockTimezoneDstStatus) obj);
                }
            }).n0(new t() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.x4
                @Override // io.reactivex.t
                public final void a(v vVar) {
                    vVar.onNext(new k(0, j));
                }
            });
        }
        return l().C().i(com.tplink.libtpnetwork.cameranetwork.g4.m.a()).L0(io.reactivex.l0.a.c()).N(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.o5
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return PlayBackRepository.this.O0(j, (ClockTimezoneInfo) obj);
            }
        }).n0(new t() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.t4
            @Override // io.reactivex.t
            public final void a(v vVar) {
                vVar.onNext(new k(0, j));
            }
        });
    }

    private q<Boolean> X1(CameraComponent cameraComponent, j jVar, final int i) {
        return U1(cameraComponent, jVar, i).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.f5
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                PlayBackRepository.this.l1(i, (List) obj);
            }
        }).g0(f4.f14396c).C(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.h4
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                PlayBackRepository.this.o1((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Response Y0(Response response) throws Exception {
        if (response.getErrorCode() == 0) {
            return response;
        }
        throw new CameraException(response.getErrorCode(), response.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Response Z0(Response response) throws Exception {
        if (response.getErrorCode() == 0) {
            return response;
        }
        throw new CameraException(response.getErrorCode(), response.toString());
    }

    private q<Boolean> Z1() {
        return q.f0(1).N(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.i5
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return PlayBackRepository.this.t1((Integer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a1 */
    public /* synthetic */ t b1(Response response) throws Exception {
        VodUserId vodUserId = (VodUserId) response.getResult();
        int errorCode = response.getErrorCode();
        if (vodUserId != null && vodUserId.getId() > 0) {
            this.q = vodUserId.getId();
        }
        if (this.q > 0) {
            return B();
        }
        return q.J(new CameraException(errorCode, "" + response));
    }

    private q<DetectionList> a2(final i iVar, final TimeZone timeZone) {
        return q.m(new s() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.p5
            @Override // io.reactivex.s
            public final void subscribe(r rVar) {
                PlayBackRepository.this.v1(timeZone, iVar, rVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c1 */
    public /* synthetic */ boolean d1(Throwable th) throws Exception {
        if (!(th instanceof CameraException) || ((CameraException) th).getErrorCode() != -71103) {
            return false;
        }
        r0();
        return true;
    }

    private q<l> d2(final long j, final long j2) {
        Date U = U(j);
        Date V = V(j);
        if (j2 > 0) {
            long j3 = 1000 * j2;
            if (j3 <= j) {
                U = U(j3);
                V = V(j);
            } else {
                Date U2 = U(j);
                V = V(j3);
                U = U2;
            }
        }
        return m0(l(), U, V).i1(l0(), new io.reactivex.g0.c() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.g5
            @Override // io.reactivex.g0.c
            public final Object apply(Object obj, Object obj2) {
                return PlayBackRepository.this.K1(j2, j, (List) obj, (Response) obj2);
            }
        }).v0(1L, new io.reactivex.g0.l() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.v4
            @Override // io.reactivex.g0.l
            public final boolean test(Object obj) {
                return PlayBackRepository.this.M1((Throwable) obj);
            }
        });
    }

    private long e2(long j, boolean z, boolean z2) {
        if (z && z2) {
            return I(j, this.n);
        }
        if (!z || z2) {
            return (z || !z2) ? j : I(j, this.p);
        }
        return I(j, this.o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g1 */
    public /* synthetic */ t h1(final CameraComponent cameraComponent, Integer num) throws Exception {
        if (this.q > 0) {
            return X1(cameraComponent, new j(this.r.get(1), this.r.get(2), this.r.get(5)), this.q);
        }
        return l0().N(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.i4
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return PlayBackRepository.this.X0(cameraComponent, (Response) obj);
            }
        });
    }

    private q<Response<DetectionList>> h0(final TimeZone timeZone, i iVar) {
        return q.f0(iVar).N(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.e5
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return PlayBackRepository.this.R0(timeZone, (i) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i0 */
    public void u1(TimeZone timeZone, final i iVar, final r<DetectionList> rVar) {
        final ArrayList arrayList = new ArrayList();
        final boolean[] zArr = {false};
        h0(timeZone, iVar).s0(new e() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.q5
            @Override // io.reactivex.g0.e
            public final boolean a() {
                return PlayBackRepository.S0(i.this, arrayList, zArr, rVar);
            }
        }).L0(io.reactivex.l0.a.c()).H0(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.u4
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                PlayBackRepository.T0(zArr, arrayList, iVar, (Response) obj);
            }
        }, new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.l4
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                PlayBackRepository.U0(arrayList, rVar, zArr, (Throwable) obj);
            }
        });
    }

    private void j2(List<DailyPlaybackItem> list, List<DailyPlaybackItem> list2, List<DailyPlaybackItem> list3) {
        list2.clear();
        list3.clear();
        for (DailyPlaybackItem dailyPlaybackItem : list) {
            if (PlayBackEventType.TYPE_MOTION.getName().equals(dailyPlaybackItem.getType())) {
                list3.add(dailyPlaybackItem);
            } else if (PlayBackEventType.TYPE_TIMING.getName().equals(dailyPlaybackItem.getType())) {
                list2.add(dailyPlaybackItem);
            } else {
                list3.add(dailyPlaybackItem);
            }
        }
    }

    private q<Response<VodUserId>> l0() {
        int i = this.q;
        if (i > 0) {
            return q.f0(new Response(0, "getUserID", new VodUserId(i)));
        }
        return l().z0();
    }

    private q<List<YearlyPlaybackItem>> m0(com.tplink.libtpnetwork.cameranetwork.net.a aVar, Date date, Date date2) {
        return aVar.a(date, date2).g0(j4.f14476c).q0(new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n0 */
    public void k1(int i, List<DailyPlaybackItem> list) {
        DailyPlaybackItem dailyPlaybackItem;
        if (list == null || list.isEmpty()) {
            this.g.postValue(new a<>(new l(-1, -1L, null)));
            return;
        }
        this.n.clear();
        m E = E(list, this.r);
        this.n.addAll(E.e());
        j2(this.n, this.o, this.p);
        this.i.postValue(E);
        if (this.n.isEmpty()) {
            this.g.postValue(new a<>(new l(-1, -1L, null)));
            return;
        }
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(this.x.f());
        O1(instance);
        if (u0(instance, this.r)) {
            List<DailyPlaybackItem> list2 = this.n;
            dailyPlaybackItem = list2.get(list2.size() - 1);
        } else {
            dailyPlaybackItem = this.n.get(0);
        }
        long startTime = dailyPlaybackItem.getStartTime();
        int[] T = T(this.n);
        long j = startTime * 1000;
        l lVar = new l(i, j, T);
        this.v = j;
        this.w = T;
        this.g.postValue(new a<>(lVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n1 */
    public /* synthetic */ void o1(Throwable th) throws Exception {
        this.g.postValue(new a<>(new l(-1, -1L, null)));
    }

    private void o0(Throwable th) {
        int errorCode;
        if ((th instanceof CameraException) && ((errorCode = ((CameraException) th).getErrorCode()) == -71101 || errorCode == -71102 || errorCode == -71103)) {
            r0();
            this.l.postValue(new a<>(Integer.valueOf(errorCode)));
        }
        this.g.postValue(new a<>(new l(-1, -1L, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p0 */
    public void E1(List<DailyPlaybackItem> list, long j) {
        if (list == null || list.isEmpty()) {
            this.g.postValue(new a<>(new l(-1, -1L, null)));
            return;
        }
        this.n.clear();
        m E = E(list, this.r);
        this.n.addAll(E.e());
        j2(this.n, this.o, this.p);
        this.i.postValue(E);
        if (this.n.isEmpty()) {
            this.g.postValue(new a<>(new l(-1, -1L, null)));
            return;
        }
        List<DailyPlaybackItem> list2 = this.n;
        long startTime = list2.get(list2.size() - 1).getStartTime();
        int[] T = T(this.n);
        if (j > 0) {
            startTime = e2(j, H(T, PlayBackEventType.TYPE_TIMING.getValue()), H(T, PlayBackEventType.TYPE_MOTION.getValue()));
        }
        long j2 = startTime * 1000;
        l lVar = new l(this.q, j2, T);
        this.v = j2;
        this.w = T;
        this.g.postValue(new a<>(lVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p1 */
    public /* synthetic */ void q1(List list) throws Exception {
        List<j> x = x(list);
        if (!x.isEmpty()) {
            this.m.put(P(x.get(0)), x);
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, List<j>> entry : this.m.entrySet()) {
                arrayList.addAll(entry.getValue());
            }
            this.k.postValue(arrayList);
            return;
        }
        this.k.postValue(new ArrayList());
    }

    private boolean s0(long j, long j2) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(j2);
        O1(instance);
        O1(instance2);
        return u0(instance, instance2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s1 */
    public /* synthetic */ t t1(Integer num) throws Exception {
        if (this.q > 0) {
            return B();
        }
        return l0().N(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.a5
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return PlayBackRepository.this.b1((Response) obj);
            }
        });
    }

    private boolean t(Date date) {
        return this.m.containsKey(Q(date));
    }

    private boolean t0(j jVar, Date date) {
        Calendar instance = Calendar.getInstance();
        instance.set(1, jVar.c());
        instance.set(2, jVar.b());
        instance.set(5, jVar.a());
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(date);
        return u0(instance, instance2);
    }

    private boolean u(long j, List<j> list) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        O1(instance);
        Calendar instance2 = Calendar.getInstance();
        for (j jVar : list) {
            instance2.set(1, jVar.c());
            instance2.set(2, jVar.b());
            instance2.set(5, jVar.a());
            O1(instance2);
            if (u0(instance2, instance)) {
                return true;
            }
        }
        return false;
    }

    private boolean u0(Calendar calendar, Calendar calendar2) {
        return calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2) && calendar.get(5) == calendar2.get(5);
    }

    private boolean v(long j) {
        if (this.x.p()) {
            long h = this.x.h(j, 0);
            long g = this.x.g(j, 0);
            boolean z = h < g;
            if (z && this.x.q(j, h, g)) {
                return true;
            }
            if (!z && this.x.r(j, h, g)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v0 */
    public /* synthetic */ t w0(Timezone timezone) throws Exception {
        this.y = TimeZone.getTimeZone(timezone.getZoneId());
        i iVar = new i();
        iVar.c(0);
        iVar.d(100);
        return a2(iVar, this.y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w1 */
    public /* synthetic */ boolean x1(Throwable th) throws Exception {
        if (!(th instanceof CameraException) || ((CameraException) th).getErrorCode() != -71103) {
            return false;
        }
        r0();
        return true;
    }

    private List<j> x(List<YearlyPlaybackItem> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (YearlyPlaybackItem yearlyPlaybackItem : list) {
                Date parse = new SimpleDateFormat("yyyyMMdd", Locale.US).parse(yearlyPlaybackItem.getDate(), new ParsePosition(0));
                if (parse != null) {
                    Calendar instance = Calendar.getInstance();
                    instance.setTime(parse);
                    arrayList.add(new j(instance.get(1), instance.get(2), instance.get(5)));
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x0 */
    public /* synthetic */ void y0(DetectionList detectionList) throws Exception {
        List<SnapshotPlaybackItem> detectionList2 = detectionList.getDetectionList();
        boolean z = detectionList.getSnapshotEnable() != null && detectionList.getSnapshotEnable().booleanValue();
        long j = 0;
        if (!this.n.isEmpty()) {
            List<DailyPlaybackItem> list = this.n;
            j = list.get(list.size() - 1).getEndTime();
        }
        if (detectionList2 != null) {
            this.j.postValue(G(detectionList2, z, this.r, j));
        } else {
            this.j.setValue(new n());
        }
    }

    private Date y(j jVar) {
        Calendar instance = Calendar.getInstance();
        instance.set(1, jVar.c());
        instance.set(2, jVar.b());
        instance.set(5, jVar.a());
        return instance.getTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y1 */
    public /* synthetic */ t z1(long j, k kVar) throws Exception {
        this.x = kVar;
        long f2 = kVar.f();
        this.t = f2;
        this.h.postValue(new a<>(Long.valueOf(f2)));
        this.r.setTimeInMillis(kVar.f());
        this.s.setTimeInMillis(kVar.f());
        O1(this.r);
        O1(this.s);
        return d2(f2, j);
    }

    private List<DailyPlaybackItem> z(DailyPlaybackItem dailyPlaybackItem, long j, Calendar calendar) {
        ArrayList arrayList = new ArrayList();
        DailyPlaybackItem dailyPlaybackItem2 = new DailyPlaybackItem(dailyPlaybackItem.getStartTime(), j - 1, dailyPlaybackItem.getType());
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(dailyPlaybackItem2.getStartTime() * 1000);
        O1(instance);
        if (u0(instance, calendar)) {
            arrayList.add(dailyPlaybackItem2);
        }
        DailyPlaybackItem dailyPlaybackItem3 = new DailyPlaybackItem(j, dailyPlaybackItem.getEndTime(), dailyPlaybackItem.getType());
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(dailyPlaybackItem3.getStartTime() * 1000);
        O1(instance2);
        if (u0(instance2, calendar)) {
            arrayList.add(dailyPlaybackItem3);
        }
        return arrayList;
    }

    public void F(boolean z, boolean z2) {
        int[] iArr = new int[0];
        if (z && z2) {
            iArr = new int[]{1, 2};
        } else if (!z && z2) {
            iArr = new int[]{2};
        } else if (z && !z2) {
            iArr = new int[]{1};
        }
        if (!this.n.isEmpty()) {
            long S = S(this.n, z, z2);
            if (S < 0) {
                S = this.n.get(0).getStartTime();
            }
            if (iArr.length == 0) {
                iArr = T(this.n);
            }
            long j = S * 1000;
            l lVar = new l(this.q, j, iArr);
            this.v = j;
            this.w = iArr;
            this.g.postValue(new a<>(lVar));
        }
    }

    public long J() {
        return this.u;
    }

    public Calendar K() {
        return this.r;
    }

    public boolean N1(long j) {
        if (!this.x.p()) {
            return false;
        }
        long g = this.x.g(j, 0);
        return j > g - ((long) this.x.k()) && j <= g;
    }

    public void O1(Calendar calendar) {
        int k;
        int j = this.x.j();
        if (this.x.p()) {
            boolean z = false;
            long h = this.x.h(calendar.getTimeInMillis(), 0);
            long g = this.x.g(calendar.getTimeInMillis(), 0);
            if (h < g) {
                z = true;
            }
            if (!z || !this.x.q(calendar.getTimeInMillis(), h, g)) {
                if (z || !this.x.r(calendar.getTimeInMillis(), h, g)) {
                    if (this.x.o()) {
                        j -= this.x.k();
                    }
                } else if (!this.x.o()) {
                    k = this.x.k();
                    j += k;
                }
            } else if (!this.x.o()) {
                k = this.x.k();
                j += k;
            }
        }
        P1(calendar, j);
    }

    public int Q1(long j) {
        if (this.x.p()) {
            long g = this.x.g(j, 0);
            long j2 = j - g;
            if (j2 > 0 && j2 < 86400000 && s0(j, g)) {
                return this.x.k() / 1000;
            }
        }
        return 0;
    }

    public TimeZone R() {
        k kVar = this.x;
        TimeZone l = kVar != null ? kVar.l() : null;
        return l != null ? l : this.y;
    }

    public void R1() {
        S1(-1L);
    }

    public void S1(long j) {
        if (this.w == null) {
            this.w = T(this.n);
        }
        if (j > 0 && j != this.v) {
            this.v = j * 1000;
        }
        this.g.postValue(new a<>(new l(this.q, this.v, this.w)));
    }

    public q<Boolean> T1(CameraComponent cameraComponent) {
        return V1(cameraComponent).v0(1L, new io.reactivex.g0.l() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.k5
            @Override // io.reactivex.g0.l
            public final boolean test(Object obj) {
                return PlayBackRepository.this.d1((Throwable) obj);
            }
        });
    }

    public long W() {
        return this.t;
    }

    public k Y() {
        return this.x;
    }

    public q<Boolean> Y1(long j) {
        Date U = U(j);
        Date V = V(j);
        if (t(new Date(j))) {
            return q.f0(Boolean.TRUE);
        }
        return m0(l(), U, V).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.b5
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                PlayBackRepository.this.q1((List) obj);
            }
        }).g0(e4.f14385c).C(f7.f14400c);
    }

    public MutableLiveData<Boolean> Z() {
        return this.f14314e;
    }

    public MutableLiveData<m> a0() {
        return this.i;
    }

    public MutableLiveData<a<Long>> b0() {
        return this.h;
    }

    public q<Boolean> b2() {
        return Z1().v0(1L, new io.reactivex.g0.l() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.o4
            @Override // io.reactivex.g0.l
            public final boolean test(Object obj) {
                return PlayBackRepository.this.x1((Throwable) obj);
            }
        });
    }

    public MutableLiveData<a<l>> c0() {
        return this.g;
    }

    public q<CameraComponent> c2(final CameraComponent cameraComponent, long j, final long j2) {
        return X(cameraComponent, j).N(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.j5
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return PlayBackRepository.this.z1(j2, (k) obj);
            }
        }).N(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.r4
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return PlayBackRepository.this.B1(cameraComponent, (l) obj);
            }
        }).v0(1L, new io.reactivex.g0.l() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.z4
            @Override // io.reactivex.g0.l
            public final boolean test(Object obj) {
                return PlayBackRepository.this.D1((Throwable) obj);
            }
        }).l0(io.reactivex.d0.b.a.a()).E(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.d4
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                PlayBackRepository.this.F1(j2, (List) obj);
            }
        }).o0(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.r5
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return PlayBackRepository.this.H1((Throwable) obj);
            }
        }).g0(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.p4
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                CameraComponent cameraComponent2 = CameraComponent.this;
                PlayBackRepository.I1(cameraComponent2, (List) obj);
                return cameraComponent2;
            }
        });
    }

    public MutableLiveData<a<Integer>> d0() {
        return this.l;
    }

    public MutableLiveData<List<j>> e0() {
        return this.k;
    }

    public MutableLiveData<Boolean> f0() {
        return this.f14315f;
    }

    public void f2(int i, boolean z, boolean z2, boolean z3) {
        Calendar calendar = this.r;
        if (calendar != null) {
            int i2 = calendar.get(1);
            int i3 = this.r.get(2);
            int i4 = this.r.get(5);
            long m = this.x.m(i2, i3, i4, i / 3600, (i / 60) % 60, i % 60);
            if (z) {
                m -= this.x.k() / 1000;
            }
            long e2 = e2(m, z2, z3) * 1000;
            l lVar = new l(this.q, e2, null);
            this.v = e2;
            this.g.postValue(new a<>(lVar));
        }
    }

    public MutableLiveData<n> g0() {
        return this.j;
    }

    public void g2(long j, boolean z, boolean z2) {
        long e2 = e2(j, z, z2) * 1000;
        l lVar = new l(this.q, e2, null);
        this.v = e2;
        this.g.postValue(new a<>(lVar));
    }

    public void h2(int i, int i2, int i3) {
        if (this.r == null) {
            this.r = Calendar.getInstance();
        }
        this.r.set(1, i);
        this.r.set(2, i2);
        this.r.set(5, i3);
    }

    public void i2(long j) {
        this.v = j;
    }

    public Calendar j0() {
        return this.s;
    }

    public int k0() {
        return this.q;
    }

    public void q0() {
        Calendar instance = Calendar.getInstance();
        this.r = instance;
        instance.setTimeInMillis(System.currentTimeMillis());
        Calendar instance2 = Calendar.getInstance();
        this.s = instance2;
        instance2.setTimeInMillis(this.r.getTimeInMillis());
        this.v = System.currentTimeMillis();
        this.t = System.currentTimeMillis();
        this.u = System.currentTimeMillis();
        this.x = new k();
        this.m.clear();
        this.n.clear();
        this.o.clear();
        this.p.clear();
        this.i.setValue(new m());
        this.j.setValue(new n());
        this.k.setValue(new ArrayList());
    }

    public void r0() {
        this.q = -1;
    }

    public boolean s(Date date) {
        List<j> list;
        String Q = Q(date);
        if (!this.m.containsKey(Q) || (list = this.m.get(Q)) == null) {
            return false;
        }
        for (j jVar : list) {
            if (t0(jVar, date)) {
                return true;
            }
        }
        return false;
    }

    public boolean w(long j, boolean z, boolean z2) {
        if (!z || !z2) {
            if (!z || z2) {
                if (z || !z2 || this.p.isEmpty()) {
                    return false;
                }
                List<DailyPlaybackItem> list = this.p;
                return Math.abs((j / 1000) - list.get(list.size() - 1).getEndTime()) <= 0;
            } else if (this.o.isEmpty()) {
                return false;
            } else {
                List<DailyPlaybackItem> list2 = this.o;
                return Math.abs((j / 1000) - list2.get(list2.size() - 1).getEndTime()) <= 0;
            }
        } else if (this.n.isEmpty()) {
            return false;
        } else {
            List<DailyPlaybackItem> list3 = this.n;
            return Math.abs((j / 1000) - list3.get(list3.size() - 1).getEndTime()) <= 0;
        }
    }
}
