package com.tplink.iot.devices.trv.view.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.renderer.YAxisRenderer;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;
import kotlin.jvm.internal.j;

/* compiled from: TemperatureRecordChartYAxisRenderer.kt */
/* loaded from: classes2.dex */
public final class b extends YAxisRenderer {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(ViewPortHandler viewPortHandler, YAxis yAxis, Transformer trans) {
        super(viewPortHandler, yAxis, trans);
        j.e(viewPortHandler, "viewPortHandler");
        j.e(yAxis, "yAxis");
        j.e(trans, "trans");
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void renderAxisLabels(Canvas c2) {
        j.e(c2, "c");
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void renderLimitLines(Canvas c2) {
        j.e(c2, "c");
        YAxis mYAxis = this.mYAxis;
        j.d(mYAxis, "mYAxis");
        List<LimitLine> limitLines = mYAxis.getLimitLines();
        if (!(limitLines == null || limitLines.isEmpty())) {
            float[] fArr = this.mRenderLimitLinesBuffer;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            Path path = this.mRenderLimitLines;
            path.reset();
            int size = limitLines.size();
            for (int i = 0; i < size; i++) {
                LimitLine l = limitLines.get(i);
                j.d(l, "l");
                if (l.isEnabled()) {
                    int save = c2.save();
                    RectF rectF = this.mLimitLineClippingRect;
                    ViewPortHandler mViewPortHandler = this.mViewPortHandler;
                    j.d(mViewPortHandler, "mViewPortHandler");
                    rectF.set(mViewPortHandler.getContentRect());
                    this.mLimitLineClippingRect.inset(0.0f, -l.getLineWidth());
                    c2.clipRect(this.mLimitLineClippingRect);
                    Paint mLimitLinePaint = this.mLimitLinePaint;
                    j.d(mLimitLinePaint, "mLimitLinePaint");
                    mLimitLinePaint.setStyle(Paint.Style.STROKE);
                    Paint mLimitLinePaint2 = this.mLimitLinePaint;
                    j.d(mLimitLinePaint2, "mLimitLinePaint");
                    mLimitLinePaint2.setColor(l.getLineColor());
                    Paint mLimitLinePaint3 = this.mLimitLinePaint;
                    j.d(mLimitLinePaint3, "mLimitLinePaint");
                    mLimitLinePaint3.setStrokeWidth(l.getLineWidth());
                    Paint mLimitLinePaint4 = this.mLimitLinePaint;
                    j.d(mLimitLinePaint4, "mLimitLinePaint");
                    mLimitLinePaint4.setPathEffect(l.getDashPathEffect());
                    fArr[1] = l.getLimit();
                    this.mTrans.pointValuesToPixel(fArr);
                    path.moveTo(this.mViewPortHandler.contentLeft(), fArr[1]);
                    path.lineTo(this.mViewPortHandler.contentRight(), fArr[1]);
                    c2.drawPath(path, this.mLimitLinePaint);
                    c2.restoreToCount(save);
                    path.reset();
                    String label = l.getLabel();
                    if (label != null && (!j.a(label, ""))) {
                        Paint mLimitLinePaint5 = this.mLimitLinePaint;
                        j.d(mLimitLinePaint5, "mLimitLinePaint");
                        mLimitLinePaint5.setStyle(l.getTextStyle());
                        Paint mLimitLinePaint6 = this.mLimitLinePaint;
                        j.d(mLimitLinePaint6, "mLimitLinePaint");
                        mLimitLinePaint6.setPathEffect(null);
                        Paint mLimitLinePaint7 = this.mLimitLinePaint;
                        j.d(mLimitLinePaint7, "mLimitLinePaint");
                        mLimitLinePaint7.setColor(l.getTextColor());
                        Paint mLimitLinePaint8 = this.mLimitLinePaint;
                        j.d(mLimitLinePaint8, "mLimitLinePaint");
                        mLimitLinePaint8.setTypeface(l.getTypeface());
                        Paint mLimitLinePaint9 = this.mLimitLinePaint;
                        j.d(mLimitLinePaint9, "mLimitLinePaint");
                        mLimitLinePaint9.setStrokeWidth(0.5f);
                        Paint mLimitLinePaint10 = this.mLimitLinePaint;
                        j.d(mLimitLinePaint10, "mLimitLinePaint");
                        mLimitLinePaint10.setTextSize(l.getTextSize());
                        FSize calcTextSize = Utils.calcTextSize(this.mLimitLinePaint, label);
                        float contentLeft = (this.mViewPortHandler.contentLeft() - l.getXOffset()) - calcTextSize.width;
                        float f2 = fArr[1] + (calcTextSize.height / 2.0f);
                        Paint mLimitLinePaint11 = this.mLimitLinePaint;
                        j.d(mLimitLinePaint11, "mLimitLinePaint");
                        mLimitLinePaint11.setTextAlign(Paint.Align.LEFT);
                        c2.drawText(label, contentLeft, f2, this.mLimitLinePaint);
                    }
                }
            }
        }
    }
}
