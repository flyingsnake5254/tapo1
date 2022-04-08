package com.yinglan.scrolllayout.content;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.yinglan.scrolllayout.ScrollLayout;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ContentRecyclerView extends RecyclerView {

    /* renamed from: c  reason: collision with root package name */
    private final b f15342c;

    /* loaded from: classes3.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ViewGroup.LayoutParams layoutParams = ContentRecyclerView.this.getLayoutParams();
            ViewParent parent = ContentRecyclerView.this.getParent();
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
            ContentRecyclerView.this.setLayoutParams(layoutParams);
        }
    }

    public ContentRecyclerView(Context context) {
        super(context);
        b bVar = new b(this, null);
        this.f15342c = bVar;
        super.addOnScrollListener(bVar);
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof ScrollLayout) {
                ((ScrollLayout) parent).setAssociatedRecyclerView(this);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    /* loaded from: classes3.dex */
    private class b extends RecyclerView.OnScrollListener {
        private final List<RecyclerView.OnScrollListener> a;

        private b() {
            this.a = new ArrayList();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            for (RecyclerView.OnScrollListener onScrollListener : new ArrayList(this.a)) {
                onScrollListener.onScrollStateChanged(recyclerView, i);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            for (RecyclerView.OnScrollListener onScrollListener : new ArrayList(this.a)) {
                onScrollListener.onScrolled(recyclerView, i, i2);
            }
        }

        /* synthetic */ b(ContentRecyclerView contentRecyclerView, a aVar) {
            this();
        }
    }

    public ContentRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b bVar = new b(this, null);
        this.f15342c = bVar;
        super.addOnScrollListener(bVar);
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    public ContentRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b bVar = new b(this, null);
        this.f15342c = bVar;
        super.addOnScrollListener(bVar);
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }
}
