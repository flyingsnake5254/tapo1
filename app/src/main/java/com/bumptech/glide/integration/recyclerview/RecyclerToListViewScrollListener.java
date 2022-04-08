package com.bumptech.glide.integration.recyclerview;

import android.widget.AbsListView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class RecyclerToListViewScrollListener extends RecyclerView.OnScrollListener {
    private final AbsListView.OnScrollListener a;

    /* renamed from: b  reason: collision with root package name */
    private int f1302b;

    /* renamed from: c  reason: collision with root package name */
    private int f1303c;

    /* renamed from: d  reason: collision with root package name */
    private int f1304d;

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        int i2 = 2;
        if (i == 0) {
            i2 = 0;
        } else if (i == 1) {
            i2 = 1;
        } else if (i != 2) {
            i2 = Integer.MIN_VALUE;
        }
        this.a.onScrollStateChanged(null, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int abs = Math.abs(findFirstVisibleItemPosition - linearLayoutManager.findLastVisibleItemPosition());
        int itemCount = recyclerView.getAdapter().getItemCount();
        if (findFirstVisibleItemPosition != this.f1302b || abs != this.f1303c || itemCount != this.f1304d) {
            this.a.onScroll(null, findFirstVisibleItemPosition, abs, itemCount);
            this.f1302b = findFirstVisibleItemPosition;
            this.f1303c = abs;
            this.f1304d = itemCount;
        }
    }
}
