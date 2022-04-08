package com.github.mikephil.charting.jobs;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class AnimatedZoomJob extends AnimatedViewPortJob implements Animator.AnimatorListener {
    private static ObjectPool<AnimatedZoomJob> pool = ObjectPool.create(8, new AnimatedZoomJob(null, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0));
    protected Matrix mOnAnimationUpdateMatrixBuffer = new Matrix();
    protected float xAxisRange;
    protected YAxis yAxis;
    protected float zoomCenterX;
    protected float zoomCenterY;
    protected float zoomOriginX;
    protected float zoomOriginY;

    @SuppressLint({"NewApi"})
    public AnimatedZoomJob(ViewPortHandler viewPortHandler, View view, Transformer transformer, YAxis yAxis, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long j) {
        super(viewPortHandler, f3, f4, transformer, view, f5, f6, j);
        this.zoomCenterX = f7;
        this.zoomCenterY = f8;
        this.zoomOriginX = f9;
        this.zoomOriginY = f10;
        this.animator.addListener(this);
        this.yAxis = yAxis;
        this.xAxisRange = f2;
    }

    public static AnimatedZoomJob getInstance(ViewPortHandler viewPortHandler, View view, Transformer transformer, YAxis yAxis, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long j) {
        AnimatedZoomJob animatedZoomJob = pool.get();
        animatedZoomJob.mViewPortHandler = viewPortHandler;
        animatedZoomJob.xValue = f3;
        animatedZoomJob.yValue = f4;
        animatedZoomJob.mTrans = transformer;
        animatedZoomJob.view = view;
        animatedZoomJob.xOrigin = f5;
        animatedZoomJob.yOrigin = f6;
        animatedZoomJob.yAxis = yAxis;
        animatedZoomJob.xAxisRange = f2;
        animatedZoomJob.resetAnimator();
        animatedZoomJob.animator.setDuration(j);
        return animatedZoomJob;
    }

    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    protected ObjectPool.Poolable instantiate() {
        return new AnimatedZoomJob(null, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L);
    }

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        ((BarLineChartBase) this.view).calculateOffsets();
        this.view.postInvalidate();
    }

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob, android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float f2 = this.xOrigin;
        float f3 = this.phase;
        float f4 = f2 + ((this.xValue - f2) * f3);
        float f5 = this.yOrigin;
        float f6 = f5 + ((this.yValue - f5) * f3);
        Matrix matrix = this.mOnAnimationUpdateMatrixBuffer;
        this.mViewPortHandler.setZoom(f4, f6, matrix);
        this.mViewPortHandler.refresh(matrix, this.view, false);
        float scaleY = this.yAxis.mAxisRange / this.mViewPortHandler.getScaleY();
        float scaleX = this.xAxisRange / this.mViewPortHandler.getScaleX();
        float[] fArr = this.pts;
        float f7 = this.zoomOriginX;
        float f8 = this.phase;
        fArr[0] = f7 + (((this.zoomCenterX - (scaleX / 2.0f)) - f7) * f8);
        float f9 = this.zoomOriginY;
        fArr[1] = f9 + (((this.zoomCenterY + (scaleY / 2.0f)) - f9) * f8);
        this.mTrans.pointValuesToPixel(fArr);
        this.mViewPortHandler.translate(this.pts, matrix);
        this.mViewPortHandler.refresh(matrix, this.view, true);
    }

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob
    public void recycleSelf() {
    }
}
