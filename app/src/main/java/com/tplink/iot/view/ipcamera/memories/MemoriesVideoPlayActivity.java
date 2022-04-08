package com.tplink.iot.view.ipcamera.memories;

import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.view.PointerIconCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.ViewModelProviders;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.c1;
import com.google.android.exoplayer2.e1;
import com.google.android.exoplayer2.h2;
import com.google.android.exoplayer2.j2;
import com.google.android.exoplayer2.l1;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.t1;
import com.google.android.exoplayer2.trackselection.k;
import com.google.android.exoplayer2.u1;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.v1;
import com.google.android.exoplayer2.video.v;
import com.google.android.exoplayer2.video.z;
import com.google.android.exoplayer2.w1;
import com.tplink.iot.R;
import com.tplink.iot.Utils.hls.d;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.DialogMemoryBottomOperationBinding;
import com.tplink.iot.databinding.ExoPlaybackControlViewBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.memories.MemoriesVideoPlayActivity;
import com.tplink.iot.view.ipcamera.memories.MemoryDeleteDialogFragment;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.ipcamera.memories.MemoriesViewModel;
import com.tplink.libtpmediaother.memory.MemoryBean;
import com.tplink.libtpmediaother.memory.r;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.apache.commons.lang.e;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

/* loaded from: classes2.dex */
public class MemoriesVideoPlayActivity extends BaseActivity implements g, EasyPermissions.PermissionCallbacks {
    private TextView H3;
    private PlayerView I3;
    private ViewGroup J3;
    private View K3;
    private TextView L3;
    private View M3;
    private View N3;
    private Animation O3;
    private Animation P3;
    private Animation Q3;
    private Animation R3;
    private e1 S3;
    private boolean U3;
    private int V3;
    private long W3;
    private int p0;
    private int p1;
    private View p2;
    private View p3;
    private MemoriesViewModel y;
    private MemoryBean z;
    private int T3 = 0;
    private boolean X3 = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements u1.e {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public /* synthetic */ void h() {
            MemoriesVideoPlayActivity.this.k1();
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
        public /* synthetic */ void M(boolean z) {
            w1.f(this, z);
        }

        @Override // com.google.android.exoplayer2.u1.c
        public /* synthetic */ void O() {
            v1.o(this);
        }

        @Override // com.google.android.exoplayer2.u1.c
        public void P(@NonNull PlaybackException playbackException) {
            int i = playbackException.errorCode;
            if (i == 4003) {
                MemoriesVideoPlayActivity.this.B1();
            } else if (i == 2005) {
                TSnackbar.z(TSnackbar.r(MemoriesVideoPlayActivity.this), R.string.record_error_video_damaged, -1).N();
                new Handler().postDelayed(new Runnable() { // from class: com.tplink.iot.view.ipcamera.memories.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        MemoriesVideoPlayActivity.a.this.h();
                    }
                }, 2000L);
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
        public /* synthetic */ void o(j2 j2Var, int i) {
            w1.w(this, j2Var, i);
        }

        @Override // com.google.android.exoplayer2.u1.c
        public /* synthetic */ void onRepeatModeChanged(int i) {
            w1.s(this, i);
        }

        @Override // com.google.android.exoplayer2.u1.c
        public /* synthetic */ void q(int i) {
            w1.m(this, i);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements MemoryDeleteDialogFragment.a {
        final /* synthetic */ MemoryDeleteDialogFragment a;

        b(MemoryDeleteDialogFragment memoryDeleteDialogFragment) {
            this.a = memoryDeleteDialogFragment;
        }

        @Override // com.tplink.iot.view.ipcamera.memories.MemoryDeleteDialogFragment.a
        public void a() {
            this.a.dismiss();
        }

        @Override // com.tplink.iot.view.ipcamera.memories.MemoryDeleteDialogFragment.a
        public void b() {
            this.a.dismiss();
            Intent intent = new Intent();
            intent.putExtra("MemoryDelete", true);
            r.f().E(MemoriesVideoPlayActivity.this.z);
            MemoriesVideoPlayActivity.this.setResult(PointerIconCompat.TYPE_NO_DROP, intent);
            MemoriesVideoPlayActivity.this.finish();
        }
    }

    private void A1(int i, String str) {
        EasyPermissions.f(this, str, i, com.tplink.iot.Utils.a1.b.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B1() {
        int i = this.T3 + 1;
        this.T3 = i;
        if (i >= 3) {
            this.T3 = 3;
            return;
        }
        e1 e1Var = this.S3;
        if (e1Var != null) {
            e1Var.prepare();
            this.S3.play();
        }
    }

    private void C1() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.memories.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MemoriesVideoPlayActivity.this.x1(view);
            }
        });
    }

    private void D1() {
        Uri uri;
        File file = new File(this.z.getVideoPath());
        if (file.exists()) {
            Uri fromFile = Uri.fromFile(file);
            if (Build.VERSION.SDK_INT < 20 || !"file".equals(fromFile.getScheme())) {
                uri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new ContentValues());
            } else {
                try {
                    uri = FileProvider.getUriForFile(this, b.d.q.b.p.b.n().concat(".provider"), file);
                } catch (IllegalArgumentException e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.STREAM", uri);
            intent.setType("video/*");
            startActivity(Intent.createChooser(intent, getString(R.string.memory_share)));
        }
    }

    private void G1() {
        if (this.y.l.get()) {
            this.M3.setVisibility(0);
            this.X3 = false;
        } else if (!this.y.l.get() || this.X3) {
            this.M3.setVisibility(8);
            this.X3 = true;
        } else {
            this.M3.setVisibility(8);
            this.X3 = true;
        }
    }

    private boolean g1() {
        return EasyPermissions.a(this, com.tplink.iot.Utils.a1.b.a());
    }

    private void h1() {
        MemoryDeleteDialogFragment A0 = MemoryDeleteDialogFragment.A0();
        A0.B0(new b(A0));
        A0.show(getSupportFragmentManager(), "MemoryDeleteDialogFragment");
    }

    private void i1() {
        this.y.o.set(true);
        r.f().e(this.z).y(new io.reactivex.g0.a() { // from class: com.tplink.iot.view.ipcamera.memories.k
            @Override // io.reactivex.g0.a
            public final void run() {
                MemoriesVideoPlayActivity.this.r1();
            }
        }).H0(new io.reactivex.g0.g() { // from class: com.tplink.iot.view.ipcamera.memories.h
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                MemoriesVideoPlayActivity.this.t1((Boolean) obj);
            }
        }, t.f8763c);
    }

    private void j1() {
        if (this.y.h.get()) {
            this.z.setMark(true);
            r.f().G(this.z);
            return;
        }
        this.z.setMark(false);
        r.f().G(this.z);
    }

    private void l1() {
        this.p2 = findViewById(R.id.root_view);
        this.p3 = findViewById(R.id.toolbar_layout);
        this.H3 = (TextView) findViewById(R.id.toolbar_title);
        this.I3 = (PlayerView) findViewById(R.id.video_view);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.video_play_layout);
        this.J3 = viewGroup;
        View.inflate(this, R.layout.player_view_memories_surface_view, viewGroup);
        this.I3 = (PlayerView) findViewById(R.id.video_view);
        this.K3 = findViewById(R.id.view_bottom_operation);
        this.L3 = (TextView) findViewById(R.id.video_play_time);
        DialogMemoryBottomOperationBinding dialogMemoryBottomOperationBinding = (DialogMemoryBottomOperationBinding) DataBindingUtil.bind(this.K3);
        dialogMemoryBottomOperationBinding.i(this);
        dialogMemoryBottomOperationBinding.h(this.y);
    }

    private void m1() {
        if (getIntent() != null) {
            Bundle extras = getIntent().getExtras();
            Objects.requireNonNull(extras);
            this.z = (MemoryBean) extras.getSerializable("MemoryBean");
        } else {
            this.z = new MemoryBean();
        }
        n1(this.z);
        this.O3 = AnimationUtils.loadAnimation(this, R.anim.record_head_enter);
        this.P3 = AnimationUtils.loadAnimation(this, R.anim.record_head_exit);
        this.Q3 = AnimationUtils.loadAnimation(this, R.anim.record_foot_enter);
        this.R3 = AnimationUtils.loadAnimation(this, R.anim.record_foot_exit);
    }

    private void n1(MemoryBean memoryBean) {
        String str;
        this.p1 = 640;
        this.p0 = 360;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        String str2 = null;
        try {
            mediaMetadataRetriever.setDataSource(memoryBean.getVideoPath());
            str = mediaMetadataRetriever.extractMetadata(18);
            try {
                str2 = mediaMetadataRetriever.extractMetadata(19);
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            str = null;
        }
        if (e.a(str) || e.a(str2)) {
            str = "640";
            str2 = "360";
        }
        this.p1 = Integer.parseInt(str);
        this.p0 = Integer.parseInt(str2);
    }

    private void o1() {
        this.y.g.set(true);
        this.y.f10390f.set(true);
        this.y.f10388d.set(true);
        this.y.f10389e.set(true);
        this.y.m.set(false);
        this.y.j.set(this.z.getDeviceAlias());
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).format(Long.valueOf(this.z.getTimestamp()));
        this.y.k.set(format);
        this.y.h.set(this.z.isMark());
        this.H3.setText(this.z.getDeviceAlias());
        this.L3.setText(format);
        ExoPlaybackControlViewBinding exoPlaybackControlViewBinding = (ExoPlaybackControlViewBinding) DataBindingUtil.bind(this.I3.findViewById(R.id.exo_controller_container));
        exoPlaybackControlViewBinding.h(this.y);
        exoPlaybackControlViewBinding.i(this);
        this.M3 = exoPlaybackControlViewBinding.p2;
        this.N3 = exoPlaybackControlViewBinding.p3;
        this.I3.setControllerVisibilityListener(new PlayerControlView.d() { // from class: com.tplink.iot.view.ipcamera.memories.j
            @Override // com.google.android.exoplayer2.ui.PlayerControlView.d
            public final void b(int i) {
                MemoriesVideoPlayActivity.this.v1(i);
            }
        });
        this.I3.setControllerShowTimeoutMs(-1);
        p1(this.z.getVideoPath());
    }

    private void p1(String str) {
        z1();
        if (str.contains("summary")) {
            this.S3 = new h2.b(this, new c1(this)).z();
        } else {
            d dVar = new d(this);
            dVar.i(2);
            this.S3 = new h2.b(this, dVar).z();
        }
        this.S3.N(new a());
        this.I3.setPlayer(this.S3);
        this.S3.p(this.U3);
        this.S3.B(this.V3, this.W3);
        this.S3.D(new l1.c().u(Uri.parse("file://" + str)).q("video/mp4").a());
        this.S3.prepare();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q1 */
    public /* synthetic */ void r1() throws Exception {
        this.y.o.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s1 */
    public /* synthetic */ void t1(Boolean bool) throws Exception {
        TSnackbar.z(TSnackbar.r(this), R.string.memory_record_save_success, -1).N();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u1 */
    public /* synthetic */ void v1(int i) {
        this.N3.startAnimation(i == 0 ? this.Q3 : this.R3);
        MemoriesViewModel memoriesViewModel = this.y;
        int i2 = memoriesViewModel.n - i;
        memoriesViewModel.n = i2;
        if (i2 < 0) {
            memoriesViewModel.n = 0;
            ObservableBoolean observableBoolean = memoriesViewModel.m;
            observableBoolean.set(!observableBoolean.get());
            F1();
        }
        G1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w1 */
    public /* synthetic */ void x1(View view) {
        onBackPressed();
    }

    private void y1() {
        e1 e1Var = this.S3;
        if (e1Var != null) {
            e1Var.p(false);
        }
    }

    private void z1() {
        e1 e1Var = this.S3;
        if (e1Var != null) {
            this.W3 = e1Var.V();
            this.V3 = this.S3.m();
            this.U3 = this.S3.E();
            this.S3.release();
            this.S3 = null;
        }
    }

    @Override // pub.devrel.easypermissions.EasyPermissions.PermissionCallbacks
    public void E0(int i, List<String> list) {
        if (2 == i) {
            i1();
        }
    }

    public void E1() {
        F1();
        G1();
    }

    public void F1() {
        int i = 0;
        boolean z = this.y.l.get() || this.y.m.get();
        if (this.y.l.get()) {
            this.p2.setBackgroundColor(ContextCompat.getColor(this, R.color.pure_black));
        } else if (this.y.m.get()) {
            this.p2.setBackgroundColor(ContextCompat.getColor(this, R.color.common_iot_dark_black));
        } else {
            this.p2.setBackgroundColor(ContextCompat.getColor(this, R.color.pure_white));
        }
        int i2 = 1792;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 23) {
            i2 = 9984;
        }
        if (i3 >= 19) {
            i2 |= 4096;
        }
        if (z) {
            i2 |= 6;
        }
        getWindow().getDecorView().setSystemUiVisibility(i2);
        ActionBar supportActionBar = getSupportActionBar();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.J3.getLayoutParams();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        if (this.y.l.get()) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.flags |= 1024;
            getWindow().setAttributes(attributes);
            getWindow().addFlags(512);
            marginLayoutParams.width = displayMetrics.widthPixels;
            marginLayoutParams.height = displayMetrics.heightPixels;
            marginLayoutParams.topMargin = 0;
            if (supportActionBar != null) {
                supportActionBar.hide();
            }
        } else {
            WindowManager.LayoutParams attributes2 = getWindow().getAttributes();
            attributes2.flags &= -1025;
            getWindow().setAttributes(attributes2);
            getWindow().clearFlags(512);
            int i4 = displayMetrics.widthPixels;
            marginLayoutParams.width = i4;
            marginLayoutParams.height = (int) (i4 / (this.p1 / this.p0));
            marginLayoutParams.topMargin = com.tplink.libtpnetwork.cameranetwork.util.e.a(80, this);
            if (supportActionBar != null) {
                supportActionBar.show();
            }
        }
        this.J3.setLayoutParams(marginLayoutParams);
        if (this.y.l.get()) {
            this.p3.setVisibility(8);
        } else if (this.y.m.get()) {
            this.p3.setVisibility(4);
        } else {
            this.p3.setVisibility(0);
        }
        this.K3.setVisibility(z ? 8 : 0);
        TextView textView = this.L3;
        if (z) {
            i = 8;
        }
        textView.setVisibility(i);
        if (!z) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.K3.getLayoutParams();
            int j = com.tplink.iot.view.quicksetup.base.d.j(this);
            int i5 = marginLayoutParams2.bottomMargin;
            if (i5 < j) {
                marginLayoutParams2.bottomMargin = i5 + j;
            }
            this.K3.setLayoutParams(marginLayoutParams2);
        }
    }

    public void k1() {
        Intent intent = new Intent();
        intent.putExtra("MemoryDelete", false);
        intent.putExtra("MemoryBean", this.z);
        setResult(PointerIconCompat.TYPE_NO_DROP, intent);
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (3 == i && g1()) {
            i1();
        }
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        k1();
    }

    @Override // com.tplink.iot.view.ipcamera.base.g, android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back /* 2131361999 */:
                onBackPressed();
                return;
            case R.id.iv_delete_item /* 2131363025 */:
            case R.id.tv_delete_item /* 2131364400 */:
                h1();
                return;
            case R.id.iv_download_item /* 2131363038 */:
            case R.id.tv_download_item /* 2131364424 */:
                if (g1()) {
                    i1();
                    return;
                } else {
                    A1(2, getString(R.string.permission_storage_requested));
                    return;
                }
            case R.id.iv_favorite_item /* 2131363047 */:
            case R.id.tv_favorite_item /* 2131364458 */:
                ObservableBoolean observableBoolean = this.y.h;
                observableBoolean.set(!observableBoolean.get());
                j1();
                return;
            case R.id.iv_share_item /* 2131363124 */:
            case R.id.tv_share_item /* 2131364626 */:
                D1();
                com.tplink.iot.Utils.x0.e.x();
                return;
            default:
                return;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.y.l.set(configuration.orientation == 2);
        E1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(128, 128);
        setContentView(R.layout.activity_memories_video);
        ((ViewGroup.MarginLayoutParams) findViewById(R.id.toolbar).getLayoutParams()).topMargin = com.tplink.iot.view.quicksetup.base.d.A(this);
        com.tplink.iot.view.quicksetup.base.d.d(this);
        com.tplink.iot.view.quicksetup.base.d.K(this);
        this.y = (MemoriesViewModel) ViewModelProviders.of(this).get(MemoriesViewModel.class);
        l1();
        C1();
        m1();
        o1();
        E1();
        setRequestedOrientation(2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        z1();
    }

    @Override // com.tplink.iot.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (16908332 != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        y1();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        EasyPermissions.d(i, strArr, iArr, this);
    }

    @Override // pub.devrel.easypermissions.EasyPermissions.PermissionCallbacks
    public void t(int i, List<String> list) {
        new AppSettingsDialog.b(this).d(R.string.permission_setting_ask_again).c(R.string.common_ok).b(R.string.common_cancel).e(2 == i ? 3 : -1).a().d();
    }
}
