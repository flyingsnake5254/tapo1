package com.tplink.iot.view.ipcamera.widget.calendar.scrollCalendar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;

/* loaded from: classes2.dex */
public class ScrollCalendarViewPager extends ViewPager {
    public ScrollCalendarViewPager(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onMeasure(int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            View childAt = getChildAt(i4);
            childAt.measure(i, View.MeasureSpec.makeMeasureSpec(0, 0));
            int measuredHeight = childAt.getMeasuredHeight();
            if (measuredHeight > i3) {
                i3 = measuredHeight;
            }
        }
        if (i3 != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(i3, Pow2.MAX_POW2);
        }
        super.onMeasure(i, i2);
    }

    public ScrollCalendarViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
