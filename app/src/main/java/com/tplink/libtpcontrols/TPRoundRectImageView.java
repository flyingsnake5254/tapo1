package com.tplink.libtpcontrols;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

/* loaded from: classes3.dex */
public class TPRoundRectImageView extends AppCompatImageView {

    /* renamed from: c  reason: collision with root package name */
    private static final Xfermode f12152c = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);

    /* renamed from: d  reason: collision with root package name */
    private Paint f12153d = null;

    public TPRoundRectImageView(Context context) {
        super(context);
    }

    private Bitmap a() {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setColor(getResources().getColor(p0.white));
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), 21.0f, 21.0f, paint);
        return createBitmap;
    }

    private Bitmap b(Bitmap bitmap, int i, int i2, boolean z) {
        Matrix matrix = new Matrix();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f2 = i / width;
        float f3 = i2 / height;
        if (f2 > f3) {
            matrix.setScale(f2, f2);
        } else {
            matrix.setScale(f3, f3);
        }
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, z);
    }

    private Bitmap c(Drawable drawable) {
        return b(((BitmapDrawable) drawable).getBitmap(), getWidth(), getHeight(), true);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f12153d == null) {
            this.f12153d = new Paint();
        }
        if (getDrawable() != null) {
            canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
            canvas.drawBitmap(c(getDrawable()), 0.0f, 0.0f, this.f12153d);
            this.f12153d.setXfermode(f12152c);
            canvas.drawBitmap(a(), 0.0f, 0.0f, this.f12153d);
            this.f12153d.setXfermode(null);
            canvas.restore();
            Paint paint = new Paint(1);
            paint.setColor(Color.rgb(11, 150, 240));
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
            canvas.drawRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), 10.0f, 10.0f, paint);
        }
    }

    public TPRoundRectImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TPRoundRectImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
