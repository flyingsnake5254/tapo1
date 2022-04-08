package com.tplink.libtpcontrols;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.Scroller;
import java.util.LinkedList;
import java.util.Queue;

/* loaded from: classes3.dex */
public class TPHorizontalListView extends AdapterView<ListAdapter> {
    private AdapterView.OnItemClickListener H3;
    private AdapterView.OnItemLongClickListener I3;

    /* renamed from: c  reason: collision with root package name */
    protected ListAdapter f12120c;
    protected Scroller p0;
    private GestureDetector p1;
    private AdapterView.OnItemSelectedListener p3;
    protected int q;
    protected int x;

    /* renamed from: d  reason: collision with root package name */
    private int f12121d = -1;

    /* renamed from: f  reason: collision with root package name */
    private int f12122f = 0;
    private int y = Integer.MAX_VALUE;
    private int z = 0;
    private Queue<View> p2 = new LinkedList();
    private boolean J3 = false;
    private DataSetObserver K3 = new a();
    private GestureDetector.OnGestureListener L3 = new b();

    /* loaded from: classes3.dex */
    class a extends DataSetObserver {
        a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            synchronized (TPHorizontalListView.this) {
                TPHorizontalListView.this.J3 = true;
            }
            TPHorizontalListView.this.invalidate();
            TPHorizontalListView.this.requestLayout();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            TPHorizontalListView.this.p();
            TPHorizontalListView.this.invalidate();
            TPHorizontalListView.this.requestLayout();
        }
    }

    /* loaded from: classes3.dex */
    class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        private boolean a(MotionEvent motionEvent, View view) {
            Rect rect = new Rect();
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            rect.set(i, i2, view.getWidth() + i, view.getHeight() + i2);
            return rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return TPHorizontalListView.this.l(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return TPHorizontalListView.this.m(motionEvent, motionEvent2, f2, f3);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            int childCount = TPHorizontalListView.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = TPHorizontalListView.this.getChildAt(i);
                if (a(motionEvent, childAt)) {
                    if (TPHorizontalListView.this.I3 != null) {
                        AdapterView.OnItemLongClickListener onItemLongClickListener = TPHorizontalListView.this.I3;
                        TPHorizontalListView tPHorizontalListView = TPHorizontalListView.this;
                        int i2 = tPHorizontalListView.f12121d + 1 + i;
                        TPHorizontalListView tPHorizontalListView2 = TPHorizontalListView.this;
                        onItemLongClickListener.onItemLongClick(tPHorizontalListView, childAt, i2, tPHorizontalListView2.f12120c.getItemId(tPHorizontalListView2.f12121d + 1 + i));
                        return;
                    } else {
                        return;
                    }
                }
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            TPHorizontalListView tPHorizontalListView;
            synchronized (TPHorizontalListView.this) {
                tPHorizontalListView = TPHorizontalListView.this;
                tPHorizontalListView.x += (int) f2;
            }
            tPHorizontalListView.requestLayout();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            int i = 0;
            while (true) {
                if (i >= TPHorizontalListView.this.getChildCount()) {
                    break;
                }
                View childAt = TPHorizontalListView.this.getChildAt(i);
                if (a(motionEvent, childAt)) {
                    if (TPHorizontalListView.this.H3 != null) {
                        AdapterView.OnItemClickListener onItemClickListener = TPHorizontalListView.this.H3;
                        TPHorizontalListView tPHorizontalListView = TPHorizontalListView.this;
                        int i2 = tPHorizontalListView.f12121d + 1 + i;
                        TPHorizontalListView tPHorizontalListView2 = TPHorizontalListView.this;
                        onItemClickListener.onItemClick(tPHorizontalListView, childAt, i2, tPHorizontalListView2.f12120c.getItemId(tPHorizontalListView2.f12121d + 1 + i));
                    }
                    if (TPHorizontalListView.this.p3 != null) {
                        AdapterView.OnItemSelectedListener onItemSelectedListener = TPHorizontalListView.this.p3;
                        TPHorizontalListView tPHorizontalListView3 = TPHorizontalListView.this;
                        int i3 = tPHorizontalListView3.f12121d + 1 + i;
                        TPHorizontalListView tPHorizontalListView4 = TPHorizontalListView.this;
                        onItemSelectedListener.onItemSelected(tPHorizontalListView3, childAt, i3, tPHorizontalListView4.f12120c.getItemId(tPHorizontalListView4.f12121d + 1 + i));
                    }
                } else {
                    i++;
                }
            }
            return true;
        }
    }

    public TPHorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k();
    }

    private void g(View view, int i) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -1);
        }
        addViewInLayout(view, i, layoutParams, true);
        view.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE));
    }

    private void h(int i) {
        View childAt = getChildAt(getChildCount() - 1);
        int i2 = 0;
        j(childAt != null ? childAt.getRight() : 0, i);
        View childAt2 = getChildAt(0);
        if (childAt2 != null) {
            i2 = childAt2.getLeft();
        }
        i(i2, i);
    }

    private void i(int i, int i2) {
        int i3;
        while (i + i2 > 0 && (i3 = this.f12121d) >= 0) {
            View view = this.f12120c.getView(i3, this.p2.poll(), this);
            g(view, 0);
            i -= view.getMeasuredWidth();
            this.f12121d--;
            this.z -= view.getMeasuredWidth();
        }
    }

    private void j(int i, int i2) {
        while (i + i2 < getWidth() && this.f12122f < this.f12120c.getCount()) {
            View view = this.f12120c.getView(this.f12122f, this.p2.poll(), this);
            g(view, -1);
            i += view.getMeasuredWidth();
            if (this.f12122f == this.f12120c.getCount() - 1) {
                this.y = (this.q + i) - getWidth();
            }
            if (this.y < 0) {
                this.y = 0;
            }
            this.f12122f++;
        }
    }

    private synchronized void k() {
        this.f12121d = -1;
        this.f12122f = 0;
        this.z = 0;
        this.q = 0;
        this.x = 0;
        this.y = Integer.MAX_VALUE;
        this.p0 = new Scroller(getContext());
        this.p1 = new GestureDetector(getContext(), this.L3);
    }

    private void n(int i) {
        if (getChildCount() > 0) {
            int i2 = this.z + i;
            this.z = i2;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i2, 0, i2 + measuredWidth, childAt.getMeasuredHeight());
                i2 += measuredWidth + childAt.getPaddingRight();
            }
        }
    }

    private void o(int i) {
        View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i <= 0) {
            this.z += childAt.getMeasuredWidth();
            this.p2.offer(childAt);
            removeViewInLayout(childAt);
            this.f12121d++;
            childAt = getChildAt(0);
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        while (childAt2 != null && childAt2.getLeft() + i >= getWidth()) {
            this.p2.offer(childAt2);
            removeViewInLayout(childAt2);
            this.f12122f--;
            childAt2 = getChildAt(getChildCount() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void p() {
        k();
        removeAllViewsInLayout();
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.p1.onTouchEvent(motionEvent) | super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.AdapterView
    public View getSelectedView() {
        return null;
    }

    protected boolean l(MotionEvent motionEvent) {
        this.p0.forceFinished(true);
        return true;
    }

    protected boolean m(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        synchronized (this) {
            this.p0.fling(this.x, 0, (int) (-f2), 0, 0, this.y, 0, 0);
        }
        requestLayout();
        return true;
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected synchronized void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f12120c != null) {
            if (this.J3) {
                int i5 = this.q;
                k();
                removeAllViewsInLayout();
                this.x = i5;
                this.J3 = false;
            }
            if (this.p0.computeScrollOffset()) {
                this.x = this.p0.getCurrX();
            }
            if (this.x <= 0) {
                this.x = 0;
                this.p0.forceFinished(true);
            }
            int i6 = this.x;
            int i7 = this.y;
            if (i6 >= i7) {
                this.x = i7;
                this.p0.forceFinished(true);
            }
            int i8 = this.q - this.x;
            o(i8);
            h(i8);
            n(i8);
            this.q = this.x;
            if (!this.p0.isFinished()) {
                post(new Runnable() { // from class: com.tplink.libtpcontrols.k0
                    @Override // java.lang.Runnable
                    public final void run() {
                        TPHorizontalListView.this.requestLayout();
                    }
                });
            }
        }
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.H3 = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.I3 = onItemLongClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.p3 = onItemSelectedListener;
    }

    @Override // android.widget.AdapterView
    public void setSelection(int i) {
    }

    @Override // android.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.f12120c;
    }

    public void setAdapter(ListAdapter listAdapter) {
        ListAdapter listAdapter2 = this.f12120c;
        if (listAdapter2 != null) {
            listAdapter2.unregisterDataSetObserver(this.K3);
        }
        this.f12120c = listAdapter;
        listAdapter.registerDataSetObserver(this.K3);
        p();
    }
}
