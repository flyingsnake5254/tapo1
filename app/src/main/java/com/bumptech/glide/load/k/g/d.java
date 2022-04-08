package com.bumptech.glide.load.k.g;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.k.d.b;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.a;

/* compiled from: GifDrawableBytesTranscoder.java */
/* loaded from: classes.dex */
public class d implements e<GifDrawable, byte[]> {
    @Override // com.bumptech.glide.load.k.g.e
    @Nullable
    public u<byte[]> a(@NonNull u<GifDrawable> uVar, @NonNull f fVar) {
        return new b(a.d(uVar.get().c()));
    }
}
