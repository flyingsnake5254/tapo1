package com.tplink.libtpcontrols;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.ScrollView;

/* loaded from: classes3.dex */
public class TPMaxHeightScrollView extends ScrollView {

    /* renamed from: c  reason: collision with root package name */
    private Context f12135c;

    public TPMaxHeightScrollView(Context context) {
        this(context, null);
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        try {
            Display defaultDisplay = ((Activity) this.f12135c).getWindowManager().getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            i2 = View.MeasureSpec.makeMeasureSpec(displayMetrics.heightPixels / 2, Integer.MIN_VALUE);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        super.onMeasure(i, i2);
    }

    public TPMaxHeightScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TPMaxHeightScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12135c = context;
    }
}
