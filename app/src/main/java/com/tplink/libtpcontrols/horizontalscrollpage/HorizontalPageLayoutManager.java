package com.tplink.libtpcontrols.horizontalscrollpage;

import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public class HorizontalPageLayoutManager extends RecyclerView.LayoutManager {

    /* renamed from: d  reason: collision with root package name */
    private int f12277d;

    /* renamed from: e  reason: collision with root package name */
    private int f12278e;

    /* renamed from: f  reason: collision with root package name */
    private int f12279f;
    private int g;
    private int h;
    private boolean a = false;

    /* renamed from: b  reason: collision with root package name */
    private int f12275b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f12276c = 0;
    private SparseArray<Rect> i = new SparseArray<>();

    public HorizontalPageLayoutManager(int i, int i2) {
        this.f12277d = i;
        this.f12278e = i2;
        this.f12279f = i * i2;
    }

    private int a() {
        return (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private int b() {
        return (getWidth() - getPaddingStart()) - getPaddingEnd();
    }

    private void c(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!state.isPreLayout()) {
            Rect rect = new Rect(getPaddingStart() + this.f12276c, getPaddingTop(), ((getWidth() - getPaddingStart()) - getPaddingEnd()) + this.f12276c, (getHeight() - getPaddingTop()) - getPaddingBottom());
            Rect rect2 = new Rect();
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                rect2.left = getDecoratedLeft(childAt);
                rect2.top = getDecoratedTop(childAt);
                rect2.right = getDecoratedRight(childAt);
                rect2.bottom = getDecoratedBottom(childAt);
                if (!Rect.intersects(rect, rect2)) {
                    removeAndRecycleView(childAt, recycler);
                }
            }
            for (int i2 = 0; i2 < getItemCount(); i2++) {
                if (Rect.intersects(rect, this.i.get(i2))) {
                    View viewForPosition = recycler.getViewForPosition(i2);
                    addView(viewForPosition);
                    measureChildWithMargins(viewForPosition, this.g, this.h);
                    Rect rect3 = this.i.get(i2);
                    int i3 = rect3.left;
                    int i4 = this.f12276c;
                    layoutDecorated(viewForPosition, i3 - i4, rect3.top, rect3.right - i4, rect3.bottom);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return true;
    }

    public void d(boolean z) {
        this.a = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        this.f12276c = 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getItemCount() == 0) {
            removeAndRecycleAllViews(recycler);
        } else if (!state.isPreLayout()) {
            int b2 = b() / this.f12278e;
            int a = a();
            int i = this.f12277d;
            int i2 = a / i;
            int i3 = 1;
            this.g = (this.f12278e - 1) * b2;
            this.h = (i - 1) * i2;
            int itemCount = (getItemCount() / this.f12279f) + (getItemCount() % this.f12279f == 0 ? 0 : 1);
            int width = (itemCount - 1) * getWidth();
            this.f12275b = width;
            if (this.a) {
                this.f12275b = -width;
            }
            detachAndScrapAttachedViews(recycler);
            int itemCount2 = getItemCount();
            int i4 = 0;
            while (i4 < itemCount) {
                int i5 = 0;
                while (i5 < this.f12277d) {
                    int i6 = 0;
                    while (true) {
                        int i7 = this.f12278e;
                        if (i6 >= i7) {
                            break;
                        }
                        int i8 = (this.f12279f * i4) + (i7 * i5) + i6;
                        if (i8 == itemCount2) {
                            i5 = this.f12277d;
                            i4 = itemCount;
                            break;
                        }
                        View viewForPosition = recycler.getViewForPosition(i8);
                        addView(viewForPosition);
                        measureChildWithMargins(viewForPosition, this.g, this.h);
                        int decoratedMeasuredWidth = getDecoratedMeasuredWidth(viewForPosition);
                        int decoratedMeasuredHeight = getDecoratedMeasuredHeight(viewForPosition);
                        Rect rect = this.i.get(i8);
                        if (rect == null) {
                            rect = new Rect();
                        }
                        int b3 = (b() * i4) + (i6 * b2);
                        int i9 = i5 * i2;
                        if (this.a) {
                            b3 = ((this.f12278e - 1) * b2) + (-b3);
                        }
                        rect.set(b3, i9, decoratedMeasuredWidth + b3, decoratedMeasuredHeight + i9);
                        this.i.put(i8, rect);
                        i6++;
                        i3 = 1;
                    }
                    i5 += i3;
                }
                removeAndRecycleAllViews(recycler);
                i4++;
            }
            c(recycler, state);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        detachAndScrapAttachedViews(recycler);
        int i2 = this.f12276c;
        int i3 = i2 + i;
        if (this.a) {
            int i4 = this.f12275b;
            if (i3 < i4) {
                i = i2 - i4;
            } else if (i3 > 0) {
                i = i2;
            }
        } else {
            int i5 = this.f12275b;
            if (i3 > i5) {
                i = i5 - i2;
            } else if (i3 < 0) {
                i = -i2;
            }
        }
        this.f12276c = i2 + i;
        offsetChildrenHorizontal(-i);
        c(recycler, state);
        return i;
    }
}
