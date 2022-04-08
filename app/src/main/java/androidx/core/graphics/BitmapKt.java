package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Point;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: Bitmap.kt */
/* loaded from: classes.dex */
public final class BitmapKt {
    public static final Bitmap applyCanvas(Bitmap applyCanvas, l<? super Canvas, p> block) {
        j.f(applyCanvas, "$this$applyCanvas");
        j.f(block, "block");
        block.invoke(new Canvas(applyCanvas));
        return applyCanvas;
    }

    public static final boolean contains(Bitmap contains, Point p) {
        int i;
        j.f(contains, "$this$contains");
        j.f(p, "p");
        int i2 = p.x;
        return i2 >= 0 && i2 < contains.getWidth() && (i = p.y) >= 0 && i < contains.getHeight();
    }

    public static final Bitmap createBitmap(int i, int i2, Bitmap.Config config) {
        j.f(config, "config");
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, config);
        j.b(createBitmap, "Bitmap.createBitmap(width, height, config)");
        return createBitmap;
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i, int i2, Bitmap.Config config, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        j.f(config, "config");
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, config);
        j.b(createBitmap, "Bitmap.createBitmap(width, height, config)");
        return createBitmap;
    }

    public static final int get(Bitmap get, int i, int i2) {
        j.f(get, "$this$get");
        return get.getPixel(i, i2);
    }

    public static final Bitmap scale(Bitmap scale, int i, int i2, boolean z) {
        j.f(scale, "$this$scale");
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(scale, i, i2, z);
        j.b(createScaledBitmap, "Bitmap.createScaledBitma…s, width, height, filter)");
        return createScaledBitmap;
    }

    public static /* synthetic */ Bitmap scale$default(Bitmap scale, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z = true;
        }
        j.f(scale, "$this$scale");
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(scale, i, i2, z);
        j.b(createScaledBitmap, "Bitmap.createScaledBitma…s, width, height, filter)");
        return createScaledBitmap;
    }

    public static final void set(Bitmap set, int i, int i2, @ColorInt int i3) {
        j.f(set, "$this$set");
        set.setPixel(i, i2, i3);
    }

    public static final boolean contains(Bitmap contains, PointF p) {
        j.f(contains, "$this$contains");
        j.f(p, "p");
        float f2 = p.x;
        float f3 = 0;
        if (f2 < f3 || f2 >= contains.getWidth()) {
            return false;
        }
        float f4 = p.y;
        return f4 >= f3 && f4 < ((float) contains.getHeight());
    }

    @RequiresApi(26)
    public static final Bitmap createBitmap(int i, int i2, Bitmap.Config config, boolean z, ColorSpace colorSpace) {
        j.f(config, "config");
        j.f(colorSpace, "colorSpace");
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, config, z, colorSpace);
        j.b(createBitmap, "Bitmap.createBitmap(widt…ig, hasAlpha, colorSpace)");
        return createBitmap;
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i, int i2, Bitmap.Config config, boolean z, ColorSpace colorSpace, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        if ((i3 & 8) != 0) {
            z = true;
        }
        if ((i3 & 16) != 0) {
            colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
            j.b(colorSpace, "ColorSpace.get(ColorSpace.Named.SRGB)");
        }
        j.f(config, "config");
        j.f(colorSpace, "colorSpace");
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, config, z, colorSpace);
        j.b(createBitmap, "Bitmap.createBitmap(widt…ig, hasAlpha, colorSpace)");
        return createBitmap;
    }
}
