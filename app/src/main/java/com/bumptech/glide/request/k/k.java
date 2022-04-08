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
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.g;
import com.bumptech.glide.request.d;
import com.bumptech.glide.util.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ViewTarget.java */
@Deprecated
/* loaded from: classes.dex */
public abstract class k<T extends View, Z> extends a<Z> {

    /* renamed from: d  reason: collision with root package name */
    private static boolean f1752d;

    /* renamed from: f  reason: collision with root package name */
    private static int f1753f = g.glide_custom_view_target_tag;
    private boolean p0;
    protected final T q;
    private final a x;
    @Nullable
    private View.OnAttachStateChangeListener y;
    private boolean z;

    /* compiled from: ViewTarget.java */
    @VisibleForTesting
    /* loaded from: classes.dex */
    static final class a {
        @Nullable
        @VisibleForTesting
        static Integer a;

        /* renamed from: b  reason: collision with root package name */
        private final View f1754b;

        /* renamed from: c  reason: collision with root package name */
        private final List<i> f1755c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        boolean f1756d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        private ViewTreeObserver$OnPreDrawListenerC0065a f1757e;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: ViewTarget.java */
        /* renamed from: com.bumptech.glide.request.k.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class ViewTreeObserver$OnPreDrawListenerC0065a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: c  reason: collision with root package name */
            private final WeakReference<a> f1758c;

            ViewTreeObserver$OnPreDrawListenerC0065a(@NonNull a aVar) {
                this.f1758c = new WeakReference<>(aVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    Log.v("ViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                a aVar = this.f1758c.get();
                if (aVar == null) {
                    return true;
                }
                aVar.a();
                return true;
            }
        }

        a(@NonNull View view) {
            this.f1754b = view;
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
            if (this.f1756d && this.f1754b.isLayoutRequested()) {
                return 0;
            }
            int i5 = i - i3;
            if (i5 > 0) {
                return i5;
            }
            if (this.f1754b.isLayoutRequested() || i2 != -2) {
                return 0;
            }
            if (Log.isLoggable("ViewTarget", 4)) {
                Log.i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return c(this.f1754b.getContext());
        }

        private int f() {
            int paddingTop = this.f1754b.getPaddingTop() + this.f1754b.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f1754b.getLayoutParams();
            return e(this.f1754b.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        private int g() {
            int paddingLeft = this.f1754b.getPaddingLeft() + this.f1754b.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f1754b.getLayoutParams();
            return e(this.f1754b.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        private boolean h(int i) {
            return i > 0 || i == Integer.MIN_VALUE;
        }

        private boolean i(int i, int i2) {
            return h(i) && h(i2);
        }

        private void j(int i, int i2) {
            Iterator it = new ArrayList(this.f1755c).iterator();
            while (it.hasNext()) {
                ((i) it.next()).d(i, i2);
            }
        }

        void a() {
            if (!this.f1755c.isEmpty()) {
                int g = g();
                int f2 = f();
                if (i(g, f2)) {
                    j(g, f2);
                    b();
                }
            }
        }

        void b() {
            ViewTreeObserver viewTreeObserver = this.f1754b.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f1757e);
            }
            this.f1757e = null;
            this.f1755c.clear();
        }

        void d(@NonNull i iVar) {
            int g = g();
            int f2 = f();
            if (i(g, f2)) {
                iVar.d(g, f2);
                return;
            }
            if (!this.f1755c.contains(iVar)) {
                this.f1755c.add(iVar);
            }
            if (this.f1757e == null) {
                ViewTreeObserver viewTreeObserver = this.f1754b.getViewTreeObserver();
                ViewTreeObserver$OnPreDrawListenerC0065a aVar = new ViewTreeObserver$OnPreDrawListenerC0065a(this);
                this.f1757e = aVar;
                viewTreeObserver.addOnPreDrawListener(aVar);
            }
        }

        void k(@NonNull i iVar) {
            this.f1755c.remove(iVar);
        }
    }

    public k(@NonNull T t) {
        this.q = (T) ((View) i.d(t));
        this.x = new a(t);
    }

    @Nullable
    private Object g() {
        return this.q.getTag(f1753f);
    }

    private void i() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.y;
        if (onAttachStateChangeListener != null && !this.p0) {
            this.q.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.p0 = true;
        }
    }

    private void k() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.y;
        if (onAttachStateChangeListener != null && this.p0) {
            this.q.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            this.p0 = false;
        }
    }

    private void l(@Nullable Object obj) {
        f1752d = true;
        this.q.setTag(f1753f, obj);
    }

    @Override // com.bumptech.glide.request.k.j
    @CallSuper
    public void a(@NonNull i iVar) {
        this.x.k(iVar);
    }

    @Override // com.bumptech.glide.request.k.a, com.bumptech.glide.request.k.j
    @CallSuper
    public void b(@Nullable Drawable drawable) {
        super.b(drawable);
        i();
    }

    @Override // com.bumptech.glide.request.k.a, com.bumptech.glide.request.k.j
    @Nullable
    public d c() {
        Object g = g();
        if (g == null) {
            return null;
        }
        if (g instanceof d) {
            return (d) g;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    @Override // com.bumptech.glide.request.k.a, com.bumptech.glide.request.k.j
    @CallSuper
    public void d(@Nullable Drawable drawable) {
        super.d(drawable);
        this.x.b();
        if (!this.z) {
            k();
        }
    }

    @Override // com.bumptech.glide.request.k.a, com.bumptech.glide.request.k.j
    public void f(@Nullable d dVar) {
        l(dVar);
    }

    @Override // com.bumptech.glide.request.k.j
    @CallSuper
    public void j(@NonNull i iVar) {
        this.x.d(iVar);
    }

    public String toString() {
        return "Target for: " + this.q;
    }
}
