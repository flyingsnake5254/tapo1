package com.tplink.iot.view.ipcamera.widget.topsnackbar;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.tplink.iot.R;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.d;

/* loaded from: classes2.dex */
public final class TSnackbar {
    private static final Handler a = new Handler(Looper.getMainLooper(), new b());

    /* renamed from: b  reason: collision with root package name */
    private int f9441b;

    /* renamed from: c  reason: collision with root package name */
    private ViewGroup f9442c;

    /* renamed from: d  reason: collision with root package name */
    private Context f9443d;

    /* renamed from: e  reason: collision with root package name */
    private SnackbarLayout f9444e;

    /* renamed from: f  reason: collision with root package name */
    private int f9445f;
    private k g;
    private AccessibilityManager h;
    private final d.b i = new d();

    /* loaded from: classes2.dex */
    public static class SnackbarLayout extends LinearLayout {

        /* renamed from: c  reason: collision with root package name */
        private TextView f9446c;

        /* renamed from: d  reason: collision with root package name */
        private TextView f9447d;

        /* renamed from: f  reason: collision with root package name */
        private int f9448f;
        private int q;
        private b x;
        private a y;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public interface a {
            void onViewAttachedToWindow(View view);

            void onViewDetachedFromWindow(View view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public interface b {
            void onLayoutChange(View view, int i, int i2, int i3, int i4);
        }

        public SnackbarLayout(Context context) {
            this(context, null);
        }

        TextView getActionView() {
            return this.f9447d;
        }

        TextView getMessageView() {
            return this.f9446c;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            a aVar = this.y;
            if (aVar != null) {
                aVar.onViewAttachedToWindow(this);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            a aVar = this.y;
            if (aVar != null) {
                aVar.onViewDetachedFromWindow(this);
            }
        }

        @Override // android.view.View
        protected void onFinishInflate() {
            super.onFinishInflate();
            this.f9446c = (TextView) findViewById(R.id.snackbar_text);
            this.f9447d = (TextView) findViewById(R.id.snackbar_action);
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            b bVar;
            super.onLayout(z, i, i2, i3, i4);
            if (z && (bVar = this.x) != null) {
                bVar.onLayoutChange(this, i, i2, i3, i4);
            }
        }

        void setOnAttachStateChangeListener(a aVar) {
            this.y = aVar;
        }

        void setOnLayoutChangeListener(b bVar) {
            this.x = bVar;
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tplink.iot.b.SnackbarLayout);
            this.f9448f = obtainStyledAttributes.getDimensionPixelSize(0, -1);
            this.q = obtainStyledAttributes.getDimensionPixelSize(7, -1);
            if (obtainStyledAttributes.hasValue(6)) {
                ViewCompat.setElevation(this, obtainStyledAttributes.getDimensionPixelSize(6, 0));
            }
            obtainStyledAttributes.recycle();
            setClickable(true);
            LayoutInflater.from(context).inflate(R.layout.view_tsnackbar_layout_include, this);
            ViewCompat.setAccessibilityLiveRegion(this, 1);
            ViewCompat.setImportantForAccessibility(this, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Animation.AnimationListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f9449c;

        a(int i) {
            this.f9449c = i;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            TSnackbar.this.D(this.f9449c);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes2.dex */
    static class b implements Handler.Callback {
        b() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                ((TSnackbar) message.obj).O();
                return true;
            } else if (i != 1) {
                return false;
            } else {
                ((TSnackbar) message.obj).t(message.arg1);
                return true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f9451c;

        c(View.OnClickListener onClickListener) {
            this.f9451c = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f9451c.onClick(view);
            TSnackbar.this.l(1);
        }
    }

    /* loaded from: classes2.dex */
    class d implements d.b {
        d() {
        }

        @Override // com.tplink.iot.view.ipcamera.widget.topsnackbar.d.b
        public String content() {
            return TSnackbar.this.f9444e.f9446c.getText().toString();
        }

        @Override // com.tplink.iot.view.ipcamera.widget.topsnackbar.d.b
        public void dismiss(int i) {
            TSnackbar.a.sendMessage(TSnackbar.a.obtainMessage(1, i, 0, TSnackbar.this));
        }

        @Override // com.tplink.iot.view.ipcamera.widget.topsnackbar.d.b
        public View getParentView() {
            return TSnackbar.this.f9442c;
        }

        @Override // com.tplink.iot.view.ipcamera.widget.topsnackbar.d.b
        public void show() {
            TSnackbar.a.sendMessage(TSnackbar.a.obtainMessage(0, TSnackbar.this));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements SwipeDismissBehavior.OnDismissListener {
        e() {
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.OnDismissListener
        public void onDismiss(View view) {
            view.setVisibility(8);
            TSnackbar.this.l(0);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.OnDismissListener
        public void onDragStateChanged(int i) {
            if (i == 0) {
                d.e().n(TSnackbar.this.i);
            } else if (i == 1 || i == 2) {
                d.e().c(TSnackbar.this.i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f implements SnackbarLayout.b {
        f() {
        }

        @Override // com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar.SnackbarLayout.b
        public void onLayoutChange(View view, int i, int i2, int i3, int i4) {
            TSnackbar.this.j();
            TSnackbar.this.f9444e.setOnLayoutChangeListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class g implements SnackbarLayout.a {

        /* loaded from: classes2.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                TSnackbar.this.D(3);
            }
        }

        g() {
        }

        @Override // com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar.SnackbarLayout.a
        public void onViewAttachedToWindow(View view) {
        }

        @Override // com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar.SnackbarLayout.a
        public void onViewDetachedFromWindow(View view) {
            if (TSnackbar.this.u()) {
                TSnackbar.a.post(new a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class h implements SnackbarLayout.b {
        h() {
        }

        @Override // com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar.SnackbarLayout.b
        public void onLayoutChange(View view, int i, int i2, int i3, int i4) {
            TSnackbar.this.f9444e.setOnLayoutChangeListener(null);
            if (TSnackbar.this.M()) {
                TSnackbar.this.j();
            } else {
                TSnackbar.this.E();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class i implements Animation.AnimationListener {
        i() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            TSnackbar.this.E();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class j extends SwipeDismissBehavior<SnackbarLayout> {
        j() {
        }

        /* renamed from: a */
        public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, SnackbarLayout snackbarLayout, MotionEvent motionEvent) {
            if (coordinatorLayout.isPointInChildBounds(snackbarLayout, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked == 0) {
                    d.e().c(TSnackbar.this.i);
                } else if (actionMasked == 1 || actionMasked == 3) {
                    d.e().n(TSnackbar.this.i);
                }
            }
            return super.onInterceptTouchEvent(coordinatorLayout, snackbarLayout, motionEvent);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean canSwipeDismissView(View view) {
            return view instanceof SnackbarLayout;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class k {
    }

    private TSnackbar(ViewGroup viewGroup, int i2) {
        this.f9441b = 0;
        this.f9441b = i2;
        this.f9442c = viewGroup;
        Context context = viewGroup.getContext();
        this.f9443d = context;
        LayoutInflater from = LayoutInflater.from(context);
        if (i2 == 1) {
            this.f9444e = (SnackbarLayout) from.inflate(R.layout.view_bsnackbar_layout, this.f9442c, false);
        } else {
            this.f9444e = (SnackbarLayout) from.inflate(R.layout.view_tsnackbar_layout, this.f9442c, false);
        }
        this.h = (AccessibilityManager) this.f9443d.getSystemService("accessibility");
        if (i2 != 0) {
            return;
        }
        if (this.f9443d.getResources().getConfiguration().orientation == 2) {
            this.f9444e.setMinimumHeight(c.a(this.f9443d));
            this.f9444e.f9446c.setGravity(17);
            return;
        }
        this.f9444e.setPadding(0, c.b(this.f9443d), 0, 0);
        this.f9444e.setMinimumHeight((c.a(this.f9443d) / 2) + c.b(this.f9443d));
    }

    @NonNull
    public static TSnackbar A(@NonNull View view, @NonNull CharSequence charSequence, int i2) {
        TSnackbar tSnackbar = new TSnackbar(m(view), 0);
        tSnackbar.L(charSequence);
        tSnackbar.K(i2);
        return tSnackbar;
    }

    @NonNull
    public static TSnackbar B(@NonNull Fragment fragment, @StringRes int i2, int i3) {
        return A(s(fragment), fragment.getResources().getText(i2), i3);
    }

    public static TSnackbar C(@NonNull Fragment fragment, @NonNull CharSequence charSequence, int i2) {
        return A(s(fragment), charSequence, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(int i2) {
        d.e().l(this.i);
        if (this.g == null) {
            ViewParent parent = this.f9444e.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f9444e);
                return;
            }
            return;
        }
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        d.e().m(this.i);
        if (this.g != null) {
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean M() {
        return !this.h.isEnabled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        Animation animation;
        if (this.f9441b == 0) {
            animation = o();
        } else {
            animation = n();
        }
        animation.setInterpolator(b.f9457b);
        animation.setDuration(250L);
        animation.setAnimationListener(new i());
        this.f9444e.startAnimation(animation);
    }

    private void k(int i2) {
        Animation animation;
        if (this.f9441b == 0) {
            animation = q();
        } else {
            animation = p();
        }
        animation.setInterpolator(b.f9457b);
        animation.setDuration(250L);
        animation.setAnimationListener(new a(i2));
        this.f9444e.startAnimation(animation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i2) {
        d.e().d(this.i, i2);
    }

    private static ViewGroup m(View view) {
        ViewGroup viewGroup = null;
        while (!(view instanceof CoordinatorLayout)) {
            if (view instanceof FrameLayout) {
                if (view.getId() == 16908290) {
                    return (ViewGroup) view;
                }
                viewGroup = (ViewGroup) view;
            }
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent instanceof View) {
                    view = (View) parent;
                    continue;
                } else {
                    view = null;
                    continue;
                }
            }
            if (view == null) {
                return viewGroup;
            }
        }
        return (ViewGroup) view;
    }

    private Animation n() {
        return AnimationUtils.loadAnimation(this.f9444e.getContext(), R.anim.design_snackbar_in);
    }

    private Animation o() {
        return AnimationUtils.loadAnimation(this.f9444e.getContext(), R.anim.snackbar_top_in);
    }

    private Animation p() {
        return AnimationUtils.loadAnimation(this.f9444e.getContext(), R.anim.design_snackbar_out);
    }

    private Animation q() {
        return AnimationUtils.loadAnimation(this.f9444e.getContext(), R.anim.snackbar_top_out);
    }

    public static ViewGroup r(Activity activity) {
        return (ViewGroup) activity.findViewById(16908290).getRootView();
    }

    public static ViewGroup s(Fragment fragment) {
        return r(fragment.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public /* synthetic */ void w(View.OnClickListener onClickListener, View view) {
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        l(1);
    }

    @NonNull
    public static TSnackbar x(@NonNull Activity activity, @StringRes int i2, int i3) {
        return A(r(activity), activity.getResources().getText(i2), i3);
    }

    public static TSnackbar y(@NonNull Activity activity, @NonNull CharSequence charSequence, int i2) {
        return A(r(activity), charSequence, i2);
    }

    @NonNull
    public static TSnackbar z(@NonNull View view, @StringRes int i2, int i3) {
        return A(view, view.getResources().getText(i2), i3);
    }

    @NonNull
    public TSnackbar F(@StringRes int i2, View.OnClickListener onClickListener) {
        return H(this.f9443d.getText(i2), onClickListener);
    }

    @NonNull
    public TSnackbar G(Drawable drawable, final View.OnClickListener onClickListener) {
        TextView actionView = this.f9444e.getActionView();
        if (drawable == null) {
            actionView.setVisibility(8);
            actionView.setOnClickListener(null);
        } else {
            actionView.setVisibility(0);
            actionView.setBackground(drawable);
            actionView.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.widget.topsnackbar.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TSnackbar.this.w(onClickListener, view);
                }
            });
        }
        return this;
    }

    @NonNull
    public TSnackbar H(CharSequence charSequence, View.OnClickListener onClickListener) {
        TextView actionView = this.f9444e.getActionView();
        if (TextUtils.isEmpty(charSequence) || onClickListener == null) {
            actionView.setVisibility(8);
            actionView.setOnClickListener(null);
        } else {
            actionView.setVisibility(0);
            actionView.setText(charSequence);
            actionView.setOnClickListener(new c(onClickListener));
        }
        return this;
    }

    @NonNull
    public TSnackbar I(@ColorInt int i2) {
        this.f9444e.getActionView().setTextColor(i2);
        return this;
    }

    public TSnackbar J(@ColorInt int i2) {
        this.f9444e.setBackgroundColor(i2);
        return this;
    }

    @NonNull
    public TSnackbar K(int i2) {
        this.f9445f = i2;
        return this;
    }

    @NonNull
    public TSnackbar L(@NonNull CharSequence charSequence) {
        this.f9444e.getMessageView().setText(charSequence);
        return this;
    }

    public void N() {
        d.e().p(this.f9445f, this.i);
    }

    final void O() {
        if (this.f9444e.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.f9444e.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                j jVar = new j();
                jVar.setStartAlphaSwipeDistance(0.1f);
                jVar.setEndAlphaSwipeDistance(0.6f);
                jVar.setSwipeDirection(0);
                jVar.setListener(new e());
                CoordinatorLayout.LayoutParams layoutParams2 = (CoordinatorLayout.LayoutParams) layoutParams;
                layoutParams2.setBehavior(jVar);
                layoutParams2.setMargins(0, -30, 0, 0);
            }
            this.f9442c.addView(this.f9444e);
        }
        if (ViewCompat.isLaidOut(this.f9444e)) {
            j();
        } else {
            this.f9444e.setOnLayoutChangeListener(new f());
        }
        this.f9444e.setOnAttachStateChangeListener(new g());
        if (!ViewCompat.isLaidOut(this.f9444e)) {
            this.f9444e.setOnLayoutChangeListener(new h());
        } else if (M()) {
            j();
        } else {
            E();
        }
    }

    final void t(int i2) {
        if (!M() || this.f9444e.getVisibility() != 0) {
            D(i2);
        } else {
            k(i2);
        }
    }

    public boolean u() {
        return d.e().h(this.i);
    }
}
