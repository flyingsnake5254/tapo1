package com.google.android.exoplayer2.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.j2;
import com.google.android.exoplayer2.l1;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.n2.b;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.t1;
import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.trackselection.j;
import com.google.android.exoplayer2.trackselection.k;
import com.google.android.exoplayer2.u1;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.ui.StyledPlayerControlView;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.n;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.y;
import com.google.android.exoplayer2.v1;
import com.google.android.exoplayer2.video.v;
import com.google.android.exoplayer2.video.z;
import com.google.android.exoplayer2.w1;
import com.google.android.exoplayer2.x0;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import org.eclipse.paho.client.mqttv3.DisconnectedBufferOptions;

/* loaded from: classes.dex */
public class StyledPlayerView extends FrameLayout implements e0 {
    @Nullable
    private final FrameLayout H3;
    @Nullable
    private u1 I3;
    private boolean J3;
    @Nullable
    private StyledPlayerControlView.m K3;
    private boolean L3;
    @Nullable
    private Drawable M3;
    private int N3;
    private boolean O3;
    @Nullable
    private n<? super PlaybackException> P3;
    @Nullable
    private CharSequence Q3;
    private int R3;
    private boolean S3;
    private boolean T3;
    private boolean U3;
    private int V3;
    private boolean W3;

    /* renamed from: c  reason: collision with root package name */
    private final a f3711c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final AspectRatioFrameLayout f3712d;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final View f3713f;
    @Nullable
    private final View p0;
    @Nullable
    private final TextView p1;
    @Nullable
    private final StyledPlayerControlView p2;
    @Nullable
    private final FrameLayout p3;
    @Nullable
    private final View q;
    private final boolean x;
    @Nullable
    private final ImageView y;
    @Nullable
    private final SubtitleView z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class a implements u1.e, View.OnLayoutChangeListener, View.OnClickListener, StyledPlayerControlView.m {

        /* renamed from: c  reason: collision with root package name */
        private final j2.b f3714c = new j2.b();
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private Object f3715d;

        public a() {
        }

        @Override // com.google.android.exoplayer2.text.k
        public void B(List<c> list) {
            if (StyledPlayerView.this.z != null) {
                StyledPlayerView.this.z.B(list);
            }
        }

        @Override // com.google.android.exoplayer2.u1.c
        public void G(TrackGroupArray trackGroupArray, k kVar) {
            u1 u1Var = (u1) g.e(StyledPlayerView.this.I3);
            j2 w = u1Var.w();
            if (w.q()) {
                this.f3715d = null;
            } else if (!u1Var.u().c()) {
                this.f3715d = w.g(u1Var.H(), this.f3714c, true).f2329c;
            } else {
                Object obj = this.f3715d;
                if (obj != null) {
                    int b2 = w.b(obj);
                    if (b2 != -1) {
                        if (u1Var.m() == w.f(b2, this.f3714c).f2330d) {
                            return;
                        }
                    }
                    this.f3715d = null;
                }
            }
            StyledPlayerView.this.L(false);
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
        public /* synthetic */ void P(PlaybackException playbackException) {
            w1.o(this, playbackException);
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

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.m
        public void b(int i) {
            StyledPlayerView.this.I();
        }

        @Override // com.google.android.exoplayer2.video.w, com.google.android.exoplayer2.video.y
        public void c(z zVar) {
            StyledPlayerView.this.G();
        }

        @Override // com.google.android.exoplayer2.u1.c
        public /* synthetic */ void d(t1 t1Var) {
            w1.l(this, t1Var);
        }

        @Override // com.google.android.exoplayer2.u1.c
        public void d0(boolean z, int i) {
            StyledPlayerView.this.H();
            StyledPlayerView.this.J();
        }

        @Override // com.google.android.exoplayer2.u1.c
        public void e(u1.f fVar, u1.f fVar2, int i) {
            if (StyledPlayerView.this.w() && StyledPlayerView.this.T3) {
                StyledPlayerView.this.u();
            }
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
        public /* synthetic */ void k0(b bVar) {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            StyledPlayerView.this.F();
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            StyledPlayerView.o((TextureView) view, StyledPlayerView.this.V3);
        }

        @Override // com.google.android.exoplayer2.u1.c
        public /* synthetic */ void onRepeatModeChanged(int i) {
            w1.s(this, i);
        }

        @Override // com.google.android.exoplayer2.u1.c
        public void q(int i) {
            StyledPlayerView.this.H();
            StyledPlayerView.this.K();
            StyledPlayerView.this.J();
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
        public void z() {
            if (StyledPlayerView.this.f3713f != null) {
                StyledPlayerView.this.f3713f.setVisibility(4);
            }
        }
    }

    public StyledPlayerView(Context context) {
        this(context, null);
    }

    @RequiresNonNull({"artworkView"})
    private boolean A(@Nullable Drawable drawable) {
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                y(this.f3712d, intrinsicWidth / intrinsicHeight);
                this.y.setImageDrawable(drawable);
                this.y.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    private static void B(AspectRatioFrameLayout aspectRatioFrameLayout, int i) {
        aspectRatioFrameLayout.setResizeMode(i);
    }

    private boolean C() {
        u1 u1Var = this.I3;
        if (u1Var == null) {
            return true;
        }
        int playbackState = u1Var.getPlaybackState();
        return this.S3 && !this.I3.w().q() && (playbackState == 1 || playbackState == 4 || !((u1) g.e(this.I3)).E());
    }

    private void E(boolean z) {
        if (N()) {
            this.p2.setShowTimeoutMs(z ? 0 : this.R3);
            this.p2.t0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean F() {
        if (N() && this.I3 != null) {
            if (!this.p2.e0()) {
                x(true);
                return true;
            } else if (this.U3) {
                this.p2.a0();
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        u1 u1Var = this.I3;
        z J = u1Var != null ? u1Var.J() : z.a;
        int i = J.f4077c;
        int i2 = J.f4078d;
        int i3 = J.f4079e;
        float f2 = 0.0f;
        f2 = (i2 == 0 || i == 0) ? 0.0f : (i * J.f4080f) / i2;
        View view = this.q;
        if (view instanceof TextureView) {
            if (f2 > 0.0f && (i3 == 90 || i3 == 270)) {
                f2 = 1.0f / f2;
            }
            if (this.V3 != 0) {
                view.removeOnLayoutChangeListener(this.f3711c);
            }
            this.V3 = i3;
            if (i3 != 0) {
                this.q.addOnLayoutChangeListener(this.f3711c);
            }
            o((TextureView) this.q, this.V3);
        }
        AspectRatioFrameLayout aspectRatioFrameLayout = this.f3712d;
        if (!this.x) {
        }
        y(aspectRatioFrameLayout, f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        int i;
        if (this.p0 != null) {
            u1 u1Var = this.I3;
            boolean z = true;
            int i2 = 0;
            if (u1Var == null || u1Var.getPlaybackState() != 2 || ((i = this.N3) != 2 && (i != 1 || !this.I3.E()))) {
                z = false;
            }
            View view = this.p0;
            if (!z) {
                i2 = 8;
            }
            view.setVisibility(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        StyledPlayerControlView styledPlayerControlView = this.p2;
        String str = null;
        if (styledPlayerControlView == null || !this.J3) {
            setContentDescription(null);
        } else if (styledPlayerControlView.e0()) {
            if (this.U3) {
                str = getResources().getString(r0.exo_controls_hide);
            }
            setContentDescription(str);
        } else {
            setContentDescription(getResources().getString(r0.exo_controls_show));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        if (!w() || !this.T3) {
            x(false);
        } else {
            u();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        n<? super PlaybackException> nVar;
        TextView textView = this.p1;
        if (textView != null) {
            CharSequence charSequence = this.Q3;
            if (charSequence != null) {
                textView.setText(charSequence);
                this.p1.setVisibility(0);
                return;
            }
            u1 u1Var = this.I3;
            PlaybackException o = u1Var != null ? u1Var.o() : null;
            if (o == null || (nVar = this.P3) == null) {
                this.p1.setVisibility(8);
                return;
            }
            this.p1.setText((CharSequence) nVar.a(o).second);
            this.p1.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(boolean z) {
        u1 u1Var = this.I3;
        if (u1Var != null && !u1Var.u().c()) {
            if (z && !this.O3) {
                p();
            }
            k A = u1Var.A();
            for (int i = 0; i < A.a; i++) {
                j a2 = A.a(i);
                if (a2 != null) {
                    for (int i2 = 0; i2 < a2.length(); i2++) {
                        if (y.k(a2.a(i2).H3) == 2) {
                            t();
                            return;
                        }
                    }
                    continue;
                }
            }
            p();
            if (!M() || (!z(u1Var.U()) && !A(this.M3))) {
                t();
            }
        } else if (!this.O3) {
            t();
            p();
        }
    }

    @EnsuresNonNullIf(expression = {"artworkView"}, result = true)
    private boolean M() {
        if (!this.L3) {
            return false;
        }
        g.i(this.y);
        return true;
    }

    @EnsuresNonNullIf(expression = {"controller"}, result = true)
    private boolean N() {
        if (!this.J3) {
            return false;
        }
        g.i(this.p2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void o(TextureView textureView, int i) {
        Matrix matrix = new Matrix();
        float width = textureView.getWidth();
        float height = textureView.getHeight();
        if (!(width == 0.0f || height == 0.0f || i == 0)) {
            float f2 = width / 2.0f;
            float f3 = height / 2.0f;
            matrix.postRotate(i, f2, f3);
            RectF rectF = new RectF(0.0f, 0.0f, width, height);
            RectF rectF2 = new RectF();
            matrix.mapRect(rectF2, rectF);
            matrix.postScale(width / rectF2.width(), height / rectF2.height(), f2, f3);
        }
        textureView.setTransform(matrix);
    }

    private void p() {
        View view = this.f3713f;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    private static void q(Resources resources, ImageView imageView) {
        imageView.setImageDrawable(resources.getDrawable(l0.exo_edit_mode_logo));
        imageView.setBackgroundColor(resources.getColor(j0.exo_edit_mode_background_color));
    }

    @RequiresApi(23)
    private static void r(Resources resources, ImageView imageView) {
        imageView.setImageDrawable(resources.getDrawable(l0.exo_edit_mode_logo, null));
        imageView.setBackgroundColor(resources.getColor(j0.exo_edit_mode_background_color, null));
    }

    private void t() {
        ImageView imageView = this.y;
        if (imageView != null) {
            imageView.setImageResource(17170445);
            this.y.setVisibility(4);
        }
    }

    @SuppressLint({"InlinedApi"})
    private boolean v(int i) {
        return i == 19 || i == 270 || i == 22 || i == 271 || i == 20 || i == 269 || i == 21 || i == 268 || i == 23;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean w() {
        u1 u1Var = this.I3;
        return u1Var != null && u1Var.f() && this.I3.E();
    }

    private void x(boolean z) {
        if ((!w() || !this.T3) && N()) {
            boolean z2 = this.p2.e0() && this.p2.getShowTimeoutMs() <= 0;
            boolean C = C();
            if (z || z2 || C) {
                E(C);
            }
        }
    }

    @RequiresNonNull({"artworkView"})
    private boolean z(m1 m1Var) {
        byte[] bArr = m1Var.m;
        if (bArr == null) {
            return false;
        }
        return A(new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length)));
    }

    public void D() {
        E(C());
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        u1 u1Var = this.I3;
        if (u1Var != null && u1Var.f()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        boolean v = v(keyEvent.getKeyCode());
        if (v && N() && !this.p2.e0()) {
            x(true);
        } else if (s(keyEvent) || super.dispatchKeyEvent(keyEvent)) {
            x(true);
        } else if (!v || !N()) {
            return false;
        } else {
            x(true);
            return false;
        }
        return true;
    }

    public List<d0> getAdOverlayInfos() {
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout = this.H3;
        if (frameLayout != null) {
            arrayList.add(new d0(frameLayout, 3, "Transparent overlay does not impact viewability"));
        }
        StyledPlayerControlView styledPlayerControlView = this.p2;
        if (styledPlayerControlView != null) {
            arrayList.add(new d0(styledPlayerControlView, 0));
        }
        return ImmutableList.copyOf((Collection) arrayList);
    }

    public ViewGroup getAdViewGroup() {
        return (ViewGroup) g.j(this.p3, "exo_ad_overlay must be present for ad playback");
    }

    public boolean getControllerAutoShow() {
        return this.S3;
    }

    public boolean getControllerHideOnTouch() {
        return this.U3;
    }

    public int getControllerShowTimeoutMs() {
        return this.R3;
    }

    @Nullable
    public Drawable getDefaultArtwork() {
        return this.M3;
    }

    @Nullable
    public FrameLayout getOverlayFrameLayout() {
        return this.H3;
    }

    @Nullable
    public u1 getPlayer() {
        return this.I3;
    }

    public int getResizeMode() {
        g.i(this.f3712d);
        return this.f3712d.getResizeMode();
    }

    @Nullable
    public SubtitleView getSubtitleView() {
        return this.z;
    }

    public boolean getUseArtwork() {
        return this.L3;
    }

    public boolean getUseController() {
        return this.J3;
    }

    @Nullable
    public View getVideoSurfaceView() {
        return this.q;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!N() || this.I3 == null) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.W3 = true;
            return true;
        } else if (action != 1 || !this.W3) {
            return false;
        } else {
            this.W3 = false;
            return performClick();
        }
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!N() || this.I3 == null) {
            return false;
        }
        x(true);
        return true;
    }

    @Override // android.view.View
    public boolean performClick() {
        super.performClick();
        return F();
    }

    public boolean s(KeyEvent keyEvent) {
        return N() && this.p2.T(keyEvent);
    }

    public void setAspectRatioListener(@Nullable AspectRatioFrameLayout.b bVar) {
        g.i(this.f3712d);
        this.f3712d.setAspectRatioListener(bVar);
    }

    @Deprecated
    public void setControlDispatcher(x0 x0Var) {
        g.i(this.p2);
        this.p2.setControlDispatcher(x0Var);
    }

    public void setControllerAutoShow(boolean z) {
        this.S3 = z;
    }

    public void setControllerHideDuringAds(boolean z) {
        this.T3 = z;
    }

    public void setControllerHideOnTouch(boolean z) {
        g.i(this.p2);
        this.U3 = z;
        I();
    }

    public void setControllerOnFullScreenModeChangedListener(@Nullable StyledPlayerControlView.d dVar) {
        g.i(this.p2);
        this.p2.setOnFullScreenModeChangedListener(dVar);
    }

    public void setControllerShowTimeoutMs(int i) {
        g.i(this.p2);
        this.R3 = i;
        if (this.p2.e0()) {
            D();
        }
    }

    public void setControllerVisibilityListener(@Nullable StyledPlayerControlView.m mVar) {
        g.i(this.p2);
        StyledPlayerControlView.m mVar2 = this.K3;
        if (mVar2 != mVar) {
            if (mVar2 != null) {
                this.p2.o0(mVar2);
            }
            this.K3 = mVar;
            if (mVar != null) {
                this.p2.R(mVar);
            }
        }
    }

    public void setCustomErrorMessage(@Nullable CharSequence charSequence) {
        g.g(this.p1 != null);
        this.Q3 = charSequence;
        K();
    }

    public void setDefaultArtwork(@Nullable Drawable drawable) {
        if (this.M3 != drawable) {
            this.M3 = drawable;
            L(false);
        }
    }

    public void setErrorMessageProvider(@Nullable n<? super PlaybackException> nVar) {
        if (this.P3 != nVar) {
            this.P3 = nVar;
            K();
        }
    }

    public void setKeepContentOnPlayerReset(boolean z) {
        if (this.O3 != z) {
            this.O3 = z;
            L(false);
        }
    }

    public void setPlayer(@Nullable u1 u1Var) {
        g.g(Looper.myLooper() == Looper.getMainLooper());
        g.a(u1Var == null || u1Var.x() == Looper.getMainLooper());
        u1 u1Var2 = this.I3;
        if (u1Var2 != u1Var) {
            if (u1Var2 != null) {
                u1Var2.i(this.f3711c);
                View view = this.q;
                if (view instanceof TextureView) {
                    u1Var2.I((TextureView) view);
                } else if (view instanceof SurfaceView) {
                    u1Var2.P((SurfaceView) view);
                }
            }
            SubtitleView subtitleView = this.z;
            if (subtitleView != null) {
                subtitleView.setCues(null);
            }
            this.I3 = u1Var;
            if (N()) {
                this.p2.setPlayer(u1Var);
            }
            H();
            K();
            L(true);
            if (u1Var != null) {
                if (u1Var.s(26)) {
                    View view2 = this.q;
                    if (view2 instanceof TextureView) {
                        u1Var.z((TextureView) view2);
                    } else if (view2 instanceof SurfaceView) {
                        u1Var.k((SurfaceView) view2);
                    }
                    G();
                }
                if (this.z != null && u1Var.s(27)) {
                    this.z.setCues(u1Var.q());
                }
                u1Var.N(this.f3711c);
                x(false);
                return;
            }
            u();
        }
    }

    public void setRepeatToggleModes(int i) {
        g.i(this.p2);
        this.p2.setRepeatToggleModes(i);
    }

    public void setResizeMode(int i) {
        g.i(this.f3712d);
        this.f3712d.setResizeMode(i);
    }

    public void setShowBuffering(int i) {
        if (this.N3 != i) {
            this.N3 = i;
            H();
        }
    }

    public void setShowFastForwardButton(boolean z) {
        g.i(this.p2);
        this.p2.setShowFastForwardButton(z);
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        g.i(this.p2);
        this.p2.setShowMultiWindowTimeBar(z);
    }

    public void setShowNextButton(boolean z) {
        g.i(this.p2);
        this.p2.setShowNextButton(z);
    }

    public void setShowPreviousButton(boolean z) {
        g.i(this.p2);
        this.p2.setShowPreviousButton(z);
    }

    public void setShowRewindButton(boolean z) {
        g.i(this.p2);
        this.p2.setShowRewindButton(z);
    }

    public void setShowShuffleButton(boolean z) {
        g.i(this.p2);
        this.p2.setShowShuffleButton(z);
    }

    public void setShowSubtitleButton(boolean z) {
        g.i(this.p2);
        this.p2.setShowSubtitleButton(z);
    }

    public void setShowVrButton(boolean z) {
        g.i(this.p2);
        this.p2.setShowVrButton(z);
    }

    public void setShutterBackgroundColor(int i) {
        View view = this.f3713f;
        if (view != null) {
            view.setBackgroundColor(i);
        }
    }

    public void setUseArtwork(boolean z) {
        g.g(!z || this.y != null);
        if (this.L3 != z) {
            this.L3 = z;
            L(false);
        }
    }

    public void setUseController(boolean z) {
        g.g(!z || this.p2 != null);
        if (this.J3 != z) {
            this.J3 = z;
            if (N()) {
                this.p2.setPlayer(this.I3);
            } else {
                StyledPlayerControlView styledPlayerControlView = this.p2;
                if (styledPlayerControlView != null) {
                    styledPlayerControlView.a0();
                    this.p2.setPlayer(null);
                }
            }
            I();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        View view = this.q;
        if (view instanceof SurfaceView) {
            view.setVisibility(i);
        }
    }

    public void u() {
        StyledPlayerControlView styledPlayerControlView = this.p2;
        if (styledPlayerControlView != null) {
            styledPlayerControlView.a0();
        }
    }

    protected void y(@Nullable AspectRatioFrameLayout aspectRatioFrameLayout, float f2) {
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setAspectRatio(f2);
        }
    }

    public StyledPlayerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Finally extract failed */
    public StyledPlayerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        boolean z;
        int i2;
        boolean z2;
        boolean z3;
        int i3;
        int i4;
        boolean z4;
        int i5;
        boolean z5;
        int i6;
        boolean z6;
        boolean z7;
        int i7;
        a aVar = new a();
        this.f3711c = aVar;
        if (isInEditMode()) {
            this.f3712d = null;
            this.f3713f = null;
            this.q = null;
            this.x = false;
            this.y = null;
            this.z = null;
            this.p0 = null;
            this.p1 = null;
            this.p2 = null;
            this.p3 = null;
            this.H3 = null;
            ImageView imageView = new ImageView(context);
            if (o0.a >= 23) {
                r(getResources(), imageView);
            } else {
                q(getResources(), imageView);
            }
            addView(imageView);
            return;
        }
        int i8 = p0.exo_styled_player_view;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, t0.StyledPlayerView, 0, 0);
            try {
                int i9 = t0.StyledPlayerView_shutter_background_color;
                z3 = obtainStyledAttributes.hasValue(i9);
                int color = obtainStyledAttributes.getColor(i9, 0);
                int resourceId = obtainStyledAttributes.getResourceId(t0.StyledPlayerView_player_layout_id, i8);
                z2 = obtainStyledAttributes.getBoolean(t0.StyledPlayerView_use_artwork, true);
                int resourceId2 = obtainStyledAttributes.getResourceId(t0.StyledPlayerView_default_artwork, 0);
                z = obtainStyledAttributes.getBoolean(t0.StyledPlayerView_use_controller, true);
                i4 = obtainStyledAttributes.getInt(t0.StyledPlayerView_surface_type, 1);
                i6 = obtainStyledAttributes.getInt(t0.StyledPlayerView_resize_mode, 0);
                int i10 = obtainStyledAttributes.getInt(t0.StyledPlayerView_show_timeout, DisconnectedBufferOptions.DISCONNECTED_BUFFER_SIZE_DEFAULT);
                boolean z8 = obtainStyledAttributes.getBoolean(t0.StyledPlayerView_hide_on_touch, true);
                boolean z9 = obtainStyledAttributes.getBoolean(t0.StyledPlayerView_auto_show, true);
                i5 = obtainStyledAttributes.getInteger(t0.StyledPlayerView_show_buffering, 0);
                this.O3 = obtainStyledAttributes.getBoolean(t0.StyledPlayerView_keep_content_on_player_reset, this.O3);
                boolean z10 = obtainStyledAttributes.getBoolean(t0.StyledPlayerView_hide_during_ads, true);
                obtainStyledAttributes.recycle();
                z4 = z8;
                z6 = z9;
                i2 = resourceId2;
                i3 = color;
                z5 = z10;
                i8 = resourceId;
                i7 = i10;
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            z6 = true;
            i6 = 0;
            z5 = true;
            i5 = 0;
            z4 = true;
            i4 = 1;
            i3 = 0;
            z3 = false;
            z2 = true;
            i2 = 0;
            i7 = DisconnectedBufferOptions.DISCONNECTED_BUFFER_SIZE_DEFAULT;
            z = true;
        }
        LayoutInflater.from(context).inflate(i8, this);
        setDescendantFocusability(262144);
        AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) findViewById(n0.exo_content_frame);
        this.f3712d = aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            B(aspectRatioFrameLayout, i6);
        }
        View findViewById = findViewById(n0.exo_shutter);
        this.f3713f = findViewById;
        if (findViewById != null && z3) {
            findViewById.setBackgroundColor(i3);
        }
        if (aspectRatioFrameLayout == null || i4 == 0) {
            this.q = null;
            z7 = false;
        } else {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (i4 == 2) {
                this.q = new TextureView(context);
            } else if (i4 == 3) {
                try {
                    this.q = (View) Class.forName("com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView").getConstructor(Context.class).newInstance(context);
                    z7 = true;
                    this.q.setLayoutParams(layoutParams);
                    this.q.setOnClickListener(aVar);
                    this.q.setClickable(false);
                    aspectRatioFrameLayout.addView(this.q, 0);
                } catch (Exception e2) {
                    throw new IllegalStateException("spherical_gl_surface_view requires an ExoPlayer dependency", e2);
                }
            } else if (i4 != 4) {
                this.q = new SurfaceView(context);
            } else {
                try {
                    this.q = (View) Class.forName("com.google.android.exoplayer2.video.VideoDecoderGLSurfaceView").getConstructor(Context.class).newInstance(context);
                } catch (Exception e3) {
                    throw new IllegalStateException("video_decoder_gl_surface_view requires an ExoPlayer dependency", e3);
                }
            }
            z7 = false;
            this.q.setLayoutParams(layoutParams);
            this.q.setOnClickListener(aVar);
            this.q.setClickable(false);
            aspectRatioFrameLayout.addView(this.q, 0);
        }
        this.x = z7;
        this.p3 = (FrameLayout) findViewById(n0.exo_ad_overlay);
        this.H3 = (FrameLayout) findViewById(n0.exo_overlay);
        ImageView imageView2 = (ImageView) findViewById(n0.exo_artwork);
        this.y = imageView2;
        this.L3 = z2 && imageView2 != null;
        if (i2 != 0) {
            this.M3 = ContextCompat.getDrawable(getContext(), i2);
        }
        SubtitleView subtitleView = (SubtitleView) findViewById(n0.exo_subtitles);
        this.z = subtitleView;
        if (subtitleView != null) {
            subtitleView.d();
            subtitleView.e();
        }
        View findViewById2 = findViewById(n0.exo_buffering);
        this.p0 = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setVisibility(8);
        }
        this.N3 = i5;
        TextView textView = (TextView) findViewById(n0.exo_error_message);
        this.p1 = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        int i11 = n0.exo_controller;
        StyledPlayerControlView styledPlayerControlView = (StyledPlayerControlView) findViewById(i11);
        View findViewById3 = findViewById(n0.exo_controller_placeholder);
        if (styledPlayerControlView != null) {
            this.p2 = styledPlayerControlView;
        } else if (findViewById3 != null) {
            StyledPlayerControlView styledPlayerControlView2 = new StyledPlayerControlView(context, null, 0, attributeSet);
            this.p2 = styledPlayerControlView2;
            styledPlayerControlView2.setId(i11);
            styledPlayerControlView2.setLayoutParams(findViewById3.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById3.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById3);
            viewGroup.removeView(findViewById3);
            viewGroup.addView(styledPlayerControlView2, indexOfChild);
        } else {
            this.p2 = null;
        }
        StyledPlayerControlView styledPlayerControlView3 = this.p2;
        if (styledPlayerControlView3 == null) {
            i7 = 0;
        }
        this.R3 = i7;
        this.U3 = z4;
        this.S3 = z6;
        this.T3 = z5;
        this.J3 = z && styledPlayerControlView3 != null;
        if (styledPlayerControlView3 != null) {
            styledPlayerControlView3.b0();
            this.p2.R(aVar);
        }
        I();
    }
}
