package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.g;
import com.bumptech.glide.util.a;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: InputStreamBitmapImageDecoderResourceDecoder.java */
@RequiresApi(api = 28)
/* loaded from: classes.dex */
public final class r implements g<InputStream, Bitmap> {
    private final d a = new d();

    @Nullable
    /* renamed from: c */
    public u<Bitmap> b(@NonNull InputStream inputStream, int i, int i2, @NonNull f fVar) throws IOException {
        return this.a.b(ImageDecoder.createSource(a.b(inputStream)), i, i2, fVar);
    }

    /* renamed from: d */
    public boolean a(@NonNull InputStream inputStream, @NonNull f fVar) throws IOException {
        return true;
    }
}
