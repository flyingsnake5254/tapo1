package com.tplink.iot.widget.colorbulb.light;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.tplink.iot.R;

/* loaded from: classes3.dex */
public class LightBulbBgView extends FrameLayout {

    /* renamed from: c  reason: collision with root package name */
    private int f11785c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f11786d;

    /* renamed from: f  reason: collision with root package name */
    private Drawable f11787f;
    private Drawable q;
    private boolean x;
    private View y;

    public LightBulbBgView(Context context) {
        this(context, null);
    }

    private void setMaskAlphaByBrightness(int i) {
        this.y.setVisibility(0);
        this.y.setAlpha((float) (((100 - i) * 1.0d) / 100.0d));
    }

    public void a(boolean z, int i, int i2) {
        this.x = z;
        if (z) {
            setBackground(this.q);
            setMaskAlphaByBrightness(i2);
        } else {
            setBackground(this.f11787f);
            this.y.setVisibility(8);
        }
        this.f11785c = i;
        invalidate();
    }

    public int getColor() {
        return this.f11785c;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.x) {
            this.f11786d.setColor(this.f11785c);
            float width = getWidth() / 2;
            float height = getHeight() / 2;
            int i = this.f11785c;
            this.f11786d.setShader(new RadialGradient(width, height, (float) Math.sqrt((width * width) + (height * height)), new int[]{(i & 16777215) | (-1291845632), (i & 16777215) | 134217728}, (float[]) null, Shader.TileMode.MIRROR));
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.f11786d);
        }
    }

    public void setBrightness(int i) {
        if (this.x) {
            setMaskAlphaByBrightness(i);
        }
    }

    public void setColor(int i) {
        this.f11785c = i;
        invalidate();
    }

    public LightBulbBgView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LightBulbBgView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11786d = new Paint(1);
        this.f11787f = getResources().getDrawable(R.mipmap.bulb_bg_off);
        this.q = getResources().getDrawable(R.mipmap.bulb_bg_on);
        setBackground(this.f11787f);
        View view = new View(context);
        this.y = view;
        view.setBackground(context.getResources().getDrawable(R.drawable.shape_bg_color_bulb_mask));
        addView(this.y, new FrameLayout.LayoutParams(-1, -1));
    }
}
