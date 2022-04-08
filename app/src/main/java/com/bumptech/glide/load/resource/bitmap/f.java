package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.c;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.i;
import com.bumptech.glide.util.j;

/* compiled from: BitmapTransformation.java */
/* loaded from: classes.dex */
public abstract class f implements i<Bitmap> {
    @Override // com.bumptech.glide.load.i
    @NonNull
    public final u<Bitmap> a(@NonNull Context context, @NonNull u<Bitmap> uVar, int i, int i2) {
        if (j.u(i, i2)) {
            e f2 = c.c(context).f();
            Bitmap bitmap = uVar.get();
            if (i == Integer.MIN_VALUE) {
                i = bitmap.getWidth();
            }
            if (i2 == Integer.MIN_VALUE) {
                i2 = bitmap.getHeight();
            }
            Bitmap c2 = c(f2, bitmap, i, i2);
            return bitmap.equals(c2) ? uVar : e.f(c2, f2);
        }
        throw new IllegalArgumentException("Cannot apply transformation on width: " + i + " or height: " + i2 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }

    protected abstract Bitmap c(@NonNull e eVar, @NonNull Bitmap bitmap, int i, int i2);
}
