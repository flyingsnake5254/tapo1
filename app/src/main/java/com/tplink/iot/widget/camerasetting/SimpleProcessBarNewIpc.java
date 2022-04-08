package com.tplink.iot.widget.camerasetting;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import b.d.q.b.j;
import com.tplink.iot.R;
import com.tplink.libtpnetwork.cameranetwork.model.SdCardStatus;

/* loaded from: classes3.dex */
public class SimpleProcessBarNewIpc extends View {
    private int p0;
    private SdCardStatus q;
    private int z;

    /* renamed from: c  reason: collision with root package name */
    int f11725c = getResources().getColor(R.color.playback_calender_mark_day);

    /* renamed from: d  reason: collision with root package name */
    int f11726d = getResources().getColor(R.color.color_d9d9d9);

    /* renamed from: f  reason: collision with root package name */
    int f11727f = getResources().getColor(R.color.tomato);
    private float x = a(getContext(), 5.0f);
    private Paint y = new Paint(1);
    private int p1 = 0;

    public SimpleProcessBarNewIpc(Context context) {
        super(context);
    }

    private int a(Context context, float f2) {
        return Math.round(TypedValue.applyDimension(1, f2, context.getResources().getDisplayMetrics()));
    }

    private void b(Canvas canvas, int i) {
        if (j.a()) {
            float f2 = this.x;
            canvas.drawRoundRect(0.0f, 0.0f, i, this.p0, f2, f2, this.y);
            return;
        }
        RectF rectF = new RectF(0.0f, 0.0f, i, this.p0);
        float f3 = this.x;
        canvas.drawRoundRect(rectF, f3, f3, this.y);
    }

    public int getProcess() {
        return this.p1;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.z = getWidth();
        this.p0 = getHeight();
        if (!SdCardStatus.ABNORMAL.equals(this.q)) {
            SdCardStatus sdCardStatus = SdCardStatus.FULL;
            if (!sdCardStatus.equals(this.q)) {
                if (SdCardStatus.UNFORMATTED.equals(this.q)) {
                    this.y.setColor(this.f11726d);
                    b(canvas, this.z);
                    return;
                } else if (sdCardStatus.equals(this.q)) {
                    this.y.setColor(this.f11727f);
                    b(canvas, this.z);
                    return;
                } else {
                    this.y.setColor(this.f11726d);
                    this.y.setStyle(Paint.Style.FILL);
                    b(canvas, this.z);
                    this.y.setColor(this.f11725c);
                    b(canvas, (int) (this.z * ((float) (this.p1 / 100.0d))));
                    return;
                }
            }
        }
        this.y.setColor(this.f11727f);
        b(canvas, this.z);
    }

    public void setProcess(int i) {
        this.p1 = i;
        invalidate();
    }

    public void setStatus(SdCardStatus sdCardStatus) {
        this.q = sdCardStatus;
    }

    public SimpleProcessBarNewIpc(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
