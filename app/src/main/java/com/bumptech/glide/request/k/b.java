package com.bumptech.glide.request.k;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* compiled from: BitmapImageViewTarget.java */
/* loaded from: classes.dex */
public class b extends f<Bitmap> {
    public b(ImageView imageView) {
        super(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: q */
    public void o(Bitmap bitmap) {
        ((ImageView) this.q).setImageBitmap(bitmap);
    }
}
