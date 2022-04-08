package com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.c;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.core.internal.view.SupportMenu;
import androidx.recyclerview.widget.ItemTouchHelper;

/* compiled from: AlmostRippleDrawable.java */
/* loaded from: classes3.dex */
public class a extends c implements Animatable {
    private int H3;
    private int I3;
    private int J3;
    private int K3;
    private int L3;
    private float p3;
    private long z;
    private float x = 0.0f;
    private boolean p0 = false;
    private boolean p1 = false;
    private int p2 = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
    private final Runnable M3 = new RunnableC0252a();
    private Interpolator y = new AccelerateDecelerateInterpolator();

    /* compiled from: AlmostRippleDrawable.java */
    /* renamed from: com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class RunnableC0252a implements Runnable {
        RunnableC0252a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long uptimeMillis = SystemClock.uptimeMillis();
            long j = uptimeMillis - a.this.z;
            if (j < a.this.p2) {
                float interpolation = a.this.y.getInterpolation(((float) j) / a.this.p2);
                a aVar = a.this;
                aVar.scheduleSelf(aVar.M3, uptimeMillis + 16);
                a.this.n(interpolation);
                return;
            }
            a aVar2 = a.this;
            aVar2.unscheduleSelf(aVar2.M3);
            a.this.p1 = false;
            a.this.n(1.0f);
        }
    }

    public a(@NonNull ColorStateList colorStateList) {
        super(colorStateList);
        this.I3 = colorStateList.getColorForState(new int[]{16842908}, SupportMenu.CATEGORY_MASK);
        this.H3 = colorStateList.getColorForState(new int[]{16842919}, SupportMenu.CATEGORY_MASK);
        this.J3 = colorStateList.getColorForState(new int[]{-16842910}, SupportMenu.CATEGORY_MASK);
    }

    private int m(int i) {
        return (i * 100) >> 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(float f2) {
        float f3 = this.p3;
        this.x = f3 + (((this.p0 ? 0.0f : 1.0f) - f3) * f2);
        invalidateSelf();
    }

    @Override // com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.c.c
    public void a(Canvas canvas, Paint paint) {
        Rect bounds = getBounds();
        int min = Math.min(bounds.width(), bounds.height());
        float f2 = this.x;
        int i = this.K3;
        int i2 = this.L3;
        float f3 = min / 2.0f;
        float f4 = f3 * f2;
        if (f2 > 0.0f) {
            if (i2 != 0) {
                paint.setColor(i2);
                paint.setAlpha(m(Color.alpha(i2)));
                canvas.drawCircle(bounds.centerX(), bounds.centerY(), f3, paint);
            }
            if (i != 0) {
                paint.setColor(i);
                paint.setAlpha(b(Color.alpha(i)));
                canvas.drawCircle(bounds.centerX(), bounds.centerY(), f4, paint);
            }
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.p1;
    }

    public void k() {
        unscheduleSelf(this.M3);
        float f2 = this.x;
        if (f2 > 0.0f) {
            this.p0 = true;
            this.p1 = true;
            this.p3 = f2;
            this.p2 = (int) ((1.0f - ((f2 - 1.0f) / (-1.0f))) * 250.0f);
            long uptimeMillis = SystemClock.uptimeMillis();
            this.z = uptimeMillis;
            scheduleSelf(this.M3, uptimeMillis + 16);
        }
    }

    public void l() {
        unscheduleSelf(this.M3);
        float f2 = this.x;
        if (f2 < 1.0f) {
            this.p0 = false;
            this.p1 = true;
            this.p3 = f2;
            this.p2 = (int) ((1.0f - ((f2 - 0.0f) / 1.0f)) * 250.0f);
            long uptimeMillis = SystemClock.uptimeMillis();
            this.z = uptimeMillis;
            scheduleSelf(this.M3, uptimeMillis + 16);
        }
    }

    @Override // com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.c.c, android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        boolean z;
        int[] state = getState();
        int length = state.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            } else if (state[i] == 16842919) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        super.setState(iArr);
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = false;
        for (int i2 : iArr) {
            if (i2 == 16842908) {
                z4 = true;
            } else if (i2 == 16842919) {
                z3 = true;
            } else if (i2 == 16842910) {
                z2 = false;
            }
        }
        if (z2) {
            unscheduleSelf(this.M3);
            this.K3 = this.J3;
            this.L3 = 0;
            this.x = 0.5f;
            invalidateSelf();
        } else if (z3) {
            l();
            int i3 = this.H3;
            this.L3 = i3;
            this.K3 = i3;
        } else if (z) {
            int i4 = this.H3;
            this.L3 = i4;
            this.K3 = i4;
            k();
        } else if (z4) {
            this.K3 = this.I3;
            this.L3 = 0;
            this.x = 1.0f;
            invalidateSelf();
        } else {
            this.K3 = 0;
            this.L3 = 0;
            this.x = 0.0f;
            invalidateSelf();
        }
        return true;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
    }
}
