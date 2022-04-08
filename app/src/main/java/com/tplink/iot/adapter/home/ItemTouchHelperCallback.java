package com.tplink.iot.adapter.home;

import android.graphics.Canvas;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public class ItemTouchHelperCallback extends ItemTouchHelper.Callback {
    private final HomeMainAdapter a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f5720b = true;

    public ItemTouchHelperCallback(HomeMainAdapter homeMainAdapter) {
        this.a = homeMainAdapter;
    }

    public void a(boolean z) {
        this.f5720b = z;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        viewHolder.itemView.setAlpha(1.0f);
        if (viewHolder instanceof i) {
            ((i) viewHolder).a();
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        if (!(recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
            return ItemTouchHelper.Callback.makeMovementFlags(3, 48);
        }
        return ItemTouchHelper.Callback.makeMovementFlags(!this.a.a() ? 0 : 15, 0);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isLongPressDragEnabled() {
        return this.f5720b;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f2, float f3, int i, boolean z) {
        if (i == 1) {
            viewHolder.itemView.setAlpha(1.0f - (Math.abs(f2) / viewHolder.itemView.getWidth()));
            viewHolder.itemView.setTranslationX(f2);
            return;
        }
        super.onChildDraw(canvas, recyclerView, viewHolder, f2, f3, i, z);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        if (viewHolder.getItemViewType() != viewHolder2.getItemViewType() && viewHolder2.getAdapterPosition() == 0) {
            return false;
        }
        this.a.r(viewHolder.getAdapterPosition(), viewHolder2.getAdapterPosition());
        return true;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i) {
        if (i != 0 && (viewHolder instanceof i)) {
            ((i) viewHolder).b();
        }
        super.onSelectedChanged(viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
        this.a.q(viewHolder.getAdapterPosition());
    }
}
