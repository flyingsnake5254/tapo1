package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;

/* loaded from: classes.dex */
public final class AspectRatioFrameLayout extends FrameLayout {

    /* renamed from: c  reason: collision with root package name */
    private final c f3666c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private b f3667d;

    /* renamed from: f  reason: collision with root package name */
    private float f3668f;
    private int q;

    /* loaded from: classes.dex */
    public interface b {
        void a(float f2, float f3, boolean z);
    }

    /* loaded from: classes.dex */
    private final class c implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        private float f3669c;

        /* renamed from: d  reason: collision with root package name */
        private float f3670d;

        /* renamed from: f  reason: collision with root package name */
        private boolean f3671f;
        private boolean q;

        private c() {
        }

        public void a(float f2, float f3, boolean z) {
            this.f3669c = f2;
            this.f3670d = f3;
            this.f3671f = z;
            if (!this.q) {
                this.q = true;
                AspectRatioFrameLayout.this.post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.q = false;
            if (AspectRatioFrameLayout.this.f3667d != null) {
                AspectRatioFrameLayout.this.f3667d.a(this.f3669c, this.f3670d, this.f3671f);
            }
        }
    }

    public AspectRatioFrameLayout(Context context) {
        this(context, null);
    }

    public int getResizeMode() {
        return this.q;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        float f2;
        float f3;
        super.onMeasure(i, i2);
        if (this.f3668f > 0.0f) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            float f4 = measuredWidth;
            float f5 = measuredHeight;
            float f6 = f4 / f5;
            float f7 = (this.f3668f / f6) - 1.0f;
            if (Math.abs(f7) <= 0.01f) {
                this.f3666c.a(this.f3668f, f6, false);
                return;
            }
            int i3 = this.q;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        f2 = this.f3668f;
                    } else if (i3 == 4) {
                        if (f7 > 0.0f) {
                            f2 = this.f3668f;
                        } else {
                            f3 = this.f3668f;
                        }
                    }
                    measuredWidth = (int) (f5 * f2);
                } else {
                    f3 = this.f3668f;
                }
                measuredHeight = (int) (f4 / f3);
            } else if (f7 > 0.0f) {
                f3 = this.f3668f;
                measuredHeight = (int) (f4 / f3);
            } else {
                f2 = this.f3668f;
                measuredWidth = (int) (f5 * f2);
            }
            this.f3666c.a(this.f3668f, f6, true);
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, Pow2.MAX_POW2), View.MeasureSpec.makeMeasureSpec(measuredHeight, Pow2.MAX_POW2));
        }
    }

    public void setAspectRatio(float f2) {
        if (this.f3668f != f2) {
            this.f3668f = f2;
            requestLayout();
        }
    }

    public void setAspectRatioListener(@Nullable b bVar) {
        this.f3667d = bVar;
    }

    public void setResizeMode(int i) {
        if (this.q != i) {
            this.q = i;
            requestLayout();
        }
    }

    public AspectRatioFrameLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.q = 0;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, t0.AspectRatioFrameLayout, 0, 0);
            try {
                this.q = obtainStyledAttributes.getInt(t0.AspectRatioFrameLayout_resize_mode, 0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.f3666c = new c();
    }
}
