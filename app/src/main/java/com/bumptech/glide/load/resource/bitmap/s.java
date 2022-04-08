package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.q;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.util.i;

/* compiled from: LazyBitmapDrawableResource.java */
/* loaded from: classes.dex */
public final class s implements u<BitmapDrawable>, q {

    /* renamed from: c  reason: collision with root package name */
    private final Resources f1653c;

    /* renamed from: d  reason: collision with root package name */
    private final u<Bitmap> f1654d;

    private s(@NonNull Resources resources, @NonNull u<Bitmap> uVar) {
        this.f1653c = (Resources) i.d(resources);
        this.f1654d = (u) i.d(uVar);
    }

    @Nullable
    public static u<BitmapDrawable> f(@NonNull Resources resources, @Nullable u<Bitmap> uVar) {
        if (uVar == null) {
            return null;
        }
        return new s(resources, uVar);
    }

    @Override // com.bumptech.glide.load.engine.u
    public int a() {
        return this.f1654d.a();
    }

    @Override // com.bumptech.glide.load.engine.q
    public void b() {
        u<Bitmap> uVar = this.f1654d;
        if (uVar instanceof q) {
            ((q) uVar).b();
        }
    }

    @Override // com.bumptech.glide.load.engine.u
    public void c() {
        this.f1654d.c();
    }

    @NonNull
    /* renamed from: d */
    public BitmapDrawable get() {
        return new BitmapDrawable(this.f1653c, this.f1654d.get());
    }

    @Override // com.bumptech.glide.load.engine.u
    @NonNull
    public Class<BitmapDrawable> e() {
        return BitmapDrawable.class;
    }
}
