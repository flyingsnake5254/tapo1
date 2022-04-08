package com.tplink.iot.adapter.smart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.adapter.smart.SmartActionAdapter;

/* loaded from: classes2.dex */
public class SmartListItemDecoration extends RecyclerView.ItemDecoration {
    private Paint a;

    /* renamed from: b  reason: collision with root package name */
    private int f5990b;

    public SmartListItemDecoration(Context context) {
        Paint paint = new Paint();
        this.a = paint;
        paint.setColor(context.getResources().getColor(R.color.divider_color));
        this.f5990b = context.getResources().getDimensionPixelSize(R.dimen.smart_action_padding_left);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        rect.set(0, 0, 0, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDraw(canvas, recyclerView, state);
        int childCount = recyclerView.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = recyclerView.getChildAt(i);
            RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(childAt);
            RecyclerView.ViewHolder viewHolder = null;
            View childAt2 = i < childCount + (-1) ? recyclerView.getChildAt(i + 1) : null;
            if (childAt2 != null) {
                viewHolder = recyclerView.getChildViewHolder(childAt2);
            }
            int left = childAt.getLeft();
            int right = childAt.getRight();
            int bottom = childAt.getBottom();
            int i2 = bottom + 1;
            if ((childViewHolder instanceof SmartActionAdapter.ActionHolder) && (viewHolder instanceof SmartActionAdapter.ActionHolder)) {
                left += this.f5990b;
            }
            canvas.drawRect(left, bottom, right, i2, this.a);
            i++;
        }
    }
}
