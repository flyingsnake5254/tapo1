package com.wdullaer.materialdatetimepicker;

import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public class GravitySnapHelper extends LinearSnapHelper {
    private OrientationHelper a;

    /* renamed from: b  reason: collision with root package name */
    private OrientationHelper f15273b;

    /* renamed from: c  reason: collision with root package name */
    private int f15274c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f15275d;

    /* renamed from: e  reason: collision with root package name */
    private b f15276e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f15277f;
    private RecyclerView.OnScrollListener g;

    /* loaded from: classes3.dex */
    class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 2) {
                GravitySnapHelper.this.f15277f = false;
            }
            if (i == 0 && GravitySnapHelper.this.f15277f && GravitySnapHelper.this.f15276e != null) {
                int i2 = GravitySnapHelper.this.i(recyclerView);
                if (i2 != -1) {
                    GravitySnapHelper.this.f15276e.a(i2);
                }
                GravitySnapHelper.this.f15277f = false;
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i);
    }

    public GravitySnapHelper(int i) {
        this(i, null);
    }

    private int e(View view, OrientationHelper orientationHelper, boolean z) {
        if (!this.f15275d || z) {
            return orientationHelper.getDecoratedEnd(view) - orientationHelper.getEndAfterPadding();
        }
        return f(view, orientationHelper, true);
    }

    private int f(View view, OrientationHelper orientationHelper, boolean z) {
        if (!this.f15275d || z) {
            return orientationHelper.getDecoratedStart(view) - orientationHelper.getStartAfterPadding();
        }
        return e(view, orientationHelper, true);
    }

    private View g(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int findLastVisibleItemPosition;
        int i;
        float f2;
        if (!(layoutManager instanceof LinearLayoutManager) || (findLastVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition()) == -1) {
            return null;
        }
        View findViewByPosition = layoutManager.findViewByPosition(findLastVisibleItemPosition);
        if (this.f15275d) {
            f2 = orientationHelper.getDecoratedEnd(findViewByPosition);
            i = orientationHelper.getDecoratedMeasurement(findViewByPosition);
        } else {
            f2 = orientationHelper.getTotalSpace() - orientationHelper.getDecoratedStart(findViewByPosition);
            i = orientationHelper.getDecoratedMeasurement(findViewByPosition);
        }
        float f3 = f2 / i;
        boolean z = ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition() == 0;
        if (f3 > 0.5f && !z) {
            return findViewByPosition;
        }
        if (z) {
            return null;
        }
        return layoutManager.findViewByPosition(findLastVisibleItemPosition - 1);
    }

    private OrientationHelper getHorizontalHelper(RecyclerView.LayoutManager layoutManager) {
        if (this.f15273b == null) {
            this.f15273b = OrientationHelper.createHorizontalHelper(layoutManager);
        }
        return this.f15273b;
    }

    private OrientationHelper getVerticalHelper(RecyclerView.LayoutManager layoutManager) {
        if (this.a == null) {
            this.a = OrientationHelper.createVerticalHelper(layoutManager);
        }
        return this.a;
    }

    private View h(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int findFirstVisibleItemPosition;
        int i;
        float f2;
        if (!(layoutManager instanceof LinearLayoutManager) || (findFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition()) == -1) {
            return null;
        }
        View findViewByPosition = layoutManager.findViewByPosition(findFirstVisibleItemPosition);
        if (this.f15275d) {
            f2 = orientationHelper.getTotalSpace() - orientationHelper.getDecoratedStart(findViewByPosition);
            i = orientationHelper.getDecoratedMeasurement(findViewByPosition);
        } else {
            f2 = orientationHelper.getDecoratedEnd(findViewByPosition);
            i = orientationHelper.getDecoratedMeasurement(findViewByPosition);
        }
        float f3 = f2 / i;
        boolean z = ((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition() == layoutManager.getItemCount() - 1;
        if (f3 > 0.5f && !z) {
            return findViewByPosition;
        }
        if (z) {
            return null;
        }
        return layoutManager.findViewByPosition(findFirstVisibleItemPosition + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int i(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            return -1;
        }
        int i = this.f15274c;
        if (i == 8388611 || i == 48) {
            return ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
        }
        if (i == 8388613 || i == 80) {
            return ((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
        }
        return -1;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) throws IllegalStateException {
        if (recyclerView != null) {
            int i = this.f15274c;
            if ((i == 8388611 || i == 8388613) && Build.VERSION.SDK_INT >= 17) {
                boolean z = true;
                if (recyclerView.getContext().getResources().getConfiguration().getLayoutDirection() != 1) {
                    z = false;
                }
                this.f15275d = z;
            }
            if (this.f15276e != null) {
                recyclerView.addOnScrollListener(this.g);
            }
        }
        super.attachToRecyclerView(recyclerView);
    }

    @Override // androidx.recyclerview.widget.LinearSnapHelper, androidx.recyclerview.widget.SnapHelper
    public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view) {
        int[] iArr = new int[2];
        if (!layoutManager.canScrollHorizontally()) {
            iArr[0] = 0;
        } else if (this.f15274c == 8388611) {
            iArr[0] = f(view, getHorizontalHelper(layoutManager), false);
        } else {
            iArr[0] = e(view, getHorizontalHelper(layoutManager), false);
        }
        if (!layoutManager.canScrollVertically()) {
            iArr[1] = 0;
        } else if (this.f15274c == 48) {
            iArr[1] = f(view, getVerticalHelper(layoutManager), false);
        } else {
            iArr[1] = e(view, getVerticalHelper(layoutManager), false);
        }
        return iArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0042  */
    @Override // androidx.recyclerview.widget.LinearSnapHelper, androidx.recyclerview.widget.SnapHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View findSnapView(androidx.recyclerview.widget.RecyclerView.LayoutManager r3) {
        /*
            r2 = this;
            boolean r0 = r3 instanceof androidx.recyclerview.widget.LinearLayoutManager
            if (r0 == 0) goto L_0x003d
            int r0 = r2.f15274c
            r1 = 48
            if (r0 == r1) goto L_0x0034
            r1 = 80
            if (r0 == r1) goto L_0x002b
            r1 = 8388611(0x800003, float:1.1754948E-38)
            if (r0 == r1) goto L_0x0022
            r1 = 8388613(0x800005, float:1.175495E-38)
            if (r0 == r1) goto L_0x0019
            goto L_0x003d
        L_0x0019:
            androidx.recyclerview.widget.OrientationHelper r0 = r2.getHorizontalHelper(r3)
            android.view.View r3 = r2.g(r3, r0)
            goto L_0x003e
        L_0x0022:
            androidx.recyclerview.widget.OrientationHelper r0 = r2.getHorizontalHelper(r3)
            android.view.View r3 = r2.h(r3, r0)
            goto L_0x003e
        L_0x002b:
            androidx.recyclerview.widget.OrientationHelper r0 = r2.getVerticalHelper(r3)
            android.view.View r3 = r2.g(r3, r0)
            goto L_0x003e
        L_0x0034:
            androidx.recyclerview.widget.OrientationHelper r0 = r2.getVerticalHelper(r3)
            android.view.View r3 = r2.h(r3, r0)
            goto L_0x003e
        L_0x003d:
            r3 = 0
        L_0x003e:
            if (r3 == 0) goto L_0x0042
            r0 = 1
            goto L_0x0043
        L_0x0042:
            r0 = 0
        L_0x0043:
            r2.f15277f = r0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wdullaer.materialdatetimepicker.GravitySnapHelper.findSnapView(androidx.recyclerview.widget.RecyclerView$LayoutManager):android.view.View");
    }

    public GravitySnapHelper(int i, b bVar) {
        this.g = new a();
        if (i == 8388611 || i == 8388613 || i == 80 || i == 48) {
            this.f15274c = i;
            this.f15276e = bVar;
            return;
        }
        throw new IllegalArgumentException("Invalid gravity value. Use START | END | BOTTOM | TOP constants");
    }
}
