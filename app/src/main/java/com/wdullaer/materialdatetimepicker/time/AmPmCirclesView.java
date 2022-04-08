package com.wdullaer.materialdatetimepicker.time;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/* loaded from: classes3.dex */
public class AmPmCirclesView extends View {
    private String H3;
    private boolean I3;
    private boolean J3;
    private boolean L3;
    private int M3;
    private int N3;
    private int O3;
    private int P3;
    private int Q3;
    private int R3;

    /* renamed from: d  reason: collision with root package name */
    private int f15304d;

    /* renamed from: f  reason: collision with root package name */
    private int f15305f;
    private int p0;
    private float p1;
    private float p2;
    private String p3;
    private int q;
    private int x;
    private int y;
    private int z;

    /* renamed from: c  reason: collision with root package name */
    private final Paint f15303c = new Paint();
    private boolean K3 = false;

    public AmPmCirclesView(Context context) {
        super(context);
    }

    public int a(float f2, float f3) {
        if (!this.L3) {
            return -1;
        }
        int i = this.P3;
        int i2 = (int) ((f3 - i) * (f3 - i));
        int i3 = this.N3;
        float f4 = i2;
        if (((int) Math.sqrt(((f2 - i3) * (f2 - i3)) + f4)) <= this.M3 && !this.I3) {
            return 0;
        }
        int i4 = this.O3;
        return (((int) Math.sqrt((double) (((f2 - ((float) i4)) * (f2 - ((float) i4))) + f4))) > this.M3 || this.J3) ? -1 : 1;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        int i4;
        if (getWidth() != 0 && this.K3) {
            if (!this.L3) {
                int width = getWidth() / 2;
                int height = getHeight() / 2;
                int min = (int) (Math.min(width, height) * this.p1);
                int i5 = (int) (min * this.p2);
                this.M3 = i5;
                int i6 = (int) (height + (i5 * 0.75d));
                this.f15303c.setTextSize((i5 * 3) / 4);
                int i7 = this.M3;
                this.P3 = (i6 - (i7 / 2)) + min;
                this.N3 = (width - min) + i7;
                this.O3 = (width + min) - i7;
                this.L3 = true;
            }
            int i8 = this.q;
            int i9 = this.x;
            int i10 = this.Q3;
            if (i10 == 0) {
                i4 = this.p0;
                i3 = this.f15304d;
                i8 = i8;
                i = 255;
                i2 = i9;
                i9 = this.y;
            } else if (i10 == 1) {
                int i11 = this.p0;
                int i12 = this.f15304d;
                i2 = this.y;
                i8 = i11;
                i = i12;
                i3 = 255;
                i4 = i8;
            } else {
                i4 = i8;
                i8 = i4;
                i2 = i9;
                i3 = 255;
                i = 255;
            }
            int i13 = this.R3;
            if (i13 == 0) {
                i4 = this.f15305f;
                i3 = this.f15304d;
            } else if (i13 == 1) {
                i8 = this.f15305f;
                i = this.f15304d;
            }
            if (this.I3) {
                i9 = this.z;
                i4 = i8;
            }
            if (this.J3) {
                i2 = this.z;
            }
            this.f15303c.setColor(i4);
            this.f15303c.setAlpha(i3);
            canvas.drawCircle(this.N3, this.P3, this.M3, this.f15303c);
            this.f15303c.setColor(i8);
            this.f15303c.setAlpha(i);
            canvas.drawCircle(this.O3, this.P3, this.M3, this.f15303c);
            this.f15303c.setColor(i9);
            float descent = this.P3 - (((int) (this.f15303c.descent() + this.f15303c.ascent())) / 2);
            canvas.drawText(this.p3, this.N3, descent, this.f15303c);
            this.f15303c.setColor(i2);
            canvas.drawText(this.H3, this.O3, descent, this.f15303c);
        }
    }

    public void setAmOrPm(int i) {
        this.Q3 = i;
    }

    public void setAmOrPmPressed(int i) {
        this.R3 = i;
    }
}
