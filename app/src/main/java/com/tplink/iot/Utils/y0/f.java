package com.tplink.iot.Utils.y0;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.util.j;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: GlideRoundTransform.java */
/* loaded from: classes2.dex */
public class f extends com.bumptech.glide.load.resource.bitmap.f {

    /* renamed from: b  reason: collision with root package name */
    private final float f5388b;

    /* renamed from: c  reason: collision with root package name */
    private final String f5389c = "com. bumptech.glide.transformations.FillSpace";

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f5390d = "com. bumptech.glide.transformations.FillSpace".getBytes(c.a);

    public f(int i) {
        this.f5388b = Resources.getSystem().getDisplayMetrics().density * i;
    }

    private Bitmap d(e eVar, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Bitmap d2 = eVar.d(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        if (d2 == null) {
            return Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(d2);
        Paint paint = new Paint(1);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        RectF rectF = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
        float f2 = this.f5388b;
        canvas.drawRoundRect(rectF, f2, f2, paint);
        return d2;
    }

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        messageDigest.update(this.f5390d);
        messageDigest.update(ByteBuffer.allocate(4).putInt((int) this.f5388b).array());
    }

    @Override // com.bumptech.glide.load.resource.bitmap.f
    protected Bitmap c(@NonNull e eVar, @NonNull Bitmap bitmap, int i, int i2) {
        return d(eVar, bitmap);
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        return (obj instanceof f) && this.f5388b == ((f) obj).f5388b;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return j.o(-853012345, j.l(this.f5388b));
    }
}
