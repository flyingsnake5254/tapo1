package com.tplink.iot.widget.colorbulb.light;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import com.tplink.iot.R;

/* loaded from: classes3.dex */
public class LightMaskView extends FrameLayout {

    /* renamed from: c  reason: collision with root package name */
    private ImageView f11796c;

    /* renamed from: d  reason: collision with root package name */
    private Drawable f11797d;

    /* renamed from: f  reason: collision with root package name */
    private Path f11798f;
    private boolean p0;
    private int q;
    private boolean x;
    private float y;
    private float z;

    public LightMaskView(@NonNull Context context) {
        this(context, null);
    }

    private void b(Canvas canvas, float f2) {
        int height = (int) ((((100.0f - f2) * 1.0d) * getHeight()) / 100.0d);
        this.f11798f.reset();
        this.f11798f.addRect(0.0f, height, getWidth(), getHeight(), Path.Direction.CCW);
        canvas.clipPath(this.f11798f);
    }

    public void a(float f2) {
        if (this.x) {
            this.z = this.y * f2;
        } else {
            this.z = this.y * (1.0f - f2);
        }
        invalidate();
    }

    public void c(boolean z, int i) {
        if (i >= 1) {
            this.q = i;
            this.x = z;
            invalidate();
        }
    }

    public void d(boolean z, int i) {
        this.y = z ? i : this.q;
        this.x = z;
        this.q = i;
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        float f2;
        if (this.p0) {
            b(canvas, this.z);
        } else {
            if (this.x) {
                int i = this.q;
                if (i < 3) {
                    i = 3;
                }
                f2 = i;
            } else {
                f2 = 0.0f;
            }
            b(canvas, f2);
        }
        super.dispatchDraw(canvas);
    }

    public int getBrightness() {
        return this.q;
    }

    public void setBrightness(int i) {
        if (i >= 1) {
            this.q = i;
            invalidate();
        }
    }

    public void setRunning(boolean z) {
        this.p0 = z;
    }

    public void setTintColor(int i) {
        DrawableCompat.setTint(this.f11797d, i);
    }

    public LightMaskView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LightMaskView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Drawable drawable;
        this.q = 50;
        ImageView imageView = new ImageView(context);
        this.f11796c = imageView;
        addView(imageView, new FrameLayout.LayoutParams(-2, -2));
        if (Build.VERSION.SDK_INT < 21) {
            drawable = getResources().getDrawable(R.mipmap.color_bulb_on_top_top);
        } else {
            drawable = getResources().getDrawable(R.mipmap.color_bulb_on_top_top, context.getTheme());
        }
        Drawable wrap = DrawableCompat.wrap(drawable);
        this.f11797d = wrap;
        DrawableCompat.setTint(wrap, -1);
        this.f11796c.setImageDrawable(this.f11797d);
        this.f11798f = new Path();
    }
}
