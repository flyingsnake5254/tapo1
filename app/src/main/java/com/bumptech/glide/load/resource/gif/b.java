package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.l.a;
import com.bumptech.glide.load.engine.z.e;

/* compiled from: GifBitmapProvider.java */
/* loaded from: classes.dex */
public final class b implements a.AbstractC0042a {
    private final e a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.z.b f1676b;

    public b(e eVar, @Nullable com.bumptech.glide.load.engine.z.b bVar) {
        this.a = eVar;
        this.f1676b = bVar;
    }

    @Override // com.bumptech.glide.l.a.AbstractC0042a
    public void a(@NonNull Bitmap bitmap) {
        this.a.c(bitmap);
    }

    @Override // com.bumptech.glide.l.a.AbstractC0042a
    @NonNull
    public byte[] b(int i) {
        com.bumptech.glide.load.engine.z.b bVar = this.f1676b;
        if (bVar == null) {
            return new byte[i];
        }
        return (byte[]) bVar.c(i, byte[].class);
    }

    @Override // com.bumptech.glide.l.a.AbstractC0042a
    @NonNull
    public Bitmap c(int i, int i2, @NonNull Bitmap.Config config) {
        return this.a.e(i, i2, config);
    }

    @Override // com.bumptech.glide.l.a.AbstractC0042a
    @NonNull
    public int[] d(int i) {
        com.bumptech.glide.load.engine.z.b bVar = this.f1676b;
        if (bVar == null) {
            return new int[i];
        }
        return (int[]) bVar.c(i, int[].class);
    }

    @Override // com.bumptech.glide.l.a.AbstractC0042a
    public void e(@NonNull byte[] bArr) {
        com.bumptech.glide.load.engine.z.b bVar = this.f1676b;
        if (bVar != null) {
            bVar.e(bArr);
        }
    }

    @Override // com.bumptech.glide.l.a.AbstractC0042a
    public void f(@NonNull int[] iArr) {
        com.bumptech.glide.load.engine.z.b bVar = this.f1676b;
        if (bVar != null) {
            bVar.e(iArr);
        }
    }
}
