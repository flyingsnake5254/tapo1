package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.handmark.pulltorefresh.library.internal.FlipLoadingLayout;
import com.handmark.pulltorefresh.library.internal.LoadingLayout;
import com.handmark.pulltorefresh.library.internal.RotateLoadingLayout;
import com.tplink.libtpcontrols.x0;

/* loaded from: classes2.dex */
public abstract class PullToRefreshBase<T extends View> extends LinearLayout {
    T H3;
    private FrameLayout I3;
    private Interpolator P3;
    private LoadingLayout R3;
    private LoadingLayout S3;
    private e<T> T3;
    private d<T> U3;
    private c<T> V3;
    private PullToRefreshBase<T>.g W3;

    /* renamed from: c  reason: collision with root package name */
    private int f5014c;

    /* renamed from: d  reason: collision with root package name */
    private float f5015d;

    /* renamed from: f  reason: collision with root package name */
    private float f5016f;
    private Mode p3;
    private float q;
    private float x;
    private boolean y = false;
    private boolean z = false;
    private boolean p0 = true;
    private State p1 = State.RESET;
    private Mode p2 = Mode.getDefault();
    private boolean J3 = true;
    private boolean K3 = false;
    private boolean L3 = false;
    private boolean M3 = true;
    private boolean N3 = true;
    private boolean O3 = true;
    private AnimationStyle Q3 = AnimationStyle.getDefault();

    /* loaded from: classes2.dex */
    public enum AnimationStyle {
        ROTATE,
        FLIP;

        static AnimationStyle getDefault() {
            return ROTATE;
        }

        static AnimationStyle mapIntToValue(int i) {
            if (i != 1) {
                return ROTATE;
            }
            return FLIP;
        }

        LoadingLayout createLoadingLayout(Context context, Mode mode, Orientation orientation, TypedArray typedArray) {
            if (a.f5019d[ordinal()] != 2) {
                return new RotateLoadingLayout(context, mode, orientation, typedArray);
            }
            return new FlipLoadingLayout(context, mode, orientation, typedArray);
        }
    }

    /* loaded from: classes2.dex */
    public enum Mode {
        DISABLED(0),
        PULL_FROM_START(1),
        PULL_FROM_END(2),
        BOTH(3),
        MANUAL_REFRESH_ONLY(4);
        
        public static Mode PULL_DOWN_TO_REFRESH;
        public static Mode PULL_UP_TO_REFRESH;
        private int mIntValue;

        static {
            Mode mode = PULL_FROM_START;
            Mode mode2 = PULL_FROM_END;
            PULL_DOWN_TO_REFRESH = mode;
            PULL_UP_TO_REFRESH = mode2;
        }

        Mode(int i) {
            this.mIntValue = i;
        }

        static Mode getDefault() {
            return PULL_FROM_START;
        }

        static Mode mapIntToValue(int i) {
            Mode[] values;
            for (Mode mode : values()) {
                if (i == mode.getIntValue()) {
                    return mode;
                }
            }
            return getDefault();
        }

        int getIntValue() {
            return this.mIntValue;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean permitsPullToRefresh() {
            return (this == DISABLED || this == MANUAL_REFRESH_ONLY) ? false : true;
        }

        public boolean showFooterLoadingLayout() {
            return this == PULL_FROM_END || this == BOTH || this == MANUAL_REFRESH_ONLY;
        }

        public boolean showHeaderLoadingLayout() {
            return this == PULL_FROM_START || this == BOTH;
        }
    }

    /* loaded from: classes2.dex */
    public enum Orientation {
        VERTICAL,
        HORIZONTAL
    }

    /* loaded from: classes2.dex */
    public enum State {
        RESET(0),
        PULL_TO_REFRESH(1),
        RELEASE_TO_REFRESH(2),
        REFRESHING(8),
        MANUAL_REFRESHING(9),
        OVERSCROLLING(16);
        
        private int mIntValue;

        State(int i) {
            this.mIntValue = i;
        }

        static State mapIntToValue(int i) {
            State[] values;
            for (State state : values()) {
                if (i == state.getIntValue()) {
                    return state;
                }
            }
            return RESET;
        }

        int getIntValue() {
            return this.mIntValue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f5017b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f5018c;

        /* renamed from: d  reason: collision with root package name */
        static final /* synthetic */ int[] f5019d;

        static {
            int[] iArr = new int[AnimationStyle.values().length];
            f5019d = iArr;
            try {
                iArr[AnimationStyle.ROTATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5019d[AnimationStyle.FLIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Mode.values().length];
            f5018c = iArr2;
            try {
                iArr2[Mode.PULL_FROM_END.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5018c[Mode.PULL_FROM_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5018c[Mode.MANUAL_REFRESH_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f5018c[Mode.BOTH.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[State.values().length];
            f5017b = iArr3;
            try {
                iArr3[State.RESET.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f5017b[State.PULL_TO_REFRESH.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f5017b[State.RELEASE_TO_REFRESH.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f5017b[State.REFRESHING.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f5017b[State.MANUAL_REFRESHING.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f5017b[State.OVERSCROLLING.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            int[] iArr4 = new int[Orientation.values().length];
            a = iArr4;
            try {
                iArr4[Orientation.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[Orientation.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes2.dex */
    public interface c<V extends View> {
        void a(PullToRefreshBase<V> pullToRefreshBase, State state, Mode mode);
    }

    /* loaded from: classes2.dex */
    public interface d<V extends View> {
        void a(PullToRefreshBase<V> pullToRefreshBase);

        void b(PullToRefreshBase<V> pullToRefreshBase);
    }

    /* loaded from: classes2.dex */
    public interface e<V extends View> {
        void a(PullToRefreshBase<V> pullToRefreshBase);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface f {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class g implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        private final Interpolator f5020c;

        /* renamed from: d  reason: collision with root package name */
        private final int f5021d;

        /* renamed from: f  reason: collision with root package name */
        private final int f5022f;
        private final long q;
        private f x;
        private boolean y = true;
        private long z = -1;
        private int p0 = -1;

        public g(int i, int i2, long j, f fVar) {
            this.f5022f = i;
            this.f5021d = i2;
            this.f5020c = PullToRefreshBase.this.P3;
            this.q = j;
            this.x = fVar;
        }

        public void a() {
            this.y = false;
            PullToRefreshBase.this.removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.z == -1) {
                this.z = System.currentTimeMillis();
            } else {
                int round = this.f5022f - Math.round((this.f5022f - this.f5021d) * this.f5020c.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.z) * 1000) / this.q, 1000L), 0L)) / 1000.0f));
                this.p0 = round;
                PullToRefreshBase.this.setHeaderScroll(round);
            }
            if (!this.y || this.f5021d == this.p0) {
                f fVar = this.x;
                if (fVar != null) {
                    fVar.a();
                    return;
                }
                return;
            }
            com.handmark.pulltorefresh.library.internal.c.a(PullToRefreshBase.this, this);
        }
    }

    public PullToRefreshBase(Context context) {
        super(context);
        l(context, null);
    }

    private void A() {
        float f2;
        float f3;
        int i;
        int i2;
        if (a.a[getPullToRefreshScrollDirection().ordinal()] != 1) {
            f3 = this.x;
            f2 = this.f5016f;
        } else {
            f3 = this.q;
            f2 = this.f5015d;
        }
        int[] iArr = a.f5018c;
        if (iArr[this.p3.ordinal()] != 1) {
            i2 = Math.round(Math.min(f3 - f2, 0.0f) / 2.0f);
            i = getHeaderSize();
        } else {
            i2 = Math.round(Math.max(f3 - f2, 0.0f) / 2.0f);
            i = getFooterSize();
        }
        setHeaderScroll(i2);
        if (i2 != 0 && !r()) {
            float abs = Math.abs(i2) / i;
            if (iArr[this.p3.ordinal()] != 1) {
                this.R3.c(abs);
            } else {
                this.S3.c(abs);
            }
            State state = this.p1;
            State state2 = State.PULL_TO_REFRESH;
            if (state != state2 && i >= Math.abs(i2)) {
                E(state2, new boolean[0]);
            } else if (this.p1 == state2 && i < Math.abs(i2)) {
                E(State.RELEASE_TO_REFRESH, new boolean[0]);
            }
        }
    }

    private void G(int i, long j) {
        H(i, j, 0L, null);
    }

    private void H(int i, long j, long j2, f fVar) {
        int i2;
        PullToRefreshBase<T>.g gVar = this.W3;
        if (gVar != null) {
            gVar.a();
        }
        if (a.a[getPullToRefreshScrollDirection().ordinal()] != 1) {
            i2 = getScrollY();
        } else {
            i2 = getScrollX();
        }
        if (i2 != i) {
            if (this.P3 == null) {
                this.P3 = new DecelerateInterpolator();
            }
            PullToRefreshBase<T>.g gVar2 = new g(i2, i, j, fVar);
            this.W3 = gVar2;
            if (j2 > 0) {
                postDelayed(gVar2, j2);
            } else {
                post(gVar2);
            }
        }
    }

    private void b(Context context, T t) {
        FrameLayout frameLayout = new FrameLayout(context);
        this.I3 = frameLayout;
        frameLayout.addView(t, -1, -1);
        d(this.I3, new LinearLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        e<T> eVar = this.T3;
        if (eVar != null) {
            eVar.a(this);
            return;
        }
        d<T> dVar = this.U3;
        if (dVar != null) {
            Mode mode = this.p3;
            if (mode == Mode.PULL_FROM_START) {
                dVar.b(this);
            } else if (mode == Mode.PULL_FROM_END) {
                dVar.a(this);
            }
        }
    }

    private LinearLayout.LayoutParams getLoadingLayoutLayoutParams() {
        if (a.a[getPullToRefreshScrollDirection().ordinal()] != 1) {
            return new LinearLayout.LayoutParams(-1, -2);
        }
        return new LinearLayout.LayoutParams(-2, -1);
    }

    private int getMaximumPullScroll() {
        if (a.a[getPullToRefreshScrollDirection().ordinal()] != 1) {
            return Math.round(getHeight() / 2.0f);
        }
        return Math.round(getWidth() / 2.0f);
    }

    private void l(Context context, AttributeSet attributeSet) {
        if (a.a[getPullToRefreshScrollDirection().ordinal()] != 1) {
            setOrientation(1);
        } else {
            setOrientation(0);
        }
        setGravity(17);
        this.f5014c = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, x0.PullToRefresh);
        int i = x0.PullToRefresh_ptrMode;
        if (obtainStyledAttributes.hasValue(i)) {
            this.p2 = Mode.mapIntToValue(obtainStyledAttributes.getInteger(i, 0));
        }
        int i2 = x0.PullToRefresh_ptrAnimationStyle;
        if (obtainStyledAttributes.hasValue(i2)) {
            this.Q3 = AnimationStyle.mapIntToValue(obtainStyledAttributes.getInteger(i2, 0));
        }
        T h = h(context, attributeSet);
        this.H3 = h;
        b(context, h);
        this.R3 = f(context, Mode.PULL_FROM_START, obtainStyledAttributes);
        this.S3 = f(context, Mode.PULL_FROM_END, obtainStyledAttributes);
        int i3 = x0.PullToRefresh_ptrRefreshableViewBackground;
        if (obtainStyledAttributes.hasValue(i3)) {
            Drawable drawable = obtainStyledAttributes.getDrawable(i3);
            if (drawable != null) {
                this.H3.setBackgroundDrawable(drawable);
            }
        } else {
            int i4 = x0.PullToRefresh_ptrAdapterViewBackground;
            if (obtainStyledAttributes.hasValue(i4)) {
                com.handmark.pulltorefresh.library.internal.b.a("ptrAdapterViewBackground", "ptrRefreshableViewBackground");
                Drawable drawable2 = obtainStyledAttributes.getDrawable(i4);
                if (drawable2 != null) {
                    this.H3.setBackgroundDrawable(drawable2);
                }
            }
        }
        int i5 = x0.PullToRefresh_ptrOverScroll;
        if (obtainStyledAttributes.hasValue(i5)) {
            this.N3 = obtainStyledAttributes.getBoolean(i5, true);
        }
        int i6 = x0.PullToRefresh_ptrScrollingWhileRefreshingEnabled;
        if (obtainStyledAttributes.hasValue(i6)) {
            this.K3 = obtainStyledAttributes.getBoolean(i6, false);
        }
        int i7 = x0.PullToRefresh_ptrInitRefreshing;
        if (obtainStyledAttributes.hasValue(i7)) {
            this.z = obtainStyledAttributes.getBoolean(i7, false);
        }
        int i8 = x0.PullToRefresh_ptrChildViewClickableWhileRefreshing;
        if (obtainStyledAttributes.hasValue(i8)) {
            this.L3 = obtainStyledAttributes.getBoolean(i8, false);
        }
        k(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        J();
    }

    private boolean o() {
        int i = a.f5018c[this.p2.ordinal()];
        if (i == 1) {
            return p();
        }
        if (i == 2) {
            return q();
        }
        if (i != 4) {
            return false;
        }
        return p() || q();
    }

    protected final void B() {
        int maximumPullScroll = (int) (getMaximumPullScroll() * 1.2f);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int i = a.a[getPullToRefreshScrollDirection().ordinal()];
        if (i == 1) {
            if (this.p2.showHeaderLoadingLayout()) {
                this.R3.setWidth(maximumPullScroll);
                paddingLeft = -maximumPullScroll;
            } else {
                paddingLeft = 0;
            }
            if (this.p2.showFooterLoadingLayout()) {
                this.S3.setWidth(maximumPullScroll);
                paddingRight = -maximumPullScroll;
            } else {
                paddingRight = 0;
            }
        } else if (i == 2) {
            if (this.p2.showHeaderLoadingLayout()) {
                this.R3.setHeight(maximumPullScroll);
                paddingTop = -maximumPullScroll;
            } else {
                paddingTop = 0;
            }
            if (this.p2.showFooterLoadingLayout()) {
                this.S3.setHeight(maximumPullScroll);
                paddingBottom = -maximumPullScroll;
            } else {
                paddingBottom = 0;
            }
        }
        setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    protected final void C(int i, int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.I3.getLayoutParams();
        int i3 = a.a[getPullToRefreshScrollDirection().ordinal()];
        if (i3 != 1) {
            if (i3 == 2 && layoutParams.height != i2) {
                layoutParams.height = i2;
                this.I3.requestLayout();
            }
        } else if (layoutParams.width != i) {
            layoutParams.width = i;
            this.I3.requestLayout();
        }
    }

    public void D(CharSequence charSequence, Mode mode) {
        j(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setReleaseLabel(charSequence);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void E(State state, boolean... zArr) {
        this.p1 = state;
        int i = a.f5017b[state.ordinal()];
        if (i == 1) {
            z();
        } else if (i == 2) {
            v();
        } else if (i == 3) {
            y();
        } else if (i == 4 || i == 5) {
            x(zArr[0]);
        }
        c<T> cVar = this.V3;
        if (cVar != null) {
            cVar.a(this, this.p1, this.p3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void F(int i) {
        G(i, getPullToRefreshScrollDuration());
    }

    protected final void I(int i, f fVar) {
        H(i, getPullToRefreshScrollDuration(), 0L, fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J() {
        LinearLayout.LayoutParams loadingLayoutLayoutParams = getLoadingLayoutLayoutParams();
        if (this == this.R3.getParent()) {
            removeView(this.R3);
        }
        if (this.p2.showHeaderLoadingLayout()) {
            c(this.R3, 0, loadingLayoutLayoutParams);
        }
        if (this == this.S3.getParent()) {
            removeView(this.S3);
        }
        if (this.p2.showFooterLoadingLayout()) {
            d(this.S3, loadingLayoutLayoutParams);
        }
        B();
        Mode mode = this.p2;
        if (mode == Mode.BOTH) {
            mode = Mode.PULL_FROM_START;
        }
        this.p3 = mode;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        T refreshableView = getRefreshableView();
        if (refreshableView instanceof ViewGroup) {
            ((ViewGroup) refreshableView).addView(view, i, layoutParams);
            return;
        }
        throw new UnsupportedOperationException("Refreshable View is not a ViewGroup so can't addView");
    }

    protected final void c(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
    }

    protected final void d(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, -1, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LoadingLayout f(Context context, Mode mode, TypedArray typedArray) {
        LoadingLayout createLoadingLayout = this.Q3.createLoadingLayout(context, mode, getPullToRefreshScrollDirection(), typedArray);
        createLoadingLayout.setVisibility(4);
        return createLoadingLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e g(boolean z, boolean z2) {
        e eVar = new e();
        if (z && this.p2.showHeaderLoadingLayout()) {
            eVar.a(this.R3);
        }
        if (z2 && this.p2.showFooterLoadingLayout()) {
            eVar.a(this.S3);
        }
        return eVar;
    }

    public final Mode getCurrentMode() {
        return this.p3;
    }

    public final boolean getFilterTouchEvents() {
        return this.M3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LoadingLayout getFooterLayout() {
        return this.S3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getFooterSize() {
        return this.S3.getContentSize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LoadingLayout getHeaderLayout() {
        return this.R3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getHeaderSize() {
        return this.R3.getContentSize();
    }

    public final d getLoadingLayoutProxy() {
        return j(true, true);
    }

    public final Mode getMode() {
        return this.p2;
    }

    public abstract Orientation getPullToRefreshScrollDirection();

    protected int getPullToRefreshScrollDuration() {
        return ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION;
    }

    protected int getPullToRefreshScrollDurationLonger() {
        return 325;
    }

    public final T getRefreshableView() {
        return this.H3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FrameLayout getRefreshableViewWrapper() {
        return this.I3;
    }

    public final boolean getShowViewWhileRefreshing() {
        return this.J3;
    }

    public final State getState() {
        return this.p1;
    }

    protected abstract T h(Context context, AttributeSet attributeSet);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void i() {
        this.O3 = false;
    }

    public final d j(boolean z, boolean z2) {
        return g(z, z2);
    }

    protected void k(TypedArray typedArray) {
    }

    public final boolean m() {
        return this.p2.permitsPullToRefresh();
    }

    public final boolean n() {
        return Build.VERSION.SDK_INT >= 9 && this.N3 && f.a(this.H3);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f2;
        float f3;
        if (!m()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.y = false;
            return false;
        } else if (this.L3 && r()) {
            return false;
        } else {
            if (action != 0 && this.y) {
                return true;
            }
            if (action != 0) {
                if (action == 2) {
                    if (!this.K3 && r()) {
                        return true;
                    }
                    if (o()) {
                        float y = motionEvent.getY();
                        float x = motionEvent.getX();
                        if (a.a[getPullToRefreshScrollDirection().ordinal()] != 1) {
                            f3 = y - this.f5016f;
                            f2 = x - this.f5015d;
                        } else {
                            f3 = x - this.f5015d;
                            f2 = y - this.f5016f;
                        }
                        float abs = Math.abs(f3);
                        if (abs > this.f5014c && (!this.M3 || abs > Math.abs(f2))) {
                            if (this.p2.showHeaderLoadingLayout() && f3 >= 1.0f && q()) {
                                this.f5016f = y;
                                this.f5015d = x;
                                this.y = true;
                                if (this.p2 == Mode.BOTH) {
                                    this.p3 = Mode.PULL_FROM_START;
                                }
                            } else if (this.p2.showFooterLoadingLayout() && f3 <= -1.0f && p()) {
                                this.f5016f = y;
                                this.f5015d = x;
                                this.y = true;
                                if (this.p2 == Mode.BOTH) {
                                    this.p3 = Mode.PULL_FROM_END;
                                }
                            }
                        }
                    }
                }
            } else if (o()) {
                float y2 = motionEvent.getY();
                this.x = y2;
                this.f5016f = y2;
                float x2 = motionEvent.getX();
                this.q = x2;
                this.f5015d = x2;
                this.y = false;
            }
            return this.y;
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.p0 && this.z) {
            if (getHeaderSize() > 0 || getFooterSize() > 0) {
                E(State.REFRESHING, true);
                this.p0 = false;
            }
        }
    }

    @Override // android.view.View
    protected final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            setMode(Mode.mapIntToValue(bundle.getInt("ptr_mode", 0)));
            this.p3 = Mode.mapIntToValue(bundle.getInt("ptr_current_mode", 0));
            this.K3 = bundle.getBoolean("ptr_disable_scrolling", false);
            this.J3 = bundle.getBoolean("ptr_show_refreshing_view", true);
            super.onRestoreInstanceState(bundle.getParcelable("ptr_super"));
            State mapIntToValue = State.mapIntToValue(bundle.getInt("ptr_state", 0));
            if (mapIntToValue == State.REFRESHING || mapIntToValue == State.MANUAL_REFRESHING) {
                E(mapIntToValue, true);
            }
            t(bundle);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    protected final Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        u(bundle);
        bundle.putInt("ptr_state", this.p1.getIntValue());
        bundle.putInt("ptr_mode", this.p2.getIntValue());
        bundle.putInt("ptr_current_mode", this.p3.getIntValue());
        bundle.putBoolean("ptr_disable_scrolling", this.K3);
        bundle.putBoolean("ptr_show_refreshing_view", this.J3);
        bundle.putParcelable("ptr_super", super.onSaveInstanceState());
        return bundle;
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        B();
        C(i, i2);
        post(new Runnable() { // from class: com.handmark.pulltorefresh.library.a
            @Override // java.lang.Runnable
            public final void run() {
                PullToRefreshBase.this.requestLayout();
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x002d, code lost:
        if (r0 != 3) goto L_0x008b;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            boolean r0 = r4.m()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            boolean r0 = r4.K3
            r2 = 1
            if (r0 != 0) goto L_0x0014
            boolean r0 = r4.r()
            if (r0 == 0) goto L_0x0014
            return r2
        L_0x0014:
            int r0 = r5.getAction()
            if (r0 != 0) goto L_0x0021
            int r0 = r5.getEdgeFlags()
            if (r0 == 0) goto L_0x0021
            return r1
        L_0x0021:
            int r0 = r5.getAction()
            if (r0 == 0) goto L_0x0074
            if (r0 == r2) goto L_0x0044
            r3 = 2
            if (r0 == r3) goto L_0x0030
            r5 = 3
            if (r0 == r5) goto L_0x0044
            goto L_0x008b
        L_0x0030:
            boolean r0 = r4.y
            if (r0 == 0) goto L_0x008b
            float r0 = r5.getY()
            r4.f5016f = r0
            float r5 = r5.getX()
            r4.f5015d = r5
            r4.A()
            return r2
        L_0x0044:
            boolean r5 = r4.y
            if (r5 == 0) goto L_0x008b
            r4.y = r1
            com.handmark.pulltorefresh.library.PullToRefreshBase$State r5 = r4.p1
            com.handmark.pulltorefresh.library.PullToRefreshBase$State r0 = com.handmark.pulltorefresh.library.PullToRefreshBase.State.RELEASE_TO_REFRESH
            if (r5 != r0) goto L_0x0062
            com.handmark.pulltorefresh.library.PullToRefreshBase$e<T extends android.view.View> r5 = r4.T3
            if (r5 != 0) goto L_0x0058
            com.handmark.pulltorefresh.library.PullToRefreshBase$d<T extends android.view.View> r5 = r4.U3
            if (r5 == 0) goto L_0x0062
        L_0x0058:
            com.handmark.pulltorefresh.library.PullToRefreshBase$State r5 = com.handmark.pulltorefresh.library.PullToRefreshBase.State.REFRESHING
            boolean[] r0 = new boolean[r2]
            r0[r1] = r2
            r4.E(r5, r0)
            return r2
        L_0x0062:
            boolean r5 = r4.r()
            if (r5 == 0) goto L_0x006c
            r4.F(r1)
            return r2
        L_0x006c:
            com.handmark.pulltorefresh.library.PullToRefreshBase$State r5 = com.handmark.pulltorefresh.library.PullToRefreshBase.State.RESET
            boolean[] r0 = new boolean[r1]
            r4.E(r5, r0)
            return r2
        L_0x0074:
            boolean r0 = r4.o()
            if (r0 == 0) goto L_0x008b
            float r0 = r5.getY()
            r4.x = r0
            r4.f5016f = r0
            float r5 = r5.getX()
            r4.q = r5
            r4.f5015d = r5
            return r2
        L_0x008b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.handmark.pulltorefresh.library.PullToRefreshBase.onTouchEvent(android.view.MotionEvent):boolean");
    }

    protected abstract boolean p();

    protected abstract boolean q();

    public final boolean r() {
        State state = this.p1;
        return state == State.REFRESHING || state == State.MANUAL_REFRESHING;
    }

    public void setChildClickableWhileRefreshing(boolean z) {
        this.L3 = z;
    }

    public void setDisableScrollingWhileRefreshing(boolean z) {
        setScrollingWhileRefreshingEnabled(!z);
    }

    public final void setFilterTouchEvents(boolean z) {
        this.M3 = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setHeaderScroll(int i) {
        int maximumPullScroll = getMaximumPullScroll();
        int min = Math.min(maximumPullScroll, Math.max(-maximumPullScroll, i));
        if (this.O3) {
            if (min < 0) {
                this.R3.setVisibility(0);
            } else if (min > 0) {
                this.S3.setVisibility(0);
            } else {
                this.R3.setVisibility(4);
                this.S3.setVisibility(4);
            }
        }
        int i2 = a.a[getPullToRefreshScrollDirection().ordinal()];
        if (i2 == 1) {
            scrollTo(min, 0);
        } else if (i2 == 2) {
            scrollTo(0, min);
        }
    }

    public void setInitRefresing(boolean z) {
        this.z = z;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setLastUpdatedLabel(charSequence);
    }

    public void setLoadingDrawable(Drawable drawable) {
        getLoadingLayoutProxy().setLoadingDrawable(drawable);
    }

    @Override // android.view.View
    public void setLongClickable(boolean z) {
        getRefreshableView().setLongClickable(z);
    }

    public final void setMode(Mode mode) {
        if (mode != this.p2) {
            this.p2 = mode;
            J();
        }
    }

    public void setOnPullEventListener(c<T> cVar) {
        this.V3 = cVar;
    }

    public final void setOnRefreshListener(e<T> eVar) {
        this.T3 = eVar;
        this.U3 = null;
    }

    public void setPullLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setPullLabel(charSequence);
    }

    public final void setPullToRefreshEnabled(boolean z) {
        setMode(z ? Mode.getDefault() : Mode.DISABLED);
    }

    public final void setPullToRefreshOverScrollEnabled(boolean z) {
        this.N3 = z;
    }

    public final void setRefreshing(boolean z) {
        if (!r()) {
            E(State.MANUAL_REFRESHING, z);
        }
    }

    public void setRefreshingLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setRefreshingLabel(charSequence);
    }

    public void setReleaseLabel(CharSequence charSequence) {
        D(charSequence, Mode.BOTH);
    }

    public void setScrollAnimationInterpolator(Interpolator interpolator) {
        this.P3 = interpolator;
    }

    public final void setScrollingWhileRefreshingEnabled(boolean z) {
        this.K3 = z;
    }

    public final void setShowViewWhileRefreshing(boolean z) {
        this.J3 = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t(Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u(Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v() {
        int i = a.f5018c[this.p3.ordinal()];
        if (i == 1) {
            this.S3.e();
        } else if (i == 2) {
            this.R3.e();
        }
    }

    public final void w() {
        if (r()) {
            E(State.RESET, new boolean[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x(boolean z) {
        if (this.p2.showHeaderLoadingLayout()) {
            this.R3.g();
        }
        if (this.p2.showFooterLoadingLayout()) {
            this.S3.g();
        }
        if (!z) {
            e();
        } else if (this.J3) {
            f bVar = new f() { // from class: com.handmark.pulltorefresh.library.b
                @Override // com.handmark.pulltorefresh.library.PullToRefreshBase.f
                public final void a() {
                    PullToRefreshBase.this.e();
                }
            };
            int i = a.f5018c[this.p3.ordinal()];
            if (i == 1 || i == 3) {
                I(getFooterSize(), bVar);
            } else {
                I(-getHeaderSize(), bVar);
            }
        } else {
            F(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y() {
        int i = a.f5018c[this.p3.ordinal()];
        if (i == 1) {
            this.S3.i();
        } else if (i == 2) {
            this.R3.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z() {
        this.y = false;
        this.O3 = true;
        this.R3.k();
        this.S3.k();
        F(0);
    }

    public final void setOnRefreshListener(d<T> dVar) {
        this.U3 = dVar;
        this.T3 = null;
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        l(context, attributeSet);
    }
}
