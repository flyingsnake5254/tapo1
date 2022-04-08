package com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.b.c;
import com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.c.b;
import com.tplink.libtpcontrols.o0;
import com.tplink.libtpcontrols.w0;
import com.tplink.libtpcontrols.x0;

/* loaded from: classes3.dex */
public class Marker extends ViewGroup implements b.AbstractC0253b {

    /* renamed from: c  reason: collision with root package name */
    private TextView f12355c;

    /* renamed from: d  reason: collision with root package name */
    private int f12356d;

    /* renamed from: f  reason: collision with root package name */
    private int f12357f;
    b q;
    private int x;

    public Marker(Context context) {
        this(context, null);
    }

    @Override // com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.c.b.AbstractC0253b
    public void a() {
        if (getParent() instanceof b.AbstractC0253b) {
            ((b.AbstractC0253b) getParent()).a();
        }
    }

    @Override // com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.c.b.AbstractC0253b
    public void b() {
        this.f12355c.setVisibility(0);
        if (getParent() instanceof b.AbstractC0253b) {
            ((b.AbstractC0253b) getParent()).b();
        }
    }

    public void c() {
        this.q.stop();
        this.f12355c.setVisibility(4);
        this.q.l();
    }

    public void d() {
        this.q.stop();
        this.q.m();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.q.draw(canvas);
        super.dispatchDraw(canvas);
    }

    public void e(String str) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        TextView textView = this.f12355c;
        textView.setText("-" + str);
        this.f12355c.measure(View.MeasureSpec.makeMeasureSpec(displayMetrics.widthPixels, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(displayMetrics.heightPixels, Integer.MIN_VALUE));
        this.f12356d = Math.max(this.f12355c.getMeasuredWidth(), this.f12355c.getMeasuredHeight());
        removeView(this.f12355c);
        TextView textView2 = this.f12355c;
        int i = this.f12356d;
        addView(textView2, new FrameLayout.LayoutParams(i, i, 51));
    }

    public void f(int i, int i2) {
        this.q.r(i, i2);
    }

    public CharSequence getValue() {
        return this.f12355c.getText();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.q.stop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        TextView textView = this.f12355c;
        int i5 = this.f12356d;
        textView.layout(paddingLeft, paddingTop, paddingLeft + i5, i5 + paddingTop);
        this.q.setBounds(paddingLeft, paddingTop, width, height);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        measureChildren(i, i2);
        int paddingLeft = this.f12356d + getPaddingLeft() + getPaddingRight();
        int paddingTop = this.f12356d + getPaddingTop() + getPaddingBottom();
        int i3 = this.f12356d;
        setMeasuredDimension(paddingLeft, paddingTop + (((int) ((i3 * 1.41f) - i3)) / 2) + this.f12357f);
    }

    public void setValue(CharSequence charSequence) {
        this.f12355c.setText(charSequence);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return drawable == this.q || super.verifyDrawable(drawable);
    }

    public Marker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, o0.discreteSeekBarStyle);
    }

    public Marker(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, "0");
    }

    public Marker(Context context, AttributeSet attributeSet, int i, String str) {
        super(context, attributeSet, i);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, x0.DiscreteSeekBar, o0.discreteSeekBarStyle, w0.DefaultSeekBar);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(x0.DiscreteSeekBar_dsb_indicatorPadding, -1);
        this.x = dimensionPixelSize;
        int i2 = dimensionPixelSize > 0 ? dimensionPixelSize * 2 : 0;
        int resourceId = obtainStyledAttributes.getResourceId(x0.DiscreteSeekBar_dsb_indicatorTextAppearance, w0.DefaultIndicatorTextAppearance);
        TextView textView = new TextView(context);
        this.f12355c = textView;
        textView.setPadding(i2, 0, i2, 0);
        this.f12355c.setTextAppearance(context, resourceId);
        this.f12355c.setGravity(17);
        this.f12355c.setText(str);
        this.f12355c.setMaxLines(1);
        this.f12355c.setSingleLine(true);
        c.g(this.f12355c, 5);
        this.f12355c.setVisibility(4);
        setPadding(i2, i2, i2, i2);
        e(str);
        float f2 = displayMetrics.density;
        this.f12357f = (int) (30.0f * f2);
        b bVar = new b(obtainStyledAttributes.getColorStateList(x0.DiscreteSeekBar_dsb_indicatorColor), (int) (f2 * 22.0f));
        this.q = bVar;
        bVar.setCallback(this);
        this.q.t(this);
        this.q.s(i2);
        ViewCompat.setElevation(this, obtainStyledAttributes.getDimension(x0.DiscreteSeekBar_dsb_indicatorElevation, displayMetrics.density * 8.0f));
        if (Build.VERSION.SDK_INT >= 21) {
            c.f(this, this.q);
        }
        obtainStyledAttributes.recycle();
    }
}
