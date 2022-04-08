package com.tplink.libtpcontrols;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.booking.rtlviewpager.RtlViewPager;

/* loaded from: classes3.dex */
public class TPNoScrollViewPager extends RtlViewPager {
    public TPNoScrollViewPager(Context context) {
        super(context);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public TPNoScrollViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
