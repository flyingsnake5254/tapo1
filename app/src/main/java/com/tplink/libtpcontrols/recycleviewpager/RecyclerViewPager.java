package com.tplink.libtpcontrols.recycleviewpager;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.libtpcontrols.x0;
import java.lang.reflect.Field;
import java.util.List;

/* loaded from: classes3.dex */
public class RecyclerViewPager extends RecyclerView {
    View H3;
    int I3;
    int J3;
    int K3;
    int L3;
    private int M3;
    private boolean N3;
    private boolean O3;

    /* renamed from: c  reason: collision with root package name */
    private RecyclerViewPagerAdapter<?> f12386c;

    /* renamed from: d  reason: collision with root package name */
    private float f12387d;

    /* renamed from: f  reason: collision with root package name */
    private float f12388f;
    private boolean p0;
    boolean p1;
    int p2;
    int p3;
    private float q;
    private List<c> x;
    private int y;
    private int z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends LinearSmoothScroller {
        a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public PointF computeScrollVectorForPosition(int i) {
            if (getLayoutManager() == null) {
                return null;
            }
            return ((LinearLayoutManager) getLayoutManager()).computeScrollVectorForPosition(i);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
        protected void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
            int i;
            int i2;
            if (getLayoutManager() != null) {
                int calculateDxToMakeVisible = calculateDxToMakeVisible(view, getHorizontalSnapPreference());
                int calculateDyToMakeVisible = calculateDyToMakeVisible(view, getVerticalSnapPreference());
                if (calculateDxToMakeVisible > 0) {
                    i = calculateDxToMakeVisible - getLayoutManager().getLeftDecorationWidth(view);
                } else {
                    i = calculateDxToMakeVisible + getLayoutManager().getRightDecorationWidth(view);
                }
                if (calculateDyToMakeVisible > 0) {
                    i2 = calculateDyToMakeVisible - getLayoutManager().getTopDecorationHeight(view);
                } else {
                    i2 = calculateDyToMakeVisible + getLayoutManager().getBottomDecorationHeight(view);
                }
                int calculateTimeForDeceleration = calculateTimeForDeceleration((int) Math.sqrt((i * i) + (i2 * i2)));
                if (calculateTimeForDeceleration > 0) {
                    action.update(-i, -i2, calculateTimeForDeceleration, this.mDecelerateInterpolator);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 16) {
                RecyclerViewPager.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            } else {
                RecyclerViewPager.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
            if (RecyclerViewPager.this.y >= 0 && RecyclerViewPager.this.y < RecyclerViewPager.this.f12386c.getItemCount() && RecyclerViewPager.this.x != null) {
                for (c cVar : RecyclerViewPager.this.x) {
                    if (cVar != null) {
                        cVar.a(RecyclerViewPager.this.z, RecyclerViewPager.this.getCurrentPosition());
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(int i, int i2);
    }

    public RecyclerViewPager(Context context) {
        this(context, null);
    }

    private int h(int i, int i2) {
        if (i == 0) {
            return 0;
        }
        int i3 = i > 0 ? 1 : -1;
        return (int) (i3 * Math.ceil((((i * i3) * this.f12388f) / i2) - this.f12387d));
    }

    private void i(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, x0.RecyclerViewPager, i, 0);
        this.f12388f = obtainStyledAttributes.getFloat(x0.RecyclerViewPager_rvp_flingFactor, 0.15f);
        this.f12387d = obtainStyledAttributes.getFloat(x0.RecyclerViewPager_rvp_triggerOffset, 0.25f);
        this.p0 = obtainStyledAttributes.getBoolean(x0.RecyclerViewPager_rvp_singlePageFling, this.p0);
        obtainStyledAttributes.recycle();
    }

    private int j(int i, int i2) {
        if (i < 0) {
            return 0;
        }
        return i >= i2 ? i2 - 1 : i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int i;
        if (motionEvent.getAction() == 0) {
            if (getLayoutManager().canScrollHorizontally()) {
                i = a.b(this);
            } else {
                i = a.d(this);
            }
            this.M3 = i;
            b.d.w.c.a.c("@", "mPositionOnTouchDown:" + this.M3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0098, code lost:
        if (r6.O3 == false) goto L_0x009a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x009a, code lost:
        r7 = r7 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x009d, code lost:
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00bb, code lost:
        if (r6.O3 == false) goto L_0x009d;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void e(int r7) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.libtpcontrols.recycleviewpager.RecyclerViewPager.e(int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x006c, code lost:
        if (r5.O3 == false) goto L_0x006e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006e, code lost:
        r6 = r6 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0071, code lost:
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x008f, code lost:
        if (r5.O3 == false) goto L_0x0071;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void f(int r6) {
        /*
            r5 = this;
            boolean r0 = r5.O3
            if (r0 == 0) goto L_0x0006
            int r6 = r6 * (-1)
        L_0x0006:
            int r0 = r5.getChildCount()
            if (r0 <= 0) goto L_0x00cb
            int r0 = com.tplink.libtpcontrols.recycleviewpager.a.d(r5)
            int r1 = r5.getHeight()
            int r2 = r5.getPaddingTop()
            int r1 = r1 - r2
            int r2 = r5.getPaddingBottom()
            int r1 = r1 - r2
            int r6 = r5.h(r6, r1)
            int r1 = r0 + r6
            boolean r2 = r5.p0
            r3 = 1
            if (r2 == 0) goto L_0x0039
            int r6 = java.lang.Math.min(r3, r6)
            r1 = -1
            int r6 = java.lang.Math.max(r1, r6)
            if (r6 != 0) goto L_0x0036
            r1 = r0
            goto L_0x0039
        L_0x0036:
            int r1 = r5.M3
            int r1 = r1 + r6
        L_0x0039:
            r6 = 0
            int r6 = java.lang.Math.max(r1, r6)
            com.tplink.libtpcontrols.recycleviewpager.RecyclerViewPagerAdapter<?> r1 = r5.f12386c
            int r1 = r1.getItemCount()
            int r1 = r1 - r3
            int r6 = java.lang.Math.min(r6, r1)
            if (r6 != r0) goto L_0x0092
            boolean r1 = r5.p0
            if (r1 == 0) goto L_0x0053
            int r1 = r5.M3
            if (r1 != r0) goto L_0x0092
        L_0x0053:
            android.view.View r0 = com.tplink.libtpcontrols.recycleviewpager.a.c(r5)
            if (r0 == 0) goto L_0x0092
            float r1 = r5.q
            int r2 = r0.getHeight()
            float r2 = (float) r2
            float r4 = r5.f12387d
            float r2 = r2 * r4
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 <= 0) goto L_0x0074
            if (r6 == 0) goto L_0x0074
            boolean r0 = r5.O3
            if (r0 != 0) goto L_0x0071
        L_0x006e:
            int r6 = r6 + (-1)
            goto L_0x0092
        L_0x0071:
            int r6 = r6 + 1
            goto L_0x0092
        L_0x0074:
            float r1 = r5.q
            int r0 = r0.getHeight()
            float r0 = (float) r0
            float r2 = r5.f12387d
            float r2 = -r2
            float r0 = r0 * r2
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x0092
            com.tplink.libtpcontrols.recycleviewpager.RecyclerViewPagerAdapter<?> r0 = r5.f12386c
            int r0 = r0.getItemCount()
            int r0 = r0 - r3
            if (r6 == r0) goto L_0x0092
            boolean r0 = r5.O3
            if (r0 != 0) goto L_0x006e
            goto L_0x0071
        L_0x0092:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "mTouchSpan:"
            r0.append(r1)
            float r1 = r5.q
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "@"
            b.d.w.c.a.c(r1, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "adjustPositionY:"
            r0.append(r2)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            b.d.w.c.a.c(r1, r0)
            com.tplink.libtpcontrols.recycleviewpager.RecyclerViewPagerAdapter<?> r0 = r5.f12386c
            int r0 = r0.getItemCount()
            int r6 = r5.j(r6, r0)
            r5.smoothScrollToPosition(r6)
        L_0x00cb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.libtpcontrols.recycleviewpager.RecyclerViewPager.f(int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean fling(int i, int i2) {
        float f2 = this.f12388f;
        boolean fling = super.fling((int) (i * f2), (int) (i2 * f2));
        if (fling) {
            if (getLayoutManager().canScrollHorizontally()) {
                e(i);
            } else {
                f(i2);
            }
        }
        b.d.w.c.a.c("@", "velocityX:" + i);
        b.d.w.c.a.c("@", "velocityY:" + i2);
        return fling;
    }

    @NonNull
    protected RecyclerViewPagerAdapter g(RecyclerView.Adapter adapter) {
        return adapter instanceof RecyclerViewPagerAdapter ? (RecyclerViewPagerAdapter) adapter : new RecyclerViewPagerAdapter(this, adapter);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public RecyclerView.Adapter getAdapter() {
        RecyclerViewPagerAdapter<?> recyclerViewPagerAdapter = this.f12386c;
        if (recyclerViewPagerAdapter != null) {
            return recyclerViewPagerAdapter.f12390b;
        }
        return null;
    }

    public int getCurrentPosition() {
        int i;
        if (getLayoutManager().canScrollHorizontally()) {
            i = a.b(this);
        } else {
            i = a.d(this);
        }
        return i < 0 ? this.y : i;
    }

    public float getFlingFactor() {
        return this.f12388f;
    }

    public float getTriggerOffset() {
        return this.f12387d;
    }

    public RecyclerViewPagerAdapter getWrapperAdapter() {
        return this.f12386c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        try {
            Field declaredField = parcelable.getClass().getDeclaredField("mLayoutState");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(parcelable);
            Field declaredField2 = obj.getClass().getDeclaredField("mAnchorOffset");
            Field declaredField3 = obj.getClass().getDeclaredField("mAnchorPosition");
            declaredField3.setAccessible(true);
            declaredField2.setAccessible(true);
            if (declaredField2.getInt(obj) > 0) {
                declaredField3.set(obj, Integer.valueOf(declaredField3.getInt(obj) - 1));
            } else if (declaredField2.getInt(obj) < 0) {
                declaredField3.set(obj, Integer.valueOf(declaredField3.getInt(obj) + 1));
            }
            declaredField2.setInt(obj, 0);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e1, code lost:
        if (r6.O3 == false) goto L_0x012a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0100, code lost:
        if (r6.O3 == false) goto L_0x012d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0128, code lost:
        if (r6.O3 == false) goto L_0x012a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x012a, code lost:
        r7 = r7 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x012d, code lost:
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x014c, code lost:
        if (r6.O3 == false) goto L_0x012d;
     */
    @Override // androidx.recyclerview.widget.RecyclerView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onScrollStateChanged(int r7) {
        /*
            Method dump skipped, instructions count: 429
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.libtpcontrols.recycleviewpager.RecyclerViewPager.onScrollStateChanged(int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        View view;
        if (motionEvent.getAction() == 2 && (view = this.H3) != null) {
            this.I3 = Math.max(view.getLeft(), this.I3);
            this.K3 = Math.max(this.H3.getTop(), this.K3);
            this.J3 = Math.min(this.H3.getLeft(), this.J3);
            this.L3 = Math.min(this.H3.getTop(), this.L3);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void scrollToPosition(int i) {
        b.d.w.c.a.c("@", "scrollToPosition:" + i);
        this.z = getCurrentPosition();
        this.y = i;
        super.scrollToPosition(i);
        getViewTreeObserver().addOnGlobalLayoutListener(new b());
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        RecyclerViewPagerAdapter g = g(adapter);
        this.f12386c = g;
        super.setAdapter(g);
    }

    public void setFlingFactor(float f2) {
        this.f12388f = f2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        super.setLayoutManager(layoutManager);
        if (layoutManager instanceof LinearLayoutManager) {
            this.O3 = ((LinearLayoutManager) layoutManager).getReverseLayout();
        }
    }

    public void setSinglePageFling(boolean z) {
        this.p0 = z;
    }

    public void setTriggerOffset(float f2) {
        this.f12387d = f2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void smoothScrollToPosition(int i) {
        b.d.w.c.a.c("@", "smoothScrollToPosition:" + i);
        this.y = i;
        if (getLayoutManager() == null || !(getLayoutManager() instanceof LinearLayoutManager)) {
            super.smoothScrollToPosition(i);
            return;
        }
        a aVar = new a(getContext());
        aVar.setTargetPosition(i);
        if (i != -1) {
            getLayoutManager().startSmoothScroll(aVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void swapAdapter(RecyclerView.Adapter adapter, boolean z) {
        RecyclerViewPagerAdapter g = g(adapter);
        this.f12386c = g;
        super.swapAdapter(g, z);
    }

    public RecyclerViewPager(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerViewPager(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12387d = 0.25f;
        this.f12388f = 0.15f;
        this.y = -1;
        this.z = -1;
        this.I3 = Integer.MIN_VALUE;
        this.J3 = Integer.MAX_VALUE;
        this.K3 = Integer.MIN_VALUE;
        this.L3 = Integer.MAX_VALUE;
        this.M3 = -1;
        this.N3 = true;
        this.O3 = false;
        i(context, attributeSet, i);
        setNestedScrollingEnabled(false);
    }
}
