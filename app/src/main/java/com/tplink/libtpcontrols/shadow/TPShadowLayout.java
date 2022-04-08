package com.tplink.libtpcontrols.shadow;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import b.d.w.c.a;
import com.hitomi.cslibrary.base.view.CornerShadowView;
import com.hitomi.cslibrary.base.view.EdgeShadowView;
import com.tplink.libtpcontrols.p0;
import com.tplink.libtpcontrols.x0;

/* loaded from: classes3.dex */
public class TPShadowLayout extends FrameLayout {
    private CornerShadowView H3;
    private int[] I3;

    /* renamed from: c  reason: collision with root package name */
    private float f12395c;

    /* renamed from: d  reason: collision with root package name */
    private float f12396d;

    /* renamed from: f  reason: collision with root package name */
    private int f12397f;
    private EdgeShadowView p0;
    private CornerShadowView p1;
    private CornerShadowView p2;
    private CornerShadowView p3;
    private Context q;
    private EdgeShadowView x;
    private EdgeShadowView y;
    private EdgeShadowView z;

    public TPShadowLayout(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        c();
        e();
        g();
        i();
        f();
        j();
        h();
        d();
    }

    private void b() {
        this.I3[0] = ColorUtils.setAlphaComponent(this.f12397f, 255);
        this.I3[1] = ColorUtils.setAlphaComponent(this.f12397f, 128);
        this.I3[2] = ColorUtils.setAlphaComponent(this.f12397f, 0);
    }

    private void c() {
        this.x = new EdgeShadowView.b().b(this.q).e(this.I3).c(this.f12396d).f(this.f12395c).g(getWidth() - ((this.f12395c + this.f12396d) * 2.0f)).d(8).a();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        int height = getHeight();
        float f2 = this.f12395c;
        layoutParams.topMargin = height - ((int) f2);
        layoutParams.leftMargin = (int) (f2 + this.f12396d);
        addView(this.x, layoutParams);
    }

    private void d() {
        this.H3 = new CornerShadowView.b().b(this.q).e(this.I3).f(this.f12395c).c(this.f12396d).d(128).a();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = getHeight() - ((int) (this.f12395c + this.f12396d));
        addView(this.H3, layoutParams);
    }

    private void e() {
        this.z = new EdgeShadowView.b().b(this.q).e(this.I3).c(this.f12396d).f(this.f12395c).g(getHeight() - ((this.f12395c + this.f12396d) * 2.0f)).d(1).a();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        float f2 = this.f12395c;
        float f3 = this.f12396d;
        layoutParams.topMargin = (int) (f2 + f3);
        layoutParams.bottomMargin = (int) (f2 + f3);
        addView(this.z, layoutParams);
    }

    private void f() {
        this.p1 = new CornerShadowView.b().b(this.q).e(this.I3).f(this.f12395c).c(this.f12396d).d(16).a();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = 0;
        layoutParams.leftMargin = 0;
        addView(this.p1, layoutParams);
    }

    private void g() {
        this.p0 = new EdgeShadowView.b().b(this.q).e(this.I3).c(this.f12396d).f(this.f12395c).g(getHeight() - ((this.f12395c + this.f12396d) * 2.0f)).d(4).a();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = (int) (this.f12395c + this.f12396d);
        layoutParams.leftMargin = getWidth() - ((int) this.f12395c);
        addView(this.p0, layoutParams);
    }

    private void h() {
        this.p3 = new CornerShadowView.b().b(this.q).e(this.I3).f(this.f12395c).c(this.f12396d).d(64).a();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = getHeight() - ((int) (this.f12395c + this.f12396d));
        layoutParams.leftMargin = getWidth() - ((int) (this.f12395c + this.f12396d));
        addView(this.p3, layoutParams);
    }

    private void i() {
        a.d("TPShadowLayout getWidth = " + getWidth());
        this.y = new EdgeShadowView.b().b(this.q).e(this.I3).c(this.f12396d).f(this.f12395c).g(((float) getWidth()) - ((this.f12395c + this.f12396d) * 2.0f)).d(2).a();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = 0;
        layoutParams.leftMargin = (int) (this.f12395c + this.f12396d);
        addView(this.y, layoutParams);
    }

    private void j() {
        this.p2 = new CornerShadowView.b().b(this.q).e(this.I3).f(this.f12395c).c(this.f12396d).d(32).a();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = 0;
        layoutParams.leftMargin = getWidth() - ((int) (this.f12395c + this.f12396d));
        addView(this.p2, layoutParams);
    }

    private void k(Context context, AttributeSet attributeSet) {
        this.q = context;
        this.f12397f = ContextCompat.getColor(context, p0.common_tplink_teal);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = this.q.obtainStyledAttributes(attributeSet, x0.TPShadowLayout);
            this.f12395c = obtainStyledAttributes.getDimension(x0.TPShadowLayout_sl_shadow_radius, this.f12395c);
            this.f12396d = obtainStyledAttributes.getDimension(x0.TPShadowLayout_sl_shadow_corner_radius, this.f12396d);
            this.f12397f = obtainStyledAttributes.getColor(x0.TPShadowLayout_sl_shadow_color, this.f12397f);
            obtainStyledAttributes.recycle();
        }
        b();
        post(new c(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public /* synthetic */ void n() {
        this.z.setShadowColors(this.I3);
        this.y.setShadowColors(this.I3);
        this.p0.setShadowColors(this.I3);
        this.x.setShadowColors(this.I3);
        this.p1.setShadowColors(this.I3);
        this.p2.setShadowColors(this.I3);
        this.p3.setShadowColors(this.I3);
        this.H3.setShadowColors(this.I3);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public void setShadowColor(int i) {
        this.f12397f = i;
        b();
        post(new Runnable() { // from class: com.tplink.libtpcontrols.shadow.d
            @Override // java.lang.Runnable
            public final void run() {
                TPShadowLayout.this.n();
            }
        });
    }

    public void setShadowCornerRadius(float f2) {
        this.f12396d = f2;
        removeAllViews();
        requestLayout();
        post(new c(this));
    }

    public void setShadowRadius(float f2) {
        this.f12395c = f2;
        removeAllViews();
        requestLayout();
        post(new c(this));
    }

    public TPShadowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TPShadowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        this.f12395c = 9.0f;
        this.f12396d = 0.0f;
        this.f12397f = -1;
        this.q = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.p0 = null;
        this.p1 = null;
        this.p2 = null;
        this.p3 = null;
        this.H3 = null;
        this.I3 = new int[3];
        k(context, attributeSet);
    }
}
