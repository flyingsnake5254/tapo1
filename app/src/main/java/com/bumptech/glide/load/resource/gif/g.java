package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.l.a;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.f;

/* compiled from: GifFrameResourceDecoder.java */
/* loaded from: classes.dex */
public final class g implements com.bumptech.glide.load.g<a, Bitmap> {
    private final e a;

    public g(e eVar) {
        this.a = eVar;
    }

    /* renamed from: c */
    public u<Bitmap> b(@NonNull a aVar, int i, int i2, @NonNull f fVar) {
        return com.bumptech.glide.load.resource.bitmap.e.f(aVar.a(), this.a);
    }

    /* renamed from: d */
    public boolean a(@NonNull a aVar, @NonNull f fVar) {
        return true;
    }
}
