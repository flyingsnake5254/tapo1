package skin.support.widget;

import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import f.a.c;
import f.a.f.a.d;
import f.a.h.a;

/* compiled from: SkinCompatProgressBarHelper.java */
/* loaded from: classes4.dex */
public class e extends c {
    private final ProgressBar a;

    /* renamed from: b  reason: collision with root package name */
    private Bitmap f17738b;

    /* renamed from: c  reason: collision with root package name */
    private int f17739c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f17740d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f17741e = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ProgressBar progressBar) {
        this.a = progressBar;
    }

    private int c(int i) {
        if (i == c.abc_ratingbar_material) {
            return 0;
        }
        return c.a(i);
    }

    private Shape d() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    private Drawable f(Drawable drawable, boolean z) {
        if (a.d(drawable)) {
            Drawable b2 = a.b(drawable);
            if (b2 != null) {
                a.f(drawable, f(b2, z));
            }
        } else if (a.c(drawable)) {
            Drawable a = a.a(drawable);
            if (a != null) {
                a.e(drawable, f(a, z));
            }
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[numberOfLayers];
            for (int i = 0; i < numberOfLayers; i++) {
                int id = layerDrawable.getId(i);
                drawableArr[i] = f(layerDrawable.getDrawable(i), id == 16908301 || id == 16908303);
            }
            LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                layerDrawable2.setId(i2, layerDrawable.getId(i2));
            }
            return layerDrawable2;
        } else if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (this.f17738b == null) {
                this.f17738b = bitmap;
            }
            ShapeDrawable shapeDrawable = new ShapeDrawable(d());
            shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
            shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            return z ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
        }
        return drawable;
    }

    private Drawable g(Drawable drawable) {
        if (!(drawable instanceof AnimationDrawable)) {
            return drawable;
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        AnimationDrawable animationDrawable2 = new AnimationDrawable();
        animationDrawable2.setOneShot(animationDrawable.isOneShot());
        for (int i = 0; i < numberOfFrames; i++) {
            Drawable f2 = f(animationDrawable.getFrame(i), true);
            f2.setLevel(10000);
            animationDrawable2.addFrame(f2, animationDrawable.getDuration(i));
        }
        animationDrawable2.setLevel(10000);
        return animationDrawable2;
    }

    public void b() {
        int a = c.a(this.f17739c);
        this.f17739c = a;
        if (a != 0) {
            Drawable d2 = d.d(this.a.getContext(), this.f17739c);
            d2.setBounds(this.a.getIndeterminateDrawable().getBounds());
            this.a.setIndeterminateDrawable(g(d2));
        }
        int c2 = c(this.f17740d);
        this.f17740d = c2;
        if (c2 != 0) {
            this.a.setProgressDrawable(f(d.d(this.a.getContext(), this.f17740d), false));
        }
        if (Build.VERSION.SDK_INT > 21) {
            int a2 = c.a(this.f17741e);
            this.f17741e = a2;
            if (a2 != 0) {
                ProgressBar progressBar = this.a;
                progressBar.setIndeterminateTintList(d.b(progressBar.getContext(), this.f17741e));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.a.getContext().obtainStyledAttributes(attributeSet, f.a.d.SkinCompatProgressBar, i, 0);
        this.f17739c = obtainStyledAttributes.getResourceId(f.a.d.SkinCompatProgressBar_android_indeterminateDrawable, 0);
        this.f17740d = obtainStyledAttributes.getResourceId(f.a.d.SkinCompatProgressBar_android_progressDrawable, 0);
        obtainStyledAttributes.recycle();
        if (Build.VERSION.SDK_INT > 21) {
            TypedArray obtainStyledAttributes2 = this.a.getContext().obtainStyledAttributes(attributeSet, new int[]{16843881}, i, 0);
            this.f17741e = obtainStyledAttributes2.getResourceId(0, 0);
            obtainStyledAttributes2.recycle();
        }
        b();
    }
}
