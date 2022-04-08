package com.tplink.iot.view.ipcamera.play;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import b.d.q.b.o;
import com.google.android.material.badge.BadgeDrawable;
import com.tplink.iot.R;
import com.tplink.iot.Utils.ScreenOrientationListenHelper;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.l;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.core.AppContext;
import com.tplink.iot.databinding.ActivityVideoPlayNewIpcBinding;
import com.tplink.iot.databinding.LayoutCameraMenuButtonBinding;
import com.tplink.iot.databinding.LayoutCameraMenuButtonDayNightModeBinding;
import com.tplink.iot.databinding.LayoutCameraMenuButtonWhiteLampBinding;
import com.tplink.iot.databinding.LayoutCameraMenuDefinitionBinding;
import com.tplink.iot.databinding.LayoutCameraMenuInfraredBinding;
import com.tplink.iot.databinding.LayoutCameraMenuSettingsBinding;
import com.tplink.iot.view.cloudvideo.CloudStorageFragment;
import com.tplink.iot.view.ipcamera.cloudconnect.CameraCloudConnectActivity;
import com.tplink.iot.view.ipcamera.play.functionintroduce.CameraFirstShowFunctionGuideDialog;
import com.tplink.iot.view.ipcamera.setting.CameraSettingsActivity;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.view.wss.WssAmazonInstrWebActivity;
import com.tplink.iot.viewmodel.ipcamera.play.MultiLiveVideoViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.TalkViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VideoControlPanelViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VideoPlayViewModel;
import com.tplink.iot.viewmodel.ipcamera.setting.l9;
import com.tplink.iot.widget.UniversalDialog;
import com.tplink.libmediaapi.live.LiveMediaAPI;
import com.tplink.libtpappcommonmedia.bean.stream.BitStreamType;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.Utils.j;
import com.tplink.libtpnetwork.Utils.u;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;
import com.tplink.libtpnetwork.cameranetwork.model.NightMode;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

/* loaded from: classes2.dex */
public class VideoPlayActivity extends BaseActivity implements EasyPermissions.PermissionCallbacks, View.OnClickListener {
    private TextView H3;
    private PopupWindow I3;
    private View J3;
    private TextView K3;
    private ImageView L3;
    private PopupWindow M3;
    private View N3;
    private ImageView O3;
    private Toolbar P3;
    private MultiLiveVideoViewModel Q3;
    private TalkViewModel R3;
    private VideoControlPanelViewModel S3;
    private io.reactivex.e0.c T3;
    private io.reactivex.e0.c V3;
    private ScreenOrientationListenHelper W3;
    CameraFirstShowFunctionGuideDialog Z3;
    private b.a.a.a.a.a.a c4;
    private io.reactivex.e0.c d4;
    private ActivityVideoPlayNewIpcBinding p0;
    private VideoPlayViewModel p1;
    private ImageView p2;
    private View p3;
    private MultiLiveAdvancedFragment y;
    private Stack<com.tplink.iot.view.ipcamera.base.f> z;
    private io.reactivex.e0.b U3 = new io.reactivex.e0.b();
    private boolean X3 = false;
    UniversalDialog.a Y3 = new UniversalDialog.a();
    private boolean a4 = false;
    private boolean b4 = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements CameraFirstShowFunctionGuideDialog.d {
        a() {
        }

        @Override // com.tplink.iot.view.ipcamera.play.functionintroduce.CameraFirstShowFunctionGuideDialog.d
        public void onFinish() {
            VideoPlayActivity.this.setRequestedOrientation(2);
            VideoPlayActivity.this.v1();
            VideoPlayActivity.this.N1();
            VideoPlayActivity.this.e0("VideoPlay.VideoControlPanelFragment", null);
            VideoPlayActivity.this.u1();
            VideoPlayActivity.this.c3();
            VideoPlayActivity.this.d3();
            VideoPlayActivity.this.M1();
            if (com.tplink.iot.Utils.z0.h.C(VideoPlayActivity.this.p1.j)) {
                com.tplink.iot.Utils.z0.h.E(VideoPlayActivity.this.Z3.getActivity(), VideoPlayActivity.this.p1.j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Observer<String> {
        b() {
        }

        /* renamed from: a */
        public void onChanged(String str) {
            if (TextUtils.isEmpty(str)) {
                VideoPlayActivity.this.p0.p1.setVisibility(8);
                return;
            }
            VideoPlayActivity.this.p0.p1.setVisibility(0);
            VideoPlayActivity.this.p0.p1.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c extends Observable.OnPropertyChangedCallback {
        c() {
        }

        @Override // androidx.databinding.Observable.OnPropertyChangedCallback
        public void onPropertyChanged(Observable observable, int i) {
            int i2 = 0;
            VideoPlayActivity.this.K3.setVisibility(VideoPlayActivity.this.Q3.N3.get() ? 0 : 8);
            ImageView imageView = VideoPlayActivity.this.L3;
            if (VideoPlayActivity.this.Q3.N3.get()) {
                i2 = 8;
            }
            imageView.setVisibility(i2);
            if (!VideoPlayActivity.this.Q3.N3.get()) {
                VideoPlayActivity.this.L3.setImageResource(VideoPlayActivity.this.Q3.P3.get() ? VideoPlayActivity.this.b4 ? R.drawable.mode_day_choose : R.drawable.mode_day : VideoPlayActivity.this.b4 ? R.drawable.mode_night_choose : R.drawable.mode_night);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d extends Observable.OnPropertyChangedCallback {
        d() {
        }

        @Override // androidx.databinding.Observable.OnPropertyChangedCallback
        public void onPropertyChanged(Observable observable, int i) {
            VideoPlayActivity.this.H3.setText(VideoPlayActivity.this.Q3.X3.get() ? R.string.video_play_mode_hq : R.string.video_play_mode_lq);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e extends Observable.OnPropertyChangedCallback {
        e() {
        }

        @Override // androidx.databinding.Observable.OnPropertyChangedCallback
        public void onPropertyChanged(Observable observable, int i) {
            VideoPlayActivity.this.O3.setImageResource(VideoPlayActivity.this.Q3.U3.get() ? R.mipmap.white_lamp_on : R.mipmap.white_lamp_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f extends Observable.OnPropertyChangedCallback {
        f() {
        }

        @Override // androidx.databinding.Observable.OnPropertyChangedCallback
        public void onPropertyChanged(Observable observable, int i) {
            if (!VideoPlayActivity.this.p1.D.get()) {
                VideoPlayActivity.this.y1();
                VideoPlayActivity.this.z1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class g implements io.reactivex.g0.g<b.a.a.a.a.a.a> {
        g() {
        }

        /* renamed from: a */
        public void accept(b.a.a.a.a.a.a aVar) throws Exception {
            if (aVar != null) {
                if (VideoPlayActivity.this.c4 == null || (VideoPlayActivity.this.c4.i() == 0 && aVar.i() == 0)) {
                    VideoPlayActivity.this.c4 = aVar;
                } else if (VideoPlayActivity.this.c4.i() == 1 && aVar.i() == 0) {
                    VideoPlayActivity.this.c4 = aVar;
                    if (VideoPlayActivity.this.p1 != null) {
                        VideoPlayActivity.this.p1.x();
                    }
                    LiveMediaAPI.resetPipeErrorStatus();
                } else {
                    VideoPlayActivity.this.c4 = aVar;
                    if (VideoPlayActivity.this.p1 != null) {
                        VideoPlayActivity.this.p1.v();
                    }
                    LiveMediaAPI.resetPipeErrorStatus();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class h {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ScreenOrientationListenHelper.Orientation.values().length];
            a = iArr;
            try {
                iArr[ScreenOrientationListenHelper.Orientation.PORTRAIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ScreenOrientationListenHelper.Orientation.LANDSCAPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ScreenOrientationListenHelper.Orientation.REVERSE_LANDSCAPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A2 */
    public /* synthetic */ void B2() {
        if (this.Q3.N3.get()) {
            this.K3.setTextColor(getResources().getColor(R.color.white));
        } else {
            this.L3.setImageResource(this.Q3.O3.get() ? R.drawable.mode_night : R.drawable.mode_day);
        }
        this.b4 = false;
    }

    private void B1() {
        if (this.z.size() <= 1) {
            E1(2);
            return;
        }
        this.z.pop();
        com.tplink.iot.view.ipcamera.base.f peek = this.z.peek();
        V2(peek.b(), peek.a(), 1);
    }

    private int C1(Context context, float f2) {
        return Math.round(TypedValue.applyDimension(1, f2, context.getResources().getDisplayMetrics()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C2 */
    public /* synthetic */ void D2(View view) {
        WssAmazonInstrWebActivity.j1(this, "https://www.tp-link.com/en/support/faq/2592/");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E2 */
    public /* synthetic */ void F2(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a aVar) {
        String str = (String) aVar.a();
        if (str != null) {
            e0(str, null);
        }
    }

    private BaseFragment F1() {
        OperationShellFragment operationShellFragment = (OperationShellFragment) getSupportFragmentManager().findFragmentByTag("VideoPlay.CloudTerraceControlFragment");
        if (operationShellFragment != null) {
            return operationShellFragment;
        }
        OperationShellFragment operationShellFragment2 = new OperationShellFragment();
        Bundle bundle = new Bundle();
        bundle.putString("first_operation_fragment_tag", "VideoPlay.CloudTerraceControlFragment");
        bundle.putString("second_operation_fragment_tag", "VideoPlay.CloudTerracePresetFragment");
        operationShellFragment2.setArguments(bundle);
        return operationShellFragment2;
    }

    private int[] G1(int i) {
        int[] iArr = new int[2];
        if (i == 0) {
            iArr[0] = R.anim.slide_in_left;
            iArr[1] = R.anim.slide_out_right;
        } else if (i == 1) {
            iArr[0] = R.anim.pop_down_in;
            iArr[1] = R.anim.pop_down_out;
        } else if (i == 2) {
            iArr[0] = 17432576;
            iArr[1] = 17432577;
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G2 */
    public /* synthetic */ void H2(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a aVar) {
        String str = (String) aVar.a();
        if (str != null) {
            TSnackbar.y(this, str, PathInterpolatorCompat.MAX_NUM_POINTS).N();
        }
    }

    private PlayBackControlFragment H1() {
        PlayBackControlFragment playBackControlFragment = (PlayBackControlFragment) getSupportFragmentManager().findFragmentByTag("VideoPlay.PlayBackControlFragment");
        return playBackControlFragment == null ? new PlayBackControlFragment() : playBackControlFragment;
    }

    private BaseFragment I1() {
        OperationShellFragment operationShellFragment = (OperationShellFragment) getSupportFragmentManager().findFragmentByTag("VideoPlay.TalkFragment");
        if (operationShellFragment == null) {
            operationShellFragment = new OperationShellFragment();
            Bundle bundle = new Bundle();
            bundle.putString("first_operation_fragment_tag", "VideoPlay.TalkFragment");
            if (this.p1.I.get()) {
                bundle.putString("second_operation_fragment_tag", "VideoPlay.CloudTerraceControlFragment");
            }
            operationShellFragment.setArguments(bundle);
        }
        return operationShellFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I2 */
    public /* synthetic */ void J2(String str) {
        w1(str);
        this.p2.setAlpha(P1(str) ? 1.0f : 0.4f);
        if (!this.p1.r.get()) {
            S2(str);
            if (str != null) {
                l9.a().b(str).c();
            }
        }
        this.R3.O(str);
        this.S3.A();
        if (TextUtils.isEmpty(str) || this.z.size() <= 0 || !TextUtils.equals("VideoPlay.CloudTerraceControlFragment", this.z.peek().b()) || !LiveMediaAPI.isPlayingProperly(str)) {
            e0("VideoPlay.VideoControlPanelFragment", null);
        }
    }

    private VideoControlPanelFragment J1() {
        VideoControlPanelFragment videoControlPanelFragment = (VideoControlPanelFragment) getSupportFragmentManager().findFragmentByTag("VideoPlay.VideoControlPanelFragment");
        return videoControlPanelFragment == null ? new VideoControlPanelFragment() : videoControlPanelFragment;
    }

    private BaseFragment K1() {
        OperationShellFragment operationShellFragment = (OperationShellFragment) getSupportFragmentManager().findFragmentByTag("VideoPlay.VoiceCallFragment");
        if (operationShellFragment == null) {
            operationShellFragment = new OperationShellFragment();
            Bundle bundle = new Bundle();
            bundle.putString("first_operation_fragment_tag", "VideoPlay.VoiceCallFragment");
            if (this.p1.I.get()) {
                bundle.putString("second_operation_fragment_tag", "VideoPlay.CloudTerraceControlFragment");
            }
            operationShellFragment.setArguments(bundle);
        }
        return operationShellFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K2 */
    public /* synthetic */ void L2(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a aVar) {
        if (this.p1.N.get()) {
            CharSequence charSequence = (CharSequence) aVar.a();
            if (!TextUtils.isEmpty(charSequence)) {
                this.p0.q.setBackground(R.color.transparent);
                this.p0.q.a(true);
                this.p0.q.m(charSequence, 7000L);
                return;
            }
            this.p0.q.j();
        }
    }

    private void L1() {
        this.p1 = (VideoPlayViewModel) ViewModelProviders.of(this).get(VideoPlayViewModel.class);
        this.Q3 = (MultiLiveVideoViewModel) ViewModelProviders.of(this).get(MultiLiveVideoViewModel.class);
        this.R3 = (TalkViewModel) ViewModelProviders.of(this).get(TalkViewModel.class);
        this.S3 = (VideoControlPanelViewModel) ViewModelProviders.of(this).get(VideoControlPanelViewModel.class);
        this.p1.j = getIntent().getStringExtra("device_id_md5");
        VideoPlayViewModel videoPlayViewModel = this.p1;
        videoPlayViewModel.k.setValue(videoPlayViewModel.j);
        Stack<com.tplink.iot.view.ipcamera.base.f> n = this.p1.n();
        this.z = n;
        n.clear();
        this.S3.C(this.p1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"CheckResult"})
    public void M1() {
        io.reactivex.e0.c cVar = this.d4;
        if (cVar != null) {
            cVar.dispose();
        }
        this.d4 = b.a.a.a.a.a.d.a(AppContext.f6185c).L0(io.reactivex.l0.a.c()).L(b.a.a.a.a.a.b.b(NetworkInfo.State.CONNECTED)).L(b.a.a.a.a.a.b.c(0, 1)).l0(io.reactivex.d0.b.a.a()).G0(new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M2 */
    public /* synthetic */ void N2(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a aVar) {
        Boolean bool = aVar != null ? (Boolean) aVar.a() : null;
        if (bool != null && bool.booleanValue()) {
            this.p1.y("VideoPlay.VideoControlPanelFragment");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N1() {
        ScreenOrientationListenHelper screenOrientationListenHelper = new ScreenOrientationListenHelper(this);
        this.W3 = screenOrientationListenHelper;
        screenOrientationListenHelper.f(new ScreenOrientationListenHelper.b() { // from class: com.tplink.iot.view.ipcamera.play.w3
            @Override // com.tplink.iot.Utils.ScreenOrientationListenHelper.b
            public final void a(boolean z, ScreenOrientationListenHelper.Orientation orientation) {
                VideoPlayActivity.this.R1(z, orientation);
            }
        });
    }

    private void O1() {
        ActivityVideoPlayNewIpcBinding activityVideoPlayNewIpcBinding = (ActivityVideoPlayNewIpcBinding) DataBindingUtil.setContentView(this, R.layout.activity_video_play_new_ipc);
        this.p0 = activityVideoPlayNewIpcBinding;
        activityVideoPlayNewIpcBinding.h(this.p1);
        this.p0.y.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.play.i3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoPlayActivity.this.T1(view);
            }
        });
        T2();
        VideoPlayViewModel videoPlayViewModel = this.p1;
        if (com.tplink.iot.Utils.z0.h.B(videoPlayViewModel.j, videoPlayViewModel.k())) {
            A1();
            X2();
            u.l(this.p1.j, false);
        } else {
            v1();
            N1();
            e0("VideoPlay.VideoControlPanelFragment", null);
            u1();
            c3();
            d3();
            M1();
            if (com.tplink.iot.Utils.z0.h.C(this.p1.j)) {
                com.tplink.iot.Utils.z0.h.E(this, this.p1.j);
            }
        }
        this.p0.f6764f.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O2 */
    public /* synthetic */ void P2(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a aVar) {
        Boolean bool = (Boolean) aVar.a();
        if (bool == null) {
            return;
        }
        if (bool.booleanValue()) {
            D1();
        } else {
            A1();
        }
    }

    private boolean P1(String str) {
        return str != null && com.tplink.libtpnetwork.Utils.f.f(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q1 */
    public /* synthetic */ void R1(boolean z, ScreenOrientationListenHelper.Orientation orientation) {
        if (z && ScreenOrientationListenHelper.e(this) && orientation != null) {
            int i = h.a[orientation.ordinal()];
            if (i == 1) {
                setRequestedOrientation(1);
            } else if (i == 2) {
                setRequestedOrientation(0);
            } else if (i == 3) {
                setRequestedOrientation(8);
            }
        }
    }

    private void R2() {
        this.X3 = false;
        EasyPermissions.f(this, getString(R.string.permission_mic_requested), 0, "android.permission.RECORD_AUDIO");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S1 */
    public /* synthetic */ void T1(View view) {
        CameraCloudConnectActivity.k1(this, this.p1.j);
    }

    private void S2(final String str) {
        io.reactivex.e0.c cVar = this.T3;
        if (cVar != null && !cVar.isDisposed()) {
            this.T3.dispose();
        }
        if (str != null) {
            io.reactivex.e0.c G0 = l9.a().b(str).i().G0(new io.reactivex.g0.g() { // from class: com.tplink.iot.view.ipcamera.play.v3
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    VideoPlayActivity.this.f2(str, (String) obj);
                }
            });
            this.T3 = G0;
            this.U3.b(G0);
            l9.a().b(str).k().observe(this, new b());
        }
    }

    private void T2() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.P3 = toolbar;
        toolbar.setContentInsetStartWithNavigation(0);
        a1(R.mipmap.ic_white_back);
        setSupportActionBar(this.P3);
        this.P3.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.play.w2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoPlayActivity.this.h2(view);
            }
        });
        LayoutCameraMenuSettingsBinding layoutCameraMenuSettingsBinding = (LayoutCameraMenuSettingsBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.layout_camera_menu_settings, this.P3, false);
        layoutCameraMenuSettingsBinding.h(this.p1.u);
        layoutCameraMenuSettingsBinding.executePendingBindings();
        ImageView imageView = layoutCameraMenuSettingsBinding.f7223c;
        this.p2 = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.play.r3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoPlayActivity.this.j2(view);
            }
        });
        LayoutCameraMenuButtonDayNightModeBinding layoutCameraMenuButtonDayNightModeBinding = (LayoutCameraMenuButtonDayNightModeBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.layout_camera_menu_button_day_night_mode, this.P3, false);
        layoutCameraMenuButtonDayNightModeBinding.m(this.p1.D);
        layoutCameraMenuButtonDayNightModeBinding.h(this.p1.m);
        layoutCameraMenuButtonDayNightModeBinding.l(this.p1.q);
        layoutCameraMenuButtonDayNightModeBinding.n(new ObservableBoolean(true));
        layoutCameraMenuButtonDayNightModeBinding.i(this.p1.r);
        View root = layoutCameraMenuButtonDayNightModeBinding.getRoot();
        this.J3 = root;
        TextView textView = (TextView) root.findViewById(R.id.textView);
        this.K3 = textView;
        textView.setText(R.string.video_play_mode_auto);
        int i = 8;
        this.K3.setVisibility(this.Q3.N3.get() ? 0 : 8);
        ImageView imageView2 = (ImageView) this.J3.findViewById(R.id.imageView);
        this.L3 = imageView2;
        if (!this.Q3.N3.get()) {
            i = 0;
        }
        imageView2.setVisibility(i);
        if (!this.Q3.N3.get()) {
            this.L3.setImageResource(this.Q3.P3.get() ? R.drawable.mode_day : R.drawable.mode_night);
        }
        c cVar = new c();
        this.Q3.N3.addOnPropertyChangedCallback(cVar);
        this.Q3.P3.addOnPropertyChangedCallback(cVar);
        this.Q3.O3.addOnPropertyChangedCallback(cVar);
        View.OnClickListener s3Var = new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.play.s3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoPlayActivity.this.l2(view);
            }
        };
        this.L3.setOnClickListener(s3Var);
        this.K3.setOnClickListener(s3Var);
        LayoutCameraMenuButtonBinding layoutCameraMenuButtonBinding = (LayoutCameraMenuButtonBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.layout_camera_menu_button, this.P3, false);
        layoutCameraMenuButtonBinding.l(this.p1.D);
        layoutCameraMenuButtonBinding.i(this.p1.q);
        layoutCameraMenuButtonBinding.m(this.p1.N);
        layoutCameraMenuButtonBinding.h(this.p1.r);
        View root2 = layoutCameraMenuButtonBinding.getRoot();
        this.p3 = root2;
        TextView textView2 = (TextView) root2.findViewById(R.id.textView);
        this.H3 = textView2;
        textView2.setText(this.Q3.X3.get() ? R.string.video_play_mode_hq : R.string.video_play_mode_lq);
        this.Q3.X3.addOnPropertyChangedCallback(new d());
        this.H3.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.play.t3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoPlayActivity.this.n2(view);
            }
        });
        LayoutCameraMenuButtonWhiteLampBinding layoutCameraMenuButtonWhiteLampBinding = (LayoutCameraMenuButtonWhiteLampBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.layout_camera_menu_button_white_lamp, this.P3, false);
        layoutCameraMenuButtonWhiteLampBinding.m(this.p1.D);
        layoutCameraMenuButtonWhiteLampBinding.l(this.p1.q);
        layoutCameraMenuButtonWhiteLampBinding.n(this.p1.O);
        layoutCameraMenuButtonWhiteLampBinding.i(this.p1.r);
        layoutCameraMenuButtonWhiteLampBinding.h(this.p1.m);
        View root3 = layoutCameraMenuButtonWhiteLampBinding.getRoot();
        this.N3 = root3;
        ImageView imageView3 = (ImageView) root3.findViewById(R.id.textView);
        this.O3 = imageView3;
        imageView3.setImageResource(this.Q3.U3.get() ? R.mipmap.white_lamp_on : R.mipmap.white_lamp_off);
        this.Q3.U3.addOnPropertyChangedCallback(new e());
        this.O3.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.play.n3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoPlayActivity.this.p2(view);
            }
        });
        float intrinsicWidth = ((com.tplink.libtpnetwork.cameranetwork.util.e.b(this)[0] - getResources().getDrawable(R.mipmap.ic_white_back).getIntrinsicWidth()) - getResources().getDrawable(R.drawable.settings).getIntrinsicWidth()) - b.d.w.f.a.a(this, 160.0f);
        Paint paint = new Paint();
        float textSize = this.H3.getTextSize();
        paint.setTextSize(textSize);
        String charSequence = this.K3.getText().toString();
        String charSequence2 = this.H3.getText().toString();
        float measureText = paint.measureText(charSequence2);
        for (float measureText2 = paint.measureText(charSequence); intrinsicWidth < measureText + measureText2; measureText2 = paint.measureText(charSequence)) {
            textSize -= 1.0f;
            paint.setTextSize(textSize);
            measureText = paint.measureText(charSequence2);
        }
        this.H3.setTextSize(0, textSize);
        this.K3.setTextSize(0, textSize);
        this.p1.D.addOnPropertyChangedCallback(new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U1 */
    public /* synthetic */ void V1(String str) {
        LiveMediaAPI.allDisplayScreenshotPreview();
        LiveMediaAPI.stopRecord(str);
        LiveMediaAPI.destroyAllDisplay();
        CameraSettingsActivity.k2(this, str, true, true);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void U2() {
        if (this.I3 == null) {
            this.I3 = new PopupWindow();
            LayoutCameraMenuDefinitionBinding layoutCameraMenuDefinitionBinding = (LayoutCameraMenuDefinitionBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.layout_camera_menu_definition, this.P3, false);
            layoutCameraMenuDefinitionBinding.h(this.Q3.X3);
            View root = layoutCameraMenuDefinitionBinding.getRoot();
            this.I3.setContentView(root);
            View.OnClickListener d3Var = new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.play.d3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VideoPlayActivity.this.r2(view);
                }
            };
            root.findViewById(R.id.definition_hq).setOnClickListener(d3Var);
            root.findViewById(R.id.definition_lq).setOnClickListener(d3Var);
            Paint paint = new Paint();
            paint.setTextSize(Z2(this, 13.0f));
            float measureText = paint.measureText(getResources().getString(R.string.video_play_mode_hq));
            float measureText2 = paint.measureText(getResources().getString(R.string.video_play_mode_lq));
            if (measureText <= measureText2) {
                measureText = measureText2;
            }
            this.I3.setHeight((((int) (paint.getFontMetrics().descent - paint.getFontMetrics().ascent)) * 2) + C1(this, 60.0f) + 1);
            this.I3.setWidth(((int) measureText) + 1 + C1(this, 35.0f));
            this.I3.setOutsideTouchable(true);
            this.I3.setTouchInterceptor(new View.OnTouchListener() { // from class: com.tplink.iot.view.ipcamera.play.u3
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return VideoPlayActivity.this.t2(view, motionEvent);
                }
            });
            this.I3.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.tplink.iot.view.ipcamera.play.k3
                @Override // android.widget.PopupWindow.OnDismissListener
                public final void onDismiss() {
                    VideoPlayActivity.this.v2();
                }
            });
        }
        int[] iArr = new int[2];
        this.H3.getLocationOnScreen(iArr);
        int width = iArr[0] + ((this.H3.getWidth() - this.I3.getWidth()) / 2);
        int height = this.P3.getHeight() - C1(this, 1.0f);
        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        this.I3.showAtLocation(this.P3, BadgeDrawable.TOP_START, width, height + rect.top);
        this.H3.setTextColor(getResources().getColor(R.color.camera_live_menu_selected));
        this.a4 = true;
    }

    private void V2(String str, Bundle bundle, int i) {
        BaseFragment J1;
        if (("VideoPlay.TalkFragment".equals(str) || "VideoPlay.VoiceCallFragment".equals(str)) && !x1()) {
            this.z.pop();
            this.R3.Q(str);
            R2();
            return;
        }
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1425288173:
                if (str.equals("VideoPlay.VideoControlPanelFragment")) {
                    c2 = 0;
                    break;
                }
                break;
            case -989769983:
                if (str.equals("VideoPlay.VoiceCallFragment")) {
                    c2 = 1;
                    break;
                }
                break;
            case -662580069:
                if (str.equals("VideoPlay.TalkFragment")) {
                    c2 = 2;
                    break;
                }
                break;
            case 723559217:
                if (str.equals("VideoPlay.CloudTerraceControlFragment")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1637381171:
                if (str.equals("VideoPlay.PlayBackControlFragment")) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                J1 = J1();
                break;
            case 1:
                J1 = K1();
                break;
            case 2:
                J1 = I1();
                break;
            case 3:
                J1 = F1();
                break;
            case 4:
                J1 = H1();
                break;
            default:
                J1 = J1();
                break;
        }
        Q2(J1, str, bundle, i, R.id.control_fragment);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void W1(Boolean bool) throws Exception {
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void W2() {
        if (this.M3 == null) {
            this.M3 = new PopupWindow();
            LayoutCameraMenuInfraredBinding layoutCameraMenuInfraredBinding = (LayoutCameraMenuInfraredBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.layout_camera_menu_infrared, this.P3, false);
            layoutCameraMenuInfraredBinding.h(this.Q3.N3);
            layoutCameraMenuInfraredBinding.i(this.Q3.P3);
            layoutCameraMenuInfraredBinding.l(this.Q3.O3);
            View root = layoutCameraMenuInfraredBinding.getRoot();
            this.M3.setContentView(root);
            View.OnClickListener y2Var = new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.play.y2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VideoPlayActivity.this.x2(view);
                }
            };
            root.findViewById(R.id.infrared_mode_auto).setOnClickListener(y2Var);
            root.findViewById(R.id.infrared_mode_day).setOnClickListener(y2Var);
            root.findViewById(R.id.infrared_mode_night).setOnClickListener(y2Var);
            Paint paint = new Paint();
            paint.setTextSize(Z2(this, 13.0f));
            float measureText = paint.measureText(getResources().getString(R.string.video_play_mode_auto));
            float measureText2 = paint.measureText(getResources().getString(R.string.video_play_mode_day));
            float measureText3 = paint.measureText(getResources().getString(R.string.video_play_mode_night));
            int max = ((int) Math.max(measureText, measureText2)) + 1;
            if (measureText3 > max) {
                max = ((int) measureText3) + 1;
            }
            this.M3.setHeight((Math.max(getResources().getDrawable(R.drawable.mode_night).getIntrinsicHeight(), ((int) (paint.getFontMetrics().descent - paint.getFontMetrics().ascent)) + 1) * 3) + C1(this, 95.0f) + 1);
            this.M3.setWidth(max + getResources().getDrawable(R.drawable.mode_night).getIntrinsicWidth() + C1(this, 45.0f));
            this.M3.setOutsideTouchable(true);
            this.M3.setTouchInterceptor(new View.OnTouchListener() { // from class: com.tplink.iot.view.ipcamera.play.g3
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return VideoPlayActivity.this.z2(view, motionEvent);
                }
            });
            this.M3.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.tplink.iot.view.ipcamera.play.o3
                @Override // android.widget.PopupWindow.OnDismissListener
                public final void onDismiss() {
                    VideoPlayActivity.this.B2();
                }
            });
        }
        int[] iArr = new int[2];
        this.K3.getLocationOnScreen(iArr);
        int width = iArr[0] + ((this.K3.getWidth() - this.M3.getWidth()) / 2);
        int height = this.P3.getHeight() - C1(this, 1.0f);
        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        this.M3.showAtLocation(this.P3, BadgeDrawable.TOP_START, width, height + rect.top);
        if (this.Q3.N3.get()) {
            this.K3.setTextColor(getResources().getColor(R.color.camera_live_menu_selected));
        } else {
            this.L3.setImageResource(this.Q3.O3.get() ? R.drawable.mode_night_choose : R.drawable.mode_day_choose);
        }
        this.b4 = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X1 */
    public /* synthetic */ void Y1(Throwable th) throws Exception {
        TSnackbar.x(this, R.string.general_failed, -1).N();
        th.printStackTrace();
    }

    private void X2() {
        CameraFirstShowFunctionGuideDialog X0 = CameraFirstShowFunctionGuideDialog.X0(this.p1.k(), this.p1.j, new a());
        this.Z3 = X0;
        X0.show(getSupportFragmentManager(), CameraFirstShowFunctionGuideDialog.f8955c);
    }

    private void Y2(String str) {
        new TPMaterialDialogV2.Builder(this).setTitle(R.string.sdcard_fail_to_initialize).i(R.string.sdcard_abnormal_tips, R.color.common_iot_dark_black).o(R.string.wss_function_learn_more, R.color.common_iot_main_blue, new TPMaterialDialogV2.d() { // from class: com.tplink.iot.view.ipcamera.play.h3
            @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
            public final void onClick(View view) {
                VideoPlayActivity.this.D2(view);
            }
        }).l(R.string.action_got_it, R.color.common_iot_light_black, null).setCancelable(false).c(false).g(8, 8).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z1 */
    public /* synthetic */ void a2() {
        this.U3.b(this.p1.i().L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).H0(b3.f8945c, new io.reactivex.g0.g() { // from class: com.tplink.iot.view.ipcamera.play.m3
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                VideoPlayActivity.this.Y1((Throwable) obj);
            }
        }));
    }

    private int Z2(Context context, float f2) {
        return Math.round(TypedValue.applyDimension(2, f2, context.getResources().getDisplayMetrics()));
    }

    private void a3() {
        ScreenOrientationListenHelper screenOrientationListenHelper = this.W3;
        if (screenOrientationListenHelper != null) {
            screenOrientationListenHelper.g();
        }
    }

    private void b3() {
        ScreenOrientationListenHelper screenOrientationListenHelper = this.W3;
        if (screenOrientationListenHelper != null) {
            screenOrientationListenHelper.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c2 */
    public /* synthetic */ void d2(String str) {
        LiveMediaAPI.allDisplayScreenshotPreview();
        LiveMediaAPI.stopRecord(str);
        LiveMediaAPI.destroyAllDisplay();
        CameraSettingsActivity.k2(this, str, true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c3() {
        this.p1.m().observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.play.e3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VideoPlayActivity.this.P2((a) obj);
            }
        });
        this.p1.l().observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.play.a3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VideoPlayActivity.this.F2((a) obj);
            }
        });
        this.p1.o().observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.play.p3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VideoPlayActivity.this.H2((a) obj);
            }
        });
        this.p1.k.observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.play.c3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VideoPlayActivity.this.J2((String) obj);
            }
        });
        this.p1.f10584f.observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.play.x2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VideoPlayActivity.this.L2((a) obj);
            }
        });
        this.R3.o.observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.play.l3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VideoPlayActivity.this.N2((a) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d3() {
        if (this.p1.G.get()) {
            getWindow().getDecorView().setSystemUiVisibility(4102);
            getWindow().setFlags(1024, 1024);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.p0.H3.getLayoutParams();
            getWindowManager().getDefaultDisplay().getRealMetrics(new DisplayMetrics());
            layoutParams.width = -1;
            layoutParams.height = -1;
            this.P3.setVisibility(8);
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.hide();
                return;
            }
            return;
        }
        getWindow().getDecorView().setSystemUiVisibility(0);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.flags &= -1025;
        getWindow().setAttributes(attributes);
        getWindow().clearFlags(512);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.p0.H3.getLayoutParams();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        layoutParams2.width = displayMetrics.widthPixels;
        layoutParams2.height = com.tplink.iot.Utils.z0.h.p(this) + o.a(this, 40.0f);
        this.P3.setVisibility(0);
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e2 */
    public /* synthetic */ void f2(final String str, String str2) throws Exception {
        b.d.w.c.a.e("SDCardManager", "******************" + str2);
        if (str2 != null) {
            TPCameraDeviceContext K1 = TPIoTClientManager.K1(str);
            char c2 = 65535;
            switch (str2.hashCode()) {
                case -854352539:
                    if (str2.equals("dilatant_suspect")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -482587636:
                    if (str2.equals("formatSuccess")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 323383221:
                    if (str2.equals("formatFail")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 734754363:
                    if (str2.equals("recordOpen")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1291357223:
                    if (str2.equals("recordClose")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 1880030787:
                    if (str2.equals("unformatted")) {
                        c2 = 5;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    Y2(str);
                    return;
                case 1:
                    this.Y3.w(getString(R.string.sdcard_formatted)).q(getString(R.string.sdcard_formatted_msg)).s(getString(R.string.device_setting_to_setting)).u(getString(R.string.common_ok)).t(null).r(new UniversalDialog.b() { // from class: com.tplink.iot.view.ipcamera.play.f3
                        @Override // com.tplink.iot.widget.UniversalDialog.b
                        public final void a() {
                            VideoPlayActivity.this.d2(str);
                        }
                    });
                    break;
                case 2:
                    this.Y3.q(getString(R.string.device_setting_format_failed)).u(getString(R.string.common_ok)).t(null).r(null).m(true);
                    break;
                case 3:
                    if (K1.getCameraDevice() == null || !K1.getCameraDevice().isUserRoleTypeDevice()) {
                        this.Y3.w(getString(R.string.sdcard_identified)).q(getString(R.string.sdcard_identified_msg)).u(getString(R.string.common_ok)).s(getString(R.string.device_setting_to_setting)).t(null).r(new UniversalDialog.b() { // from class: com.tplink.iot.view.ipcamera.play.j3
                            @Override // com.tplink.iot.widget.UniversalDialog.b
                            public final void a() {
                                VideoPlayActivity.this.V1(str);
                            }
                        });
                        break;
                    } else {
                        return;
                    }
                case 4:
                    if (K1.getCameraDevice() == null || !K1.getCameraDevice().isUserRoleTypeDevice()) {
                        this.Y3.q(getString(R.string.device_setting_detetion_close_msg)).u(getString(R.string.device_enable)).s(getString(R.string.action_cancel)).m(true).t(new UniversalDialog.c() { // from class: com.tplink.iot.view.ipcamera.play.q3
                            @Override // com.tplink.iot.widget.UniversalDialog.c
                            public final void a() {
                                VideoPlayActivity.this.a2();
                            }
                        }).r(null);
                        break;
                    } else {
                        return;
                    }
                case 5:
                    this.Y3.w(getString(R.string.new_sd_card_identified_title)).q(getString(R.string.new_sd_card_identified_text)).u(getString(R.string.initialize)).s(getString(R.string.action_cancel)).t(new UniversalDialog.c() { // from class: com.tplink.iot.view.ipcamera.play.z2
                        @Override // com.tplink.iot.widget.UniversalDialog.c
                        public final void a() {
                            l9.a().b(str).e();
                        }
                    }).r(null);
                    break;
            }
            this.Y3.l().show(getSupportFragmentManager(), "SdCardStatusDialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g2 */
    public /* synthetic */ void h2(View view) {
        onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i2 */
    public /* synthetic */ void j2(View view) {
        String str;
        if (view.getAlpha() == 1.0f && (str = this.p1.j) != null) {
            io.reactivex.e0.c cVar = this.V3;
            if (cVar != null) {
                cVar.dispose();
            }
            LiveMediaAPI.muteAudio(str, true);
            LiveMediaAPI.previewScreenShot(str);
            LiveMediaAPI.destroyAllDisplay();
            LiveMediaAPI.stopRecord(str);
            CameraSettingsActivity.k2(this, str, true, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k2 */
    public /* synthetic */ void l2(View view) {
        if (j.h(this.p1.m)) {
            Toast.makeText(this, (int) R.string.camera_share_tip_no_permission, 0).show();
        } else if (this.b4) {
            z1();
        } else {
            W2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m2 */
    public /* synthetic */ void n2(View view) {
        if (this.a4) {
            y1();
            return;
        }
        U2();
        if (j.a(this.p1.f10584f, R.string.live_video_change_resolutions_tips)) {
            this.p1.f10584f.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(""));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o2 */
    public /* synthetic */ void p2(View view) {
        if (j.h(this.p1.m)) {
            Toast.makeText(this, (int) R.string.camera_share_tip_no_permission, 0).show();
        } else {
            this.Q3.H0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q2 */
    public /* synthetic */ void r2(View view) {
        this.Q3.z0(view.getId() == R.id.definition_hq ? BitStreamType.MAIN_HD : BitStreamType.MINOR_VGA);
        com.tplink.iot.Utils.x0.e.f(this.Q3.C());
        y1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s2 */
    public /* synthetic */ boolean t2(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 4) {
            return false;
        }
        int[] iArr = new int[2];
        this.H3.getLocationOnScreen(iArr);
        if (iArr[0] < motionEvent.getRawX() && motionEvent.getRawX() < iArr[0] + this.H3.getWidth() && iArr[1] < motionEvent.getRawY() && motionEvent.getRawY() < iArr[1] + this.H3.getHeight()) {
            return true;
        }
        y1();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u1() {
        CloudStorageFragment cloudStorageFragment = new CloudStorageFragment();
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        if (!cloudStorageFragment.isAdded()) {
            beginTransaction.add(R.id.fl_cloud_storage_fragment, cloudStorageFragment, CloudStorageFragment.class.getName());
        }
        beginTransaction.commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u2 */
    public /* synthetic */ void v2() {
        this.H3.setTextColor(getResources().getColor(R.color.white));
        this.a4 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v1() {
        if (this.y == null) {
            this.y = new MultiLiveAdvancedFragment();
        }
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        if (!this.y.isAdded()) {
            MultiLiveAdvancedFragment multiLiveAdvancedFragment = this.y;
            beginTransaction.replace(R.id.video_fragment, multiLiveAdvancedFragment, multiLiveAdvancedFragment.getClass().getName());
        }
        beginTransaction.commitAllowingStateLoss();
    }

    private void w1(String str) {
        boolean z = false;
        if (!TextUtils.isEmpty(str)) {
            ALCameraDevice cameraDevice = TPIoTClientManager.K1(str).getCameraDevice();
            if (cameraDevice != null && cameraDevice.isCameraLocked()) {
                z = true;
            }
            this.p2.setEnabled(!z);
            this.p1.r.set(z);
            return;
        }
        this.p1.r.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w2 */
    public /* synthetic */ void x2(View view) {
        int id = view.getId();
        this.Q3.y0(id == R.id.infrared_mode_auto ? NightMode.AUTO : id == R.id.infrared_mode_day ? NightMode.DAY : NightMode.NIGHT);
        z1();
    }

    private boolean x1() {
        return EasyPermissions.a(this, "android.permission.RECORD_AUDIO");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y2 */
    public /* synthetic */ boolean z2(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 4) {
            return false;
        }
        int[] iArr = new int[2];
        this.K3.getLocationOnScreen(iArr);
        if (iArr[0] < motionEvent.getRawX() && motionEvent.getRawX() < iArr[0] + this.K3.getWidth() && iArr[1] < motionEvent.getRawY() && motionEvent.getRawY() < iArr[1] + this.K3.getHeight()) {
            return true;
        }
        z1();
        return true;
    }

    public void A1() {
        setRequestedOrientation(1);
    }

    public void D1() {
        setRequestedOrientation(0);
    }

    @Override // pub.devrel.easypermissions.EasyPermissions.PermissionCallbacks
    public void E0(int i, List<String> list) {
        String o;
        if (i == 0 && (o = this.R3.o()) != null) {
            this.p1.y(o);
        }
    }

    public void E1(int i) {
        super.finish();
        if (i != 3) {
            int[] G1 = G1(i);
            overridePendingTransition(G1[0], G1[1]);
        }
    }

    protected void Q2(Fragment fragment, String str, Bundle bundle, int i, int i2) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        if (bundle != null && bundle.size() > 0) {
            if (fragment.isAdded() || fragment.isVisible() || fragment.getArguments() != null) {
                Bundle arguments = fragment.getArguments();
                if (arguments != null) {
                    for (String str2 : bundle.keySet()) {
                        if (bundle.get(str2) instanceof String) {
                            arguments.putString(str2, bundle.getString(str2));
                        } else if (bundle.get(str2) instanceof Boolean) {
                            arguments.putBoolean(str2, bundle.getBoolean(str2));
                        } else if (bundle.get(str2) instanceof Long) {
                            arguments.putLong(str2, bundle.getLong(str2));
                        } else if (bundle.get(str2) instanceof Serializable) {
                            arguments.putSerializable(str2, bundle.getSerializable(str2));
                        } else if (bundle.get(str2) instanceof Parcelable) {
                            arguments.putParcelable(str2, bundle.getParcelable(str2));
                        }
                    }
                }
            } else {
                fragment.setArguments(bundle);
            }
        }
        if ("VideoPlay.VideoControlPanelFragment".equals(str)) {
            beginTransaction.setCustomAnimations(R.anim.pop_down_in, R.anim.pop_down_out);
        } else {
            int[] a2 = l.a(i);
            if (!(a2[0] == 0 || a2[1] == 0)) {
                beginTransaction.setCustomAnimations(a2[0], a2[1]);
            }
        }
        beginTransaction.replace(i2, fragment, str).commitAllowingStateLoss();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            LiveMediaAPI.disableRelayTimer();
            this.Q3.A();
        } else if (action == 1 || action == 3) {
            this.Q3.B();
            LiveMediaAPI.enableRelayTimer();
        }
        return dispatchTouchEvent;
    }

    public void e0(String str, Bundle bundle) {
        com.tplink.iot.view.ipcamera.base.f fVar = new com.tplink.iot.view.ipcamera.base.f();
        fVar.d(str);
        fVar.c(bundle);
        if (this.z.size() <= 0 || !TextUtils.equals(str, this.z.peek().b())) {
            boolean z = false;
            Iterator<com.tplink.iot.view.ipcamera.base.f> it = this.z.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().b().equalsIgnoreCase(str)) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (z) {
                while (!this.z.pop().b().equalsIgnoreCase(str) && this.z.size() > 0) {
                }
            }
            this.z.push(fVar);
            V2(str, bundle, 1);
        }
    }

    @Override // android.app.Activity
    public void finish() {
        E1(0);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        CloudStorageFragment cloudStorageFragment;
        super.onActivityResult(i, i2, intent);
        if (1 != i || this.X3) {
            if (i == 1345 && (cloudStorageFragment = (CloudStorageFragment) getSupportFragmentManager().findFragmentByTag(CloudStorageFragment.class.getName())) != null) {
                cloudStorageFragment.onActivityResult(i, i2, intent);
            }
        } else if (EasyPermissions.a(this, "android.permission.RECORD_AUDIO")) {
            String o = this.R3.o();
            if (o != null) {
                this.p1.y(o);
            }
        } else {
            this.R3.k.set(false);
            this.R3.m.set(false);
        }
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.p1.G.get()) {
            A1();
        } else {
            B1();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        ALCameraDevice cameraDevice;
        if (view.getId() == R.id.locked_cover && (str = this.p1.j) != null && (cameraDevice = TPIoTClientManager.K1(str).getCameraDevice()) != null) {
            com.tplink.iot.viewmodel.home.u.f(this, cameraDevice.getLockMessage());
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        VideoPlayViewModel videoPlayViewModel = this.p1;
        boolean z = true;
        if (configuration.orientation == 1) {
            z = false;
        }
        videoPlayViewModel.z(z);
        d3();
        this.p1.g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        L1();
        O1();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_live, menu);
        this.p2.setPaddingRelative(0, 0, C1(this, 16.0f), 0);
        this.P3.getMenu().findItem(R.id.action_settings).setActionView(this.p2);
        this.P3.getMenu().findItem(R.id.action_lamp).setActionView(this.N3);
        this.P3.getMenu().findItem(R.id.action_infrared_mode).setActionView(this.J3);
        this.P3.getMenu().findItem(R.id.action_definition).setActionView(this.p3);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        io.reactivex.e0.c cVar = this.V3;
        if (cVar != null) {
            cVar.dispose();
        }
        y1();
        z1();
        this.U3.d();
        ScreenOrientationListenHelper screenOrientationListenHelper = this.W3;
        if (screenOrientationListenHelper != null) {
            screenOrientationListenHelper.d();
        }
        String str = this.p1.j;
        if (str != null) {
            LiveMediaAPI.stopRecord(str);
            l9.a().b(this.p1.j).d();
        }
        LiveMediaAPI.destroyAllDisplay();
        o.d("");
        io.reactivex.e0.c cVar2 = this.d4;
        if (cVar2 != null) {
            cVar2.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        b3();
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        this.p2.setAlpha(P1(this.p1.j) ? 1.0f : 0.4f);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        EasyPermissions.d(i, strArr, iArr, this);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        this.S3.A();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a3();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.p1.g();
        this.p1.w();
        this.R3.L();
        LiveMediaAPI.setPlayInPreviewPage(false);
        LiveMediaAPI.bindCallingVariable(this.R3.k);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.U3.dispose();
        LiveMediaAPI.disableRelayTimer();
        if (LiveMediaAPI.getCallingObservable() == this.R3.k) {
            LiveMediaAPI.bindCallingVariable(null);
        }
    }

    @Override // pub.devrel.easypermissions.EasyPermissions.PermissionCallbacks
    public void t(int i, List<String> list) {
        new AppSettingsDialog.b(this).d(R.string.permission_setting_ask_again).c(R.string.action_yes).b(R.string.action_no).e(i == 0 ? 1 : -1).a().d();
    }

    public void y1() {
        PopupWindow popupWindow = this.I3;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.I3.dismiss();
        }
    }

    public void z1() {
        PopupWindow popupWindow = this.M3;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.M3.dismiss();
        }
    }
}
