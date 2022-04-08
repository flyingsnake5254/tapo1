package com.tplink.iot.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ExpandableListView;

/* loaded from: classes3.dex */
public class SuperExpandableListView extends ExpandableListView {
    public SuperExpandableListView(Context context) {
        super(context);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public SuperExpandableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SuperExpandableListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
