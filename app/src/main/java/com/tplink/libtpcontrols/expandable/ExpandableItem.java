package com.tplink.libtpcontrols.expandable;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.tplink.libtpcontrols.s0;
import com.tplink.libtpcontrols.t0;
import com.tplink.libtpcontrols.x0;

/* loaded from: classes3.dex */
public class ExpandableItem extends RelativeLayout {

    /* renamed from: c  reason: collision with root package name */
    private int f12207c;

    /* renamed from: d  reason: collision with root package name */
    private View f12208d;

    /* renamed from: f  reason: collision with root package name */
    private RecyclerView f12209f;
    private ExpandableSubItemsAdapter q;

    public ExpandableItem(Context context) {
        this(context, null, 0);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, x0.ExpandableItem);
        int resourceId = obtainStyledAttributes.getResourceId(x0.ExpandableItem_ei_headerLayout, -1);
        int resourceId2 = obtainStyledAttributes.getResourceId(x0.ExpandableItem_ei_contentLayout, -1);
        if (resourceId == -1 || resourceId2 == -1) {
            throw new IllegalArgumentException("HeaderLayout and ContentLayout cannot be null!");
        } else if (!isInEditMode()) {
            this.f12207c = obtainStyledAttributes.getInt(x0.ExpandableItem_ei_duration, PathInterpolatorCompat.MAX_NUM_POINTS);
            obtainStyledAttributes.recycle();
            View inflate = LayoutInflater.from(context).inflate(t0.expandable_item, this);
            View inflate2 = View.inflate(context, resourceId, null);
            this.f12208d = inflate2;
            inflate2.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            ((ViewGroup) inflate.findViewById(s0.expandable_item_header)).addView(this.f12208d);
            RecyclerView recyclerView = (RecyclerView) View.inflate(context, resourceId2, null);
            this.f12209f = recyclerView;
            recyclerView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            ((ViewGroup) inflate.findViewById(s0.expandable_item_content)).addView(this.f12209f);
            this.f12209f.setLayoutManager(new LinearLayoutManager(context));
            this.f12209f.setItemAnimator(new DefaultItemAnimator());
        }
    }

    public RecyclerView getContentView() {
        return this.f12209f;
    }

    public View getHeader() {
        return this.f12208d;
    }

    public void setContentViewAdapter(RecyclerView.Adapter adapter) {
        ExpandableSubItemsAdapter expandableSubItemsAdapter = new ExpandableSubItemsAdapter(adapter);
        this.q = expandableSubItemsAdapter;
        this.f12209f.setAdapter(expandableSubItemsAdapter);
    }

    public ExpandableItem(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ExpandableItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }
}
