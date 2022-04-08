package com.tplink.libtpcontrols.snaprecycleview;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.core.text.TextUtilsCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public class SnappingRecyclerView extends RecyclerView {
    private boolean H3;
    private boolean I3;

    /* renamed from: c  reason: collision with root package name */
    private boolean f12414c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f12415d;

    /* renamed from: f  reason: collision with root package name */
    private int f12416f;
    private c p0;
    private d p1;
    private int p2;
    private boolean p3;
    private long q;
    private Handler x;
    private boolean y;
    private Orientation z;

    /* loaded from: classes3.dex */
    public enum Orientation {
        HORIZONTAL(0),
        VERTICAL(1);
        
        int value;

        Orientation(int i) {
            this.value = i;
        }

        public int intValue() {
            return this.value;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            SnappingRecyclerView.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1) {
                if (!SnappingRecyclerView.this.f12415d) {
                    SnappingRecyclerView.this.f12414c = true;
                }
            } else if (i == 0) {
                if (SnappingRecyclerView.this.f12414c) {
                    SnappingRecyclerView snappingRecyclerView = SnappingRecyclerView.this;
                    snappingRecyclerView.r(snappingRecyclerView.getCenterView());
                }
                SnappingRecyclerView.this.f12414c = false;
                SnappingRecyclerView.this.f12415d = false;
                if (SnappingRecyclerView.this.getCenterView() != null) {
                    SnappingRecyclerView snappingRecyclerView2 = SnappingRecyclerView.this;
                    if (snappingRecyclerView2.m(snappingRecyclerView2.getCenterView()) > 0.0f) {
                        SnappingRecyclerView snappingRecyclerView3 = SnappingRecyclerView.this;
                        snappingRecyclerView3.r(snappingRecyclerView3.getCenterView());
                    }
                }
                SnappingRecyclerView.this.q();
            } else if (i == 2) {
                SnappingRecyclerView.this.f12415d = true;
            }
            SnappingRecyclerView.this.f12416f = i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            SnappingRecyclerView.this.t();
            super.onScrolled(recyclerView, i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class c {
        private Orientation a;

        public c(Orientation orientation) {
            this.a = orientation;
        }

        public float a(View view) {
            return b(view) + (c(view) / 2);
        }

        public float b(View view) {
            if (this.a == Orientation.VERTICAL) {
                return view.getY();
            }
            return view.getX();
        }

        public int c(View view) {
            if (this.a == Orientation.VERTICAL) {
                return view.getHeight();
            }
            return view.getWidth();
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(View view, int i);
    }

    public SnappingRecyclerView(Context context) {
        this(context, null);
    }

    private int getCenterLocation() {
        if (this.z == Orientation.VERTICAL) {
            return getMeasuredHeight() / 2;
        }
        return getMeasuredWidth() / 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View getCenterView() {
        return l(getCenterLocation());
    }

    private void k() {
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
        addOnScrollListener(new b());
    }

    private View l(int i) {
        View view = null;
        if (getChildCount() <= 0) {
            return null;
        }
        int i2 = 9999;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            int a2 = ((int) this.p0.a(childAt)) - i;
            if (Math.abs(a2) < Math.abs(i2)) {
                view = childAt;
                i2 = a2;
            }
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float m(View view) {
        float centerLocation = getCenterLocation();
        float a2 = this.p0.a(view);
        return (Math.max(centerLocation, a2) - Math.min(centerLocation, a2)) / (centerLocation + this.p0.c(view));
    }

    private int n(View view) {
        return ((int) this.p0.a(view)) - getCenterLocation();
    }

    private void o() {
        setHasFixedSize(true);
        setOrientation(this.z);
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        View centerView = getCenterView();
        int childAdapterPosition = getChildAdapterPosition(centerView);
        d dVar = this.p1;
        if (!(dVar == null || childAdapterPosition == this.p2)) {
            dVar.a(centerView, childAdapterPosition);
        }
        this.p2 = childAdapterPosition;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(View view) {
        if (view != null) {
            stopScroll();
            int n = n(view);
            if (n != 0) {
                s(n);
            }
        }
    }

    private void setMarginsForChild(View view) {
        int i;
        int i2;
        int i3;
        int itemCount = getLayoutManager().getItemCount() - 1;
        int childAdapterPosition = getChildAdapterPosition(view);
        int i4 = 0;
        if (this.z == Orientation.VERTICAL) {
            i = childAdapterPosition == 0 ? getCenterLocation() : 0;
            i2 = childAdapterPosition == itemCount ? getCenterLocation() : 0;
            i3 = 0;
        } else {
            i4 = childAdapterPosition == 0 ? getCenterLocation() : 0;
            i3 = childAdapterPosition == itemCount ? getCenterLocation() : 0;
            i2 = 0;
            i = 0;
        }
        if (this.z == Orientation.HORIZONTAL && Build.VERSION.SDK_INT >= 17) {
            ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).setMarginStart(i4);
            ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).setMarginEnd(i3);
        }
        if (ViewCompat.getLayoutDirection(view) == 1) {
            ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).setMargins(i3, i, i4, i2);
        } else {
            ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).setMargins(i4, i, i3, i2);
        }
        if (Build.VERSION.SDK_INT >= 18 && !view.isInLayout()) {
            view.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        SnapViewHolder snapViewHolder;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            setMarginsForChild(childAt);
            if (this.y) {
                float m = 1.0f - (m(childAt) * 0.6f);
                childAt.setScaleX(m);
                childAt.setScaleY(m);
            }
            if (this.p3) {
                float m2 = m(childAt);
                if (this.H3) {
                    childAt.setAlpha(1.0f - m2);
                    try {
                        snapViewHolder = (SnapViewHolder) getChildViewHolder(childAt);
                    } catch (ClassCastException unused) {
                        snapViewHolder = null;
                    }
                    if (m2 < 0.3f) {
                        if (snapViewHolder != null) {
                            snapViewHolder.a.setVisibility(0);
                        }
                    } else if (snapViewHolder != null) {
                        snapViewHolder.a.setVisibility(4);
                    }
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f12415d && this.f12416f == 1 && currentTimeMillis - this.q < 20) {
            this.f12414c = true;
        }
        this.q = currentTimeMillis;
        View l = l((int) (this.z == Orientation.VERTICAL ? motionEvent.getY() : motionEvent.getX()));
        if (this.f12414c || motionEvent.getAction() != 1 || l == getCenterView()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        r(l);
        return true;
    }

    public int getScrollOffset() {
        if (this.z == Orientation.VERTICAL) {
            return computeVerticalScrollOffset();
        }
        return computeHorizontalScrollOffset();
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onChildAttachedToWindow(@NonNull View view) {
        super.onChildAttachedToWindow(view);
        if (!this.I3 && this.f12416f == 0) {
            this.I3 = true;
            r(getCenterView());
            t();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.x.removeCallbacksAndMessages(null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (l((int) (this.z == Orientation.VERTICAL ? motionEvent.getY() : motionEvent.getX())) != getCenterView()) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    protected boolean p() {
        return Build.VERSION.SDK_INT >= 17 && TextUtilsCompat.getLayoutDirectionFromLocale(getContext().getResources().getConfiguration().locale) == 1;
    }

    public void s(int i) {
        if (this.z == Orientation.VERTICAL) {
            super.smoothScrollBy(0, i);
        } else {
            super.smoothScrollBy(i, 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void scrollToPosition(int i) {
        if (p()) {
            i = -i;
        }
        this.p0.c(getChildAt(0));
        s(this.p0.c(getChildAt(0)) * i);
    }

    public void setOnViewSelectedListener(d dVar) {
        this.p1 = dVar;
    }

    public void setOrientation(Orientation orientation) {
        this.z = orientation;
        this.p0 = new c(orientation);
        setLayoutManager(new LinearLayoutManager(getContext(), this.z.intValue(), false));
    }

    public SnappingRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SnappingRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12414c = false;
        this.f12415d = false;
        this.f12416f = 0;
        this.q = 0L;
        this.x = new Handler();
        this.y = false;
        this.z = Orientation.HORIZONTAL;
        this.p3 = false;
        this.H3 = true;
        o();
    }
}
