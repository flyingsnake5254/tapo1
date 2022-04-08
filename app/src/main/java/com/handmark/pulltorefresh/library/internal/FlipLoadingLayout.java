package com.handmark.pulltorefresh.library.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.tplink.libtpcontrols.r0;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public class FlipLoadingLayout extends LoadingLayout {
    private final Animation J3;
    private final Animation K3;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
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

    public FlipLoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        float f2 = mode == PullToRefreshBase.Mode.PULL_FROM_START ? -180 : 180;
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, f2, 1, 0.5f, 1, 0.5f);
        this.J3 = rotateAnimation;
        Interpolator interpolator = LoadingLayout.f5045c;
        rotateAnimation.setInterpolator(interpolator);
        rotateAnimation.setDuration(150L);
        rotateAnimation.setFillAfter(true);
        RotateAnimation rotateAnimation2 = new RotateAnimation(f2, 0.0f, 1, 0.5f, 1, 0.5f);
        this.K3 = rotateAnimation2;
        rotateAnimation2.setInterpolator(interpolator);
        rotateAnimation2.setDuration(150L);
        rotateAnimation2.setFillAfter(true);
    }

    private float getDrawableRotationAngle() {
        int i = a.a[this.p1.ordinal()];
        return i != 1 ? (i == 2 && this.p2 == PullToRefreshBase.Orientation.HORIZONTAL) ? 270.0f : 0.0f : this.p2 == PullToRefreshBase.Orientation.HORIZONTAL ? 90.0f : 180.0f;
    }

    @Override // com.handmark.pulltorefresh.library.internal.LoadingLayout
    protected void b(Drawable drawable) {
        if (drawable != null) {
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            ViewGroup.LayoutParams layoutParams = this.f5047f.getLayoutParams();
            int max = Math.max(intrinsicHeight, intrinsicWidth);
            layoutParams.height = max;
            layoutParams.width = max;
            this.f5047f.requestLayout();
            this.f5047f.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate((layoutParams.width - intrinsicWidth) / 2.0f, (layoutParams.height - intrinsicHeight) / 2.0f);
            matrix.postRotate(getDrawableRotationAngle(), layoutParams.width / 2.0f, layoutParams.height / 2.0f);
            this.f5047f.setImageMatrix(matrix);
        }
    }

    @Override // com.handmark.pulltorefresh.library.internal.LoadingLayout
    protected void d(float f2) {
    }

    @Override // com.handmark.pulltorefresh.library.internal.LoadingLayout
    protected void f() {
        if (this.J3 == this.f5047f.getAnimation()) {
            this.f5047f.startAnimation(this.K3);
        }
    }

    @Override // com.handmark.pulltorefresh.library.internal.LoadingLayout
    protected int getDefaultDrawableResId() {
        return r0.default_ptr_flip;
    }

    @Override // com.handmark.pulltorefresh.library.internal.LoadingLayout
    protected void h() {
        this.f5047f.clearAnimation();
        this.f5047f.setVisibility(4);
        this.q.setVisibility(0);
    }

    @Override // com.handmark.pulltorefresh.library.internal.LoadingLayout
    protected void j() {
        this.f5047f.startAnimation(this.J3);
    }

    @Override // com.handmark.pulltorefresh.library.internal.LoadingLayout
    protected void l() {
        this.f5047f.clearAnimation();
        this.q.setVisibility(8);
        this.f5047f.setVisibility(0);
    }
}
