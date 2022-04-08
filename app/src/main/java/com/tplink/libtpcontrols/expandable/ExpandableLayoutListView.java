package com.tplink.libtpcontrols.expandable;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

/* loaded from: classes3.dex */
public class ExpandableLayoutListView extends ListView {

    /* renamed from: c  reason: collision with root package name */
    private Integer f12229c = -1;

    /* loaded from: classes3.dex */
    public class a implements AbsListView.OnScrollListener {

        /* renamed from: c  reason: collision with root package name */
        private int f12230c = 0;

        public a() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.f12230c != 0) {
                for (int i4 = 0; i4 < ExpandableLayoutListView.this.getChildCount(); i4++) {
                    ExpandableLayoutItem expandableLayoutItem = (ExpandableLayoutItem) ExpandableLayoutListView.this.getChildAt(i4).findViewWithTag(ExpandableLayoutItem.class.getName());
                    if (expandableLayoutItem.h().booleanValue() && i4 != ExpandableLayoutListView.this.f12229c.intValue() - ExpandableLayoutListView.this.getFirstVisiblePosition()) {
                        expandableLayoutItem.f();
                    } else if (!expandableLayoutItem.getCloseByUser().booleanValue() && !expandableLayoutItem.h().booleanValue() && i4 == ExpandableLayoutListView.this.f12229c.intValue() - ExpandableLayoutListView.this.getFirstVisiblePosition()) {
                        expandableLayoutItem.l();
                    }
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            this.f12230c = i;
        }
    }

    public ExpandableLayoutListView(Context context) {
        super(context);
        setOnScrollListener(new a());
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        this.f12229c = Integer.valueOf(i);
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (i2 != i - getFirstVisiblePosition()) {
                ((ExpandableLayoutItem) getChildAt(i2).findViewWithTag(ExpandableLayoutItem.class.getName())).e();
            }
        }
        ExpandableLayoutItem expandableLayoutItem = (ExpandableLayoutItem) getChildAt(i - getFirstVisiblePosition()).findViewWithTag(ExpandableLayoutItem.class.getName());
        if (expandableLayoutItem.h().booleanValue()) {
            expandableLayoutItem.e();
        } else {
            expandableLayoutItem.k();
        }
        return super.performItemClick(view, i, j);
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        if (onScrollListener instanceof a) {
            super.setOnScrollListener(onScrollListener);
            return;
        }
        throw new IllegalArgumentException("OnScrollListner must be an OnExpandableLayoutScrollListener");
    }

    public ExpandableLayoutListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnScrollListener(new a());
    }

    public ExpandableLayoutListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOnScrollListener(new a());
    }
}
