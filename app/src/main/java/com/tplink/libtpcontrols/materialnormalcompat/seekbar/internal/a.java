package com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.IBinder;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.google.android.material.badge.BadgeDrawable;
import com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.b.c;
import com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.c.b;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;

/* compiled from: PopupIndicator.java */
/* loaded from: classes3.dex */
public class a {
    private final WindowManager a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f12358b;

    /* renamed from: c  reason: collision with root package name */
    private C0250a f12359c;

    /* renamed from: d  reason: collision with root package name */
    private b.AbstractC0253b f12360d;

    /* renamed from: e  reason: collision with root package name */
    private int[] f12361e = new int[2];

    /* renamed from: f  reason: collision with root package name */
    Point f12362f = new Point();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PopupIndicator.java */
    /* renamed from: com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0250a extends FrameLayout implements b.AbstractC0253b {

        /* renamed from: c  reason: collision with root package name */
        private Marker f12363c;

        /* renamed from: d  reason: collision with root package name */
        private int f12364d;

        public C0250a(Context context, AttributeSet attributeSet, int i, String str) {
            super(context);
            Marker marker = new Marker(context, attributeSet, i, str);
            this.f12363c = marker;
            addView(marker, new FrameLayout.LayoutParams(-2, -2, 51));
        }

        @Override // com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.c.b.AbstractC0253b
        public void a() {
            if (a.this.f12360d != null) {
                a.this.f12360d.a();
            }
            a.this.e();
        }

        @Override // com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.c.b.AbstractC0253b
        public void b() {
            if (a.this.f12360d != null) {
                a.this.f12360d.b();
            }
        }

        public void d(int i, int i2) {
            this.f12363c.f(i, i2);
        }

        public void e(int i) {
            this.f12364d = i;
            int measuredWidth = i - (this.f12363c.getMeasuredWidth() / 2);
            Marker marker = this.f12363c;
            marker.offsetLeftAndRight(measuredWidth - marker.getLeft());
            if (!c.b(this)) {
                invalidate();
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            int measuredWidth = this.f12364d - (this.f12363c.getMeasuredWidth() / 2);
            Marker marker = this.f12363c;
            marker.layout(measuredWidth, 0, marker.getMeasuredWidth() + measuredWidth, this.f12363c.getMeasuredHeight());
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            measureChildren(i, i2);
            setMeasuredDimension(View.MeasureSpec.getSize(i), this.f12363c.getMeasuredHeight());
        }
    }

    public a(Context context, AttributeSet attributeSet, int i, String str) {
        this.a = (WindowManager) context.getSystemService("window");
        this.f12359c = new C0250a(context, attributeSet, i, str);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f12362f.set(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    private int b(int i) {
        return (i & (-426521)) | 32768 | 8 | 16 | 512;
    }

    private WindowManager.LayoutParams c(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = BadgeDrawable.TOP_START;
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.format = -3;
        layoutParams.flags = b(layoutParams.flags);
        layoutParams.type = 1000;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = 3;
        layoutParams.setTitle("DiscreteSeekBar Indicator:" + Integer.toHexString(hashCode()));
        return layoutParams;
    }

    private void f(WindowManager.LayoutParams layoutParams) {
        this.a.addView(this.f12359c, layoutParams);
        this.f12359c.f12363c.d();
    }

    private void h() {
        this.f12359c.measure(View.MeasureSpec.makeMeasureSpec(this.f12362f.x, Pow2.MAX_POW2), View.MeasureSpec.makeMeasureSpec(this.f12362f.y, Integer.MIN_VALUE));
    }

    private void n(int i) {
        this.f12359c.e(i + this.f12361e[0]);
    }

    private void o(View view, WindowManager.LayoutParams layoutParams, int i) {
        h();
        int measuredHeight = this.f12359c.getMeasuredHeight();
        int paddingBottom = this.f12359c.f12363c.getPaddingBottom();
        view.getLocationInWindow(this.f12361e);
        layoutParams.x = 0;
        layoutParams.y = (this.f12361e[1] - measuredHeight) + i + paddingBottom;
        layoutParams.width = this.f12362f.x;
        layoutParams.height = measuredHeight;
    }

    public void d() {
        this.f12359c.f12363c.c();
    }

    public void e() {
        if (g()) {
            this.f12358b = false;
            this.a.removeViewImmediate(this.f12359c);
        }
    }

    public boolean g() {
        return this.f12358b;
    }

    public void i(int i) {
        if (g()) {
            n(i);
        }
    }

    public void j(int i, int i2) {
        this.f12359c.d(i, i2);
    }

    public void k(b.AbstractC0253b bVar) {
        this.f12360d = bVar;
    }

    public void l(CharSequence charSequence) {
        this.f12359c.f12363c.setValue(charSequence);
    }

    public void m(View view, Rect rect) {
        if (g()) {
            this.f12359c.f12363c.d();
            return;
        }
        IBinder windowToken = view.getWindowToken();
        if (windowToken != null) {
            WindowManager.LayoutParams c2 = c(windowToken);
            c2.gravity = BadgeDrawable.TOP_START;
            o(view, c2, rect.bottom);
            this.f12358b = true;
            n(rect.centerX());
            f(c2);
        }
    }

    public void p(String str) {
        e();
        C0250a aVar = this.f12359c;
        if (aVar != null) {
            aVar.f12363c.e(str);
        }
    }
}
