package com.wdullaer.materialdatetimepicker.time;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/* loaded from: classes3.dex */
public class CircleView extends View {

    /* renamed from: d  reason: collision with root package name */
    private boolean f15307d;

    /* renamed from: f  reason: collision with root package name */
    private int f15308f;
    private boolean p0;
    private int p1;
    private int p2;
    private int p3;
    private int q;
    private float x;
    private float y;

    /* renamed from: c  reason: collision with root package name */
    private final Paint f15306c = new Paint();
    private boolean z = false;

    public CircleView(Context context) {
        super(context);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (getWidth() != 0 && this.z) {
            if (!this.p0) {
                this.p1 = getWidth() / 2;
                int height = getHeight() / 2;
                this.p2 = height;
                int min = (int) (Math.min(this.p1, height) * this.x);
                this.p3 = min;
                if (!this.f15307d) {
                    this.p2 = (int) (this.p2 - (((int) (min * this.y)) * 0.75d));
                }
                this.p0 = true;
            }
            this.f15306c.setColor(this.f15308f);
            canvas.drawCircle(this.p1, this.p2, this.p3, this.f15306c);
            this.f15306c.setColor(this.q);
            canvas.drawCircle(this.p1, this.p2, 8.0f, this.f15306c);
        }
    }
}
