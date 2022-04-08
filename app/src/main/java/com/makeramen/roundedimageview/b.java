package com.makeramen.roundedimageview;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import java.util.HashSet;

/* compiled from: RoundedDrawable.java */
/* loaded from: classes2.dex */
public class b extends Drawable {

    /* renamed from: c  reason: collision with root package name */
    private final RectF f5121c;

    /* renamed from: d  reason: collision with root package name */
    private final Bitmap f5122d;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f5123e;

    /* renamed from: f  reason: collision with root package name */
    private final int f5124f;
    private final int g;
    private final Paint i;
    private Shader.TileMode l;
    private Shader.TileMode m;
    private final RectF a = new RectF();

    /* renamed from: b  reason: collision with root package name */
    private final RectF f5120b = new RectF();
    private final RectF h = new RectF();
    private final Matrix j = new Matrix();
    private final RectF k = new RectF();
    private boolean n = true;
    private float o = 0.0f;
    private final boolean[] p = {true, true, true, true};
    private boolean q = false;
    private float r = 0.0f;
    private ColorStateList s = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
    private ImageView.ScaleType t = ImageView.ScaleType.FIT_CENTER;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RoundedDrawable.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public b(Bitmap bitmap) {
        RectF rectF = new RectF();
        this.f5121c = rectF;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.l = tileMode;
        this.m = tileMode;
        this.f5122d = bitmap;
        int width = bitmap.getWidth();
        this.f5124f = width;
        int height = bitmap.getHeight();
        this.g = height;
        rectF.set(0.0f, 0.0f, width, height);
        Paint paint = new Paint();
        this.f5123e = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.i = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setColor(this.s.getColorForState(getState(), ViewCompat.MEASURED_STATE_MASK));
        paint2.setStrokeWidth(this.r);
    }

    private static boolean a(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return false;
            }
        }
        return true;
    }

    private static boolean b(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return true;
            }
        }
        return false;
    }

    public static Bitmap c(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 2), Math.max(drawable.getIntrinsicHeight(), 2), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Exception e2) {
            e2.printStackTrace();
            Log.w("RoundedDrawable", "Failed to create bitmap from drawable!");
            return null;
        }
    }

    public static b d(Bitmap bitmap) {
        if (bitmap != null) {
            return new b(bitmap);
        }
        return null;
    }

    public static Drawable e(Drawable drawable) {
        if (drawable == null || (drawable instanceof b)) {
            return drawable;
        }
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i = 0; i < numberOfLayers; i++) {
                layerDrawable.setDrawableByLayerId(layerDrawable.getId(i), e(layerDrawable.getDrawable(i)));
            }
            return layerDrawable;
        }
        Bitmap c2 = c(drawable);
        return c2 != null ? new b(c2) : drawable;
    }

    private void f(Canvas canvas) {
        if (!a(this.p) && this.o != 0.0f) {
            RectF rectF = this.f5120b;
            float f2 = rectF.left;
            float f3 = rectF.top;
            float width = rectF.width() + f2;
            float height = this.f5120b.height() + f3;
            float f4 = this.o;
            if (!this.p[0]) {
                this.k.set(f2, f3, f2 + f4, f3 + f4);
                canvas.drawRect(this.k, this.f5123e);
            }
            if (!this.p[1]) {
                this.k.set(width - f4, f3, width, f4);
                canvas.drawRect(this.k, this.f5123e);
            }
            if (!this.p[2]) {
                this.k.set(width - f4, height - f4, width, height);
                canvas.drawRect(this.k, this.f5123e);
            }
            if (!this.p[3]) {
                this.k.set(f2, height - f4, f4 + f2, height);
                canvas.drawRect(this.k, this.f5123e);
            }
        }
    }

    private void g(Canvas canvas) {
        float f2;
        if (!a(this.p) && this.o != 0.0f) {
            RectF rectF = this.f5120b;
            float f3 = rectF.left;
            float f4 = rectF.top;
            float width = rectF.width() + f3;
            float height = f4 + this.f5120b.height();
            float f5 = this.o;
            float f6 = this.r / 2.0f;
            if (!this.p[0]) {
                canvas.drawLine(f3 - f6, f4, f3 + f5, f4, this.i);
                canvas.drawLine(f3, f4 - f6, f3, f4 + f5, this.i);
            }
            if (!this.p[1]) {
                canvas.drawLine((width - f5) - f6, f4, width, f4, this.i);
                canvas.drawLine(width, f4 - f6, width, f4 + f5, this.i);
            }
            if (!this.p[2]) {
                f2 = f5;
                canvas.drawLine((width - f5) - f6, height, width + f6, height, this.i);
                canvas.drawLine(width, height - f2, width, height, this.i);
            } else {
                f2 = f5;
            }
            if (!this.p[3]) {
                canvas.drawLine(f3 - f6, height, f3 + f2, height, this.i);
                canvas.drawLine(f3, height - f2, f3, height, this.i);
            }
        }
    }

    private void o() {
        float f2;
        float f3;
        int i = a.a[this.t.ordinal()];
        if (i == 1) {
            this.h.set(this.a);
            RectF rectF = this.h;
            float f4 = this.r;
            rectF.inset(f4 / 2.0f, f4 / 2.0f);
            this.j.reset();
            this.j.setTranslate((int) (((this.h.width() - this.f5124f) * 0.5f) + 0.5f), (int) (((this.h.height() - this.g) * 0.5f) + 0.5f));
        } else if (i == 2) {
            this.h.set(this.a);
            RectF rectF2 = this.h;
            float f5 = this.r;
            rectF2.inset(f5 / 2.0f, f5 / 2.0f);
            this.j.reset();
            float f6 = 0.0f;
            if (this.f5124f * this.h.height() > this.h.width() * this.g) {
                f3 = this.h.height() / this.g;
                f6 = (this.h.width() - (this.f5124f * f3)) * 0.5f;
                f2 = 0.0f;
            } else {
                f3 = this.h.width() / this.f5124f;
                f2 = (this.h.height() - (this.g * f3)) * 0.5f;
            }
            this.j.setScale(f3, f3);
            Matrix matrix = this.j;
            float f7 = this.r;
            matrix.postTranslate(((int) (f6 + 0.5f)) + (f7 / 2.0f), ((int) (f2 + 0.5f)) + (f7 / 2.0f));
        } else if (i == 3) {
            this.j.reset();
            float min = (((float) this.f5124f) > this.a.width() || ((float) this.g) > this.a.height()) ? Math.min(this.a.width() / this.f5124f, this.a.height() / this.g) : 1.0f;
            this.j.setScale(min, min);
            this.j.postTranslate((int) (((this.a.width() - (this.f5124f * min)) * 0.5f) + 0.5f), (int) (((this.a.height() - (this.g * min)) * 0.5f) + 0.5f));
            this.h.set(this.f5121c);
            this.j.mapRect(this.h);
            RectF rectF3 = this.h;
            float f8 = this.r;
            rectF3.inset(f8 / 2.0f, f8 / 2.0f);
            this.j.setRectToRect(this.f5121c, this.h, Matrix.ScaleToFit.FILL);
        } else if (i == 5) {
            this.h.set(this.f5121c);
            this.j.setRectToRect(this.f5121c, this.a, Matrix.ScaleToFit.END);
            this.j.mapRect(this.h);
            RectF rectF4 = this.h;
            float f9 = this.r;
            rectF4.inset(f9 / 2.0f, f9 / 2.0f);
            this.j.setRectToRect(this.f5121c, this.h, Matrix.ScaleToFit.FILL);
        } else if (i == 6) {
            this.h.set(this.f5121c);
            this.j.setRectToRect(this.f5121c, this.a, Matrix.ScaleToFit.START);
            this.j.mapRect(this.h);
            RectF rectF5 = this.h;
            float f10 = this.r;
            rectF5.inset(f10 / 2.0f, f10 / 2.0f);
            this.j.setRectToRect(this.f5121c, this.h, Matrix.ScaleToFit.FILL);
        } else if (i != 7) {
            this.h.set(this.f5121c);
            this.j.setRectToRect(this.f5121c, this.a, Matrix.ScaleToFit.CENTER);
            this.j.mapRect(this.h);
            RectF rectF6 = this.h;
            float f11 = this.r;
            rectF6.inset(f11 / 2.0f, f11 / 2.0f);
            this.j.setRectToRect(this.f5121c, this.h, Matrix.ScaleToFit.FILL);
        } else {
            this.h.set(this.a);
            RectF rectF7 = this.h;
            float f12 = this.r;
            rectF7.inset(f12 / 2.0f, f12 / 2.0f);
            this.j.reset();
            this.j.setRectToRect(this.f5121c, this.h, Matrix.ScaleToFit.FILL);
        }
        this.f5120b.set(this.h);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.n) {
            BitmapShader bitmapShader = new BitmapShader(this.f5122d, this.l, this.m);
            Shader.TileMode tileMode = this.l;
            Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
            if (tileMode == tileMode2 && this.m == tileMode2) {
                bitmapShader.setLocalMatrix(this.j);
            }
            this.f5123e.setShader(bitmapShader);
            this.n = false;
        }
        if (this.q) {
            if (this.r > 0.0f) {
                canvas.drawOval(this.f5120b, this.f5123e);
                canvas.drawOval(this.h, this.i);
                return;
            }
            canvas.drawOval(this.f5120b, this.f5123e);
        } else if (b(this.p)) {
            float f2 = this.o;
            if (this.r > 0.0f) {
                canvas.drawRoundRect(this.f5120b, f2, f2, this.f5123e);
                canvas.drawRoundRect(this.h, f2, f2, this.i);
                f(canvas);
                g(canvas);
                return;
            }
            canvas.drawRoundRect(this.f5120b, f2, f2, this.f5123e);
            f(canvas);
        } else {
            canvas.drawRect(this.f5120b, this.f5123e);
            if (this.r > 0.0f) {
                canvas.drawRect(this.h, this.i);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f5123e.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f5123e.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f5124f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public b h(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.s = colorStateList;
        this.i.setColor(colorStateList.getColorForState(getState(), ViewCompat.MEASURED_STATE_MASK));
        return this;
    }

    public b i(float f2) {
        this.r = f2;
        this.i.setStrokeWidth(f2);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.s.isStateful();
    }

    public b j(float f2, float f3, float f4, float f5) {
        HashSet hashSet = new HashSet(4);
        hashSet.add(Float.valueOf(f2));
        hashSet.add(Float.valueOf(f3));
        hashSet.add(Float.valueOf(f4));
        hashSet.add(Float.valueOf(f5));
        hashSet.remove(Float.valueOf(0.0f));
        boolean z = true;
        if (hashSet.size() <= 1) {
            if (!hashSet.isEmpty()) {
                float floatValue = ((Float) hashSet.iterator().next()).floatValue();
                if (Float.isInfinite(floatValue) || Float.isNaN(floatValue) || floatValue < 0.0f) {
                    throw new IllegalArgumentException("Invalid radius value: " + floatValue);
                }
                this.o = floatValue;
            } else {
                this.o = 0.0f;
            }
            boolean[] zArr = this.p;
            zArr[0] = f2 > 0.0f;
            zArr[1] = f3 > 0.0f;
            zArr[2] = f4 > 0.0f;
            if (f5 <= 0.0f) {
                z = false;
            }
            zArr[3] = z;
            return this;
        }
        throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
    }

    public b k(boolean z) {
        this.q = z;
        return this;
    }

    public b l(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (this.t != scaleType) {
            this.t = scaleType;
            o();
        }
        return this;
    }

    public b m(Shader.TileMode tileMode) {
        if (this.l != tileMode) {
            this.l = tileMode;
            this.n = true;
            invalidateSelf();
        }
        return this;
    }

    public b n(Shader.TileMode tileMode) {
        if (this.m != tileMode) {
            this.m = tileMode;
            this.n = true;
            invalidateSelf();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(@NonNull Rect rect) {
        super.onBoundsChange(rect);
        this.a.set(rect);
        o();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState = this.s.getColorForState(iArr, 0);
        if (this.i.getColor() == colorForState) {
            return super.onStateChange(iArr);
        }
        this.i.setColor(colorForState);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f5123e.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f5123e.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.f5123e.setDither(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f5123e.setFilterBitmap(z);
        invalidateSelf();
    }
}
