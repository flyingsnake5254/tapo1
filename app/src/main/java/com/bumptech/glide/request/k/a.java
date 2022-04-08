package com.bumptech.glide.request.k;

import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.d;

/* compiled from: BaseTarget.java */
@Deprecated
/* loaded from: classes.dex */
public abstract class a<Z> implements j<Z> {

    /* renamed from: c  reason: collision with root package name */
    private d f1738c;

    @Override // com.bumptech.glide.request.k.j
    public void b(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.k.j
    @Nullable
    public d c() {
        return this.f1738c;
    }

    @Override // com.bumptech.glide.request.k.j
    public void d(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.k.j
    public void f(@Nullable d dVar) {
        this.f1738c = dVar;
    }

    @Override // com.bumptech.glide.request.k.j
    public void h(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.manager.m
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.m
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.m
    public void onStop() {
    }
}
