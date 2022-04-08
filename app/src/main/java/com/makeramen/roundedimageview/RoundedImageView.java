package com.makeramen.roundedimageview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.core.view.ViewCompat;

/* loaded from: classes2.dex */
public class RoundedImageView extends ImageView {

    /* renamed from: c  reason: collision with root package name */
    public static final Shader.TileMode f5117c = Shader.TileMode.CLAMP;

    /* renamed from: d  reason: collision with root package name */
    private static final ImageView.ScaleType[] f5118d = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    private boolean H3;
    private int I3;
    private int J3;
    private ImageView.ScaleType K3;
    private Shader.TileMode L3;
    private Shader.TileMode M3;

    /* renamed from: f  reason: collision with root package name */
    private final float[] f5119f;
    private boolean p0;
    private Drawable p1;
    private boolean p2;
    private boolean p3;
    private Drawable q;
    private ColorStateList x;
    private float y;
    private ColorFilter z;

    /* JADX INFO: Access modifiers changed from: package-private */
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
                a[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public RoundedImageView(Context context) {
        super(context);
        this.f5119f = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.x = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
        this.y = 0.0f;
        this.z = null;
        this.p0 = false;
        this.p2 = false;
        this.p3 = false;
        this.H3 = false;
        Shader.TileMode tileMode = f5117c;
        this.L3 = tileMode;
        this.M3 = tileMode;
    }

    private void a() {
        Drawable drawable = this.p1;
        if (drawable != null && this.p0) {
            Drawable mutate = drawable.mutate();
            this.p1 = mutate;
            if (this.p2) {
                mutate.setColorFilter(this.z);
            }
        }
    }

    private static Shader.TileMode b(int i) {
        if (i == 0) {
            return Shader.TileMode.CLAMP;
        }
        if (i == 1) {
            return Shader.TileMode.REPEAT;
        }
        if (i != 2) {
            return null;
        }
        return Shader.TileMode.MIRROR;
    }

    private Drawable c() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i = this.J3;
        if (i != 0) {
            try {
                drawable = resources.getDrawable(i);
            } catch (Exception e2) {
                Log.w("RoundedImageView", "Unable to find resource: " + this.J3, e2);
                this.J3 = 0;
            }
        }
        return b.e(drawable);
    }

    private Drawable d() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i = this.I3;
        if (i != 0) {
            try {
                drawable = resources.getDrawable(i);
            } catch (Exception e2) {
                Log.w("RoundedImageView", "Unable to find resource: " + this.I3, e2);
                this.I3 = 0;
            }
        }
        return b.e(drawable);
    }

    private void f(Drawable drawable, ImageView.ScaleType scaleType) {
        if (drawable != null) {
            if (drawable instanceof b) {
                b bVar = (b) drawable;
                bVar.l(scaleType).i(this.y).h(this.x).k(this.p3).m(this.L3).n(this.M3);
                float[] fArr = this.f5119f;
                if (fArr != null) {
                    bVar.j(fArr[0], fArr[1], fArr[2], fArr[3]);
                }
                a();
            } else if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                for (int i = 0; i < numberOfLayers; i++) {
                    f(layerDrawable.getDrawable(i), scaleType);
                }
            }
        }
    }

    private void g(boolean z) {
        if (this.H3) {
            if (z) {
                this.q = b.e(this.q);
            }
            f(this.q, ImageView.ScaleType.FIT_XY);
        }
    }

    private void h() {
        f(this.p1, this.K3);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    public void e(float f2, float f3, float f4, float f5) {
        float[] fArr = this.f5119f;
        if (fArr[0] != f2 || fArr[1] != f3 || fArr[2] != f5 || fArr[3] != f4) {
            fArr[0] = f2;
            fArr[1] = f3;
            fArr[3] = f4;
            fArr[2] = f5;
            h();
            g(false);
            invalidate();
        }
    }

    @ColorInt
    public int getBorderColor() {
        return this.x.getDefaultColor();
    }

    public ColorStateList getBorderColors() {
        return this.x;
    }

    public float getBorderWidth() {
        return this.y;
    }

    public float getCornerRadius() {
        return getMaxCornerRadius();
    }

    public float getMaxCornerRadius() {
        float f2 = 0.0f;
        for (float f3 : this.f5119f) {
            f2 = Math.max(f3, f2);
        }
        return f2;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.K3;
    }

    public Shader.TileMode getTileModeX() {
        return this.L3;
    }

    public Shader.TileMode getTileModeY() {
        return this.M3;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        ColorDrawable colorDrawable = new ColorDrawable(i);
        this.q = colorDrawable;
        setBackgroundDrawable(colorDrawable);
    }

    @Override // android.view.View
    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        this.q = drawable;
        g(true);
        super.setBackgroundDrawable(this.q);
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i) {
        if (this.J3 != i) {
            this.J3 = i;
            Drawable c2 = c();
            this.q = c2;
            setBackgroundDrawable(c2);
        }
    }

    public void setBorderColor(@ColorInt int i) {
        setBorderColor(ColorStateList.valueOf(i));
    }

    public void setBorderWidth(@DimenRes int i) {
        setBorderWidth(getResources().getDimension(i));
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.z != colorFilter) {
            this.z = colorFilter;
            this.p2 = true;
            this.p0 = true;
            a();
            invalidate();
        }
    }

    public void setCornerRadius(float f2) {
        e(f2, f2, f2, f2);
    }

    public void setCornerRadiusDimen(@DimenRes int i) {
        float dimension = getResources().getDimension(i);
        e(dimension, dimension, dimension, dimension);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.I3 = 0;
        this.p1 = b.d(bitmap);
        h();
        super.setImageDrawable(this.p1);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.I3 = 0;
        this.p1 = b.e(drawable);
        h();
        super.setImageDrawable(this.p1);
    }

    @Override // android.widget.ImageView
    public void setImageResource(@DrawableRes int i) {
        if (this.I3 != i) {
            this.I3 = i;
            this.p1 = d();
            h();
            super.setImageDrawable(this.p1);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        setImageDrawable(getDrawable());
    }

    public void setOval(boolean z) {
        this.p3 = z;
        h();
        g(false);
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (this.K3 != scaleType) {
            this.K3 = scaleType;
            switch (a.a[scaleType.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    super.setScaleType(ImageView.ScaleType.FIT_XY);
                    break;
                default:
                    super.setScaleType(scaleType);
                    break;
            }
            h();
            g(false);
            invalidate();
        }
    }

    public void setTileModeX(Shader.TileMode tileMode) {
        if (this.L3 != tileMode) {
            this.L3 = tileMode;
            h();
            g(false);
            invalidate();
        }
    }

    public void setTileModeY(Shader.TileMode tileMode) {
        if (this.M3 != tileMode) {
            this.M3 = tileMode;
            h();
            g(false);
            invalidate();
        }
    }

    public void setBorderColor(ColorStateList colorStateList) {
        if (!this.x.equals(colorStateList)) {
            if (colorStateList == null) {
                colorStateList = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
            }
            this.x = colorStateList;
            h();
            g(false);
            if (this.y > 0.0f) {
                invalidate();
            }
        }
    }

    public void setBorderWidth(float f2) {
        if (this.y != f2) {
            this.y = f2;
            h();
            g(false);
            invalidate();
        }
    }

    public RoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundedImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f};
        this.f5119f = fArr;
        this.x = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
        this.y = 0.0f;
        this.z = null;
        this.p0 = false;
        this.p2 = false;
        this.p3 = false;
        this.H3 = false;
        Shader.TileMode tileMode = f5117c;
        this.L3 = tileMode;
        this.M3 = tileMode;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.RoundedImageView, i, 0);
        int i2 = obtainStyledAttributes.getInt(a.RoundedImageView_android_scaleType, -1);
        if (i2 >= 0) {
            setScaleType(f5118d[i2]);
        } else {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        float dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(a.RoundedImageView_riv_corner_radius, -1);
        fArr[0] = obtainStyledAttributes.getDimensionPixelSize(a.RoundedImageView_riv_corner_radius_top_left, -1);
        fArr[1] = obtainStyledAttributes.getDimensionPixelSize(a.RoundedImageView_riv_corner_radius_top_right, -1);
        fArr[2] = obtainStyledAttributes.getDimensionPixelSize(a.RoundedImageView_riv_corner_radius_bottom_right, -1);
        fArr[3] = obtainStyledAttributes.getDimensionPixelSize(a.RoundedImageView_riv_corner_radius_bottom_left, -1);
        int length = fArr.length;
        boolean z = false;
        for (int i3 = 0; i3 < length; i3++) {
            float[] fArr2 = this.f5119f;
            if (fArr2[i3] < 0.0f) {
                fArr2[i3] = 0.0f;
            } else {
                z = true;
            }
        }
        if (!z) {
            dimensionPixelSize = dimensionPixelSize < 0.0f ? 0.0f : dimensionPixelSize;
            int length2 = this.f5119f.length;
            for (int i4 = 0; i4 < length2; i4++) {
                this.f5119f[i4] = dimensionPixelSize;
            }
        }
        float dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(a.RoundedImageView_riv_border_width, -1);
        this.y = dimensionPixelSize2;
        if (dimensionPixelSize2 < 0.0f) {
            this.y = 0.0f;
        }
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(a.RoundedImageView_riv_border_color);
        this.x = colorStateList;
        if (colorStateList == null) {
            this.x = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
        }
        this.H3 = obtainStyledAttributes.getBoolean(a.RoundedImageView_riv_mutate_background, false);
        this.p3 = obtainStyledAttributes.getBoolean(a.RoundedImageView_riv_oval, false);
        int i5 = obtainStyledAttributes.getInt(a.RoundedImageView_riv_tile_mode, -2);
        if (i5 != -2) {
            setTileModeX(b(i5));
            setTileModeY(b(i5));
        }
        int i6 = obtainStyledAttributes.getInt(a.RoundedImageView_riv_tile_mode_x, -2);
        if (i6 != -2) {
            setTileModeX(b(i6));
        }
        int i7 = obtainStyledAttributes.getInt(a.RoundedImageView_riv_tile_mode_y, -2);
        if (i7 != -2) {
            setTileModeY(b(i7));
        }
        h();
        g(true);
        if (this.H3) {
            super.setBackgroundDrawable(this.q);
        }
        obtainStyledAttributes.recycle();
    }
}
