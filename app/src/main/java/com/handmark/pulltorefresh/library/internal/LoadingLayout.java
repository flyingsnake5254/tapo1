package com.handmark.pulltorefresh.library.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.d;
import com.handmark.pulltorefresh.library.extras.TPPullToRefreshWheel;
import com.tplink.libtpcontrols.s0;
import com.tplink.libtpcontrols.t0;
import com.tplink.libtpcontrols.v0;
import com.tplink.libtpcontrols.x0;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public abstract class LoadingLayout extends FrameLayout implements d {

    /* renamed from: c  reason: collision with root package name */
    static final Interpolator f5045c = new LinearInterpolator();
    private CharSequence H3;
    private CharSequence I3;

    /* renamed from: d  reason: collision with root package name */
    private FrameLayout f5046d;

    /* renamed from: f  reason: collision with root package name */
    protected final ImageView f5047f;
    private final TextView p0;
    protected final PullToRefreshBase.Mode p1;
    protected final PullToRefreshBase.Orientation p2;
    private CharSequence p3;
    protected final ProgressBar q;
    private TPPullToRefreshWheel x;
    private boolean y;
    private final TextView z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f5048b;

        static {
            int[] iArr = new int[PullToRefreshBase.Mode.values().length];
            f5048b = iArr;
            try {
                iArr[PullToRefreshBase.Mode.PULL_FROM_END.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5048b[PullToRefreshBase.Mode.PULL_FROM_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[PullToRefreshBase.Orientation.values().length];
            a = iArr2;
            try {
                iArr2[PullToRefreshBase.Orientation.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[PullToRefreshBase.Orientation.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public LoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context);
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable;
        this.p1 = mode;
        this.p2 = orientation;
        if (a.a[orientation.ordinal()] != 1) {
            LayoutInflater.from(context).inflate(t0.pull_to_refresh_header_vertical, this);
        } else {
            LayoutInflater.from(context).inflate(t0.pull_to_refresh_header_horizontal, this);
        }
        FrameLayout frameLayout = (FrameLayout) findViewById(s0.fl_inner);
        this.f5046d = frameLayout;
        this.z = (TextView) frameLayout.findViewById(s0.pull_to_refresh_text);
        this.q = (ProgressBar) this.f5046d.findViewById(s0.pull_to_refresh_progress);
        this.p0 = (TextView) this.f5046d.findViewById(s0.pull_to_refresh_sub_text);
        this.f5047f = (ImageView) this.f5046d.findViewById(s0.pull_to_refresh_image);
        this.x = (TPPullToRefreshWheel) this.f5046d.findViewById(s0.pull_to_refresh_wheel);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f5046d.getLayoutParams();
        int[] iArr = a.f5048b;
        if (iArr[mode.ordinal()] != 1) {
            layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
            this.p3 = context.getString(v0.pull_to_refresh_pull_label);
            this.H3 = context.getString(v0.pull_to_refresh_refreshing_label);
            this.I3 = context.getString(v0.pull_to_refresh_release_label);
        } else {
            layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
            this.p3 = context.getString(v0.pull_to_refresh_from_bottom_pull_label);
            this.H3 = context.getString(v0.pull_to_refresh_from_bottom_refreshing_label);
            this.I3 = context.getString(v0.pull_to_refresh_from_bottom_release_label);
        }
        int i = x0.PullToRefresh_ptrHeaderBackground;
        if (typedArray.hasValue(i) && (drawable = typedArray.getDrawable(i)) != null) {
            c.b(this, drawable);
        }
        int i2 = x0.PullToRefresh_ptrHeaderTextAppearance;
        if (typedArray.hasValue(i2)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i2, typedValue);
            setTextAppearance(typedValue.data);
        }
        int i3 = x0.PullToRefresh_ptrSubHeaderTextAppearance;
        if (typedArray.hasValue(i3)) {
            TypedValue typedValue2 = new TypedValue();
            typedArray.getValue(i3, typedValue2);
            setSubTextAppearance(typedValue2.data);
        }
        int i4 = x0.PullToRefresh_ptrHeaderTextColor;
        if (typedArray.hasValue(i4) && (colorStateList2 = typedArray.getColorStateList(i4)) != null) {
            setTextColor(colorStateList2);
        }
        int i5 = x0.PullToRefresh_ptrHeaderSubTextColor;
        if (typedArray.hasValue(i5) && (colorStateList = typedArray.getColorStateList(i5)) != null) {
            setSubTextColor(colorStateList);
        }
        Drawable drawable2 = null;
        int i6 = x0.PullToRefresh_ptrDrawable;
        drawable2 = typedArray.hasValue(i6) ? typedArray.getDrawable(i6) : drawable2;
        if (iArr[mode.ordinal()] != 1) {
            int i7 = x0.PullToRefresh_ptrDrawableStart;
            if (typedArray.hasValue(i7)) {
                drawable2 = typedArray.getDrawable(i7);
            } else {
                int i8 = x0.PullToRefresh_ptrDrawableTop;
                if (typedArray.hasValue(i8)) {
                    b.a("ptrDrawableTop", "ptrDrawableStart");
                    drawable2 = typedArray.getDrawable(i8);
                }
            }
        } else {
            int i9 = x0.PullToRefresh_ptrDrawableEnd;
            if (typedArray.hasValue(i9)) {
                drawable2 = typedArray.getDrawable(i9);
            } else {
                int i10 = x0.PullToRefresh_ptrDrawableBottom;
                if (typedArray.hasValue(i10)) {
                    b.a("ptrDrawableBottom", "ptrDrawableEnd");
                    drawable2 = typedArray.getDrawable(i10);
                }
            }
        }
        setLoadingDrawable(drawable2 == null ? context.getResources().getDrawable(getDefaultDrawableResId()) : drawable2);
        k();
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.p0 == null) {
            return;
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.p0.setVisibility(8);
            return;
        }
        this.p0.setText(charSequence);
        if (8 == this.p0.getVisibility()) {
            this.p0.setVisibility(0);
        }
    }

    private void setSubTextAppearance(int i) {
        TextView textView = this.p0;
        if (textView != null) {
            textView.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        TextView textView = this.p0;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        TextView textView = this.z;
        if (textView != null) {
            textView.setTextAppearance(getContext(), i);
        }
        TextView textView2 = this.p0;
        if (textView2 != null) {
            textView2.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        TextView textView = this.z;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
        TextView textView2 = this.p0;
        if (textView2 != null) {
            textView2.setTextColor(colorStateList);
        }
    }

    public final void a() {
        if (this.z.getVisibility() == 0) {
            this.z.setVisibility(4);
        }
        if (this.q.getVisibility() == 0) {
            this.q.setVisibility(4);
        }
        if (this.f5047f.getVisibility() == 0) {
            this.f5047f.setVisibility(4);
        }
        if (this.p0.getVisibility() == 0) {
            this.p0.setVisibility(4);
        }
    }

    protected abstract void b(Drawable drawable);

    public final void c(float f2) {
        if (!this.y) {
            d(f2);
        }
        float f3 = (f2 - 0.6f) / 0.39999998f;
        TPPullToRefreshWheel tPPullToRefreshWheel = this.x;
        if (tPPullToRefreshWheel == null) {
            return;
        }
        if (f2 < 0.6f) {
            tPPullToRefreshWheel.setInstantProgress(0.0f);
        } else if (f2 > 1.0f) {
            tPPullToRefreshWheel.setInstantProgress(1.0f);
        } else {
            tPPullToRefreshWheel.setInstantProgress(f3);
        }
    }

    protected abstract void d(float f2);

    public final void e() {
        TextView textView = this.z;
        if (textView != null) {
            textView.setText(this.p3);
        }
        f();
    }

    protected abstract void f();

    public final void g() {
        TextView textView = this.z;
        if (textView != null) {
            textView.setText(this.H3);
        }
        if (this.y) {
            ((AnimationDrawable) this.f5047f.getDrawable()).start();
        } else {
            h();
        }
        TextView textView2 = this.p0;
        if (textView2 != null) {
            if (TextUtils.isEmpty(textView2.getText())) {
                this.p0.setVisibility(8);
            } else {
                this.p0.setVisibility(0);
            }
        }
        TPPullToRefreshWheel tPPullToRefreshWheel = this.x;
        if (tPPullToRefreshWheel != null) {
            tPPullToRefreshWheel.i();
        }
    }

    public final int getContentSize() {
        if (a.a[this.p2.ordinal()] != 1) {
            return this.f5046d.getHeight();
        }
        return this.f5046d.getWidth();
    }

    protected abstract int getDefaultDrawableResId();

    protected abstract void h();

    public final void i() {
        TextView textView = this.z;
        if (textView != null) {
            textView.setText(this.I3);
        }
        j();
    }

    protected abstract void j();

    public final void k() {
        TextView textView = this.z;
        if (textView != null) {
            textView.setText(this.p3);
        }
        this.f5047f.setVisibility(0);
        if (this.y) {
            ((AnimationDrawable) this.f5047f.getDrawable()).stop();
        } else {
            l();
        }
        TextView textView2 = this.p0;
        if (textView2 != null) {
            if (TextUtils.isEmpty(textView2.getText())) {
                this.p0.setVisibility(8);
            } else {
                this.p0.setVisibility(0);
            }
        }
        TPPullToRefreshWheel tPPullToRefreshWheel = this.x;
        if (tPPullToRefreshWheel != null) {
            tPPullToRefreshWheel.j();
        }
    }

    protected abstract void l();

    public final void m() {
        if (4 == this.z.getVisibility()) {
            this.z.setVisibility(0);
        }
        if (4 == this.q.getVisibility()) {
            this.q.setVisibility(0);
        }
        if (4 == this.f5047f.getVisibility()) {
            this.f5047f.setVisibility(0);
        }
        if (4 == this.p0.getVisibility()) {
            this.p0.setVisibility(0);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        Log.d("LoadingLayout", "loadinglayout onLayout innerLayout height = " + this.f5046d.getHeight());
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Log.d("LoadingLayout", "loadinglayout onMeasure innerLayout height = " + this.f5046d.getHeight());
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Log.d("LoadingLayout", "loadinglayout onSizeChanged innerLayout height = " + this.f5046d.getHeight());
    }

    public final void setHeaderWheelBarColor(int i) {
        TPPullToRefreshWheel tPPullToRefreshWheel = this.x;
        if (tPPullToRefreshWheel != null) {
            tPPullToRefreshWheel.setBarColor(i);
        }
    }

    public final void setHeight(int i) {
        getLayoutParams().height = i;
        requestLayout();
    }

    @Override // com.handmark.pulltorefresh.library.d
    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    @Override // com.handmark.pulltorefresh.library.d
    public final void setLoadingDrawable(Drawable drawable) {
        this.f5047f.setImageDrawable(drawable);
        this.y = drawable instanceof AnimationDrawable;
        b(drawable);
    }

    @Override // com.handmark.pulltorefresh.library.d
    public void setPullLabel(CharSequence charSequence) {
        this.p3 = charSequence;
    }

    @Override // com.handmark.pulltorefresh.library.d
    public void setRefreshingLabel(CharSequence charSequence) {
        this.H3 = charSequence;
    }

    @Override // com.handmark.pulltorefresh.library.d
    public void setReleaseLabel(CharSequence charSequence) {
        this.I3 = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.z.setTypeface(typeface);
    }

    public final void setWidth(int i) {
        getLayoutParams().width = i;
        requestLayout();
    }
}
