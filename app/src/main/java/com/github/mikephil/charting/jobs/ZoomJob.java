package com.github.mikephil.charting.jobs;

import android.graphics.Matrix;
import android.view.View;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* loaded from: classes.dex */
public class ZoomJob extends ViewPortJob {
    private static ObjectPool<ZoomJob> pool;
    protected YAxis.AxisDependency axisDependency;
    protected Matrix mRunMatrixBuffer = new Matrix();
    protected float scaleX;
    protected float scaleY;

    static {
        ObjectPool<ZoomJob> create = ObjectPool.create(1, new ZoomJob(null, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null));
        pool = create;
        create.setReplenishPercentage(0.5f);
    }

    public ZoomJob(ViewPortHandler viewPortHandler, float f2, float f3, float f4, float f5, Transformer transformer, YAxis.AxisDependency axisDependency, View view) {
        super(viewPortHandler, f4, f5, transformer, view);
        this.scaleX = f2;
        this.scaleY = f3;
        this.axisDependency = axisDependency;
    }

    public static ZoomJob getInstance(ViewPortHandler viewPortHandler, float f2, float f3, float f4, float f5, Transformer transformer, YAxis.AxisDependency axisDependency, View view) {
        ZoomJob zoomJob = pool.get();
        zoomJob.xValue = f4;
        zoomJob.yValue = f5;
        zoomJob.scaleX = f2;
        zoomJob.scaleY = f3;
        zoomJob.mViewPortHandler = viewPortHandler;
        zoomJob.mTrans = transformer;
        zoomJob.axisDependency = axisDependency;
        zoomJob.view = view;
        return zoomJob;
    }

    public static void recycleInstance(ZoomJob zoomJob) {
        pool.recycle((ObjectPool<ZoomJob>) zoomJob);
    }

    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    protected ObjectPool.Poolable instantiate() {
        return new ZoomJob(null, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null);
    }

    @Override // java.lang.Runnable
    public void run() {
        Matrix matrix = this.mRunMatrixBuffer;
        this.mViewPortHandler.zoom(this.scaleX, this.scaleY, matrix);
        this.mViewPortHandler.refresh(matrix, this.view, false);
        float scaleY = ((BarLineChartBase) this.view).getAxis(this.axisDependency).mAxisRange / this.mViewPortHandler.getScaleY();
        float scaleX = ((BarLineChartBase) this.view).getXAxis().mAxisRange / this.mViewPortHandler.getScaleX();
        float[] fArr = this.pts;
        fArr[0] = this.xValue - (scaleX / 2.0f);
        fArr[1] = this.yValue + (scaleY / 2.0f);
        this.mTrans.pointValuesToPixel(fArr);
        this.mViewPortHandler.translate(this.pts, matrix);
        this.mViewPortHandler.refresh(matrix, this.view, false);
        ((BarLineChartBase) this.view).calculateOffsets();
        this.view.postInvalidate();
        recycleInstance(this);
    }
}