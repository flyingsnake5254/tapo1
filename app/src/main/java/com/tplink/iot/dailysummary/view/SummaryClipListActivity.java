package com.tplink.iot.dailysummary.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.h2;
import com.google.android.exoplayer2.j2;
import com.google.android.exoplayer2.l1;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.t1;
import com.google.android.exoplayer2.u1;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.v1;
import com.google.android.exoplayer2.video.v;
import com.google.android.exoplayer2.video.z;
import com.google.android.exoplayer2.w1;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPMaterialDialogV3;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.dailysummary.network.bean.common.SummaryClip;
import com.tplink.iot.dailysummary.network.bean.common.SummaryClipVideo;
import com.tplink.iot.dailysummary.view.adapter.SummaryClipAdapter;
import com.tplink.iot.dailysummary.viewmodel.SummaryClipListViewModel;
import com.tplink.iot.databinding.ActivitySummaryClipListBinding;
import com.tplink.iot.widget.CirclePercentBar;
import io.reactivex.s;
import java.io.File;
import java.util.List;

/* compiled from: SummaryClipListActivity.kt */
/* loaded from: classes2.dex */
public final class SummaryClipListActivity extends BaseActivity {
    public static final a y = new a(null);
    private boolean H3;
    private SummaryClipAdapter I3;
    private View J3;
    private View K3;
    private View L3;
    private View M3;
    private View N3;
    private View O3;
    private ImageView P3;
    private ImageView Q3;
    private ImageView R3;
    private View S3;
    private View T3;
    private PlayerView U3;
    private CirclePercentBar V3;
    private View W3;
    private TPMaterialDialogV3 X3;
    private RecyclerView p0;
    private h2 p1;
    private io.reactivex.e0.c p2;
    private Thread p3;
    private SummaryClipListViewModel z;

    /* compiled from: SummaryClipListActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final void a(Context context, int i) {
            kotlin.jvm.internal.j.e(context, "context");
            Intent intent = new Intent(context, SummaryClipListActivity.class);
            intent.putExtra("clip_index", i);
            context.startActivity(intent);
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SummaryClipListActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b implements CirclePercentBar.c {
        b() {
        }

        @Override // com.tplink.iot.widget.CirclePercentBar.c
        public final void n() {
            SummaryClipListActivity.this.t1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SummaryClipListActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c implements View.OnClickListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TPMaterialDialogV3 f6284c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ SummaryClipListActivity f6285d;

        c(TPMaterialDialogV3 tPMaterialDialogV3, SummaryClipListActivity summaryClipListActivity) {
            this.f6284c = tPMaterialDialogV3;
            this.f6285d = summaryClipListActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f6284c.dismiss();
            SummaryClipListActivity.n1(this.f6285d).l();
        }
    }

    /* compiled from: SummaryClipListActivity.kt */
    /* loaded from: classes2.dex */
    public static final class d implements u1.e {
        d() {
        }

        @Override // com.google.android.exoplayer2.text.k
        public /* synthetic */ void B(List list) {
            w1.b(this, list);
        }

        @Override // com.google.android.exoplayer2.u1.c
        public /* synthetic */ void G(TrackGroupArray trackGroupArray, com.google.android.exoplayer2.trackselection.k kVar) {
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
        public void P(PlaybackException error) {
            kotlin.jvm.internal.j.e(error, "error");
            SummaryClipListActivity.n1(SummaryClipListActivity.this).z(true);
            b.d.w.c.a.c("SPlayActivity-tyler", "onPlayerError: " + error.getMessage());
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
        public void U(boolean z, int i) {
            if (i == 1) {
                SummaryClipListActivity.n1(SummaryClipListActivity.this).A(false);
            } else if (i != 2) {
                int i2 = 6;
                if (i == 3) {
                    SummaryClipListActivity.n1(SummaryClipListActivity.this).A(true);
                    SummaryClipListActivity.n1(SummaryClipListActivity.this).y(false);
                    SummaryClipListViewModel n1 = SummaryClipListActivity.n1(SummaryClipListActivity.this);
                    if (z) {
                        i2 = 5;
                    }
                    n1.B(i2);
                } else if (i == 4) {
                    SummaryClipListActivity.n1(SummaryClipListActivity.this).B(6);
                }
            } else {
                SummaryClipListActivity.n1(SummaryClipListActivity.this).y(true);
            }
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
        public void g(boolean z) {
            SummaryClipListActivity.n1(SummaryClipListActivity.this).y(z);
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
        public void o(j2 timeline, int i) {
            kotlin.jvm.internal.j.e(timeline, "timeline");
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
    /* compiled from: SummaryClipListActivity.kt */
    /* loaded from: classes2.dex */
    public static final class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SummaryClipListActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SummaryClipListActivity.kt */
    /* loaded from: classes2.dex */
    public static final class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SummaryClipListActivity.this.q1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SummaryClipListActivity.kt */
    /* loaded from: classes2.dex */
    public static final class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SummaryClipListActivity.this.t1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SummaryClipListActivity.kt */
    /* loaded from: classes2.dex */
    public static final class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SummaryClipListActivity.this.t1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SummaryClipListActivity.kt */
    /* loaded from: classes2.dex */
    public static final class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SummaryClipListActivity.this.s1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SummaryClipListActivity.kt */
    /* loaded from: classes2.dex */
    public static final class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SummaryClipListActivity.this.s1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SummaryClipListActivity.kt */
    /* loaded from: classes2.dex */
    public static final class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SummaryClipListActivity summaryClipListActivity = SummaryClipListActivity.this;
            summaryClipListActivity.r1(!summaryClipListActivity.H3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SummaryClipListActivity.kt */
    /* loaded from: classes2.dex */
    public static final class l implements View.OnClickListener {
        l() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SummaryClipListActivity.this.r1(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SummaryClipListActivity.kt */
    /* loaded from: classes2.dex */
    public static final class m<T> implements Observer<Boolean> {
        m() {
        }

        /* renamed from: a */
        public final void onChanged(Boolean it) {
            kotlin.jvm.internal.j.d(it, "it");
            if (it.booleanValue()) {
                SummaryClipListActivity summaryClipListActivity = SummaryClipListActivity.this;
                String string = summaryClipListActivity.getString(R.string.video_capture_saved);
                kotlin.jvm.internal.j.d(string, "getString(R.string.video_capture_saved)");
                com.tplink.iot.e.a.a.d(summaryClipListActivity, string, false, 4, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SummaryClipListActivity.kt */
    /* loaded from: classes2.dex */
    public static final class n<T> implements Observer<Integer> {
        n() {
        }

        /* renamed from: a */
        public final void onChanged(Integer it) {
            CirclePercentBar k1 = SummaryClipListActivity.k1(SummaryClipListActivity.this);
            kotlin.jvm.internal.j.d(it, "it");
            k1.setPercentData(it.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SummaryClipListActivity.kt */
    /* loaded from: classes2.dex */
    public static final class o<T> implements Observer<Integer> {
        o() {
        }

        /* renamed from: a */
        public final void onChanged(Integer num) {
            if (num == null || num.intValue() != 5) {
                if (num == null || num.intValue() != 6) {
                    if (num == null || num.intValue() != 0) {
                        if (num != null && num.intValue() == 1) {
                            h2 h2Var = SummaryClipListActivity.this.p1;
                            if (h2Var != null) {
                                h2Var.p(false);
                            }
                            SummaryClipListActivity.this.u1();
                        } else if (num != null && num.intValue() == 2) {
                            SummaryClipListActivity.k1(SummaryClipListActivity.this).setPercentData(100);
                            TextView textView = (TextView) SummaryClipListActivity.i1(SummaryClipListActivity.this).findViewById(R.id.tv_download_state);
                            if (textView != null) {
                                textView.setText(R.string.download_memory_success);
                            }
                            Button button = (Button) SummaryClipListActivity.i1(SummaryClipListActivity.this).findViewById(R.id.btn_negative);
                            if (button != null) {
                                button.setText(R.string.common_ok);
                            }
                        } else if (num != null && num.intValue() == 3) {
                            SummaryClipListActivity.k1(SummaryClipListActivity.this).m();
                            TextView textView2 = (TextView) SummaryClipListActivity.i1(SummaryClipListActivity.this).findViewById(R.id.tv_download_state);
                            if (textView2 != null) {
                                textView2.setText(R.string.download_video_failed);
                            }
                        } else if (num != null && num.intValue() == 4) {
                            com.tplink.iot.e.a.a.d(SummaryClipListActivity.this, "Summary has already been downloaded.", false, 4, null);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SummaryClipListActivity.kt */
    /* loaded from: classes2.dex */
    public static final class p<T> implements s<l1> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SummaryClipVideo f6295b;

        p(SummaryClipVideo summaryClipVideo) {
            this.f6295b = summaryClipVideo;
        }

        @Override // io.reactivex.s
        public final void subscribe(io.reactivex.r<l1> it) {
            kotlin.jvm.internal.j.e(it, "it");
            Thread currentThread = Thread.currentThread();
            SummaryClipListActivity.this.p3 = currentThread;
            String e2 = com.tplink.iot.h.j.a.e(b.d.w.h.a.a(this.f6295b.getM3u8()), this.f6295b.getUri());
            StringBuilder sb = new StringBuilder();
            sb.append(b.d.q.b.p.b.h());
            String str = File.separator;
            sb.append(str);
            sb.append("cloudvideo");
            sb.append(str);
            sb.append("playing.m3u8");
            String sb2 = sb.toString();
            com.tplink.iot.h.j.a.f(sb2, e2);
            Uri parse = Uri.parse("file://" + sb2);
            if (kotlin.jvm.internal.j.a(currentThread, SummaryClipListActivity.this.p3)) {
                l1 a = new l1.c().u(parse).q("application/x-mpegURL").a();
                kotlin.jvm.internal.j.d(a, "MediaItem.Builder().setU…APPLICATION_M3U8).build()");
                it.onNext(a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SummaryClipListActivity.kt */
    /* loaded from: classes2.dex */
    public static final class q<T> implements io.reactivex.g0.g<l1> {
        q() {
        }

        /* renamed from: a */
        public final void accept(l1 l1Var) {
            h2 h2Var = SummaryClipListActivity.this.p1;
            if (h2Var != null) {
                h2Var.D(l1Var);
                h2Var.prepare();
                h2Var.B(0, 0L);
                h2Var.p(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SummaryClipListActivity.kt */
    /* loaded from: classes2.dex */
    public static final class r<T> implements io.reactivex.g0.g<Throwable> {

        /* renamed from: c  reason: collision with root package name */
        public static final r f6297c = new r();

        r() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            b.d.w.c.a.c("tylerTest", "setVideo failed!");
        }
    }

    private final void A1() {
        SummaryClipListViewModel summaryClipListViewModel = this.z;
        if (summaryClipListViewModel == null) {
            kotlin.jvm.internal.j.t("mViewModel");
        }
        summaryClipListViewModel.r().observe(this, new m());
        summaryClipListViewModel.s().observe(this, new n());
        summaryClipListViewModel.v().observe(this, new o());
    }

    private final void C1(Configuration configuration) {
        boolean z = configuration.orientation == 2;
        this.H3 = z;
        if (z) {
            Window window = getWindow();
            View decorView = window.getDecorView();
            kotlin.jvm.internal.j.d(decorView, "decorView");
            decorView.setSystemUiVisibility(4102);
            window.setFlags(1024, 1024);
            WindowManager windowManager = getWindowManager();
            kotlin.jvm.internal.j.d(windowManager, "windowManager");
            windowManager.getDefaultDisplay().getRealMetrics(new DisplayMetrics());
            View view = this.S3;
            if (view != null) {
                view.setVisibility(0);
            }
            View view2 = this.O3;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            ImageView imageView = this.Q3;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            View view3 = this.M3;
            if (view3 != null) {
                view3.setVisibility(0);
            }
            ImageView imageView2 = this.Q3;
            if (imageView2 != null) {
                Resources resources = getResources();
                SummaryClipListViewModel summaryClipListViewModel = this.z;
                if (summaryClipListViewModel == null) {
                    kotlin.jvm.internal.j.t("mViewModel");
                }
                imageView2.setImageDrawable(resources.getDrawable(kotlin.jvm.internal.j.a(summaryClipListViewModel.u().getValue(), Boolean.TRUE) ? R.drawable.tool_sound : R.drawable.tool_sound_off));
                return;
            }
            return;
        }
        Window window2 = getWindow();
        View decorView2 = window2.getDecorView();
        kotlin.jvm.internal.j.d(decorView2, "decorView");
        decorView2.setSystemUiVisibility(256);
        window2.getAttributes().flags &= -1025;
        window2.clearFlags(512);
        WindowManager windowManager2 = getWindowManager();
        kotlin.jvm.internal.j.d(windowManager2, "windowManager");
        windowManager2.getDefaultDisplay().getRealMetrics(new DisplayMetrics());
        View view4 = this.S3;
        if (view4 != null) {
            view4.setVisibility(8);
        }
        View view5 = this.O3;
        if (view5 != null) {
            view5.setVisibility(8);
        }
        ImageView imageView3 = this.Q3;
        if (imageView3 != null) {
            imageView3.setVisibility(8);
        }
        View view6 = this.M3;
        if (view6 != null) {
            view6.setVisibility(8);
        }
        ImageView imageView4 = this.P3;
        if (imageView4 != null) {
            Resources resources2 = getResources();
            SummaryClipListViewModel summaryClipListViewModel2 = this.z;
            if (summaryClipListViewModel2 == null) {
                kotlin.jvm.internal.j.t("mViewModel");
            }
            imageView4.setImageDrawable(resources2.getDrawable(kotlin.jvm.internal.j.a(summaryClipListViewModel2.u().getValue(), Boolean.TRUE) ? R.drawable.summary_player_tool_sound : R.drawable.summary_player_tool_mute));
        }
    }

    public static final /* synthetic */ View i1(SummaryClipListActivity summaryClipListActivity) {
        View view = summaryClipListActivity.W3;
        if (view == null) {
            kotlin.jvm.internal.j.t("mDownloadDialogView");
        }
        return view;
    }

    public static final /* synthetic */ CirclePercentBar k1(SummaryClipListActivity summaryClipListActivity) {
        CirclePercentBar circlePercentBar = summaryClipListActivity.V3;
        if (circlePercentBar == null) {
            kotlin.jvm.internal.j.t("mPbProcessBar");
        }
        return circlePercentBar;
    }

    public static final /* synthetic */ SummaryClipListViewModel n1(SummaryClipListActivity summaryClipListActivity) {
        SummaryClipListViewModel summaryClipListViewModel = summaryClipListActivity.z;
        if (summaryClipListViewModel == null) {
            kotlin.jvm.internal.j.t("mViewModel");
        }
        return summaryClipListViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q1() {
        Bitmap bitmap;
        SummaryClipListViewModel summaryClipListViewModel = this.z;
        if (summaryClipListViewModel == null) {
            kotlin.jvm.internal.j.t("mViewModel");
        }
        if (kotlin.jvm.internal.j.a(summaryClipListViewModel.t().getValue(), Boolean.TRUE)) {
            PlayerView playerView = this.U3;
            if (playerView == null) {
                kotlin.jvm.internal.j.t("mPlayerView");
            }
            View videoSurfaceView = playerView.getVideoSurfaceView();
            if (videoSurfaceView != null && (bitmap = ((TextureView) videoSurfaceView).getBitmap()) != null) {
                SummaryClipListViewModel summaryClipListViewModel2 = this.z;
                if (summaryClipListViewModel2 == null) {
                    kotlin.jvm.internal.j.t("mViewModel");
                }
                kotlin.jvm.internal.j.d(bitmap, "bitmap");
                summaryClipListViewModel2.m(bitmap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r1(boolean z) {
        setRequestedOrientation(!z ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s1() {
        h2 h2Var = this.p1;
        if (h2Var == null) {
            return;
        }
        if (h2Var.c1() == 0.0f) {
            h2Var.t1(1.0f);
            SummaryClipListViewModel summaryClipListViewModel = this.z;
            if (summaryClipListViewModel == null) {
                kotlin.jvm.internal.j.t("mViewModel");
            }
            summaryClipListViewModel.o(true);
            ImageView imageView = this.Q3;
            if (imageView != null) {
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.tool_sound));
                return;
            }
            return;
        }
        h2Var.t1(0.0f);
        SummaryClipListViewModel summaryClipListViewModel2 = this.z;
        if (summaryClipListViewModel2 == null) {
            kotlin.jvm.internal.j.t("mViewModel");
        }
        summaryClipListViewModel2.o(false);
        ImageView imageView2 = this.Q3;
        if (imageView2 != null) {
            imageView2.setImageDrawable(getResources().getDrawable(R.drawable.tool_sound_off));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t1() {
        SummaryClipListViewModel summaryClipListViewModel = this.z;
        if (summaryClipListViewModel == null) {
            kotlin.jvm.internal.j.t("mViewModel");
        }
        summaryClipListViewModel.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u1() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.download_process, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_download_state);
        if (textView != null) {
            textView.setText(R.string.downloading);
        }
        kotlin.p pVar = kotlin.p.a;
        kotlin.jvm.internal.j.d(inflate, "LayoutInflater.from(this…ownloading)\n            }");
        this.W3 = inflate;
        if (inflate == null) {
            kotlin.jvm.internal.j.t("mDownloadDialogView");
        }
        View findViewById = inflate.findViewById(R.id.pb_process);
        CirclePercentBar circlePercentBar = (CirclePercentBar) findViewById;
        circlePercentBar.setListener(new b());
        kotlin.jvm.internal.j.d(findViewById, "mDownloadDialogView.find… { download() }\n        }");
        this.V3 = circlePercentBar;
        TPMaterialDialogV3.Builder builder = new TPMaterialDialogV3.Builder(this);
        View view = this.W3;
        if (view == null) {
            kotlin.jvm.internal.j.t("mDownloadDialogView");
        }
        TPMaterialDialogV3 a2 = builder.setView(view).setCancelable(false).c(false).create();
        View view2 = this.W3;
        if (view2 == null) {
            kotlin.jvm.internal.j.t("mDownloadDialogView");
        }
        ((Button) view2.findViewById(R.id.btn_negative)).setOnClickListener(new c(a2, this));
        if (!a2.isShowing()) {
            a2.show();
        }
        this.X3 = a2;
    }

    private final void v1() {
        com.tplink.iot.Utils.hls.d dVar = new com.tplink.iot.Utils.hls.d(this);
        dVar.i(2);
        h2 z = new h2.b(this, dVar).z();
        z.N(new d());
        kotlin.p pVar = kotlin.p.a;
        this.p1 = z;
        PlayerView playerView = this.U3;
        if (playerView == null) {
            kotlin.jvm.internal.j.t("mPlayerView");
        }
        playerView.setPlayer(this.p1);
    }

    private final void w1(int i2) {
        RecyclerView recyclerView;
        Window window = getWindow();
        kotlin.jvm.internal.j.d(window, "window");
        View decorView = window.getDecorView();
        kotlin.jvm.internal.j.d(decorView, "window.decorView");
        decorView.setSystemUiVisibility(0);
        com.tplink.iot.view.quicksetup.base.d.b0(this, R.color.common_iot_dark_black);
        ActivitySummaryClipListBinding activitySummaryClipListBinding = (ActivitySummaryClipListBinding) DataBindingUtil.setContentView(this, R.layout.activity_summary_clip_list);
        activitySummaryClipListBinding.setLifecycleOwner(this);
        SummaryClipListViewModel summaryClipListViewModel = this.z;
        if (summaryClipListViewModel == null) {
            kotlin.jvm.internal.j.t("mViewModel");
        }
        activitySummaryClipListBinding.h(summaryClipListViewModel);
        this.p0 = activitySummaryClipListBinding.p1;
        this.J3 = activitySummaryClipListBinding.f6705c;
        this.L3 = activitySummaryClipListBinding.f6706d;
        this.N3 = activitySummaryClipListBinding.q;
        this.P3 = activitySummaryClipListBinding.f6707f;
        PlayerView playerViewSummaryClip = activitySummaryClipListBinding.p0;
        kotlin.jvm.internal.j.d(playerViewSummaryClip, "playerViewSummaryClip");
        this.U3 = playerViewSummaryClip;
        this.K3 = findViewById(R.id.btn_toolbar_back_land);
        this.S3 = findViewById(R.id.layout_summary_clip_player_top_toolbar_land);
        this.T3 = findViewById(R.id.layout_summary_clip_player_bottom_toolbar_land);
        this.O3 = findViewById(R.id.iv_summary_clip_download_land);
        this.Q3 = (ImageView) findViewById(R.id.iv_sound_land);
        this.R3 = (ImageView) findViewById(R.id.iv_full_screen);
        if (i2 >= 0) {
            this.I3 = new SummaryClipAdapter(this, i2);
        }
        SummaryClipAdapter summaryClipAdapter = this.I3;
        if (summaryClipAdapter != null && (recyclerView = this.p0) != null) {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
            gridLayoutManager.setOrientation(1);
            kotlin.p pVar = kotlin.p.a;
            recyclerView.setLayoutManager(gridLayoutManager);
            recyclerView.setAdapter(summaryClipAdapter);
        }
    }

    static /* synthetic */ void x1(SummaryClipListActivity summaryClipListActivity, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = -1;
        }
        summaryClipListActivity.w1(i2);
    }

    private final void y1(int i2) {
        SummaryClipAdapter summaryClipAdapter;
        List<SummaryClip> h2 = com.tplink.iot.e.a.c.k.h();
        if (h2 != null && h2.size() >= i2 + 1) {
            SummaryClipVideo summaryClipVideo = h2.get(i2).getVideo().get(0);
            if (summaryClipVideo != null && !TextUtils.isEmpty(summaryClipVideo.getUri()) && !TextUtils.isEmpty(summaryClipVideo.getM3u8())) {
                B1(summaryClipVideo);
            }
            RecyclerView recyclerView = this.p0;
            if (recyclerView != null && (summaryClipAdapter = this.I3) != null) {
                recyclerView.scrollToPosition(summaryClipAdapter.r());
            }
        }
    }

    private final void z1() {
        View view = this.J3;
        if (view != null) {
            view.setOnClickListener(new e());
        }
        View view2 = this.L3;
        if (view2 != null) {
            view2.setOnClickListener(new f());
        }
        View view3 = this.N3;
        if (view3 != null) {
            view3.setOnClickListener(new g());
        }
        View view4 = this.O3;
        if (view4 != null) {
            view4.setOnClickListener(new h());
        }
        ImageView imageView = this.P3;
        if (imageView != null) {
            imageView.setOnClickListener(new i());
        }
        ImageView imageView2 = this.Q3;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new j());
        }
        ImageView imageView3 = this.R3;
        if (imageView3 != null) {
            imageView3.setOnClickListener(new k());
        }
        View view5 = this.K3;
        if (view5 != null) {
            view5.setOnClickListener(new l());
        }
    }

    public final void B1(SummaryClipVideo video) {
        kotlin.jvm.internal.j.e(video, "video");
        SummaryClipListViewModel summaryClipListViewModel = this.z;
        if (summaryClipListViewModel == null) {
            kotlin.jvm.internal.j.t("mViewModel");
        }
        summaryClipListViewModel.x(video);
        io.reactivex.e0.c cVar = this.p2;
        if (cVar != null) {
            cVar.dispose();
        }
        this.p2 = io.reactivex.q.m(new p(video)).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).H0(new q(), r.f6297c);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        kotlin.jvm.internal.j.e(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        x1(this, 0, 1, null);
        C1(newConfig);
        z1();
        PlayerView playerView = this.U3;
        if (playerView == null) {
            kotlin.jvm.internal.j.t("mPlayerView");
        }
        playerView.setPlayer(this.p1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int intExtra = getIntent().getIntExtra("clip_index", 0);
        ViewModel viewModel = new ViewModelProvider(this).get(SummaryClipListViewModel.class);
        kotlin.jvm.internal.j.d(viewModel, "ViewModelProvider(this).…istViewModel::class.java)");
        SummaryClipListViewModel summaryClipListViewModel = (SummaryClipListViewModel) viewModel;
        summaryClipListViewModel.w();
        kotlin.p pVar = kotlin.p.a;
        this.z = summaryClipListViewModel;
        w1(intExtra);
        z1();
        v1();
        A1();
        y1(intExtra);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        io.reactivex.e0.c cVar = this.p2;
        if (cVar != null) {
            cVar.dispose();
        }
        h2 h2Var = this.p1;
        if (h2Var != null) {
            h2Var.release();
        }
        super.onDestroy();
    }
}
