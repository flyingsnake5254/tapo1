package com.yinglan.scrolllayout.content;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.ListView;
import com.yinglan.scrolllayout.ScrollLayout;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ContentListView extends ListView {

    /* renamed from: c  reason: collision with root package name */
    private final c f15335c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f15336d = false;

    /* renamed from: f  reason: collision with root package name */
    private View f15337f;

    /* loaded from: classes3.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ViewGroup.LayoutParams layoutParams = ContentListView.this.getLayoutParams();
            ViewParent parent = ContentListView.this.getParent();
            while (true) {
                if (parent == null) {
                    break;
                } else if (parent instanceof ScrollLayout) {
                    ScrollLayout scrollLayout = (ScrollLayout) parent;
                    int measuredHeight = scrollLayout.getMeasuredHeight() - scrollLayout.O3;
                    if (layoutParams.height != measuredHeight) {
                        layoutParams.height = measuredHeight;
                    } else {
                        return;
                    }
                } else {
                    parent = parent.getParent();
                }
            }
            ContentListView.this.setLayoutParams(layoutParams);
        }
    }

    /* loaded from: classes3.dex */
    class b implements AbsListView.OnScrollListener {
        b() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt = absListView.getChildAt(0);
            if (childAt == null) {
                return;
            }
            if (i == 0 && childAt.getTop() == 0) {
                ContentListView.this.f15336d = false;
                ContentListView.this.e();
            } else if (!ContentListView.this.f15336d) {
                ContentListView.this.f15336d = true;
                ContentListView.this.e();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
        }
    }

    public ContentListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c cVar = new c(this, null);
        this.f15335c = cVar;
        super.setOnScrollListener(cVar);
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        View view = this.f15337f;
        if (view != null && view.getVisibility() != 0) {
            this.f15337f.setVisibility(0);
        }
    }

    private void f() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("Must be invoked from the main thread.");
        }
    }

    public void d(AbsListView.OnScrollListener onScrollListener) {
        f();
        this.f15335c.a(onScrollListener);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof ScrollLayout) {
                ((ScrollLayout) parent).setAssociatedListView(this);
                return;
            }
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        d(onScrollListener);
    }

    public void setTopShadowView(View view) {
        if (view != null) {
            this.f15337f = view;
            d(new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c implements AbsListView.OnScrollListener {

        /* renamed from: c  reason: collision with root package name */
        private final List<AbsListView.OnScrollListener> f15340c;

        private c() {
            this.f15340c = new ArrayList();
        }

        public void a(AbsListView.OnScrollListener onScrollListener) {
            if (onScrollListener != null) {
                for (AbsListView.OnScrollListener onScrollListener2 : this.f15340c) {
                    if (onScrollListener == onScrollListener2) {
                        return;
                    }
                }
                this.f15340c.add(onScrollListener);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            for (AbsListView.OnScrollListener onScrollListener : new ArrayList(this.f15340c)) {
                onScrollListener.onScroll(absListView, i, i2, i3);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            for (AbsListView.OnScrollListener onScrollListener : new ArrayList(this.f15340c)) {
                onScrollListener.onScrollStateChanged(absListView, i);
            }
        }

        /* synthetic */ c(ContentListView contentListView, a aVar) {
            this();
        }
    }

    public ContentListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c cVar = new c(this, null);
        this.f15335c = cVar;
        super.setOnScrollListener(cVar);
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    public ContentListView(Context context) {
        super(context);
        c cVar = new c(this, null);
        this.f15335c = cVar;
        super.setOnScrollListener(cVar);
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }
}
