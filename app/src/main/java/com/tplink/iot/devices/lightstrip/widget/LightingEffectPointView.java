package com.tplink.iot.devices.lightstrip.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.AppCompatImageView;
import com.tplink.iot.R;
import com.tplink.iot.b;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: LightingEffectPointView.kt */
/* loaded from: classes2.dex */
public final class LightingEffectPointView extends AppCompatImageView {

    /* renamed from: c  reason: collision with root package name */
    public static final a f7807c = new a(null);

    /* renamed from: d  reason: collision with root package name */
    private final int f7808d;

    /* renamed from: f  reason: collision with root package name */
    private final float f7809f;
    private int p0;
    private boolean p1;
    private int p2;
    private final Paint q;
    private float x;
    private int y;
    private final Paint z;

    /* compiled from: LightingEffectPointView.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public LightingEffectPointView(Context context) {
        this(context, null, 0, 6, null);
    }

    public LightingEffectPointView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ LightingEffectPointView(Context context, AttributeSet attributeSet, int i, int i2, f fVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void a(Canvas canvas) {
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
            if (!this.p1) {
                Bitmap e2 = e(drawable);
                Paint paint = this.z;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                paint.setShader(new BitmapShader(e2, tileMode, tileMode));
                this.p1 = true;
            }
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, this.z);
            canvas.restoreToCount(saveCount);
        }
    }

    private final void b(Canvas canvas) {
        this.z.setShader(null);
        this.z.setColor(this.y);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, (getWidth() / 2.0f) - this.x, this.z);
    }

    private final void c(Canvas canvas) {
        if (this.z.getShader() == null || !this.p1) {
            this.p1 = false;
            int i = this.p2;
            if (i == -1) {
                i = R.mipmap.icon_lighting_effect_scene;
            }
            setImageResource(i);
        }
        a(canvas);
    }

    private final void d(Canvas canvas) {
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, ((getWidth() - this.f7809f) / 2.0f) - this.x, this.q);
    }

    private final Bitmap e(Drawable drawable) {
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

    private final float f(int i) {
        Context context = getContext();
        j.d(context, "context");
        Resources resources = context.getResources();
        j.d(resources, "context.resources");
        return TypedValue.applyDimension(1, i, resources.getDisplayMetrics());
    }

    private final int g(int i) {
        int i2 = this.f7808d;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(this.f7808d, size);
        }
        if (mode != 0) {
            return mode != 1073741824 ? i2 : size;
        }
        return this.f7808d;
    }

    public final void h(int i) {
        if (!(i == 0 || i == 1)) {
            i = -1;
        }
        this.p0 = i;
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        j.e(canvas, "canvas");
        int i = this.p0;
        if (i == 0) {
            b(canvas);
            d(canvas);
        } else if (i == 1) {
            c(canvas);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        int min = Math.min(g(i), g(i2));
        setMeasuredDimension(min, min);
    }

    public final void setColor(@ColorInt int i) {
        this.y = i;
        invalidate();
    }

    public final void setColorAndUpdateContent(@ColorInt int i) {
        this.y = i;
        this.p0 = 0;
        invalidate();
    }

    public final void setEffectImageId(@DrawableRes int i) {
        this.p1 = false;
        this.p2 = i;
    }

    public final void setOutlineColor(@ColorInt int i) {
        this.q.setColor(i);
        invalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LightingEffectPointView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        j.e(context, "context");
        this.f7808d = (int) f(24);
        float f2 = f(2);
        this.f7809f = f2;
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(f2);
        paint.setColor(-1);
        p pVar = p.a;
        this.q = paint;
        this.y = -1;
        this.z = new Paint(3);
        this.p2 = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.LightingEffectPointView);
        this.x = obtainStyledAttributes.getDimension(0, 0.0f);
        obtainStyledAttributes.recycle();
    }
}
