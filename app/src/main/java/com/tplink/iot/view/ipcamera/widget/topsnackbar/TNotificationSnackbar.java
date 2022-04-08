package com.tplink.iot.view.ipcamera.widget.topsnackbar;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.tplink.iot.R;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.d;

/* loaded from: classes2.dex */
public final class TNotificationSnackbar {
    private static final Handler a = new Handler(Looper.getMainLooper(), new c());

    /* renamed from: b  reason: collision with root package name */
    private int f9427b;

    /* renamed from: c  reason: collision with root package name */
    private ViewGroup f9428c;

    /* renamed from: d  reason: collision with root package name */
    private Context f9429d;

    /* renamed from: e  reason: collision with root package name */
    private SnackbarLayout f9430e;

    /* renamed from: f  reason: collision with root package name */
    private int f9431f;
    private l g;
    private AccessibilityManager h;
    private final d.b i = new f();

    /* loaded from: classes2.dex */
    public static class SnackbarLayout extends LinearLayout {
        private b H3;
        private a I3;

        /* renamed from: c  reason: collision with root package name */
        private TextView f9432c;

        /* renamed from: d  reason: collision with root package name */
        private TextView f9433d;

        /* renamed from: f  reason: collision with root package name */
        private ImageView f9434f;
        private float p0;
        private boolean p1;
        private c p2;
        private final int p3;
        private TextView q;
        private int x;
        private int y;
        private float z;

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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public interface c {
            void a();
        }

        public SnackbarLayout(Context context) {
            this(context, null);
        }

        View getCardView() {
            return this;
        }

        TextView getContentView() {
            return this.f9433d;
        }

        ImageView getImageView() {
            return this.f9434f;
        }

        TextView getMessageView() {
            return this.f9432c;
        }

        TextView getTimeView() {
            return this.q;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            a aVar = this.I3;
            if (aVar != null) {
                aVar.onViewAttachedToWindow(this);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            a aVar = this.I3;
            if (aVar != null) {
                aVar.onViewDetachedFromWindow(this);
            }
        }

        @Override // android.view.View
        protected void onFinishInflate() {
            super.onFinishInflate();
            this.f9432c = (TextView) findViewById(R.id.snackbar_text);
            this.f9433d = (TextView) findViewById(R.id.snackbar_content);
            this.f9434f = (ImageView) findViewById(R.id.snackbar_image);
            this.q = (TextView) findViewById(R.id.snackbar_time);
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            b bVar;
            super.onLayout(z, i, i2, i3, i4);
            if (z && (bVar = this.H3) != null) {
                bVar.onLayoutChange(this, i, i2, i3, i4);
            }
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            c cVar;
            c cVar2;
            int action = motionEvent.getAction();
            if (action == 0) {
                this.z = motionEvent.getY();
                this.p1 = false;
            } else if (action != 1) {
                if (action == 2) {
                    float y = motionEvent.getY();
                    this.p0 = y;
                    if (this.z - y > 20.0f) {
                        if (!this.p1 && (cVar2 = this.p2) != null) {
                            this.p1 = true;
                            cVar2.a();
                        }
                        return true;
                    }
                }
            } else if (this.z - this.p0 > 20.0f) {
                if (!this.p1 && (cVar = this.p2) != null) {
                    this.p1 = true;
                    cVar.a();
                }
                return true;
            }
            return super.onTouchEvent(motionEvent);
        }

        @Override // android.view.View
        protected void onWindowVisibilityChanged(int i) {
            a aVar;
            super.onWindowVisibilityChanged(i);
            if (i != 4 && (aVar = this.I3) != null) {
                aVar.onViewDetachedFromWindow(this);
            }
        }

        void setOnAttachStateChangeListener(a aVar) {
            this.I3 = aVar;
        }

        void setOnLayoutChangeListener(b bVar) {
            this.H3 = bVar;
        }

        public void setOnSwipeListener(c cVar) {
            this.p2 = cVar;
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.p1 = false;
            this.p3 = 20;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tplink.iot.b.SnackbarLayout);
            this.x = obtainStyledAttributes.getDimensionPixelSize(0, -1);
            this.y = obtainStyledAttributes.getDimensionPixelSize(7, -1);
            if (obtainStyledAttributes.hasValue(6)) {
                ViewCompat.setElevation(this, obtainStyledAttributes.getDimensionPixelSize(6, 0));
            }
            obtainStyledAttributes.recycle();
            setClickable(true);
            LayoutInflater.from(context).inflate(R.layout.view_tsnackbar_notification_layout_include, this);
            ViewCompat.setAccessibilityLiveRegion(this, 1);
            ViewCompat.setImportantForAccessibility(this, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            TNotificationSnackbar.this.x();
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
    public class b implements Animation.AnimationListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f9436c;

        b(int i) {
            this.f9436c = i;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            TNotificationSnackbar.this.w(this.f9436c);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes2.dex */
    static class c implements Handler.Callback {
        c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                ((TNotificationSnackbar) message.obj).H();
                return true;
            } else if (i != 1) {
                return false;
            } else {
                ((TNotificationSnackbar) message.obj).s(message.arg1);
                return true;
            }
        }
    }

    /* loaded from: classes2.dex */
    class d implements View.OnClickListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f9438c;

        d(View.OnClickListener onClickListener) {
            this.f9438c = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            View.OnClickListener onClickListener = this.f9438c;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            TNotificationSnackbar.this.l(1);
        }
    }

    /* loaded from: classes2.dex */
    class e implements SnackbarLayout.c {
        e() {
        }

        @Override // com.tplink.iot.view.ipcamera.widget.topsnackbar.TNotificationSnackbar.SnackbarLayout.c
        public void a() {
            TNotificationSnackbar.this.l(0);
        }
    }

    /* loaded from: classes2.dex */
    class f implements d.b {
        f() {
        }

        @Override // com.tplink.iot.view.ipcamera.widget.topsnackbar.d.b
        public String content() {
            return TNotificationSnackbar.this.f9430e.f9432c.getText().toString();
        }

        @Override // com.tplink.iot.view.ipcamera.widget.topsnackbar.d.b
        public void dismiss(int i) {
            TNotificationSnackbar.a.sendMessage(TNotificationSnackbar.a.obtainMessage(1, i, 0, TNotificationSnackbar.this));
        }

        @Override // com.tplink.iot.view.ipcamera.widget.topsnackbar.d.b
        public View getParentView() {
            return TNotificationSnackbar.this.f9428c;
        }

        @Override // com.tplink.iot.view.ipcamera.widget.topsnackbar.d.b
        public void show() {
            TNotificationSnackbar.a.sendMessage(TNotificationSnackbar.a.obtainMessage(0, TNotificationSnackbar.this));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class g implements SwipeDismissBehavior.OnDismissListener {
        g() {
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.OnDismissListener
        public void onDismiss(View view) {
            view.setVisibility(8);
            TNotificationSnackbar.this.l(0);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.OnDismissListener
        public void onDragStateChanged(int i) {
            if (i == 0) {
                d.e().n(TNotificationSnackbar.this.i);
            } else if (i == 1 || i == 2) {
                d.e().c(TNotificationSnackbar.this.i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class h implements SnackbarLayout.b {
        h() {
        }

        @Override // com.tplink.iot.view.ipcamera.widget.topsnackbar.TNotificationSnackbar.SnackbarLayout.b
        public void onLayoutChange(View view, int i, int i2, int i3, int i4) {
            TNotificationSnackbar.this.j();
            TNotificationSnackbar.this.f9430e.setOnLayoutChangeListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class i implements SnackbarLayout.a {

        /* loaded from: classes2.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                TNotificationSnackbar.this.w(3);
            }
        }

        i() {
        }

        @Override // com.tplink.iot.view.ipcamera.widget.topsnackbar.TNotificationSnackbar.SnackbarLayout.a
        public void onViewAttachedToWindow(View view) {
        }

        @Override // com.tplink.iot.view.ipcamera.widget.topsnackbar.TNotificationSnackbar.SnackbarLayout.a
        public void onViewDetachedFromWindow(View view) {
            if (TNotificationSnackbar.this.t()) {
                TNotificationSnackbar.a.post(new a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class j implements SnackbarLayout.b {
        j() {
        }

        @Override // com.tplink.iot.view.ipcamera.widget.topsnackbar.TNotificationSnackbar.SnackbarLayout.b
        public void onLayoutChange(View view, int i, int i2, int i3, int i4) {
            TNotificationSnackbar.this.f9430e.setOnLayoutChangeListener(null);
            if (TNotificationSnackbar.this.F()) {
                TNotificationSnackbar.this.j();
            } else {
                TNotificationSnackbar.this.x();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class k extends SwipeDismissBehavior<SnackbarLayout> {
        k() {
        }

        /* renamed from: a */
        public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, SnackbarLayout snackbarLayout, MotionEvent motionEvent) {
            if (coordinatorLayout.isPointInChildBounds(snackbarLayout, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked == 0) {
                    d.e().c(TNotificationSnackbar.this.i);
                } else if (actionMasked == 1 || actionMasked == 3) {
                    d.e().n(TNotificationSnackbar.this.i);
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
    public static abstract class l {
        public void a(TNotificationSnackbar tNotificationSnackbar, int i) {
        }

        public void b(TNotificationSnackbar tNotificationSnackbar) {
        }
    }

    private TNotificationSnackbar(ViewGroup viewGroup, int i2) {
        this.f9427b = 0;
        this.f9427b = i2;
        this.f9428c = viewGroup;
        Context context = viewGroup.getContext();
        this.f9429d = context;
        LayoutInflater from = LayoutInflater.from(context);
        if (i2 == 1) {
            this.f9430e = (SnackbarLayout) from.inflate(R.layout.view_bsnackbar_notification_layout, this.f9428c, false);
        } else {
            this.f9430e = (SnackbarLayout) from.inflate(R.layout.view_tsnackbar_notification_layout, this.f9428c, false);
        }
        this.h = (AccessibilityManager) this.f9429d.getSystemService("accessibility");
        if (i2 != 0) {
            return;
        }
        if (this.f9429d.getResources().getConfiguration().orientation == 2) {
            this.f9430e.setMinimumHeight(c.a(this.f9429d));
            this.f9430e.f9432c.setGravity(17);
            return;
        }
        this.f9430e.setPadding(0, c.b(this.f9429d), 0, 0);
        this.f9430e.setMinimumHeight((c.a(this.f9429d) / 2) + c.b(this.f9429d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean F() {
        return !this.h.isEnabled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        Animation animation;
        if (this.f9427b == 0) {
            animation = o();
        } else {
            animation = n();
        }
        animation.setInterpolator(b.f9457b);
        animation.setDuration(250L);
        animation.setAnimationListener(new a());
        this.f9430e.startAnimation(animation);
    }

    private void k(int i2) {
        Animation animation;
        if (this.f9427b == 0) {
            animation = q();
        } else {
            animation = p();
        }
        animation.setInterpolator(b.f9457b);
        animation.setDuration(250L);
        animation.setAnimationListener(new b(i2));
        this.f9430e.startAnimation(animation);
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
        return AnimationUtils.loadAnimation(this.f9430e.getContext(), R.anim.design_snackbar_in);
    }

    private Animation o() {
        return AnimationUtils.loadAnimation(this.f9430e.getContext(), R.anim.snackbar_top_in);
    }

    private Animation p() {
        return AnimationUtils.loadAnimation(this.f9430e.getContext(), R.anim.design_snackbar_out);
    }

    private Animation q() {
        return AnimationUtils.loadAnimation(this.f9430e.getContext(), R.anim.snackbar_top_out);
    }

    public static ViewGroup r(Activity activity) {
        return (ViewGroup) activity.findViewById(16908290).getRootView();
    }

    public static TNotificationSnackbar u(@NonNull Activity activity, @NonNull CharSequence charSequence, int i2) {
        return v(r(activity), charSequence, i2);
    }

    @NonNull
    public static TNotificationSnackbar v(@NonNull View view, @NonNull CharSequence charSequence, int i2) {
        TNotificationSnackbar tNotificationSnackbar = new TNotificationSnackbar(m(view), 0);
        tNotificationSnackbar.E(charSequence);
        tNotificationSnackbar.B(i2);
        return tNotificationSnackbar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(int i2) {
        d.e().l(this.i);
        l lVar = this.g;
        if (lVar != null) {
            lVar.a(this, i2);
        }
        ViewParent parent = this.f9430e.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f9430e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        d.e().m(this.i);
        l lVar = this.g;
        if (lVar != null) {
            lVar.b(this);
        }
    }

    @NonNull
    public TNotificationSnackbar A(@NonNull CharSequence charSequence) {
        this.f9430e.getContentView().setText(charSequence);
        return this;
    }

    @NonNull
    public TNotificationSnackbar B(int i2) {
        this.f9431f = i2;
        return this;
    }

    @NonNull
    public TNotificationSnackbar C(Bitmap bitmap) {
        ImageView imageView = this.f9430e.getImageView();
        if (bitmap != null) {
            imageView.setVisibility(0);
            imageView.setImageBitmap(bitmap);
        } else {
            imageView.setVisibility(8);
        }
        return this;
    }

    public TNotificationSnackbar D(boolean z) {
        if (z) {
            this.f9430e.setOnSwipeListener(new e());
        }
        return this;
    }

    @NonNull
    public TNotificationSnackbar E(@NonNull CharSequence charSequence) {
        this.f9430e.getMessageView().setText(charSequence);
        return this;
    }

    public void G() {
        d.e().p(this.f9431f, this.i);
    }

    final void H() {
        if (this.f9430e.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.f9430e.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                k kVar = new k();
                kVar.setStartAlphaSwipeDistance(0.1f);
                kVar.setEndAlphaSwipeDistance(0.6f);
                kVar.setSwipeDirection(0);
                kVar.setListener(new g());
                CoordinatorLayout.LayoutParams layoutParams2 = (CoordinatorLayout.LayoutParams) layoutParams;
                layoutParams2.setBehavior(kVar);
                layoutParams2.setMargins(0, -30, 0, 0);
            }
            this.f9428c.addView(this.f9430e);
        }
        if (ViewCompat.isLaidOut(this.f9430e)) {
            j();
        } else {
            this.f9430e.setOnLayoutChangeListener(new h());
        }
        this.f9430e.setOnAttachStateChangeListener(new i());
        if (!ViewCompat.isLaidOut(this.f9430e)) {
            this.f9430e.setOnLayoutChangeListener(new j());
        } else if (F()) {
            j();
        } else {
            x();
        }
    }

    final void s(int i2) {
        if (!F() || this.f9430e.getVisibility() != 0) {
            w(i2);
        } else {
            k(i2);
        }
    }

    public boolean t() {
        return d.e().h(this.i);
    }

    @NonNull
    public TNotificationSnackbar y(l lVar) {
        this.g = lVar;
        return this;
    }

    @NonNull
    public TNotificationSnackbar z(View.OnClickListener onClickListener) {
        this.f9430e.getCardView().setOnClickListener(new d(onClickListener));
        return this;
    }
}
