package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.g;
import com.bumptech.glide.util.i;
import java.io.IOException;

/* compiled from: BitmapDrawableDecoder.java */
/* loaded from: classes.dex */
public class a<DataType> implements g<DataType, BitmapDrawable> {
    private final g<DataType, Bitmap> a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources f1620b;

    public a(@NonNull Resources resources, @NonNull g<DataType, Bitmap> gVar) {
        this.f1620b = (Resources) i.d(resources);
        this.a = (g) i.d(gVar);
    }

    @Override // com.bumptech.glide.load.g
    public boolean a(@NonNull DataType datatype, @NonNull f fVar) throws IOException {
        return this.a.a(datatype, fVar);
    }

    @Override // com.bumptech.glide.load.g
    public u<BitmapDrawable> b(@NonNull DataType datatype, int i, int i2, @NonNull f fVar) throws IOException {
        return s.f(this.f1620b, this.a.b(datatype, i, i2, fVar));
    }
}
