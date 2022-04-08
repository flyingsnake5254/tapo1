package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.internal.IndicatorLayout;
import com.tplink.libtpcontrols.q0;
import com.tplink.libtpcontrols.x0;

/* loaded from: classes2.dex */
public abstract class PullToRefreshAdapterViewBase<T extends AbsListView> extends PullToRefreshBase<T> implements AbsListView.OnScrollListener {
    private boolean X3;
    private AbsListView.OnScrollListener Y3;
    private PullToRefreshBase.b Z3;
    private View a4;
    private IndicatorLayout b4;
    private IndicatorLayout c4;
    private boolean d4;
    private boolean e4 = true;

    /* loaded from: classes2.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[PullToRefreshBase.Mode.values().length];
            a = iArr;
            try {
                iArr[PullToRefreshBase.Mode.PULL_FROM_END.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[PullToRefreshBase.Mode.PULL_FROM_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public PullToRefreshAdapterViewBase(Context context) {
        super(context);
        ((AbsListView) this.H3).setOnScrollListener(this);
    }

    private void K() {
        IndicatorLayout indicatorLayout;
        IndicatorLayout indicatorLayout2;
        PullToRefreshBase.Mode mode = getMode();
        FrameLayout refreshableViewWrapper = getRefreshableViewWrapper();
        if (mode.showHeaderLoadingLayout() && this.b4 == null) {
            this.b4 = new IndicatorLayout(getContext(), PullToRefreshBase.Mode.PULL_FROM_START);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = getResources().getDimensionPixelSize(q0.indicator_right_padding);
            layoutParams.gravity = 53;
            refreshableViewWrapper.addView(this.b4, layoutParams);
        } else if (!mode.showHeaderLoadingLayout() && (indicatorLayout2 = this.b4) != null) {
            refreshableViewWrapper.removeView(indicatorLayout2);
            this.b4 = null;
        }
        if (mode.showFooterLoadingLayout() && this.c4 == null) {
            this.c4 = new IndicatorLayout(getContext(), PullToRefreshBase.Mode.PULL_FROM_END);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.rightMargin = getResources().getDimensionPixelSize(q0.indicator_right_padding);
            layoutParams2.gravity = 85;
            refreshableViewWrapper.addView(this.c4, layoutParams2);
        } else if (!mode.showFooterLoadingLayout() && (indicatorLayout = this.c4) != null) {
            refreshableViewWrapper.removeView(indicatorLayout);
            this.c4 = null;
        }
    }

    private static FrameLayout.LayoutParams L(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return null;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            layoutParams2.gravity = ((LinearLayout.LayoutParams) layoutParams).gravity;
            return layoutParams2;
        }
        layoutParams2.gravity = 17;
        return layoutParams2;
    }

    private boolean M() {
        View childAt;
        Adapter adapter = ((AbsListView) this.H3).getAdapter();
        if (adapter == null || adapter.isEmpty()) {
            return true;
        }
        return ((AbsListView) this.H3).getFirstVisiblePosition() <= 1 && (childAt = ((AbsListView) this.H3).getChildAt(0)) != null && childAt.getTop() >= ((AbsListView) this.H3).getTop();
    }

    private boolean N() {
        Adapter adapter = ((AbsListView) this.H3).getAdapter();
        if (adapter == null || adapter.isEmpty()) {
            return true;
        }
        int lastVisiblePosition = ((AbsListView) this.H3).getLastVisiblePosition();
        if (lastVisiblePosition >= (((AbsListView) this.H3).getCount() - 1) - 1) {
            View childAt = ((AbsListView) this.H3).getChildAt(lastVisiblePosition - ((AbsListView) this.H3).getFirstVisiblePosition());
            return childAt != null && childAt.getBottom() <= ((AbsListView) this.H3).getBottom();
        }
        return false;
    }

    private void O() {
        if (this.b4 != null) {
            getRefreshableViewWrapper().removeView(this.b4);
            this.b4 = null;
        }
        if (this.c4 != null) {
            getRefreshableViewWrapper().removeView(this.c4);
            this.c4 = null;
        }
    }

    private void P() {
        if (this.b4 != null) {
            if (r() || !q()) {
                if (this.b4.b()) {
                    this.b4.a();
                }
            } else if (!this.b4.b()) {
                this.b4.e();
            }
        }
        if (this.c4 == null) {
            return;
        }
        if (r() || !p()) {
            if (this.c4.b()) {
                this.c4.a();
            }
        } else if (!this.c4.b()) {
            this.c4.e();
        }
    }

    private boolean getShowIndicatorInternal() {
        return this.d4 && m();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.handmark.pulltorefresh.library.PullToRefreshBase
    public void J() {
        super.J();
        if (getShowIndicatorInternal()) {
            K();
        } else {
            O();
        }
    }

    public boolean getShowIndicator() {
        return this.d4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.handmark.pulltorefresh.library.PullToRefreshBase
    public void k(TypedArray typedArray) {
        this.d4 = typedArray.getBoolean(x0.PullToRefresh_ptrShowIndicator, !n());
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.Z3 != null) {
            this.X3 = i3 > 0 && i + i2 >= i3 + (-1);
        }
        if (getShowIndicatorInternal()) {
            P();
        }
        AbsListView.OnScrollListener onScrollListener = this.Y3;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i, i2, i3);
        }
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        View view = this.a4;
        if (view != null && !this.e4) {
            view.scrollTo(-i, -i2);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
        PullToRefreshBase.b bVar;
        if (i == 0 && (bVar = this.Z3) != null && this.X3) {
            bVar.a();
        }
        AbsListView.OnScrollListener onScrollListener = this.Y3;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i);
        }
    }

    @Override // com.handmark.pulltorefresh.library.PullToRefreshBase
    protected boolean p() {
        return N();
    }

    @Override // com.handmark.pulltorefresh.library.PullToRefreshBase
    protected boolean q() {
        return M();
    }

    public void setAdapter(ListAdapter listAdapter) {
        ((AdapterView) this.H3).setAdapter(listAdapter);
    }

    public final void setEmptyView(View view) {
        FrameLayout refreshableViewWrapper = getRefreshableViewWrapper();
        if (view != null) {
            view.setClickable(true);
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
            FrameLayout.LayoutParams L = L(view.getLayoutParams());
            if (L != null) {
                refreshableViewWrapper.addView(view, L);
            } else {
                refreshableViewWrapper.addView(view);
            }
        }
        T t = this.H3;
        if (t instanceof com.handmark.pulltorefresh.library.internal.a) {
            ((com.handmark.pulltorefresh.library.internal.a) t).setEmptyViewInternal(view);
        } else {
            ((AbsListView) t).setEmptyView(view);
        }
        this.a4 = view;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        ((AbsListView) this.H3).setOnItemClickListener(onItemClickListener);
    }

    public final void setOnLastItemVisibleListener(PullToRefreshBase.b bVar) {
        this.Z3 = bVar;
    }

    public final void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.Y3 = onScrollListener;
    }

    public final void setScrollEmptyView(boolean z) {
        this.e4 = z;
    }

    public void setShowIndicator(boolean z) {
        this.d4 = z;
        if (getShowIndicatorInternal()) {
            K();
        } else {
            O();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.handmark.pulltorefresh.library.PullToRefreshBase
    public void v() {
        super.v();
        if (getShowIndicatorInternal()) {
            int i = a.a[getCurrentMode().ordinal()];
            if (i == 1) {
                this.c4.c();
            } else if (i == 2) {
                this.b4.c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.handmark.pulltorefresh.library.PullToRefreshBase
    public void x(boolean z) {
        super.x(z);
        if (getShowIndicatorInternal()) {
            P();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.handmark.pulltorefresh.library.PullToRefreshBase
    public void y() {
        super.y();
        if (getShowIndicatorInternal()) {
            int i = a.a[getCurrentMode().ordinal()];
            if (i == 1) {
                this.c4.d();
            } else if (i == 2) {
                this.b4.d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.handmark.pulltorefresh.library.PullToRefreshBase
    public void z() {
        super.z();
        if (getShowIndicatorInternal()) {
            P();
        }
    }

    public PullToRefreshAdapterViewBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ((AbsListView) this.H3).setOnScrollListener(this);
    }
}
