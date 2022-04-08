package com.bumptech.glide.load.engine.z;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* compiled from: BitmapPoolAdapter.java */
/* loaded from: classes.dex */
public class f implements e {
    @Override // com.bumptech.glide.load.engine.z.e
    public void a(int i) {
    }

    @Override // com.bumptech.glide.load.engine.z.e
    public void b() {
    }

    @Override // com.bumptech.glide.load.engine.z.e
    public void c(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // com.bumptech.glide.load.engine.z.e
    @NonNull
    public Bitmap d(int i, int i2, Bitmap.Config config) {
        return Bitmap.createBitmap(i, i2, config);
    }

    @Override // com.bumptech.glide.load.engine.z.e
    @NonNull
    public Bitmap e(int i, int i2, Bitmap.Config config) {
        return d(i, i2, config);
    }
}
