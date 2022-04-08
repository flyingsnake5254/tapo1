package com.tplink.iot.view.ipcamera.play;

import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.k;
import com.tplink.iot.adapter.playback.RecordTypeAdapter;
import com.tplink.iot.adapter.playback.SnapshotAdapter;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.databinding.FragmentPlayBackControlBinding;
import com.tplink.iot.j.c.a;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.widget.calendar.b;
import com.tplink.iot.view.ipcamera.widget.calendar.c;
import com.tplink.iot.view.ipcamera.widget.calendar.d;
import com.tplink.iot.view.ipcamera.widget.timeaxis.TimeAxisLayout;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.play.PlayBackControlViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.PlaybackMainViewModel;
import com.tplink.libmediaapi.vod.VodMediaAPI;
import com.tplink.libtpnetwork.cameranetwork.business.model.PlayBackEventType;
import com.tplink.libtpnetwork.cameranetwork.business.model.j;
import com.tplink.libtpnetwork.cameranetwork.business.model.l;
import com.tplink.libtpnetwork.cameranetwork.business.model.m;
import com.tplink.libtpnetwork.cameranetwork.model.DailyPlaybackItem;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class PlayBackControlFragment extends BaseFragment implements g, b, c, TimeAxisLayout.b {
    private RecyclerView p0;
    private RecyclerView p1;
    private RecordTypeAdapter p2;
    private SnapshotAdapter.a p3 = new SnapshotAdapter.a() { // from class: com.tplink.iot.view.ipcamera.play.w0
        @Override // com.tplink.iot.adapter.playback.SnapshotAdapter.a
        public final void a(a aVar) {
            PlayBackControlFragment.this.I0(aVar);
        }
    };
    private FragmentPlayBackControlBinding q;
    private PlaybackMainViewModel x;
    private PlayBackControlViewModel y;
    private SnapshotAdapter z;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H0 */
    public /* synthetic */ void I0(a aVar) {
        this.y.t0(aVar.d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J0 */
    public /* synthetic */ void K0(List list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                j jVar = (j) it.next();
                arrayList.add(new d(jVar.c(), jVar.b() + 1, jVar.a()));
            }
            this.y.f4.set(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L0 */
    public /* synthetic */ void N0(Integer num) {
        if (num != null) {
            this.z.q(num.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O0 */
    public /* synthetic */ void P0(Boolean bool) {
        View findViewById = this.q.y.findViewById(R.id.play_back_ruler_layout);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        if (this.y.X3.get()) {
            layoutParams.height = k.a(getContext(), 106.0f);
        } else {
            layoutParams.height = k.a(getContext(), 152.0f);
        }
        layoutParams.width = -1;
        findViewById.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q0 */
    public /* synthetic */ void R0(List list) {
        this.p2.n(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S0 */
    public /* synthetic */ void T0(Boolean bool) {
        if (bool == null) {
            return;
        }
        if (bool.booleanValue()) {
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(this.y.k());
            this.y.E0(instance);
            this.y.g4.set(new d(instance.get(1), instance.get(2) + 1, instance.get(5)));
            return;
        }
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(this.y.k());
        this.y.E0(instance2);
        this.y.g4.set(new d(instance2.get(1), instance2.get(2) + 1, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U0 */
    public /* synthetic */ void V0(Boolean bool) {
        if (bool != null && bool.booleanValue() && this.y.k() != this.y.o()) {
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(this.y.k());
            this.y.E0(instance);
            this.y.u0(instance.get(1), instance.get(2), instance.get(5));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W0 */
    public /* synthetic */ void X0(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a aVar) {
        Boolean bool = (Boolean) aVar.a();
        if (bool != null && bool.booleanValue()) {
            int i = this.y.l().get(1);
            int i2 = this.y.l().get(2);
            this.y.g4.set(new d(i, i2 + 1, this.y.l().get(5)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y0 */
    public /* synthetic */ void Z0(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a aVar) {
        l lVar = (l) aVar.c();
        if (lVar != null) {
            this.y.z0(false);
            long j = lVar.a / 1000;
            if (j > 0) {
                long j2 = 1000 * j;
                this.y.k4.set(this.y.B(j + this.y.i0(j2)));
                this.y.v0(j2);
                return;
            }
            PlayBackControlViewModel playBackControlViewModel = this.y;
            int i0 = playBackControlViewModel.i0(playBackControlViewModel.o());
            PlayBackControlViewModel playBackControlViewModel2 = this.y;
            this.y.k4.set(playBackControlViewModel2.B(playBackControlViewModel2.o() / 1000) + i0);
            PlayBackControlViewModel playBackControlViewModel3 = this.y;
            playBackControlViewModel3.v0(playBackControlViewModel3.o());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a1 */
    public /* synthetic */ void b1(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a aVar) {
        Integer num = (Integer) aVar.a();
        if (num != null) {
            this.y.k4.set(num.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c1 */
    public /* synthetic */ void d1(m mVar) {
        boolean z;
        if (mVar == null || mVar.e().isEmpty()) {
            this.y.l4.set(new Pair<>(new ArrayList(), new ArrayList()));
            this.y.w0(new ArrayList());
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        this.y.n4.set(mVar.f());
        this.y.o4.set(mVar.c());
        this.y.p4.set(mVar.d());
        Iterator<DailyPlaybackItem> it = mVar.e().iterator();
        while (true) {
            z = false;
            if (!it.hasNext()) {
                break;
            }
            DailyPlaybackItem next = it.next();
            int B = this.y.B(next.getStartTime());
            int B2 = this.y.B(next.getEndTime());
            if (mVar.f() && next.getStartTime() >= mVar.a()) {
                B += mVar.b();
                B2 += mVar.b();
            }
            if (B2 < B) {
                b.d.w.c.a.c("VideoPlay.PlayBackControlFragment", "startTime " + B + " endTime " + B2);
                if (this.y.m(next.getStartTime()) < 0) {
                    B = 0;
                } else {
                    B2 = 86399;
                }
            }
            if (PlayBackEventType.TYPE_MOTION.getName().equals(next.getType())) {
                arrayList2.add(new int[]{B, B2});
            } else if (PlayBackEventType.TYPE_TIMING.getName().equals(next.getType())) {
                arrayList.add(new int[]{B, B2});
            } else {
                arrayList2.add(new int[]{B, B2});
            }
        }
        this.y.l4.set(new Pair<>(arrayList, arrayList2));
        this.y.a4.set(!arrayList.isEmpty());
        this.y.c4.set(!arrayList2.isEmpty());
        this.y.b4.set(!arrayList.isEmpty() && !arrayList2.isEmpty());
        ObservableBoolean observableBoolean = this.y.d4;
        if (!arrayList.isEmpty() && !arrayList2.isEmpty()) {
            z = true;
        }
        observableBoolean.set(z);
        ArrayList arrayList3 = new ArrayList();
        if (!arrayList.isEmpty()) {
            arrayList3.add(1);
        }
        if (!arrayList2.isEmpty()) {
            arrayList3.add(2);
        }
        this.y.w0(arrayList3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e1 */
    public /* synthetic */ void f1(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a aVar) {
        Long l;
        if (aVar != null && (l = (Long) aVar.a()) != null) {
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(l.longValue());
            this.y.E0(instance);
            this.y.e4.set(new d(instance.get(1), instance.get(2) + 1, instance.get(5)));
            this.y.h4.set(instance);
            this.y.A0(instance);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g1 */
    public /* synthetic */ void h1(List list) {
        VodMediaAPI.releaseDownloadImage();
        this.z.o(list);
        this.z.r(this.y.n());
    }

    private void i1() {
        this.y.C0(this);
        this.y.w().observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.play.v0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PlayBackControlFragment.this.K0((List) obj);
            }
        });
        this.y.p().observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.play.u0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PlayBackControlFragment.this.T0((Boolean) obj);
            }
        });
        this.y.z().observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.play.c1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PlayBackControlFragment.this.V0((Boolean) obj);
            }
        });
        this.y.r().observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.play.b1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PlayBackControlFragment.this.X0((com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a) obj);
            }
        });
        this.y.u().observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.play.y0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PlayBackControlFragment.this.Z0((com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a) obj);
            }
        });
        this.y.y().observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.play.t0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PlayBackControlFragment.this.b1((com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a) obj);
            }
        });
        this.y.s().observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.play.z0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PlayBackControlFragment.this.d1((m) obj);
            }
        });
        this.y.t().observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.play.x0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PlayBackControlFragment.this.f1((com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a) obj);
            }
        });
        this.y.A().observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.play.a1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PlayBackControlFragment.this.h1((List) obj);
            }
        });
        this.x.z.observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.play.e1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PlayBackControlFragment.this.N0((Integer) obj);
            }
        });
        this.y.Y3.observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.play.d1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PlayBackControlFragment.this.P0((Boolean) obj);
            }
        });
        this.y.D().observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.play.s0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PlayBackControlFragment.this.R0((List) obj);
            }
        });
    }

    @Override // com.tplink.iot.view.ipcamera.widget.timeaxis.TimeAxisLayout.b
    public void L() {
    }

    @Override // com.tplink.iot.view.ipcamera.widget.calendar.c
    public void M0(d dVar) {
        Calendar C = this.y.C();
        d dVar2 = new d(C.get(1), C.get(2) + 1, C.get(5));
        if (dVar.b(dVar2) > 0) {
            if (this.y.T3.get()) {
                this.y.G();
            }
        } else if (dVar.b(dVar2) < 0) {
            this.y.I();
        }
    }

    @Override // com.tplink.iot.view.ipcamera.widget.timeaxis.TimeAxisLayout.b
    public void T() {
    }

    @Override // com.tplink.iot.view.ipcamera.widget.calendar.b
    public void g0(int i, int i2, int i3) {
        b.d.w.c.a.c("VideoPlay.PlayBackControlFragment", "year " + i + " month " + i2 + " day " + i3);
        this.y.u0(i, i2, i3);
        this.y.n0();
    }

    @Override // com.tplink.iot.view.ipcamera.base.g, android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.y.Z3.get()) {
            int id = view.getId();
            if (id != R.id.date_today) {
                boolean z = false;
                switch (id) {
                    case R.id.check_box_24h /* 2131362226 */:
                        this.y.j();
                        PlayBackControlViewModel playBackControlViewModel = this.y;
                        ObservableBoolean observableBoolean = playBackControlViewModel.d4;
                        if (playBackControlViewModel.a4.get() && this.y.c4.get()) {
                            z = true;
                        }
                        observableBoolean.set(z);
                        return;
                    case R.id.check_box_motion_detect /* 2131362227 */:
                        this.y.j();
                        PlayBackControlViewModel playBackControlViewModel2 = this.y;
                        ObservableBoolean observableBoolean2 = playBackControlViewModel2.b4;
                        if (playBackControlViewModel2.a4.get() && this.y.c4.get()) {
                            z = true;
                        }
                        observableBoolean2.set(z);
                        return;
                    default:
                        switch (id) {
                            case R.id.date_cur_date /* 2131362361 */:
                                if (!this.y.U3.get()) {
                                    ObservableBoolean observableBoolean3 = this.y.U3;
                                    observableBoolean3.set(!observableBoolean3.get());
                                    PlayBackControlViewModel playBackControlViewModel3 = this.y;
                                    playBackControlViewModel3.f(playBackControlViewModel3.U3.get());
                                    ObservableBoolean observableBoolean4 = this.y.W3;
                                    observableBoolean4.set(!observableBoolean4.get() && this.x.q.get());
                                    ObservableBoolean observableBoolean5 = this.y.V3;
                                    if (!observableBoolean5.get() && !this.x.q.get() && !this.y.Z3.get()) {
                                        z = true;
                                    }
                                    observableBoolean5.set(z);
                                    return;
                                }
                                return;
                            case R.id.date_index_back /* 2131362362 */:
                                ObservableBoolean observableBoolean6 = this.y.U3;
                                observableBoolean6.set(!observableBoolean6.get());
                                PlayBackControlViewModel playBackControlViewModel4 = this.y;
                                playBackControlViewModel4.f(playBackControlViewModel4.U3.get());
                                ObservableBoolean observableBoolean7 = this.y.W3;
                                observableBoolean7.set(!observableBoolean7.get() && this.x.q.get());
                                ObservableBoolean observableBoolean8 = this.y.V3;
                                if (!observableBoolean8.get() && !this.x.q.get() && !this.y.Z3.get()) {
                                    z = true;
                                }
                                observableBoolean8.set(z);
                                return;
                            case R.id.date_move_backward /* 2131362363 */:
                                if (this.y.U3.get()) {
                                    this.y.I();
                                    return;
                                }
                                this.y.H();
                                this.y.g4.set(new d(this.y.l().get(1), this.y.l().get(2) + 1, this.y.l().get(5)));
                                return;
                            case R.id.date_move_forward /* 2131362364 */:
                                if (this.y.U3.get()) {
                                    this.y.G();
                                    return;
                                }
                                this.y.F();
                                this.y.g4.set(new d(this.y.l().get(1), this.y.l().get(2) + 1, this.y.l().get(5)));
                                return;
                            default:
                                return;
                        }
                }
            } else {
                this.y.E();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.q = (FragmentPlayBackControlBinding) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_play_back_control, viewGroup, false);
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity);
        String stringExtra = activity.getIntent().getStringExtra("device_id_md5");
        FragmentActivity activity2 = getActivity();
        Objects.requireNonNull(activity2);
        long longExtra = activity2.getIntent().getLongExtra("record_time", 0L);
        this.x = (PlaybackMainViewModel) ViewModelProviders.of(getActivity(), new CameraViewModelFactory(getActivity(), stringExtra)).get(PlaybackMainViewModel.class);
        PlayBackControlViewModel playBackControlViewModel = (PlayBackControlViewModel) ViewModelProviders.of(getActivity(), new CameraViewModelFactory(getActivity(), stringExtra)).get(PlayBackControlViewModel.class);
        this.y = playBackControlViewModel;
        playBackControlViewModel.J();
        this.y.K(this.x);
        this.y.x0();
        if (longExtra > 0) {
            this.y.r0(System.currentTimeMillis(), longExtra);
        } else {
            this.y.q0(System.currentTimeMillis());
        }
        this.q.n(this.y);
        this.q.h(this);
        this.q.l(this);
        this.q.m(this);
        this.q.i(this);
        this.y.j4.set(4.0f);
        Calendar instance = Calendar.getInstance();
        instance.setTimeZone(TimeZone.getDefault());
        instance.setTimeInMillis(System.currentTimeMillis());
        this.y.e4.set(new d(instance.get(1), instance.get(2) + 1, instance.get(5)));
        RecyclerView recyclerView = (RecyclerView) this.q.z.findViewById(R.id.rv_snapshot);
        this.p0 = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        SnapshotAdapter snapshotAdapter = new SnapshotAdapter(getActivity(), this.p3, this.y);
        this.z = snapshotAdapter;
        this.p0.setAdapter(snapshotAdapter);
        RecyclerView recyclerView2 = (RecyclerView) this.q.x.findViewById(R.id.rv_record_types);
        this.p1 = recyclerView2;
        recyclerView2.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        RecordTypeAdapter recordTypeAdapter = new RecordTypeAdapter(getActivity());
        this.p2 = recordTypeAdapter;
        this.p1.setAdapter(recordTypeAdapter);
        i1();
        return this.q.getRoot();
    }

    @Override // com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.tplink.iot.view.ipcamera.widget.timeaxis.TimeAxisLayout.b
    public void x(int i, boolean z) {
        b.d.w.c.a.c("VideoPlay.PlayBackControlFragment", "secondsInDay " + i + " minus " + z);
        this.y.s0(i, z);
    }

    @Override // com.tplink.iot.view.ipcamera.widget.timeaxis.TimeAxisLayout.b
    public void y0(int i, boolean z, boolean z2) {
        if (z) {
            b.d.w.c.a.c("VideoPlay.PlayBackControlFragment", "byUser secondsInDay " + i);
            this.y.z0(true);
            this.y.y0(i, z2);
        }
    }
}
