package com.tplink.iot.viewmodel.ipcamera.play;

import android.app.Application;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableFloat;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tplink.iot.R;
import com.tplink.iot.Utils.q0;
import com.tplink.iot.Utils.s;
import com.tplink.iot.view.ipcamera.widget.calendar.d;
import com.tplink.libmediaapi.common.apicallback.VodStreamDisplayCallback;
import com.tplink.libmediaapi.vod.VodMediaAPI;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.model.j;
import com.tplink.libtpnetwork.cameranetwork.business.model.l;
import com.tplink.libtpnetwork.cameranetwork.business.model.m;
import com.tplink.libtpnetwork.cameranetwork.business.model.n;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.PlayBackRepository;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import com.tplink.libtpnetwork.cameranetwork.net.CameraException;
import io.reactivex.e0.b;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.q;
import io.reactivex.t;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;

/* loaded from: classes3.dex */
public class PlayBackControlViewModel extends AndroidViewModel implements VodStreamDisplayCallback {
    private final PlayBackRepository K3;
    private String L3;
    private PlaybackMainViewModel M3;
    public long P3;
    public ObservableField<VodPlayRate> r4;
    public ObservableField<String> s4;
    public VodPlayRate t4;
    private CommonCameraRepository v4;

    /* renamed from: c  reason: collision with root package name */
    private final String f10549c = "PlayBackControlViewModel";

    /* renamed from: d  reason: collision with root package name */
    private final MutableLiveData<a<Integer>> f10550d = new MutableLiveData<>();

    /* renamed from: f  reason: collision with root package name */
    private final MutableLiveData<a<Boolean>> f10551f = new MutableLiveData<>();
    private final MutableLiveData<a<Boolean>> q = new MutableLiveData<>();
    private final MediatorLiveData<Boolean> x = new MediatorLiveData<>();
    private final MediatorLiveData<Boolean> y = new MediatorLiveData<>();
    private final MediatorLiveData<List<com.tplink.iot.j.c.a>> z = new MediatorLiveData<>();
    private final Set<Integer> p0 = new HashSet();
    private final MediatorLiveData<List<Integer>> p1 = new MediatorLiveData<>();
    private final MediatorLiveData<m> p2 = new MediatorLiveData<>();
    private final MediatorLiveData<a<l>> p3 = new MediatorLiveData<>();
    private final MediatorLiveData<a<Long>> H3 = new MediatorLiveData<>();
    private final MediatorLiveData<List<j>> I3 = new MediatorLiveData<>();
    private final MediatorLiveData<a<Integer>> J3 = new MediatorLiveData<>();
    private boolean N3 = false;
    public ObservableField<String> O3 = new ObservableField<>();
    public ObservableField<String> Q3 = new ObservableField<>();
    public ObservableBoolean R3 = new ObservableBoolean(true);
    public ObservableBoolean S3 = new ObservableBoolean(true);
    public ObservableBoolean T3 = new ObservableBoolean(false);
    public ObservableBoolean U3 = new ObservableBoolean(false);
    public ObservableBoolean V3 = new ObservableBoolean(false);
    public ObservableBoolean W3 = new ObservableBoolean(true);
    public ObservableBoolean X3 = new ObservableBoolean(false);
    public final MutableLiveData<Boolean> Y3 = new MutableLiveData<>(Boolean.FALSE);
    public final ObservableBoolean Z3 = new ObservableBoolean(true);
    public ObservableBoolean a4 = new ObservableBoolean(false);
    public ObservableBoolean b4 = new ObservableBoolean(true);
    public ObservableBoolean c4 = new ObservableBoolean(true);
    public ObservableBoolean d4 = new ObservableBoolean(true);
    public ObservableField<d> e4 = new ObservableField<>();
    public ObservableField<List<d>> f4 = new ObservableField<>();
    public ObservableField<d> g4 = new ObservableField<>();
    public ObservableField<Calendar> h4 = new ObservableField<>();
    public ObservableField<d> i4 = new ObservableField<>();
    public ObservableFloat j4 = new ObservableFloat();
    public ObservableInt k4 = new ObservableInt();
    public ObservableField<Pair<ArrayList<int[]>, ArrayList<int[]>>> l4 = new ObservableField<>();
    public ObservableField<List<ArrayList<int[]>>> m4 = new ObservableField<>();
    public ObservableBoolean n4 = new ObservableBoolean(false);
    public ObservableInt o4 = new ObservableInt();
    public ObservableInt p4 = new ObservableInt();
    public ObservableBoolean q4 = new ObservableBoolean(false);
    private b u4 = new b();

    public PlayBackControlViewModel(@NonNull Application application, TPCameraDeviceContext tPCameraDeviceContext) {
        super(application);
        J();
        this.K3 = (PlayBackRepository) e.b(tPCameraDeviceContext, PlayBackRepository.class);
        j0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int N(com.tplink.iot.j.c.a aVar, com.tplink.iot.j.c.a aVar2) {
        return (int) (aVar2.d() - aVar.d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O */
    public /* synthetic */ void P(Throwable th) throws Exception {
        if (!(th instanceof CameraException)) {
            return;
        }
        if (((CameraException) th).getErrorCode() == -71101) {
            this.K3.r0();
            PlaybackMainViewModel playbackMainViewModel = this.M3;
            if (playbackMainViewModel != null) {
                playbackMainViewModel.y(getApplication().getString(R.string.camera_playback_too_many_viewer));
                return;
            }
            return;
        }
        this.K3.r0();
        PlaybackMainViewModel playbackMainViewModel2 = this.M3;
        if (playbackMainViewModel2 != null) {
            playbackMainViewModel2.y(getApplication().getString(R.string.common_operation_failed));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0128 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x012d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0132 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0137 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x013c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0141 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0062 A[SYNTHETIC] */
    /* renamed from: R */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ void S(com.tplink.libtpnetwork.cameranetwork.business.model.n r23) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 498
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.viewmodel.ipcamera.play.PlayBackControlViewModel.S(com.tplink.libtpnetwork.cameranetwork.business.model.n):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T */
    public /* synthetic */ void U() throws Exception {
        this.Z3.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V */
    public /* synthetic */ t W(CameraComponent cameraComponent) throws Exception {
        return q.f1(this.K3.T1(cameraComponent).C(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.play.d1
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                PlayBackControlViewModel.this.P((Throwable) obj);
            }
        }), p0(cameraComponent), k1.f10622c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X */
    public /* synthetic */ void Y(c cVar) throws Exception {
        this.u4.b(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z */
    public /* synthetic */ void a0(Throwable th) throws Exception {
        if (!(th instanceof CameraException)) {
            return;
        }
        if (((CameraException) th).getErrorCode() == -71101) {
            this.K3.r0();
            PlaybackMainViewModel playbackMainViewModel = this.M3;
            if (playbackMainViewModel != null) {
                playbackMainViewModel.y(getApplication().getString(R.string.camera_playback_too_many_viewer));
                return;
            }
            return;
        }
        this.K3.r0();
        PlaybackMainViewModel playbackMainViewModel2 = this.M3;
        if (playbackMainViewModel2 != null) {
            playbackMainViewModel2.y(getApplication().getString(R.string.common_operation_failed));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b0 */
    public /* synthetic */ t c0(long j, long j2, CameraComponent cameraComponent) throws Exception {
        return this.K3.c2(cameraComponent, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d0 */
    public /* synthetic */ t e0(CameraComponent cameraComponent) throws Exception {
        if (cameraComponent.isSupportSnapshot()) {
            return this.K3.b2();
        }
        this.X3.set(false);
        MutableLiveData<Boolean> mutableLiveData = this.Y3;
        Boolean bool = Boolean.FALSE;
        mutableLiveData.postValue(bool);
        return q.f0(bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f0 */
    public /* synthetic */ void g0() throws Exception {
        this.Z3.set(false);
    }

    private List<Integer> i() {
        return new ArrayList(this.p0);
    }

    private void j0() {
        this.p0.clear();
        this.x.removeSource(this.K3.Z());
        MediatorLiveData<Boolean> mediatorLiveData = this.x;
        MutableLiveData<Boolean> Z = this.K3.Z();
        MediatorLiveData<Boolean> mediatorLiveData2 = this.x;
        mediatorLiveData2.getClass();
        mediatorLiveData.addSource(Z, new y2(mediatorLiveData2));
        this.y.removeSource(this.K3.f0());
        MediatorLiveData<Boolean> mediatorLiveData3 = this.y;
        MutableLiveData<Boolean> f0 = this.K3.f0();
        MediatorLiveData<Boolean> mediatorLiveData4 = this.y;
        mediatorLiveData4.getClass();
        mediatorLiveData3.addSource(f0, new y2(mediatorLiveData4));
        this.p2.removeSource(this.K3.a0());
        MediatorLiveData<m> mediatorLiveData5 = this.p2;
        MutableLiveData<m> a0 = this.K3.a0();
        final MediatorLiveData<m> mediatorLiveData6 = this.p2;
        mediatorLiveData6.getClass();
        mediatorLiveData5.addSource(a0, new Observer() { // from class: com.tplink.iot.viewmodel.ipcamera.play.u2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MediatorLiveData.this.setValue((m) obj);
            }
        });
        this.p3.removeSource(this.K3.c0());
        MediatorLiveData<a<l>> mediatorLiveData7 = this.p3;
        MutableLiveData<a<l>> c0 = this.K3.c0();
        final MediatorLiveData<a<l>> mediatorLiveData8 = this.p3;
        mediatorLiveData8.getClass();
        mediatorLiveData7.addSource(c0, new Observer() { // from class: com.tplink.iot.viewmodel.ipcamera.play.x2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MediatorLiveData.this.setValue((a) obj);
            }
        });
        this.H3.removeSource(this.K3.b0());
        MediatorLiveData<a<Long>> mediatorLiveData9 = this.H3;
        MutableLiveData<a<Long>> b0 = this.K3.b0();
        final MediatorLiveData<a<Long>> mediatorLiveData10 = this.H3;
        mediatorLiveData10.getClass();
        mediatorLiveData9.addSource(b0, new Observer() { // from class: com.tplink.iot.viewmodel.ipcamera.play.x2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MediatorLiveData.this.setValue((a) obj);
            }
        });
        this.I3.removeSource(this.K3.e0());
        MediatorLiveData<List<j>> mediatorLiveData11 = this.I3;
        MutableLiveData<List<j>> e0 = this.K3.e0();
        final MediatorLiveData<List<j>> mediatorLiveData12 = this.I3;
        mediatorLiveData12.getClass();
        mediatorLiveData11.addSource(e0, new Observer() { // from class: com.tplink.iot.viewmodel.ipcamera.play.a1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MediatorLiveData.this.setValue((List) obj);
            }
        });
        this.J3.removeSource(this.K3.d0());
        MediatorLiveData<a<Integer>> mediatorLiveData13 = this.J3;
        MutableLiveData<a<Integer>> d0 = this.K3.d0();
        final MediatorLiveData<a<Integer>> mediatorLiveData14 = this.J3;
        mediatorLiveData14.getClass();
        mediatorLiveData13.addSource(d0, new Observer() { // from class: com.tplink.iot.viewmodel.ipcamera.play.x2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MediatorLiveData.this.setValue((a) obj);
            }
        });
        this.z.removeSource(this.K3.g0());
        this.z.addSource(this.K3.g0(), new Observer() { // from class: com.tplink.iot.viewmodel.ipcamera.play.g1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PlayBackControlViewModel.this.k0((n) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(n nVar) {
        q.f0(nVar).L0(io.reactivex.l0.a.c()).E(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.play.l1
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                PlayBackControlViewModel.this.S((n) obj);
            }
        }).C(w2.f10665c).F0();
    }

    private q<Boolean> p0(CameraComponent cameraComponent) {
        if (cameraComponent.isSupportSnapshot()) {
            return this.K3.b2();
        }
        this.X3.set(false);
        MutableLiveData<Boolean> mutableLiveData = this.Y3;
        Boolean bool = Boolean.FALSE;
        mutableLiveData.postValue(bool);
        return q.f0(bool);
    }

    public MutableLiveData<List<com.tplink.iot.j.c.a>> A() {
        return this.z;
    }

    public void A0(Calendar calendar) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(o());
        E0(instance);
        boolean e2 = q0.e(instance.getTime(), calendar.getTime());
        this.R3.set(e2);
        this.T3.set(!e2);
        this.Q3.set(e2 ? getApplication().getString(R.string.play_back_today) : new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(calendar.getTime()));
    }

    public int B(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j * 1000);
        E0(instance);
        return (instance.get(11) * 3600) + (instance.get(12) * 60) + instance.get(13);
    }

    public void B0(Calendar calendar) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(o());
        E0(instance);
        boolean h = q0.h(instance.getTime(), calendar.getTime());
        this.S3.set(h);
        this.T3.set(!h);
        this.Q3.set(new SimpleDateFormat("yyyy-MM", Locale.US).format(calendar.getTime()));
    }

    public Calendar C() {
        PlayBackRepository playBackRepository = this.K3;
        if (playBackRepository != null) {
            return playBackRepository.j0();
        }
        return Calendar.getInstance();
    }

    public void C0(LifecycleOwner lifecycleOwner) {
    }

    public MutableLiveData<List<Integer>> D() {
        return this.p1;
    }

    public void D0() {
        PlayBackRepository playBackRepository = this.K3;
        if (playBackRepository != null) {
            A0(playBackRepository.K());
        }
    }

    public void E() {
        if (this.K3 != null) {
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(o());
            E0(instance);
            u0(instance.get(1), instance.get(2), instance.get(5));
            if (this.K3.s(instance.getTime())) {
                this.x.postValue(Boolean.TRUE);
            } else {
                this.x.postValue(Boolean.FALSE);
            }
            n0();
        }
    }

    public void E0(Calendar calendar) {
        PlayBackRepository playBackRepository = this.K3;
        if (playBackRepository != null) {
            playBackRepository.O1(calendar);
        }
    }

    public void F() {
        PlayBackRepository playBackRepository = this.K3;
        if (playBackRepository != null) {
            playBackRepository.K().add(5, 1);
            A0(this.K3.K());
            n0();
        }
    }

    public void G() {
        PlayBackRepository playBackRepository = this.K3;
        if (playBackRepository != null) {
            playBackRepository.j0().add(2, 1);
            this.i4.set(new d(this.K3.j0().get(1), this.K3.j0().get(2) + 1, 1));
            this.q.postValue(new a<>(Boolean.valueOf(q0.g(this.K3.j0(), this.K3.K()))));
            B0(this.K3.j0());
            o0(this.K3.j0().getTimeInMillis());
        }
    }

    public void H() {
        PlayBackRepository playBackRepository = this.K3;
        if (playBackRepository != null) {
            playBackRepository.K().add(5, -1);
            A0(this.K3.K());
            n0();
        }
    }

    public void I() {
        PlayBackRepository playBackRepository = this.K3;
        if (playBackRepository != null) {
            playBackRepository.j0().add(2, -1);
            this.i4.set(new d(this.K3.j0().get(1), this.K3.j0().get(2) + 1, 1));
            this.q.postValue(new a<>(Boolean.valueOf(q0.g(this.K3.j0(), this.K3.K()))));
            B0(this.K3.j0());
            o0(this.K3.j0().getTimeInMillis());
        }
    }

    public void J() {
        PlayBackRepository playBackRepository = this.K3;
        if (playBackRepository != null) {
            playBackRepository.q0();
        }
        this.Q3.set(getApplication().getString(R.string.play_back_today));
        this.P3 = System.currentTimeMillis();
    }

    public void K(PlaybackMainViewModel playbackMainViewModel) {
        String str = playbackMainViewModel.f10555e;
        this.L3 = str;
        this.v4 = (CommonCameraRepository) e.c(str, CommonCameraRepository.class);
        this.M3 = playbackMainViewModel;
    }

    public void L() {
        PlayBackRepository playBackRepository = this.K3;
        if (playBackRepository != null) {
            playBackRepository.r0();
        }
    }

    public void f(boolean z) {
        PlayBackRepository playBackRepository = this.K3;
        if (playBackRepository != null) {
            playBackRepository.j0().setTimeInMillis(this.K3.K().getTimeInMillis());
            if (z) {
                B0(this.K3.j0());
            } else {
                A0(this.K3.j0());
                o0(this.K3.K().getTimeInMillis());
            }
            this.q.postValue(new a<>(Boolean.valueOf(q0.g(this.K3.j0(), this.K3.K()))));
        }
    }

    public void g(String str, String str2, ObservableField<VodPlayRate> observableField, ObservableField<String> observableField2, VodPlayRate vodPlayRate) {
        b.d.w.c.a.c("PlayBackControlViewModel", "currentTimestamp " + this.P3);
        this.r4 = observableField;
        this.s4 = observableField2;
        this.t4 = vodPlayRate;
        VodMediaAPI.changeVodPlayRate(str, str2, this.P3 / 1000);
    }

    public boolean h(long j) {
        PlayBackRepository playBackRepository = this.K3;
        if (playBackRepository != null) {
            return playBackRepository.w(j, this.a4.get(), this.c4.get());
        }
        return false;
    }

    public boolean h0(long j) {
        PlayBackRepository playBackRepository = this.K3;
        if (playBackRepository != null) {
            return playBackRepository.N1(j);
        }
        return false;
    }

    public int i0(long j) {
        PlayBackRepository playBackRepository = this.K3;
        if (playBackRepository != null) {
            return playBackRepository.Q1(j);
        }
        return 0;
    }

    public void j() {
        PlayBackRepository playBackRepository = this.K3;
        if (playBackRepository != null) {
            playBackRepository.F(this.a4.get(), this.c4.get());
        }
    }

    public long k() {
        long currentTimeMillis = System.currentTimeMillis();
        PlayBackRepository playBackRepository = this.K3;
        return playBackRepository != null ? playBackRepository.J() : currentTimeMillis;
    }

    public Calendar l() {
        PlayBackRepository playBackRepository = this.K3;
        if (playBackRepository != null) {
            return playBackRepository.K();
        }
        return Calendar.getInstance();
    }

    public void l0() {
        PlayBackRepository playBackRepository = this.K3;
        if (playBackRepository != null) {
            playBackRepository.R1();
        }
    }

    public int m(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j * 1000);
        E0(instance);
        return instance.get(6) - l().get(6);
    }

    public void m0(long j) {
        PlayBackRepository playBackRepository = this.K3;
        if (playBackRepository != null) {
            playBackRepository.S1(j);
        }
    }

    public TimeZone n() {
        PlayBackRepository playBackRepository = this.K3;
        if (playBackRepository != null) {
            return playBackRepository.R();
        }
        return null;
    }

    public void n0() {
        this.W3.set(true);
        this.V3.set(false);
        this.U3.set(false);
        if (this.K3 != null) {
            int i = l().get(1);
            int i2 = l().get(2);
            this.g4.set(new d(i, i2 + 1, l().get(5)));
        }
        if (this.K3 != null) {
            this.Z3.set(true);
            this.v4.K0().N(new io.reactivex.g0.j() { // from class: com.tplink.iot.viewmodel.ipcamera.play.j1
                @Override // io.reactivex.g0.j
                public final Object apply(Object obj) {
                    return PlayBackControlViewModel.this.W((CameraComponent) obj);
                }
            }).F(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.play.m1
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    PlayBackControlViewModel.this.Y((c) obj);
                }
            }).C(w2.f10665c).y(new io.reactivex.g0.a() { // from class: com.tplink.iot.viewmodel.ipcamera.play.i1
                @Override // io.reactivex.g0.a
                public final void run() {
                    PlayBackControlViewModel.this.U();
                }
            }).L0(io.reactivex.l0.a.c()).F0();
            return;
        }
        this.p3.postValue(new a<>(new l(-1, -1L, null)));
    }

    public long o() {
        long currentTimeMillis = System.currentTimeMillis();
        PlayBackRepository playBackRepository = this.K3;
        return playBackRepository != null ? playBackRepository.W() : currentTimeMillis;
    }

    public void o0(long j) {
        this.u4.b(this.K3.Y1(j).C(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.play.h1
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                PlayBackControlViewModel.this.a0((Throwable) obj);
            }
        }).F0());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.u4.dispose();
    }

    public MutableLiveData<Boolean> p() {
        return this.x;
    }

    public void q0(long j) {
        r0(j, 0L);
    }

    public MutableLiveData<a<Boolean>> r() {
        return this.q;
    }

    public void r0(final long j, final long j2) {
        this.Z3.set(true);
        if (j2 > 0 && j >= j2) {
            long j3 = j / 1000;
            if (j3 - j2 > 252288000) {
                j2 = j3 - 252288000;
            }
        }
        this.u4.b(this.v4.K0().N(new io.reactivex.g0.j() { // from class: com.tplink.iot.viewmodel.ipcamera.play.e1
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return PlayBackControlViewModel.this.c0(j, j2, (CameraComponent) obj);
            }
        }).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).N(new io.reactivex.g0.j() { // from class: com.tplink.iot.viewmodel.ipcamera.play.b1
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return PlayBackControlViewModel.this.e0((CameraComponent) obj);
            }
        }).y(new io.reactivex.g0.a() { // from class: com.tplink.iot.viewmodel.ipcamera.play.f1
            @Override // io.reactivex.g0.a
            public final void run() {
                PlayBackControlViewModel.this.g0();
            }
        }).F0());
    }

    public MutableLiveData<m> s() {
        return this.p2;
    }

    public void s0(int i, boolean z) {
        PlayBackRepository playBackRepository = this.K3;
        if (playBackRepository != null) {
            playBackRepository.f2(i, z, this.a4.get(), this.c4.get());
        }
    }

    @Override // com.tplink.libmediaapi.common.apicallback.VodStreamDisplayCallback
    public void showDisplayProgress(long j) {
        if (!this.N3 && !VodMediaAPI.isFlushing(this.L3)) {
            v0(j);
            this.f10550d.postValue(new a<>(Integer.valueOf(B(j / 1000) + i0(j))));
            if (h(j)) {
                b.d.w.c.a.c("TTTT", "get last");
                this.f10551f.postValue(new a<>(Boolean.TRUE));
            }
            PlayBackRepository playBackRepository = this.K3;
            if (playBackRepository != null) {
                playBackRepository.i2(j);
            }
            if (this.n4.get()) {
                this.q4.set(h0(j));
            } else {
                this.q4.set(false);
            }
        }
    }

    public MutableLiveData<a<Long>> t() {
        return this.H3;
    }

    public void t0(long j) {
        PlayBackRepository playBackRepository = this.K3;
        if (playBackRepository != null) {
            playBackRepository.g2(j, this.a4.get(), this.c4.get());
        }
    }

    public MutableLiveData<a<l>> u() {
        return this.p3;
    }

    public void u0(int i, int i2, int i3) {
        PlayBackRepository playBackRepository = this.K3;
        if (playBackRepository != null) {
            playBackRepository.h2(i, i2, i3);
            A0(this.K3.K());
        }
    }

    public MediatorLiveData<a<Integer>> v() {
        return this.J3;
    }

    public void v0(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        E0(instance);
        this.O3.set(new SimpleDateFormat("HH:mm:ss", Locale.US).format(instance.getTime()));
        this.P3 = j;
    }

    @Override // com.tplink.libmediaapi.common.apicallback.VodStreamDisplayCallback
    public void vodPlayRate(boolean z, float f2) {
        VodPlayRate vodPlayRate;
        b.d.w.c.a.c("PlayBackControlViewModel", "play rate success " + z + " rate " + f2);
        if (!z) {
            ObservableField<VodPlayRate> observableField = this.r4;
            if (!(observableField == null || this.s4 == null || (vodPlayRate = this.t4) == null)) {
                observableField.set(vodPlayRate);
                this.s4.set(this.t4.getValue());
            }
            PlaybackMainViewModel playbackMainViewModel = this.M3;
            if (playbackMainViewModel != null) {
                playbackMainViewModel.y(getApplication().getString(R.string.general_failed));
            }
        }
        this.r4 = null;
        this.s4 = null;
        this.t4 = null;
    }

    @Override // com.tplink.libmediaapi.common.apicallback.VodStreamDisplayCallback
    public void vodSeekTime(boolean z) {
        b.d.w.c.a.c("PlayBackControlViewModel", "seek time success " + z);
        if (!z) {
            this.M3.m.set(true);
        }
    }

    public MutableLiveData<List<j>> w() {
        return this.I3;
    }

    public void w0(List<Integer> list) {
        this.p0.clear();
        if (!s.b(list)) {
            this.p0.addAll(list);
        }
        this.p1.postValue(i());
    }

    public MutableLiveData<a<Boolean>> x() {
        return this.f10551f;
    }

    public void x0() {
        VodMediaAPI.setVodStreamDisplayCallback(this.L3, this);
    }

    public MutableLiveData<a<Integer>> y() {
        return this.f10550d;
    }

    public void y0(int i, boolean z) {
        Calendar instance = Calendar.getInstance();
        instance.set(1, this.K3.K().get(1));
        instance.set(2, this.K3.K().get(2));
        instance.set(5, this.K3.K().get(5));
        instance.set(11, i / 3600);
        instance.set(12, (i % 3600) / 60);
        instance.set(13, i % 60);
        if (this.K3.R() != null) {
            instance.setTimeZone(this.K3.R());
        }
        if (z) {
            instance.add(11, -(this.K3.Y().k() / 3600000));
        }
        this.O3.set(String.format(Locale.US, "%02d:%02d:%02d", Integer.valueOf(instance.get(11)), Integer.valueOf(instance.get(12)), Integer.valueOf(instance.get(13))));
        if (this.n4.get()) {
            b.d.w.c.a.e("time:", instance.getTimeInMillis() + "");
            this.q4.set(h0(instance.getTimeInMillis()));
            return;
        }
        this.q4.set(false);
    }

    public MutableLiveData<Boolean> z() {
        return this.y;
    }

    public void z0(boolean z) {
        this.N3 = z;
    }
}
