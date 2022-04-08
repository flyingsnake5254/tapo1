package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.g;
import java.io.IOException;

/* compiled from: ParcelFileDescriptorBitmapDecoder.java */
@RequiresApi(21)
/* loaded from: classes.dex */
public final class t implements g<ParcelFileDescriptor, Bitmap> {
    private final k a;

    public t(k kVar) {
        this.a = kVar;
    }

    @Nullable
    /* renamed from: c */
    public u<Bitmap> b(@NonNull ParcelFileDescriptor parcelFileDescriptor, int i, int i2, @NonNull f fVar) throws IOException {
        return this.a.d(parcelFileDescriptor, i, i2, fVar);
    }

    /* renamed from: d */
    public boolean a(@NonNull ParcelFileDescriptor parcelFileDescriptor, @NonNull f fVar) {
        return this.a.o(parcelFileDescriptor);
    }
}
