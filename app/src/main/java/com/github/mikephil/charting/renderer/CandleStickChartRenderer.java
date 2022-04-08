package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.CandleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet;
import com.github.mikephil.charting.renderer.BarLineScatterCandleBubbleRenderer;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* loaded from: classes.dex */
public class CandleStickChartRenderer extends LineScatterCandleRadarRenderer {
    protected CandleDataProvider mChart;
    private float[] mShadowBuffers = new float[8];
    private float[] mBodyBuffers = new float[4];
    private float[] mRangeBuffers = new float[4];
    private float[] mOpenBuffers = new float[4];
    private float[] mCloseBuffers = new float[4];

    public CandleStickChartRenderer(CandleDataProvider candleDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mChart = candleDataProvider;
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas canvas) {
        for (T t : this.mChart.getCandleData().getDataSets()) {
            if (t.isVisible()) {
                drawDataSet(canvas, t);
            }
        }
    }

    protected void drawDataSet(Canvas canvas, ICandleDataSet iCandleDataSet) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        Transformer transformer = this.mChart.getTransformer(iCandleDataSet.getAxisDependency());
        float phaseY = this.mAnimator.getPhaseY();
        float barSpace = iCandleDataSet.getBarSpace();
        boolean showCandleBar = iCandleDataSet.getShowCandleBar();
        this.mXBounds.set(this.mChart, iCandleDataSet);
        this.mRenderPaint.setStrokeWidth(iCandleDataSet.getShadowWidth());
        int i6 = this.mXBounds.min;
        while (true) {
            BarLineScatterCandleBubbleRenderer.XBounds xBounds = this.mXBounds;
            if (i6 <= xBounds.range + xBounds.min) {
                CandleEntry candleEntry = (CandleEntry) iCandleDataSet.getEntryForIndex(i6);
                if (candleEntry != null) {
                    float x = candleEntry.getX();
                    float open = candleEntry.getOpen();
                    float close = candleEntry.getClose();
                    float high = candleEntry.getHigh();
                    float low = candleEntry.getLow();
                    if (showCandleBar) {
                        float[] fArr = this.mShadowBuffers;
                        fArr[0] = x;
                        fArr[2] = x;
                        fArr[4] = x;
                        fArr[6] = x;
                        int i7 = (open > close ? 1 : (open == close ? 0 : -1));
                        if (i7 > 0) {
                            fArr[1] = high * phaseY;
                            fArr[3] = open * phaseY;
                            fArr[5] = low * phaseY;
                            fArr[7] = close * phaseY;
                        } else if (open < close) {
                            fArr[1] = high * phaseY;
                            fArr[3] = close * phaseY;
                            fArr[5] = low * phaseY;
                            fArr[7] = open * phaseY;
                        } else {
                            fArr[1] = high * phaseY;
                            fArr[3] = open * phaseY;
                            fArr[5] = low * phaseY;
                            fArr[7] = fArr[3];
                        }
                        transformer.pointValuesToPixel(fArr);
                        if (!iCandleDataSet.getShadowColorSameAsCandle()) {
                            Paint paint = this.mRenderPaint;
                            if (iCandleDataSet.getShadowColor() == 1122867) {
                                i2 = iCandleDataSet.getColor(i6);
                            } else {
                                i2 = iCandleDataSet.getShadowColor();
                            }
                            paint.setColor(i2);
                        } else if (i7 > 0) {
                            Paint paint2 = this.mRenderPaint;
                            if (iCandleDataSet.getDecreasingColor() == 1122867) {
                                i5 = iCandleDataSet.getColor(i6);
                            } else {
                                i5 = iCandleDataSet.getDecreasingColor();
                            }
                            paint2.setColor(i5);
                        } else if (open < close) {
                            Paint paint3 = this.mRenderPaint;
                            if (iCandleDataSet.getIncreasingColor() == 1122867) {
                                i4 = iCandleDataSet.getColor(i6);
                            } else {
                                i4 = iCandleDataSet.getIncreasingColor();
                            }
                            paint3.setColor(i4);
                        } else {
                            Paint paint4 = this.mRenderPaint;
                            if (iCandleDataSet.getNeutralColor() == 1122867) {
                                i3 = iCandleDataSet.getColor(i6);
                            } else {
                                i3 = iCandleDataSet.getNeutralColor();
                            }
                            paint4.setColor(i3);
                        }
                        this.mRenderPaint.setStyle(Paint.Style.STROKE);
                        canvas.drawLines(this.mShadowBuffers, this.mRenderPaint);
                        float[] fArr2 = this.mBodyBuffers;
                        fArr2[0] = (x - 0.5f) + barSpace;
                        fArr2[1] = close * phaseY;
                        fArr2[2] = (x + 0.5f) - barSpace;
                        fArr2[3] = open * phaseY;
                        transformer.pointValuesToPixel(fArr2);
                        if (i7 > 0) {
                            if (iCandleDataSet.getDecreasingColor() == 1122867) {
                                this.mRenderPaint.setColor(iCandleDataSet.getColor(i6));
                            } else {
                                this.mRenderPaint.setColor(iCandleDataSet.getDecreasingColor());
                            }
                            this.mRenderPaint.setStyle(iCandleDataSet.getDecreasingPaintStyle());
                            float[] fArr3 = this.mBodyBuffers;
                            canvas.drawRect(fArr3[0], fArr3[3], fArr3[2], fArr3[1], this.mRenderPaint);
                        } else if (open < close) {
                            if (iCandleDataSet.getIncreasingColor() == 1122867) {
                                this.mRenderPaint.setColor(iCandleDataSet.getColor(i6));
                            } else {
                                this.mRenderPaint.setColor(iCandleDataSet.getIncreasingColor());
                            }
                            this.mRenderPaint.setStyle(iCandleDataSet.getIncreasingPaintStyle());
                            float[] fArr4 = this.mBodyBuffers;
                            canvas.drawRect(fArr4[0], fArr4[1], fArr4[2], fArr4[3], this.mRenderPaint);
                        } else {
                            if (iCandleDataSet.getNeutralColor() == 1122867) {
                                this.mRenderPaint.setColor(iCandleDataSet.getColor(i6));
                            } else {
                                this.mRenderPaint.setColor(iCandleDataSet.getNeutralColor());
                            }
                            float[] fArr5 = this.mBodyBuffers;
                            canvas.drawLine(fArr5[0], fArr5[1], fArr5[2], fArr5[3], this.mRenderPaint);
                        }
                    } else {
                        float[] fArr6 = this.mRangeBuffers;
                        fArr6[0] = x;
                        fArr6[1] = high * phaseY;
                        fArr6[2] = x;
                        fArr6[3] = low * phaseY;
                        float[] fArr7 = this.mOpenBuffers;
                        fArr7[0] = (x - 0.5f) + barSpace;
                        float f2 = open * phaseY;
                        fArr7[1] = f2;
                        fArr7[2] = x;
                        fArr7[3] = f2;
                        float[] fArr8 = this.mCloseBuffers;
                        fArr8[0] = (0.5f + x) - barSpace;
                        float f3 = close * phaseY;
                        fArr8[1] = f3;
                        fArr8[2] = x;
                        fArr8[3] = f3;
                        transformer.pointValuesToPixel(fArr6);
                        transformer.pointValuesToPixel(this.mOpenBuffers);
                        transformer.pointValuesToPixel(this.mCloseBuffers);
                        if (open > close) {
                            if (iCandleDataSet.getDecreasingColor() == 1122867) {
                                i = iCandleDataSet.getColor(i6);
                            } else {
                                i = iCandleDataSet.getDecreasingColor();
                            }
                        } else if (open < close) {
                            if (iCandleDataSet.getIncreasingColor() == 1122867) {
                                i = iCandleDataSet.getColor(i6);
                            } else {
                                i = iCandleDataSet.getIncreasingColor();
                            }
                        } else if (iCandleDataSet.getNeutralColor() == 1122867) {
                            i = iCandleDataSet.getColor(i6);
                        } else {
                            i = iCandleDataSet.getNeutralColor();
                        }
                        this.mRenderPaint.setColor(i);
                        float[] fArr9 = this.mRangeBuffers;
                        canvas.drawLine(fArr9[0], fArr9[1], fArr9[2], fArr9[3], this.mRenderPaint);
                        float[] fArr10 = this.mOpenBuffers;
                        canvas.drawLine(fArr10[0], fArr10[1], fArr10[2], fArr10[3], this.mRenderPaint);
                        float[] fArr11 = this.mCloseBuffers;
                        canvas.drawLine(fArr11[0], fArr11[1], fArr11[2], fArr11[3], this.mRenderPaint);
                    }
                }
                i6++;
            } else {
                return;
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas canvas) {
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        CandleData candleData = this.mChart.getCandleData();
        for (Highlight highlight : highlightArr) {
            ILineScatterCandleRadarDataSet iLineScatterCandleRadarDataSet = (ICandleDataSet) candleData.getDataSetByIndex(highlight.getDataSetIndex());
            if (iLineScatterCandleRadarDataSet != null && iLineScatterCandleRadarDataSet.isHighlightEnabled()) {
                CandleEntry candleEntry = (CandleEntry) iLineScatterCandleRadarDataSet.getEntryForXValue(highlight.getX(), highlight.getY());
                if (isInBoundsX(candleEntry, iLineScatterCandleRadarDataSet)) {
                    MPPointD pixelForValues = this.mChart.getTransformer(iLineScatterCandleRadarDataSet.getAxisDependency()).getPixelForValues(candleEntry.getX(), ((candleEntry.getLow() * this.mAnimator.getPhaseY()) + (candleEntry.getHigh() * this.mAnimator.getPhaseY())) / 2.0f);
                    highlight.setDraw((float) pixelForValues.x, (float) pixelForValues.y);
                    drawHighlightLines(canvas, (float) pixelForValues.x, (float) pixelForValues.y, iLineScatterCandleRadarDataSet);
                }
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValue(Canvas canvas, String str, float f2, float f3, int i) {
        this.mValuePaint.setColor(i);
        canvas.drawText(str, f2, f3, this.mValuePaint);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas canvas) {
        float f2;
        CandleEntry candleEntry;
        if (isDrawingValuesAllowed(this.mChart)) {
            List<T> dataSets = this.mChart.getCandleData().getDataSets();
            for (int i = 0; i < dataSets.size(); i++) {
                ICandleDataSet iCandleDataSet = (ICandleDataSet) dataSets.get(i);
                if (shouldDrawValues(iCandleDataSet) && iCandleDataSet.getEntryCount() >= 1) {
                    applyValueTextStyle(iCandleDataSet);
                    Transformer transformer = this.mChart.getTransformer(iCandleDataSet.getAxisDependency());
                    this.mXBounds.set(this.mChart, iCandleDataSet);
                    float phaseX = this.mAnimator.getPhaseX();
                    float phaseY = this.mAnimator.getPhaseY();
                    BarLineScatterCandleBubbleRenderer.XBounds xBounds = this.mXBounds;
                    float[] generateTransformedValuesCandle = transformer.generateTransformedValuesCandle(iCandleDataSet, phaseX, phaseY, xBounds.min, xBounds.max);
                    float convertDpToPixel = Utils.convertDpToPixel(5.0f);
                    ValueFormatter valueFormatter = iCandleDataSet.getValueFormatter();
                    MPPointF instance = MPPointF.getInstance(iCandleDataSet.getIconsOffset());
                    instance.x = Utils.convertDpToPixel(instance.x);
                    instance.y = Utils.convertDpToPixel(instance.y);
                    for (int i2 = 0; i2 < generateTransformedValuesCandle.length; i2 += 2) {
                        float f3 = generateTransformedValuesCandle[i2];
                        float f4 = generateTransformedValuesCandle[i2 + 1];
                        if (!this.mViewPortHandler.isInBoundsRight(f3)) {
                            break;
                        }
                        if (!this.mViewPortHandler.isInBoundsLeft(f3) || !this.mViewPortHandler.isInBoundsY(f4)) {
                            iCandleDataSet = iCandleDataSet;
                        } else {
                            int i3 = i2 / 2;
                            CandleEntry candleEntry2 = (CandleEntry) iCandleDataSet.getEntryForIndex(this.mXBounds.min + i3);
                            if (iCandleDataSet.isDrawValuesEnabled()) {
                                candleEntry = candleEntry2;
                                f2 = f4;
                                iCandleDataSet = iCandleDataSet;
                                drawValue(canvas, valueFormatter.getCandleLabel(candleEntry2), f3, f4 - convertDpToPixel, iCandleDataSet.getValueTextColor(i3));
                            } else {
                                candleEntry = candleEntry2;
                                f2 = f4;
                                iCandleDataSet = iCandleDataSet;
                            }
                            if (candleEntry.getIcon() != null && iCandleDataSet.isDrawIconsEnabled()) {
                                Drawable icon = candleEntry.getIcon();
                                Utils.drawImage(canvas, icon, (int) (f3 + instance.x), (int) (f2 + instance.y), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                            }
                        }
                    }
                    MPPointF.recycleInstance(instance);
                }
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
    }
}
