package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.k.e.d;

/* compiled from: ResourceBitmapDecoder.java */
/* loaded from: classes.dex */
public class v implements g<Uri, Bitmap> {
    private final d a;

    /* renamed from: b  reason: collision with root package name */
    private final e f1658b;

    public v(d dVar, e eVar) {
        this.a = dVar;
        this.f1658b = eVar;
    }

    @Nullable
    /* renamed from: c */
    public u<Bitmap> b(@NonNull Uri uri, int i, int i2, @NonNull f fVar) {
        u<Drawable> c2 = this.a.b(uri, i, i2, fVar);
        if (c2 == null) {
            return null;
        }
        return l.a(this.f1658b, c2.get(), i, i2);
    }

    /* renamed from: d */
    public boolean a(@NonNull Uri uri, @NonNull f fVar) {
        return "android.resource".equals(uri.getScheme());
    }
}
