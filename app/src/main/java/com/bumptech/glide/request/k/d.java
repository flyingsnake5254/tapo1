package com.bumptech.glide.request.k;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.g;
import com.bumptech.glide.util.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: CustomViewTarget.java */
/* loaded from: classes.dex */
public abstract class d<T extends View, Z> implements j<Z> {
    @IdRes

    /* renamed from: c  reason: collision with root package name */
    private static final int f1742c = g.glide_custom_view_target_tag;

    /* renamed from: d  reason: collision with root package name */
    private final a f1743d;

    /* renamed from: f  reason: collision with root package name */
    protected final T f1744f;
    @Nullable
    private View.OnAttachStateChangeListener q;
    private boolean x;
    private boolean y;

    /* compiled from: CustomViewTarget.java */
    @VisibleForTesting
    /* loaded from: classes.dex */
    static final class a {
        @Nullable
        @VisibleForTesting
        static Integer a;

        /* renamed from: b  reason: collision with root package name */
        private final View f1745b;

        /* renamed from: c  reason: collision with root package name */
        private final List<i> f1746c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        boolean f1747d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        private ViewTreeObserver$OnPreDrawListenerC0064a f1748e;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: CustomViewTarget.java */
        /* renamed from: com.bumptech.glide.request.k.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class ViewTreeObserver$OnPreDrawListenerC0064a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: c  reason: collision with root package name */
            private final WeakReference<a> f1749c;

            ViewTreeObserver$OnPreDrawListenerC0064a(@NonNull a aVar) {
                this.f1749c = new WeakReference<>(aVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("CustomViewTarget", 2)) {
                    Log.v("CustomViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                a aVar = this.f1749c.get();
                if (aVar == null) {
                    return true;
                }
                aVar.a();
                return true;
            }
        }

        a(@NonNull View view) {
            this.f1745b = view;
        }

        private static int c(@NonNull Context context) {
            if (a == null) {
                Display defaultDisplay = ((WindowManager) i.d((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                a = Integer.valueOf(Math.max(point.x, point.y));
            }
            return a.intValue();
        }

        private int e(int i, int i2, int i3) {
            int i4 = i2 - i3;
            if (i4 > 0) {
                return i4;
            }
            if (this.f1747d && this.f1745b.isLayoutRequested()) {
                return 0;
            }
            int i5 = i - i3;
            if (i5 > 0) {
                return i5;
            }
            if (this.f1745b.isLayoutRequested() || i2 != -2) {
                return 0;
            }
            if (Log.isLoggable("CustomViewTarget", 4)) {
                Log.i("CustomViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return c(this.f1745b.getContext());
        }

        private int f() {
            int paddingTop = this.f1745b.getPaddingTop() + this.f1745b.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f1745b.getLayoutParams();
            return e(this.f1745b.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        private int g() {
            int paddingLeft = this.f1745b.getPaddingLeft() + this.f1745b.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f1745b.getLayoutParams();
            return e(this.f1745b.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        private boolean h(int i) {
            return i > 0 || i == Integer.MIN_VALUE;
        }

        private boolean i(int i, int i2) {
            return h(i) && h(i2);
        }

        private void j(int i, int i2) {
            Iterator it = new ArrayList(this.f1746c).iterator();
            while (it.hasNext()) {
                ((i) it.next()).d(i, i2);
            }
        }

        void a() {
            if (!this.f1746c.isEmpty()) {
                int g = g();
                int f2 = f();
                if (i(g, f2)) {
                    j(g, f2);
                    b();
                }
            }
        }

        void b() {
            ViewTreeObserver viewTreeObserver = this.f1745b.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f1748e);
            }
            this.f1748e = null;
            this.f1746c.clear();
        }

        void d(@NonNull i iVar) {
            int g = g();
            int f2 = f();
            if (i(g, f2)) {
                iVar.d(g, f2);
                return;
            }
            if (!this.f1746c.contains(iVar)) {
                this.f1746c.add(iVar);
            }
            if (this.f1748e == null) {
                ViewTreeObserver viewTreeObserver = this.f1745b.getViewTreeObserver();
                ViewTreeObserver$OnPreDrawListenerC0064a aVar = new ViewTreeObserver$OnPreDrawListenerC0064a(this);
                this.f1748e = aVar;
                viewTreeObserver.addOnPreDrawListener(aVar);
            }
        }

        void k(@NonNull i iVar) {
            this.f1746c.remove(iVar);
        }
    }

    public d(@NonNull T t) {
        this.f1744f = (T) ((View) i.d(t));
        this.f1743d = new a(t);
    }

    @Nullable
    private Object g() {
        return this.f1744f.getTag(f1742c);
    }

    private void i() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.q;
        if (onAttachStateChangeListener != null && !this.y) {
            this.f1744f.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.y = true;
        }
    }

    private void k() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.q;
        if (onAttachStateChangeListener != null && this.y) {
            this.f1744f.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            this.y = false;
        }
    }

    private void n(@Nullable Object obj) {
        this.f1744f.setTag(f1742c, obj);
    }

    @Override // com.bumptech.glide.request.k.j
    public final void a(@NonNull i iVar) {
        this.f1743d.k(iVar);
    }

    @Override // com.bumptech.glide.request.k.j
    public final void b(@Nullable Drawable drawable) {
        i();
        m(drawable);
    }

    @Override // com.bumptech.glide.request.k.j
    @Nullable
    public final com.bumptech.glide.request.d c() {
        Object g = g();
        if (g == null) {
            return null;
        }
        if (g instanceof com.bumptech.glide.request.d) {
            return (com.bumptech.glide.request.d) g;
        }
        throw new IllegalArgumentException("You must not pass non-R.id ids to setTag(id)");
    }

    @Override // com.bumptech.glide.request.k.j
    public final void d(@Nullable Drawable drawable) {
        this.f1743d.b();
        l(drawable);
        if (!this.x) {
            k();
        }
    }

    @Override // com.bumptech.glide.request.k.j
    public final void f(@Nullable com.bumptech.glide.request.d dVar) {
        n(dVar);
    }

    @Override // com.bumptech.glide.request.k.j
    public final void j(@NonNull i iVar) {
        this.f1743d.d(iVar);
    }

    protected abstract void l(@Nullable Drawable drawable);

    protected void m(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.manager.m
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.m
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.m
    public void onStop() {
    }

    public String toString() {
        return "Target for: " + this.f1744f;
    }
}
