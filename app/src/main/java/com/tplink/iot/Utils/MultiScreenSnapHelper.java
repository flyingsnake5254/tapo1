package com.tplink.iot.Utils;

import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

/* loaded from: classes2.dex */
public class MultiScreenSnapHelper extends SnapHelper {
    private OrientationHelper a;

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f5256b;

    /* renamed from: c  reason: collision with root package name */
    private int f5257c = 1;

    /* renamed from: d  reason: collision with root package name */
    private int f5258d = 1000;

    /* loaded from: classes2.dex */
    class a extends LinearSmoothScroller {
        a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return 40.0f / displayMetrics.densityDpi;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
        protected void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
            MultiScreenSnapHelper multiScreenSnapHelper = MultiScreenSnapHelper.this;
            int[] calculateDistanceToFinalSnap = multiScreenSnapHelper.calculateDistanceToFinalSnap(multiScreenSnapHelper.f5256b.getLayoutManager(), view);
            int i = calculateDistanceToFinalSnap[0];
            int i2 = calculateDistanceToFinalSnap[1];
            int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
            if (calculateTimeForDeceleration > 0) {
                action.update(i, i2, calculateTimeForDeceleration, this.mDecelerateInterpolator);
            }
        }
    }

    private int b(View view, OrientationHelper orientationHelper) {
        return orientationHelper.getDecoratedStart(view) - orientationHelper.getStartAfterPadding();
    }

    private int c(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        LinearLayoutManager linearLayoutManager;
        int findFirstVisibleItemPosition;
        if (!(layoutManager instanceof LinearLayoutManager) || (findFirstVisibleItemPosition = (linearLayoutManager = (LinearLayoutManager) layoutManager).findFirstVisibleItemPosition()) == -1 || linearLayoutManager.findLastCompletelyVisibleItemPosition() == layoutManager.getItemCount() - 1) {
            return -1;
        }
        View findViewByPosition = layoutManager.findViewByPosition(findFirstVisibleItemPosition);
        int findLastVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
        View findViewByPosition2 = layoutManager.findViewByPosition(findLastVisibleItemPosition);
        int i = this.f5257c;
        int i2 = i - (findFirstVisibleItemPosition % i);
        int i3 = (findLastVisibleItemPosition % i) + 1;
        if (i2 > i3) {
            return (findFirstVisibleItemPosition / i) * i;
        }
        if (i3 > i2) {
            return (findLastVisibleItemPosition / i) * i;
        }
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        findViewByPosition.getLocalVisibleRect(rect);
        findViewByPosition2.getLocalVisibleRect(rect2);
        if (rect.height() * rect.width() >= rect2.height() * rect2.width()) {
            int i4 = this.f5257c;
            return (findFirstVisibleItemPosition / i4) * i4;
        }
        int i5 = this.f5257c;
        return (findLastVisibleItemPosition / i5) * i5;
    }

    private OrientationHelper getHorizontalHelper(RecyclerView.LayoutManager layoutManager) {
        if (this.a == null) {
            this.a = OrientationHelper.createHorizontalHelper(layoutManager);
        }
        return this.a;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) throws IllegalStateException {
        this.f5256b = recyclerView;
        super.attachToRecyclerView(recyclerView);
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view) {
        int[] iArr = new int[2];
        if (layoutManager.canScrollHorizontally()) {
            iArr[0] = b(view, getHorizontalHelper(layoutManager));
        } else {
            iArr[0] = 0;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    @Nullable
    protected LinearSmoothScroller createSnapScroller(RecyclerView.LayoutManager layoutManager) {
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider)) {
            return null;
        }
        return new a(this.f5256b.getContext());
    }

    public void d(int i) {
        this.f5257c = i;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        return layoutManager.findViewByPosition(c(layoutManager, getHorizontalHelper(layoutManager)));
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        int c2 = c(layoutManager, getHorizontalHelper(layoutManager));
        if (c2 == -1) {
            return ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
        }
        int i3 = this.f5258d;
        if (i > i3) {
            c2 += this.f5257c;
        } else if (i < (-i3)) {
            c2 -= this.f5257c;
        }
        int itemCount = layoutManager.getItemCount();
        if (c2 > itemCount) {
            return itemCount - this.f5257c;
        }
        if (c2 >= 0 || itemCount <= 0) {
            return c2;
        }
        return 0;
    }
}
