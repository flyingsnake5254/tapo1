package com.handmark.pulltorefresh.library.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.tplink.libtpcontrols.r0;
import com.tplink.libtpcontrols.x0;

/* loaded from: classes2.dex */
public class RotateLoadingLayout extends LoadingLayout {
    private final Animation J3;
    private final Matrix K3;
    private float L3;
    private float M3;
    private final boolean N3;

    public RotateLoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.N3 = typedArray.getBoolean(x0.PullToRefresh_ptrRotateDrawableWhilePulling, true);
        this.f5047f.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        this.K3 = matrix;
        this.f5047f.setImageMatrix(matrix);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.J3 = rotateAnimation;
        rotateAnimation.setInterpolator(LoadingLayout.f5045c);
        rotateAnimation.setDuration(1200L);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setRepeatMode(1);
    }

    private void n() {
        Matrix matrix = this.K3;
        if (matrix != null) {
            matrix.reset();
            this.f5047f.setImageMatrix(this.K3);
        }
    }

    @Override // com.handmark.pulltorefresh.library.internal.LoadingLayout
    public void b(Drawable drawable) {
        if (drawable != null) {
            this.L3 = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.M3 = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.handmark.pulltorefresh.library.internal.LoadingLayout
    protected void d(float f2) {
        this.K3.setRotate(this.N3 ? f2 * 90.0f : Math.max(0.0f, Math.min(180.0f, (f2 * 360.0f) - 180.0f)), this.L3, this.M3);
        this.f5047f.setImageMatrix(this.K3);
    }

    @Override // com.handmark.pulltorefresh.library.internal.LoadingLayout
    protected void f() {
    }

    @Override // com.handmark.pulltorefresh.library.internal.LoadingLayout
    protected int getDefaultDrawableResId() {
        return r0.default_ptr_rotate;
    }

    @Override // com.handmark.pulltorefresh.library.internal.LoadingLayout
    protected void h() {
        this.f5047f.startAnimation(this.J3);
    }

    @Override // com.handmark.pulltorefresh.library.internal.LoadingLayout
    protected void j() {
    }

    @Override // com.handmark.pulltorefresh.library.internal.LoadingLayout
    protected void l() {
        this.f5047f.clearAnimation();
        n();
    }
}
