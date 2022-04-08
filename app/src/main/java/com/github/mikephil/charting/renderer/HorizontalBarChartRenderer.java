package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.buffer.HorizontalBarBuffer;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* loaded from: classes.dex */
public class HorizontalBarChartRenderer extends BarChartRenderer {
    private RectF mBarShadowRectBuffer = new RectF();

    public HorizontalBarChartRenderer(BarDataProvider barDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(barDataProvider, chartAnimator, viewPortHandler);
        this.mValuePaint.setTextAlign(Paint.Align.LEFT);
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
    protected void drawDataSet(Canvas canvas, IBarDataSet iBarDataSet, int i) {
        Transformer transformer = this.mChart.getTransformer(iBarDataSet.getAxisDependency());
        this.mBarBorderPaint.setColor(iBarDataSet.getBarBorderColor());
        this.mBarBorderPaint.setStrokeWidth(Utils.convertDpToPixel(iBarDataSet.getBarBorderWidth()));
        boolean z = true;
        boolean z2 = iBarDataSet.getBarBorderWidth() > 0.0f;
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        if (this.mChart.isDrawBarShadowEnabled()) {
            this.mShadowPaint.setColor(iBarDataSet.getBarShadowColor());
            float barWidth = this.mChart.getBarData().getBarWidth() / 2.0f;
            int min = Math.min((int) Math.ceil(iBarDataSet.getEntryCount() * phaseX), iBarDataSet.getEntryCount());
            for (int i2 = 0; i2 < min; i2++) {
                float x = ((BarEntry) iBarDataSet.getEntryForIndex(i2)).getX();
                RectF rectF = this.mBarShadowRectBuffer;
                rectF.top = x - barWidth;
                rectF.bottom = x + barWidth;
                transformer.rectValueToPixel(rectF);
                if (this.mViewPortHandler.isInBoundsTop(this.mBarShadowRectBuffer.bottom)) {
                    if (!this.mViewPortHandler.isInBoundsBottom(this.mBarShadowRectBuffer.top)) {
                        break;
                    }
                    this.mBarShadowRectBuffer.left = this.mViewPortHandler.contentLeft();
                    this.mBarShadowRectBuffer.right = this.mViewPortHandler.contentRight();
                    canvas.drawRect(this.mBarShadowRectBuffer, this.mShadowPaint);
                }
            }
        }
        BarBuffer barBuffer = this.mBarBuffers[i];
        barBuffer.setPhases(phaseX, phaseY);
        barBuffer.setDataSet(i);
        barBuffer.setInverted(this.mChart.isInverted(iBarDataSet.getAxisDependency()));
        barBuffer.setBarWidth(this.mChart.getBarData().getBarWidth());
        barBuffer.feed(iBarDataSet);
        transformer.pointValuesToPixel(barBuffer.buffer);
        if (iBarDataSet.getColors().size() != 1) {
            z = false;
        }
        if (z) {
            this.mRenderPaint.setColor(iBarDataSet.getColor());
        }
        for (int i3 = 0; i3 < barBuffer.size(); i3 += 4) {
            int i4 = i3 + 3;
            if (this.mViewPortHandler.isInBoundsTop(barBuffer.buffer[i4])) {
                int i5 = i3 + 1;
                if (this.mViewPortHandler.isInBoundsBottom(barBuffer.buffer[i5])) {
                    if (!z) {
                        this.mRenderPaint.setColor(iBarDataSet.getColor(i3 / 4));
                    }
                    float[] fArr = barBuffer.buffer;
                    int i6 = i3 + 2;
                    canvas.drawRect(fArr[i3], fArr[i5], fArr[i6], fArr[i4], this.mRenderPaint);
                    if (z2) {
                        float[] fArr2 = barBuffer.buffer;
                        canvas.drawRect(fArr2[i3], fArr2[i5], fArr2[i6], fArr2[i4], this.mBarBorderPaint);
                    }
                }
            } else {
                return;
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
    public void drawValue(Canvas canvas, String str, float f2, float f3, int i) {
        this.mValuePaint.setColor(i);
        canvas.drawText(str, f2, f3, this.mValuePaint);
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas canvas) {
        int i;
        MPPointF mPPointF;
        int i2;
        float[] fArr;
        int i3;
        float f2;
        float f3;
        BarEntry barEntry;
        int i4;
        if (isDrawingValuesAllowed(this.mChart)) {
            List dataSets = this.mChart.getBarData().getDataSets();
            float convertDpToPixel = Utils.convertDpToPixel(5.0f);
            boolean isDrawValueAboveBarEnabled = this.mChart.isDrawValueAboveBarEnabled();
            int i5 = 0;
            while (i5 < this.mChart.getBarData().getDataSetCount()) {
                IBarDataSet iBarDataSet = (IBarDataSet) dataSets.get(i5);
                if (!shouldDrawValues(iBarDataSet)) {
                    dataSets = dataSets;
                    i = i5;
                } else {
                    boolean isInverted = this.mChart.isInverted(iBarDataSet.getAxisDependency());
                    applyValueTextStyle(iBarDataSet);
                    float f4 = 2.0f;
                    float calcTextHeight = Utils.calcTextHeight(this.mValuePaint, "10") / 2.0f;
                    ValueFormatter valueFormatter = iBarDataSet.getValueFormatter();
                    BarBuffer barBuffer = this.mBarBuffers[i5];
                    float phaseY = this.mAnimator.getPhaseY();
                    MPPointF instance = MPPointF.getInstance(iBarDataSet.getIconsOffset());
                    instance.x = Utils.convertDpToPixel(instance.x);
                    instance.y = Utils.convertDpToPixel(instance.y);
                    if (!iBarDataSet.isStacked()) {
                        int i6 = 0;
                        while (i6 < barBuffer.buffer.length * this.mAnimator.getPhaseX()) {
                            float[] fArr2 = barBuffer.buffer;
                            int i7 = i6 + 1;
                            float f5 = (fArr2[i7] + fArr2[i6 + 3]) / f4;
                            if (!this.mViewPortHandler.isInBoundsTop(fArr2[i7])) {
                                break;
                            }
                            if (this.mViewPortHandler.isInBoundsX(barBuffer.buffer[i6]) && this.mViewPortHandler.isInBoundsBottom(barBuffer.buffer[i7])) {
                                BarEntry barEntry2 = (BarEntry) iBarDataSet.getEntryForIndex(i6 / 4);
                                float y = barEntry2.getY();
                                String barLabel = valueFormatter.getBarLabel(barEntry2);
                                float calcTextWidth = Utils.calcTextWidth(this.mValuePaint, barLabel);
                                float f6 = isDrawValueAboveBarEnabled ? convertDpToPixel : -(calcTextWidth + convertDpToPixel);
                                float f7 = isDrawValueAboveBarEnabled ? -(calcTextWidth + convertDpToPixel) : convertDpToPixel;
                                if (isInverted) {
                                    f6 = (-f6) - calcTextWidth;
                                    f7 = (-f7) - calcTextWidth;
                                }
                                if (iBarDataSet.isDrawValuesEnabled()) {
                                    i4 = i6;
                                    dataSets = dataSets;
                                    instance = instance;
                                    i5 = i5;
                                    barBuffer = barBuffer;
                                    calcTextHeight = calcTextHeight;
                                    valueFormatter = valueFormatter;
                                    drawValue(canvas, barLabel, barBuffer.buffer[i6 + 2] + (y >= 0.0f ? f6 : f7), f5 + calcTextHeight, iBarDataSet.getValueTextColor(i6 / 2));
                                } else {
                                    i4 = i6;
                                    dataSets = dataSets;
                                    calcTextHeight = calcTextHeight;
                                    instance = instance;
                                    valueFormatter = valueFormatter;
                                    i5 = i5;
                                    barBuffer = barBuffer;
                                }
                                if (barEntry2.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                    Drawable icon = barEntry2.getIcon();
                                    float f8 = barBuffer.buffer[i4 + 2];
                                    if (y < 0.0f) {
                                        f6 = f7;
                                    }
                                    Utils.drawImage(canvas, icon, (int) (f8 + f6 + instance.x), (int) (f5 + instance.y), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                                }
                            } else {
                                i4 = i6;
                                dataSets = dataSets;
                                i5 = i5;
                                calcTextHeight = calcTextHeight;
                                instance = instance;
                                barBuffer = barBuffer;
                                valueFormatter = valueFormatter;
                            }
                            i6 = i4 + 4;
                            f4 = 2.0f;
                        }
                        dataSets = dataSets;
                        i = i5;
                        mPPointF = instance;
                    } else {
                        dataSets = dataSets;
                        i = i5;
                        mPPointF = instance;
                        Transformer transformer = this.mChart.getTransformer(iBarDataSet.getAxisDependency());
                        int i8 = 0;
                        int i9 = 0;
                        while (i8 < iBarDataSet.getEntryCount() * this.mAnimator.getPhaseX()) {
                            BarEntry barEntry3 = (BarEntry) iBarDataSet.getEntryForIndex(i8);
                            int valueTextColor = iBarDataSet.getValueTextColor(i8);
                            float[] yVals = barEntry3.getYVals();
                            if (yVals == null) {
                                int i10 = i9 + 1;
                                if (!this.mViewPortHandler.isInBoundsTop(barBuffer.buffer[i10])) {
                                    break;
                                } else if (this.mViewPortHandler.isInBoundsX(barBuffer.buffer[i9]) && this.mViewPortHandler.isInBoundsBottom(barBuffer.buffer[i10])) {
                                    String barLabel2 = valueFormatter.getBarLabel(barEntry3);
                                    float calcTextWidth2 = Utils.calcTextWidth(this.mValuePaint, barLabel2);
                                    float f9 = isDrawValueAboveBarEnabled ? convertDpToPixel : -(calcTextWidth2 + convertDpToPixel);
                                    float f10 = isDrawValueAboveBarEnabled ? -(calcTextWidth2 + convertDpToPixel) : convertDpToPixel;
                                    if (isInverted) {
                                        f9 = (-f9) - calcTextWidth2;
                                        f10 = (-f10) - calcTextWidth2;
                                    }
                                    if (iBarDataSet.isDrawValuesEnabled()) {
                                        i2 = i8;
                                        fArr = yVals;
                                        barEntry = barEntry3;
                                        drawValue(canvas, barLabel2, barBuffer.buffer[i9 + 2] + (barEntry3.getY() >= 0.0f ? f9 : f10), barBuffer.buffer[i10] + calcTextHeight, valueTextColor);
                                    } else {
                                        barEntry = barEntry3;
                                        i2 = i8;
                                        fArr = yVals;
                                    }
                                    if (barEntry.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                        Drawable icon2 = barEntry.getIcon();
                                        float f11 = barBuffer.buffer[i9 + 2];
                                        if (barEntry.getY() < 0.0f) {
                                            f9 = f10;
                                        }
                                        Utils.drawImage(canvas, icon2, (int) (f11 + f9 + mPPointF.x), (int) (barBuffer.buffer[i10] + mPPointF.y), icon2.getIntrinsicWidth(), icon2.getIntrinsicHeight());
                                    }
                                }
                            } else {
                                i2 = i8;
                                fArr = yVals;
                                int length = fArr.length * 2;
                                float[] fArr3 = new float[length];
                                float f12 = -barEntry3.getNegativeSum();
                                int i11 = 0;
                                int i12 = 0;
                                float f13 = 0.0f;
                                while (i11 < length) {
                                    float f14 = fArr[i12];
                                    int i13 = (f14 > 0.0f ? 1 : (f14 == 0.0f ? 0 : -1));
                                    if (i13 == 0 && (f13 == 0.0f || f12 == 0.0f)) {
                                        f12 = f14;
                                        f12 = f12;
                                    } else if (i13 >= 0) {
                                        f13 += f14;
                                        f12 = f12;
                                        f12 = f13;
                                    } else {
                                        f12 -= f14;
                                    }
                                    fArr3[i11] = f12 * phaseY;
                                    i11 += 2;
                                    i12++;
                                }
                                transformer.pointValuesToPixel(fArr3);
                                int i14 = 0;
                                while (i14 < length) {
                                    float f15 = fArr[i14 / 2];
                                    String barStackedLabel = valueFormatter.getBarStackedLabel(f15, barEntry3);
                                    float calcTextWidth3 = Utils.calcTextWidth(this.mValuePaint, barStackedLabel);
                                    float f16 = isDrawValueAboveBarEnabled ? convertDpToPixel : -(calcTextWidth3 + convertDpToPixel);
                                    f16 = isDrawValueAboveBarEnabled ? -(calcTextWidth3 + convertDpToPixel) : convertDpToPixel;
                                    if (isInverted) {
                                        f16 = (-f16) - calcTextWidth3;
                                        f16 = (-f16) - calcTextWidth3;
                                    }
                                    boolean z = (f15 == 0.0f && f12 == 0.0f && f13 > 0.0f) || f15 < 0.0f;
                                    float f17 = fArr3[i14];
                                    if (z) {
                                    }
                                    float f18 = f17 + f16;
                                    float[] fArr4 = barBuffer.buffer;
                                    float f19 = (fArr4[i9 + 1] + fArr4[i9 + 3]) / 2.0f;
                                    if (!this.mViewPortHandler.isInBoundsTop(f19)) {
                                        break;
                                    }
                                    if (this.mViewPortHandler.isInBoundsX(f18) && this.mViewPortHandler.isInBoundsBottom(f19)) {
                                        if (iBarDataSet.isDrawValuesEnabled()) {
                                            f2 = f19;
                                            i3 = i14;
                                            fArr3 = fArr3;
                                            f3 = f18;
                                            drawValue(canvas, barStackedLabel, f18, f19 + calcTextHeight, valueTextColor);
                                        } else {
                                            f2 = f19;
                                            i3 = i14;
                                            fArr3 = fArr3;
                                            f3 = f18;
                                        }
                                        if (barEntry3.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                            Drawable icon3 = barEntry3.getIcon();
                                            Utils.drawImage(canvas, icon3, (int) (f3 + mPPointF.x), (int) (f2 + mPPointF.y), icon3.getIntrinsicWidth(), icon3.getIntrinsicHeight());
                                        }
                                    } else {
                                        i3 = i14;
                                        fArr3 = fArr3;
                                    }
                                    i14 = i3 + 2;
                                    length = length;
                                }
                            }
                            i9 = fArr == null ? i9 + 4 : i9 + (fArr.length * 4);
                            i8 = i2 + 1;
                        }
                    }
                    MPPointF.recycleInstance(mPPointF);
                }
                i5 = i + 1;
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
        BarData barData = this.mChart.getBarData();
        this.mBarBuffers = new HorizontalBarBuffer[barData.getDataSetCount()];
        for (int i = 0; i < this.mBarBuffers.length; i++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(i);
            this.mBarBuffers[i] = new HorizontalBarBuffer(iBarDataSet.getEntryCount() * 4 * (iBarDataSet.isStacked() ? iBarDataSet.getStackSize() : 1), barData.getDataSetCount(), iBarDataSet.isStacked());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public boolean isDrawingValuesAllowed(ChartInterface chartInterface) {
        return ((float) chartInterface.getData().getEntryCount()) < ((float) chartInterface.getMaxVisibleCount()) * this.mViewPortHandler.getScaleY();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
    public void prepareBarHighlight(float f2, float f3, float f4, float f5, Transformer transformer) {
        this.mBarRect.set(f3, f2 - f5, f4, f2 + f5);
        transformer.rectToPixelPhaseHorizontal(this.mBarRect, this.mAnimator.getPhaseY());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
    public void setHighlightDrawPos(Highlight highlight, RectF rectF) {
        highlight.setDraw(rectF.centerY(), rectF.right);
    }
}
