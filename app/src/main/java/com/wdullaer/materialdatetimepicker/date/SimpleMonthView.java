package com.wdullaer.materialdatetimepicker.date;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;

/* loaded from: classes3.dex */
public class SimpleMonthView extends MonthView {
    public SimpleMonthView(Context context, AttributeSet attributeSet, a aVar) {
        super(context, attributeSet, aVar);
    }

    @Override // com.wdullaer.materialdatetimepicker.date.MonthView
    public void d(Canvas canvas, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        if (this.W3 == i3) {
            canvas.drawCircle(i4, i5 - (MonthView.f15295f / 3), MonthView.z, this.L3);
        }
        if (!m(i, i2, i3) || this.W3 == i3) {
            this.J3.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
        } else {
            canvas.drawCircle(i4, (MonthView.f15295f + i5) - MonthView.p1, MonthView.p0, this.L3);
            this.J3.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        }
        if (this.p2.f(i, i2, i3)) {
            this.J3.setColor(this.o4);
        } else if (this.W3 == i3) {
            this.J3.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
            this.J3.setColor(this.k4);
        } else if (!this.V3 || this.X3 != i3) {
            this.J3.setColor(m(i, i2, i3) ? this.n4 : this.j4);
        } else {
            this.J3.setColor(this.m4);
        }
        canvas.drawText(String.format(this.p2.c(), "%d", Integer.valueOf(i3)), i4, i5, this.J3);
    }
}
