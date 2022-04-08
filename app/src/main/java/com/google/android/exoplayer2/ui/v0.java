package com.google.android.exoplayer2.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StyledPlayerControlViewLayoutManager.java */
/* loaded from: classes.dex */
public final class v0 {
    private boolean A;
    private boolean B;
    private final StyledPlayerControlView a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final View f3770b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final ViewGroup f3771c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final ViewGroup f3772d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final ViewGroup f3773e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final ViewGroup f3774f;
    @Nullable
    private final ViewGroup g;
    @Nullable
    private final ViewGroup h;
    @Nullable
    private final ViewGroup i;
    @Nullable
    private final View j;
    @Nullable
    private final View k;
    private final AnimatorSet l;
    private final AnimatorSet m;
    private final AnimatorSet n;
    private final AnimatorSet o;
    private final AnimatorSet p;
    private final ValueAnimator q;
    private final ValueAnimator r;
    private final Runnable s = new Runnable() { // from class: com.google.android.exoplayer2.ui.z
        @Override // java.lang.Runnable
        public final void run() {
            v0.this.c0();
        }
    };
    private final Runnable t = new Runnable() { // from class: com.google.android.exoplayer2.ui.r
        @Override // java.lang.Runnable
        public final void run() {
            v0.this.q();
        }
    };
    private final Runnable u = new Runnable() { // from class: com.google.android.exoplayer2.ui.v
        @Override // java.lang.Runnable
        public final void run() {
            v0.this.u();
        }
    };
    private final Runnable v = new Runnable() { // from class: com.google.android.exoplayer2.ui.y
        @Override // java.lang.Runnable
        public final void run() {
            v0.this.t();
        }
    };
    private final Runnable w = new Runnable() { // from class: com.google.android.exoplayer2.ui.s
        @Override // java.lang.Runnable
        public final void run() {
            v0.this.r();
        }
    };
    private final View.OnLayoutChangeListener x = new View.OnLayoutChangeListener() { // from class: com.google.android.exoplayer2.ui.t
        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            v0.this.R(view, i2, i3, i4, i5, i6, i7, i8, i9);
        }
    };
    private boolean C = true;
    private int z = 0;
    private final List<View> y = new ArrayList();

    /* compiled from: StyledPlayerControlViewLayoutManager.java */
    /* loaded from: classes.dex */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (v0.this.f3770b != null) {
                v0.this.f3770b.setVisibility(4);
            }
            if (v0.this.f3771c != null) {
                v0.this.f3771c.setVisibility(4);
            }
            if (v0.this.f3773e != null) {
                v0.this.f3773e.setVisibility(4);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if ((v0.this.j instanceof DefaultTimeBar) && !v0.this.A) {
                ((DefaultTimeBar) v0.this.j).f(250L);
            }
        }
    }

    /* compiled from: StyledPlayerControlViewLayoutManager.java */
    /* loaded from: classes.dex */
    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            int i = 0;
            if (v0.this.f3770b != null) {
                v0.this.f3770b.setVisibility(0);
            }
            if (v0.this.f3771c != null) {
                v0.this.f3771c.setVisibility(0);
            }
            if (v0.this.f3773e != null) {
                ViewGroup viewGroup = v0.this.f3773e;
                if (!v0.this.A) {
                    i = 4;
                }
                viewGroup.setVisibility(i);
            }
            if ((v0.this.j instanceof DefaultTimeBar) && !v0.this.A) {
                ((DefaultTimeBar) v0.this.j).u(250L);
            }
        }
    }

    /* compiled from: StyledPlayerControlViewLayoutManager.java */
    /* loaded from: classes.dex */
    class c extends AnimatorListenerAdapter {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ StyledPlayerControlView f3777c;

        c(StyledPlayerControlView styledPlayerControlView) {
            this.f3777c = styledPlayerControlView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            v0.this.Z(1);
            if (v0.this.B) {
                this.f3777c.post(v0.this.s);
                v0.this.B = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            v0.this.Z(3);
        }
    }

    /* compiled from: StyledPlayerControlViewLayoutManager.java */
    /* loaded from: classes.dex */
    class d extends AnimatorListenerAdapter {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ StyledPlayerControlView f3779c;

        d(StyledPlayerControlView styledPlayerControlView) {
            this.f3779c = styledPlayerControlView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            v0.this.Z(2);
            if (v0.this.B) {
                this.f3779c.post(v0.this.s);
                v0.this.B = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            v0.this.Z(3);
        }
    }

    /* compiled from: StyledPlayerControlViewLayoutManager.java */
    /* loaded from: classes.dex */
    class e extends AnimatorListenerAdapter {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ StyledPlayerControlView f3781c;

        e(StyledPlayerControlView styledPlayerControlView) {
            this.f3781c = styledPlayerControlView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            v0.this.Z(2);
            if (v0.this.B) {
                this.f3781c.post(v0.this.s);
                v0.this.B = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            v0.this.Z(3);
        }
    }

    /* compiled from: StyledPlayerControlViewLayoutManager.java */
    /* loaded from: classes.dex */
    class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            v0.this.Z(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            v0.this.Z(4);
        }
    }

    /* compiled from: StyledPlayerControlViewLayoutManager.java */
    /* loaded from: classes.dex */
    class g extends AnimatorListenerAdapter {
        g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            v0.this.Z(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            v0.this.Z(4);
        }
    }

    /* compiled from: StyledPlayerControlViewLayoutManager.java */
    /* loaded from: classes.dex */
    class h extends AnimatorListenerAdapter {
        h() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (v0.this.f3774f != null) {
                v0.this.f3774f.setVisibility(4);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (v0.this.h != null) {
                v0.this.h.setVisibility(0);
                v0.this.h.setTranslationX(v0.this.h.getWidth());
                v0.this.h.scrollTo(v0.this.h.getWidth(), 0);
            }
        }
    }

    /* compiled from: StyledPlayerControlViewLayoutManager.java */
    /* loaded from: classes.dex */
    class i extends AnimatorListenerAdapter {
        i() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (v0.this.h != null) {
                v0.this.h.setVisibility(4);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (v0.this.f3774f != null) {
                v0.this.f3774f.setVisibility(0);
            }
        }
    }

    public v0(StyledPlayerControlView styledPlayerControlView) {
        this.a = styledPlayerControlView;
        this.f3770b = styledPlayerControlView.findViewById(n0.exo_controls_background);
        this.f3771c = (ViewGroup) styledPlayerControlView.findViewById(n0.exo_center_controls);
        this.f3773e = (ViewGroup) styledPlayerControlView.findViewById(n0.exo_minimal_controls);
        ViewGroup viewGroup = (ViewGroup) styledPlayerControlView.findViewById(n0.exo_bottom_bar);
        this.f3772d = viewGroup;
        this.i = (ViewGroup) styledPlayerControlView.findViewById(n0.exo_time);
        View findViewById = styledPlayerControlView.findViewById(n0.exo_progress);
        this.j = findViewById;
        this.f3774f = (ViewGroup) styledPlayerControlView.findViewById(n0.exo_basic_controls);
        this.g = (ViewGroup) styledPlayerControlView.findViewById(n0.exo_extra_controls);
        this.h = (ViewGroup) styledPlayerControlView.findViewById(n0.exo_extra_controls_scroll_view);
        View findViewById2 = styledPlayerControlView.findViewById(n0.exo_overflow_show);
        this.k = findViewById2;
        View findViewById3 = styledPlayerControlView.findViewById(n0.exo_overflow_hide);
        if (!(findViewById2 == null || findViewById3 == null)) {
            findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.x
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v0.this.T(view);
                }
            });
            findViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.x
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v0.this.T(view);
                }
            });
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.exoplayer2.ui.u
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                v0.this.F(valueAnimator);
            }
        });
        ofFloat.addListener(new a());
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.exoplayer2.ui.q
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                v0.this.H(valueAnimator);
            }
        });
        ofFloat2.addListener(new b());
        Resources resources = styledPlayerControlView.getResources();
        int i2 = k0.exo_styled_bottom_bar_height;
        float dimension = resources.getDimension(i2) - resources.getDimension(k0.exo_styled_progress_bar_height);
        float dimension2 = resources.getDimension(i2);
        AnimatorSet animatorSet = new AnimatorSet();
        this.l = animatorSet;
        animatorSet.setDuration(250L);
        animatorSet.addListener(new c(styledPlayerControlView));
        animatorSet.play(ofFloat).with(N(0.0f, dimension, findViewById)).with(N(0.0f, dimension, viewGroup));
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.m = animatorSet2;
        animatorSet2.setDuration(250L);
        animatorSet2.addListener(new d(styledPlayerControlView));
        animatorSet2.play(N(dimension, dimension2, findViewById)).with(N(dimension, dimension2, viewGroup));
        AnimatorSet animatorSet3 = new AnimatorSet();
        this.n = animatorSet3;
        animatorSet3.setDuration(250L);
        animatorSet3.addListener(new e(styledPlayerControlView));
        animatorSet3.play(ofFloat).with(N(0.0f, dimension2, findViewById)).with(N(0.0f, dimension2, viewGroup));
        AnimatorSet animatorSet4 = new AnimatorSet();
        this.o = animatorSet4;
        animatorSet4.setDuration(250L);
        animatorSet4.addListener(new f());
        animatorSet4.play(ofFloat2).with(N(dimension, 0.0f, findViewById)).with(N(dimension, 0.0f, viewGroup));
        AnimatorSet animatorSet5 = new AnimatorSet();
        this.p = animatorSet5;
        animatorSet5.setDuration(250L);
        animatorSet5.addListener(new g());
        animatorSet5.play(ofFloat2).with(N(dimension2, 0.0f, findViewById)).with(N(dimension2, 0.0f, viewGroup));
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.q = ofFloat3;
        ofFloat3.setDuration(250L);
        ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.exoplayer2.ui.w
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                v0.this.J(valueAnimator);
            }
        });
        ofFloat3.addListener(new h());
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.r = ofFloat4;
        ofFloat4.setDuration(250L);
        ofFloat4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.exoplayer2.ui.a0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                v0.this.L(valueAnimator);
            }
        });
        ofFloat4.addListener(new i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E */
    public /* synthetic */ void F(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = this.f3770b;
        if (view != null) {
            view.setAlpha(floatValue);
        }
        ViewGroup viewGroup = this.f3771c;
        if (viewGroup != null) {
            viewGroup.setAlpha(floatValue);
        }
        ViewGroup viewGroup2 = this.f3773e;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(floatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G */
    public /* synthetic */ void H(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = this.f3770b;
        if (view != null) {
            view.setAlpha(floatValue);
        }
        ViewGroup viewGroup = this.f3771c;
        if (viewGroup != null) {
            viewGroup.setAlpha(floatValue);
        }
        ViewGroup viewGroup2 = this.f3773e;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(floatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I */
    public /* synthetic */ void J(ValueAnimator valueAnimator) {
        l(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K */
    public /* synthetic */ void L(ValueAnimator valueAnimator) {
        l(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    private static ObjectAnimator N(float f2, float f3, View view) {
        return ObjectAnimator.ofFloat(view, "translationY", f2, f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        boolean e0 = e0();
        if (this.A != e0) {
            this.A = e0;
            view.post(new Runnable() { // from class: com.google.android.exoplayer2.ui.o
                @Override // java.lang.Runnable
                public final void run() {
                    v0.this.d0();
                }
            });
        }
        boolean z = i4 - i2 != i8 - i6;
        if (!this.A && z) {
            view.post(new Runnable() { // from class: com.google.android.exoplayer2.ui.p
                @Override // java.lang.Runnable
                public final void run() {
                    v0.this.S();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        int i2;
        if (!(this.f3774f == null || this.g == null)) {
            int width = (this.a.getWidth() - this.a.getPaddingLeft()) - this.a.getPaddingRight();
            while (true) {
                if (this.g.getChildCount() <= 1) {
                    break;
                }
                int childCount = this.g.getChildCount() - 2;
                View childAt = this.g.getChildAt(childCount);
                this.g.removeViewAt(childCount);
                this.f3774f.addView(childAt, 0);
            }
            View view = this.k;
            if (view != null) {
                view.setVisibility(8);
            }
            int o = o(this.i);
            int childCount2 = this.f3774f.getChildCount() - 1;
            for (int i3 = 0; i3 < childCount2; i3++) {
                o += o(this.f3774f.getChildAt(i3));
            }
            if (o > width) {
                View view2 = this.k;
                if (view2 != null) {
                    view2.setVisibility(0);
                    o += o(this.k);
                }
                ArrayList arrayList = new ArrayList();
                for (int i4 = 0; i4 < childCount2; i4++) {
                    View childAt2 = this.f3774f.getChildAt(i4);
                    o -= o(childAt2);
                    arrayList.add(childAt2);
                    if (o <= width) {
                        break;
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.f3774f.removeViews(0, arrayList.size());
                    for (i2 = 0; i2 < arrayList.size(); i2++) {
                        this.g.addView((View) arrayList.get(i2), this.g.getChildCount() - 1);
                    }
                    return;
                }
                return;
            }
            ViewGroup viewGroup = this.h;
            if (!(viewGroup == null || viewGroup.getVisibility() != 0 || this.r.isStarted())) {
                this.q.cancel();
                this.r.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(View view) {
        W();
        if (view.getId() == n0.exo_overflow_show) {
            this.q.start();
        } else if (view.getId() == n0.exo_overflow_hide) {
            this.r.start();
        }
    }

    private void U(Runnable runnable, long j) {
        if (j >= 0) {
            this.a.postDelayed(runnable, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(int i2) {
        int i3 = this.z;
        this.z = i2;
        if (i2 == 2) {
            this.a.setVisibility(8);
        } else if (i3 == 2) {
            this.a.setVisibility(0);
        }
        if (i3 != i2) {
            this.a.k0();
        }
    }

    private boolean a0(View view) {
        int id = view.getId();
        return id == n0.exo_bottom_bar || id == n0.exo_prev || id == n0.exo_next || id == n0.exo_rew || id == n0.exo_rew_with_amount || id == n0.exo_ffwd || id == n0.exo_ffwd_with_amount;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0() {
        if (!this.C) {
            Z(0);
            W();
            return;
        }
        int i2 = this.z;
        if (i2 == 1) {
            this.o.start();
        } else if (i2 == 2) {
            this.p.start();
        } else if (i2 == 3) {
            this.B = true;
        } else if (i2 == 4) {
            return;
        }
        W();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0() {
        ViewGroup viewGroup = this.f3773e;
        if (viewGroup != null) {
            viewGroup.setVisibility(this.A ? 0 : 4);
        }
        View view = this.j;
        if (view != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(k0.exo_styled_progress_margin_bottom);
            if (this.A) {
                dimensionPixelSize = 0;
            }
            marginLayoutParams.bottomMargin = dimensionPixelSize;
            this.j.setLayoutParams(marginLayoutParams);
            View view2 = this.j;
            if (view2 instanceof DefaultTimeBar) {
                DefaultTimeBar defaultTimeBar = (DefaultTimeBar) view2;
                if (this.A) {
                    defaultTimeBar.g(true);
                } else {
                    int i2 = this.z;
                    if (i2 == 1) {
                        defaultTimeBar.g(false);
                    } else if (i2 != 3) {
                        defaultTimeBar.t();
                    }
                }
            }
        }
        for (View view3 : this.y) {
            view3.setVisibility((!this.A || !a0(view3)) ? 0 : 4);
        }
    }

    private boolean e0() {
        int width = (this.a.getWidth() - this.a.getPaddingLeft()) - this.a.getPaddingRight();
        int height = (this.a.getHeight() - this.a.getPaddingBottom()) - this.a.getPaddingTop();
        int o = o(this.f3771c);
        ViewGroup viewGroup = this.f3771c;
        int paddingLeft = o - (viewGroup != null ? viewGroup.getPaddingLeft() + this.f3771c.getPaddingRight() : 0);
        int m = m(this.f3771c);
        ViewGroup viewGroup2 = this.f3771c;
        return width <= Math.max(paddingLeft, o(this.i) + o(this.k)) || height <= (m - (viewGroup2 != null ? viewGroup2.getPaddingTop() + this.f3771c.getPaddingBottom() : 0)) + (m(this.f3772d) * 2);
    }

    private void l(float f2) {
        ViewGroup viewGroup = this.h;
        if (viewGroup != null) {
            this.h.setTranslationX((int) (viewGroup.getWidth() * (1.0f - f2)));
        }
        ViewGroup viewGroup2 = this.i;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(1.0f - f2);
        }
        ViewGroup viewGroup3 = this.f3774f;
        if (viewGroup3 != null) {
            viewGroup3.setAlpha(1.0f - f2);
        }
    }

    private static int m(@Nullable View view) {
        if (view == null) {
            return 0;
        }
        int height = view.getHeight();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return height;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return height + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private static int o(@Nullable View view) {
        if (view == null) {
            return 0;
        }
        int width = view.getWidth();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return width;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return width + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        this.n.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        Z(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        this.l.start();
        U(this.u, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        this.m.start();
    }

    public void O() {
        this.a.addOnLayoutChangeListener(this.x);
    }

    public void P() {
        this.a.removeOnLayoutChangeListener(this.x);
    }

    public void Q(boolean z, int i2, int i3, int i4, int i5) {
        View view = this.f3770b;
        if (view != null) {
            view.layout(0, 0, i4 - i2, i5 - i3);
        }
    }

    public void V() {
        this.a.removeCallbacks(this.w);
        this.a.removeCallbacks(this.t);
        this.a.removeCallbacks(this.v);
        this.a.removeCallbacks(this.u);
    }

    public void W() {
        if (this.z != 3) {
            V();
            int showTimeoutMs = this.a.getShowTimeoutMs();
            if (showTimeoutMs <= 0) {
                return;
            }
            if (!this.C) {
                U(this.w, showTimeoutMs);
            } else if (this.z == 1) {
                U(this.u, 2000L);
            } else {
                U(this.v, showTimeoutMs);
            }
        }
    }

    public void X(boolean z) {
        this.C = z;
    }

    public void Y(@Nullable View view, boolean z) {
        if (view != null) {
            if (!z) {
                view.setVisibility(8);
                this.y.remove(view);
                return;
            }
            if (!this.A || !a0(view)) {
                view.setVisibility(0);
            } else {
                view.setVisibility(4);
            }
            this.y.add(view);
        }
    }

    public void b0() {
        if (!this.a.g0()) {
            this.a.setVisibility(0);
            this.a.u0();
            this.a.p0();
        }
        c0();
    }

    public boolean n(@Nullable View view) {
        return view != null && this.y.contains(view);
    }

    public void p() {
        int i2 = this.z;
        if (i2 != 3 && i2 != 2) {
            V();
            if (!this.C) {
                r();
            } else if (this.z == 1) {
                u();
            } else {
                q();
            }
        }
    }

    public void s() {
        int i2 = this.z;
        if (i2 != 3 && i2 != 2) {
            V();
            r();
        }
    }

    public boolean v() {
        return this.z == 0 && this.a.g0();
    }
}
