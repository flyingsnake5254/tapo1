package com.tplink.libtpcontrols.horizontalscrollpage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.libtpcontrols.horizontalscrollpage.PagingScrollHelper;

/* loaded from: classes3.dex */
public class PagingScrollHelper {

    /* renamed from: f  reason: collision with root package name */
    private c f12287f;
    private int k;
    private int l;
    private RecyclerView a = null;

    /* renamed from: b  reason: collision with root package name */
    private PageIndicatorView f12283b = null;

    /* renamed from: c  reason: collision with root package name */
    private PageScrollListener f12284c = new PageScrollListener();

    /* renamed from: d  reason: collision with root package name */
    private PageFlingListener f12285d = new PageFlingListener();

    /* renamed from: e  reason: collision with root package name */
    private b f12286e = new b();
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private int j = 0;
    private int m = 0;
    private int n = 0;
    private ValueAnimator o = null;
    private boolean p = false;
    private boolean q = false;
    private a r = a.HORIZONTAL;

    /* loaded from: classes3.dex */
    public class PageFlingListener extends RecyclerView.OnFlingListener {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class a extends AnimatorListenerAdapter {
            a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (PagingScrollHelper.this.f12287f != null) {
                    PagingScrollHelper.this.f12287f.a(PagingScrollHelper.this.u());
                }
                if (PagingScrollHelper.this.f12283b != null && !PagingScrollHelper.this.q) {
                    PagingScrollHelper.this.f12283b.setSelectedPage(PagingScrollHelper.this.u());
                }
                PagingScrollHelper pagingScrollHelper = PagingScrollHelper.this;
                pagingScrollHelper.n = pagingScrollHelper.u();
                PagingScrollHelper.this.a.stopScroll();
                PagingScrollHelper pagingScrollHelper2 = PagingScrollHelper.this;
                pagingScrollHelper2.i = pagingScrollHelper2.g;
                PagingScrollHelper pagingScrollHelper3 = PagingScrollHelper.this;
                pagingScrollHelper3.j = pagingScrollHelper3.h;
            }
        }

        public PageFlingListener() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void b(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (PagingScrollHelper.this.r == a.VERTICAL) {
                PagingScrollHelper.this.a.scrollBy(0, intValue - PagingScrollHelper.this.g);
                return;
            }
            PagingScrollHelper.this.a.scrollBy(intValue - PagingScrollHelper.this.h, 0);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnFlingListener
        public boolean onFling(int i, int i2) {
            int i3;
            int i4;
            if (PagingScrollHelper.this.r == a.NULL) {
                return false;
            }
            int v = PagingScrollHelper.this.v();
            if (PagingScrollHelper.this.r == a.VERTICAL) {
                i3 = PagingScrollHelper.this.g;
                if (i2 < 0) {
                    v--;
                } else if (i2 > 0) {
                    v++;
                }
                i4 = v * PagingScrollHelper.this.a.getHeight();
            } else {
                i3 = PagingScrollHelper.this.h;
                if (i < 0) {
                    v--;
                } else if (i > 0) {
                    v++;
                }
                i4 = v * PagingScrollHelper.this.a.getWidth();
            }
            if (!PagingScrollHelper.this.p ? i4 < 0 : i4 > 0) {
                i4 = 0;
            }
            if (PagingScrollHelper.this.o == null) {
                PagingScrollHelper.this.o = ValueAnimator.ofInt(i3, i4);
                PagingScrollHelper.this.o.setDuration(300L);
                PagingScrollHelper.this.o.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tplink.libtpcontrols.horizontalscrollpage.a
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        PagingScrollHelper.PageFlingListener.this.b(valueAnimator);
                    }
                });
                PagingScrollHelper.this.o.addListener(new a());
            } else {
                PagingScrollHelper.this.o.cancel();
                PagingScrollHelper.this.o.setIntValues(i3, i4);
            }
            PagingScrollHelper.this.o.start();
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class PageScrollListener extends RecyclerView.OnScrollListener {
        public PageScrollListener() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
            if (i == 0 && PagingScrollHelper.this.r != a.NULL) {
                a aVar = PagingScrollHelper.this.r;
                a aVar2 = a.VERTICAL;
                int i2 = NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                boolean z = true;
                i2 = 0;
                if (aVar == aVar2) {
                    if (Math.abs(PagingScrollHelper.this.g - PagingScrollHelper.this.i) <= recyclerView.getHeight() / 2) {
                        z = false;
                    }
                    if (z) {
                        if (PagingScrollHelper.this.g - PagingScrollHelper.this.i >= 0) {
                            i2 = 1000;
                        }
                        PagingScrollHelper.this.f12285d.onFling(i2, i2);
                    }
                } else {
                    if (Math.abs(PagingScrollHelper.this.h - PagingScrollHelper.this.j) <= recyclerView.getWidth() / 2) {
                        z = false;
                    }
                    if (z) {
                        if (PagingScrollHelper.this.h - PagingScrollHelper.this.j >= 0) {
                            i2 = 1000;
                        }
                    }
                }
                i2 = 0;
                PagingScrollHelper.this.f12285d.onFling(i2, i2);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            PagingScrollHelper.this.g += i2;
            PagingScrollHelper.this.h += i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public enum a {
        HORIZONTAL,
        VERTICAL,
        NULL
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            PagingScrollHelper pagingScrollHelper = PagingScrollHelper.this;
            pagingScrollHelper.i = pagingScrollHelper.g;
            PagingScrollHelper pagingScrollHelper2 = PagingScrollHelper.this;
            pagingScrollHelper2.j = pagingScrollHelper2.h;
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(int i);
    }

    public PagingScrollHelper(int i, int i2) {
        this.k = 2;
        this.l = 3;
        this.k = i;
        this.l = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int u() {
        int i;
        if (this.r == a.VERTICAL) {
            i = this.g / this.a.getHeight();
        } else {
            i = this.h / this.a.getWidth();
        }
        return Math.abs(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int v() {
        if (this.r == a.VERTICAL) {
            return this.i / this.a.getHeight();
        }
        return this.j / this.a.getWidth();
    }

    public void A() {
        RecyclerView.LayoutManager layoutManager = this.a.getLayoutManager();
        if (layoutManager != null) {
            if (layoutManager.canScrollVertically()) {
                this.r = a.VERTICAL;
            } else if (layoutManager.canScrollHorizontally()) {
                this.r = a.HORIZONTAL;
            } else {
                this.r = a.NULL;
            }
            ValueAnimator valueAnimator = this.o;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            this.j = 0;
            this.i = 0;
            this.h = 0;
            this.g = 0;
            this.n = 0;
        }
    }

    public void w(PageIndicatorView pageIndicatorView) {
        this.f12283b = pageIndicatorView;
    }

    public void x(boolean z) {
        this.p = z;
    }

    public void y(c cVar) {
        this.f12287f = cVar;
    }

    public void z(RecyclerView recyclerView) {
        if (recyclerView != null) {
            this.a = recyclerView;
            boolean z = recyclerView.getAdapter() == null || this.a.getAdapter().getItemCount() == 0;
            this.q = z;
            if (!z) {
                recyclerView.setOnFlingListener(this.f12285d);
                recyclerView.addOnScrollListener(this.f12284c);
                recyclerView.setOnTouchListener(this.f12286e);
            }
            A();
            return;
        }
        throw new IllegalArgumentException("recycleView must be not null");
    }
}
