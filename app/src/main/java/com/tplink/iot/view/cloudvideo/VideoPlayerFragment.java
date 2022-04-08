package com.tplink.iot.view.cloudvideo;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.h2;
import com.google.android.exoplayer2.j2;
import com.google.android.exoplayer2.l1;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.t1;
import com.google.android.exoplayer2.trackselection.k;
import com.google.android.exoplayer2.u1;
import com.google.android.exoplayer2.ui.DefaultTimeBar;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.v1;
import com.google.android.exoplayer2.video.v;
import com.google.android.exoplayer2.video.z;
import com.google.android.exoplayer2.w1;
import com.scwang.smart.refresh.layout.c.g;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPMaterialDialogV3;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.x0.w;
import com.tplink.iot.Utils.z0.h;
import com.tplink.iot.adapter.cloudvideo.CloudVideoListAdapter;
import com.tplink.iot.adapter.home.HomeMainSpaceItemDecoration;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.cloud.bean.cloudvideo.common.CloudVideo;
import com.tplink.iot.cloud.bean.cloudvideo.common.PartCloudVideo;
import com.tplink.iot.model.cloudvideo.CloudVideoItem;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.cloudvideo.VideoPlayerViewModel;
import com.tplink.iot.widget.CirclePercentBar;
import com.tplink.iot.widget.refreshlayout.SmartRefreshFooter;
import com.tplink.iot.widget.refreshlayout.SmartRefreshHeader;
import com.tplink.iot.widget.refreshlayout.TPSmartRefreshLayout;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import java.io.File;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
public class VideoPlayerFragment extends BaseFragment implements CloudVideoListAdapter.d, CirclePercentBar.c {
    private CloudVideoListAdapter I3;
    private VideoPlayerViewModel K3;
    private ALCameraDevice M3;
    private com.tplink.iot.h.f N3;
    @BindView
    LinearLayout mBottomToolButtonsView;
    @BindView
    ImageView mCaptureIv;
    @BindView
    ImageView mCaptureLandIv;
    @BindView
    RelativeLayout mCaptureLandView;
    @BindView
    RecyclerView mCloudVideoRv;
    @BindView
    ImageView mDownloadIv;
    @BindView
    ImageView mDownloadLandIv;
    @BindView
    TextView mDurationTv;
    @BindView
    View mEmptyPlayView;
    @BindView
    ImageView mFullScreenOrSelectVideoIv;
    @BindView
    LottieAnimationView mLoadingAnimationView;
    @BindView
    ImageView mMuteIv;
    @BindView
    ImageView mMuteLandIv;
    @BindView
    ImageView mPauseIv;
    @BindView
    ImageView mPlayIv;
    @BindView
    RelativeLayout mPlayTitleView;
    @BindView
    PlayerView mPlayerView;
    @BindView
    TextView mPositionTv;
    @BindView
    LinearLayout mRootView;
    @BindView
    LinearLayout mSelectCloudVideoView;
    @BindView
    LinearLayout mTapRefreshView;
    @BindView
    DefaultTimeBar mTimeBar;
    @BindView
    RelativeLayout mTopControlView;
    @BindView
    FrameLayout mVideoPlayLayout;
    private h2 p0;
    private float p3;
    private CirclePercentBar q;
    @BindView
    TPSmartRefreshLayout refreshLayout;
    private View x;
    private TPMaterialDialogV3 y;
    private CloudVideoItem z;
    private int p1 = 0;
    private long p2 = 0;
    private boolean H3 = false;
    private List<CloudVideoItem> J3 = new ArrayList();
    private String L3 = "";
    private boolean O3 = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements com.tplink.iot.h.i.b {
        a() {
        }

        @Override // com.tplink.iot.h.i.b
        public void a(long j, long j2, int i) {
            if (VideoPlayerFragment.this.q != null && VideoPlayerFragment.this.y != null && VideoPlayerFragment.this.y.isShowing() && VideoPlayerFragment.this.N3.E()) {
                VideoPlayerFragment.this.q.setPercentData((int) ((j2 * 100) / j));
            }
        }

        @Override // com.tplink.iot.h.i.b
        public void b(int i, int i2) {
            if (VideoPlayerFragment.this.q != null && VideoPlayerFragment.this.x != null) {
                VideoPlayerFragment.this.q.setPercentData(100);
                ((TextView) VideoPlayerFragment.this.x.findViewById(R.id.tv_download_state)).setText(R.string.download_memory_success);
                ((Button) VideoPlayerFragment.this.x.findViewById(R.id.btn_negative)).setText(R.string.common_ok);
                VideoPlayerFragment.this.K3.m(VideoPlayerFragment.this.N3.B(), i2);
            }
        }

        @Override // com.tplink.iot.h.i.a
        public void onError(Throwable th) {
            if (VideoPlayerFragment.this.q != null && VideoPlayerFragment.this.x != null) {
                VideoPlayerFragment.this.q.m();
                ((TextView) VideoPlayerFragment.this.x.findViewById(R.id.tv_download_state)).setText(R.string.download_video_failed);
            }
        }

        @Override // com.tplink.iot.h.i.a
        public void onStart() {
            VideoPlayerFragment.this.a1();
            VideoPlayerFragment.this.i1();
            if (VideoPlayerFragment.this.q != null && VideoPlayerFragment.this.x != null) {
                ((TextView) VideoPlayerFragment.this.x.findViewById(R.id.tv_download_state)).setText(R.string.downloading);
                VideoPlayerFragment.this.q.k();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPlayerFragment.this.y.dismiss();
            if (VideoPlayerFragment.this.N3 != null) {
                VideoPlayerFragment.this.N3.y();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements Observer<Boolean> {
        c() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            if (bool != null && bool.booleanValue()) {
                TSnackbar.y(VideoPlayerFragment.this.getActivity(), VideoPlayerFragment.this.getString(R.string.video_capture_saved), -1).N();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements g {
        d() {
        }

        @Override // com.scwang.smart.refresh.layout.c.g
        public void m(@NonNull com.scwang.smart.refresh.layout.a.f fVar) {
            VideoPlayerFragment.this.d1(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements com.scwang.smart.refresh.layout.c.e {
        e() {
        }

        @Override // com.scwang.smart.refresh.layout.c.e
        public void q(@NonNull com.scwang.smart.refresh.layout.a.f fVar) {
            VideoPlayerFragment.this.d1(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f implements u1.e {
        f() {
        }

        @Override // com.google.android.exoplayer2.text.k
        public /* synthetic */ void B(List list) {
            w1.b(this, list);
        }

        @Override // com.google.android.exoplayer2.u1.c
        public /* synthetic */ void G(TrackGroupArray trackGroupArray, k kVar) {
            w1.x(this, trackGroupArray, kVar);
        }

        @Override // com.google.android.exoplayer2.video.w
        public /* synthetic */ void I(int i, int i2) {
            w1.v(this, i, i2);
        }

        @Override // com.google.android.exoplayer2.u1.c
        public /* synthetic */ void J(PlaybackException playbackException) {
            w1.p(this, playbackException);
        }

        @Override // com.google.android.exoplayer2.u1.c
        public /* synthetic */ void K(int i) {
            v1.l(this, i);
        }

        @Override // com.google.android.exoplayer2.u1.c
        public void M(boolean z) {
            if (z) {
                VideoPlayerFragment.this.mLoadingAnimationView.o();
                VideoPlayerFragment.this.mLoadingAnimationView.setVisibility(0);
                return;
            }
            VideoPlayerFragment.this.mLoadingAnimationView.g();
            VideoPlayerFragment.this.mLoadingAnimationView.setVisibility(8);
        }

        @Override // com.google.android.exoplayer2.u1.c
        public /* synthetic */ void O() {
            v1.o(this);
        }

        @Override // com.google.android.exoplayer2.u1.c
        public void P(@NonNull PlaybackException playbackException) {
            CloudVideoListFragment cloudVideoListFragment;
            if (playbackException.getMessage() != null) {
                VideoPlayerFragment.this.n1(false, true);
            }
            if (VideoPlayerFragment.this.K3.l(VideoPlayerFragment.this.z.getCloudVideo().getPartCloudVideos().get(0).getUriExpiresAt()) && (cloudVideoListFragment = (CloudVideoListFragment) VideoPlayerFragment.this.getFragmentManager().findFragmentById(R.id.cloud_video_container)) != null) {
                cloudVideoListFragment.j1();
            }
        }

        @Override // com.google.android.exoplayer2.audio.r
        public /* synthetic */ void R(float f2) {
            w1.z(this, f2);
        }

        @Override // com.google.android.exoplayer2.u1.c
        public /* synthetic */ void S(u1 u1Var, u1.d dVar) {
            w1.e(this, u1Var, dVar);
        }

        @Override // com.google.android.exoplayer2.u1.c
        public /* synthetic */ void U(boolean z, int i) {
            v1.k(this, z, i);
        }

        @Override // com.google.android.exoplayer2.video.w
        public /* synthetic */ void W(int i, int i2, int i3, float f2) {
            v.a(this, i, i2, i3, f2);
        }

        @Override // com.google.android.exoplayer2.u1.c
        public /* synthetic */ void Y(l1 l1Var, int i) {
            w1.h(this, l1Var, i);
        }

        @Override // com.google.android.exoplayer2.audio.r, com.google.android.exoplayer2.audio.t
        public /* synthetic */ void a(boolean z) {
            w1.u(this, z);
        }

        @Override // com.google.android.exoplayer2.video.w, com.google.android.exoplayer2.video.y
        public /* synthetic */ void c(z zVar) {
            w1.y(this, zVar);
        }

        @Override // com.google.android.exoplayer2.u1.c
        public /* synthetic */ void d(t1 t1Var) {
            w1.l(this, t1Var);
        }

        @Override // com.google.android.exoplayer2.u1.c
        public /* synthetic */ void d0(boolean z, int i) {
            w1.k(this, z, i);
        }

        @Override // com.google.android.exoplayer2.u1.c
        public /* synthetic */ void e(u1.f fVar, u1.f fVar2, int i) {
            w1.q(this, fVar, fVar2, i);
        }

        @Override // com.google.android.exoplayer2.u1.c
        public /* synthetic */ void f(int i) {
            w1.n(this, i);
        }

        @Override // com.google.android.exoplayer2.u1.c
        public /* synthetic */ void g(boolean z) {
            v1.d(this, z);
        }

        @Override // com.google.android.exoplayer2.u1.c
        public /* synthetic */ void j(List list) {
            v1.q(this, list);
        }

        @Override // com.google.android.exoplayer2.n2.c
        public /* synthetic */ void k0(com.google.android.exoplayer2.n2.b bVar) {
            w1.c(this, bVar);
        }

        @Override // com.google.android.exoplayer2.u1.c
        public /* synthetic */ void m0(boolean z) {
            w1.g(this, z);
        }

        @Override // com.google.android.exoplayer2.u1.c
        public /* synthetic */ void n(u1.b bVar) {
            w1.a(this, bVar);
        }

        @Override // com.google.android.exoplayer2.u1.c
        public void o(j2 j2Var, int i) {
        }

        @Override // com.google.android.exoplayer2.u1.c
        public /* synthetic */ void onRepeatModeChanged(int i) {
            w1.s(this, i);
        }

        @Override // com.google.android.exoplayer2.u1.c
        public void q(int i) {
            if (i == 3) {
                VideoPlayerFragment.this.n1(false, false);
            } else if (i == 2) {
                VideoPlayerFragment.this.n1(true, false);
            }
        }

        @Override // com.google.android.exoplayer2.u1.c
        public /* synthetic */ void s(m1 m1Var) {
            w1.i(this, m1Var);
        }

        @Override // com.google.android.exoplayer2.u1.c
        public /* synthetic */ void v(boolean z) {
            w1.t(this, z);
        }

        @Override // com.google.android.exoplayer2.metadata.e
        public /* synthetic */ void w(Metadata metadata) {
            w1.j(this, metadata);
        }

        @Override // com.google.android.exoplayer2.n2.c
        public /* synthetic */ void x(int i, boolean z) {
            w1.d(this, i, z);
        }

        @Override // com.google.android.exoplayer2.video.w
        public /* synthetic */ void z() {
            w1.r(this);
        }
    }

    private void S0() {
        TextureView textureView = (TextureView) this.mPlayerView.getVideoSurfaceView();
        if (textureView != null) {
            this.K3.h(textureView.getBitmap());
        }
    }

    private String W0(long j) {
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb, Locale.getDefault());
        if (j == -9223372036854775807L) {
            j = 0;
        }
        long j2 = (j + 500) / 1000;
        long j3 = j2 % 60;
        long j4 = (j2 / 60) % 60;
        long j5 = j2 / 3600;
        sb.setLength(0);
        return j5 > 0 ? formatter.format("%d:%02d:%02d", Long.valueOf(j5), Long.valueOf(j4), Long.valueOf(j3)).toString() : formatter.format("%02d:%02d", Long.valueOf(j4), Long.valueOf(j3)).toString();
    }

    private void X0() {
        com.tplink.iot.view.quicksetup.base.d.b0(getActivity(), R.color.common_iot_dark_black);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        gridLayoutManager.setOrientation(1);
        this.mCloudVideoRv.setLayoutManager(gridLayoutManager);
        this.mCloudVideoRv.addItemDecoration(new HomeMainSpaceItemDecoration(getActivity(), 2));
        CloudVideoListAdapter cloudVideoListAdapter = new CloudVideoListAdapter(getActivity(), true);
        this.I3 = cloudVideoListAdapter;
        this.mCloudVideoRv.setAdapter(cloudVideoListAdapter);
        this.I3.H(this.J3);
        this.I3.J(this);
        this.refreshLayout.Q(new SmartRefreshHeader(getContext()));
        this.refreshLayout.O(new SmartRefreshFooter(getContext()));
        this.refreshLayout.G(true);
        this.refreshLayout.E(true);
        this.refreshLayout.F(false);
        this.refreshLayout.N(new d());
        this.refreshLayout.L(new e());
    }

    private void Y0(CloudVideoItem cloudVideoItem) {
        if (cloudVideoItem != null && cloudVideoItem.getCloudVideo() != null) {
            if (this.p0 == null) {
                com.tplink.iot.Utils.hls.d dVar = new com.tplink.iot.Utils.hls.d(getActivity());
                dVar.i(2);
                h2 z = new h2.b(getActivity(), dVar).z();
                this.p0 = z;
                z.N(new f());
                this.p0.B(this.p1, this.p2);
                this.mPlayerView.setPlayer(this.p0);
            }
            c1(cloudVideoItem);
        }
    }

    private void Z0(CloudVideo cloudVideo) {
        PartCloudVideo partCloudVideo;
        if (cloudVideo != null && cloudVideo.getPartCloudVideos() != null && !cloudVideo.getPartCloudVideos().isEmpty() && (partCloudVideo = cloudVideo.getPartCloudVideos().get(0)) != null) {
            long duration = partCloudVideo.getDuration();
            b.d.w.c.a.d("videoDuration=" + duration);
            if (TextUtils.isEmpty(this.L3)) {
                return;
            }
            if (this.O3) {
                w.C(b.d.w.h.a.g(this.L3), duration);
            } else {
                w.B(b.d.w.h.a.g(this.L3), duration, !TextUtils.isEmpty(cloudVideo.getUuid()) ? cloudVideo.getUuid() : "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a1() {
        h2 h2Var = this.p0;
        if (h2Var != null) {
            h2Var.p(false);
        }
    }

    private void c1(CloudVideoItem cloudVideoItem) {
        PartCloudVideo partCloudVideo;
        CloudVideo cloudVideo = cloudVideoItem.getCloudVideo();
        if (cloudVideo != null) {
            Z0(cloudVideo);
            if (cloudVideo.getPartCloudVideos() != null && !cloudVideo.getPartCloudVideos().isEmpty() && (partCloudVideo = cloudVideo.getPartCloudVideos().get(0)) != null) {
                String m3u8 = partCloudVideo.getM3u8();
                String uri = partCloudVideo.getUri();
                this.mDurationTv.setText(W0(partCloudVideo.getDuration()));
                String e2 = com.tplink.iot.h.j.a.e(b.d.w.h.a.a(m3u8), uri);
                StringBuilder sb = new StringBuilder();
                sb.append(b.d.q.b.p.b.h());
                String str = File.separator;
                sb.append(str);
                sb.append("cloudvideo");
                sb.append(str);
                sb.append("playing.m3u8");
                String sb2 = sb.toString();
                com.tplink.iot.h.j.a.f(sb2, e2);
                this.p0.D(new l1.c().u(Uri.parse("file://" + sb2)).q("application/x-mpegURL").a());
                this.p0.p(true);
                this.p0.prepare();
                CloudVideoListAdapter cloudVideoListAdapter = this.I3;
                if (cloudVideoListAdapter != null) {
                    cloudVideoListAdapter.N(cloudVideoItem.getCloudVideo().getUuid());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d1(boolean z) {
        CloudVideoListFragment cloudVideoListFragment = (CloudVideoListFragment) getFragmentManager().findFragmentById(R.id.cloud_video_container);
        if (cloudVideoListFragment != null) {
            cloudVideoListFragment.k1(z);
        }
    }

    private void e1() {
        h2 h2Var = this.p0;
        if (h2Var != null) {
            this.p2 = h2Var.V();
            this.p1 = this.p0.m();
            this.p0.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i1() {
        TPMaterialDialogV3 tPMaterialDialogV3 = this.y;
        if (tPMaterialDialogV3 == null || !tPMaterialDialogV3.isShowing()) {
            View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.download_process, (ViewGroup) null);
            this.x = inflate;
            CirclePercentBar circlePercentBar = (CirclePercentBar) inflate.findViewById(R.id.pb_process);
            this.q = circlePercentBar;
            circlePercentBar.setListener(this);
            this.y = new TPMaterialDialogV3.Builder(getActivity()).setView(this.x).setCancelable(false).c(false).create();
            ((Button) this.x.findViewById(R.id.btn_negative)).setOnClickListener(new b());
            if (!this.y.isShowing()) {
                this.y.show();
            }
        }
    }

    private void j1() {
        this.K3.j().observe(this, new c());
    }

    private void k1(Configuration configuration) {
        boolean z = configuration.orientation == 2;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mVideoPlayLayout.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mSelectCloudVideoView.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.mEmptyPlayView.getLayoutParams();
        if (z) {
            this.mRootView.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.pure_black));
            getActivity().getWindow().getDecorView().setSystemUiVisibility(4102);
            getActivity().getWindow().setFlags(1024, 1024);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            marginLayoutParams.width = i;
            int i2 = displayMetrics.heightPixels;
            marginLayoutParams.height = i2;
            int i3 = (int) (i / 2.5f);
            marginLayoutParams2.width = i3;
            marginLayoutParams2.height = i2;
            marginLayoutParams3.width = i - i3;
            marginLayoutParams3.height = i2;
        } else {
            this.mRootView.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.pure_black));
            getActivity().getWindow().getDecorView().setSystemUiVisibility(256);
            WindowManager.LayoutParams attributes = getActivity().getWindow().getAttributes();
            attributes.flags &= -1025;
            getActivity().getWindow().setAttributes(attributes);
            getActivity().getWindow().clearFlags(512);
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics2);
            marginLayoutParams.width = displayMetrics2.widthPixels;
            marginLayoutParams.height = h.p(getActivity());
            marginLayoutParams2.width = 0;
            marginLayoutParams2.height = 0;
            marginLayoutParams3.width = 0;
            marginLayoutParams3.height = 0;
        }
        m1(z);
    }

    private void l1() {
        h2 h2Var = this.p0;
        if (h2Var != null) {
            if (this.H3) {
                h2Var.t1(this.p3);
                this.mMuteIv.setImageDrawable(getResources().getDrawable(R.drawable.tool_sound));
                this.mMuteLandIv.setImageDrawable(getResources().getDrawable(R.drawable.tool_sound));
            } else {
                this.p3 = h2Var.c1();
                this.p0.t1(0.0f);
                this.mMuteIv.setImageDrawable(getResources().getDrawable(R.drawable.tool_sound_off));
                this.mMuteLandIv.setImageDrawable(getResources().getDrawable(R.drawable.tool_sound_off));
            }
            this.H3 = !this.H3;
        }
    }

    private void m1(boolean z) {
        if (z) {
            this.mTopControlView.setVisibility(8);
            this.mBottomToolButtonsView.setVisibility(8);
            this.mPlayTitleView.setVisibility(0);
            this.mFullScreenOrSelectVideoIv.setImageDrawable(getResources().getDrawable(R.drawable.tool_full_screen_land));
            this.mDownloadLandIv.setVisibility(0);
            this.mMuteLandIv.setVisibility(0);
            this.mCaptureLandView.setVisibility(0);
            return;
        }
        this.mTopControlView.setVisibility(0);
        this.mBottomToolButtonsView.setVisibility(0);
        this.mPlayTitleView.setVisibility(8);
        this.mFullScreenOrSelectVideoIv.setImageDrawable(getResources().getDrawable(R.drawable.tool_full_screen));
        this.mDownloadLandIv.setVisibility(8);
        this.mMuteLandIv.setVisibility(8);
        this.mCaptureLandView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n1(boolean z, boolean z2) {
        if (z) {
            this.mLoadingAnimationView.o();
            this.mLoadingAnimationView.setVisibility(0);
        } else {
            this.mLoadingAnimationView.g();
            this.mLoadingAnimationView.setVisibility(8);
            if (z2) {
                this.mTapRefreshView.setVisibility(0);
            } else {
                this.mTapRefreshView.setVisibility(8);
            }
        }
        if (z || z2) {
            this.mPlayIv.setAlpha(0.4f);
            this.mPauseIv.setAlpha(0.4f);
            this.mPositionTv.setAlpha(0.4f);
            this.mDurationTv.setAlpha(0.4f);
            this.mCaptureIv.setAlpha(0.4f);
            this.mCaptureIv.setClickable(false);
            this.mCaptureLandIv.setAlpha(0.4f);
            this.mCaptureLandView.setClickable(false);
            this.mTimeBar.setPlayedColor(getResources().getColor(R.color.common_iot_light_black));
            this.mTimeBar.setScrubberColor(getResources().getColor(R.color.common_iot_light_black));
            this.mTimeBar.setClickable(false);
            return;
        }
        this.mPlayIv.setAlpha(1.0f);
        this.mPauseIv.setAlpha(1.0f);
        this.mPositionTv.setAlpha(1.0f);
        this.mDurationTv.setAlpha(1.0f);
        this.mCaptureIv.setAlpha(1.0f);
        this.mCaptureIv.setClickable(true);
        this.mCaptureLandIv.setAlpha(1.0f);
        this.mCaptureLandView.setClickable(true);
        this.mTimeBar.setPlayedColor(getResources().getColor(R.color.common_iot_main_blue));
        this.mTimeBar.setScrubberColor(getResources().getColor(R.color.common_iot_main_blue));
        this.mTimeBar.setClickable(true);
    }

    public void T0() {
        TPSmartRefreshLayout tPSmartRefreshLayout = this.refreshLayout;
        if (tPSmartRefreshLayout != null) {
            tPSmartRefreshLayout.l();
        }
    }

    public void U0() {
        TPSmartRefreshLayout tPSmartRefreshLayout = this.refreshLayout;
        if (tPSmartRefreshLayout != null) {
            tPSmartRefreshLayout.q();
        }
    }

    public void V0() {
        TPSmartRefreshLayout tPSmartRefreshLayout = this.refreshLayout;
        if (tPSmartRefreshLayout != null) {
            tPSmartRefreshLayout.q();
            this.refreshLayout.l();
        }
    }

    public void b1(CloudVideoItem cloudVideoItem) {
        if (cloudVideoItem != null) {
            n1(false, false);
            this.z = cloudVideoItem;
            this.p2 = 0L;
            this.p1 = 0;
            this.p0.B(0, 0L);
            c1(this.z);
            CloudVideoListFragment cloudVideoListFragment = (CloudVideoListFragment) getFragmentManager().findFragmentById(R.id.cloud_video_container);
            if (cloudVideoListFragment != null) {
                cloudVideoListFragment.s1(cloudVideoItem.getCloudVideo().getUuid());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick
    public void capture() {
        S0();
    }

    @Override // com.tplink.iot.base.BaseFragment, com.tplink.iot.i.a
    @SuppressLint({"SourceLockedOrientationActivity"})
    public boolean d() {
        if (getResources().getConfiguration().orientation != 2) {
            return super.d();
        }
        getActivity().setRequestedOrientation(1);
        this.mSelectCloudVideoView.setVisibility(8);
        this.mEmptyPlayView.setVisibility(8);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick
    @SuppressLint({"SourceLockedOrientationActivity"})
    public void doBack() {
        d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick
    public void download() {
        PartCloudVideo partCloudVideo = this.z.getCloudVideo().getPartCloudVideos().get(0);
        long duration = partCloudVideo.getDuration();
        if (!TextUtils.isEmpty(this.L3)) {
            w.y(b.d.w.h.a.g(this.L3), duration, (this.z.getCloudVideo() == null || this.z.getCloudVideo().getUuid() == null) ? "" : this.z.getCloudVideo().getUuid());
        }
        String a2 = b.d.w.h.a.a(partCloudVideo.getM3u8());
        String uri = partCloudVideo.getUri();
        com.tplink.iot.h.f fVar = new com.tplink.iot.h.f("1000");
        this.N3 = fVar;
        fVar.z(this.z.getCloudVideo().getEventLocalTime() + ".mp4", a2, uri, new a());
    }

    @Override // com.tplink.iot.adapter.cloudvideo.CloudVideoListAdapter.d
    public void f0() {
    }

    public void f1(List<CloudVideoItem> list) {
        if (list != null) {
            this.J3.clear();
            this.J3.addAll(list);
            if (list.isEmpty()) {
                TPSmartRefreshLayout tPSmartRefreshLayout = this.refreshLayout;
                if (tPSmartRefreshLayout != null) {
                    tPSmartRefreshLayout.G(false);
                }
                RecyclerView recyclerView = this.mCloudVideoRv;
                if (recyclerView != null) {
                    recyclerView.setVisibility(8);
                }
            } else {
                TPSmartRefreshLayout tPSmartRefreshLayout2 = this.refreshLayout;
                if (tPSmartRefreshLayout2 != null) {
                    tPSmartRefreshLayout2.G(true);
                }
                RecyclerView recyclerView2 = this.mCloudVideoRv;
                if (recyclerView2 != null) {
                    recyclerView2.setVisibility(0);
                }
            }
            CloudVideoListAdapter cloudVideoListAdapter = this.I3;
            if (cloudVideoListAdapter != null) {
                cloudVideoListAdapter.H(this.J3);
            }
        }
    }

    public void g1(CloudVideoItem cloudVideoItem) {
        this.z = cloudVideoItem;
        Z0(cloudVideoItem.getCloudVideo());
    }

    public void h1(String str) {
        CloudVideoListAdapter cloudVideoListAdapter = this.I3;
        if (cloudVideoListAdapter != null) {
            cloudVideoListAdapter.N(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick
    public void hideVideoList() {
        this.mSelectCloudVideoView.setVisibility(8);
        this.mEmptyPlayView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick
    public void mute() {
        l1();
    }

    @Override // com.tplink.iot.widget.CirclePercentBar.c
    public void n() {
        download();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getArguments() != null) {
            this.L3 = getArguments().getString("cloud_video_device_id");
            this.M3 = (ALCameraDevice) getArguments().getSerializable("cloud_video_device");
            this.O3 = getArguments().getBoolean("cloud_video_open_from_me");
        }
        this.K3 = (VideoPlayerViewModel) ViewModelProviders.of(this).get(VideoPlayerViewModel.class);
        String g = b.d.w.h.a.g(this.L3);
        ALCameraDevice aLCameraDevice = this.M3;
        if (aLCameraDevice == null) {
            this.K3.n(g);
        } else {
            this.K3.o(g, aLCameraDevice);
        }
        j1();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        k1(configuration);
    }

    @Override // com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.cloud_video_player, viewGroup, false);
        ButterKnife.b(this, inflate);
        X0();
        return inflate;
    }

    @Override // com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        e1();
        com.tplink.iot.view.quicksetup.base.d.b0(getActivity(), R.color.pure_white);
        getActivity().getWindow().getDecorView().setSystemUiVisibility(8192);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        a1();
    }

    @Override // com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        k1(getResources().getConfiguration());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        Y0(this.z);
    }

    @Override // com.tplink.iot.adapter.cloudvideo.CloudVideoListAdapter.d
    public void p(CloudVideoItem cloudVideoItem) {
        if (cloudVideoItem.isHasVideo()) {
            b1(cloudVideoItem);
        } else {
            s0.p(getActivity(), getString(R.string.video_can_not_play_remind));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick
    public void reload() {
        CloudVideoItem k;
        n1(false, false);
        if (this.K3.l(this.z.getCloudVideo().getPartCloudVideos().get(0).getUriExpiresAt()) && (k = this.K3.k(this.z.getCloudVideo().getUuid(), this.J3)) != null) {
            this.z = k;
        }
        c1(this.z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick
    @SuppressLint({"SourceLockedOrientationActivity"})
    public void showVideoList() {
        if (getResources().getConfiguration().orientation != 2) {
            getActivity().setRequestedOrientation(6);
        } else if (this.mSelectCloudVideoView.getVisibility() == 8) {
            this.mSelectCloudVideoView.setVisibility(0);
            this.mEmptyPlayView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick
    public void topBack() {
        getActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick
    public void topClose() {
        CloudVideoListFragment cloudVideoListFragment = (CloudVideoListFragment) getFragmentManager().findFragmentById(R.id.cloud_video_container);
        if (cloudVideoListFragment != null) {
            cloudVideoListFragment.l1();
        }
        com.tplink.iot.h.f fVar = this.N3;
        if (fVar != null) {
            fVar.y();
            this.N3 = null;
        }
    }
}
