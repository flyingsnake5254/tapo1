package com.tplink.libtpcontrols;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class TPRippleBackground extends RelativeLayout {
    private ArrayList<Animator> H3;
    private RelativeLayout.LayoutParams I3;

    /* renamed from: c  reason: collision with root package name */
    private int f12145c;

    /* renamed from: d  reason: collision with root package name */
    private float f12146d;

    /* renamed from: f  reason: collision with root package name */
    private float f12147f;
    private int p0;
    private Paint p1;
    private AnimatorSet p3;
    private int q;
    private int x;
    private int y;
    private float z;
    private boolean p2 = false;
    private ArrayList<a> J3 = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends View {
        public a(Context context) {
            super(context);
            setVisibility(4);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            float min = Math.min(getWidth(), getHeight()) / 2;
            canvas.drawCircle(min, min, min - TPRippleBackground.this.f12146d, TPRippleBackground.this.p1);
        }
    }

    public TPRippleBackground(Context context) {
        super(context);
    }

    private void c(Context context, AttributeSet attributeSet) {
        if (!isInEditMode()) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, x0.TPRippleBackground);
                this.f12145c = obtainStyledAttributes.getColor(x0.TPRippleBackground_rb_color, getResources().getColor(p0.tp_rippelColor));
                this.f12146d = obtainStyledAttributes.getDimension(x0.TPRippleBackground_rb_strokeWidth, getResources().getDimension(q0.tp_rippleStrokeWidth));
                this.f12147f = obtainStyledAttributes.getDimension(x0.TPRippleBackground_rb_radius, getResources().getDimension(q0.tp_rippleRadius));
                this.q = obtainStyledAttributes.getInt(x0.TPRippleBackground_rb_duration, PathInterpolatorCompat.MAX_NUM_POINTS);
                this.x = obtainStyledAttributes.getInt(x0.TPRippleBackground_rb_rippleAmount, 6);
                this.z = obtainStyledAttributes.getFloat(x0.TPRippleBackground_rb_scale, 6.0f);
                this.p0 = obtainStyledAttributes.getInt(x0.TPRippleBackground_rb_type, 0);
                obtainStyledAttributes.recycle();
                this.y = this.q / this.x;
                Paint paint = new Paint();
                this.p1 = paint;
                paint.setAntiAlias(true);
                if (this.p0 == 0) {
                    this.f12146d = 0.0f;
                    this.p1.setStyle(Paint.Style.FILL);
                } else {
                    this.p1.setStyle(Paint.Style.STROKE);
                }
                this.p1.setColor(this.f12145c);
                float f2 = this.f12147f;
                float f3 = this.f12146d;
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) ((f2 + f3) * 2.0f), (int) ((f2 + f3) * 2.0f));
                this.I3 = layoutParams;
                layoutParams.addRule(13, -1);
                AnimatorSet animatorSet = new AnimatorSet();
                this.p3 = animatorSet;
                animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
                this.H3 = new ArrayList<>();
                for (int i = 0; i < this.x; i++) {
                    a aVar = new a(getContext());
                    addView(aVar, this.I3);
                    this.J3.add(aVar);
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aVar, "ScaleX", 1.0f, this.z);
                    ofFloat.setRepeatCount(-1);
                    ofFloat.setRepeatMode(1);
                    ofFloat.setStartDelay(this.y * i);
                    ofFloat.setDuration(this.q);
                    this.H3.add(ofFloat);
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(aVar, "ScaleY", 1.0f, this.z);
                    ofFloat2.setRepeatCount(-1);
                    ofFloat2.setRepeatMode(1);
                    ofFloat2.setStartDelay(this.y * i);
                    ofFloat2.setDuration(this.q);
                    this.H3.add(ofFloat2);
                    ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(aVar, "Alpha", 1.0f, 0.0f);
                    ofFloat3.setRepeatCount(-1);
                    ofFloat3.setRepeatMode(1);
                    ofFloat3.setStartDelay(this.y * i);
                    ofFloat3.setDuration(this.q);
                    this.H3.add(ofFloat3);
                }
                this.p3.playTogether(this.H3);
                return;
            }
            throw new IllegalArgumentException("Attributes should be provided to this view,");
        }
    }

    public boolean d() {
        return this.p2;
    }

    public void e() {
        if (!d()) {
            Iterator<a> it = this.J3.iterator();
            while (it.hasNext()) {
                it.next().setVisibility(0);
            }
            this.p3.start();
            this.p2 = true;
        }
    }

    public void f() {
        if (d()) {
            Iterator<a> it = this.J3.iterator();
            while (it.hasNext()) {
                it.next().setVisibility(4);
            }
            this.p3.end();
            this.p2 = false;
        }
    }

    public TPRippleBackground(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context, attributeSet);
    }

    public TPRippleBackground(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c(context, attributeSet);
    }
}
