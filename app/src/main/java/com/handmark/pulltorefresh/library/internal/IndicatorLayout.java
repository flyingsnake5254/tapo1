package com.handmark.pulltorefresh.library.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.tplink.libtpcontrols.l0;
import com.tplink.libtpcontrols.q0;
import com.tplink.libtpcontrols.r0;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public class IndicatorLayout extends FrameLayout implements Animation.AnimationListener {

    /* renamed from: c  reason: collision with root package name */
    private Animation f5042c;

    /* renamed from: d  reason: collision with root package name */
    private Animation f5043d;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f5044f;
    private final Animation q;
    private final Animation x;

    /* loaded from: classes2.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[PullToRefreshBase.Mode.values().length];
            a = iArr;
            try {
                iArr[PullToRefreshBase.Mode.PULL_FROM_END.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[PullToRefreshBase.Mode.PULL_FROM_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public IndicatorLayout(Context context, PullToRefreshBase.Mode mode) {
        super(context);
        int i;
        int i2;
        this.f5044f = new ImageView(context);
        Drawable drawable = getResources().getDrawable(r0.indicator_arrow);
        this.f5044f.setImageDrawable(drawable);
        int dimensionPixelSize = getResources().getDimensionPixelSize(q0.indicator_internal_padding);
        this.f5044f.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        addView(this.f5044f);
        if (a.a[mode.ordinal()] != 1) {
            i = l0.slide_in_from_top;
            i2 = l0.slide_out_to_top;
            setBackgroundResource(r0.indicator_bg_top);
        } else {
            i = l0.slide_in_from_bottom;
            int i3 = l0.slide_out_to_bottom;
            setBackgroundResource(r0.indicator_bg_bottom);
            this.f5044f.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.setRotate(180.0f, drawable.getIntrinsicWidth() / 2.0f, drawable.getIntrinsicHeight() / 2.0f);
            this.f5044f.setImageMatrix(matrix);
            i2 = i3;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(context, i);
        this.f5042c = loadAnimation;
        loadAnimation.setAnimationListener(this);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(context, i2);
        this.f5043d = loadAnimation2;
        loadAnimation2.setAnimationListener(this);
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        this.q = rotateAnimation;
        rotateAnimation.setInterpolator(linearInterpolator);
        rotateAnimation.setDuration(150L);
        rotateAnimation.setFillAfter(true);
        RotateAnimation rotateAnimation2 = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.x = rotateAnimation2;
        rotateAnimation2.setInterpolator(linearInterpolator);
        rotateAnimation2.setDuration(150L);
        rotateAnimation2.setFillAfter(true);
    }

    public void a() {
        startAnimation(this.f5043d);
    }

    public final boolean b() {
        Animation animation = getAnimation();
        return animation != null ? this.f5042c == animation : getVisibility() == 0;
    }

    public void c() {
        this.f5044f.startAnimation(this.x);
    }

    public void d() {
        this.f5044f.startAnimation(this.q);
    }

    public void e() {
        this.f5044f.clearAnimation();
        startAnimation(this.f5042c);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (animation == this.f5043d) {
            this.f5044f.clearAnimation();
            setVisibility(8);
        } else if (animation == this.f5042c) {
            setVisibility(0);
        }
        clearAnimation();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        setVisibility(0);
    }
}
