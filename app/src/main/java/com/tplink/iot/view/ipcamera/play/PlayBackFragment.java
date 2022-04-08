package com.tplink.iot.view.ipcamera.play;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.tplink.iot.R;
import com.tplink.iot.Utils.m;
import com.tplink.iot.Utils.x0.e;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.databinding.FragmentPlayBackVideoBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.widget.a.a;
import com.tplink.iot.view.ipcamera.widget.calendar.b;
import com.tplink.iot.view.ipcamera.widget.calendar.c;
import com.tplink.iot.view.ipcamera.widget.calendar.d;
import com.tplink.iot.view.ipcamera.widget.scollitem.ScrollPlayRatePicker;
import com.tplink.iot.view.ipcamera.widget.timeaxis.TimeAxisLayout;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.view.ipcamera.widget.touchlayout.TouchListenerRelativeLayout;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.play.PlayBackControlViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.PlaybackMainViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VodPlayRate;
import com.tplink.iot.viewmodel.ipcamera.play.VodViewModel;
import com.tplink.libmediaapi.live.LiveMediaAPI;
import com.tplink.libmediaapi.vod.VodMediaAPI;
import com.tplink.libtpnetwork.cameranetwork.business.model.l;
import com.tplink.libtpvideorender.view.GLSurfaceViewGPU;
import java.util.Calendar;
import java.util.Objects;

/* loaded from: classes2.dex */
public class PlayBackFragment extends BaseFragment implements g, a, ScrollPlayRatePicker.a, TimeAxisLayout.b, b, c, TouchListenerRelativeLayout.a {
    private GLSurfaceViewGPU H3;
    private long p0 = 0;
    private long p1 = 0;
    private String p2;
    private l p3;
    private FragmentPlayBackVideoBinding q;
    private PlaybackMainViewModel x;
    private VodViewModel y;
    private PlayBackControlViewModel z;

    private void H0(View view) {
        ObservableBoolean observableBoolean;
        PlaybackMainViewModel playbackMainViewModel;
        if (!this.x.q.get() && !this.x.l.get()) {
            switch (view.getId()) {
                case R.id.play_error /* 2131363663 */:
                    this.x.l.set(true);
                    this.x.m.set(false);
                    this.z.l0();
                    return;
                case R.id.rate_tag /* 2131363748 */:
                    this.y.S3.set(!observableBoolean.get());
                    return;
                case R.id.tool_full_screen /* 2131364262 */:
                    this.y.S3.set(false);
                    this.x.D(!playbackMainViewModel.r.get());
                    return;
                case R.id.tool_pic /* 2131364268 */:
                    this.y.u();
                    return;
                case R.id.tool_play /* 2131364269 */:
                    boolean z = !this.y.R3.get();
                    this.y.R3.set(z);
                    if (!z) {
                        VodMediaAPI.pauseDisplay(this.p2);
                        VodMediaAPI.disableRelayTimer();
                        return;
                    } else if (VodMediaAPI.isStreamAlive(this.p2)) {
                        VodMediaAPI.resumeDisplay(this.p2);
                        return;
                    } else {
                        W0();
                        return;
                    }
                case R.id.tool_sound /* 2131364272 */:
                    this.x.E();
                    return;
                case R.id.tool_video /* 2131364273 */:
                    if (this.y.R3.get() || this.y.N3.get()) {
                        this.y.z();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void I0(View view) {
        if (!this.x.l.get()) {
            boolean z = true;
            switch (view.getId()) {
                case R.id.back_fullscreen /* 2131362001 */:
                    if (this.x.r.get()) {
                        this.x.D(false);
                        this.x.u.set(false);
                        this.x.s.set(false);
                        this.x.t.set(false);
                        return;
                    }
                    return;
                case R.id.check_box_24h /* 2131362226 */:
                    this.z.j();
                    PlayBackControlViewModel playBackControlViewModel = this.z;
                    ObservableBoolean observableBoolean = playBackControlViewModel.d4;
                    if (!playBackControlViewModel.a4.get() || !this.z.c4.get()) {
                        z = false;
                    }
                    observableBoolean.set(z);
                    this.x.t.set(false);
                    return;
                case R.id.check_box_motion_detect /* 2131362227 */:
                    this.z.j();
                    PlayBackControlViewModel playBackControlViewModel2 = this.z;
                    ObservableBoolean observableBoolean2 = playBackControlViewModel2.b4;
                    if (!playBackControlViewModel2.a4.get() || !this.z.c4.get()) {
                        z = false;
                    }
                    observableBoolean2.set(z);
                    this.x.t.set(false);
                    return;
                case R.id.date_move_backward /* 2131362363 */:
                    this.z.I();
                    return;
                case R.id.date_move_forward /* 2131362364 */:
                    this.z.G();
                    return;
                case R.id.date_today /* 2131362367 */:
                    this.z.E();
                    this.x.u.set(false);
                    return;
                case R.id.tool_filter /* 2131364261 */:
                    ObservableBoolean observableBoolean3 = this.x.t;
                    observableBoolean3.set(true ^ observableBoolean3.get());
                    return;
                case R.id.tool_play_date /* 2131364270 */:
                    ObservableBoolean observableBoolean4 = this.x.u;
                    observableBoolean4.set(true ^ observableBoolean4.get());
                    return;
                case R.id.tool_rate /* 2131364271 */:
                    ObservableBoolean observableBoolean5 = this.x.s;
                    observableBoolean5.set(true ^ observableBoolean5.get());
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K0 */
    public /* synthetic */ void L0(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a aVar) {
        Boolean bool = (Boolean) aVar.a();
        if (bool != null && bool.booleanValue()) {
            this.z.l0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N0 */
    public /* synthetic */ void O0(GLSurfaceViewGPU gLSurfaceViewGPU) {
        if (gLSurfaceViewGPU != null) {
            if (gLSurfaceViewGPU.getParent() instanceof ViewGroup) {
                ((ViewGroup) gLSurfaceViewGPU.getParent()).removeView(gLSurfaceViewGPU);
            }
            this.q.q.removeAllViews();
            this.q.q.addView(gLSurfaceViewGPU, 0);
            this.H3 = gLSurfaceViewGPU;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P0 */
    public /* synthetic */ void Q0(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a aVar) {
        l lVar = (l) aVar.a();
        if (lVar != null) {
            this.p3 = lVar;
            this.y.f();
            int i = lVar.f14145b;
            if (i > 0) {
                long j = lVar.a;
                if (j > 0) {
                    long j2 = j / 1000;
                    int[] iArr = lVar.f14146c;
                    this.z.W3.set(false);
                    this.z.V3.set(true);
                    this.z.U3.set(false);
                    this.x.q.set(false);
                    this.z.D0();
                    VodMediaAPI.resumeDisplay(this.p2);
                    this.y.R3.set(true);
                    String value = this.y.T3.get().getValue();
                    if (getUserVisibleHint()) {
                        this.p0 = System.currentTimeMillis();
                        if (iArr != null) {
                            VodMediaAPI.startVodStreamDisplay(this.p2, getContext(), j2, i, iArr, value);
                            return;
                        } else if (VodMediaAPI.isStreamAlive(this.p2)) {
                            VodMediaAPI.seekVodStreamDisplay(this.p2, i, j2, value);
                            return;
                        } else {
                            X0(j2);
                            return;
                        }
                    } else {
                        b.d.w.c.a.c("PlayBackFragment", "由于回放页面不可见,不播放");
                        return;
                    }
                }
            }
            this.z.W3.set(true);
            this.z.V3.set(false);
            this.z.U3.set(false);
            VodMediaAPI.releaseStream(this.p2);
            VodMediaAPI.clearPlayerCache(this.p2);
            this.y.hideLoadingView();
            this.x.q.set(true);
            this.x.m.set(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R0 */
    public /* synthetic */ void S0(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a aVar) {
        Boolean bool = (Boolean) aVar.a();
        if (bool != null && bool.booleanValue()) {
            VodMediaAPI.pauseDisplay(this.p2);
            this.y.R3.set(false);
            this.x.y(getString(R.string.video_live_no_record));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T0 */
    public /* synthetic */ void U0(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a aVar) {
        Integer num = (Integer) aVar.a();
        if (num == null) {
            return;
        }
        if (num.intValue() == -71101) {
            TSnackbar.A(TSnackbar.s(this), getString(R.string.camera_playback_too_many_viewer), PathInterpolatorCompat.MAX_NUM_POINTS).N();
        } else if (num.intValue() == -71102 || num.intValue() == -71103) {
            TSnackbar.A(TSnackbar.s(this), getString(R.string.common_operation_failed), PathInterpolatorCompat.MAX_NUM_POINTS).N();
        }
    }

    private void V0() {
        long j = this.p0;
        if (j != 0) {
            int connectionType = LiveMediaAPI.getConnectionType(this.p2);
            e.q(this.p2, (this.p1 - j) / 1000.0d, m.a(connectionType));
            this.p0 = 0L;
        }
    }

    private void Z0() {
        this.x.y.observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.play.g1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PlayBackFragment.this.L0((com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a) obj);
            }
        });
        this.y.V3.observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.play.j1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PlayBackFragment.this.O0((GLSurfaceViewGPU) obj);
            }
        });
        this.z.u().observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.play.h1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PlayBackFragment.this.Q0((com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a) obj);
            }
        });
        this.z.x().observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.play.i1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PlayBackFragment.this.S0((com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a) obj);
            }
        });
        this.z.v().observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.play.f1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PlayBackFragment.this.U0((com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a) obj);
            }
        });
    }

    public boolean J0() {
        VodViewModel vodViewModel = this.y;
        if (vodViewModel == null) {
            return false;
        }
        return vodViewModel.R3.get();
    }

    @Override // com.tplink.iot.view.ipcamera.widget.timeaxis.TimeAxisLayout.b
    public void L() {
    }

    @Override // com.tplink.iot.view.ipcamera.widget.calendar.c
    public void M0(d dVar) {
        Calendar C = this.z.C();
        d dVar2 = new d(C.get(1), C.get(2) + 1, C.get(5));
        if (dVar.b(dVar2) > 0) {
            if (this.z.T3.get()) {
                this.z.G();
            }
        } else if (dVar.b(dVar2) < 0) {
            this.z.I();
        }
    }

    @Override // com.tplink.iot.view.ipcamera.widget.timeaxis.TimeAxisLayout.b
    public void T() {
    }

    public void W0() {
        l lVar;
        if (this.y.R3.get() && (lVar = this.p3) != null && lVar.f14145b > 0 && lVar.a > 0) {
            b.d.w.c.a.c("PlayBackFragment", "start play");
            this.p0 = System.currentTimeMillis();
            this.z.l0();
            this.x.n();
        }
    }

    @Override // com.tplink.iot.view.ipcamera.widget.touchlayout.TouchListenerRelativeLayout.a
    public void X(MotionEvent motionEvent) {
        b.d.w.c.a.c("PlayBackFragment", "onActionUp");
        if (!this.x.r.get()) {
            return;
        }
        if (this.x.t.get() || this.x.u.get() || this.x.s.get()) {
            this.x.f();
            float rawX = motionEvent.getRawX();
            if (getActivity() != null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                FragmentActivity activity = getActivity();
                Objects.requireNonNull(activity);
                activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
                float f2 = displayMetrics.widthPixels;
                float f3 = displayMetrics.density;
                if (this.x.t.get()) {
                    if (rawX < f2 - (f3 * 184.0f)) {
                        this.x.t.set(false);
                    }
                } else if (this.x.u.get()) {
                    if (rawX < f2 - (f3 * 360.0f)) {
                        this.x.u.set(false);
                    }
                } else if (this.x.s.get() && rawX < f2 - (f3 * 120.0f)) {
                    this.x.s.set(false);
                }
            }
        } else {
            float y = motionEvent.getY();
            if (getActivity() != null) {
                DisplayMetrics displayMetrics2 = new DisplayMetrics();
                FragmentActivity activity2 = getActivity();
                Objects.requireNonNull(activity2);
                activity2.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics2);
                if (y >= displayMetrics2.heightPixels - (displayMetrics2.density * 50.0f)) {
                    this.x.w();
                    this.x.i();
                } else if (this.x.v.get()) {
                    this.x.f();
                    this.x.v.set(false);
                } else {
                    this.x.w();
                    this.x.i();
                }
            }
        }
    }

    public void X0(long j) {
        if (this.y.R3.get()) {
            b.d.w.c.a.c("PlayBackFragment", "start play");
            this.p0 = System.currentTimeMillis();
            this.z.m0(j);
            this.x.n();
        }
    }

    public void Y0() {
        if (this.y.R3.get()) {
            b.d.w.c.a.c("PlayBackFragment", "stop play");
            this.p1 = System.currentTimeMillis();
            VodMediaAPI.releaseStream(this.p2);
            VodMediaAPI.clearPlayerCache(this.p2);
            V0();
        }
    }

    @Override // com.tplink.iot.view.ipcamera.widget.touchlayout.TouchListenerRelativeLayout.a
    public void c(MotionEvent motionEvent) {
        b.d.w.c.a.c("PlayBackFragment", "onActionDown");
    }

    @Override // com.tplink.iot.view.ipcamera.widget.scollitem.ScrollPlayRatePicker.a
    public void e(VodPlayRate vodPlayRate) {
        VodPlayRate vodPlayRate2 = this.y.T3.get();
        this.y.T3.set(vodPlayRate);
        this.y.U3.set(vodPlayRate.getDisplayValue());
        this.y.f();
        if (VodMediaAPI.isStreamAlive(this.p2)) {
            PlayBackControlViewModel playBackControlViewModel = this.z;
            String str = this.p2;
            String value = vodPlayRate.getValue();
            VodViewModel vodViewModel = this.y;
            playBackControlViewModel.g(str, value, vodViewModel.T3, vodViewModel.U3, vodPlayRate2);
        } else {
            X0(this.z.P3 / 1000);
        }
        this.y.S3.set(false);
        this.x.s.set(false);
    }

    @Override // com.tplink.iot.view.ipcamera.widget.calendar.b
    public void g0(int i, int i2, int i3) {
        b.d.w.c.a.c("PlayBackFragment", "year " + i + " month " + i2 + " day " + i3);
        this.z.u0(i, i2, i3);
        this.z.n0();
        this.x.u.set(false);
    }

    @Override // com.tplink.iot.view.ipcamera.base.g, android.view.View.OnClickListener
    public void onClick(View view) {
        H0(view);
        I0(view);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.q = (FragmentPlayBackVideoBinding) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_play_back_video, viewGroup, false);
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity);
        this.p2 = activity.getIntent().getStringExtra("device_id_md5");
        PlaybackMainViewModel playbackMainViewModel = (PlaybackMainViewModel) ViewModelProviders.of(getActivity(), new CameraViewModelFactory(getActivity(), this.p2)).get(PlaybackMainViewModel.class);
        this.x = playbackMainViewModel;
        playbackMainViewModel.A(false, this.p2);
        this.z = (PlayBackControlViewModel) ViewModelProviders.of(getActivity(), new CameraViewModelFactory(getActivity(), this.p2)).get(PlayBackControlViewModel.class);
        VodViewModel vodViewModel = (VodViewModel) ViewModelProviders.of(getActivity(), new CameraViewModelFactory(getActivity(), this.p2)).get(VodViewModel.class);
        this.y = vodViewModel;
        vodViewModel.w(this.x, this.z);
        this.y.v();
        this.q.o(this);
        this.q.q(this.x);
        this.q.r(this.y);
        this.q.n(this.z);
        this.q.h(this);
        this.q.m(this);
        this.q.i(this);
        this.q.p(this);
        this.q.N3.setListener(this);
        this.q.l(this);
        Z0();
        return this.q.getRoot();
    }

    @Override // com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        VodMediaAPI.stopDisplay(this.p2);
        GLSurfaceViewGPU gLSurfaceViewGPU = this.H3;
        if (gLSurfaceViewGPU != null) {
            gLSurfaceViewGPU.a(this.q.q);
        }
    }

    @Override // com.tplink.iot.view.ipcamera.widget.touchlayout.TouchListenerRelativeLayout.a
    public void onSingleTapUp(MotionEvent motionEvent) {
        b.d.w.c.a.c("PlayBackFragment", "onSingleTapUp");
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        VodMediaAPI.bindRecordingVariable(this.y.N3);
    }

    @Override // com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (VodMediaAPI.getRecordingObservable() == this.y.N3) {
            VodMediaAPI.bindRecordingVariable(null);
        }
    }

    @Override // com.tplink.iot.view.ipcamera.widget.timeaxis.TimeAxisLayout.b
    public void x(int i, boolean z) {
        b.d.w.c.a.c("PlayBackFragment", "secondsInDay " + i + " minus " + z);
        this.z.s0(i, z);
    }

    @Override // com.tplink.iot.view.ipcamera.widget.timeaxis.TimeAxisLayout.b
    public void y0(int i, boolean z, boolean z2) {
        if (z) {
            b.d.w.c.a.c("PlayBackFragment", "byUser secondsInDay " + i);
            this.z.z0(true);
            this.z.y0(i, z2);
        }
    }
}
