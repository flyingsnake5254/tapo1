package com.tplink.libtpcontrols;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.AppCompatImageView;

/* loaded from: classes3.dex */
public class TPRoundImageView extends AppCompatImageView {

    /* renamed from: c  reason: collision with root package name */
    private int f12149c;

    /* renamed from: d  reason: collision with root package name */
    private int f12150d;

    /* renamed from: f  reason: collision with root package name */
    private Paint f12151f;
    private RectF p0;
    private int q;
    private Matrix x;
    private BitmapShader y;
    private int z;

    public TPRoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.x = new Matrix();
        Paint paint = new Paint();
        this.f12151f = paint;
        paint.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, x0.RoundImageView);
        this.f12150d = obtainStyledAttributes.getDimensionPixelSize(x0.RoundImageView_borderRadius, (int) TypedValue.applyDimension(1, 10.0f, getResources().getDisplayMetrics()));
        this.f12149c = obtainStyledAttributes.getInt(x0.RoundImageView_type, 0);
        obtainStyledAttributes.recycle();
    }

    private Bitmap b(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return createBitmap;
    }

    private void c() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            Bitmap b2 = b(drawable);
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.y = new BitmapShader(b2, tileMode, tileMode);
            int i = this.f12149c;
            float f2 = 1.0f;
            if (i == 0) {
                f2 = (this.z * 1.0f) / Math.min(b2.getWidth(), b2.getHeight());
            } else if (i == 1 && !(b2.getWidth() == getWidth() && b2.getHeight() == getHeight())) {
                f2 = Math.max((getWidth() * 1.0f) / b2.getWidth(), (getHeight() * 1.0f) / b2.getHeight());
            }
            this.x.setScale(f2, f2);
            this.y.setLocalMatrix(this.x);
            this.f12151f.setShader(this.y);
        }
    }

    public int a(int i) {
        return (int) TypedValue.applyDimension(1, i, getResources().getDisplayMetrics());
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (getDrawable() != null) {
            c();
            if (this.f12149c == 1) {
                RectF rectF = this.p0;
                int i = this.f12150d;
                canvas.drawRoundRect(rectF, i, i, this.f12151f);
                return;
            }
            int i2 = this.q;
            canvas.drawCircle(i2, i2, i2, this.f12151f);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f12149c == 0) {
            int min = Math.min(getMeasuredWidth(), getMeasuredHeight());
            this.z = min;
            this.q = min / 2;
            setMeasuredDimension(min, min);
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            super.onRestoreInstanceState(bundle.getParcelable("state_instance"));
            this.f12149c = bundle.getInt("state_type");
            this.f12150d = bundle.getInt("state_border_radius");
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("state_instance", super.onSaveInstanceState());
        bundle.putInt("state_type", this.f12149c);
        bundle.putInt("state_border_radius", this.f12150d);
        return bundle;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f12149c == 1) {
            this.p0 = new RectF(0.0f, 0.0f, i, i2);
        }
    }

    public void setBorderRadius(int i) {
        int a = a(i);
        if (this.f12150d != a) {
            this.f12150d = a;
            invalidate();
        }
    }

    public void setType(int i) {
        if (this.f12149c != i) {
            this.f12149c = i;
            if (!(i == 1 || i == 0)) {
                this.f12149c = 0;
            }
            requestLayout();
        }
    }

    public TPRoundImageView(Context context) {
        this(context, null);
    }
}
