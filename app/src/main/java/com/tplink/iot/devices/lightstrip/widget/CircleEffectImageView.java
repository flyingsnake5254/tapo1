package com.tplink.iot.devices.lightstrip.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: CircleEffectImageView.kt */
/* loaded from: classes2.dex */
public final class CircleEffectImageView extends LightingEffectBaseView {
    private final float M3;
    private final Paint N3;
    private final Paint O3;
    private boolean P3;

    public CircleEffectImageView(Context context) {
        this(context, null, 0, 6, null);
    }

    public CircleEffectImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ CircleEffectImageView(Context context, AttributeSet attributeSet, int i, int i2, f fVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final Bitmap k(Drawable drawable) {
        Bitmap bitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        if (drawable == null) {
            j.d(bitmap, "bitmap");
            return bitmap;
        }
        Canvas canvas = new Canvas(bitmap);
        Matrix imageMatrix = getImageMatrix();
        if (imageMatrix != null) {
            canvas.concat(imageMatrix);
        }
        drawable.draw(canvas);
        j.d(bitmap, "bitmap");
        return bitmap;
    }

    @Override // com.tplink.iot.devices.lightstrip.widget.LightingEffectBaseView
    public void c(Canvas canvas) {
        j.e(canvas, "canvas");
        Drawable drawable = getDrawable();
        Matrix imageMatrix = getImageMatrix();
        if (drawable != null && drawable.getIntrinsicWidth() != 0 && drawable.getIntrinsicHeight() != 0) {
            if (imageMatrix == null && getPaddingTop() == 0 && getPaddingLeft() == 0) {
                drawable.draw(canvas);
                return;
            }
            int saveCount = canvas.getSaveCount();
            canvas.save();
            if (getCropToPadding()) {
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                canvas.clipRect(getPaddingLeft() + scrollX, getPaddingTop() + scrollY, ((scrollX + getRight()) - getLeft()) - getPaddingRight(), ((scrollY + getBottom()) - getTop()) - getPaddingBottom());
            }
            canvas.translate(getPaddingLeft(), getPaddingTop());
            if (!this.P3) {
                Bitmap k = k(drawable);
                Paint paint = this.N3;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                paint.setShader(new BitmapShader(k, tileMode, tileMode));
                this.P3 = true;
            }
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, ((getWidth() / 2.0f) - getMHaloWidth()) - getMGapWidth(), this.N3);
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, (((getWidth() - this.M3) / 2.0f) - getMHaloWidth()) - getMGapWidth(), this.O3);
            canvas.restoreToCount(saveCount);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.P3 = false;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.P3 = false;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        this.P3 = false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleEffectImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        j.e(context, "context");
        float e2 = e(2);
        this.M3 = e2;
        this.N3 = new Paint(1);
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(e2);
        paint.setColor(536870912);
        p pVar = p.a;
        this.O3 = paint;
    }
}
