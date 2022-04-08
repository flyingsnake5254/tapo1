package com.tplink.iot.view.ipcamera.memories;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
    private int a;

    /* renamed from: b  reason: collision with root package name */
    private int f8714b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f8715c;

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i = this.a;
        int i2 = childAdapterPosition % i;
        if (this.f8715c) {
            int i3 = this.f8714b;
            rect.left = i3 - ((i2 * i3) / i);
            rect.right = ((i2 + 1) * i3) / i;
            if (childAdapterPosition < i) {
                rect.top = i3;
            }
            rect.bottom = i3;
            return;
        }
        int i4 = this.f8714b;
        rect.left = (i2 * i4) / i;
        rect.right = i4 - (((i2 + 1) * i4) / i);
        if (childAdapterPosition >= i) {
            rect.top = i4;
        }
    }
}
