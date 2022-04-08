package com.tplink.libtpcontrols.expandable;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tplink.libtpcontrols.s0;
import com.tplink.libtpcontrols.t0;
import com.tplink.libtpcontrols.x0;

/* loaded from: classes3.dex */
public class ExpandableLayout extends RelativeLayout {

    /* renamed from: c  reason: collision with root package name */
    private Boolean f12210c;

    /* renamed from: d  reason: collision with root package name */
    private Boolean f12211d;

    /* renamed from: f  reason: collision with root package name */
    private Integer f12212f;
    private FrameLayout q;
    private FrameLayout x;
    private Animation y;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends Animation {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f12213c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f12214d;

        a(View view, int i) {
            this.f12213c = view;
            this.f12214d = i;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f2, Transformation transformation) {
            int i = (f2 > 1.0f ? 1 : (f2 == 1.0f ? 0 : -1));
            if (i == 0) {
                ExpandableLayout.this.f12211d = Boolean.TRUE;
            }
            this.f12213c.getLayoutParams().height = i == 0 ? -2 : (int) (this.f12214d * f2);
            this.f12213c.requestLayout();
        }

        @Override // android.view.animation.Animation
        public boolean willChangeBounds() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b extends Animation {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f12216c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f12217d;

        b(View view, int i) {
            this.f12216c = view;
            this.f12217d = i;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f2, Transformation transformation) {
            if (f2 == 1.0f) {
                this.f12216c.setVisibility(8);
                ExpandableLayout.this.f12211d = Boolean.FALSE;
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.f12216c.getLayoutParams();
            int i = this.f12217d;
            layoutParams.height = i - ((int) (i * f2));
            this.f12216c.requestLayout();
        }

        @Override // android.view.animation.Animation
        public boolean willChangeBounds() {
            return true;
        }
    }

    public ExpandableLayout(Context context) {
        super(context);
        Boolean bool = Boolean.FALSE;
        this.f12210c = bool;
        this.f12211d = bool;
    }

    private void b(View view) {
        b bVar = new b(view, view.getMeasuredHeight());
        this.y = bVar;
        bVar.setDuration(this.f12212f.intValue());
        view.startAnimation(this.y);
    }

    private void c(View view) {
        view.measure(-1, -2);
        int measuredHeight = view.getMeasuredHeight();
        view.getLayoutParams().height = 0;
        view.setVisibility(0);
        a aVar = new a(view, measuredHeight);
        this.y = aVar;
        aVar.setDuration(this.f12212f.intValue());
        view.startAnimation(this.y);
    }

    private void d(Context context, AttributeSet attributeSet) {
        View inflate = View.inflate(context, t0.view_expandable, this);
        this.x = (FrameLayout) inflate.findViewById(s0.view_expandable_headerlayout);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, x0.ExpandableLayout);
        int resourceId = obtainStyledAttributes.getResourceId(x0.ExpandableLayout_el_headerLayout, -1);
        int resourceId2 = obtainStyledAttributes.getResourceId(x0.ExpandableLayout_el_contentLayout, -1);
        this.q = (FrameLayout) inflate.findViewById(s0.view_expandable_contentLayout);
        if (resourceId == -1 || resourceId2 == -1) {
            throw new IllegalArgumentException("HeaderLayout and ContentLayout cannot be null!");
        } else if (!isInEditMode()) {
            this.f12212f = Integer.valueOf(obtainStyledAttributes.getInt(x0.ExpandableLayout_el_duration, getContext().getResources().getInteger(17694720)));
            View inflate2 = View.inflate(context, resourceId, null);
            inflate2.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.x.addView(inflate2);
            View inflate3 = View.inflate(context, resourceId2, null);
            inflate3.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.q.addView(inflate3);
            this.q.setVisibility(8);
            this.x.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.libtpcontrols.expandable.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExpandableLayout.this.f(view);
                }
            });
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void f(View view) {
        if (!this.f12210c.booleanValue()) {
            if (this.q.getVisibility() == 0) {
                b(this.q);
            } else {
                c(this.q);
            }
            this.f12210c = Boolean.TRUE;
            new Handler().postDelayed(new Runnable() { // from class: com.tplink.libtpcontrols.expandable.a
                @Override // java.lang.Runnable
                public final void run() {
                    ExpandableLayout.this.h();
                }
            }, this.f12212f.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void h() {
        this.f12210c = Boolean.FALSE;
    }

    public FrameLayout getContentLayout() {
        return this.q;
    }

    public FrameLayout getHeaderLayout() {
        return this.x;
    }

    @Override // android.view.ViewGroup
    public void setLayoutAnimationListener(Animation.AnimationListener animationListener) {
        this.y.setAnimationListener(animationListener);
    }

    public ExpandableLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Boolean bool = Boolean.FALSE;
        this.f12210c = bool;
        this.f12211d = bool;
        d(context, attributeSet);
    }

    public ExpandableLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Boolean bool = Boolean.FALSE;
        this.f12210c = bool;
        this.f12211d = bool;
        d(context, attributeSet);
    }
}
