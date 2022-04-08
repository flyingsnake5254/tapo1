package com.tplink.iot.widget.i;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import java.util.Objects;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: OnPressScaleChangeTouchListener.kt */
/* loaded from: classes3.dex */
public final class a implements View.OnTouchListener {

    /* renamed from: c  reason: collision with root package name */
    private float f11816c;

    /* renamed from: d  reason: collision with root package name */
    private final int f11817d;

    /* renamed from: f  reason: collision with root package name */
    private final int f11818f;
    private int q;
    private float x;
    private long y;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnPressScaleChangeTouchListener.kt */
    /* renamed from: com.tplink.iot.widget.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0244a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ View f11820d;

        C0244a(View view) {
            this.f11820d = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator it) {
            a aVar = a.this;
            j.d(it, "it");
            Object animatedValue = it.getAnimatedValue();
            Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            aVar.f11816c = ((Float) animatedValue).floatValue();
            this.f11820d.setScaleX(a.this.f11816c);
            this.f11820d.setScaleY(a.this.f11816c);
        }
    }

    public a(float f2, long j) {
        this.x = f2;
        this.y = j;
        this.f11816c = 1.0f;
        if (f2 < 0.0f || f2 > 1.0f) {
            this.x = 0.8f;
        }
        this.f11818f = 1;
        this.q = 1;
    }

    private final void d(View view, float f2, float f3) {
        ValueAnimator animator = ValueAnimator.ofFloat(f2, f3);
        j.d(animator, "animator");
        animator.setDuration(this.y);
        animator.setInterpolator(new FastOutSlowInInterpolator());
        animator.addUpdateListener(new C0244a(view));
        animator.start();
    }

    public final void c(View view) {
        if (view != null) {
            view.setOnTouchListener(this);
        }
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent event) {
        j.e(view, "view");
        j.e(event, "event");
        int action = event.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float width = view.getWidth();
                    float x = event.getX();
                    if (x >= 0.0f && x <= width) {
                        float height = view.getHeight();
                        float y = event.getY();
                        if (y >= 0.0f && y <= height) {
                            return false;
                        }
                    }
                    if (this.q != this.f11817d) {
                        return false;
                    }
                    d(view, this.f11816c, 1.0f);
                    this.q = this.f11818f;
                    return false;
                } else if (action != 3) {
                    return false;
                }
            }
            if (this.q != this.f11817d) {
                return false;
            }
            d(view, this.f11816c, 1.0f);
            this.q = this.f11818f;
            return false;
        } else if (this.q != this.f11818f) {
            return false;
        } else {
            d(view, this.f11816c, this.x);
            this.q = this.f11817d;
            return false;
        }
    }

    public /* synthetic */ a(float f2, long j, int i, f fVar) {
        this((i & 1) != 0 ? 0.88f : f2, (i & 2) != 0 ? 240L : j);
    }
}
