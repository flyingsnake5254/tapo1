package com.tplink.libtpcontrols.tppulltorefresh;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tplink.libtpcontrols.u0;
import com.tplink.libtpcontrols.x0;
import com.tplink.libtpcontrols.z0.d;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes3.dex */
public class TPPullToRefreshLayout extends RelativeLayout {
    private Timer H3;
    private d I3;
    private float J3;
    private float K3;
    private float L3;
    private boolean M3;
    private boolean N3;
    private int O3;
    private int P3;
    private ValueAnimator Q3;

    /* renamed from: c  reason: collision with root package name */
    private int f12431c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f12432d;

    /* renamed from: f  reason: collision with root package name */
    private float f12433f;
    private ImageView p0;
    private float p1;
    private d p2;
    private boolean p3;
    private float q;
    private float x;
    private float y;
    private TPCircleProgressBar z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements Animator.AnimatorListener {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            TPPullToRefreshLayout.this.z.g();
            TPPullToRefreshLayout tPPullToRefreshLayout = TPPullToRefreshLayout.this;
            tPPullToRefreshLayout.L3 = tPPullToRefreshLayout.J3;
            TPPullToRefreshLayout.this.requestLayout();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            TPPullToRefreshLayout.this.z.g();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b extends TimerTask {

        /* renamed from: c  reason: collision with root package name */
        Map<Integer, Integer> f12435c = null;

        b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (this.f12435c == null) {
                HashMap hashMap = new HashMap();
                this.f12435c = hashMap;
                TPPullToRefreshLayout tPPullToRefreshLayout = TPPullToRefreshLayout.this;
                tPPullToRefreshLayout.m(hashMap, tPPullToRefreshLayout);
                return;
            }
            HashMap hashMap2 = new HashMap();
            for (Map.Entry entry : hashMap2.entrySet()) {
                if (!((Integer) entry.getValue()).equals(this.f12435c.get(entry.getKey()))) {
                    this.f12435c = hashMap2;
                    return;
                }
            }
            if (TPPullToRefreshLayout.this.I3 != null) {
                TPPullToRefreshLayout.this.I3.a();
            }
            if (TPPullToRefreshLayout.this.H3 != null) {
                TPPullToRefreshLayout.this.H3.cancel();
                TPPullToRefreshLayout.this.H3 = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements Animator.AnimatorListener {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            TPPullToRefreshLayout.this.z.i();
            TPPullToRefreshLayout tPPullToRefreshLayout = TPPullToRefreshLayout.this;
            tPPullToRefreshLayout.L3 = -tPPullToRefreshLayout.O3;
            TPPullToRefreshLayout.this.requestLayout();
            TPPullToRefreshLayout.this.M3 = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            TPPullToRefreshLayout.this.z.i();
            TPPullToRefreshLayout.this.M3 = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public TPPullToRefreshLayout(@NonNull Context context) {
        this(context, null, -1);
    }

    private boolean j(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            return view.canScrollVertically(-1);
        }
        if (!(view instanceof AbsListView)) {
            return view.getScrollY() > 0;
        }
        AbsListView absListView = (AbsListView) view;
        return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
    }

    private boolean k(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (j(childAt)) {
                return true;
            }
            if ((childAt instanceof ViewGroup) && k((ViewGroup) childAt)) {
                return true;
            }
        }
        return false;
    }

    private int l(float f2) {
        return (int) ((f2 * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(Map<Integer, Integer> map, ViewGroup viewGroup) {
        map.put(Integer.valueOf(viewGroup.getId()), Integer.valueOf(viewGroup.getScrollY()));
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt != null && childAt.getId() == -1) {
                childAt.setId(View.generateViewId());
            }
            if (childAt instanceof ViewGroup) {
                m(map, (ViewGroup) childAt);
            }
        }
    }

    private void n() {
        if (this.L3 >= this.K3) {
            this.M3 = true;
            d dVar = this.p2;
            if (dVar != null) {
                dVar.onRefresh();
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this.L3, this.J3);
            ofFloat.setDuration((long) ((this.L3 - this.J3) * 0.6d));
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tplink.libtpcontrols.tppulltorefresh.a
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    TPPullToRefreshLayout.this.s(valueAnimator);
                }
            });
            ofFloat.start();
            ofFloat.addListener(new a());
            return;
        }
        o();
    }

    private void o() {
        ValueAnimator valueAnimator = this.Q3;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.L3, -this.O3);
        this.Q3 = ofFloat;
        ofFloat.setDuration(300L);
        this.Q3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tplink.libtpcontrols.tppulltorefresh.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                TPPullToRefreshLayout.this.u(valueAnimator2);
            }
        });
        this.Q3.addListener(new c());
        this.Q3.start();
    }

    private void p(Context context, AttributeSet attributeSet) {
        this.O3 = l(54.0f);
        this.P3 = l(24.0f);
        this.z = new TPCircleProgressBar(getContext());
        ImageView imageView = new ImageView(context);
        this.p0 = imageView;
        imageView.setImageResource(u0.loading_bg);
        if (Build.VERSION.SDK_INT >= 21) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, x0.TPPullToRefreshLayout);
            float dimension = obtainStyledAttributes.getDimension(x0.TPPullToRefreshLayout_progress_bar_elevation, 0.0f);
            this.z.setElevation(dimension);
            this.p0.setElevation(dimension);
            obtainStyledAttributes.recycle();
        }
        post(new Runnable() { // from class: com.tplink.libtpcontrols.tppulltorefresh.c
            @Override // java.lang.Runnable
            public final void run() {
                TPPullToRefreshLayout.this.w();
            }
        });
        this.f12431c = ViewConfiguration.get(context).getScaledTouchSlop();
        this.L3 = -this.O3;
        this.J3 = l(20.0f);
        this.K3 = l(24.0f);
    }

    private boolean q() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (!(childAt instanceof TPCircleProgressBar)) {
                if (j(childAt)) {
                    return false;
                }
                if ((childAt instanceof ViewGroup) && k((ViewGroup) childAt)) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public /* synthetic */ void s(ValueAnimator valueAnimator) {
        this.L3 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public /* synthetic */ void u(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.L3 = floatValue;
        TPCircleProgressBar tPCircleProgressBar = this.z;
        int i = this.O3;
        tPCircleProgressBar.setProgress((floatValue + i) / (this.K3 + i));
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public /* synthetic */ void w() {
        int i = this.O3;
        addView(this.p0, -1, new RelativeLayout.LayoutParams(i, i));
        int i2 = this.P3;
        addView(this.z, -1, new RelativeLayout.LayoutParams(i2, i2));
    }

    private void x(int i) {
        ImageView imageView = this.p0;
        if (imageView != null) {
            imageView.layout((getWidth() - this.p0.getWidth()) / 2, i, (getWidth() + this.p0.getWidth()) / 2, this.O3 + i);
        }
        TPCircleProgressBar tPCircleProgressBar = this.z;
        if (tPCircleProgressBar != null) {
            tPCircleProgressBar.layout((getWidth() - this.z.getWidth()) / 2, ((this.O3 - this.z.getHeight()) / 2) + i, (getWidth() + this.z.getWidth()) / 2, this.z.getHeight() + i + ((this.O3 - this.z.getHeight()) / 2));
        }
    }

    private void y() {
        Timer timer = this.H3;
        if (timer != null) {
            timer.cancel();
        }
        Timer timer2 = new Timer();
        this.H3 = timer2;
        timer2.schedule(new b(), 0L, 100L);
    }

    private void z() {
        Timer timer = this.H3;
        if (timer != null) {
            timer.cancel();
            this.H3 = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            d dVar = this.I3;
            if (dVar != null) {
                dVar.b();
                z();
            }
        } else if ((action == 1 || action == 3) && this.I3 != null) {
            y();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.M3 && this.p3) {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.f12432d = false;
            } else if (action != 0 && this.f12432d) {
                return true;
            } else {
                if (action != 0) {
                    if (action == 2 && q()) {
                        float y = motionEvent.getY();
                        float x = motionEvent.getX();
                        float f2 = y - this.q;
                        float f3 = x - this.f12433f;
                        float abs = Math.abs(f2);
                        if (abs > this.f12431c && f2 > 1.0f && abs > Math.abs(f3)) {
                            this.f12432d = true;
                        }
                    }
                } else if (q()) {
                    float y2 = motionEvent.getY();
                    this.y = y2;
                    this.q = y2;
                    float x2 = motionEvent.getX();
                    this.x = x2;
                    this.f12433f = x2;
                    this.f12432d = false;
                }
                return this.f12432d;
            }
        }
        return false;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f12432d) {
            float f2 = (this.q - this.y) * this.p1;
            int i5 = this.O3;
            float f3 = f2 - i5;
            this.L3 = f3;
            this.z.setProgress((f3 + i5) / (this.K3 + i5));
        }
        x((int) this.L3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001f, code lost:
        if (r0 != 3) goto L_0x009c;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            int r0 = r8.getAction()
            r1 = 0
            if (r0 != 0) goto L_0x000d
            int r0 = r8.getEdgeFlags()
            if (r0 != 0) goto L_0x0011
        L_0x000d:
            boolean r0 = r7.p3
            if (r0 != 0) goto L_0x0012
        L_0x0011:
            return r1
        L_0x0012:
            int r0 = r8.getAction()
            r2 = 1
            if (r0 == 0) goto L_0x0085
            if (r0 == r2) goto L_0x0079
            r3 = 2
            if (r0 == r3) goto L_0x0023
            r8 = 3
            if (r0 == r8) goto L_0x0079
            goto L_0x009c
        L_0x0023:
            boolean r0 = r7.N3
            if (r0 != 0) goto L_0x0065
            boolean r0 = r7.q()
            if (r0 == 0) goto L_0x0065
            float r0 = r8.getY()
            float r3 = r8.getX()
            float r4 = r7.q
            float r0 = r0 - r4
            float r4 = r7.f12433f
            float r3 = r3 - r4
            float r4 = java.lang.Math.abs(r0)
            int r5 = r7.f12431c
            float r5 = (float) r5
            r6 = 1065353216(0x3f800000, float:1.0)
            int r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r5 <= 0) goto L_0x0058
            int r5 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r5 <= 0) goto L_0x0058
            float r3 = java.lang.Math.abs(r3)
            int r3 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x0058
            r7.f12432d = r2
            r7.N3 = r2
        L_0x0058:
            int r3 = r7.f12431c
            float r3 = (float) r3
            int r3 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x0065
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 >= 0) goto L_0x0065
            r7.N3 = r2
        L_0x0065:
            boolean r0 = r7.f12432d
            if (r0 == 0) goto L_0x009c
            float r0 = r8.getY()
            r7.q = r0
            float r8 = r8.getX()
            r7.f12433f = r8
            r7.requestLayout()
            return r2
        L_0x0079:
            r7.N3 = r1
            boolean r8 = r7.f12432d
            if (r8 == 0) goto L_0x009c
            r7.f12432d = r1
            r7.n()
            return r2
        L_0x0085:
            boolean r0 = r7.q()
            if (r0 == 0) goto L_0x009c
            float r0 = r8.getY()
            r7.y = r0
            r7.q = r0
            float r8 = r8.getX()
            r7.x = r8
            r7.f12433f = r8
            return r2
        L_0x009c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.libtpcontrols.tppulltorefresh.TPPullToRefreshLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setOnRefreshListener(d dVar) {
        this.p2 = dVar;
    }

    public void setOnScrollListener(d dVar) {
        this.I3 = dVar;
    }

    public void setRefreshable(boolean z) {
        this.p3 = z;
    }

    public TPPullToRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public TPPullToRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        this.f12432d = false;
        this.z = null;
        this.p0 = null;
        this.p1 = 0.5f;
        this.p2 = null;
        this.p3 = true;
        this.H3 = null;
        this.I3 = null;
        this.J3 = 0.0f;
        this.K3 = 0.0f;
        this.L3 = 0.0f;
        this.M3 = false;
        this.N3 = false;
        this.O3 = 0;
        this.P3 = 0;
        this.Q3 = null;
        p(context, attributeSet);
    }
}
