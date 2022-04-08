package com.tplink.iot.devices.lightstrip.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: DashCircleAddView.kt */
/* loaded from: classes2.dex */
public final class DashCircleAddView extends View {

    /* renamed from: c  reason: collision with root package name */
    private final int f7768c;

    /* renamed from: d  reason: collision with root package name */
    private final float f7769d;

    /* renamed from: f  reason: collision with root package name */
    private final float f7770f;
    private final Paint p0;
    private final float q;
    private final float x;
    private float y;
    private final Paint z;

    public DashCircleAddView(Context context) {
        this(context, null, 0, 6, null);
    }

    public DashCircleAddView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ DashCircleAddView(Context context, AttributeSet attributeSet, int i, int i2, f fVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final float a(int i) {
        Context context = getContext();
        j.d(context, "context");
        Resources resources = context.getResources();
        j.d(resources, "context.resources");
        return TypedValue.applyDimension(1, i, resources.getDisplayMetrics());
    }

    private final int b(int i) {
        int i2 = this.f7768c;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(this.f7768c, size);
        }
        if (mode != 0) {
            return mode != 1073741824 ? i2 : size;
        }
        return this.f7768c;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        j.e(canvas, "canvas");
        float width = getWidth() / 2.0f;
        canvas.drawCircle(width, width, (((getWidth() - this.f7769d) / 2.0f) - this.q) - this.f7770f, this.z);
        float width2 = getWidth() * 0.4f;
        canvas.drawLine(width2, width, getWidth() - width2, width, this.p0);
        canvas.drawLine(width, width2, width, getHeight() - width2, this.p0);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int min = Math.min(b(i), b(i2));
        setMeasuredDimension(min, min);
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent event) {
        j.e(event, "event");
        int action = event.getAction();
        if (action == 0) {
            setAlpha(0.5f);
        } else if (action == 1 || action == 3) {
            setAlpha(1.0f);
        }
        super.onTouchEvent(event);
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DashCircleAddView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        j.e(context, "context");
        this.f7768c = (int) a(84);
        float a = a(2);
        this.f7769d = a;
        this.f7770f = a(4);
        this.q = a(6);
        float a2 = a(2);
        this.x = a2;
        this.y = a(36);
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor((int) 2576980377L);
        paint.setStrokeWidth(a);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setPathEffect(new DashPathEffect(new float[]{5.0f, 10.0f}, 0.0f));
        p pVar = p.a;
        this.z = paint;
        Paint paint2 = new Paint(1);
        paint2.setColor((int) 4288256409L);
        paint2.setStrokeWidth(a2);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        this.p0 = paint2;
    }
}
